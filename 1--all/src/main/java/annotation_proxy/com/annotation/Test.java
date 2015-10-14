package annotation_proxy.com.annotation;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean falg =Demo.class.isAnnotationPresent(anntation.class);
		if(falg){
			System.out.println(">>");
			anntation a=Demo.class.getAnnotation(anntation.class);
			System.out.println(">"+a.name());
			System.out.println(a.value());
			
		}
		//anntation a=	Demo.class.getAnnotation(anntation.class);
		
	}

}
