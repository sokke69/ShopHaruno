package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.ProductDao;
import domain.Product;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));

		try {
			ProductDao productDao = DaoFactory.createProductDao();
			Product product = productDao.findById(id);
			request.setAttribute("product", product);
			request.getRequestDispatcher("/WEB-INF/view/deleteProduct.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Product product = new Product();
		product.setId(id);
		
		try {
			ProductDao productDao = DaoFactory.createProductDao();
			productDao.delete(product);
			
			request.getRequestDispatcher("/WEB-INF/view/deleteProductDone.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException();
		}
		
	}

}
