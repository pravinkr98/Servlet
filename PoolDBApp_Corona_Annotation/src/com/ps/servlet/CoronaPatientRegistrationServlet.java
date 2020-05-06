package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//@WebServlet("/register")
@WebServlet(urlPatterns="/registrationurl",loadOnStartup=1,name="corona",
			initParams= {@WebInitParam(name="p1",value="val1"),
						@WebInitParam(name="p2",value="val2")})
public class CoronaPatientRegistrationServlet extends HttpServlet {
	
	public static final String INSERT_CORONA_QUERY="INSERT INTO CORONA_REGISTRATION(PATID,PATNAME,PATADDRS,AGE,GENDER,STAGE) VALUES(CORONA_PATID_SEQ.NEXTVAL,?,?,?,?,?)";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String patName=null,patAddrs=null,gender=null,stage=null;
		int age=0,count=0;
		PreparedStatement ps=null;
		Connection con=null;
		ServletConfig cg=null;
		//get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		patName=req.getParameter("patName");
		patAddrs=req.getParameter("patAddrs");
		age=Integer.parseInt(req.getParameter("age"));
		gender=req.getParameter("gender");
		stage=req.getParameter("stage");
		try {
			//get Pooled JDBC con object
			con=getPooledConnection();
			//create JDBC PreparedStatement object
			ps=con.prepareStatement(INSERT_CORONA_QUERY);
			//set values to query params
			ps.setString(1, patName);
			ps.setString(2, patAddrs);
			ps.setInt(3, age);
			ps.setString(4, gender);
			ps.setString(5, stage);
			//execute the query
			count=ps.executeUpdate();
			//process the result
			if(count==0)
				pw.println("<h1 style='color:red;text-align:center'>Registration Failed.</h1>");
			else
				pw.println("<h1 style='color:green;text-align:center'>Registration Successful.</h1>");			
		
			//get Access to ServletConfig object
			cg=getServletConfig();
			pw.println("<br> p1 init param value:: "+cg.getInitParameter("p1"));
			pw.println("<br> p2 init param value:: "+cg.getInitParameter("p2"));
			pw.println("<br> logical name of Servlet comp:: "+cg.getServletName());
		}
		catch(SQLException se) {
			se.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Registration Failed</h1>");
		}
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Unknown Problems</h1>");
		}
		finally {
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();//releases the jdbc object back to the connection pool
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			pw.println("<h1><a href='register.html'>Home</a></h1>");
			try {
				if(pw!=null)
					pw.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
	
	private Connection getPooledConnection()throws Exception {
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		//create InitialContex object
		ic=new InitialContext();
		//get DataSource object through lookup operation
		ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
		//get Pooled JDBC con object
		con=ds.getConnection();
		return con;
	}
	

}
