<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ognl.jsp' starting page</title>
    
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <!--
  <link rel="stylesheet" type="text/css" href="styles.css">
  -->

  </head>
  
  <body>
  <%@taglib prefix="s" uri="/struts-tags" %>
  <s:debug></s:debug>
  <s:property value="userName"/>
    <table border="1" cellpadding="1" cellspacing="1" align="center" width="80%"> 
    <caption>
    <strong>访问Struts 2的命名对象：parameters、request、session、application和attr</strong>
    </caption>
    <tr>
    <th>OGNL表达式</th>
    <th>Java代码</th>
    <th>执行结果</th>
    </tr>
    <tr>
    <td>#parameters.greeting</td>
    <td>ActionContext.getContext().getParameters().get("greeting")</td>
    <td><s:property value="#parameters.greeting"/></td>
    </tr>
    <tr>
    <td>#request.empName</td>
    <td>((Map)ActionContext.getContext().get("request")).get("empName")</td>
    <td><s:property value="#request.empName" /></td>
    </tr>
    <tr>
    <td>#session.empName</td>
    <td>ActionContext.getContext().getSession().get("empName")</td>
    <td><s:property value="#session.empName" /></td>
    </tr>
    <tr>
    <td>#application.empName</td>
    <td>ActionContext.getContext().getApplication().get("empName")</td>
    <td><s:property value="#application.empName" /></td>
    </tr>
    <tr>
    <td>#attr.empName</td>
    <td>((Map)ActionContext.getContext().get("attr")).get("empName")</td>
    <td><s:property value="#attr.empName" /></td>
    </tr>   
  </table>
  <p>
    
  <table border="1">
    <caption><strong>访问列表</strong></caption>
    <tr>
      <th>OGNL表达式</th>
    <th>Java代码</th>
    <th>执行结果</th>
   </tr>
  <tr>
    <td>emps[0].name</td>
    <td>
    ((OgnlAction)ActionContext.getContext().getValueStack().peek()).getEmps().get(0).getName()
    </td>
    <td><s:property value="emps[0].name"/></td>
  </tr>
  <tr>
    <td>emps[1].address</td>
    <td>
    ((OgnlAction)ActionContext.getContext().getValueStack().peek()).getEmps().get(1).getAddress()
    </td>
    <td><s:property value="emps[1].address"/></td>
  </tr>
  <tr>
    <td>emps[2].address.street</td>
    <td>
    ((OgnlAction)ActionContext.getContext().getValueStack().peek()).getEmps().get(2).getAddress().getCity()
    </td>
    <td><s:property value="emps[2].address.street"/></td>
  </tr>
  <tr>
    <td>emps.size</td>
    <td>
    ((OgnlAction)ActionContext.getContext().getValueStack().peek()).getEmps().size()
    </td>
    <td><s:property value="emps.size"/></td>
  </tr>
  <tr>
    <td>emps.isEmpty</td>
    <td>
    ((OgnlAction)ActionContext.getContext().getValueStack().peek()).getEmps().isEmpty()
    </td>
    <td><s:property value="emps.isEmpty"/></td>
  </tr>
  </table>
  <br/><br/><br/><br/><br/>
  <s:if test="#list != null">
    这个非空==================================
  </s:if>
  
  <s:if test="emps != null">
    这个非空==================================
  </s:if>
  
  
  <br/><br/><br/><br/><br/>
  <p>
  <table border="1">
    <caption><strong>访问数组</strong></caption>
    <tr>
    <th>OGNL表达式</th>
    <th>Java代码</th>
    <th>执行结果</th>
    </tr>
    <tr>
    <td>emps[0].emails[0]</td>
    <td>
    ((OgnlAction)ActionContext.getContext().getValueStack().peek()).getEmps().get(0).getEmails()[0]
    </td>
    <td><s:property value="emps[0].emails[0]"/></td>
    </tr>
    <tr>
    <td>emps[1].emails[1]</td>
    <td>
    ((OgnlAction)ActionContext.getContext().getValueStack().peek()).getEmps().get(1).getEmails()[1]
    </td>
    <td><s:property value="emps[1].emails[1]"/></td>
    </tr>
  </table>
  
  <p>
    <table border="1">
    <caption><strong>访问Map</strong></caption>
    <tr>
    <th>OGNL表达式</th>
    <th>Java代码</th>
    <th>执行结果</th>
    </tr>
    <tr>
    <td>emps[0].accounts['建行']</td>
    <td>
    ((OgnlAction)ActionContext.getContext().getValueStack().peek()).getEmps().get(0).getAccounts().get("建行")
    </td>
    <td><s:property value="emps[0].accounts['建行']"/></td>
    </tr>
    <tr>
    <td>emps[1].accounts.农行</td>
    <td>
    ((OgnlAction)ActionContext.getContext().getValueStack().peek()).getEmps().get(1).getAccounts().get("农行")
    </td>
    <td><s:property value="emps[1].accounts.农行"/></td>
    </tr>
    <tr>
    <td>emps[2].accounts.size</td>
    <td>
    ((OgnlAction)ActionContext.getContext().getValueStack().peek()).getEmps().get(1).getAccounts().size()
    </td>
    <td><s:property value="emps[2].accounts.size"/></td>
    </tr>
    <tr>
    <td>emps[2].accounts.isEmpty</td>
    <td>
    ((OgnlAction)ActionContext.getContext().getValueStack().peek()).getEmps().get(1).getAccounts().isEmpty()
    </td>
    <td><s:property value="emps[2].accounts.isEmpty"/></td>
    </tr>
  </table>
  
  <p/>
  <h3>选择和投影</h3>
  <p>选择示例: emps.{?#this.salary &gt; 2000}</p>
  <ul>
    <!-- iterator标签迭代集合中的元素，并将当前迭代的对象压入栈中 -->
    <s:iterator value="emps.{?#this.salary > 2000}">
      <!-- 由于当前迭代的对象已放入栈中，所以property标签访问就是迭代对象的属性 -->
    <li><s:property value="name"/>的薪水是<s:property value="salary"/></li>
    </s:iterator>
  </ul>
  <p>投影示例: emps.{name}</p>
  <ul>
    <s:iterator value="emps.{name}">
    <li><s:property/></li>
      </s:iterator>
  </ul>
  
  <h3>Lambda表达式</h3>
  <p>Lambda表达式示例：#isManager = :[#this.name == '张三' ? '是管理者' : '是雇员']</p>
  <s:push value="#isManager = :[#this.name == '张三' ? '是管理者' : '是雇员']"/>
  <ul>    
  <s:iterator value="emps">
    <li><s:property value="name"/><s:property value="#isManager(top)"/></li>
  </s:iterator>
  </ul>
  </body>
</html> 