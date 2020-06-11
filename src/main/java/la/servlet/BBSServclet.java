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

/**
 * Servlet implementation class BBSServclet
 */
@WebServlet("/BBSServclet")
public class BBSServclet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<String> list = new ArrayList<String>();
	List<String> store = new ArrayList<String>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String s = request.getParameter("message");
		list.add(s);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset = 'utf-8'><title>掲示板</title></head><body>");
		out.println("<d>メッセージ：</d><br>");
		out.println("<form action='/jmaster-gradle/BBSServclet' method='get'>");
		out.println("<textarea name='message'>入力してください</textarea><br>");
		out.println("<input type = 'submit' value='書き込み'></form>");
		out.println("<form action='/jmaster-gradle/BBSServclet' method='post'>");
		out.println("<input type = 'submit' value='削除'></form>");

		for (String date : list) {
			if (date == null) {
			} else {
				if (date.equals("hello")) {
					out.println("<hr align='left' width='100%'>");
					out.println("<font color='red'>" + date + "</font><br>");
				} else {
					out.println("<hr align='left' width='100%'>");
					out.println("<d>" + date + "</d><br>");
				}

			}
		}
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("list（変更前）" + list);
		int size = list.size() - 2;
		if (size >= 0) {
			store.clear();
			for (String date : list) {
				if (date != null) {
					store.add(date);
				}
			}
			store.remove(size);
			list.clear();

			for (String date2 : store) {
				if (date2 != null) {
					list.add(date2);
				}
			}

			System.out.println("list（変更後）" + list);
			System.out.println("store" + store);
			System.out.println(size);
		} else {
			store.clear();
			list.clear();
		}
		this.doGet(request, response);
	}

}
