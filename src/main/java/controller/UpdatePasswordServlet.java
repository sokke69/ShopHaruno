package controller;

import java.io.IOException;
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

/**
 * Servlet implementation class UpdatePasswordServlet
 */
@WebServlet("/updatePassword")
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/updatePassword.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			/* SessionからログインしているユーザーのIDを取得 */
			Integer id = (Integer) request.getSession().getAttribute("userId");
			
			/* 入力された値の取得 */
			String oldPass = request.getParameter("request-old-login-pass");
			String newPass = request.getParameter("request-new-login-pass");
			String newPassCheck = request.getParameter("request-new-login-pass-check");
			
			/* パスワードの正規表現チェック */
			Pattern passPattern = Pattern.compile("[0-9a-zA-Z]+");
			Matcher oldPassMatcher = passPattern.matcher(oldPass);
			Matcher newPassMatcher = passPattern.matcher(newPass);
			Matcher newPassCheckMatcher = passPattern.matcher(newPassCheck);
			
			/* 入力されたパスワードをBCryptでハッシュ化 */
			String hashedNewPass = BCrypt.hashpw(newPass, BCrypt.gensalt());
			
			/* 入力された旧パスワードがDBのパスワードと等しいかチェック */
			AdminDao adminDao = DaoFactory.createAdminDao();
			boolean checkPass = adminDao.checkPassword(id, oldPass);
			
			/* バリデーションチェック用boolean作成 */
			boolean isError = false;
			
			/* バリデーション 旧パスワード */
			if (oldPass.isBlank()) {
				request.setAttribute("oldLoginPassError", "旧パスワードが未入力です。");
				isError = true;
			} else if ((oldPass.length() < 6 || oldPass.length() > 20) && !(oldPassMatcher.matches())) {
				request.setAttribute("oldLoginPassError", "旧パスワードは6字以上20字以内で入力してください。使用できる文字は半角英数字のみです。");
				isError = true;
			} else if (oldPass.length() < 6 || oldPass.length() > 20) {
				request.setAttribute("oldLoginPassError", "旧パスワードは6字以上20字以内で入力してください。");
				isError = true;
			} else if (!oldPassMatcher.matches()) {
				request.setAttribute("oldLoginPassError", "旧パスワードに使用できる文字文字は半角英数字のみです。");
				isError = true;
			} else if (!checkPass) {
				request.setAttribute("oldLoginPassError", "旧パスワードが違います");
				isError = true;
			} else {
				request.setAttribute("oldLoginPassSuccess", "他項目にエラーがある為もう一度入力をお願いします。");
			}
			
			/* バリデーション 新パスワード */
			if (newPass.isBlank()) {
				request.setAttribute("newLoginPassError", "新パスワードが未入力です。");
				isError = true;
			} else if ((newPass.length() < 6 || newPass.length() > 20) && !(newPassMatcher.matches())) {
				request.setAttribute("newLoginPassError", "新パスワードは6字以上20字以内で入力してください。使用できる文字文字は半角英数字のみです。");
				isError = true;
			} else if (newPass.length() < 6 || newPass.length() > 20) {
				request.setAttribute("newLoginPassError", "新パスワードは6字以上20字以内で入力してください。");
				isError = true;
			} else if (!newPassMatcher.matches()) {
				request.setAttribute("newLoginPassError", "新パスワードに使用できる文字文字は半角英数字のみです。");
				isError = true;
			} 
			
			/* バリデーション 新パスワード(確認) */
			if (newPassCheck.isBlank()) {
				request.setAttribute("newLoginPassCheckError", "新パスワード(確認)が未入力です。");
				isError = true;
			} else if ((newPassCheck.length() < 6 || newPassCheck.length() > 20) && !(newPassCheckMatcher.matches())) {
				
			} else if (newPassCheck.length() < 6 || newPassCheck.length() > 20) {
				request.setAttribute("newLoginPassCheckError", "新パスワードは6字以上20字以内で入力してください。");
				isError = true;
			} else if (!newPassCheckMatcher.matches()) {
				request.setAttribute("newLoginPassCheckError", "新パスワードに使用できる文字文字は半角英数字のみです。");
				isError = true;
			} 
			
			/* パスワード同一入力チェック */
			if (newPass.isBlank() && newPassCheck.isBlank()) {
				request.setAttribute("newLoginPassError", "新パスワードが未入力です。");
				request.setAttribute("newLoginPassCheckError", "新パスワード(確認)が未入力です。");
			} else if (!newPass.equals(newPassCheck)) {
				request.setAttribute("newLoginPassSameError", "同じログインパスワードが入力されていません。");
				isError = true;
			} else {
				request.setAttribute("newLoginPassSameSuccess", "他項目にエラーがある為もう一度入力をお願いします。");
			}
			
			/* パスワード同一でもどちらかにエラーがあれば同一チェックエラーは消去し非表示に */
			if (request.getAttribute("newLoginPassError") != null ||
					request.getAttribute("newLoginPassSameError") != null) {
				request.setAttribute("newLoginPassSameSuccess", null);
			}
			
			/* 項目に問題があった場合エラーを表示してページを再表示 */
			if (isError) {
				request.getRequestDispatcher("/WEB-INF/view/updatePassword.jsp").forward(request, response);
			} 
			
			/* 項目に問題がなかった場合はパスワードを変更し完了ページを表示 */
			if (!isError){
				/* UPDATE */
				adminDao.updatePassword(id, hashedNewPass);
				
				/*完了ページ表示用*/
				request.getSession().setAttribute("completeTitle", "パスワード変更");
				request.getSession().setAttribute("completeMessage", "パスワードを変更しました。");
				request.getSession().setAttribute("completeLink1Title", "マイアカウント");
				request.getSession().setAttribute("completeLink1", "viewMyData");
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
