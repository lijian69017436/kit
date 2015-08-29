<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/checksession.jsp"%>
<HTML>
<HEAD>
<TITLE>百合内衣--管理系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css></STYLE>
<SCRIPT language=javascript>
<!--
function openwin(url) {
var newwin = window.open(url,"","scrollbars=no,resizable=no, width=700,height=500");
return false;
}

function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,features);
}
//-->
</SCRIPT>
<SCRIPT language=javascript>
function switchSysBar_top(){
	if (switchPointtop.innerText==5){
		switchPointtop.innerText=6;
		document.all("topmnuList").style.display="none";		
		top.main.rows="26,*";
	}
	else{
		switchPointtop.innerText=5;
		document.all("topmnuList").style.display=""	;			
		top.main.rows="91,*"	;	
	}
}
</SCRIPT>

<script>
var XMLHttpReq;
//创建XMLHttpRequest对象       
function createXMLHttpRequest() {
	if(window.XMLHttpRequest) { //Mozilla 浏览器

		XMLHttpReq = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) { // IE浏览器

		try {
			XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {}
		}
	}
}

//发送请求函数
function sendRequest() {
	createXMLHttpRequest();
	var url = "auto_funsh.jsp";
	//alert(" the url:  "+url);
	XMLHttpReq.open("GET", url, true);
	XMLHttpReq.onreadystatechange = processResponse;//指定响应函数
	XMLHttpReq.send(null);  // 发送请求

}
// 处理返回信息函数
function processResponse() {
	if (XMLHttpReq.readyState == 4) { // 判断对象状态
		if (XMLHttpReq.status == 200) { // 信息已经成功返回，开始处理信息
			DisplayHot();
			setTimeout("sendRequest()", 60000);
		} else { //页面不正常
//			window.alert("您所请求的页面有异常,连接数据库失败!");
		}
	}
}

function DisplayHot() {
	 
	  var name = XMLHttpReq.responseXML.getElementsByTagName("name")[0].firstChild.nodeValue;
	  var count = XMLHttpReq.responseXML.getElementsByTagName("count")[0].firstChild.nodeValue;
	  var show = XMLHttpReq.responseXML.getElementsByTagName("show")[0].firstChild.nodeValue;
	  
		//document.getElementById("product").innerHTML = name;
		//document.getElementById("count").innerHTML = count;		
		//document.getElementById("show").innerHTML = show;
		
		var ddd="onClick=javascript:show_sms('"+name+"');return false";
		if(show ==0){
			document.getElementById("show").innerHTML="<a href='#' "+ddd+"><img src='images/sms1.gif' border=0 height=12>短信"+
		"<object id='sms_sound' classid='clsid:D27CDB6E-AE6D-11cf-96B8-444553540000'"+
		"codebase='http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0' width='0' height='0'>"+
		"<param name='movie' value='images/1.swf'><param name=quality value=high>"+
		"<embed id='sms_sound' src='images/1.swf' width='0' height='0' quality='autohigh' wmode='opaque' "+
		"type='application/x-shockwave-flash' "+ 
		"plugspace='http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash'></embed></object></a>";
		show_sms(name);
		}else{
			document.getElementById("show").innerHTML = "";
		}
		
}

//弹出
function show_sms(url)
{
   mytop=screen.availHeight-190;
   myleft=0;
   window.open(url,"","height=150,width=350,status=0,toolbar=no,menubar=no,location=no,scrollbars=yes,top="+mytop+",left="+myleft+",resizable=yes");
}


</script>

<META content="MSHTML 6.00.2800.1106" name=GENERATOR>
<link rel="stylesheet" href="style/css.css">
<style type="text/css">
<!--
.STYLE1 {
	font-size: 16pt;
	font-weight: bold;
	color: #4C6494;
}
-->

</style>
</HEAD>
<BODY bgColor=#ffffff leftMargin=0 topMargin=0 marginwidth="0" marginheight="0" onload=sendRequest()>
<table width="101%" border="0" cellpadding="0" cellspacing="0" background="images/ss_02.gif">
  <tr>
    <td><table width="296" height="35" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td><span class="STYLE1">百合内衣--管理系统</span></td>
        </tr>
      </table></td>
    <td align="right" class="zise12">
	      <script language="JavaScript" > 
			<!---
			today=new Date();
			var hours = today.getHours();
			var minutes = today.getMinutes();
			var seconds = today.getSeconds();
			var timeValue = "<FONT COLOR=red>" + ((hours >12) ? hours -12 :hours);
			 timeValue += ((minutes < 10) ? "<BLINK><FONT COLOR=red>:</FONT></BLINK>0" : "<BLINK><FONT COLOR=red>:</FONT></BLINK>") + minutes+"</FONT></FONT>";
			 timeValue += (hours >= 12) ? "<FONT COLOR=blue><I><B>pm</B></I></FONT>" : "<FONT COLOR=blue><B><I>am</I></B></FONT>";
			function initArray(){
			this.length=initArray.arguments.length
			for(var i=0;i<this.length;i++)
			this[i+1]=initArray.arguments[i] }
			var d=new initArray("<font color=RED>星期日","<font color=red>星期一","<font color=red>星期二",
					"<font color=red>星期三","<font color=red>星期四","<font color=red>星期五","<font color=GREEN>星期六");
			document.write("<font color=red>",today.getYear(),"<font color=red>年","<font color=red>",today.getMonth()+1,
					"<font color=red>月","<font color=red>",today.getDate(),"<font color=red>日 </FONT>",d[today.getDay()+1]);
			 //-->
			</script>
	</td>
    <td align="right" class="zise12">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="3" valign="bottom"><table width="94%" border="0" cellpadding="0" cellspacing="5" class="lanse12">
      <tr>
        <td><img src="images/ss_04.gif" width="12" height="18" alt="" /></td>
        <td>全部菜单</td>
        
        <td><img src="images/ss_14.gif" width="25" height="18" alt="" /></td>
        <td><a href="communication_left.jsp" target="leftFrame">业务平台</a></td>
        <td><img src="images/ss_14.gif" width="25" height="18" alt="" /></td>
        <td><a href="audit_left.jsp" target="leftFrame">财务管理</a></td>
        
        
        <td><img src="images/ss_12.gif" width="19" height="18" alt="" /></td>
        <td><a  target="leftFrame">审核管理</a></td>
        
        <td><img src="images/ss_06.gif" width="21" height="18" alt="" /></td>
        <td><a   target="leftFrame">基础资料</a></td>
        
        
        <td><img src="images/ss_14.gif" width="25" height="18" alt="" /></td>
        <td><a   target="leftFrame">生产采购平台</a></td>
        
        <td><img src="images/ss_12.gif" width="19" height="18" alt="" /></td>
        <td><a   target="leftFrame">库房管理</a></td>        
        
         <td><img src="images/ss_10.gif" width="20" height="18" alt="" /></td>
        <td><a   target="leftFrame">报表与统计</a></td>
        
        
        
        <td><img src="images/ss_16.gif" width="21" height="18" alt="" /></td>
        <td><a   target="leftFrame">员工管理</a></td>
        
        <td><img src="images/ss_06.gif" width="21" height="18" alt="" /></td>
        <td><a   target="leftFrame">系统管理</a></td>
        
<%--        <td><img src="images/ss_10.gif" width="20" height="18" alt="" /></td>--%>
<%--        <td><a href="result_left.jsp" target="leftFrame">结算管理</a></td>--%>
        
       
        
<%--        <td><img src="images/ss_14.gif" width="25" height="18" alt="" /></td>--%>
<%--        <td><a href="personal_office_left.jsp" target="leftFrame">日志管理</a></td>--%>
        
        
        
        <td><img src="images/ss_18.gif" width="21" height="18" alt="" /></td>
        <td><a   target="leftFrame">常用资料</a></td>
        
<%--        <td><img src="images/ss_20.gif" width="19" height="18" alt="" /></td>--%>
<%--        <td><a href="help/oa_help.html" target="leftFrame">系统帮助</a></td>--%>
        
      <td><img src="images/exit2.gif" width="16" height="16"></td>
      <td><a  target="_parent" >退出</a></td>
     
     
      </tr>
    </table>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>
          <table border="0" cellspacing="0" cellpadding="0" width="100%" >
              <tr>
                <td width="1" rowspan="2"  align="center" bgcolor="#8093C1" ></td>
                <td height="2"  align="center" ></td>
              </tr>
              <tr>
                <td  align="center" >
                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                      <td height="12">
                      <table width="100%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="170" align="center" background="images/x_05.gif">
                            <table width="170" height="25" border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                  <td align="center"><span class="lanse12">主菜单</span></td>
                                  <td width="1" bgcolor="#8093C1"></td>
                                  <td align="center"><span class="lanse12">
                                    <a href="loginShow.jsp" target="bottomFrame">在线人员</a></span></td>
                                  <td width="1" bgcolor="#8093C1"></td>
                                  <td align="center"><span class="lanse12">全部人员</span></td>
                                </tr>
                            </table></td>
                            <td width="1" height="25" bgcolor="#8093C1"></td>
                            <td width="810" background="images/x_07.gif" bgcolor="">
                            <table width="41%" height="20" border="0" cellpadding="0" cellspacing="0" class="gray12">
                                <tr valign="middle">
                                  <td align="center"><div align="left"></div>
<script>							  
now = new Date();
var hour2 = now.getHours()
var tmp="";
var sstr = "";
	if(hour2 < 6){sstr=("凌晨好!");}
	else if (hour2 < 9){sstr=("早上好!");}
	else if (hour2 < 12){sstr=("上午好!");}
	else if (hour2 < 14){sstr=("中午好!");}
	else if (hour2 < 17){sstr=("下午好!");}
	else if (hour2 < 19){sstr=("傍晚好!");}
	else if (hour2 < 22){sstr=("晚上好!");}
	else {sstr=("夜里好!")}
	document.write(sstr);
</script>	
<%--								  <%=staffcnname%>--%>
								  <!--IFRAME border=0 
                  name=guest marginWidth=0 frameSpacing=0 marginHeight=0 
                  src="<%//=request.getContextPath()%>/user_logrefresh.jsp" frameBorder=0 noResize width=38 
                  scrolling=no height=15 > </IFRAME-->
				   
								  </td>
								  <td align="center" id="show"></td>
                                  <!--td align="center"><img src="images/t_08.gif" width="18" height="13" /></td>
                                  <td align="center">产品展示》</td>
                                  <td align="center"><img src="images/t_10.gif" width="16" height="14" /></td>
                                  <td align="center">部门经理</td>
                                  <td align="center"><img src="images/t_05.gif" width="17" height="15" /></td>
                                  <td align="center">忙碌</td-->
                                </tr>
                            </table></td>
                          </tr>
                      </table></td>
                    </tr>
                    <tr>
                      <td height="1" bgcolor="#8093C1"></td>
                    </tr>
                </table></td>
              </tr>
          </table></td>
        </tr>
    </table>
  </td>
 </tr>
</table>

</BODY>
</HTML>

<script>
  now = new Date();
  var hour2 = now.getHours()
  var tmp="";
  var sstr = "";
  	if(hour2 < 6){sstr=("凌晨好!")}
  	else if (hour2 < 9){sstr=("早上好!")}
  	else if (hour2 < 12){sstr=("上午好!")}
  	else if (hour2 < 14){sstr=("中午好!")}
  	else if (hour2 < 17){sstr=("下午好!")}
  	else if (hour2 < 19){sstr=("傍晚好!")}
  	else if (hour2 < 22){sstr=("晚上好!")}
  	else {sstr=("夜里好!")}
</script>

                                                                                                    
