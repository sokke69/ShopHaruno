package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.ProductDao;
import domain.Product;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			/* 画像キャッシュ問題をクリアするためセッションに本日の日付を格納 */
			Date todayDate = new Date();
			SimpleDateFormat fmt = new SimpleDateFormat("yMMddHHmmss");
			String today = fmt.format(todayDate);
			request.getSession().setAttribute("today", today);
			
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			ProductDao productDao = DaoFactory.createProductDao();
			Product product = productDao.findById(id);
			request.setAttribute("product", product);

			request.getRequestDispatcher("/WEB-INF/view/deleteProduct.jsp").forward(request, response);
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
			/* URLから削除する商品のidを取得しセット */
			Integer id = Integer.parseInt(request.getParameter("id"));
			Product product = new Product();
			product.setId(id);
			
			/* データベースの商品データの削除実行 */
			ProductDao productDao = DaoFactory.createProductDao();
			productDao.delete(product);
			
			/* imgsフォルダの画像削除実行 */
			deleteImg(request);
			
			/*完了ページ表示用*/
			request.getSession().setAttribute("completeTitle", "商品削除");
			request.getSession().setAttribute("completeMessage", "商品を削除しました。");
			request.getSession().setAttribute("completeLink1Title", "商品リスト");
			request.getSession().setAttribute("completeLink1", "listProduct");
			request.getSession().setAttribute("completeLink2Title", "データベースリスト");			
			request.getSession().setAttribute("completeLink2", "listDb");	
			
			/* ページ移動 */
			request.getRequestDispatcher("/WEB-INF/view/done.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException();
		}

	}

	private File getUploadedDirectory(HttpServletRequest request) throws ServletException {
		ServletContext context = request.getServletContext();

		String path = context.getRealPath("/imgs");
		return new File(path);

	}

	private void deleteImg(HttpServletRequest request) throws ServletException {

		Integer id = Integer.parseInt(request.getParameter("id"));
		String idStr = id.toString();

		File filePath = getUploadedDirectory(request);
		Path main = Paths.get(filePath + "/" + idStr + "_main.jpg");
		Path sub01 = Paths.get(filePath + "/" + idStr + "_sub01.jpg");
		Path sub02 = Paths.get(filePath + "/" + idStr + "_sub02.jpg");
		Path sub03 = Paths.get(filePath + "/" + idStr + "_sub03.jpg");
		Path sub04 = Paths.get(filePath + "/" + idStr + "_sub04.jpg");
		Path sub05 = Paths.get(filePath + "/" + idStr + "_sub05.jpg");
		Path sub06 = Paths.get(filePath + "/" + idStr + "_sub06.jpg");
		Path sub07 = Paths.get(filePath + "/" + idStr + "_sub07.jpg");
		Path sub08 = Paths.get(filePath + "/" + idStr + "_sub08.jpg");
		
		try {
			Files.deleteIfExists(main);
			Files.deleteIfExists(sub01);
			Files.deleteIfExists(sub02);
			Files.deleteIfExists(sub03);
			Files.deleteIfExists(sub04);
			Files.deleteIfExists(sub05);
			Files.deleteIfExists(sub06);
			Files.deleteIfExists(sub07);
			Files.deleteIfExists(sub08);
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
