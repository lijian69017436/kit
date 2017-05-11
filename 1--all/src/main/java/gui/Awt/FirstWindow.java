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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

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
				 JFrame frame1=new JFrame("第二个窗体");
					frame1.setBounds(100,100,1800,900);
					frame1.setLayout(new FlowLayout());//创建一个布局  设置默认布局
					frame1.setVisible(true);//让窗体可见
					frame1.setAlwaysOnTop(true);
					
			}
		});
		
		
		tf=new TextField();//添加文本框
		tf.setColumns(40);
		tf.addKeyListener(new KeyAdapter() {//键盘事件监听  
			public void keyPressed(KeyEvent e){//如果 键盘输入 enter 打印文本框内容
				if(e.getKeyCode()==e.VK_ENTER){
//					System.exit(0);
					System.out.println(tf.getText());
				}
			}
		});
		
		
		frame.setLocation(300,399);//设置窗体在显示器的位置
		frame.setSize(400,200);//大小 
		
		frame.setLayout(new FlowLayout());//创建一个布局  设置默认布局
		frame.add(bt);//添加按钮
		frame.add(tf);
		frame.add(new JLabel("显示文字"));
		
		frame.addWindowListener(new WindowAdapter(){ // 为了关闭窗口
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);//让窗体可见
	}
}

