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
@WebServlet("/deleteUserMasterOnly")
public class DeleteUserMasterOnlyServlet extends HttpServlet {
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
			Admin admin = adminDao.findById2(id);
			request.setAttribute("user", admin);
			request.getRequestDispatcher("/WEB-INF/view/deleteUserMasterOnly.jsp").forward(request, response);
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

		try {
			/* URLから削除するユーザーのIDを取得しセット */
			Integer id = Integer.parseInt(request.getParameter("id"));
			Admin admin = new Admin();
			admin.setId(id);
			
			/* 削除実行 */
			AdminDao adminDao = DaoFactory.createAdminDao();
			adminDao.delete(admin);
			
			/*完了ページ表示用*/
			request.getSession().setAttribute("completeTitle", "ユーザー削除");
			request.getSession().setAttribute("completeMessage", "ユーザーを削除しました");
			request.getSession().setAttribute("completeLink1Title", "ユーザーリスト");
			request.getSession().setAttribute("completeLink1", "listUser");
			request.getSession().setAttribute("completeLink2Title", "データベースリスト");			
			request.getSession().setAttribute("completeLink2", "listDb");	

			/* ページ移動 */
			request.getRequestDispatcher("/WEB-INF/view/done.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException();
		}

	}

}
