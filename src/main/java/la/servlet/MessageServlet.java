package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		String message = request.getParameter("message");
		String mozi = request.getParameter("mozi");

		switch (mozi) {
		case "big":
			out.println("<html><head><meta charset='UTF-8'><title>メッセージ出力</title></head>");
			out.println("<body><h1>" + message + "</h1></body>");
			System.out.println(message);
			break;
		case "middle":
			out.println("<html><head><meta charset='UTF-8'><title>メッセージ出力</title></head>");
			out.println("<body><h2>" + message + "</h2></body>");
			break;
		case "small":
			out.println("<html><head><meta charset='UTF-8'><title>メッセージ出力</title></head>");
			out.println("<body><h3>" + message + "</h3></body>");
			break;
		default:
			break;
		}

	}

}
