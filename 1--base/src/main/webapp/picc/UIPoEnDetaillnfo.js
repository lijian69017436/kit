	/**
	 * @author @author lsj
	 * @fileOverview 联合销售
	 * @version 1.0
	 */

	/**
	 * @class
	 */
    function insuredValueP(obj){
        var IDCARD_SHIELD = document.getElementById("IDCARD_SHIELD");
		if(obj.email != null && obj.email != undefined && document.getElementById("_emailEAD") !=null){
			if(document.getElementById("_emailEAD") != null){
				document.getElementById("_emailEAD").value = obj.email;// 邮箱
				document.getElementById("_emailEAD").readOnly = true;
			}
		}
		if(obj.postCode != null && obj.postCode != undefined && document.getElementById("_postCodeEAD")!=null){
			if(document.getElementById("_postCodeEAD") != null){
				document.getElementById("_postCodeEAD").value = obj.postCode;// 邮编
				document.getElementById("_postCodeEAD").readOnly = true;
			}
		}
		if(obj.insuredCode != null && obj.insuredCode != undefined ){
			if(document.getElementById("_insuredCodeEAD")!=null){
				document.getElementById("_insuredCodeEAD").value = obj.insuredCode;// ID
				document.getElementById("_insuredCodeEAD").readOnly = true;
			}
		}
		if(obj.insuredName != null && obj.insuredName != undefined ){
			if(document.getElementById("_insuredNameEAD")!=null){
				document.getElementById("_insuredNameEAD").value = obj.insuredName;// 名称
			}
		}
		if(obj.identifytype != null && obj.identifytype != undefined ){
			if(document.getElementById("_identifyTypeEAD")!=null){
				document.getElementById("_identifyTypeEAD").value = obj.identifytype;// 证件类型
				document.getElementById("_identifyTypeEAD").readOnly = true;
			}
		}
		if(obj.identifyNumberEdit != null && obj.identifyNumberEdit != undefined ){
			if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1" && obj.identifytype != null && obj.identifytype != undefined && obj.identifytype.trim() == "01"){
	            document.getElementById("_identifyNumberEAD").value = obj.identifyNumberEdit.trim().substr(0, 10) + "******" + obj.identifyNumberEdit.trim().substr(16, 2);
	            if(obj.identifyNumberLSJ != null && obj.identifyNumberLSJ != undefined && obj.identifyNumberLSJ !=""){
	            	//隐藏域赋值
					document.getElementById("_identifyNumber1EAD").value = obj.identifyNumberLSJ;	
	            }
			}else{
				document.getElementById("_identifyNumberEAD").value = obj.identifyNumberEdit;// 证件号码
			}
			document.getElementById("_identifyNumberEAD").readOnly = true;
		}
		if(obj.mobile != null && obj.mobile != undefined ){
			var mobiles = obj.mobile;
			var mobileNoYG = obj.mobileNoYG;
			if(mobiles!=""){
				if(document.getElementById("_mobilesEAD")!=null){
					document.getElementById("_mobilesEAD").value = mobileNoYG.substr(0, 3) + "****" + mobileNoYG.substr(7, 4);// 移动电话
					document.getElementById("_mobilesEAD").readOnly = true;
				}
			}else{
				if(document.getElementById("_mobilesEAD")!=null){
					document.getElementById("_mobilesEAD").value = mobileNoYG;
					document.getElementById("_mobilesEAD").readOnly = true;
				}
			}
			if(document.getElementById("_mobileEAD")!=null){
				document.getElementById("_mobileEAD").value = mobiles;
			}
		}
		if(obj.insuredAddress != null && obj.insuredAddress != undefined ){
			if(document.getElementById("_insuredAddressEAD")!=null){
				document.getElementById("_insuredAddressEAD").value = obj.insuredAddress;// 地址
				document.getElementById("_insuredAddressEAD").readOnly = true;	
			}
        }
	}
    function insuredValueG(obj){
		if(obj.insuredCode != null && obj.insuredCode != undefined ){
			if(document.getElementById("_insuredCodeEAD")!=null){
				document.getElementById("_insuredCodeEAD").value = obj.insuredCode.trim();// ID
	       		document.getElementById("_insuredCodeEAD").readOnly = true;
			}
		}
		if(obj.insuredName != null && obj.insuredName != undefined ){
			if(document.getElementById("_insuredNameEAD")!=null){
				document.getElementById("_insuredNameEAD").value = obj.insuredName;// 名称
	       		document.getElementById("_insuredNameEAD").readOnly = true;
			}
		}
		if(obj.unifiedSocialCreditCode != null && obj.unifiedSocialCreditCode != undefined ){
			if(document.getElementById("_unifiedSocialCreditCodeEAD")!=null){
				document.getElementById("_unifiedSocialCreditCodeEAD").value = obj.unifiedSocialCreditCode; //统一社会信用代码		
	       		document.getElementById("_unifiedSocialCreditCodeEAD").readOnly = true;
			}
		}
		if(obj.identifyNumberEdit != null && obj.identifyNumberEdit != undefined ){
			if(document.getElementById("_identifyNumberEAD")!=null){
				document.getElementById("_identifyNumberEAD").value = obj.identifyNumberEdit.trim();// 组织机构代码
			}
		}
		if(obj.unitType != null && obj.unitType != undefined ){
			if(document.getElementById("_unitTypeEAD")!=null){
				document.getElementById("_unitTypeEAD").value = obj.unitType;// 单位性质
			}
		}
		//LiChenhui;组织机构代码控制只读;20100930;begin;
		if(document.getElementById("_identifyNumberEAD")!=null){
		     document.getElementById("_identifyNumberEAD").readOnly = true;
		}
		if(obj.mobile != null && obj.mobile != undefined ){
			var mobiles = obj.mobile;
			var mobileNoYG = obj.mobileNoYG;
			if(mobiles!=""){
				if(document.getElementById("_mobilesEAD")!=null){
					document.getElementById("_mobilesEAD").value = mobileNoYG.substr(0, 3) + "****" + mobileNoYG.substr(7, 4);// 移动电话
					document.getElementById("_mobilesEAD").readOnly = true;
				}
			}else{
				if(document.getElementById("_mobilesEAD")!=null){
					document.getElementById("_mobilesEAD").value = mobileNoYG;
					document.getElementById("_mobilesEAD").readOnly = true;
				}
			}
			if(document.getElementById("_mobileEAD")!=null){
				document.getElementById("_mobileEAD").value = mobiles;
			}
		}
		if(obj.insuredAddress != null && obj.insuredAddress != undefined ){
			if(document.getElementById("_insuredAddressEAD")!=null){
				document.getElementById("_insuredAddressEAD").value = obj.insuredAddress;// 地址
			}
		} else {
			if(document.getElementById("_insuredAddressEAD")!=null){
				document.getElementById("_insuredAddressEAD").value = "";
			}
		}
		if(document.getElementById("_insuredAddressEAD")!=null){
			document.getElementById("_insuredAddressEAD").readOnly = true;
		}
    }

	function showInsuredDetailInfo(tr){
		// 获取当前行记录信息
	    var riskCode = document.getElementById("riskCode").value;
	    var eleName = "";
		if(riskCode == "DAA" || riskCode == "DAX"){
			eleName = tr.cells[6].all[1].name;
		}
		var IDCARD_SHIELD = document.getElementById("IDCARD_SHIELD");
		var index=eleName.substring(eleName.indexOf("[")+1,eleName.indexOf("]"));
		var _insuredType = document.getElementById("prpUinsureds["+index+"].insuredType").value;
		var _insuredName = document.getElementById("prpUinsureds["+index+"].insuredName").value;
		var _insuredFlagValue = document.getElementById("prpUinsureds["+index+"].insuredFlag").value;
		var _insuredCode = document.getElementById("prpUinsureds["+ index +"].insuredCode").value;
		var _unitType = document.getElementById("prpUinsureds["+index+"].unitType").value;
		var _unifiedSocialCreditCode = document.getElementById("prpUinsureds["+index+"].unifiedSocialCreditCode").value;
		var _identifyType = document.getElementById("prpUinsureds["+index+"].identifyType").value;
		var _identifyNumber =document.getElementById("prpUinsureds["+index+"].identifyNumber").value;
		var _insuredAddress = document.getElementById("prpUinsureds["+index+"].insuredAddress").value;

		//是否普惠融资带动客户显示和存储
		var _isFinanceCustomer = document.getElementById("prpUinsureds["+index+"].isFinanceCustomer").value;
		var financeFlag = "";
		if(document.getElementById("financeFlagEAD["+index+"]")!=null){
	        financeFlag = document.getElementById("financeFlagEAD["+index+"]").value;
		}
		//隐藏域加密手机号
		var _mobile = "";
		var _mobileNoYG = ""
		if(document.getElementById("prpUinsureds["+index+"].mobile")!=null){
			_mobile = document.getElementById("prpUinsureds["+index+"].mobile").value;
		}
		//显示域未加密手机号带星
		if(document.getElementById("prpUinsureds["+index+"].mobiles")!=null){
			_mobileNoYG =document.getElementById("prpUinsureds["+index+"].mobiles").value;
		}
		//modify by cj 20100730 版本号和审批状态的显示和存储 end
		//为各个元素输入域赋值
		var _insuredFlag = document.getElementsByName("_insuredFlagEAD");
		for ( var i = 0; i < _insuredFlag.length; i++) {
			if(_insuredFlag[i]!=null){
				_insuredFlag[i].checked = false;
			}
		}
		for ( var i = 0; i < _insuredFlag.length; i++) {
			if(_insuredFlag[i]!=null){
				if (_insuredFlagValue.charAt(i)=="1") {
					_insuredFlag[i].checked = true;
				}else{
					_insuredFlag[i].checked = false;
				}
			}
		}
		document.getElementById("_insuredFlagValueEAD").value = _insuredFlagValue;
		document.getElementById("_insuredNameEAD").value = _insuredName;
		document.getElementById("_insuredTypeEAD").value = _insuredType;
		document.getElementById("_insuredCodeEAD").value = _insuredCode;
		// 根据类型隐藏域
		changeInsuredNature();
		if(trim(_unitType)!=""){
			document.getElementById("_unitTypeEAD").value = trim(_unitType);
		}else{
			document.getElementById("_unitTypeEAD").value = '';
		}
		if(trim(_unifiedSocialCreditCode)!=""){
			document.getElementById("_unifiedSocialCreditCodeEAD").value = trim(_unifiedSocialCreditCode);
		}else{
			document.getElementById("_unifiedSocialCreditCodeEAD").value = '';
		}
		document.getElementById("_identifyTypeEAD").value = _identifyType;

		//modify by cj 20100729 去掉多余的空格 begin
		document.getElementById("_identifyNumberEAD").value = trim(_identifyNumber);
		if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1" && _identifyType == "01"){
			var identifyNumbers = document.getElementById("prpUinsureds["+index+"].identifyNumbers");
			if(document.getElementById("_identifyNumber1EAD") != null){
				//隐藏域加密身份证号
				document.getElementById("_identifyNumber1EAD").value = _identifyNumber;
				if(identifyNumbers!=null && identifyNumbers.value != ""){
					//显示域未加密身份证号带星
					document.getElementById("_identifyNumberEAD").value = identifyNumbers.value;
				}
			}
		}
		document.getElementById("_insuredAddressEAD").value = _insuredAddress;
		if(document.getElementById("_isFinanceCustomerEAD")!=null){
			var isFinanceCustomer = document.getElementById("_isFinanceCustomerEAD");
	        while(document.all("_isFinanceCustomerEAD").options.length>0){
	        	document.all("_isFinanceCustomerEAD").options.remove(0);
	        }
	        if(financeFlag  == "0") {
	        	isFinanceCustomer.options.add(new Option("否","3"));
	        	isFinanceCustomer.options.add(new Option("普惠融资间接带动","2"));
	        }else{
	        	isFinanceCustomer.options.add(new Option("否","3"));
	        	isFinanceCustomer.options.add(new Option("普惠融资间接带动","2"));
	        	isFinanceCustomer.options.add(new Option("普惠融资直接带动","1"));
	        }
			var optionsLength = document.all("_isFinanceCustomerEAD").options.length;
			for(var i=0;i<optionsLength;i++){
				if(isFinanceCustomer.options[i].value == trim(_isFinanceCustomer)){
					isFinanceCustomer.options[i].selected = true;
					break;
				}
			}
		}
		document.getElementById("_mobilesEAD").value = _mobileNoYG;
		document.getElementById("_mobileEAD").value = _mobile;
		document.getElementById("updateIndexEAD").value = index;
		//将关键信息设为只读;LICHENHUI;20101021;
    	setInsuredReadOnly();
	}
	function changeInsuredNature(){
		var insuredType = document.getElementById('_insuredTypeEAD');
		//add by zhaoxiaojie 20100804 设置默认项 begin
		if(insuredType.value =="2"){
		    // 如果类型为单位，单位性质默认为企业类型
		    document.getElementById('_unitTypeEAD').value = "300";
		    //modify by LiChenhui;类型为单位，证件类型的值设置为空;20100810;begin;
		    document.getElementById('_identifyTypeEAD').value = "31";
		    document.getElementById('_identifyTypeEAD').disabled =true;
		    //modify by LiChenhui;类型为单位，证件类型的值设置为空;20100810;end;
	    }else{
	    	 // 如果类型为个人，证件类型为身份证
	        document.getElementById('_identifyTypeEAD').value = "01";
	        document.getElementById('_identifyTypeEAD').disabled =false;
	    }
		//add by zhaoxiaojie 20100804 设置默认项end
		var des_identifyType = document.getElementById('des_identifyTypeEAD');
		var inp_identifyType = document.getElementById('inp_identifyTypeEAD');
		var des_identifyNum = document.getElementById('_identifyNumberEAD');
		var des_unitType = document.getElementById("des_unitTypeEAD");
	    var inp_unitType = document.getElementById("inp_unitTypeEAD");
	    var decorationId1=document.getElementById("decorationId1EAD");
	    var decorationValue1=document.getElementById("decorationValue1");
	    var des_unifiedSocialCreditCode=document.getElementById("des_unifiedSocialCreditCodeEAD");
		var inp_unifiedSocialCreditCode=document.getElementById("inp_unifiedSocialCreditCodeEAD");
		if(insuredType.value!="1"){
			//modify by zhaoxiaojie 20100804 关系人类型团体时显示单位性质 begin
			//R624
			des_unitType.style.display = "";
			// R26
			inp_unitType.style.display = "";
			decorationId1.style.display = "none";
			decorationValue1.style.display = "none";
			des_unifiedSocialCreditCode.style.display="";
			inp_unifiedSocialCreditCode.style.display="";
			//add by zhangqingtao 补全表格 begein
		}else{
			// R623
			
			//modify by zhaoxiaojie 20100804 关系人类型个人时隐藏单位性质 begin
			des_unitType.style.display = "none";
			//R26
			inp_unitType.style.display = "none";
			decorationId1.style.display = "";
			decorationValue1.style.display = "";
			des_unifiedSocialCreditCode.style.display="none";
			inp_unifiedSocialCreditCode.style.display="none";
			//modify by zhaoxiaojie 20100804 关系人类型个人时隐藏单位性质 end
		}
	}
	function setInsuredReadOnly(){
		var insuredCode = document.getElementById("_insuredCodeEAD");
		if(insuredCode.value.trim() != ""){
			insuredCode.readOnly = true;
			var insuredName = document.getElementById("_insuredNameEAD");
			insuredName.readOnly = true;
			var identifyNumber = document.getElementById("_identifyNumberEAD");
			identifyNumber.readOnly = true;
			var identifyType = document.getElementById("_identifyTypeEAD");
			identifyType.disabled = true;
			var mobile = document.getElementById("_mobilesEAD");
			if(mobile!=null){
				mobile.readOnly = true;
			}
			var mobiles = document.getElementById("_mobilesEAD");
			if(mobiles!=null){
				mobiles.readOnly = true;
			}
			var insuredAddress = document.getElementById("_insuredAddressEAD");
			if(insuredAddress!=null){
				insuredAddress.readOnly = true;
			}
			var unifiedSocialCreditCode = document.getElementById("_unifiedSocialCreditCodeEAD");
			if(unifiedSocialCreditCode!=null){
				unifiedSocialCreditCode.readOnly = true;
			}
		} else {
			var _mobiles = document.getElementById("_mobilesEAD");
			if(_mobiles != null && _mobile1.readOnly == true){
				var insuredName = document.getElementById("_insuredNameEAD");
				insuredName.readOnly = false;
				var insuredCode = document.getElementById("_insuredCodeEAD");
				insuredCode.readOnly = false;
				var identifyNumber = document.getElementById("_identifyNumberEAD");
				identifyNumber.readOnly = false;
				var identifyType = document.getElementById("_identifyTypeEAD");
				identifyType.disabled = false;
				var mobile = document.getElementById("_mobilesEAD");
				if(mobile!=null){
					mobile.readOnly = false;
				}
				var insuredAddress = document.getElementById("_insuredAddressEAD");
				if(insuredAddress!=null){
					insuredAddress.readOnly = false;
				}
				var unifiedSocialCreditCode = document.getElementById("_unifiedSocialCreditCodeEAD");
				unifiedSocialCreditCode.readOnly = true;
			}
		}
	}
	function insured_Add(pageCode, field, idx) {
		var plancode = trim(document.getElementById("prpUmain.planCode").value);
	    var index = 0;
		// 如果当前全局行序集合无此列表信息并且当前列表有信息
		index = document.getElementById(idx).value;
		if (isNaN(parseInt(globalindex[pageCode])) && parseInt(index) != 0) {
			globalindex[pageCode] = parseInt(index);
		}
	    if(plancode!="EAD0000002" && plancode!="EAD3500002" && plancode!="EAD3200001" && plancode!="EAD3200002" && 
			   plancode!="EAD3200003" && plancode!="EAD3200004" && plancode!="EAD3200005"&&(checkInsureAll(pageCode, field, idx)==false)){
	     	return false;
	    }else{
	       var insuredName = document.getElementById("_insuredNameEAD");
	       if(isEmptyField(insuredName)==true){
	          errorMessage(insuredName.description+"不能为空");
	          return false;
	       }
	    }
	    if(!checkinsuredType()){
	    	alert("关系人类型为团体时，单位性质不允许为空！");
	    	return false;
	    }
		var IDCARD_SHIELD = document.getElementById("IDCARD_SHIELD");
		var _insuredFlag = document.getElementsByName("_insuredFlagEAD");
		var _insuredFlag_hide = document.getElementsByName("_insuredFlag_hideEAD");
		var _insuredFlagValue = "";
		var _insuredFlagText = "";
		for ( var i = 0; i < _insuredFlag.length; i++) {
			if (_insuredFlag[i].checked == true) {
				_insuredFlagValue += "1";
				if (_insuredFlagText != "") {
					_insuredFlagText = _insuredFlagText + "/";
				}
				_insuredFlagText += _insuredFlag_hide[i].value;	
			} else {
				_insuredFlagValue += "0";
			}
		}
		var number = 0;
		for(var i = 0 ; i<_insuredFlag.length-1;i++)
		{
			if(_insuredFlag[i].checked)
			{
				number = number + 1;
			}
		}
		if(plancode!="EAD0000002" && plancode!="EAD3500002" && plancode!="EAD3200001" && plancode!="EAD3200002" && 
	    plancode!="EAD3200003" && plancode!="EAD3200004" && plancode!="EAD3200005" && !(_insuredFlag[2].checked && (number==1)) )
		{
			if(document.getElementById("_insuredCodeEAD").value=="" 
				|| document.getElementById("_insuredCodeEAD").readOnly != true)
			{
				errorMessage("关系人必从客户系统带入，请点查询按钮进行查询！");
				return false;
			}
		}
		_insuredFlagValue = dealInsuredFlagResident(_insuredFlagValue, "0");
		var _insuredType = document.getElementById("_insuredTypeEAD").value;
		var _insuredName = document.getElementById("_insuredNameEAD").value;
		document.getElementById("_insuredNameEAD").value = "";
		var _insuredCode = document.getElementById("_insuredCodeEAD").value;
		document.getElementById("_insuredCodeEAD").value = "";
		var _unitType=document.getElementById("_unitTypeEAD").value;
		var _identifyType = document.getElementById("_identifyTypeEAD").value;
		var _identifyNumber = document.getElementById("_identifyNumberEAD").value;
		document.getElementById("_identifyNumberEAD").value = "";
		var _identifyNumber1 = document.getElementById("_identifyNumber1EAD").value;
		document.getElementById("_identifyNumber1EAD").value = "";
		var _insuredAddress = document.getElementById("_insuredAddressEAD").value;
		document.getElementById("_insuredAddressEAD").value = "";
		//是否普惠融资带动客户
		var _isFinanceCustomer = "";
		if(document.getElementById("_isFinanceCustomerEAD")!=null){
			_isFinanceCustomer = document.getElementById("_isFinanceCustomerEAD").value;
		}
		var _financeFlag = "";
		if(document.getElementById("financeFlagEAD")!=null){
	        _financeFlag = document.getElementById("financeFlagEAD").value;
		}
		if(document.getElementById("_isFinanceCustomerEAD")!=null){
	        while(document.all("_isFinanceCustomerEAD").options.length>0){
	        	document.all("_isFinanceCustomerEAD").options.remove(0);
	        }
	        document.getElementById("_isFinanceCustomerEAD").options.add(new Option("否","3"));
	        document.getElementById("_isFinanceCustomerEAD").options.add(new Option("普惠融资间接带动","2"));
	        document.getElementById("_isFinanceCustomerEAD").options.add(new Option("普惠融资直接带动","1"));
		}
		var _mobile = document.getElementById("_mobileEAD").value;
		document.getElementById("_mobileEAD").value = "";
		
		var _mobiles = document.getElementById("_mobilesEAD").value;
		document.getElementById("_mobilesEAD").value = "";
		
		document.getElementById("_insuredCodeEAD").value = "";
		document.getElementById("_insuredCodeEAD").readOnly = false;
		document.getElementById("_mobileEAD").readOnly = false;

		var select_insuredType = document.getElementById("_insuredTypeEAD");
		var select_unitType=document.getElementById("_unitTypeEAD");
		var select_identifyType = document.getElementById("_identifyTypeEAD");
		var _unifiedSocialCreditCode = document.getElementById("_unifiedSocialCreditCodeEAD").value;
		document.getElementById("_unifiedSocialCreditCodeEAD").value="";
		var iinsuredType = "";
		if(select_insuredType.value!=""){
			iinsuredType = select_insuredType.options[select_insuredType.selectedIndex].text;
		}
		var iunitType="";
		if(select_unitType.value!=""){
		    iunitType = select_unitType.options[select_unitType.selectedIndex].text;
		}
		var iidentifyType = "";
		if(select_identifyType.value!=""){
		    iidentifyType = select_identifyType.options[select_identifyType.selectedIndex].text;
		}
		// 将数据更新至显示列表
		if(document.getElementById("updateIndexEAD").value < 0){// 保存
			// 列表区显示数据
			document.getElementById("uinsuredFlag").value = _insuredFlagText;
			document.getElementById("uinsuredType").value = iinsuredType;
			document.getElementById("uinsuredName").value = _insuredName;
			document.getElementById("uinsuredCode").value = _insuredCode;
			if(_insuredType =="1"){
				document.getElementById("uunitType").value = "";
			}else{
				document.getElementById("uunitType").value =iunitType;
			}
			document.getElementById("uidentifyType").value = iidentifyType;
			document.getElementById("uidentifyNumber").value = _identifyNumber;
			document.getElementById("uinsuredAddress").value = _insuredAddress;
			document.getElementById("umobile").value = _mobiles;
			// 列表区隐含域数据
			document.getElementById("prpUinsureds_[0].insuredFlag").value = _insuredFlagValue;
			document.getElementById("prpUinsureds_[0].insuredType").value = _insuredType;
			document.getElementById("prpUinsureds_[0].insuredCode").value = _insuredCode;
			document.getElementById("prpUinsureds_[0].insuredName").value = _insuredName;
			if(_insuredType =="1"){
				document.getElementById("prpUinsureds_[0].unitType").value = "";
			}else{
				document.getElementById("prpUinsureds_[0].unitType").value =_unitType;
			}
			document.getElementById("prpUinsureds_[0].identifyType").value = _identifyType;
			if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1" && _identifyType == "01"){
				document.getElementById("prpUinsureds_[0].identifyNumber").value = _identifyNumber1;
				document.getElementById("prpUinsureds_[0].identifyNumbers").value = _identifyNumber;
			}else{
				document.getElementById("prpUinsureds_[0].identifyNumber").value = _identifyNumber;
			}
			document.getElementById("prpUinsureds_[0].insuredAddress").value = _insuredAddress;
			//是否普惠融资带动客户的显示和存储
			if(document.getElementById("prpUinsureds_[0].isFinanceCustomer")!=null){
				document.getElementById("prpUinsureds_[0].isFinanceCustomer").value = _isFinanceCustomer;
			}
			if(document.getElementById("financeFlag_[0]")!=null){
				document.getElementById("financeFlag_[0]").value = _financeFlag;
			}
			document.getElementById("prpUinsureds_[0].mobile").value = _mobile;
			//新加隐藏域带星手机号
			document.getElementById("prpUinsureds_[0].mobiles").value = _mobiles;
			document.getElementById("prpUinsureds_[0].unifiedSocialCreditCode").value = _unifiedSocialCreditCode;
			var _email = document.getElementById("_emailEAD");
			var _postCode = document.getElementById("_postCodeEAD");
			if(_email != null){
				document.getElementById("prpUinsureds_[0].email").value = _email.value;
				_email.value = "";
			}
			if(_postCode != null){
				document.getElementById("prpUinsureds_[0].postCode").value = _postCode.value;
				_postCode.value = "";
			}
			insertRowForStruts2(pageCode, field, index);
		}else{//修改保存
			var updateIndex = document.getElementById("updateIndexEAD").value;
			var insuredFlag = document.getElementById("prpUinsureds["+ updateIndex +"].insuredFlag");
			var insuredType = document.getElementById("prpUinsureds["+ updateIndex +"].insuredType");
			var insuredCode = document.getElementById("prpUinsureds["+ updateIndex +"].insuredCode");
			var insuredName = document.getElementById("prpUinsureds["+ updateIndex +"].insuredName");
			var unitType = document.getElementById("prpUinsureds["+ updateIndex +"].unitType");
			var identifyType = document.getElementById("prpUinsureds["+ updateIndex +"].identifyType");
			var identifyNumber = document.getElementById("prpUinsureds["+ updateIndex +"].identifyNumber");
			var identifyNumbers = document.getElementById("prpUinsureds["+ updateIndex +"].identifyNumbers");
			var insuredAddress = document.getElementById("prpUinsureds["+ updateIndex +"].insuredAddress");
			var isFinanceCustomer = document.getElementById("prpUinsureds["+ updateIndex +"].isFinanceCustomer");
			var financeFlag = document.getElementById("financeFlag["+ updateIndex +"]");
			var mobile = document.getElementById("prpUinsureds["+ updateIndex +"].mobile");
			//var postCode = document.getElementById("prpUinsureds["+ updateIndex +"].postCode");
			var unifiedSocialCreditCode = document.getElementById("prpUinsureds["+ updateIndex +"].unifiedSocialCreditCode");
			var insuredFlagStr=document.getElementById("_insuredFlagValueEAD").value;
			_insuredFlagValue+=insuredFlagStr.substring(7);
			insuredFlag.value = _insuredFlagValue;
			insuredType.value = _insuredType;
			insuredCode.value = _insuredCode;
			insuredName.value = _insuredName;
			if(_insuredType == "1"){
				unitType.value = "";
			}else{
				unitType.value = _unitType;
			}
			identifyType.value = _identifyType;
			identifyNumber.value = _identifyNumber;
			if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1" && _identifyType == "01"){
				//隐藏域赋值
				identifyNumber.value = _identifyNumber1;
				//显示域赋值
				if(identifyNumbers!=null){
					identifyNumbers.value = _identifyNumber;
				}
			}
			insuredAddress.value = _insuredAddress;
			//是否普惠融资带动客户的显示和存储 start
			if(isFinanceCustomer!=null){
				isFinanceCustomer.value = _isFinanceCustomer;
			}
			if(financeFlag!=null){
				financeFlag.value = _financeFlag;
			}
            //是否普惠融资带动客户的显示和存储 end
			unifiedSocialCreditCode.value=_unifiedSocialCreditCode;
			mobile.value = _mobile;
			//postCode.value = _postCode;
			var tr = insuredFlag.parentElement.parentElement;
			//列表的显示字段（没有下标）
			tr.cells[0].all[1].value = _insuredFlagText;
			tr.cells[1].all[0].value = _insuredType;
			tr.cells[2].all[0].value = _insuredCode;
			tr.cells[2].all[1].value = _insuredName;
			if(_insuredType == "1"){
				tr.cells[3].all[0].value = "";
			}else{
				tr.cells[3].all[0].value = iunitType;
			}
			tr.cells[4].all[0].value = iidentifyType;
			tr.cells[5].all[0].value = _identifyNumber;
			tr.cells[7].all[0].value = _mobiles;
			tr.cells[8].all[0].value = _insuredAddress;
			
		}
	    document.getElementById("updateIndexEAD").value = "-1";
	    document.getElementById("_insuredNameEAD").readOnly = false;
	    document.getElementById("_unifiedSocialCreditCodeEAD").readOnly = false;
	    document.getElementById("_identifyNumberEAD").readOnly = false;
	    document.getElementById("_mobilesEAD").readOnly = false;
	    document.getElementById("_insuredAddressEAD").readOnly = false;
	}
	/*
	 * 校验如果类型为团体，单位性质不能为空
	 */
	function checkinsuredType(){
		var unitType = document.getElementById('_unitTypeEAD').value;
		var insuredType = document.getElementById('_insuredTypeEAD').value;
		if(insuredType =="2" && (unitType == "" || unitType == null)){
			return false;
		}
		return true;
	}
	function dealInsuredFlagResident(_insuredFlagValue, _resident){
		var insuredFlagLength = _insuredFlagValue.length;
	    for(var i=0; i < 30 - insuredFlagLength; i++){
	    	_insuredFlagValue += "0";
	    }
	    if(_insuredFlagValue.substring(0,1) == "1" && _resident!="" && _resident.length>0){
	    	_insuredFlagValue = _insuredFlagValue.substring(0,29) + _resident;
	    }
	    return _insuredFlagValue;
	}
	function changeInsuredType(){
		//根据关系人类型，来清空关系人的属性值
		clearInsured();
		//改变类型时,改变关系人页面元素
		changeInsuredNature();
    }
	function clearInsured(){
		var insuredType = document.getElementById("_insuredTypeEAD").value;
			if(insuredType == "1"){
				document.getElementById("_unitTypeEAD").value = "";
				document.getElementById("_identifyNumberEAD").value = "";// 证件号码
				if(document.getElementById("_identifyNumber1EAD")!=null){
					document.getElementById("_identifyNumber1EAD").value = "";
				}
				document.getElementById("_mobileEAD").value = "";// 移动电话-隐藏域
				document.getElementById("_mobilesEAD").value = "";// 移动电话
				document.getElementById("_insuredAddressEAD").value = "";// 地址
				document.getElementById("_insuredAddressEAD").readOnly = false;
				document.getElementById("_insuredNameEAD").value = "";
				document.getElementById("_insuredNameEAD").readOnly = false;
				document.getElementById("_insuredCodeEAD").value = "";// ID
				document.getElementById("_insuredCodeEAD").readOnly = false;
				document.getElementById("_identifyNumberEAD").readOnly = false;
				document.getElementById("_unifiedSocialCreditCodeEAD").value = "";//统一社会信用代码
				
			}else if(insuredType == "2"){
				document.getElementById("_identifyNumberEAD").value = "";// 证件号码
				document.getElementById("_mobileEAD").value = "";// 移动电话-隐藏域
				document.getElementById("_mobilesEAD").value = "";// 移动电话
				document.getElementById("_insuredAddressEAD").value = "";// 地址
				document.getElementById("_insuredAddressEAD").readOnly = false;
				document.getElementById("_insuredNameEAD").value = "";
				document.getElementById("_insuredNameEAD").readOnly = false;
				document.getElementById("_insuredCodeEAD").value = "";// ID
				document.getElementById("_insuredCodeEAD").readOnly = false;
				document.getElementById("_identifyNumberEAD").readOnly = false;
			}
	}
	function changeInsuredNature(){
		var insuredType = document.getElementById('_insuredTypeEAD');
		if(insuredType.value =="2"){
			document.getElementById('_unitTypeEAD').value = "300";
			document.getElementById('_identifyTypeEAD').value = "31";
			document.getElementById('_identifyTypeEAD').disabled =true;
		}else{
			document.getElementById('_identifyTypeEAD').value = "01";
			document.getElementById('_identifyTypeEAD').disabled =false;
		}
		var des_identifyType = document.getElementById('des_identifyTypeEAD');
		var inp_identifyType = document.getElementById('inp_identifyTypeEAD');
		var des_identifyNum = document.getElementById('_identifyNumberEAD');
		var des_unitType = document.getElementById("des_unitTypeEAD");
	    var inp_unitType = document.getElementById("inp_unitTypeEAD");
	    var decorationId1=document.getElementById("decorationId1EAD");
	    var decorationValue1=document.getElementById("decorationValue1EAD");
	    var des_unifiedSocialCreditCode=document.getElementById("des_unifiedSocialCreditCodeEAD");
		var inp_unifiedSocialCreditCode=document.getElementById("inp_unifiedSocialCreditCodeEAD");
		if(insuredType.value!="1"){
			des_unitType.style.display = "";
			inp_unitType.style.display = "";
			decorationId1.style.display = "none";
			decorationValue1.style.display = "none";
			des_unifiedSocialCreditCode.style.display="";
			inp_unifiedSocialCreditCode.style.display="";
		}else{
			des_unitType.style.display = "none";
			inp_unitType.style.display = "none";
			decorationId1.style.display = "";
			decorationValue1.style.display = "";
			des_unifiedSocialCreditCode.style.display="none";
			inp_unifiedSocialCreditCode.style.display="none";
		}
	}
	function queryCustomerUnitedSale(){
		var insuredType = document.getElementById("_insuredTypeEAD").value;
		if(insuredType == "1"){
			queryCustomerPUnitedSale();
		}else if(insuredType == "2"){
			queryCustomerGUnitedSale();
		}
	}
	function queryCustomerPUnitedSale(){
		var _insuredType = document.getElementById("_insuredTypeEAD").value;
		var _insuredName = document.getElementById("_insuredNameEAD").value;
		var _identifyNumber = document.getElementById("_identifyNumberEAD").value;
		var _insuredCode = document.getElementById("_insuredCodeEAD").value;
		var _identifyType = document.getElementById("_identifyTypeEAD").value;
		var customerURL = document.getElementById("customerURLEAD");
		if((_insuredName==null||_insuredName == "")&&(_identifyNumber==null||_identifyNumber == "")&&(_insuredCode==null||_insuredCode == "")){
		       errorMessage("请输入查询条件（名称、证件号码或代码至少输入一项）！");
		       document.getElementById("_insuredNameEAD").focus();
		       document.getElementById("_insuredNameEAD").select();
			   return false;
		}

		var callback = {
				success:function (res) {
			     var prod = YAHOO.lang.JSON.parse(res.responseText);
			     var flag;
		         if(parseInt(prod.data[0].count)==1) 
		      	 {
		        	 insuredValueUnitedSale(prod);
		      	 }
		      	 else if(parseInt(prod.data[0].count)>1)
		      	 {
		      		searchCustomer(prod.data[0].URL);
		      	 }
		  		 else
		  		 {
		  			createCustomer(prod.data[0].URL);//modified by LanNing 20100823 易用性-查不到关系人自动进入新增页面
		  		 }
			  	if(_insuredType == "1" && document.getElementById("_identifyTypeEAD").value =="01"){
			  		var identifyNumber = document.getElementById("_identifyNumberEAD");
			  	}
		  		// 将审批状态、代码和版本号设置为只读
		  		if(flag == false){
		  			document.getElementById("_insuredCodeEAD").readOnly = false;
		  			document.getElementById("_mobileEAD").readOnly = false;
		  		}
		  		if(flag == undefined){
		  			//document.getElementById("_insuredCode").readOnly = true;
		  			document.getElementById("_mobileEAD").readOnly = true;
		  		}
			  
			},
			failure:function (res) {
			   errorMessage("服务异常！");
			   return false;
			}
		};
		var strURL = "/prpall/custom/customAmountQueryP.do?_identifyType="+_identifyType+"&_insuredName="+_insuredName+"&_identifyNumber="+_identifyNumber+"&_insuredCode="+_insuredCode;
	    var transaction = YAHOO.util.Connect.asyncRequest('POST',strURL, callback); 
	}
	function queryCustomerGUnitedSale(){
		var _insuredType = document.getElementById("_insuredTypeEAD").value;
		var _insuredName = document.getElementById("_insuredNameEAD").value;
		var _identifyNumber = document.getElementById("_identifyNumberEAD").value;
		var _insuredCode = document.getElementById("_insuredCodeEAD").value;
		var _identifyType = document.getElementById("_identifyTypeEAD").value;
		var _unifiedSocialCreditCode=document.getElementById("_unifiedSocialCreditCodeEAD").value;
		if((_insuredName==null||_insuredName == "")&&(_identifyNumber==null||_identifyNumber == "")&&(_unifiedSocialCreditCode==null||_unifiedSocialCreditCode=="")&&(_insuredCode==null||_insuredCode=="")){
		       errorMessage("请输入查询条件（名称、组织机构代码、统一社会信用代码或客户代码至少输入一项）！");
			   return false;
		}
		var callback = 
		{success:function (res) 
		{
			 var prod = YAHOO.lang.JSON.parse(res.responseText);
	      		    var prod = YAHOO.lang.JSON.parse(res.responseText);
			     var flag;
		         if(parseInt(prod.data[0].count)==1) 
		      	 {
		        	 insuredValueUnitedSale(prod);
		      	 }
		      	 else if(parseInt(prod.data[0].count)>1)
		      	 {
		      		searchCustomer(prod.data[0].URL);
		      	 }
		  		 else
		  		 {
		  			createCustomer(prod.data[0].URL);//modified by LanNing 20100823 易用性-查不到关系人自动进入新增页面
		  		 }
			  	if(_insuredType == "2" && document.getElementById("_identifyTypeEAD").value =="31"){
			  		var identifyNumber = document.getElementById("_identifyNumberEAD");
			  	}
		  		// 将审批状态、代码和版本号设置为只读
		  		if(flag == false){
		  			document.getElementById("_insuredCodeEAD").readOnly = false;
		  			document.getElementById("_mobileEAD").readOnly = false;
		  		}
		  		if(flag == undefined){
		  			document.getElementById("_mobileEAD").readOnly = true;
		  		}
		},
		failure:function (res) 
		{
		   errorMessage("服务异常！");
		   return false;
		}
		};
		var strURL = "/prpall/custom/customAmountQueryG.do?_identifyType="+_identifyType+"&_insuredName="+_insuredName+"&_identifyNumber="+_identifyNumber+"&_insuredCode="+_insuredCode+"&unifiedSocialCreditCode="+_unifiedSocialCreditCode;
	    var transaction = YAHOO.util.Connect.asyncRequest('POST',strURL, callback); 
		
	}
	function insuredValueUnitedSale(filed){
		var _insuredType = document.getElementById("_insuredTypeEAD").value;
		if(_insuredType == "1"){
	        document.getElementById("_insuredCodeEAD").value=filed.data[0].insuredCode;
	         document.getElementById("_insuredCodeEAD").readOnly = true;
	        document.getElementById("_insuredNameEAD").value=filed.data[0].insuredName;// 名称
	        var _email = document.getElementById("_emailEAD");
			var _postCode = document.getElementById("_postCodeEAD");
			if(_email != null){
				_email.value = filed.data[0].email;
			}
			if(_postCode != null){
				_postCode.value = filed.data[0].postCode;
			}
	        if(filed.data[0].insuredName  != null){
	        	document.getElementById("_insuredNameEAD").value=filed.data[0].insuredName;//名称
	        	document.getElementById("_insuredNameEAD").readOnly = true;
	        }
	        if(filed.data[0].identifyType  != null){
	        	document.getElementById("_identifyTypeEAD").value = filed.data[0].identifyType;// 证件类型
	        }
	        
	        if(filed.data[0].identifyNumber  != null){
		        var IDCARD_SHIELD = document.getElementById("IDCARD_SHIELD");
		        if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1" && filed.data[0].identifyType =="01"){
			        document.getElementById("_identifyNumber1EAD").value = filed.data[0].identifyNumber;// 隐藏域加密证件号码
			        document.getElementById("_identifyNumberEAD").readOnly = true;
			        if(filed.data[0].identifyNumberLSJ != null && filed.data[0].identifyNumberLSJ != ""){
		        		document.getElementById("_identifyNumberEAD").value = filed.data[0].identifyNumberLSJ.substr(0, 10) + "******" + filed.data[0].identifyNumberLSJ.substr(16, 2);
			        }
		        }else{
		        	document.getElementById("_identifyNumberEAD").value = filed.data[0].identifyNumber;// 证件号码
		        	document.getElementById("_identifyNumberEAD").readOnly = true;
		        }
	        }
	        if(filed.data[0].insuredAddress  != null){
	        	document.getElementById("_insuredAddressEAD").value = filed.data[0].insuredAddress;// 地址
	        	document.getElementById("_insuredAddressEAD").readOnly = true;
	        }
	        var phoneType = filed.data[0].phoneType;
	       	if(filed.data[0].mobile != null){
	       		 var mobiles = filed.data[0].mobile;
	       		 var mobileNoYG =filed.data[0].mobileNoYG;
	       		 if(mobileNoYG!=""){
	       			 document.getElementById("_mobilesEAD").value = mobileNoYG.substr(0, 3) + "****" + mobileNoYG.substr(7, 4);// 移动电话
	       			 document.getElementById("_mobilesEAD").readOnly = true;
	       		 }else{
	   				document.getElementById("_mobilesEAD").value = mobileNoYG;
	   				document.getElementById("_mobilesEAD").readOnly = true;
	       		 }
	       		document.getElementById("_mobileEAD").value = mobiles;
	   		}
	   		if(filed.data[0].repeatTimes != null){
	   			document.getElementById("_repeatTimesEAD").value = filed.data[0].repeatTimes;
	   		}
	 	}else{
	 		document.getElementById("_insuredCodeEAD").value=filed.data[0].insuredCode;
	 		document.getElementById("_insuredCodeEAD").readOnly = true;
	        document.getElementById("_insuredNameEAD").value=filed.data[0].insuredName;// 名称
	        if(filed.data[0].insuredName  != null){
	        	document.getElementById("_insuredNameEAD").value=filed.data[0].insuredName;//名称
	        	document.getElementById("_insuredNameEAD").readOnly = true;
	        }
	        if(filed.data[0].identifyNumber  != null){
	 			document.getElementById("_identifyNumberEAD").value = filed.data[0].identifyNumber;// 证件号码
	 			document.getElementById("_identifyNumberEAD").readOnly = true;
	        }
	         if(filed.data[0].unifiedSocialCreditCode  != null){
	 			document.getElementById("_unifiedSocialCreditCodeEAD").value = filed.data[0].unifiedSocialCreditCode;// 统一社会信用代码
	 			document.getElementById("_unifiedSocialCreditCodeEAD").readOnly = true;
	        }
	         if(filed.data[0].unitType  != null){
	 			document.getElementById("_unitTypeEAD").value = filed.data[0].unitType;// 单位性质
	 			document.getElementById("_unitTypeEAD").readOnly = true;
	        }
	        if(filed.data[0].insuredAddress  != null){
	 			document.getElementById("_insuredAddressEAD").value = filed.data[0].insuredAddress;// 地址
	 			document.getElementById("_insuredAddressEAD").readOnly = true;
	        }
	        var phoneType = filed.data[0].phoneType;
	       	if(filed.data[0].mobile != null){
	       		 var mobiles = filed.data[0].mobile;
	       		 var mobileNoYG =filed.data[0].mobileNoYG;
	       		 if(mobileNoYG!=""){
	       			 document.getElementById("_mobilesEAD").value = mobileNoYG.substr(0, 3) + "****" + mobileNoYG.substr(7, 4);// 移动电话
	       			 document.getElementById("_mobilesEAD").readOnly = true;
	       		 }else{
	   				document.getElementById("_mobilesEAD").value = mobileNoYG;
	   				document.getElementById("_mobilesEAD").readOnly = true;
	       		 }
	       		 document.getElementById("_mobileEAD").value = mobiles;
	   		}
	 	}
		var isFinanceCustomer = document.getElementById("_isFinanceCustomerEAD");
		if(isFinanceCustomer != null && isFinanceCustomer != undefined){
	        while(document.all("_isFinanceCustomerEAD").options.length>0){
	        	document.all("_isFinanceCustomerEAD").options.remove(0);
	        }
	        if(filed.data[0].financeFlag  == "0") {
	        	isFinanceCustomer.options.add(new Option("否","3"));
	        	isFinanceCustomer.options.add(new Option("普惠融资间接带动","2"));
				document.getElementById("financeFlagEAD").value = "0";
	        }else{
	        	isFinanceCustomer.options.add(new Option("否","3"));
	        	isFinanceCustomer.options.add(new Option("普惠融资间接带动","2"));
	        	isFinanceCustomer.options.add(new Option("普惠融资直接带动","1"));
				document.getElementById("financeFlagEAD").value = "1";
	        }
		}
		checkCstReturnInfo(filed.data[0].mobile);
	}
	/**
	 * @description 校验客户系统返回信息-若移动电话、固定电话均为空或地址为空时，弹出提示并进入客户系统"客户信息修改"界面
	 */
	function checkCstReturnInfo(mobile){
		if(mobile==null || mobile==undefined || mobile==""){
			alert("客户移动电话为空，请进行补录。");
			editCustomer();
		}
	}
	function editCustomer(){
		var insuredType = document.getElementById("_insuredTypeEAD").value;
		var customerURL = document.getElementById("customerURLEAD").value;
		var insuredCode = document.getElementById("_insuredCodeEAD").value;
		if(insuredCode==""){
			errorMessage("客户编码不能为空");
			return false;
		}
		var openerName = "CustomEdit" + Math.floor(Math.random()*100);//随机获取弹出窗口名称，防止弹出窗口close时关闭了新的弹出框
		if(insuredType == "1"){
			var strURL = customerURL+"/customperson/prepareUpdate.do?customerCode="+insuredCode+"&syscode=prpall";
			window.open(strURL, openerName, "height=600,width=800,top=200,left=200,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0");
		
		}else if(insuredType == "2"){
			var strURL = customerURL+"/customgroup/prepareUpdate.do?customerCode="+insuredCode+"&syscode=prpall";
			window.open(strURL, openerName, "height=600,width=800,top=200,left=200,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0");
		}
	}
	function searchCustomer(url){
		var _insuredType = document.getElementById("_insuredTypeEAD").value;
		var _insuredName = document.getElementById("_insuredNameEAD").value;
		var _identifyNumber = document.getElementById("_identifyNumberEAD").value;
		var _identifyType = document.getElementById("_identifyTypeEAD").value;
		if(_insuredType == "1"){
			var strURL = url+"?customerCName="+URLEncoding(_insuredName)+"&identifyType="+_identifyType+"&identifyNumber="+_identifyNumber+"&syscode=prpall";
			window.open(strURL, "QueryCustomList", "height=600,width=800,top=200,left=200,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0");
		
		}else if(_insuredType == "2"){
			var strURL = url+"?customerCName="+URLEncoding(_insuredName)+"&syscode=prpall";
			window.open(strURL, "QueryCustomList", "height=600,width=800,top=200,left=200,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0");
		}
	}
	/**
	 * @Author : PICC GEFEI
	 * @description 创建客户信息
	 * @param null
	 * @return null
	 * @date 2009-09-17
	 */
	function createCustomer(url){
		var _insuredType = document.getElementById("_insuredTypeEAD").value;
		var _insuredName = document.getElementById("_insuredNameEAD").value;
		var _identifyNumber = document.getElementById("_insuredCodeEAD").value;
		var _identifyType = document.getElementById("_identifyTypeEAD").value;
		var _unifiedSocialCreditCode = document.getElementById("_unifiedSocialCreditCodeEAD").value;
		if(_insuredType == "1"){
			var strURL = url+"?customerCName="+URLEncoding(_insuredName)+"&identifyType="+_identifyType+"&identifyNumber="+_identifyNumber+"&syscode=prpall";
			window.open(strURL);
		
		}else if(_insuredType == "2"){
			var strURL = url+"?customerCName="+URLEncoding(_insuredName)+"&organizeCode="+_identifyNumber+"&unifiedSocialCreditCode="+_unifiedSocialCreditCode+"&syscode=prpall";
			window.open(strURL, "QueryCustomList", "height=600,width=800,top=200,left=200,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0");
		}
	}
	/*
	 * 检查非空字段以及重复校验
	 */
	function checkInsureAll(pageCode, field, idx){
		  var checkFlag = "0";
		  var strInsureFlag  = "0000000";
		  var driverNo = 0;
		  var obj = document.getElementsByName("_insuredFlagEAD");
		  var objTopLen = parseInt(globalindex[pageCode]);
		  var arrElement = new Array();
		  var i=0;
		  var ownerName = "";
		  var secureName = "";
		  arrElement[i++] = document.getElementById("_insuredNameEAD");
		  arrElement[i++] = document.getElementById("_identifyNumberEAD");
		  arrElement[i++] = document.getElementById("_insuredAddressEAD");
		  var IDCARD_SHIELD = document.getElementById("IDCARD_SHIELD");
		  var detailInfoRiskCode = document.getElementById("detailInfoRiskCode").value; 
		  if(detailInfoRiskCode=='EAD'){
			   this.checkInsuredEAD();
		  }
		  for(i=0;i<arrElement.length;i++)
		  {
		    if(isEmptyField(arrElement[i])==true)
		    {
		    	if(arrElement[i].description=="证件号码" && document.getElementById("_insuredTypeEAD").value=="2"){
		    		continue;
		    	}
		      errorMessage(arrElement[i].description+"不能为空");
		      arrElement[i].focus();
		      arrElement[i].select();
		      return false;
		    }
		  }
		  for(var i=0;i<obj.length;i++){
		     if(obj[i].checked){
		        checkFlag = "1";
		        strInsureFlag = strInsureFlag.substring(0,i)+"1"+strInsureFlag.substring(i+1);
		     }
		  }
		  
		  var insuredType = document.getElementById("_insuredTypeEAD");
		  if(checkFlag == "0"){
		     errorMessage("请选择一个关系人角色！");
		     return false;
		  }else if(strInsureFlag.substring(0,2).indexOf("1")>-1){
			  var comCode = document.getElementById("prpUmain.comCode").value;
			  if(comCode.substring(0,2) == '45' && insuredType.value=="1"){
				  if(document.getElementById("_mobilesEAD").value==""){
					  alert("移动电话必须录入，请修改!");
					  return false;
				  }
				  var configedRepeatTimesLocal=document.getElementById("configedRepeatTimesLocal").value;
				  var repeatTimes=document.getElementById("_repeatTimesEAD").value;
				  if(parseInt(configedRepeatTimesLocal) > 0 && parseInt(repeatTimes)>0){
					  if(parseInt(configedRepeatTimesLocal)<=parseInt(repeatTimes)){
							alert("此电话号码已重复录入"+repeatTimes+"次，不允许出单");
							return false;	
					  }
				  }
			  }
		  }  
		  for(var j=0;j<objTopLen;j++){
		  	if(document.getElementById("updateIndexEAD").value == j){// 保存
		  		continue;
		  	}
		  }
		  
		  var _mobile = document.getElementById("_mobileEAD").value;
		  var el_table_Insured = document.getElementById("insertInsuredRowEAD");
		  var el_tbody_Insured = el_table_Insured.tBodies.item(0);
		  var vCount = parseInt(globalindex["insertInsuredRowEAD"]);
		  for (var i = 0; i < vCount; i++)
		  {
		  	if(document.getElementById("updateIndexEAD").value == i){// 保存
		  		continue;
		  	}
		    if(document.getElementById("prpUinsureds["+i+"].identifyType")!=null&&document.getElementById("prpUinsureds["+i+"].identifyType").value=="01"){
		    	if(compare(document.getElementById("prpUinsureds["+i+"].insuredFlag").value,document.getElementById("_insuredFlagEAD").value)){
		    		if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1"){
			    		if(document.getElementById("prpUinsureds["+i+"].identifyNumber").value==document.getElementById("_identifyNumber1EAD").value)
			    		{
			    			alert("身份证号码不能重复！");
			    			return false;
			    		}
		    		}else{
			    		if(document.getElementById("prpUinsureds["+i+"].identifyNumber").value==document.getElementById("_identifyNumberEAD").value)
			    		{
			    			alert("身份证号码不能重复！");
			    			return false;
			    		}
		    		}

		    	}
			 }
		  }
		  if(strInsureFlag.substring(1,2)=="1" && strInsureFlag.substring(2,3)=="0"){
			 secureName = document.getElementById("_insuredNameEAD").value;      	
		  }else if(strInsureFlag.substring(1,2)=="0" && strInsureFlag.substring(2,3)=="1"){
		  	 ownerName = document.getElementById("_insuredNameEAD").value;  
		  }
		  return true;
	}
	function checkInsuredEAD(){
		var insureType =  document.getElementById("_insuredTypeEAD");
		var plancode = trim(document.getElementById("prpUmain.planCode").value);
		var insuredCount = 0;
		//判断选择角色是否是受益人
		var isBeneficiary = this.checkBeneficiary();
		if(isBeneficiary){
			//如果是受益人,就绕开被保险人校验
		}else if(insureType.value=="1"){
		    if(plancode == "EAD0000001" || plancode == "EAD0000003" || plancode == "EAD0000010" || plancode == "EAD0000009" || 
		    	plancode == "EAD0000008" || plancode == "EAD0000007" || plancode == "EAD0000006" || plancode == "EAD0000005"
		        || plancode == "EAD0000004"){
		       if(document.getElementsByName("_insuredFlagEAD")[1].checked){
			       errorMessage("该方案不允许录入其他被保险人");
			       return false;
		       }
		    }
		}else{
			if(plancode == "EAD0000001" || plancode == "EAD0000003" || plancode == "EAD0000010" || plancode == "EAD0000009" || 
			 	  plancode == "EAD0000008" || plancode == "EAD0000007" || plancode == "EAD0000006" || plancode == "EAD0000005" ||
				  plancode == "EAD0000004"){
				 var oTBODY   = document.all("insertInsuredRowEAD").tBodies.item(0);
				 var rows = oTBODY.rows;
				 var vCount = rows.length;
				 var reg = /^(prpCinsureds){1}(\[){1}[0-9]{1,3}(\]){1}(\.){1}(insuredFlag){1}$/;
				 for(var i = 0;i<vCount;i++){
					var els = oTBODY.rows[i].all;
					for(var j=0; j < els.length; j++ ){
						var name = els[j].name ||els[j].id || "";
						if(reg.exec(name)){
							if(els[j].value.substring(1,2)=='1'){
							     insuredCount = insuredCount +1;
								break;
							}
						}
					}
				}
			}
			if(insuredCount>0){
				 errorMessage("该方案只允许录入唯一一个被保险人");
			     return false;
			}
	    }	
    }	
	/**
	 * 判断选中的角色是否是受益人
	 */
	function checkBeneficiary(){
		var isBeneficiary = false;
	    var _insuredRdo = YAHOO.util.Dom.getElementsBy(
	    		function(obj){
					return obj.type == "radio" && obj.name == "_insuredFlagEAD";	    
	    		}, 
	    		"input", "testtable");
	    var len = _insuredRdo.length;
	    //是否选择的是"受益人",需求说受益人可以有很多个,就让它随便加吧
	    var isBeneficiary = false;
	    for(var i=0; i < len; i++){
			if(_insuredRdo[i].checked && _insuredRdo[i].title == "受益人"){
				isBeneficiary = true;
				break;
			}
	    }
	    return isBeneficiary;
	}
	/**
	 * @description 关系人关系判断，保证同一个关系只有一条数据
	 */
	function compare(insuredFlag1,insuredFlag2){
	    for(var i =0;i<insuredFlag1.length;i++){
	        if(insuredFlag1.charAt(i)=='1'&& insuredFlag2.charAt(i)=='1'){
	            return true;
	        }
	    } 
	    return false;
	}
	function checkIdentifyNumberID(field){
		// 证件类型只有是身份证的时候才校验
		if(document.getElementById("_insuredTypeEAD").value=="1"&&document.getElementById("_identifyTypeEAD").value=="01"){
			var IDCARD_SHIELD = document.getElementById("IDCARD_SHIELD");
			if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1"
			    && field == document.getElementById("_identifyNumberEAD") && document.getElementById("_identifyNumberEAD").readOnly){
			}else{
		        if(field.value==""){
			        return false;
			    }
			    if(!isChinaIDCard(field.value)){// 用客户管理系统的身份证校验
				    field.focus();
					field.select();
					return false;
			    }else{
				    writeDivLicenseNo();
				}
			}
		}
        return true;
    }
	// 证件类型改变时，清空证件号码
	function clearIdentifyNumber(){
        document.getElementById("_identifyNumberEAD").value = "";
		if(document.getElementById("_identifyNumberEAD").onchange!=null){
		    document.getElementById("_identifyNumberEAD").onchange();
		}
		if(document.getElementById("_identifyNumber1EAD")!=null){
			document.getElementById("_identifyNumber1EAD").value = "";
		}
        document.getElementById("_identifyNumberEAD").onblur();
        writeDivLicenseNo(); 
	}
	function writeDivLicenseNo(){
		var identifyNumber = document.getElementById("_identifyNumberEAD").value;
		if(document.getElementById("_identifyTypeEAD").value=="01" && isNaN(document.getElementById("_drivingLicenseNoEAD"))){
			document.getElementById("_drivingLicenseNoEAD").value = identifyNumber;
		}else if(isNaN(document.getElementById("_drivingLicenseNoEAD"))){
			document.getElementById("_drivingLicenseNoEAD").value = "";
		}
	}
	isChinaIDCard : function(StrNo) {
	  	var num = StrNo;
	  	num = num.toUpperCase();  
		StrNo = StrNo.toString();
		if (StrNo.length == 15) {
			re = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/); 
	    	var arrSplit = num.match(re); 
	    	// 检查生日日期是否正确
	    	var dtmBirth = new Date('19' + arrSplit[2] + '/' + arrSplit[3] + '/' + arrSplit[4]); 
	    	getAge(dtmBirth);
			if (!isValidDate("19" + StrNo.substr(6, 2), StrNo.substr(8, 2), StrNo
					.substr(10, 2))) {
				return false;
			}
			
		} else if (StrNo.length == 18) {
		  	re = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/); 
	      	var arrSplit = num.match(re); 
	      	// 检查生日日期是否正确
	     	var dtmBirth = new Date(arrSplit[2] + "/" + arrSplit[3] + "/" + arrSplit[4]); 
	     	getAge(dtmBirth);	
			if (!isValidDate(StrNo.substr(6, 4), StrNo.substr(10, 2), StrNo.substr(
					12, 2))) {
				return false;
			}
		} else {
			alert("输入的身份证号码必须为15位或者18位！");
			return false;
		}

		if (StrNo.length == 18) {
			var a, b, c
			if (!isNumber(StrNo.substr(0, 17))) {
				alert("身份证号码错误,18位的身份证号前17位必须是数字！");
				return false;
			}
			a = parseInt(StrNo.substr(0, 1)) * 7 + parseInt(StrNo.substr(1, 1)) * 9
					+ parseInt(StrNo.substr(2, 1)) * 10;
			a = a + parseInt(StrNo.substr(3, 1)) * 5 + parseInt(StrNo.substr(4, 1))
					* 8 + parseInt(StrNo.substr(5, 1)) * 4;
			a = a + parseInt(StrNo.substr(6, 1)) * 2 + parseInt(StrNo.substr(7, 1))
					* 1 + parseInt(StrNo.substr(8, 1)) * 6;
			a = a + parseInt(StrNo.substr(9, 1)) * 3
					+ parseInt(StrNo.substr(10, 1)) * 7
					+ parseInt(StrNo.substr(11, 1)) * 9;
			a = a + parseInt(StrNo.substr(12, 1)) * 10
					+ parseInt(StrNo.substr(13, 1)) * 5
					+ parseInt(StrNo.substr(14, 1)) * 8;
			a = a + parseInt(StrNo.substr(15, 1)) * 4
					+ parseInt(StrNo.substr(16, 1)) * 2;
			b = a % 11;
			if (b == 2) // 最后一位为校验位
			{
				c = StrNo.substr(17, 1).toUpperCase(); // 转为大写X
			} else {
				c = parseInt(StrNo.substr(17, 1));
			}
			switch (b) {
			case 0:
				if (c != 1) {
					alert("身份证号码校验位错:最后一位应该为:1");
					return false;
				}
				break;
			case 1:
				if (c != 0) {
					alert("身份证号码校验位错:最后一位应该为:0");
					return false;
				}
				break;
			case 2:
				if (c != "X") {
					alert("身份证号码校验位错:最后一位应该为:X");
					return false;
				}
				break;
			case 3:
				if (c != 9) {
					alert("身份证号码校验位错:最后一位应该为:9");
					return false;
				}
				break;
			case 4:
				if (c != 8) {
					alert("身份证号码校验位错:最后一位应该为:8");
					return false;
				}
				break;
			case 5:
				if (c != 7) {
					alert("身份证号码校验位错:最后一位应该为:7");
					return false;
				}
				break;
			case 6:
				if (c != 6) {
					alert("身份证号码校验位错:最后一位应该为:6");
					return false;
				}
				break;
			case 7:
				if (c != 5) {
					alert("身份证号码校验位错:最后一位应该为:5");
					return false;
				}
				break;
			case 8:
				if (c != 4) {
					alert("身份证号码校验位错:最后一位应该为:4");
					return false;
				}
				break;
			case 9:
				if (c != 3) {
					alert("身份证号码校验位错:最后一位应该为:3");
					return false;
				}
				break;
			case 10:
				if (c != 2) {
					alert("身份证号码校验位错:最后一位应该为:2");
					return false;
				}
			}
		} else {// 15位身份证号
			if (!isNumber(StrNo)) {
				alert("身份证号码错误,15位的身份证号必须全部是数字！");
				return false;
			}
		}
		return true;
	}
	// 根据身份证日期生成年龄
	function getAge(dtmBirth){
	   var birthYear = dtmBirth.getFullYear();
	   var date = new Date();
	   var age = date.getYear() - birthYear;
	}
	function isValidDate(iY, iM, iD) {
		if (iY > 2200 || iY < 1900 || !isNumber(iY)) {
			alert("输入身份证号,年度" + iY + "非法！");
			return false;
		}
		if (iM > 12 || iM <= 0 || !isNumber(iM)) {
			alert("输入身份证号,月份" + iM + "非法！");
			return false;
		}
		if (iD > 31 || iD <= 0 || !isNumber(iD)) {
			alert("输入身份证号,日期" + iD + "非法！");
			return false;
		}
		return true;
	}
	/**
	 * 验证是不是数字
	 */
	function isNumber(oNum) {
		if (!oNum)
			return false;
		var strP = /^\d+(\.\d+)?$/;
		if (!strP.test(oNum))
			return false;
		try {
			if (parseFloat(oNum) != oNum)
				return false;
		} catch (ex) {
			return false;
		}
		return true;
	}
	/**
	 * 验证是不是数字
	 */
	function isNumber(oNum) {
		if (!oNum)
			return false;
		var strP = /^\d+(\.\d+)?$/;
		if (!strP.test(oNum))
			return false;
		try {
			if (parseFloat(oNum) != oNum)
				return false;
		} catch (ex) {
			return false;
		}
		return true;
	}
	function changeIdentifyNumber(){
		document.getElementById("_insuredCodeEAD").value = "";
		document.getElementById("_mobileEAD").readOnly = false;
	}
	blurMobile : function(field){	
		checkIsInteger(field);
		checkMobile(field);
	}
	/**
	 * 校验字符串是否为整型 返回值： 如果为空，定义校验通过， 返回true 如果字串全部为数字，校验通过，返回true 如果校验不通过， 返回false
	 * 参考提示信息：输入域必须为数字！
	 */
	function checkIsInteger(field){
		var str = field.value;
		if(str!="")
		{ 
		    if(/^(\-?)(\d+)$/.test(str)|| /^1[3,5,4,7,8,9]\d{1}\*{4}\d{4}$/.test(str))
		    {
		    	return true;
		    }
		    else{
		    	alert("请输入合理的数字");
		    	field.focus(); 
		    	field.select();
		    	field.value="";
		    	return false;
		    }
		}
	}
	/**
	 * @description 移动电话号码合法性校验
	 * <p>
	 * <font color=red>规则 : R628,R635</font>
	 * </p>
	 * @param obj
	 * @return
	 */
	function checkMobile(obj)	{
	    var num = obj.value;
	 	var partten = /^1[3,5,4,7,8,9]\d{9}$/;
	 	var partten1=/^1[3,5,4,7,8,9]\d{1}\*{4}\d{4}$/;
	 	if(num!=null&&num!="")
	 	{
	 		if(num.length!=11){ 			
	 			alert("移动电话号码必须为11位有效数字!");
	 			obj.value = "";
		 		obj.focus();
		 		obj.select();
		 		return false;
		 		
		 	}
	 		if(!partten.test(num) && !partten.test(num)){
	 			alert("移动电话格式错误。例如：15821345169");
	 			obj.value = "";
	 			obj.focus();
	 			obj.select();
	 			return false;
	 		}
	 	}
	 	return true;
	}
	//刷新被保险人人数
	function refreshCount(temp){
		var insuredCount = 0;
		var oTBODY   = document.all("insertInsuredRowEAD").tBodies.item(0);
		var rows = oTBODY.rows;
		var vCount = rows.length;
		var reg = /^(prpUinsureds){1}(\[){1}[0-9]{1,3}(\]){1}(\.){1}(insuredFlag){1}$/;
		for(var i = 0;i<vCount;i++){
			var els = oTBODY.rows[i].all;
			for(var j=0; j < els.length; j++ ){
				var name = els[j].name ||els[j].id || "";
				if(reg.exec(name)){
					if(els[j].value.substring(1,2)=='1'){
						insuredCount = insuredCount +1;
					}
				}
			}
		}
		var riskTemplateCode = document.getElementById("prpUmain.riskCode").value;
		if(riskTemplateCode == "EAD"){
			if(document.getElementById("prpUmain.insuredQuantity")!=null){
				document.getElementById("prpUmain.insuredQuantity").value = insuredCount;
				ItemKind.reCount(temp);
			}
		}
	}
	function checkInsuredName(){
		document.getElementById("_insuredCodeEAD").value = "";
		document.getElementById("_insuredAddressEAD").value = "";
		document.getElementById("_identifyNumberEAD").value="";
		if(document.getElementById("_identifyNumber1EAD")!=null){
			document.getElementById("_identifyNumber1EAD").value="";
		}
		document.getElementById("_mobilesEAD").value="";
		if(document.getElementById("_emailEAD")!= null){
			document.getElementById("_emailEAD").value="";
			document.getElementById("_emailEAD").readOnly=false;
		};
		if(document.getElementById("_postCodeEAD")!= null){
			document.getElementById("_postCodeEAD").value="";
			document.getElementById("_postCodeEAD").readOnly=false;
		};
		document.getElementById("_mobileEAD").readOnly = false;
		document.getElementById("_mobilesEAD").readOnly = false;
		document.getElementById("_identifyNumberEAD").readOnly = false;
		document.getElementById("_insuredAddressEAD").readOnly=false;
	}
	/**
	 * 校验字符串是否为整型 返回值： 如果为空，定义校验通过， 返回true 如果字串全部为数字，校验通过，返回true 如果校验不通过， 返回false
	 * 参考提示信息：输入域必须为数字！
	 */
	function checkIsInteger(field){
		var str = field.value;
		if(str!="")
		{ 
		    if(/^(\-?)(\d+)$/.test(str)|| /^1[3,5,4,7,8,9]\d{1}\*{4}\d{4}$/.test(str))
		    {
		    	return true;
		    }
		    else{
		    	alert("请输入合理的数字");
		    	field.focus(); 
		    	field.select();
		    	field.value="";
		    	return false;
		    }
		}
	}
	// 验证移动电话号码
	function changeMobile(field){
		document.getElementById("_insuredCodeEAD").value = "";
		if(checkIsInteger(field) && checkMobile(field)){
			var index = UnitedSaleInsured.getInsuredsIndex(field);
			document.getElementById("prpUinsureds["+index+"].mobile").value=trim(field.value);
		}
	}
	/**
	 * @private
	 * @description 获取关系人所在行的下标
	 * @return
	 */
	function getInsuredsIndex(field) {
	    var reg = /^prpUinsureds_(\[){1}[0-9]{1,5}(\]){1}(\.){1}mobile$/;
	    var row=field.parentNode.parentNode;
		var els = row.all;
		var index = 0;
		for(var k = 0;k <els.length;k++){
			var el = els[k];
			var name = el.id || el.name;
			if(!reg.exec(name)){
				continue;
			}
			index = name.substring(name.indexOf('[') +1,name.indexOf(']'));	
		}    		
		return index;
	}
	function deleteOneRow(obj,field){
		var tr = getTR(obj);
		var eleName = tr.cells[6].all[1].name;
		var index=eleName.substring(eleName.indexOf("[")+1,eleName.indexOf("]"));
		deleteRow(obj,field);
		clearInsuredInputArea();
	}
	function clearInsuredInputArea(){
		var _insuredName = document.getElementById("_insuredNameEAD");
		_insuredName.value = "";
		_insuredName.readOnly = false;
		var _insuredCode = document.getElementById("_insuredCodeEAD");
		_insuredCode.value = "";
		_insuredCode.readOnly = false; 
		var _identifyNumber = document.getElementById("_identifyNumberEAD");
		_identifyNumber.value = "";
		_identifyNumber.readOnly = false;
		var _identifyNumber1EAD = document.getElementById("_identifyNumber1EAD");
		if(_identifyNumber1EAD!=null){
			_identifyNumber1EAD.value = "";
		}
		var _insuredAddress = document.getElementById("_insuredAddressEAD");
		_insuredAddress.value = "";
		_insuredAddress.readOnly = false;
		var _mobile = document.getElementById("_mobileEAD");
		_mobile.value = "";
		_mobile.readOnly = false;
		var _mobiles = document.getElementById("_mobilesEAD");
		_mobiles.value = "";
		_mobiles.readOnly = false;
		var _unifiedSocialCreditCode = document.getElementById("_unifiedSocialCreditCodeEAD");
		_unifiedSocialCreditCode.value="";
		_unifiedSocialCreditCode.readOnly = false;
		var updateIndex = document.getElementById("updateIndexEAD");
		updateIndex.value = "-1";
	}
	/**
	 * @author sinosoft
	 * @description 广东职业证号双击域事件
	 * @param 
	 * @return
	 */
	function code_CodeSelect_gd_prpdsellerno(self){
		var index = self.name.split('[')[1].split("]")[0];
		var cmaincomcode = d('prpUmain.comCode').value;
		var selfName = self.name;
		var prefix = selfName.substr(0,selfName.indexOf("."));
		var businessNature =  d('prpUmain.businessNature').value;
		var agentcode = d('prpUmain.agentcode');
		var addstr = 'node=node';
		if(businessNature=='0'||businessNature=='1'){
			addstr = addstr + ',cmaincomcode='+cmaincomcode;
		}else{
			if(agentcode.value && trim(agentcode.value)!=''){
				addstr = addstr + ',agentcode='+agentcode.value;
			}
		}
		if(businessNature!=''){
			addstr = addstr + ',businessnature='+businessNature;
		}
		var callBack = "prpdsellernoCallback('"+index+"')";
		code_CodeSelect(self,'gd_prpdsellerno','0,1,2,3,4,5,6,7,8','Y',addstr,"","","");
	}
	/**
	 * @author sinosoft
	 * @description 广东手续费回调方法
	 * @param 
	 * @return
	 */
	function prpdsellernoCallback(index){
		var value =d('prpUmain.businessNature').value;
		if("0" == trim(value)){
			d('commission['+index+'].costType').value='03';
			d('prpUcommissionsTemp['+index+'].costType').value='03';
		}else if("1"== trim(value) ||"2"== trim(value) ||"3"== trim(value) ){
			d('commission['+index+'].costType').value='01';
			d('prpUcommissionsTemp['+index+'].costType').value='01';
		}else if("4" == trim(value) ){
			d('commission['+index+'].costType').value='02';
			d('prpUcommissionsTemp['+index+'].costType').value='02';
		}
	}
	/**
	 * @description 广东职业证号onchange事件
	 * @param 
	 * @return
	 */
	function code_CodeChange_gd_prpdsellerno(self){
		var index = self.name.split('[')[1].split("]")[0];
		var cmaincomcode = d('prpUmain.comCode').value;
		var selfName = self.name;
		var prefix = selfName.substr(0,selfName.indexOf("."));
		var businessNature =  d('prpUmain.businessNature').value; 
		var agentcode = d('prpUmain.agentcode');
		var addstr = 'node=node';
		if(businessNature=='0'||businessNature=='1'){
			addstr = addstr + ',cmaincomcode='+cmaincomcode;
		}else{
			if(agentcode.value && trim(agentcode.value)!=''){
				addstr = addstr + ',agentcode='+agentcode.value;
			}
		}
		
		if(businessNature=='1' ||businessNature=='0' ){
			addstr = addstr + ',businessnature='+businessNature;
		}
		code_CodeChange(self,'gd_prpdsellerno','0,1,2,3,4,5,6,7,8','Y',addstr,"","",null);
	}

