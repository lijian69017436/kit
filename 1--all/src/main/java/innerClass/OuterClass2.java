package innerClass;

/**
 * 局部内部类： 在 方法里边创建 内部类  在调用内部类 
 *  	在 方法外调用方法
 * */
public class OuterClass2 {
	 
	 public void printTest( String name2,int age2){
		 final String i="admin";
		 class InnerClass2{ //在方法里边创建内部类 
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
				System.out.println(i);//可以访问到当前方法的常量 final 常量，其他参数，和内部类所在的方法中属性方法等依然访问不到；
				//System.out.println(this.name+":"+this.age);
			}		
		 }
		 //调用 本方法的内部类  
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
