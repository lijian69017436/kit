package design.design.strategy;

import javax.swing.JFrame;

public class Market { //策略模式   商场 收银软件

  public static void main(String[] args) {
    Window win =new Window();
    win.setVisible(true);
}
}

class Window extends JFrame{//创建一个窗口
  private static final long serialVersionUID = 1L;

  public Window(){
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(600,480);
  }
 
}