package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ACategoryDao;
import dao.DaoFactory;
import dao.ProductDao;
import domain.ACategory;
import domain.Product;

/**
 * Servlet implementation class AaddProductServlet
 */
@WebServlet("/addProduct")



/* 注意！！使うPCによって必ずここを変更する！！！！！！！！ */
//@MultipartConfig(location = "C:/Users/zd2L17/temp")
@MultipartConfig(location = "C:/temp")



public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* session中にproductがあるならば初期化 */
		if (request.getSession().getAttribute("product") != null) {
			request.getSession().removeAttribute("product");
		}
		
		try {
			/* カテゴリ名取得用 */
			ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
			List<ACategory> aCategoryList = aCategoryDao.findAll();
			request.setAttribute("aCategoryList", aCategoryList);
			/* ページ表示 */
			request.getRequestDispatcher("/WEB-INF/view/addProduct.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			/* session中にproductがあるならば初期化 */
			if (request.getSession().getAttribute("product") != null) {
				request.getSession().removeAttribute("product");
			}
			
			/* 新規ファイル書き込み用にproductsテーブルのMAX(id)+1を取得 */
			ProductDao productDao = DaoFactory.createProductDao();
			Integer id = productDao.findLatestIdPlusOne();
			String idStr = id.toString();
			
			/* DB登録用変数セット */
			String productName = request.getParameter("product-name");
			String productUrl = request.getParameter("product-url");
			Integer aCategoryId = Integer.parseInt(request.getParameter("a-category-id"));
			String imgMain = ("./imgs/" + idStr + "_main.jpg");
			String imgSub01 = ("./imgs/" + idStr + "_sub01.jpg");
			String imgSub02 = ("./imgs/" + idStr + "_sub02.jpg");
			String imgSub03 = ("./imgs/" + idStr + "_sub03.jpg");
			String imgSub04 = ("./imgs/" + idStr + "_sub04.jpg");
			String imgSub05 = ("./imgs/" + idStr + "_sub05.jpg");
			String imgSub06 = ("./imgs/" + idStr + "_sub06.jpg");
			String imgSub07 = ("./imgs/" + idStr + "_sub07.jpg");
			String imgSub08 = ("./imgs/" + idStr + "_sub08.jpg");
			String userNickName = (String) request.getSession().getAttribute("userNickName");
			
			/* 商品URLの正規表現チェック */
			Pattern urlPattern = Pattern.compile("https?://[\\w/:%#\\$&\\?\\(\\)~\\.=\\+\\-]+");
			Matcher urlMatcher = urlPattern.matcher(productUrl);
			
			/* ページ再表示用 */
			request.setAttribute("aId", aCategoryId);
			ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
			List<ACategory> aCategoryList = aCategoryDao.findAll();
			Integer countAId = aCategoryDao.countAId();
			request.setAttribute("aCategoryList", aCategoryList);
			request.setAttribute("countAId", countAId);
			request.setAttribute("productName", productName);
			request.setAttribute("productUrl", productUrl);
			
			/* バリデーションチェック用boolean作成 */
			boolean isError = false;
			
			/* 商品名バリデーション */
			if (productName.isBlank()) {
				request.setAttribute("nameError", "商品名が入力されていません。");
				isError = true;
			} else if (productName.length() > 255) {
				request.setAttribute("nameError", "商品名は255文字以内で入力してください。");
				isError = true;
			} else {
				request.setAttribute("nameSuccess", "true");
			}
			
			/* 商品URLバリデーション */
			if (productUrl.isBlank()) {
				request.setAttribute("urlError", "商品URLが入力されていません。");
				isError = true;
			} else if (productUrl.length() > 8190) {
				request.setAttribute("urlError", "商品URの文字数がオーバーしています。");
				isError = true;
			} else if (!urlMatcher.matches()) {
				request.setAttribute("urlError", "商品URLが正しく入力されていません。");
				isError = true;
			} else {
				request.setAttribute("urlSuccess", "true");
			}
			
			/* 商品カテゴリバリデーション */
			if (aCategoryId == 0) {
				request.setAttribute("aCategoryError", "選択してください。");
				isError = true;
			} else {
				request.setAttribute("aCategorySuccess", "true");
			}
			
			/* エラーがある場合は再表示 */
			if (isError) {
				request.getRequestDispatcher("/WEB-INF/view/addProduct.jsp").forward(request, response);
			} /* エラーがない場合は登録 */
			else if (!isError) {
				/* insert実行用にセット */
				Product product = new Product();

				product.setProductName(productName);
				product.setProductUrl(productUrl);
				product.setCategoryA(aCategoryId);
				product.setImgMain(imgMain);
				product.setImgSub01(imgSub01);
				product.setImgSub02(imgSub02);
				product.setImgSub03(imgSub03);
				product.setImgSub04(imgSub04);
				product.setImgSub05(imgSub05);
				product.setImgSub06(imgSub06);
				product.setImgSub07(imgSub07);
				product.setImgSub08(imgSub08);
				product.setRegistBy(userNickName);
				
				/* 画像ファイルを取得して書き込み */
				writeImg(request);
				
				/* DBに登録 */
				productDao.insert(product);
				request.getSession().removeAttribute("product");
				
				/* 完了ページ移動 */
				request.getRequestDispatcher("/WEB-INF/view/addProductDone.jsp").forward(request, response);
			}
			
		} catch (Exception e1) {
			throw new ServletException(e1);
		}

	}

	private File getUploadedDirectory(HttpServletRequest request) throws ServletException {
		ServletContext context = request.getServletContext();

		String path = context.getRealPath("/imgs");
		return new File(path);

	}
	
	private void writeImg(HttpServletRequest request) throws ServletException {
		
		File filePath = getUploadedDirectory(request);
		
		try {
			/* 新規ファイル書き込み用にproductsテーブルのMAX(id)+1を取得 */
			ProductDao productDao = DaoFactory.createProductDao();
			Integer id = productDao.findLatestIdPlusOne();
			String idStr = id.toString();
			
			/* メイン画像取得 */
			Part partMain = request.getPart("product-img-main");
			long mainFileSize = partMain.getSize();
			/* メイン画像書き込み */
			if (mainFileSize > 0) {
				partMain.write(filePath + "/" + idStr + "_main.jpg");
			}

			/* サブ画像List取得 */
			List<Part> partsSub = request.getParts().stream().filter(part -> "product-img-sub".equals(part.getName()))
					.collect(Collectors.toList());
			/* サブ画像取得&書き込み */
			for(int i=0; i <= partsSub.size()-1; i++) {
				/* 取得 */
				Part partSub = partsSub.get(i);
				long subFileSize = partSub.getSize();
				/* 書き込み */
				if (subFileSize > 0) {
					partSub.write(filePath + "/" + idStr + "_sub0" + (i+1) + ".jpg");
				}
			}
		} catch (Exception e1) {
			throw new ServletException(e1);
		}

	}

}
