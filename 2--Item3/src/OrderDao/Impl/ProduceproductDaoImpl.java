package OrderDao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import OrderDao.inter.ProduceproductDao;
import OrderDao.vo.ProduceproductVo;
import Tool.Tool;
import Tool.page;

public class ProduceproductDaoImpl implements ProduceproductDao {
  private Connection conn;
  private String sql;
  private PreparedStatement  pre;
  private ResultSet res;
  private  boolean flage=false;
  
  public ProduceproductVo selectById(int id) {
    conn=Tool.getToolInstance().getconn();
    sql="select id ,orderid,productcode,productname,guige,color,totals,unit," +
    		"moneytype,suttle,discount,price,money,fullmoney,sizes" +
    		"  from produceproduct where id=?";
    ProduceproductVo ex=new ProduceproductVo();
    try {
      pre =conn.prepareStatement(sql);
      pre.setInt(1, id);
      res=pre.executeQuery();
      if(res.next()){
        ex.setId(res.getInt(1));
        ex.setOrderid(res.getString(2));
        ex.setProductcode(res.getString(3));
        ex.setProductname(res.getString(4));
        ex.setGuige(res.getString(5));
        ex.setColor(res.getString(6));
        ex.setTotals(res.getString(7));
        ex.setUnit(res.getString(8));
        ex.setMoneytype(res.getString(9));
        ex.setSuttle(res.getString(10));
        ex.setDiscount(res.getString(11));
        ex.setPrice(res.getString(12));
        ex.setMoney(res.getString(13));
        ex.setFullmoney(res.getString(14));
        ex.setSizes(res.getString(15));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ex;
  }
  public List<ProduceproductVo> queryByIdOrNames(int id ,String names) {//查询
    conn=Tool.getToolInstance().getconn();
    if(id!=0&&names==null){
      sql="select * from produceproduct where id like '%"+id+"%' ";
    }else if(id==0&&names!=null){
      sql="select * from produceproduct where address like '%"+names+"%' ";
    }else if(id!=0&&names!=null){
      sql="select * from produceproduct where address like '%"+names+"%' and id like'%"+id+"%' ";
    }
    List<ProduceproductVo> list=new ArrayList<ProduceproductVo>();
    try {
      PreparedStatement pre=conn.prepareStatement(sql);
      ResultSet res=pre.executeQuery();
      while(res.next()){
      }
    } catch (SQLException e) {e.printStackTrace();}
    return list;
  }
  
  
//分页 方法  利用 数据库limit 分页  调用工具累 page 传入 当前页 和 每页条数
  public List<ProduceproductVo> getpagelist(page page) {
    conn=Tool.getToolInstance().getconn();
    String sql="select * from produceproduct limit ?,?";
    List<ProduceproductVo> list= new ArrayList<ProduceproductVo>();
    try {
      PreparedStatement prs= conn.prepareStatement(sql);
      prs.setInt(1, (page.getPageNow()-1)*page.getPageSize());//查询的开始索引 ， 当前页 -1乘以 每页条数
      prs.setInt(2, page.getPageSize());
      res=prs.executeQuery();
      while(res.next()){
        ProduceproductVo ex=new ProduceproductVo();
        ex.setId(res.getInt(1));
        ex.setOrderid(res.getString(2));
        ex.setProductcode(res.getString(3));
        ex.setProductname(res.getString(4));
        ex.setGuige(res.getString(5));
        ex.setColor(res.getString(6));
        ex.setTotals(res.getString(7));
        ex.setUnit(res.getString(8));
        ex.setMoneytype(res.getString(9));
        ex.setSuttle(res.getString(10));
        ex.setDiscount(res.getString(11));
        ex.setPrice(res.getString(12));
        ex.setMoney(res.getString(13));
        ex.setFullmoney(res.getString(14));
        ex.setSizes(res.getString(15));
        list.add(ex);
      }
    } catch (SQLException e) {e.printStackTrace();}
    return list;
  }

  
  
  public boolean delete(int id) {//删除方法 
    conn=Tool.getToolInstance().getconn();
    sql="delete from produceproduct where id=?";
    try {
      pre =conn.prepareStatement(sql);
      pre.setInt(1, id);
      if(pre.executeUpdate()>0){
        flage=true;
      }
    } catch (SQLException e) {e.printStackTrace();}
    return flage;
  }
  
  public boolean insert(ProduceproductVo ex) {//添加方法
    conn=Tool.getToolInstance().getconn();
    sql="insert into produceproduct (" +
    		" id ,orderid,productcode,productname,guige,color,totals,unit," +
        "moneytype,suttle,discount,price,money,fullmoney,sizes)" +
    		" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    try {
      pre =conn.prepareStatement(sql);
      pre.setInt(1, ex.getId());
      pre.setString(2, ex.getOrderid());
      pre.setString(3, ex.getProductcode());
      pre.setString(4, ex.getProductname());
      pre.setString(5, ex.getGuige());
      pre.setString(6, ex.getColor());
      pre.setString(7, ex.getTotals());
      pre.setString(8, ex.getUnit());
      pre.setString(9, ex.getMoneytype());
      pre.setString(10, ex.getSuttle());
      pre.setString(11, ex.getDiscount());
      pre.setString(12, ex.getPrice());
      pre.setString(13, ex.getMoney());
      pre.setString(14, ex.getFullmoney());
      pre.setString(15, ex.getSizes());
      if(pre.executeUpdate()>0){
        flage=true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return flage;
  }
  public boolean update(ProduceproductVo ex) {
    conn=Tool.getToolInstance().getconn();
    sql="update produceproduct set orderid=?,productcode=?,productname=?,guige=?," +
    		"color=?,totals=?,unit=?,moneytype=?,suttle=?,discount=?,price=?,money=?,fullmoney=?,sizes=? " +
    		" where id=?";
    try {
      pre =conn.prepareStatement(sql);
      pre.setString(1, ex.getOrderid());
      pre.setString(2, ex.getProductcode());
      pre.setString(3, ex.getProductname());
      pre.setString(4, ex.getGuige());
      pre.setString(5, ex.getColor());
      pre.setString(6, ex.getTotals());
      pre.setString(7, ex.getUnit());
      pre.setString(8, ex.getMoneytype());
      pre.setString(9, ex.getSuttle());
      pre.setString(10, ex.getDiscount());
      pre.setString(11, ex.getPrice());
      pre.setString(12, ex.getMoney());
      pre.setString(13, ex.getFullmoney());
      pre.setString(14, ex.getSizes());
      pre.setInt(15, ex.getId());
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
      String sql="select count(*) from produceproduct";//查询总条数
      ResultSet  rs= st.executeQuery(sql);
      if(rs.next()){
        i=rs.getInt(1);//得到 多少条数据
      }
    } catch (SQLException e) {e.printStackTrace();}
    return i;
  }
  
  
}
