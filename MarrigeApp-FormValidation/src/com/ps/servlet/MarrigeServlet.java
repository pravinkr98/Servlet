package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
		String name=null,tage=null,gender=null,vstatus=null;
		int age=0;
		List<String> lst = new ArrayList<String>();
		name=req.getParameter("pname");
		tage=req.getParameter("page");
		gender=req.getParameter("gender");
		vstatus=req.getParameter("vflag");
		//age=Integer.parseInt(tage);
		pw=res.getWriter();
		res.setContentType("text/html");
		
		// Server Form validation logic
		if(vstatus.equals("no"))
		{
				if (name.equals("") || name == null || name.length() == 0)// required rule
				{
					lst.add("Person name is mandatory");// pw.println("<font color=red>Person name is mandatory</font>");
					// return;
				}
				if (tage.equals("") || tage == null || tage.length() == 0)// required rule
				{
					lst.add("Person age is mandatory");// pw.println("<font color=red>Person age is mandatory</font>");
					// return;
				}
				// to check wheather age is numeric value or not
				else {

					try {
						// convert given age value to numeric value
						age = Integer.parseInt(tage);
						if (age <= 0 || age >= 125) {
							lst.add("Person age must be within 1 through 125");// pw.println("<font color=red>Person age must be
																				// within 1 through 125</font>");
							// return;
						}
					} catch (NumberFormatException nfe) {
						lst.add("Age must be numeric value");// pw.println("<font color=red>Age must be numeric value</font>");
						// return;
					}
				}
		}//if
		else {
			// convert given age value to numeric value
			age = Integer.parseInt(tage);
		}

		if (lst.isEmpty())
		{
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
		}
		else
		{
			for (String lst1 : lst) {
				pw.println("<br>" + lst1);
			}
		}
		

		pw.println("<br><a href='input.html'><img src='home.png'></a>");

	}
}
