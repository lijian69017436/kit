package se.se.io_project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOExample2 {

  /**
   * 创建一个文件，向文件中写内容；
   * @param filePath 文件存储路径
   * @param filename 文件名
   * @param text写的内容；
   * @throws IOException
   */
  public static void writeTargetFileText(String filePath, String fileName, String text) throws IOException {

    boolean f = false;// 定义一个变量，标示存储路径是否存在；
    // 如果存储路径不存在，创建存储路径；
    File file = new File(filePath);// File类用于处理文件；
    if (!file.exists()) {// 判断该文件是否存在
      boolean flag = file.mkdirs();// 创建多层文件夹以(不能创建具体文件)

      if (flag) {
        System.out.println("文件存储路径创建成功！:" + filePath);
        f = true;
      } else{
        System.out.println("文件路径创建失败！");
      }
    } else{// 文件的存储路径存在了；
      f = true;
    }

    if (f) {
      // 创建指定路径下的文件；
      File fileTxt = new File(filePath + "/" + fileName);
      if (!fileTxt.exists()) {// 如果具体文件不存在
        fileTxt.createNewFile();// 创建该文件

      }
      FileWriter out = new FileWriter(fileTxt);// 将文件放入字符输出流；
      out.write(text);// 将字符串写入；
      out.close();// 关闭流
    }

  }

  /**
   * 指定一个文本文件，读取内容；
   * @throws IOException
   */

  public static String readTargetFileText(String filePath) throws IOException {// filePath包含具体文件名的了路径；
    File file = new File(filePath);
    if (!file.exists()) {
      System.out.println("要读取的文件不存在");
      return null;
    }
    // 文件放入输入流；
    FileReader reader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(reader);

    String str = "";
    while (bufferedReader.ready()){// 如果缓冲流准备就绪（流可以读取数据了）
      str = str + bufferedReader.readLine() + "\n";// 读取正行数据；
    }
    return str;
  }

  public static void main(String[] args) throws IOException {
    writeTargetFileText("D:/员工信息/事业部", "李四信息20140811.txt", "张三考勤信息：空");
    String str = readTargetFileText("D:/workspace/8.5Exception/src/com/cobhy/test/DateUtils.java");
    System.out.println(str);
  }

}
