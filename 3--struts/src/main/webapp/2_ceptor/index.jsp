<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
    This is my JSP page. <br>
    <a href="/ceptor/ceptor.action">-----</a>
	<form action="/ceptor/ceptor!act.do" method="post">
		用户名：<input type="text" name="userName">
		密码<input type="text" name="pwd">
		<input type="submit" value="登陆">
	</form>
  </body>
</html>
