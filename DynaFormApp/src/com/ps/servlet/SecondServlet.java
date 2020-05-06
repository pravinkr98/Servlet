package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	       
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String pname=null,fname=null,marital=null;
		String f2val1=null,f2val2=null;
		//get PrintWriter
		pw=res.getWriter();
		//set res content type
		res.setContentType("text/html");
		//read form1/req1 data
		pname=req.getParameter("pname");
		fname=req.getParameter("fname");
		marital=req.getParameter("marital");
		//read form2/req2 data
		f2val1=req.getParameter("f2t1");
		f2val2=req.getParameter("f2t2");
		//display dynamic webpage having both form1/req1 data and form2/req2 data
		pw.println("<h1 style='color:red;text-align:center'>Result page</h1>");
		pw.println("<br>form1/req1 data:: "+pname+"....."+fname+"....."+marital);
		pw.println("<br>form2/req2 data:: "+f2val1+"....."+f2val2);
		//add hyperlink
		pw.println("<br><br><a href='input.html'>Home</a>");
		
		//close stream
		pw.close();
	
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
