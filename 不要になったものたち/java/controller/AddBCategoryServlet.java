package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ACategoryDao;
import dao.BCategoryDao;
import dao.DaoFactory;
import domain.ACategory;
import domain.BCategory;

/**
 * Servlet implementation class AddACategorySevlet
 */
@WebServlet("/addBCategory")
public class AddBCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
			List<ACategory> aCategoryList = aCategoryDao.findAll();
			request.setAttribute("aCategoryList", aCategoryList);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		request.getRequestDispatcher("/WEB-INF/view/addBCategory.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String bCategoryName = request.getParameter("b-category-name");
		Integer bCategoryAId = Integer.parseInt(request.getParameter("b-category-a-id"));
		
		BCategory bCategory = new BCategory();
		
		bCategory.setbCategoryName(bCategoryName);
		bCategory.setaCategoryId(bCategoryAId);
		
		try {
			BCategoryDao bCategoryDao = DaoFactory.createBCategoryDao();
			bCategoryDao.insert(bCategory);
			request.getRequestDispatcher("/WEB-INF/view/addBCategoryDone.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
