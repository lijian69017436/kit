<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/checksession.jsp"%>
<html>
<head>
<title>百合内衣--管理系统</title>
<link href="style" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/style/css.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$("#submit11").click(function(){
		var form=$("[name='f1']").serialize();
		$.ajax({
			type:"post",
			url:"<%=basePath%>ExportClientServlet.do?action=update",
      data:form,
      success:function(){
        location.href="<%=basePath%>ExportClientServlet.do?action=getPagelist&pageNow=1";
      }
		});
	});
});



</script>

</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
<form name="f1"  method="post" action="">
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr> 
    <td width="46%" height="30" class="yr_04">&nbsp;<br><br></td>
    <td width="54%" align="right" class="yr_04">&nbsp;  </td>
  </tr>
  </table>
  <table width="96%" border="0" align="center" cellpadding="4" cellspacing="1" class="yr_05">
    <tr  align="center">
      <td height="80" colspan="8" class="yr_08" >新增出口询价</td>
    </tr>
    <tr bgcolor="#FFFFFF" align="center"> 
        <td width="8%" height="13" nowrap class="yr_07"><div align="left">询价单号:
         </td>
        <td width="22%" nowrap class="yr_07"><div align="left">
          <input  class="input" name="id" type="text"  class="input" size="15" value="${ex.id }" readonly="">
        </td>
        <td width="12%" nowrap class="yr_07">
          <div align="left">客户号码:		 </td>
        <td width="23%" nowrap class="yr_07"><div align="left">
          <input name="clientnumber"  value="${ ex.clientnumber} " id="clientnumber"  type="text" size="15" class="input" ondblclick="query(this.value)">
         </td>
        <td width="8%"> 
          
          <div align="left"> 客户地址：</span> </td>
        <td width="27%"><div align="left">
          <input  class="input" name="clientaddress" type="text" value="${ ex.clientaddress}" class="input" size="15">
         </td>
    </tr>
    <tr bgcolor="#FFFFFF" align="center">
      <td height="14" nowrap class="yr_07"><div align="left">TEL:
       </td>
      <td height="14" nowrap class="yr_07"><div align="left">
        <input  class="input" name="tel"  value="${ ex.tel}" type="text" size="15">
       </td>
      <td width="12%" nowrap class="yr_07"><div align="left">日 期 ：          
       </td>
      <td width="23%" nowrap class="yr_07"><div align="left">
        <input  name="dates"  value="${ ex.dates}" type="text" class="input" id="dates" size="15"  readonly="">
      <img src="<%=basePath %>/images/calendar_bnt.gif" style="cursor:hand;" align="absmiddle" alt="" onClick="fPopUpCalendarDlg(dates);return false"> </td>
      <td nowrap class="yr_07"><div align="left">客户名称：
        
       </td>
      <td nowrap class="yr_07"><div align="left">
        <input  class="input" name="names"  value="${ ex.names}" type="text" size="15">
       </td>
    </tr>
    <tr bgcolor="#FFFFFF" align="center">
      <td height="28" nowrap class="yr_07"><div align="left">FAX:
        
       </td>
      <td height="28" nowrap class="yr_07"><div align="left">
        <input  class="input" name="fax" value="${ ex.fax}"  type="text" size="15">
       </td>
      <td width="12%" nowrap class="yr_07"><div align="left">SALES / DEPT：
        
       </td>
      <td width="23%" nowrap class="yr_07"><div align="left">
        <input  class="input" name="sales" value="${ ex.sales}"  type="text" size="15">
       </td>
      <td><div align="left"> 联 系 人：
        
      </span> </td>
      <td><div align="left"> 
        <input  class="input" name="linkman"  value="${ ex.linkman}" type="text" size="15">
      </span> </td>
    </tr>
  </table>
  <table width="96%"  align="center">
    <tr align="right"> 
      <td> 
        <div align="center">
          <input  class="input" type="button" id="submit11"name="Submit1" value="提交" >
          &nbsp;&nbsp;&nbsp;&nbsp;
          <input  class="input" type="reset" name="Submit2" value="重置">
        <div align="center"> 
      </td>
    </tr>
  </table>
</form>
</body>
</html>
                                                                                                    
