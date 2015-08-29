package RepertoryDao.inter;

import java.util.List;

import RepertoryDao.vo.PaymentincaseVo;
import Tool.page;

public interface PaymentincaseDao {
    public List<PaymentincaseVo> getpagelist(page page);//·ÖÒ³==
  
    public PaymentincaseVo  selectById(int id);
    public boolean delete(int id);
    public boolean insert(PaymentincaseVo ex);
    public int getCount() ;
    public boolean update(PaymentincaseVo ex);
    public List<PaymentincaseVo> queryByIdOrNames(int id ,String names);
}
