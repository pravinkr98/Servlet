package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String name=null,gender=null,addres=null,ms=null,qlfy=null,course=null,furl=null,email=null,fweek=null,fcolor=null,fmonth=null,hobby=null,dob=null;
		int age=0,salary=0;
		long phone=0;
		//get PrintWriter
		PrintWriter pw = null;
		pw=res.getWriter();
		//set response content
		res.setContentType("text/html");
		//read form data
		name=req.getParameter("tname");
		age=Integer.parseInt(req.getParameter("tage"));
		gender=req.getParameter("gen");
		phone=Long.parseLong(req.getParameter("phone"));
		addres=req.getParameter("addrs");
		ms=req.getParameter("ms");
		dob=req.getParameter("dob");
		fweek=req.getParameter("fweek");
		fcolor=req.getParameter("fcolor");
		salary=Integer.parseInt(req.getParameter("sal"));
		fmonth=req.getParameter("fmonth");
		qlfy=Arrays.toString(req.getParameterValues("qlfy"));
		course=Arrays.toString(req.getParameterValues("crs"));
		hobby=Arrays.toString(req.getParameterValues("hb"));
		furl=req.getParameter("furl");
		email=req.getParameter("emailid");
		
		//write request processing logic
		if(gender.equalsIgnoreCase("M"))
		{
			if(age<=5)
				pw.println("<b>Master "+name+" u r baby boy.</b>");
			else if(age<=12)
				pw.println("<b>Master "+name+" u r small boy.</b>");
			else if(age<=19)
				pw.println("<b>Master/Mr. "+name+" u r teenage boy.</b>");
			else if(age<=35)
				pw.println("<b>Mr. "+name+" u r young man.</b>");
			else if(age<=50)
				pw.println("<b>Mr. "+name+" u r middle aged man.</b>");
			else
				pw.println("<b>Mr. "+name+" u r Budda.</b>");			
		}//if
		else
		{
			if(age<=5)
				pw.println("<b>Master "+name+" u r baby girl.</b>");
			else if(age<=12)
				pw.println("<b>Master "+name+" u r small girl.</b>");
			else if(age<=19)
				if(ms.equals("married"))
					pw.println("<b>Mrs. "+name+" u r teenage woman.</b>");
				else
					pw.println("<b>Miss "+name+" u r teenage girl.</b>");
			else if(age<=35)
				if(ms.equals("married"))
					pw.println("<b>Mrs. "+name+" u r young woman.</b>");
				else
					pw.println("<b>Miss "+name+" u r young woman.</b>");
			else if(age<=50)
				if(ms.equals("married"))
					pw.println("<b>Mrs. "+name+" u r middle aged woman.</b>");
				else
					pw.println("<b>Miss "+name+" u r middle aged woman.</b>");
			else
				if(ms.equals("married"))
					pw.println("<b>Mrs. "+name+" u r old woman.</b>");
				else
					pw.println("<b>Miss "+name+" u r old woman.</b>");
		}
		
		//display all details
		pw.println("<br><br><b>Name\t:: "+name+"</b>");
		pw.println("<br><b>Age\t:: "+age+"</b>");
		pw.println("<br><b>Gender\t:: "+gender+"</b>");
		pw.println("<br><b>Address\t:: "+addres+"</b>");
		pw.println("<br><b>Contact\t:: "+phone+"</b>");
		pw.println("<br><b>Marital Status\t:: "+ms+"</b>");
		pw.println("<br><b>Salary\t:: "+salary+"</b>");
		pw.println("<br><b>Date of Birth\t:: "+dob+"</b>");
		pw.println("<br><b>Qualification\t:: "+qlfy+"</b>");
		pw.println("<br><b>Course\t:: "+course+"</b>");
		pw.println("<br><b>Hobbies\t:: "+hobby+"</b>");
		pw.println("<br><b>Faviorite Color\t:: "+fcolor+"</b>");
		pw.println("<br><b>Faviorite Week\t:: "+fweek+"</b>");
		pw.println("<br><b>Faviorite Month\t:: "+fmonth+"</b>");
		pw.println("<br><b>Facabook Url\t:: "+furl+"</b>");
		pw.println("<br><b>Email id\t:: "+email+"</b>");
		
		//set home link
		pw.println("<br><a href='form.html'>home</a>");
	}

}
