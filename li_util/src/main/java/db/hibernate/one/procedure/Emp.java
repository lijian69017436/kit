package db.hibernate.one.procedure;

import java.math.BigDecimal;
 

 /**
  * 
  * 包：
create or replace package hibernatePackage is

   type cur is ref cursor return emp%rowtype;

end hibernatepackage;

存储过程：
create or replace procedure EmpHibernateProcedure(param_deptno in number, res out hibernatepackage.cur) is
begin
  
   open res for select emp.* from emp where emp.deptno=param_deptno;

end EmpHibernateProcedure;
  * 
  * 
  * */
public class Emp {
	 
	
	private Integer empno;
	
	 
	private String ename;
	
	 
	private Integer mgr;
	
	 
	private String job;
	
	 
	private BigDecimal sal;
	
	 
	private String hiredate;
	
	 
	private BigDecimal comm;
	
	 
	private Integer deptno;

	public Emp(){}
	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public BigDecimal getSal() {
		return sal;
	}

	public void setSal(BigDecimal sal) {
		this.sal = sal;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public BigDecimal getComm() {
		return comm;
	}

	public void setComm(BigDecimal comm) {
		this.comm = comm;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	 

	 

	 

}
