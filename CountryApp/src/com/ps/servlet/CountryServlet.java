package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String[] capital= {"New Delhi","Islamabad","Bejing","Washington DC","Moscow"};
		PrintWriter pw=null;
		//get PrintWriter
		pw=res.getWriter();
		//set Content
		res.setContentType("text/html");
		//display capital 
		pw.println("Capital :: "+capital[Integer.parseInt(req.getParameter("country"))]);
		
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
