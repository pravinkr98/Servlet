package com.ps.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class BrowserCheckingFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter pw=null;
		String browser=null;
		//get printwriter object
		pw=response.getWriter();
		//set Content type
		response.setContentType("text/html");
		//get browser name
		browser=request.getHeader("user-agent");
		//check filter condition
		if(browser.indexOf("Chrome")==-1) {
			pw.println("<h1 style='color:red;text-align:center'>Use Chrome browser for open this website</h1>");
			return;
		}
		else {
			System.out.println("BrowserCheckingFilter.doFilter():: before filter");
			chain.doFilter(request, response);
			System.out.println("BrowserCheckingFilter.doFilter():: after filter");
		}
	}
}
