package se.se.annotation_proxy.com.annotation_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy_Handler implements InvocationHandler {//
	private Object iml;
	private User u;
	public Proxy_Handler(Object iml,User u){ 
		this.iml=iml;
		this.u=u;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
		throws Throwable {
		Object o=null;
		boolean flag=false;
		
		String  mname=method.getName();
		
		Class[] parames=method.getParameterTypes();
		
		Method met=iml.getClass().getMethod(mname, parames);
		
		System.out.println("="+met);
		if(met.isAnnotationPresent(Limit.class)){
				Limit lt=met.getAnnotation(Limit.class);
				String [] limit=  lt.limit().split(",");
				for(int i=0; i<limit.length; i++){
						if(limit[i].equals(u.getRole())){
								 o=method.invoke(iml, args); 
								 flag=true;
								 break;
						}
				}																							
				if(!flag){
					System.out.println(""+met);
				}
		}else{
			System.out.println("");
		}
		return o;
	}
}
