package com.ps.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ps.dto.EmployeeDTO;
import com.ps.service.EmployeeMgmtService;
import com.ps.service.EmployeeMgmtServiceImpl;
import com.ps.vo.EmployeeVO;

//@WebServlet("/controller")
public class MainController extends HttpServlet {
	private EmployeeMgmtService service;

	@Override
	public void init() throws ServletException {
		service=new EmployeeMgmtServiceImpl();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		EmployeeVO vo=null;
		EmployeeDTO dto=null;
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data and store into vo class object
		vo=new EmployeeVO();
		vo.setEmpNO(req.getParameter("eno"));
		vo.setEname(req.getParameter("ename"));
		vo.setEaddr(req.getParameter("eaddr"));
		vo.setJob(req.getParameter("ejob"));
		vo.setSal(req.getParameter("esal"));
		//store vo object into dto class object
		dto=new EmployeeDTO();
		dto.setEmpNO(Integer.parseInt(vo.getEmpNO()));
		dto.setEname(vo.getEname());
		dto.setEaddr(vo.getEaddr());
		dto.setJob(vo.getJob());
		dto.setSal(Float.parseFloat(vo.getSal()));
		//use service
		try {
			String result=service.registerEmployee(dto);
			pw.println(result);
		}
		catch(Exception e) {
			pw.println("Internal Problem");
		}
		pw.println("<br><a href='employee_register.html'>Home</a>");
				
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
	
	

}
