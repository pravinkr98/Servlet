package com.ps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.ps.bo.EmployeeBO;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String INSERT_EMP_QUERY="INSERT INTO EMP VALUES(?,?,?,?,?,?,?)";
	
	//helper methods
	private Connection getPooledJdbcConnection()throws Exception{
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		//create InitialContext object
		ic=new InitialContext();
		//get DataSource object
		ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
		//get Pooled JDBC con object
		con=ds.getConnection();
		return con;
	}
	
	@Override
	public int insert(EmployeeBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		
		//get connection from connection pool
		con=getPooledJdbcConnection();
		//create PreparedStatement object
		ps=con.prepareStatement(INSERT_EMP_QUERY);
		//set query param value
		ps.setInt(1, bo.getEmpNO());
		ps.setString(2, bo.getEname());
		ps.setString(3, bo.getEaddr());
		ps.setString(4, bo.getJob());
		ps.setFloat(5, bo.getSal());
		ps.setFloat(6, bo.getGrossSal());
		ps.setFloat(7, bo.getNetSal());
		//execute prepared statement query
		count=ps.executeUpdate();
		//close jdbc objects
		ps.close();
		con.close();
		
		return count;
	}

}
