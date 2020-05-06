package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/errorurl",name="err")
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		
		//get printwriter
		pw=res.getWriter();
		//set ContentType
		res.setContentType("text/html");
		pw.println("<br><b><h1 style='color:red;text-align:center'>Internal DB problem (Error-Servlet)</h1></b>");
		pw.println("<br><br><b><a href='input.html'>Home page</a></b>");
		//close stream
		//pw.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
