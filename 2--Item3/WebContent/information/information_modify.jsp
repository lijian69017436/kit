<%@ page contentType="text/html; charset=utf-8" %>
<%--<%@page import="cn.bway.foreigntrade.information.model.Information,java.util.*"%>--%>

<%@ include file="/checksession.jsp"%>
<%--<%--%>
<%----%>
<%--request.setCharacterEncoding("utf-8");--%>
<%--Information per=(Information)request.getAttribute("ModilfyInformation");--%>
<%--%>--%>
<html>
<head>
<title>百合内衣--系统</title>
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
<script src="js/common.js" language=javascript></script>
<script src="js/Calendar.js" language=javascript></script>
<script src="js/popwin.js" language=javascript></script>
<script src="js/checkForm.js" language=javascript></script>
<script language="javascript">
	function Page(pageNum){
	if(checkNum(pageNum)==0) {
   		alert("要跳转的页数必须是大于0的数字！");
   		return;
	}
	
	var page_objForm=document.forms[0];
	page_objForm.pageNum.value= pageNum;
        page_objForm.action="<%=request.getContextPath()%>/showInformation.do";
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
<html:form name="pageObject" action="/modifyInformation" type="cn.bway.foreigntrade.information.form.InformationForm" scope="request">
    <br><br><br><br><br><br>
    <table width="80%" border="0" align="center" cellpadding="4" cellspacing="1" class="yr_05">
      <tr   align="center">  
	      <td height="23" colspan="10" class="yr_08" >信息栏</td>
	    </tr>
	    <input  class="input" name="id" type="hidden" size="10" value="getId()%>" >
      <tr bgcolor="#FFFFFF"> 
      <td height="13" nowrap class="yr_07"><div align="left">消息ID：
          <input  class="input" name="inforid" type="text" size="10" value="getInforid()%>" readonly="">
       </td>
      <td nowrap class="yr_07"><div align="left">消息类型：
          <input  class="input" name="infortype" type="text" size="10" value="getInfortype() %>" readonly="">
       </td>
      <td nowrap class="yr_07"><div align="left">消息内容：
         <input  class="input" name="inforcontent" type="text" size="10" value="getInforcontent() %>"  readonly="">
       </td>
    </tr>
    <tr bgcolor="#FFFFFF">
      <td height="14" nowrap class="yr_07"><div align="left">消息路径：
          <input  class="input" name="inforurl" type="text" size="10"  value="getInforurl()">
       </td>
      <td height="14" nowrap class="yr_07"><div align="left">消息时间：
          <input  class="input" name="infortime" type="text" size="10"  value="getInfortime()">
       </td>
      <td height="14" nowrap class="yr_07"><div align="left">发消息人：
          <input  class="input" name="informan" type="text" size="10"  value="getInforman()">
          <input  class="input" name="inforget" type="hidden" size="10"  value="getInforget()">
       </td>
    </tr>
    </table>
  <div align="center">
    <p>
      <input  class="input" type="submit" name="Submit" value="提交">
      <input  class="input" type="reset" name="Submit" value="重写">
      <br>
    </p>
   
</html:form>
</body>
</html>

