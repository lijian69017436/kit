package se.se.io_project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class IOExample1 {

	/**
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		 Reader inputStreamReader=new InputStreamReader(System.in);//������̨����������ӵ��ַ�������?
		 BufferedReader bufferedReader=new BufferedReader(inputStreamReader);//��ӻ�������?
		 /*int j=0;//����洢�ֽڵı���?
		 while( (j=bufferedReader.read())!=-1){//read������ȡ�ֽڣ�����ֵΪ-1 ˵���Ѿ���������ĩβ���Ѿ������л�ȡ����ݣ�?
			   System.out.println(j);//�����ݴ��������ֽڣ�
			  
		 }*/
		 while(true){
			 String str=bufferedReader.readLine();//���ж�ȡ�ַ��������ݣ�
			   System.out.println(str);
			   if(str.equals("bye")){//�������bye�˳����룻
				   break;   
			   }
		 }
		
		 bufferedReader.close();//�رջ�������
		 inputStreamReader.close();//�ر��ַ���������
		
       
	}

}
