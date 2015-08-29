package OrderDao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import OrderDao.factory.OrderDaoFactory;
import OrderDao.inter.ExportClientDao;
import OrderDao.vo.ExportClientVo;
import Tool.page;

public class ExportClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url;
  private ExportClientDao exportclient=  OrderDaoFactory.getInstance().getExportClientInstance();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String action =request.getParameter("action");
	  if("delete".equals(action)){      //ɾ��
	    this.delete(request, response);
	  }else if("insert".equals(action)){//���
	    this.insert(request, response);
	  }else if("getPagelist".equals(action)){//��ѯ ��ҳ
	    this.getPagelist(request, response);
	  }else if("update".equals(action)){//����
	    this.update(request, response);
	  }else if("selectById".equals(action)){//����id��ѯ 
      this.selectById(request, response);
    }else if("query".equals(action)){
      this.query(request, response);
    }
	  
	  
	}
	
	public  void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  int id=0;
	  if(request.getParameter("id1s")!=null&&request.getParameter("id1s")!=""){
	    id=new Integer(request.getParameter("id1s").trim());
	  }
    String names=request.getParameter("names");
    List<ExportClientVo> list= exportclient.queryByIdOrNames(id ,names);
    HttpSession session =request.getSession();//���� ��ֵ������ session ;
    if(list.size()>0){
      session.setAttribute("getPaglist", list);
      url="order/exportclient_list.jsp";
    }else{
      url="audit/error.jsp";
      
    }
    response.sendRedirect(url);
    return;
  }
	
	
	protected void getPagelist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //System.out.println("��ҳ");
    page page=new page();
    if(request.getParameter("pageNow")!=null){//��������� ���� pagenow���
      int pageNow=Integer.parseInt(request.getParameter("pageNow"));
      if(pageNow==0){
        pageNow=1;
      }
      page.setCount(exportclient.getCount());//����������
      page.setPageNow(pageNow);//���õ�ǰҳ
    }
    List<ExportClientVo> list=exportclient.getpagelist(page);
    HttpSession session =request.getSession();//���� ��ֵ������ session ;
    if(list.size()>0){
      session.setAttribute("page", page);
      session.setAttribute("getPaglist", list);
      url="order/exportclient_list.jsp";
    }else{
      url="audit/error.jsp";
    }
    response.sendRedirect(url);
    return;
  }

	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  //System.out.println("insert");
	  ExportClientVo ex=new ExportClientVo();
	  ex.setId(Integer.parseInt(request.getParameter("id")));
	  ex.setLinkman(request.getParameter("linkman"));
	  ex.setNames(request.getParameter("names"));
	  ex.setClientnumber(request.getParameter("clientnumber"));
	  ex.setClientaddress(request.getParameter("clientaddress"));
	  ex.setDates(request.getParameter("dates"));
	  ex.setFax(request.getParameter("fax"));
	  ex.setTel(request.getParameter("tel"));
	  ex.setSales(request.getParameter("sales"));
	  if(ex!=null){
	    exportclient.insert(ex);
	  }
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //System.out.println("insert");
    ExportClientVo ex=new ExportClientVo();
    ex.setId(Integer.parseInt(request.getParameter("id")));
    ex.setLinkman(request.getParameter("linkman"));
    ex.setNames(request.getParameter("names"));
    ex.setClientnumber(request.getParameter("clientnumber"));
    ex.setClientaddress(request.getParameter("clientaddress"));
    ex.setDates(request.getParameter("dates"));
    ex.setFax(request.getParameter("fax"));
    ex.setTel(request.getParameter("tel"));
    ex.setSales(request.getParameter("sales"));
    if(ex!=null){
      exportclient.update(ex);
    }
  }
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  int id=Integer.parseInt(request.getParameter("id"));
	  exportclient.delete(id);
	}
	
	protected void selectById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// System.out.println("export �� ��ѯ");
	  int id=Integer.parseInt(request.getParameter("id"));
	  ExportClientVo ex= exportclient.selectById(id);
	  HttpSession session=request.getSession();
	  session.setAttribute("ex", ex);
	  //System.out.println("111");
	  response.sendRedirect("order/exportclient_modify.jsp");
	  return;
	}

}
