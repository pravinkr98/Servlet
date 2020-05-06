package com.ps.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadParameters;

@WebServlet("/uploadurl")
public class UploadServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		MultipartFormDataRequest mfdreq=null;
		UploadBean bean=null;
		Vector vector=null;
		UploadParameters param=null;
		//get PrintWriter
		pw=res.getWriter();
		//set ContentType
		res.setContentType("text/html");
		try {
			//create MultiPartFormDataRequest object
			mfdreq=new MultipartFormDataRequest(req);
			//perform file uploading
			bean=new UploadBean();
			bean.setFolderstore("E:/store");
			//restrictions
			bean.setOverwrite(false);
			bean.setMaxfiles(7);
			bean.setFilesizelimit(20*1024*1024);
			bean.setBlacklist("*.pdf,*.jpg");
			//upload file
			bean.store(mfdreq);
			pw.println("<h1 style='color:green'>Files are uploaded successfully</h1>");
			//display the names of the uploaded files
			vector=bean.getHistory();
			for(int i=0;i<vector.size();++i) {
				param=(UploadParameters)vector.elementAt(i);
				pw.println("<br><b>file:: "+param.getFilename()+" size:: "+param.getFilesize()+" type:: "+param.getContenttype()+" model:: "+param.getStoreinfo()+"</b><br>");
			}//for
		}
		catch(Exception e) {
			pw.println("<h2 style='color:red;text-align:center'>Problem in uploading --> "+e.getMessage()+"</h2>");
			e.printStackTrace();
		}
		
		//hyperlink
		pw.println("<br><a href='upload.html'>Home</a>");
		
		//close stream
		pw.close();
				
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
