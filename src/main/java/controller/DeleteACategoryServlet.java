package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ACategoryDao;
import dao.DaoFactory;
import domain.ACategory;

/**
 * Servlet implementation class DeleteACategoryServlet
 */
@WebServlet("/deleteACategory")
public class DeleteACategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));

		try {
			ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
			ACategory aCategory = aCategoryDao.findById(id);
			request.setAttribute("aCategory", aCategory);

			request.getRequestDispatcher("/WEB-INF/view/deleteACategory.jsp").forward(request, response);

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

		ACategory aCategory = new ACategory();

		Integer id = Integer.parseInt(request.getParameter("id"));

		aCategory.setId(id);

		try {
			ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
			aCategoryDao.delete(aCategory);

			request.getRequestDispatcher("/WEB-INF/view/deleteACategoryDone.jsp").forward(request, response);

		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
