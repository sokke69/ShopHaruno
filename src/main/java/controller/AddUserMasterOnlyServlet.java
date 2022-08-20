package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import dao.AdminDao;
import dao.DaoFactory;
import dao.UserTypeDao;
import domain.Admin;
import domain.UserType;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/addUserMasterOnly")
public class AddUserMasterOnlyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			UserTypeDao userTypeDao = DaoFactory.createUserTypeDao();
			List<UserType> userTypeList = userTypeDao.findAll();
			request.setAttribute("userTypeList", userTypeList);
			
			request.getRequestDispatcher("/WEB-INF/view/addUserMasterOnly.jsp").forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userNickName = request.getParameter("user-nick-name");
		String userName = request.getParameter("user-name");
		String userPass = request.getParameter("user-pass");
		String userPassCheck = request.getParameter("user-pass-check");
		Integer typeId = Integer.parseInt(request.getParameter("user-type"));
		//System.out.println("user-name = " + userName + ", user-pass = " + userPass + ", user-type = " + typeId);
		
		/*
		 * if (userPass != userPassCheck) {
		 * request.getRequestDispatcher("/WEB-INF/view/AddUserMasterOnly.jsp").forward(
		 * request, response); }
		 */
		
		String hashedPass = BCrypt.hashpw(userPass, BCrypt.gensalt());
		//System.out.println("hashedpass = " + hashedPass);
		
		Admin admin = new Admin();
		
		admin.setUserNickName(userNickName);
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








