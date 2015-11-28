<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
    <form action="../ognl/ognl!login.action" method="post">
			用户名：<input type="text" name="userName">
			密码<input type="text" name="pwd">
			<input type="submit" value="登陆">
		</form>
  </body>
</html>
