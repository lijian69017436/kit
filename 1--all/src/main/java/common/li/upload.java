package common.li;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

public class upload {

  
  /**
   * 文件下载
   * @param reponse
   * @param path
   * @throws IOException
   */
  public static void downfileByPath(HttpServletResponse reponse,String path){
    BufferedInputStream bis= null;
    BufferedOutputStream bos= null;
    OutputStream fos= null;
    InputStream fis= null;
    try {
      String  filepath=path;//本地绝对路径
      File uploadFile = new File(filepath);
      fis = new FileInputStream(uploadFile);
      bis = new BufferedInputStream(fis);
      fos = reponse.getOutputStream();
      bos = new BufferedOutputStream(fos);
      reponse.setHeader("Content-disposition","attachment;filename=" +URLEncoder.encode(uploadFile.getName(), "utf-8"));
      int bytesRead = 0;
      //用输入流进行先读，然后用输出流去写，缓冲输入输出流
      byte[] buffer = new byte[8192];
      while ((bytesRead = bis.read(buffer, 0, 8192)) != -1) {
        bos.write(buffer, 0, bytesRead);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }finally{
      try {
        if (bos!=null) {
          bos.flush();
          bos.close();
        }
        if (fis!=null) {
          fis.close();
        }
        if (bis!=null) {
          bis.close();
        }
        if (fos!=null) {
          fos.flush();
          fos.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }  
  }

}
