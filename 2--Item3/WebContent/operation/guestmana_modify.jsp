<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/checksession.jsp"%>

<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="style/css.css" type="text/css">
    <style type="text/css">
    <!--
    .style1 {color: #FF0000}
    -->
    </style>
</head>
<script language=javascript>
function condition(theform) {
	if(theform.name.value.length==0)
	{
		alert("璇疯緭鍏ュ崟浣嶅悕绉帮紒");
		theform.name.focus();
		return false;
	}
	if(theform.artificialperson.value.length==0)
	{
		alert("璇疯緭鍏ユ硶浜轰唬琛紒");
		theform.artificialperson.focus();
		return false;
	}
	if(theform.principal.value.length==0)
	{
		theform.principal.focus();
		return false;
	}
	if(theform.linkman.value.length==0)
	{
		alert("璇疯緭鍏ヨ仈绯荤數璇濓紒");
		theform.linkman.focus();
		return false;
	}
	if(theform.regaddr.value.length==0)
	{
		alert("璇疯緭鍏ユ敞鍐屽湴鍧€锛?);
		theform.regaddr.focus();
		return false;
	}
}

</script>

<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
    $(function(){
        alert("2");
      $("#submit1").click(function(){
        var form=$("[name='f1']").serialize();
        alert(form);
        $.ajax({
          type:"post",
          url:"../GuestmanaServlet.do?action=update",
          data:form,
          success:function(){
            location.href="../GuestmanaServlet.do?action=getPagelist&pageNow=1";
          }
        });
      });
    });
    
    </script>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form name="f1" action="" >
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr  bgcolor="#FFFFFF"> 
    <td height="30" class="yr_04"> 您的位置：基础资料&gt;&gt;修改客户</td>
    </tr>
  </table>
  <table width="96%" height="66" border="0" align="center" cellpadding="4" cellspacing="1" class="yr_05">
    <tr   align="center"> 
      <td height="23" colspan="8" class="yr_06" > 修改客户 </td>
    </tr>
    <tr bgcolor="#FFFFFF"> 
      <td width="15%" height="6" nowrap class="yr_07">编 &nbsp;号 &nbsp;：        </td>
      <td width="21%" nowrap class="yr_07">
        <input class="input" name="id" type="text" size="15" value="${ex.id}" ></td>
      <td width="10%" nowrap class="yr_07">客户名称：        </td>
      <td width="20%" nowrap class="yr_07">
        <input class="input" name="names" type="text" size="15" value="${ex.name}"></td>
      <td width="13%" nowrap class="yr_07">公司性质：        </td>
      <td width="21%" nowrap class="yr_07">
        <select name="propertys" >
          <option selected>${ex.propertys}</option>
          <option>Brands</option>
          <option>Others</option>
          <option>Trading</option>
        </select></td>
    </tr>
    <tr bgcolor="#FFFFFF">
      <td height="3" nowrap class="yr_07">送货及条款：      </td>
      <td height="3" nowrap class="yr_07">
          <input class="input" name="deliver" type="text" size="15" value="${ex.deliver}"></td>
      <td nowrap class="yr_07">地区：      </td>
      <td nowrap class="yr_07">
        <input class="input" name="country" type="text" size="15" value="${ex.country}"></td>
      <td width="13%" nowrap class="yr_07">地址:</td>
      <td width="21%" nowrap class="yr_07">
          <input class="input" name="address" type="text" size="15" value="${ex.address}"></td>
    </tr>
    <tr bgcolor="#FFFFFF">
      <td height="6" nowrap class="yr_07">实地考察及时间：      </td>
      <td height="6" nowrap class="yr_07">
      <input class="input" name="review" type="text" size="15" value="${ex.review}">  
      	  <img src="images/calendar_bnt.gif" style="cursor:hand ;" align="absmiddle" alt="" onClick="fPopUpCalendarDlg(review);return false">
			    </td>
      <td width="10%" nowrap class="yr_07">      合同号码：      </td>
      <td width="20%" nowrap class="yr_07">
        <select name="contractcode">
          <option selected>${ex.contractcode}</option>
          <option>
           12131
          </option>
        </select></td>
      <td nowrap class="yr_07">营业执照号码：      </td>
      <td nowrap class="yr_07">
        <input class="input" name="charter" type="text" size="15" value="${ex.charter}"></td>
    </tr>
    <tr bgcolor="#FFFFFF">
      <td height="6" nowrap class="yr_07">付款条款：      </td>
      <td height="6" colspan="5" nowrap class="yr_07">
        <textarea name="payment" cols="40" >${ex.payment}</textarea></td>
    </tr>
    <tr bgcolor="#FFFFFF">
      <td height="3" nowrap class="yr_07">快递船务：</td>
      <td height="3" colspan="5" nowrap class="yr_07">
        <textarea name="express" cols="40" >${ex.express}</textarea></td>
    </tr>
    <tr bgcolor="#FFFFFF">
      <td height="3" nowrap class="yr_07">约见情况： </td>
      <td height="3" colspan="5" nowrap class="yr_07">
        <textarea name="appointment" cols="40">${ex.appointment}</textarea></td>
    </tr>
    <tr bgcolor="#FFFFFF">
      <td height="3" nowrap class="yr_07">合同留存：</td>
      <td height="3" colspan="5" nowrap class="yr_07">
        <textarea name="contractleave" cols="40">${ex.contractleave }</textarea></td>
    </tr>
    <tr bgcolor="#FFFFFF">
      <td height="3" nowrap class="yr_07">是否代理及范围：</td>
        <td height="3" colspan="5" nowrap class="yr_07">
          <textarea name="supply" cols="40" id="supply">${ex.supply}</textarea></td>
    </tr>
  </table>
  <p align="center"><input class="input" type="button" name="Submit" id="submit1" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;
    <input class="input" type="reset" name="Submit" value="重写">
  </p>
</form>
</body>
</html>
