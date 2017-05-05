<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mil.jtaspect.entity.Student" %> 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>

<script src="jquery/jquery.min.js"></script>

</head>
<body>
	<center>
		<form action="login.action" method="POST">
		
			<%
				String username=null;
				String password=null;
				String error1=null;
				String error2=null;
				String error3=null;
				error1=(String)request.getAttribute("error1");
				
				error2=(String)request.getAttribute("error2");
				
				error3=(String)request.getAttribute("error3");
				
				if(session.getAttribute("stu")!=null){
					Student stu=(Student)session.getAttribute("stu");
					username=stu.getSid();
					password=stu.getSpass(); 
				}
				
			%>
			<table border="0">
				<tr align="center">
					<td>用户名：</td><td><input name="username" value="<%=username!=null?username:"" %>"/></td><td><span><%=error2!=null?error2:"" %></span></td>
				</tr>
				<tr align="center">
					<td>密码：</td><td><input type="password" name="password" value="<%=password!=null?password:"" %>"/></td><td><span><%=error3!=null?error3:"" %></span></td>
				</tr>
				<tr align="center">
					<td>验证码：</td><td><input name="code"/></td><td><span><%=error1!=null?error1:"" %></span></td>
				</tr>
				<tr align="center">
					<td colspan="2"><img src="yzcode" id="img" onclick="this.src='yzcode?'+Math.random()"/></td><td><a href="javascript:;" onclick="document.getElementById('img').src='yzcode?'+Math.random();">看不清</a></td>
				</tr>
			</table>
		
		<input type="submit" value="登录"/>
		</form>
	</center>
</body>
</html>