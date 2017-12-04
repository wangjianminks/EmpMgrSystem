<?xml version="1.0" encoding="utf-8" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="com.cheer.util.*,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>update</title>
</head>
<body>
	<%
	Integer empno = 0;
	try
	{
		empno = Integer.valueOf(request.getParameter("empno"));
	}
	catch(NumberFormatException e)
	{
		e.printStackTrace();
	}
	%>
	<form action="http://localhost:8080/EmpMgrSystem/servlet/updateEmp" style="text-align:center">
<table border="1" align="center">
<tr><td>员工号</td><td><input type="text" size="40px" name="empno" value="<%= empno %>"></input></td></tr>
<tr><td>员工姓名:</td><td><input type="text" size="40px" name="ename" ></input></td></tr>
<tr><td>员工薪资:</td><td><input type="text" size="40px" name="sal" ></input></td></tr>
<tr><td>员工就职日期:</td><td><input type="text" size="40px" name="hiredate" ></input></td></tr>
<tr><td>员工工作:</td><td><input type="text" size="40px" name="job"></input></td></tr>
</table>
<input type="submit"   value="提交"></input>
</form>

		
		

</body>
</html>