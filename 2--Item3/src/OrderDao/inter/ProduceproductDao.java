package OrderDao.inter;

import java.util.List;

import OrderDao.vo.ProduceproductVo;
import Tool.page;

public interface ProduceproductDao {
    public List<ProduceproductVo> getpagelist(page page);//·ÖÒ³==
  
    public ProduceproductVo  selectById(int id);
    public boolean delete(int id);
    public boolean insert(ProduceproductVo ex);
    public int getCount() ;
    public boolean update(ProduceproductVo ex);
    public List<ProduceproductVo> queryByIdOrNames(int id ,String names);
}
