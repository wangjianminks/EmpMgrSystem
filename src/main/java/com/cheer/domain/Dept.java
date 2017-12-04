/**
 * 文件名 ：Dept.java
 *作者 ：WangJianmin
 *建立时间：2017年11月27日
 */
package com.cheer.domain;


/**
 *简述功能
 * @author WangJianmin
 * @version Dept
 * @date 下午3:38:09
 */

public class Dept
{

	private Integer deptno;

	private String dname;

	private String loc;


	public Dept()
	{
		super();
	}

	public Integer getDeptno()
	{
		return deptno;
	}

	public String getDname()
	{
		return dname;
	}

	public String getLoc()
	{
		return loc;
	}

	public void setDeptno(Integer deptno)
	{
		this.deptno = deptno;
	}

	public void setDname(String dname)
	{
		this.dname = dname;
	}

	public void setLoc(String loc)
	{
		this.loc = loc;
	}
	
	
}
