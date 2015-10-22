package design.design.proxys.dynamicProxys;


/*
 */
public class HelloImpl implements Hello{

	
	public void sayHello(String to) {
		System.out.println("helloImpl:"+to);
	}

	
	public void print(String p) {
		System.out.println("helloImpl:"+p);
	}

	

}
