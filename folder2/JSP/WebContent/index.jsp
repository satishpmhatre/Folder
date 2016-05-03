<%@ page language="java" import="java.sql.*"%>
<html>
<head>
<title> Films Example: JSP, Postgres version</title>
</head>
<body bgcolor="white">
<%
       try { 
	   
 	    Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection ("jdbc:postgresql://localhost:5433/postgres","postgres", "123");
        conn.setAutoCommit(false);
		
       System.out.println("Opened database successfully");
	
	               Statement stmt = conn.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT * FROM employee");
	    out.println( "<table border=1>" );
            while ( rs.next() ) {
                int title = rs.getInt("OFFICEID");
                String director = rs.getString("NAME");
                int origin = rs.getInt("AGE");
                String made = rs.getString("ADDRESS");
                float length = rs.getFloat("SALARY");
                out.println("<tr><td>"+title+"</td><td>"+director+"</td><td>"+origin+"</td><td>"+
			made+"</td><td>"+length+"</td></tr>" );
            }
	    out.println( "</table>" );

            conn.close();
        } catch (Exception e) {
            out.println( "<h1>exception: "+e+e.getMessage()+"</h1>" );
        }
%>
</body>
</html>