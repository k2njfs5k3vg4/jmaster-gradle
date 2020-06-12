package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.PlusBean;

/**
 * Servlet implementation class PlusServlet4
 */
@WebServlet("/PlusServlet4")
public class PlusServlet4 extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		//リクエストパラメータの読み込み
		String num1 = request.getParameter("value1");
		String num2 = request.getParameter("value2");
		if (num1 == null || num1.length() == 0 || num2 == null
				|| num2.length() == 0) {
			//未入力データあり
			showNotEnterdError(out);
			return;
		}

		//足し算の実行
		int answer = 0;
		try {
			int i1 = Integer.parseInt(num1);
			int i2 = Integer.parseInt(num2);
			answer = i1 + i2;

			PlusBean bean = new PlusBean(i1, i2, answer);

			request.setAttribute("plus", bean);

			//フォワード
			RequestDispatcher rd = request.getRequestDispatcher("/answer.jsp");
			rd.forward(request, response);

		} catch (NumberFormatException e) {
			//整数でない
			showNotIntegerError(out);
			return;
		}

		//答えの出力
		/*out.println("<html><head><title>Plus</title></head><body>");
		out.println(num1 + "+" + num2 + "=" + answer);
		out.println("</body></html>");*/
		//doGet(request, response);
	}

	private void showNotIntegerError(PrintWriter out) {
		out.println("<html><head><title>Plus</title></head><body>");
		out.println("<h1>整数ではない値が入力されました</h1>");
		out.println("</body></html>");
	}

	private void showNotEnterdError(PrintWriter out) {
		out.println("<html><head><title>Plus</title></head><body>");
		out.println("<h1>整数を二つ入力してください</h1>");
		out.println("</body></html>");

	}

}
