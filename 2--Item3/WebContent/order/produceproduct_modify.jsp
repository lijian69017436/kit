<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/checksession.jsp"%>

<html>
<head>
    <link href="<%=basePath%>style/css.css" rel="stylesheet" type="text/css" />
                <style type="text/css">
                <!--
                .style1 {color: #FF0000}
                -->
                </style>
    <script type="text/javascript" src="../js/jquery.js"></script>
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
    <script type="text/javascript">
    $(function(){
        alert("2");
      $("#submit11").click(function(){
        var form=$("[name='f1']").serialize();
        alert(form);
        $.ajax({
          type:"post",
          url:"<%=basePath%>ProduceproductServlet.do?action=update",
          data:form,
          success:function(){
            location.href="<%=basePath%>ProduceproductServlet.do?action=getPagelist&pageNow=1";
          }
        });
      });
    });
    
    </script>
    <title>百合内衣--管理系统</title>
    <link href="<%=basePath%>style/css.css" rel="stylesheet" type="text/css">
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<form name="f1"  method="post" action="">
  <table width="96%" border="0" cellpadding="0" cellspacing="0">
    <tr> 
    <td width="46%" height="30" class="yr_04"> 您的位置：业务平台&gt;&gt;修改生产单产品</td>
    <td width="54%" align="right" class="yr_04"> 
	
  </tr>
  </table>
  <table width="96%" border="0" align="center" cellpadding="4" cellspacing="1" class="yr_05">
    <tr bgcolor="#FFFFFF" align="center">
      <td height="23" colspan="16" class="yr_08" > <span class="yr_04">修改生产单产品</span></td>
    </tr>
    <tr bgcolor="#FFFFFF" align="center"> 
            <input type="hidden" name="id11" value="${ex.id }"/>
        <td width="8%" nowrap class="yr_07">
           <div align="left">订单号：</div></td>
        <td width="14%" nowrap class="yr_07">
          <div align="left">
            <input  name="orderid" type="text"  class="input" size="15" value="${ex.orderid}"></div></td> 
        <td nowrap class="yr_07"><div align="left">产品编号: </div> 
        <td nowrap class="yr_07">
          <div align="left">
            <input  class="input" name="productcode" type="text" size="15" value="${ex.productcode}"></div> </td>
        <td width="10%" nowrap class="yr_07"><div align="left">货品名称：</div> </td>
        <td nowrap class="yr_07">
          <div align="left">
            <input  class="input" name="productname" type="text" size="15"value="${ex.productname}">
        	</div>
  	     </td>
        <td nowrap class="yr_07"><div align="left">型号规格：</div> </td>
        <td nowrap class="yr_07"><div align="left">
          <input  class="input" name="guige" type="text" size="15" value="${ex.guige}"></div>
        </td>
    </tr>
	  <tr bgcolor="#FFFFFF" align="center">
      <td width="8%" nowrap class="yr_07"><div align="left">颜色:</div></td>
      <td width="14%" nowrap class="yr_07">
        <div align="left">
          <input  class="input" name="color" type="text" size="15"value="${ex.color}">
		</div>
        </td>
      <td nowrap class="yr_07"><div align="left">单 位:</div></td>
      <td nowrap class="yr_07">
        <div align="left">
          <input  class="input" name="unit" type="text" size="15" value="${ex.unit}">
		</div>
        </td>
      <td nowrap class="yr_07"><div align="left">净重:</div></td>
      <td nowrap class="yr_07">
        <div align="left">
          <input  class="input" name="suttle" type="text" size="15" value="${ex.suttle}">
		</div>
        </td>
      <td nowrap class="yr_07"><div align="left">折 扣：</div> </td>
      <td nowrap class="yr_07"><div align="left">
        <input  class="input" name="discount" type="text" size="15" value="${ex.discount}"></div>
       </td>
    </tr>	
  <tr bgcolor="#FFFFFF" align="center">
      <td width="8%" height="27" nowrap class="yr_07"><div align="left">价格:</div></td>
      <td nowrap class="yr_07">
        <div align="left">
          <input  class="input" name="price" type="text" size="15" value="${ex.price}"></div>
         </td>
      <td width="8%" nowrap class="yr_07"><div align="left">币 制 :</div></td>
      <td width="18%" height="27" nowrap class="yr_07">
        <div align="left">
          <input  name="moneytype" type="text" size="15" value="${ex.moneytype}">
		</div>
      </td>
	  <td height="27" nowrap class="yr_07"><div align="left">金额: </td>
	  <td width="17%" height="27" nowrap class="yr_07">
        <div align="left">
             <input  class="input" name="money" type="text" size="15" value="${ex.money}">
      	</div>
	  </td>
         <td width="9%" height="27" nowrap class="yr_07"><div align="left">描述：</div> </td>
         <td width="16%" height="27" nowrap class="yr_07">
           <div align="left">
             <input  class="input" name="fullmoney" type="text" size="15" value="${ex.fullmoney}">
           </div> 
		</td>
  </tr>
	<tr bgcolor="#FFFFFF" align="center">
      <td nowrap class="yr_07"><div align="left">图片: </div> </td>
      <td width="14%" nowrap class="yr_07"><div align="left">
        <input  class="input" name="sizes" type="text" size="15" value="${ex.sizes}"></div>
      </td>
      <td width="8%" height="27" nowrap class="yr_07"><div align="left">数 量：</div> </td>
      <td colspan="5" nowrap class="yr_07">
        <div align="left">
            <input   name="totals" type="text" size="15" value=""/>
        </div>
		</td>
    </tr>
  </table>
  <br>
  <center>
    <input  class="input" type="button" name="Submit11"  id="submit11"value="提交">
    <input  class="input" type="reset" name="Submit" value="重写">
  </center>
</form>
</body>
</html>