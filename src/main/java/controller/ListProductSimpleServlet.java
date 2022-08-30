package controller;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class ListProductSimpleServlet
 */
@WebServlet("/listProductSimple")
public class ListProductSimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			/* 編集・削除画面へどのページから行ったかをセッションに記録。各ページのリンク「戻る」に使用する */
			/* simple版のセッションは消す */
			request.getSession().setAttribute("visitedBySimple", "true");
			request.getSession().removeAttribute("visitedByDesign");
			
			/* urlに?Category=があれば取得してInteger化 */
			String categoryStr = request.getParameter("Category");
			Integer category = null;
			if (categoryStr != null) {
				category = Integer.parseInt(categoryStr);
			}
			
			/* データベースからカテゴリ一覧の取得 */
			ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
			List<ACategory> aCategoryList = aCategoryDao.findAll();
			
			/* DBから商品の取得 */
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
			request.getRequestDispatcher("/WEB-INF/view/listProductSimple.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
