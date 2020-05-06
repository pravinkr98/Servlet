package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBServlet extends HttpServlet {
	Connection con=null;
	PreparedStatement ps=null;
	PrintWriter pw=null;
	ResultSet rs=null;
	
	@Override
	public void init() {
		ServletConfig cg=null;
		String jdbcDriver,jdbcUrl,jdbcUser,jdbcPwd;
		try {
			cg=getServletConfig();
			jdbcDriver=cg.getInitParameter("dbDriver");
			jdbcUrl=cg.getInitParameter("dburl");
			jdbcUser=cg.getInitParameter("dbuser");
			jdbcPwd=cg.getInitParameter("dbpwd");
			//register jdbc driver
			Class.forName(jdbcDriver);
			//Establish the connection
			con=DriverManager.getConnection(jdbcUrl,jdbcUser,jdbcPwd);
			//create jdbc prepared statement
			ps=con.prepareStatement("SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?");
		}//try
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Internal DB error</h1>");
		}
	}//init
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		int eno=0;
		ServletConfig cg=null;
		ServletContext sc=null;				
		try {
			cg=getServletConfig();
			sc=cg.getServletContext();
			pw=res.getWriter();
			//set content type
			res.setContentType("text/html");
			//read form data
			eno=Integer.parseInt(req.getParameter("teno"));
			//set param value to SQL query
			ps.setInt(1,eno);
			//execute the sql query
			rs=ps.executeQuery();
			//process the Result set
			if(rs.next()) {
				pw.println("<br><b>Employee no. : </b>"+rs.getInt(1));
				pw.println("<br><b>Employee name : </b>"+rs.getString(2));
				pw.println("<br><b>Employee job : </b>"+rs.getString(3));
				pw.println("<br><b>Employee salary : </b>"+rs.getFloat(4));
				pw.println("<br><b>Employee department no. : </b>"+rs.getInt(5));
			}//if
			else {
				pw.println("<br>No Employee found.");
			}
			pw.println("<br>ServletContext obj class name::"+sc.getClass());
			pw.println("<br>ServletConfig obj class name::"+cg.getClass());
			pw.println("<br><br><a href='input.html'>Home</a>");
		}//try
		catch(Exception se) {
			se.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Internal Error</h1>");
		}
	}//doGet
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
	@Override
	public void destroy() {
		//close jdbc objects
		try {
			if(rs!=null)
				rs.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		try {
			if(ps!=null)
				ps.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		try {
			if(pw!=null)
				pw.close();
		}
		catch(Exception iao) {
			iao.printStackTrace();
		}
		try {
			if(con!=null)
				con.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}

}
