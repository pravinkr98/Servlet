package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sgsturl")
public class ITStateGSTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String pname=null,ptype=null,company=null;
		float cost=0.0f,sgst=0.0f;
		PrintWriter pw=null;
		ServletContext sc1=null,sc2=null;
		RequestDispatcher rd=null;
		//read form data
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read form data
		pname=req.getParameter("pName");
		ptype=req.getParameter("pType");
		company=req.getParameter("company");
		cost=Float.parseFloat(req.getParameter("cost"));
		//calculate state GST
		if(ptype.equalsIgnoreCase("product"))
			sgst=cost*0.12f;
		else if(ptype.equalsIgnoreCase("service"))
			sgst=cost*0.1f;
		else if(ptype.equalsIgnoreCase("startup"))
			sgst=cost*0.03f;
		
		//display details
		pw.println("<h1 style='color:red;text-align:centr'>GST Info</h1>");
		pw.println("<br><b>Project name :: "+pname+"</b>");
		pw.println("<br><b>Project company :: "+company+"</b>");
		pw.println("<br><b>Project type :: "+ptype+"</b>");
		pw.println("<br><b>Cost :: "+cost+"</b>");
		pw.println("<br><b><i>State GST :: "+sgst+"</i></b>");
		
		//Communication with destination servlet CentralGSTApp using cross context communication
		//get Servlet context object of currnt web application
		sc1=getServletContext();
		//get Foreign context object of CentralGSTApp
		sc2=sc1.getContext("/CentralGSTApp");
		//get RequestDispatcher object pointing ITCentralGSTServlet of CentralGSTApp
		rd=sc2.getRequestDispatcher("/cgsturl");
		rd.include(req, res);
		
		//add home link
		pw.println("<br><br><a href='input.html'>Home</a>");
		
		//close stream
		pw.close();
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
