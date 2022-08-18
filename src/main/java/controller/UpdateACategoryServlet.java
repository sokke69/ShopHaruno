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
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		try {
			ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
			ACategory aCategory = aCategoryDao.findById(id);
			request.setAttribute("aCategory", aCategory);
			
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
		
		ACategory aCategory = new ACategory();
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		String aCategoryName = request.getParameter("a-category-name");
		
		aCategory.setId(id);
		aCategory.setaCategoryName(aCategoryName);
		
		try {
			ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
			aCategoryDao.update(aCategory);
			
			request.getRequestDispatcher("/WEB-INF/view/updateACategoryDone.jsp").forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

}





