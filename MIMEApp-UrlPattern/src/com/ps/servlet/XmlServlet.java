//XmlServlet
package com.ps.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class XmlServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		//getPrintWriter
		PrintWriter pw=null;
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/xml");
		//write logic to generate output(webpage)
		pw.println("<table border='1' align='center'>");
		pw.println("<tr><th>Politician</th><th>Party</th><th>Role</th></tr>");
		pw.println("<tr><td>Modi</td><td>BJP</td><td>PM</td></tr>");
		pw.println("<tr><td>Amit Sah</td><td>BJP</td><td>Chanakya</td></tr>");
		pw.println("<tr><td>Rahul Gandhi</td><td>Congress</td><td>MP</td></tr>");
		pw.println("<tr><td>Arvind Kejriwal</td><td>AAP</td><td>CM</td></tr>");
		pw.println("</table>");
		
		//close stream
		pw.close();
	}//service(-,-)
}//class