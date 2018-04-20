
//3 ajax 请求

var ajax_url='';
$.ajax({
    url : ajax_url,
    dataType : "json",
    data : {},
    async : false,
    cache : false,
    type : "post",
    success : function(data) {
        eval("(" + obj + "={" + obj + ":data})");
        _DataArray.push(eval("(" + obj + ")"));
        
        
    }
});


	// 为了避免用户误操作，在域名结尾输入多余字符导致cookie失效问题，这里校验一下浏览器的host是否与后台拿到的host一致//
	//判断 浏览器 地址栏地址 是否是制定地址 不是跳转到指定地址
if (window.location.host != 'fkgg07.faisco.cn') {
	window.location.href = 'http://' + 'fkgg07.faisco====.cn'; 
} 
	//设置浏览器 地址栏的地址


//回车查询
document.onkeydown = function(evt){
	var evt = window.event?window.event:evt;
	if(evt.keyCode==13){
		//调用 的  查询 函数
		dosubmit();
	}
}

//1,需要 引用  jquery  和    easyui
$(function(){ //表单提交的 时候 可以 做处理 
	$("#uname").focus();
	$(inputForm).form({
	    onSubmit:function(){//如果 提交   md5 加密密码
    		var pass = $("#upass").val();
    		$("#md5Pass").val(pass.md5());
	    	return true;
	    },
	    success:function(data){//表单 提交 返回的 结果  
	    	var result = jQuery.parseJSON(data); //解析 json 数据
			console.info('-----'+result); 
			$("#cardNo").text(result.cardNo);
			$("#version").text(result.version);
			$('.accountBankName').text("常用卡   : "+result.accountBankName);
			/* window.location.href='${pageContext.request.contextPath}/jsp/register_step2.jsp' */
			//根据 logo 的 值来修该  图片路径
			var logo=result.accountBankName;
			if(logo==null||''==logo){   //根据 返回数据 设置  路径 
				$('#logo').attr('src','${pageContext.request.contextPath}/image/admin/gou.png'); 
			}
	    }
	});
});

//2,调用表单插件的'submit'方法提交
$('#ff').form('submit', {
    url:'',
    onSubmit: function(){
        //进行表单验证
        //如果返回false阻止提交
    },
    success:function(data){
        alert(data)
    }
});

var getjson_url="./AdminController/queryServerAll.do?time="+new Date().getTime();
$.getJSON( getjson_url	, function(data){
	
	$("#serverIds").empty();    //更新页面 的  为空
	$("#add_serverIds").empty(); //添加页面的 为空
    
	$.each(data, function(i,item){ //循环 取出list 集合 的 数据
    	  $("#serverIds").append("<td><input type='checkbox' name='servers' id='"+item.id+"' value="+item.id+" /></td><td>"+item.text+"</td>");
    	 
    	  $("#add_serverIds").append("<input type='checkbox' name='add_servers' id='add_"+item.id+"' value="+item.id+" />"+item.text+"");
    	  
    	  if(i%5==1){
    		  $("#serverIds").append("<br/>");
	    	  $("#add_serverIds").append("<br/>");
    	  }
    });
});
