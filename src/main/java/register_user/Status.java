package register_user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Status")
public class Status extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pt = response.getWriter();
		String n = request.getParameter("name");
		String p  = request.getParameter("pass"); 
		String cnt = request.getParameter("num"); 
		String s = request.getParameter("status");
		//pt.print("Welcome "+n);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/touron","root","divya");
			PreparedStatement ps=con.prepareStatement("update data set username=?,contact=?,status=? where password=?");
			ps.setString(1, n);
			ps.setString(2, cnt);
			ps.setString(3, s);
			ps.setString(4, p);
			ps.executeUpdate();
			
			RequestDispatcher rd=request.getRequestDispatcher("last.html");
			rd.include(request, response);
			
			con.close();
			
		} catch (ClassNotFoundException | SQLException e1) {
			
			e1.printStackTrace();
		}
		
		
	}

}
