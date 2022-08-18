package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BCategoryDao;
import dao.DaoFactory;
import domain.BCategory;

/**
 * Servlet implementation class DeleteBCategoryServlet
 */
@WebServlet("/deleteBCategory")
public class DeleteBCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));

		try {
			BCategoryDao bCategoryDao = DaoFactory.createBCategoryDao();
			BCategory bCategory = bCategoryDao.findById(id);
			request.setAttribute("bCategory", bCategory);

			request.getRequestDispatcher("/WEB-INF/view/deleteBCategory.jsp").forward(request, response);

		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		BCategory bCategory = new BCategory();

		Integer id = Integer.parseInt(request.getParameter("id"));

		bCategory.setId(id);

		try {
			BCategoryDao bCategoryDao = DaoFactory.createBCategoryDao();
			bCategoryDao.delete(bCategory);

			request.getRequestDispatcher("/WEB-INF/view/deleteBCategoryDone.jsp").forward(request, response);

		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		
	}

}
