package se.se.socket;
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
    InputStream inputStream = socket.getInputStream();
    Reader reader = new InputStreamReader(inputStream);
    BufferedReader bufferedReader = new BufferedReader(reader);

    OutputStream outputStream = socket.getOutputStream();
    PrintWriter writer = new PrintWriter(outputStream);
    // BufferedWriter bufferedWriter=new BufferedWriter(writer);
    String getClientMsg = "";
    do{

      if (bufferedReader.ready()){

        getClientMsg = bufferedReader.readLine();

        System.out.println("==" + getClientMsg);
        writer.print("hello client");
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

