package se.se.annotation_proxy.com.annotation;

public class Test {

	/**
	 * @param args
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
	  //是否 有注解  
		boolean falg =Demo.class.isAnnotationPresent(anntation.class);
		if(falg){//如果有  
			System.out.println(">>");
			anntation a=Demo.class.getAnnotation(anntation.class);
			System.out.println(">"+a.name());
			System.out.println(a.value());
		}
		//anntation a=	Demo.class.getAnnotation(anntation.class);
		
	}

}
