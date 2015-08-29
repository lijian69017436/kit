<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ include file="/checksession.jsp"%>


<html>
	<head>
		<title>百合内衣--管理系统</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link href="style" rel="stylesheet" type="text/css">
		<link href="<%=basePath%>style/css.css" rel="stylesheet"
			type="text/css">
		<style type="text/css">
<!--
.style1 {
	color: #FF0000
}
-->
</style>

<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript">
$(function(){
  $("[name='Submit']").click(function(){
    var table=$("#form11").serialize();
    alert(table);
    $.ajax({
      type:"post",
      url:"../GuestorderServlet.do?action=insert",
      data:table,
      success:function(){
        location.href="../GuestorderServlet.do?action=getPagelist&pageNow=1";
      }
    });
  });
});
</script>
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
		theform.regaddr.focus();
		return false;
	}
}

</script>
	<%--<%String[] orderid=new codeDao().getId("guestorder","id","P"); %>--%>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form name="form11" id="form11" action="" onsubmit="return condition(this);">
	<table width="96%" border="0" align="center" cellpadding="4"cellspacing="1" class="yr_05">
		<tr align="center">
			<td width="68%" class="yr_08">
				新增客户订单
			</td>
		</tr>
	</table>
	<table width="96%" border="0" align="center" cellpadding="4"
		cellspacing="1" class="yr_05">
		<tr id="a" style="display: " bgcolor="#FFFFFF" align="center">
			<td height="13" nowrap class="yr_07">
				<table width="100%" border="0" align="center" cellpadding="4"
					cellspacing="1" class="yr_05">
					<tr bgcolor="#FFFFFF" align="center">
						<td nowrap class="yr_07">
							<div align="left">
								订单号:
              <input class="input" name="id11" type="text" size="15" value="" >
						</td>
						<td nowrap class="yr_07">
							<div align="left">
								客户编号:
								<input class="input" name="guestcode" type="text" size="15">
							</div>
						</td>
						<td nowrap class="yr_07">
							<div align="left">
								客户地址:
								<input class="input" name="address" type="text" size="15">
							</div>
						</td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
						<td nowrap class="yr_07">
							<div align="left">
								DAT E :
								<input class="input" name="times" type="text" size="15"
									>
								<img src="../images/calendar_bnt.gif" style="cursor: hand;"
									align="absmiddle" alt=""
									onClick="fPopUpCalendarDlg(times);return false">
						</td>
						<td width="275" nowrap class="yr_07">
							<div align="left">
								F R O M :
								<input class="input" name="froms" type="text" size="15">
						</td>
						<td height="14" nowrap class="yr_07">
							<div align="left">
								T E L ：
								<input " name="tel" class="input" type="text" size="15">
						</td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">

						<td width="212" nowrap class="yr_07">
							<div align="left">
								F A X &nbsp;:
								<input class="input" name="fax" type="text" size="15">
						</td>
						<td nowrap class="yr_07">
							<div align="left">
								联 系 人 :
								<input class="input" name="linkman" type="text" size="15">
						</td>
						<td nowrap class="yr_07">
							<div align="left">
								审 核 ：
								<input class="input" name="checks" type="text" size="15">
						</td>
					</tr>
				</table>

			</td>
			<table width="96%" align="center">
				<tr align="right">
					<td>
						<div align="center">
							<input class="input" type="button" name="Submit" value="提交">
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input class="input" type="reset" name="Submit2" value="重置">
					<div align="center">
					</td>
				</tr>
			</table>
		</tr>
	</table>
	</form>
</body>
</html>
