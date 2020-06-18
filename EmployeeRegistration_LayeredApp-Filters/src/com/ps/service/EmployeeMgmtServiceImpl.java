package com.ps.service;

import com.ps.bo.EmployeeBO;
import com.ps.dao.EmployeeDAO;
import com.ps.dao.EmployeeDAOImpl;
import com.ps.dto.EmployeeDTO;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	private EmployeeDAO dao;
	
	public EmployeeMgmtServiceImpl() {
		dao=new EmployeeDAOImpl();
	}
	
	@Override
	public String registerEmployee(EmployeeDTO dto) throws Exception {
		float grossSalary=0.0f;
		float netSalary=0.0f;
		EmployeeBO bo=null;
		int count=0;
		//write b.logic
		grossSalary=dto.getSal()+dto.getSal()*0.4f;
		netSalary=grossSalary-(grossSalary*0.2f);
		//create BO class object having persistable data
		bo=new EmployeeBO();
		bo.setEmpNO(dto.getEmpNO());
		bo.setEname(dto.getEname());
		bo.setEaddr(dto.getEaddr());
		bo.setJob(dto.getJob());
		bo.setSal(dto.getSal());
		bo.setGrossSal(grossSalary);
		bo.setNetSal(netSalary);
		//use dao
		count=dao.insert(bo);
		//process the result
		if(count==0)
			return "Registration failed";
		else
			return "Registration Succeded";
		
	}

}
