package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cgsturl")
public class ITCentralGSTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		float cost=0.0f;
		float cgst=0.0f;
		String ptype=null;
		//get PrintWriter
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read project cost from request object
		cost=Float.parseFloat(req.getParameter("cost"));
		ptype=req.getParameter("pType");
		//calculate central GST
		if(ptype.equalsIgnoreCase("product"))
			cgst=cost*0.18f;
		else if(ptype.equalsIgnoreCase("service"))
			cgst=cost*0.15f;
		else if(ptype.equalsIgnoreCase("startup"))
			cgst=cost*0.1f;
		
		//dispaly details
		pw.println("<br><b><i>Central GST :: "+cgst+"</i></b>");
		
		//do not close stream
		//pw.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
