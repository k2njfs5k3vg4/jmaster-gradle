package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PlusServlet
 */
@WebServlet("/PlusServlet")
public class PlusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String num1 = request.getParameter("value1");
		String num2 = request.getParameter("value2");

		int i1 = Integer.parseInt(num1);
		int i2 = Integer.parseInt(num2);

		int answer = i1 + i2;

		PlusBean bean = new PlusBean(i1, i2, answer);

		request.setAttribute("plus", bean);
		//		request.setAttribute("data1", Integer.valueOf(i1));
		//		request.setAttribute("data2", Integer.valueOf(i2));
		//		request.setAttribute("answer", Integer.valueOf(answer));

		RequestDispatcher rd = request.getRequestDispatcher("/AnswerServlet");
		rd.forward(request, response);
	}

}