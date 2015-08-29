package RepertoryDao.factory;

import OrderDao.Impl.ExportClientDaoImpl;
import RepertoryDao.Impl.BuydocumentDaoImpl;
import RepertoryDao.Impl.PaymentincaseDaoImpl;
import RepertoryDao.inter.BuydocumentDao;
import RepertoryDao.inter.PaymentincaseDao;

public class RepertoryDaoFactory {
  private RepertoryDaoFactory(){
  }
  public static RepertoryDaoFactory getInstance(){
    return new RepertoryDaoFactory();
  }
  public  PaymentincaseDao getpaymentincaseInstance(){
    return new PaymentincaseDaoImpl();
  }
  public  BuydocumentDao getBuydocumentInstance(){
    return new BuydocumentDaoImpl();
  }
 
  
}
