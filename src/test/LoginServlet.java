package test;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2810597074861795423L;

	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException ,IOException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		request.getRequestDispatcher("link.html").include(request,response);
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from cookiereg where uname=? and pword=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				out.print("you are sucessfully logged in");
				out.print("<br> welcome  "+name);
				Cookie ck1=new Cookie("name",name);
				response.addCookie(ck1);
				Cookie ck2=new Cookie("pass",password);
				response.addCookie(ck2);
				
			}
			else
			{
				out.print("sorry ,username or password error");
				request.getRequestDispatcher("login.html").include(request,response);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

}
