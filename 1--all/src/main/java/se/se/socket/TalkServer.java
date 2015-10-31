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

    PrintWriter os = new PrintWriter(socket.getOutputStream());
    BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("--:" + is.readLine());
    readline = sin.readLine();

    while (!readline.equals("bye")){
      os.println(readline);
      os.flush();
      System.out.println("==:" + is.readLine());
      readline = sin.readLine();
    }
    os.close();
    is.close();
    socket.close();
    server.close();

  }
}