	


var mobiles = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 

jQuery.validator.addMethod("stringCheck", function(value, element) {
	return this.optional(element)
			|| (/^[A-Za-z_0-9\u4e00-\u9fa5-`=\\\[\];',.\/~!@#$%^&*()_+|{}:"<>?]{2,20}$/
					.test(value) && !/^[0-9]{11}$/.test(value))
}, '<span class="info_ico"></span>2-20位，支持数字、字母、汉字、符号<span class="ei_right">&nbsp;</span>');

// 字符验证1      
jQuery.validator.addMethod("addrCheck", function(value, element) {
	return this.optional(element) || /^[A-Za-z0-9_]{2,100}$/.test(value);
}, '<span class="info_ico"></span>2-100位，支持数字、字母、汉字、符号<span class="ei_right">&nbsp;</span>');

// 中文字两个字节       
jQuery.validator
		.addMethod("byteRangeLength", function(value, element, param) {
			var length = value.length;
			for (var i = 0; i < value.length; i++) {
				if (value.charCodeAt(i) > 127) {
					length++;
				}
			}
			return this.optional(element) || (length >= param[0] && length <= param[1]);
		},'<span class="info_ico"></span>请确保输入的值在6-20个字节之间(一个中文字算2个字节)<span class="ei_right">&nbsp;</span>');

//密码验证
jQuery.validator.addMethod("isPassWord", function(value, element) {
	value = $.trim(value);
	return this.optional(element)
			|| /^[A-Za-z0-9_\u4e00-\u9fa5-`=\\\[\];',.\/~!@#$%^&*()_+|{}:"<>?]{6,20}$/
					.test(value);
}, '<span class="info_ico"></span>6-20位，支持数字、字母、符号<span class="ei_right">&nbsp;</span>');

//Email验证
jQuery.validator.addMethod("isEmail", function(value, element) {
	return this.optional(element)||  /^[A-Z0-9a-z_\\\[\];',.\/~!@#$%^\&*()_+|{}:"<>?][_.0-9A-Za-z-\\\[\];',.\/~\!@#$%^\&*()_+|{}\:"<>?]{0,31}@([0-9A-Za-z\\\[\];',.\/~\!@#$%^\&*()_+|{}:\"\<\>\?][0-9A-Za-z-\\\[\];',.\/~\!@#$%^\&*()_+|{}:\"<>?]{0,30}\.){1,4}[a-zA-Z]{2,4}$/
					.test(value);

}, '<span style="color:#F00">请您正确的输入Email</span><span class="ei_right">&nbsp;</span>');

// 身份证号码验证       
jQuery.validator.addMethod("isIdCardNo", function(value, element) {
	return this.optional(element) || isIdCardNo(value);
}, '<span class="info_ico"></span>请您正确的输入身份证号码<span class="ei_right">&nbsp;</span>');

// 手机号码验证       
jQuery.validator.addMethod("isMobilePhone", function(value, element) {
	var length = value.length;
	return this.optional(element) || (length == 11 && mobiles.test(value));
	//	     return this.optional(element) || /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/.test(value); 
}, '<span class="info_ico"></span>请正确填写您的手机号码<span class="ei_right">&nbsp;</span>');

// 推荐人手机号码验证       
jQuery.validator.addMethod("tjrphonenum", function(value, element) {
	var length = value.length;
	return value==='';
}, '<span class="info_ico"></span>请正确填写手机号码<span class="ei_right">&nbsp;</span>');


// 联系电话(手机/电话皆可)验证   
jQuery.validator.addMethod("isPhone", function(value,element) {   
    var length = value.length;   
    var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;   
    var tel = /^\d{3,4}-?\d{7,9}$/;   
    return this.optional(element) || (tel.test(value) || mobile.test(value));   
}, "请正确填写您的手机号码"); 



//CHS: {		return /^[\u0391-\uFFE5]+$/.test(value)  	message: '请输入汉字'
//english     return /^[A-Za-z]+$/i.test(value);          message : '请输入英文'
//ip        return /\d+\.\d+\.\d+\.\d+/.test(value);    message : 'IP地址格式不正确'
//ZIP 		return /^[0-9]\d{5}$/.test(value);    	message: '邮政编码不存在'
//QQ  		return /^[1-9]\d{4,10}$/.test(value);  	message: 'QQ号码不正确'
//mobile		return /^(?:13\d|15\d|18\d)-?\d{5}(\d{3}|\*{3})$/.test(value);  	message: '手机号码不正确'
//tel		return /^(\d{3}-|\d{4}-)?(\d{8}|\d{7})?(-\d{1,6})?$/.test(value);	message:'电话号码不正确'
//mobileAndTel 		return /(^([0\+]\d{2,3})\d{3,4}\-\d{3,8}$)|(^([0\+]\d{2,3})\d{3,4}\d{3,8}$)|(^([0\+]\d{2,3}){0,1}13\d{9}$)|(^\d{3,4}\d{3,8}$)|(^\d{3,4}\-\d{3,8}$)/.test(value);
//			message: '请正确输入电话号码'
//number		return /^[0-9]+.?[0-9]*$/.test(value); 	message: '请输入数字'
//money  	 	return (/^(([1-9]\d*)|\d)(\.\d{1,2})?$/).test(value); 	 message:'请输入正确的金额'
//integer		return /^[+]?[1-9]\d*$/.test(value);	message: '请输入正整数'
//integ 		return /^[+]?[0-9]\d*$/.test(value);	message: '请输入正整数'
//loginName 		return /^[\u0391-\uFFE5\w]+$/.test(value);	message: '只允许汉字、英文字母'
//englishOrNum         return /^[a-zA-Z0-9_]{1,}$/.test(value);    message : '请输入英文、数字、下划线'
