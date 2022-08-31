package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.ProductDao;
import domain.Product;

/**
 * Servlet implementation class DeleteImgServlet
 */
@WebServlet("/deleteImg")
public class DeleteImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			/* URLからIDを取得 */
			Integer id = Integer.parseInt(request.getParameter("id"));

			/* DaoFactoryから使用するDaoを作成 */
			ProductDao productDao = DaoFactory.createProductDao();

			/* idから対象の商品を取得しセット */
			Product product = productDao.findById(id);
			Integer countImg = productDao.getImgCount(id);
			Integer countImgPlus = countImg + 1;
			request.setAttribute("product", product);
			request.setAttribute("countImgPlus", countImgPlus);

			/* ページを表示 */
			request.getRequestDispatcher("/WEB-INF/view/deleteImg.jsp").forward(request, response);
		} catch (Exception e) {
			new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			/* URLからIDを取得 */
			Integer id = Integer.parseInt(request.getParameter("id"));

			/* DaoFactoryから使用するDaoを作成 */
			ProductDao productDao = DaoFactory.createProductDao();

			/* チェックボタン取得 */
			String check01 = request.getParameter("check01");
			String check02 = request.getParameter("check02");
			String check03 = request.getParameter("check03");
			String check04 = request.getParameter("check04");
			String check05 = request.getParameter("check05");
			String check06 = request.getParameter("check06");
			String check07 = request.getParameter("check07");
			String check08 = request.getParameter("check08");
			String check09 = request.getParameter("check09");

			/* 取得したexeの個数を計算 */
			Integer countDelete = 0;
			if (check01.equals("exe")) {
				countDelete += 1;
			}
			if (check02.equals("exe")) {;
				countDelete += 1;
			}
			if (check03.equals("exe")) {
				countDelete += 1;
			}
			if (check04.equals("exe")) {
				countDelete += 1;
			}
			if (check05.equals("exe")) {
				countDelete += 1;
			}
			if (check06.equals("exe")) {
				countDelete += 1;
			}
			if (check07.equals("exe")) {
				countDelete += 1;
			}
			if (check08.equals("exe")) {
				countDelete += 1;
			}
			if (check09.equals("exe")) {
				countDelete += 1;
			}
			
			/* 取得したexeの数が元の画像数がは同じもしくは超えるとき画像ファイルが0になってしまうのでエラーで戻る */
			Integer countImg = productDao.getImgCount(id);
			if (countDelete >= countImg) {
				request.setAttribute("id", id);
				request.getRequestDispatcher("/WEB-INF/view/updateProductFail.jsp").forward(request, response);
			} else {
				/* 取得した変数にexeが入っているなら各々削除実行 */
				countDelete = 0;
				if (check01.equals("exe")) {
					deleteImg(request, id, 1);
					countDelete += 1;
				}
				if (check02.equals("exe")) {
					deleteImg(request, id, 2);
					countDelete += 1;
				}
				if (check03.equals("exe")) {
					deleteImg(request, id, 3);
					countDelete += 1;
				}
				if (check04.equals("exe")) {
					deleteImg(request, id, 4);
					countDelete += 1;
				}
				if (check05.equals("exe")) {
					deleteImg(request, id, 5);
					countDelete += 1;
				}
				if (check06.equals("exe")) {
					deleteImg(request, id, 6);
					countDelete += 1;
				}
				if (check07.equals("exe")) {
					deleteImg(request, id, 7);
					countDelete += 1;
				}
				if (check08.equals("exe")) {
					deleteImg(request, id, 8);
					countDelete += 1;
				}
				if (check09.equals("exe")) {
					deleteImg(request, id, 9);
					countDelete += 1;
				}
				
				/* 選択された画像が削除されたため穴あきが発生してるためリネームして画像番号を詰める */
				renameImg(request, id);
				
				/* 商品情報のimgカラム変更 */
				Integer oldImgCount = productDao.getImgCount(id);
				Integer newImgCount = oldImgCount - countDelete;
				productDao.updateImgCount(id, newImgCount);
				
			
				/* 完了ページ表示用 */
				request.getSession().setAttribute("completeTitle", "商品画像削除");
				request.getSession().setAttribute("completeMessage", "商品画像の削除が完了しました。");
				request.getSession().setAttribute("completeLink1Title", "商品リスト");
				request.getSession().setAttribute("completeLink1", "listProduct");
				request.getSession().setAttribute("completeLink2Title", "データベースリスト");
				request.getSession().setAttribute("completeLink2", "listDb");
				
				/* 完了ページ移動 */
				request.getRequestDispatcher("/WEB-INF/view/done.jsp").forward(request, response);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			new ServletException(e);
		}

	}

	private File getUploadedDirectory(HttpServletRequest request) throws ServletException {
		ServletContext context = request.getServletContext();

		String path = context.getRealPath("/imgs");
		return new File(path);

	}

	private void deleteImg(HttpServletRequest request, Integer id, Integer imgNumber) throws ServletException {

		try {
			/* 編集する商品のidをString化 */
			String idStr = id.toString();

			/* imgsフォルダの位置取得 */
			File filePath = getUploadedDirectory(request);

			/* 削除実行 */
			Path p = Paths.get(filePath + "/" + idStr + "_0" + (imgNumber) + ".jpg");
			Files.delete(p);

		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ServletException(e1);
		}

	}

	private void renameImg(HttpServletRequest request, Integer id) throws ServletException {

		try {
			/* 編集する商品のidをString化 */
			String idStr = id.toString();

			/* imgsフォルダの位置取得 */
			File filePath = getUploadedDirectory(request);

			/* ファイル名設定 */
			String p01Str = filePath + "/" + idStr + "_01.jpg";
			String p02Str = filePath + "/" + idStr + "_02.jpg";
			String p03Str = filePath + "/" + idStr + "_03.jpg";
			String p04Str = filePath + "/" + idStr + "_04.jpg";
			String p05Str = filePath + "/" + idStr + "_05.jpg";
			String p06Str = filePath + "/" + idStr + "_06.jpg";
			String p07Str = filePath + "/" + idStr + "_07.jpg";
			String p08Str = filePath + "/" + idStr + "_08.jpg";
			String p09Str = filePath + "/" + idStr + "_09.jpg";
			File p01 = new File(p01Str);
			File p02 = new File(p02Str);
			File p03 = new File(p03Str);
			File p04 = new File(p04Str);
			File p05 = new File(p05Str);
			File p06 = new File(p06Str);
			File p07 = new File(p07Str);
			File p08 = new File(p08Str);
			File p09 = new File(p09Str);

			/* _01.jpgチェック */
			if (!p01.exists()) {
				if (p02.exists()) {
					p02.renameTo(p01);
				} else if (p03.exists()) {
					p03.renameTo(p01);
				} else if (p04.exists()) {
					p04.renameTo(p01);
				} else if (p05.exists()) {
					p05.renameTo(p01);
				} else if (p06.exists()) {
					p06.renameTo(p01);
				} else if (p07.exists()) {
					p07.renameTo(p01);
				} else if (p08.exists()) {
					p08.renameTo(p01);
				} else if (p09.exists()) {
					p09.renameTo(p01);
				}
			}
			/* _02.jpgチェック */
			if (!p02.exists()) {
				if (p03.exists()) {
					p03.renameTo(p02);
				} else if (p04.exists()) {
					p04.renameTo(p02);
				} else if (p05.exists()) {
					p05.renameTo(p02);
				} else if (p06.exists()) {
					p06.renameTo(p02);
				} else if (p07.exists()) {
					p07.renameTo(p02);
				} else if (p08.exists()) {
					p08.renameTo(p02);
				} else if (p09.exists()) {
					p09.renameTo(p02);
				}
			}
			/* _03.jpgチェック */
			if (!p03.exists()) {
				if (p04.exists()) {
					p04.renameTo(p03);
				} else if (p05.exists()) {
					p05.renameTo(p03);
				} else if (p06.exists()) {
					p06.renameTo(p03);
				} else if (p07.exists()) {
					p07.renameTo(p03);
				} else if (p08.exists()) {
					p08.renameTo(p03);
				} else if (p09.exists()) {
					p09.renameTo(p03);
				}
			}
			/* _04.jpgチェック */
			if (!p04.exists()) {
				if (p05.exists()) {
					p05.renameTo(p04);
				} else if (p06.exists()) {
					p06.renameTo(p04);
				} else if (p07.exists()) {
					p07.renameTo(p04);
				} else if (p08.exists()) {
					p08.renameTo(p04);
				} else if (p09.exists()) {
					p09.renameTo(p04);
				}
			}
			/* _05.jpgチェック */
			if (!p05.exists()) {
				if (p06.exists()) {
					p06.renameTo(p05);
				} else if (p07.exists()) {
					p07.renameTo(p05);
				} else if (p08.exists()) {
					p08.renameTo(p05);
				} else if (p09.exists()) {
					p09.renameTo(p05);
				}
			}
			/* _06.jpgチェック */
			if (!p06.exists()) {
				if (p07.exists()) {
					p07.renameTo(p06);
				} else if (p08.exists()) {
					p08.renameTo(p06);
				} else if (p09.exists()) {
					p09.renameTo(p06);
				}
			}
			/* _07.jpgチェック */
			if (!p07.exists()) {
				if (p08.exists()) {
					p08.renameTo(p07);
				} else if (p09.exists()) {
					p09.renameTo(p07);
				}
			}
			/* _08.jpgチェック */
			if (!p08.exists()) {
				if (p09.exists()) {
					p09.renameTo(p08);
				}
			}
			

		} catch (Exception e2) {
			e2.printStackTrace();
			throw new ServletException(e2);
		}

	}

}
