

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ExpireSession
 */
public class ExpireSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		Integer oldAccessCount = (Integer) session
				.getAttribute("accessCount");
		if (oldAccessCount != null) {
			session.invalidate();
		}
		response.setContentType("text/html");
		out.println("ur session is expired" +"<br>");
		out.println("<a href=http://localhost:8080/servletslearing14/Login.html>ReStart Session</a>");
		out.close();
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
