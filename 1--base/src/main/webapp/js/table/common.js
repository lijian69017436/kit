/*！

 * patent V1.0

 * copyright 2016

 * designed and built by lhy

 * 2016 06 24

 */
var params = {};
var teamid;
var except_Inventer ="";
var column_Number= [{
    field: 'number',
    title: '序号',
    halign:"center",
    align:"center",
    formatter: function (value, row, index) {
        //pageNumber*pageSize +


        return index+1;
    }
}]
var column_Check = [{
	checkbox:true
}]

var columns_agency = [
                      {
                          field: 'agencycode',
                          title: '机构代码',
                          halign:"center",
                          align:"center"
                      },{
                          field: 'agencybrand',
                          title: '机构字号',
                          halign:"center",
                          align:"center"
                      }, {
                          field: 'agencyname',
                          title: '机构名称',
                          halign:"center",
                          align:"center"
                      },{
                          field: 'agencytype',
                          title: '机构类别',
                          halign:"center",
                          align:"center"
                      }, {
                          field: 'principal',
                          title: '负责人',
                          halign:"center",
                          align:"center"
                      },{
                          field: 'territory',
                          title: '地域',
                          halign:"center",
                          align:"center"
                      }
                  ]
var column_Det = [{
    title: '操作',
    halign:"center",
    align:"center",
    formatter: function (value, row, index) {
        return [
            "<a onClick='detailagency(\""+row.agencyid+ "\")'   href='javascript:;' ><span>查看详细</span></a>",
        ].join('   ');
    }
}]
Array.prototype.indexOf = function(val) {
	for (var i = 0; i < this.length; i++) {
	if (this[i] == val) return i;
	}
	return -1;
	};
Array.prototype.remove = function(val) {
	var index = this.indexOf(val);
	if (index > -1) {
	this.splice(index, 1);
	}
};
//form表单中的数据转化为对象


$.fn.serializeObject = function(){
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name] !== undefined) {
			if (!o[this.name].push) {
				o[this.name] = [o[this.name]];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};
//页面高度自适应


function autoHeight(){
    var height = document.documentElement.clientHeight;
    $(".main-container").css("height",760);
}
var selectedInventorIds = "";
//加载发明人列表


function loadMainfestList(){
	$('#locations').manifest({
        formatDisplay: function (data, $item, $mpItem) {
          return data.name;
        },
        formatValue: function (data, $value, $item, $mpItem) {
          return data.id;
        },
        marcoPolo: {
        	url:"../inventor/showInventor",
          data: {
            selectedInventorIds:selectedInventorIds
          },
          formatData: function (data) {
            //return data.response.venues;




              return data.venues;
          },
          formatItem: function (data, $item) {
            return data.name;
          },
          minChars: 1,
          param: 'query'
        },
        required: true
      });
}
//加载院系中的发明人


function loadInventorsInCollege(inventorsid,url,collegeid){
	$('#'+inventorsid).manifest({
        formatDisplay: function (data, $item, $mpItem) {
          return data.name;
        },
        formatValue: function (data, $value, $item, $mpItem) {
          return data.id;
        },
        marcoPolo: {
        	url:url,
          data: {
            selectedInventorIds:selectedInventorIds,
            collegeid:collegeid
          },
          formatData: function (data) {
            //return data.response.venues;


              return data.venues;
          },
          formatItem: function (data, $item) {
            return data.name;
          },
          minChars: 1,
          param: 'query'
        },
        required: true
      });
}
//加载发明人列表


function loadInventors(inventorsid,url){
	$('#'+inventorsid).manifest({
        formatDisplay: function (data, $item, $mpItem) {
          return data.name;
        },
        formatValue: function (data, $value, $item, $mpItem) {
          return data.id;
        },
        marcoPolo: {
        	url:url,
          data: {
            selectedInventorIds:selectedInventorIds
          },
          formatData: function (data) {
            //return data.response.venues;


              return data.venues;
          },
          formatItem: function (data, $item) {
            return data.name;
          },
          minChars: 1,
          param: 'query'
        },
        required: true
      });
}
//加载团队中的发明人


function loadInventorsInTeam(inventorsid,url,teamid){
	$('#'+inventorsid).manifest({
        formatDisplay: function (data, $item, $mpItem) {
          return data.name;
        },
        formatValue: function (data, $value, $item, $mpItem) {
          return data.id;
        },
        marcoPolo: {
        	url:url,
          data: {
            selectedInventorIds:selectedInventorIds,
            teamid:teamid
          },
          formatData: function (data) {
              return data.venues;
          },
          formatItem: function (data, $item) {
            return data.name;
          },
          minChars: 1,
          param: 'query'
        },
        required: true
      });
}

var CollegeId = "";
var TeamId = "";
function singleInventor(inventorid,url){
	$('#'+inventorid).marcoPolo({
		  url:url,
		  data: {
	            teamid:TeamId,
	            collegeid:CollegeId
	      },
	      formatData: function (data) {
	            return data.venues;
	      },
		  formatItem: function (data, $item) {
		    return data.name;
		  },
          minChars: 1,
		  onSelect: function (data, $item) {
			  this.val(data.name);
			  $("#ProposalRegister_inventorid").val(data.id);
		  },
          param: 'query',
          required: true
	});
}


function ajaxSubmitFile(formId,url,check,func,domId){
	$("#"+formId).ajaxSubmit({
		url:url,
		beforeSubmit:check,
        //定义返回JSON数据，还包括xml和script格式


        dataType:'json',
        success: function(data) {
            //提交成功后调用


            func(data,domId);
        }
    });
	//return false;


}
/****************************************显示获取的学院信息**********************************************************************/
function showcollege(data,id){
	var collegeOption = "<option value=''>请选择所属"+permissionName[1]+"</option>";
	$.each(data,function(index,content){
		collegeOption += "<option value='"+content["collegeid"]+"'>"+content["collegename"]+"</option>"
	})
	$("#"+id).html(collegeOption);
}
function ajaxTable(t_type,t_async,t_url,t_data,t_func,t_dom,col,i_url){
    $.ajax({
        type:t_type, cache: false, dataType: 'json',
        async:t_async,
        url:t_url,
        data:t_data,
        success:function(data){
            if(data["resultInfo"]=="-1"){
                window.location.href="doRedirect.do";
            }else{
                t_func(t_dom,i_url,col);
            }

        }
    });
}
//获取饼图


//ajaxPic("get",false,"../data/test.json","",piePic,"饼图","pie");


//获取爽柱状图


//ajaxPic("get",false,"data/testBar.json","",doubleBar,"受理量与提交量对比","bar");


//ajax请求图表


function ajaxPic(t_type,t_async,t_url,t_data,t_func,t_title,t_dom){
    $.ajax({
        type:t_type, cache: false, dataType: 'json',
        async:t_async,
        url:t_url,
        data:t_data,
        success:function(data){
            t_func(t_title,data,t_dom);
        }
    });
}
function ajaxFunc(t_type,t_async,t_url,t_data,t_func,t_dom){
    $.ajax({
        type:t_type, cache: false, dataType: 'json',
        async:t_async,
        url:t_url,
        data:t_data,
        success:function(data){
            t_func(data,t_dom);
        }
    });
}
function ajaxIsRepeat(t_type,t_async,t_url,t_data,t_func,t_dom,tipContent){
    $.ajax({
        type:t_type, cache: false, dataType: 'json',
        async:t_async,
        url:t_url,
        data:t_data,
        success:function(data){
            t_func(data,t_dom,tipContent);
        }
    });
}
/*创建列表

 * title 表名称

 * colHeader 表头信息中的头部（自增或复选框）

 * colContent 表头信息内容

 * colTail 表头信息尾部（决定操作项有哪些：详细、删除）

 * tableId:表id

 * url:请求数据路径

 * params:表格提交的查询条件

 * checkid:复选框选中以后需要提交的字段名称

 */
function createTable(title,colHeader,colContent,colTail,tableId,url,queryParams,checkid){
	var col ;
	if(title.length != 0){
		col = [title,colHeader.concat(colContent).concat(colTail)];
	}else{
		if(colHeader.length != 0)
		col = [colHeader.concat(colContent).concat(colTail)];
		else
		col = colContent.concat(colTail);
	}
	params["ids"] = "";
	$("#"+tableId).bootstrapTable('destroy'); 
    $("#"+tableId).bootstrapTable({
        dataType: "json",
        method: 'get',
        contentType: "application/x-www-form-urlencoded",
        cache: false,
        url:url,
        queryParams: queryParams,
        columns:col,
        pagination:true,
        sidePagination:'server',
        pageNumber:1,
        pageSize:10,
        pageList:[10],
        onCheck: function (row) {
        	var id = checkid;
    		//遍历所有的row 获取name


    		//params["ids"] .add(row.agencyid);


        	params["ids"] += row[""+id+""] +",";
        },
        onUncheck: function (row) {
        	var id = checkid;
        	params["ids"] = params["ids"].replace(row[""+id+""]+",","");
    		//遍历所有的row 获取name


    		//params["ids"] .add(row.agencyid);


        },
        onCheckAll:function(rows){
        	var id = checkid;
        	for(var i=0;i<rows.length;i++){
            	params["ids"] += rows[i][""+id+""] +",";
        	}
        },
        onUncheckAll:function(rows){
            params["ids"] = "";
        }/*,
        onLoadSuccess:function(data){
        	var rows = data["rows"];
        	$.each(rows,function(index,content){
        		if(content["agencytype"] == "NORMAL"){
        			data["rows"][index]["agencytype"] = "正常";
        		}
        	})
        }*/
    })
}

/*创建排序列表

 * colHeader 表头信息中的头部（自增或复选框）

 * colContent 表头信息内容

 * colTail 表头信息尾部（决定操作项有哪些：详细、删除）

 * tableId:表id

 * url:请求数据路径

 * params:表格提交的查询条件

 * checkid:复选框选中以后需要提交的字段名称

 * sort:排序字段

 * sortOrder:排序方式

 */
function createSortTable(colHeader,colContent,colTail,tableId,url,queryParams,checkid,sort,sortOrder){
	var col = [colHeader.concat(colContent).concat(colTail)];
	params["ids"] = "";
	params["other"] = "";
	$("#"+tableId).bootstrapTable('destroy'); 
    $("#"+tableId).bootstrapTable({
        dataType: "json",
        method: 'get',
        contentType: "application/x-www-form-urlencoded",
        cache: false,
        url:url,
        sortName:sort,  //排序列名

        sortOrder: sortOrder,//排位命令（desc，asc）

        queryParams: queryParams,
        columns:col,
        pagination:true,
        sidePagination:'server',
        pageNumber:1,
        pageSize:10,
        pageList:[10],
        onCheck: function (row) {
        	var id = checkid;
        	if(row.proposalstatustype == "待处理"){
            	params["other"] += row[""+id+""] +",";
        	}else{
            	params["ids"] += row[""+id+""] +",";
        	}
    		//遍历所有的row 获取name


    		//params["ids"] .add(row.agencyid);


        },
        onUncheck: function (row) {
        	var id = checkid;
        	params["other"] = params["other"].replace(row[""+id+""]+",","");
        	params["ids"] = params["ids"].replace(row[""+id+""]+",","");
    		//遍历所有的row 获取name


    		//params["ids"] .add(row.agencyid);


        },
        onCheckAll:function(rows){
        	var id = checkid;
        	params["other"] = "";
        	for(var i=0;i<rows.length;i++){
            	if(rows[i].proposalstatustype == "待处理"){
                	params["other"] += rows[i][""+id+""] +",";
            	}else{
                	params["ids"] += rows[i][""+id+""] +",";
            	}
        	}
        },
        onUncheckAll:function(rows){
        	params["other"] = "";
            params["ids"] = "";
        }/*,
        onLoadSuccess:function(data){
        	var rows = data["rows"];
        	$.each(rows,function(index,content){
        		if(content["agencytype"] == "NORMAL"){
        			data["rows"][index]["agencytype"] = "正常";
        		}
        	})
        }*/
    })
}
/*创建单选列表

 * title 表名称

 * colHeader 表头信息中的头部（自增或复选框）

 * colContent 表头信息内容

 * colTail 表头信息尾部（决定操作项有哪些：详细、删除）

 * tableId:表id

 * url:请求数据路径

 * params:表格提交的查询条件

 * checkid:复选框选中以后需要提交的字段名称

 */
function createRadioTable(title,colHeader,colContent,colTail,tableId,url,queryParams,checkid){
	var col ;
	if(title == []){
		col = [title,colHeader.concat(colContent).concat(colTail)];
	}else{
		col = [colHeader.concat(colContent).concat(colTail)];
	}
	params["id"] = "";
	$("#"+tableId).bootstrapTable('destroy'); 
    $("#"+tableId).bootstrapTable({
        dataType: "json",
        method: 'get',
        contentType: "application/x-www-form-urlencoded",
        cache: false,
        url:url,
        queryParams: queryParams,
        columns:col,
        pagination:true,
        sidePagination:'server',
        pageNumber:1,
        pageSize:10,
        pageList:[10],
        singleSelect:true,
        onCheck: function (row) {
        	params["id"] = row["agencyid"];
        	$("#ProposalRegister_agencyid").val(row["agencyid"])
        	$("#ProposalRegister_agencyname").val(row["agencyname"])
        },
        onUncheck: function (row) {
        	params["id"] = "";
        	$("#ProposalRegister_agencyid").val("")
        	$("#ProposalRegister_agencyname").val("")
        },
    })
}
/*创建列表

 * title 表名称

 * colContent 表头信息内容

 * colTail 表头信息尾部（决定操作项有哪些：详细、删除）

 * tableId:表id

 * url:请求数据路径

 * params:表格提交的查询条件

 * checkid:复选框选中以后需要提交的字段名称

 */
function createTableNoPagination(title,colContent,colTail,tableId,url,queryParams,checkid){
	var col = colContent.concat(colTail)
	var col ;
	if(title.length != 0){
		col = [title,colContent.concat(colTail)];
	}else{
		col = [colContent.concat(colTail)];
	}
	$("#"+tableId).bootstrapTable('destroy'); 
    $("#"+tableId).bootstrapTable({
        dataType: "json",
        method: 'get',
        contentType: "application/x-www-form-urlencoded",
        cache: false,
        url:url,
        queryParams: queryParams,
        columns:col
    })
}
function getTeamParams(params) {
    var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的

        teamid:teamId
    };
    return temp;
}
//根据分页进行查询


function getPageParams(params) {
    var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的

        pageSize: params.limit,   //页面大小

        pageNumber: params.offset/params.limit+1,
        offset: params.offset, //页码

        sort: params.sort,  //排序列名

        sortOrder: params.order//排位命令（desc，asc）

    };
    return temp;
}
//根据省市进行查询


function getCityParams(params) {
    var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的

        pageSize: params.limit,   //页面大小

        pageNumber: params.offset/params.limit+1,
        offset: params.offset, //页码

        sort: params.sort,  //排序列名

        sortOrder: params.order,//排位命令（desc，asc）

        province:$("#pro").val(),
        city:$("#city").val(),
        agencyname:$("#add_agencyname").val(),
        agencycode:$("#add_agencycode").val()
    };
    return temp;
}
//根据日期进行查询


function getDateParams(params) {
    var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的

        pageSize: params.limit,   //页面大小

        pageNumber: params.offset/params.limit+1,
        offset: params.offset, //页码

        sort: params.sort,  //排序列名

        sortOrder: params.order,//排位命令（desc，asc）

        start:$("#from").val(),
        end:$("#to").val(),
        agencyname:$("#evaluate_agencyname").val(),
        agencycode:$("#evaluate_agencycode").val()
    };
    return temp;
}
var selectKey="";
var selectValue = "";
var tabType = "";
//根据查询选择框进行查询


function getPageParams(params) {
    var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的

        pageSize: params.limit,   //页面大小

        pageNumber: params.offset/params.limit+1,
        offset: params.offset, //页码

        sort: params.sort,  //排序列名

        sortOrder: params.order,//排位命令（desc，asc）

        key:selectKey,
        value:selectValue,
        listtype:tabType,
    };
    return temp;
}

function fromtoDate(){
    //加载日期


    $(".from-date").datetimepicker({
        language:  'zh-CN',
        format: "yyyy-mm-dd",
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
    	endDate:new Date(),
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    }).on('changeDate',function(e){  
        var startTime = e.date;  
        $(".to-date").datetimepicker("setStartDate", startTime);
    });
    $(".to-date").datetimepicker({
        language:  'zh-CN',
        format: "yyyy-mm-dd",
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
    	endDate:new Date(),
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    }).on('changeDate',function(e){  
        var toTime = e.date;  
        $(".from-date").datetimepicker("setEndDate",toTime);
    });
}

function startDate(){
	var Nowdate = new Date();
	var vYear = Nowdate.getFullYear();
	var startDate =vYear+"-"+ "01" +"-"+ "01";	
	return startDate;
}
function nowDate(){	
	var Nowdate = new Date();
	var vYear = Nowdate.getFullYear();
	var vMon = Nowdate.getMonth() + 1;
	var vDay = Nowdate.getDate();
	if(vDay<10){
		vDay="0"+vDay;
	}
	if(vMon<10){
		vMon="0"+vMon;
	}
	var today =vYear+"-"+ vMon +"-"+vDay;	
	return today;
}

function agencyDeatilTable(t_data,id){
	var data = t_data[0];
	var tableHtml = "<table class='detail-table'>";
	var num = 0;
	$.each(data,function(index,content){
		num++;
		if(num==11){
			tableHtml += "<tr><td colspan='2'>"+index +":"+content+"</td></tr></table>";
		}else{
			if(num%2 == 1){
				tableHtml += "<tr><td>"+index +":"+content+"</td>";
			}else{
				tableHtml += "<td>"+index +":"+content+"</td></tr>";
			}
		}
		
	})
	tableHtml += "</table>";
    $("#"+id).html(tableHtml);
}

function queryParams(params) {
    var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的

        pageSize: params.limit,   //页面大小

        pageNumber: params.offset/params.limit+1,
        offset: params.offset, //页码

        sort: params.sort,  //排序列名

        sortOrder: params.order//排位命令（desc，asc）

    };
    return temp;
}

//查看详细


function detailagency(id){
    $('#modal_detail').modal();
    $("#agency_detail").html("");
    var param = {};
    param["agencyid"] = id;
    ajaxFunc("get","false","../agency/showAgencyDetail",param,agencyDeatilTable,"agency_detail");
}
function initDateSearch(){
	//加载日期


    $(".from-date").datetimepicker({
        language:  'zh-CN',
        format: "yyyy-mm-dd",
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
    	endDate:new Date(),
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    }).on('changeDate',function(e){  
        var startTime = e.date;  
        $(".to-date").datetimepicker("setStartDate", startTime);
    });
    $("#from").val(startDate());
    $(".to-date").datetimepicker({
        language:  'zh-CN',
        format: "yyyy-mm-dd",
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
    	endDate:new Date(),
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    }).on('changeDate',function(e){  
        var toTime = e.date;  
        $(".from-date").datetimepicker("setEndDate",toTime);
    });
    $("#to").val(nowDate());
}
function initCitySearch(){
	//加载省、市


    $("#pro_city").citySelect({
        prov: "全部",
        nodata: "none"
    });
    $("#add_agencyname").val("");
    $("#add_agencycode").val("");
    
}
//juery页面的显示


/*

 var location = window.location.href;

    if(location.indexOf("?") != -1 ){

    	//获取url中的参数，进行查询

    	var param = GetSearchContent();

    	var agencyName = param["agencyName"]

    	alert(agencyName)

    	//$("#agencyName").val(agencyName);

    	//$("searchBtn").click();

    }

 */
//从url路径中获取参数


function GetSearchContent() { 
	var url = location.search; //获取url中"?"符后的字串 

	var theRequest = new Object(); 
	if (url.indexOf("?") != -1) { 
		var str = url.substr(1); 
		strs = str.split("&"); 
		for(var i = 0; i < strs.length; i ++) { 
			theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]); 
		} 
	} 
	return theRequest; 
}
//显示提示信息


function showTip(id,content){
	$("#"+id).next().addClass("in");
	$("#"+id).next().find(".tooltip-inner").html(content)
}
//隐藏提示信息


function hideTip(id){
	$("#"+id).next().removeClass("in");
}

/*

 * 遍历form中的元素，生成name:value格式的object对象。

 */
function getFormElement(formID){
	var elements=new Object();
	var tag=$("#"+formID+" input[type='text'],#"+formID+" input[type='password'],#"+formID+" select,#"+formID+" input[type='radio']:checked");
	for(var i=0;i<tag.length;i++){
		var name=tag[i].name;
		var value=tag[i].value;
		elements[name]=value; 
	}
	if($("#"+formID).find("input[type='checkbox']").is(":visible")==true){
		var checkboxTag = $("#"+formID+" input[type='checkbox']:checked");
		var name = checkboxTag[0].name;
		elements[name]="";
		for(var i=0;i<checkboxTag.length;i++){
			elements[name]+=checkboxTag[i].value+","; 
		}
		elements[name] = elements[name].substring(0,elements[name].length-1)
	}
	return elements;
}
