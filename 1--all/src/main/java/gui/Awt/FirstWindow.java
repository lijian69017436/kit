package gui.Awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FirstWindow {

	private  static TextField tf=null;
	
	public static void main(String[] args) {
		//创建窗体对象 
		final Frame frame=new Frame("第一个窗体");//创建一个窗体
		Button bt=new Button("按钮");//创建一个按钮
//		bt.addActionListener(new ActionListener() {//按钮 添加一个  监听器
//			private int count =0;
//			public void actionPerformed(ActionEvent e) {
//				frame.add(new Button("按钮"+count));//添加一个按钮
//				frame.validate();
//			}
//		});
		
		bt.addMouseListener(new MouseAdapter() {//鼠标事件监听
			public void mouseClicked(MouseEvent e) {
				System.out.println("单击++");
				System.out.println(tf.getText());
				
			}
		});
		
		bt.addKeyListener(new KeyAdapter() {//键盘事件监听  
			public void keyPressed(KeyEvent e){//如果 键盘输入 enter 退出
				if(e.getKeyCode()==e.VK_ENTER){
					System.exit(0);
				}
			}
		});
		
		tf=new TextField();//添加文本框
		tf.setColumns(40);
		
		frame.setLocation(300,399);//设置窗体在显示器的位置
		frame.setSize(300,300);//大小 
		
		frame.setLayout(new FlowLayout());//创建一个布局  设置默认布局
		frame.add(bt);//添加按钮
		frame.add(tf);
		
		frame.setVisible(true);//让窗体可见
	}
}

