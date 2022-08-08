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
import domain.Product;

/**
 * Servlet implementation class AaddProductServlet
 */
@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
			List<ACategory> aCategoryList = aCategoryDao.findAll();
			request.setAttribute("aCategoryList", aCategoryList);
			
			BCategoryDao bCategoryDao = DaoFactory.createBCategoryDao();
			List<BCategory> bCategoryList = bCategoryDao.findAll();
			request.setAttribute("bCategoryList", bCategoryList);
			
			if (request.getSession().getAttribute("product") != null) {
				System.out.println("sessionにproduct有り");
				request.getSession().removeAttribute("product");
			} else {
				System.out.println("sessionにproduct無し");
			}
			
			request.getRequestDispatcher("/WEB-INF/view/addProduct.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if (request.getSession().getAttribute("product") != null) {
			request.getSession().removeAttribute("product");
		}
		
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
		String userNickName = (String) request.getSession().getAttribute("userNickName");
		
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
		product.setRegistBy(userNickName);
		
		request.setAttribute("product", product);
		request.getSession().setAttribute("product", product);
		
		try {
			//ProductDao productDao = DaoFactory.createProductDao();
			//productDao.insert(product);
			response.sendRedirect(request.getContextPath() + "/addProductCheck");
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

}










