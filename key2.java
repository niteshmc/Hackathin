
  
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class keyextraction
 */
public class key2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Connection con;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public key2() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");// TO LOAD DRIVER
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","password");//
			
		}
		catch(ClassNotFoundException er1)
		{
				System.out.println("Class not found exception in contest pgm:"+er1.getMessage());
				
				
		}
		catch(Exception er)
		{
			System.out.println("any problem"+ er.getMessage());
			
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
				
				HttpSession session=request.getSession(true);
				
		        Integer id= (Integer)session.getAttribute("");
		        
		        java.io.PrintWriter out=response.getWriter();
		        int flag=0;
			    String input = request.getParameter("string");
			    
			    String output;

				int bal =0;
				int bill =0;
				String date = null;
				int a =0;
				long num=0;
				String promo=null ;
				String plan=null ;
				String acc =null;
				String pdt=null;
				String service=null ;
			    
			    while(input!=null){
			    	
			    	try{
			    	String query="select * from customerinfo where cust_id= "+id;
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					while(rs.next()){
						
						 bal=rs.getInt("balance");
						bill=rs.getInt("bill");
						date=rs.getString("due_date");
						a =rs.getInt(" prev_recharge");
						num =rs.getLong("call_history");
						promo = rs.getString("promotions");
						plan = rs.getString("plans");
						acc = rs.getString("linkedacc");
						pdt = rs.getString("products");
						service = rs.getString("services");
												
					
					
					}

					rs.close();
					st.close();
			    	
			    	} catch(SQLException e){
						e.printStackTrace();
						
					}  	
			    	
			    	
			    	
			    
				Pattern p = Pattern.compile("(balance|remaining|Balance|amount|bill|Bill)");
				Matcher m = p.matcher(input);
			   if(m.find()){
				
						if(service.equals("prepaid")){
							out.println("the balance is "+bill+" and the duedate is"+date);
							output = "the balance is "+bill+" and the duedate is"+date;
							flag++;
						}
						else{
							out.println("the bill is "+bal+" and the duedate is"+date);
							flag++;
							output="the bill is "+bal+" and the duedate is"+date;
						}
						
						}
						
						
					
			   
				
			   
			    
			   Pattern p1 = Pattern.compile("(promotions|Promotions|Offers|plans|offers|free|discount)");
				Matcher m1 = p1.matcher(input);
			   if(m1.find()){
				
					out.println("you are using "+plan+" plan, hence you are eligible for"+ service+ " promotion");
							flag++;
						output = "you are using "+plan+" plan, hence you are eligible for"+ service+ " promotion";
						
			   
			   }
				  
						
					
				 
			   
				
				
			   Pattern p2 = Pattern.compile("(date|due|due date|last|day)");
				Matcher m2 = p2.matcher(input);
			   if(m2.find()){
				   
				
						out.println("the Due date is "+ date);
						output = "the Due date is "+ date;
						flag++;
					}
			   
				
			   
			   Pattern p3 = Pattern.compile("(previous|recharge|transaction|top|up)");
				Matcher m3 = p3.matcher(input);
			   if(m3.find()){
				   
				   
						out.println("the previous recharge amount is RS."+ a);
						output = "the previous recharge amount is RS."+ a;
						flag++;
					}
			   
					
			   
			   Pattern p4 = Pattern.compile("(call|history|last call|contact|call log)");
				Matcher m4 = p4.matcher(input);
			   if(m4.find()){
				  
						out.println("the last call was made to "+ num);
						output = "the last call was made to "+ num;
						flag++;
					}
			   
					
			   
			   
			   Pattern p5 = Pattern.compile("(link|linked|accounts|account|merged|multiple)");
				Matcher m5 = p5.matcher(input);
			   if(m5.find()){
				
						out.println("This Account is linked to a "+ acc);
						output = "This Account is linked to a "+ acc;
						flag++;
					}
			   
					
				   //plan
				   Pattern p6 = Pattern.compile("(plan|pack|current|data|voice)");
					Matcher m6 = p6.matcher(input);
				   if(m6.find()){
					 
							out.println("Your current plan is "+ plan);
							output = "Your current plan is "+ plan;
							flag++;
						}
				   
						
					
				   //pdt
				   Pattern p7 = Pattern.compile("(use|eligible|using|product|products)");
					Matcher m7 = p7.matcher(input);
				   if(m7.find()){
					  
							out.println("The products you are eligible for are "+ pdt);
							output = "The products you are eligible for are "+ pdt;
							flag++;
						}
				   
			    //services
				   Pattern p8 = Pattern.compile("(service|services|prepaid|postpaid)");
					Matcher m8 = p8.matcher(input);
				   if(m8.find()){
					 
							out.println("The service you are using is "+service);
							output = "The service you are using is "+service;
							flag++;
						}
				   
						
				   
				   
				   if(flag ==0){
					   
					out.println("NOT found");
				output = "Sorry, please be more specific. We will forward this question to our customer care and they will resolve it";
							
				 
				   }
			   }
			   }
	}
				
		
	


