package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BBSServlet
 */
@WebServlet("/BBSServlet")
public class BBSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<String> list = new ArrayList<String>();

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>BBSServlet</title></head><meta charset=\"UTF-8\"><body>");
		out.println("メッセージ：<br>");

		out.println("<form action=\"/jmaster-gradle/BBSServlet\" method=\"post\">");
		out.println("<textarea name=\"message\" rows=\"4\" cols=\"40\"></textarea><br>");
		out.println("<input type=\"submit\" value=\"書き込み\"><br>");
		request.setCharacterEncoding("UTF-8");

		if (request.getParameter("message") != null) {
			list.add(request.getParameter("message"));
		}
		for (String li : list) {
			out.println("<hr>" + li);
		}
		out.println("<hr></body></html>");

	}

}
