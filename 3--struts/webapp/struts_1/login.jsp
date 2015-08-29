<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <a href="../login.do">登陆</a>
  
  <form action="../a.do" method="post">
            用户名：<input type="text" name="ee.name"/>
    <input type="submit" value="用户名提交"/>
  </form>
  
  <s:property value="11"/>
</body>
</html>