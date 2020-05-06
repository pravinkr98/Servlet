package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		String name = null, tage = null;
		int age = 0;
		List<String> lst = new ArrayList<String>();
		// get PrintWriter
		pw = res.getWriter();
		// set response content Type
		res.setContentType("text/html");
		// read form data from the form comps of form page
		name = req.getParameter("pname");
		tage = req.getParameter("page");
		// Server Form validation logic
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
		if (lst.isEmpty()) {
			if (age >= 18) {
				pw.println("<h1><font color='green'>" + name + " u r elgible to vote</font></h1>");
			} else {
				pw.println("<h1><font color='red'>" + name + " u r not elgible to vote</font></h1>");
			}
		} else {
			for (String lst1 : lst) {
				pw.println("<br>" + lst1);
			}
		}

		// add hyperlink
		pw.println("<br><br><a href='input.html'>home</a>");
		// close stream
		pw.close();
	}

}
