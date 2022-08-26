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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			/* ログインフォームから取得 */
			String userName = request.getParameter("login-id");
			String userPass = request.getParameter("login-pass");

			/* ログインIDの正規表現チェック */
			Pattern namePattern = Pattern.compile("[0-9a-zA-Z\\-\\_]+");
			Matcher nameMatcher = namePattern.matcher(userName);

			/* ログインパスの正規表現チェック */
			Pattern passPattern = Pattern.compile("[0-9a-zA-Z]+");
			Matcher passMatcher = passPattern.matcher(userPass);

			/* ログインチェック フォームに入力された内容とDBに一致するものがあればadminにreturn有り→ログイン */
			AdminDao adminDao = DaoFactory.createAdminDao();
			boolean findIs = adminDao.findByLoginIdAndLoginPass(userName, userPass);

			/* admin有り→データベースリストへ */
			if (findIs) {
				/* 取得したuserNameからDBの対応データを取り出す */
				Admin admin = new Admin();
				admin = adminDao.findByUserName(userName);

				/* セッションにログインユーザー情報(ID・ログインID・ユーザーニックネーム)格納 */
				Integer sessionId = admin.getId();
				String sessionUserName = admin.getUserName();
				String sessionUserNickName = admin.getUserNickName();
				request.getSession().setAttribute("userId", sessionId);
				request.getSession().setAttribute("userName", sessionUserName);
				request.getSession().setAttribute("userNickName", sessionUserNickName);

				/* セッションにログインユーザー情報(ログインタイプID)格納するための変数用意 */
				Integer sessionUserType = admin.getTypeId();

				/*
				 * ページ遷移チェック セッションに格納する情報はフィルター(filter/AuthFilter)で使用
				 */
				boolean register = false;
				if (sessionUserType == 1) {
					request.getSession().setAttribute("userIsMaster", sessionUserType);
				} else if (sessionUserType == 2) {
					request.getSession().setAttribute("userIsUser", sessionUserType);
				} else if (sessionUserType == 3) {
					request.getSession().setAttribute("userIsTester", sessionUserType);
				} else if (sessionUserType == 4) {
					request.getSession().setAttribute("userIsRegister", sessionUserType);
					register = true;
				}

				/* 4(Register)ならユーザー登録画面(RegisterOnly)へ */
				if (register) {
					response.sendRedirect("addUserRegisterOnly");
				}

				/* 1～3(Master,User,Tester)ならデータベストリストへ */
				else if (!register) {
					response.sendRedirect("listDb");
				}
				
				
				

				/* admin無し→ログイン画面へ戻る */
			} else {
				/* ログインエラー判断変数 */
				boolean isError = false;
				
				/* userName空欄・文字数・パターン双方チェック */
				if (userName.isBlank()) {
					request.setAttribute("nameError", "※ ログインIDが入力されていません。");
					isError = true;
				} else if (!(nameMatcher.matches()) && (userName.length() > 12)) {
					request.setAttribute("nameError", "※ ログインIDは12文字以内で入力してください。使用できる文字は半角英数字と「-」「_」です。");
					isError = true;
				} else if (!nameMatcher.matches()) {
					request.setAttribute("nameError", "※ 使用できる文字は半角英数字と「-」「_」です。");
					isError = true;
				} else if (userName.length() > 12) {
					request.setAttribute("nameError", "※ ログインIDは12文字以内で入力してください。");
					isError = true;
				} else {
					request.setAttribute("nameError", "※ ログインIDもしくはパスワードが違います。");
					isError = true;
				}

				/* userPass空欄・文字数・パターン双方チェック */
				if (userPass.isBlank()) {
					request.setAttribute("passError", "※ パスワードが入力されていません。");
				} else if ((userPass.length() > 20) && !(passMatcher.matches())) {
					request.setAttribute("passError", "※ パスワードは20文字以内で入力してください。使用できる文字は半角英数字と「_」のみです。");
					isError = true;
				} else if (!passMatcher.matches()) {
					request.setAttribute("passError", "※ 使用できる文字は半角英数字です。");
					isError = true;
				} else if (userPass.length() > 20) {
					request.setAttribute("passError", "※ パスワードは20文字以内で入力してください。");
					isError = true;
				} else {
					request.setAttribute("passError", "※ ログインIDもしくはパスワードが違います。");
					isError = true;
				}
				
				/* isErrorがtrueならエラーメッセージを表示しページを再表示 */
				if (isError) {
					request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
					return;
				}

			}
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
