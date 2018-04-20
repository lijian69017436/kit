package action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{
  private static final long serialVersionUID = 1L;

  private File file; //代表上穿文件的file对象
  private String fileFileName; //上传文件名
  private String fileContentType; //上传文件类型
  private String description; //上传文件描述
  
  //保存上传文件的路径，相对于web 应用的根路径 ，需要struts。xml文件中配置
  private String  uploadDir;

  public String execute() throws Exception {
    
    String newFileName=null;
    //获取当前的时间用来给上传文件使用 
    long now=new Date().getTime();//得到的时间自1970年1月一日0时分秒开始
    System.out.println("当前时间"+now);
    //得到保存上传文件的真实目录
    String path=ServletActionContext.getServletContext().getRealPath(uploadDir);
    System.out.println("真实路径"+path);
    File dir=new File(path);
    if(!dir.exists()){//如果这个路径不存在 则创建目录
      dir.mkdir();
    }
    System.out.println(dir+"---");
    //处理文件路径 
    int index=fileFileName.lastIndexOf('.');
    System.out.println("路径index"+index);
    //判断上传文件，然后给上传文件重新命名
    if(index!=-1){
      newFileName=now +fileFileName.substring(index);
    }else{
      newFileName=Long.toString(now);
    }
    //创建缓冲区
    BufferedOutputStream bos=null;
    BufferedInputStream bis=null;
    //读取保存在临时文件目录下的上传文件，写入到新的文件中
    FileInputStream fis=new FileInputStream(file);
    bis=new BufferedInputStream(fis);
    FileOutputStream
    fos=new FileOutputStream(new File(dir,newFileName));
    bos=new BufferedOutputStream(fos);
    byte[] buf=new byte[4096];
    int len=-1;
    while((len=bis.read(buf))!=-1){
      bos.write(buf,0,len);
    }
    if(null!=bis){
      bis.close();
    }
    if(null!=bos){
      bos.close();
    }
    
    
    return "s";
  }
  
  private InputStream inputStream; //获取下载文件输入流
  private String downFileName;  //下载文件名
  public String download()throws Exception{
    String dfile=ServletActionContext.getServletContext().getRealPath("/")+
          "file/"+downFileName;
    inputStream=new FileInputStream(dfile);
    return "download";
  }
  
  
  
  
  
  
  
  
  
  
  public InputStream getInputStream() {
    return inputStream;
  }










  public void setInputStream(InputStream inputStream) {
    this.inputStream = inputStream;
  }










  public String getDownFileName() {
    return downFileName;
  }










  public void setDownFileName(String downFileName) {
    this.downFileName = downFileName;
  }










  public File getFile() {
    return file;
  }

  public void setFile(File file) {
    this.file = file;
  }

  public String getFileFileName() {
    return fileFileName;
  }

  public void setFileFileName(String fileFileName) {
    this.fileFileName = fileFileName;
  }

  public String getFileContentType() {
    return fileContentType;
  }

  public void setFileContentType(String fileContentType) {
    this.fileContentType = fileContentType;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getUploadDir() {
    return uploadDir;
  }

  public void setUploadDir(String uploadDir) {
    this.uploadDir = uploadDir;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
}
