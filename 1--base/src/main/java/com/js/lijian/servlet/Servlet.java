package com.js.lijian.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lijian.util.DownloadFileUtils;
import com.lijian.util.ExcelUtil;

import net.sf.json.JSONObject;

public class Servlet extends HttpServlet{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("-----"+req.getRequestURI()+"-----");
    req.setAttribute("lijian", "hello word");
    ExcelUtil.testcreateFile();
    DownloadFileUtils.downloadFile(new File("d://e.text"), resp);
    req.getRequestDispatcher("/index.jsp").forward(req, resp);
  }
  
  
  
}
