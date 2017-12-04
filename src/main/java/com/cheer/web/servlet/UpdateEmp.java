/**
 * 文件名 ：UpdateEmp.java
 *作者 ：WangJianmin
 *建立时间：2017年11月30日
 */
package com.cheer.web.servlet;

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
 *简述功能
 * @author WangJianmin
 * @version UpdateEmp
 * @date 上午8:56:58
 */
@WebServlet("/servlet/updateEmp")
public class UpdateEmp extends HttpServlet
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
			String sql ="UPDATE tbl_emp SET ename = ?, sal = ? , hiredate = TO_DATE(?, \'YYYY-MM--DD\'),  job = ?WHERE empno = ?";

			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, req.getParameter("ename"));
			psmt.setDouble(2, Double.valueOf(req.getParameter("sal")));
			psmt.setString(3, req.getParameter("hiredate"));
			psmt.setString(4, req.getParameter("job"));
			psmt.setInt(5, Integer.valueOf(req.getParameter("empno")));

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
