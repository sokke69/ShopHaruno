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
 * Servlet implementation class ListBCategoryByAIdServlet
 */
@WebServlet("/listBCategoryByAId")
public class ListBCategoryByAIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		//System.out.println("前ページで取得したidは" + id + "です。");
		
		try {
			BCategoryDao bCategoryDao = DaoFactory.createBCategoryDao();
			List<BCategory> bCategoryListByAId = bCategoryDao.pickByAId(id);
			
			ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
			List<ACategory> aCategoryList = aCategoryDao.findAll();
			
			request.setAttribute("bCategoryListByAId", bCategoryListByAId);
			request.setAttribute("aCategoryList", aCategoryList);
			request.getRequestDispatcher("/WEB-INF/view/listBCategoryByAId.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
