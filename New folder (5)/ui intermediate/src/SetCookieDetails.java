

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieDetails
 */
public class SetCookieDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
//set cookies
	      String login=request.getParameter("uname");
	      String password=request.getParameter("password");
	      Cookie c1=new Cookie("login", login);
	      Cookie c2=new Cookie("password", password);
	      c1.setMaxAge(10); 
	     
	      c1.setPath("/");
	      c2.setMaxAge(10); 
	      c2.setPath("/");
	      response.addCookie(c1);
	      response.addCookie(c2);
	      response.setContentType("text/html"); 
	      out.println("<html><body> Cookie successfully set"+c1+"</body></html>");
	}

}
