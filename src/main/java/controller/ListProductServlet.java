package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
 * Servlet implementation class ListProductServlet
 */
@WebServlet("/listProduct")
public class ListProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			/* 画像キャッシュ問題をクリアするためセッションに本日の日付を格納 */
			Date todayDate = new Date();
			SimpleDateFormat fmt = new SimpleDateFormat("yMMddHHmmss");
			String today = fmt.format(todayDate);
			request.getSession().setAttribute("today", today);
			
			/* urlに?Category=があれば取得してInteger化 */
			String categoryStr = request.getParameter("Category");
			Integer category = null;
			if (categoryStr != null) {
				category = Integer.parseInt(categoryStr);
			}
			
			/* データベースからカテゴリ一覧の取得 */
			ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
			List<ACategory> aCategoryList = aCategoryDao.findAll();
			
			/* データベースから商品の取得 */
			ProductDao productDao = DaoFactory.createProductDao();
			List<Product> productList = new ArrayList<>();
			if (categoryStr == null) {
				productList = productDao.findAllDesc();
			} else {
					productList = productDao.findByAIdDesc(category);
			}
			
			/* 取得したデータを各リストへ収納しjspで表示用にsetAttribute */
			request.setAttribute("productList", productList);
			request.setAttribute("aCategoryList", aCategoryList);
			
			/* ページ表示 */
			request.getRequestDispatcher("/WEB-INF/view/listProduct.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
