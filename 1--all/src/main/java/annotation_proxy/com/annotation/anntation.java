package annotation_proxy.com.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//����  һ���Զ���ע��    
@Retention(RetentionPolicy.RUNTIME)//�����÷�����ע������  ����
public @interface anntation {//ע�� ���� �Ƿ��� �ӿ� ���ε�
	String name();    //���� �� �޲����  ���쳣��
	String value();
	
}
