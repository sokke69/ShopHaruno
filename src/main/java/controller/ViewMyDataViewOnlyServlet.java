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
 * Servlet implementation class ViewMyDataViewOnlyServlet
 */
@WebServlet("/viewMyDataViewOnly")
public class ViewMyDataViewOnlyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			/* セッションからログインしているユーザーのIDからユーザー情報取得しセット */
			Integer id = (Integer) request.getSession().getAttribute("userId");
			AdminDao adminDao = DaoFactory.createAdminDao();
			Admin admin = adminDao.findById(id);
			request.setAttribute("myData", admin);
			
			/* ページ表示 */
			request.getRequestDispatcher("/WEB-INF/view/viewMyDataViewOnly.jsp").forward(request, response);

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
