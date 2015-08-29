<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/checksession.jsp"%>
<%
request.setCharacterEncoding("utf-8");
%>
<html>
<head>
<title>百合内衣--管理系统</title>
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
		location.href="<%=request.getContextPath()%>/modifyInformation.do?act=modify&id="+id;
	}
	function view(tablename,inforid,inforcontent){
		window.open("<%=request.getContextPath()%>/queryInformationmanagement.do?inforcontent="+inforcontent+"&tablename="+tablename+"&inforid="+inforid,"newwindow", "height=600, width=650, top=50, left=170, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");	
	}
	function stcok(tablename,inforid,inforcontent,isaudit){
		window.open("<%=request.getContextPath()%>/queryInformationmanagement.do?isaudit="+isaudit+"&inforcontent="+inforcontent+"&tablename="+tablename+"&inforid="+inforid,"newwindow", "height=600, width=650, top=50, left=170, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");	
	}
	function remove(type,orderid,id){
		location.href="<%=request.getContextPath()%>/removeInformation.do?type="+type+"&orderid="+orderid+"&id="+id;
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
<form name="pageObject" action="/queryColormanagement">
    <br><br><br><br><br><br>
    <table width="80%" border="0" align="center" cellpadding="4" cellspacing="1" class="yr_05">
      <tr   align="center">  
	      <td height="23" colspan="10" class="yr_08" >信息栏</td>
	    </tr>
      <tr>	 
	    <td width="5%" nowrap class="yr_06">No.</td>
	    <td width="10%" nowrap class="yr_06">消息ID</td>
	    <td width="10%" nowrap class="yr_06">消息类型</td>
	    <td width="10%" nowrap class="yr_06">消息路径</td>
	    <td width="10%" nowrap class="yr_06">消息内容</td>
	    <td width="10%" nowrap class="yr_06">消息时间</td>
	    <td width="10%" nowrap class="yr_06">发消息人</td>
	    <td width="10%" colspan="3" nowrap class="yr_06">操作</td>
	 </tr>
	 <tr height=18>
		 <td>&nbsp;</td>
	     <td>&nbsp;</td>
		 <td>&nbsp;</td>
		 <td>&nbsp;</td>
		 <td>&nbsp;</td>
		 <td>&nbsp;</td>
	 </tr>
	 <tr>	 
	    <td width="5%" nowrap class="yr_07">id</td>
	    <td width="10%" nowrap class="yr_07">inforid</td>
	    <td width="10%" nowrap class="yr_07">infortype</td>
	    <td width="10%" nowrap class="yr_07">inforcontent</td>
	    <td width="10%" nowrap class="yr_07">inforurl</td>
	    <td width="10%" nowrap class="yr_07">infortime</td>
	    <td width="10%" nowrap class="yr_07">informan</td>
<%--	 if(isaudit==1){ --%>
	        <td width="5%" nowrap align="center" class="yr_07">[<a href="#" onClick="stcok('tablename','inforid','inforcontent','isaudit')">查看</a>]</td>
	        <td width="5%" nowrap align="center" class="yr_07">[<a href="#" onClick="modify('id')">修改</a>]</td>	        
	        <td width="5%" nowrap align="center" class="yr_07">[<a href="#" onClick="remove('inforcontent','inforid','id')">删除</a>]</td>
<%--	 }else if(isaudit==0)--%>
<%--	        <td width="5%" nowrap align="center" class="yr_07">[<a href="#" onClick="stcok('tablename','inforid','inforcontent','isaudit')">查看</a>]</td>--%>
<%--	        <td width="5%" nowrap align="center" class="yr_07">[<a href="#" onClick="modify('id')">修改</a>]</td>        --%>
<%--	        <td width="5%" nowrap align="center" class="yr_07"><font color="read">...</font></td>--%>
<%--	 }--%>
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

