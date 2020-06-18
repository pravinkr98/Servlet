package com.ps.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter("/*")
public class TimeCheckFilter extends HttpFilter {
	
	public TimeCheckFilter() {
		System.out.println("TimeCheckFilter:: 0-param constructor");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("TimeCheckFilter.init()");
	}
		
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Calendar calendar=null;
		int hour=0;
		PrintWriter pw=null;
		
		//get printwriter object
		pw=response.getWriter();
		//set Content type
		response.setContentType("text/html");
		System.out.println("TimeCheckFilter.doFilter()");
		System.out.println("browser :: "+request.getHeader("user-agent"));
		//get calendar object
		calendar=Calendar.getInstance();
		//get hour of the day
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		System.out.println("hour :: "+hour);
		//check filter condition
		if(hour<9||hour>17) {
			pw.print("<h1 style='color:red;text-align:center'>Request must be given between 9AM to 5PM</h1>");
			return;
		}
		else {
			System.out.println("TimeCheckFilter.doFilter()::before Filter");
			chain.doFilter(request, response);
			System.out.println("TimeCheckFilter.doFilter()::after Filter");
		}
		
	}
	
	@Override
	public void destroy() {
		System.out.println("TimeCheckFilter.destroy()");
	}
	
	
}
