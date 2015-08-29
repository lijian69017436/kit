package innerClass;
/**
 * 非静态成员内部类实例
 * */
public class OuterClass {
	 private String name;
	 private int age;
 

	//主函数
	public static void main(String agrgs[]){
		OuterClass outer=new OuterClass();
		outer.testOuter();
		
	}
	/**
	 * 非静态成员内部类
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
		
		/*内部类的一个方法*/
		public void printInnerMsg(String name,int age){
			System.out.println("内部类中的："+name+":"+age);
			System.out.println("外部类中的："+OuterClass.this.getName()+":"+OuterClass.this.getAge());
		}
		
	}
	
	/**
	 * 通过此方法，实例化并调用内部类中属性和方法；
	 * */
	public void testOuter(){
		OuterClass outerClass=new OuterClass();//实例化外部类；
		outerClass.setName("王二");
		outerClass.setAge(22);
		OuterClass.InnerClass  
		 	 inner=outerClass.new  InnerClass();//实例化内部类；
			 inner.setName("张三");
			 inner.setAge(23);
			 inner.printInnerMsg(inner.getName(), inner.getAge());//调用内部类中的某个方法；	
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
