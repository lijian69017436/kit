package OrderDao.factory;

import OrderDao.Impl.ExportClientDaoImpl;
import OrderDao.Impl.GuestmanaDaoImpl;
import OrderDao.Impl.GuestorderDaoImpl;
import OrderDao.Impl.ProduceproductDaoImpl;
import OrderDao.inter.ExportClientDao;
import OrderDao.inter.GuestmanaDao;
import OrderDao.inter.GuestorderDao;
import OrderDao.inter.ProduceproductDao;

public class OrderDaoFactory {
  private OrderDaoFactory(){
  }
  public static OrderDaoFactory getInstance(){
    return new OrderDaoFactory();
  }
  public  ExportClientDao getExportClientInstance(){
    return new ExportClientDaoImpl();
  }
  public  GuestorderDao getGuestorderInstance(){
    return new GuestorderDaoImpl();
  }
  public  ProduceproductDao getProduceproductInstance(){
    return new ProduceproductDaoImpl();
  }
  
  public  GuestmanaDao getGuestmanaInstance(){
    return new GuestmanaDaoImpl();
  }
  
}
