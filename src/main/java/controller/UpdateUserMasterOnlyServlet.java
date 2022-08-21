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

import dao.AdminDao;
import dao.DaoFactory;
import dao.UserTypeDao;
import domain.Admin;
import domain.UserType;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/updateUserMasterOnly")
public class UpdateUserMasterOnlyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		try {
			AdminDao adminDao = DaoFactory.createAdminDao();
			Admin admin = adminDao.findById(id);
			Integer typeId = adminDao.findTypeIdById(id);
			request.setAttribute("user", admin);
			request.setAttribute("typeId", typeId);
			
			//System.out.println("typeId : " + typeId);
			
			UserTypeDao userTypeDao = DaoFactory.createUserTypeDao();
			List<UserType> userTypeList = userTypeDao.findAll();
			Integer countTypeId = userTypeDao.countTypeId(); 
			request.setAttribute("userTypeList", userTypeList);
			request.setAttribute("countTypeId", countTypeId);
			
			//System.out.println("countTypeId : " + countTypeId);
			
			request.getRequestDispatcher("/WEB-INF/view/updateUserMasterOnly.jsp").forward(request, response);
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
			
			
			
			/* 入力された値の取得 */
			Integer id = Integer.parseInt(request.getParameter("id"));
			String userName = request.getParameter("request-user-name");
			String loginId = request.getParameter("request-login-id");
			Integer typeId = Integer.parseInt(request.getParameter("request-user-type"));
			
			/* ページを再表示したときのユーザータイプ再取得用 */
			UserTypeDao userTypeDao = DaoFactory.createUserTypeDao();
			List<UserType> userTypeList = userTypeDao.findAll();
			Integer countTypeId = userTypeDao.countTypeId(); 
			request.setAttribute("userTypeList", userTypeList);
			request.setAttribute("countTypeId", countTypeId);
			
			/* ページを再表示したときのinput value自動入力 */
			Admin admin = new Admin();
			admin.setId(id);
			admin.setUserNickName(userName);
			admin.setUserName(loginId);
			admin.setTypeId(typeId);
			request.setAttribute("user", admin);
			request.setAttribute("typeId", typeId);
			
			/* ログインIDがDBと重複していないかチェック */
			AdminDao adminDao = DaoFactory.createAdminDao();
			boolean checkLoginIdIs = adminDao.checkUserName(loginId);
			/* ログインIDの正規表現チェック */
			Pattern namePattern = Pattern.compile("[0-9a-zA-Z\\-\\_]+");
			Matcher nameMatcher = namePattern.matcher(loginId);
			
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
			
			/* バリデーション ユーザータイプ */
			if (typeId == 0) {
				request.setAttribute("typeError", "選択してください。");
				isError = true;
			} else {
				request.setAttribute("typeSuccess", "true");
			}
			
			/* 項目に問題があった場合エラーを表示してページを再表示 */
			if(isError){
				request.getRequestDispatcher("/WEB-INF/view/updateUserMasterOnly.jsp").forward(request, response);
			}
			
			if (!isError) {
				/* UPDATE */
				adminDao.update(admin);
				
				request.getRequestDispatcher("/WEB-INF/view/updateUserDone.jsp").forward(request, response);
			}
			
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

}
