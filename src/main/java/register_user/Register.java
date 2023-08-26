package register_user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter pt=response.getWriter();
		String n=request.getParameter("user");
		String p=request.getParameter("pass");
		String num=request.getParameter("num");
		String sta=null ;
		pt.print("Welcome "+n);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/touron","root","divya");
			PreparedStatement ps=con.prepareStatement("insert into data values(?,?,?,?)");
			ps.setString(1, n);
			ps.setString(2, p);
		    ps.setString(3, num);
		    ps.setString(4, sta);
		    ps.executeUpdate();
			con.close();
			RequestDispatcher rd=request.getRequestDispatcher("selection.html");
			rd.include(request, response);
			
		} catch (ClassNotFoundException | SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
	}

}
