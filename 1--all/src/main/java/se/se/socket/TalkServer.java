package se.se.socket;

import java.io.*;
import java.net.*;

public class TalkServer {
	public static void main(String args[]) throws Exception {

		ServerSocket server = null;

		server = new ServerSocket(4700);

		Socket socket = server.accept();

		String readline;
		BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		PrintWriter os = new PrintWriter(socket.getOutputStream());//ͨ��PrintWriter �������ͻ���д��ݣ�
		BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));//����̨�������
		System.out.println("����˶�ȡ�ͻ��˵����Ϊ��:" + is.readLine());
		readline = sin.readLine();//��ȡ����̨�������ݣ�
		 
		while (!readline.equals("bye")) {//������̨�������ݲ���bye
			os.println(readline);//������̨д����ݣ� ��ͻ���д��
			os.flush();//ˢ������
			System.out.println("��������ȡ�ͻ������:" + is.readLine());//��ȡ�ͻ�����������ݣ�
			readline = sin.readLine();//��ȡ����̨��ݸ����ַ�
		}
		os.close();
		is.close();
		socket.close();
		server.close();

	}
}