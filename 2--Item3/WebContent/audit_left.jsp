<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="checksession.jsp"%>
<HTML>
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 6.00.2800.1479" name=GENERATOR><style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="<%=basePath %>style/style.css" rel="stylesheet" type="text/css">
</HEAD>

<BODY bgcolor="#E9F4FD">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#E9F4FD">
  <tr>
    <td height="20" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tbody >
        <tr>
          <td width="2%" valign="bottom">
              <img class="outline" id="MEMU_01" style="CURSOR: hand" onClick="myclick(this)" src="images/tree_minusl.gif" /></td>
          <td width="2%" valign="bottom">
              <img alt="系统管理" src="<%=basePath %>images/mytable.gif" width="19" border="0" /></td>
          <td width="96%" colspan="3"><span class="gray12">
          <a href="javascript:myclick(MEMU_01)">&nbsp;财务管理</a> &nbsp;&nbsp;
          <a href="javascript:menu_expand()"><u>
          <span id="expand_text">展开</span></u></a></span> </td>
        </tr>
      </tbody>
    </table></td>
  </tr>
  <tr>
    <td valign="top" bgcolor="#E9F4FD"  id="MEMU_01d" style="display:">

      <table width="145" border="0" cellpadding="0" cellspacing="0" class="small">
        <tbody>
          <tr>
            <td width="19"><img src="images/tree_transp.gif" border="0" /></td>
            <td width="19"><img src="images/tree_blank.gif" /></td>
            <td width="19"><img height="16" alt="出口询价" src="images/diary.gif" width="16" border="0" /></td>
            <td width="100" colspan="2">  &nbsp;
                <a href="<%=basePath%>BuydocumentServlet.do?action=getPagelist&pageNow=1" class="gray12" target="bottomFrame">采购付款</a></td>
          </tr>
        </tbody>
      </table>
      <table width="145" border="0" cellpadding="0" cellspacing="0" class="small">
        <tbody>
          <tr>
            <td width="19"><img src="images/tree_transp.gif" border="0" /></td>
            <td width="19"><img src="images/tree_blank.gif" /></td>
            <td width="19"><img height="16" alt="客户订单" src="images/diary.gif" width="16" border="0" /></td>
            <td width="100" colspan="2">&nbsp;
                <a href="<%=basePath%>PaymentincaseServlet.do?action=getPagelist&pageNow=1" class="gray12" target="bottomFrame">订单发票</a></td>
          </tr>
        </tbody>
      </table>
       <table width="145" border="0" cellpadding="0" cellspacing="0" class="small">
        <tbody>
          <tr>
            <td width="19"><img src="images/tree_transp.gif" border="0" /></td>
            <td width="19"><img src="images/tree_blank.gif" /></td>
            <td width="19"><img height="16" alt="客户订单" src="images/diary.gif" width="16" border="0" /></td>
            <td width="100" colspan="2">&nbsp;<a href="<%=basePath%>audit/auditmanagement.jsp" class="gray12" target="bottomFrame">审核设置</a></td>
          </tr>
        </tbody>
      </table>
      </td>
  </tr>
</table>



<script language="JavaScript">
var openedid;
var openedid_ft;
var flag=0,sflag=0;

//-------- 菜单点击事件 -------
function myclick(srcelement){
  var targetid,srcelement,targetelement;
  var strbuf;

  //-------- 如果点击了展开或收缩按钮---------
  if(srcelement.className=="outline")  {
     //if(srcelement.title!="" && srcelement.src.indexOf("plus")>-1)
       // menu_shrink();

     targetid=srcelement.id+"d";
     targetelement=document.all(targetid);

     if (targetelement.style.display=="none")     {
        targetelement.style.display='';
        strbuf=srcelement.src;
        if(strbuf.indexOf("plus.gif")>-1)
                srcelement.src="images/tree_minus.gif";
        else
                srcelement.src="images/tree_minusl.gif";
     }
     else     {
        targetelement.style.display="none";
        strbuf=srcelement.src;
        if(strbuf.indexOf("minus.gif")>-1)
                srcelement.src="images/tree_plus.gif";
        else
                srcelement.src="images/tree_plusl.gif";
     }
  }
}

//-------- 打开网址 -------
function openURL(URL){
    parent.openURL(URL);
}

//-------- 菜单全部展开/收缩 -------
var menu_flag=0;
function menu_expand(){
  if(menu_flag==0)
     expand_text.innerHTML="收缩";
  else
     expand_text.innerHTML="展开";

  menu_flag=1-menu_flag;

  for (i=0; i<document.all.length; i++)  {
        srcelement=document.all(i);
        if(srcelement.className=="outline")        {
                targetid=srcelement.id+"d";
                targetelement=document.all(targetid);
                if (menu_flag==1)                {
                        targetelement.style.display='';
                        strbuf=srcelement.src;
                        if(strbuf.indexOf("plus.gif")>-1)
                                srcelement.src="images/tree_minus.gif";
                        else
                                srcelement.src="images/tree_minusl.gif";
                }else                {
                        targetelement.style.display="none";
                        strbuf=srcelement.src;
                        if(strbuf.indexOf("minus.gif")>-1)
                                srcelement.src="images/tree_plus.gif";
                        else
                                srcelement.src="images/tree_plusl.gif";
                }
        }
  }
}

//-------- 收缩打开的主菜单项 -------
function menu_shrink()
{
  for (i=0; i<document.all.length; i++)
  {
        srcelement=document.all(i);
        if(srcelement.title!="")
        {
              strbuf=srcelement.src;

              if(strbuf.indexOf("minus")>-1)
              {
                 targetid=srcelement.id+"d";
                 targetelement=document.all(targetid);
                 targetelement.style.display='none';

                 if(strbuf.indexOf("minus.gif")>-1)
                    srcelement.src="images/tree_plus.gif";
                 else
                    srcelement.src="images/tree_plusl.gif";
               }
         }
  }
}

//-------- 打开windows程序 -------
function winexe(NAME,PROG)
{
   URL="/general/winexe?PROG="+PROG+"&NAME="+NAME;
   window.open(URL,"winexe","height=100,width=350,status=0,toolbar=no,menubar=no,location=no,scrollbars=yes,top=0,left=0,resizable=no");
}
</script>



</BODY>
</HTML>

