<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/checksession.jsp"%>
<%

	request.setCharacterEncoding("utf-8");
	String id=request.getParameter("id");
	String audittype=request.getParameter("audittype");
	String tablename=request.getParameter("tablename");
	System.out.println(tablename+"------tablename-------");
	//String username=(String) session.getAttribute(LoginConstants.GLOBLE_STAFF_NAME);
	//PageListVO rvo = null;
	//rvo=(PageListVO)AuditstaffManagerFactory.getAuditstaffManager().getAll(audittype);
	//ArrayList ListResult = (ArrayList) rvo.getretVO();
	//request.setAttribute("auditstaff", ListResult);//杩斿洖form鍙奓istResult鏁版嵁闆
%>
<html>
<head>
<title>百合内衣--管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<%=basePath %>style/css.css" type="text/css">
<style type="text/css">
<!--
.style1 {color: #FF0000}
-->
</style>
</head>

<script language=javascript>
	
	function condition(theform)
	{
		if(theform.pname.value.length==0)
		{
			alert("璇疯緭鍏ュ悕瀛楋紒");
			theform.pname.focus();  
			return false;
		}
		if(theform.ppass.value.length==0)
		{
			alert("璇疯緭鍏ュ瘑鐮侊紒");
			theform.ppass.focus();
			return false;
		}
		if(theform.psex.value.length==0)
		{
			alert("璇疯緭鍏ユ€у埆锛?);
			theform.psex.focus();
			return false;
		}
		if(theform.ptel.value.length==0)
		{
			alert("璇疯緭鍏ョ數璇濓紒");
			theform.ptel.focus();
			return false;
		}	
		if(theform.paddr.value.length==0)
		{
			alert("璇疯緭鍏ュ湴鍧€锛?);
			theform.paddr.focus();
			return false;
		}		
	}
	
</script>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
<form name="f1" method="post" action="<%=basePath %>audit/successflly.jsp">
<br>
<table width="400" border="0" align="center" cellpadding="4" cellspacing="1" class="yr_05">
    <tr   align="center"> 
      <td height="23" colspan="10" class="yr_08" >提审单据</td>
    </tr>
    <tr bgcolor="#FFFFFF">
      <td height="28" nowrap  class="yr_07"><div align="right">提审人: </td>
      <td nowrap  class="yr_07">
        <div align="justify">
          <input   name="staffid" value="username" readonly="readonly" type="text" size="10">
         </td>
    </tr>
    <tr bgcolor="#FFFFFF"> 
      <input type="hidden" name="id">
      <td width="13%" height="13" nowrap  class="yr_07"><div align="right">审核人: </td>
      <td width="25%" nowrap  class="yr_07">
        <div align="justify">
          <select name="auditstaffid">
				<option value=" pro" property="orderid">staffname</option>
		</select>
         </td>
   </tr>
    <tr bgcolor="#FFFFFF">
      <td height="14" nowrap  class="yr_07"><div align="right">单据编号: </td>
      <td width="25%" nowrap  class="yr_07">
        <div align="justify">
          <input   name="orderid" type="text" size="10"  value="<%=id%>" readonly="">
         </td>
    </tr>
    <tr bgcolor="#FFFFFF">
      <td height="28" nowrap  class="yr_07"><div align="right">审核单据: </td>
      <td width="25%" nowrap  class="yr_07">
        <div align="justify">
          <input   name="audittype" type="text" size="10"  value="<%=audittype%>"  readonly="" >
         </td>
    </tr>
          <input name="state" type="hidden"   value="id" size="10">
          <input name="audittime" type="hidden" value="tablename"   size="10">
        
    <tr bgcolor="#FFFFFF">
      <td height="28" nowrap  class="yr_07"><div align="right">审核说明: </td>
      <td width="25%" nowrap  class="yr_07">
        <div align="justify">
          <input   name="remark" type="text" size="15" >
         </td>
    </tr>
  </table>
  <p align="center">
    <input   type="submit" name="Submit" value="提交" >
    <input   type="reset" name="Submit2" value="重写">
  </p>
</form>
</body>
</html>

