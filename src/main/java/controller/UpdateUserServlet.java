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
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		try {
			AdminDao adminDao = DaoFactory.createAdminDao();
			Admin admin = adminDao.findById(id);
			request.setAttribute("user", admin);
			request.getRequestDispatcher("/WEB-INF/view/updateUser.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Admin admin = new Admin();
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		String userNickName = request.getParameter("user-nick-name");
		String userName = request.getParameter("user-name");
		Integer userType = Integer.parseInt(request.getParameter("user-type"));
		
		admin.setId(id);
		admin.setUserNickName(userNickName);
		admin.setUserName(userName);
		admin.setTypeId(userType);
		
		try {
			AdminDao adminDao = DaoFactory.createAdminDao();
			adminDao.update(admin);
			
			request.getRequestDispatcher("/WEB-INF/view/updateUserDone.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

}
