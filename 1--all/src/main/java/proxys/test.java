package proxys;


public class test {

	
	public static void main(String[] args) {
		
		Hello hello=ProxyHandler.proxy();
		//这里无论访问哪个方法，都是会把请求转发到handler.invoke  
		
		hello.print("All the test");
		hello.sayHello("Denny");
	}
}
