package socket;

import java.io.*;
import java.net.*;

public class TalkClient {
	public static void main(String args[]) throws Exception {

		Socket socket = new Socket("127.0.0.1", 4700);
		BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));//控制台输入的数据流；
		
		PrintWriter os = new PrintWriter(socket.getOutputStream());//向服务器写数据的输出流；
		
		BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));//读取服务器的输入流；
		String readline;
		readline = sin.readLine();//进来以后第一次读取数据；
		while (!readline.equals("bye")) {
			os.println(readline);//向服务器写数据；
			os.flush();//刷新流；
			System.out.println("Client读取Server:" + is.readLine());//输出从服务器读取的数据；
			readline = sin.readLine();
		}
		os.close();
		is.close();
		socket.close();

	}
}