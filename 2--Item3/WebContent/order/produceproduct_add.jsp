<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/checksession.jsp"%>
<html>
<head>
<title>百合内衣--管理系统</title>
<link href="<%=basePath%>style/css.css" rel="stylesheet" type="text/css">
<% String orderid=(String)request.getParameter("id"); %>

<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript">
$(function(){
  $("[name='Submit']").click(function(){
    var table=$("#form11").serialize();
    alert(table);
    $.ajax({
      type:"post",
      url:"../ProduceproductServlet.do?action=insert",
      data:table,
      success:function(){
        location.href="../ProduceproductServlet.do?action=getPagelist&pageNow=1";
      }
    });
  });
});
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form name="pageObject" id="form11" action="" >
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr> 
    <td width="46%" height="30" class="yr_04"> 您的位置：业务平台&gt;&gt;新增通知产品</td>
    <td width="54%" align="right" class="yr_04"> 
	
  </tr>
  </table>
  <table width="96%" border="0" align="center" cellpadding="4" cellspacing="1" class="yr_05">
    <tr  align="center">
      <td height="23" colspan="10" class="yr_08" > <span class="yr_04">新增生产通知产品</span></td>
    </tr>
    <tr bgcolor="#FFFFFF" align="center">
      <td width="8%" nowrap class="yr_07"><div align="left">订单号：  </td>
      <td width="14%" nowrap class="yr_07"><div align="left">
          <input  name="orderid" type="text"  class="input" size="15" value="" >
      </td>
      <td nowrap class="yr_07"><div align="left">货品编号:  
      <td nowrap class="yr_07"><div align="left">
          <input  class="input" name="productcode" type="text" size="15">
      </td>
      <td width="10%" nowrap class="yr_07"><div align="left">货品名称： </td>
      <td nowrap class="yr_07"><div align="left">
          <input  class="input" name="productname" type="text" size="15">
      </td>
      <td nowrap class="yr_07"><div align="left">型号规格： </td>
      <td nowrap class="yr_07"><div align="left">
          <input  class="input" name="guige" type="text" size="15" >
      </td> 
    </tr>
	  <tr bgcolor="#FFFFFF" align="center">
	    <td width="8%" nowrap class="yr_07"><div align="left">颜色:  </td>
	    <td width="14%" nowrap class="yr_07"><div align="left">
	      <input  class="input" name="color" type="text" size="15">
        </td>
	    <td nowrap class="yr_07"><div align="left">单 位:  </td>
	    <td nowrap class="yr_07"><div align="left">
	      <input  class="input" name="unit" type="text" size="15">
        </td>
	    <td nowrap class="yr_07"><div align="left">净重:  </td>
	    <td nowrap class="yr_07"><div align="left">
            <input  class="input" name="suttle" type="text" size="15">
        </td>
	    <td nowrap class="yr_07"><div align="left">折 扣： </td>
	    <td nowrap class="yr_07"><div align="left">
            <input  class="input" name="discount" type="text" size="15" >
        </td>
    </tr>	
  <tr bgcolor="#FFFFFF" align="center">
    <td width="8%" height="27" nowrap class="yr_07"><div align="left">价格:  </td>
    <td nowrap class="yr_07"><div align="left">
        <input  class="input" name="price" type="text" size="15">
    </td>
    <td width="8%" nowrap class="yr_07"><div align="left">币 制 :  </td>
    <td width="18%" height="27" nowrap class="yr_07"><div align="left">
        <input  class="input"  name="moneytype" type="text" size="15" >
    </td>
    <td height="27" nowrap class="yr_07"><div align="left">金额: </td>
    <td width="17%" height="27" nowrap class="yr_07"><div align="left">
        <input  class="input" name="money" type="text" size="15">
    </td>
    <td width="9%" height="27" nowrap class="yr_07"><div align="left">描述： </td>
    <td width="16%" height="27" nowrap class="yr_07"><div align="left">
        <input  class="input" name="fullmoney" type="text" size="15">
    </td>
    </tr>
	<tr bgcolor="#FFFFFF" align="center">
	  <td nowrap class="yr_07">图片:  </td>
	  <td width="14%" nowrap class="yr_07"><div align="left">
          <input  class="input" name="sizes" type="text" size="15"></div>
      </td>
	  <td width="8%" height="27" nowrap class="yr_07"><div align="left">数 量： </td>
	  <td colspan="5" nowrap class="yr_07"><div align="left">
          <input  class="input"   name="totals" type="text" size="15" >
	    <div align="left"> </td>
    </tr>
  </table>
  <div align="center"><br>
    <input  class="input" type="button" id="Submit" name="Submit" value="提交">
    <input  class="input" type="reset" name="Submit" value="重写">
    </form>
  </div>
</body>
</html>
                                                                                                    
