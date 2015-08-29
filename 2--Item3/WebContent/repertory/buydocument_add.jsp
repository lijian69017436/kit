<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
          //协议                                                   名字                                                               端口号
%>

<html>
<head>
<title>百合内衣--管理系统</title>
<link href="<%=request.getContextPath()%>/style/css.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
$(function(){
  $("[name='Submit1']").click(function(){
    var table=$("#form11").serialize();
    alert(table);
    $.ajax({
      type:"post",
      url:"../BuydocumentServlet.do?action=insert",
      data:table,
      success:function(){
        location.href="../BuydocumentServlet.do?action=getPagelist&pageNow=1";
      }
    });
  });
});
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
  <form name="pageObject" id="form11" action=""    >
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr> 
    <td width="46%" height="30" class="yr_04"> 您的位置：库房管理&gt;&gt;采购单信息<br></td>
    <td width="54%" align="right" class="yr_04"> 
  
  <br></tr>
  </table>
  <table width="96%" border="0" align="center" cellpadding="4" cellspacing="1" class="yr_05">
    <tr  align="center">
      <td height="23" colspan="10" class="yr_08" > <span class="yr_04">新增采购单产品</span></td>
    </tr>
    <tr>
      <td width="8%"  class="yr_07"><div align="left">订单号：</div></td> 
      <td width="15%" nowrap  class="yr_07"><div align="left">
        <input  name="orderid" type="text"  class="input" size="10" >
      </div></td> 
      <td width="11%" nowrap  class="yr_07"><div align="left">供应商编号：</div>
      <td width="16%" nowrap  class="yr_07"><div align="left">
        <input   class="input" name="codes" type="text" size="15">      
      </div>
      <td width="11%" nowrap  class="yr_07"><div align="left">供应商名称：      </div>
      <td width="16%" nowrap  class="yr_07"><div align="left">
        <input  class="input"  name="providername" type="text" size="15">
      </div>
      <td width="6%" nowrap  class="yr_07"><div align="left">地址：</div></td>
      <td width="17%" nowrap  class="yr_07"><div align="left">
        <input  class="input" name="address" type="text" size="15">
      </div></td>
    </tr>
  <tr>
    <td nowrap  class="yr_07"><div align="left">电 话：</div></td>
    <td height="27" nowrap class="yr_07"><div align="left">
      <input  class="input" name="tel" type="text" size="10">
      </div></td>
    <td height="27" nowrap class="yr_07"><div align="left">日 期：</div></td>
      <td height="27" nowrap class="yr_07"><div align="left">
        <input  class="input" name="times" type="text" size="15" >
         <img src="../images/calendar_bnt.gif" style="cursor:hand;" align="absmiddle" alt="" onClick="fPopUpCalendarDlg(times);return false">
        
      </div></td>
      <td height="27" nowrap class="yr_07"><div align="left">传真：</div></td>
      <td height="27" nowrap class="yr_07"><div align="left">
        <input  class="input"  name="fax" type="text" size="15">
      </div></td>
      <td height="27" nowrap class="yr_07"><div align="left">邮箱：</div></td>
      <td height="27" nowrap class="yr_07"><div align="left">
        <input  class="input"  name="emails" type="text" size="15">
      </div></td>
  </tr>
  <tr>
    <td nowrap  class="yr_07"><div align="left">联系人：</div></td>
      <td height="27"  nowrap class="yr_07">
        <div align="left">
          <input  class="input" name="linkman" type="text" size="10"></div></td>
      <td nowrap  class="yr_07"><div align="left">仓库类别：</div></td>
      <td height="27" colspan="5" nowrap class="yr_07">
        <div align="left">
          <input  class="input"  name="types" type="text" size="15">
        </div></td>
    </tr>
  </table>
  <center>
    <p>
      <input  class="input" type="button" name="Submit1" value="提交">
      <input  class="input" type="reset" name="Submit2" value="重写">
    </p>
 </center>
</form>
</body>
</html>