package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/*")
public class AuthFilter extends HttpFilter implements Filter {

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public AuthFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		String uri = req.getRequestURI();
		if (!uri.contains("/imgs/") && 
				!uri.endsWith("/login") && 
				!uri.contains("/css/") && 
				!uri.contains("/js/") && 
				!uri.contains("/index") &&
				!uri.contains("/enquiry")) {
			if (session.getAttribute("userName") == null) {
				res.sendRedirect(req.getContextPath() + "/login");
				return;
			}
		}
		
		/* ユーザーリストページ遷移時masterのみユーザーの追加・編集・削除可能なlistUserMasterOnlyへ */
		if (uri.endsWith("/listUser")) {
			if (session.getAttribute("userIsMaster") != null) {
				res.sendRedirect(req.getContextPath() + "/listUserMasterOnly");
				return;
			} 
		}
		
		/* それ以外のユーザーがユーザー追加編集削除画面へ遷移しようとすると閲覧専用のlistUserへ 
		 * 直接URLを打ち込んでadd～等に飛ぼうとしてもlistUserへ */
		if(uri.endsWith("/addUser") ||
				uri.endsWith("/addUserDone") ||
				uri.endsWith("/updateUser") ||
				uri.endsWith("/updateUserDone") ||
				uri.endsWith("/deleteUser") ||
				uri.endsWith("/deleteUserDone")) {
			if (session.getAttribute("userIsMaster") == null) {
				res.sendRedirect(req.getContextPath() + "/listUser");
				return;
			}
		}
		
		/* ユーザータイプregister以外でURLにRegisterが含まれるページに遷移しようとすると閲覧不可へ */
		if(uri.equals("/addUserRegisterOnly")) {
			if (session.getAttribute("userIsRegister") == null) {
				res.sendRedirect(req.getContextPath() + "/notView");
				return;
			}
		}
		
		/* ユーザーがmasterでない場合かつURLにMasterOnlyが含まれる場合は閲覧不可のページへ */
		if (uri.contains("MasterOnly")) {
			if (session.getAttribute("userIsMaster") == null) {
				res.sendRedirect(req.getContextPath() + "/notView");
				return;
			}
		}
		
		/* ユーザーがregisterのとき表示しないで移動 */
		if (!uri.contains("Register") &&
				!uri.contains("login") && 
				!uri.contains("logout") &&
				!uri.contains("index") && 
				!uri.contains("enquiry")) {
			if (session.getAttribute("userIsRegister") != null) {
				request.getRequestDispatcher("/WEB-INF/view/addUserRegisterOnly.jsp").forward(request, response);
				return;
			}
		}	


		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
