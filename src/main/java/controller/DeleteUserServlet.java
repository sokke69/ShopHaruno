package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import dao.DaoFactory;
import domain.Admin;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));

		try {
			AdminDao adminDao = DaoFactory.createAdminDao();
			Admin admin = adminDao.findById(id);
			request.setAttribute("user", admin);
			request.getRequestDispatcher("/WEB-INF/view/deleteUser.jsp").forward(request, response);
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
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Admin admin = new Admin();
		admin.setId(id);
		
		try {
			AdminDao adminDao = DaoFactory.createAdminDao();
			adminDao.delete(admin);
			
			request.getRequestDispatcher("/WEB-INF/view/deleteUserDone.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException();
		}
		
	}

}
