/**
 * 文件名 ：Emp.java
 *作者 ：WangJianmin
 *建立时间：2017年11月27日
 */
package com.cheer.domain;

import java.util.Date;


/**
 *简述功能
 * @author WangJianmin
 * @version Emp
 * @date 下午3:38:33
 */

public class Emp
{
	 private static final long serialVersionUID = -2126185781775441109L;

    private Integer empno;

    private String ename;

    private String job;

    private Integer mgr;

    private Date hiredate;

    private Double sal;

    private Double comm;

    private Dept dept;

    

	public Emp()
	{

	}
	

	/**
	 * @param empno
	 * @param ename
	 * @param job
	 * @param hiredate
	 * @param sal
	 */
	public Emp(Integer empno, String ename, String job, Date hiredate, Double sal)
	{
		this();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.hiredate = hiredate;
		this.sal = sal;
	}


	public Integer getEmpno()
	{
		return empno;
	}

	public String getEname()
	{
		return ename;
	}

	public String getJob()
	{
		return job;
	}

	public Integer getMgr()
	{
		return mgr;
	}

	public Date getHiredate()
	{
		return hiredate;
	}

	public Double getSal()
	{
		return sal;
	}

	public Double getComm()
	{
		return comm;
	}

	public Dept getDept()
	{
		return dept;
	}

	public void setEmpno(Integer empno)
	{
		this.empno = empno;
	}

	public void setEname(String ename)
	{
		this.ename = ename;
	}

	public void setJob(String job)
	{
		this.job = job;
	}

	public void setMgr(Integer mgr)
	{
		this.mgr = mgr;
	}

	public void setHiredate(Date hiredate)
	{
		this.hiredate = hiredate;
	}

	public void setSal(Double sal)
	{
		this.sal = sal;
	}

	public void setComm(Double comm)
	{
		this.comm = comm;
	}

	public void setDept(Dept dept)
	{
		this.dept = dept;
	}

}

