package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			EmployeeDAO dao = new EmployeeDAO();
			List<EmployeeBean> list = dao.findAll();
			request.setAttribute("employees", list);
			RequestDispatcher rd = request.getRequestDispatcher("/showItem.jsp");
			rd.forward(request, response);
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("massage", "内部エラーが発生");
			RequestDispatcher rd = request.getRequestDispatcher("/errorItem.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String action = request.getParameter("action");
		if ("add_info".equals(action)) {
			String store = request.getParameter("input_code");
			int code = Integer.parseInt(store);
			String name = request.getParameter("input_name");
			store = request.getParameter("input_age");
			int age = Integer.parseInt(store);
			String tel = request.getParameter("input_tel");
			EmployeeDAO dao = new EmployeeDAO();
			try {
				dao.addEmployee(code, name, age, tel);
			} catch (DAOException e) {
				e.printStackTrace();
			}
		} else if ("delete_info".equals(action)) {
			String store = request.getParameter("input_code");
			int code = Integer.parseInt(store);
			EmployeeDAO dao = new EmployeeDAO();
			try {
				dao.deleteEmployee(code);
			} catch (DAOException e) {
				e.printStackTrace();
			}

		} else if ("update_info".equals(action)) {
			String store = request.getParameter("input_code");
			int code = 0;
			if (!"".equals(store)) {
				code = Integer.parseInt(store);
			}
			String name = request.getParameter("input_name");
			store = request.getParameter("input_age");
			int age = 0;
			if (!"".equals(store)) {
				age = Integer.parseInt(store);
			}
			String tel = request.getParameter("input_tel");
			EmployeeDAO dao = new EmployeeDAO();
			try {
				dao.updateEmployee(code, name, age, tel);
			} catch (DAOException e) {
				e.printStackTrace();
			}

		}
		doGet(request, response);
	}
}
