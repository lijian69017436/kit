package io_project;

import java.io.BufferedReader;
import java.io.*;
import java.io.InputStream;

public class T {
	public static void writeBySystemInToFile(String filePath,String fileName) throws IOException{
		File fileEnter=new File(filePath);
		if(!fileEnter.exists()){
			fileEnter.mkdirs();
			
		}
		File file=new File(filePath+"/"+fileName);
		if(!file.exists()){
			file.createNewFile();
			
		}
		InputStream input=System.in;
		InputStreamReader streamReader=new InputStreamReader(input);
		BufferedReader bufferedReader=new BufferedReader(streamReader);
		
		FileOutputStream out=new FileOutputStream(file);
		OutputStreamWriter streamWriter=new OutputStreamWriter(out);
		BufferedWriter bufferedWriter=new BufferedWriter(streamWriter);
		
		while(true){
			String str=bufferedReader.readLine();
			bufferedWriter.write(str);
			bufferedWriter.newLine();
			if(str.equals("end")){
				break;
			}
				
		}
		bufferedReader.close();
		streamReader.close();
		
		bufferedWriter.close();
		streamWriter.close();
		out.close();
		
		
		
	} 
	public static void main(String args[]) throws IOException{
		writeBySystemInToFile("D:/IOException5_test", "test.txt");
	}
	
		
		

}
