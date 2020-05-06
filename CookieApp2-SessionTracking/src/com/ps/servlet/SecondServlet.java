package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	private static final String INSERT_PERSON_QUERY="INSERT INTO COOKIE_PERSON_INFO VALUES(COOKIE_PID.NEXTVAL,?,?,?,?,?)";
	
	@Resource(name="DsJndi")
	private DataSource ds;
	   
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,fname=null,gender=null;
		Float income=0.0f,tax=0.0f;
		Cookie cookies[]=null;
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		
		//get PrintWriter
		pw=res.getWriter();
		//set Content Type
		res.setContentType("text/html");
		
		//read form2/req2 data
		income=Float.parseFloat(req.getParameter("income"));
		tax=Float.parseFloat(req.getParameter("tax"));
		
		//read form1/req1 data from cookie value (Session Tracking)
		cookies=req.getCookies();
		if(cookies!=null) {
			name=cookies[0].getValue();
			fname=cookies[1].getValue();
			gender=cookies[2].getValue();
		}
		
		try {
			//get connection from connection pooling
			con=ds.getConnection();
			//create PreparedStatement query
			ps=con.prepareStatement(INSERT_PERSON_QUERY);
			//set query param value
			if(ps!=null) {
				ps.setString(1, name);
				ps.setString(2, fname);
				ps.setString(3, gender);
				ps.setFloat(4, income);
				ps.setFloat(5, tax);
			}
			
			//execute sql query statement
			count=ps.executeUpdate();
			
			//process the result
			if(count==0)
				pw.println("<h1 style='color:red;text-align:center'>Person registration failed.</h1>");
			else
				pw.println("<h1 style='color:green;text-align:center'>Person registration succeded.</h1>");		
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close objects
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}//finally
		
		//display form1/req1 data and form2/req2 data
		pw.println("form1/req1 data :: "+name+"......"+fname+"......"+gender);
		pw.println("<br>form2/req2 data :: "+income+"......"+tax);
		
		//set home page
		pw.println("<h1><a href='input.html'>Home</a></h1>");
		
		//close stream
		pw.close();		
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
