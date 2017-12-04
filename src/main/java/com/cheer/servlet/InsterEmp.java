/**
 * 文件名 ：InsterEmp.java
 *作者 ：WangJianmin
 *建立时间：2017年11月28日
 */
package com.cheer.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cheer.util.DBHelper;

/**
 * 简述功能
 * 
 * @author WangJianmin
 * @version InsterEmp
 * @date 下午4:53:48
 */
@WebServlet("/servlet/insterEmp")
public class InsterEmp extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		resp.setContentType("text/html;charset=utf-8");
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try
		{
			conn = DBHelper.getInstance().getConnection();
			String sql = "insert into tbl_emp(empno, ename, job, hiredate, sal) values(?, ?, ?, TO_DATE(?, \'yyyy-mm--dd\'), ?)";

			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, Integer.valueOf(req.getParameter("empno")));
			psmt.setString(2, req.getParameter("ename"));
			psmt.setString(3, req.getParameter("job"));
			psmt.setString(4, req.getParameter("hiredate"));
			psmt.setDouble(5, Double.valueOf(req.getParameter("sal")));
			rs = psmt.executeQuery();

		} catch (NumberFormatException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBHelper.closeResultSet(rs);
			DBHelper.closeStatement(psmt);
			DBHelper.closeConnection(conn);
		}
		resp.sendRedirect("../mgr.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{

		this.doPost(req, resp);
	}

}
