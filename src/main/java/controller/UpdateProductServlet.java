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
import dao.ProductDao;
import domain.ACategory;
import domain.BCategory;
import domain.Product;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		try {
			ProductDao productDao = DaoFactory.createProductDao();
			Product product = productDao.findById(id);
			request.setAttribute("product", product);
			
			ACategoryDao aCategoryDao = DaoFactory.createACategoryDao();
			List<ACategory> aCategoryList = aCategoryDao.findAll();
			request.setAttribute("aCategoryList", aCategoryList);
			
			BCategoryDao bCategoryDao = DaoFactory.createBCategoryDao();
			List<BCategory> bCategoryList = bCategoryDao.findAll();
			request.setAttribute("bCategoryList", bCategoryList);
			
			request.getRequestDispatcher("/WEB-INF/view/updateProduct.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Product product = new Product();
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		String productName = request.getParameter("product-name");
		String productUrl = request.getParameter("product-url");
		Integer aCategoryId = Integer.parseInt(request.getParameter("a-category-id"));
		String productImgMain = request.getParameter("product-img-main");
		String productImgSub01 = request.getParameter("product-img-sub-01");
		String productImgSub02 = request.getParameter("product-img-sub-02");
		String productImgSub03 = request.getParameter("product-img-sub-03");
		String productImgSub04 = request.getParameter("product-img-sub-04");
		String productImgSub05 = request.getParameter("product-img-sub-05");
		String productImgSub06 = request.getParameter("product-img-sub-06");
		String productImgSub07 = request.getParameter("product-img-sub-07");
		String productImgSub08 = request.getParameter("product-img-sub-08");
		String productUpdateBy = (String) request.getSession().getAttribute("userNickName");
		
		
		product.setId(id);
		product.setProductName(productName);
		product.setProductUrl(productUrl);
		product.setCategoryA(aCategoryId);
		product.setImgMain(productImgMain);
		product.setImgSub01(productImgSub01);
		product.setImgSub02(productImgSub02);
		product.setImgSub03(productImgSub03);
		product.setImgSub04(productImgSub04);
		product.setImgSub05(productImgSub05);
		product.setImgSub06(productImgSub06);
		product.setImgSub07(productImgSub07);
		product.setImgSub08(productImgSub08);
		product.setUpdateBy(productUpdateBy);
		
		try {
			//ProductDao productDao = DaoFactory.createProductDao();
			//productDao.update(product);
			
			request.setAttribute("product", product);
			request.getSession().setAttribute("product", product);
			
			response.sendRedirect(request.getContextPath() + "/updateProductCheck");
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

}
