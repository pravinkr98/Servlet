package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testurl")
public class ThreadTestServlet extends HttpServlet implements SingleThreadModel{
	
	public ThreadTestServlet() {
		System.out.println("ThreadTestServlet:: 0-param constructor");
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("ThreadTestServlet.doGet()"+this.hashCode());
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("<h1>Date and Time :: "+new java.util.Date()+"</h1>hashCode :: "+this.hashCode());
		
		
		  try { 
			  Thread.sleep(30000); 
			  }
		  catch(Exception e)
		  	{ 
			  e.printStackTrace(); 
			 }
		 
		//close stream
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ThreadTestServlet.doPost()");
		doGet(request, response);
	}

}
