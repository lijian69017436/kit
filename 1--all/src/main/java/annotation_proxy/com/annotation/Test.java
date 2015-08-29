package annotation_proxy.com.annotation;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// �ж� ����û��  ָ���� ע��
		boolean falg =Demo.class.isAnnotationPresent(anntation.class);
		if(falg){
			System.out.println("��ע��");
			//�õ���ע�� 
			anntation a=Demo.class.getAnnotation(anntation.class);
			//��ȡע������
			System.out.println(">"+a.name());
			System.out.println(a.value());
			
			
		}
		//anntation a=	Demo.class.getAnnotation(anntation.class);
		
	}

}
