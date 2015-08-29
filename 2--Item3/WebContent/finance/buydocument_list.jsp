<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
					//协议                                                   名字                                                               端口号
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>百合内衣--管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../workspace/waimao/web/repertory/style" rel="stylesheet" type="text/css">
<link href="<%=basePath%>/style/css.css" rel="stylesheet" type="text/css">
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
      url:"../BuydocumentServlet.do?action=delete",
      data:{id:id},
      success:function(){//data可以叫别的名字 成功后获取的数据
        var ro="#row"+id;
        $(ro).remove();
      }
    });
  }
</script>
</head>
<script type="text/javascript">    
	function getid(id){
		window.open("<%=basePath%>audit/audittable_add.jsp?audittype=buydocument&tablename=Buydocument&id="+id,"newwindow", "height=300, width=500, top=250, left=250, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");
	}
	var page_objForm=document.forms[0];
	page_objForm.pageNum.value= pageNum;
        page_objForm.action="<%=basePath%>repertory/buydocument_list.jsp";
        page_objForm.target="";
		page_objForm.submit();
	
	function customSubmit(pInput,pURL)
	{
		var theForm=document.forms[0];
		theForm.pageNum.value=1;
		theForm.submit();
	}
	function modify(id){
	
	   var temp=id;
		location.href="<%=basePath%>repertory/buydocument_modify.jsp?act=modify&id="+temp;
	}
	function customSubmit(pInput,pURL)
	{
		var theForm=document.forms[0];
		theForm.pageNum.value=1;
		theForm.submit();
	}
</script>
<script type="text/javascript">
	function getid(id){
		location.href="<%=basePath %>repertory/buydocument_list.jsp?id="+id;
	}
	
	function remove(id){
		location.href="<%=basePath%>repertory/buydocument_list?id="+id;
	}
	function setId(backs,getid){
		for(i=1; i<backs.parentNode.childNodes.length; i++)
		 {
			   backs.parentNode.childNodes[i].className="table-back";
		 }
		backs.className="yr_111";
		id=getid;
		if(id>0){
			document.all.submsg.src="<%=basePath%>repertory/buyproduct_listall.jsp?id="+id+"";
		}else{
			alert("请选择采购单!");
		}
	}
	
	
</script>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form name="pageObject" action="../BuydocumentServlet.do?action=query" method="post">
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr> 
    <td width="46%" height="30" class="yr_04"> 您的位置：财务管理&gt;&gt;采购付款&gt;&gt;采购付款单</td>
    <td width="54%" align="right" class="yr_04"> 
	   [<a href="<%=basePath %>repertory/buydocument_add.jsp">新增</a>]
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
  </tr>
  </table>
  <table width="96%" border="0" align="center" cellpadding="4" cellspacing="1" class="yr_05">
    <tr  align="center">
      <td height="35" colspan="6" class="yr_08" >采购付款单</td>
    </tr>
    <tr > 
      <td width="18%"  class="yr_07"> 
      订单号：
        <input  class="input" type="text" name="orderid"></td>
      <td width="19%"  class="yr_07">
        <input type="submit" name="sdd" value="查询" class="button">        
        <input type="button" name="Submit2" value="重写" class="button"></td>
    </tr>
  </table>
  <br>
 <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" class="yr_05">
    <tr> 
      <td width="7%"  class="yr_06"><div align="center">订单号 </div></td>
      <td width="15%"   class="yr_06"><div align="center">供应商名称 </div></td>
      <td width="8%"   class="yr_06"><div align="center">供应商编号 </div></td>
      <td width="15%"   class="yr_06"><div align="center">地 址 </div></td>
      <td width="8%"   class="yr_06"><div align="center">联系人 </div></td>
      <td width="11%"   class="yr_06"><div align="center">电 话 </div></td>
      <td width="11%"   class="yr_06"><div align="center">传 真 </div></td>
      <td width="11%"   class="yr_06"><div align="center">邮 箱 </div></td>
      <td width="7%"   class="yr_06"><div align="center">日 期 </div></td>
      <td width="10%"   class="yr_06"><div align="center">是否付款</div></td>
      <td width="10%"   class="yr_06"><div align="center">操作</div></td>
    </tr>
    <c:choose>
      <c:when test="${empty getPaglist }">
      </c:when>
      <c:otherwise>
        <c:forEach items="${getPaglist}" var="buydocument">
            <tr id="row${buydocument.id}">
                <td  class="yr_07">${buydocument.orderid}</td>
                <td  class="yr_07">${buydocument.providername}</td>
                <td  class="yr_07">${buydocument.codes}</td>
                <td  class="yr_07">${buydocument.address}</td>
                <td  class="yr_07">${buydocument.linkman}</td>
                <td  class="yr_07">${buydocument.tel}</td>
                <td  class="yr_07">${buydocument.emails}</td>
                <td  class="yr_07">${buydocument.fax}</td>
                <td  class="yr_07">${buydocument.times}</td>
                <td  class="yr_07">
                	<input  class="input" type="checkbox" name="oo" value="checkbox" checked="checked" disabled="true"> </td>
                <td  class="yr_07">
                	<a href="#" onClick="deletes(${buydocument.id})">删除</a></td>
                <td  class="yr_07"><div align="center">
                	<a href="#" onClick="getid(id)">付款</a></div></td>
                <td  class="yr_07"><div align="center">&nbsp;</div></td>
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
                <a href="<%=basePath%>BuydocumentServlet.do?action=getPagelist&pageNow=1">  第一页</a> 
                <a href="<%=basePath%>BuydocumentServlet.do?action=getPagelist&pageNow=${page.pageNow-1}">上一页</a> 
                <a href="<%=basePath%>BuydocumentServlet.do?action=getPagelist&pageNow=${page.pageNow+1}">下一页</a> 
                <a href="<%=basePath%>BuydocumentServlet.do?action=getPagelist&pageNow=${page.pageCount }">最后页</a> 
                                       每<input name="textfield32" type="text" size="2" class="input" value="${page.pageSize }" readonly="readonly">  页条 
              </td>
            </tr>
          </table>
</form>
  <br>
  <IFRAME id="submsg" style="Z-INDEX: 1; VISIBILITY: inherit; WIDTH: 100%; HEIGHT: 48%" 
        name="submsg" src="<%=basePath%>audit/welcome.jsp" frameBorder="0" scrolling="auto">
  </IFRAME>
</body>
</html>
