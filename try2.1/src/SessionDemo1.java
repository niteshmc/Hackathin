

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDemo
 */

public class SessionDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection c;
	HttpSession session;
	String prevId=null;
	public void init(ServletConfig config )throws ServletException
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		     c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","password");
		     
			System.out.println("success");
		}
		catch(ClassNotFoundException er)
		{
			System.out.println("Class not found");
		}
		catch(SQLException sqq)
		{
			
		}
	}


	
	
	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String id = request.getParameter("uname");
		/*if(prevId == null ){
			prevId= id;
		}*/
		session.setAttribute("prevuname",prevId);
		session.setAttribute("uname",id);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String heading;
		/*Integer accessCount = new Integer(0);
		session.setAttribute("accessCount", accessCount);
		if (session.isNew()) {
			heading = "Welcome, New user";
			System.out.println(heading);
		} else {
			heading = "Welcome Back";
			
			Integer oldAccessCount = (Integer) session.getAttribute("accessCount");
			
			
			if (oldAccessCount != null) {
				accessCount = new Integer(oldAccessCount.intValue() + 1);
				session.invalidate();
			}
		}*/
		//session.setAttribute("accessCount", accessCount);
		
		String password = request.getParameter("password");
		int name=Integer.parseInt(id);
		   String pass=null;
	
		try{
		 Statement stmt=c.createStatement();
		 String query = "SELECT password from customerinfo where cust_id = "+name;
		 System.out.println(query);
	      ResultSet rs = stmt.executeQuery(query);
	      
	
	      while(rs.next()){
	    	  System.out.println(query);
	        // int id = rs.getInt("cust_i");
	        pass = rs.getString("password");
	        
	      }
	         if(pass.equals(password))
	        	 
	         {
	
	        	System.out.println("equals");
		request.getRequestDispatcher("jspServletConn.jsp").
		include(request,response);
	         }
	         else
	         {
	        	
	        	 out.println("Invalid credentials");
	        	 request.getRequestDispatcher("Login.html").
	     		include(request,response);
	         }
	        //prevId= id;
	         //session.setAttribute("prevuname",prevId);
	      rs.close();
	      stmt.close();
	      }
	      
	      catch(SQLException sq)
	      {
	    	  
	      }
	      
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	 public void destroy() {
		    session.invalidate();
		  }
	
}
