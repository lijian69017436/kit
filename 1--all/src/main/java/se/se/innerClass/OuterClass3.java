package se.se.innerClass;
/**
 * �Զ����ڲ��ӿ� ���ڴ����ӿڶ��� ���� 
 *
 */
public class OuterClass3 {

	 
	public static void main(String[] args) {
		InnerDao dao=new InnerDao() {
			public void printMsg() {
				System.out.println("�����ڲ���ʵ�ֽӿڣ�");
				
			}
		};
		
		dao.printMsg();
	}
	
	
	//������һ���ڲ��ӿڣ�
	interface InnerDao{
		public void printMsg();
	}

}
