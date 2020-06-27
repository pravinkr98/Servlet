package com.ps.wrappers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {
	private HttpServletRequest req;

	public MyRequest(HttpServletRequest request) {
		super(request);
		this.req=request;
	}
	
	@Override
	public String getParameter(String name) {
		String pval=req.getParameter(name);
		if(name.equals("user")) {
			if(!pval.endsWith("gmail.com"))
				pval=pval+"@gmail.com";
		}
		return pval;
	}

}
