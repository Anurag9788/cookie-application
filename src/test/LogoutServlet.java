package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -884307008620264553L;

	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		Cookie ck1=new Cookie("name","");
		ck1.setMaxAge(0);
		response.addCookie(ck1);
		Cookie ck2=new Cookie("pass","");
		ck2.setMaxAge(0);
		response.addCookie(ck2);
		out.print("<br> you are sucessfully logged out");
	}
	

}
