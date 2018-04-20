package xml_init_destory.dao;

import java.util.List;
import java.util.Map;

public interface PersonDao {
	public void init();
	public void destroy();
	
	public List<Map<String,Object>> getAll();
}
