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
		try {
			
			/* URLから削除したいカテゴリのidを取得しセット */
			Integer id = Integer.parseInt(request.getParameter("id"));
			ACategory aCategory = new ACategory();
			aCategory.setId(id);
			
			/*削除実行*/
			ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
			aCategoryDao.delete(aCategory);
			
			/*完了ページ表示用*/
			request.getSession().setAttribute("completeTitle", "カテゴリ削除");
			request.getSession().setAttribute("completeMessage", "カテゴリを削除しました。");
			request.getSession().setAttribute("completeLink1Title", "カテゴリリスト");
			request.getSession().setAttribute("completeLink1", "listACategory");
			request.getSession().setAttribute("completeLink2Title", "データベースリスト");			
			request.getSession().setAttribute("completeLink2", "listDb");	

			/* ページ移動 */
			request.getRequestDispatcher("/WEB-INF/view/done.jsp").forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
