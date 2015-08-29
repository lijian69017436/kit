package OrderDao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import OrderDao.factory.OrderDaoFactory;
import OrderDao.inter.GuestmanaDao;
import OrderDao.vo.GuestmanaVo;
import OrderDao.vo.GuestorderVo;
import Tool.page;

public class GuestmanaServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private String url;
  private GuestmanaDao Instance=  OrderDaoFactory.getInstance().getGuestmanaInstance();
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
    }else if("selectGuestorderByGuestcode".equals(action)){//查询 订单的 练习人 和 合同资料 往来日志，
      this.selectGuestorderByGuestcode(request, response);
    }
    
    
  }
  protected void selectGuestorderByGuestcode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String guestcode=request.getParameter("id");
    GuestorderVo code=OrderDaoFactory.getInstance().getGuestorderInstance().selectGuestorderByGuestcode(guestcode);
    JSONObject js= new JSONObject(code);
    PrintWriter  pr=response.getWriter();
    pr.print(js.toString());
    pr.flush();
    pr.close();
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
    List<GuestmanaVo> list=Instance.getpagelist(page);
    HttpSession session =request.getSession();//创建 传值作用域 session ;
    if(list.size()>0){
      session.setAttribute("page", page);
      session.setAttribute("getPaglist", list);
      url="operation/guestmana_list.jsp";
    }else{
      url="audit/error.jsp";
    }
    response.sendRedirect(url);
    return;
  }
  
  
  
  public  void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String country=null;
    if(request.getParameter("country")!=null&&request.getParameter("country")!=""){
      country=request.getParameter("country");
    }
    String names=request.getParameter("namess");
    List<GuestmanaVo> list= Instance.queryByIdOrNames(country,names);
    HttpSession session =request.getSession();//创建 传值作用域 session ;
    if(list.size()>0){
      session.setAttribute("getPaglist", list);
      url="operation/guestmana_list.jsp";
    }else{
      url="audit/error.jsp";
    }
    response.sendRedirect(url);
    return;
  }
  
  

  protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //System.out.println("insert");
    GuestmanaVo ex=new GuestmanaVo();
    ex.setId(Integer.parseInt(request.getParameter("id")));
    ex.setName(request.getParameter("names"));
    ex.setPropertys(request.getParameter("propertys"));
    ex.setDeliver(request.getParameter("deliver"));
    ex.setAddress(request.getParameter("address"));
    ex.setSupply(request.getParameter("supply"));
    ex.setReview(request.getParameter("review"));
    ex.setContractcode(request.getParameter("contractcode"));
    ex.setCharter(request.getParameter("charter"));
    ex.setPayment(request.getParameter("payment"));
    ex.setAppointment(request.getParameter("appointent"));
    ex.setExpress(request.getParameter("express"));
    ex.setContractleave(request.getParameter("contractleave"));
    ex.setCountry(request.getParameter("country"));
    if(ex!=null){
      Instance.insert(ex);
    }
  }
  
  protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("insert");
    GuestmanaVo ex=new GuestmanaVo();
    ex.setId(Integer.parseInt(request.getParameter("id")));
    ex.setName(request.getParameter("names"));
    ex.setPropertys(request.getParameter("propertys"));
    ex.setDeliver(request.getParameter("deliver"));
    ex.setAddress(request.getParameter("address"));
    ex.setSupply(request.getParameter("supply"));
    ex.setReview(request.getParameter("review"));
    ex.setContractcode(request.getParameter("contractcode"));
    ex.setCharter(request.getParameter("charter"));
    ex.setPayment(request.getParameter("payment"));
    ex.setAppointment(request.getParameter("appointent"));
    ex.setExpress(request.getParameter("express"));
    ex.setContractleave(request.getParameter("contractleave"));
    ex.setCountry(request.getParameter("country"));
    if(ex!=null){
      System.out.println("ddd");
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
    GuestmanaVo ex= Instance.selectById(id);
    HttpSession session=request.getSession();
    session.setAttribute("ex", ex);
    response.sendRedirect("operation/guestmana_modify.jsp");
    return;
  }


}

