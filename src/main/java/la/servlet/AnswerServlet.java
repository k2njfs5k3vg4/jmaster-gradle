package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.PlusBean;

/**
 * Servlet implementation class AnswerServlet
 */
@WebServlet("/AnswerServlet")
public class AnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnswerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		//		Integer num1 = (Integer) request.getAttribute("data1");
		//		Integer num2 = (Integer) request.getAttribute("data2");
		//		Integer answer = (Integer) request.getAttribute("answer");

		PlusBean bean = (PlusBean) request.getAttribute("plus");

		out.println("<html><head><title>Plus</title></answer><body>");
		//		out.println(num1 + "+" + num2 + "=" + answer);
		out.println(bean.getValue1() + "+" + bean.getValue2() + "=" + bean.getAnswer());
		out.println("</body></html>");
	}

}
