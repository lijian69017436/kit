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
				System.out.println(tf.getText());
				
			}
		});
		
		bt.addKeyListener(new KeyAdapter() {//�����¼�����  
			public void keyPressed(KeyEvent e){//��� �������� enter �˳�
				if(e.getKeyCode()==e.VK_ENTER){
					System.exit(0);
				}
			}
		});
		
		tf=new TextField();//����ı���
		tf.setColumns(40);
		
		frame.setLocation(300,399);//���ô�������ʾ����λ��
		frame.setSize(300,300);//��С 
		
		frame.setLayout(new FlowLayout());//����һ������  ����Ĭ�ϲ���
		frame.add(bt);//��Ӱ�ť
		frame.add(tf);
		
		frame.setVisible(true);//�ô���ɼ�
	}
}

