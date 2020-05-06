package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/headerurl")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		System.out.println("HeaderServlet.doGet()-- Header ");
		
		//get PrintWriter
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//set header
		pw.println("<br><b><h1 style='color:red;text-align:center'><marquee>W E L C O M E   T O   P R A V E E N   W O R L D</marquee></h1></b><br><br><br><hr>");
		//do not close stream
		//pw.close();
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("HeaderServlet.doPost()-- Header ");
		doGet(req, res);
	}

}
