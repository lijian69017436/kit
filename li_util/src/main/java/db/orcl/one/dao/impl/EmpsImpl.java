package db.orcl.one.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import db.orcl.one.OrclTool;
import db.orcl.one.dao.EmpsDao;
import db.orcl.one.vo.EmpsVo;
import oracle.jdbc.OracleTypes;

public class EmpsImpl implements EmpsDao {
	private Connection conn = OrclTool.getOrclInstance().getconn();
	private String sql = null;
	private PreparedStatement prs = null;
	private int result = 0;
	private boolean flags = false;
	private ResultSet re = null;

	public int savaEmp1() {
		int i = -1;
		String sql = "{?=call emps_pags.savaEmps(?,?,?,?)}";
		CallableStatement cs;
		try {
			cs = conn.prepareCall(sql);//
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setInt(2, 7);
			cs.setString(3, "�ܽ���");
			cs.setString(4, "С��");
			cs.setInt(5, 10000);
			cs.execute();
			i = cs.getInt(1);
			if (i > 0) {
				System.out.println("ok");
			} else {
				System.out.println("error");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public List<Map<String, Object>> select_emps() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "{call emps_pags.select_emps(?)}";
		try {
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR); 
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1); 
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("empno", rs.getInt(1));
				map.put("ename", rs.getString(2));
				map.put("job", rs.getString(3));
				map.put("mgr", rs.getString(4));
				map.put("hiredate", rs.getString(5));
				map.put("sal", rs.getString(6));
				map.put("comm", rs.getString(7));
				map.put("deptno", rs.getString(8));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Map<String, Object>> select_emps(int deptno) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "{call emps_pags.select_empsBydno(?,?)}";
		try {
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR); 
			cs.setInt(2, deptno);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(1); 
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("empno", rs.getInt(1));
				map.put("ename", rs.getString(2));
				map.put("job", rs.getString(3));
				map.put("mgr", rs.getString(4));
				map.put("hiredate", rs.getString(5));
				map.put("sal", rs.getString(6));
				map.put("comm", rs.getString(7));
				map.put("deptno", rs.getString(8));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int delete_emps(int id) {
		String sql = "{?=call emps_pags.delete_emps(?)}";
		int i = -1;
		try {
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setInt(2, id);
			cs.execute();
			i = cs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public boolean insertEmp(EmpsVo emp) {
		boolean flags = false;
		try {
			sql = "insert into emp(ename,job,sal,comm,mgr,deptno) values(?,?,?,?,?,?);";
			prs = conn.prepareStatement(sql);
			prs.setString(1, emp.getEname());
			prs.setString(2, emp.getJob());
			prs.setInt(3, emp.getSal());
			prs.setInt(4, emp.getComm());
			prs.setInt(5, emp.getMgr());
			prs.setInt(6, emp.getDeptno());
			int i = prs.executeUpdate();
			if (i > 0) {
				System.out.println("����ɹ�");
				flags = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flags;
	}

	public boolean updateEmp(int id, EmpsVo emp) {
		try {
			sql = "update emp set ename=?,sal=?,job=?,mgr=? ,comm=?,hiredate=?,deptno=? where empno=?";
			prs = conn.prepareStatement(sql);
			prs.setString(1, emp.getEname());
			prs.setInt(2, emp.getSal());
			prs.setString(3, emp.getJob());
			prs.setInt(4, emp.getMgr());
			prs.setInt(5, emp.getComm());
			prs.setString(6, emp.getHiredate());
			prs.setInt(7, emp.getDeptno());

			prs.setInt(8, id);

			result = prs.executeUpdate();
			if (result > 0) {
				flags = true;
				System.out.println("���³ɹ�");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flags;
	}

	public boolean deleteEmp(int id) {
		try {
			sql = "delete from emp where empno=?;";
			prs = conn.prepareStatement(sql);
			prs.setInt(1, id);
			result = prs.executeUpdate();
			if (result > 0) {
				flags = true;
				System.out.println("ɾ���ɹ�");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flags;
	}

	public EmpsVo getEmp1(int id) {
		sql = "select * from emp where empno=?;";
		EmpsVo e = new EmpsVo();
		try {
			prs = conn.prepareStatement(sql);
			prs.setInt(1, id);
			re = prs.executeQuery();
			while (re.next()) {
				e.setEmpno(re.getInt("empno"));
				e.setEname(re.getString("ename"));
				e.setJob(re.getString("job"));
				e.setMgr(re.getInt("mgr"));
				e.setHiredate(re.getString("hiredate"));
				e.setSal(re.getInt("sal"));
				e.setComm(re.getInt("comm"));
				e.setDeptno(re.getInt("deptno"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return e;
	}

	public Map<String, Object> getEmp2(int id) {
		sql = "select * from emp where empno=?;";
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			prs = conn.prepareStatement(sql);
			prs.setInt(1, id);
			re = prs.executeQuery();
			while (re.next()) {
				m.put("empno", re.getInt("empno"));
				m.put("ename", re.getString("ename"));
				m.put("job", re.getString("job"));
				m.put("mgr", re.getInt("mgr"));
				m.put("hiredate", re.getString("hiredate"));
				m.put("sal", re.getInt("sal"));
				m.put("comm", re.getInt("comm"));
				m.put("deptno", re.getInt("deptno"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

	public List<Object> getAllEmps() {
		sql = "select * from emp;";
		List<Object> list = new ArrayList<Object>();
		try {
			prs = conn.prepareStatement(sql);
			re = prs.executeQuery();
			while (re.next()) {
				EmpsVo e = new EmpsVo();
				e.setEmpno(re.getInt("empno"));
				e.setEname(re.getString("ename"));
				e.setJob(re.getString("job"));
				e.setMgr(re.getInt("mgr"));
				e.setHiredate(re.getString("hiredate"));//
				e.setSal(re.getInt("sal"));
				e.setComm(re.getInt("comm"));
				e.setDeptno(re.getInt("deptno"));
				list.add(new JSONObject(e));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<EmpsVo> queryEmp1() {
		sql = "select e.ename,e.sal,d.dname,d.loc from emp e,dept d where e.deptno=d.deptno;";
		List<EmpsVo> list = new ArrayList<EmpsVo>();
		try {
			prs = conn.prepareStatement(sql);
			re = prs.executeQuery();
			while (re.next()) {
				EmpsVo e = new EmpsVo();
				e.setEname(re.getString("ename"));
				e.setSal(re.getInt("sal"));
				e.setDname(re.getString("dname"));
				e.setLoc(re.getString("loc"));
				list.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Map<String, Object>> getQueryEmp() {
		sql = "select e.ename,e.sal,d.dname,d.loc from emp e,dept d where e.deptno=d.deptno;";
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			prs = conn.prepareStatement(sql);
			re = prs.executeQuery();
			while (re.next()) {
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("ename", re.getString("ename"));
				m.put("sal", re.getInt("sal"));
				m.put("dname", re.getString("dname"));
				m.put("loc", re.getString("loc"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
