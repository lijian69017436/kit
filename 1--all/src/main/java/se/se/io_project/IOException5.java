package se.se.io_project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IOException5 {

	/**
	 *  将控制台输入内容，写入指定文件，如果该文件和路径不存在，则创建该路径；
	 * @throws IOException 
	 */
	
	public static void writeMsgBySystemInToFile(String filePath,String fileName) throws IOException{
		File fileEntry=new File(filePath);//文件存储路径
		if(!fileEntry.exists()){
			fileEntry.mkdirs();//创建该路径
		}
		
		File  file=new File(filePath+"/"+fileName);
		if(!file.exists()){
			file.createNewFile();//创建该文件
		}
		
		InputStream input=System.in;//控制台输入的，是字节流数据；
	    InputStreamReader streamReader=new InputStreamReader(input);//控制台输入的System.in放入字符流
	    BufferedReader bufferedReader=new BufferedReader(streamReader);//放入缓冲流
	    
	    
	    FileOutputStream outStream=new FileOutputStream(file);
	    OutputStreamWriter streamWriter=new OutputStreamWriter(outStream);
	    BufferedWriter bufferedWriter=new BufferedWriter(streamWriter);
	    
	    while(true){
	    	String str=bufferedReader.readLine();//正行读取数据；
	    	bufferedWriter.write(str);//将数据写入缓冲流
	    	bufferedWriter.newLine();//通过缓冲流换行；
	    	if(str.equals("end")){
	    		break;
	    	}
	    }
	    
	    //流的关闭：从内层往外层关闭；
	    bufferedReader.close();
	    streamReader.close();
	    
	    bufferedWriter.close();
	    streamWriter.close();
	    outStream.close();
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		writeMsgBySystemInToFile("D:/IOException5_test", "test.txt");
	}

}
