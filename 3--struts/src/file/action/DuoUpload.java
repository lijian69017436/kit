package action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DuoUpload extends ActionSupport{
  private List<File> file;
  private List<String > fileFileName;
  private List<String> fileContentType;
  private String uploadDir;
  
  
  public String execute() throws Exception {
    String newFileName =null;
    for(int i=0;i<file.size();i++){
      long now =new Date().getTime();
      int index=fileFileName.get(i).lastIndexOf('.');
      String path=ServletActionContext.getServletContext().getRealPath(uploadDir);
      File dir=new File(path);
      if(!dir.exists()){
        dir.mkdir();
      }
      if(index!=-1){
        newFileName=now+fileFileName.get(i).substring(index);
        
      }else{
        newFileName=Long.toString(now);
      }
      BufferedOutputStream bos=null;
      BufferedInputStream bis=null;
      FileInputStream fis=new FileInputStream(file.get(i));
      bis=new BufferedInputStream(fis);
      FileOutputStream fos=new FileOutputStream(new File(dir,newFileName));
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
    }
     
    return "sss";
  }


  public List<File> getFile() {
    return file;
  }


  public void setFile(List<File> file) {
    this.file = file;
  }


  public List<String> getFileFileName() {
    return fileFileName;
  }


  public void setFileFileName(List<String> fileFileName) {
    this.fileFileName = fileFileName;
  }


  public List<String> getFileContentType() {
    return fileContentType;
  }


  public void setFileContentType(List<String> fileContentType) {
    this.fileContentType = fileContentType;
  }


  public String getUploadDir() {
    return uploadDir;
  }


  public void setUploadDir(String uploadDir) {
    this.uploadDir = uploadDir;
  }
  
  
  
}
