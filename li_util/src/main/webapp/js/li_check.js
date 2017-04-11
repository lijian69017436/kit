//js 正则验证 
var li={}

/**
 * 检查输入的一串字符是否全部是数字
 * 输入:str  字符串
 * 返回:true 或 flase; true表示为数字
 */
li.number=function(numberStr){
	var numb=/^\+?[1-9][0-9]*$/;
    return numb.test(li.trim(numberStr)) ;
}
//去掉字符串头尾空格   
li.trim=function (str){
    return str.replace(/(^\s*)|(\s*$)/g, "");
}
/**
 * 检查输入的URL地址是否正确
 * 输入:str  字符串
 *  返回:true 或 flase; true表示格式正确
 */
li.checkUrl=function (str){
    if (str.match(/(http[s]?|ftp):\/\/[^\/\.]+?\..+\w$/i) == null) {
        return false
    }else {
        return true;
    }
}

/**
 * 检查输入的手机号码格式是否正确
 * 输入:str  字符串
 * 返回:true 或 flase; true表示格式正确
 */
li.checkMobilePhone=function (str){
	var r=/^0?1[3|4|5|8][0-9]\d{8}$/;
	return r.test(str);
}

/**
 * 是否为空  true 是空  false 不为空
 */
li.isNull=function (str){
	if(''==str|| null==str){
		return true;
	}
	return false
}

