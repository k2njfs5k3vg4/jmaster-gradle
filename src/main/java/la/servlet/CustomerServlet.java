package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String tell = request.getParameter("tell");

		if (!"".contentEquals(name)) {
			session.setAttribute("name", name);
		}
		if (!"".contentEquals(address)) {
			session.setAttribute("address", address);
		}
		if (!"".contentEquals(tell)) {
			session.setAttribute("tell", tell);
		}

		out.println("<html><head><title>CustomerServlet</title></head><body>"
				+ "<h1>登録しました</h1><br>");
		out.println("<a href='/jmaster-gradle/CustomerServlet?action=confirm'>情報確認</a><br>");
		out.println("</body></html>");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		String name = (String) session.getAttribute("name");
		String address = (String) session.getAttribute("address");
		String tell = (String) session.getAttribute("tell");
		if (name == null) {
			name = "";
		}
		if (address == null) {
			address = "";
		}
		if (tell == null) {
			tell = "";
		}

		out.println("<html><head><title>CustomerServlet</title></head><body>");
		out.println("名前：" + name + "<br>");
		out.println("住所：" + address + "<br>");
		out.println("電話：" + tell);
		out.println("</body></html>");

	}

}
