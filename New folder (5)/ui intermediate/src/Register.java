
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");	
		getServletContext().setAttribute("successAttr", "Fetching using Attribute");
		if( (fname!=null && fname.trim().length()!=0) && 
			(lname!=null && lname.trim().length()!=0)){	
				request.getRequestDispatcher("Success").
								forward(request,response);//goes to success and print there 
		}
		else{
				request.setAttribute("error",
					"first name or last name not entered");
				getServletContext().
				getNamedDispatcher("Error").
					include(request,response);//goes to error and comes back to register.java
				request.getRequestDispatcher(
						"Register.html").
							include(request,response); //goes to register.html and comes back to display fnam nd lname
						//displays all what ever is in register.java
			
				}
	}
}
