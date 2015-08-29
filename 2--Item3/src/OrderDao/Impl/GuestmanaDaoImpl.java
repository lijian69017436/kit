package OrderDao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import OrderDao.inter.GuestmanaDao;
import OrderDao.vo.GuestmanaVo;
import Tool.Tool;
import Tool.page;

public class GuestmanaDaoImpl implements GuestmanaDao {
  private Connection conn;
  private String sql;
  private PreparedStatement  pre;
  private ResultSet res;
  private  boolean flage=false;
  
  public GuestmanaVo selectById(int id) {
    conn=Tool.getToolInstance().getconn();
    sql="select  id ,names  ,propertys,deliver,address  ," +
    		"supply  ,  review   ,contractcode     , charter  ,payment   ," +
    		"appointment    ,express      ,contractleave " +
    		"  from clientmanagement where id=?";
    GuestmanaVo ex=new GuestmanaVo();
    try {
      pre =conn.prepareStatement(sql);
      pre.setInt(1, id);
      res=pre.executeQuery();
      if(res.next()){
        ex.setId(res.getInt(1));
        ex.setName(res.getString(2));
        ex.setPropertys(res.getString(3));
        ex.setDeliver(res.getString(4));
        ex.setAddress(res.getString(5));
        ex.setSupply(res.getString(6));
        ex.setReview(res.getString(7));
        ex.setContractcode(res.getString(8));
        ex.setCharter(res.getString(9));
        ex.setPayment(res.getString(10));
        ex.setAppointment(res.getString(11));
        ex.setExpress(res.getString(12));
        ex.setContractleave(res.getString(13));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ex;
  }
  
//分页 方法  利用 数据库limit 分页  调用工具累 page 传入 当前页 和 每页条数
  public List<GuestmanaVo> getpagelist(page page) {
    conn=Tool.getToolInstance().getconn();
    String sql="select * from clientmanagement limit ?,?";
    List<GuestmanaVo> list= new ArrayList<GuestmanaVo>();
    try {
      PreparedStatement prs= conn.prepareStatement(sql);
      prs.setInt(1, (page.getPageNow()-1)*page.getPageSize());//查询的开始索引 ， 当前页 -1乘以 每页条数
      prs.setInt(2, page.getPageSize());
      res=prs.executeQuery();
      while(res.next()){
        GuestmanaVo ex=new GuestmanaVo();
        ex.setId(res.getInt(1));
        ex.setName(res.getString(2));
        ex.setPropertys(res.getString(3));
        ex.setDeliver(res.getString(4));
        ex.setAddress(res.getString(5));
        ex.setSupply(res.getString(6));
        ex.setReview(res.getString(7));
        ex.setContractcode(res.getString(8));
        ex.setCharter(res.getString(9));
        ex.setPayment(res.getString(10));
        ex.setAppointment(res.getString(11));
        ex.setExpress(res.getString(12));
        ex.setContractleave(res.getString(13));
        ex.setCountry(res.getString(14));
        list.add(ex);
      }
    } catch (SQLException e) {e.printStackTrace();}
    return list;
  }

  
  
  public List<GuestmanaVo> queryByIdOrNames(String country,String names) {//查询
    conn=Tool.getToolInstance().getconn();
    if(country!=null&&names==null){
      sql="select * from clientmanagement where country like '%"+country+"%' ";
    }else if(country==null&&names!=null){
      sql="select * from clientmanagement where names like '%"+names+"%' ";
    }else if(country!=null&&names!=null){
      sql="select * from clientmanagement where names like '%"+names+"%' and country like'%"+country+"%' ";
    }
    List<GuestmanaVo> list=new ArrayList<GuestmanaVo>();
    try {
      PreparedStatement pre=conn.prepareStatement(sql);
      ResultSet res=pre.executeQuery();
      while(res.next()){
        GuestmanaVo ex=new GuestmanaVo();
        ex.setId(res.getInt(1));
        ex.setName(res.getString(2));
        ex.setPropertys(res.getString(3));
        ex.setDeliver(res.getString(4));
        ex.setAddress(res.getString(5));
        ex.setSupply(res.getString(6));
        ex.setReview(res.getString(7));
        ex.setContractcode(res.getString(8));
        ex.setCharter(res.getString(9));
        ex.setPayment(res.getString(10));
        ex.setAppointment(res.getString(11));
        ex.setExpress(res.getString(12));
        ex.setContractleave(res.getString(13));
        ex.setCountry(res.getString(14));
        list.add(ex);
      }
    } catch (SQLException e) {e.printStackTrace();}
    return list;
  }
  
  

  
  
  public boolean delete(int id) {//删除方法 
    conn=Tool.getToolInstance().getconn();
    sql="delete from clientmanagement where id=?";
    try {
      pre =conn.prepareStatement(sql);
      pre.setInt(1, id);
      if(pre.executeUpdate()>0){
        flage=true;
      }
    } catch (SQLException e) {e.printStackTrace();}
    return flage;
  }
  
  public boolean insert(GuestmanaVo ex) {//添加方法
    conn=Tool.getToolInstance().getconn();
    sql="insert into clientmanagement (" +
    		" id ,names  ,propertys,deliver,address  ," +
        "supply  ,  review   ,contractcode     , charter  ,payment   ," +
        "appointment    ,express      ,contractleave ,country )" +
    		" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    try {
      pre =conn.prepareStatement(sql);
      pre.setInt(1, ex.getId());
      pre.setString(2, ex.getName());
      pre.setString(3, ex.getPropertys());
      pre.setString(4, ex.getDeliver());
      pre.setString(5, ex.getAddress());
      pre.setString(6, ex.getSupply());
      pre.setString(7, ex.getReview());
      pre.setString(8, ex.getContractcode());
      pre.setString(9, ex.getCharter());
      pre.setString(10, ex.getPayment());
      pre.setString(11, ex.getAppointment());
      pre.setString(12, ex.getExpress());
      pre.setString(13, ex.getContractleave());
      pre.setString(14, ex.getCountry());
      if(pre.executeUpdate()>0){
        flage=true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return flage;
  }
  public boolean update(GuestmanaVo ex) {
    conn=Tool.getToolInstance().getconn();
    sql="update clientmanagement set names=?,propertys=?,deliver=?,address=?," +
    		"supply=?,review=?,charter=?,payment=?,appointment=?," +
    		"contractcode=?,express=?,contractleave=? ,country=?" +
    		" where id=?";
    try {
      pre =conn.prepareStatement(sql);
      pre.setString(1, ex.getName());
      pre.setString(2, ex.getPropertys());
      pre.setString(3, ex.getDeliver());
      pre.setString(4, ex.getAddress());
      pre.setString(5, ex.getSupply());
      pre.setString(6, ex.getReview());
      pre.setString(7, ex.getContractcode());
      pre.setString(8, ex.getCharter());
      pre.setString(9, ex.getPayment());
      pre.setString(10, ex.getAppointment());
      pre.setString(11, ex.getExpress());
      pre.setString(12, ex.getContractleave());
      pre.setString(13, ex.getCountry());
      pre.setInt(14, ex.getId());
      System.out.println("fff");
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
      String sql="select count(*) from clientmanagement";//查询总条数
      ResultSet  rs= st.executeQuery(sql);
      if(rs.next()){
        i=rs.getInt(1);//得到 多少条数据
      }
    } catch (SQLException e) {e.printStackTrace();}
    return i;
  }

  
  
}
