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
				!uri.contains("/index")) {
			if (session.getAttribute("userName") == null) {
				res.sendRedirect(req.getContextPath() + "/login");
				return;
			}
		}

		Integer userType = (Integer) session.getAttribute("userType");
		// ユーザータイプ1(master)の場合のみ/listUserOnlyMasterを開きそれ以外は閲覧のみのlistUserを開く
		if (uri.contains("User") ) {
			if (userType == 1) {
				res.sendRedirect(req.getContextPath() + "/listUserOnlyMaster");
				return;
			} else {
				res.sendRedirect(req.getContextPath() + "/listUser");
				return;
			}
		// ユーザータイプ3(test)の場合全データベースの追加・編集・削除を不可にする為閲覧専用ページに飛ばす
		} else if (uri.contains("Product") && userType == 3) {
				res.sendRedirect(req.getContextPath() + "/listProductOnlyView");
				return;
		} else if (uri.contains("ACategory") && userType == 3) {
				res.sendRedirect(req.getContextPath() + "/listACategoryOnlyView");
				return;
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
