package annotation_proxy.com.annotation_proxy;

import java.lang.reflect.Proxy;

  public class MethdDaoProxy {
    public static  MthedDao proxy(User u){//���� ����
      MthedDao impl=new MthedDaoImpl();
      Proxy_Handler handler= new Proxy_Handler(impl,u);
      
      
      MthedDao d=(MthedDao)Proxy.newProxyInstance( //��������ʵ��
                impl.getClass().getClassLoader(),   //���������
                impl.getClass().getInterfaces(),  //�õ� �����Ľӿ�
                handler);  // �Զ����  ������ 
      return d;
    }
  
}
