package se.se.socket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
  public static void main(String args[]) throws UnknownHostException, IOException{
	  Socket socket=new Socket("127.0.0.1",8080);
	  InputStream inputStream=socket.getInputStream();
	  InputStreamReader reader=new InputStreamReader(inputStream);
	  BufferedReader bufferedReader=new BufferedReader(reader);//��ȡ��������
	  
	  OutputStream outputStream=socket.getOutputStream();//��������˷�����ݣ�
	   PrintWriter writer=new PrintWriter(outputStream);
	   //BufferedWriter bufferedWriter=new BufferedWriter(writer);
	  
	   writer.println("admin");
	    
	   while(bufferedReader.ready()){
		   String serverStr=bufferedReader.readLine();
		   System.out.println("�ͻ��˶�ȡ��������Ϊ��"+serverStr);
		   if("hello client".equals(serverStr)){
			   break;
		   }  
	   }
	   //bufferedWriter.close();
	   writer.close();
	   outputStream.close();
	   
	   bufferedReader.close();
	   reader.close();
	   inputStream.close();
	   socket.close();
	   
  }
}
