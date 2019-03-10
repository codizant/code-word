package com.example.module;

public class Employee {

	private String	empno;
	private String ename;
	private String job;
	
	
	public String getEmpno() {
		return empno;
	}
	public String getEname() {
		return ename;
	}
	public String getJob() {
		return job;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", job=" + job
				+ "]";
	}
	
	
}
