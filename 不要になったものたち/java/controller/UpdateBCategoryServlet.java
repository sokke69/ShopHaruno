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
 * Servlet implementation class UpdateBCategoryServlet
 */
@WebServlet("/updateBCategory")
public class UpdateBCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		try {
			ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
			List<ACategory> aCategoryList = aCategoryDao.findAll();
			request.setAttribute("aCategoryList", aCategoryList);
			
			BCategoryDao bCategoryDao = DaoFactory.createBCategoryDao();
			BCategory bCategory = bCategoryDao.findById(id);
			request.setAttribute("bCategory", bCategory);
			
			request.getRequestDispatcher("/WEB-INF/view/updateBCategory.jsp").forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		String bCategoryName = request.getParameter("b-category-name");
		Integer aCategoryId = Integer.parseInt(request.getParameter("b-category-a-id"));
		
		BCategory bCategory = new BCategory();
		bCategory.setId(id);
		bCategory.setbCategoryName(bCategoryName);
		bCategory.setaCategoryId(aCategoryId);
		
		try {
			BCategoryDao bCategoryDao = DaoFactory.createBCategoryDao();
			bCategoryDao.update(bCategory);
			
			request.getRequestDispatcher("/WEB-INF/view/updateBCategoryDone.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
