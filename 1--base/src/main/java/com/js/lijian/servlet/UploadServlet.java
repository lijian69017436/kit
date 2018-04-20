package com.js.lijian.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lijian.util.UploadFileUtils;

public class UploadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("-----" + req.getRequestURI() + "-----");
		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		UploadFileUtils.uploadFile(req, "/patent/lijian/");

	}

	

}
