package test;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.RegBean;

@WebServlet("/dis")
public class DisServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		PreparedStatement ps=null;
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		ServletContext sct=req.getServletContext();
		RegBean rb= (RegBean)sct.getAttribute("beanRef");
		int result;
	
		try {
			Connection con=DBConnection.getCon();
			 ps=con.prepareStatement("INSERT INTO cookiereg VALUES(?,?,?,?,?,?,?)");
			 ps.setString(1, rb.getUserName());
			 ps.setString(2, rb.getPassword());
			 ps.setString(3, rb.getFirstName());
			 ps.setString(4, rb.getLasttName());
			 ps.setString(5, rb.getAddress());
			 ps.setString(6, rb.getPhoneNo());
			 ps.setString(7, rb.getMailId());
			result= ps.executeUpdate();
			 if(result!=0) {
				 pw.println("Registration sucessful");
				 res.setHeader("Refresh", "1; URL=login.html");
			 }
		String sub=req.getParameter("preview");
		if(sub.equals("preview")) {
			pw.println("username"+rb.getUserName()+"<br>");
			pw.println("password"+rb.getPassword()+"<br>");
			
		
		}
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
