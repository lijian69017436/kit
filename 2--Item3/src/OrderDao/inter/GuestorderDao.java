package OrderDao.inter;

import java.util.List;

import OrderDao.vo.GuestorderVo;
import Tool.page;

public interface GuestorderDao {
    public List<GuestorderVo> getpagelist(page page);//分页==
  
    public GuestorderVo  selectById(int id);
    public boolean delete(int id);
    public boolean insert(GuestorderVo ex);
    public int getCount() ;
    public boolean update(GuestorderVo ex);
    public List<GuestorderVo> queryByIdOrNames(int id ,String names);
    
    public GuestorderVo selectGuestorderByGuestcode(String  guestcode) ;//查询 客户 编号的 方法
}
