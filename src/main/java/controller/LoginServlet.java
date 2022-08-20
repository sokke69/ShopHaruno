package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import dao.DaoFactory;
import domain.Admin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			
			boolean isError = false;
			
			String userName = request.getParameter("loginId");
			String userPass = request.getParameter("loginPass");
			
			Pattern passPattern = Pattern.compile("[0-9a-zA-Z]+");
			Matcher passMatcher = passPattern.matcher(userPass);
			
			AdminDao adminDao = DaoFactory.createAdminDao();
			Admin admin = adminDao.findByLoginIdAndLoginPass(userName, userPass);
					
			if (admin != null) {
				
				String sessionUserName = admin.getUserName();
				Integer sessionUserType = admin.getTypeId();
				String sessionUserNickName = admin.getUserNickName();
				
				request.getSession().setAttribute("userName", sessionUserName);
				request.getSession().setAttribute("userNickName", sessionUserNickName);
				
				//String sessionUserTypeName = null;
				if (sessionUserType == 1) {
					request.getSession().setAttribute("userIsMaster", sessionUserType);
				//	sessionUserTypeName = "Master";
				} else if (sessionUserType == 2) {
					request.getSession().setAttribute("userIsUser", sessionUserType);
				//	sessionUserTypeName = "User";
				} else if (sessionUserType == 3) {
					request.getSession().setAttribute("userIsTester", sessionUserType);
				//	sessionUserTypeName = "Tester";
				}	
				
				/*
				 * System.out.println("[session格納]"); System.out.println("ユーザーID : " +
				 * sessionUserName); System.out.println("ユーザーニックネーム : " + sessionUserNickName);
				 * System.out.println("ユーザータイプ:" + sessionUserType);
				 */
				
				response.sendRedirect("listDb");
				
			} else {
				request.setAttribute("Error", "true");
				
				if(userName.isBlank()) {
					request.setAttribute("nameError", "※ ログインIDが入力されていません。");
					isError = true;
				} else if (userName.length() > 12) {
					request.setAttribute("nameError", "※ ログインIDは12文字以内で入力してください。");
					isError = true;
				} else {
					request.setAttribute("allError", "※ ログインIDもしくはパスワードが違います。");
					isError = true;
				}
				
				if(userPass.isBlank()) {
					request.setAttribute("passError", "※ パスワードが入力されていません。");
				} else if(userPass.length() > 20 && !passMatcher.matches()) {
					request.setAttribute("passError", "※ パスワードは20文字以内で入力してください。使える文字は半角英数字と「_」のみです。");
					isError = true;
				} else if (userPass.length() > 20) {
					request.setAttribute("passError", "※ パスワードは20文字以内で入力してください。");
					isError = true;
				} else if (!passMatcher.matches()) {
					request.setAttribute("passError", "※ 半角英数字以外の文字が入力されています。");
					isError = true;
				} else {
					request.setAttribute("allError", "※ ログインIDもしくはパスワードが違います。");
					isError = true;
				}
				
				if(isError == true) {
					request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
					return;
				}

				
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		
	}

}
