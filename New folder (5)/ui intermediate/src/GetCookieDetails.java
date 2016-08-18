

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookieDetails
 */
public class GetCookieDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<HTML><HEAD><TITLE>");
	        out.println("Getting cookies");
	        out.println("</TITLE></HEAD><BODY>");
	        out.println(" Cookie Name\t" + "Cookie Value" + "<p>");
	        Cookie[] cs = request.getCookies();
	        if (cs == null) {
	            out.println("No cookies");
	        } else {
	            Cookie cookie;
	            for (int i = 0; i < cs.length; i++) {
	                cookie = cs[i];
	                out.println("<p>" + cookie.getName() + "\t" + cookie.getValue());
	            }         }
	        out.println("</BODY></HTML>");
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	}

}
