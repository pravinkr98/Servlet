package com.ps.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	      
    
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd=null;
		HttpSession ses=null;
		ServletContext sc=null;
		
		//create request attribute
		req.setAttribute("attr1", "val1");
		
		//create session attribute
		ses=req.getSession();
		ses.setAttribute("username", "raja");
		ses.setAttribute("password", "rani");
		
		//create ServletContext attribute
		sc=getServletContext();
		sc.setAttribute("reqCount", 5);
		
		//forward request SecondServlet
		rd=req.getRequestDispatcher("/secondurl");
		rd.forward(req, res);
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
