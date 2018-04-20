<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/jquery/taglib.jsp"></jsp:include>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<form action="/lijian" id="form1" method="post">
		<table width="100%" style="table-layout:fixed;">
			<tr>
				<td>Name:</td>
				<td><input name ='name' id='name' type="text"  ></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input name ='email' id='email' type='text'></td>
			</tr>
		</table>
			<input type="button" value='提交' style="width: 200"  onclick="dosubmit()"> 
	</form>
</body>
<script type="text/javascript" src="/jquery/validate_test/jquery.validate.min.js"></script>
<script type="text/javascript" src="/jquery/validate_test/lijian_valid.js"></script>
<script type="text/javascript">
$(function (){
});

var form1valid=$('#form1').validate({ //这个表单验证
	onfocusout:false, //失去焦点时验证
	onsubmit:true,  //表单提交时验证
	rules:{ //验证 规则
		name : { //设置 name的 验证规则 
			required:true,
			isEmail:true,  //自定义的 规则验证
		}
	}
	/* 设置错误信息 */
	/* 
	,
	messages : {
		name : {
			required : '<span class="info_ico"></span>请输入您的用户名<span class="ei_right">&nbsp;</span>',
			stringCheck : '<span class="info_ico"></span>2-20位，支持数字、字母、汉字、符号<span class="ei_right">&nbsp;</span>',								
			byteRangeLength : '<span class="info_ico"></span>2-20位，支持数字、字母、汉字、符号<span class="ei_right">&nbsp;</span>',
			remote : '<span class="info_ico"></span>该账号已经存在<span class="ei_right">&nbsp;</span>'
		},
		pwd : {
			required : '<span class="info_ico"></span>请输入您的密码<span class="ei_right">&nbsp;</span>',
			minlength : '<span class="info_ico"></span>6-20位，支持数字、字母、符号<span class="ei_right">&nbsp;</span>',
			maxlength : '<span class="info_ico"></span>6-20位，支持数字、字母、符号<span class="ei_right">&nbsp;</span>'
		},
		conPwd : {
			required : '<span class="info_ico"></span>请再次输入您的密码<span class="ei_right">&nbsp;</span>',
			minlength : '<span class="info_ico"></span>6-20位，支持数字、字母、符号<span class="ei_right">&nbsp;</span>',
			equalTo : '<span class="info_ico"></span>您输入的密码不一致<span class="ei_right">&nbsp;</span>'
		},
		email : {
			required : '<span class="info_ico"></span>请输入您的Email<span class="ei_right">&nbsp;</span>',
			remote : '<span class="info_ico"></span>该Email邮箱已经存在<span class="ei_right">&nbsp;</span>'
		},
		mobilePhone : {
			required : '<span class="info_ico"></span>请输入您的手机号码<span class="ei_right">&nbsp;</span>',
			minlength : '<span class="info_ico"></span>请输入正确的手机号码<span class="ei_right">&nbsp;</span>',
			maxlength : '<span class="info_ico"></span>请输入正确的手机号码<span class="ei_right">&nbsp;</span>',
			remote : '<span class="info_ico"></span>该手机号码已经存在<span class="ei_right">&nbsp;</span>'
		},
		resetCode:{
			required:'<span class="info_ico"></span>请输入验证码<span class="ei_right">&nbsp;</span>',
			number: '<span class="info_ico"></span>验证码只能是数字<span class="ei_right">&nbsp;</span>',
			 minlength: '<span class="info_ico"></span>验证码长度不正确<span class="ei_right">&nbsp;</span>',
			 maxlength: '<span class="info_ico"></span>验证码长度不正确<span class="ei_right">&nbsp;</span>',
			 remote: '<span class="info_ico"></span>验证码输入错误<span class="ei_right">&nbsp;</span>'
		 }, 
		liveTell : {
			required : '<span class="info_ico"></span>请输入您的固定电话号码<span class="ei_right">&nbsp;</span>',
			isTel : '<span class="info_ico"></span>请输入一个有效的电话号码<span class="ei_right">&nbsp;</span>',
			remote : '<span class="info_ico"></span>该固定电话号码已经存在<span class="ei_right">&nbsp;</span>'
		},
		address : {
			required : '<span class="info_ico"></span>请输入您的联系地址<span class="ei_right">&nbsp;</span>',
			addrCheck : '<span class="info_ico"></span>请正确输入您的联系地址<span class="ei_right">&nbsp;</span>',
			byteRangeLength : '<span class="info_ico"></span>请详实您的联系地址以便于我们联系您<span class="ei_right">&nbsp;</span>'
		},
		validateCode : {
			required : '<span class="info_ico"></span>请输入验证码<span class="ei_right">&nbsp;</span>',
			remote : '<span class="info_ico"></span>验证码不正确<span class="ei_right">&nbsp;</span>'
		},
		isAgree : {
			required : '<span class="info_ico"></span>请选择协议<span class="ei_right">&nbsp;</span>'
		},
		tjrphonenum:{
			required : '<span class="info_ico"></span>请正确填写手机号码<span class="ei_right">&nbsp;</span>',
		}
	} */
});

function dosubmit(){
	console.info(form1valid.valid()); //检查 是否验证通过
	form1valid.resetForm(); //重置表单 
	//$()  是选中 这个 东西
	//方法 是 () 里边的 
	//属性 是 {} 里边的
	$('#form1').submit();
	
}

</script>
</html>