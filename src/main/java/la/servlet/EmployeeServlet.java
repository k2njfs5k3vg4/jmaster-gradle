package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.EmpBean;
import la.dao.DAOException;
import la.dao.EmployeeDAO;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			EmployeeDAO dao = new EmployeeDAO();
			List<EmpBean> list = dao.findAll();

			request.setAttribute("employees", list);
			RequestDispatcher rd = request.getRequestDispatcher("/showEmp.jsp");
			rd.forward(request, response);

		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
			rd.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("action");

		if ("add".equals(type)) {

			String code = request.getParameter("code");
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			String tel = request.getParameter("tel");

			if (code == null || "".equals(code)) {
				doGet(request, response);
				return;
			}

			if (name == null || "".equals(name)) {
				name = "未登録";
			}

			if (age == null || "".equals(age)) {
				age = "0";
			}

			if (tel == null || "".equals(tel)) {
				tel = "未登録";
			}

			EmployeeDAO e = new EmployeeDAO();

			try {
				int i1 = Integer.parseInt(code);
				int i2 = Integer.parseInt(age);

				e.add(i1, name, i2, tel);

			} catch (DAOException e2) {
				e2.printStackTrace();

			} catch (Exception e3) {

				e3.printStackTrace();
			}
		} else if ("delete".equals(type)) {
			String code = request.getParameter("code");

			EmployeeDAO e = new EmployeeDAO();

			try {
				int i1 = Integer.parseInt(code);
				e.delete(i1);

			} catch (DAOException e2) {
				e2.printStackTrace();

			} catch (Exception e3) {

				e3.printStackTrace();
			}
		} else if ("update".equals(type)) {
			String code = request.getParameter("code");
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			String tel = request.getParameter("tel");

			if (code == null || "".equals(code)) {
				doGet(request, response);
				return;
			}

			if (name == null || "".equals(name)) {
				name = "未登録";
			}

			if (age == null || "".equals(age)) {
				age = "0";
			}

			if (tel == null || "".equals(tel)) {
				tel = "未登録";
			}

			EmployeeDAO e = new EmployeeDAO();

			try {
				int i1 = Integer.parseInt(code);
				int i2 = Integer.parseInt(age);

				e.update(i1, name, i2, tel);

			} catch (DAOException e2) {
				e2.printStackTrace();

			} catch (Exception e3) {

				e3.printStackTrace();
			}
		}

		doGet(request, response);
	}

}
