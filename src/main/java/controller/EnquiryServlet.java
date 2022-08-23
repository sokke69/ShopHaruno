package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * Servlet implementation class EnquiryServlet
 */
@WebServlet("/enquiry")
public class EnquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/enquiry.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("request-name");
		String emailAddress = request.getParameter("request-email");
		String text = request.getParameter("request-text");
		
		/* ページ再表示したときにinputに入力しておく用 */
		request.setAttribute("requestName", name);
		request.setAttribute("requestEmailAddress", emailAddress);
		request.setAttribute("requestText", text);
		
		/* メールアドレスの正規表現チェック */
		Pattern emailAddressPattern = Pattern.compile("^([a-zA-Z0-9])+([a-zA-Z0-9._-])*@([a-zA-Z0-9_-])+([a-zA-Z0-9._-]+)+$");
		Matcher emailAddressMatcher = emailAddressPattern.matcher(emailAddress);
		
		boolean isError = false;
		
		if (name.isBlank()) {
			request.setAttribute("nameError", "お名前(会社名)が入力されていません。");
			isError = true;
		} else if (name.length() > 25) {
			request.setAttribute("nameError", "お名前(会社名)は25文字以内で入力」してください。");
			isError = true;
		} else {
			request.setAttribute("nameSuccess", "true");
		}
		
		if (emailAddress.isBlank()) {
			request.setAttribute("emailAddressError", "メールアドレスが入力されていません。");
			isError = true;
		} else if(!emailAddressMatcher.matches()) {
			request.setAttribute("emailAddressError", "メールアドレスが正しく入力されていません。");
			isError = true;
		} else {
			request.setAttribute("emailAddressSuccess", "true");
		}
		
		if (text.isBlank()) {
			request.setAttribute("textError", "お問い合わせ内容が入力されていません。");
			isError = true;
		} else if (text.length() > 1000) {
			request.setAttribute("textError", "お問い合わせ内容は1000文字以内で入力してください。");
			isError = true;
		} else {
			request.setAttribute("textSuccess", "true");
		}
		
		if (isError) {
			
			request.getRequestDispatcher("/WEB-INF/view/enquiry.jsp").forward(request, response);
			
		} else if (!isError) {
			
			String subject = "[お問い合わせ] " + name + " 様 (" + emailAddress + ")";
			
			SimpleEmail email = new SimpleEmail();
			try {
				email.setHostName("smtp.gmail.com");
				email.setStartTLSEnabled(true);
				email.setSslSmtpPort("465");
				email.setAuthentication("send.shopharuno@gmail.com", "awjs ogdi qfqx rklu");
				email.setFrom("send.shopharuno@gmail.com", "SHOP HARUNO[お問い合わせ]", "ISO-2022-JP");
				
				email.addTo("enquiry.shopharuno@gmail.com", "SHOP HARUNO", "ISO-2022-JP");
				
				email.setCharset("ISO-2022-JP");
				email.setSubject(subject);
				email.setMsg(text);
				
				email.send();
				
				request.getRequestDispatcher("/WEB-INF/view/enquiryDone.jsp").forward(request, response);
			} catch (EmailException e) {
				request.getRequestDispatcher("/WEB-INF/view/enquiryFail.jsp").forward(request, response);
			}
			
		}
		
	}

}
