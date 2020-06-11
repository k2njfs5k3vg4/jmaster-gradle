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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String USER = "jack";
	private static final String PASS = "abc";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		//		actionリクエストのパラメータ読み込み
		String action = request.getParameter("action");
		if (action.equals("login")) {
			String name = request.getParameter("name");
			String passWord = request.getParameter("pw");

			if (name.equals(USER) && passWord.equals(PASS)) {
				HttpSession session = request.getSession();
				session.setAttribute("isLogin", true);
				session.setAttribute("username", name);

				out.println("<html><head><meta charset = 'utf-8'><title>掲示板</title></head><body>");
				out.println("<d>メッセージ：</d><br>");
				out.println("</body></html>");
				response.sendRedirect("/jmaster-gradle/BBSServclet?username");
			} else {
				out.println("<html><head><meta charset = 'utf-8'><title>掲示板</title></head><body>");
				out.println("<h1>ユーザ名またはパスワードが違います</h1>");
				out.println("</body></html>");
			}
		} else if (action.equals("logout")) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
				out.println("<html><head><meta charset = 'utf-8'><title>掲示板</title></head><body>");
				out.println("<h1>ログアウトしました</h1>");
				out.println("</body></html>");
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset = 'utf-8'><title>掲示板</title></head><body>");
		out.println("<h1>ログインできていません</h1>");
		out.println("</body></html>");
	}
}
