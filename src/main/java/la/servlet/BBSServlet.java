package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	private List<String> commentList = new ArrayList<String>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		String newComment = request.getParameter("commentArea");

		out.println("<html><head><title>掲示板</title>"
				+ "<style>.size{font-size:150%}</style></head><body>");
		out.println("<form action='/jmaster-gradle/BBSServlet' method='post'>");
		out.println("メッセージ：<br>");
		out.println("<textarea name='commentArea' rows='4' cols='40'></textarea><br>");
		out.println("<input type='submit' value='書き込み'></form><br>");

		if (newComment != null) {
			if (newComment.length() != 0) {
				commentList.add(request.getParameter("commentArea"));
			}
			for (String comment : commentList) {
				Matcher m = Pattern.compile("はじめまして.*").matcher(comment);
				if (m.find()) {
					out.println("<span class='size'>" + comment + "</span><br>");
					out.println("<hr>");
					//				if (comment.contentEquals(h)) {
					//					out.println("<span class='size'>" + comment + "</span><br>");
					//					out.println("<hr>");
				} else {
					out.println(comment + "<br>");
					out.println("<hr>");
				}
			}
		}

		out.println("</body></html>");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
