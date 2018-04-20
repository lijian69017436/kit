package com.ejz.wechat.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ejz.wechat.dao.entity.Photo;
import com.ejz.wechat.service.PhotoService;
import com.ejz.wechat.util.DateUtils;
import com.ejz.wechat.util.PropertiesUtil;
import com.ejz.wechat.util.UUIDUtil;
import com.zbxsoft.core.orm.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller()
@Api(value="获取用户列表" ,consumes="123" ,description="1234")
public class IndexController extends BaseController {

	@Autowired
	PhotoService photoService;

	public IndexController() {
	}

	/**
	 * 首页
	 */
	@ApiOperation(value="首页", notes="")
	@RequestMapping(value = "/index" )
	public String index() {
		System.out.println(1);
		return "index";
	}

	/**
	 * 封装数据 返回 图片列表
	 * 
	 * @param page
	 * @throws IOException
	 */
	@RequestMapping(value = "/index/img")
	public void Img(String page) throws IOException {
		JSONObject json = new JSONObject();
		JSONArray arr = new JSONArray();
		Page<Photo> photo = photoService.selectByPage(Integer.valueOf(page), 10);
		for (Photo p : photo.getResult()) {
			JSONObject json1 = new JSONObject();
			json1.put("src", PropertiesUtil.getInstance().getValue("resourceServer") + p.getPath());
			arr.add(json1);
		}
		json.put("data", arr);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.getWriter().print(json.toString());
	}

	/**
	 * 接受 上传的图片
	 * 
	 * @throws IOException
	 */
	@Scope("prototype")
	@RequestMapping(value = "/upload/img")
	public void uploadImg() {
		// 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
		// String Path = URLUtil.getClassPath(this.getClass());
		// String uplodaImg="/uploadImg";
		// String savePath= Path.substring(0, Path.length()-8)+uplodaImg;
		// request.getContextPath();
		String savePath = PropertiesUtil.getInstance().getValue("resourcePath");
		System.out.println(savePath);
		File file = new File(savePath);
		// 判断上传文件的保存目录是否存在
		if (!file.exists() && !file.isDirectory()) {
			System.out.println(savePath + "目录不存在，需要创建");
			// 创建目录
			file.mkdir();
		}
		// 消息提示
		String msg = "";
		String filename = null;
		// 使用Apache文件上传组件处理文件上传步骤：
		// 1、创建一个DiskFileItemFactory工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 2、创建一个文件上传解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 解决上传文件名的中文乱码
		upload.setHeaderEncoding("UTF-8");
		// 3、判断提交上来的数据是否是上传表单的数据
		if (!ServletFileUpload.isMultipartContent(request)) {
			// 按照传统方式获取数据
			return;
		}
		// 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
		List<FileItem> list = null;
		try {
			list = upload.parseRequest(request);

			for (FileItem item : list) {
					// 如果fileitem中封装的是普通输入项的数据
					if (item.isFormField()) {
						String name = item.getFieldName();
						// 解决普通输入项的数据的中文乱码问题
						String value = item.getString("UTF-8");
						System.out.println(name + "=" + value);
					} else {// 如果fileitem中封装的是上传文件
							
						filename = item.getName();// 得到上传的文件名称，
						if (filename == null || filename.trim().equals("")) {
							continue;
						}
						// 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：
						// c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
						// 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
						filename = filename.substring(filename.lastIndexOf("\\") + 1);
						
						item.write(new File(savePath + File.separator + filename));

						item.delete();
						
						msg += filename + "文件上传成功！";
						
						Photo photo = new Photo();
						photo.setId(UUIDUtil.getUUID());
						photo.setPath(filename);
						photo.setTime(DateUtils.formatDate_ymdhms(new Date()));
						photoService.addPhoto(photo);
					}

			}
		} catch (Exception e1) {
			msg += filename + "文件上传失败！";
			e1.printStackTrace();
		}
		

		// 关闭输入流
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			response.getWriter().print("{\"结果\":\"" + msg + "\"}");
			//
			return ;
		} catch (IOException e) {
			// e.printStackTrace();
		}

	}

}
