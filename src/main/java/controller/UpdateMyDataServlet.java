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
 * Servlet implementation class ChangeMyDataServlet
 */
@WebServlet("/updateMyData")
public class UpdateMyDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Integer id = (Integer) request.getSession().getAttribute("userId");

			AdminDao adminDao = DaoFactory.createAdminDao();
			Admin admin = adminDao.findById(id);

			request.setAttribute("myData", admin);

			request.getRequestDispatcher("/WEB-INF/view/updateMyData.jsp").forward(request, response);

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
			/* SessionからログインしているユーザーのIDを取得 */
			Integer id = (Integer) request.getSession().getAttribute("userId");

			AdminDao adminDao = DaoFactory.createAdminDao();
			
			/* 入力された値の取得 */
			String userName = request.getParameter("request-user-name");
			String newLoginId = request.getParameter("request-login-id");
			
			/* アップデート用Adminセット */
			Admin admin = new Admin();
			admin.setId(id);
			admin.setUserName(newLoginId);
			admin.setUserNickName(userName);
			
			/* ログインIDがDBと重複していないかチェック */
			String oldLoginId = adminDao.findLoginIdById(id);
			boolean checkLoginIdIs = adminDao.checkUserName(oldLoginId,newLoginId);
			/* ログインIDの正規表現チェック */
			Pattern namePattern = Pattern.compile("[0-9a-zA-Z\\-\\_]+");
			Matcher nameMatcher = namePattern.matcher(newLoginId);
			
			/* バリデーションチェック用boolean作成 */
			boolean isError = false;
			
			/* バリデーション ユーザー名 */
			if (userName.isBlank()) {
				request.setAttribute("nameError", "ユーザー名が未入力です。");
				isError = true;
			} else if (userName.length() > 12) {
				request.setAttribute("nameError", "ユーザー名は12文字以内で入力してください。");
				isError = true;
			} else {
				request.setAttribute("nameSuccess", "true");
			}
			
			/* バリデーション ログインID */
			if (newLoginId.isBlank()) {
				request.setAttribute("loginIdError", "ログインIDが未入力です。");
				isError = true;
			} else if (newLoginId.length() < 4 || newLoginId.length() > 12) {
				request.setAttribute("loginIdError", "ログインIDは4文字以上12文字以内で入力してください。");
				isError = true;
			} else if(!nameMatcher.matches()) {
				request.setAttribute("loginIdError", "ログインIDに使える文字は半角英数字と「-」「_」のみです。");
				isError = true;
			} else if (!checkLoginIdIs) {
				request.setAttribute("loginIdError", "このログインIDは既に使われています。");
				isError = true;
			} else {
				request.setAttribute("loginIdSuccess", "true");
			}
			
			
			
			/* 項目に問題があった場合エラーを表示してページを再表示 */
			if(isError){
				
				/* ページを再表示するときのinput value自動入力 */
				request.setAttribute("myData", admin);
				
				request.getRequestDispatcher("/WEB-INF/view/updateMyData.jsp").forward(request, response);
			}
			
			/* 問題がなければデータを更新して完了画面を表示 */
			if (!isError) {
				/* UPDATE */
				adminDao.updateNickNameAndUserId(admin);
				
				request.getRequestDispatcher("/WEB-INF/view/updateMyDataDone.jsp").forward(request, response);
			}

		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
