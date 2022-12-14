package controller;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			/* ユーザータイプ取得用 */
			UserTypeDao userTypeDao = DaoFactory.createUserTypeDao();
			List<UserType> userTypeList = userTypeDao.findAll();
			request.setAttribute("userTypeList", userTypeList);
			/* ページ表示 */
			request.getRequestDispatcher("/WEB-INF/view/addUserMasterOnly.jsp").forward(request, response);

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
			/* 入力された値の取得 */
			String userName = request.getParameter("request-user-name");
			String loginId = request.getParameter("request-login-id");
			String loginPass = request.getParameter("request-login-pass");
			String loginPassCheck = request.getParameter("request-login-pass-check");
			Integer typeId = Integer.parseInt(request.getParameter("request-user-type"));
						
			/* ページを再表示したときのユーザータイプ再取得用 */
			UserTypeDao userTypeDao = DaoFactory.createUserTypeDao();
			List<UserType> userTypeList = userTypeDao.findAll();
			Integer countTypeId = userTypeDao.countTypeId(); 
			request.setAttribute("userTypeList", userTypeList);
			request.setAttribute("countTypeId", countTypeId);
			
			/* ページを再表示したときのinput value自動入力(パスワード以外) */
			request.setAttribute("inputedUserName", userName);
			request.setAttribute("inputedLoginId", loginId);
			request.setAttribute("inputedTypeId", typeId);
			
			/* ログインIDがDBと重複していないかチェック */
			AdminDao adminDao = DaoFactory.createAdminDao();
			boolean checkLoginIdIs = adminDao.checkUserName2(loginId);
			/* ログインIDの正規表現チェック */
			Pattern namePattern = Pattern.compile("[0-9a-zA-Z\\-\\_]+");
			Matcher nameMatcher = namePattern.matcher(loginId);
			
			/* ログインパスワードの正規表現チェック */
			Pattern passPattern = Pattern.compile("[0-9a-zA-Z]+");
			Matcher passMatcher = passPattern.matcher(loginPass);
			Matcher passCheckMatcher = passPattern.matcher(loginPassCheck);
			
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
			if (loginId.isBlank()) {
				request.setAttribute("loginIdError", "ログインIDが未入力です。");
				isError = true;
			} else if (loginId.length() < 4 || loginId.length() > 12) {
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
			
			/* バリデーション パスワード */
			if (loginPass.isBlank()) {
				request.setAttribute("loginPassError", "ログインパスワードが未入力です。");
				isError = true;
			} else if (loginPass.length() < 6 || loginPass.length() > 20) {
				request.setAttribute("loginPassError", "ログインパスワードは6字以上20字以内で入力してください。");
				isError = true;
			} else if (!passMatcher.matches()) {
				request.setAttribute("loginPassError", "ログインパスワードに使える文字は半角英数字のみです。");
				isError = true;
			} 
			
			/* バリデーション パスワード(確認) */
			if (loginPassCheck.isBlank()) {
				request.setAttribute("loginPassCheckError", "ログインパスワード(確認)が未入力です。");
				isError = true;
			} else if (loginPassCheck.length() < 6 || loginPassCheck.length() > 20) {
				request.setAttribute("loginPassCheckError", "ログインパスワードは6字以上20字以内で入力してください。");
				isError = true;
			} else if (!passCheckMatcher.matches()) {
				request.setAttribute("loginPassCheckError", "ログインパスワードに使える文字は半角英数字のみです。");
				isError = true;
			} 
			
			/* パスワード同一入力チェック */
			if (loginPass.isBlank() && loginPassCheck.isBlank()) {
				request.setAttribute("loginPassError", "ログインパスワードが未入力です。");
				request.setAttribute("loginPassCheckError", "ログインパスワード(確認)が未入力です。");
			} else if (!loginPass.equals(loginPassCheck)) {
				request.setAttribute("loginPassSameError", "同じログインパスワードが入力されていません。");
				isError = true;
			} else {
				request.setAttribute("loginPassSameSuccess", "他項目にエラーがある為もう一度入力をお願いします。");
			}
			
			/* パスワード同一でもどちらかにエラーがあれば同一チェックエラーは消去し非表示に */
			if (request.getAttribute("loginPassError") != null ||
					request.getAttribute("loginPassSameError") != null) {
				request.setAttribute("loginPassSameSuccess", null);
			}
			
			/* バリデーション ユーザータイプ */
			if (typeId == 0) {
				request.setAttribute("typeError", "選択してください。");
				isError = true;
			} else {
				request.setAttribute("typeSuccess", "true");
			}
			
			
			
			
			/* 項目に問題があった場合エラーを表示してページを再表示 */
			if(isError){
				request.getRequestDispatcher("/WEB-INF/view/addUserMasterOnly.jsp").forward(request, response);
			}
			
			/* 項目に問題がなかった場合ユーザー追加完了ページを表示 */
			if (!isError) {
				/* 入力されたパスワードをBCryptでハッシュ化 */
				String hashedPass = BCrypt.hashpw(loginPass, BCrypt.gensalt());
				
				
				/* INSERT用にadminへ各要素を追加 */
				Admin admin = new Admin();
				admin.setUserNickName(userName);
				admin.setUserName(loginId);
				admin.setUserPass(hashedPass);
				admin.setTypeId(typeId);

				adminDao.insert(admin);
				
				/*完了ページ表示用*/
				request.getSession().setAttribute("completeTitle", "ユーザー追加");
				request.getSession().setAttribute("completeMessage", "ユーザーを追加しました。");
				request.getSession().setAttribute("completeLink1Title", "ユーザーリスト");
				request.getSession().setAttribute("completeLink1", "listUser");
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
