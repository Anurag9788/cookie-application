package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import test.RegBean;

@WebServlet("/reg3")
public class RegServlet3 extends HttpServlet{
@Override
public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	ServletContext sct=req.getServletContext();
	RegBean rb=(RegBean)sct.getAttribute("beanRef");
	String phNo=req.getParameter("phno");
	rb.setPhoneNo(phNo);
	String mId=req.getParameter("mailid");
	rb.setMailId(mId);
	RequestDispatcher rd=req.getRequestDispatcher("final.html");
	rd.forward(req, res);
	
	
}
}
