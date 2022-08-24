package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ACategoryDao;
import dao.DaoFactory;
import dao.ProductDao;
import domain.ACategory;
import domain.Product;

/**
 * Servlet implementation class Index2Servlet
 */
@WebServlet("/index2")
public class Index2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			/* DBから商品一覧の取得 */
			ProductDao productDao = DaoFactory.createProductDao();
			List<Product> productList = productDao.findAll();
			
			/* データベースからカテゴリ一覧の取得 */
			ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
			List<ACategory> aCategoryList = aCategoryDao.findAll();
			
			/* 取得したデータを各リストへ収納しjspで表示用にsetAttribute */
			request.setAttribute("productList", productList);
			request.setAttribute("aCategoryList", aCategoryList);
			
			/* ページ表示 */
			request.getRequestDispatcher("/WEB-INF/view/index2.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		/* カテゴリ別表示用にカテゴリidとして使用するidをurlから取得 */
		Integer id = Integer.parseInt(request.getParameter("Category"));
		
		try {
			/* DBから取得したカテゴリIDの商品一覧の取得 */
			ProductDao productDao = DaoFactory.createProductDao();
			List<Product> productList = productDao.findByAId(id);
			
			/* データベースからカテゴリ一覧の取得 */
			ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
			List<ACategory> aCategoryList = aCategoryDao.findAll();
			
			/* 取得したデータを各リストへ収納しjspで表示用にsetAttribute */
			request.setAttribute("productList", productList);
			request.setAttribute("aCategoryList", aCategoryList);
			
			/* ページ表示 */
			request.getRequestDispatcher("/WEB-INF/view/index2.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

}
