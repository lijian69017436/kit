package se.se.io_project;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOExceptionCopyByByteStream {

	/**
	 * 通过字节流复制文件
	 * @throws IOException 
	 */
	// filePathTarget 被复制的文件路径和文件名； filePath 复制完以后的文件存储路径； fileName 复制后存储的文件名；
	public static  void copyFile(String filePathTarget,String filePath) throws IOException{
		File file=new File(filePathTarget);//被复制的文件
		if(file.exists()){//如果文件存在
			
			//将被复制的文件读入内存；
			FileInputStream fileInputStream=new FileInputStream(file);
			BufferedInputStream bufferedInputSream=new BufferedInputStream(fileInputStream);
			
			//判断复制的文件存储路径是否存在；
			File fileTarget=new File(filePath);
			if(!fileTarget.exists()){
				fileTarget.mkdirs();
			}
			
			//创建 目标文件（复制以后的那个文件）；
			File fileCopyRes=new File(filePath+"/"+file.getName());
			if(fileCopyRes.exists()){
				System.out.println("该文件已经复制过！不能再次复制；");
			}else{
				fileCopyRes.createNewFile();//创建目标文件；
				 FileOutputStream fileOutputStream=new FileOutputStream(fileCopyRes);//将目标文件放入输入流；
				 BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
				 
				 //第一种：下面写法不好，容易阻塞，效率低
				 /*int j=0;
				 while((j=bufferedInputSream.read())!=-1){//如果流读取完毕
					 bufferedOutputStream.write(j); 
					 System.out.println(j);
					 
				 }*/
				 //第二种：
				 int i=0;
				 byte [] byteItems=new byte[1024];
				 while((i=bufferedInputSream.read(byteItems))!=-1){
					 System.out.println(i);
					 bufferedOutputStream.write(byteItems, 0, i);//每次读取1024字节，这些字节都存放这个数组中， 从数组下标0开始读取，读取的长度i
					 bufferedOutputStream.flush();//刷新输出流；
				 }
				 
				 
				 bufferedInputSream.close();
				 fileInputStream.close();
				 
				 bufferedOutputStream.close();
				 fileOutputStream.close();
				
			}
			
		}
		
		
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		copyFile("D:/上课讲解内容/上课视频/7.7视频HTML/html1.fbr","D:/新员工信息");

	}

}
