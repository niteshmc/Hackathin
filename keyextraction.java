

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
public class keyextraction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Connection con;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public keyextraction() {
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
		        List<String> ques = new ArrayList<String>();
		        String key=null;
		        Integer id= (Integer)session.getAttribute("");
		        java.io.PrintWriter out=response.getWriter();
		        int flag=0;
			    String input = request.getParameter("string");
			    
			    String output;
			    
			    while(input!=null){
			    
				Pattern p = Pattern.compile("(balance|remaining|Balance|amount|bill|Bill)");
				Matcher m = p.matcher(input);
			   if(m.find()){
				   try{
					   out.println("found");

					String query="select bill,balance,due_date,services from customerinfo where cust_id= "+id;
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					while(rs.next()){
						int bal=rs.getInt("balance");
						int bill=rs.getInt("bill");
						String date=rs.getString("due_date");
						String services=rs.getString("services");
						if(services.equals("prepaid")){
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
						
						
					
			   
					rs.close();
					st.close();
			   }
				   catch(SQLException e){
						e.printStackTrace();
						
					}}
					
					
				
			   
			    
			   Pattern p1 = Pattern.compile("(promotions|Promotions|Offers|plans|offers|free|discount)");
				Matcher m1 = p1.matcher(input);
			   if(m1.find()){
				  try{ 
				out.println("found");
					
					String query1="select promotions,plans from customerinfo where cust_id= "+id;
					Statement st1=con.createStatement();
					ResultSet rs1=st1.executeQuery(query1);
					while(rs1.next()){
						String plan =rs1.getString("plans");
						String services=rs1.getString("promotions");
							out.println("you are using "+plan+" plan, hence you are eligible for"+ services+ " promotion");
							flag++;
						output = "you are using "+plan+" plan, hence you are eligible for"+ services+ " promotion";
						flag++;
							
						}
					
			   
					rs1.close();
					st1.close();
			   }
				  catch(SQLException e){
						e.printStackTrace();
						
				  }
			   }
					
						
					
				 
			   
				
				
			   Pattern p2 = Pattern.compile("(date|due|due date|last|day)");
				Matcher m2 = p2.matcher(input);
			   if(m2.find()){
				   try{
				out.println("found");
					
					String query="select due_date from customerinfo where cust_id= "+id;
					Statement st2=con.createStatement();
					ResultSet rs2=st2.executeQuery(query);
					while(rs2.next()){
						String date =rs2.getString("due_date");
						out.println("the Due date is "+ date);
						output = "the Due date is "+ date;
						flag++;
					}
			   
					rs2.close();
					st2.close();
			   }catch(SQLException e){
					e.printStackTrace();
					
			  }}
			   
			   
			   Pattern p3 = Pattern.compile("(previous|recharge|transaction|top|up)");
				Matcher m3 = p3.matcher(input);
			   if(m3.find()){
				   
				   try{
				out.println("found");
					
					String query="select prev_recharge from customerinfo where cust_id= "+id;
					Statement st3=con.createStatement();
					ResultSet rs3=st3.executeQuery(query);
					while(rs3.next()){
						int a =rs3.getInt("prev_recharge");
						out.println("the previous recharge amount is RS."+ a);
						output = "the previous recharge amount is RS."+ a;
						flag++;
					}
			   
					rs3.close();
					st3.close();}
					catch(SQLException e){
						e.printStackTrace();
						
				  }}
				   
			   
			   Pattern p4 = Pattern.compile("(call|history|last call|contact|call log)");
				Matcher m4 = p4.matcher(input);
			   if(m4.find()){
				   try{
				out.println("found");
					
					String query="select call_history from customerinfo where cust_id= "+id;
					Statement st4=con.createStatement();
					ResultSet rs4=st4.executeQuery(query);
					while(rs4.next()){
						long num =rs4.getInt("call_history");
						out.println("the last call was made to "+ num);
						output = "the last call was made to "+ num;
						flag++;
					}
			   
					rs4.close();
					st4.close();
			   }catch(SQLException e){
					e.printStackTrace();
					
			  }}
			   
			   
			   Pattern p5 = Pattern.compile("(link|linked|accounts|account|merged|multiple)");
				Matcher m5 = p5.matcher(input);
			   if(m5.find()){
				   try{
				out.println("found");
					
					String query="select linkedacc from customerinfo where cust_id= "+id;
					Statement st5=con.createStatement();
					ResultSet rs5=st5.executeQuery(query);
					while(rs5.next()){
						String acc =rs5.getString("linkedacc");
						out.println("This Account is linked to a "+ acc);
						output = "This Account is linked to a "+ acc;
						flag++;
					}
			   
					rs5.close();
					st5.close();
			   }catch(SQLException e){
					e.printStackTrace();
					
			  }}
				   //plan
				   Pattern p6 = Pattern.compile("(plan|pack|current|data|voice)");
					Matcher m6 = p6.matcher(input);
				   if(m6.find()){
					   try{
					out.println("found");
						
						String query="select plans from customerinfo where cust_id= "+id;
						Statement st4=con.createStatement();
						ResultSet rs4=st4.executeQuery(query);
						while(rs4.next()){
							String plan =rs4.getString("plans");
							out.println("Your current plan is "+ plan);
							output = "Your current plan is "+ plan;
							flag++;
						}
				   
						rs4.close();
						st4.close();
				   }catch(SQLException e){
						e.printStackTrace();
						
				  }}
					
				   //pdt
				   Pattern p7 = Pattern.compile("(use|eligible|using|product|products)");
					Matcher m7 = p7.matcher(input);
				   if(m7.find()){
					   try{
					out.println("found");
						
						String query="select call_history from customerinfo where cust_id= "+id;
						Statement st4=con.createStatement();
						ResultSet rs4=st4.executeQuery(query);
						while(rs4.next()){
							String pdt =rs4.getString("products");
							out.println("The products you are eligible for are "+ pdt);
							output = "The products you are eligible for are "+ pdt;
							flag++;
						}
				   
						rs4.close();
						st4.close();
				   }catch(SQLException e){
						e.printStackTrace();
						
				  }}	
			    //services
				   Pattern p8 = Pattern.compile("(service|services|prepaid|postpaid)");
					Matcher m8 = p8.matcher(input);
				   if(m8.find()){
					   try{
					out.println("found");
						
						String query="select services from customerinfo where cust_id= "+id;
						Statement st4=con.createStatement();
						ResultSet rs4=st4.executeQuery(query);
						while(rs4.next()){
							String service =rs4.getString("services");
							out.println("The service you are using is "+service);
							output = "The service you are using is "+service;
							flag++;
						}
				   
						rs4.close();
						st4.close();
				   }catch(SQLException e){
						e.printStackTrace();
						
				  }
					   
				   
				   }
				   if(flag ==0){
					   
					out.println("NOT found");
				output = "Sorry, please be more specific. We will forward this question to our customer care and they will resolve it";
							
				 
			    
			   }
			   }
	}}
			    
				
		
	


