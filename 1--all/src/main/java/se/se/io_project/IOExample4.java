package se.se.io_project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class IOExample4 {

	/**
	 * 通过字节流，将字符串写入文件（不建议使用，我们一般用Writer）；
	 * @throws IOException 
	 * 
	 */
	public static void main(String[] args) throws IOException {
		 File file=new File("D:/test.txt");
         FileOutputStream stream=new FileOutputStream(file);
         ObjectOutputStream objStream=new ObjectOutputStream(stream);//对象流，开发不常用；
         objStream.writeBytes("admin");
         objStream.close();
		 
	}

}
