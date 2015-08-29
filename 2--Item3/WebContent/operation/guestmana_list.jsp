<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/checksession.jsp"%>
<html>
<head>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
  $(function(){
  	$("linkman1").click(function(){
  		alert("d");
  	});
  });
  function click1(id){
    $("#view_tr2").html("");
    $.ajax({
      type:"post",//数据提交的方式
      url:"../GuestmanaServlet.do?action=selectGuestorderByGuestcode",
      data:{id:id},
      success:function(data){//data可以叫别的名字 成功后获取的数据
        //alert(data);
      	 var re= eval("("+data+")");
      	 var row=""+
         "<td>"+re.linkman+"</td>"+
         "<td>"+re.froms+"</td>"+
         "<td>"+re.fax+"</td>";
         $("#view_tr2").append(row);
      }
    });
  }
  function deletes(id){//删除 方法
    $.ajax({
      type:"post",//数据提交的方式
      url:"../GuestmanaServlet.do?action=delete",
      data:{id:id},
      success:function(){//data可以叫别的名字 成功后获取的数据
        var ro="#row"+id;
        $(ro).remove();
      }
    });
  }
</script>

<title>百合内衣--管理系统</title>
<link href="style" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/style/css.css" rel="stylesheet" type="text/css">
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="96%" border="0" cellpadding="0" cellspacing="0">
    <tr> 
    <td width="45%" height="30" class="yr_04"> 您的位置：基础资料&gt;&gt;客户管理</td>
    <td width="45%" align="right" class="yr_04"><strong>
	[<a href="<%=request.getContextPath()%>/operation/guestmana_add.jsp">新增</a>]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</strong></td>
  </tr>
  </table>
<form name="pageObject" action="../GuestmanaServlet.do?action=query" method="post" >
  <table width="96%" border="0" align="center" cellpadding="4" cellspacing="1" class="yr_05">
    <tr   align="center"> 
      <td height="23" colspan="7" class="yr_08" > 客户管理</td>
    </tr>
    <tr bgcolor="#FFFFFF"> 
      <td width="17%" height="28" nowrap class="yr_07">选择地区：        
      <select name="country">
    	   <option></option>
    	   <option>北京</option>
    	   <option>台湾</option>
    	   <option>澳门</option>
      </select>
      </td>
      <td width="19%" nowrap class="yr_07">客户名称：      
        <input class="input" name="namess" type="text" size="15"></td>
      <td width="19%">
        <input class="input" type="submit" name="Submit" value="查询" class="button">
        <input class="input" type="reset" name="Submit2" value="重写" class="button"></td>
    </tr>
  </table>
  <br>
  <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" class="yr_05">
    <tr> 
      <td width="8%"  class="yr_06"><div align="center">客户编号 </td>
      <td width="23%" nowrap  class="yr_06"><div align="center">客户名称 </td>
      <td width="11%" nowrap  class="yr_06">公司性质</td>
      <td width="18%" nowrap  class="yr_06">地址</td>
      <td width="8%" nowrap  class="yr_06">考察及时间</td>
      <td width="9%" nowrap  class="yr_06">代理及范围</td>
       <td width="8%" nowrap  class="yr_06">地区</td>
      <td nowrap colspan="2" class="yr_06"><div align="center">操作 </td>
    </tr>
   
     <c:choose>
      <c:when test="${empty getPaglist }">
      </c:when>
      <c:otherwise>
        <c:forEach items="${getPaglist}" var="guestmana">
              <tr id="row${guestmana.id}" onClick="click1(${guestmana.id})" >
                <td height="20" nowrap class="yr_07"> ${guestmana.id} </td>
                <td nowrap class="yr_07">${guestmana.name}</td>
                <td nowrap class="yr_07">${guestmana.propertys}</td>
                <td nowrap class="yr_07">${guestmana.address}</td>
                <td nowrap class="yr_07">${guestmana.review}</td>
                <td nowrap class="yr_07">${guestmana.payment}</td>
                <td nowrap class="yr_07">${guestmana.country}</td>      
  	            <td  align="center" class="yr_07"><strong>[<a href="#" onClick="deletes(${guestmana.id})">删除</a>]</strong></td>        
  	            <td  align="center" class="yr_07"><strong>[<a href="../GuestmanaServlet.do?action=selectById&id=${guestmana.id}" >修改</a>]</strong></td>
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
                <a href="<%=basePath%>GuestmanaServlet.do?action=getPagelist&pageNow=1">  第一页</a> 
                <a href="<%=basePath%>GuestmanaServlet.do?action=getPagelist&pageNow=${page.pageNow-1}">上一页</a> 
                <a href="<%=basePath%>GuestmanaServlet.do?action=getPagelist&pageNow=${page.pageNow+1}">下一页</a> 
                <a href="<%=basePath%>GuestmanaServlet.do?action=getPagelist&pageNow=${page.pageCount }">最后页</a> 
                                       每<input name="textfield32" type="text" size="2" class="input" value="${page.pageSize }" readonly="readonly">  页条 
              </td>
            </tr>
          </table>
<br><br><br><br>
	&nbsp;&nbsp;&nbsp;
   <table width="96%" border="0" align="center" cellpadding="0" id="view" style=":none" cellspacing="1" class="yr_05">
	    <tr align="center">
	      <td width="36%" class="yr_06" ><a href="#" id="linkman1">联系人</a></td>
	      <td width="36%" class="yr_06" ><a href="javascript:contractdata('guestcontractdata');">合同资料</td>
	      <td width="34%" class="yr_06" ><a href="javascript:logs('client');">往来日志</td>
	    </tr>
      <tr id="view_tr2">
      </tr>
      <h7>根据订单的客户编号来查询 详细信息的</h7>
	  </table>  

  <br>
</form>
<IFRAME id="submsg" style="Z-INDEX: 1; VISIBILITY: inherit; WIDTH: 100%; HEIGHT: 48%" 
      name="submsg" src="<%=request.getContextPath() %>/audit/welcome.jsp" frameBorder="0" scrolling="auto"></IFRAME>
</body>
</html>