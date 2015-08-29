<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/checksession.jsp"%>
<html>
<head>
<title>新增装箱</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="style" rel="stylesheet" type="text/css">
<link href="<%=basePath%>/style/css.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
$(function(){
  $("[name='Submit1']").click(function(){
    var table=$("#form11").serialize();
    alert(table);
    $.ajax({
      type:"post",
      url:"../PaymentincaseServlet.do?action=insert",
      data:table,
      success:function(){
        location.href="../PaymentincaseServlet.do?action=getPagelist&pageNow=1";
      }
    });
  });
});
</script>
</head>

<title>百合内衣--管理系统</title>
<link href="<%=basePath%>/style/css.css" rel="stylesheet" type="text/css">

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form name="f1" id="form11"  method="post" action="">
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr> 
    <td width="46%" height="30" class="yr_04"> 您的位置：库房管理&gt;&gt;新装箱单</td>
    <td width="54%" align="right" class="yr_04"> 
	
  </tr>
  </table>
  <table width="96%" border="0" align="center" cellpadding="4" cellspacing="1" class="yr_05">
    <tr  align="center">
      <td height="23" colspan="8" class="yr_08" > <span class="yr_04">新装箱</span></td>
    </tr>
    <tr  >  
      <td nowrap class="yr_07">PI号：</td>
      <td nowrap class="yr_07">
          <input  class="input" name="plid" type="text" size="15" ></td> 
      <td nowrap class="yr_07">公司编号：</td>
      <td nowrap class="yr_07">
          <input  class="input" name="companycode" type="text" size="15" ></td> 
      <td width="25%" nowrap class="yr_07">客户编号:</td>
      <td nowrap class="yr_07">
          <input   class="input"  name="clientcode" type="text" size="15" >      </td>
      <td nowrap class="yr_07">日期：</td>
      <td nowrap class="yr_07">
          <input  class="input"  name="numbers" type="text" size="15"  >     
          <img src="../images/calendar_bnt.gif" style="cursor:hand;" align="absmiddle" alt="" onClick="fPopUpCalendarDlg(numbers);return false"> </td> 
    </tr>
	<tr >
      <td width="25%" nowrap class="yr_07">净重:</td>
      <td class="yr_07"><input  class="input" name="suttle" type="text" size="15" >      </td> 
	  <td width="25%" nowrap class="yr_07">毛重:</td>
      <td class="yr_07"><input  class="input" name="grossweight" type="text" size="15" >      </td> 
      <td width="25%" nowrap class="yr_07">外箱尺寸:</td>
      <td class="yr_07" colspan="3"><input  class="input" name="sizes" type="text" size="15" >      </td> 
      <input class="input" name="documentname" type="hidden" size="15" >    
    </tr>
  </table>
  <div align="center"><br>
    <input  class="input" type="button" name="Submit1" value="提交">
    <input  class="input" type="reset" name="Submit" value="重写">
   
</form>
</body>
</html>
<script Language="JavaScript" src="../js/pub_Calendar.js"></script>
                                                                                                    
