package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String sch=null;
		String engine=null;
		String url=null;
		//get printwriter object
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		sch=req.getParameter("ss");
		engine=req.getParameter("engine");
		//prepara url based on the selected search engine
		if(engine.equalsIgnoreCase("google"))
			url="https://www.google.com/search?q="+sch;
		else if(engine.equalsIgnoreCase("bing"))
			url="https://www.bing.com/search?q="+sch;
		else if(engine.equalsIgnoreCase("yahoo"))
			url="https://in.search.yahoo.com/search?q="+sch;
		
		//perform sendRedirection
		System.out.println("before res.sendRedirect(-) method");
		res.sendRedirect(url);
		System.out.println("after res.sendRedirect(-) method");
		
		//close stream
		pw.close();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
