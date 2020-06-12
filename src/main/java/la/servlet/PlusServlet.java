package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PlusServlet")
public class PlusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String num1 = request.getParameter("value1");
		String num2 = request.getParameter("value2");

		if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
			showNotEnterdError(out);
			return;
		}

		int answer = 0;
		try {
			int i1 = Integer.parseInt(num1);
			int i2 = Integer.parseInt(num2);
			answer = i1 + i2;

			//Beanにまとめる
			PlusBean bean = new PlusBean(i1, i2, answer);

			//			request.setAttribute("data1", Integer.valueOf(i1));
			//			request.setAttribute("data2", Integer.valueOf(i2));
			request.setAttribute("plus", bean);

			RequestDispatcher rd = request.getRequestDispatcher("/AnswerServlet2");
			rd.forward(request, response);

		} catch (NumberFormatException e) {
			showNotIntegerError(out);
			return;
		}

		//		out.println("<html><head><title>Plus</title></head><body>");
		//		out.println(num1 + "+" + num2 + "=" + answer);
		//		out.println("</body></html>");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	private void showNotEnterdError(PrintWriter out) {
		out.println("<html><head><title>Plus</title></head><body>");
		out.println("<h1>整数を2つ入力してください</h1>");
		out.println("</body></html>");

	}

	private void showNotIntegerError(PrintWriter out) {
		out.println("<html><head><title>Plus</title></head><body>");
		out.println("<h1>整数じゃないよ</h1>");
		out.println("</body></html>");
	}

}
