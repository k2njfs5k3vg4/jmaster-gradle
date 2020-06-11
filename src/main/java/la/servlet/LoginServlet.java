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
	//private static final long serialVersionUID = 1L;
	private static final String[] USER = { "kawamura", "hosodo" };
	private static final String[] PASS = { "himitu", "tumihi" };

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>LoginServlet</title></head><body>");
		out.println("<form action='/jmaster-gradle/LoginServlet' method='post'>");
		out.println("ユーザー名：<input type=\"text\" name = \"name\"<br>");
		out.println("パスワード：<input type=\"password\" name = \"pw\"<br>");
		out.println("<input type=\"hidden\" name = \"action\" value=\"login\"><br>");
		out.println("<input type='submit' value='ログイン'></form><br>");

		//actionリクエスト
		String action = request.getParameter("action");
		if (action != null) {
			if (action.contentEquals("login")) {
				//userとpass取得
				String name = request.getParameter("name");
				String passWord = request.getParameter("pw");

				for (int i = 0; i < USER.length; i++) {
					if (name.contentEquals(USER[i]) && passWord.contentEquals(PASS[i])) {
						//userとpass一致
						HttpSession session = request.getSession();
						//login済み
						session.setAttribute("isLogin", "true");
						session.setAttribute("username", USER[i]);
						//BBSServletへ
						out.println("</body></html>");
						response.sendRedirect("/jmaster-gradle/BBSServlet");

					}
				}
				out.println("<h1>ユーザー名またはパスワードが違います</h1>");
				out.println("</body></html>");

			} else if (action.contentEquals("logout")) {

				//logout
				HttpSession session = request.getSession(false);
				if (session != null) {
					session.invalidate();
					out.println("<html><head><title>Logout</title></head><body>");
					out.println("<h1>ログアウトしました。</h1>");
					out.println("</body></html>");
				}
			}
		} else {
			out.println("</body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
