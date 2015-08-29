<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>百合内衣--管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=basePath%>style/css.css" rel="stylesheet" type="text/css">
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
      url:"../PaymentincaseServlet.do?action=delete",
      data:{id:id},
      success:function(){//data可以叫别的名字 成功后获取的数据
        var ro="#row"+id;
        $(ro).remove();
      }
    });
  }
</script>
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
			document.all.submsg.src="<%=basePath%>repertory/incasementproduct_list.jsp?act=down&id="+id+"";
		}else{
			alert("请选择客户订单!");
		}
	}
	function Page(pageNum){
	if(checkNum(pageNum)==0) {
   		alert("要跳转的页数必须是大于0的数字！");
   		return;
	}
	
	var page_objForm=document.forms[0];
	page_objForm.pageNum.value= pageNum;
        page_objForm.action="<%=basePath%>/finance/paymentincase_list.jsp";
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
		location.href="<%=basePath%>repertory/incasementdocument_modify.jsp?act=modify&id="+temp;
	}
	function remove(id){
		location.href="<%=basePath%>finance/paymentincase_list.jsp?id="+id;
	}
	function customSubmit(pInput,pURL)
	{
		var theForm=document.forms[0];
		theForm.pageNum.value=1;
		theForm.submit();
	}
</script>
<script type="text/javascript">
function getid(getid,id){
		location.href="<%=basePath %>finance/paymentincase_list.jsp?getid="+getid+"&id="+id;
	}
</script>



<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form name="pageObject" action="<%=basePath %>PaymentincaseServlet.do?action=query" method="post">
 <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr> 
    <td width="46%" height="30" class="yr_04"> 您的位置：财务管理&gt;&gt;订单发票</td>
  
      <td width="24%" class="yr_04" align="right"> 
         [<a href="../repertory/incasementdocument_add.jsp">新增</a>] </td>
    </table>
  <table width="96%" border="0" align="center" cellpadding="4" cellspacing="1" class="yr_05">
    <tr  align="center">
      <td height="35" colspan="6" class="yr_08" >订单发票</td>
    </tr>
    <tr > 
      <td width="27%" height="13" nowrap class="yr_07"> 
                  
       收获日期:  <input  class="input" name="starttime" type="text" size="15" readonly>
           <img src="images/calendar_bnt.gif" style="cursor:hand;" align="absmiddle" alt="" 
              onClick="fPopUpCalendarDlg(starttime);return false">  </td>
      <td width="18%" nowrap class="yr_07"> 
                    
         截止日期：<input  class="input" name="endtime" type="text" size="15" readonly>     
           <img src="images/calendar_bnt.gif" style="cursor:hand;" align="absmiddle" alt="" 
                onClick="fPopUpCalendarDlg(endtime);return false"></td>
      <td width="36%" nowrap class="yr_07">
    PI号：<input  class="input" type="text" name="plid"></td>
      <td width="19%" nowrap class="yr_07"> 
      
        <input type="submit" name="Submit" value="查询" class="button">  
        <input type="reset" name="Submit2" value="重写" class="button">        </td>
    </tr>
  </table>
  <br>
 
  <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" class="yr_05">
    <tr> 
      <td width="10%"  class="yr_06"><div align="center">箱号</div> </td>
      <td width="10%" nowrap  class="yr_06"><div align="center">PI号</div> </td>
      <td width="10%" nowrap  class="yr_06"><div align="center">公司编号</div> </td>
      <td width="10%" nowrap  class="yr_06"><div align="center">客户编号</div> </td>
      <td width="8%" nowrap  class="yr_06"><div align="center">数量</div> </td>
      <td width="10%" nowrap  class="yr_06">净重</td>
	    <td width="10%"  class="yr_06"><div align="center">毛重</div> </td>
      <td width="10%" nowrap  class="yr_06"><div align="center">外箱尺寸</div> </td>
      <td width="10%" nowrap  class="yr_06"><div align="center">日期</div> </td>
      <td width="25%" nowrap class="yr_06" colspan="2"><div align="center">操作</div> </td>
    </tr>
    <c:choose>
      <c:when test="${empty getPaglist }">
      </c:when>
      <c:otherwise>
        <c:forEach items="${getPaglist}" var="pay">    
            <tr id="row${pay.id }">
              <td nowrap class="yr_07">${pay.getid}</td>
              <td nowrap class="yr_07">${pay.plid}</td>
              <td nowrap class="yr_07">${pay.companycode}</td>
              <td nowrap class="yr_07">${pay.clientcode}</td>
              <td nowrap class="yr_07">${pay.numbers}</td>
              <td nowrap class="yr_07">${pay.suttle}</td>
        	    <td nowrap class="yr_07">${pay.grossweight}</td>
              <td nowrap class="yr_07">${pay.sizes}</td>
        	    <td nowrap class="yr_07">${pay.times}</td>
                	<td nowrap class="yr_07"><div align="center">
                	<input  class="input" type="checkbox" name="oo" value="checkbox" checked="checked" disabled="true"> </td>
                	<td nowrap class="yr_07"><div align="center">
                	<a href="#" onClick="deletes(${pay.id})">删除</a></td>
                	<td nowrap class="yr_07" align="center">
                	<a href="#" onClick="getid('getid','id')">发票通过</a></td>
            </tr>
           </c:forEach>
      </c:otherwise>
    </c:choose>  
  </table>
          <table  width="96%" align="center">
            <tr align="right">
              <td> 共有<span class="style1"> ${page.pageCount }</span>页
              <span class="style1">${page.count }</span>条记录，
                                      当前为第<span class="style1">${page.pageNow }</span>页 
                <a href="<%=basePath%>PaymentincaseServlet.do?action=getPagelist&pageNow=1">  第一页</a> 
                <a href="<%=basePath%>PaymentincaseServlet.do?action=getPagelist&pageNow=${page.pageNow-1}">上一页</a> 
                <a href="<%=basePath%>PaymentincaseServlet.do?action=getPagelist&pageNow=${page.pageNow+1}">下一页</a> 
                <a href="<%=basePath%>PaymentincaseServlet.do?action=getPagelist&pageNow=${page.pageCount }">最后页</a> 
                                       每<input name="textfield32" type="text" size="2" class="input" value="${page.pageSize }" readonly="readonly">  页条 
              </td>
            </tr>
          </table>
</form>
<br>
<IFRAME id="submsg" style="Z-INDEX: 1; VISIBILITY: inherit; WIDTH: 100%; HEIGHT: 48%" 
      name="submsg" src="<%=basePath%>audit/welcome.jsp" frameBorder="0" scrolling="auto"></IFRAME>
</body>
</html>
