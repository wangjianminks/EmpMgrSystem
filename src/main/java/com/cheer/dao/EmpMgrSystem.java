/**
 * 文件名 ：EmpMgrSystem.java
 *作者 ：WangJianmin
 *建立时间：2017年11月27日
 */
package com.cheer.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cheer.domain.Emp;
import com.cheer.util.DBHelper;

/**
 * 简述功能
 * 
 * @author WangJianmin
 * @version EmpMgrSystem
 * @date 下午7:45:30
 */
@WebServlet("/servlet/mgrSystem")
public class EmpMgrSystem extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	private DBHelper db = DBHelper.getInstance();

	@Override
	public void init(ServletConfig config) throws ServletException
	{

		super.init(config);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		resp.setContentType("text/html;charset=utf-8");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String empno = req.getParameter("empno");

		@SuppressWarnings("unchecked")
		List<Emp> empList = (List<Emp>) req.getSession().getAttribute("list");

		for (Emp e : empList)
		{
			if (e.getEmpno().toString().equals(empno))
			{
				String sql = "DELETE FROM  tbl_emp WHERE empno = ?";

				try
				{
					conn = db.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, empno);
					rs = pstmt.executeQuery();
				} catch (SQLException e1)
				{
					e1.printStackTrace();
				} finally
				{
					DBHelper.closeResultSet(rs);
					DBHelper.closeStatement(pstmt);
					DBHelper.closeConnection(conn);
				}
				resp.sendRedirect("../mgr.jsp");
				return;
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{

		this.doPost(req, resp);
	}

}
