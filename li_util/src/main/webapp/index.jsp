<%@page contentType="text/html" pageEncoding="UTF-8"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<script type="text/javascript" src="js/li_check.js"></script>
<script type="text/javascript" src="jquery/jquery-1.8.0.js"></script>
<script type="text/javascript">
var str='';

window.onload=function (){
}
function number(){
	str=$('#num_id').val();
	alert(li.number(str));
}
function url(){
	str=$('#url_id').val();
	alert(li.checkUrl(str));
}
function phone_id(){
	str=$('#phone_id').val();
	alert(li.checkMobilePhone(str));
}


</script>
<body>
	<h2>Hello World!</h2>
	<%@page isELIgnored="false" %> <!-- 设置 el生效 -->
	<p>${param.email}</p><!-- 取出 出   param 当中的参数 -->
	<p>${lijian}</p>     <!-- 取出  attribult -->
	<input id="num_id" value="123"> <a onclick="number();" href="#">验证数字</a> <br>
	<input id="url_id" value="ss"> <a onclick="url();" href="#">验证url</a> <br>
	<input id="phone_id" value="ss"> <a onclick="phone_id();" href="#">验证手机号</a> <br>
	
</body>
</html>
