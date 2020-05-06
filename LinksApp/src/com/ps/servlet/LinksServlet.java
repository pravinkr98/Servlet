package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String link=null;
		Locale locales[]=null;
		//get Printwriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read "l1" request param value to know the hyperlink that is clicked
		link=req.getParameter("l1");
		if(link.equalsIgnoreCase("link1")) //all languages
		{
			locales=Locale.getAvailableLocales();
			pw.println("<h1 style='color:blue'>All Languages are ::</h1>");
			for(Locale lc : locales) {
				pw.println(lc.getDisplayLanguage()+"<br>");
			}
		}//if
		else if(link.equalsIgnoreCase("link2"))
		{
			locales=Locale.getAvailableLocales();
			pw.println("<h1 style='color:green'>All Countries are ::</h1>");
			for(Locale lc : locales) {
				pw.println(lc.getDisplayCountry()+"<br>");
			}
		}//else if
		else
		{
			pw.println("<h1 style='color:orange;text-align:center'>Date and Time :: "+new java.util.Date());
		}
		//add hyperlink
		pw.println("<br><a href='links.html'>Home</a>");
	}//doGet
}//class
