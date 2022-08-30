package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/updateProduct")



/* 注意！！使うPCによって必ずここを変更する！！！！！！！！ */
@MultipartConfig(location = "C:/Users/zd2L17/temp")
//MultipartConfig(location = "C:/temp")



public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));

		try {
			ProductDao productDao = DaoFactory.createProductDao();
			Product product = productDao.findById(id);
			Integer aId = productDao.findAIdById(id);
			request.setAttribute("product", product);
			request.setAttribute("aId", aId);
			
			
			ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
			List<ACategory> aCategoryList = aCategoryDao.findAll();
			Integer countAId = aCategoryDao.countAId();
			request.setAttribute("aCategoryList", aCategoryList);
			request.setAttribute("countAId", countAId);
			
			request.getRequestDispatcher("/WEB-INF/view/updateProduct.jsp").forward(request, response);
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
			/* 入力されたデータを取得 */
			Integer id = Integer.parseInt(request.getParameter("id"));
			String productName = request.getParameter("product-name");
			String productUrl = request.getParameter("product-url");
			Integer aCategoryId = Integer.parseInt(request.getParameter("a-category-id"));
			
			/* セッションからログインしているユーザー名を取得(編集ユーザー記録用) */
			String productUpdateBy = (String) request.getSession().getAttribute("userNickName");
			
			/* 商品URLの正規表現チェック */
			Pattern urlPattern = Pattern.compile("https?://[\\w/:%#\\$&\\?\\(\\)~\\.=\\+\\-]+");
			Matcher urlMatcher = urlPattern.matcher(productUrl);
			
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
			
			/* update実行用にセット */
			Product product = new Product();
			
			product.setId(id);
			product.setProductName(productName);
			product.setProductUrl(productUrl);
			product.setCategoryA(aCategoryId);
			product.setUpdateBy(productUpdateBy);
			
			/* エラーがある場合は再表示 */
			if (isError) {
				/* ページ再表示用 */
				request.setAttribute("aId", aCategoryId);
				ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
				List<ACategory> aCategoryList = aCategoryDao.findAll();
				Integer countAId = aCategoryDao.countAId();
				request.setAttribute("aCategoryList", aCategoryList);
				request.setAttribute("countAId", countAId);
				request.setAttribute("product", product);
				
				/* ページ再表示 */
				request.getRequestDispatcher("/WEB-INF/view/updateProduct.jsp").forward(request, response);
				
			/* エラーがなければ編集を実行 */
			} else if (!isError) {
				
				/* 画像ファイル上書き */
				writeImg(request,id);
				
				/* DBを更新 */
				ProductDao productDao = DaoFactory.createProductDao();
				productDao.update(product);
				
				/*完了ページ表示用*/
				request.getSession().setAttribute("completeTitle", "商品編集");
				request.getSession().setAttribute("completeMessage", "商品の編集が完了しました。");
				request.getSession().setAttribute("completeLink1Title", "商品リスト");
				request.getSession().setAttribute("completeLink1", "listProduct");
				request.getSession().setAttribute("completeLink2Title", "データベースリスト");
				request.getSession().setAttribute("completeLink2", "listDb");

				/* ページ移動 */
				request.getRequestDispatcher("/WEB-INF/view/done.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}
	
	private File getUploadedDirectory(HttpServletRequest request) throws ServletException {
		ServletContext context = request.getServletContext();
		
		String path = context.getRealPath("/imgs");
		return new File(path);
		
	}

	private void writeImg(HttpServletRequest request,Integer id) throws ServletException {
		
		File filePath = getUploadedDirectory(request);
		
		try {
			/* 編集する商品のidをString化 */
			String idStr = id.toString();
			
			/* メイン画像取得 */
			Part partMain = request.getPart("product-img-main");
			long mainFileSize = partMain.getSize();
			// メイン画像書き込み
			if (mainFileSize > 0) {
				partMain.write(filePath + "/" + idStr + "_main.jpg");
			}
			
			/* サブ画像取得 */
			Part partSub01 = request.getPart("product-img-sub-01");
			Part partSub02 = request.getPart("product-img-sub-02");
			Part partSub03 = request.getPart("product-img-sub-03");
			Part partSub04 = request.getPart("product-img-sub-04");
			Part partSub05 = request.getPart("product-img-sub-05");
			Part partSub06 = request.getPart("product-img-sub-06");
			Part partSub07 = request.getPart("product-img-sub-07");
			Part partSub08 = request.getPart("product-img-sub-08");
			long sub01FileSize = partSub01.getSize();
			long sub02FileSize = partSub02.getSize();
			long sub03FileSize = partSub03.getSize();
			long sub04FileSize = partSub04.getSize();
			long sub05FileSize = partSub05.getSize();
			long sub06FileSize = partSub06.getSize();
			long sub07FileSize = partSub07.getSize();
			long sub08FileSize = partSub08.getSize();
			
			/* サブ画像書き込み */
			if (sub01FileSize > 0) {
				partSub01.write(filePath + "/" + idStr + "_sub01.jpg");
			}
			if (sub02FileSize > 0) {
				partSub02.write(filePath + "/" + idStr + "_sub02.jpg");
			}
			if (sub03FileSize > 0) {
				partSub03.write(filePath + "/" + idStr + "_sub03.jpg");
			}
			if (sub04FileSize > 0) {
				partSub04.write(filePath + "/" + idStr + "_sub04.jpg");
			}
			if (sub05FileSize > 0) {
				partSub05.write(filePath + "/" + idStr + "_sub05.jpg");
			}
			if (sub06FileSize > 0) {
				partSub06.write(filePath + "/" + idStr + "_sub06.jpg");
			}
			if (sub07FileSize > 0) {
				partSub07.write(filePath + "/" + idStr + "_sub07.jpg");
			}
			if (sub08FileSize > 0) {
				partSub08.write(filePath + "/" + idStr + "_sub08.jpg");
			}
		} catch (Exception e1) {
			throw new ServletException(e1);
		}

	}

}
