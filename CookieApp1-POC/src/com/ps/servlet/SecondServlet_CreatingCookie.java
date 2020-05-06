package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet_CreatingCookie extends HttpServlet {
	       
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		Cookie cookies[]=null;
		
		//get PrintWriter object
		pw=res.getWriter();
		//set Content type
		res.setContentType("text/html");
		cookies=req.getCookies();
		//display cookies
		
		if(cookies!=null) {
			pw.println("<b>Displaying cookies</b>");
			pw.println("<table border='1' bgcolor='green'>");
			pw.println("<tr><th>Cookie name</th><th>Cookie value</th></tr>");
			for(Cookie ck:cookies) {
				pw.println("<tr><td>"+ck.getName()+"</td><td>"+ck.getValue()+"</td></tr>");				
			}
			pw.println("</table>");
		}
		else
			pw.println("<b>No cookies present</b>");
		
		//close stream
			pw.close();
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
