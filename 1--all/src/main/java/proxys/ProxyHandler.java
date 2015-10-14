package proxys;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/*  动态代理 
 * 
 *  生成与代理类相关联的InvocationHandler对象 
 */
public class ProxyHandler implements InvocationHandler {
	
	//保存 真实 实现类
	private Object dele;
	
	public ProxyHandler(Object obj){
	  this.dele=obj;
	}
	/**
	 * proxy   目标对象的代理类实例
	 * method	对应在代理实例上调用接口方法的 method实例
	 * args		传入到代理实例上方法参数值的对象数组 
	 * return 	方法的返回值  没有返回值 时是null
	 * 
	 * @具体的代理层  的 处理程序 
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		
		//在这里完全可以  做一些其它的事情  
		
		//身份验证   ...等等
		
		quanxian();//权限满足 继续 下一步
		//转发
		Object result = method.invoke(dele, args);
		
		return result;
	}
	
	public  void quanxian(){
		System.out.println("权限 ——》》");
	}
	
}

