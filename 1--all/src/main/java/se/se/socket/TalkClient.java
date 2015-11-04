package se.se.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TalkClient {
  public static void main(String args[]) throws Exception {

    Socket socket = new Socket("127.0.0.1", 4700);
    BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));

    PrintWriter os = new PrintWriter(socket.getOutputStream());

    BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    String readline;
    readline = sin.readLine();
    while (!readline.equals("bye")){
      os.println(readline);
      os.flush();
      System.out.println("Client---Server:" + is.readLine());
      readline = sin.readLine();
    }
    os.close();
    is.close();
    socket.close();

  }
}