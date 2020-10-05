package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import test.RegBean;

@WebServlet("/reg2")
public class RegServlet2 extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8726063695712918343L;

	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		ServletContext sct=req.getServletContext();
		RegBean rb=(RegBean)sct.getAttribute("beanRef");
		String fName=req.getParameter("firstname");
		rb.setFirstName(fName);
		String lName=req.getParameter("lastname");
		rb.setLastName(lName);
		String addr=req.getParameter("address");
		rb.setAddress(addr);
		RequestDispatcher rd=req.getRequestDispatcher("Register3.html");
		rd.forward(req, res);
		
		
	}

}
