package com.js.lijian.servlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
/**
 * 
 * @{#} ExcelUtil.java Create on 2012-6-5下午02:04:16
 * <p>
 * 设置文件相关属性，然后以文件流形式生成对应的文件
 * </p>
 * 
 * @author hexin
 * @version V1.0
 */
public class ExcelUtil {


  /**
   * 把map里面的数据输出到FreeMark模板中从而生成对应的文件
   * 
   * @param templateName
   *          模板名称
   * @param map 
   *          模板数据
   * @param fileName
   *          生成的文件名称，带后缀
   * @return
   */
  public static void testcreateFile() {
    try {
      String templateName = null;
      Map map = null;
      String fileName = null;
        File outFile = createFile(templateName, map, fileName);
        HttpServletResponse response = null;
     //   DownloadFileUtils.downloadFile( outFile,response);
     
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (TemplateException e) {
      e.printStackTrace();
    }
    
  }

  
  /**
   * 根据模板和 数据生成文件
   * @param templateName
   * @param map
   * @param fileName
   * @return
   * @throws IOException
   * @throws FileNotFoundException
   * @throws UnsupportedEncodingException
   * @throws TemplateException
   */
  private static File createFile(String templateName, Map map, String fileName)
      throws IOException, FileNotFoundException, UnsupportedEncodingException, TemplateException {
    String path = ExcelUtil.class.getResource("/").getPath();
    String ctx = path.substring(0, path.indexOf("WEB-INF/classes/"));// Struts2Utils.getSession().getServletContext().getRealPath("/");//定时器就没有请求对象
    
    String templateFilePath=ctx+"/WEB-INF/template/"; //模板文件路径
    String downloadFilePath=ctx + "downloadfiles";   //下载文件路径
      
      File file = new File(downloadFilePath); // 创建下载文件夹
      if (!file.exists()) {
        file.mkdirs();
      }
      File files = new File(templateFilePath); //创建模板文件夹
      if (!files.exists()) {
        files.mkdirs();
      }
      // 0.得到模板
      Template template = getTemplate(templateName, templateFilePath);
      // 1,生成要下载的文件
      File outFile = new File(downloadFilePath + "/" + fileName);
      OutputStreamWriter oWriter = new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8");// 这个地方对流的编码不可或缺，
      Writer out = new BufferedWriter(oWriter);
      
      template.process(map, out);
      out.close();
      return outFile;
    
  }

/**
 * 得到模板
 * @param templateName
 * @param templateFilePath
 * @return
 * @throws IOException
 */
  private static Template getTemplate(String templateName, String templateFilePath) throws IOException {
    Configuration freemarker_cfg = new Configuration();
    freemarker_cfg.setDefaultEncoding("utf-8");
    freemarker_cfg.setDirectoryForTemplateLoading(new File(templateFilePath));
    Template template = freemarker_cfg.getTemplate(templateName, "UTF-8");
    return template;
  }


  
  
}
