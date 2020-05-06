package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	public TestServlet() {
		ServletConfig cg=null;
		System.out.println("TestServlet.::0-param constructor");
		cg=getServletConfig();
	//	ServletContext sc=cg.getServletContext();
	//System.out.println("dbuser init param value::"+cg.getInitParameter("dbuser"));
	//	System.out.println("dbuser context param value::"+sc.getInitParameter("dbuser"));
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("TestServlet.init()");
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		ServletContext sc=null;
		ServletConfig cg=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		//get Access Servlet Config object
		cg=getServletConfig();
		//get Access Servlet Config object
		sc=getServletContext();
		pw.println("<br>db user init parameter value:: "+cg.getInitParameter("dbuser"));
		pw.println("<br>db user context parameter value:: "+sc.getInitParameter("dbuser"));
		
		pw.println("<br><br><br>Details using ServletContext object<br><br>");
		pw.println("<br>Server Info:: "+sc.getServerInfo());
		pw.println("<br>Server api version:: "+sc.getMajorVersion()+"."+sc.getMinorVersion());
		pw.println("<br>MIME type of input.html is:: "+sc.getMimeType("input.html"));
		pw.println("<br>Path of input.html:: "+sc.getRealPath("/input.html"));
		pw.println("<br>Path of web root folder:: "+sc.getRealPath("/"));
		pw.println("<br>Context path of the web application:: "+sc.getContextPath());
		
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
