package test;


import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import  javax.servlet.http.*;
import test.RegBean;

@WebServlet("/reg1")
public class RegServlet1 extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		RegBean rb=new RegBean();
		ServletContext sct=req.getServletContext();
		sct.setAttribute("beanRef", rb);
		String uName=req.getParameter("username");
		rb.setUserName(uName);
		String pWord=req.getParameter("password");
		rb.setPassword(pWord);
		RequestDispatcher rd=req.getRequestDispatcher("Register2.html");
		rd.forward(req,res);
		 
	}
	
	
}
