package jdkprotxy.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * proxy�������˼
 *
 */
public class JDKProxy implements InvocationHandler{
	/**
	 * @param proxy 
	 * 		Ŀ�����Ĵ�����ʵ�� �������Ķ��������
	 * @param method 
	 * 		ͨ��������õķ�����
	 * @param args 
	 * 		���÷��� ��Ҫ�Ĳ���
	 */
	private Object targetObject;//�����Ŀ����� --�����ʲô����
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println(2);
		System.out.println("������ ʵ�� "+proxy.getClass());
		System.out.println("�������� "+method.getName());
		System.out.println(3);
		if(args!=null&& args.length>0){
			for(int i=0;i<args.length;i++){
				System.out.println("������:"+args[i].toString());
			}
		}
		System.out.println(4);
		Object reObject=null;
		reObject =method.invoke(this.targetObject, args);
		System.out.println(5);
		return reObject;
	}
	
	public Object createProxyInstance(Object targetObject){
		this.targetObject=targetObject;
		System.out.println(1);
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), 
				targetObject.getClass().getInterfaces(), this);
	}				//���� ����  
}
