package RepertoryDao.inter;

import java.util.List;

import RepertoryDao.vo.BuydocumentVo;
import Tool.page;

public interface BuydocumentDao {
    public List<BuydocumentVo> getpagelist(page page);//·ÖÒ³==
  
    public BuydocumentVo  selectById(int id);
    public boolean delete(int id);
    public boolean insert(BuydocumentVo ex);
    public int getCount() ;
    public boolean update(BuydocumentVo ex);
    public List<BuydocumentVo> queryByIdOrNames(int id ,String names);
}
