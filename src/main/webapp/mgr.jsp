<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ page import="com.cheer.domain.Emp,com.cheer.util.DBHelper,java.sql.*,java.util.*"%>
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

 <%
 	DBHelper db = DBHelper.getInstance();
   Connection conn=null;
   PreparedStatement pstmt=null;
   ResultSet rs=null;
  %>
  <%
    try
    {
	conn = db.getConnection();
      String sql="SELECT * FROM tbl_emp";
      pstmt=conn.prepareStatement(sql);
      rs=pstmt.executeQuery();
   %>
<div id="menu">
<!-- onclick="window.loction.href='  ' "-->
<a href="http://localhost:8080/EmpMgrSystem/inster.jsp">增加新员工</a>
</div>
   <table border="1" cellspacing="0" align="center" >
   <tr>
   <td>雇员编号</td>
   <td>雇员姓名</td>
   <td>雇员工作</td>
    <td>雇员工资</td>
    <td>雇员日期</td>
    <th>操作</th>
</tr>
<%
List<Emp> list = new ArrayList<>();

    while(rs.next())
    {
     int empno=rs.getInt("empno");
     String ename=rs.getString("ename");
     String job=rs.getString("job");
     double sal=rs.getDouble("sal");
     java.util.Date  date=rs.getDate("hiredate");
     
     list.add(new Emp(empno, ename, job,date,sal));
    }
    session.setAttribute("list",list);
    for(Emp e : (List<Emp>)session.getAttribute("list"))
    {
    %>
<tr>
<td><%=e.getEmpno() %></td>
		<td><%=e.getEname() %></td>
		<td><%=e.getJob() %></td>
		<td><%=e.getHiredate() %></td>
		<td><%=e.getSal() %></td>
<td>
<a href="servlet/mgrSystem?empno=<%=e.getEmpno() %>">删除</a>
&nbsp;
<a href="update.jsp?empno=<%=e.getEmpno() %>">修改</a>
</td>
</tr>
<%
    }
   %>
 <!--  <tr>
   <td colspan=6> <a href=">插入新数据</a></td>
   </tr> -->
   </table>

   <%
   }
     catch(Exception e)
      {
         System.out.println(e);
      }
  finally
      {
    	  DBHelper.closeResultSet(rs);
    	  DBHelper.closeStatement(pstmt);
    	  DBHelper.closeConnection(conn);
       }
    %>

</form>
</body>
</html>