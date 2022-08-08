package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListDbServlet
 */
@WebServlet("/listDb")
public class ListDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String userId = (String) request.getSession().getAttribute("userName");
		//String userType = (String) request.getSession().getAttribute("userType");
		//String userNickName = (String) request.getSession().getAttribute("userNickName");
		//System.out.println("ユーザーID:" + userId + "、ユーザータイプ:"  + userType + "、ユーザーニックネーム:" + userNickName + "でログイン中。");
		
		
		request.getRequestDispatcher("/WEB-INF/view/listDb.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		
		
	}

}
