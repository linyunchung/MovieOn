package com.prob.model;
import java.sql.Date;

public class ProbVO implements java.io.Serializable{
	private Integer probno;
	private Date    probtime;
	private String  probtype;
	private String  content;
	private String  email;
	
	public Integer getProbno() {
		return probno;
	}
	public void setProbno(Integer probno) {
		this.probno = probno;
	}
	public Date getProbtime() {
		return probtime;
	}
	public void setProbtime(Date probtime) {
		this.probtime = probtime;
	}
	public String getProbtype() {
		return probtype;
	}
	public void setProbtype(String probtype) {
		this.probtype = probtype;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	

//	private Integer empno;
//	private String ename;
//	private String job;
//	private Date hiredate;
//	private Double sal;
//	private Double comm;
//	private Integer deptno;
	
//	public Integer getEmpno() {
//		return empno;
//	}
//	public void setEmpno(Integer empno) {
//		this.empno = empno;
//	}
//	public String getEname() {
//		return ename;
//	}
//	public void setEname(String ename) {
//		this.ename = ename;
//	}
//	public String getJob() {
//		return job;
//	}
//	public void setJob(String job) {
//		this.job = job;
//	}
//	public Date getHiredate() {
//		return hiredate;
//	}
//	public void setHiredate(Date hiredate) {
//		this.hiredate = hiredate;
//	}
//	public Double getSal() {
//		return sal;
//	}
//	public void setSal(Double sal) {
//		this.sal = sal;
//	}
//	public Double getComm() {
//		return comm;
//	}
//	public void setComm(Double comm) {
//		this.comm = comm;
//	}
//	public Integer getDeptno() {
//		return deptno;
//	}
//	public void setDeptno(Integer deptno) {
//		this.deptno = deptno;
//	}
}
