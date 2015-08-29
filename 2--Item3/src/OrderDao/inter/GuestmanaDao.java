package OrderDao.inter;

import java.util.List;

import OrderDao.vo.GuestmanaVo;
import Tool.page;

public interface GuestmanaDao {
    public List<GuestmanaVo> getpagelist(page page);//·ÖÒ³==
  
    public GuestmanaVo  selectById(int id);
    public boolean delete(int id);
    public boolean insert(GuestmanaVo ex);
    public int getCount() ;
    public boolean update(GuestmanaVo ex);
    public List<GuestmanaVo> queryByIdOrNames(String country,String names);
}
