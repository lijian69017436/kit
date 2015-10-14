package se.se.socket;

import java.io.*;
import java.net.*;

public class TalkClient {
	public static void main(String args[]) throws Exception {

		Socket socket = new Socket("127.0.0.1", 4700);
		BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));//����̨������������
		
		PrintWriter os = new PrintWriter(socket.getOutputStream());//�������д��ݵ��������
		
		BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));//��ȡ����������������
		String readline;
		readline = sin.readLine();//�����Ժ��һ�ζ�ȡ��ݣ�
		while (!readline.equals("bye")) {
			os.println(readline);//�������д��ݣ�
			os.flush();//ˢ������
			System.out.println("Client��ȡServer:" + is.readLine());//����ӷ�������ȡ����ݣ�
			readline = sin.readLine();
		}
		os.close();
		is.close();
		socket.close();

	}
}