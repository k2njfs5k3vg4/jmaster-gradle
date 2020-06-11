package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
	ArrayList<String> commentList = new ArrayList<String>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		String newComment = request.getParameter("commentArea");

		if (session == null) {//sessionなし
			out.println("<html><head><title>掲示板</title></head><body>");
			out.println("<h1>ログインしてください。</h1>");
			out.println("<a href ='/jmaster-gradle/LoginServlet'>ログイン画面へ</a>");
			out.println("</body></html>");
			return;
		} else {
			String isLogin = (String) session.getAttribute("isLogin");
			if (isLogin == null || !isLogin.contentEquals("true")) {
				out.println("<html><head><title>掲示板</title></head><body>");
				out.println("<h1>ログインしてください。</h1><br>");
				out.println("<a href ='/jmaster-gradle/LoginServlet'>ログイン画面へ</a>");
				out.println("</body></html>");
				return;
			}
		}

		String userName = (String) session.getAttribute("username");

		//@SuppressWarnings("unchecked")
		//ArrayList<String> commentList = (ArrayList<String>) session.getAttribute("commentList");

		out.println("<html><head><title>掲示板</title></head><body>");
		out.println("<form action='/jmaster-gradle/BBSServlet' method='post'>");
		out.println("メッセージ：<br>");
		out.println("<textarea name='commentArea' rows='4' cols='40'></textarea><br>");
		out.println("<input type='submit' value='書き込み'></form>");
		out.println("<a href='/jmaster-gradle/LoginServlet?action=logout'>ログアウト</a><br>");

		//		if (commentList == null) {
		//			commentList = new ArrayList<String>();
		//			session.setAttribute("commentList", commentList);
		//		}
		if (newComment != null) {
			if (newComment.length() != 0) {
				commentList.add(userName + "：" + newComment);
			}
		}

		if (commentList != null) {
			for (String comment : commentList) {
				out.println(comment + "<br>");
				out.println("<hr>");
			}
		}

		out.println("</body></html>");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
