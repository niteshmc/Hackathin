
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDemo
 */
public class SessionDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String heading;
		Integer accessCount = new Integer(0);
		if (session.isNew()) {
			heading = "Welcome, New user";
		} else {
			heading = "Welcome Back";
			Integer oldAccessCount = (Integer) session
					.getAttribute("accessCount");
			if (oldAccessCount != null) {
				accessCount = new Integer(oldAccessCount.intValue() + 1);
			}
		}
		session.setAttribute("accessCount", accessCount);
		String name = request.getParameter("uname");
		String password = request.getParameter("password");
		session.setAttribute("uname",name);
		out.println("<BODY>" + "<H1 ALIGN=\"CENTER\">" +
				heading + "</H1>\n");
		if( name!= null || name.length() >0  ){
		out.println( "Hello user " + name );
		}
		request.getRequestDispatcher("index.html").
		forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
