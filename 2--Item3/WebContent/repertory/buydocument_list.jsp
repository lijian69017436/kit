<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/checksession.jsp"%>
<html>
<head>
<title>百合内衣--管理系统</title>
<script src="js/common.js" language=javascript></script>
<script src="js/Calendar.js" language=javascript></script>
<script src="js/popwin.js" language=javascript></script>
<script src="js/checkForm.js" language=javascript></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=basePath %>web/repertory/style" rel="stylesheet" type="text/css">
<link href="<%=basePath %>style/css.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.style1 {color: #FF0000}
-->
</style>
</head>
<script>

function setid(backs,getid){
		for(i=1; i<backs.parentNode.childNodes.length; i++)
		 {
			   backs.parentNode.childNodes[i].className="table-back";
		 }
		backs.className="yr_111";
		id=getid;
		if(id>0){
			document.all.submsg.src="<%=basePath %>queryBuyproduct.do?id="+id+"";
		}else{
			alert("请选择采购单!");
		}
	}

	function getid(id){
		window.open("<%=basePath %>audit/audittable_add.jsp?audittype=buydocument&tablename=Buydocument&id="+id,"newwindow", "height=300, width=500, top=250, left=250, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");
	}
	function getorderid(id){
		window.open("<%=basePath %>queryAudittable.do?audittype=buydocument&tablename=Buydocument&orderid="+id,"newwindow", "height=300, width=500, top=250, left=250, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");
	}
	function printll(id){
		window.open("<%=basePath %>buydocument_list.jsp?act=printll&id="+id,"newwindow", "height=600, width=650, top=00, left=00, toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, status=no");
	}
	function payment(id,checks){
		if(checks==2){
			alert("单据未通过，不允许申请付款！");
		}
		if(checks==1){
			alert("单据正在审核，不允许申请付款！");
		}
		if(checks==0){
			alert("单据未审核，不允许申请付款！");
		}
		if(checks==3){
			window.open("<%=basePath %>repertory/buydocument_add.jsp?act=payment&id="+id,"newwindow", "height=600, width=650, top=00, left=00, toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, status=no");
		}
	}
	function Page(pageNum){
	if(checkNum(pageNum)==0) {
   		alert("要跳转的页数必须是大于0的数字！");
   		return;
	}
	
	var page_objForm=document.forms[0];
	page_objForm.pageNum.value= pageNum;
        page_objForm.action="<%=basePath %>repertory/buydocument_list.jsp";
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
	
	   var temp=id;
		location.href="<%=basePath %>repertory/buydocument_modify.jsp?act=modify&id="+temp;
	}
	function remove(id){
		location.href="<%=basePath %>repertory/buydocument_list.jsp?id="+id;
	}
	function customSubmit(pInput,pURL)
	{
		var theForm=document.forms[0];
		theForm.pageNum.value=1;
		theForm.submit();
	}
</script>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form name="pageObject" action="repertory/buydocument_list.jsp">
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr> 
    <td width="46%" height="30" class="yr_04"> 您的位置：库房管理&gt;&gt;单据管理&gt;&gt;采购单</td>
    <td width="54%" align="right" class="yr_04"> 
	[<a href="<%=basePath  %>repertory/buydocument_add.jsp">新增</a>]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
  </tr>
  </table>
  <table width="96%" border="0" align="center" cellpadding="4" cellspacing="1" class="yr_05">
    <tr  align="center">
      <td height="35" colspan="6" class="yr_08" >采购单</td>
    </tr>
    <tr > 
      <td width="18%"  class="yr_07"> 
      订单号：
        <input  class="input" type="text" name="orderid"></td>
      <td width="19%"  class="yr_07">
        <input  class="input" type="button" name="Submit" value="查询" class="button">        
        <input  class="input" type="button" name="Submit2" value="重写" class="button"></td>
    </tr>
  </table>
  <br>
 <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" class="yr_05">
    <tr>
	  <td width="10%"  class="yr_06"><div align="center">NO.</td>
      <td width="10%"  class="yr_06"><div align="center">PI </td>
      <td width="10%"   class="yr_06"><div align="center">仓库类别 </td>
      <td width="10%"   class="yr_06"><div align="center">供应商编号 </td>
      <td width="15%"   class="yr_06"><div align="center">供应商名称 </td>
      <td width="20%"   class="yr_06"><div align="center">地 址 </td>
      <td width="8%"   class="yr_06"><div align="center">联系人 </td>
      <td width="11%"   class="yr_06"><div align="center">电 话 </td>
      <td width="11%"   class="yr_06"><div align="center">传 真 </td>
      <td width="11%"   class="yr_06"><div align="center">邮 箱 </td>
      <td width="7%"   class="yr_06"><div align="center">日 期 </td>
      <td width="10%"   class="yr_06"><div align="center">是否审核 </td>
      <td width="16%"  class="yr_06" colspan="4"><div align="center" >操作 </td>
    </tr>
	 <tr height=18 >
		 <td>&nbsp;<br></td>
	     <td>&nbsp;<br></td>
		 <td>&nbsp;<br></td>
		 <td>&nbsp;<br></td>
		 <td>&nbsp;<br></td>
		 <td>&nbsp;<br></td>
		 <td>&nbsp;<br></td>
		 <td>&nbsp;<br></td>
		 <td>&nbsp;<br></td>
		 <td>&nbsp;<br></td>
	 </tr>
     <tr onClick="setid(this,id)">
      <td  class="yr_07">id</td>
      <td  class="yr_07">orderid</td>
      <td  class="yr_07">types</td>
      <td  class="yr_07">providername</td>
      <td  class="yr_07">codes</td>
      <td  class="yr_07">address</td>
      <td  class="yr_07">linkman</td>
      <td  class="yr_07">tel</td>
      <td  class="yr_07">emails</td>
      <td  class="yr_07">fax</td>
      <td  class="yr_07">times</td></a>
      <% int check=0; if(check==4){ %>
      	<td  class="yr_07"><div align="center">
      	<input  class="input" type="checkbox" name="checkbox" value="checkbox" checked="checked" disabled="true"> </td>
      	<td  class="yr_07">&nbsp;</td>
      	<td  class="yr_07">&nbsp;</td>
      <td  class="yr_07"><div align="center">[<a href="#" onClick="printll(id)">打印</a>] </td>
      <td  class="yr_07">&nbsp;</td>
      <%} else if(check==3){ %>
      	<td  class="yr_07"><div align="center">
      	<input  class="input" type="checkbox" name="checkbox" value="checkbox" checked="checked" disabled="true"> </td>
      	<td  class="yr_07">&nbsp;</td>
      	<td  class="yr_07">&nbsp;</td>
      <td  class="yr_07"><div align="center">[<a href="#" onClick="printll(id)">打印</a>] </td>
      <td  class="yr_07"><div align="center">[<a href="#" onClick="payment(id,checks)">申请付款</a>] </td>
      <%} else if(check==2){ %>
      	<td  class="yr_07"><div align="center" >
      	<a href="#" onclick="getorderid(id"/>)"><font color="red">未通过</a> </td></font> </td>
      	<td  class="yr_07"><div align="center">[<a href="#" onClick="remove(id)">删除</a>] </td>
      	<td  class="yr_07"><div align="center">[<a href="#" onClick="modify(id)">修改</a>] </td>
      <td  class="yr_07"><div align="center">[<a href="#" onClick="printll(id)">打印</a>] </td>
      	<td  class="yr_07"><div align="center" ><font color="read">...</font> </td>
      <%} else if(check==1){ %>
      	<td  class="yr_07"><div align="center" ><font color="read">...</font> </td>
      	<td  class="yr_07"><div align="center" ><font color="read">...</font> </td>
      	<td  class="yr_07"><div align="center" ><font color="read">...</font> </td>
        <td  class="yr_07"><div align="center">[<a href="#" onClick="printll(id)">打印</a>] </td>
      	<td  class="yr_07"><div align="center" ><font color="read">...</font> </td>
      <%} else if(check==0){ %>
      	<td  class="yr_07"><div align="center">
      	<a href="#" onclick="getid(id)">审核</a> </td>
      	<td  class="yr_07"><div align="center">[<a href="#" onClick="remove(id)">删除</a>] </td>
        <td  class="yr_07"><div align="center">[<a href="#" onClick="modify(id)">修改</a>] </td>
        <td  class="yr_07"><div align="center">[<a href="#" onClick="printll(id)">打印</a>] </td>
      	<td  class="yr_07"><div align="center" ><font color="read">...</font> </td>
      <%} %>
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

<br>
<IFRAME id="submsg" style="Z-INDEX: 1; VISIBILITY: inherit; WIDTH: 100%; HEIGHT: 48%" 
      name="submsg" src="<%=basePath  %>audit/welcome.jsp" frameBorder="0" scrolling="auto"></IFRAME>

</body>
</html>
