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
 * Servlet implementation class UpdateACategoryServlet
 */
@WebServlet("/updateACategory")
public class UpdateACategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			/* URLからID取得 */
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			/* 表示用にカテゴリー取得 */
			ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
			ACategory aCategory = aCategoryDao.findById(id);
			request.setAttribute("aCategory", aCategory);
			
			/* ページ表示 */
			request.getRequestDispatcher("/WEB-INF/view/updateACategory.jsp").forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			/* update様に取得 */
			Integer id = Integer.parseInt(request.getParameter("id"));
			String aCategoryName = request.getParameter("a-category-name");
			
			/* バリデーションチェック用boolean作成 */
			boolean isError = false;
			
			/* カテゴリ名バリデーション */
			if (aCategoryName.isBlank()) {
				request.setAttribute("aCategoryError", "名前を入力してください。");
				isError = true;
			} else if (aCategoryName.length() > 20) {
				request.setAttribute("aCategoryError", "名前は20文字以内で入力してください。");
				isError = true;
			}
			
			/* エラーがあればページを再表示 */
			if (isError) {
				request.getRequestDispatcher("/WEB-INF/view/updateACategory.jsp").forward(request, response);
			} /* エラーがなければupdate */ 
			else if (!isError) {
				/* update用にセット */
				ACategory aCategory = new ACategory();
				aCategory.setId(id);
				aCategory.setaCategoryName(aCategoryName);
				
				/* update */
				ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
				aCategoryDao.update(aCategory);
				
				/*完了ページ表示用*/
				request.getSession().setAttribute("completeTitle", "カテゴリ編集");
				request.getSession().setAttribute("completeMessage", "カテゴリを変更しました。");
				request.getSession().setAttribute("completeLink1Title", "カテゴリリスト");
				request.getSession().setAttribute("completeLink1", "listACategory");
				request.getSession().setAttribute("completeLink2Title", "データベースリスト");
				request.getSession().setAttribute("completeLink2", "listDb");
				
				/* ページ移動 */
				request.getRequestDispatcher("/WEB-INF/view/done.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

}





