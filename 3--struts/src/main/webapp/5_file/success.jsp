<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@taglib uri="/struts-tags" prefix="s" %>
备注：<s:property value="description"/>
文件名：<s:property value="fileFileName"/>
文件类型：<s:property value="fileContentType"/>
<s:a href="uploadfile!download?downFileName=%{fileFileName}">下载</s:a>
</body>
</html>