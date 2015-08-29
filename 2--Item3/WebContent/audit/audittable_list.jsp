<%@ page contentType="text/html; charset=utf-8" %>
<%-- <%@page import="cn.bway.foreigntrade.operation.units.model.Units,java.util.*"%>--%>

<%@ include file="/checksession.jsp"%>
<html>
<head>
<title>百合内衣管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="style/css.css" type="text/css">
<style type="text/css">
<!--
.style1 {color: #FF0000}
.style2 {color: #FFFFFF;
	font-weight: bold;
}
.style3 {color: #FFFFFF}
-->
</style>
<script language="javascript">
	function Page(pageNum){
	if(checkNum(pageNum)==0) {
   		alert("要跳转的页数必须是大于0的数字！");
   		return;
	}
	
	var page_objForm=document.forms[0];
	page_objForm.pageNum.value= pageNum;
        page_objForm.action="<%=request.getContextPath()%>/showCountryport.do";
        page_objForm.target="";
		page_objForm.submit();
	}
	function customSubmit(pInput,pURL)
	{
		var theForm=document.forms[0];
		theForm.pageNum.value=1;
		theForm.submit();
	}
	function modify(id){
		location.href="<%=request.getContextPath()%>/modifyCountryport.do?act=modify&id="+id;
	}
	function remove(id){
		location.href="<%=request.getContextPath()%>/removeCountryport.do?id="+id;
	}
	function customSubmit(pInput,pURL)
	{
		var theForm=document.forms[0];
		theForm.pageNum.value=1;
		theForm.submit();
	}
</script>

</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr> 
	    <td width="46%" height="30" class="yr_04"> 您的位置：审核管理&gt;&gt;已审核</td>
	    <td width="54%" align="right" class="yr_04">
  </table>
<form name="pageObject" action="/queryCountryport">
  <table width="96%" border="0" align="center" cellpadding="4" cellspacing="1" class="yr_05">
    <tr   align="center">  
      <td height="23" colspan="10" class="yr_08" >已审核</td>
    </tr>
    <tr bgcolor="#FFFFFF"> 
      <td width="14%" height="28" nowrap class="yr_07">选择区域：
        <select name="types">
        	<option >国外</option>
        	<option>国内</option>
        </select></td>
      <td width="29%" nowrap class="yr_07">单据名称：
	  	<input   name="portchiness" type="text" size="18">	  
	  </td>
      <td width="57%" nowrap class="yr_07"><div align="center">
          <input   type="submit" name="Submit" value="查询" class="button"> 
          <input   type="reset" name="Submit2" value="重写" class="button"> 
      </td>
    </tr>
  </table>
  <br>
  <table width="96%" border="0" align="center" cellpadding="4" cellspacing="1" class="yr_05">
    <tr> 
      <td width="10%"   class="yr_06"><div align="center">编号 </td>
      <td width="5%"  nowrap  class="yr_06"><div align="center">提审人 </td>      
      <td width="10%"  nowrap  class="yr_06"><div align="center">审核人 </td>
      <td width="10%"  nowrap  class="yr_06"><div align="center">单据类型 </td>
      <td width="20%"  nowrap  class="yr_06"><div align="center">单据编号 </td>
      <td width="10%"  nowrap  class="yr_06"><div align="center">审核状态 </td>
      <td width="10%"  nowrap  class="yr_06"><div align="center">提审时间 </td>
      <td  width="10%"  nowrap  class="yr_06"><div align="center">备注 </td>
    </tr>
	 <tr height=18>
		 <td>&nbsp;</td>
	     <td>&nbsp;</td>
		 <td>&nbsp;</td>
		 <td>&nbsp;</td>
		 <td>&nbsp;</td>
		 <td>&nbsp;</td>
		 <td>&nbsp;</td>
		 <td>&nbsp;</td>
		 <td>&nbsp;</td>
		 <td>&nbsp;</td>
	 </tr>
	 <tr>
	    <td width="10%" nowrap class="yr_07"> id </td>
	    <td width="5%" nowrap class="yr_07"> staffid </td>
	    <td width="10%" nowrap class="yr_07"> auditstaffid </td>
	    <td width="10%" nowrap class="yr_07"> audittype </td>
	    <td width="20%" nowrap class="yr_07"> orderid </td>
	    <td width="10%" nowrap class="yr_07"> state </td>
	    <td width="10%" nowrap class="yr_07"> audittime </td>
	    <td width="10%" nowrap class="yr_07"> remark </td>
	 </tr>
    </table>
<table width="96%"  align="center">
    <tr align="right">
      <td> 共有<span class="style1">31</span>页<span class="style1">301</span>条记录，当前为第<span class="style1">1</span>页 <a href="#">第一页</a> <a href="#">前一页</a> <a href="#">下一页</a> <a href="#">最后页</a> 每
        <input  class="input" name="textfield32" type="text" size="2" class="input">
        页条 到第
        <input  class="input" name="textfield32" type="text" size="2" class="input">
        页 </td>
    </tr>
  </table>
</form>
</body>
</html>

