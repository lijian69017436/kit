package OrderDao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import OrderDao.inter.ExportClientDao;
import OrderDao.inter.GuestorderDao;
import OrderDao.vo.ExportClientVo;
import OrderDao.vo.GuestorderVo;
import Tool.Tool;
import Tool.page;

public class GuestorderDaoImpl implements GuestorderDao {
  private Connection conn;
  private String sql;
  private PreparedStatement  pre;
  private ResultSet res;
  private  boolean flage=false;
  
  public GuestorderVo selectById(int id) {
    conn=Tool.getToolInstance().getconn();
    sql="select id ,guestcode,address,times,froms,tel,fax,linkman  from guestorder where id=?";
    GuestorderVo ex=new GuestorderVo();
    try {
      pre =conn.prepareStatement(sql);
      pre.setInt(1, id);
      res=pre.executeQuery();
      if(res.next()){
        ex.setId(res.getInt(1));
        ex.setGuestcode(res.getString(2));
        ex.setAddress(res.getString(3));
        ex.setTimes(res.getString(4));
        ex.setFroms(res.getString(5));
        ex.setTel(res.getString(6));
        ex.setFax(res.getString(7));
        ex.setLinkman(res.getString(8));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ex;
  }
  public GuestorderVo selectGuestorderByGuestcode(String  guestcode) {
    conn=Tool.getToolInstance().getconn();
    sql="select froms,fax,linkman  from guestorder where guestcode=?";
    GuestorderVo ex=new GuestorderVo();
    try {
      pre =conn.prepareStatement(sql);
      pre.setString(1, guestcode);
      res=pre.executeQuery();
      if(res.next()){
        ex.setFroms(res.getString(1));
        ex.setFax(res.getString(2));
        ex.setLinkman(res.getString(3));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ex;
  }
  public List<GuestorderVo> queryByIdOrNames(int id ,String names) {//分页  
    conn=Tool.getToolInstance().getconn();
    if(id!=0&&names==null){
      sql="select * from guestorder where id like '%"+id+"%' ";
    }else if(id==0&&names!=null){
      sql="select * from guestorder where address like '%"+names+"%' ";
    }else if(id!=0&&names!=null){
      sql="select * from guestorder where address like '%"+names+"%' and id like'%"+id+"%' ";
    }
    List<GuestorderVo> list=new ArrayList<GuestorderVo>();
    try {
      PreparedStatement pre=conn.prepareStatement(sql);
      ResultSet res=pre.executeQuery();
      while(res.next()){
        GuestorderVo ex=new GuestorderVo();
        ex.setId(res.getInt(1));
        ex.setGuestcode(res.getString(2));
        ex.setAddress(res.getString(3));
        ex.setTimes(res.getString(4));
        ex.setFroms(res.getString(5));
        ex.setTel(res.getString(6));
        ex.setFax(res.getString(7));
        ex.setLinkman(res.getString(8));
        list.add(ex);
      }
    } catch (SQLException e) {e.printStackTrace();}
    return list;
  }
  
  
  
  
  
  
//分页 方法  利用 数据库limit 分页  调用工具累 page 传入 当前页 和 每页条数
  public List<GuestorderVo> getpagelist(page page) {
    conn=Tool.getToolInstance().getconn();
    String sql="select * from guestorder limit ?,?";
    List<GuestorderVo> list= new ArrayList<GuestorderVo>();
    try {
      PreparedStatement prs= conn.prepareStatement(sql);
      prs.setInt(1, (page.getPageNow()-1)*page.getPageSize());//查询的开始索引 ， 当前页 -1乘以 每页条数
      prs.setInt(2, page.getPageSize());
      res=prs.executeQuery();
      while(res.next()){
        GuestorderVo ex=new GuestorderVo();
        ex.setId(res.getInt(1));
        ex.setGuestcode(res.getString(2));
        ex.setAddress(res.getString(3));
        ex.setTimes(res.getString(4));
        ex.setFroms(res.getString(5));
        ex.setTel(res.getString(6));
        ex.setFax(res.getString(7));
        ex.setLinkman(res.getString(8));
        list.add(ex);
      }
    } catch (SQLException e) {e.printStackTrace();}
    return list;
  }

  
  
  public boolean delete(int id) {//删除方法 
    conn=Tool.getToolInstance().getconn();
    sql="delete from guestorder where id=?";
    try {
      pre =conn.prepareStatement(sql);
      pre.setInt(1, id);
      if(pre.executeUpdate()>0){
        flage=true;
      }
    } catch (SQLException e) {e.printStackTrace();}
    return flage;
  }
  
  public boolean insert(GuestorderVo ex) {
    conn=Tool.getToolInstance().getconn();
    sql="insert into guestorder (id ,guestcode,address,times,froms,tel,fax,linkman)" +
    		" values(?,?,?,?,?,?,?,?)";
    try {
      pre =conn.prepareStatement(sql);
      pre.setInt(1, ex.getId());
      pre.setString(2, ex.getGuestcode());
      pre.setString(3, ex.getAddress());
      pre.setString(4, ex.getTimes());
      pre.setString(5, ex.getFroms());
      pre.setString(6, ex.getTel());
      pre.setString(7, ex.getFax());
      pre.setString(8, ex.getLinkman());
      if(pre.executeUpdate()>0){
        flage=true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return flage;
  }
  public boolean update(GuestorderVo ex) {
    conn=Tool.getToolInstance().getconn();
    sql="update guestorder set guestcode=?,address=?,times=?,froms=?,tel=?,fax=?,linkman=? " +
    " where id=?";
    try {
      pre =conn.prepareStatement(sql);
      pre.setString(1, ex.getGuestcode());
      pre.setString(2, ex.getAddress());
      pre.setString(3, ex.getTimes());
      pre.setString(4, ex.getFroms());
      pre.setString(5, ex.getTel());
      pre.setString(6, ex.getFax());
      pre.setString(7, ex.getLinkman());
      pre.setInt(8, ex.getId());
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
      String sql="select count(*) from guestorder";//查询总条数
      ResultSet  rs= st.executeQuery(sql);
      if(rs.next()){
        i=rs.getInt(1);//得到 多少条数据
      }
    } catch (SQLException e) {e.printStackTrace();}
    return i;
  }
  
  
}
