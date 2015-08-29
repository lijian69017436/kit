package socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String args[]) throws IOException {
    ServerSocket serverSocket = new ServerSocket(8080);
    Socket socket = serverSocket.accept();
    InputStream inputStream = socket.getInputStream();// 通过inputSteam读取客户端数据；
    Reader reader = new InputStreamReader(inputStream);
    BufferedReader bufferedReader = new BufferedReader(reader);

    OutputStream outputStream = socket.getOutputStream();// 向客户端法综数据；
    PrintWriter writer = new PrintWriter(outputStream);
    // BufferedWriter bufferedWriter=new BufferedWriter(writer);
    String getClientMsg = "";
    do{

      if (bufferedReader.ready()){

        getClientMsg = bufferedReader.readLine();// 读取客户端数据；

        System.out.println("服务器接收客户端数据为：" + getClientMsg);
        writer.print("hello client");// 往客户端写数据；
        writer.flush();

      }
    } while (!getClientMsg.equals("admin"));

    writer.close();
    outputStream.close();

    bufferedReader.close();
    reader.close();
    inputStream.close();
    socket.close();
    serverSocket.close();

  }
}
