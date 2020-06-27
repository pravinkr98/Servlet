package com.ps.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ps.wrappers.MyRequest;
import com.ps.wrappers.MyResponse;

@WebFilter("/loginurl")
public class LoginFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		MyRequest mreq=null;
		MyResponse mres=null;
		String output=null;
		PrintWriter pw=null;
		
		//create Custom Request object
		mreq=new MyRequest(request);
		//create Custom Response object
		mres=new MyResponse(response);
		chain.doFilter(mreq, mres);
		//get output from custom response
		output=mres.toString();
		//modify output 
		output=output+"<br>---from<b> Praveen</b>";
		//specify response Content type
		response.setContentType("text/html");
		//get PrintWriter object
		pw=response.getWriter();
		pw.print(output);
		//close stream
		pw.close();
	}
}
