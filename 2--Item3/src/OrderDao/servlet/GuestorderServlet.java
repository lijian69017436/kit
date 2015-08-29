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
import OrderDao.inter.GuestorderDao;
import OrderDao.vo.ExportClientVo;
import OrderDao.vo.GuestorderVo;
import Tool.page;

/**
 * Servlet implementation class GuestorderServlet
 */
public class GuestorderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  private String url;
  private GuestorderDao guestorder=  OrderDaoFactory.getInstance().getGuestorderInstance();
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
  protected void getPagelist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //System.out.println("��ҳ");
    page page=new page();
    if(request.getParameter("pageNow")!=null){//��������� ���� pagenow���
      int pageNow=Integer.parseInt(request.getParameter("pageNow"));
      if(pageNow==0){
        pageNow=1;
      }
      page.setCount(guestorder.getCount());//����������
      page.setPageNow(pageNow);//���õ�ǰҳ
    }
    ////////////
    List<GuestorderVo> list=guestorder.getpagelist(page);
    HttpSession session =request.getSession();//���� ��ֵ������ session ;
    if(list.size()>0){
      session.setAttribute("page", page);
      session.setAttribute("getPaglist", list);
      url="order/guestorder_list.jsp";
    }else{
      url="audit/error.jsp";
    }
    response.sendRedirect(url);
    return;
  }

  
  
  
  
  
  
  
  
  public  void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id=0;
    if(request.getParameter("id1111")!=null&&request.getParameter("id1111")!=""){
      id=new Integer(request.getParameter("id1111").trim());
    }
    String names=request.getParameter("address");
    List<GuestorderVo> list= guestorder.queryByIdOrNames(id ,names);
    HttpSession session =request.getSession();//���� ��ֵ������ session ;
    if(list.size()>0){
      session.setAttribute("getPaglist", list);
      url="order/guestorder_list.jsp";
    }else{
      url="audit/error.jsp";
    }
    response.sendRedirect(url);
    return;
  }
  
  

  protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //System.out.println("insert");
    GuestorderVo ex=new GuestorderVo();
    ex.setId(Integer.parseInt(request.getParameter("id11")));
    ex.setGuestcode(request.getParameter("guestcode"));
    ex.setAddress(request.getParameter("address"));
    ex.setTimes(request.getParameter("times"));
    ex.setFroms(request.getParameter("froms"));
    ex.setTel(request.getParameter("tel"));
    ex.setFax(request.getParameter("fax"));
    ex.setLinkman(request.getParameter("linkman"));
    if(ex!=null){
      guestorder.insert(ex);
    }
  }
  
  protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //System.out.println("insert");
    GuestorderVo ex=new GuestorderVo();
    ex.setId(Integer.parseInt(request.getParameter("id11")));
    ex.setGuestcode(request.getParameter("guestcode"));
    ex.setAddress(request.getParameter("address"));
    ex.setTimes(request.getParameter("times"));
    ex.setFroms(request.getParameter("froms"));
    ex.setTel(request.getParameter("tel"));
    ex.setFax(request.getParameter("fax"));
    ex.setLinkman(request.getParameter("linkman"));
    if(ex!=null){
      guestorder.update(ex);
    }
  }
  
  protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id=Integer.parseInt(request.getParameter("id"));
    guestorder.delete(id);
  }
  
  protected void selectById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // System.out.println("export �� ��ѯ");
    int id=Integer.parseInt(request.getParameter("id"));
    GuestorderVo ex= guestorder.selectById(id);
    HttpSession session=request.getSession();
    session.setAttribute("ex", ex);
    response.sendRedirect("order/guestorder_modify.jsp");
    return;
  }


}
