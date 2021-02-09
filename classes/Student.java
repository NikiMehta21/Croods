import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Student extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String dob=request.getParameter("dob");
		String country=request.getParameter("country");
		
		try{
		// loading jdbc drivers for mysql using library in lib folder
            Class.forName("com.mysql.jdbc.Driver");
            
            // connection wi8 database 
            Connection con = DriverManager.getConnection
                        ("jdbc:mysql:/ /localhost:3306/stude","root","");

            //INserting data to db Stud 
		PreparedStatement ps=con.prepareStatement("insert into stud values(?,?,?,?)");
		ps.setString(1,name);
		ps.setString(2,phone);
		ps.setString(3,dob);
		ps.setString(4,country);
		
		int i=ps.executeUpdate();
		if(i>0)
		out.print("You are successfully registered...");
		
			
		}catch (Exception e2) {System.out.println(e2);}
		
		out.close();
	}

}
