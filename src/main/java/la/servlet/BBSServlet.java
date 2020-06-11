package la.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BBSServlet
 */
@WebServlet("/BBSServlet")
public class BBSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<String> bbs = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BBSServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html><head><title>BBS</title></head><body>");
		out.println("<h3>メッセージ</h3>");

		out.println("<form action='/jmaster-gradle/BBSServlet' method='post'>");
		out.println("<textarea name='value' rows='4' cols='40'>");
		out.println("</textarea><br>");
		out.println("<input type='submit' value='書き込み'></form>");

		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		doGet(request, response);

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")

		ArrayList<String> bbs = (ArrayList<String>) session.getAttribute("message");

		String message = request.getParameter("value");
		if (message == null || message.length() == 0) {
			showNoData(out);
			//			return;
		}

		if (bbs == null) {
			bbs = new ArrayList<String>();
			session.setAttribute("message", bbs);
		}

		bbs.add(message);

		out.println("<html><head><title>BBS</title></head><body>");
		out.println("<h3>メッセージ</h3>");

		out.println("<form action='/jmaster-gradle/BBSServlet' method='post'>");
		out.println("<textarea name='value' rows='4' cols='40'>");
		out.println("</textarea><br>");
		out.println("<input type='submit' value='書き込み'></form>");

		for (String data : bbs) {
			if (data.equals("Hello")) {
				out.println("<h3><font color=\"purple\">" + data + "</font></h3>");
			} else if (data.length() == 3) {
				out.println("<h3><font color=\"blue\">" + data + "</font></h3>");
			} else {
				out.println("<h3>" + data + "</h3>");
			}
		}
		out.println("</body></html>");
	}

	private void showNoData(PrintWriter out) {
		// TODO 自動生成されたメソッド・スタブ
		out.println("<html><head><title>showNoData</title></head><body>");
		out.println("<h1><font color=\"red\">入力してください</font></h1>");
		out.println("</body></html>");
	}

}