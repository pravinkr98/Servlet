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
import javax.servlet.http.HttpSession;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	      
    
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd=null;
		PrintWriter pw=null;
		HttpSession ses=null;
		ServletContext sc=null;
		
		//get PrintWriter
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		
		//read and display request attribute values
		pw.println("<br><b>(SecondServlet) request attribute(attr1) value :: "+req.getAttribute("attr1")+"</b>");
		
		pw.println();
		//get session
		ses=req.getSession();
		pw.println("<br><b>(SecondServlet) session attribute(username) value :: "+(String)ses.getAttribute("username")+"</b>");
		pw.println("<br><b>(SecondServlet) session attribute(password) value :: "+(String)ses.getAttribute("password")+"</b>");
		//ses.setAttribute("password", "jokar");
		//ses.removeAttribute("password");
		
		pw.println();
		//get Access to ServletContext object
		sc=getServletContext();
		pw.println("<br><b>(SecondServlet) ServletContext attribute(reqCount) value :: "+(Integer)sc.getAttribute("reqCount")+"</b>");

		
		//forward request thirdServlet
		rd=req.getRequestDispatcher("/thirdurl");
		rd.forward(req, res);
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
