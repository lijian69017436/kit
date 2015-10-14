package se.se.innerClass;
/**
 * �Ǿ�̬��Ա�ڲ���ʵ��
 * */
public class OuterClass {
	 private String name;
	 private int age;
 

	//������
	public static void main(String agrgs[]){
		OuterClass outer=new OuterClass();
		outer.testOuter();
		
	}
	/**
	 * �Ǿ�̬��Ա�ڲ���
	 * */
	class InnerClass{
		private String name;
		private int age;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
		/*�ڲ����һ������*/
		public void printInnerMsg(String name,int age){
			System.out.println("�ڲ����еģ�"+name+":"+age);
			System.out.println("�ⲿ���еģ�"+OuterClass.this.getName()+":"+OuterClass.this.getAge());
		}
		
	}
	
	/**
	 * ͨ��˷�����ʵ������ڲ��������Ժͷ�����
	 * */
	public void testOuter(){
		OuterClass outerClass=new OuterClass();//ʵ���ⲿ�ࣻ
		outerClass.setName("����");
		outerClass.setAge(22);
		OuterClass.InnerClass  
		 	 inner=outerClass.new  InnerClass();//ʵ���ڲ��ࣻ
			 inner.setName("����");
			 inner.setAge(23);
			 inner.printInnerMsg(inner.getName(), inner.getAge());//�����ڲ����е�ĳ��������	
	}
	
	
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
