package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/fourthurl")
public class FourthServlet extends HttpServlet {
	      
    
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd=null;
		PrintWriter pw=null;
		HttpSession ses=null;
		ServletContext sc=null;
		
		//get PrintWriter
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		
		//read and display request attribute values
		pw.println("<br><b>(FourthServlet) req attribute(attr1) value :: "+req.getAttribute("attr1")+"</b>");
		
		pw.println();
		//get session
		ses=req.getSession();
		pw.println("<br><b>(FourthServlet) session attribute(username) value :: "+(String)ses.getAttribute("username")+"</b>");
		pw.println("<br><b>(FourthServlet) session attribute(password) value :: "+(String)ses.getAttribute("password")+"</b>");
		
		pw.println();
		//get Access to ServletContext object
		sc=getServletContext();
		pw.println("<br><b>(FourthServlet) ServletContext attribute(reqCount) value :: "+(Integer)sc.getAttribute("reqCount")+"</b>");
				
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
