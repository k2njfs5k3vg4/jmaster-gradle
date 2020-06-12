package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnswerServlet
 */
@WebServlet("/AnswerServlet")
public class AnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String answer = request.getParameter("answer");
		PrintWriter out = response.getWriter();
		//		request.setCharacterEncoding("UTF-8");

		switch (answer) {
		case "1":
			out.println("<html><head><meta charset='UTF-8'><title>クイズの結果</title></head>");
			out.println("<body><h1>不正解！</h1></body></html>");
			break;
		case "2":
			out.println("<html><head><meta charset='UTF-8'><title>クイズの結果</title></head>");
			out.println("<body><h1>正解！</h1></body></html>");
			//			System.out.println("aaa");
			break;
		case "3":
			out.println("<html><head><meta charset='UTF-8'><title>クイズの結果</title></head>");
			out.println("<body><h1>不正解！</h1></body></html>");
			break;
		default:
			break;
		}
	}

}
