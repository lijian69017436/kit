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
		//System.out.println("过滤器 的 --——销毁方法，服务器重启，关闭时运行的方法");
	}
	//过滤方法
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");//显示数据的类型：文本，html 字符编码集
		//运行通过的方法
		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("过滤器的 ----文件初始化--项目被服务器加载的时候启动");
	}

}
