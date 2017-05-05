<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">  
    var time = 4;  
  
    function countTime() {  
  
        window.setTimeout('returnUrlByTime()', 1000);  
  
        time = time - 1;  
  
        document.getElementById("jishi").innerHTML = time;  
    }  
</script>
</head>
<body onload="countTime()">
<h3>请勿重复提交您的信息！谢谢！</h3>  
    <b><span id="jishi"></span>秒后，转入输入界面。</b>  
      
    <%  
        //转向语句  
        response.setHeader("Refresh", "3;URL=load.jsp");  
    %>  
</body>
</html>