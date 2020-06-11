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
 * Servlet implementation class ConfirmServlet
 */
@WebServlet("/ComfirmServlet")
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);

		if (session == null) {
			//			response.sendRedirect("/jmaster-gradle/CustomerServlet");
			out.println("<html><head><title>Confirm</title></head><body>");
			out.println("<h1>名前、住所、電話番号を登録してください</h1>");
			out.println("</body></html>");
			return;
		}

		String name = (String) session.getAttribute("name");
		String address = (String) session.getAttribute("address");
		String tel = (String) session.getAttribute("tel");

		out.println("<html><head><title>Confirm</title></head><body>");

		out.println("名前:" + name + "<br>");
		out.println("住所:" + address + "<br>");
		out.println("電話:" + tel + "<br>");

		out.println("<a href=\"/jmaster-gradle/CustomerServlet\">登録画面へ</a>");

		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
