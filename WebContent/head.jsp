<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mil.jtaspect.entity.Student" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>头部</title>
</head>
<body>
<% if(session.getAttribute("stu")!=null){
	Student stu=(Student)session.getAttribute("stu");
%>
	<span>您现在登陆的是：<%=stu.getSid() %></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span><a href="xiaohui.jsp">安全退出</a></span>
<%}else{%>
<span>您现在没有登录：<a href="load.jsp">登录</a></span>
<%} %>
</body>
</html>