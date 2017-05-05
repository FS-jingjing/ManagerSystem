<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,mil.jtaspect.entity.User"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户中心</title>
</head>
<body>
<%@ include file="head.jsp" %>
<table border="1" width="500px">
	<tr>
		<th>编号</th>
		<th>姓名</th>
		<th>性别</th>
		<th>生日</th>
		<th>住址</th>
		<th>操作</th>
	</tr>
	<%	List<User>list=(List<User>)request.getAttribute("list"); 
		for(User s:list){%>
			<tr>
				<td><%=s.getId() %></td>
				<td><%=s.getName() %></td>
				<td><% int num=s.getSex();if(num==1){out.print("男");}else{out.print("女");} %></td>
				<td><%=s.getBirthday() %></td>
				<td><%=s.getAddress() %></td>
				<td><a href="xiaohui.jsp">登录</a>&nbsp;&nbsp;<a href="zhuce.html">注册</a></td>
			</tr>
		<% } %>
	
</table>
</body>
</html>