package RepertoryDao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import RepertoryDao.factory.RepertoryDaoFactory;
import RepertoryDao.inter.PaymentincaseDao;
import RepertoryDao.vo.PaymentincaseVo;
import Tool.page;

public class PaymentincaseServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private String url;
  private PaymentincaseDao Instance=  RepertoryDaoFactory.getInstance().getpaymentincaseInstance();
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action =request.getParameter("action");
    if("delete".equals(action)){      //删除
      this.delete(request, response);
    }else if("insert".equals(action)){//添加
      this.insert(request, response);
    }else if("getPagelist".equals(action)){//查询 分页
      this.getPagelist(request, response);
    }else if("update".equals(action)){//更新
      this.update(request, response);
    }else if("selectById".equals(action)){//根据id查询 
      this.selectById(request, response);
    }else if("query".equals(action)){
      this.query(request, response);
    }
    
    
  }
  protected void getPagelist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //System.out.println("分页");
    page page=new page();
    if(request.getParameter("pageNow")!=null){//如果有数据 存入 pagenow里边
      int pageNow=Integer.parseInt(request.getParameter("pageNow"));
      if(pageNow==0){
        pageNow=1;
      }
      page.setCount(Instance.getCount());//设置总条数
      page.setPageNow(pageNow);//设置当前页
    }
    ////////////
    List<PaymentincaseVo> list=Instance.getpagelist(page);
    HttpSession session =request.getSession();//创建 传值作用域 session ;
    if(list.size()>0){
      session.setAttribute("page", page);
      session.setAttribute("getPaglist", list);
      url="finance/paymentincase_list.jsp";
    }else{
      url="audit/error.jsp";
    }
    response.sendRedirect(url);
    return;
  }
  
  
  
  public  void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id=0;
  //  if(request.getParameter("id1111")!=null&&request.getParameter("id1111")!=""){
    //  id=new Integer(request.getParameter("id1111").trim());
    //}
    String names=null;
    if(request.getParameter("plid")!=""){
      names=request.getParameter("plid");
    }
    List<PaymentincaseVo> list= Instance.queryByIdOrNames(id ,names);
    HttpSession session =request.getSession();//创建 传值作用域 session ;
    if(list.size()>0){
      session.setAttribute("getPaglist", list);
      url="finance/paymentincase_list.jsp";
    }else{
      url="audit/error.jsp";
    }
    response.sendRedirect(url);
    return;
  }
  
  

  protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //System.out.println("insert");
    PaymentincaseVo ex=new PaymentincaseVo();
    
    ex.setPlid(request.getParameter("plid"));
    ex.setCompanycode(request.getParameter("companycode"));
    ex.setClientcode(request.getParameter("clientcode"));
    ex.setNumbers(request.getParameter("numbers"));
    ex.setSuttle(request.getParameter("suttle"));
    ex.setGrossweight(request.getParameter("grossweight"));
    ex.setSizes(request.getParameter("sizes"));
    ex.setDocumentname(request.getParameter("documentname"));
    ex.setChecks(request.getParameter("checks"));
    ex.setTimes(request.getParameter("times"));
    ex.setGetid(request.getParameter("getid"));
    if(ex!=null){
      Instance.insert(ex);
    }
  }
  
  protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //System.out.println("insert");
    PaymentincaseVo ex=new PaymentincaseVo();
    if(ex!=null){
      Instance.update(ex);
    }
  }
  
  protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int id=Integer.parseInt(request.getParameter("id"));
    Instance.delete(id);
  }
  
  protected void selectById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // System.out.println("export 的 查询");
    int id=Integer.parseInt(request.getParameter("id"));
    PaymentincaseVo ex= Instance.selectById(id);
    HttpSession session=request.getSession();
    session.setAttribute("ex", ex);
    response.sendRedirect("order/produceproduct_modify.jsp");
    return;
  }


}
