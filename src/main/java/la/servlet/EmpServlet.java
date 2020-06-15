package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.EmpBean;
import la.dao.DAOException;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			EmpDAO dao = new EmpDAO();
			List<EmpBean> list = dao.findAll();
			request.setAttribute("Emp", list);
			RequestDispatcher rd = request.getRequestDispatcher("/showEmp.jsp");
			rd.forward(request, response);
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラー");
			RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
