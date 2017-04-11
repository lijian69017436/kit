<%@ page contentType="text/html;charset=UTF-8" %>
<!-- 1 用法 --><%-- 
<link rel="stylesheet" type="text/css" href="${ctx}/css/**.css"> --%>

<%-- <%@ taglib prefix="s" uri="/struts-tags" %> --%>
<!-- 引入 jstl 标签 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- 设置 跟路径 -->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="htx" value="${pageContext.request.localName}"/>
<script type="text/javascript">var htx = 'http://${htx}/';</script>
<c:set var="sysTitle" value="北京黄金交易中心业务系统"/>

