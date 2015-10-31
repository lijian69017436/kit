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
    Reader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

    int j = 0;
    while ((j = bufferedReader.read()) != -1){
      System.out.println(j);
    }

    while (true){
      String str = bufferedReader.readLine();
      System.out.println(str);
      if (str.equals("bye")) {//
        break;
      }
    }
    bufferedReader.close();
    inputStreamReader.close();

  }

}
