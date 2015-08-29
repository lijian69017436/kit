package OrderDao.inter;

import java.util.List;

import OrderDao.vo.ExportClientVo;
import Tool.page;

public interface ExportClientDao {
    public ExportClientVo  selectById(int id);
    public boolean delete(int id);
    public boolean insert(ExportClientVo ex);
    public int getCount() ;
    public List<ExportClientVo> getpagelist(page page);
    public boolean update(ExportClientVo ex);
    public List<ExportClientVo> queryByIdOrNames(int id ,String names);
}
