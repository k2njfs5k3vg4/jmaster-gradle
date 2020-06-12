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
 * Servlet implementation class InformationServlet
 */
@WebServlet("/InformationServlet")
public class InformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("uname");
		String address = (String) session.getAttribute("uaddress");
		String tel = (String) session.getAttribute("utel");

		try {
			if (username.equals("") || address.equals("") || tel.equals("")) {
				out.println("<html><head><meta charset = 'utf-8'><title>情報確認</title></head><body>");
				out.println("名前、住所、電話番号を入力してください");
				out.println("<br><a href='/jmaster-gradle/customer.html'>情報登録画面に戻る</a>");
				out.println("</body></html>");
			} else {
				out.println("<html><head><meta charset = 'utf-8'><title>情報確認</title></head><body>");
				out.println(username + "<br>");
				out.println(address + "<br>");
				out.println(tel + "<br>");
				out.println("<br><a href='/jmaster-gradle/customer.html'>情報登録画面に戻る</a>");
				out.println("</body></html>");
			}
		} catch (NullPointerException e) {
			out.println("<html><head><meta charset = 'utf-8'><title>情報確認</title></head><body>");
			out.println("名前、住所、電話番号を入力してください");
			out.println("<br><a href='/jmaster-gradle/customer.html'>情報登録画面に戻る</a>");
			out.println("</body></html>");
		}
	}
}
