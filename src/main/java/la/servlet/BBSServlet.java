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
	List<String> list = new ArrayList<String>();
	String u;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String user = request.getParameter("USER");
		String pass = request.getParameter("PASS");
		String s = request.getParameter("message");

		u = user;

		out.println("<html><head><meta charset = 'utf-8'><title>掲示板</title></head><body>");

		if ("jack".equals(user) && "abc".equals(pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogin", "true");
		} else {
			out.println("<h1>ユーザ名またはパスワードが違います</h1>");
		}

		HttpSession session = request.getSession(false);
		if (session == null) {
			out.println("<h1>ログインしてください</h1>");
			out.println("<d>メッセージ：</d><br>");
			out.println("<form action='/jmaster-gradle/BBSServlet' method='get'>");
			out.println("<input type = 'text' name='USER'>");
			out.println("<input type = 'text' name='PASS'>");
			out.println("<input type = 'submit' value='ログイン'></form>");
			out.println("</body></html>");
			return;
		} else {
			String isLogin = (String) session.getAttribute("isLogin");
			if (isLogin == null || !isLogin.equals("true")) {
				out.println("<h1>tes</h1>");
				out.println("<d>メッセージ：</d><br>");
				out.println("<form action='/jmaster-gradle/BBSServlet' method='get'>");
				out.println("<input type = 'text' name='USER'>");
				out.println("<input type = 'text' name='PASS'>");
				out.println("<input type = 'submit' value='ログイン'></form>");
				out.println("</body></html>");
				return;
			}
		}

		if ("logout".equals(s)) {
			session.setAttribute("isLogin", "false");
		}

		//		@SuppressWarnings("unchecked")
		//		List<String> arlist = (ArrayList<String>) session.getAttribute("message");
		//		if (arlist == null) {
		//			arlist = new ArrayList<String>();
		//			session.setAttribute("message", arlist);
		//		}
		//		arlist.add(s);

		list.add(s);

		out.println("<d>メッセージ：</d><br>");
		out.println("<form action='/jmaster-gradle/BBSServlet' method='get'>");
		out.println("<textarea name='message'>入力してください</textarea><br>");
		out.println("<input type = 'submit' value='書き込み'></form>");
		//		out.println("<input type='button' value='メッセージを一つ消す' onclick='list.remove(0)'>");

		for (String date : list) {
			if (date == null) {
			} else {
				if (date.equals("hello")) {
					out.println("<hr align='left' width='100%'>");
					out.println("<font color='red'>" + date + "(by " + u + ")" + "</font><br>");
				} else if (date.equals("delete")) {
					DeleteMessage();
					out.println("<hr align='left' width='100%'>");
					out.println("<font color='red'>" + date + "(by " + u + ")" + "</font><br>");
				} else {
					out.println("<hr align='left' width='100%'>");
					out.println("<d>" + date + "(by " + u + ")" + "</d><br>");
				}
			}
		}
		out.println("</body></html>");
		return;
	}

	public void DeleteMessage() {
		System.out.println("aaaa");
		list.remove(list.size() - 1);
	}

}