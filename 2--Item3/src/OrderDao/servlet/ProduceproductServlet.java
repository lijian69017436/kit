package OrderDao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import OrderDao.factory.OrderDaoFactory;
import OrderDao.inter.ProduceproductDao;
import OrderDao.vo.ProduceproductVo;
import Tool.page;

public class ProduceproductServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private String url;
  private ProduceproductDao Instance=  OrderDaoFactory.getInstance().getProduceproductInstance();
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
      page.setCount(Instance.getCount());//����������
      page.setPageNow(pageNow);//���õ�ǰҳ
    }
    ////////////
    List<ProduceproductVo> list=Instance.getpagelist(page);
    HttpSession session =request.getSession();//���� ��ֵ������ session ;
    if(list.size()>0){
      session.setAttribute("page", page);
      session.setAttribute("getPaglist", list);
      url="order/produceproduct_list.jsp";
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
    List<ProduceproductVo> list= Instance.queryByIdOrNames(id ,names);
    HttpSession session =request.getSession();//���� ��ֵ������ session ;
    if(list.size()>0){
      session.setAttribute("getPaglist", list);
      url="order/produceproduct_list.jsp";
    }else{
      url="audit/error.jsp";
    }
    response.sendRedirect(url);
    return;
  }
  
  

  protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //System.out.println("insert");
    ProduceproductVo ex=new ProduceproductVo();
    
    ex.setOrderid(request.getParameter("orderid"));
    ex.setProductcode(request.getParameter("productcode"));
    ex.setProductname(request.getParameter("productname"));
    ex.setGuige(request.getParameter("guige"));
    ex.setColor(request.getParameter("color"));
    ex.setTotals(request.getParameter("totals"));
    ex.setUnit(request.getParameter("unit"));
    ex.setMoneytype(request.getParameter("moneytype"));
    ex.setSuttle(request.getParameter("suttle"));
    ex.setDiscount(request.getParameter("discount"));
    ex.setPrice(request.getParameter("price"));
    ex.setMoney(request.getParameter("money"));
    ex.setFullmoney(request.getParameter("fullmoney"));
    ex.setSizes(request.getParameter("sizes"));
    if(ex!=null){
      Instance.insert(ex);
    }
  }
  
  protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //System.out.println("insert");
    ProduceproductVo ex=new ProduceproductVo();
    ex.setId(Integer.parseInt(request.getParameter("id11")));
    ex.setOrderid(request.getParameter("orderid"));
    ex.setProductcode(request.getParameter("productcode"));
    ex.setProductname(request.getParameter("productname"));
    ex.setGuige(request.getParameter("guige"));
    ex.setColor(request.getParameter("color"));
    ex.setTotals(request.getParameter("totals"));
    ex.setUnit(request.getParameter("unit"));
    ex.setMoneytype(request.getParameter("moneytype"));
    ex.setSuttle(request.getParameter("suttle"));
    ex.setDiscount(request.getParameter("discount"));
    ex.setPrice(request.getParameter("price"));
    ex.setMoney(request.getParameter("money"));
    ex.setFullmoney(request.getParameter("fullmoney"));
    ex.setSizes(request.getParameter("sizes"));
    if(ex!=null){
      Instance.update(ex);
    }
  }
  
  protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id=Integer.parseInt(request.getParameter("id"));
    Instance.delete(id);
  }
  
  protected void selectById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // System.out.println("export �� ��ѯ");
    int id=Integer.parseInt(request.getParameter("id"));
    ProduceproductVo ex= Instance.selectById(id);
    HttpSession session=request.getSession();
    session.setAttribute("ex", ex);
    response.sendRedirect("order/produceproduct_modify.jsp");
    return;
  }


}
