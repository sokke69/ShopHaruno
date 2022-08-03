package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import dao.AdminDao;
import dao.DaoFactory;
import domain.Admin;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/addUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("user-name");
		String userPass = request.getParameter("user-pass");
		Integer typeId = Integer.parseInt(request.getParameter("user-type"));
		//System.out.println("user-name = " + userName + ", user-pass = " + userPass + ", user-type = " + typeId);
		
		String hashedPass = BCrypt.hashpw(userPass, BCrypt.gensalt());
		//System.out.println("hashedpass = " + hashedPass);
		
		Admin admin = new Admin();
		
		admin.setUserName(userName);
		admin.setUserPass(hashedPass);
		admin.setTypeId(typeId);
		//System.out.println("admin.userName = " + admin.getUserName() + ", admin.userPass = " + admin.getUserPass() + ". admin.typeId = " + admin.getTypeId());
		
		try {
			AdminDao adminDao = DaoFactory.createAdminDao();
			adminDao.insert(admin);
			response.sendRedirect(request.getContextPath() + "/listUser");
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		
	}

}








