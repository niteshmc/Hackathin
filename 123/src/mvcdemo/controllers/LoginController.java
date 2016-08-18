package mvcdemo.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







import com.sun.javafx.collections.MappingChange.Map;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static LinkedHashMap<String, String> map= new LinkedHashMap<String,String>();
	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String message1 = request.getParameter("msg");
		
		RequestDispatcher rd = null;
		
			map.put(message1,"java");
			rd = request.getRequestDispatcher("/jspServletConn.jsp");
			request.setAttribute("map", map );
			rd.forward(request, response);
	}

}