package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/")
@WebServlet(value= {"/","url"})
public class DefaultServletTest extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		//get printwriter object
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		pw.println("<h1 style='color:red;text-align:center'>This is default servlet page.</h1>");
		pw.println("<h2 style='color:blue;text-align:center'>You must have to type correct url...</h>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
