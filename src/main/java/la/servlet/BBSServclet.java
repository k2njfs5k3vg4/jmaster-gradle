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
 * Servlet implementation class BBSServclet
 */
@WebServlet("/BBSServclet")
public class BBSServclet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<String> list = new ArrayList<String>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("username");
		//ここから掲示板コンテンツ
		String s = request.getParameter("message");
		list.add(s);
		out.println("<html><head><meta charset = 'utf-8'><title>掲示板</title></head><body>");
		out.println("<d>メッセージ：</d><br>");
		out.println("<form action='/jmaster-gradle/BBSServclet' method='get'>");
		out.println("<textarea name='message'>入力してください</textarea><br>");
		out.println("<input type = 'submit' value='書き込み'></form>");

		out.println("<form action='/jmaster-gradle/LoginServlet' method='post'>");
		out.println("<input type='hidden' name='action' value='logout'><br>");
		out.println("<input type = 'submit' value='ログアウト'></form>");

		for (String data : list) {
			if (data == null) {
			} else {
				if (data.equals("hello")) {
					out.println("<hr align='left' width='100%'>");
					out.println(name + "：<font color='red'>" + data + "</font><br>");
				} else if (data.length() == 3) {
					out.println("<hr align='left' width='100%'>");
					out.println(name + "：<font color='blue'>" + data + "</font><br>");
				} else {
					out.println("<hr align='left' width='100%'>");
					out.println(name + "：<d>" + data + "</d><br>");
				}

			}
		}
		out.println("</body></html>");
	}
}
