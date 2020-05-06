package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String comp=null;
		int val1=0,val2=0;
		//get PrintWriter
		pw=res.getWriter();
		//set Content type
		res.setContentType("text/html");
		comp=req.getParameter("s1");
		//write logic
		if(comp.equals("link1")) {
			pw.println("Date and Time"+new java.util.Date());			
		}
		else if(comp.equals("link2")) {
			pw.println("System properties"+System.getProperties());
		}
		else if(comp.equals("add")) {
			//read form data
			val1=Integer.parseInt(req.getParameter("t1"));
			val2=Integer.parseInt(req.getParameter("t2"));
			pw.println("Addition :: "+(val1+val2));
		}
		else if(comp.equals("sub")) {
			//read form data
			val1=Integer.parseInt(req.getParameter("t1"));
			val2=Integer.parseInt(req.getParameter("t2"));
			pw.println("Subtraction :: "+(val1-val2));
		}
		else if(comp.equals("mul")) {
			//read form data
			val1=Integer.parseInt(req.getParameter("t1"));
			val2=Integer.parseInt(req.getParameter("t2"));
			pw.println("Multiplication :: "+(val1*val2));
		}
		else{
			//read form data
			val1=Integer.parseInt(req.getParameter("t1"));
			val2=Integer.parseInt(req.getParameter("t2"));
			pw.println("Division :: "+(val1/val2));
		}
		//add hyperlink
		pw.println("<a href='form.html'>Home</a>");
		//close stream
		pw.close();
	}
}
