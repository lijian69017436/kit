package proxys;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/*
 * 生成与代理类相关联的InvocationHandler对象 
 */
public class ProxyHandler implements InvocationHandler {
	
	//保存 真实 实现类
	private Object dele;
	
	public ProxyHandler(Object obj){
		this.dele = obj;
	}
	/**
	 * proxy   目标对象的代理类实例
	 * method	对应在代理实例上调用接口方法的 method实例
	 * args		传入到代理实例上方法参数值的对象数组 
	 * return 	方法的返回值  没有返回值 时是null
	 */
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
	
		
		//在这里完全可以把下面这句注释掉，而做一些其它的事情  
		
		//身份验证
		
		quanxian();//权限满足 继续 下一步
		//转发
		Object result = method.invoke(dele, args);
		
		return result;
	}
	public static void quanxian(){
		System.out.println("权限 ——》》");
	}
	
	
	public static Hello proxy(){//代理 方法

		//实例化 真实的 实现类
		Hello impl = new HelloImpl();
		
		//生成相关联的类
		ProxyHandler handler = new ProxyHandler(impl);
		/**
		 * loader    定义代理类的 加载器
		 * interfaces  代理类 要实现 的接口列表
		 * h   指派方法调用的 调用处理程序
		 */
		//生成代理类，并将handler关联在一起。
		Hello hello = (Hello)Proxy.newProxyInstance(impl.getClass().getClassLoader(),
				                                    impl.getClass().getInterfaces(), 
				                                    handler);
		
		return hello;
	}
}
