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
 * Servlet implementation class ListACategoryServlet
 */
@WebServlet("/listBCategory")
public class ListBCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListBCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			BCategoryDao bCategoryDao = DaoFactory.createBCategoryDao();
			List<BCategory> bCategoryList = bCategoryDao.findAll();
			
			ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
			List<ACategory> aCategoryList = aCategoryDao.findAll();
			
			request.setAttribute("bCategoryList", bCategoryList);
			request.setAttribute("aCategoryList", aCategoryList);
			request.getRequestDispatcher("/WEB-INF/view/listBCategory.jsp").forward(request, response);
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
