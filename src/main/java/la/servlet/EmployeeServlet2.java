package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.EmployeeBean;
import la.dao.DAOException;
import la.dao.EmployeeDAO2;

/**
 * Servlet implementation class EmployeeServlet2
 */
@WebServlet("/EmployeeServlet2")
public class EmployeeServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");

			String action = request.getParameter("action");

			EmployeeDAO2 dao = new EmployeeDAO2();
			if (action.contentEquals("add")) {
				int code = Integer.parseInt(request.getParameter("code"));
				String name = request.getParameter("name");
				int age = Integer.parseInt(request.getParameter("age"));
				String tel = request.getParameter("tel");
				dao.addEmployee(code, name, age, tel);
				List<EmployeeBean> list = dao.findAll();
				request.setAttribute("employees", list);
				gotoPage(request, response, "/showEmployee2.jsp");
			} else if (action.equals("delete")) {
				int code = Integer.parseInt(request.getParameter("code"));
				dao.deleteByPrimaryKey(code);

				List<EmployeeBean> list = dao.findAll();
				request.setAttribute("employees", list);
				gotoPage(request, response, "/showEmployee2.jsp");
			} else if (action.contentEquals("search")) {
				String name = request.getParameter("name");
				List<EmployeeBean> list = dao.findByName(name);
				request.setAttribute("employees", list);
				gotoPage(request, response, "/showEmployee2.jsp");
			} else {
				request.setAttribute("message", "正しく操作してください");
				gotoPage(request, response, "/errInternal.jsp");
			}

		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました");
			gotoPage(request, response, "/errInternal.jsp");

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
