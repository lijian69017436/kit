package RepertoryDao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import RepertoryDao.inter.PaymentincaseDao;
import RepertoryDao.vo.PaymentincaseVo;
import Tool.Tool;
import Tool.page;

public class PaymentincaseDaoImpl implements PaymentincaseDao {
  private Connection conn;
  private String sql;
  private PreparedStatement  pre;
  private ResultSet res;
  private  boolean flage=false;
  
  public PaymentincaseVo selectById(int id) {
    conn=Tool.getToolInstance().getconn();
    sql="select id ,plid,companycode,clientcode,numbers,suttle,grossweight" +
    		",sizes,documentname,checks,times,getid  from paymentincase where id=?";
    PaymentincaseVo ex=new PaymentincaseVo();
    try {
      pre =conn.prepareStatement(sql);
      pre.setInt(1, id);
      res=pre.executeQuery();
      if(res.next()){
        ex.setId(res.getInt(1));
        ex.setPlid(res.getString(2));
        ex.setCompanycode(res.getString(3));
        ex.setClientcode(res.getString(4));
        ex.setNumbers(res.getString(5));
        ex.setSuttle(res.getString(6));
        ex.setGrossweight(res.getString(7));
        ex.setSizes(res.getString(8));
        ex.setDocumentname(res.getString(9));
        ex.setChecks(res.getString(10));
        ex.setTimes(res.getString(11));
        ex.setGetid(res.getString(12));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ex;
  }
  public List<PaymentincaseVo> queryByIdOrNames(int id ,String names) {//分页  
    conn=Tool.getToolInstance().getconn();
    if(id!=0&&names==null){
      sql="select * from paymentincase where id like '%"+id+"%' ";
    }else if(id==0&&names!=null){
      sql="select * from paymentincase where plid like '%"+names+"%' ";
    }else if(id!=0&&names!=null){
      sql="select * from paymentincase where orderid like '%"+names+"%' and id like'%"+id+"%' ";
    }
    List<PaymentincaseVo> list=new ArrayList<PaymentincaseVo>();
    try {
      PreparedStatement pre=conn.prepareStatement(sql);
      ResultSet res=pre.executeQuery();
      while(res.next()){
        PaymentincaseVo ex=new PaymentincaseVo();
        ex.setId(res.getInt(1));
        ex.setPlid(res.getString(2));
        ex.setCompanycode(res.getString(3));
        ex.setClientcode(res.getString(4));
        ex.setNumbers(res.getString(5));
        ex.setSuttle(res.getString(6));
        ex.setGrossweight(res.getString(7));
        ex.setSizes(res.getString(8));
        ex.setDocumentname(res.getString(9));
        ex.setChecks(res.getString(10));
        ex.setTimes(res.getString(11));
        ex.setGetid(res.getString(12));
        list.add(ex);
      }
    } catch (SQLException e) {e.printStackTrace();}
    return list;
  }
  
  
  
  
  
  
//分页 方法  利用 数据库limit 分页  调用工具累 page 传入 当前页 和 每页条数
  public List<PaymentincaseVo> getpagelist(page page) {
    conn=Tool.getToolInstance().getconn();
    String sql="select * from paymentincase limit ?,?";
    List<PaymentincaseVo> list= new ArrayList<PaymentincaseVo>();
    try {
      PreparedStatement prs= conn.prepareStatement(sql);
      prs.setInt(1, (page.getPageNow()-1)*page.getPageSize());//查询的开始索引 ， 当前页 -1乘以 每页条数
      prs.setInt(2, page.getPageSize());
      res=prs.executeQuery();
      while(res.next()){
        PaymentincaseVo ex=new PaymentincaseVo();
        ex.setId(res.getInt(1));
        ex.setPlid(res.getString(2));
        ex.setCompanycode(res.getString(3));
        ex.setClientcode(res.getString(4));
        ex.setNumbers(res.getString(5));
        ex.setSuttle(res.getString(6));
        ex.setGrossweight(res.getString(7));
        ex.setSizes(res.getString(8));
        ex.setDocumentname(res.getString(9));
        ex.setChecks(res.getString(10));
        ex.setTimes(res.getString(11));
        ex.setGetid(res.getString(12));
        list.add(ex);
      }
    } catch (SQLException e) {e.printStackTrace();}
    return list;
  }

  
  
  public boolean delete(int id) {//删除方法 
    conn=Tool.getToolInstance().getconn();
    sql="delete from paymentincase where id=?";
    try {
      pre =conn.prepareStatement(sql);
      pre.setInt(1, id);
      if(pre.executeUpdate()>0){
        flage=true;
      }
    } catch (SQLException e) {e.printStackTrace();}
    return flage;
  }
  
  public boolean insert(PaymentincaseVo ex) {
    conn=Tool.getToolInstance().getconn();
    sql="insert into paymentincase (id ,plid,companycode,clientcode,numbers,suttle,grossweight" +
        ",sizes,documentname,checks,times,getid )" +
    		" values(?,?,?,?,?,?,?,?,?,?,?,?)";
    try {
      pre =conn.prepareStatement(sql);
      pre.setInt(1, ex.getId());
      pre.setString(2, ex.getPlid());
      pre.setString(3, ex.getCompanycode());
      pre.setString(4, ex.getClientcode());
      pre.setString(5, ex.getNumbers());
      pre.setString(6, ex.getSuttle());
      pre.setString(7, ex.getGrossweight());
      pre.setString(8, ex.getSizes());
      pre.setString(9, ex.getDocumentname());
      pre.setString(10, ex.getChecks());
      pre.setString(11, ex.getTimes());
      pre.setString(12, ex.getGetid());
      if(pre.executeUpdate()>0){
        flage=true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return flage;
  }
  public boolean update(PaymentincaseVo ex) {
    conn=Tool.getToolInstance().getconn();
    sql="update paymentincase set plid=?,companycode=?,clientcode=?,numbers=?,suttle=?,grossweight=? " +
    " ,sizes=?, documentname=?, checks=?, times=? , getid=?  where id=?";
    try {
      pre =conn.prepareStatement(sql);
      pre.setString(1, ex.getPlid());
      pre.setString(2, ex.getCompanycode());
      pre.setString(3, ex.getClientcode());
      pre.setString(4, ex.getNumbers());
      pre.setString(5, ex.getSuttle());
      pre.setString(6, ex.getGrossweight());
      pre.setString(7, ex.getSizes());
      pre.setString(8, ex.getDocumentname());
      pre.setString(9, ex.getChecks());
      pre.setString(10, ex.getTimes());
      pre.setString(11, ex.getGetid());
      pre.setInt(12, ex.getId());
      if(pre.executeUpdate()>0){
        flage=true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return flage;
  }
  
  
//得到总共条数    
  public int getCount() {
    int i=0;
    conn=Tool.getToolInstance().getconn();
    try {
      Statement st= conn.createStatement();
      String sql="select count(*) from paymentincase";//查询总条数
      ResultSet  rs= st.executeQuery(sql);
      if(rs.next()){
        i=rs.getInt(1);//得到 多少条数据
      }
    } catch (SQLException e) {e.printStackTrace();}
    return i;
  }
  
  
}
