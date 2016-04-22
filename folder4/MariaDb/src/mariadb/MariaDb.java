package mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MariaDb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Connection c = null;
	      Statement stmt = null;
	      try
	      {
	    	  Class.forName("org.mariadb.jdbc.Driver");
	          c = DriverManager.getConnection("jdbc:mariadb://localhost:33067/test", "root", "123");
	          c.setAutoCommit(false);
	          System.out.println("Opened database successfully");

	          stmt = c.createStatement();          
	         
	          String select= "SELECT * FROM employee;";
	         		 
	          ResultSet rs = stmt.executeQuery(select);
	          
	          while(rs.next())
	          {
	         	 int id=rs.getInt("eid");
	         	 String name=rs.getString("ename");
	         	 String address=rs.getString("address");
	         		         	 
	         	 System.out.println("Office id="+id);
	         	 System.out.println("Name="+name);
	         	 System.out.println("Address="+address+"\n");
	         	 	        	 
	         	       	 
	          }
	          
	          rs.close();
	          stmt.close();        
	          
	          
	          c.commit();
	          
	          c.close();
	       } catch (Exception e) {
	          System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	          System.exit(0);
	       }
	       System.out.println("Records Displayed successfully");
	    }
	 }