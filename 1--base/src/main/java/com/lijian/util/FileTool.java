package com.lijian.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件处理 类
 * @author Administrator
 *
 */
public class FileTool {


  /**
   * 根据nio 创建 文件
   * @param path 文件路径
   * @param name 文件名字
   * @param content 写入内容
   * @param code 文件编码
   * @throws IOException 抛出异常
   */
  public static void  writesStringByNIO(String path,String name,String content,String code) throws IOException  {
    createFile(path,name);
    File file=new File (path+name);
    @SuppressWarnings("resource")
	FileOutputStream fos = new FileOutputStream(file);      
    FileChannel fc = fos.getChannel();
    //创建一个buffer并把准备写的数据填充进去;
    ByteBuffer bb = ByteBuffer.wrap(content.getBytes());
    //数据源
    byte[] message = content.getBytes(code);
    bb.put(message);
    bb.flip();
    fc.write(bb);
    bb.clear();
    fc.close();
}
  
  /**
   * 根据 路径和文件名 创建 文件
   * @param filePath
   * @param fileName
   */
  public static String createFile(String filePath,String fileName){
    String result="";
    try{
      File fi=new File(filePath);
      File fil=new File(filePath+fileName);
      if(!fi.exists()){
        fi.mkdirs();
      }
      if(!fil.exists()){
         fil.createNewFile();
         result="创建 文件 成功"+filePath+fileName;
      }
//      Log.base.debug(""+fil.getAbsoluteFile());
    } catch (IOException e){
      result="创建 文件 失败 ："+filePath+fileName+e.toString();
    }
    return result;
  }
  
  
  /**
   *  指定一个文本文件，读取内容；
   * @throws IOException 
   * */
  
  public static StringBuffer readTargetFileText(String filePath) throws IOException{//filePath包含具体文件名的了路径；
    File file=new File(filePath);
    if(!file.exists()){
      System.out.println("要读取的文件不存在");
      return null;
    }
    //文件放入输入流；
      FileReader reader=new FileReader(file);
    BufferedReader bufferedReader=new BufferedReader(reader);
      
    StringBuffer str=new StringBuffer();
      while(bufferedReader.ready()){//如果缓冲流准备就绪（流可以读取数据了）
        str.append(bufferedReader.readLine()+"\r\n");//读取正行数据；
         
      }
    return str;
    
  }
}
