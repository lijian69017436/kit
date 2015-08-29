<%@ page contentType="text/html; charset=utf-8"%>
<HTML>
<HEAD>
	<TITLE>百合内衣--管理系统</TITLE>
	<META http-equiv=Content-Type content="text/html; charset=utf-8">
	<META content="MSHTML 6.00.2800.1106" name=GENERATOR>
</HEAD>
<%@ include file="/checksession.jsp"%>
	<script language="javascript">
		top.moveTo(0, 0);
		top.resizeTo(screen.availWidth, screen.availHeight);
	</script>
<frameset rows="91,*,20" cols="*" frameborder="NO" border="0"framespacing="0" id="main">
	<frame name="topFrame" scrolling="no" noresize frameborder="0"      src="menu_top.jsp">
	<frameset rows="*" cols="172,10,*" frameborder="NO" border="0"framespacing="0" id="setyou">
		<frame name="leftFrame"  scrolling="NO" noresize marginwidth="152" src="left.jsp">
		<frame name="midFrame" scrolling="NO" noresize                  src="mid.jsp" >
		<frame name="bottomFrame" noresize scrolling="auto"       	src="information/information_list.jsp">
		<!-- showInformation.do -->
	</frameset>
	<frame name="statusbar" scrolling="no" noresize frameborder="0"  src="status_bar.jsp">
</frameset>
</HTML>
