package Tool;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter implements javax.servlet.Filter {
  public Filter() {
  }
	public void destroy() {
		//System.out.println("������ �� --�������ٷ������������������ر�ʱ���еķ���");
	}
	//���˷���
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");//��ʾ���ݵ����ͣ��ı���html �ַ����뼯
		//����ͨ���ķ���
		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("�������� ----�ļ���ʼ��--��Ŀ�����������ص�ʱ������");
	}

}
