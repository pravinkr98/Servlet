package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	   
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,fname=null,gender=null;
		HttpSession ses=null;
		long ms=0L;
		Date d=null;
		boolean b=false;
		
		//get PrintWriter
		pw=res.getWriter();
		//set Content Type
		res.setContentType("text/html");
		//get request parameter value
		name=req.getParameter("pname");
		fname=req.getParameter("fname");
		gender=req.getParameter("gender");
		
		//create HttpSession and add form1/req1 data
		ses=req.getSession(true);
		ses.setAttribute("pname", name);
		ses.setAttribute("fname", fname);
		ses.setAttribute("gender", gender);
		
		//HttpSession actions
		ms=ses.getLastAccessedTime(); //To know when the session obj is lastly accessed
		d=new Date(ms);
		
		b=ses.isNew(); //To know wheather session is new or old
				
		//create dynamic form2
		pw.println("<form action='"+res.encodeURL("secondurl")+"' method='POST'>");
		//pw.println("<form action='secondurl' method='POST'>");
		pw.println("<table align='center' border='0' bgcolor='green'>");
		pw.println("<tr><td>Income ::</td><td><input type='text' name='income'></td></tr>");
		pw.println("<tr><td>Tax ::</td><td><input type='text' name='tax'></td></tr>");
		pw.println("<tr><td><input type='submit' value='Submit'></td><td><input type='reset' value='Cancel'></td></tr>");
		pw.println("</table></form>");
		pw.println("<br><br><b>HttpSession id::: </b>"+ses.getId());		
		pw.println("<br><br><b>Last access time::: </b>"+d);
		pw.println("<br><br><b>Session is new ?::: </b>"+b);	
		
		//set idle timeout
		ses.setMaxInactiveInterval(1500);
				
		//close stream
		pw.close();
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
