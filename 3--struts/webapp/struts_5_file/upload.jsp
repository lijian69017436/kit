<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@taglib uri="/struts-tags"  prefix="s"%>
	<s:form action="upload" enctype="multipart/form-data" method="post">
		<s:file name="file" label="选择上传文件"></s:file>
		<s:textfield name="description" label="描述"></s:textfield>
		<s:submit value="上传"></s:submit>
	</s:form>
</body>
</html>

