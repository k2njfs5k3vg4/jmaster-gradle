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
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		request.getSession();

		out.println("<html><head><title>Customer</title></head><body>");
		out.println("<form action=\"/jmaster-gradle/CustomerServlet\" method=\"post\">");

		out.println("名前:<input type=\"text\" name=\"name\" ><br>");
		out.println("住所:<input type=\"text\" name=\"address\" ><br>");
		out.println("電話:<input type=\"text\" name=\"tel\" ><br>");
		out.println("<input type=\"submit\" value=\"登録\"><br>");

		out.println("</form>");
		out.println("<a href=\"/jmaster-gradle/ComfirmServlet\">情報確認</a>");

		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");

		HttpSession session = request.getSession();

		if (name != null && !"".equals(name)) {
			session.setAttribute("name", name);
		}
		if (address != null && !"".equals(address)) {
			session.setAttribute("address", address);
		}
		if (tel != null && !"".equals(tel)) {
			session.setAttribute("tel", tel);
		}

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Customer</title></head><body>");

		out.println("<h1>登録しました!</h1>");
		out.println("<a href=\"/jmaster-gradle/ComfirmServlet\">情報確認</a>");

		out.println("</body></html>");
	}

}
