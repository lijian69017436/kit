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
		<link href="<%=basePath%>/style/css.css" rel="stylesheet"
			type="text/css">
		<style type="text/css">
<!--
.style1 {
	color: #FF0000
}
-->
</style>

<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
  $(function(){
    $("#submit11").click(function(){
      var form=$("[name='f1']").serialize();
      alert(form);
      $.ajax({
        type:"post",
        url:"<%=basePath%>GuestorderServlet.do?action=update",
        data:form,
        success:function(){
          location.href="<%=basePath%>GuestorderServlet.do?action=getPagelist&pageNow=1";
        }
      });
    });
  });
 </script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
		<form name="f1" action="">
			<table width="96%" border="0" align="center" cellpadding="4"
				cellspacing="1" class="yr_05">
				<tr align="center">
					<td width="68%" class="yr_08">
						修改客户订单
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
										<input class="input" name="id11" type="text" size="15"
											value="${ex.id }" readonly="readonly">
								</td>

								<td nowrap class="yr_07">
									<div align="left">
										客户编号:
										<input class="input" name="guestcode" type="text" size="15"
											value="${ex.guestcode}">
								</td>
								<td>
									<div align="left" class="yr_07">
										客户地址:
										<input name="address" class="input" type="text" size="15"
											value="${ex.address}">
								</td>
							</tr>
							<tr bgcolor="#FFFFFF" align="center">
								<td nowrap class="yr_07">
									<div align="left">
										DAT E :
										<input class="input" name="times" type="text" size="15"
											value="${ex.times}" >
								</td>
								<td width="275" nowrap class="yr_07">
									<div align="left">
										F R O M :
										<input class="input" name="froms" type="text" size="15"
											value="${ex.froms}">
								</td>
								<td height="14" nowrap class="yr_07">
									<div align="left">
										T E L :
										<input class="input" name="tel" type="text" size="15"
											value="${ex.tel}">
								</td>
							</tr>
							<tr bgcolor="#FFFFFF" align="center">

								<td width="212" nowrap class="yr_07">
									<div align="left">
										F A X &nbsp;:
										<input class="input" name="fax" type="text" size="15"
											value="${ex.fax}">
								</td>
								<td nowrap class="yr_07">
									<div align="left">
										联 系 人 :
										<input class="input" name="linkman" type="text" size="15"
											value="${ex.linkman}">
								</td>
								<td nowrap class="yr_07">
									<div align="left">
										审 核 :
										<input class="input" name="checks" type="text" size="15"
											value="${ex.checks}" readonly="readonly">
								</td>
							</tr>
						</table>
					</td>
					<table width="96%" align="center">
						<tr align="right">
							<td>
								<div align="center">
									<input class="input" type="button" name="submit11" id="submit11" value="提交">
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input class="input" type="reset" name="Submit2" value="重置">
								</div>
							</td>
						</tr>
					</table>
				</tr>
			</table>
		</form>
	</body>
</html>
