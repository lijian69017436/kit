<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/checksession.jsp"%>
<html>
	<head>
  <script type="text/javascript" src="../js/jquery.js"></script>
		<title>百合内衣--管理系统</title>
		<link href="style" rel="stylesheet" type="text/css">
		<link href="<%=basePath%>style/css.css" rel="stylesheet"
			type="text/css">

		<script language="javascript">
function setid(backs,getid){
		for(i=1; i<backs.parentNode.childNodes.length; i++)
		 {
			   backs.parentNode.childNodes[i].className="table-back";
		 }
		backs.className="yr_111";
		id=getid;
		if(id>0){
			document.all.submsg.src="<%=basePath%>order/orderproduct_list.jsp?id="+id+"";
		}else{
			alert("请选择客户订单!");
		}
	}
	function getid(id){
		window.open("<%=basePath%>audit/audittable_add.jsp?audittype=guestorder&tablename=Guestorder&id="+id,"newwindow", "height=300, width=500, top=250, left=250, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");
		
	}
	function getorderid(id){
		window.open("<%=basePath%>audit/audittable_modify.jsp?audittype=guestorder&tablename=Guestorder&orderid="+id,"newwindow", "height=300, width=500, top=250, left=250, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");
		
	}
	function printll(id){
		window.open("<%=basePath%>order/guestorder_list.jsp?act=printll&id="+id,"newwindow", "height=600, width=650, top=00, left=00, toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, status=no");
	}
	function Page(pageNum){
	if(checkNum(pageNum)==0) {
   		alert("要跳转的页数必须是大于0的数字！");
   		return;
	}
	
	var page_objForm=document.forms[0];
	page_objForm.pageNum.value= pageNum;
        page_objForm.action="<%=basePath%>order/guestorder_list.jsp";
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
		location.href="<%=basePath%>order/guestorder_modify.jsp?act=modify&id="+temp;
	}
	function remove(id){
		location.href="<%=basePath%>order/guestorder_list.jsp?id="+id;
	}
	function customSubmit(pInput,pURL)
	{
		var theForm=document.forms[0];
		theForm.pageNum.value=1;
		theForm.submit();
	}
	function produceOrder(id){
		location.href="<%=basePath%>order/producenoteproduct_listTemp.jspc?act=add&id="+id;
		
	}
</script>

<script type="text/javascript">
  $(function(){
    
  });
  function deletes(id){//删除 方法
    $.ajax({
      type:"post",//数据提交的方式
      url:"../GuestorderServlet.do?action=delete",
      data:{id:id},
      success:function(){//data可以叫别的名字 成功后获取的数据
        var ro="#row"+id;
        $(ro).remove();
      }
    });
  }
</script>
	</head>
	<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="46%" height="30" class="yr_04">
					您的位置：业务平台&gt;&gt;客户订单
				</td>
				<td width="54%" align="right" class="yr_04">
					[<a href="guestorder_add.jsp">新增</a>]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
		</table>
		<form action="../GuestorderServlet.do?action=query" method="post">
			<table width="96%" border="0" align="center" cellpadding="4"
				cellspacing="1" class="yr_05">
				<tr align="center">
					<td height="23" colspan="5" class="yr_08">客户订单</td>
				</tr>
				<tr bgcolor="#FFFFFF" align="center">
					<td width="30%" height="28" nowrap class="yr_07">
						<div align="left">
								询价单号：<input class="input" type="text" name="id1111"/>
						</div>
					</td>
					<td width="38%">
						<div align="left">
							客户地址：<input class="input" type="text" name="address"/>
						</div>
					</td>
					<td width="32%">
						<input class="input" type="submit" name="Submit" value="查询"
							class="button">
						<input class="input" type="reset" name="Submit2" value="重写"
							class="button">
					</td>
				</tr>
			</table>

			<br>
			<table width="96%" border="0" align="center" cellpadding="0"
				cellspacing="1" class="yr_05">
				<tr>
					<td width="7%" class="yr_06">订单号</td>
					<td width="10%" nowrap class="yr_06">客户编号</td>
					<td width="25%" nowrap class="yr_06">客户地址</td>
					<td width="11%" nowrap class="yr_06">DATE</td>
					<td width="10%" nowrap class="yr_06">FROM</td>
					<td width="7%" nowrap class="yr_06">TEL</td>
					<td width="7%" nowrap class="yr_06">FAX</td>
					<td width="7%" nowrap class="yr_06">联系人</td>
					<td width="10%" nowrap class="yr_06">是否审核</td>
					<td width="18%" nowrap class="yr_06" colspan="3">操作</td>
				</tr>
       <c:choose>
          <c:when test="${empty getPaglist }">
          </c:when>
          <c:otherwise>
        <c:forEach items="${getPaglist }" var="guestorder">
				<tr id="row${guestorder.id }">
					<td nowrap class="yr_07">${guestorder.id}</td>
					<td nowrap class="yr_07">${guestorder.guestcode}</td>
					<td nowrap class="yr_07">${guestorder.address}</td>
					<td nowrap class="yr_07">${guestorder.times}</td>
					<td nowrap class="yr_07">${guestorder.froms}</td>
					<td nowrap class="yr_07">${guestorder.tel}</td>
					<td nowrap class="yr_07">${guestorder.fax}</td>
					<td nowrap class="yr_07">${guestorder.linkman}</td>
					<td nowrap class="yr_07">
						<div align="center">
							<a href="#" onclick="getid(id)">审核</a>
						</div>
					</td>
					<td nowrap class="yr_07">
						<div align="center">
							[<a href="#" onClick="deletes(${guestorder.id})">删除</a>]
						</div>
					</td>
					<td nowrap class="yr_07">
						<div align="center">
							[<a href="../GuestorderServlet.do?action=selectById&id=${guestorder.id}">修改</a>]
						</div>
					</td>
					<td nowrap class="yr_07">
						<div align="center">
							[<a href="#" onClick="printll(id)">打印</a>]
						</div>
					</td>
           </c:forEach>
      </c:otherwise>
    </c:choose>
			</table>
    			<table width="96%" align="center">
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
		</form>
		<br>
		<IFRAME id="submsg"
			style="Z-INDEX: 1; VISIBILITY: inherit; WIDTH: 100%; HEIGHT: 48%"
			name="submsg" src="<%=basePath%>audit/welcome.jsp" frameBorder="0"
			scrolling="auto"></IFRAME>
	</body>
</html>