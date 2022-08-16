package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ACategoryDao;
import dao.BCategoryDao;
import dao.DaoFactory;
import dao.ProductDao;
import domain.ACategory;
import domain.BCategory;
import domain.Product;

/**
 * Servlet implementation class AaddProductServlet
 */
@WebServlet("/addProduct")
@MultipartConfig(location = "C:/Users/zd2L17/temp")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		if (request.getSession().getAttribute("product") != null) {
			request.getSession().removeAttribute("product");
		}

		try {
			// productsテーブルのMAX(id)+1を取得
			ProductDao productDao = DaoFactory.createProductDao();
			Integer id = productDao.findLatestIdPlusOne();
			String idStr = id.toString();

			// メイン画像取得
			Part partMain = request.getPart("product-img-main");
			long mainFileSize = partMain.getSize();
			
			//サブ画像取得
			Part partSub01 = request.getPart("product-img-sub-01");
			Part partSub02 = request.getPart("product-img-sub-02");
			Part partSub03 = request.getPart("product-img-sub-03");
			Part partSub04 = request.getPart("product-img-sub-04");
			Part partSub05 = request.getPart("product-img-sub-05");
			Part partSub06 = request.getPart("product-img-sub-06");
			Part partSub07 = request.getPart("product-img-sub-07");
			Part partSub08 = request.getPart("product-img-sub-08");
			long sub01FileSize = partSub01.getSize();
			long sub02FileSize = partSub02.getSize();
			long sub03FileSize = partSub03.getSize();
			long sub04FileSize = partSub04.getSize();
			long sub05FileSize = partSub05.getSize();
			long sub06FileSize = partSub06.getSize();
			long sub07FileSize = partSub07.getSize();
			long sub08FileSize = partSub08.getSize();


			// メイン画像保存
			if (mainFileSize > 0) {
				File filePath = getUploadedDirectory(request);
				partMain.write(filePath + "/" + idStr + "_main.jpg");
			}
			
			//サブ画像保存
			if (sub01FileSize > 0) {
				File filePath = getUploadedDirectory(request);
				partSub01.write(filePath + "/" + idStr + "_sub01.jpg");
			}
			if (sub02FileSize > 0) {
				File filePath = getUploadedDirectory(request);
				partSub02.write(filePath + "/" + idStr + "_sub02.jpg");
			}
			if (sub03FileSize > 0) {
				File filePath = getUploadedDirectory(request);
				partSub03.write(filePath + "/" + idStr + "_sub03.jpg");
			}
			if (sub04FileSize > 0) {
				File filePath = getUploadedDirectory(request);
				partSub04.write(filePath + "/" + idStr + "_sub04.jpg");
			}
			if (sub05FileSize > 0) {
				File filePath = getUploadedDirectory(request);
				partSub05.write(filePath + "/" + idStr + "_sub05.jpg");
			}
			if (sub06FileSize > 0) {
				File filePath = getUploadedDirectory(request);
				partSub06.write(filePath + "/" + idStr + "_sub06.jpg");
			}
			if (sub07FileSize > 0) {
				File filePath = getUploadedDirectory(request);
				partSub07.write(filePath + "/" + idStr + "_sub07.jpg");
			}
			if (sub08FileSize > 0) {
				File filePath = getUploadedDirectory(request);
				partSub08.write(filePath + "/" + idStr + "_sub08.jpg");
			}
			

			String productName = request.getParameter("product-name");
			String productUrl = request.getParameter("product-url");
			Integer aCategoryId = Integer.parseInt(request.getParameter("a-category-id"));
			String imgMain = ("./imgs/" + idStr + "_main.jpg");
			String imgSub01 = ("./imgs/" + idStr + "_sub01.jpg");
			String imgSub02 = ("./imgs/" + idStr + "_sub02.jpg");
			String imgSub03 = ("./imgs/" + idStr + "_sub03.jpg");
			String imgSub04 = ("./imgs/" + idStr + "_sub04.jpg");
			String imgSub05 = ("./imgs/" + idStr + "_sub05.jpg");
			String imgSub06 = ("./imgs/" + idStr + "_sub06.jpg");
			String imgSub07 = ("./imgs/" + idStr + "_sub07.jpg");
			String imgSub08 = ("./imgs/" + idStr + "_sub08.jpg");
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

			productDao.insert(product);
			request.getSession().removeAttribute("product");
			request.getRequestDispatcher("/WEB-INF/view/addProductDone.jsp").forward(request, response);

		} catch (Exception e1) {
			throw new ServletException(e1);
		}

	}

	private File getUploadedDirectory(HttpServletRequest request) throws ServletException {
		ServletContext context = request.getServletContext();

			String path = context.getRealPath("/imgs");
			return new File(path);

	}

}
