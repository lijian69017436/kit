package design.design.proxys.dynamicProxys;

import java.lang.reflect.Proxy;

public class test {

	
	public static void main(String[] args) {
	  Hello he = new HelloImpl();
    /**
     * 1,把对象加载到代理方法中去     
     * 2, 中间代理对象处理下     
     * 3, 然后返回代理对象 
     * 4, 然后强转成接口   
     * 5,代理对象  调用方法   
     */
    Hello hello = (Hello)Proxy.newProxyInstance(
        he.getClass().getClassLoader(),  //代理类加载器
        he.getClass().getInterfaces(),   //代理类实现的接口
        new ProxyHandler(he));           //代理类的 处理程序    
    //我代理的 一个产品   可以在这个产品上 加点 价格等等    自定义的内容
    //反正 买家接触不到  具体 的厂家  你也不知道
		hello.print("All the test");
		hello.sayHello("Denny");
	}
}
