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
		//����������� 
		final Frame frame=new Frame("��һ������");//����һ������
		Button bt=new Button("��ť");//����һ����ť
//		bt.addActionListener(new ActionListener() {//��ť ���һ��  ������
//			private int count =0;
//			public void actionPerformed(ActionEvent e) {
//				frame.add(new Button("��ť"+count));//���һ����ť
//				frame.validate();
//			}
//		});
		
		bt.addMouseListener(new MouseAdapter() {//����¼�����
			public void mouseClicked(MouseEvent e) {
				System.out.println("����++");
				 JFrame frame1=new JFrame("�ڶ�������");
					frame1.setBounds(100,100,1800,900);
					frame1.setLayout(new FlowLayout());//����һ������  ����Ĭ�ϲ���
					frame1.setVisible(true);//�ô���ɼ�
					frame1.setAlwaysOnTop(true);
					
			}
		});
		
		
		tf=new TextField();//����ı���
		tf.setColumns(40);
		tf.addKeyListener(new KeyAdapter() {//�����¼�����  
			public void keyPressed(KeyEvent e){//��� �������� enter ��ӡ�ı�������
				if(e.getKeyCode()==e.VK_ENTER){
//					System.exit(0);
					System.out.println(tf.getText());
				}
			}
		});
		
		
		frame.setLocation(300,399);//���ô�������ʾ����λ��
		frame.setSize(400,200);//��С 
		
		frame.setLayout(new FlowLayout());//����һ������  ����Ĭ�ϲ���
		frame.add(bt);//��Ӱ�ť
		frame.add(tf);
		frame.add(new JLabel("��ʾ����"));
		
		frame.addWindowListener(new WindowAdapter(){ // Ϊ�˹رմ���
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);//�ô���ɼ�
	}
}

