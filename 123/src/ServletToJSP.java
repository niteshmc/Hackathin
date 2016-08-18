import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletToJSP extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("welcome>>>>>>>>>>>>>>>>>>>.");
		//communicating a simple String message.
		String message = "Example source code of Servlet to JSP communication.";
		request.setAttribute("message", message);


		//Servlet JSP communication
		RequestDispatcher reqDispatcher = getServletConfig().
				getServletContext().getRequestDispatcher("/jspServletConn.jsp");
		reqDispatcher.forward(request,response);
	}
}