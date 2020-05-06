package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarrigeServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarrigeServlet.doGet()");
		PrintWriter pw=null;
		String name=null,tage=null,gender=null;
		int age=0;
		name=req.getParameter("pname");
		tage=req.getParameter("page");
		gender=req.getParameter("gender");
		age=Integer.parseInt(tage);
		pw=res.getWriter();
		res.setContentType("text/html");

		if(gender.equals("male")){
			if(age<21)
				pw.println("<h2 style='color:red;text-align'>Mr. "+name+" you are not eligible for Marrige</h2>");
			else
				pw.println("<h2 style='color:green;text-align'>Mr. "+name+" you are eligible for Marrige</h2>");
		}
		else{
			if(age<18)
			pw.println("<h2 style='color:red;text-align'>Miss "+name+" you are not eligible for Marrige</h2>");
		else
			pw.println("<h2 style='color:green;text-align'>Miss "+name+" you are eligible for Marrige</h2>");
		}

		pw.println("<br><a href='input.html'><img src='home.png'></a>");

	}
}
