package test;
import java.sql.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ProfileServlet")

public class ProfileServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1735272394287612176L;

	@Override
	protected void doGet ( HttpServletRequest request,HttpServletResponse response ) throws ServletException,IOException {
		response.setContentType("text/hml");
			PrintWriter out=response.getWriter();
			request.getRequestDispatcher("link.html").include(request,response);
			Cookie ck[]=request.getCookies();
			if(ck!=null) {
				String name=ck[0].getValue();
				String pass=ck[1].getValue();
			
			if(!name.equals("")||name!=null)
			{
				out.print("<b>welcome </b>"+name);
				
				
			
			try {
				Connection con=DBConnection.getCon();
				PreparedStatement ps=con.prepareStatement("select * from cookiereg");
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					out.println("<br>First name:"+rs.getString(3));
					out.println("<br>lastname : "+rs.getString(4));
					
				}
			
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			}
			}
			else {
				out.println("login first");
				request.getRequestDispatcher("login.html").include(request,response);
			}
			out.close();
				
			}
			
			
			
	}


