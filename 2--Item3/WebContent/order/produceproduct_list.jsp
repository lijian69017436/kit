<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/checksession.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>百合内衣--管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../workspace<%=basePath%>/web/order/style" rel="stylesheet" type="text/css">
<link href="<%=basePath%>/style/css.css" rel="stylesheet" type="text/css">
<script src="js/common.js" language=javascript></script>
<script src="js/Calendar.js" language=javascript></script>
<script src="js/popwin.js" language=javascript></script>
<script src="js/checkForm.js" language=javascript></script>
<style type="text/css">
<!--
.style1 {color: #FF0000}
-->
</style>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
  $(function(){
    
  });
  function deletes(id){//删除 方法
    $.ajax({
      type:"post",//数据提交的方式
      url:"../ProduceproductServlet.do?action=delete",
      data:{id:id},
      success:function(){//data可以叫别的名字 成功后获取的数据
        var ro="#row"+id;
        $(ro).remove();
      }
    });
  }
</script>

</head>
<script language="javascript">
	function getid(id){
		alert(id);
		window.open("audit/audittable_add.jsp?audittype=order&id="+id,"newwindow", "height=500, width=650, top=150, left=220, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");
	}
	function getall(id){
		location.href="order/exportproduct_list.jsp?act=down&id="+id;   
	}
	function Page(pageNum){
	if(checkNum(pageNum)==0) {
   		alert("要跳转的页数必须是大于0的数字！");
   		return;
	}
	
	var page_objForm=document.forms[0];
	page_objForm.pageNum.value= pageNum;
        page_objForm.action="<%=basePath%>order/produceproduct_list.jsp";
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
		location.href="<%=basePath%>order/produceproduct_modify.jsp?act=modify&id="+temp;
	}
	function remove(id){
		location.href="<%=basePath%>order/produceproduct_list.jsp?id="+id;
	}
	function customSubmit(pInput,pURL)
	{
		var theForm=document.forms[0];
		theForm.pageNum.value=1;
		theForm.submit();
	}
</script>

<%String id=(String)request.getAttribute("id"); %>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form name="pageObject" action="<%=basePath %>order/produceproduct_list.jsp">
 <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td width="46%" height="30" class="yr_04"> 您的位置：业务平台&gt;&gt;生产单产品信息</td>
      <td width="54%" align="right" class="yr_04">[<a href="<%=basePath %>order/produceproduct_add.jsp">新增</a>]</td>
    </tr>
  </table>
  
  
  <table width="96%" border="0" align="center" cellpadding="4" cellspacing="1" class="yr_05" >
    <tr align="center" bgcolor="#FFFFFF" >
      <td height="13" colspan="17" class="yr_08"><span >生产单产品信息</span></td>
    </tr>
    <tr bgcolor="" align="center" >
      <td width="7%" height="13" class="yr_08">生产单号</td>
      <td width="7%" class="yr_08">货品编号</td>
      <td width="8%" class="yr_08">货品名称</td>
      <td width="6%" class="yr_08">规格</td>
      <td width="6%" height="13" class="yr_08">颜色</td>
      <td width="7%" height="10" class="yr_08">数量</td>
      <td width="3%" height="13" class="yr_08">单 位</td>
      <td width="4%" class="yr_08">币 制</td>
      <td width="4%" height="10" class="yr_08">净重</td>
      <td width="4%" height="13" class="yr_08">折 扣</td>
      <td width="5%" class="yr_08">价格</td>
      <td width="8%" class="yr_08">金额</td>
      <td width="5%" class="yr_08">描述</td>
      <td width="8%" class="yr_08">图片</td>
      <td nowrap class="yr_06" colspan="3"><div align="center">操作 </td>
    </tr>
	
     <c:choose>
      <c:when test="${empty getPaglist }">
      </c:when>
      <c:otherwise>
        <c:forEach items="${getPaglist }" var="produceproduct">
            <tr id="row${produceproduct.id}">
              <input type="hidden" name="id" value="${produceproduct.id}"/>
              <td nowrap class="yr_07">${produceproduct.orderid}</td>
              <td nowrap class="yr_07">${produceproduct.productcode}</td>
              <td nowrap class="yr_07">${produceproduct.productname}</td>
              <td nowrap class="yr_07">${produceproduct.guige}</td>
              <td nowrap class="yr_07">${produceproduct.color}</td>
              <td nowrap class="yr_07">${produceproduct.totals}</td>
              <td nowrap class="yr_07">${produceproduct.unit}</td>
              <td nowrap class="yr_07">${produceproduct.moneytype}</td>
              <td nowrap class="yr_07">${produceproduct.suttle}</td>
              <td nowrap class="yr_07">${produceproduct.discount}</td>
              <td nowrap class="yr_07">${produceproduct.price}</td>
              <td nowrap class="yr_07">${produceproduct.money}</td>
              <td nowrap class="yr_07">${produceproduct.fullmoney}</td>
              <td nowrap class="yr_07">${produceproduct.sizes}</td>
              <td width="7%" align="center" nowrap class="yr_07">[<a href="#" onClick="deletes(${produceproduct.id})">删除</a>]</td>
              <td width="7%" nowrap class="yr_07 align="center">[<a href="../ProduceproductServlet.do?action=selectById&id=${produceproduct.id}" >修改</a>]</td>
          </tr>
       </c:forEach>
      </c:otherwise>
    </c:choose>
  </table>
          <table width="96%" align="center">
            <tr align="right">
              <td> 共有<span class="style1">${page.pageCount }</span>页
              <span class="style1">${page.count }</span>条记录，
                                      当前为第<span class="style1">${page.pageNow }</span>页 
                <a href="<%=basePath%>ProduceproductServlet.do?action=getPagelist&pageNow=1">  第一页</a> 
                <a href="<%=basePath%>ProduceproductServlet.do?action=getPagelist&pageNow=${page.pageNow-1}">上一页</a> 
                <a href="<%=basePath%>ProduceproductServlet.do?action=getPagelist&pageNow=${page.pageNow+1}">下一页</a> 
                <a href="<%=basePath%>ProduceproductServlet.do?action=getPagelist&pageNow=${page.pageCount }">最后页</a> 
                                       每<input name="textfield32" type="text" size="2" class="input" value="${page.pageSize }" readonly="readonly">  页条 
              </td>
            </tr>
          </table>
</form>
</body>
</html>
