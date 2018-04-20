package com.lijian.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

/**
 * 下载文件类
 * @ClassName: DownloadFileUtils 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author lijian 
 * @date 2016年3月31日 上午10:35:11 
 *
 */
public class DownloadFileUtils {

  private static final int BUFFER_SIZE = 1 * 1024;

/**
 * 打开流下载文件
 * @param outFile
 * @param response
 * @throws IOException
 */
  public static void downloadFile( File outFile,HttpServletResponse response) throws IOException{
    // 1,读取下载文件到内存
    BufferedInputStream br = new BufferedInputStream(new FileInputStream(outFile));
    // 2,设置 response out 流
    OutputStream outputStream = setResponseGetOut(outFile,response);
    // 3,下载开始
    byte[] buf = new byte[BUFFER_SIZE];
    int len = 0; 
    while ((len = br.read(buf)) != -1) {
      outputStream.write(buf, 0, len);
    }

    br.close();
    outputStream.close();
  }
 /**
  * @解释 设置 response 一些信息 得到outputStream
  * @param outFile
  * @param response
  * @return outputStream
  * @throws IOException
  */
  private static OutputStream setResponseGetOut(File outFile,HttpServletResponse response) throws IOException {
    String fileName=outFile.getName();
    response.reset();
    fileName = java.net.URLEncoder.encode(fileName, "UTF-8");// 处理中文文件名的问题
    fileName = new String(fileName.getBytes("UTF-8"), "GBK");// 处理中文文件名的问题
    response.setContentType("application/vnd.ms-excel"); // 设置response的编码方式
    response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
    OutputStream outputStream = response.getOutputStream();// 从response对象中得到输出流,准备下载
    return outputStream;
  }
}
