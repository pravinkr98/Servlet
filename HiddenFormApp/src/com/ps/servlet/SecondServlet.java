package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	private static final String PERSON_INFO_QUERY="INSERT INTO PERSON_INFO VALUES(PID_SEQ.NEXTVAL,?,?,?,?,?)";
	
	@Resource(name="DsJndi")
	private DataSource ds;
	       
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String pname=null,fname=null,marital=null;
		String f2val1=null,f2val2=null;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//get PrintWriter
		pw=res.getWriter();
		//set res content type
		res.setContentType("text/html");
		//read form1/req1 data
		pname=req.getParameter("hname");
		fname=req.getParameter("hfname");
		marital=req.getParameter("marital");
		//read form2/req2 data
		f2val1=req.getParameter("f2t1");
		f2val2=req.getParameter("f2t2");
		
		try {
			//get pooled jdbc connection
			con=ds.getConnection();
			//create PreparedStatement object
			ps=con.prepareStatement(PERSON_INFO_QUERY);
			//set query param values
			ps.setString(1, pname);
			ps.setString(2, fname);
			ps.setString(3, marital);
			ps.setString(4, f2val1);
			ps.setString(5, f2val2);
			//execute sql query statement
			result=ps.executeUpdate();
			//process result
			if(result==0)
				pw.println("<br><br>Person Registration Failed.");
			else
				pw.println("<br><br>Person Registration Successful.");
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close jdbc objects
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
		}
		//display dynamic webpage having both form1/req1 data and form2/req2 data
		pw.println("<h1 style='color:red;text-align:center'>Result page</h1>");
		pw.println("<br>form1/req1 data:: "+pname+"....."+fname+"....."+marital);
		pw.println("<br>form2/req2 data:: "+f2val1+"....."+f2val2);
		//add hyperlink
		pw.println("<br><br><a href='input.html'>Home</a>");
		
		//close stream
		pw.close();
	
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
