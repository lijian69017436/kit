package gui.Awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import se.se.domPa_resXML.test.AddPersonTest;

public class Frame { //策略模式   商场 收银软件

  public static void main(String[] args) {
    Window win =new Window();
    win.setVisible(true);
}
}

class Window extends JFrame{//创建一个窗口
  private static final long serialVersionUID = 1L;
  TextField tf=null;  //文本框
  TextField tf1=null;  //文本框
  Button bt=null;   //按钮
  TextArea textArea=null;
  StringBuffer str=null;
  public Window(){
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(600,480);
      setLocation(300,399);//设置窗体在显示器的位置
      setLayout(new FlowLayout());//创建一个布局  设置默认布局
      str=new StringBuffer();
      
      textArea = new TextArea();
      bt=new Button();//创建一个按钮
      bt.setLabel("按钮");
      bt.addMouseListener(new MouseAdapter() {//鼠标事件监听
        public void mouseClicked(MouseEvent e) {
          str.append(tf.getText()+"\r\n");
          textArea.setText(str.toString());
        }
      });
      bt.addKeyListener(new KeyAdapter() {//键盘事件监听  
        public void keyPressed(KeyEvent e){//如果 键盘输入 enter 退出
          if(e.getKeyCode()==e.VK_ENTER){
            System.exit(0);
          }
        }
      });
      
      tf= new TextField();//添加文本框
      tf.setColumns(20);
      tf1= new TextField();//添加文本框
      tf1.setColumns(5);
      
      add(tf);
      add("数量",tf1);
      add(bt);//添加按钮
      add(textArea);
  }
 
}