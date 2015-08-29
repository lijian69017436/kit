package innerClass;
/**
 * 自定义内部接口 ，在创建接口对象 调用 
 *
 */
public class OuterClass3 {

	 
	public static void main(String[] args) {
		InnerDao dao=new InnerDao() {
			public void printMsg() {
				System.out.println("匿名内部类实现接口；");
				
			}
		};
		
		dao.printMsg();
	}
	
	
	//定义了一个内部接口；
	interface InnerDao{
		public void printMsg();
	}

}
