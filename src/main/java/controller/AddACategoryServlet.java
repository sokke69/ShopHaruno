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
 * Servlet implementation class AddACategoryServlet
 */
@WebServlet("/addACategory")
public class AddACategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/addACategory.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			/* 追加したい名前を取得 */
			String aCategoryName = request.getParameter("a-category-name");
			
			/* エラー判定用 */
			boolean isError = false;
			
			/* エラー時再表示用 */
			request.setAttribute("aCategoryName", aCategoryName);
			
			/* カテゴリ名バリデーション */
			if (aCategoryName.isBlank()) {
				request.setAttribute("aCategoryError", "カテゴリ名が入力されていません。");
				isError = true;
			} else if (aCategoryName.length() > 20) {
				request.setAttribute("aCategoryError", "カテゴリ名は20文字以内で入力してください。");
				isError = true;
			}
			
			/* エラーがある場合はページを再表示 */
			if (isError) {
				request.getRequestDispatcher("/WEB-INF/view/addACategory.jsp").forward(request, response);
			} 
			/* エラーがない場合は登録 */
			else if (!isError) {
				/* 取得した名前をセット */
				ACategory aCategory = new ACategory();
				aCategory.setaCategoryName(aCategoryName);
				
				/* 追加 */
				ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
				aCategoryDao.insert(aCategory);
				
				/* 完了ページ表示 */
				request.getRequestDispatcher("/WEB-INF/view/addACategoryDone.jsp").forward(request, response);
			}

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
