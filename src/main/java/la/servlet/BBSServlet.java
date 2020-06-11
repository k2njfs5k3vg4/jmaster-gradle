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

/**
 * Servlet implementation class BBSServlet
 */
@WebServlet("/BBSServlet")
public class BBSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//	private List<String> list = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BBSServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html><head><title>BBS</title></head><body>");

		out.println("メッセージ:<form action=\"/jmaster-gradle/BBSServlet\" method=\"post\">");

		out.println("<textarea name=\"message\" rows=\"4\" cols=\"40\"></textarea>");
		out.println("<br>");
		out.println("<input type=\"submit\" value=\"書き込み\">");
		out.println("<input type=\"reset\" value=\"リセット\">");

		out.println("</form>");

		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<String> list = (ArrayList<String>) session.getAttribute("list");

		for (String string : list) {

			out.println("<hr>");
			out.println(string);

		}

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

		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<String> list = (ArrayList<String>) session.getAttribute("list");

		if (list == null) {
			list = new ArrayList<String>();
			session.setAttribute("list", list);
		}

		if (message == null || message.length() == 0) {
		} else {
			list.add(message);
		}

		doGet(request, response);
	}

}