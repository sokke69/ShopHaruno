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
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/updateProduct")



/* 注意！！使うPCによって必ずここを変更する！！！！！！！！ */
@MultipartConfig(location = "C:/Users/zd2L17/temp")
//@MultipartConfig(location = "C:/temp")



public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

		try {
			/* DaoFactoryで使用するDaoの作成 */
			ProductDao productDao = DaoFactory.createProductDao();
			ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();	
			
			/* URLから修正したい商品のIDの取得 */
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			/* IDから商品情報を取得・セット */
			Product product = productDao.findById(id);
			request.setAttribute("product", product);
			
			/* 登録できる残り枚数を計算・セット */
			Integer countImg = product.getImg();
			Integer restOfCountImg = 9 - countImg;
			request.setAttribute("countImg", countImg);
			request.setAttribute("restOfCountImg", restOfCountImg);
			
			/* IDからカテゴリIDを個別に取得・セット */
			Integer aId = productDao.findAIdById(id);
			request.setAttribute("aId", aId);
			
			/* カテゴリーの件数取得・セット */
			Integer countAId = aCategoryDao.countAId();
			request.setAttribute("countAId", countAId);
			
			/* カテゴリーリストの取得・セット */
			List<ACategory> aCategoryList = aCategoryDao.findAll();
			request.setAttribute("aCategoryList", aCategoryList);
			
			/* ページ表示 */
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
		
		/* 画像削除ボタンが押されたらここを実行 */
		
		
		
		
		/* 画像削除ボタンが押されていない場合はここを実行 */
		try {
			/* DaoFactoryで使用するDaoの作成 */
			ProductDao productDao = DaoFactory.createProductDao();
			ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
			
			/* 入力されたデータを取得 */
			Integer id = Integer.parseInt(request.getParameter("id"));
			String productName = request.getParameter("product-name");
			String productUrl = request.getParameter("product-url");
			Integer countImg = productDao.findCountImg(id);
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
				List<ACategory> aCategoryList = aCategoryDao.findAll();
				Integer countAId = aCategoryDao.countAId();
				request.setAttribute("aCategoryList", aCategoryList);
				request.setAttribute("countAId", countAId);
				request.setAttribute("product", product);
				
				/* ページ再表示 */
				request.getRequestDispatcher("/WEB-INF/view/updateProduct.jsp").forward(request, response);
				
			/* エラーがなければ編集を実行 */
			} else if (!isError) {
				
				/* 画像ファイル変更・追加 */
				Integer registImg = writeImg(request,id,countImg);
				Integer updateImg = countImg + registImg;
				
				/* update実行用にセット(2) */
				product.setImg(updateImg);
				
				/* DBに反映させアップデート */
				productDao.update(product);
				
				/*完了ページ表示用*/
				request.getSession().setAttribute("completeTitle", "商品編集");
				request.getSession().setAttribute("completeMessage", "商品の編集が完了しました。");
				request.getSession().setAttribute("completeLink1Title", "商品リスト");
				request.getSession().setAttribute("completeLink1", "listProduct");
				request.getSession().setAttribute("completeLink2Title", "データベースリスト");
				request.getSession().setAttribute("completeLink2", "listDb");

				/* 完了ページ移動 */
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

	private Integer writeImg(HttpServletRequest request, Integer id, Integer countImg) throws ServletException {
		
		File filePath = getUploadedDirectory(request);
		
		try {
			/* 編集する商品のidをString化 */
			String idStr = id.toString();

			/* 1 画像取得・書き込み */
			Part part01 = request.getPart("product-img-01");
			long part01FileSize = part01.getSize();
			if (part01FileSize > 0) {
				part01.write(filePath + "/" + idStr + "_01.jpg");
			}

			/* 2～9 画像取得・書き込み */
			Part part02 = request.getPart("product-img-02");
			Part part03 = request.getPart("product-img-03");
			Part part04 = request.getPart("product-img-04");
			Part part05 = request.getPart("product-img-05");
			Part part06 = request.getPart("product-img-06");
			Part part07 = request.getPart("product-img-07");
			Part part08 = request.getPart("product-img-08");
			Part part09 = request.getPart("product-img-09");
			if (part02 != null) {
				long part02FileSize = part02.getSize();
				if (part02FileSize > 0) {
					part02.write(filePath + "/" + idStr + "_02.jpg");
				}
			}
			if (part03 != null) {
				long part03FileSize = part03.getSize();
				if (part03FileSize > 0) {
					part03.write(filePath + "/" + idStr + "_03.jpg");
				}
			}
			if (part04 != null) {
				long part04FileSize = part04.getSize();
				if (part04FileSize > 0) {
					part04.write(filePath + "/" + idStr + "_04.jpg");
				}
			}
			if (part05 != null) {
				long part05FileSize = part05.getSize();
				if (part05FileSize > 0) {
					part05.write(filePath + "/" + idStr + "_05.jpg");
				}
			}
			if (part06 != null) {
				long part06FileSize = part06.getSize();
				if (part06FileSize > 0) {
					part07.write(filePath + "/" + idStr + "_06.jpg");
				}
			}
			if (part07 != null) {
				long part07FileSize = part07.getSize();
				if (part07FileSize > 0) {
					part07.write(filePath + "/" + idStr + "_07.jpg");
				}
			}
			if (part08 != null) {
				long part08FileSize = part08.getSize();
				if (part08FileSize > 0) {
					part08.write(filePath + "/" + idStr + "_08.jpg");
				}
			}
			if (part09 != null) {
				long part09FileSize = part09.getSize();
				if (part09FileSize > 0) {
					part09.write(filePath + "/" + idStr + "_09.jpg");
				}
			}			
			
			/* 変更ではなく追加画像の取得 */
			List<Part> partsImg = request.getParts().stream().filter(part -> "product-img".equals(part.getName()))
					.collect(Collectors.toList());
			/* 画像取得&書き込み */
			for(int i = 0; i <= partsImg.size()-1; i++) {
				/* 取得 */
				Part partImg = partsImg.get(i);
				long subFileSize = partImg.getSize();
				
				/* 変数iを書き込み用に現在登録枚数に変更 */
				i = i + countImg;
				
				/* 書き込み */
				if (subFileSize > 0) {
					partImg.write(filePath + "/" + idStr + "_0" + (i+1) + ".jpg");
				}
				
				/* 変数iを変更前に戻す */
				i = i - countImg;
			}
			
			return partsImg.size();

		} catch (Exception e1) {
			throw new ServletException(e1);
		}

	}

}
