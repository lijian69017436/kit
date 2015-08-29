<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/checksession.jsp"%>
<html>
<head>
<title>百合内衣--管理系统</title>
<link href="style" rel="stylesheet" type="text/css">
<link href="<%=basePath %>style/css.css" rel="stylesheet" type="text/css">

<script src="js/common.js" language=javascript></script>
<script src="js/Calendar.js" language=javascript></script>
<script src="js/popwin.js" language=javascript></script>
<script src="js/checkForm.js" language=javascript></script>
<script language="javascript">
	function getid(id){
		window.open("<%=basePath %>audit/audittable_add.jsp?audittype=export&id="+id,"newwindow", "height=300, width=500, top=250, left=250, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no");
		//location.href="showExportclient.do";
	}
	function updates(){
		alert("ytm");
	}
	function getall(id){
		location.href="showExportproduct.do?act=down&id="+id;   
	}
	function Page(pageNum){
	if(checkNum(pageNum)==0) {
   		alert("要跳转的页数必须是大于0的数字！");
   		return;
	}
	
	var page_objForm=document.forms[0];
	page_objForm.pageNum.value= pageNum;
        page_objForm.action="<%=basePath %>exportclient_list.jsp";
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
		location.href="<%=basePath %>exportclient_modify.jsp?act=modify&id="+id;
	}
	function remove(id){
		location.href="<%=basePath %>/removeExportclient.do?id="+id;
	}
	function customSubmit(pInput,pURL)
	{
		var theForm=document.forms[0];
		theForm.pageNum.value=1;
		theForm.submit();
	}
	
	function auto(inforcontent,id){
		location.href="<%=basePath %>/addPaymentincase.do?inforcontent="+inforcontent+"&id="+id+"";
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
  <br>
  <table width="96%" border="0" align="center" cellpadding="4" cellspacing="1" class="yr_05">
    <tr  align="center">
      <td height="42" colspan="8" class="yr_08" >单据列表</td>
    </tr>
    <tr height=18>
    <logic:notEmpty name="document">
    <% 

    //request.setAttribute("inman",new codeDao().getColume("staffinfo","staffcnname"));
List document=(List)request.getAttribute("document");
	for(int i=0;i<document.size();i++){
		Object[] str=(Object[])document.get(i);
			for(int y=0;y<str.length;y++){
 %>
		 <td nowrap class="yr_07"><%=str[y]%></td>
	<%
	}
	 }
	 %> 
	  </logic:notEmpty>
	  </tr>
  </table>
  <br>
  <br>
  <br>
  <br>
  <table width="96%" border="0" align="center" cellpadding="4" cellspacing="1" class="yr_05">
    <tr   align="center">
      <td height="23" class="yr_08" colspan="12" ><span class="yr_04">产品信息</td>
    </tr>
    <logic:notEmpty name="product">
    <%
List product=(List)request.getAttribute("product");
	for(int i=0;i<product.size();i++){
		Object[] str=(Object[])product.get(i);
 %>
	 <tr height=18>
	 	<%for(int y=0;y<str.length;y++)
	 	{
	 	 %>
	     <td nowrap class="yr_07"><%=str[y] %></td>
	     <%} %>
	 </tr>
	<%
	}
	 %> 
	  </logic:notEmpty>
  </table>
  <br>
  <br>
  <br>
  
  <form name=homeForm method="POST" action="<%=basePath %>//modifyAudittable.do" onSubmit="return isSubmit();">
  <table width="96%" border="0" align="center"  cellpadding="0" cellspacing="1" class="yr_05">
  	<input type="hidden" name="orderid"  value="<bean:write name="inforid"/>">
  	<input type="hidden" name="audittype" value="<bean:write name="inforcontent"/>">
  	<logic:notEqual  value="1" name="isaudit">
  	<logic:empty name="incaseid">
  		<tr align="center" >
	  		<td height="42" colspan="8" class="yr_08" >审核消息</td>
	  	</tr>
	  	<tr >
	  		<td width="8%" nowrap class="yr_07">是否通过:</td>
	  		<td width="92%" nowrap class="yr_07">
				<select  class="input" name="state">
					<option  class="input">通过</option>
					<option>不通过</option>
				</select>
		  </td>
		</tr>	
		<tr>
		  <logic:equal value="0" name="isaudit">	  	
	  		<td width="8%" nowrap class="yr_07">选择采购:</td>
	  		<td width="92%" nowrap class="yr_07">
				<select name="stock">
		      		<logic:present name="inman">
		      			<logic:iterate id="na" name="inman">
		      				<option><bean:write name="na"/></option>
		      			</logic:iterate>
		      		</logic:present>
		      	</select>
		  </td>	
		 	
		  </logic:equal>	
	  	</tr>
	  	<tr>
	  		<td nowrap class="yr_07">审核意见:</td>
			<td nowrap class="yr_07">
				<textarea name="feedback" cols="20" rows="3"  class="input"></textarea>
			</td>
	  	</tr>
	  	<tr align="center">
	  		<td nowrap class="yr_07" colspan="2"><input  class="input" type="submit" value="提交">&nbsp;&nbsp;&nbsp;<input  class="input" type="submit" value="重写"></td>
	  	</tr>
  	
  	</logic:empty>
  		<logic:present name="incaseid"> 
  	<tr align="center"> 			
  			<td nowrap class="yr_07" colspan="2"><a href="#" onClick="auto('<bean:write name="inforcontent"/>','<bean:write name="incaseid"/>' )">申请发票</a></td>
  	</tr>
  	</logic:present>
  	 
  	</logic:notEqual>
<%--  	<tr align="center">--%>
<%--  		<logic:equal value="1" name="isaudit">			--%>
<%--  			<td nowrap class="yr_07" colspan="2"><font color="red"><a href="#" onClick="auto('<bean:write name="isaudit"/>' )">显示库存不足!</a></font></td>--%>
<%--  			<table width="96%" border="0" align="center" cellpadding="4" cellspacing="1" class="yr_05" >--%>
<%--			    <tr align="center" bgcolor="#FFFFFF" >--%>
<%--			      <td height="13" colspan="17" class="yr_08"><span >生产单产品信息</span></td>--%>
<%--			    </tr>--%>
<%--			    <tr bgcolor="" align="center" >--%>
<%--			      <td width="7%" height="13" class="yr_08">生产号</td>--%>
<%--			      <td width="7%" class="yr_08">货品编号</td>--%>
<%--			      <td width="8%" class="yr_08">货品名称</td>--%>
<%--			      <td width="6%" class="yr_08">规格</td>--%>
<%--			      <td width="6%" height="13" class="yr_08">颜色</td>--%>
<%--			      <td width="7%" height="10" class="yr_08">数量</td>--%>
<%--			      <td width="3%" height="13" class="yr_08">单 位</td>--%>
<%--			      <td width="4%" class="yr_08">币 制</td>--%>
<%--			      <td width="4%" height="10" class="yr_08">净重</td>--%>
<%--			      <td width="4%" height="13" class="yr_08">折 扣</td>--%>
<%--			      <td width="5%" class="yr_08">价格</td>--%>
<%--			        <td width="8%" class="yr_08">金额</td>--%>
<%--			          <td width="5%" class="yr_08">描述</td>--%>
<%--			            <td width="8%" class="yr_08">图片</td>--%>
<%--			    </tr>--%>
<%--				<logic:empty name="produ">--%>
<%--				 <tr height=18 >--%>
<%--					 <td>&nbsp;<br></td>--%>
<%--				     <td>&nbsp;<br></td>--%>
<%--					 <td>&nbsp;<br></td>--%>
<%--					 <td>&nbsp;<br></td>--%>
<%--					 <td>&nbsp;<br></td>--%>
<%--					 <td>&nbsp;<br></td>--%>
<%--					 <td>&nbsp;<br></td>--%>
<%--					 <td>&nbsp;<br></td>--%>
<%--					 <td>&nbsp;<br></td>--%>
<%--					 <td>&nbsp;<br></td>--%>
<%--				 </tr></logic:empty>  --%>
<%--				<logic:notEmpty name="produ">--%>
<%--				 <logic:iterate id="result" name="produ" type="cn.bway.foreigntrade.order.produceproduct.model.Produceproduct">--%>
<%--				    <tr>--%>
<%--				      <td nowrap class="yr_07"><bean:write name="result"  property="orderid"/></td>--%>
<%--				      <td nowrap class="yr_07"><bean:write name="result"  property="productcode"/></td>--%>
<%--				      <td nowrap class="yr_07"><bean:write name="result"  property="productname"/></td>--%>
<%--				      <td nowrap class="yr_07"><bean:write name="result"  property="guige"/></td>--%>
<%--				      <td nowrap class="yr_07"><bean:write name="result"  property="color"/></td>--%>
<%--				      <td nowrap class="yr_07"><bean:write name="result"  property="totals"/></td>--%>
<%--				      <td nowrap class="yr_07"><bean:write name="result"  property="unit"/></td>--%>
<%--				      <td nowrap class="yr_07"><bean:write name="result"  property="moneytype"/></td>--%>
<%--				      <td nowrap class="yr_07"><bean:write name="result"  property="suttle"/></td>--%>
<%--				      <td nowrap class="yr_07"><bean:write name="result"  property="discount"/></td>--%>
<%--				      <td nowrap class="yr_07"><bean:write name="result"  property="price"/></td>--%>
<%--				      <td nowrap class="yr_07"><bean:write name="result"  property="money"/></td>--%>
<%--				      <td nowrap class="yr_07"><bean:write name="result"  property="fullmoney"/></td>--%>
<%--				      <td nowrap class="yr_07"><bean:write name="result"  property="color"/>--%>
<%--				    </tr>--%>
<%--			    </logic:iterate>--%>
<%--			    </logic:notEmpty>--%>
<%--			  </tr>--%>
<%--			  </table>--%>
<%--  		</logic:equal>--%>
<%--  	</tr>--%>
  		<logic:present  name="productcode">
  		<input type="hidden" name="act"  value="add">
  		<input type="hidden" name="incasegetid"  value="<bean:write name="incasegetid"/>">
  	<tr align="center">
  		<p align="center"><a href="#" onClick="auto('<bean:write name="isaudit"/>' )"><h1 ><font color="red">库存不足!</font></h1></a></p>
  		<td  width="100%">
  		<table width="100%"  border="0" align="center" cellpadding="0" cellspacing="1" class="yr_05">
		    <tr  > 
		      <td width="6%"  class="yr_06"><div align="center">编号</td>
		      <td width="10%" nowrap  class="yr_06">产品名称</td>
		      <td width="8%" nowrap  class="yr_06">类别</td>
		      <td width="5%" nowrap  class="yr_06">单价</td>
		      <td width="10%" nowrap  class="yr_06">规格</td>
		      <td width="10%" nowrap  class="yr_06">颜色 </td>
		      <td width="10%" nowrap  class="yr_06">材料</td>      
		      <td width="10%" nowrap  class="yr_06">供应商名称</td>
		      <td width="6%" nowrap class="yr_06">库存</td>
		    </tr>
			   <logic:empty name="productcode">
			 <tr height=18>
				 <td>&nbsp;</td>
			     <td>&nbsp;</td>
				 <td>&nbsp;</td>
				 <td>&nbsp;</td>
				 <td>&nbsp;</td>
				 <td>&nbsp;</td>
			 </tr>  
			  </logic:empty>	  
			<logic:notEmpty name="productcode">
			 <logic:iterate id="result" name="productcode" indexId="index">	 
		    <tr bgcolor="red">
<%--		      <a href="#" onClick="querys('<bean:write name="result" property="id"/>')">--%>
		      <td><bean:write name="result" property="codes"/></td>
		      <td><bean:write name="result" property="names"/></td>
		      <td><bean:write name="result" property="types"/></td>
		      <td><bean:write name="result" property="price"/></td>
		      <td><bean:write name="result" property="spec"/></td>
		      <td><bean:write name="result" property="color"/></td>
		      <td><bean:write name="result" property="stuff"/></td>
		      <td><bean:write name="result" property="provide"/></td>
			  <td><bean:write name="result" property="numbers"/></td>
			  </a>
			  </tr>
		     </logic:iterate>
		     </logic:notEmpty>
		</table>
		</td>
		</font>
  	</tr>
  	<tr align="center">
	  <td nowrap class="yr_07" colspan="2"><input  class="input" type="submit" value="&nbsp;&nbsp;确定&nbsp;&nbsp;"></td>
	</tr>
		</logic:present>
  </table>
  </form>
</html>