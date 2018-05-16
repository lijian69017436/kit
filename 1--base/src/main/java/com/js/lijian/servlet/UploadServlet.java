package com.js.lijian.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lijian.util.UploadFileUtils;


/**
 * 
 * @Description: TODO( 上传 servlet  路径  /upload) 
 * @author 李健 
 * @date 2018年5月10日 下午1:50:32
 */
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
