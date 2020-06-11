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
	List<String> bbs = new ArrayList<String>();

	private static final String USER = "kameda";
	private static final String PASS = "abc";

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
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html><head><title>BBS</title></head><body>");

		out.println("<form action='/jmaster-gradle/BBSServlet' method='post'>");
		out.println("ユーザー名:<input type = 'text' name = 'name'><br>");
		out.println("パスワード:<input type = 'password' name = 'pw'><br>");
		out.println("<input type='hidden' name='action' value='login'>");
		out.println("<input type='submit' value='ログイン'></form>");
		out.println("<a href='/jmaster-gradle/BBSServlet?action=logout'>ログアウト</a>");

		out.println("<h3>メッセージ</h3>");

		out.println("<form action='/jmaster-gradle/BBSServlet' method='post'>");
		out.println("<textarea name='value' rows='4' cols='40'>");
		out.println("</textarea><br>");
		out.println("<input type='submit' value='書き込み'></form>");

		out.println("</body></html>");

		////

		String action = request.getParameter("action");
		String name = request.getParameter("name");
		String passWord = request.getParameter("pw");
		if (action.equals("login")) {

			if (name.equals(USER) && passWord.equals(PASS)) {
				HttpSession session = request.getSession();
				session.setAttribute("isLogin", "true");
				out.println("<html><head><title>Login</title></head><body>");
				out.println("<h3>ログイン成功</h3>");
				out.println("</body></html>");
				return;
			} else {
				out.println("<html><head><title>Login</title></head><body>");
				out.println("<h3>ログイン失敗</h3>");
				out.println("</body></html>");
				return;
			}
		} else if (action.equals("logout")) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
				out.println("<html><head><title>Login</title></head><body>");
				out.println("<h3>ログアウト</h3>");
				out.println("</body></html>");
				return;
			}
		}
		//

		HttpSession session = request.getSession(false);
		if (session == null) {
			out.println("<html><head><title>Login</title></head><body>");
			out.println("<h3>ログインしてください1</h3>");
			out.println("</body></html>");
			return;
		} else {
			String isLogin = (String) session.getAttribute("isLogin");
			if (isLogin == null || !isLogin.equals("true")) {
				out.println("<html><head><title>Login</title></head><body>");
				out.println("<h3>ログインしてください2</h3>");
				out.println("</body></html>");
				return;
			}
		}

		request.setCharacterEncoding("UTF-8");

		//		HttpSession session = request.getSession();
		//		@SuppressWarnings("unchecked")

		//		ArrayList<String> bbs = (ArrayList<String>) session.getAttribute("message");

		String message = request.getParameter("value");
		if (message == null || message.length() == 0) {
			showNoData(out);
			//			return;
		}

		if (bbs == null) {
			bbs = new ArrayList<String>();
			//					session.setAttribute("message", bbs);
		}
		//				out.println("<h3>" + session.getId() + "</h3>");
		bbs.add(message);

		out.println("<html><head><title>BBS</title></head><body>");
		out.println("<h3>メッセージ</h3>");

		out.println("<form action='/jmaster-gradle/BBSServlet' method='post'>");
		out.println("<textarea name='value' rows='4' cols='40'>");
		out.println("</textarea><br>");
		out.println("<input type='submit' value='書き込み'></form>");

		for (String data : bbs) {
			//			if (data.equals("Hello")) {
			//				out.println("<h3><font color=\"purple\">" + data + "</font></h3>");
			//			} else if (data.length() == 3) {
			//				out.println("<h3><font color=\"blue\">" + data + "</font></h3>");
			//			} else {
			out.println("<h3>" + name + ":" + data + "<h3>");
			//			out.println("<h3>" + data + "</h3>");
			//			}
		}
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		//		response.setContentType("text/html;charset=UTF-8");
		//		PrintWriter out = response.getWriter();
		//
		//		request.setCharacterEncoding("UTF-8");
		//
		//		//		HttpSession session = request.getSession();
		//		//		@SuppressWarnings("unchecked")
		//
		//		//		ArrayList<String> bbs = (ArrayList<String>) session.getAttribute("message");
		//
		//		String message = request.getParameter("value");
		//		if (message == null || message.length() == 0) {
		//			showNoData(out);
		//			//			return;
		//		}
		//
		//		if (bbs == null) {
		//			bbs = new ArrayList<String>();
		//			//					session.setAttribute("message", bbs);
		//		}
		//		//				out.println("<h3>" + session.getId() + "</h3>");
		//		bbs.add(message);
		//
		//		out.println("<html><head><title>BBS</title></head><body>");
		//		out.println("<h3>メッセージ</h3>");
		//
		//		out.println("<form action='/jmaster-gradle/BBSServlet' method='post'>");
		//		out.println("<textarea name='value' rows='4' cols='40'>");
		//		out.println("</textarea><br>");
		//		out.println("<input type='submit' value='書き込み'></form>");
		//
		//		for (String data : bbs) {
		//			//			if (data.equals("Hello")) {
		//			//				out.println("<h3><font color=\"purple\">" + data + "</font></h3>");
		//			//			} else if (data.length() == 3) {
		//			//				out.println("<h3><font color=\"blue\">" + data + "</font></h3>");
		//			//			} else {
		//			out.println("<h3>" + name + ":" + data + "<h3>");
		//			//			out.println("<h3>" + data + "</h3>");
		//			//			}
		//		}
		//		out.println("</body></html>");
	}

	private void showNoData(PrintWriter out) {
		// TODO 自動生成されたメソッド・スタブ
		out.println("<html><head><title>showNoData</title></head><body>");
		out.println("<h1><font color=\"red\">入力してください</font></h1>");
		out.println("</body></html>");
	}

}