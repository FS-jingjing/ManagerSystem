<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="add.action" method="POST">
<% 
	String error1=null;
	error1=(String)request.getAttribute("zcname");
%>
	<center>
		<table>
			<tr>
				<td>用户名：</td>
				<td><input name="username"/></td>
				<td><span><%=error1!=null?error1:"" %></span></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;&nbsp;码：</td>
				<td><input type="password" name="password"/></td>
				<td></td>
			</tr>
			<tr align="center">
				<td colspan="3"><input type="submit" value="注册"/></td>
			</tr>
		</table>
	</center>
</form>
</body>
</html>