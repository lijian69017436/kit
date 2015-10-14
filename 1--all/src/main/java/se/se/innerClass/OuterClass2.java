package se.se.innerClass;

/**
 * �ֲ��ڲ��ࣺ �� ������ߴ��� �ڲ���  �ڵ����ڲ��� 
 *  	�� ��������÷���
 * */
public class OuterClass2 {
	 
	 public void printTest( String name2,int age2){
		 final String i="admin";
		 class InnerClass2{ //�ڷ�����ߴ����ڲ��� 
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
			public void printInner(){ 
				System.out.println(i);//���Է��ʵ���ǰ�����ĳ��� final ���������������ڲ������ڵķ��������Է�������Ȼ���ʲ�����
				//System.out.println(this.name+":"+this.age);
			}		
		 }
		 //���� ���������ڲ���  
		 InnerClass2 inner=new InnerClass2();
         inner.setName(name2);
         inner.setAge(age2);
         inner.printInner();
         System.out.println(inner.getName()+":"+inner.getAge());
		 
		 
	 }
	 
	public static void main(String[] args) {
		OuterClass2 outer=new OuterClass2();
		outer.printTest("111", 222);
		 
		

	}

	

}
