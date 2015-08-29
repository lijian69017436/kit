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
<link href="<%=basePath %>style/css.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript">
$(function(){
  $("[name='Submit']").click(function(){
    var table=$("#form11").serialize();
    $.ajax({
      type:"post",
      url:"../ExportClientServlet.do?action=insert",
      data:table,
      success:function(){
        location.href="../ExportClientServlet.do?action=getPagelist&pageNow=1";
      }
    });
  });
});
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
<form name="f1"  method="post" id="form11" >
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
      <td width="8%" height="13" nowrap class="yr_07"><div align="left">询价单号:</td>
      <td width="22%" nowrap class="yr_07"><div align="left">
        <input  class="input" name="id" type="text"  class="input" size="15"  />
       </td>
      <td width="12%" nowrap class="yr_07">
        <div align="left">客户号码:		 </td>
      <td width="23%" nowrap class="yr_07"><div align="left">
        <input name="clientnumber" id="clientnumber" type="text" size="15" class="input" ondblclick="query(this.value)">
       </td>
      <td width="8%"> 
        <div align="left"> 客户地址：</span> </td>
      <td width="27%"><div align="left">
        <input  class="input" name="clientaddress" type="text"  class="input" size="15">
       </td>
    </tr>
    <tr bgcolor="#FFFFFF" align="center">
      <td height="14" nowrap class="yr_07"><div align="left">TEL:</div> </td>
      
      <td height="14" nowrap class="yr_07"><div align="left">
        <input  class="input" name="tel" type="text" size="15"></div></td>
       
      <td width="12%" nowrap class="yr_07"><div align="left">日 期 ：  </div>  </td>      
       
      <td width="23%" nowrap class="yr_07"><div align="left">
          <input  name="dates" type="text" class="input" id="dates" size="15" >
          <img src="../images/calendar_bnt.gif" style="cursor:hand;" align="middle" alt="" > </div></td>
      
      <td nowrap class="yr_07"><div align="left">客户名称：</div> </td>
      <td nowrap class="yr_07"><div align="left">
        <input  class="input" name="names" type="text" size="15"></div></td>
       
    </tr>
    <tr bgcolor="#FFFFFF" align="center">
      <td height="28" nowrap class="yr_07"><div align="left">FAX:</div>
        
       </td>
      <td height="28" nowrap class="yr_07"><div align="left">
        <input  class="input" name="fax" type="text" size="15"></div></td>
       
      <td width="12%" nowrap class="yr_07"><div align="left">SALES / DEPT：</div></td>
      <td width="23%" nowrap class="yr_07"><div align="left">
        <input  class="input" name="sales" type="text" size="15"></div></td>
       
      <td><div align="left"> 联 系 人：</div> </td>
      <td><div align="left"> 
        <input  class="input" name="linkman" type="text" size="15"> </div> </td>
    </tr>
  </table>
  <table width="96%"  align="center">
    <tr align="right"> 
      <td> 
        <div align="center">
          <input  class="input" type="button" name="Submit" value="提交" >
          &nbsp;&nbsp;&nbsp;&nbsp;
          <input  class="input" type="reset" name="Submit2" value="重置"></div>
      </td>
    </tr>
  </table>
</form>
</body>
</html>
                                                                                                    
