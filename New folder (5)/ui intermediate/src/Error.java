

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Error
 */
public class Error extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><head><title>login </title>");
		out.println("<head><body><font color=red><b>");

		String err=(String)request.getAttribute("error");
		if(err!=null)
				out.println(err);
		out.println("</font><b><br></body></html>");

	}

}
