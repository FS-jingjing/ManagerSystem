<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,mil.jtaspect.entity.Student"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="head.jsp" %>
<table border="1" width="500px">
	<tr>
		<th>用户名</th>
		<th>密码</th>
		<th>操作</th>
	</tr>
			<% List<Student>list=(List<Student>)request.getAttribute("list"); 
			for(Student s:list){%>
				<tr>
					<td><%=s.getSid() %></td>
					<td><%=s.getSpass() %></td>
					<td><a href="del.action?id=<%=s.getSid() %>">删除</a>&nbsp;&nbsp;<a href="zhuce.html">注册</a></td>
				</tr>
			<%}%>
</table>
</body>
</html>