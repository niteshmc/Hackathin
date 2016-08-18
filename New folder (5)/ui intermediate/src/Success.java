

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class Success extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Success() {
        super();
        
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    String successAttr= (String)getServletContext()
		    		.getAttribute("successAttr");
		    System.out.println(successAttr);
		    
		    out.println("<html><head><title>Success</title>");
		    out.println("<head><body>");
		    out.println("Thanks <I> 	"+
		    		request.getParameter("fname")+"</I><br>" );
		    out.println("Learning Attr <I> 	"+
		    		successAttr+ "<br>");
		    
		    out.println("</body></html>");	 
	}

}
