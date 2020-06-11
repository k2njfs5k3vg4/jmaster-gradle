package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BBSServlet")
public class BBSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<String> list = new ArrayList<String>();

	@SuppressWarnings("unused")
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//		doPost(request, response);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);
		//		String name = (String) session.getAttribute("name");

		if (session == null) {
			out.println("<html><head><title>BBS</title></head><body>");
			out.println("ログインしてください<br><a href=\"/jmaster-gradle/login.html\">ログインページへ</a>");
			out.println("</body></html>");
			return;
		}

		out.println("<html><head><title>BBS</title></head><body>");

		out.println("メッセージ:<form action=\"/jmaster-gradle/BBSServlet\" method=\"post\">");

		out.println("<textarea name=\"message\" rows=\"4\" cols=\"40\"></textarea>");
		out.println("<br>");
		out.println("<input type=\"submit\" value=\"書き込み\">");
		out.println("<input type=\"reset\" value=\"リセット\">");

		out.println("</form>");

		//		@SuppressWarnings("unchecked")
		//		List<String> list = (ArrayList<String>) session.getAttribute("list");

		for (String string : list) {

			out.println("<hr>");
			out.println(string);

		}

		out.println("<br><a href=\"/jmaster-gradle/LoginServlet?action=logout\">ログアウト</a>");
		out.println("</body></html>");
		out.println("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String message = request.getParameter("message");

		//		HttpSession session = request.getSession(false);
		//		@SuppressWarnings("unchecked")
		//		this.list = (ArrayList<String>) session.getAttribute("list");

		//		if (list == null) {
		//			list = new ArrayList<String>();
		//			session.setAttribute("list", list);
		//		}
		HttpSession session = request.getSession(false);
		String name = (String) session.getAttribute("name");

		if (message == null || message.length() == 0) {
		} else {
			list.add(name + " : " + message);
		}

		doGet(request, response);
	}

}