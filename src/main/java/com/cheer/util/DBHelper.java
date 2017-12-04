package com.cheer.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBHelper
{
	private static final Logger LOGGER = LogManager.getLogger(DBHelper.class);

	//饿汉式单例
	private static final DBHelper INSTANCE = new DBHelper();

	//构造函数私有化
	private DBHelper(){}

	//提供一个获取实例的方法
	public static DBHelper getInstance()
	{
		return INSTANCE;
	}

	public Connection getConnection()
	{

		String url = null;
		String username = null;
		String password = null;

		InputStream in = null;

		
		try
		{
			// 将当前路径下config文件夹下的db.properties文件读取到流中
            in = DBHelper.class.getResourceAsStream("/config/db.properties");
            
            // 创建一个Properties对象，它继承HashTable
            Properties props = new Properties();
            
            // Properties加载流
            props.load(in);

			url = props.getProperty("url");
			username = props.getProperty("username");
			password = props.getProperty("password");
		}
		catch(IOException e)
		{
			LOGGER.catching(e);
		}
		finally
		{
			if (in != null)
			{
				try
				{
					in.close();
				}
				catch(IOException e)
				{
					LOGGER.catching(e);
				}
			}
		}
		
		Connection conn = null;
		
		try
		{
			//反射   加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//获取连接
			conn = DriverManager.getConnection(url, username, password);
			
		}
		catch(ClassNotFoundException e)
		{
			LOGGER.catching(e);
		}
		catch(SQLException e)
		{
			LOGGER.catching(e);
		}
		return conn;
	}

	public static void closeConnection(Connection conn)
	{
		if (conn != null)
		{
			try
			{
				conn.close();
			}
			catch(SQLException e)
			{
				LOGGER.catching(e);
			}
		}
	}

	public static void closeStatement(Statement stat)
	{
		if (stat != null)
		{
			try
			{
				stat.close();
			}
			catch(SQLException e)
			{
				LOGGER.catching(e);
			}
		}
	}

	public static void closeResultSet(ResultSet rs)
	{
		if (rs != null)
		{
			try
			{
				rs.close();
			}
			catch(SQLException e)
			{
				LOGGER.catching(e);
			}
		}
	}
}

