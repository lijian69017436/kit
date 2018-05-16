package com.js.lijian.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.junit.Test;

public class UploadFileUtils {

	/**
	 * 解析 request 请求 
	 * 把解析后的 fileitem 写入磁盘
	 * @param req
	 * @param filePath
	 */
	@Test
	public static void uploadFile(HttpServletRequest req,String filePath){
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		try {
			List<FileItem> items = parseRequest(req);
			System.out.println(items.size()+"__");
			// 2. 遍历 items:
			for (FileItem item : items) {
				// 若是一个一般的表单域, 打印信息
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString("utf-8");
					System.out.println(name + ": " + value);
				} else {
					String fileName = item.getName();
					writeFile(item, filePath,fileName);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

/**
 * 解析 request 得到 文件 对象
 * @param req
 * @return
 * @throws FileUploadException
 */
	private static List<FileItem> parseRequest(HttpServletRequest req) throws FileUploadException {
		// 1、创建一个DiskFileItemFactory工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 2、创建一个文件上传解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 解决上传文件名的中文乱码
		upload.setHeaderEncoding("UTF-8");
		factory.setSizeThreshold(1024 * 500);// 设置内存的临界值为500K
		File linshi = new File("/patent/lijian/linshi");// 当超过500K的时候，存到一个临时文件夹中
		if (!linshi.exists()) {
			linshi.mkdirs();
		}
		factory.setRepository(linshi);
		upload.setSizeMax(1024 * 1024 * 5);// 设置上传的文件总的大小不能超过5M
		// 1. 得到 FileItem 的集合 items
		return upload.parseRequest(req);
	}
	
	
	/**
	 * 根据文件对象  和文件地址  写到磁盘
	 * @param item 文件对象
	 * @param filePath 磁盘地址
	 * @throws Exception 
	 */
	private static void writeFile( FileItem item ,String filePath,String filename) throws Exception {
		File file=new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		// 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：
		// c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
		// 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
		filename = filename.substring(filename.lastIndexOf("\\") + 1);
		
		// 若是文件域则把文件保存到 e:\\files 目录下.
		InputStream in = item.getInputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		OutputStream out = new FileOutputStream(filePath+filename);
		while ((len = in.read(buffer)) != -1) {
			out.write(buffer, 0, len);
		}
		out.close();
		in.close();
		
//		item.write(new File(filePath + filename));
//		item.delete();
	}
}
