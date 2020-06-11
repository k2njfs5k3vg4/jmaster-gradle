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
 * Servlet implementation class HInfoServlet
 */
@WebServlet("/HInfoServlet")
public class HInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		out.println("<html><head><title>info</title></head><body>");

		String name = (String) session.getAttribute("name");
		String adr = (String) session.getAttribute("address");
		String tel = (String) session.getAttribute("tel");

		if (name != null && adr != null && tel != null && name != "" && adr != "" && tel != "") {
			out.println("名前：" + name);
			out.println("住所：" + adr);
			out.println("電話：" + tel);
		} else {
			out.println("<h1>名前、住所、電話番号をすべて登録してください</h1>");
		}

		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
