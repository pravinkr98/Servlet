package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet_CreatingCookie extends HttpServlet {
	       
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		Cookie ck1=null,ck2=null,ck3=null,ck4=null;
		//get PrintWriter object
		pw=res.getWriter();
		//set Content type
		res.setContentType("text/html");		
		//crate cookie (InMemory Cookies)
		ck1=new Cookie("ap","hyd");
		ck2=new Cookie("mh","Mumbai");
		res.addCookie(ck1);res.addCookie(ck2);
		//create Cookie (Persistent Cookies)
		ck3=new Cookie("ts","Hyderebad");
		ck4=new Cookie("mp","Indore");
		ck3.setMaxAge(120);ck4.setMaxAge(60);
		res.addCookie(ck3);res.addCookie(ck4);
		
		
		pw.println("<b>Cookies created and added response ........</b>");
		
		
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
