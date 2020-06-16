package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.ItemBean;
import la.dao.DAOException;
import la.dao.ItemDAO;

/**
 * Servlet implementation class ItemServlet
 */
@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8");

			// パラメータの解析
			String action = request.getParameter("action");


			ItemDAO dao = new ItemDAO();

			// パラメータなしの場合は全レコード表示
			if (action == null || action.length()==0) {
				List<ItemBean> list = dao.findAll();
				// Listをスコープに入れてJSPへフォワードする
				request.setAttribute("emps", list);
				gotoPage(request, response, "/showItem.jsp");

			} else if (action.equals("add")){  // addのときは追加する
				String name = request.getParameter("name");
				int age = Integer.parseInt(request.getParameter("age"));
				String tel = request.getParameter("tel");
				dao.addData(name,age,tel);
				// 追加後全レコード表示
				List<ItemBean> list = dao.findAll();
				// Listをスコープに入れてJSPへフォワードする
				request.setAttribute("emps", list);
				gotoPage(request, response, "/showItem.jsp");

			}else if (action.equals("delete")){  // deleteのときは削除する
			int code = Integer.parseInt(request.getParameter("code"));
			dao.deleteData(code);
			// 削除後全レコード表示
			List<ItemBean> list = dao.findAll();
			// Listをスコープに入れてJSPへフォワードする
			request.setAttribute("emps", list);
			gotoPage(request, response, "/showItem.jsp");

			} else if (action.equals("search")){  // searchのときは検索する
				int age = Integer.parseInt(request.getParameter("age"));

				List<ItemBean> list = dao.findByAge(age);
				// Listをスコープに入れてJSPへフォワードする
				request.setAttribute("emps", list);
				gotoPage(request, response, "/showItem.jsp");

				} else {
				request.setAttribute("message", "正しく操作してください");
				gotoPage(request, response, "/errInternal.jsp");
			}

		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			RequestDispatcher rd = request.getRequestDispatcher("/errorInternal.jsp");
			rd.forward(request, response);
		}

	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
