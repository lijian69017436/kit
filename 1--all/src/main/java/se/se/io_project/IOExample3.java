package se.se.io_project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOExample3 {

	public static void main(String[] args) throws IOException {
		   File file=new File("D:/test.txt");
		   FileOutputStream  fileOutputStream= new FileOutputStream(file);
		   fileOutputStream.write(99);
		   fileOutputStream.close();
		   

	}

}
