package socket;

import java.io.*;
import java.net.*;

public class TalkServer {
	public static void main(String args[]) throws Exception {

		ServerSocket server = null;

		server = new ServerSocket(4700);

		Socket socket = server.accept();

		String readline;
		BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		PrintWriter os = new PrintWriter(socket.getOutputStream());//通过PrintWriter 将数据向客户端写数据；
		BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));//控制台输入数据
		System.out.println("服务端读取客户端的数据为：:" + is.readLine());
		readline = sin.readLine();//读取控制台输入的数据；
		 
		while (!readline.equals("bye")) {//如果控制台输入的数据不是bye
			os.println(readline);//将控制台写的数据， 向客户端写；
			os.flush();//刷新流；
			System.out.println("服务器读取客户端数据:" + is.readLine());//读取客户端输入流数据；
			readline = sin.readLine();//读取控制台数据赋给字符串；
		}
		os.close();
		is.close();
		socket.close();
		server.close();

	}
}