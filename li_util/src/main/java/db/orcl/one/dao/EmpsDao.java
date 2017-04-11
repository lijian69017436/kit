package db.orcl.one.dao;

import java.util.List;
import java.util.Map;

import db.orcl.one.vo.EmpsVo;

public interface EmpsDao {

	public List<Map<String, Object>> select_emps();

	public int delete_emps(int id);

	public List<Map<String, Object>> select_emps(int deptno); //

	public boolean insertEmp(EmpsVo emp);

	public boolean updateEmp(int id, EmpsVo emp);//

	public boolean deleteEmp(int id);//

	public EmpsVo getEmp1(int id);//

	public Map<String, Object> getEmp2(int id);//

	public List<Object> getAllEmps();//

	public List<EmpsVo> queryEmp1();//

	public List<Map<String, Object>> getQueryEmp();//
}
