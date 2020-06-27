package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginurl")
public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uname=null,pwd=null;
		PrintWriter pw=null;
		
		System.out.println(req.getClass()+"     "+res.getClass());
		//get PrintWriter
		pw=res.getWriter();
		//set response type
		res.setContentType("text/html");
		//read form data
		uname=req.getParameter("user").trim();
		pwd=req.getParameter("pwd").trim();
		//perform authentication
		if(uname.equalsIgnoreCase("raja@gmail.com")&&pwd.equals("rani")) {
			pw.println("<h1 style='color:green;text-align:center'>Valid Credentials</h1>");
		}
		else
			pw.println("<h1 style='color:red;text-align:center'>Invalid Credentials</h1>");

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
