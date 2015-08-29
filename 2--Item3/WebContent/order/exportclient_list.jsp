<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/checksession.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script type="text/javascript" src="../js/jquery.js"></script>
<title>百合内衣--管理系统</title>
<link href="style" rel="stylesheet" type="text/css">
<link href="<%=basePath %>/style/css.css" rel="stylesheet" type="text/css">
<script language="javascript">
  function setid(backs,getid){
    for(i=1; i<backs.parentNode.childNodes.length; i++)		 {
    <%--		 	backs.--%>
    <%--		 	document.all.mm.--%>
    <%--			backs.parentNode.childNodes[i].className="table-back";--%>
		 }
		backs.className="yr_111";
		id=getid;
		if(id>0){
			document.all.submsg.src="<%=basePath %>/queryExportproduct.do?id="+id+"";
		}else{
			alert("请选择出口询价单!");
		}
	}
	function getid(id){
		window.open("<%=basePath %>/audit/audittable_list.jsp?audittype=export&tablename=Exportclient&id="+id,
				"newwindow", 
				"height=300, width=500, top=250, left=250, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");
	}
	function getorderid(id){
		window.open("<%=basePath %>/audit/audittable_modify.jsp?audittype=export&tablename=Exportclient&orderid="+id,
				"newwindow",
				"height=300, width=500, top=250, left=250, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");
	}
	function printll(id){
		window.open(" <%=basePath %>/order/exportclient_list.jsp?act=printll&id="+id,
				"newwindow",
				"height=600, width=650, top=00, left=00, toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, status=no");
	}
	function Page(pageNum){
  	if(checkNum(pageNum)==0) {
     		alert("要跳转的页数必须是大于0的数字！");
     		return;
  	}
  	var page_objForm=document.forms[0];
  	page_objForm.pageNum.value= pageNum;
    page_objForm.action="<%=basePath %>/order/exportclient_list.jsp";
    page_objForm.target="";
		page_objForm.submit();
	}
	function customSubmit(pInput,pURL)	{
		var theForm=document.forms[0];
		theForm.pageNum.value=1;
		theForm.submit();
	}
	function modify(id){
		location.href="<%=basePath %>order/exportclient_modify.jsp?act=modify&id="+id;
	}
	function remove(id){
		location.href="<%=basePath %>order/exportclient_list.jsp?id="+id;
	}
	function customSubmit(pInput,pURL)	{
		var theForm=document.forms[0];
		theForm.pageNum.value=1;
		theForm.submit();
	}
	function produceOrder(id){
		location.href="<%=basePath %>order/exportclient_add.jsp?act=add&id="+id;
	}
	
</script>
<script type="text/javascript">
  $(function(){
  	
  });
  function deletes(id){//删除 方法
    $.ajax({
      type:"post",//数据提交的方式
      url:"../ExportClientServlet.do?action=delete",
      data:{id:id},
      success:function(){//data可以叫别的名字 成功后获取的数据
        var ro="#row"+id;
        $(ro).remove();
      }
    });
  }
  function selectbyid(id){
    $.ajax({
      type:"post",//数据提交的方式
      url:"../ExportClientServlet.do?action=selectById",
      data:{id:id},
      success:function(data){//data可以叫别的名字 成功后获取的数据
        var data=eval("("+data+")");
         alert(data.id);
      }
    });
  }
  
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="a()">
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr> 
      <td width="46%" height="30" class="yr_04"> 您的位置：业务平台&gt;&gt;出口询价</td>
      <td width="54%" align="right" class="yr_04"> 
  	     [<a href="<%=basePath %>order/exportclient_add.jsp">新增</a>]
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
    </tr>
  </table>
<form name="pageObject" action="../ExportClientServlet.do?action=query" method="post" >
  <table width="96%" border="0" align="center" cellpadding="4" cellspacing="1" class="yr_05">
    <tr  align="center">
      <td height="42" colspan="5" class="yr_08" >出口询价</td>
    </tr>
    <tr bgcolor="#FFFFFF" align="left"> 
      <td width="30%"><div align="left"> <span>
                      单号： <input  class="input" name="id1s" type="text" size="15"></span></div>
      </td>
      <td width="30%"><div align="left"> <span>
                      客户名称： <input  class="input" name="names" type="text" size="15"></span></div>
      </td>
      <td width="37%"><div align="left">
        <input  class="input" type="submit" name="Submit" id="query11" value="查询" class="button">
        <input  class="input" type="reset" name="Submit2" value="重写" class="button"></div>
       </td>
    </tr>
  </table><br>
  <table id="exporttable" width="96%" border="0" align="center" cellpadding="0" cellspacing="1" class="yr_05">
    <tr> 
      <td width="7%"  class="yr_06"><div align="center">询价单号 </div></td>
      <td width="10%" nowrap  class="yr_06"><div align="center">客户号码 </div></td>
      <td width="10%" nowrap  class="yr_06"><div align="center">客户名称 </div></td>
      <td width="10%" nowrap  class="yr_06"> 客户地址</td>
      <td width="8%" nowrap  class="yr_06">TEL</td>
      <td width="8%" nowrap  class="yr_06">FAX</td>
      <td width="5%" nowrap  class="yr_06">SALES</td>
      <td width="5%" nowrap  class="yr_06"> 联 系 人</td>
      <td width="8%" nowrap  class="yr_06">日期</td>
      <td width="8%" nowrap  class="yr_06"><div align="center">是否审核</div> </td>
      <td width="12%" nowrap colspan="3" class="yr_06"><div align="center">操作 </div></td>
    </tr>
    
    <c:choose>
      <c:when test="${empty getPaglist }">
      </c:when>
      <c:otherwise>
        <c:forEach items="${getPaglist }" var="exportEntity">
          <tr id="row${exportEntity.id}">
           <td nowrap class="yr_07">${exportEntity.id} </td>
            <td nowrap class="yr_07">${exportEntity.clientnumber}</td>
            <td nowrap class="yr_07">${exportEntity.names}</td>
            <td nowrap class="yr_07">${exportEntity.clientaddress}</td>
            <td nowrap class="yr_07">${exportEntity.tel}</td>
            <td nowrap class="yr_07">${exportEntity.fax}</td>
            <td nowrap class="yr_07">${exportEntity.sales}</td>
            <td nowrap class="yr_07">${exportEntity.linkman}</td>
            <td nowrap class="yr_07">${exportEntity.dates}</td>
            <td nowrap class="yr_07"><div align="center">
            <a href="#" onclick="getid(id)">审核</a></div> </td>
            <td nowrap class="yr_07"><div align="center">[<a href="#" onClick="deletes(${exportEntity.id})">删除</a>] </div></td>
            <td nowrap class="yr_07"><div align="center">[<a href="../ExportClientServlet.do?action=selectById&id=${exportEntity.id}" >修改</a>] </div></td>
            <td nowrap class="yr_07"><div align="center">[<a href="#" onClick="printll(id)">打印</a>] </div></td>
          </tr>
        </c:forEach>
      </c:otherwise>
    </c:choose>
    
    
  </table>
  <table width="96%"  align="center">
    <tr align="right">
      <td> 共有<span class="style1">${page.pageCount }</span>页
      <span class="style1">${page.count }</span>条记录，
                    当前为第<span class="style1">${page.pageNow }</span>页 
        <a href="<%=basePath%>ExportClientServlet.do?action=getPagelist&pageNow=1">  第一页</a> 
        <a href="<%=basePath%>ExportClientServlet.do?action=getPagelist&pageNow=${page.pageNow-1}">上一页</a> 
        <a href="<%=basePath%>ExportClientServlet.do?action=getPagelist&pageNow=${page.pageNow+1}">下一页</a> 
        <a href="<%=basePath%>ExportClientServlet.do?action=getPagelist&pageNow=${page.pageCount }">最后页</a> 
                     每<input name="textfield32" type="text" size="2" class="input" value="${page.pageSize }" readonly="readonly">  页条 
      </td>
    </tr>
      
  </table>
</form><br>
    <IFRAME id="submsg" style="Z-INDEX: 1; VISIBILITY: inherit; WIDTH: 100%; HEIGHT: 48%" 
          name="submsg" src="<%=basePath  %>audit/welcome.jsp" frameBorder="0" scrolling="auto">
    </IFRAME>
</html>