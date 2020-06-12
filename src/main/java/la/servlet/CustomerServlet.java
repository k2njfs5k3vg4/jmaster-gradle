package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");

		if (username.equals("") || address.equals("") || tel.equals("")) {
			out.println("<html><head><meta charset = 'utf-8'><title>情報確認</title></head><body>");
			out.println("名前、住所、電話番号のいずれかに入力漏れがあります");
			out.println("<br><a href='/jmaster-gradle/customer.html'>情報登録画面に戻る</a>");
			out.println("</body></html>");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("uname", username);
			session.setAttribute("uaddress", address);
			session.setAttribute("utel", tel);
			out.println("<html><head><meta charset = 'utf-8'><title>登録完了</title></head><body>");
			out.println("登録しました！");
			out.println("<br><a href='/jmaster-gradle/customer.html'>情報登録画面に戻る</a>");
			out.println("</body></html>");
		}
	}

}
