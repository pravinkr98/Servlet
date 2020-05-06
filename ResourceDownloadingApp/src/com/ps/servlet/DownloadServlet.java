package com.ps.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

@WebServlet("/downloadurl")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		File file=null;
		String fname=null;
		ServletContext sc=null;
		String mimeType=null;
		InputStream is=null;
		OutputStream os=null;
		
		//read file name to be downloaded as additional req param value from hyperlink
		fname=req.getParameter("filename");
		//create File object locating and holding the file to be downloaded
		file=new File("E:/store/"+fname);
		//get the length of the file and make it as response content length
		res.setContentLengthLong(file.length());
		//get ServletContext object
		sc=getServletContext();
		//get MIME type of the file and make it as response MIME type
		mimeType=sc.getMimeType("E:/store/"+fname);
		res.setContentType(mimeType!=null?mimeType:"application/octet-stream");
		//create InputStream ponting to the file to be downloaded
		is=new FileInputStream(file);
		//create OutputStream Pointing to response object
		os=res.getOutputStream();
		//set values t content-disposition response header
		res.setHeader("Content-Disposition", "attachment;fileName="+fname);
		//copy the file content to response object
		IOUtils.copy(is, os);
		//close streams
		is.close();
		os.close();
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
