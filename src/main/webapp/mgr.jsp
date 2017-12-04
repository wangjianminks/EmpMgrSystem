<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ page import="com.cheer.domain.*,com.cheer.util.*,com.cheer.service.*,com.cheer.web.servlet.*,java.sql.*,java.util.*,java.text.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<title>首页</title>
<style type="text/css">
/*对menu层设计*/
		#menu{
			width: 100px;	/*相对单位的优势是当访问者在浏览器调整了文字的大小，容器的大小可以自动调整*/
			margin: 0 auto;
			font-family: Arimal;
			font-size: 14px;
			border:solid 1px #aaa; /*细灰色边框*/
		}

		/*设置菜单选项*/
		#menu a, #menu a:visited{
			display: block;
			text-decoration: none;
			color: #000; /*黑色*/
			line-height: 1.4em;  /*文字上下会各产生0.2em的空白*/
			border:0.5em solid #fff;  /*白色背景，防止跳动*/
		}
		/*鼠标经过时的效果*/
		#menu a:hover{
			color: #fff;
			background-color: #aaa; /*深灰色*/
			border-color: #ddd #aaa; /*浅灰*/
		}
</style>
</head>
<body>
<form method="post">


<div id="menu">
<!-- onclick="window.loction.href='  ' "-->
<a href="http://localhost:8080/EmpMgrSystem/inster.jsp">增加新员工</a>
</div>


		
   <table border="1" cellspacing="0" align="center" >
   <tr>
   <td>雇员编号</td>
   <td>雇员姓名</td>
   <td>雇员工作</td>
   <td>上司</td>
   <td>雇员日期</td>
    <td>雇员工资</td>
    <td>奖金</td>
    <th>操作</th>
</tr>
<%
		    EmpService empService = (EmpService)application.getAttribute("empService");

		    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		    
		    request.setAttribute("empList", empService.getAll());
		%>
<c:forEach var="emp" items="${empList }">
<tr>
	<td>${emp.empno}</td>
		<td>${emp.ename }</td>
		<td>${emp.job }</td>
		<td>${emp.mgr }</td>
		<td>${emp.hiredate }</td>
		<td>${emp.sal }</td>
		<td>${emp.comm }</td>
<td>
<a href="servlet/mgrSystem?empno=${emp.empno }">删除</a>
&nbsp;
<a href="update.jsp?empno=${emp.empno }">修改</a>
</td>
</tr>
</c:forEach>

 <!--  <tr>
   <td colspan=6> <a href=">插入新数据</a></td>
   </tr> -->
   </table>


</form>
</body>
</html>