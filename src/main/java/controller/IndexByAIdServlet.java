package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ACategoryDao;
import dao.BCategoryDao;
import dao.DaoFactory;
import dao.ProductDao;
import domain.ACategory;
import domain.BCategory;
import domain.Product;

/**
 * Servlet implementation class IndexByAIdServlet
 */
@WebServlet("/indexByAId")
public class IndexByAIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("aId"));
		
		try {
			ProductDao productDao = DaoFactory.createProductDao();
			List<Product> productList = productDao.findByAId(id);
			
			ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
			List<ACategory> aCategoryList = aCategoryDao.findAll();
			
			BCategoryDao bCategoryDao = DaoFactory.createBCategoryDao();
			List<BCategory> bCategoryList = bCategoryDao.findAll();
			
			request.setAttribute("productList", productList);
			request.setAttribute("bCategoryList", bCategoryList);
			request.setAttribute("aCategoryList", aCategoryList);
			
			request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
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
