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
 * Servlet implementation class AddProductCheckServlet
 */
@WebServlet("/addProductCheck")
public class AddProductCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().getAttribute("product");
		
		
		request.getRequestDispatcher("/WEB-INF/view/addProductCheck.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String productName = request.getParameter("product-name");
		String productUrl = request.getParameter("product-url");
		Integer aCategoryId = Integer.parseInt(request.getParameter("a-category-id"));
		String imgMain = request.getParameter("product-img-main");
		String imgSub01 = request.getParameter("product-img-sub-01");
		String imgSub02 = request.getParameter("product-img-sub-02");
		String imgSub03 = request.getParameter("product-img-sub-03");
		String imgSub04 = request.getParameter("product-img-sub-04");
		String imgSub05 = request.getParameter("product-img-sub-05");
		String imgSub06 = request.getParameter("product-img-sub-06");
		String imgSub07 = request.getParameter("product-img-sub-07");
		String imgSub08 = request.getParameter("product-img-sub-08");
		String registBy = request.getParameter("regist-by");
		
		Product product = new Product();
		
		product.setProductName(productName);
		product.setProductUrl(productUrl);
		product.setCategoryA(aCategoryId);
		product.setImgMain(imgMain);
		product.setImgSub01(imgSub01);
		product.setImgSub02(imgSub02);
		product.setImgSub03(imgSub03);
		product.setImgSub04(imgSub04);
		product.setImgSub05(imgSub05);
		product.setImgSub06(imgSub06);
		product.setImgSub07(imgSub07);
		product.setImgSub08(imgSub08);
		product.setRegistBy(registBy);
		
		try {
			ProductDao productDao = DaoFactory.createProductDao();
			productDao.insert(product);
			request.getSession().removeAttribute("product");
			request.getRequestDispatcher("/WEB-INF/view/addProductDone.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
