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
 * Servlet implementation class HCostmerServlet
 */
@WebServlet("/HCostmerServlet")
public class HCostmerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		//request.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		//String action = request.getParameter("action");

		//if (action != null)
		out.println("<html><head><title>info</title></head><body>");

		if (request.getParameter("name") != null && request.getParameter("name") != "") {
			session.setAttribute("name", request.getParameter("name"));
			if (request.getParameter("address") != null && request.getParameter("address") != "") {
				session.setAttribute("address", request.getParameter("address"));
				if (request.getParameter("tel") != null && request.getParameter("tel") != "") {
					session.setAttribute("tel", request.getParameter("tel"));
					out.println("<h1>登録しました！</h1>");
				}
			}
		} else {
			out.println("<h1>名前、住所、電話番号をすべて入力してください</h1>");
		}
		/*String s1 = (String) session.getAttribute("name");
		String s2 = (String) session.getAttribute("address");
		String s3 = (String) session.getAttribute("tel");
		if (action != null) {
			if (s1 != null && s2 != null && s3 != null && s1 != "" && s2 != "" && s3 != "") {
				out.println("名前：" + s1);
				out.println("住所：" + s2);
				out.println("電話：" + s3);
			} else {
				out.println("<h1>名前、住所、電話番号を登録してください</h1>");
			}
		}
		
		if (action != null)*/
		out.println("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		/*HttpSession session = request.getSession(false);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if (action == null)
			doGet(request, response);
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>info</title></head><body>");
		
		String s1 = (String) session.getAttribute("name");
		String s2 = (String) session.getAttribute("address");
		String s3 = (String) session.getAttribute("tel");
		if (action != null) {
			if (s1 != null && s2 != null && s3 != null) {
				out.println("名前：" + s1);
				out.println("住所：" + s2);
				out.println("電話：" + s3);
			} else {
				out.println("<h1>名前、住所、電話番号を登録してください</h1>");
			}
		}*/
	}

}
