package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final String[] USERS = new String[] { "kima himitu", "nakagawa Himitu" };
	//	private static final String[] PASS = new String[] { "himitu" };

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String action = request.getParameter("action");
		if (action.equals("login")) {
			String name = request.getParameter("name");
			String password = request.getParameter("pw");
			String check = name + " " + password;

			if (Arrays.asList(USERS).contains(check)) {
				HttpSession session = request.getSession();
				session.setAttribute("name", name);
				response.sendRedirect("/jmaster-gradle/BBSServlet");
			} else {
				out.println("<html><head><title>Error</title></head><body>");
				out.println("Error");
				out.println("<br><a href=\"/jmaster-gradle/login.html\">ログインページへ</a>");
				out.println("</body></html>");
			}
		} else if (action.equals("logout")) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
				out.println("<html><head><title>logout</title></head><body>");
				out.println("ログアウトしました");
				out.println("<br><a href=\"/jmaster-gradle/login.html\">ログインページへ</a>");
				out.println("</body></html>");
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
