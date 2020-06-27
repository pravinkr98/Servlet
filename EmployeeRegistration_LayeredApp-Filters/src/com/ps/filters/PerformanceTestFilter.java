package com.ps.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class PerformanceTestFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long start=0,end=0;
		start=System.currentTimeMillis();
		System.out.println("PerformanceTestFilter.doFilter():: before filter");
		chain.doFilter(request, response);
		System.out.println("PerformanceTestFilter.doFilter():: after filter");
		end=System.currentTimeMillis();
		System.out.println(request.getRequestURI()+" request has taken "+(end-start)+" ms to process the request");
		
	}//do filter
	
}
