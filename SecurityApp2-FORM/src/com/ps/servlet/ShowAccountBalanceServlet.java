package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/balanceurl")
public class ShowAccountBalanceServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		
		//get PrintWriter object
		pw=res.getWriter();
		//set ContentType
		res.setContentType("text/html");
		//display message
		pw.println("<h1 style='color:red;text-align:center'>Account Balance is :: "+new Random().nextInt(1000000)+"</h1>");
		//add hyperlink
		pw.println("<br><br><a href='index.html'>Home</a>");
		//close stream
		pw.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
