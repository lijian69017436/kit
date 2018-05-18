	/**
	 * @author huxiaodong
	 * @fileOverview 关系人基本信息
	 * @version 1.0
	 */

	/**
	 * @class
	 */
	Insured = {
	
	hpDialogIs : new HashMap(),
	updateIndex : -1,
			/**
			 * @author sinosoft
			 * @description 初始化关系人标志
			 *<p>
			 *<font color=red>规则 : R24</font>
			 *</p>
			 * @return
			 */
			initInsuredFlag : function(){
				
				var relationType = document.getElementById("relationType").value;
				var riskCode = document.getElementById("riskCode").value;
				if(relationType == "" || relationType == null){
					relationType = 1;
				}
				var _insuredFlag_hide = document.getElementsByName("_insuredFlag_hide");
				var _insuredFlag = document.getElementsByName("_insuredFlag");
				
					if(relationType == '1'){	
					for(var i = 0;i < _insuredFlag.length;i++){
						if("DAE,DGA,DAB,DZB".indexOf(riskCode) > -1){
							if(_insuredFlag_hide[i].value == '投保人' || _insuredFlag_hide[i].value == '被保险人'){
								_insuredFlag[i].checked = true;
							}else{
								_insuredFlag[i].checked = false;
							}
						}else{
							// R24
							if(document.getElementById("comCode").value.substring(0,2) != '31') {
								if(_insuredFlag_hide[i].value == '投保人' || _insuredFlag_hide[i].value == '被保险人' || _insuredFlag_hide[i].value == '车主'){
									_insuredFlag[i].checked = true;
								}else{
									_insuredFlag[i].checked = false;
								}
							}else{
								if(_insuredFlag_hide[i].value == '投保人' || _insuredFlag_hide[i].value == '被保险人'){
									_insuredFlag[i].checked = true;
								}else{
									_insuredFlag[i].checked = false;
								}
							}
						}
					}
					}else{
						// R24
						for(var i = 0;i < _insuredFlag.length;i++){
							if(_insuredFlag_hide[i].value == '投保人' || _insuredFlag_hide[i].value == '被保险人'){
								_insuredFlag[i].checked = true;
							}else{
								_insuredFlag[i].checked = false;
							}
						}
					}
			},
			
			/**
			 * @description 根据投保人类型判断否电子投保
			 * @param
			 * @return
			 */
			onchangeIsNetProp : function(){
				var insuredType = document.getElementById("_insuredType").value;
				var _insuredFlag = document.getElementsByName("_insuredFlag");
				var isNetProp = document.getElementsByName("isNetProp");
				var NETPPROP_SWITCH = document.getElementById("NETPPROP_SWITCH");
				if(NETPPROP_SWITCH!=null && NETPPROP_SWITCH.value=="1"){
					if(_insuredFlag[0].checked){
						if(insuredType == "2"){
							//投保人为法人
					        var isNetPropshow=document.getElementsByName("isNetPropshow");
							if(isNetPropshow!=null && isNetPropshow.length>0){
								isNetPropshow[1].checked = true;
								document.getElementById("isNetPropshow").disabled=true; 
							}
							if(document.getElementById("isNetProp")!=null){
								document.getElementById("isNetProp").value="0";
							}
						}else{
							var isNetPropshow=document.getElementsByName("isNetPropshow");
							if(isNetPropshow!=null && isNetPropshow.length>0){
							    isNetPropshow[0].checked = true;
								document.getElementById("isNetPropshow").disabled=false; 
							}
							if(document.getElementById("isNetProp")!=null){
								document.getElementById("isNetProp").value="1";
							}
					    }
					}
				}else{
				    var isNetPropshow=document.getElementsByName("isNetPropshow");
					if(isNetPropshow!=null && isNetPropshow.length>0){
					isNetPropshow[1].checked = true;
						document.getElementById("isNetPropshow").disabled=true; 
					}
					if(document.getElementById("isNetProp")!=null){
						document.getElementById("isNetProp").value="0";
					}
				}
			},
			/**
			 * @author sinosoft
			 * @description 清除输入域信息
			 * @return
			 */
			clearInsuredInputArea : function(){
				Insured.resetInsuredFlag();
				//LICHENHUI;重置时将关键信息的只读放开;20101014;begin;
				document.getElementById("modelList").innerHTML = "";
				var insuredName = document.getElementById("_insuredName");
				insuredName.value = "";
				insuredName.readOnly = false;
				var insuredCode = document.getElementById("_insuredCode");
				insuredCode.value = "";
			    //insuredCode.readOnly = false;
				var identifyNumber = document.getElementById("_identifyNumber");
				identifyNumber.value = "";
				identifyNumber.readOnly = false;
				var identifyNumber1 = document.getElementById("_identifyNumber1");
				if(identifyNumber1 != null){
					identifyNumber1.value = "";
				}
				var identifyType = document.getElementById("_identifyType");
				identifyType.disabled = false;
				var insuredType = document.getElementById("_insuredType");
				insuredType.disabled = false;
				var countryCode = document.getElementById("_countryCode");
				countryCode.disabled = false;
				var sex = document.getElementById("_sex");
				sex.disabled = false;
				var age = document.getElementById("_age");
				age.value = "";  
				var unifiedSocialCreditCode = document.getElementById("_unifiedSocialCreditCode");
				var electronicPolicyFlag = document.getElementById("electronicPolicyFlag");
				unifiedSocialCreditCode.value = ""; 
				unifiedSocialCreditCode.readOnly = false;
				document.getElementById("_taxPayerNumber").value = "";
				//LICHENHUI;重置时将关键信息的只读放开;20101014;begin;
				document.getElementById("_drivingYears").value = "";
				document.getElementById("_insuredAddress").value = "";
				document.getElementById("_insuredAddress").readOnly = false;
				document.getElementById("_phoneNumber").value = "";
				document.getElementById("_phoneNumber1").value = "";
				document.getElementById("_phoneNumber1").readOnly = false;
				document.getElementById("_mobile").value = "";
				document.getElementById("_mobile1").value = ""; 
				document.getElementById("_mobile1").readOnly = false;
				document.getElementById("_postCode").value = "";
				document.getElementById("_postCode").readOnly = false;
				document.getElementById("_auditStatus").value = "";
				document.getElementById("_auditStatusDes").value = "";
				document.getElementById("_versionNo").value = "";
				document.getElementById("_drivingLicenseNo").value = "";
				document.getElementById("drivingLicenseNo").style.display = "none";
				document.getElementById("drivingLicenseNoValue").style.display = "none";
				//modify by sangjianjun;准驾车型只有在指定驾驶人才显示  20100728 begin
				document.getElementById("_drivingCarType").value = "";
				document.getElementById("drivingCarType").style.display = "none";
				document.getElementById("drivingCarTypeValue").style.display = "none";
				//modify by sangjianjun;准驾车型只有在指定驾驶人才显示  20100728 end
				
				//modify by lujunfeng 指定驾驶人时显示上年违章次数和初次领证日期
				document.getElementById("_causetroubleTimes").value = "";
				document.getElementById("_acceptLicenseDate").value = "";
				document.getElementById("disType").style.display = "none";
				document.getElementById("causetroubleTimesType").style.display = "none";
				document.getElementById("causetroubleTimesValue").style.display = "none";
					
				document.getElementById("acceptLicenseDateType").style.display = "none";
				document.getElementById("acceptLicenseDateValue").style.display = "none";
				
				document.getElementById("_appendPrintName").value = "";
				
				var comCode = document.getElementById("comCode").value;
				var riskCode = document.getElementById("riskCode").value;
				if(comCode.substring(0,2) == "11" && riskCode == "DAA"){
					document.getElementById("_email").value = "";
					document.getElementById("iDCardCheckInfo.idcardCode").value = "";
					document.getElementById("iDCardCheckInfo.name").value = "";
					document.getElementById("iDCardCheckInfo.nation").value = "";
					document.getElementById("iDCardCheckInfo.birthday").value = "";
					document.getElementById("iDCardCheckInfo.sex").value = "";
					document.getElementById("iDCardCheckInfo.address").value = "";
					document.getElementById("iDCardCheckInfo.issure").value = "";
					document.getElementById("iDCardCheckInfo.validStartDate").value = "";
					document.getElementById("iDCardCheckInfo.validEndDate").value = "";
					document.getElementById("iDCardCheckInfo.samCode").value = "";
					document.getElementById("iDCardCheckInfo.samType").value = "";
					document.getElementById("iDCardCheckInfo.flag").value = "0";
				}
				if((riskCode == "DAA" || riskCode == "DAV") && electronicPolicyFlag != null
						&& (electronicPolicyFlag.value == "1" || (electronicPolicyFlag.value == "2" && comCode.substring(0,2) == "36" ))){
					document.getElementById("_email").value = "";
				}
				// 快速报价页面没有集团代码对象
				if(document.getElementById("group_code")){
					document.getElementById("group_code").value = "";
				}
				//清空军属军人信息
				if(riskCode == "DAV"){
					Insured.clearSoldierInput();
					document.getElementById("soldierRelations").style.display = "none";
					document.getElementById("soldierRelationsValue").style.display = "none";
					document.getElementById("soldierIdentifyType").style.display = "none";
					document.getElementById("soldierIdentifyTypeValue").style.display = "none";
					document.getElementById("soldierIdentifyNumber").style.display = "none";
					document.getElementById("soldierIdentifyNumberValue").style.display = "none";
				}
				//还原是否普惠融资带动客户下拉框
				var isFinanceCustomer = document.getElementById("_isFinanceCustomer");
				if(isFinanceCustomer != null && isFinanceCustomer != undefined){
			        while(document.all("_isFinanceCustomer").options.length>0){
			        	document.all("_isFinanceCustomer").options.remove(0);
			        }
			        isFinanceCustomer.options.add(new Option("否","3"));
			        isFinanceCustomer.options.add(new Option("普惠融资间接带动","2"));
			        isFinanceCustomer.options.add(new Option("普惠融资直接带动","1"));
					document.getElementById("financeFlag").value = "";
				}
			},
	
			/**
			 * @author LICHENHUI
			 * @description  将关键信息设为只读
			 */
			setInsuredReadOnly : function(){
				var insuredCode = document.getElementById("_insuredCode");
				if(insuredCode.value.trim() != ""){
					insuredCode.readOnly = true;
					var insuredName = document.getElementById("_insuredName");
					insuredName.readOnly = true;
					var identifyNumber = document.getElementById("_identifyNumber");
					identifyNumber.readOnly = true;
					var identifyType = document.getElementById("_identifyType");
					identifyType.disabled = true;
					var sex = document.getElementById("_sex");
					sex.disabled = true;
					var countryCode = document.getElementById("_countryCode");
					countryCode.disabled = true;
					document.getElementById("_insuredType").disabled = true;
					var mobile = document.getElementById("_mobile1");
					var insuredType = document.getElementById("_insuredType").value;
					var comCode = document.getElementById("prpCmain.comCode").value;
					var riskCode = document.getElementById("riskCode").value;
					if(mobile!=null){
						if(insuredType=="2" && comCode.substring(0,2) == "11" && (riskCode == "DAA" || riskCode == "DAV")){
							mobile.readOnly = false;
						}else{
							mobile.readOnly = true;
						}
						
					}
					var phoneNumber = document.getElementById("_phoneNumber1");
					if(phoneNumber!=null){
						phoneNumber.readOnly = true;
					}
					var insuredAddress = document.getElementById("_insuredAddress");
					if(insuredAddress!=null){
						insuredAddress.readOnly = true;
					}
					var postCode = document.getElementById("_postCode");
					if(postCode!=null){
						postCode.readOnly = true;
					}
					var unifiedSocialCreditCode = document.getElementById("_unifiedSocialCreditCode");
					if(unifiedSocialCreditCode!=null){
						unifiedSocialCreditCode.readOnly = true;
					}
				} else {
					var _mobile1 = document.getElementById("_mobile1");
					if(_mobile1 != null && _mobile1.readOnly == true){
						var insuredName = document.getElementById("_insuredName");
						insuredName.readOnly = false;
						var insuredCode = document.getElementById("_insuredCode");
					//  insuredCode.readOnly = false;
						var identifyNumber = document.getElementById("_identifyNumber");
						identifyNumber.readOnly = false;
						var identifyType = document.getElementById("_identifyType");
						identifyType.disabled = false;
						document.getElementById("_insuredType").disabled = false;
						var sex = document.getElementById("_sex");
						sex.disabled = false;
						var countryCode = document.getElementById("_countryCode");
						countryCode.disabled = false;
						var mobile = document.getElementById("_mobile1");
						if(mobile!=null){
							mobile.readOnly = false;
						}
						var phoneNumber = document.getElementById("_phoneNumber1");
						if(phoneNumber!=null){
							phoneNumber.readOnly = false;
						}
						var insuredAddress = document.getElementById("_insuredAddress");
						if(insuredAddress!=null){
							insuredAddress.readOnly = false;
						}
						var postCode = document.getElementById("_postCode");
						if(postCode!=null){
							postCode.readOnly = false;
						}
					}
				}
			},
			/**
			 * @author sinosoft
			 * @description 增加关系人方法
			 *<p>
			 *<font color=red>规则 : R27,R31,R439,R440,R441,R540</font>
			 *</p>
			 * @param pageCode
			 * @param field
			 * @param idx
			 * @return
			 */
			insured_Add : function(pageCode, field, idx) {
			    var index = 0;
				// 如果当前全局行序集合无此列表信息并且当前列表有信息
				index = document.getElementById(idx).value;
				if (isNaN(parseInt(globalindex[pageCode])) && parseInt(index) != 0) {
					globalindex[pageCode] = parseInt(index);
				}
				/* 输入区域信息备份、清空。 */
			    var riskCode = document.getElementById("riskCode").value;
				var _insuredFlag = document.getElementsByName("_insuredFlag");
				var _insuredFlag_hide = document.getElementsByName("_insuredFlag_hide");
				var mobileTemp = document.getElementById('_mobile');
				var comCodeTemp = document.getElementById("comCode").value;
				var _insuredFlagValue = "";
				var _insuredFlagText = "";
				for ( var i = 0; i < _insuredFlag.length; i++) {
					if (_insuredFlag[i].checked == true) {
						/**
						 * 广东个性-驾驶员控制 begin
						 * zouyx 20110506
						 */
						if(isGuangdong()){
							if(i==3){
								if(guangZhouFlag){
									if(countInsuredRelationship()>=1){
										errorMessage("广州地区只可录入一名指定驾驶员!");
										return false;
									}
								}else{
									if(countInsuredRelationship()>=1){
										errorMessage("广东控制:只能录一个驾驶员!");
										return false;
									}
								}
							}
						}
						/**
						 * 广东个性-end
						 */
				    	if(riskCode == "DAV" && i == 8){
				    		_insuredFlagValue = _insuredFlagValue + "00000000000000001";
				    	}else{
							_insuredFlagValue += "1";
				    	}
						if (_insuredFlagText != "") {
							_insuredFlagText = _insuredFlagText + "/";
						}
						_insuredFlagText += _insuredFlag_hide[i].value;	
					} else {
						_insuredFlagValue += "0";
					}
				}
				if(document.getElementById("_insuredType").value =="1" &&"51,52".indexOf(comCodeTemp.substring(0,2)) > -1 && (_insuredFlagValue.substring(0,1) == "1" || _insuredFlagValue.substring(1,2) == "1")){
					if(mobileTemp.value =="" || mobileTemp.value == null){
						alert("移动电话不能为空，请录入！");
						return false;
					}
				}
				//add by zhaoxiaojie 20100802 关系人为单独车主的话不用校验 begin
			    //modify by lujunfeng 20110803 添加关系人为单独港澳车车主和受益人的话不用校验 
			    if(_insuredFlagValue=="00000000" || (_insuredFlagValue.substr(0,1)+_insuredFlagValue.substr(1,1)+_insuredFlagValue.substr(2,1)+_insuredFlagValue.substr(3,1)+_insuredFlagValue.substr(6,1)+_insuredFlagValue.substr(7,1)).indexOf("1") > -1){
			    	 if((_insuredFlagValue.substr(6,1)+_insuredFlagValue.substr(7,1)+_insuredFlagValue.substr(2,1)).indexOf("1") > -1){
			       	  var arrElement = new Array();
			   		  var i=0;
			   		  arrElement[i++] = document.getElementById("_insuredName");
				   	  arrElement[i++] = document.getElementById("_mobile");
			   		  if(_insuredFlagValue != '00000001'){
			   	   		  arrElement[i++] = document.getElementById("_phoneNumber");
			   		  }
			   		  //单独委托人校验证件号码
			   		  if(_insuredFlagValue == '00000001'){
			   			  arrElement[i++] = document.getElementById("_identifyNumber");
			   		  }
			   		  //modify by lujunfeng 20110803 修改关系人手机号、固定电话只需要录入其中一个
			   		  if(isEmptyField(arrElement[0])==true)
			   		  {
			   		        errorMessage(arrElement[0].description+"不能为空");
			   		        arrElement[0].focus();
			   		        arrElement[0].select();
			   		        return false;
			   		  }
			   		  // R441
			   		  if(isEmptyField(arrElement[1])==true && isEmptyField(arrElement[2])==true)
			   		  {
				   		     errorMessage(arrElement[1].description+"和"+arrElement[2].description+"不能同时为空");
				   		     //modify by zhangqingtao PRPALL-3129 20121122 让其focus()显示的电话号码上
				   		     document.getElementById("_mobile1").focus();
				   		     document.getElementById("_mobile1").select();
				   		     return false;
			   		  }
			   		  
			   		  var checkFlag = "0";
					  var strInsureFlag  = "00000000";
					  var obj = document.getElementsByName("_insuredFlag");
					  var objTopLen = parseInt(globalindex[pageCode]);
					
					  for(var i=0;i<obj.length;i++){
					     if(obj[i].checked){
					        checkFlag = "1";
					        strInsureFlag = strInsureFlag.substring(0,i)+"1"+strInsureFlag.substring(i+1);
					     }
					  }
					  if(strInsureFlag.substr(7,1).indexOf("1")>-1){
						  if(document.getElementById("_insuredType").value == "2"){
							  errorMessage("委托人不能为团体客户！");
							  return false;
						  }
					  }
					  if(riskCode =='DAX' && strInsureFlag.substr(2,3).indexOf("1")>-1){
						  if(document.getElementById("_insuredType").value != "1"){
							  errorMessage("车主不能为团体客户！");
							  return false;
						  }
						  
					  }
			   		  for(var j=0;j<objTopLen;j++){
			  		  	if(document.getElementById("updateIndex").value == j){// 保存
			  		  		continue;
			  		  	}
			  		  	var insuredFlagEl = document.getElementById("prpCinsureds["+j+"].insuredFlag");
			  		  	if(insuredFlagEl==null){
			  		  		continue;
			  		  	}
			  		  	var flagEl = document.getElementById("prpCinsureds["+j+"].flag");
			  		  	var flagFirstChar = flagEl.value;
			  		  	if(flagEl.value.length>1){
			  		  		flagFirstChar = flagEl.value.substring(0,1);
			  		  	}
			  		    if(isNaN(insuredFlagEl)&&insuredFlagEl!=null){
			  	             if((strInsureFlag.substring(6,7).indexOf("1")>-1) && (insuredFlagEl.value.substring(6,7).indexOf("1")>-1)
			  			         	&&(flagFirstChar!="B" && flagFirstChar!="D")){
			  			           if(((strInsureFlag.substring(6,7)=="0"&&insuredFlagEl.value.substring(6,7)=="1"))||
			  			               ((strInsureFlag.substring(6,7)=="1"&&insuredFlagEl.value.substring(6,7)=="0"))){
			  			           }else{
			  			                errorMessage("请不要重复录入联系人.");
			  						     return false;	           
			  			           }	         	
			  			     }   
			  	             if((strInsureFlag.substring(7,8).indexOf("1")>-1) && (insuredFlagEl.value.substring(7,8).indexOf("1")>-1)
			   			         	&&(flagFirstChar!="B" && flagFirstChar!="D")){
			   			           if(((strInsureFlag.substring(7,8)=="0"&&insuredFlagEl.value.substring(7,8)=="1"))||
			   			               ((strInsureFlag.substring(7,8)=="1"&&insuredFlagEl.value.substring(7,8)=="0"))){
			   			           }else{
			   			                errorMessage("请不要重复录入委托人.");
			   						     return false;	           
			   			           }	         	
			   			     }
			  	             if(riskCode == "DAV" && (strInsureFlag.substring(8,9).indexOf("1")>-1) && (insuredFlagEl.value.substring(24,25).indexOf("1")>-1)
			   			         	&&(flagFirstChar!="B" && flagFirstChar!="D")){
			   			           if(((strInsureFlag.substring(8,9)=="0"&&insuredFlagEl.value.substring(24,25)=="1"))||
			   			               ((strInsureFlag.substring(8,9)=="1"&&insuredFlagEl.value.substring(24,25)=="0"))){
			   			           }else{
			   			                errorMessage("请不要重复录入军属军人.");
			   			                return false; 
			   			           }   	
			   			     }
			  	             if(riskCode == "DAV" && (strInsureFlag.substring(8,9).indexOf("1")>-1) && (insuredFlagEl.value.substring(2,3).indexOf("1")>-1)
			   			         	&&(flagFirstChar!="B" && flagFirstChar!="D")){
			   			           if(((strInsureFlag.substring(8,9)=="0"&&insuredFlagEl.value.substring(2,3)=="1"))||
			   			               ((strInsureFlag.substring(8,9)=="1"&&insuredFlagEl.value.substring(2,3)=="0"))){
			   			           }else{
			   			  		  		var soldierRelationsEL = document.getElementById("prpCinsureds["+j+"].soldierRelations");
			   			  		  		if(soldierRelationsEL != null && soldierRelationsEL.value == 0){
				   			                errorMessage("车主为军人本人，无需录入军属军人信息.");
				   			                return false; 
			   			  		  		}
			   			           }   	
			   			     }
			  	             if(riskCode == "DAV" && (strInsureFlag.substring(2,3).indexOf("1")>-1) && (insuredFlagEl.value.substring(24,25).indexOf("1")>-1)
			   			         	&&(flagFirstChar!="B" && flagFirstChar!="D")){
			   			           if(((strInsureFlag.substring(2,3)=="0"&&insuredFlagEl.value.substring(24,25)=="1"))||
			   			               ((strInsureFlag.substring(2,3)=="1"&&insuredFlagEl.value.substring(24,25)=="0"))){
			   			           }else{
			   			  		  		var soldierRelationsEL = document.getElementById("_soldierRelations");
			   			  		  		if(soldierRelationsEL != null && soldierRelationsEL.value == 0){
			   			  		  			var message = "已经有军属军人信息，车主的与军人关系不能为本人，请核实车主与军属军人的关系.";
			   			  		  			if(document.getElementById('bizType').value == 'ENDORSE'){
			   			  		  				message = "请先删除军属军人信息后再批改车主的与军人关系";
			   			  		  			}
				   			                errorMessage(message);
				   			                return false; 
			   			  		  		}
			   			           }   	
			   			     }
			  		    }
			  		  }
			  		  if((_insuredFlagValue.substr(0,1)+_insuredFlagValue.substr(1,1)+_insuredFlagValue.substr(3,1)).indexOf("1") > -1){
			  		      if(Insured.checkInsureAll(pageCode, field, idx)==false){
			   		           return false;
			   		      }
			  		  }
			       }else{
			    	   if(Insured.checkInsureAll(pageCode, field, idx)==false){
			   		    return false;
			   		}
			       }
				}else{
					//add by LiChenhui;关系人为车主只校验名称;20100802;begin;
					// R27,R440
					var insuredNameEl = document.getElementById("_insuredName");
					if(isEmptyField(insuredNameEl)==true){
				      errorMessage(insuredNameEl.description+"不能为空");
				      insuredNameEl.focus();
				      return false;
			        }
					if(Insured.checkInsureAll(pageCode, field, idx)==false){
			   		    return false;
			   		}
					//add by LiChenhui;关系人为车主只校验名称;20100802;begin;
				        //add by cj 20100916 不能重复录入车主的校验 start	 
					var checkFlag = "0";
					  var strInsureFlag  = "00000000";
					  var obj = document.getElementsByName("_insuredFlag");
					  var objTopLen = parseInt(globalindex[pageCode]);
					
					  for(var i=0;i<obj.length;i++){
					     if(obj[i].checked){
					        checkFlag = "1";
					        strInsureFlag = strInsureFlag.substring(0,i)+"1"+strInsureFlag.substring(i+1);
					     }
					  }
					  for(var j=0;j<objTopLen;j++){
					  	if(document.getElementById("updateIndex").value == j){// 保存
					  		continue;
					  	}
					  	var insuredFlagEl = document.getElementById("prpCinsureds["+j+"].insuredFlag");
					  	if(insuredFlagEl==null){
					  		continue;
					  	}
					  	var flagEl = document.getElementById("prpCinsureds["+j+"].flag");
					  	var flagFirstChar = flagEl.value;
					  	if(flagEl.value.length>1){
					  		flagFirstChar = flagEl.value.substring(0,1);
					  	}
					    if(isNaN(insuredFlagEl)&&insuredFlagEl!=null){
				             if((strInsureFlag.substring(2,3).indexOf("1")>-1) && (insuredFlagEl.value.substring(2,3).indexOf("1")>-1)
						         	&&(flagFirstChar!="B" && flagFirstChar!="D")){
						           if(((strInsureFlag.substring(2,3)=="0"&&insuredFlagEl.value.substring(2,3)=="1"))||
						               ((strInsureFlag.substring(2,3)=="1"&&insuredFlagEl.value.substring(2,3)=="0"))){
						           }else{
						                errorMessage("请不要重复录入车主.");
									     return false;	           
						           }	         	
						     }
			  	             if(riskCode == "DAV" && (strInsureFlag.substring(8,9).indexOf("1")>-1) && (insuredFlagEl.value.substring(24,25).indexOf("1")>-1)
			   			         	&&(flagFirstChar!="B" && flagFirstChar!="D")){
			   			           if(((strInsureFlag.substring(8,9)=="0"&&insuredFlagEl.value.substring(24,25)=="1"))||
			   			               ((strInsureFlag.substring(8,9)=="1"&&insuredFlagEl.value.substring(24,25)=="0"))){
			   			           }else{
			   			                errorMessage("请不要重复录入军属军人.");
			   			                return false; 
			   			           }   	
			   			     }
			  	             if(riskCode == "DAV" && (strInsureFlag.substring(8,9).indexOf("1")>-1) && (insuredFlagEl.value.substring(2,3).indexOf("1")>-1)
			   			         	&&(flagFirstChar!="B" && flagFirstChar!="D")){
			   			           if(((strInsureFlag.substring(8,9)=="0"&&insuredFlagEl.value.substring(2,3)=="1"))||
			   			               ((strInsureFlag.substring(8,9)=="1"&&insuredFlagEl.value.substring(2,3)=="0"))){
			   			           }else{
			   			  		  		var soldierRelationsEL = document.getElementById("prpCinsureds["+j+"].soldierRelations");
			   			  		  		if(soldierRelationsEL != null && soldierRelationsEL.value == 0){
				   			                errorMessage("车主为军人本人，无需录入军属军人信息.");
				   			                return false; 
			   			  		  		}
			   			           }   	
			   			     }
			  	             if(riskCode == "DAV" && (strInsureFlag.substring(2,3).indexOf("1")>-1) && (insuredFlagEl.value.substring(24,25).indexOf("1")>-1)
			   			         	&&(flagFirstChar!="B" && flagFirstChar!="D")){
			   			           if(((strInsureFlag.substring(2,3)=="0"&&insuredFlagEl.value.substring(24,25)=="1"))||
			   			               ((strInsureFlag.substring(2,3)=="1"&&insuredFlagEl.value.substring(24,25)=="0"))){
			   			           }else{
			   			  		  		var soldierRelationsEL = document.getElementById("_soldierRelations");
			   			  		  		if(soldierRelationsEL != null && soldierRelationsEL.value == 0){
			   			  		  			var message = "已经有军属军人信息，车主的与军人关系不能为本人，请核实车主与军属军人的关系.";
			   			  		  			if(document.getElementById('bizType').value == 'ENDORSE'){
			   			  		  				message = "请先删除军属军人信息后再批改车主的与军人关系";
			   			  		  			}
				   			                errorMessage(message);
				   			                return false; 
			   			  		  		}
			   			           }   	
			   			     }
					    }
					  }
					  //add by cj 20100916 不能重复录入车主的校验 end 	
				}
				//end
			    
				var number = 0;
				for(var i = 0 ; i<_insuredFlag.length;i++)
				{
					if(_insuredFlag[i].checked)
					{
						number = number + 1;
					}
				}
				//modify by lujunfeng 20110803  添加指定驾驶人、受益人、港澳车车主、联系人不需要与客户系统交互
				// R31,R439
				if(_insuredFlag[0].checked || _insuredFlag[1].checked || _insuredFlag[2].checked)
				{
					if(document.getElementById("comCode").value.substring(0,2) != "31"){
						if(_insuredFlag[0].checked || _insuredFlag[1].checked){
							
							//mayou 厦门摩托车快速出单自动带出默认值修改  begin
							var MOTORFASTTRACK_i = document.getElementById("MOTORFASTTRACK").value;
							var motorFastTrack_flag_i = document.getElementById("motorFastTrack_flag").value;
							var MOTORFASTTRACK_INSUREDCODE_i = document.getElementById("MOTORFASTTRACK_INSUREDCODE").value;
							if(MOTORFASTTRACK_i == "1" && 
								motorFastTrack_flag_i == "Y" &&
								document.getElementById("_insuredCode").value == MOTORFASTTRACK_INSUREDCODE_i)
								{
									//不做校验
								}
							else{
									if(document.getElementById("_insuredCode").value=="" 
									|| document.getElementById("_insuredCode").readOnly != true )
								{
									errorMessage("关系人必从客户系统带入，请点查询按钮进行查询！");
									return false;
								}
							//mayou 厦门摩托车快速出单自动带出默认值修改  end
							}
						}
					}else{
						if(document.getElementById("_insuredType").value== "2" ){
							var message = "";
							if(_insuredFlag[0].checked){
								message += "[投保人]";
							}
							if(_insuredFlag[1].checked){
								message += "[被保险人]";
							}
							if(_insuredFlag[2].checked){
								message += "[车主]";
							}
								message += "单位性质不能为空！";
							if(trim(document.getElementById("_unitType").value) == ""){
								errorMessage(message);
								return false;
							}
						}
					}
				}
				//DAV要求车主与军属军人必须由客户系统带出
				if(riskCode == "DAV" && (_insuredFlag[2].checked || _insuredFlag[8].checked)){
					if(document.getElementById("_insuredCode").value=="" 
						|| document.getElementById("_insuredCode").readOnly != true ){
						errorMessage("关系人必从客户系统带入，请点查询按钮进行查询！");
						return false;
					}
				}
				
				//DAX要求车主必须由客户系统带出
				if(riskCode == "DAX" && (_insuredFlag[2].checked)){
					if(document.getElementById("_insuredCode").value=="" 
						|| document.getElementById("_insuredCode").readOnly != true ){
						errorMessage("关系人必从客户系统带入，请点查询按钮进行查询！");
						return false;
					}
				}
				if(comCodeTemp.substring(0,2) == "32" && _insuredFlag[2].checked){
					if(document.getElementById("_insuredCode").value=="" 
						|| document.getElementById("_insuredCode").readOnly != true ){
						errorMessage("关系人必从客户系统带入，请点查询按钮进行查询！");
						return false;
					}
				}
				if(_insuredFlag[0].checked) {
					if(trim(document.getElementById("_countryCode").value) == ""){
						errorMessage("投保人国籍不能为空，请重查客户信息");
					    if(document.getElementById('bizType').value != 'ENDORSE'){
					    	return false;
 					    }
					}
				}
				
				//R540 同一个号码作为被保险人的移动电话号在自然年（本年1月1日至当前日期）内最多投保的次数
			    var DAGMobilePhoneNum = document.getElementById("DAGMobilePhoneNum");
			    var mobile = document.getElementById("_mobile");
			    if(riskCode=="DAG" &&  _insuredFlagValue.substring(1, 2)=='1' 
			    	&& mobile.value!="" && DAGMobilePhoneNum!=null && trim(DAGMobilePhoneNum.value)!=""){
					var callback = {
						/**
						 * @private
						 */
			    		success:function (res) {
							var phoneNum = YAHOO.lang.JSON.parse(res.responseText).msg;
							if(parseInt(phoneNum) > parseInt(DAGMobilePhoneNum.value)-1){
								var messeage = "此手机号本年度内已经"+phoneNum+"次被用于被保险人移动电话了，不允许再次使用！"
								alert(messeage);
								return;
							}
							Insured.insuredAdd(pageCode, field, index, _insuredFlagValue,_insuredFlagText);
			    		},
			    		/**
						 * @private
						 */
			    		failure:function (res) {
			    			errorMessage("");
			    			return false;
			    		}
					};
					var strURL = "/prpall/business/getDAGMobilePhoneNum.do?mobile="+mobile.value;
					var transaction = YAHOO.util.Connect.asyncRequest('POST',strURL, callback); 
			    }else{
				    /*if(!Insured.checkInsureOwn(pageCode)){
				    	return false;
				    }*/
			    	Insured.insuredAdd(pageCode, field, index, _insuredFlagValue,_insuredFlagText);
			    }
			    //该方法弃用改由ilog自动带出
			    /*if(isNaN(document.getElementById("iniPrpCengage_Flag")) && document.getElementById("iniPrpCengage_Flag") != null
						  && document.getElementById("iniPrpCengage_Flag").value == "1"){
					  Engage.insertEngageDevice();
				}*/
			   
			},
			/**
			 * @author sinosoft
			 * @description 关系人添加方法(内部)
			 * @param pageCode
			 * @param field
			 * @param index
			 * @param _insuredFlagValue
			 * @param _insuredFlagText
			 * @return
			 */
			insuredAdd : function(pageCode, field, index, _insuredFlagValue,_insuredFlagText){
	    		var IDCARD_SHIELD = document.getElementById("IDCARD_SHIELD");
				var _insuredType = document.getElementById("_insuredType").value;
				var _insuredName = document.getElementById("_insuredName").value;
				var riskCode = document.getElementById('riskCode').value;
				var comCode = document.getElementById('comCode').value;
				document.getElementById("_insuredName").value = "";
				var el_unitType = document.getElementById("_unitType"); 
				var _unitType = "";
				var unitTypeText = "";
				var electronicPolicyFlag = document.getElementById("electronicPolicyFlag");
				if(el_unitType.value != ""){
					_unitType = el_unitType.value;
					unitTypeText = el_unitType.options[el_unitType.selectedIndex].text;
				}
				//modify by zhaoxiaojie 20100804 类型为个人的时候将单位性质置空 begin
				if(_insuredType == "1"){
					_unitType = "";
					unitTypeText = "";
				}
				//modify by zhaoxiaojie 20100804 类型为个人的时候将单位性质置空 end
				Insured.changeTypeClearCrossInfo();//清除交叉销售信息
				Insured.changeCodeClearDemandNo();//上平台地区改变被保险人代码清空投保查询码
				//厦门上门投保业务，被保险人改变时要清空保费
			    var bizType = document.getElementById('bizType').value;
			    if(bizType != 'ENDORSE'){
			    	Insured.checkClearSumPremiumByCondition();
			    }
				//是否勾选直升机险
				var haveUFJ = false;
				var chooseFlag=document.getElementById("prpUitemKindVos[0].chooseFlag");
				if(chooseFlag!=undefined && chooseFlag!=null && chooseFlag.checked){
					haveUFJ = true;
				}
				if(haveUFJ){
					var downflag = false;
					if(_insuredFlagValue.substring(1,2) == "1"){
						downflag = true;
					}
					var insuredTab = document.getElementById("insertInsuredRow");
					var insuredTbody = insuredTab.tBodies.item(0);
					var insuredRow = insuredTbody.rows;
					for(var j = 0; j < insuredRow.length; j++){
						var eles = insuredRow[j].all;
						for(var k = 0 ; k < eles.length ; k++){
							var eleName = eles[k].name || eles[k].id || "";
							if(eleName.indexOf("insuredFlag") > -1){
								if(eles[k].value.substring(1,2)=="1"){
									var index = eleName.substring(eleName.indexOf("[")+1, eleName.indexOf("]"));
									var upInsuredType = document.getElementById("prpCinsureds["+index+"].insuredType");
									if(downflag && upInsuredType!=null && upInsuredType.value=="1" && _insuredType=="2"){
										//由个人改为团体
					    				alert("此操作将导致删除直升机救援险信息");
					    				chooseFlag.checked=false;
										document.getElementById("itemKindUnitedSaletd").style.display="none";
										document.getElementById("itemKindUnitedSaletr").style.display="none";
						    			var bloodType = document.getElementById("prpUitemKindVos[0].bloodType");
						    			var bloodTypeDesc = document.getElementById("BloodTypeDesc[0]");
					    				if(bloodType!=null){
					    					bloodType.value ="";
					    				}
					    				if(bloodTypeDesc!=null){
					    					bloodTypeDesc.value ="";
					    				}
									}
									if(downflag && upInsuredType!=null && upInsuredType.value=="1" && _insuredType=="1"){
										//修改被保险人（被保险人类型未发生变化，仍为个人）
						    			var bloodType = document.getElementById("prpUitemKindVos[0].bloodType");
						    			var bloodTypeDesc = document.getElementById("BloodTypeDesc[0]");
					    				if(bloodType!=null){
					    					bloodType.value ="";
					    				}
					    				if(bloodTypeDesc!=null){
					    					bloodTypeDesc.value ="";
					    				}
									}
								}
								break;
							}
						}
					}
				}
			    //处理insuredFlag和居民非居民字段
			    var _resident = document.getElementById("_resident").value;
			    _insuredFlagValue = Insured.dealInsuredFlagResident(_insuredFlagValue, _resident);
			    document.getElementById("_resident").value = "";
				var _insuredCode = document.getElementById("_insuredCode").value;
				document.getElementById("_insuredCode").value = "";
				var _identifyType = document.getElementById("_identifyType").value;
				var _identifyNumber = document.getElementById("_identifyNumber").value;
				document.getElementById("_identifyNumber").value = "";
				if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1" && document.getElementById("_identifyType").value =="01"){
					if(document.getElementById("_identifyNumber1") != null){
						var _identifyNumber1 = document.getElementById("_identifyNumber1").value;
					}
					if(document.getElementById("_drivingLicenseNoLSJ") != null){
						var _drivingLicenseNoLSJ = document.getElementById("_drivingLicenseNoLSJ").value;
						document.getElementById("_drivingLicenseNoLSJ").value = "";
					}
				}
				var _drivingYears = document.getElementById("_drivingYears").value;
				document.getElementById("_drivingYears").value = "";
				var _insuredAddress = document.getElementById("_insuredAddress").value;
				document.getElementById("_insuredAddress").value = "";
				//北分电子保单个性
				if((riskCode == "DAA" || riskCode == "DAV") && electronicPolicyFlag != null && (comCode.substring(0,2)=="11" 
					|| electronicPolicyFlag.value == "1" || (electronicPolicyFlag.value == "2" && comCode.substring(0,2)=="36"  ))){
					var _email = document.getElementById("_email").value;
					document.getElementById("_email").value = "";
				}
				var _phoneNumber = document.getElementById("_phoneNumber").value;
				var _phoneNumber1 = document.getElementById("_phoneNumber1").value;
				document.getElementById("_phoneNumber").value = "";
				var _mobile = document.getElementById("_mobile").value;
				var _mobile1 = document.getElementById("_mobile1").value;
				document.getElementById("_mobile").value = "";
				var _postCode = document.getElementById("_postCode").value;
				document.getElementById("_postCode").value = "";
				var _unifiedSocialCreditCode = document.getElementById("_unifiedSocialCreditCode").value;
				document.getElementById("_unifiedSocialCreditCode").value="";
				var _countryCode = document.getElementById("_countryCode").value;
				var _age = document.getElementById("_age").value;
				document.getElementById("_age").value = "";
				var _drivingLicenseNo = document.getElementById("_drivingLicenseNo").value;
				document.getElementById("_drivingLicenseNo").value = "";
				document.getElementById("drivingLicenseNo").style.display = "none";
				document.getElementById("drivingLicenseNoValue").style.display = "none";
				if(document.getElementById("drivingLicenseNo1")!=null){
					document.getElementById("drivingLicenseNo1").style.display = "";
				}
				var _sex = document.getElementById("_sex").value;
				var _drivingCarType = document.getElementById("_drivingCarType").value;
				document.getElementById("_drivingCarType").value = "";
				//modify by sangjianjun;准驾车型只有在指定驾驶人才显示  20100728 begin
				document.getElementById("drivingCarType").style.display = "none";
				document.getElementById("drivingCarTypeValue").style.display = "none";
				
				//modify by sangjianjun;准驾车型只有在指定驾驶人才显示  20100728 end
				
				//modify by lujunfeng 指定驾驶人时显示上年违章次数和初次领证日期
				var _causetroubleTimes = document.getElementById("_causetroubleTimes").value;
				var _acceptLicenseDate = document.getElementById("_acceptLicenseDate").value;
				//是否普惠融资带动客户
				var _isFinanceCustomer = "";
				if(document.getElementById("_isFinanceCustomer")!=null){
					_isFinanceCustomer = document.getElementById("_isFinanceCustomer").value;
				}
				var _financeFlag = "";
				if(document.getElementById("financeFlag")!=null){
			        _financeFlag = document.getElementById("financeFlag").value;
				}
				var _taxPayerNumber = document.getElementById("_taxPayerNumber").value;
				if(riskCode == "DAV"){
					var _soldierRelations = document.getElementById("_soldierRelations").value;
					var _soldierIdentifyType = document.getElementById("_soldierIdentifyType").value;
					var _soldierIdentifyNumber = document.getElementById("_soldierIdentifyNumber").value;
					Insured.clearSoldierInput();
					document.getElementById("soldierRelations").style.display = "none";
					document.getElementById("soldierRelationsValue").style.display = "none";
					document.getElementById("soldierIdentifyType").style.display = "none";
					document.getElementById("soldierIdentifyTypeValue").style.display = "none";
					document.getElementById("soldierIdentifyNumber").style.display = "none";
					document.getElementById("soldierIdentifyNumberValue").style.display = "none";
				}
				document.getElementById("_causetroubleTimes").value = "";
				document.getElementById("_acceptLicenseDate").value = "";
				if(document.getElementById("_isFinanceCustomer")!=null){
			        while(document.all("_isFinanceCustomer").options.length>0){
			        	document.all("_isFinanceCustomer").options.remove(0);
			        }
			        document.getElementById("_isFinanceCustomer").options.add(new Option("否","3"));
			        document.getElementById("_isFinanceCustomer").options.add(new Option("普惠融资间接带动","2"));
			        document.getElementById("_isFinanceCustomer").options.add(new Option("普惠融资直接带动","1"));
				}
				document.getElementById("disType").style.display = "none";
				document.getElementById("causetroubleTimesType").style.display = "none";
				document.getElementById("causetroubleTimesValue").style.display = "none";
				document.getElementById("acceptLicenseDateType").style.display = "none";
				document.getElementById("acceptLicenseDateValue").style.display = "none";
					
				document.getElementById("CarKindLicense").value = "";
				var _appendPrintName = document.getElementById("_appendPrintName").value;
				document.getElementById("_appendPrintName").value = "";
				//modify by cj 20100730 版本号和审批状态的显示和存储 start
				var _auditStatus = document.getElementById("_auditStatus").value;
				document.getElementById("_auditStatus").value = "";
				document.getElementById("_auditStatusDes").value = "";
				document.getElementById("_insuredCode").value = "";
				var _versionNo = document.getElementById("_versionNo").value;
				document.getElementById("_versionNo").value = "";
				var group_code = document.getElementById("group_code").value;
				document.getElementById("group_code").value = "";
				//modify by cj 20100730 版本号和审批状态的显示和存储 end
			    //document.getElementById("_insuredCode").readOnly = false;
				var select_insuredType = document.getElementById("_insuredType");
				var select_identifyType = document.getElementById("_identifyType");
				var iinsuredType = "";
				if(select_insuredType.value!=""){
					iinsuredType = select_insuredType.options[select_insuredType.selectedIndex].text;
				}
				var iidentifyType = "";
				if(select_identifyType.value!=""){
				    iidentifyType = select_identifyType.options[select_identifyType.selectedIndex].text;
				}
				// 将数据更新至显示列表
				document.getElementById("prpCmainCommon.ext2").value = group_code;

				if(document.getElementById("updateIndex").value < 0){// 保存
					// 列表区显示数据
					document.getElementById("iinsuredFlag").value = _insuredFlagText;
					document.getElementById("iinsuredType").value = iinsuredType;
					document.getElementById("iinsuredName").value = _insuredName;
					document.getElementById("iinsuredCode").value = _insuredCode;
					document.getElementById("iunitType").value = unitTypeText;
					document.getElementById("iidentifyNumber").value = _identifyNumber;
					document.getElementById("iinsuredAddress").value = _insuredAddress;
					//北分电子保单个性
					if((riskCode == "DAA" || riskCode == "DAV") && electronicPolicyFlag != null && (
							comCode.substring(0,2)=="11" || (electronicPolicyFlag.value == "2" && comCode.substring(0,2)=="36" )
								|| electronicPolicyFlag.value == "1")){
						document.getElementById("iemail").value = _email;
					}
					document.getElementById("iphoneNumber").value = _phoneNumber1;
					document.getElementById("imobile").value = _mobile1;
					//modify by cj 20100730 版本号和审批状态的显示和存储 start
					document.getElementById("iauditStatus").value = _auditStatus;
					document.getElementById("iversionNo").value = _versionNo;
					if(comCode.substring(0,2)=="11"){
						document.getElementById("iidentifyNumber").style.display="";
						if(document.getElementById("showIdentfynumber")!=null){
							document.getElementById("showIdentfynumber").style.display="none";
							document.getElementById("showIdentfynumber").value="";
						}
					}
					if(select_insuredType.value=="2"  && comCode.substring(0,2)=="11"){
						//北分,类型团体
						//_identifyNumber（组织机构代码） _unifiedSocialCreditCode（统一社会信用码）客户代码（_insuredCode）
						if(_identifyNumber==null  || _identifyNumber ==""){
							if(_unifiedSocialCreditCode==null ||_unifiedSocialCreditCode==""){
								//组织机构代码和统一社会代码同时为空iidentifyType
								//证件类型显示“组织机构代码”，证件号码显示“客户代码”后九位，
								document.getElementById("iidentifyType").value="组织机构代码证";
								document.getElementById("prpCinsureds_[0].identifyType").value="31";
								
								document.getElementById("iidentifyNumber").style.display="none";
							    if(document.getElementById("showIdentfynumber")!=null){
							    	document.getElementById("showIdentfynumber").style.display="";
									document.getElementById("showIdentfynumber").value=_insuredCode.substring(trim(_insuredCode).length-9,trim(_insuredCode).length);
							    }
								
							}else{
								//只存在统一社会代码
								//证件类型显示“工商注册号码”，证件号码显示“统一社会信用代码”，
								document.getElementById("iidentifyType").value="工商注册号码";
								document.getElementById("prpCinsureds_[0].identifyType").value="11";
								document.getElementById("iidentifyNumber").style.display="none";
								if(document.getElementById("showIdentfynumber")!=null){
									document.getElementById("showIdentfynumber").style.display="";
									document.getElementById("showIdentfynumber").value =_unifiedSocialCreditCode;
								}
								
							}
						}else{
							document.getElementById("iidentifyType").value = iidentifyType;//北分特殊处理
//							document.getElementById("iidentifyNumber").value = _identifyNumber;//北分团体特殊处理
							document.getElementById("prpCinsureds_[0].identifyType").value = _identifyType;//北分团体特殊处理
//							document.getElementById("prpCinsureds_[0].identifyNumber").value = _identifyNumber;//北分团体特殊处理
						}
					}else {
						document.getElementById("iidentifyType").value = iidentifyType;//北分特殊处理
//						document.getElementById("iidentifyNumber").value = _identifyNumber;//北分团体特殊处理
						document.getElementById("prpCinsureds_[0].identifyType").value = _identifyType;//北分团体特殊处理
//						document.getElementById("prpCinsureds_[0].identifyNumber").value = _identifyNumber;//北分团体特殊处理
					}
					//modify by cj 20100730 版本号和审批状态的显示和存储 end
					// 列表区隐含域数据iidentifyType  prpCinsureds_[0].identifyType   iidentifyNumber
					document.getElementById("prpCinsureds_[0].insuredFlag").value = _insuredFlagValue;
					document.getElementById("prpCinsureds_[0].insuredType").value = _insuredType;
					document.getElementById("prpCinsureds_[0].taxPayerNumber").value = _taxPayerNumber;
					//document.getElementById("prpCinsureds_[0].insuredNature").value = _insuredType;
					document.getElementById("prpCinsureds_[0].insuredCode").value = _insuredCode;
					document.getElementById("prpCinsureds_[0].insuredName").value = _insuredName;
					document.getElementById("prpCinsureds_[0].unitType").value = _unitType;
					if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1" && document.getElementById("_identifyType").value == "01"){
						document.getElementById("prpCinsureds_[0].identifyNumber").value = _identifyNumber1;
						document.getElementById("identifyNumber_[0]").value = _identifyNumber;
						if(_drivingLicenseNoLSJ != ""){
							document.getElementById("prpCinsureds_[0].drivingLicenseNo").value = _drivingLicenseNoLSJ;
							document.getElementById("drivingLicenseNo_[0]").value = _drivingLicenseNo; 
						}
					}else{
						document.getElementById("prpCinsureds_[0].identifyNumber").value = _identifyNumber;
						document.getElementById("identifyNumber_[0]").value = _identifyNumber;
						document.getElementById("prpCinsureds_[0].drivingLicenseNo").value = _drivingLicenseNo; 
					}
					document.getElementById("prpCinsureds_[0].drivingYears").value = _drivingYears;
					document.getElementById("prpCinsureds_[0].insuredAddress").value = _insuredAddress;
					//北分电子保单个性
					if((riskCode == "DAA" || riskCode == "DAV") && electronicPolicyFlag != null && (
							comCode.substring(0,2)=="11" || (electronicPolicyFlag.value == "2" && comCode.substring(0,2)=="36" )
							|| electronicPolicyFlag.value == "1")){
						document.getElementById("prpCinsureds_[0].email").value = _email;
					}
					document.getElementById("prpCinsureds_[0].phoneNumber").value = _phoneNumber;
					document.getElementById("prpCinsureds_[0].mobile").value = _mobile;
					document.getElementById("prpCinsureds_[0].postCode").value = _postCode;
					document.getElementById("prpCinsureds_[0].unifiedSocialCreditCode").value = _unifiedSocialCreditCode;
					//modify by cj 20100730 版本号和审批状态的显示和存储 start
					document.getElementById("prpCinsureds_[0].auditStatus").value = _auditStatus;
					document.getElementById("prpCinsureds_[0].versionNo").value = _versionNo;
					//modify by cj 20100730 版本号和审批状态的显示和存储 end
					document.getElementById("prpCinsureds_[0].sex").value = _sex;
					document.getElementById("prpCinsureds_[0].countryCode").value = _countryCode;
					document.getElementById("prpCinsureds_[0].age").value = _age;
					document.getElementById("prpCinsureds_[0].drivingCarType").value = _drivingCarType;
					document.getElementById("prpCinsureds_[0].appendPrintName").value = _appendPrintName; 
					//add by lujunfeng 20110803 指定驾驶人时显示上年违章次数和初次领证日期
					document.getElementById("prpCinsureds_[0].causetroubleTimes").value = _causetroubleTimes;
					document.getElementById("prpCinsureds_[0].acceptLicenseDate").value = _acceptLicenseDate;
					//是否普惠融资带动客户的显示和存储
					if(document.getElementById("prpCinsureds_[0].isFinanceCustomer")!=null){
						document.getElementById("prpCinsureds_[0].isFinanceCustomer").value = _isFinanceCustomer;
					}
					if(document.getElementById("financeFlag_[0]")!=null){
						document.getElementById("financeFlag_[0]").value = _financeFlag;
					}

					if(riskCode == "DAV"){
						if(_insuredFlagValue.substring(2,3) == "1" || _insuredFlagValue.substring(24,25) == "1"){
							if(_insuredFlagValue.substring(2,3) == "1"){
								document.getElementById("prpCinsureds_[0].soldierRelations").value = _soldierRelations;
							}else if(_insuredFlagValue.substring(24,25) == "1"){
								document.getElementById("prpCinsureds_[0].soldierRelations").value=0;
							}else{
								document.getElementById("prpCinsureds_[0].soldierRelations").value="";
							}
							document.getElementById("prpCinsureds_[0].soldierIdentifyType").value = _soldierIdentifyType;
							document.getElementById("prpCinsureds_[0].soldierIdentifyNumber").value = _soldierIdentifyNumber;
						}
					}
					document.getElementById("_phoneNumber1").value = "";
					document.getElementById("_mobile1").value = ""; 
					if(document.getElementById("_identifyNumber1") != null){
						document.getElementById("_identifyNumber1").value = ""; 
					}
					//北分身份证信息采集隐藏域赋值
					if(comCode.substring(0,2) == "11" && riskCode == "DAA"
						&& (_insuredFlagValue.substring(0,1) == "1" || _insuredFlagValue.substring(1,2) == "1")){
						var flag1 = document.getElementById("idCardCheckInfo.flag");
						if(null != flag1 && (flag1.value == "1" || flag1.value == "2")){
							var idcardCode = document.getElementById("idCardCheckInfo.idcardCode").value;//身份证号
							var name = document.getElementById("idCardCheckInfo.name").value;//姓名
							var nation = document.getElementById("idCardCheckInfo.nation").value;//民族
							var birthday = document.getElementById("idCardCheckInfo.birthday").value;//出生日期
							var sex = document.getElementById("idCardCheckInfo.sex").value;//性别
							var address = document.getElementById("idCardCheckInfo.address").value;//住址
							var ISSUER = document.getElementById("idCardCheckInfo.issure").value;//签发机构
							var validStartDate = document.getElementById("idCardCheckInfo.validStartDate").value;//身份证号码有效开始时间
							var validEndDate = document.getElementById("idCardCheckInfo.validEndDate").value;//身份证号码有效结束时间
							var SAMCode = document.getElementById("idCardCheckInfo.samCode").value;//身份证采集器编码
							var SAMType = document.getElementById("idCardCheckInfo.samType").value;//采集设备类型
							var flag = document.getElementById("idCardCheckInfo.flag").value;
							
							document.getElementById("idCardCheckInfo_[0].idcardCode").value = idcardCode;//身份证号
							document.getElementById("idCardCheckInfo_[0].name").value = name;//姓名
							document.getElementById("idCardCheckInfo_[0].nation").value = nation;//民族
							document.getElementById("idCardCheckInfo_[0].birthday").value = birthday;//出生日期
							document.getElementById("idCardCheckInfo_[0].sex").value = sex;//性别
							document.getElementById("idCardCheckInfo_[0].address").value = address;//住址
							document.getElementById("idCardCheckInfo_[0].issure").value = ISSUER;//签发机构
							document.getElementById("idCardCheckInfo_[0].validStartDate").value = validStartDate;//身份证号码有效开始时间
							document.getElementById("idCardCheckInfo_[0].validEndDate").value = validEndDate;//身份证号码有效结束时间
							document.getElementById("idCardCheckInfo_[0].samCode").value = SAMCode;//身份证采集器编码
							document.getElementById("idCardCheckInfo_[0].samType").value = SAMType;//采集设备类型
							document.getElementById("idCardCheckInfo_[0].flag").value = flag;
							document.getElementById("idCardCheckInfo_[0].insuredcode").value = _insuredCode;
							document.getElementById("idCardCheckInfo_[0].insuredFlag").value = _insuredFlagValue.substring(0,2);
							document.getElementById("idCardCheckInfo_[0].mobile").value = _mobile;
							
							document.getElementById("idCardCheckInfo.idcardCode").value = "";
							document.getElementById("idCardCheckInfo.name").value = "";
							document.getElementById("idCardCheckInfo.nation").value = "";
							document.getElementById("idCardCheckInfo.birthday").value = "";
							document.getElementById("idCardCheckInfo.sex").value = "";
							document.getElementById("idCardCheckInfo.address").value = "";
							document.getElementById("idCardCheckInfo.issure").value = "";
							document.getElementById("idCardCheckInfo.validStartDate").value = "";
							document.getElementById("idCardCheckInfo.validEndDate").value = "";
							document.getElementById("idCardCheckInfo.samCode").value = "";
							document.getElementById("idCardCheckInfo.samType").value = "";
							document.getElementById("idCardCheckInfo.flag").value = "";
						}
					}
					insertRowForStruts2(pageCode, field, index);
					if(comCode.substring(0,2) == "11" && riskCode == "DAA" && (_insuredFlagValue.substring(0,1) == "1" || _insuredFlagValue.substring(1,2) == "1")){
						document.getElementById("idCardCheckInfo_[0].idcardCode").value = "";//身份证号
						document.getElementById("idCardCheckInfo_[0].name").value = "";//姓名
						document.getElementById("idCardCheckInfo_[0].nation").value = "";//民族
						document.getElementById("idCardCheckInfo_[0].birthday").value = "";//出生日期
						document.getElementById("idCardCheckInfo_[0].sex").value = "";//性别
						document.getElementById("idCardCheckInfo_[0].address").value = "";//住址
						document.getElementById("idCardCheckInfo_[0].issure").value = "";//签发机构
						document.getElementById("idCardCheckInfo_[0].validStartDate").value = "";//身份证号码有效开始时间
						document.getElementById("idCardCheckInfo_[0].validEndDate").value = "";//身份证号码有效结束时间
						document.getElementById("idCardCheckInfo_[0].samCode").value = "";//身份证采集器编码
						document.getElementById("idCardCheckInfo_[0].samType").value = "";//采集设备类型
						document.getElementById("idCardCheckInfo_[0].flag").value = "0";
						document.getElementById("idCardCheckInfo_[0].insuredcode").value = "";
						document.getElementById("idCardCheckInfo_[0].insuredFlag").value = "";
						document.getElementById("idCardCheckInfo_[0].mobile").value = "";
						
					}
				}else{// 修改保存
					var updateIndex = document.getElementById("updateIndex").value;
					var insuredFlag = document.getElementById("prpCinsureds["+ updateIndex +"].insuredFlag");
					var insuredType = document.getElementById("prpCinsureds["+ updateIndex +"].insuredType");
					var insuredCode = document.getElementById("prpCinsureds["+ updateIndex +"].insuredCode");
					var insuredName = document.getElementById("prpCinsureds["+ updateIndex +"].insuredName");
					var unitType = document.getElementById("prpCinsureds["+ updateIndex +"].unitType");
					var identifyType = document.getElementById("prpCinsureds["+ updateIndex +"].identifyType");
					var identifyNumber = document.getElementById("prpCinsureds["+ updateIndex +"].identifyNumber");
					var drivingYears = document.getElementById("prpCinsureds["+ updateIndex +"].drivingYears");
					var insuredAddress = document.getElementById("prpCinsureds["+ updateIndex +"].insuredAddress");
					//北分电子保单个性
					if((riskCode == "DAA" || riskCode == "DAV") && electronicPolicyFlag != null && (
							comCode.substring(0,2)=="11" || (electronicPolicyFlag.value == "2" && comCode.substring(0,2)=="36" )
							|| electronicPolicyFlag.value == "1")){
						var email = document.getElementById("prpCinsureds["+ updateIndex +"].email");
					}
					var phoneNumber = document.getElementById("prpCinsureds["+ updateIndex +"].phoneNumber");
					var mobile = document.getElementById("prpCinsureds["+ updateIndex +"].mobile");
					var postCode = document.getElementById("prpCinsureds["+ updateIndex +"].postCode");
					var auditStatus = document.getElementById("prpCinsureds["+ updateIndex +"].auditStatus");
					var versionNo = document.getElementById("prpCinsureds["+ updateIndex +"].versionNo");
					var sex = document.getElementById("prpCinsureds["+ updateIndex +"].sex");
					var countryCode = document.getElementById("prpCinsureds["+ updateIndex +"].countryCode");
					var age = document.getElementById("prpCinsureds["+ updateIndex +"].age");
					var drivingLicenseNo = document.getElementById("prpCinsureds["+ updateIndex +"].drivingLicenseNo");
					var drivingCarType = document.getElementById("prpCinsureds["+ updateIndex +"].drivingCarType");
					var appendPrintName = document.getElementById("prpCinsureds["+ updateIndex +"].appendPrintName");
					//add by lujunfeng 20110803 指定驾驶人时显示上年违章次数和初次领证日期
					var causetroubleTimes = document.getElementById("prpCinsureds["+ updateIndex +"].causetroubleTimes");
					var acceptLicenseDate = document.getElementById("prpCinsureds["+ updateIndex +"].acceptLicenseDate");
					var isFinanceCustomer = document.getElementById("prpCinsureds["+ updateIndex +"].isFinanceCustomer");
					var financeFlag = document.getElementById("financeFlag["+ updateIndex +"]");
					var unifiedSocialCreditCode = document.getElementById("prpCinsureds["+ updateIndex +"].unifiedSocialCreditCode");
					document.getElementById("prpCinsureds["+ updateIndex +"].taxPayerNumber").value=_taxPayerNumber;
					if(comCode.substring(0,2)=="11"){
						document.getElementById("iidentifyNumber").style.display="";
						document.getElementById("showIdentfynumber").style.display="none";
						document.getElementById("showIdentfynumber").value="";
						if(document.getElementById("prpCinsureds["+ updateIndex +"].identifyNumber")!=null ){
							document.getElementById("prpCinsureds["+ updateIndex +"].identifyNumber").style.display="";
						}
						if(document.getElementById("show["+ updateIndex +"]Identfynumber")!=null){
							document.getElementById("show["+ updateIndex +"]Identfynumber").style.display="none";
							document.getElementById("show["+ updateIndex +"]Identfynumber").value="";
						}
					}
					if(riskCode == "DAV"){
						var soldierRelations = document.getElementById("prpCinsureds["+ updateIndex +"].soldierRelations");
						var soldierIdentifyType = document.getElementById("prpCinsureds["+ updateIndex +"].soldierIdentifyType");
						var soldierIdentifyNumber = document.getElementById("prpCinsureds["+ updateIndex +"].soldierIdentifyNumber");
					}
					insuredFlag.value = _insuredFlagValue;
					insuredType.value = _insuredType;
					//document.getElementById("prpCinsureds["+ updateIndex +"].insuredNature").value = _insuredType;
					insuredCode.value = _insuredCode;
					insuredName.value = _insuredName;
					unitType.value = _unitType;
//					identifyType.value = _identifyType;//北分团体特殊处理
					if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1" && document.getElementById("_identifyType").value =="01"){
						identifyNumber.value = _identifyNumber1;
						if(document.getElementById("identifyNumber["+ updateIndex +"]") != null){
							document.getElementById("identifyNumber["+ updateIndex +"]").value = _identifyNumber; 
						}
						if(_drivingLicenseNoLSJ != ""){
							drivingLicenseNo.value = _drivingLicenseNoLSJ;
							if(document.getElementById("drivingLicenseNo["+ updateIndex +"]") != null){
								document.getElementById("drivingLicenseNo["+ updateIndex +"]").value = _drivingLicenseNo; 
							}
						}
					}else{
						identifyNumber.value = _identifyNumber;//北分团体特殊处理
						drivingLicenseNo.value = _drivingLicenseNo;
					}
					drivingYears.value = _drivingYears;
					insuredAddress.value = _insuredAddress;
					unifiedSocialCreditCode.value=_unifiedSocialCreditCode;
					if(riskCode == "DAV"){
						if(_insuredFlagValue.substring(2,3) == "1" || _insuredFlagValue.substring(24,25) == "1"){
							if(_insuredFlagValue.substring(2,3) == "1"){
								soldierRelations.value = _soldierRelations;
							}else if(_insuredFlagValue.substring(24,25) == "1"){
								soldierRelations.value="0";
							}else{
								soldierRelations.value="";
							}
							if((_insuredFlagValue.substring(2,3) == "1" && _soldierRelations == 0) || _insuredFlagValue.substring(24,25) == "1"){
								soldierIdentifyType.value = _soldierIdentifyType;
								soldierIdentifyNumber.value = _soldierIdentifyNumber;
							}
						}
					}
					//北分电子保单个性
					if((riskCode == "DAA" || riskCode == "DAV") && electronicPolicyFlag != null && (
							comCode.substring(0,2)=="11" || electronicPolicyFlag.value == "1" || 
							(electronicPolicyFlag.value == "2" &&  comCode.substring(0,2)=="36"))){
						email.value = _email;
					}
					phoneNumber.value = _phoneNumber;
					mobile.value = _mobile;
					postCode.value = _postCode;
					//modify by cj 20100730 版本号和审批状态的显示和存储 start
					auditStatus.value = _auditStatus;
					versionNo.value = _versionNo;
					//modify by cj 20100730 版本号和审批状态的显示和存储 end
					sex.value = _sex;
					countryCode.value = _countryCode;
					age.value = _age;
					drivingCarType.value = _drivingCarType;
					appendPrintName.value = _appendPrintName;
					//add by lujunfeng 20110803 指定驾驶人时显示上年违章次数和初次领证日期
					causetroubleTimes.value = _causetroubleTimes;
					acceptLicenseDate.value = _acceptLicenseDate;
					//是否普惠融资带动客户的显示和存储 start
					if(isFinanceCustomer!=null){
						isFinanceCustomer.value = _isFinanceCustomer;
					}
					if(financeFlag!=null){
						financeFlag.value = _financeFlag;
					}
                    //是否普惠融资带动客户的显示和存储 end
					var tr = insuredFlag.parentElement.parentElement;
					//列表的显示字段（没有下标）
					tr.cells[0].all[1].value = _insuredFlagText;
					tr.cells[1].all[0].value = iinsuredType;
					tr.cells[2].all[0].value = _insuredCode;
					tr.cells[2].all[1].value = _insuredName;
					tr.cells[3].all[0].value = unitTypeText;
					tr.cells[4].all[0].value = iidentifyType;
					tr.cells[5].all[0].value = _identifyNumber;
					tr.cells[6].all[0].value = _insuredAddress;
					if(select_insuredType.value=="2"  && comCode.substring(0,2)=="11"){
						//北分,类型团体
						//_identifyNumber（组织机构代码） _unifiedSocialCreditCode（统一社会信用码）客户代码（_insuredCode）
						if(_identifyNumber==null  || _identifyNumber ==""){
							if(_unifiedSocialCreditCode==null ||_unifiedSocialCreditCode==""){
								//组织机构代码和统一社会代码同时为空iidentifyType
//								iidentifyType  prpCinsureds_[0].identifyType   iidentifyNumber
//								prpCinsureds_[0].identifyNumber
								//证件类型显示“组织机构代码”，证件号码显示“客户代码”后九位，
								tr.cells[4].all[0].value="组织机构代码证";
								identifyType.value ="31";
								document.getElementById("iidentifyNumber").style.display="none";
								document.getElementById("showIdentfynumber").style.display="";
								document.getElementById("showIdentfynumber").value=_insuredCode.substring(trim(_insuredCode).length-9,trim(_insuredCode).length);
								if(document.getElementById("prpCinsureds["+ updateIndex +"].identifyNumber")!=null){
									document.getElementById("prpCinsureds["+ updateIndex +"].identifyNumber").style.display="none";
								}
								if(document.getElementById("show["+ updateIndex +"]Identfynumber")!=null){
									document.getElementById("show["+ updateIndex +"]Identfynumber").style.display="";
									document.getElementById("show["+ updateIndex +"]Identfynumber").value=_insuredCode.substring(trim(_insuredCode).length-9,trim(_insuredCode).length);					
								}
							}else{
								//只存在统一社会代码
								//证件类型显示“工商注册号码”，证件号码显示“统一社会信用代码”，
								tr.cells[4].all[0].value="工商注册号码";
								identifyType.value ="11";
								document.getElementById("iidentifyNumber").style.display="none";
								document.getElementById("showIdentfynumber").style.display="";
								document.getElementById("showIdentfynumber").value=_unifiedSocialCreditCode;
								if(document.getElementById("prpCinsureds["+ updateIndex +"].identifyNumber")!=null){
									document.getElementById("prpCinsureds["+ updateIndex +"].identifyNumber").style.display="none";
								}
								if(document.getElementById("show["+ updateIndex +"]Identfynumber")!=null){
									document.getElementById("show["+ updateIndex +"]Identfynumber").style.display="";
									document.getElementById("show["+ updateIndex +"]Identfynumber").value=_unifiedSocialCreditCode;					
								}
							}
						}else{
							identifyType.value = _identifyType;//北分团体特殊处理
//							identifyNumber.value = _identifyNumber;//北分团体特殊处理
						}
					}else {
						identifyType.value = _identifyType;//北分团体特殊处理
//						identifyNumber.value = _identifyNumber;//北分团体特殊处理
					}
					
					
					
					
					//北分电子保单个性
					if((riskCode == "DAA" || riskCode == "DAV") && electronicPolicyFlag != null && (
							comCode.substring(0,2)=="11" || electronicPolicyFlag.value == "1" || 
							(electronicPolicyFlag.value == "2" && comCode.substring(0,2)=="36"))){
						tr.cells[7].all[0].value = _email;
					}
					//北分身份证信息采集隐藏域赋值
					if(comCode.substring(0,2) == "11" && riskCode == "DAA"
						&& (_insuredFlagValue.substring(0,1) == "1" || _insuredFlagValue.substring(1,2) == "1")){
						var flag1 = document.getElementById("idCardCheckInfo.flag");
						if(null != flag1 && (flag1.value == "1" || flag1.value == "2")){
							var idcardCode = document.getElementById("idCardCheckInfo.idcardCode").value;//身份证号
							var name = document.getElementById("idCardCheckInfo.name").value;//姓名
							var nation = document.getElementById("idCardCheckInfo.nation").value;//民族
							var birthday = document.getElementById("idCardCheckInfo.birthday").value;//出生日期
							var sex = document.getElementById("idCardCheckInfo.sex").value;//性别
							var address = document.getElementById("idCardCheckInfo.address").value;//住址
							var ISSUER = document.getElementById("idCardCheckInfo.issure").value;//签发机构
							var validStartDate = document.getElementById("idCardCheckInfo.validStartDate").value;//身份证号码有效开始时间
							var validEndDate = document.getElementById("idCardCheckInfo.validEndDate").value;//身份证号码有效结束时间
							var SAMCode = document.getElementById("idCardCheckInfo.samCode").value;//身份证采集器编码
							var SAMType = document.getElementById("idCardCheckInfo.samType").value;//采集设备类型
							var flag = document.getElementById("idCardCheckInfo.flag").value;
							
							document.getElementById("idCardCheckInfo["+ updateIndex +"].idcardCode").value = idcardCode;//身份证号
							document.getElementById("idCardCheckInfo["+ updateIndex +"].name").value = name;//姓名
							document.getElementById("idCardCheckInfo["+ updateIndex +"].nation").value = nation;//民族
							document.getElementById("idCardCheckInfo["+ updateIndex +"].birthday").value = birthday;//出生日期
							document.getElementById("idCardCheckInfo["+ updateIndex +"].sex").value = sex;//性别
							document.getElementById("idCardCheckInfo["+ updateIndex +"].address").value = address;//住址
							document.getElementById("idCardCheckInfo["+ updateIndex +"].issure").value = ISSUER;//签发机构
							document.getElementById("idCardCheckInfo["+ updateIndex +"].validStartDate").value = validStartDate;//身份证号码有效开始时间
							document.getElementById("idCardCheckInfo["+ updateIndex +"].validEndDate").value = validEndDate;//身份证号码有效结束时间
							document.getElementById("idCardCheckInfo["+ updateIndex +"].samCode").value = SAMCode;//身份证采集器编码
							document.getElementById("idCardCheckInfo["+ updateIndex +"].samType").value = SAMType;//采集设备类型
							document.getElementById("idCardCheckInfo["+ updateIndex +"].flag").value = flag;
							document.getElementById("idCardCheckInfo["+ updateIndex +"].insuredcode").value = _insuredCode;
							document.getElementById("idCardCheckInfo["+ updateIndex +"].insuredFlag").value = _insuredFlagValue.substring(0,2);
							document.getElementById("idCardCheckInfo["+ updateIndex +"].mobile").value = _mobile;
							
							document.getElementById("idCardCheckInfo.idcardCode").value = "";
							document.getElementById("idCardCheckInfo.name").value = "";
							document.getElementById("idCardCheckInfo.nation").value = "";
							document.getElementById("idCardCheckInfo.birthday").value = "";
							document.getElementById("idCardCheckInfo.sex").value = "";
							document.getElementById("idCardCheckInfo.address").value = "";
							document.getElementById("idCardCheckInfo.issure").value = "";
							document.getElementById("idCardCheckInfo.validStartDate").value = "";
							document.getElementById("idCardCheckInfo.validEndDate").value = "";
							document.getElementById("idCardCheckInfo.samCode").value = "";
							document.getElementById("idCardCheckInfo.samType").value = "";
							document.getElementById("idCardCheckInfo.flag").value = "";
						}else{
							Insured.clearIdCardCheckInfo(updateIndex);
						}
					}else if(comCode.substring(0,2) == "11" && riskCode == "DAA"){
						Insured.clearIdCardCheckInfo(updateIndex);
					}
					
					var _phoneNumber1 = document.getElementById("_phoneNumber1").value;
					var lengPhoneNumber1 =_phoneNumber1.length;
					
					var flag = true;
					for(var i =0; i<lengPhoneNumber1; i++ ){
						var f =  _phoneNumber1.substr(i,1);
						
						if(f == "*"){
							flag = false;
							break;
						}
					}
					//北分电子保单个性要求
					if((riskCode == "DAA" || riskCode == "DAV") && electronicPolicyFlag != null && (
							comCode.substring(0,2)=="11" || (electronicPolicyFlag.value == "2" && comCode.substring(0,2)=="36")
								|| electronicPolicyFlag.value == "1")){
						if(flag){
							tr.cells[8].all[0].value = _phoneNumber;	
						}else{
							tr.cells[8].all[0].value = _phoneNumber1;
						}
					}else{
						if(flag){
							tr.cells[7].all[0].value = _phoneNumber;	
						}else{
							tr.cells[7].all[0].value = _phoneNumber1;
						}
					}
					
					var _mobile1 = document.getElementById("_mobile1").value;
					var lengMobile1 =_mobile1.length;
					
					var flag = true;
					for(var i =0; i<lengMobile1; i++ ){
						var f =  _mobile1.substr(i,1);
						
						if(f == "*"){
							flag = false;
							break;
						}
					}
					//北分电子保单个性要求
					if((riskCode == "DAA" || riskCode == "DAV") && electronicPolicyFlag != null && (
							comCode.substring(0,2)=="11" || (electronicPolicyFlag.value == "2" && comCode.substring(0,2)=="36" )
								|| electronicPolicyFlag.value == "1")){
						if(flag){
							tr.cells[9].all[0].value = _mobile;
						}else{
							tr.cells[9].all[0].value = _mobile1;
						}
					}else{
						if(flag){
							tr.cells[8].all[0].value = _mobile;
						}else{
							tr.cells[8].all[0].value = _mobile1;
						}
					}
					
					document.getElementById("_phoneNumber1").value = "";
					document.getElementById("_mobile1").value = ""; 
					if(document.getElementById("_identifyNumber1") != null){
						document.getElementById("_identifyNumber1").value = ""; 
					}
					// 批改出发批改调整变色的方法
					var _bizType = document.getElementById("bizType");
					if(_bizType.value == "ENDORSE"){
						tr.cells[0].all[1].onchange();
						tr.cells[1].all[0].onchange();
				        tr.cells[2].all[1].onchange();
				        tr.cells[3].all[0].onchange();
				        tr.cells[4].all[0].onchange();
				        tr.cells[5].all[0].onchange();
				        tr.cells[6].all[0].onchange();
				        tr.cells[7].all[0].onchange();
				        
				        /* add by zxj 20101102 批文显示不全 begin */
						if(drivingYears.onchange!=null){
							drivingYears.onchange();//新增和修改的位置不一样;LICHENHUI;20101202
						}
						if(age.onchange!=null){
							age.onchange();
						}
						if(unitType.onchange!=null){
							unitType.onchange();
						}
						//电话屏蔽--用于生成批文
						if(mobile.onchange!=null){
							mobile.onchange();
						}
						if(phoneNumber.onchange!=null){
							phoneNumber.onchange();
						}
						if(postCode.onchange!=null){
							postCode.onchange();
						}
						if(countryCode.onchange!=null){
							countryCode.onchange();
						}
						if(soldierRelations != null && soldierRelations.onchange!=null){
							soldierRelations.onchange();
						}
						if(soldierIdentifyType != null && soldierIdentifyType.onchange!=null){
							soldierIdentifyType.onchange();
						}
						if(soldierIdentifyNumber != null && soldierIdentifyNumber.onchange!=null){
							soldierIdentifyNumber.onchange();
						}
						/* add by zxj 20101102 批文显示不全 end */
				        tr.cells[8].all[0].onchange();
			        }
					
				}
				//广东省分公司关于修改系统中纳税人信息的紧急需求
				var gdFlag = false;
				if(isGuangdong() && !guangZhouFlag){
					gdFlag = true;
				}
				if(isNaN(document.getElementById("CarShipInit_Flag"))&&((gdFlag && _insuredFlagValue.substring(0,1)=="1") || (!gdFlag && _insuredFlagValue.substring(1,2)=="1")) && comCode.substring(0,2) != "12"){//TJGGG
					CarShipTax.onActiveSetDe_insured();
					
				}
				if(isNaN(document.getElementById("CarShipInit_Flag"))&&_insuredFlagValue.substring(2,3)=="1" && (comCode.substring(0,2) == "12" || comCode.substring(0,4) == "4403")){//TJGGG
					CarShipTax.onActiveSetDe_insured();
				}
				if (!document.getElementsByName("_insuredFlag")[1].checked) {//不是被保险人还要判断以前是否有保险人
					var index = false;
					var insertRow = document.getElementById("insertInsuredRow");
					var inputs = insertRow.getElementsByTagName("input");
					var insuredF = /^prpCinsureds.*insuredFlag$/;
					var ids;
					for ( var i = 0; i < inputs.length; i++) {
						ids = inputs[i].getAttribute("id");
						if (insuredF.test(ids)) {
							var num = ids.replace(/[^0-9]/ig,"");
							if (document.getElementById("prpCinsureds["+num+"].insuredType").value=="2"
							&& document.getElementById("prpCinsureds["+num+"].insuredFlag").value.substring(1,2) == 1) {
								index =true;
								break;
							}
						}
					}
					if (!index && document.getElementById("prpCcarShipTax.taxPayerNumberLSJ")!=null && document.getElementById("prpCcarShipTax.taxPayerNumber") != null) {
						document.getElementById("prpCcarShipTax.taxPayerNumberLSJ").value = "";
						document.getElementById("prpCcarShipTax.taxPayerNumber").value = "";
					}	
				}
				//增加指定驾驶人影响保费,需要清空保费重新计算
				var clauseType  = document.getElementById("prpCitemCar.clauseType").value;
				if(_insuredFlagText.indexOf("指定驾驶人")>-1  && clauseType == 'F42'){
					ItemKind.clearSumPremium();
				}
			    Insured.resetInsuredFlag();    
		//	    document.getElementById("updateIndex").value = "-1";	
			    
			    /* add by zhaoxiaojie 20100820 查询关系人后将重要信息设置为只读,添加完成后恢复 begin */
			    document.getElementById("_insuredType").disabled = false;
				//document.getElementById("_insuredCode").readOnly = false;
			    document.getElementById("_insuredName").readOnly = false;
			    document.getElementById("_mobile1").readOnly = false;
			    document.getElementById("_phoneNumber1").readOnly = false;
				document.getElementById("_identifyType").disabled = false;
				document.getElementById("_countryCode").disabled = false;
				document.getElementById("_insuredAddress").readOnly = false;
				document.getElementById("_postCode").readOnly = false;
				document.getElementById("_identifyNumber").readOnly = false;
				document.getElementById("_sex").disabled = false;
				document.getElementById("_unifiedSocialCreditCode").readOnly = false;
				//document.getElementById("_age").readOnly = false;
			    /* add by zhaoxiaojie 20100820 查询关系人后将重要信息设置为只读,添加完成后恢复end */
			    // 校验优惠
				ItemCar.doCheckProfits();
				//修改页面上的关系人信息要提示修改意外险信息
				Insured.changeEad();
				//是否勾选直升机险
				if(haveUFJ){
					var insuredUFJ = false;
					var downflag = false;
					if(_insuredFlagValue.substring(1,2) == "1"){
						downflag = true;
					}
					var insuredTab = document.getElementById("insertInsuredRow");
					var insuredTbody = insuredTab.tBodies.item(0);
					var insuredRow = insuredTbody.rows;
					for(var j = 0; j < insuredRow.length; j++){
						var eles = insuredRow[j].all;
						for(var k = 0 ; k < eles.length ; k++){
							var eleName = eles[k].name || eles[k].id || "";
							if(eleName.indexOf("insuredFlag") > -1){
								if(eles[k].value.substring(1,2)=="1"){
									insuredUFJ = true;
								}
								break;
							}
						}
					}
					if(!insuredUFJ){
						//删除被保险人
	    				alert("此操作将导致删除直升机救援险信息");
	    				chooseFlag.checked=false;
						document.getElementById("itemKindUnitedSaletd").style.display="none";
						document.getElementById("itemKindUnitedSaletr").style.display="none";
		    			var bloodType = document.getElementById("prpUitemKindVos[0].bloodType");
		    			var bloodTypeDesc = document.getElementById("BloodTypeDesc[0]");
	    				if(bloodType!=null){
	    					bloodType.value ="";
	    				}
	    				if(bloodTypeDesc!=null){
	    					bloodTypeDesc.value ="";
	    				}
					}
				}
				//获取行号
				var idx=parseInt(globalindex["insertInsuredRow"]) - 1;
				var insuredflag;
				var flagI;
				if(document.getElementById("updateIndex").value < 0){// 保存
				  insuredflag = document.getElementById("prpCinsureds["+idx+"].insuredFlag");
				  flagI = document.getElementById("prpCinsureds["+idx+"].flag");
				}else{
				  insuredflag = document.getElementById("prpCinsureds["+updateIndex+"].insuredFlag");
				  flagI = document.getElementById("prpCinsureds["+updateIndex+"].flag");	
				}
				
				if(Insured.isOwner(insuredflag.value)&&document.getElementById("bizType").value == "ENDORSE"){
					Insured.ownerBeChanged();
				}
//				 gi++;
//				 globalindex[globalIndexCode] = gi;
				 document.getElementById("updateIndex").value = "-1";	
			},
			
			/**
			 * @author
			 * @description 修改关系人，清空当前行身份证采集表信息
			 * @param updateIndex
			 * @return
			 */

			clearIdCardCheckInfo : function(updateIndex){
				document.getElementById("idCardCheckInfo.idcardCode").value = "";
				document.getElementById("idCardCheckInfo.name").value = "";
				document.getElementById("idCardCheckInfo.nation").value = "";
				document.getElementById("idCardCheckInfo.birthday").value = "";
				document.getElementById("idCardCheckInfo.sex").value = "";
				document.getElementById("idCardCheckInfo.address").value = "";
				document.getElementById("idCardCheckInfo.issure").value = "";
				document.getElementById("idCardCheckInfo.validStartDate").value = "";
				document.getElementById("idCardCheckInfo.validEndDate").value = "";
				document.getElementById("idCardCheckInfo.samCode").value = "";
				document.getElementById("idCardCheckInfo.samType").value = "";
				document.getElementById("idCardCheckInfo.flag").value = "";

				document.getElementById("idCardCheckInfo["+ updateIndex +"].idcardCode").value = "";//身份证号
				document.getElementById("idCardCheckInfo["+ updateIndex +"].name").value = "";//姓名
				document.getElementById("idCardCheckInfo["+ updateIndex +"].nation").value = "";//民族
				document.getElementById("idCardCheckInfo["+ updateIndex +"].birthday").value = "";//出生日期
				document.getElementById("idCardCheckInfo["+ updateIndex +"].sex").value = "";//性别
				document.getElementById("idCardCheckInfo["+ updateIndex +"].address").value = "";//住址
				document.getElementById("idCardCheckInfo["+ updateIndex +"].issure").value = "";//签发机构
				document.getElementById("idCardCheckInfo["+ updateIndex +"].validStartDate").value = "";//身份证号码有效开始时间
				document.getElementById("idCardCheckInfo["+ updateIndex +"].validEndDate").value = "";//身份证号码有效结束时间
				document.getElementById("idCardCheckInfo["+ updateIndex +"].samCode").value = "";//身份证采集器编码
				document.getElementById("idCardCheckInfo["+ updateIndex +"].samType").value = "";//采集设备类型
				document.getElementById("idCardCheckInfo["+ updateIndex +"].flag").value = "0";
				document.getElementById("idCardCheckInfo["+ updateIndex +"].insuredcode").value = "";
				document.getElementById("idCardCheckInfo["+ updateIndex +"].insuredFlag").value = "";
				document.getElementById("idCardCheckInfo["+ updateIndex +"].mobile").value = "";
			},
			
			/**
			 * @author lch
			 * @description 合并insuredFlag和居民非居民字段<br/>
			 * @param _insuredFlagValue, _resident
			 * @return
			 */
			dealInsuredFlagResident : function(_insuredFlagValue, _resident){
				var insuredFlagLength = _insuredFlagValue.length;
			    for(var i=0; i < 30 - insuredFlagLength; i++){
			    	_insuredFlagValue += "0";
			    }
			    if(_insuredFlagValue.substring(0,1) == "1" && _resident!="" && _resident.length>0){
			    	_insuredFlagValue = _insuredFlagValue.substring(0,29) + _resident;
			    }
			    return _insuredFlagValue;
			},
			
			/**
			 * @author huxiaodong
			 * @description 指定驾驶人的click事件<br/>
			 *<p>
			 *<font color=red>规则 : 调用：R416,R443</font>
			 *</p>
			 *<p>
			 *1>判断录入指定驾驶员是否满足条件<br/> 2>显示/隐藏指定驾驶员的属性域<br/>
			 *3>车辆条款类型为家庭自用、尊贵人生、天津店面直销时,修改关系人中:指定驾驶人、性别、驾龄、年龄时清空总保费<br/>
			 *</p>
			 * @param filed
			 *            表单域
			 * @return
			 */
			clickDriver : function(filed){
				//R416 判断录入指定驾驶员是否满足条件
				Insured.checkUseNature(filed);
				//R443 显示/隐藏指定驾驶员的属性域
				Insured.addDrivingLicenseNo(filed);
				//车辆条款类型为家庭自用、尊贵人生、天津店面直销时,修改关系人中:指定驾驶人、性别、驾龄、年龄时清空总保费
				Insured.clearSumPremium_();
			},
			
			/**
			 * @author sinosoft
			 * @description 只有当使用性质为“家庭自用211”时才能录入指定驾驶员
			 *<p>
			 *<font color=red>规则 : R416</font>
			 *</p>
			 * @param field 表单域
			 * @return
			 */
			checkUseNature : function(field){
				var useNature = document.getElementById("prpCitemCar.useNatureCode").value;
				var riskCode = document.getElementById("riskCode").value;
				// R416
				if(field.checked&&useNature!="211"&&riskCode !="DGA"){
					errorMessage("只有当使用性质为“家庭自用”时，才能录入指定驾驶人");
					field.checked = false;
				}
			},
			
			/**
			 * @author sinosoft
			 * @description 当车辆条款类型为家庭自用、尊贵人生、天津店面直销时，修改关系人中:指定驾驶人、性别、驾龄、年龄时清空总保费
			 * @return
			 */
			clearSumPremium_ : function(){
				var clauseType  = document.getElementById("prpCitemCar.clauseType").value;
				//add by zhangqingtao 如果是riskCode为DAN 不清空总保费 20120925
				var riskCode= document.getElementById("riskCode").value;
				if('F42,F48,F49'.indexOf(clauseType) >= 0  && document.getElementById("comCode").value.substring(0,2) != '31'){
					if(riskCode != null && riskCode !="" && riskCode !="DAN"){
						ItemKind.clearSumPremium();
					}
				}
			},
			/**
			 * @author huxiaodong
			 * @description 类型change事件<br/>
			 *<p>
			 *1>根据关系人类型，来清空关系人的属性值<br/> 2>改变类型时,改变关系人页面元素<br/>
			 *</p>
			 * @return
			 */
			changeInsuredType : function(){
				//根据关系人类型，来清空关系人的属性值
				Insured.clearInsured();
				//改变类型时,改变关系人页面元素
				Insured.changeInsuredNature();
//				Insured.onchangeIsNetProp();
			},
			
			/**
			 * @author sinosoft
			 * @description 根据关系人类型，来清空关系人的属性值
			 * @return
			 */
			clearInsured : function(){
				var insuredType = document.getElementById("_insuredType").value;
				if(insuredType == "1"){
					document.getElementById("_insuredCode").value = "";// ID
					document.getElementById("_identifyNumber").value = "";// 证件号码
					if(document.getElementById("_identifyNumber1")!=null){
						document.getElementById("_identifyNumber1").value = "";// 证件号码
					}
					document.getElementById("_mobile").value = "";// 移动电话-隐藏域
					if(!document.getElementById("isCqp")){
						document.getElementById("_mobile1").value = "";// 移动电话
						document.getElementById("_phoneNumber1").value = "";// 固定电话
						document.getElementById("_mobile1").readOnly = false;
						document.getElementById("_phoneNumber1").readOnly = false;
					}
					document.getElementById("_phoneNumber").value = "";// 固定电话-隐藏域
					document.getElementById("_insuredAddress").value = "";// 地址
					document.getElementById("_insuredAddress").readOnly = false;
					document.getElementById("_postCode").value = "";// 邮编
					document.getElementById("_postCode").readOnly = false;
					document.getElementById("_auditStatus").value = "";// 审批状态
					document.getElementById("_versionNo").value = "";// 版本号
					document.getElementById("_appendPrintName").value = "";// 打印附加
					//document.getElementById("_insuredCode").readOnly = false;
					document.getElementById("_insuredName").readOnly = false;
					document.getElementById("_identifyNumber").readOnly = false;
					document.getElementById("_identifyType").disabled = false;
					document.getElementById("_countryCode").disabled = false;
					document.getElementById("_sex").disabled = false;
					_drivingLicenseNo = document.getElementById("_drivingLicenseNo");
					_acceptLicenseDate = document.getElementById("_acceptLicenseDate");
					if(_drivingLicenseNo != null){
						_drivingLicenseNo.readOnly = false;
					}
					if(_acceptLicenseDate != null){
						_acceptLicenseDate.value ="";
						_acceptLicenseDate.readOnly = false;
					}
					if(document.getElementById("group_code")){
						document.getElementById("group_code").value = "";
					}
				}else if(insuredType == "2"){
					document.getElementById("_insuredCode").value = "";// ID
					document.getElementById("_identifyNumber").value = "";// 证件号码
					document.getElementById("_mobile").value = "";// 移动电话-隐藏域
					if(!document.getElementById("isCqp")){
						document.getElementById("_mobile1").value = "";// 移动电话
						document.getElementById("_phoneNumber1").value = "";// 固定电话
						document.getElementById("_mobile1").readOnly = false;
						document.getElementById("_phoneNumber1").readOnly = false;
					}
					document.getElementById("_phoneNumber").value = "";// 固定电话-隐藏域
					document.getElementById("_insuredAddress").value = "";// 地址
					document.getElementById("_insuredAddress").readOnly = false;
					document.getElementById("_postCode").value = "";// 邮编
					document.getElementById("_postCode").readOnly = false;
					document.getElementById("_auditStatus").value = "";// 审批状态
					document.getElementById("_versionNo").value = "";// 版本号
					document.getElementById("_appendPrintName").value = "";// 打印附加
					//document.getElementById("_insuredCode").readOnly = false
					document.getElementById("_insuredName").readOnly = false;
					document.getElementById("_identifyNumber").readOnly = false;
					document.getElementById("_age").value = "";
					document.getElementById("_drivingYears").value = "";
					_drivingLicenseNo = document.getElementById("_drivingLicenseNo");
					_acceptLicenseDate = document.getElementById("_acceptLicenseDate");
					if(_drivingLicenseNo != null){
						_drivingLicenseNo.readOnly = false;
					}
					if(_acceptLicenseDate != null){
						_acceptLicenseDate.value ="";
						_acceptLicenseDate.readOnly = false;
					}
					
					if(document.getElementById("group_code")){
						document.getElementById("group_code").value = "";
					}
				}
			},
			
			/**
			 * @author sinosoft
			 * @description 改变类型时,改变关系人页面元素
			 * <p>
			 *<font color=red>规则 : R26,R623,R624</font>
			 *</p>
			 * @return
			 */
			changeInsuredNature : function(){
				var insuredType = document.getElementById('_insuredType');
				//add by zhaoxiaojie 20100804 设置默认项 begin
					if(insuredType.value =="2"){
					    // 如果类型为单位，单位性质默认为企业类型
					    document.getElementById('_unitType').value = "300";
					    //modify by LiChenhui;类型为单位，证件类型的值设置为空;20100810;begin;
					    document.getElementById('_identifyType').value = "31";
					    //modify by LiChenhui;类型为单位，证件类型的值设置为空;20100810;end;
				    }else{
				    	 // 如果类型为个人，证件类型为身份证
				        document.getElementById('_identifyType').value = "01";
				    }
					//add by zhaoxiaojie 20100804 设置默认项end
				document.getElementById("_unifiedSocialCreditCode").value = "";// 统一社会信用代码
				var des_identifyType = document.getElementById('des_identifyType');
				var inp_identifyType = document.getElementById('inp_identifyType');
				var des_identifyNum = document.getElementById('_identifyNumber');
				var des_sex = document.getElementById('des_sex');
				var inp_sex = document.getElementById('inp_sex');
				var des_drivingYears = document.getElementById('des_drivingYears');
				var inp_drivingYears = document.getElementById('inp_drivingYears');
				var des_age = document.getElementById('des_age');
				var inp_age = document.getElementById('inp_age');
				var des_unitType = document.getElementById("des_unitType");
			    var inp_unitType = document.getElementById("inp_unitType");
			    var des_countryCode = document.getElementById("des_countryCode");
			    var inp_countryCode = document.getElementById("inp_countryCode");
			    var decorationId1 = document.getElementById("decorationId1");
			    var decorationValue1 = document.getElementById("decorationValue1");
			    var mustInput = document.getElementById("mustInput");
			    var des_unifiedSocialCreditCode=document.getElementById("des_unifiedSocialCreditCode");
				var inp_unifiedSocialCreditCode=document.getElementById("inp_unifiedSocialCreditCode");
				if(insuredType.value!="1"){
					des_identifyType.style.display="none";
					inp_identifyType.style.display="none";
					des_sex.style.display="none";
					inp_sex.style.display="none";
					des_drivingYears.style.display="none";
					inp_drivingYears.style.display="none";
					des_age.style.display="none";
					inp_age.style.display="none";
					//modify by zhaoxiaojie 20100804 关系人类型团体时显示单位性质 begin
					//R624
					des_unitType.style.display = "";
					// R26
					inp_unitType.style.display = "";
					des_identifyNumber.innerText="组织机构代码：";
					des_identifyNum.description="组织机构代码";
					//add by zhangqingtao 补全表格 begein
					decorationId1.style.display = "none";
					decorationValue1.style.display = "none";
					//add by zhangqingtao 补全表格 end
					mustInput.style.display = "none";
					inp_countryCode.style.display = "none";
					des_countryCode.style.display = "none";
					des_unifiedSocialCreditCode.style.display="";
					inp_unifiedSocialCreditCode.style.display="";

				}else{
					// R623
					des_identifyType.style.display="";
					inp_identifyType.style.display="";
					des_sex.style.display="";
					inp_sex.style.display="";
					des_drivingYears.style.display="";
					inp_drivingYears.style.display="";
					des_age.style.display="";
					inp_age.style.display="";
					des_identifyNumber.innerText="证件号码：";
					des_identifyNum.description="证件号码";
					decorationId1.style.display = "none";
					decorationValue1.style.display = "none";
					if(document.getElementById("decorationId")!=null){
						document.getElementById("decorationId").style.display = "none";
					}
					document.getElementById("decorationValue").style.display = "none";
					//modify by zhaoxiaojie 20100804 关系人类型个人时隐藏单位性质 begin
					des_unitType.style.display = "none";
					//R26
					inp_unitType.style.display = "none";
					//modify by zhaoxiaojie 20100804 关系人类型个人时隐藏单位性质 end
					inp_countryCode.style.display = "";
					des_countryCode.style.display = "";
					des_unifiedSocialCreditCode.style.display="none";
					inp_unifiedSocialCreditCode.style.display="none";
				}
				if(document.getElementById("editType").value!="SHOW_PROPOSAL" && document.getElementById("editType").value!="SHOW_ENDORSE"
					&& document.getElementById("editType").value!="SHOW_POLICY"){
					if(insuredType.value=="2"){
					    var arrFlag = document.getElementsByName("_insuredFlag");
					    arrFlag[3].checked = false;
					    Insured.addDrivingLicenseNo(arrFlag[3]);
					    arrFlag[3].disabled = true;
					}else{
					    var arrFlag = document.getElementsByName("_insuredFlag");
					    arrFlag[3].disabled = false;  
					}
			    }
				//add xuzechao 20110812 删除客户评级的列表
				document.getElementById("modelList").innerHTML="";
			},
			/**
			 * @author sinosoft
			 * @description 显示/隐藏指定驾驶员的属性域
			 *<p>
			 *<font color=red>规则 : R443</font>
			 *</p>
			 * @param chk
			 * 			角色为指定驾驶人触发
			 */
			addDrivingLicenseNo : function(chk){
				if(chk.checked){
					// R443
					// 报价中没有if体中的代码，报价不执行
					if(!document.getElementById("isCqp")){
						if(document.getElementById("decorationId")!=null){
							document.getElementById("decorationId").style.display = "none";
						}
						document.getElementById("decorationValue").style.display = "none";
						document.getElementById("imageone").style.display = "";
						document.getElementById("imagetwo").style.display = "";
					}
					document.getElementById("drivingLicenseNo").style.display = "";
					document.getElementById("drivingLicenseNoValue").style.display = "";
					if(document.getElementById("drivingLicenseNo1")!=null){
						document.getElementById("drivingLicenseNo1").style.display = "none";
					}
					//modify by sangjianjun;准驾车型只有在指定驾驶人才显示  20100728 begin
					document.getElementById("drivingCarType").style.display = "";
					document.getElementById("drivingCarTypeValue").style.display = "";
					document.getElementById("CarKindLicense").value = "";
					//modify by lujunfeng 指定驾驶人时显示上年违章次数和初次领证日期
					document.getElementById("disType").style.display = "";
					document.getElementById("causetroubleTimesType").style.display = "";
					document.getElementById("causetroubleTimesValue").style.display = "";
					document.getElementById("acceptLicenseDateType").style.display = "";
					document.getElementById("acceptLicenseDateValue").style.display = "";
					Insured.writeDivLicenseNo();
					Insured.writeDrivingLicenseNo(document.getElementById("_identifyNumber"));
				}else{
					// 报价中没有if体中的代码，报价不执行
					if(!document.getElementById("isCqp")){
						if(document.getElementById("decorationId")!=null){
							document.getElementById("decorationId").style.display = "";
						}
						document.getElementById("decorationValue").style.display = "";
						document.getElementById("imageone").style.display = "none";
						document.getElementById("imagetwo").style.display = "none";
					}
					var IDCARD_SHIELD = document.getElementById("IDCARD_SHIELD");
					if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1"){
						if(document.getElementById("drivingLicenseNo") != null){
							document.getElementById("drivingLicenseNo").value = "";
						}
						if(document.getElementById("drivingLicenseNoLSJ") != null){
							document.getElementById("drivingLicenseNoLSJ").value = "";
						}
					}
					document.getElementById("drivingLicenseNo").style.display = "none";
					document.getElementById("drivingLicenseNoValue").style.display = "none";
					if(document.getElementById("drivingLicenseNo1")!=null){
						document.getElementById("drivingLicenseNo1").style.display = "";
					}
					document.getElementById("drivingCarType").style.display = "none";
					document.getElementById("drivingCarTypeValue").style.display = "none";
					
					document.getElementById("disType").style.display = "none";
					document.getElementById("causetroubleTimesType").style.display = "none";
					document.getElementById("causetroubleTimesValue").style.display = "none";
					
					document.getElementById("acceptLicenseDateType").style.display = "none";
					document.getElementById("acceptLicenseDateValue").style.display = "none";
					//modify by sangjianjun;准驾车型只有在指定驾驶人才显示  20100728 end
				}
			},
	
			/**
			 * @author sinosoft
			 * @description 每增加一条后，清空相应字段
			 *<p>
			 *<font color=red>规则 : R25</font>
			 *</p>
			 * @return
			 */
			resetInsuredFlag : function (){
				var relationType = document.getElementById("relationType").value;
				relationType = (relationType == ''?'1':relationType);
				var _insuredFlag_hide = document.getElementsByName("_insuredFlag_hide");
				var _insuredFlag = document.getElementsByName("_insuredFlag");		
				
				for(var i = 0;i < _insuredFlag.length; i++){
					// R25
					if(relationType == '1'){
						_insuredFlag[i].checked = false;
					}else{
						
						if(_insuredFlag_hide[i].value == '车主'){
							_insuredFlag[i].checked = true;
						}else{
							_insuredFlag[i].checked = false;
						}
					}
				}	
			},
			/**
			 * @author sinosoft
			 * @description 检验是否有指定驾驶人：有--带出自动带出特约
			 * @return
			 */
			checkInsuredFlag : function (){
			  var table = document.getElementById('insertInsuredRow');
			  var rows =  table.tBodies.item(0).rows;
			  var elen = rows.length;
			  var hasI = false;
			  for (var i = 0; i < elen; i++)
			  {
			    if(document.getElementById("prpCinsureds["+i+"].insuredFlag").value.substring(3,4)=="1")
			    	{
			    		hasI = true;
			    		break;
			    	}
			  }  	
			  if(hasI){
				  document.getElementById("prpCinsuredDiv_Flag").value = "1";
				  //该方法弃用改由ilog自动带出
				  /*if(isNaN(document.getElementById("iniPrpCengage_Flag"))){
					  Engage.insertEngageDevice();
				  }*/  	
			  }     
			},
			/**
			 * @author sinosoft
			 * @description 检验是否有关系人信息
			 * @return
			 */
			getInsuredName:function(){
				var index = document.getElementById("hidden_index_insured").value;
				if (isNaN(parseInt(globalindex["insertInsuredRow"])) && parseInt(index) != 0) {
					globalindex["insertInsuredRow"] = parseInt(index);
				}
				var objTopLen = parseInt(globalindex["insertInsuredRow"]);
				var insuredName = "";
				 for (var i = 0; i < objTopLen; i++)
				  {
				    if(document.getElementById("prpCinsureds["+i+"].insuredFlag")!=null 
				    		&& (document.getElementById("prpCinsureds["+i+"].insuredFlag").value.substring(0,1)=="1"
				    			 || document.getElementById("prpCinsureds["+i+"].insuredFlag").value.substring(1,2)=="1"))
			    	{
			    	    insuredName = document.getElementById("prpCinsureds["+i+"].insuredName").value;
			    		break;
			    	}
				  } 
				return insuredName;
			},
			/**
			 * @author sinosoft
			 * @description 获取车主名称
			 * @return
			 */
			getOwnerName : function(){
				var strInsureFlag  = "00000000";
				var obj = document.getElementsByName("_insuredFlag");
				var index = document.getElementById("hidden_index_insured").value;
				if (isNaN(parseInt(globalindex["insertInsuredRow"])) && parseInt(index) != 0) {
					globalindex["insertInsuredRow"] = parseInt(index);
				}
				var objTopLen = parseInt(globalindex["insertInsuredRow"]);
				var ownerName = "";
				for(var i=0;i<obj.length;i++){
			    	if(obj[i].checked){
			    		strInsureFlag = strInsureFlag.substring(0,i)+"1"+strInsureFlag.substring(i+1);
			    	}
				}
				for(var m=0;m<objTopLen;m++){
					if(document.getElementById("updateIndex").value == m){// 保存
						continue;
					}  	
					if(isNaN(document.getElementById("prpCinsureds["+m+"].insuredFlag"))&&document.getElementById("prpCinsureds["+m+"].insuredFlag")!=null){	
						if(strInsureFlag.substring(2,3)=="0" && document.getElementById("prpCinsureds["+m+"].insuredFlag").value.substring(2,3)=="1"){
							ownerName = document.getElementById("prpCinsureds["+m+"].insuredName").value;
						}    
					}
				}
				if(strInsureFlag.substring(1,2)=="0" && strInsureFlag.substring(2,3)=="1"){
					ownerName = document.getElementById("_insuredName").value;  
				}
	//			  var table = document.getElementById('insertInsuredRow');
	//			  var rows =  table.tBodies.item(0).rows;
	//			  var elen = rows.length;
				  var hasI = false;
				  for (var i = 0; i < objTopLen; i++)
				  {
				    if(document.getElementById("prpCinsureds["+i+"].insuredFlag")!=null 
				    		&& document.getElementById("prpCinsureds["+i+"].insuredFlag").value.substring(2,3)=="1" 
				    			&& ((document.getElementById("prpCinsureds["+i+"].flag")!=null 
				    			&& document.getElementById("prpCinsureds["+i+"].flag").value.length >= 1 
				    			&& document.getElementById("prpCinsureds["+i+"].flag").value.substring(0,1)!="B" 
					    			&& document.getElementById("prpCinsureds["+i+"].flag").value.substring(0,1)!="D") 
					    			||(document.getElementById("prpCinsureds["+i+"].flag")!=null 
					    	    			&& document.getElementById("prpCinsureds["+i+"].flag").value == "" )))
			    	{
			    	    ownerName = document.getElementById("prpCinsureds["+i+"].insuredName").value;
			    		break;
			    	}
				  } 
				return ownerName;
			},
			/**
			 * @author sinosoft
			 * @description 获取车主证件类型
			 * @return
			 */
			getIdentifyType : function(){
				var messge=true;
				var identifyType = "";
				var table = document.getElementById('insertInsuredRow');
				var rows =  table.tBodies.item(0).rows;
				var elen = rows.length;
				var applicantIndex = -1;
				var reg = /^prpCinsureds(\[){1}[0-9]{1,5}(\]){1}(\.){1}insuredFlag/;
				
				for (var i = 0; i < elen; i++) {
					var row = rows[i];
					var els = row.all;
					for(var j=0;j<els.length;j++){
						var elName = els[j].name || els[i].id;
						if(reg.exec(elName)){
							var index = ItemKind.getGlobalIndex(elName);
						    if(document.getElementById("prpCinsureds["+index+"].insuredFlag").value.substring(2,3)=="1") {
						    	identifyType = document.getElementById("prpCinsureds["+index+"].identifyType").value;
						    	applicantIndex = index;
						    	break;
						    }
						}
					}
					if(applicantIndex > -1){
						break;
					}
				}
				if(identifyType !='01' && identifyType !='02' 
					&& identifyType !='03' && identifyType !='16'){
					messge=false;
				}
				return messge;
			},
			/**
			 * @author sinosoft
			 * @description 校验投保人、被保险人、车主的移动电话不允许为空，上海个性（全面型）
			 * @return
			 */
			checkMobile1 : function () {
				var flag = false;
				var flag1 = false;
				var flag2 = false;
				var checkFlag = true;
				var applicantIndex = -1;
				var table = document.getElementById('insertInsuredRow');
				var rows =  table.tBodies.item(0).rows;
				var elen = rows.length;
				var reg = /^prpCinsureds(\[){1}[0-9]{1,5}(\]){1}(\.){1}insuredFlag/;
				
				for (var i = 0; i < elen; i++) {
					var row = rows[i];
					var els = row.all;
					for(var j=0;j<els.length;j++){
						var elName = els[j].name || els[i].id;
						if(reg.exec(elName)){
							var index = ItemKind.getGlobalIndex(elName);
							var insuredFlag = document.getElementById("prpCinsureds["+index+"].insuredFlag");
							var mobile = document.getElementById("prpCinsureds["+index+"].mobile");
						    if(insuredFlag.value.substring(0,1) =="1") {
						    	if(mobile.value ==null || mobile.value ==""){
									flag = true;
									applicantIndex = 0;
									break;
								}
						    }
						    if(insuredFlag.value.substring(1,2) =="1") {
						    	if(mobile.value ==null || mobile.value ==""){
									flag1 = true;
									applicantIndex = 0;
									break;
								}
						    }
						    if(insuredFlag.value.substring(2,3) =="1") {
						    	if(mobile.value ==null || mobile.value ==""){
									flag2 = true;
									applicantIndex = 0;
									break;
								}
						    }
						}
					}
					if(applicantIndex > -1){
						break;
					}
				}
				if(flag || flag1 || flag2 ){
					checkFlag=false;
				}
				return checkFlag;
			},
			/**
			 * @author sinosoft
			 * @description 获取车主类型
			 * @return
			 */
			getOwnerType : function(){				
				var strInsureFlag  = "00000000";
				var obj = document.getElementsByName("_insuredFlag");
				var index = document.getElementById("hidden_index_insured").value;
				if (isNaN(parseInt(globalindex["insertInsuredRow"])) && parseInt(index) != 0) {
					globalindex["insertInsuredRow"] = parseInt(index);
				}
				var objTopLen = parseInt(globalindex["insertInsuredRow"]);
				var ownerType = "";
				for(var i=0;i<obj.length;i++){
			    	if(obj[i].checked){
			    		strInsureFlag = strInsureFlag.substring(0,i)+"1"+strInsureFlag.substring(i+1);
			    	}
				}
				for(var m=0;m<objTopLen;m++){
					if(document.getElementById("updateIndex").value == m){// 保存
						continue;
					}  	
					if(isNaN(document.getElementById("prpCinsureds["+m+"].insuredFlag"))&&document.getElementById("prpCinsureds["+m+"].insuredFlag")!=null){	
						if(strInsureFlag.substring(2,3)=="0" && document.getElementById("prpCinsureds["+m+"].insuredFlag").value.substring(2,3)=="1"){
							ownerType= document.getElementById("prpCinsureds["+m+"].insuredType").value;
						}    
					}
				}
				if(strInsureFlag.substring(1,2)=="0" && strInsureFlag.substring(2,3)=="1" && !Common.is4S()){
					ownerType = document.getElementById("_insuredType").value;  
				}
	//			  var table = document.getElementById('insertInsuredRow');
	//			  var rows =  table.tBodies.item(0).rows;
	//			  var elen = rows.length;
				  var hasI = false;
				  for (var i = 0; i < objTopLen; i++)
				  {
				    if(document.getElementById("prpCinsureds["+i+"].insuredFlag")!=null 
				    		&& document.getElementById("prpCinsureds["+i+"].insuredFlag").value.substring(2,3)=="1" 
				    			&& ((document.getElementById("prpCinsureds["+i+"].flag")!=null 
				    			&& document.getElementById("prpCinsureds["+i+"].flag").value.length >= 1 
				    			&& document.getElementById("prpCinsureds["+i+"].flag").value.substring(0,1)!="B" 
					    			&& document.getElementById("prpCinsureds["+i+"].flag").value.substring(0,1)!="D") 
					    			||(document.getElementById("prpCinsureds["+i+"].flag")!=null 
					    	    			&& document.getElementById("prpCinsureds["+i+"].flag").value == "" )))
			    	{
				    	ownerType = document.getElementById("prpCinsureds["+i+"].insuredType").value;
			    		break;
			    	}
				  } 
				return ownerType;
			},
	
			/**
			 * @author yanggang
			 * @description PRPALL-2051 自动带出指定驾驶人特约 
			 * @return 驾驶员的信息
			 */
			getDriverName : function(){
				var strInsureFlag  = "00000000";
				var obj = document.getElementsByName("_insuredFlag");
				var index = document.getElementById("hidden_index_insured").value;
				if (isNaN(parseInt(globalindex["insertInsuredRow"])) && parseInt(index) != 0) {
					globalindex["insertInsuredRow"] = parseInt(index);
				}
				var objTopLen = parseInt(globalindex["insertInsuredRow"]);
				var driverName = "";		//姓名
				var identifyType = "";		//证件类型
				var _identifyType = "";
				var identifyNumber = "";	//证件号
				var age = "";				//年龄
				var insuredAddress = "";	//地址
				var mobile = "";			//移动电话
				var phoneNumber = "";		//固定电话
				var drivingLicenseNo = "";	//驾驶证号
				var causetroubleTimes = "";	//上年违章次数
				var acceptLicenseDate = "";	//初次领证日期
				var drivingCarType = "";	//准驾车型
				var _drivingCarType = "";
				var driverArray = new Array();
				var result = "";
				var comcode = document.getElementById("comCode").value;
				for(var i=0;i<obj.length;i++){
			    	if(obj[i].checked){
			    		strInsureFlag = strInsureFlag.substring(0,i)+"1"+strInsureFlag.substring(i+1);
			    	}
				}
				for(var m=0;m<objTopLen;m++){
					if(document.getElementById("updateIndex").value == m){// 保存
						continue;
					}  	
					if(isNaN(document.getElementById("prpCinsureds["+m+"].insuredFlag"))&&document.getElementById("prpCinsureds["+m+"].insuredFlag")!=null){
						var flag = document.getElementById("prpCinsureds["+m+"].flag");
						if(document.getElementById("prpCinsureds["+m+"].insuredFlag").value.substring(3,4)=="1" && 
								flag != null && ((flag.value != null && trim(flag.value) != '' && 
										flag.value.substring(0,1) != 'B' && flag.value.substring(0,1) != 'D')
										|| trim(flag.value) == '')){
							driverName = document.getElementById("prpCinsureds["+m+"].insuredName").value;
							_identifyType = document.getElementById("prpCinsureds["+m+"].identifyType").value;
							identifyType = Insured.getIdentifyTypeByNo(_identifyType);
							identifyNumber = document.getElementById("prpCinsureds["+m+"].identifyNumber").value;
							age = document.getElementById("prpCinsureds["+m+"].age").value;
							insuredAddress = document.getElementById("prpCinsureds["+m+"].insuredAddress").value;
							mobile = document.getElementById("prpCinsureds["+m+"].mobile").value;
							phoneNumber = document.getElementById("prpCinsureds["+m+"].phoneNumber").value;
							drivingLicenseNo = document.getElementById("prpCinsureds["+m+"].drivingLicenseNo").value;
							causetroubleTimes = document.getElementById("prpCinsureds["+m+"].causetroubleTimes").value;
							acceptLicenseDate = document.getElementById("prpCinsureds["+m+"].acceptLicenseDate").value;
							_drivingCarType = document.getElementById("prpCinsureds["+m+"].drivingCarType").value;
							if(_drivingCarType != null){
								_drivingCarType = trim(_drivingCarType);
							}
							drivingCarType = Insured.getDrivingCarTypeByNo(_drivingCarType);
							if(comcode.substring(0,2)=="31"){
								driverArray.push(driverName+"("+identifyNumber+")");
							}else{
								driverArray.push(driverName + "(驾驶证号码：" + drivingLicenseNo + 
										"，初次领证日期：" + acceptLicenseDate + "，准驾车型：" + drivingCarType + ")");
							}
						}
					}
				}
				if(strInsureFlag.substring(3,4) != '0'){
					driverName = document.getElementById("_insuredName").value;
					_identifyType = document.getElementById("_identifyType").value;
					identifyType = Insured.getIdentifyTypeByNo(_identifyType);
					identifyNumber = document.getElementById("_identifyNumber").value;
					age = document.getElementById("_age").value;
					insuredAddress = document.getElementById("_insuredAddress").value;
					mobile = document.getElementById("_mobile").value;
					phoneNumber = document.getElementById("_phoneNumber").value;
					drivingLicenseNo = document.getElementById("_drivingLicenseNo").value;
					causetroubleTimes = document.getElementById("_causetroubleTimes").value;
					acceptLicenseDate = document.getElementById("_acceptLicenseDate").value;
					_drivingCarType = document.getElementById("_drivingCarType").value;
					drivingCarType = Insured.getDrivingCarTypeByNo(_drivingCarType);
					if(comcode.substring(0,2)=="31"){
						driverArray.push(driverName+"("+identifyNumber+")");
					}else{
						driverArray.push(driverName + "(驾驶证号码：" + drivingLicenseNo + 
								"，初次领证日期：" + acceptLicenseDate + "，准驾车型：" + drivingCarType + ")");
					}
				}
				for(var i=0;i< driverArray.length;i++){
					if(i == driverArray.length - 1){
						result = result + driverArray[i]
					}else{
						result = result + driverArray[i]+"、"
					}
				}
				return result;
			},
	
			/**
			 * @author sinosoft
			 * @description 显示移动电话和固定电话
			 * @param mobile 移动电话号
			 * @param phoneNumber 固定电话号
			 * @return 电话号
			 */
			sumPhoneNumber : function(mobile ,phoneNumber){
				var sumPhoneNumber = "";
				if(mobile != null && mobile != undefined && mobile != ""){
					sumPhoneNumber = sumPhoneNumber + "，手机号码：" + mobile;
				}
				if(phoneNumber != null && phoneNumber != undefined && phoneNumber != ""){
					sumPhoneNumber = sumPhoneNumber + "，固定电话：" + phoneNumber;
				}
				return sumPhoneNumber;
			},
	
			/**
			 * @author sinosoft
			 * @description 通过证件类型编号返回类型名称
			 * @param _identifyType 证件类型
			 * @return 证件类型名称
			 */
			getIdentifyTypeByNo : function(_identifyType){
				var identifyType = "";
				if(_identifyType != null && _identifyType != undefined && _identifyType != ""){
					if(_identifyType == "01"){
						identifyType = "身份证";
					}else if(_identifyType == "02"){
						identifyType = "户口薄";
					}else if(_identifyType == "03"){
						identifyType = "护照";
					}else if(_identifyType == "04"){
						identifyType = "军人证件";
					}else if(_identifyType == "05"){
						identifyType = "驾驶执照";
					}else if(_identifyType == "06"){
						identifyType = "返乡证";
					}else if(_identifyType == "07"){
						identifyType = "港澳身份证";
					}else if(_identifyType == "08"){
						identifyType = "工号";
					}else if(_identifyType == "09"){
						identifyType = "赴台通行证";
					}else if(_identifyType == "10"){
						identifyType = "港澳通行证";
					}else if(_identifyType == "15"){
						identifyType = "士兵证";
					}else if(_identifyType == "25"){
						identifyType = "港澳居民来往内地通行证";
					}else if(_identifyType == "26"){
						identifyType = "台湾居民来往内地通行证";
					}else if(_identifyType == "31"){
						identifyType = "组织机构代码证";
					}else if(_identifyType == "99"){
						identifyType = "其他";
					}
				}
				return identifyType;
			},
	
			/**
			 * @author sinosoft 
			 * @description 通过准驾车型编号返回名称
			 * @param _drivingCarType 准驾车型编号
			 * @return 准驾车型名称
			 */
			getDrivingCarTypeByNo : function(_drivingCarType){
				var drivingCarType = "";
				if(_drivingCarType != null && _drivingCarType != undefined && _drivingCarType != ""){
					if(_drivingCarType == "A1"){
						drivingCarType = "大型客车";
					}else if(_drivingCarType == "A2"){
						drivingCarType = "牵引车";
					}else if(_drivingCarType == "A3"){
						drivingCarType = "城市公交车";
					}else if(_drivingCarType == "B1"){
						drivingCarType = "中型客车";
					}else if(_drivingCarType == "B2"){
						drivingCarType = "大型汽车";
					}else if(_drivingCarType == "C1"){
						drivingCarType = "小型汽车";
					}else if(_drivingCarType == "C2"){
						drivingCarType = "小型自动挡汽车";
					}else if(_drivingCarType == "C3"){
						drivingCarType = "低速载货汽车";
					}else if(_drivingCarType == "C4"){
						drivingCarType = "三轮汽车";
					}else if(_drivingCarType == "D"){
						drivingCarType = "普通三轮摩托车";
					}else if(_drivingCarType == "E"){
						drivingCarType = "普通二轮摩托车";
					}else if(_drivingCarType == "F"){
						drivingCarType = "轻便摩托车";
					}else if(_drivingCarType == "M"){
						drivingCarType = "轮式自行机械车";
					}else if(_drivingCarType == "N"){
						drivingCarType = "无轨电车";
					}else if(_drivingCarType == "P"){
						drivingCarType = "有轨电车";
					}
				}
				return drivingCarType;
			},
	
			/**
			 * @author sinosoft
			 * @description 上海收益人特约
			 * @return 收益人名称
			 * @deprecated
			 */
			getBeneficiaryName : function(){
				var strInsureFlag  = "00000000";
				var obj = document.getElementsByName("_insuredFlag");
				var objTopLen = parseInt(globalindex["insertInsuredRow"]);
				var beneficiaryName = "";
				for(var i=0;i<obj.length;i++){
			    	if(obj[i].checked){
			    		strInsureFlag = strInsureFlag.substring(0,i)+"1"+strInsureFlag.substring(i+1);
			    	}
				}
				for(var m=0;m<objTopLen;m++){
					if(document.getElementById("updateIndex").value == m){// 保存
						continue;
					}  	
					if(isNaN(document.getElementById("prpCinsureds["+m+"].insuredFlag"))&&document.getElementById("prpCinsureds["+m+"].insuredFlag")!=null){	
						if(document.getElementById("prpCinsureds["+m+"].insuredFlag").value.substring(4,5)=="1"){
							beneficiaryName = document.getElementById("prpCinsureds["+m+"].insuredName").value;
						}
					}
				}
				if(strInsureFlag.substring(4,5) != '0'){
					beneficiaryName = document.getElementById("_insuredName").value;
				}
				return beneficiaryName;
			},
			/**
			 * @author cj
			 * @description 检查车主与被保险人是否同一个人
			 * @param  pageCode
			 */
			checkInsureOwn : function(pageCode){
			  var strInsureFlag  = "00000000";
			  var obj = document.getElementsByName("_insuredFlag");
			  var objTopLen = parseInt(globalindex[pageCode]);
			  var riskCode = document.getElementById("riskCode").value;
			  var bizType=document.getElementById("bizType");
			  var ownerName = "";
			  var secureName = "";
			  var driverFlag = false;
			  //受益人
			  var beneficiaryFlag = false;
			  for(var i=0;i<obj.length;i++){
			     if(obj[i].checked){
			        strInsureFlag = strInsureFlag.substring(0,i)+"1"+strInsureFlag.substring(i+1);
			     }
			  }
			  for(var m=0;m<objTopLen;m++){
				if(document.getElementById("updateIndex").value == m){// 保存
					continue;
				}  	
			    if(isNaN(document.getElementById("prpCinsureds["+m+"].insuredFlag"))&&document.getElementById("prpCinsureds["+m+"].insuredFlag")!=null){	
				     if(strInsureFlag.substring(1,2)=="0" && document.getElementById("prpCinsureds["+m+"].insuredFlag").value.substring(1,2)=="1"){
				     	  secureName = document.getElementById("prpCinsureds["+m+"].insuredName").value;
				     }
				     if(strInsureFlag.substring(2,3)=="0" && document.getElementById("prpCinsureds["+m+"].insuredFlag").value.substring(2,3)=="1"){
				     	  ownerName = document.getElementById("prpCinsureds["+m+"].insuredName").value;
				     }   
				     if(strInsureFlag.substring(3,4)=="0" && document.getElementById("prpCinsureds["+m+"].insuredFlag").value.substring(3,4)=="1"){
				    	 driverFlag = true;
				     } 
				     if(strInsureFlag.substring(4,5)=="0" && document.getElementById("prpCinsureds["+m+"].insuredFlag").value.substring(4,5)=="1"){
				    	 beneficiaryFlag = true;
				     } 
			    }
			  }
			  if(strInsureFlag.substring(1,2)=="1" && strInsureFlag.substring(2,3)=="0"){
				 secureName = document.getElementById("_insuredName").value;      	
			  }
			  if(strInsureFlag.substring(1,2)=="0" && strInsureFlag.substring(2,3)=="1"){
			  	 ownerName = document.getElementById("_insuredName").value;  
			  }
			  if(strInsureFlag.substring(3,4)=="1" || driverFlag){
				  document.getElementById("prpCinsuredDiv_Flag").value = "1";
			  }else if(strInsureFlag.substring(3,4)=="0" && !driverFlag){
			          document.getElementById("prpCinsuredDiv_Flag").value = "0";
			  }
			  //上海受益人
			  if(strInsureFlag.substring(4,5)=="1" || beneficiaryFlag){
				  document.getElementById("prpCinsuredBon_Flag").value = "1";
			  }else if(strInsureFlag.substring(4,5)=="0" && !beneficiaryFlag){
			          document.getElementById("prpCinsuredBon_Flag").value = "0";
			  }
			  
			  if(secureName !="" && secureName != null && ownerName !="" && ownerName != null && secureName != ownerName){
				  document.getElementById("prpCinsuredOwn_Flag").value = "1";
			  	  if(riskCode == "DAA" || riskCode == "DAT" || riskCode == "DAZ" || riskCode == "DAV") {
			  		 if(bizType!=null&&bizType.value=="PROPOSAL"){
			  		       if(!(isNaN(document.getElementById("inititemkind_Flag")) && document.getElementById("inititemkind_Flag") != null
								  && document.getElementById("inititemkind_Flag").value == "1")){
						           alert("请先加载保险责任标签页")
						           return false
						   }
						   if(publicCache.isKindCIInited !=true){
							    alert("请先加载交强险标签页")
							    return false
						   }
			  		 }  
			  	  } 
			  }else{
			        document.getElementById("prpCinsuredOwn_Flag").value = "0";
			  } 
//			  if(isNaN(document.getElementById("iniPrpCengage_Flag")) && document.getElementById("iniPrpCengage_Flag") != null
//					  && document.getElementById("iniPrpCengage_Flag").value == "1"){
//				  Engage.insertEngageDevice();
//			  }
			  return true;
			},
			/**
			 * @author sinosoft
			 * @description 关系人初始化特约标志
			 * @return true/false
			 */
			initEngageFlag : function(){
				//DAB、DZB产品(非批改)单独处理，因为关系人标签不一样
				if(Common.isOther()){
					if(InsuredPickup.initEngageFlagOther()){
						return true;
					}
				}else{
				  var bizType = document.getElementById('bizType').value;
				  //检查标签页
				  if(!Insured.checkTabView()){
					  return false;
				  }
				  var strInsureFlag  = "00000000";
				  var obj = document.getElementsByName("_insuredFlag");
//				  for(var i=0;i<obj.length;i++){
//				     if(obj[i].checked){
//				    	 添加特约时，不用关注勾选框
//				        strInsureFlag = strInsureFlag.substring(0,i)+"1"+strInsureFlag.substring(i+1);
//				     }
//				  }
				  var table_device = document.getElementById('insertInsuredRow');
				  var rows_device = table_device.tBodies.item(0).rows;
				  var len = rows_device.length;
				  var ownerName = "";
				  var secureName = "";
				  var driverFlag = false;
				  //受益人
				  var beneficiaryFlag = false;
				  //取值
				  var vCount = parseInt(globalindex["insertInsuredRow"]);
				  if(isNaN(vCount)){
					  vCount = len;
				  }
				  for(var m=0;m<vCount;m++){
//					if(document.getElementById("updateIndex").value == m){// 保存
//						continue;
//					}
					if(bizType == 'ENDORSE'){
					    if(isNaN(document.getElementById("prpCinsureds["+m+"].insuredFlag"))&&document.getElementById("prpCinsureds["+m+"].insuredFlag")!=null){	
						     if(document.getElementById("prpCinsureds["+m+"].insuredFlag").value.substring(1,2)=="1" && 
						    		 document.getElementById("prpCinsureds["+m+"].flag").value.substring(0,1)!="B" && 
						    		 document.getElementById("prpCinsureds["+m+"].flag").value.substring(0,1)!="D"){
						     	  secureName = document.getElementById("prpCinsureds["+m+"].insuredName").value;
						     }
						     if(document.getElementById("prpCinsureds["+m+"].insuredFlag").value.substring(2,3)=="1" && 
						    		 document.getElementById("prpCinsureds["+m+"].flag").value.substring(0,1)!="B" && 
						    		 document.getElementById("prpCinsureds["+m+"].flag").value.substring(0,1)!="D"){
						     	  ownerName = document.getElementById("prpCinsureds["+m+"].insuredName").value;
						     }   
						     if(document.getElementById("prpCinsureds["+m+"].insuredFlag").value.substring(3,4)=="1" && 
						    		 document.getElementById("prpCinsureds["+m+"].flag").value.substring(0,1)!="B" && 
						    		 document.getElementById("prpCinsureds["+m+"].flag").value.substring(0,1)!="D"){
						    	 driverFlag = true;
						     } 
						     if(document.getElementById("prpCinsureds["+m+"].insuredFlag").value.substring(4,5)=="1" && 
						    		 document.getElementById("prpCinsureds["+m+"].flag").value.substring(0,1)!="B" && 
						    		 document.getElementById("prpCinsureds["+m+"].flag").value.substring(0,1)!="D"){
						    	 beneficiaryFlag = true;
						     } 
					    }
					}else{
					    if(isNaN(document.getElementById("prpCinsureds["+m+"].insuredFlag"))&&document.getElementById("prpCinsureds["+m+"].insuredFlag")!=null){	
						     if(document.getElementById("prpCinsureds["+m+"].insuredFlag").value.substring(1,2)=="1"){
						     	  secureName = document.getElementById("prpCinsureds["+m+"].insuredName").value;
						     }
						     if(document.getElementById("prpCinsureds["+m+"].insuredFlag").value.substring(2,3)=="1"){
						     	  ownerName = document.getElementById("prpCinsureds["+m+"].insuredName").value;
						     }
						     if(document.getElementById("prpCinsureds["+m+"].insuredFlag").value.substring(3,4)=="1"){
						    	 driverFlag = true;
						     }
						     if(document.getElementById("prpCinsureds["+m+"].insuredFlag").value.substring(4,5)=="1"){
						    	 beneficiaryFlag = true;
						     } 
					    }
					}
				  }
				  	  // 被保险人
				  	  if(strInsureFlag.substring(1,2)=="1" && strInsureFlag.substring(2,3)=="0"){
						 secureName = document.getElementById("_insuredName").value;      	
					  }
					  if(strInsureFlag.substring(1,2)=="0" && strInsureFlag.substring(2,3)=="1"){
					  	 ownerName = document.getElementById("_insuredName").value;  
					  }
					  //指定驾驶人
					  if(strInsureFlag.substring(3,4)=="1" || driverFlag){
						  document.getElementById("prpCinsuredDiv_Flag").value = "1";
					  }else if(strInsureFlag.substring(3,4)=="0" && !driverFlag){
					          document.getElementById("prpCinsuredDiv_Flag").value = "0";
					  }
					  //上海受益人
					  if(strInsureFlag.substring(4,5)=="1" || beneficiaryFlag){
						  document.getElementById("prpCinsuredBon_Flag").value = "1";
					  }else if(strInsureFlag.substring(4,5)=="0" && !beneficiaryFlag){
					          document.getElementById("prpCinsuredBon_Flag").value = "0";
					  }
					  //车主
					  if(secureName !="" && secureName != null && ownerName !="" && ownerName != null && secureName != ownerName){
					  	document.getElementById("prpCinsuredOwn_Flag").value = "1";
					  }else{
					        document.getElementById("prpCinsuredOwn_Flag").value = "0";
					  }
					  
					  //拖车服务特约条款
					  var table = document.getElementById('itemKindSub');
					  if(table != null) {
						  
						  var udFlag = "0";
						  document.getElementById("xzFlag").value = "0";
						  document.getElementById("kbFlag").value = "0";
						  document.getElementById("sbFlag").value = "0";
						  if(bizType == 'ENDORSE'){
							  if(document.getElementById("kbFlag")!= null){
								  document.getElementById("kbFlag").value = "0";
							  }
							  if(document.getElementById("sbFlag")!= null){
								  document.getElementById("sbFlag").value = "0";
							  }
						  }
						  var kindCode;
						  var kindFlag;
						  var rows = table.tBodies.item(0).rows;
						  var regKind = /^(prpCitemKindsTemp){1}(\[){1}[0-9]{1,3}(\]){1}(\.){1}(kindCode){1}$/;
						  for(var i = 0;i < rows.length;i++){
							  var row = rows[i];
							  var els = row.all;
							  for(var j = 0; j< els.length;j++){
								  var elName = els[j].name ||els[j].id;
								  if (regKind.exec(elName)) {
									  kindCode = els[j];
									  var index = ItemKind.getGlobalIndex(kindCode.name ||kindCode.id);
									  kindFlag = document.getElementById("prpCitemKindsTemp["+index+"].flag");
									  var chooseflag = document.getElementById("prpCitemKindsTemp["+index+"].chooseFlag");
									  if(kindCode != null && kindCode != undefined && 
											  ((kindFlag != null && kindFlag != undefined && kindFlag.value != null
											  && kindFlag.value!= '' && kindFlag.value.substring(0,1) != "B" && kindFlag.value.substring(0,1) != "D"
											  && kindFlag.value.substring(0,1) != "S" && kindFlag.value.substring(0,1) != "T") || 
											  kindFlag == null)){
										  //拖车服务特约条款
										  if(kindCode.value == "050382" && chooseflag.checked){
											  udFlag = "1";  
											  continue;
										  }
										  //新增设备特约条款
										  if((kindCode.value == "050260" || kindCode.value == "050261") && chooseflag.checked){
											  document.getElementById("xzFlag").value = "1";
											  continue;
										  }
										  //送油、充电服务特约条款
										  if(kindCode.value == "050381" && document.getElementById("kbFlag")!= null && chooseflag.checked){
											  document.getElementById("kbFlag").value = "1";
											  continue;
										  }
										  if(kindCode.value == "050384" && chooseflag.checked){
											  document.getElementById("sbFlag").value = "1";
											  continue;
										  }
									  }
								  }
							  }
						  }
						  document.getElementById("udFlag").value = udFlag;
					  }
					  return true;
				}
			},
			/**
			 * @author sinosoft
			 * @description 检查非空字段以及重复校验
			 *<p>
			 *<font color=red>规则 : R30,R419,R442</font>
			 *</p>
			 * @param pageCode
			 * @param field
			 * @param idx
			 * @return true/false
			 */
			checkInsureAll : function(pageCode, field, idx){
			  var checkFlag = "0";
			  var strInsureFlag  = "00000000";
			  var driverNo = 0;
			  var obj = document.getElementsByName("_insuredFlag");
			  var objTopLen = parseInt(globalindex[pageCode]);
			  var arrElement = new Array();
			  var i=0;
			  
			  arrElement[i++] = document.getElementById("_insuredName");
			  
			  var insuredType = document.getElementById("_insuredType");
			  
			  if(insuredType.value == "1"){
				  arrElement[i++] = document.getElementById("_identifyNumber");
			  }
			  for(i=0;i<arrElement.length;i++) 
			  {
			    if(isEmptyField(arrElement[i])==true)
			    {
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
			  if(checkFlag == "0"){
			     errorMessage("请选择一个关系人角色！");
			     return false;
			  }else if(strInsureFlag.substring(0,2).indexOf("1")>-1){
				  var comCode = document.getElementById("comCode").value;
				  var insuredType = document.getElementById('_insuredType')
				  if(comCode.substring(0,2) == '32' && insuredType.value=="1"){
					  if(document.getElementById("_mobile").value==""){
						  alert("移动电话必须录入，请修改!");
						  return false;
					  }
					  var configedRepeatTimesLocal=document.getElementById("configedRepeatTimesLocal").value;
					  var repeatTimes=document.getElementById("_repeatTimes").value;
					  if(parseInt(configedRepeatTimesLocal) > 0 && parseInt(repeatTimes)>0){
						  if(parseInt(configedRepeatTimesLocal)<=parseInt(repeatTimes)){
								alert("此电话号码已重复录入"+repeatTimes+"次，不允许出单");
								return false;	
						  }
					  }
				  }
			    	 
			     if(document.getElementById("_insuredAddress").value==""){
				     errorMessage("投保人/被保险人地址不能为空！");
				     document.getElementById("_insuredAddress").focus();
				     return false;
			     }
			     
			     //LiChehui;角色为车主、指定驾驶人、受益人、港澳车车主或联系人时，审批状态不影响出单;20100926;begin;
			     var _auditStatus = document.getElementById("_auditStatus").value;
				 switch(_auditStatus){
					  case '':
					  case '2':break;
					  case '0':alert("此客户未经审核通过，不允许录单！");return false;
					  case '1':alert("此客户未经审核通过，不允许录单！");return false;
					  case '3':alert("此客户未经审核通过，不允许录单！");return false;
				 }
				 //LiChehui;角色为车主、指定驾驶人、受益人、港澳车车主或联系人时，审批状态不影响出单;20100926;end;
			  }else if(strInsureFlag.substring(3,4) == '1' &&document.getElementById("_insuredAddress").value=="" ){
			  	 errorMessage("指定驾驶人地址不能为空！");
			  	 document.getElementById("_insuredAddress").focus();
			  	 return false;
			  }
			  var insuredType = document.getElementById("_insuredType");
			  if(insuredType.value=="1"){
			  	var sex = document.getElementById("_sex");
			  	if(sex.value == ""){
			  		errorMessage("关系人类型为个人时，性别不能为空！");
			  		return false;
			  	}
			  }

			  if(!Insured.checkRepeatInsuredFlag(strInsureFlag)){
				  return false;
			  }
			  
			  // R419
			  if(strInsureFlag.substring(3,4)=="1"&&document.getElementById("prpCitemCar.useNatureCode").value=="211"&&driverNo>=3){
			      errorMessage("使用性质为“家庭自用”时，最多只允许录入三个指定驾驶人！");
			      return false;
			  }
			  // R442
			  if(strInsureFlag.charAt(3)=="1"){
			  	var riskCode = document.getElementById("riskCode").value;
				if(document.getElementById("prpCitemCar.useNatureCode").value!="211" && riskCode !="DGA"){
					errorMessage("只有使用性质为“家庭自用”时，才能录入指定驾驶人！");
					return false;
				}
			  	if(document.getElementById("_drivingLicenseNo").value == ""){
			  		alert("关系人角色选择指定驾驶人时，驾驶证号码不能为空！");
			  		document.getElementById("_drivingLicenseNo").focus();
			  		return false;
			  	}
			  	if(document.getElementById("_drivingYears").value == ""){
			  		errorMessage("关系人角色选择指定驾驶人时，驾龄不能为空！");
			  		document.getElementById("_drivingYears").focus();
			  		return false;
			  	}
			  	if(document.getElementById("_age").value == ""){
			  		errorMessage("关系人角色选择指定驾驶人时，年龄不能为空！");
			  		document.getElementById("_age").focus();
			  		return false;
			  	}
			  	if(document.getElementById("_sex").value != "1" && document.getElementById("_sex").value != "2"){
			  		errorMessage("关系人角色选择指定驾驶人时，性别必须录入！");
			  		try{
			  			document.getElementById("_sex").focus();
			  		}catch(e){}
			  		return false;
			  	}
			  	if(document.getElementById("_identifyType").value=="05" && document.getElementById("_drivingLicenseNo").value != document.getElementById("_identifyNumber").value){
			  		alert("指定驾驶人的证件类型为驾驶执照时，证件号码必须与驾驶证号码一致！");
			  		document.getElementById("_drivingLicenseNo").value = document.getElementById("_identifyNumber").value;
			  		return false;
			  	}
			    if(document.getElementById("_drivingCarType").value == ""&&document.getElementById("_insuredType").value == "1"&&document.getElementById("CarKindLicense").value == "") {
			  	  alert("关系人角色选择指定驾驶人时，准驾车型不可以为空！");
			  	  return false;
			    }
			    //add by lujunfeng 20110803 指定驾驶人判断上年违章次数和初次领证日期是否为空
			    if(document.getElementById("_causetroubleTimes").value == "") {
			  	  alert("关系人角色选择指定驾驶人时，上年违章次数不可以为空！");
			  	  document.getElementById("_causetroubleTimes").focus();
			  	  return false;
			  }
			  
			    if(document.getElementById("_acceptLicenseDate").value == "") {
			  	  alert("关系人角色选择指定驾驶人时，初次领证日期不可以为空！");
			  	  document.getElementById("_acceptLicenseDate").focus();
			  	  return false;
			    }
			  }
			  
			  var _phoneNumber = document.getElementById("_phoneNumber").value;
			  var _mobile = document.getElementById("_mobile").value;
			  var _drivingCarType = document.getElementById("_drivingCarType").value;
			  var _insuredType = document.getElementById("_insuredType").value;
			  var _carKindLicense = document.getElementById("CarKindLicense").value;
			  // R30
			  if(_phoneNumber == "" && _mobile == ""){
			  	alert("固定电话和移动电话不可以同时为空！");
			  	return false;
			  }
			  var el_table_Insured = document.getElementById("insertInsuredRow");
			  var el_tbody_Insured = el_table_Insured.tBodies.item(0);
			  var vCount = parseInt(globalindex["insertInsuredRow"]);
			  for (var i = 0; i < vCount; i++)
			  {
				  	if(document.getElementById("updateIndex").value == i){// 保存
				  		continue;
				  	}
				    if(document.getElementById("prpCinsureds["+i+"].identifyType")!=null&&document.getElementById("prpCinsureds["+i+"].identifyType").value=="01"){
				    	if(Insured.compare(document.getElementById("prpCinsureds["+i+"].insuredFlag").value,document.getElementById("_insuredFlag").value)){
				    		var IDCARD_SHIELD = document.getElementById("IDCARD_SHIELD");
				    		if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1"){
					    		if(document.getElementById("prpCinsureds["+i+"].identifyNumber").value==document.getElementById("_identifyNumber1").value)
					    		{
					    			alert("身份证号码不能重复！");
					    			return false;
					    		}
				    		}else{
					    		if(document.getElementById("prpCinsureds["+i+"].identifyNumber").value==document.getElementById("_identifyNumber").value)
					    		{
					    			alert("身份证号码不能重复！");
					    			return false;
					    		}
				    		}
				    	}
					 }
				  }
				  return true;
			},
			/**
			 * @author sinosoft
			 * @description 关系人关系判断，保证同一个关系只有一条数据
			 * @param insuredFlag1 
			 * @param insuredFlag2 
			 * @return true/false
			 */
			compare : function(insuredFlag1,insuredFlag2){
			    for(var i =0;i<insuredFlag1.length;i++){
			        if(insuredFlag1.charAt(i)=='1'&& insuredFlag2.charAt(i)=='1'){
			            return true;
			        }
			    } 
			    return false;
			}, 
	
			/**
			 * @author sinosoft
			 * @description 续保单保存时，校验固定电话和移动电话不能同时为空
			 * @return 通过则返回true，不通过返回false
			 */
			checkPhoneBeforeSave : function(){
				if(document.getElementById("insertInsuredRow") != null){
					var tabs = el_tableView.get('tabs');
				    for(var i=0;i<tabs.length;i++){
				    	if(tabs[i].get("id") == "insuredTab"){
				    		var insuredTab = tabs[i];
				    		if(insuredTab.get('dataLoaded'))
				    		{
			    				var index = document.getElementById("hidden_index_insured").value;
							    var len = parseInt(globalindex["insertInsuredRow"]);
							    if(isNaN(len)&& parseInt(index)!=0){
								    len = parseInt(index);
							    }
							    for(var j=0; j<len; j++){
			        				if(document.getElementById('prpCinsureds['+j+'].phoneNumber')!=null 
			        						&& document.getElementById('prpCinsureds['+j+'].mobile').value!=null
			        						&& document.getElementById('prpCinsureds['+j+'].phoneNumber').value == ''
			        						&& document.getElementById('prpCinsureds['+j+'].mobile').value == ''){
			        					errorMessage("固定电话和移动电话不可以同时为空！");
			        					el_tableView.set('activeTab', tabs[i]);
			        					return false;
			        				}
			        			}
	
				    		}
				    		break;
				    	}
				    }
				}
				return true;
			},
	
			/**
			 * @author sinosoft
			 * @description 检验组织机构代码/个人身份证号码长度
			 *<p>
			 *<font color=red>规则 : 调用:R29</font>
			 *</p>
			 * @param field
			 * 		   输入域
			 * @return 校验通过 true,校验失败 false
			 */
			checkIdentifyNumberID : function(field){
					// 证件类型只有是身份证的时候才校验
				if(document.getElementById("_insuredType").value=="1"&&document.getElementById("_identifyType").value=="01")
				{
				   if(field.value==""){
				      document.getElementById("_age").value = "";
				      document.getElementById("_drivingLicenseNo").value = "";
				      return false;
				   }
				   // R29
				   var idx = "0";
				   var IDCARD_SHIELD = document.getElementById("IDCARD_SHIELD");
				   if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1"
					   && field == document.getElementById("_identifyNumber") && document.getElementById("_identifyNumber").readOnly){
				   }else{
					   if(!Insured.isChinaIDCard(field.value, idx)){// 用客户管理系统的身份证校验
					       document.getElementById("_age").value = "";
					       field.focus();
						   field.select();
						   return false;
					   }else{
						   Insured.writeDivLicenseNo();
					   }
				   }
				}else  if(document.getElementById("_insuredType").value=="1"&&document.getElementById("_identifyType").value=="16"){
					//身份证
					 if(field.value==""){
						 document.getElementById("_age").value = "";
					     document.getElementById("_drivingLicenseNo").value = "";
						 return false;
					  }
					  if(trim(field.value).length!=15){
						    alert("输入的外国人永久居留身份证号码必须为15位！");
						    field.value="";
						    field.focus();
							return false;
					  }
				}else if(document.getElementById("_insuredType").value=="1"){
					Insured.writeDrivingLicenseNo(field);
				}else if(document.getElementById("_insuredType").value=="2"){	    
					if(field.value!=""&&field.readOnly==false&&!Insured.isValidEntpCode(field.value)){
						 field.focus();
				   	  	 field.select();
				   	  	 return false;
					}
				}
			    return true;
			},
			/**
			 * @author huxiaodong
			 * @description 驾驶证号码的blur事件<br/>
			  *<p>
			 *<font color=red>规则 : 调用:R420,R641</font>
			 *</p>
			 *<p>
			 *1>校验字符串是否为整型 <br/> 2>校验驾驶证号码<br/>
			 *</p>
			 * @param filed
			 *            表单域
			 * @return
			 */
			blurDrivingLicenseNo : function(filed){
				//校验字符串是否为整型
				checkLength(filed);
				//R420,R641 校验驾驶证号码
				Insured.checkDrivingLicenseNo(filed);
			},
			changeDrivingLicenseNo : function(filed){
                if(document.getElementById("_drivingLicenseNo") != null && document.getElementById("_drivingLicenseNoLSJ") != null){
                	document.getElementById("_drivingLicenseNoLSJ").value = document.getElementById("_drivingLicenseNo").value
                }
			},
			onclickDrivingLicenseNo : function(){
				var IDCARD_SHIELD = document.getElementById("IDCARD_SHIELD");
                if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1" && document.getElementById("_drivingLicenseNo").value != ""){
            		if(confirm("请确认是否修改驾驶证")){
            			document.getElementById("_drivingLicenseNo").value = "";//---确定
            			document.getElementById("_drivingLicenseNoLSJ").value = "";
            			document.getElementById("_drivingLicenseNo").focus();
                    }else{
                    	document.getElementById("_drivingLicenseNo").blur();
                    	return false;//---取消
                    }  
                }
			},
			onclickDrivingLicenseNoCqp : function(field){
				var name = field.id || field.name;
				var intIndex = name.substring(name.indexOf('[')+1,name.indexOf(']'));
				var IDCARD_SHIELD = document.getElementById("IDCARD_SHIELD");
                if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1"
                	&& document.getElementById("drivingLicenseNos["+intIndex+"]") != null
                	&& document.getElementById("drivingLicenseNos["+intIndex+"]").value != ""){
            		if(confirm("请确认是否修改驾驶证")){
                    	document.getElementById("drivingLicenseNos["+intIndex+"]").focus();//---确定
                    	document.getElementById("drivingLicenseNos["+intIndex+"]").value = "";
            			document.getElementById("prpCinsureds["+intIndex+"].drivingLicenseNo").value = "";//---确定
                    }else{
                    	document.getElementById("drivingLicenseNos["+intIndex+"]").blur();
                    	return false;//---取消
                    }  
                }
			},
			changeDrivingLicenseNoCqp : function(field){
				var name = field.id || field.name;
				var intIndex = name.substring(name.indexOf('[')+1,name.indexOf(']'));
				if(document.getElementById("prpCinsureds["+intIndex+"].drivingLicenseNo") != null){
					document.getElementById("prpCinsureds["+intIndex+"].drivingLicenseNo").value = field.value;
				}
			},
			/**
			 * @author sinosoft
			 * @description 校验驾驶证号码
			 *<p>
			 *<font color=red>规则 : R420,R641</font>
			 *</p>
			 * @param field
			 * 				输入域
			 * @return 校验通过 true,校验失败 false
			 */
			checkDrivingLicenseNo : function (field){
				var drivingLicenseNo = trim(field.value);
				var isCqp;
				var identifyType;
				var countryCode;
				if(document.getElementById("isCqp") != null) {
					isCqp = document.getElementById("isCqp").value;
				}
				// add by zhangqingtao 在DAA，DZA，DAZ，DAG时证件类型为 07 10 25 时 不用校验号码长度 20121205 begin
				if(isCqp != null && isCqp == "1") {
					var name = field.id || field.name;
					var intIndex = name.substring(name.indexOf('[')+1,name.indexOf(']'));
					identifyType = document.getElementById("prpCinsureds["+intIndex+"].identifyType");
					countryCode = document.getElementById("prpCinsureds["+intIndex+"].countryCode");
					if(countryCode != null && countryCode.value ==""){
						countryCode = document.getElementById("_countryCode");
					}
				}else{
					identifyType = document.getElementById("_identifyType");
					countryCode = document.getElementById("_countryCode");
				}
				//PRPALL-5259 驾驶证号码的长度控制
				if((countryCode != null && countryCode.value == "CHN")
						&&(identifyType != null && (identifyType.value == "01" || identifyType.value == "02"))){
					if(drivingLicenseNo.length != 15 && drivingLicenseNo.length != 18){
			      		errorMessage("驾驶证号码必须为15位或18位");
		      			if(isCqp != null && isCqp == "1"){
//						    现在为onchange事件可不聚焦  				
		      			}else{
		      				field.focus();
		      			}
			      		field.select();
			      		return false;
					}
				}else{
					if(drivingLicenseNo == ""){
			      		errorMessage('驾驶证号码不允许为空！');
						return false;
					}
				}
				return true;
			},
			/**
			 * @author sinosoft
			 * @description 保存前校验驾驶证号码
			 * @param field
			 * 				输入域
			 * @return 校验通过 true,校验失败 false
			 */
			beforeSaveDrivingLicenseNo : function(field){
				var tabs = el_tableView.get('tabs');
				var drivingLicenseNo = trim(field.value);
				var name = field.id || field.name;
				var intIndex = name.substring(name.indexOf('[')+1,name.indexOf(']'));
				var identifyType = document.getElementById("prpCinsureds["+intIndex+"].identifyType");
				var countryCode = document.getElementById("prpCinsureds["+intIndex+"].countryCode");
				var IDCARD_SHIELD = document.getElementById("IDCARD_SHIELD");
				if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1"
					&& drivingLicenseNo != "" && drivingLicenseNo.length > 3 && drivingLicenseNo.substring(0, 3) == "LSJ"){
					return true;
				}else{
					//PRPALL-5259 驾驶证号码的长度控制
					if((countryCode != null && countryCode.value == "CHN")
							&&(identifyType != null && (identifyType.value == "01" || identifyType.value == "02"))){
						if(drivingLicenseNo.length != 15 && drivingLicenseNo.length != 18){
				      		errorMessage("驾驶证号码必须为15位或18位");
				      		el_tableView.set('activeTab', tabs[1]);
				      		return false;
						}
					}else{
						if(drivingLicenseNo == ""){
				      		errorMessage('驾驶证号码不允许为空！');
				      		el_tableView.set('activeTab', tabs[1]);
							return false;
						}
					}
				}
				return true;
			},
			
			/**
			 * @author huxiaodong
			 * @description 驾龄的blur事件<br/>
			 *<p>
			 *1>校验字符串是否为整型 <br/> 2>校验驾龄<br/>
			 *3>车辆条款类型为家庭自用、尊贵人生、天津店面直销时,修改关系人中:指定驾驶人、性别、驾龄、年龄时清空总保费<br/>
			 *</p>
			 * @param filed
			 *            表单域
			 * @return
			 */
			blurDrivingYears : function(filed){
				//校验字符串是否为整型
				checkIsInteger(filed);
				//校验驾龄
				Insured.checkCarDriverAge(filed);
				Insured.changeAge(filed);
				//车辆条款类型为家庭自用、尊贵人生、天津店面直销时,修改关系人中:指定驾驶人、性别、驾龄、年龄时清空总保费
				Insured.clearSumPremium_();
			},
			
			/**
			 * @author sinosoft
			 * @description 校验驾龄
			 * @param field
			 * 				表单域
			 * @return 通过true,不通过false
			 */
			checkCarDriverAge : function(field)
			{
			  var age = parseInt(field.value);
			  if(age>100)
			  {
			    errorMessage("请准确输入驾龄");
			    field.value = '';
			    field.focus();
			    field.select();
			    return false;
			  }
			  if(age<0)
			  {
			    errorMessage("驾龄不能为负数,请准确输入驾龄");
			    field.value = '';
			    field.focus();
			    field.select();
			    return false;
			  }
			  if(field.value.length>1 && field.value.substring(0,1) =="0"){
				alert("不能为以0开头的数字，请输入合理的数字");
				field.value = '';
				field.focus();
				field.select();
				return false;
			  }
			  return true;
			},
			/**
			 * @author sinosoft
			 * @description 校验驾龄
			 * @param field
			 * 				表单域
			 * @return 通过true,不通过false
			 */
			changeAge : function (field){
				var age;
				var drivingAge;
				var isCqp = document.getElementById("isCqp");
				if(isCqp != null && isCqp == "1") {
					age = document.getElementById("prpCinsureds["+idx+"].age");
					drivingAge = document.getElementById("prpCinsureds["+idx+"].drivingYears");
				}else{
					age = document.getElementById("_age");
					drivingAge = document.getElementById("_drivingYears");
				}
				if(age != null && age.value != "" && drivingAge!=null && drivingAge.value!=""){
				     if(parseInt(drivingAge.value) > parseInt(age.value)){
					    errorMessage("驾龄不能大于年龄!");
					    drivingAge.value = '';
					    drivingAge.focus();
					    drivingAge.select();
					    return false;          
				     }	
			    }
			},

			/**
			 * 校验数字不能为负数且不能为以0开头的整数
			 * @param field
			 * @return
			 */
			checkIsNumber : function(field){
				var integer = parseInt(field.value);
//				var parent = /^([1-9]\d{0,14})$/;
				if(integer<0){
					field.value = "";
					alert("不能为负数，请输入合理的数字");
				}
				if(field.value.length>1 && field.value.substring(0,1) =="0"){
					field.value = "";
					alert("不能为以0开头的数字，请输入合理的数字");
				}
			},
			/**
			 * @author huxiaodong
			 * @description 移动电话的blur事件<br/>
			 *<p>
			 *<font color=red>规则 :调用:R628,R635/font>
			 *</p>
			 *<p>
			 *1>校验字符串是否为整型<br/> 2> 验证移动电话号码<br/>
			 *</p>
			 * @param filed
			 *            表单域
			 * @return
			 */
			blurMobile : function(filed){
				var _mobile= document.getElementById("_mobile");
				var isCqp = document.getElementById("isCqp");
				//校验字符串是否为整型
				if(checkIsInteger(filed)==false){
					filed.value = "";
		 			if(_mobile != null && _mobile.value != ""){
						 _mobile.value = "";
					}
					if(!(isCqp != null && isCqp.value == "1")) {
			 			filed.focus();
			 			filed.select();
					}
			 		return false;
				}
				//R628,R635 验证移动电话号码
				Insured.checkMobile(filed);
			},
			
			/**
			 * @author sinosoft
			 * @description 验证移动电话号码
			 *<p>
			 *<font color=red>规则 : R628,R635</font>
			 *</p>
			 * @param obj
			 * 		   输入域
			 * @return
			 */
			checkMobile : function(obj){
				var _mobile= document.getElementById("_mobile");
			    var num = obj.value;
			 	var partten = /^1[3,5,4,7,8,9]\d{9}$/;
			 	var partten1=/^1[3,5,4,7,8,9]\d{1}\*{4}\d{4}$/;
			 	// R628
			 	if(num!=null&&num!="")
			 	{
			 		if(num.length!=11){ 			
			 			alert("移动电话号码必须为11位有效数字!");
			 			obj.value = "";
			 			if(_mobile != null && _mobile.value != ""){
							 _mobile.value = "";
						}
				 		obj.focus();
				 		obj.select();
				 	}
			 		// R635
			 		if(!partten.test(num)&&!partten1.test(num)){
				 		alert("移动电话格式错误。例如：15821345169");
				 		//obj.value = "";
				 		if(_mobile != null && _mobile.value != ""){
							// _mobile.value = "";
						}
				 		obj.focus();
				 		obj.select();
				 	}
			 	}
			},
	
			/**
			 * @author sinosoft
			 * @description 验证固定电话
			  *<p>
			  *<font color=red>规则 : R642</font>
			  *</p>
			 * @param obj
			 * 		   输入域
			 * @return  校验失败 false
			 */
			checkPhone : function(obj){
				var _phoneNumber = document.getElementById("_phoneNumber");
				var num = obj.value;
				var partten = /^.*[u4E00-u9FA5]+.*$/;	// 汉字正则表达式
				//var partten=/^[+]{0,1}(\d){1,4}[ ]?([-]?\d{0,2}(\d|[*]){3}\d{3})+$/;
				var partten=/^[+]{0,1}(\d){1,4}[ ]?([-]?\d{0,2}(\d|[*]){3}\d{3})+$/; 
			    if(num!=null&&num!="")
				{
					if(!partten.test(num)){
						alert("请输入合法的固定电话!");
						//obj.value = "";
						if(_phoneNumber != null && _phoneNumber.value != ""){
							//_phoneNumber.value = "";
						}
						obj.focus();
					       return false;
					}
				}
				var length = obj.value.length;
				// R642
				if(length>0 && length!=7 && length!=8 && length!=11 && length!=12)
				{
					alert("固定电话必须为7、8、11或12位数字!");
					obj.value = "";
					if(_phoneNumber != null && _phoneNumber.value != ""){
						_phoneNumber.value = "";
					}
					obj.focus();
			        return false;
				}
				return true;
			},
			/**
			 * @author sinosoft
			 * @description 验证电子邮箱的格式
			 * @param field
			 * 		  输入域
			 * @return 如果为空，定义校验通过 如果电子邮箱格式正确，验证通过 如果电子邮箱格式错误，不通过
			 */
			checkEmail : function(field){
			  if(!field.value==""){
				  if(field.value.match(/([\w-]+\.{0,1}){0,9}[\w-]+@{1}([\w-]+\.{1}){1,2}\w{2,4}(\.{0,1}\w{2}){0,1}/ig)!=field.value)
				  {
				  	alert("电子邮箱格式不正确，请重新输入");
				    field.focus();
				    return false;
					}
			  }
			},
	
			/**
			 * @author sinosoft
			 * @description 非空字段校验
			 *<p>
			 *<font color=red>规则 : R419</font>
			 *</p>
			 * @return 通过true,不通过false
			 */
			checkInsureAllInput : function(){
			   var _bizType = document.getElementById("bizType");
			   var editType = document.getElementById("editType");
			   var riskCode = document.getElementById("riskCode");
			   var comcode = document.getElementById("comCode").value;
			   var tabs = el_tableView.get('tabs');
			   var index = document.getElementById("hidden_index_insured").value;
			   var len = parseInt(globalindex["insertInsuredRow"]);
			   if(isNaN(len)&& parseInt(index)!=0){
				  len = parseInt(index);
			   }
			   var carOwnerFlag = false;
			   var driverFlag = false;
			   var driverCount = 0;
			   //委托人
			   var principalFlag = false;
			   var flag = "0";
			   var reInsuredFlag10 = 0;
			   var reInsuredFlag01 = 0;
			   var reInsuredFlag001 = 0;//车主
			   for(var j=0;j<len;j++){
				  if(document.getElementById("prpCinsureds["+j+"].insuredFlag")!=null){
					  //Add by LiChenhui;转投保保存时校验指定驾驶人只能是家庭自用时选择;20100805;begin;
					  var insuredFlag = document.getElementById("prpCinsureds["+j+"].insuredFlag");
					  var useNature = document.getElementById("prpCitemCar.useNatureCode");
					  var insuredType = document.getElementById("prpCinsureds["+j+"].insuredType");
					  var unitType = document.getElementById("prpCinsureds["+j+"].unitType");
					  var row=getTR(insuredFlag)
					  var flagValue = document.getElementById(getFlagELName(row)).value;
	
					  if(insuredFlag.value.substring(3,4)=="1" && useNature.value!="211" && riskCode.value !="DGA" && flagValue.substring(0,1) != "B" && flagValue.substring(0,1) != "D"){
					  	  errorMessage("只有当使用性质为“家庭自用”时，才能录入指定驾驶人！");
				  		  el_tableView.set('activeTab', tabs[1]);
				  		  return false;
					  }
					//Add by LiChenhui;转投保保存时校验指定驾驶人只能是家庭自用时选择;20100805;end;
					  //add by lujunfeng 20110811 保存时不需要校验港澳车车主、受益人固定电话和移动电话
					  var insuredFlagValue = "";
					  if(insuredFlag.value.trim().length>=8){
						  insuredFlagValue = insuredFlag.value.trim().substring(0,8);
					  }
					  if(flagValue.substring(0,1) != "B" && flagValue.substring(0,1) != "D" && insuredFlagValue !="00100000" && insuredFlagValue !="00001000" && insuredFlagValue !="00000100" 
					       && insuredFlagValue !="00101000" && insuredFlagValue !="00100100" && insuredFlagValue !="00001100" && insuredFlagValue !="00101100"){
						  if(document.getElementById('prpCinsureds['+j+'].phoneNumber').value == ''
				  				&& document.getElementById('prpCinsureds['+j+'].mobile').value == ''){
				  				errorMessage("固定电话和移动电话不可以同时为空！");
				  				el_tableView.set('activeTab', tabs[1]);
				  				return false;
				  			} 
					  }
					  
					  //46307 广西车险客户信息真实性管理办法
					  if(comcode.substring(0,2) == '32' && flagValue.substring(0,1) != "B" && flagValue.substring(0,1) != "D"
						  && "COPY_PROPOSAL,RENEWAL,COPY_POLICY".indexOf(editType.value)>=0 
						  && insuredType.value=="1" && insuredFlagValue.substring(0,2).indexOf("1")>-1){						  
						  if(document.getElementById('prpCinsureds['+j+'].mobile').value == ''){
							  alert("移动电话必须录入，请修改!");
							  return false;	
						  }
						  var configedRepeatTimesLocal=document.getElementById("configedRepeatTimesLocal").value;
						  var repeatTimes=document.getElementById("repeatTimes["+j+"]").value;
						  if(parseInt(configedRepeatTimesLocal) > 0 && parseInt(repeatTimes)>0){
							  if(parseInt(configedRepeatTimesLocal)<=parseInt(repeatTimes)){
									alert("此电话号码已重复录入"+repeatTimes+"次，不允许出单");
									return false;	
							  }
						  }
					  }
					  if(flagValue.substring(0,1) != "B" && flagValue.substring(0,1) != "D" ){
						  if(insuredFlagValue.substring(0, 1) == "1"){
							  if(document.getElementById('prpCinsureds['+j+'].countryCode').value == ''){
								  errorMessage("投保人国籍不能为空，请重查客户信息");
								  el_tableView.set('activeTab', tabs[1]);
								  if(document.getElementById('bizType').value != 'ENDORSE'){
									  return false;
								  }
							  }
						  }
					  }					  	
					  if(flagValue.substring(0,1) != "B" && flagValue.substring(0,1) != "D" && insuredFlag.value.substring(0,2).indexOf("1")>-1){
						  var auditStatus = document.getElementById("prpCinsureds["+j+"].auditStatus");
						  if(auditStatus.value!="" && auditStatus.value!="2"){
							  errorMessage("关系人未经审核通过，不允许录单！");
							  el_tableView.set('activeTab', tabs[1]);
				  			  return false;
						  }
					  }
					   var deletePgflag = true;
					   if(_bizType.value == "ENDORSE"){
			   		      
			   		       if(flagValue.substring(0,1)=="B"||flagValue.substring(0,1)=="D"){
			   		      	   deletePgflag = false;
			   		       }
			   		   }
					   if(deletePgflag){
						   if(insuredFlag.value.substring(0,2)=="11"){
						      flag = 2;
						   }else if((insuredFlag.value.substring(0,1)=="1")||(insuredFlag.value.substring(1,2)=="1")){
						      flag++;
						   }
						   if(insuredFlag.value.substring(0,1)=="1"){
						      reInsuredFlag10++;
						   }
						   if(insuredFlag.value.substring(1,2)=="1"){
						      reInsuredFlag01++;
						   }
						   if(insuredFlag.value.substring(2,3)=="1"){
						       carOwnerFlag = true;
						       reInsuredFlag001++;
						   }
						   if(insuredFlag.value.substring(3,4)=="1"){
						       driverFlag = true;
						       driverCount++;
						   }
						   if(insuredFlag.value.substring(7,8)== "1"){
							   principalFlag = true;
						   }
					   }
					   
					   // 续保或保单复制需要清空关系人代码并重新载入，如关系人没有关系人代码需重新载入
					   var insuredCode = document.getElementById("prpCinsureds["+j+"].insuredCode");
					   //var flag = document.getElementById("prpCinsureds["+j+"].flag");
					   if((insuredCode == null || insuredCode.value == null || insuredCode.value.trim() == '')
							   && (editType.vlaue == 'RENEWAL' || editType.value == "COPY_POLICY") ){
						   var insuredName = document.getElementById("prpCinsureds["+j+"].insuredName");
						   errorMessage("关系人：" + insuredName.value + "的关系人代码为空，需要重新载入。");
					  	   el_tableView.set('activeTab', tabs[1]);
					  	   return false;
					   }
					   if(principalFlag && insuredType.value != '1'){
						   errorMessage("委托人：" + insuredName.value + "类型不能为必须为个人！");
					  	   el_tableView.set('activeTab', tabs[1]);
					  	   return false;
					   }
						//关系人为团体客户的投保人、 被保险人、车主单位性质不能为空(上海平台校验)
						if(comcode.substring(0,2)=="31" && insuredType.value == "2" 
								&& (reInsuredFlag10 == "1" || reInsuredFlag01 == "1" || carOwnerFlag)){
							var message = "";
							if(reInsuredFlag10 == "1"){
								message += "[投保人]";
							}
							if(reInsuredFlag01 == "1"){
								message += "[被保险人]";
							}
							if(carOwnerFlag){
								message += "[车主]";
							}
								message += "单位性质不能为空！";
							if(trim(unitType.value) == ""){
								errorMessage(message);
							  	el_tableView.set('activeTab', tabs[1]);
								return false;
							}
						}
				  }
			   }
			    // R419
				if(driverCount > 3){
					errorMessage("使用性质为“非营业个人”时，最多只允许录入三个指定驾驶人！");
					el_tableView.set('activeTab', tabs[1]);
					return false;   
				}
				if(isGuangdong()){
					if(guangZhouFlag){
						if(countInsuredRelationship()>1){
							errorMessage("广州地区只可录入一名指定驾驶员!");
							return false;
						}
					}else{
						if(countInsuredRelationship()>1){
							errorMessage("广东控制:只能录一个驾驶员!");
							return false;
						}
					}
				}
				if(driverFlag){
				   document.getElementById("prpCmainCar.agreeDriverFlag").value = "1";
				}else{
				   document.getElementById("prpCmainCar.agreeDriverFlag").value = "0";
				}
				if(reInsuredFlag01>1 || reInsuredFlag10 >1 || reInsuredFlag001 > 1){
					errorMessage("请不要录入重复的投保人/被保险人/车主");
					el_tableView.set('activeTab', tabs[1]);
					return false;
				}
				if(flag<2){
				   errorMessage("必须录入投保人和被保险人！");
				   el_tableView.set('activeTab', tabs[1]);
				   return false;
				}
				if(!carOwnerFlag){
					/*add by zhaoxiaojie 20100820 DAE,DGA,DAB,DZB去掉车主信息 begin*/
				   if("DAE,DGA,DAB,DZB".indexOf(riskCode.value) < 0){
					   var message = "必须录入车主信息";
					   //上海保存时校验车主
					   if(comcode.substring(0,2)=="31") {
						   var owner = document.getElementById("owner");
						   if(owner!=null && trim(owner.value)!=""){
							   message += "(" + owner.value + ")";
						   }
					   }
				       errorMessage(message);
					   el_tableView.set('activeTab', tabs[1]);
					   return false;
				   }
				   /*add by zhaoxiaojie 20100820 DAE,DGA,DAB,DZB去掉车主信息 end*/
				}
			},
			/**
			 * @author sinosoft
			 * @description 查看关系人信息
			 * @param field
			 * 		   输入域
			 * @return
			 */
			showInsured : function(field){
			   tr = document.getElementById("prpCinsuredsTr["+field.title+"]");
			   Insured.showInsuredDetail(tr);
			},
			/**
			 * @author sinosoft
			 * @description 显示关系人的详细信息
			 * @param tr
			 * 		   标签域
			 */
			showInsuredDetail : function(tr){
			    if(document.getElementById("editType").value=="SHOW_PROPOSAL" || document.getElementById("editType").value=="SHOW_ENDORSE"){
			       document.getElementById("testtable").style.display = "";
			    }
				// 获取当前行记录信息
			    var comCode =  document.getElementById("prpCmain.comCode").value;
			    var riskCode = document.getElementById("riskCode").value;
			    var eleName = "";
			    var electronicPolicyFlag = document.getElementById("electronicPolicyFlag");
				if(electronicPolicyFlag != null && (comCode.substring(0,2) == "11" || 
						(electronicPolicyFlag.value == "2" && comCode.substring(0,2) == "36") 
						|| electronicPolicyFlag.value == "1" ) && (riskCode == "DAA" || riskCode == "DAV")){
					eleName = tr.cells[8].all[1].name;
				}else{
					eleName = tr.cells[7].all[1].name;
				}
				var IDCARD_SHIELD = document.getElementById("IDCARD_SHIELD");
				var index=eleName.substring(eleName.indexOf("[")+1,eleName.indexOf("]"));
				var _insuredFlagValue = document.getElementById("prpCinsureds["+index+"].insuredFlag").value ;
				var _insuredType = document.getElementById("prpCinsureds["+index+"].insuredType").value;
				var _insuredName = document.getElementById("prpCinsureds["+index+"].insuredName").value;
				var _insuredCode = document.getElementById("prpCinsureds["+ index +"].insuredCode").value;
				var _unitType = document.getElementById("prpCinsureds["+index+"].unitType").value;
				var _unifiedSocialCreditCode = document.getElementById("prpCinsureds["+index+"].unifiedSocialCreditCode").value;
				var _identifyType = document.getElementById("prpCinsureds["+index+"].identifyType").value;
				var _identifyNumber =document.getElementById("prpCinsureds["+index+"].identifyNumber").value;
				var _drivingYears = document.getElementById("prpCinsureds["+index+"].drivingYears").value;
				var _insuredAddress = document.getElementById("prpCinsureds["+index+"].insuredAddress").value;
				if((riskCode == "DAA" || riskCode == "DAV") && electronicPolicyFlag != null && 
						(comCode.substring(0,2)=="11" || electronicPolicyFlag.value == "1" || 
								(electronicPolicyFlag.value == "2" && comCode.substring(0,2)=="36" ))){
					var _email = document.getElementById("prpCinsureds["+index+"].email").value;
				}
				var _phoneNumber = document.getElementById("prpCinsureds["+index+"].phoneNumber").value;
				var _mobile = document.getElementById("prpCinsureds["+index+"].mobile").value;
				/*if(document.getElementById("mobile["+index+"]")!=null&&document.getElementById("mobile["+index+"]")!=undefined){
					var mobileNoYG =document.getElementById("mobile["+index+"]").value;
				}else if(document.getElementById("imobile")!=null&&document.getElementById("imobile")!=undefined){
					var mobileNoYG =document.getElementById("imobile").value;
				}else if(document.getElementById("prpCinsureds["+index+"].mobile")!=null&&document.getElementById("prpCinsureds["+index+"].mobile")!=undefined){
					var mobileNoYG =document.getElementById("prpCinsureds["+index+"].mobile").value;
				}else{
					var mobileNoYG ="";
				}*/
				if(document.getElementById("mobile["+index+"]")!=null&&document.getElementById("mobile["+index+"]")!=undefined){
						var mobileNoYG =document.getElementById("mobile["+index+"]").value;
				}else if(document.getElementById("prpCinsureds["+index+"].mobile")!=null&&document.getElementById("prpCinsureds["+index+"].mobile")!=undefined){
					var tr=document.getElementById("prpCinsureds["+index+"].mobile").parentNode.parentNode;
					var td=tr.childNodes;
					for(var i=0; i<td.length;i++){
						var input=td[i].childNodes;
						for(var j=0;j<input.length;j++){
							if(input[j].id=="imobile"){
								var mobileNoYG=input[j].value;
							}
						}
					}
				}
				if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1" && _identifyType == "01"){
					if(document.getElementById("identifyNumber["+index+"]") != null && document.getElementById("identifyNumber["+index+"]") != undefined){
						var identifyNumberLSJ = document.getElementById("identifyNumber["+index+"]").value;
					}else if(document.getElementById("prpCinsureds["+index+"].identifyNumber") != null && document.getElementById("prpCinsureds["+index+"].identifyNumber") != undefined){
						var tr = document.getElementById("prpCinsureds["+index+"].identifyNumber").parentNode.parentNode;
						var td = tr.childNodes;
						for(var i=0; i<td.length;i++){
							var input=td[i].childNodes;
							for(var j=0;j<input.length;j++){
								if(input[j].id == "iidentifyNumber"){
									var identifyNumberLSJ=input[j].value;
								}
							}
						}
					}
				}
				var _repeatTimes=document.getElementById("repeatTimes["+index+"]").value;
				
				if(document.getElementById("editType").value=="NEW" ){
					var _phoneNumber1 =  _phoneNumber;
					var _mobile1 = _mobile;
				}else{
					if(document.getElementById("bizType").value != "ENDORSE"){
						if(document.getElementById("phoneNumber["+index+"]") != null){
							var _phoneNumber1 = document.getElementById("phoneNumber["+index+"]").value;
						}else{
							var _phoneNumber1 = _phoneNumber;
						}
						if(document.getElementById("mobile["+index+"]") != null){
							var _mobile1 = document.getElementById("mobile["+index+"]").value;							
						}else{
							var _mobile1 = _mobile;
						}	
					}else{
						var _phoneNumber1 = _phoneNumber;
						var _mobile1 = _mobile;
					}
				}
				
				var _postCode = document.getElementById("prpCinsureds["+index+"].postCode").value;
				var _sex = document.getElementById("prpCinsureds["+index+"].sex").value;
				var _countryCode = trim(document.getElementById("prpCinsureds["+index+"].countryCode").value);
				var _age = document.getElementById("prpCinsureds["+index+"].age").value;
				if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1" && _identifyType == "01"){
					if(document.getElementById("drivingLicenseNo["+index+"]") != null
							&& document.getElementById("drivingLicenseNo["+index+"]").value != ""){
						var _drivingLicenseNoLSJ = document.getElementById("_drivingLicenseNoLSJ");
						if(_drivingLicenseNoLSJ !=null){
							_drivingLicenseNoLSJ.value = document.getElementById("prpCinsureds["+index+"].drivingLicenseNo").value;
						}
						var _drivingLicenseNo = document.getElementById("drivingLicenseNo["+index+"]").value;
					}else{
						var _drivingLicenseNo = document.getElementById("prpCinsureds["+index+"].drivingLicenseNo").value;
					}
				}else{
					var _drivingLicenseNo = document.getElementById("prpCinsureds["+index+"].drivingLicenseNo").value;
				}
				var _drivingCarType = document.getElementById("prpCinsureds["+index+"].drivingCarType").value;
				var _appendPrintName = document.getElementById("prpCinsureds["+index+"].appendPrintName").value;
				//modify by cj 20100730 版本号和审批状态的显示和存储 start
				var _auditStatus = document.getElementById("prpCinsureds["+index+"].auditStatus").value;
				var _versionNo = document.getElementById("prpCinsureds["+index+"].versionNo").value;
				var groupCode = document.getElementById("prpCmainCommon.ext2").value;
				//modify by cj 20100730 版本号和审批状态的显示和存储 end
				//modify by lujunfeng 指定驾驶人时显示上年违章次数和初次领证日期
				var _causetroubleTimes = document.getElementById("prpCinsureds["+index+"].causetroubleTimes").value;
				var _acceptLicenseDate = document.getElementById("prpCinsureds["+index+"].acceptLicenseDate").value;
				//是否普惠融资带动客户显示和存储
				var _isFinanceCustomer = "";
				if(document.getElementById("prpCinsureds["+index+"].isFinanceCustomer")!=null){
					_isFinanceCustomer = document.getElementById("prpCinsureds["+index+"].isFinanceCustomer").value;
				}
				var financeFlag = "";
				if(document.getElementById("financeFlag["+index+"]")!=null){
			        financeFlag = document.getElementById("financeFlag["+index+"]").value;
				}
				if(riskCode == "DAV"){
					var _soldierRelations = document.getElementById("prpCinsureds["+index+"].soldierRelations").value;
					var _soldierIdentifyType = document.getElementById("prpCinsureds["+index+"].soldierIdentifyType").value;
					var _soldierIdentifyNumber = document.getElementById("prpCinsureds["+index+"].soldierIdentifyNumber").value;
				}
				//为各个元素输入域赋值
				var _insuredFlag = document.getElementsByName("_insuredFlag");
				for ( var i = 0; i < _insuredFlag.length; i++) {
					if(_insuredFlag[i]!=null){
						_insuredFlag[i].checked = false;
					}
				}
				for ( var i = 0; i < _insuredFlag.length; i++) {
					if(i == 8 && _insuredFlagValue.charAt(24)=="1" && _insuredFlag[8]!=null){
						_insuredFlag[8].checked = true;
					}else if(_insuredFlag[i]!=null){
						if (_insuredFlagValue.charAt(i)=="1") {
							_insuredFlag[i].checked = true;
							//Add by LiChenhui;条款非家庭自用时，关系人不能指定驾驶人;20100805;begin;
							if(i==3){
								Insured.checkUseNature(_insuredFlag[i]);
							}
							 document.getElementById("_repeatTimes").value=_repeatTimes;		
								//if(i==0||i==1){ 
									//双击某条关系人赋值到_isCheckRepeat域的值默认为0,从而不使它提示重复录入电话信息
									//document.getElementById("_isCheckRepeat").value=0;	
								//}
							//Add by LiChenhui;条款非家庭自用时，关系人不能指定驾驶人;20100805;begin;
						}else{
							_insuredFlag[i].checked = false;
						}
					}
				}
				if(_insuredFlagValue.length >= 30){
					document.getElementById("_resident").value = _insuredFlagValue.substring(29,30);
				}
				if(riskCode == "DAA" && comCode.substring(0,2)=="11" && (_insuredFlagValue.substring(0,1) == "1" || _insuredFlagValue.substring(1,2) == "1") && !(document.getElementById("editType").value=="SHOW_PROPOSAL" || document.getElementById("editType").value=="SHOW_ENDORSE" || document.getElementById("editType").value=="SHOW_POLICY")){
					var idcardCode = document.getElementById("idCardCheckInfo["+ index +"].idcardCode").value;//身份证号
					var name = document.getElementById("idCardCheckInfo["+ index +"].name").value;//姓名
					var nation = document.getElementById("idCardCheckInfo["+ index +"].nation").value;//民族
					var birthday = document.getElementById("idCardCheckInfo["+ index +"].birthday").value;//出生日期
					var sex = document.getElementById("idCardCheckInfo["+ index +"].sex").value;//性别
					var address = document.getElementById("idCardCheckInfo["+ index +"].address").value;//住址
					var ISSUER = document.getElementById("idCardCheckInfo["+ index +"].issure").value;//签发机构
					var validStartDate = document.getElementById("idCardCheckInfo["+ index +"].validStartDate").value;//身份证号码有效开始时间
					var validEndDate = document.getElementById("idCardCheckInfo["+ index +"].validEndDate").value;//身份证号码有效结束时间
					var SAMCode = document.getElementById("idCardCheckInfo["+ index +"].samCode").value;//身份证采集器编码
					var SAMType = document.getElementById("idCardCheckInfo["+ index +"].samType").value;//采集设备类型
					var flag = document.getElementById("idCardCheckInfo["+ index +"].flag").value;
					
					document.getElementById("idCardCheckInfo.idcardCode").value = idcardCode;
					document.getElementById("idCardCheckInfo.name").value = name;
					document.getElementById("idCardCheckInfo.nation").value = nation;
					document.getElementById("idCardCheckInfo.birthday").value = birthday;
					document.getElementById("idCardCheckInfo.sex").value = sex;
					document.getElementById("idCardCheckInfo.address").value = address;
					document.getElementById("idCardCheckInfo.issure").value = ISSUER;
					document.getElementById("idCardCheckInfo.validStartDate").value = validStartDate;
					document.getElementById("idCardCheckInfo.validEndDate").value = validEndDate;
					document.getElementById("idCardCheckInfo.samCode").value = SAMCode;
					document.getElementById("idCardCheckInfo.samType").value = SAMType;
					document.getElementById("idCardCheckInfo.flag").value = flag;
				}
				document.getElementById("_insuredType").value = _insuredType;
				document.getElementById("_insuredName").value = _insuredName;
				document.getElementById("_insuredCode").value = _insuredCode;
				// 根据类型隐藏域
				Insured.changeInsuredNature();
				if(trim(_unitType)!=""){
					document.getElementById("_unitType").value = trim(_unitType);
				}else{
					document.getElementById("_unitType").value = '';
				}
				if(trim(_unifiedSocialCreditCode)!=""){
					document.getElementById("_unifiedSocialCreditCode").value = trim(_unifiedSocialCreditCode);
				}else{
					document.getElementById("_unifiedSocialCreditCode").value = '';
				}
				document.getElementById("_identifyType").value = _identifyType;
				//modify by cj 20100729 去掉多余的空格 begin
				document.getElementById("_identifyNumber").value = trim(_identifyNumber);
				if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1" && _identifyType == "01"){
					if(document.getElementById("_identifyNumber1") != null){
						document.getElementById("_identifyNumber1").value = trim(_identifyNumber);
						if(document.getElementById("_identifyNumber") != null){
							if(document.getElementById("_identifyNumber1").value != "" && document.getElementById("_identifyNumber1").value != null){
								document.getElementById("_identifyNumber").value = trim(identifyNumberLSJ);
							    if(tr.cells[5].all[0].value == _identifyNumber){
								   document.getElementById("_identifyNumber").value = trim(identifyNumberLSJ);
							    }
							}
						}
					}
				}
				document.getElementById("_drivingYears").value = _drivingYears;
				document.getElementById("_insuredAddress").value = _insuredAddress;
				if((riskCode == "DAA" || riskCode == "DAV") && electronicPolicyFlag != null
						&& (comCode.substring(0,2)=="11" || (electronicPolicyFlag.value == "2" && comCode.substring(0,2)=="36" )
							|| electronicPolicyFlag.value == "1")){
					document.getElementById("_email").value = _email;
				}
				document.getElementById("_phoneNumber").value = trim(_phoneNumber);
				
				
				if(document.getElementById("_phoneNumber1") != null){
					if(document.getElementById("_phoneNumber").value!="" && document.getElementById("_phoneNumber").value!=null){
					   document.getElementById("_phoneNumber1").value = trim( _phoneNumber).substring(0, trim( _phoneNumber).length-6) + "***" + trim( _phoneNumber).substring(trim( _phoneNumber).length-3, trim( _phoneNumber).length);	
					   if(tr.cells[7].all[0].value == _phoneNumber){
						document.getElementById("_phoneNumber1").value = trim(_phoneNumber);
					}
					}
					else{
						document.getElementById("_phoneNumber1").value = trim(_phoneNumber1);
					}
				}
				document.getElementById("_mobile").value = trim(_mobile);
				if(document.getElementById("_mobile1") != null){
					if(document.getElementById("_mobile").value!="" && document.getElementById("_mobile").value!=null){
					    //document.getElementById("_mobile1").value = trim(_mobile).substring(0,3)+"****"+trim(_mobile).substring(7,11);
						document.getElementById("_mobile1").value =trim(mobileNoYG);
					    if(tr.cells[8].all[0].value == _mobile){
						   document.getElementById("_mobile1").value = trim(mobileNoYG);
					    }
					}else{
						document.getElementById("_mobile1").value = trim(_mobile1);
					}
				}
				if(document.getElementById("_isFinanceCustomer")!=null){
					var isFinanceCustomer = document.getElementById("_isFinanceCustomer");
			        while(document.all("_isFinanceCustomer").options.length>0){
			        	document.all("_isFinanceCustomer").options.remove(0);
			        }
			        if(financeFlag  == "0") {
			        	isFinanceCustomer.options.add(new Option("否","3"));
			        	isFinanceCustomer.options.add(new Option("普惠融资间接带动","2"));
			        }else{
			        	isFinanceCustomer.options.add(new Option("否","3"));
			        	isFinanceCustomer.options.add(new Option("普惠融资间接带动","2"));
			        	isFinanceCustomer.options.add(new Option("普惠融资直接带动","1"));
			        }
					var optionsLength = document.all("_isFinanceCustomer").options.length;
					for(var i=0;i<optionsLength;i++){
						if(isFinanceCustomer.options[i].value == trim(_isFinanceCustomer)){
							isFinanceCustomer.options[i].selected = true;
							break;
						}
					}
				}
				//modify by cj 20100729 end
				document.getElementById("_postCode").value = _postCode;
				document.getElementById("_countryCode").value = _countryCode;
				document.getElementById("_age").value = _age;
				document.getElementById("_sex").value = _sex;
				document.getElementById("_appendPrintName").value = _appendPrintName;
				//modify by cj 20100730 版本号和审批状态的显示和存储 start
				document.getElementById("_auditStatus").value = _auditStatus;
				document.getElementById("_auditStatusDes").value = Insured.tranAuditStatus(_auditStatus);
				document.getElementById("_versionNo").value = _versionNo;
				if(_insuredFlag[0].checked){
					document.getElementById("group_code").value = groupCode;
				}
	
				//modify by cj 20100730 版本号和审批状态的显示和存储 end
				if(_insuredFlag[3].checked){
					//modify by zhaoxiaojie 20100804 将这三行放入if语句里面防止在双击的时候弹出代码不存在或者没有权限提示 start
					var carKindLicense = document.getElementById("CarKindLicense");
					carKindLicense.value = _drivingCarType;
					carKindLicense.onchange();
					//modify by zhaoxiaojie 20100804 将这三行放入if语句里面防止在双击的时候弹出代码不存在或者没有权限提示 end
					document.getElementById("drivingLicenseNo").style.display = "";
					document.getElementById("drivingLicenseNoValue").style.display = "";
					if(document.getElementById("drivingLicenseNo1")!=null){
						document.getElementById("drivingLicenseNo1").style.display = "none";
					}
					//modify by sangjianjun;准驾车型只有在指定驾驶人才显示  20100728 begin
					document.getElementById("drivingCarType").style.display = "";
					document.getElementById("drivingCarTypeValue").style.display = "";
					//modify by sangjianjun;准驾车型只有在指定驾驶人才显示  20100728 end
					
					//modify by lujunfeng 指定驾驶人时显示上年违章次数和初次领证日期
					document.getElementById("disType").style.display = "";
					document.getElementById("causetroubleTimesType").style.display = "";
					document.getElementById("causetroubleTimesValue").style.display = "";
					
					document.getElementById("acceptLicenseDateType").style.display = "";
					document.getElementById("acceptLicenseDateValue").style.display = "";
					
					document.getElementById("_causetroubleTimes").value = _causetroubleTimes;
					document.getElementById("_acceptLicenseDate").value = _acceptLicenseDate;
					
					document.getElementById("imageone").style.display = "";
					document.getElementById("imagetwo").style.display = "";
//					if(document.getElementById("_identifyType").value=="01" && isNaN(document.getElementById("_drivingLicenseNo"))){
//					    document.getElementById("_drivingLicenseNo").value = _identifyNumber;
//					    //document.getElementById("_drivingLicenseNo").readOnly = true;
//				        }else{
//				            document.getElementById("_drivingLicenseNo").value = _drivingLicenseNo;
//				        }
					//PRPALL-5500双击关系人之后，带入页面的驾驶证号。
					document.getElementById("_drivingLicenseNo").value = _drivingLicenseNo;
				}else{
					document.getElementById("imageone").style.display = "none";
					document.getElementById("imagetwo").style.display = "none";
					document.getElementById("drivingLicenseNo").style.display = "none";
					document.getElementById("drivingLicenseNoValue").style.display = "none";
					if(document.getElementById("drivingLicenseNo1")!=null){
						document.getElementById("drivingLicenseNo1").style.display = "";
					}
					document.getElementById("drivingCarType").style.display = "none";
					document.getElementById("drivingCarTypeValue").style.display = "none";
					document.getElementById("disType").style.display = "none";
					document.getElementById("causetroubleTimesType").style.display = "none";
					document.getElementById("causetroubleTimesValue").style.display = "none";
					document.getElementById("acceptLicenseDateType").style.display = "none";
					document.getElementById("acceptLicenseDateValue").style.display = "none";
				}
				if(riskCode == "DAV"){
					Insured.clearSoldierInput();
					document.getElementById("soldierRelations").style.display = "none";
					document.getElementById("soldierRelationsValue").style.display = "none";
					document.getElementById("soldierIdentifyType").style.display = "none";
					document.getElementById("soldierIdentifyTypeValue").style.display = "none";
					document.getElementById("soldierIdentifyNumber").style.display = "none";
					document.getElementById("soldierIdentifyNumberValue").style.display = "none";
					if(_insuredFlag[2].checked || _insuredFlag[8].checked){
						if(_insuredFlag[2].checked){
							document.getElementById("soldierRelations").style.display = "";
							document.getElementById("soldierRelationsValue").style.display = "";
							document.getElementById("_soldierRelations").value = _soldierRelations;
						}
						if((_insuredFlag[2].checked && _soldierRelations == 0) || _insuredFlag[8].checked){
							document.getElementById("soldierIdentifyType").style.display = "";
							document.getElementById("soldierIdentifyTypeValue").style.display = "";
							document.getElementById("_soldierIdentifyType").value = _soldierIdentifyType;
							document.getElementById("soldierIdentifyNumber").style.display = "";
							document.getElementById("soldierIdentifyNumberValue").style.display = "";
							document.getElementById("_soldierIdentifyNumber").value = _soldierIdentifyNumber;
						}
					}
				}
				document.getElementById("updateIndex").value = index;
				//将关键信息设为只读;LICHENHUI;20101021;
				if(document.getElementById("editType").value != "SHOW_PROPOSAL" && document.getElementById("editType").value != "SHOW_ENDORSE"){
					Insured.setInsuredReadOnly();
				}
			},
			/**
			 * @author sinosoft
			 * @description 隐藏域赋值
			 * @return
			 */
			checkMoblie : function(obj){
				var _mobile= document.getElementById("_mobile");
			    var num = obj.value;
			 	var partten = /^1[3,5,4,7,8,9]\d{9}$/;
			 	// R628
			 	if(num!=null&&num!="")
			 	{
			 		if(num.length!=11){ 			
			 			alert("移动电话号码必须为11位有效数字!");
			 			//obj.value = "";
			 			if(_mobile != null && _mobile.value != ""){
							// _mobile.value = "";
						}
				 		obj.focus();
				 		obj.value = "";
				 		return false;
				 	}
			 		// R635
			 		if(!partten.test(num)){
				 		alert("移动电话格式错误。例如：15821345169");
				 		//obj.value = "";
				 		if(_mobile != null && _mobile.value != ""){
							// _mobile.value = "";
						}
				 		obj.focus();
				 		obj.value = "";
				 		return false;
				 	}
			 	}
				document.getElementById("_mobile").value = document.getElementById("_mobile1").value;
			},
			
			/**
			 * @author sinosoft
			 * @description 隐藏域赋值
			 * @return
			 */
			checkMoblie_1 : function(obj){
				document.getElementById("_mobile").value = document.getElementById("_mobile1").value;
			},
			
			/**
			 * @author qinhuina
			 * @description 移动电话页面赋值
			 * @return
			 */
			checkMoblieBack : function(){
				//EAD产品没有_mobile1隐藏域，所以校验是否有域
				if(document.getElementById("_mobile1")!=null){
					var mobile = document.getElementById("_mobile").value;
					  if(mobile!=null && mobile!=""){
					    document.getElementById("_mobile1").value=mobile.substr(0, 3) + "****" + mobile.substr(7, 4);
					  }
					  else{
						  document.getElementById("_mobile1").value = mobile;
					  }
						  
					}
			},
			/**
			 * @author sinosoft
			 * @description 隐藏域赋值
			 * @return
			 */
			checkPhoneNumber : function(obj){
				var _phoneNumber = document.getElementById("_phoneNumber");
				var num = obj.value;
				var partten = /^.*[u4E00-u9FA5]+.*$/;	// 汉字正则表达式
				var partten=/^[+]{0,1}(\d){1,4}[ ]?([-]?((\d)|[ ]){1,12})+$/;  
			    if(num!=null&&num!="")
				{
					if(!partten.test(num)){
						alert("请输入合法的固定电话!");
						//obj.value = "";
						if(_phoneNumber != null && _phoneNumber.value != ""){
							//_phoneNumber.value = "";
						}
						obj.focus();
						obj.value = "";
					    return false;
					}
				}
				var length = obj.value.length;
				// R642
				if(length>0 && length!=7 && length!=8 && length!=11 && length!=12)
				{
					alert("固定电话必须为7、8、11或12位数字!");
					//obj.value = "";
					if(_phoneNumber != null && _phoneNumber.value != ""){
						//_phoneNumber.value = "";
					}
					obj.focus();
					obj.value = "";
			        return false;
				}
				document.getElementById("_phoneNumber").value = document.getElementById("_phoneNumber1").value;
			},
			
			/**
			 * @author sinosoft
			 * @description 隐藏域赋值
			 * @return
			 */
			checkPhoneNumber_1 : function(obj){
				document.getElementById("_phoneNumber").value = document.getElementById("_phoneNumber1").value;
			},
			
			/**
			 * @author qinhuina
			 * @description 固定电话页面赋值
			 * @return 
			 */
			checkPhoneNumberBack : function(){
				if(document.getElementById("_phoneNumber1") != null){
					var phoneNumber =  document.getElementById("_phoneNumber").value;
					if(phoneNumber!=null && phoneNumber!=""){
					document.getElementById("_phoneNumber1").value = phoneNumber.substring(0, phoneNumber.length-6) + "***" + phoneNumber.substring(phoneNumber.length-3, phoneNumber.length);
				    }else{
				    	document.getElementById("_phoneNumber1").value = phoneNumber;
				    }
			   }
			},
			/**
			 * @author sinosoft
			 * @description 检验身份证号码
			 *<p>
			 *<font color=red>规则 : 调用 ：R636</font>
			 *</p>
			 * @param field
			 * 		   输入域
			 * @return 通过true,不通过false
			 * @deprecated
			 */
			checkidentifyNumber : function(field){
			  var num = field.value;
			  num = num.toUpperCase();  
			  // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X。
			  if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(num)))   
			  { 
			      alert('输入的身份证号长度不对，或者号码不符合规定！\n15位号码应全为数字，18位号码末位可以为数字或X。'); 
			      field.focus();
			      return false; 
			  } 
				// 校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
				// 下面分别分析出生日期和校验位
			  var len, re; 
			  len = num.length; 
			  if (len == 15) 
			  { 
			    re = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/); 
			    var arrSplit = num.match(re); 
			    // 检查生日日期是否正确
			    var dtmBirth = new Date('19' + arrSplit[2] + '/' + arrSplit[3] + '/' + arrSplit[4]); 
			    var bGoodDay; 
			    bGoodDay = (dtmBirth.getYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4])); 
			    if (!bGoodDay) 
			    { 
			       alert('输入的身份证号里出生日期不对！');   
			       field.focus();
			       return false; 
			    } 
			    else 
			    { 
			       // 将15位身份证转成18位
			       // 校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
			    	var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2); 
			        var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'); 
			        var nTemp = 0, i;   
			        num = num.substr(0, 6) + '19' + num.substr(6, num.length - 6); 
			        for(i = 0; i < 17; i++) 
			        { 
			           nTemp += num.substr(i, 1) * arrInt[i]; 
			        } 
			        num += arrCh[nTemp % 11]; 
			        Insured.getAge(dtmBirth);  
			        return num;   
				 }   
			   } 
			   if (len == 18) 
			   { 
			      re = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/); 
			      var arrSplit = num.match(re); 
			      // 检查生日日期是否正确
			      var dtmBirth = new Date(arrSplit[2] + "/" + arrSplit[3] + "/" + arrSplit[4]); 
			      var bGoodDay; 
			      bGoodDay = (dtmBirth.getFullYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4])); 
			      if (!bGoodDay) 
			      { 
			        alert('输入的身份证号里出生日期不对！'); 
			        field.focus();
			        return false; 
			   	  } 
			   	  else 
			      { 
			        // 检验18位身份证的校验码是否正确。
			        // 校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。
			        var valnum; 
			        var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2); 
			        var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'); 
			        var nTemp = 0, i; 
			        for(i = 0; i < 17; i ++) 
			        { 
			          nTemp += num.substr(i, 1) * arrInt[i]; 
			        } 
			        valnum = arrCh[nTemp % 11]; 
			        if (valnum != num.substr(17, 1)) 
			        { 
			          alert('18位身份证的校验码不正确！最后一位应该为：' + valnum); 
			          field.focus();
			          return false; 
			        } 
			        //R636
			        Insured.getAge(dtmBirth);
			        return num; 
			      } 
			  } 
			   return true; 
			},
	
			/**
			 * @author sinosoft
			 * @description 组织机构代码验证 
			 * @param code
			 * 		   输入域
			 * @return 通过true,不通过false
			 */
			isValidEntpCode : function(code){
				var ws = [ 3, 7, 9, 10, 5, 8, 4, 2 ];
				var str = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ';
				var reg = /^([0-9A-Z]){8}[-]{0,1}[0-9X]{1}$/;
				if (!reg.test(code)) {
					alert("组织机构代码格式错误！例：78305975-3或783059753");
					return false;
				}
				var sum = 0;
				for ( var i = 0; i < 8; i++) {
					sum += str.indexOf(code.charAt(i)) * ws[i];
				}
				var C9 = 11 - (sum % 11);
				var codeChar = code.charAt(code.length-1);
				if (C9 == 11) {	// C9='0'
					if('0' != codeChar){
						alert("组织机构代码校验位错误！");
						return false;
					}
				} else if (C9 == 10) {	// C9=='X'
					if('X' != codeChar){
						alert("组织机构代码校验位错误！");
						return false;
					}
				} else {
					if(C9 != codeChar){
						alert("组织机构代码校验位错误！");
						return false;
					}
				}
				return true;
			},
	
			/**
			 * @author sinosoft 
			 * @description 回写驾驶证号码
			 * @param obj
			 * 		   身份证号码
			 * @return
			 */
			writeDrivingLicenseNo : function(obj){
				var licenseNo = obj.value;
				if(document.getElementById("_identifyType").value=="05" && Insured.checkDrivingLicenseNo(obj)){
					document.getElementById("_drivingLicenseNo").value = licenseNo;
				}
			},
			/**
			 * @author sinosoft
			 * @description 证件类型为身份证，用证件号回写驾驶证号码，否则为空
			 *<p>
			 *<font color=red>规则 : R625</font>
			 *</p>
			 * @return
			 */
			writeDivLicenseNo : function(){
				// R625
				var identifyNumber = document.getElementById("_identifyNumber").value;
				var IDCARD_SHIELD = document.getElementById("IDCARD_SHIELD");
				if(document.getElementById("_identifyType").value=="01" && isNaN(document.getElementById("_drivingLicenseNo"))){
					document.getElementById("_drivingLicenseNo").value = identifyNumber;
					if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1"){
						var identifyNumber1 = document.getElementById("_identifyNumber1");
						if(identifyNumber1 != null){
							document.getElementById("_drivingLicenseNoLSJ").value = identifyNumber1.value;
						}
					}
				}else if(isNaN(document.getElementById("_drivingLicenseNo"))){
					document.getElementById("_drivingLicenseNo").value = "";
				}
			},
			/**
			 * @author sinosoft
			 * @description 删除关系人操作
			 * @param obj
			 * @param field
			 * @return
			 */
			deleteOneRow : function(obj,field){
				var tr = getTR(obj);
				var eleName = tr.cells[0].all[0].name;
				var index=eleName.substring(eleName.indexOf("[")+1,eleName.indexOf("]"));
				//获取角色串
				var clauseType  = document.getElementById("prpCitemCar.clauseType").value;
				var bizType = document.getElementById('bizType').value;
				var insuredFlag = document.getElementById(eleName.substring(0,eleName.indexOf("[")+1)+index+"].insuredFlag").value;
	
				//如果是删除关系人 需要判断标签页是否加载
				if(field == "insertInsuredRow" && bizType == "ENDORSE" && Insured.checkInitEngage(document.getElementById("prpCinsureds["+index+"].insuredFlag"),"InsuredDel")){
					if(!Insured.checkTabView()){
						return false;
					}
				}
				if(document.getElementById("updateIndex").value == index){
					if(!confirm("此条记录正在修改，确定要删除吗？")){
						return false;
					}
					//如果包含指定驾驶员删除记录的时候清空保费
					if(insuredFlag.substring(3,4) == 1 && clauseType == 'F42'){
						ItemKind.clearSumPremium();
					}
					Insured.clearInsuredInputArea();
					document.getElementById("updateIndex").value = "-1";
				}else{
				   if(silenceMode == false && !confirm("确定要删除此条记录吗？")){
			   		return false;
				   }
				    //如果包含指定驾驶员删除记录的时候清空保费
					if(insuredFlag.substring(3,4) == 1  && clauseType == 'F42'){
						ItemKind.clearSumPremium();
					}
				   Insured.clearInsuredInputArea();
				}
				
				deleteRow(obj,field);
				
			    //modify by cj 20100818 校验车主与被保险人是否同一个人 
			    //Insured.checkInsureOwn(field);
			    //该方法弃用改由ilog自动带出
			    /*if(isNaN(document.getElementById("iniPrpCengage_Flag")) && document.getElementById("iniPrpCengage_Flag") != null
						  && document.getElementById("iniPrpCengage_Flag").value == "1"){
					  Engage.insertEngageDevice();
				}*/
				//修改页面上的关系人信息要提示修改意外险信息
				Insured.changeEad();
				//删除被保险人后清空交叉销售信息
				if(bizType != "ENDORSE" && insuredFlag.substring(1,2) == "1"){
					MainTotal.clearCrossInfo();
				}
				//平台交管-删除车主后清空交强险信息
				var pm_vehicle_switch = document.getElementById("pm_vehicle_switch");
				if(bizType == "ENDORSE" &&pm_vehicle_switch!=null&& pm_vehicle_switch.value == "1" && insuredFlag.substring(2,3) == "1"){
					ItemKind.clearSumPremiumCI();
					if(document.getElementById("prpCmain.sumPremium1") != null && document.getElementById("prpCmain.sumPremium1").value == "0"){
						document.getElementById("prpCmain.sumPremium1").value = ""
					}
				}
				ItemKind.changeConditon();
			},
	
			/**
			 * @author sinosoft
			 * @description 根据身份证日期生成年龄
			 *<p>
			 *<font color=red>规则 : R636</font>
			 *</p>
			 * @param dtmBirth
			 * 		   身份证日期
			 * @return
			 */
			getAge : function(dtmBirth){
			   // R636
			   var birthYear = dtmBirth.getFullYear();
			   var date = new Date();
			   var age = date.getYear() - birthYear;
			   document.getElementById("_age").value = age;
			},
			/**
			 * @author sinosoft
			 * description 证件类型改变时，清空证件号码
			 * @return
			 */
			clearIdentifyNumber : function (){
			   document.getElementById("_identifyNumber").value = "";
			   if(document.getElementById("_identifyNumber").onchange!=null){
			      document.getElementById("_identifyNumber").onchange();
			   }
			   //改变证件类型，会清空证件号，然后调onblur校验是否为空，故驾驶证时，不调onblur
			   if(document.getElementById("_identifyType") !=null 
					   && document.getElementById("_identifyType").value!="05"){
				   document.getElementById("_identifyNumber").onblur();
			   }
			   Insured.writeDivLicenseNo(); 
			},
			/**
			 * @author sinosoft
			 * @description 点击年龄时，校验身份证号是否输入
			 * @return 不通过返回false
			 */
			checkAge : function(){
			   if(document.getElementById("_insuredType").value=="1"&&document.getElementById("_identifyType").value=="01")
			   {
				   if(document.getElementById("_identifyNumber").value == ""){
				        errorMessage("请先输入证件号码！");
				        document.getElementById("_identifyNumber").focus();
				        return false;
				   }else{
				       errorMessage("证件类型为身份证，年龄自动生成，不允许修改！");
				       document.getElementById("_age").blur();
				       return false;
				   }
			   }
			},
			/**
			 * @author sinosoft
			 * @description 判断身份证号码格式函数 公民身份号码是特征组合码， 排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码
			 *<p>
			 *<font color=red>规则 : R29,R627</font>
			 *</p>
			 * @param StrNo
			 * 		   身份证号
			 * @return 通过返回true,不通过返回false
			 */
			isChinaIDCard : function(StrNo, idx){
			  	var num = StrNo;
			  	num = num.toUpperCase();  
				StrNo = StrNo.toString();
				//R29
				if (StrNo.length == 15) {
					//提取公共方法校验身份证信息
					if(!Insured.checkIdentifyNumber(StrNo)){
						return false;
					}
//					re = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/); 
//			    	var arrSplit = num.match(re); 
			    	// 检查生日日期是否正确
//			    	var dtmBirth = new Date('19' + arrSplit[2] + '/' + arrSplit[3] + '/' + arrSplit[4]); 
//			    	//Insured.getAge(dtmBirth);
			    	if(document.getElementById("isCqp")){
//			    		Insured.getAge4S(dtmBirth,idx);
						document.getElementById("prpCinsureds["+ idx +"].age").readOnly = true;
			    	}
					if (!Insured.isValidDate("19" + StrNo.substr(6, 2), StrNo.substr(8, 2), StrNo
							.substr(10, 2))) {
						return false;
					}
					
				} else if (StrNo.length == 18) {
					//提取公共方法校验身份证信息
					if(!Insured.checkIdentifyNumber(StrNo)){
						return false;
					}
//				  	re = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/); 
//			      	var arrSplit = num.match(re); 
//			      	// 检查生日日期是否正确
//			     	var dtmBirth = new Date(arrSplit[2] + "/" + arrSplit[3] + "/" + arrSplit[4]); 
//			    	Insured.getAge(dtmBirth);
			    	if(document.getElementById("isCqp")){
//			    		Insured.getAge4S(dtmBirth,idx);
					   document.getElementById("prpCinsureds["+ idx +"].age").readOnly = true;
			    	}
					if (!Insured.isValidDate(StrNo.substr(6, 4), StrNo.substr(10, 2), StrNo.substr(
							12, 2))) {
						return false;
					}
				} else {
					// R627
					alert("输入的身份证号码必须为15位或者18位！");
					return false;
				}
				return true;
			},
			/**
			 * @author qinhuina
			 * @description 校验身份证
			 * @param StrNo
			 * 		   身份证号
			 * @return 通过返回true,不通过返回false
			 */
			checkIdentifyNumber : function (StrNo){
				if (StrNo.length == 18) {
					var a, b, c
					// R627
					if (!Common.isNumber(StrNo.substr(0, 17))) {
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
				} else {// R627 15位身份证号
					if (!Common.isNumber(StrNo)) {
						alert("身份证号码错误,15位的身份证号必须全部是数字！");
						return false;
					}
				}
				return true;
			},
			/**
			 * @author sinosoft
			 * @description 检验身份证号的年、月、日是否符合标准
			 * @param iY 年份
			 * @param iM 月份
			 * @param iD 日期
			 * @return ture:检验通过，false:校验不通过
			 */
			isValidDate : function(iY, iM, iD) {
				if (iY > 2200 || iY < 1900 || !Common.isNumber(iY)) {
					alert("输入身份证号,年度" + iY + "非法！");
					return false;
				}
				if (iM > 12 || iM <= 0 || !Common.isNumber(iM)) {
					alert("输入身份证号,月份" + iM + "非法！");
					return false;
				}
				if (iD > 31 || iD <= 0 || !Common.isNumber(iD)) {
					alert("输入身份证号,日期" + iD + "非法！");
					return false;
				}
				return true;
			},
			
			/**
			 * @author huxiaodong
			 * @description 年龄blur事件<br/>
			 *<p>
			 *1>检验字符串是否满足条件<br/>2>校验年龄范围0~200<br/>
			 *</p>
			 * @param this
			 *            表单域
			 * @return
			 */
			blurAage : function(filed){
				//检验是否满足条件
				Insured.checkNumber(filed);
				//校验年龄范围0~200
				if(Insured.checkAgeRange(filed)==false){
					return;
				}
				//校验年龄与驾龄
				Insured.checkDrivingYears(filed);
			},
			/**
			 * @author huxiaodong
			 * @description 检验字符串是否满足条件<br/>
			 *<p>
			 *1>校验字符串是否为整型<br/> 2>控制输入域长度<br/>
			 *</p>
			 *@private
			 *@param filed
			 *            表单域
			 * @return
			 */
			checkNumber : function(filed){
				//校验字符串是否为整型
				checkIsInteger(filed);
				//控制输入域长度
				checkLength(filed);
			},
			/**
			 * @author sinosoft
			 * @description 校验年龄范围0~200
			 * @param obj
			 * @return false:校验不通过
			 */
			checkAgeRange : function(obj){
				var age = parseInt(obj.value);
				if(age<0||age>200){
					alert("年龄不应该超出0~200的范围！");
					obj.value = '';
					obj.select();
					obj.focus();
					return false;
				}
				if(age == 0){
					alert("年龄不能为0！");
					obj.value = '';
					obj.select();
					obj.focus();
					return false;	    
				}
				return true;
			},
			/**
			 * @author qinhuina
			 * @description 校验年龄与驾龄
			 * @param obj
			 * @return false:校验不通过
			 */
			checkDrivingYears : function(filed) {
				if(document.getElementById("_drivingYears").value != "" && document.getElementById("_drivingYears").value != null){
				     var drivingAge = document.getElementById("_drivingYears");
			             Insured.checkCarDriverAge(drivingAge);
			             Insured.changeAge(filed);
				}
			},
			/**
			 * @author sinosoft
			 * @description 查询客户评级信息
			 *<p>
			 *<font color=red>规则 : R472</font>
			 *</p>
			 * @param 
			 * @return
			 */
			queryCustomer : function(value){
				var insuredType = document.getElementById("_insuredType").value;
				if(insuredType == null || insuredType == ""){
					insuredType = "1";
				}
				// R472
				if(insuredType == "1"){
					Insured.queryCustomerP(value);
				}else if(insuredType == "2"){
					Insured.queryCustomerG(value);
				}
			},
			/**
			 * @author sinosoft
			 * @description 类型为个体时，查询客户评级信息
			 *<p>
			 *<font color=red>规则 : R431</font>
			 *</p>
			 * @param 
			 * @return false:校验不通过
			 */
			queryCustomerP : function(value){
				var _insuredType = fm._insuredType.value;
				if(_insuredType == null || _insuredType == ""){
					_insuredType = "1";
				}
				var _editflag = "1";
				if(document.getElementById("editFlag")!=null){
					_editflag = document.getElementById("editFlag").value;
				}
				var _insuredName = fm._insuredName.value;
				var _identifyNumber = fm._identifyNumber.value;
				var _insuredCode = fm._insuredCode.value;
				var _identifyType = fm._identifyType.value;
				var _insuredFlag_hide = document.getElementsByName("_insuredFlag_hide");
				var _insuredFlag = document.getElementsByName("_insuredFlag");
				var customerURL = document.getElementById("customerURL");
					// R431
				if((_insuredName==null||_insuredName == "")&&(_identifyNumber==null||_identifyNumber == "")&&(_insuredCode==null||_insuredCode == "")){
				       errorMessage("请输入查询条件（名称、证件号码或代码至少输入一项）！");
				       fm._insuredName.focus();
					   fm._insuredName.select();
					   return false;
				}
	
				var callback = {
				/**
				 * @private
				 */
				success:function (res) 
				{
				     var prod = YAHOO.lang.JSON.parse(res.responseText);
				     //var flag;
			         if(parseInt(prod.data[0].count)==1) 
			      	 {
			             var auditStatus = prod.data[0].auditStatus;
			             if(!("0,1,3".indexOf(auditStatus) <= -1 || trim(auditStatus)=="")){
				             for(var i = 0;i < _insuredFlag.length;i++){
				            	 if(_insuredFlag_hide[i].value == '投保人' || _insuredFlag_hide[i].value == '被保险人'){
				            		 if(_insuredFlag[i].checked){
				            			 alert("此客户未经审核通过，不允许录单！");
							    			return false;
				            		 }
				            	 }
				             }
			             }
			   		 	Insured.insuredValue(prod);
			   		 	Insured.insuredLevelValue(prod);
			      	 }
			      	 else if(parseInt(prod.data[0].count)>1)
			      	 {
			      	 	Insured.searchCustomer(prod.data[0].URL);
			      	 }
			  		 else
			  		 {
			 		 	 Insured.createCustomer(prod.data[0].URL);//modified by LanNing 20100823 易用性-查不到关系人自动进入新增页面
			  		 }
			  	     if(_insuredType == "1" && (document.getElementById("_identifyType").value =="01"|| document.getElementById("_identifyType").value =="16")){
				  		 var identifyNumber = document.getElementById("_identifyNumber");
				  		 Insured.checkIdentifyNumberID(identifyNumber);
			  	     }
			  		// 将审批状态、代码和版本号设置为只读
//			  		if(flag == false){
//			  		//  document.getElementById("_insuredCode").readOnly = false;
//			  		}
//			  		if(flag == undefined){
//			  			//document.getElementById("_insuredCode").readOnly = true;
//			  		}
			  		document.getElementById("_auditStatus").readOnly = true;
			  		document.getElementById("_versionNo").readOnly = true;
				  
				},
				/**
				 * @private
				 */
				failure:function (res) 
				{
				   errorMessage("登录超时，请重登陆！");
				   return false;
				}
				};
				var timestamp=new Date().getTime();
				var strURL = "/prpall/custom/customAmountQueryP.do?_identifyType="+_identifyType+"&_insuredName="
				    +_insuredName+"&_identifyNumber="+_identifyNumber+"&_insuredCode="+_insuredCode+"&time="+timestamp;
				var transaction = YAHOO.util.Connect.asyncRequest('GET',strURL, callback); 
			},
			
			queryCustomerLevel : function(){
				var insuredType = document.getElementById("_insuredType").value;
				if(insuredType == null || insuredType == ""){
					insuredType = "1";
				}
				var _identifyNumber = fm._identifyNumber.value;
				var _insuredCode = fm._insuredCode.value;
				if((_insuredCode==null||_insuredCode == "") &&( _identifyNumber== null || _identifyNumber == "")){
				       errorMessage("请输入客户代码或证件号码！");
					   return false;
				}
				var callback = {
				/**
				 * @private
				 */
				success:function (res) 
				{
				     var prod = YAHOO.lang.JSON.parse(res.responseText);
				     var flag;
			         if(parseInt(prod.data[0].count)==1) 
			      	 {
			   		 	Insured.insuredLevelValue(prod);
			      	 }
				},
				/**
				 * @private
				 */
				failure:function (res) 
				{
				   errorMessage("查询客户评级失败！");
				   return false;
				}
				};
				var strURL = "";
				if(insuredType == "1"){
					strURL = "/prpall/custom/customAmountQueryP.do?_insuredCode="+_insuredCode+"&_identifyNumber="+_identifyNumber+"&levelFlag=1";
				}else if(insuredType == "2"){
					strURL = "/prpall/custom/customAmountQueryG.do?_insuredCode="+_insuredCode+"&_identifyNumber="+_identifyNumber+"&levelFlag=1";
				}
				
				var transaction = YAHOO.util.Connect.asyncRequest('GET',strURL, callback); 
			},	
			fileUpload : function(operateType,businessType,businessNo,businessNoCI,bizType,unlCTX){
				var insuredCode = document.getElementById("_insuredCode").value;
				var insuredType = document.getElementById("_insuredType").value;
				var bizNo1 = document.getElementById("bizNo");
				if(bizNo1!=null && trim(bizNo1.value)!=""){
					if(bizNo1.value.substring(1,4) == "DZA"){
						businessNoCI = bizNo1.value;
						businessNo = "";
					}else{
						businessNo = bizNo1.value;
						businessNoCI = "";
					}
				}
				window.open(unlCTX+"/upload/fileUpload.do?opreateType="+operateType+"&businessNo="+businessNo+"&businessNoCI="+businessNoCI+"&businessType="+businessType+"&bizType="+bizType+"&insuredCode="+insuredCode+"&insuredType="+insuredType);
			},
			imageDisabled : function(field){ 
                var isReadOnly = document.getElementById("_insuredCode").readOnly; 
                var insuredCode = document.getElementById("_insuredCode").value; 
                if(isReadOnly && trim(insuredCode)!= "" && insuredCode!=null && insuredCode!=undefined){ 
                	if(document.getElementById("showImage")!=null){
                		document.getElementById("showImage").disabled=false;
                	}
                }else{ 
                	if(document.getElementById("showImage")!=null){
                        document.getElementById("showImage").disabled=true; 
                	}
                } 
            },
			/**
			 * @author sinosoft
			 * @description 类型为团体时，查询客户评级信息
			 * @param value
			 * @return
			 */
			queryCustomerG : function(value){
				var _insuredName = fm._insuredName.value;
				var _identifyNumber = fm._identifyNumber.value;
				var _insuredCode = fm._insuredCode.value;
			 	var _identifyType = fm._identifyType.value;
				var customerURL = document.getElementById("customerURL");
				var _unifiedSocialCreditCode=fm._unifiedSocialCreditCode.value;
				var _editflag = "1";
				if(document.getElementById("editFlag")!=null){
					_editflag = document.getElementById("editFlag").value;
				}
					if((_insuredName==null||_insuredName == "")&&(_identifyNumber==null||_identifyNumber == "")&&(_insuredCode==null||_insuredCode == "")&&(_unifiedSocialCreditCode==null||_unifiedSocialCreditCode == "")){
					       errorMessage("请输入查询条件(名称、组织机构代码、统一社会信用代码或客户代码至少输入一项）！");
					       fm._insuredName.focus();
						   fm._insuredName.select();
						   return false;
					}
				var callback = {
				/**
				 * @private
				 */
				success:function (res) 
				{
					 var prod = YAHOO.lang.JSON.parse(res.responseText);
			      		 if(parseInt(prod.data[0].count)==1) 
			      		 {
			      		 	Insured.insuredValue(prod);
			      		 	//查询直接带出客户评级
			      		 	Insured.insuredLevelValue(prod);
			      		 }
			      		 else if(parseInt(prod.data[0].count)>1)
			      		 {
			      		 	Insured.searchCustomer(prod.data[0].URL);
			      		 }
			      		 else
			      		 {
			  		 		Insured.createCustomer(prod.data[0].URL);//modified by LanNing 20100823 易用性-查不到关系人自动进入新增页面
			      		 }
			      		// 将审批状态、代码和版本号设置为只读
			      	  	//document.getElementById("_insuredCode").readOnly = true;
			      		document.getElementById("_auditStatus").readOnly = true;
			      		document.getElementById("_versionNo").readOnly = true;
				},
				/**
				 * @private
				 */
				failure:function (res) 
				{
				   errorMessage("服务异常！");
				   return false;
				}
				};
				var strURL = "";
//				if(value == "showLevel"){
//					strURL = "/prpall/custom/customAmountQueryG.do?_insuredCode="+_insuredCode+"&_identifyNumber="+_identifyNumber+"&editFlag="+_editflag+"&levelFlag=1";
//				}else{
					strURL = "/prpall/custom/customAmountQueryG.do?_identifyType="+_identifyType+"&_insuredName="+_insuredName+"&_identifyNumber="+_identifyNumber+"&_insuredCode="+_insuredCode+"&unifiedSocialCreditCode="+_unifiedSocialCreditCode;
				//}
				var transaction = YAHOO.util.Connect.asyncRequest('GET',strURL, callback); 
			},
	
			/**
			 * @Author : PICC GEFEI
			 * @description 创建客户信息
			 * @param url
			 * @return
			 * @date 2009-09-17
			 */
			createCustomer : function (url){
				var _insuredType = fm._insuredType.value;
				var _insuredName = fm._insuredName.value;
				var _identifyNumber = fm._identifyNumber.value;
				var _identifyType = fm._identifyType.value;
				var _unifiedSocialCreditCode = fm._unifiedSocialCreditCode.value;
				if(_insuredType == "1"){
					var strURL = url+"?customerCName="+URLEncoding(_insuredName)+"&identifyType="+_identifyType+"&identifyNumber="+_identifyNumber+"&syscode=prpall";
					var comCode = document.getElementById("comCode").value;
					var riskCode = document.getElementById("riskCode").value;
					if((riskCode == "DAA" || riskCode == "DZA")){
						var certiEndDate = "";
						if (document.getElementById("ocrData.certiEndDate") != null) {
							certiEndDate = document.getElementById("ocrData.certiEndDate").value;
						}
						strURL+= "&gender="+document.getElementById("_sex").value+"&dateValid="+certiEndDate+"&addressCname="+URLEncoding(document.getElementById("_insuredAddress").value);
						if (comCode.substring(0,2) == "11") {
							var issure ="";
							if (document.getElementById("ocrData.issure") != null) {
								issure=document.getElementById("ocrData.issure").value;
							}
							strURL+= "&institution="+issure;
						}
					}
					window.open(strURL);
				}else if(_insuredType == "2"){
					var strURL = url+"?customerCName="+URLEncoding(_insuredName)+"&organizeCode="+_identifyNumber+"&unifiedSocialCreditCode="+_unifiedSocialCreditCode+"&syscode=prpall";
					window.open(strURL, "QueryCustomList", "height=600,width=800,top=200,left=200,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0");
				}
			},
			/**
			 * @author sinosoft
			 * @description 调用客户系统后，返回进行赋值、主要属性设置为只读
			 *<p>
			 *<font color=red>规则 : R29,R471,R643</font>
			 *</p>
			 * @param filed
			 * 		   输入域
			 * @return
			 */
			insuredValue : function(filed){
				var comCode =  document.getElementById("comCode").value;
			    var riskCode = document.getElementById("riskCode").value;
				document.getElementById("save2").focus();
				var _insuredType = fm._insuredType.value;
				document.getElementById("_insuredType").disabled = true;
				//判断是否要置主要字段为只读。
				var readOnlyFlag = Insured.getAuditStatus(filed.data[0].auditStatus);
				var electronicPolicyFlag = document.getElementById("electronicPolicyFlag"); 
				// R29
				if(_insuredType == "1"){
			        document.getElementById("_insuredCode").value=filed.data[0].insuredCode;
			        var insuredFlag = document.getElementsByName("_insuredFlag");
			        if(readOnlyFlag=="1")
			        {
			       		 document.getElementById("_insuredCode").readOnly = true;
			       	}
			        document.getElementById("_insuredName").value=filed.data[0].insuredName;// 名称
			        if(readOnlyFlag=="1")
			        {
			        	document.getElementById("_insuredName").readOnly = true;
			        }
			        if(filed.data[0].identifyType  != null)
			        {
			        	document.getElementById("_identifyType").value = filed.data[0].identifyType;// 证件类型
			        	if(readOnlyFlag=="1")
			        	{
			        		document.getElementById("_identifyType").disabled = true;
			        	}
			        }
			        if(filed.data[0].countryCode  != null)
			        {
			        	document.getElementById("_countryCode").value = filed.data[0].countryCode;// 国籍
			        	if(readOnlyFlag=="1")
			        	{
			        		document.getElementById("_countryCode").disabled = true;
			        	}
			        }
			        if(filed.data[0].resident  != null)
			        {
			        	document.getElementById("_resident").value = filed.data[0].resident;// 居民与非居民
			        }
			        if(filed.data[0].unitType  != null)
			        {
			        	document.getElementById("_unitType").value = filed.data[0].unitType;// 单位性质
			        }
			        var IDCARD_SHIELD = document.getElementById("IDCARD_SHIELD");
			        if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1" && document.getElementById("_identifyType").value =="01"){
				        if(filed.data[0].identifyNumber  != null){
					        document.getElementById("_identifyNumber1").value = filed.data[0].identifyNumber;// 隐藏域加密证件号码
				        	if(readOnlyFlag=="1"){
				        		document.getElementById("_identifyNumber").readOnly = true;
				        	}
				        }
				        if(filed.data[0].identifyNumberLSJ != null && filed.data[0].identifyNumberLSJ != ""){
			        		document.getElementById("_identifyNumber").value = filed.data[0].identifyNumberLSJ.substr(0, 10) + "******" + filed.data[0].identifyNumberLSJ.substr(16, 2);
			        		//指定驾驶人
			        		if(insuredFlag!=null && insuredFlag[3] != null && insuredFlag[3].checked){
				        		document.getElementById("_drivingLicenseNo").value = filed.data[0].identifyNumberLSJ.substr(0, 10) + "******" + filed.data[0].identifyNumberLSJ.substr(16, 2);
				        		document.getElementById("_drivingLicenseNoLSJ").value = filed.data[0].identifyNumber;
			        		}
				        }
			        }else{
				        if(filed.data[0].identifyNumber  != null){
					        document.getElementById("_identifyNumber").value = filed.data[0].identifyNumber.trim();// 证件号码
				        	if(readOnlyFlag=="1"){
				        		document.getElementById("_identifyNumber").readOnly = true;
				        	}
				        }
			        }
			        if(filed.data[0].sex != null && filed.data[0].sex!="")
			        {
			        	document.getElementById("_sex").value = filed.data[0].sex;// 性别
			        }else{
			        	document.getElementById("_sex").value = '0';
			        }
			        if(filed.data[0].age != null && filed.data[0].age != ""){
			        	document.getElementById("_age").value = filed.data[0].age;// 年龄
			        }else{
			        	document.getElementById("_age").value = "";
			        }
			        if(readOnlyFlag=="1"){
		        		document.getElementById("_sex").disabled = true;
		        	}
			        
			        if(filed.data[0].insuredAddress  != null) {
			        	document.getElementById("_insuredAddress").value = filed.data[0].insuredAddress;// 地址
			        } else {
			        	document.getElementById("_insuredAddress").value = "";
			        }
			        if(readOnlyFlag=="1"){
			        	document.getElementById("_insuredAddress").readOnly = true;
			        }
			        if(filed.data[0].postCode  != null) {
			        	document.getElementById("_postCode").value = filed.data[0].postCode;// 邮编
			        } else {
			        	document.getElementById("_postCode").value = "";
			        }
			        if(readOnlyFlag=="1"){
			        	document.getElementById("_postCode").readOnly = true;
			        }
			        var phoneType = filed.data[0].phoneType;
			        if(filed.data[0].mobile != null) {
			        	document.getElementById("_mobile").value = filed.data[0].mobile;// 隐藏域加密移动电话
			   		} else {
			   			document.getElementById("_mobile").value = "";// 移动电话
			   		}
			        if(filed.data[0].mobileNoYG != null && filed.data[0].mobileNoYG != "") {
			        	document.getElementById("_mobile1").value = filed.data[0].mobileNoYG.substr(0, 3) + "****" + filed.data[0].mobileNoYG.substr(7, 4);// 显示未加密移动电话
			   		} else {
			   			document.getElementById("_mobile1").value = "";// 移动电话
			   		}
			        //Insured.checkMoblieBack();
			        if(readOnlyFlag=="1")
			        {
			        	document.getElementById("_mobile1").readOnly = true;
			        }
			   		if(filed.data[0].phoneNumber != null) {
			   			document.getElementById("_phoneNumber").value = filed.data[0].phoneNumber;// 固定电话
			   		} else {
			   			document.getElementById("_phoneNumber").value = "";// 固定电话
			   		}
			   		Insured.checkPhoneNumberBack();
			   		if(readOnlyFlag=="1")
			   		{
			   			document.getElementById("_phoneNumber1").readOnly = true;
			   		}
				   	Insured.checkIdentifyNumberID(document.getElementById("_identifyNumber"));
			   		if(filed.data[0].versionNo != null)
			   		{
			   			// R643
			   			document.getElementById("_versionNo").value = filed.data[0].versionNo;// 版本号码
			   		}
			   		if(filed.data[0].auditStatus != null)
			   		{
			   			var auditStatus = filed.data[0].auditStatus;// 审批状态
			   			var auditStatusDes = Insured.tranAuditStatus(trim(auditStatus));
			   			document.getElementById("_auditStatus").value = trim(auditStatus);
						document.getElementById("_auditStatusDes").value = auditStatusDes;
			   		}
			   		if(filed.data[0].groupCode != null){
			   			document.getElementById("group_code").value = filed.data[0].groupCode;
			   		}
			   		if(filed.data[0].isCheckRepeat != null){
			   			document.getElementById("_isCheckRepeat").value = filed.data[0].isCheckRepeat;
			   		}
			   		if(filed.data[0].configedRepeatTimes != null){
			   			document.getElementById("_configedRepeatTimes").value = filed.data[0].configedRepeatTimes;
			   		}
			   		if(filed.data[0].repeatTimes != null){
			   			document.getElementById("_repeatTimes").value = filed.data[0].repeatTimes;
			   		}
			   		if((riskCode == "DAA" || riskCode == "DAV") && electronicPolicyFlag != null
			   			&& (comCode.substring(0,2)=="11" || (electronicPolicyFlag.value == "2" && comCode.substring(0,2)=="36" ) 
			   				|| electronicPolicyFlag.value == "1")){
			   			if(filed.data[0].email != null){
				   			document.getElementById("_email").value = filed.data[0].email;
				   		}
			   		}
			   		if(comCode.substring(0,2) == "11" && riskCode == "DAA"){
			   			if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1" && document.getElementById("_identifyType").value == "01"){
			   				document.getElementById("idCardCheckInfo.idcardCode").value =document.getElementById("_identifyNumber1").value;
			   			}else{
			   				document.getElementById("idCardCheckInfo.idcardCode").value = document.getElementById("_identifyNumber").value;
			   			}
			   			document.getElementById("idCardCheckInfo.name").value = document.getElementById("_insuredName").value;
			   			if(filed.data[0].nation != null){
							document.getElementById("idCardCheckInfo.nation").value = filed.data[0].nation;//民族
			   			}
			   			if(filed.data[0].birthDate != null){
							document.getElementById("idCardCheckInfo.birthday").value = ItemKind.formatDateToDay(filed.data[0].birthDate);//出生日期
			   			}
			   			document.getElementById("idCardCheckInfo.sex").value = document.getElementById("_sex").value;
			   			if(filed.data[0].address != null){
							document.getElementById("idCardCheckInfo.address").value = filed.data[0].address;//住址
			   			}
			   			if(filed.data[0].institution != null){
							document.getElementById("idCardCheckInfo.issure").value = filed.data[0].institution;//签发机构
			   			}
			   			if(filed.data[0].dateValidStart != null){
							document.getElementById("idCardCheckInfo.validStartDate").value = ItemKind.formatDate(filed.data[0].dateValidStart);//身份证有效期起期
			   			}
			   			if(filed.data[0].dateValid != null){
							document.getElementById("idCardCheckInfo.validEndDate").value = ItemKind.formatDate(filed.data[0].dateValid);//身份证有效期止期
			   			}
						document.getElementById("idCardCheckInfo.samCode").value = "";//身份证采集器编码
						document.getElementById("idCardCheckInfo.samType").value = "";//采集设备类型
			   			document.getElementById("idCardCheckInfo.flag").value = "2";
			   		}
			 	}else{
			 		document.getElementById("_insuredCode").value=filed.data[0].insuredCode;
			 		if(readOnlyFlag=="1")
			   		{
			 			document.getElementById("_insuredCode").readOnly = true;
			 		}
			    	document.getElementById("_insuredName").value=filed.data[0].insuredName;// 名称
				    if(readOnlyFlag=="1")
				    {
				        document.getElementById("_insuredName").readOnly = true;
				    }
				    if(filed.data[0].unitType  != null)
			 		{
			 			//当单位性质为空时默认为企业单位;LICHENHUI;20111025(bug16057);begin;
			 			if(trim(filed.data[0].unitType)!=""){
				 			document.getElementById("_unitType").value = filed.data[0].unitType;// 单位性质
			 			}else{
			 				document.getElementById("_unitType").value = "";
			 			}
			 		}
				    
	    			if(filed.data[0].unifiedSocialCreditCode != null)
			        {
			        	document.getElementById("_unifiedSocialCreditCode").value = filed.data[0].unifiedSocialCreditCode; //统一社会信用代码	
			        	if(readOnlyFlag=="1")
			        	{
			        		document.getElementById("_unifiedSocialCreditCode").readOnly = true;
			        	}
			        }
	    			if(filed.data[0].revenueCode != null)
			        {
			        	document.getElementById("_revenueCode").value = filed.data[0].revenueCode; //税务代码	
			        }
				    if(filed.data[0].countryCode  != null) {
			        	document.getElementById("_countryCode").value = filed.data[0].countryCode;// 国籍
			        }
			        if(filed.data[0].resident  != null) {
			        	document.getElementById("_resident").value = filed.data[0].resident;// 居民与非居民
			        }
			        if(filed.data[0].identifyNumber  != null)
			 		{
			 			document.getElementById("_identifyNumber").value = filed.data[0].identifyNumber.trim();// 证件号码
			 		}
			 		//LiChenhui;组织机构代码控制只读;20100930;begin;
					if(readOnlyFlag=="1")
			    	{
						document.getElementById("_identifyNumber").readOnly = true;
					}
					if(filed.data[0].insuredAddress  != null) {
			        	document.getElementById("_insuredAddress").value = filed.data[0].insuredAddress;// 地址
			        } else {
			        	document.getElementById("_insuredAddress").value = "";
			        }
			        if(readOnlyFlag=="1"){
			        	document.getElementById("_insuredAddress").readOnly = true;
			        }
			        if(filed.data[0].postCode  != null) {
			        	document.getElementById("_postCode").value = filed.data[0].postCode;// 邮编
			        } else {
			        	document.getElementById("_postCode").value = "";
			        }
			        if(readOnlyFlag=="1"){
			        	document.getElementById("_postCode").readOnly = true;
			        }
			        var phoneType = filed.data[0].phoneType;
			        if(filed.data[0].mobile != null) {
			        	document.getElementById("_mobile").value = filed.data[0].mobile;// 隐藏域加密移动电话
			   		} else {
			   			document.getElementById("_mobile").value = "";// 移动电话
			   		}
			        if(filed.data[0].mobileNoYG != null && filed.data[0].mobileNoYG !="") {
			        	document.getElementById("_mobile1").value = filed.data[0].mobileNoYG.substr(0, 3) + "****" + filed.data[0].mobileNoYG.substr(7, 4);// 显示未加密移动电话
			   		} else {
			   			document.getElementById("_mobile1").value = "";// 移动电话
			   		}
			        if (filed.data[0].taxPayerNumber != null && filed.data[0].taxPayerNumber !="") {
			        	document.getElementById("_taxPayerNumber").value = filed.data[0].taxPayerNumber;//纳税人识别号
					}
			        //Insured.checkMoblieBack();
			        if(readOnlyFlag=="1")
			        {
			        	document.getElementById("_mobile1").readOnly = true;
			        }
			        if(comCode.substring(0,2) == "11" && (riskCode == "DAA" || riskCode == "DAV")){
			        	document.getElementById("_mobile1").readOnly = false;
		   			}
			   		if(filed.data[0].phoneNumber != null) {
			   			document.getElementById("_phoneNumber").value = filed.data[0].phoneNumber;// 固定电话
			   		} else {
			   			document.getElementById("_phoneNumber").value = "";// 固定电话
			   		}
			   		Insured.checkPhoneNumberBack();
			   		if(readOnlyFlag=="1")
			   		{
			   			document.getElementById("_phoneNumber1").readOnly = true;
			   		}
			   		if(filed.data[0].versionNo != null)
			   		{
			   			document.getElementById("_versionNo").value = filed.data[0].versionNo;// 版本号码
			   		}
			   		if(filed.data[0].auditStatus != null)
			   		{
			   			var auditStatus = filed.data[0].auditStatus;// 审批状态
			   			var auditStatusDes = Insured.tranAuditStatus(trim(auditStatus));
			   			document.getElementById("_auditStatus").value = trim(auditStatus);
						document.getElementById("_auditStatusDes").value = auditStatusDes;
			   		}
			   		if(filed.data[0].appendPrintName != null)
			   		{
			   			document.getElementById("_appendPrintName").value = filed.data[0].appendPrintName;// 批改附加
			   		}
			   		
			   		if(filed.data[0].groupCode != null){
			   			document.getElementById("group_code").value = filed.data[0].groupCode;
			   		}
			   		if((riskCode == "DAA" || riskCode == "DAV") && electronicPolicyFlag != null 
			   			&& (comCode.substring(0,2)=="11" || (electronicPolicyFlag.value == "2" && comCode.substring(0,2)=="36")
			   				|| electronicPolicyFlag.value == "1")){
			   			if(filed.data[0].email != null){
				   			document.getElementById("_email").value = filed.data[0].email;
				   		}
			   		}	
							   
			 	}
				var isFinanceCustomer = document.getElementById("_isFinanceCustomer");
				if(isFinanceCustomer != null && isFinanceCustomer != undefined){
			        while(document.all("_isFinanceCustomer").options.length>0){
			        	document.all("_isFinanceCustomer").options.remove(0);
			        }
			        if(filed.data[0].financeFlag  == "0") {
			        	isFinanceCustomer.options.add(new Option("否","3"));
			        	isFinanceCustomer.options.add(new Option("普惠融资间接带动","2"));
						document.getElementById("financeFlag").value = "0";
			        }else{
			        	isFinanceCustomer.options.add(new Option("否","3"));
			        	isFinanceCustomer.options.add(new Option("普惠融资间接带动","2"));
			        	isFinanceCustomer.options.add(new Option("普惠融资直接带动","1"));
						document.getElementById("financeFlag").value = "1";
			        }
				}
				//校验客户系统返回信息
				Insured.checkCstReturnInfo(filed.data[0].mobile, filed.data[0].phoneNumber, filed.data[0].insuredAddress);
			},
	
			/**
			 * @author xuzechao
			 * @description 浏览关系人信息时只设置客户评级值
			 * @param filed
			 * 		   客户系统返回的关系人信息
			 * @return
			 */
			insuredLevelValue : function(filed) {
				if(document.getElementById("modelList")!=null){
					document.getElementById("modelList").innerHTML=Insured.showLevel(filed.data[0].prpDcstLevelList);
				}
			},
			/**
			 * @author sinosoft
			 * @description 显示客户评级信息列表信息
			 * @param filed:
			 * 		   客户系统返回的客户评级信息
			 * @return 返回列表Table
			 */
			showLevel : function (filed)
			{
				if(filed == null || filed.length == 0)
					{
						var str = "";
						str +="<table id='UnitPersonEdit' border='0' cellpadding='0' class='common_table'  width='100%' cellspacing='1'>";
						str +="<tr class='sort'>";
						str +="<td align='center'>模型级别</td>";
						str +="<td align='center'>客户等级</td>";
						str +="<td align='center'>等级描述</td>";
						str +="<td align='center'>等级来源</td>";
						str +="<td align='center'>证件号码</td>";
						str +="<td align='center'>渠道类型</td>";
						str +="</tr><tr><td colspan = '6' align='center'>无记录</td></tr></table>";
						document.getElementById("modelList").innerHTML=str;
					}
					else if(filed != null && filed.length > 0)
					{
						var str = "";
						str +="<table id='UnitPersonEdit' border='0' cellpadding='0' class='common_table'  width='100%' cellspacing='1'>";
						str +="<tr class='sort'>";
						str +="<td align='center'>模型级别</td>";
						str +="<td align='center'>客户等级</td>";
						str +="<td align='center'>等级描述</td>";
						str +="<td align='center'>等级来源</td>";
						str +="<td align='center'>证件号码</td>";
						str +="<td align='center'>渠道类型</td>";
						str +="</tr>";
						var prpList = filed;
						for(i=0;i<prpList.length;i++)
				   			{
				   				var prp = prpList[i];
								str += "<tr><td align='center'>";
								if(prp.id.modelEname.indexOf("Z") ==0)
								{
									str +="总公司</td><td align='center'>";
								}else if(prp.id.modelEname.indexOf("F") == 0)
								{
									str +="分公司</td><td align='center'>";
								}else
								{
									str +="</td><td align='center'>";
								}
								str += prp.gradeName;
								str +="</td><td align='center'>";
								str += prp.gradeDescribe;
								str +="</td><td align='center'>";
								if(prp.sourceType == "1")
								{
									str +="自动评级";
								}else if(prp.sourceType == "2")
								{
									str +="手动评级";
								}
								str +="</td><td align='center'>";
						        var IDCARD_SHIELD = document.getElementById("IDCARD_SHIELD");
						        if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1"){
						        	if(prp.identifyCardNo != null && prp.identifyCardNo != "" && prp.identifyCardNo != undefined ){
								        if(Insured.checkIdentifyCardNo(prp.identifyCardNo.trim())){
								        	str +=prp.identifyCardNo.trim().substr(0, 10) + "******" + prp.identifyCardNo.trim().substr(16, 2);
								        }else{
								        	str +=prp.identifyCardNo;
								        }
						        	}else{
						        		str +=prp.identifyCardNo;
						        	}
						        }else{
									str +=prp.identifyCardNo;
						        }
								str +="</td><td align='center'>";
								if(prp.channelType =="1")
								{
									str +="电销";
								}else if(prp.channelType =="2")
								{
									str +="网销";
								}
								str +="</td></tr>";
				   			}
						str +="</table>";
					}
				return str;
			},
			checkIdentifyCardNo : function (StrNo){
				if (StrNo.length == 18) {
					var a, b, c
					// R627
					if (!Common.isNumber(StrNo.substr(0, 17))) {
						//alert("身份证号码错误,18位的身份证号前17位必须是数字！");
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
							//alert("身份证号码校验位错:最后一位应该为:1");
							return false;
						}
						break;
					case 1:
						if (c != 0) {
							//alert("身份证号码校验位错:最后一位应该为:0");
							return false;
						}
						break;
					case 2:
						if (c != "X") {
							//alert("身份证号码校验位错:最后一位应该为:X");
							return false;
						}
						break;
					case 3:
						if (c != 9) {
							//alert("身份证号码校验位错:最后一位应该为:9");
							return false;
						}
						break;
					case 4:
						if (c != 8) {
							//alert("身份证号码校验位错:最后一位应该为:8");
							return false;
						}
						break;
					case 5:
						if (c != 7) {
							//alert("身份证号码校验位错:最后一位应该为:7");
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
							//alert("身份证号码校验位错:最后一位应该为:4");
							return false;
						}
						break;
					case 9:
						if (c != 3) {
							//alert("身份证号码校验位错:最后一位应该为:3");
							return false;
						}
						break;
					case 10:
						if (c != 2) {
							//alert("身份证号码校验位错:最后一位应该为:2");
							return false;
						}
					}
					return true;
				}
				return false;
			},
			/**
			 * @author sinosoft
			 * @description 通过客户返回的"审批状态代号"转换成"审批状态名称"
			 * @param auditStatus
			 * 		   审批状态代号
			 * return 审批状态含义
			 */
			tranAuditStatus : function(auditStatus){
				var auditStatusDes = "";
				switch(auditStatus){
					case '':
						auditStatusDes = "审批通过";break;
					case '2':
						auditStatusDes = "审批通过";break;
					case '0':
						auditStatusDes = "未提交审批";break;
					case '1':
						auditStatusDes = "待审批";break;
					case '3':
						auditStatusDes = "审批不通过";break;
					default:break;
				}
				return auditStatusDes;
			},
			/**
			 * @author sinosoft
			 * @description 通过客户返回的"审批状态代号"返回相应的只读情况
			 * @param auditStatus
			 * 		   审批状态代号
			 * @return 返回值：1为只读；0为不只读
			 */
			getAuditStatus : function(auditStatus){
				var readOnlyFlag = "";
				switch(auditStatus){
					case '':
						readOnlyFlag = "1";break;
					case '2':
						readOnlyFlag = "1";break;
					case '0':
						readOnlyFlag = "0";break;
					case '1':
						readOnlyFlag = "0";break;
					case '3':
						readOnlyFlag = "0";break;
					default:break;
				}
				return readOnlyFlag;
			},
			/**
			 * @author hxd
			 * @description 如果客户返回的结果大于1条时，根据关系人类型在新的页面里显示多条的客户信息
			 * @param url
			 * 		   客户系统的接口地址
			 * @return
			 */
			searchCustomer : function (url){
				var _insuredType = fm._insuredType.value;
				var _insuredName = fm._insuredName.value;
				var _identifyNumber = fm._identifyNumber.value;
				var _identifyType = fm._identifyType.value;
				if(_insuredType == "1"){
					var strURL = url+"?customerCName="+URLEncoding(_insuredName)+"&identifyType="+_identifyType+"&identifyNumber="+_identifyNumber+"&syscode=prpall";
					window.open(strURL, "QueryCustomList", "height=600,width=800,top=200,left=200,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0");
				
				}else if(_insuredType == "2"){
					var strURL = url+"?customerCName="+URLEncoding(_insuredName)+"&organizeCode="+_identifyNumber+"&syscode=prpall";
					window.open(strURL, "QueryCustomList", "height=600,width=800,top=200,left=200,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0");
				}
			},
			/**
			 * @author sinosoft
			 * @description 对客户信息进行修改
			 * @return
			 */
			editCustomer : function(){
				var insuredType = document.getElementById("_insuredType").value;
				var customerURL = document.getElementById("customerURL").value;
				var insuredCode = document.getElementById("_insuredCode").value;
				if(insuredCode=="")
				{
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
			},
			/**
			 * @author sinosoft
			 * @description 将客户新增或查询界面返回信息赋值到页面（类型为"个人"）
			 * @param obj
			 * 		   关系人信息
			 * @return
			 */
			insuredValueP : function(obj){ // 自然人
				var IDCARD_SHIELD = document.getElementById("IDCARD_SHIELD");
				var readOnlyFlag = Insured.getAuditStatus(obj.auditStatus);
				var insuredFlag = document.getElementsByName("_insuredFlag");
				if(obj.insuredCode != null && obj.insuredCode != undefined ){
					document.getElementById("_insuredCode").value = obj.insuredCode;// ID
					if(readOnlyFlag=="1")
			        {
			       		 document.getElementById("_insuredCode").readOnly = true;
			       	}
				}
				if(obj.insuredName != null && obj.insuredName != undefined ){
					document.getElementById("_insuredName").value = obj.insuredName;// 名称
					if(readOnlyFlag=="1")
			        {
			       		 document.getElementById("_insuredName").readOnly = true;
			       	}
				}
				if(obj.identifytype != null && obj.identifytype != undefined ){
					document.getElementById("_identifyType").value = obj.identifytype;// 证件类型
					if(readOnlyFlag=="1")
			        {
			       		 document.getElementById("_identifyType").disabled = true;
			       	}
				}
				if(obj.identifyNumberEdit != null && obj.identifyNumberEdit != undefined ){
					if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1" && obj.identifytype != null && obj.identifytype.trim() == "01"){
			            document.getElementById("_identifyNumber").value = obj.identifyNumberEdit.trim().substr(0, 10) + "******" + obj.identifyNumberEdit.trim().substr(16, 2);
			            if(obj.identifyNumberLSJ != null && obj.identifyNumberLSJ != undefined && obj.identifyNumberLSJ !=""){
			            	//隐藏域赋值
							document.getElementById("_identifyNumber1").value = obj.identifyNumberLSJ;	
			            }
			            if(insuredFlag!=null && insuredFlag[3] != null && insuredFlag[3].checked){
				            document.getElementById("_drivingLicenseNo").value = obj.identifyNumberEdit.trim().substr(0, 10) + "******" + obj.identifyNumberEdit.trim().substr(16, 2);
				            document.getElementById("_drivingLicenseNoLSJ").value = obj.identifyNumberLSJ;
			            }
					}else{
						document.getElementById("_identifyNumber").value = obj.identifyNumberEdit.trim();// 证件号码
					}
					if(readOnlyFlag=="1")
			        {
			       		 document.getElementById("_identifyNumber").readOnly = true;
			       	}
				}
				if(obj.sex != null && obj.sex != undefined &&  obj.sex !=""){
					document.getElementById("_sex").value = obj.sex;// 性别
					
				}else{
					document.getElementById("_sex").value ='0';
				}
				if(obj.age != null && obj.age != undefined &&  obj.age != ""){
					document.getElementById("_age").value = obj.age;// 年龄
				}else{
					document.getElementById("_age").value = "";
				}
				if(readOnlyFlag=="1")
		    	{
		    		document.getElementById("_sex").disabled = true;
		    	}
				if(obj.countryCode != null && obj.countryCode != undefined ) {
					document.getElementById("_countryCode").value = obj.countryCode;// 国籍
					if(readOnlyFlag=="1")
		        	{
		        		document.getElementById("_countryCode").disabled = true;
		        	}
				}
		        if(obj.resident != null && obj.resident != undefined ) {
		        	if(document.getElementById("_resident") != null){
		        		document.getElementById("_resident").value = obj.resident;// 居民与非居民
		        	}
		        }
				/*if(obj.mobile != null && obj.mobile != undefined && obj.mobile !=""){
					document.getElementById("_mobile").value = obj.mobile;// 移动电话
				} else {
					document.getElementById("_mobile").value = "";// 移动电话
				}*/
		        if(obj.mobileNoYG != null && obj.mobileNoYG != undefined && obj.mobileNoYG !=""){
					document.getElementById("_mobile1").value = obj.mobileNoYG.substr(0, 3) + "****" + obj.mobileNoYG.substr(7, 4) ;// 移动电话
				} else {
					document.getElementById("_mobile1").value = "";// 移动电话
				}
				//意外险
				/*if(obj.mobile != null && obj.mobile != undefined && obj.mobile !=""){
					 var mobiles = obj.mobile;
		       		 if(document.getElementById("_mobiles") != null){
		       			 document.getElementById("_mobiles").value = mobiles.substr(0, 3) + "****" + mobiles.substr(7, 4);// 移动电话
		       			 document.getElementById("_mobile").value = mobiles;// 移动电话
		       		 }
				}*/
				//对隐藏域赋值
				document.getElementById("_mobile").value = obj.mobile;	
				//Insured.checkMoblieBack();
				if(readOnlyFlag=="1")
				{
					if(document.getElementById("_mobile1") != null){
						document.getElementById("_mobile1").readOnly = true;
					}
				}
				if(obj.phoneNumber != null && obj.phoneNumber != undefined && obj.phoneNumber !=""){
					document.getElementById("_phoneNumber").value = obj.phoneNumber;// 固定电话
				} else {
					document.getElementById("_phoneNumber").value = "";
				}
				Insured.checkPhoneNumberBack();
				if(readOnlyFlag=="1")
				{
					if(document.getElementById("_phoneNumber1") != null){
						document.getElementById("_phoneNumber1").readOnly = true;
					}
				}
				if(obj.insuredAddress != null && obj.insuredAddress != undefined ){
					document.getElementById("_insuredAddress").value = obj.insuredAddress;// 地址
				} else {
					document.getElementById("_insuredAddress").value = "";
				}
				if(readOnlyFlag=="1"){
					document.getElementById("_insuredAddress").readOnly = true;
				}
				if(obj.postCode != null && obj.postCode != undefined ){
					document.getElementById("_postCode").value = obj.postCode;// 邮编
				} else {
					document.getElementById("_postCode").value = "";
				}
				if(readOnlyFlag=="1"){
					document.getElementById("_postCode").readOnly = true;
				}
			  	if(document.getElementById("_identifyType").value =="01" || document.getElementById("_identifyType").value =="16"){
			  		var identifyNumber = document.getElementById("_identifyNumber");
			  		Insured.checkIdentifyNumberID(identifyNumber);
			  	}
			  	if(obj.auditStatus != null && obj.auditStatus != undefined ){
					var auditStatus = obj.auditStatus;// 审批状态
					var auditStatusDes = Insured.tranAuditStatus(auditStatus);
					document.getElementById("_auditStatus").value = auditStatus;
					document.getElementById("_auditStatusDes").value = auditStatusDes;
				}
				if(obj.versionNo != null && obj.versionNo != undefined ){
					document.getElementById("_versionNo").value = obj.versionNo;// 版本号
				}
				if(obj.appendPrintName != null && obj.appendPrintName != undefined ){
					document.getElementById("_appendPrintName").value = obj.appendPrintName;// 打印附加
				}
				if(obj.groupCode != null && obj.groupCode != undefined ){
					document.getElementById("group_code").value = obj.groupCode;// 集团代码
				}
				if(obj.phoneRepeatCheckFlag != null && obj.phoneRepeatCheckFlag != undefined ){
		   			document.getElementById("_isCheckRepeat").value = obj.phoneRepeatCheckFlag;
		   		}
		   		if(obj.configedRepeatTimes != null && obj.configedRepeatTimes != undefined ){
		   			document.getElementById("_configedRepeatTimes").value = obj.configedRepeatTimes;
		   		}
		   		if(obj.phoneNumberRepeatTimes != null && obj.phoneNumberRepeatTimes != undefined ){
		   			document.getElementById("_repeatTimes").value = obj.phoneNumberRepeatTimes;
		   		}
		   		var comCode = document.getElementById("comCode").value;
				var riskCode = document.getElementById("riskCode").value;
				if(comCode.substring(0,2) == "11" && riskCode == "DAA"){
					if(obj.email != null && obj.email != undefined ){
			   			document.getElementById("_email").value = obj.email;
			   		}
				}
				var isFinanceCustomer = document.getElementById("_isFinanceCustomer");
				if(isFinanceCustomer != null && isFinanceCustomer != undefined){
			        while(document.all("_isFinanceCustomer").options.length>0){
			        	document.all("_isFinanceCustomer").options.remove(0);
			        }
			        if(obj.financeFlag  == "0") {
			        	isFinanceCustomer.options.add(new Option("否","3"));
			        	isFinanceCustomer.options.add(new Option("普惠融资间接带动","2"));
						document.getElementById("financeFlag").value = "0";
			        }else{
			        	isFinanceCustomer.options.add(new Option("否","3"));
			        	isFinanceCustomer.options.add(new Option("普惠融资间接带动","2"));
			        	isFinanceCustomer.options.add(new Option("普惠融资直接带动","1"));
						document.getElementById("financeFlag").value = "1";
			        }
				}
				if(comCode.substring(0,2) == "11" && riskCode == "DAA"){
					if(obj.identifyNumberEdit != null && obj.identifyNumberEdit != undefined ){
						document.getElementById("idCardCheckInfo.idcardCode").value = obj.identifyNumberEdit.trim();// 身份证号
					}
					if(obj.insuredName != null && obj.insuredName != undefined ){
						document.getElementById("idCardCheckInfo.name").value = obj.insuredName;//姓名
					}
                    if(obj.nation != null && obj.nation != undefined ){
						document.getElementById("idCardCheckInfo.nation").value = obj.nation;//民族
                    }
                    if(obj.birthday != null && obj.birthday != undefined ){
						document.getElementById("idCardCheckInfo.birthday").value = obj.birthday;//出生日期
                    }
    				if(obj.sex != null && obj.sex != undefined ){
    					document.getElementById("idCardCheckInfo.sex").value = obj.sex;//性别
    				}
    				if(obj.address != null && obj.address != undefined ){
    					document.getElementById("idCardCheckInfo.address").value = obj.address;//住址
    				}
    				if(obj.issure != null && obj.issure != undefined ){
    					document.getElementById("idCardCheckInfo.issure").value = obj.issure;//签发机构
    				}
    				if(obj.validStartDate != null && obj.validStartDate != undefined ){
						document.getElementById("idCardCheckInfo.validStartDate").value = obj.validStartDate;//身份证号码有效开始时间
    				}
    				if(obj.validEndDate != null && obj.validEndDate != undefined ){
						document.getElementById("idCardCheckInfo.validEndDate").value =obj.validEndDate;//身份证号码有效结束时间
    				}
					document.getElementById("idCardCheckInfo.samCode").value = "";//身份证采集器编码
					document.getElementById("idCardCheckInfo.samType").value = "";//采集设备类型
					document.getElementById("idCardCheckInfo.flag").value = "2";
				}
				//校验客户系统返回信息
				Insured.checkCstReturnInfo(obj.mobileNoYG, obj.phoneNumber, obj.insuredAddress);
			},
			/**
			 * @author sinosoft
			 * @description 将客户新增或查询界面返回信息赋值到页面（类型为"团体"）
			 * @param obj
			 * 		   关系人信息
			 * @return
			 */
			insuredValueG : function(obj){ // 法人
				var readOnlyFlag = Insured.getAuditStatus(obj.auditStatus);
				if(obj.insuredCode != null && obj.insuredCode != undefined ){
					document.getElementById("_insuredCode").value = obj.insuredCode.trim();// ID
					if(readOnlyFlag=="1")
			        {
			       		 document.getElementById("_insuredCode").readOnly = true;
			       	}
				}
				if(obj.insuredName != null && obj.insuredName != undefined ){
					document.getElementById("_insuredName").value = obj.insuredName;// 名称
					if(readOnlyFlag=="1")
			        {
			       		 document.getElementById("_insuredName").readOnly = true;
			       	}
				}
				if(obj.unifiedSocialCreditCode != null && obj.unifiedSocialCreditCode != undefined ){
					document.getElementById("_unifiedSocialCreditCode").value = obj.unifiedSocialCreditCode; //统一社会信用代码		
					if(readOnlyFlag=="1")
			        {
			       		 document.getElementById("_unifiedSocialCreditCode").readOnly = true;
			       	}
				}
				if(obj.revenueCode !=null && obj.revenueCode !=undefined){
					document.getElementById("_revenueCode").value = obj.revenueCode; //税务代码	
				}
				
				if(obj.identifyNumberEdit != null && obj.identifyNumberEdit != undefined ){
					document.getElementById("_identifyNumber").value = obj.identifyNumberEdit.trim();// 组织机构代码
				}
				if(obj.countryCode != null && obj.countryCode != undefined ) {
					document.getElementById("_countryCode").value = obj.countryCode;// 国籍
				}
				if(obj.unitType != null && obj.unitType != undefined ){
					document.getElementById("_unitType").value = obj.unitType;// 单位性质
				}
		        if(obj.resident != null && obj.resident != undefined ) {
		        	document.getElementById("_resident").value = obj.resident;// 居民与非居民
		        }
				//LiChenhui;组织机构代码控制只读;20100930;begin;
				if(readOnlyFlag=="1")
			    {
			      		 document.getElementById("_identifyNumber").readOnly = true;
			    }
				/*if(obj.mobile != null && obj.mobile != undefined && obj.mobile !=""){
					document.getElementById("_mobile").value = obj.mobile;// 移动电话
				} else {
					document.getElementById("_mobile").value = "";
				}*/
				if(obj.mobileNoYG != null && obj.mobileNoYG != undefined && obj.mobileNoYG !=""){
					document.getElementById("_mobile1").value = obj.mobileNoYG.substr(0, 3) + "****" + obj.mobileNoYG.substr(7, 4) ;// 移动电话
				} else {
					document.getElementById("_mobile1").value = "";
				}
				//对隐藏域赋值
				document.getElementById("_mobile").value =obj.mobile;
				//Insured.checkMoblieBack();
				if(readOnlyFlag=="1")
				{
					document.getElementById("_mobile1").readOnly = true;
				}
				if(obj.phoneNumber != null && obj.phoneNumber != undefined && obj.phoneNumber != ""){
					document.getElementById("_phoneNumber").value = obj.phoneNumber;// 固定电话
				} else {
					document.getElementById("_phoneNumber").value = "";
				}
				Insured.checkPhoneNumberBack();
				if(readOnlyFlag=="1")
				{
					document.getElementById("_phoneNumber1").readOnly = true;
				}
				if(obj.insuredAddress != null && obj.insuredAddress != undefined ){
					document.getElementById("_insuredAddress").value = obj.insuredAddress;// 地址
				} else {
					document.getElementById("_insuredAddress").value = "";
				}
				if(readOnlyFlag=="1"){
					document.getElementById("_insuredAddress").readOnly = true;
				}
				if(obj.postCode != null && obj.postCode != undefined ){
					document.getElementById("_postCode").value = obj.postCode;// 邮编
				} else {
					document.getElementById("_postCode").value = "";
				}
				if(readOnlyFlag=="1"){
					document.getElementById("_postCode").readOnly = true;
				}
			  	if(obj.auditStatus != null && obj.auditStatus != undefined ){
					var auditStatus = obj.auditStatus;// 审批状态
					var auditStatusDes = Insured.tranAuditStatus(auditStatus);
					document.getElementById("_auditStatus").value = auditStatus;
					document.getElementById("_auditStatusDes").value = auditStatusDes;
				}
				if(obj.versionNo != null && obj.versionNo != undefined ){
					document.getElementById("_versionNo").value = obj.versionNo;// 版本号
				}
				if(obj.appendPrintName != null && obj.appendPrintName != undefined ){
					document.getElementById("_appendPrintName").value = obj.appendPrintName;// 打印附加
				}
				if(obj.groupCode != null && obj.groupCode != undefined ){
					document.getElementById("group_code").value = obj.groupCode;// 集团代码
				}
				if(obj.taxPayerNumber != null && obj.taxPayerNumber != undefined ){
					document.getElementById("_taxPayerNumber").value = obj.taxPayerNumber;
				}
				var comCode = document.getElementById("comCode").value;
				var riskCode = document.getElementById("riskCode").value;
				if(comCode.substring(0,2) == "11" && riskCode == "DAA"){
					if(obj.email != null && obj.email != undefined ){
						document.getElementById("_email").value = obj.email;// 邮箱
					}
				}
				var isFinanceCustomer = document.getElementById("_isFinanceCustomer");
				if(isFinanceCustomer != null && isFinanceCustomer != undefined){
			        while(document.all("_isFinanceCustomer").options.length>0){
			        	document.all("_isFinanceCustomer").options.remove(0);
			        }
			        if(obj.financeFlag  == "0") {
			        	isFinanceCustomer.options.add(new Option("否","3"));
			        	isFinanceCustomer.options.add(new Option("普惠融资间接带动","2"));
						document.getElementById("financeFlag").value = "0";
			        }else{
			        	isFinanceCustomer.options.add(new Option("否","3"));
			        	isFinanceCustomer.options.add(new Option("普惠融资间接带动","2"));
			        	isFinanceCustomer.options.add(new Option("普惠融资直接带动","1"));
						document.getElementById("financeFlag").value = "1";
			        }
				}
				//校验客户系统返回信息
				Insured.checkCstReturnInfo(obj.mobileNoYG, obj.phoneNumber, obj.insuredAddress);
			},
			
			/**
			 * @author sinosoft
			 * @description 获取指定驾驶员数
			 * @return 指定驾驶员总数
			 */
			getMaxProfitDriver : function (){
				var index = document.getElementById("hidden_index_insured").value;
			    var len = parseInt(globalindex["insertInsuredRow"]);
			    if(isNaN(len)&& parseInt(index)!=0){
			    	len = parseInt(index);
			    }
				var maxObjIndex = -1;
			    var maxRate = 0;
			 	for(var j=0;j<len;j++){
					if(isNaN(document.getElementById("prpCinsureds["+j+"].insuredFlag")) && 
						document.getElementById("prpCinsureds["+j+"].insuredFlag")!=null){
						var TR = getTR(document.getElementById("prpCinsureds["+j+"].insuredFlag"));
						if(document.getElementById("prpCinsureds["+j+"].insuredFlag").value.substring(3,4)=="1" &&
								getFlagELName(TR) != null && (getFlagELName(TR)).value != 'B' 
								&& (getFlagELName(TR)).value != 'D'){
			    			driverFlag = true;
			    			var rate = Insured.getSexRate(j) * Insured.getAgeRate(j) * Insured.getDrivingYearsRate(j);
			    			if( rate > maxRate){
			    				maxRate = rate;
			    				maxObjIndex = j
			    			}
						}
					}
				}
				return maxObjIndex;
			},
			/**
			 * @author sinosoft
			 * @description 获取性别Rate
			 * @param index 第几个
			 * @return sexRate
			 */
			getSexRate : function(index){
				var sexRate;
				var sex = document.getElementById("prpCinsureds["+index+"].sex").value
				if(sex == "1"){// 男
					sexRate = 100;
				}else if(sex == "2"){
					sexRate = 95;
				}
				return sexRate;
			},
			/**
			 * @author sinosoft
			 * @description 获取年龄Rate
			 * @param index 第几个
			 * @return ageRate
			 */
			getAgeRate : function(index){
				var ageRate;
				var age = parseInt(document.getElementById("prpCinsureds["+index+"].age").value);
				if(age<25 || age>=60){
					ageRate = 105;
				}else if((age>=25 && age<30) || (age>=40 && age<60)){
					ageRate = 100;
				}else if(age>=30&&age<40){
					ageRate = 95;
				}
				return ageRate;
			},
			/**
			 * @author sinosoft
			 * @description 获取驾龄Rate
			 * @param index 第几个
			 * @return DrivingYearsRate
			 */
			getDrivingYearsRate : function(index){
				var DrivingYearsRate;
				drivingYears = parseInt(document.getElementById("prpCinsureds["+index+"].drivingYears").value);
				if(drivingYears < 1){
					DrivingYearsRate = 105;
				}else if(drivingYears>=1 && drivingYears<3){
					DrivingYearsRate =102
				}else if(drivingYears >= 3){
					DrivingYearsRate = 100;
				}
				return DrivingYearsRate;
			},
			/**
			 * @author sinosoft
			 * @description 改变关系人名称，清空客户代码、地址
			 * @return
			 */
			checkInsuredName : function(){
				document.getElementById("_insuredCode").value = "";
				document.getElementById("_insuredAddress").value = "";
			},
			/**
			 * @author sinosoft
			 * @description 改变关系人证件号码，清空客户代码
			 * @return
			 */
			changeIdentifyNumber : function(){
				document.getElementById("_insuredCode").value = "";
				//隐藏域赋值
				if(document.getElementById("_identifyNumber1") != null){
					document.getElementById("_identifyNumber1").value = document.getElementById("_identifyNumber").value;
				}
			},
	
			/**
			 * @author LanNing联合销售
			 * @description 修改页面上的关系人信息要提示修改意外险信息
			 *<p>
			 *<font color=red>规则 : R638,R1030</font>
			 *</p>
			 * @return
			 */
			changeEad : function(){
				// R638
				if(document.getElementById("riskCode").value == "DAA"){
					if(document.getElementById("insuredChangeFlag")!=null 
						&& document.getElementById("insuredChangeFlag").value=="1"){
						alert("关系人信息已改变，请修改意外险信息");
						// R1030
						document.getElementById("refreshEadFlag").value = 1;//refreshEadFlag为1，需要刷新意外险
					}
					//意外险移到联合销售需重新校验
					var unitedSaleRelatioStr =document.getElementById("unitedSaleRelatioStr").value;
					if(unitedSaleRelatioStr.indexOf("EAD")>-1){
						alert("关系人信息已改变，请修改意外险信息");
					}
				}
			},
			/**
			 * @author sinosoft
			 * @description 
			 * @return
			 */
			ownerBeChanged : function(){
				// 获取列表中共有几个被保险人
				var topIndex = parseInt(globalindex['insertInsuredRow']);
				var insuredELName = "";
				var riskCodeValue = "";
				var insuredNameIsOwner ="";
				var j;
				var riskCode = document.getElementById("riskCode");
				if(riskCode != null && riskCode.value != ""){
					riskCodeValue = riskCode.value ;
				}
				var arr = [];
				var isGuoHu = false;
				var ageChange = true;
				var updateIndex = document.getElementById("updateIndex").value;
				var age = document.getElementById("prpCinsureds_[0].age");
				var insuredCode = document.getElementById("prpCinsureds_[0].insuredCode");
				var identifyNumber = document.getElementById("prpCinsureds_[0].identifyNumber");
				if((age.value != age.title) && (identifyNumber.value == identifyNumber.title) && (insuredCode.value == insuredCode.title)){
				    ageChange = false;
				}
				for ( var i = 0; i < topIndex; i++) {
					insuredELName = "prpCinsureds["+i+"].insuredFlag";
					var insuredFlagEl = document.getElementById(insuredELName);
					var flag = document.getElementById("prpCinsureds["+i+"].flag");
					if(insuredFlagEl == null)continue;
					if(Insured.isOwner(insuredFlagEl.value)){
						var insuredName = document.getElementById("prpCinsureds["+i+"].insuredName");
						if(insuredName!= null && insuredNameIsOwner ==""){
							insuredNameIsOwner= insuredName.value;
							j=1;
						}else{
						    j= j+1;
						}
						arr.push(i);
						if(insuredNameIsOwner !=insuredName.value && flag != null && i == topIndex - 1 && 
								(flag.value == "" || (flag.value.length > 0 && flag.value.substring(0,1) != "B" && flag.value.substring(0,1) != "D"))){
							isGuoHu = true;
						}else if(j==1 && insuredNameIsOwner ==insuredName.value && flag!=null && flag.value != null && flag.value != "" && (flag.value.substring(0,1) == "I" || flag.value.substring(0,1) == "U") && ageChange){
							isGuoHu = true;
						}else if(j > 1 && insuredNameIsOwner == insuredName.value){
							isGuoHu = false;
						}
					}
				}
				if(arr.length <= 0)return;
				if(arr.length > 0 && isGuoHu && document.getElementById("bizType").value == "ENDORSE" && riskCodeValue != "DAN"){
					if(confirm("是否属于过户车辆？")){
			                      //add by nongjinmei  2011-09-19 如果属于车辆过户，深圳平台需要传值：过户标志、过户时间   start 
						var comCode = document.getElementById("prpCmain.comCode").value;
						var bizType = document.getElementById("bizType");
						if(comCode.substring(0,4)=='4403') {
							var transferVehicleFlags =document.getElementsByName("prpCitemCar.transferVehicleFlag");
							for(var i=0;transferVehicleFlags!=undefined&&i<transferVehicleFlags.length;i++){
								if(transferVehicleFlags[i].value!=null&&transferVehicleFlags[i].value=="1"){
									transferVehicleFlags[i].checked= true;
								}else{
									transferVehicleFlags[i].disabled= true;
								}
							}
							document.getElementById('prpCitemCar.transferDate.label').style.display='block';
							document.getElementById('prpCitemCar.transferDate.label2').style.display='block';
						}
			                        //add by nongjinmei  2011-09-19 如果属于车辆过户，深圳平台需要传值：过户标志、过户时间   end
						if(document.getElementById("prpCitemCar.transferVehicleFlag") != null) {
							if(document.getElementsByName("prpCitemCar.transferVehicleFlag")[1].checked){
								el_tableView.set('activeTab',el_tableView.get('tabs')[0]);
							}else if(document.getElementsByName("prpCitemCar.transferVehicleFlag")[0].checked ){
								el_tableView.set('activeTab',el_tableView.get('tabs')[0]);
								document.getElementById('prpCitemCar.transferDate').value = "";
								document.getElementById('prpCitemCar.transferDate').readOnly = false;
								document.getElementById('prpCitemCar.transferDate').focus();
							}
						}
							
					}
				}
			},
			/**
			 * @author sinosoft
			 * @description 检验是否为车主
			 * @param insuredFlag 关系人标志
			 * @return 返回true:是车主;false:非车主
			 */
			isOwner : function(insuredFlag){
				try {
					if(insuredFlag.substring(2,3) == '1'){
						return true;
					}
				} catch (e) {
				}
				return false;
			},
			/**
			 * @author zhaoxj
			 * @description 检验是否为投保人
			 * @param insuredFlag 关系人标志
			 * @return 返回true:是投保人;false:非投保人
			 */
			isPolicyholder : function(insuredFlag){
				try {
					if(insuredFlag.substring(0,1) == '1'){
						return true;
					}
				} catch (e) {
				}
				return false;
			},
			/**
			 * @author zhaoxj
			 * @description 检验是否为被保险人
			 * @param insuredFlag 关系人标志
			 * @return 返回true:是被保险人;false:非被保险人
			 */
			isInsured : function(insuredFlag){
				try {
					if(insuredFlag.substring(1,2) == '1'){
						return true;
					}
				} catch (e) {
				}
				return false;
			},
			/**
			 * @author huxiaodong
			 * @description 初次领证日期的blur事件<br/>
			 *<p>
			 *1>校验初登日期,如果只输入到月，系统自动带出01 <br/> 
			 *2>校验初次领证日期不能晚于当前日期br/>
			 *</p>
			 * @param this
			 *            表单域
			 * @return
			 */
			blurAcceptLicenseDate : function(filed){
				//校验初登日期,如果只输入到月，系统自动带出01 
				ItemCar.checkEnrollDate_1(filed);
				//次领证日期不能晚于当前日期
				Insured.checkacceptLicenseDate(filed);
			},
			
			/**
			 * @author sinosoft
			 * @description 校验初次领证日期不能晚于当前日期
			 * @param filed
			 * @return false为校验失败 
			 */
			checkacceptLicenseDate : function (filed){
				var curDate = document.getElementById("Today").value;
				var acceptLicenseDate = filed.value;
				if(trim(acceptLicenseDate)!="" && compareFullDate(curDate,acceptLicenseDate)<0){
					errorMessage("初次领证日期不能晚于当前日期！");
					filed.value="";
					filed.focus();
					return false;
				}
			},
			/**
			 * 校验如果类型为团体，单位性质不能为空
			 */
			checkinsuredTypeForFG : function(){
				var unitType = document.getElementById('_unitType').value;
				var insuredType = document.getElementById('_insuredType').value;
				var insurancefee_reform = document.getElementById("insurancefee_reform").value;
				if(insurancefee_reform == "1"){
					if(insuredType =="2" && (unitType == "" || unitType == null)){
						return false;
					}
					return true;
				}
				return true;
			},
			/**
			 * @author huxiaodong
			 * @description 确定按钮的click事件<br/>
			 *<p>
			 *1>重庆车船税改造，根据关系人类型修改车船税页面的纳税人编码<br/> 
			 *2>增加关系人方法<br/>
			 *3>辅助核保的处理<br/>
			 *4>清除手续费<br/>
			 *</p>
			 * @param this
			 *            表单域
			 * @return
			 */
			clickSaveButton : function(pageCode, field, idx){
				var riskCode = document.getElementById('riskCode').value;
				var comCode=document.getElementById('comCode').value;
				var bizType = document.getElementById('bizType').value;
				var drivingLicenseNo = document.getElementById('_drivingLicenseNo');
				var insuredType = document.getElementById('_insuredType');
				var insuredFlag = document.getElementsByName("_insuredFlag");
				var mobile = document.getElementById('_mobile');
				var email = document.getElementById('_email');
				var useNatureCode = document.getElementById("prpCitemCar.useNatureCode").value;
				if(bizType == "ENDORSE" && Insured.checkInitEngage(field,"InsuredAdd")){
					var tabs = el_tableView.get('tabs');
					var tabLength = tabs.length;
					for(var i=0;i<tabLength;i++){
						if (tabs[i].get('id') == "engageTab" && !(document.getElementById("iniPrpCengage_Flag") != null
								&& document.getElementById("iniPrpCengage_Flag").value == "1")) {
							el_tableView.set('activeTab', tabs[i]);
							return false;
						}
					}
				}
				//北分电子保单：关系人校验(先注释)
//				if(riskCode == "DAA" && comCode.substring(0,2)=="11" ){
//					//北分电子保单个性：关系人类型为个人时 校验 手机、邮箱 必录
//					if(insuredFlag[0].checked && document.getElementsByName("prpCmainCommon.netsales")[0].checked && insuredType.value==1 ){
//						if(mobile.value=="" || mobile.value==null || email.value=="" || email.value==null){
//							alert("当选择电子保单时，请录入投保人的手机、邮箱！");
//							return false;
//						}
//					}
//					//北分电子保单个性：关系人类型为团体时 校验角色类型必须有联系人类型 且 手机、邮箱 必录
//					  var insuredFlag = document.getElementsByName("_insuredFlag");
//					  if(insuredFlag[6].checked && document.getElementsByName("prpCmainCommon.netsales")[0].checked && insuredType.value==2){
//							  errorMessage("当选择电子保单时，若为联系人信息，关系人类型不能为团体！");
//							  return false;
//					  }
//					  if( insuredFlag[6].checked && document.getElementsByName("prpCmainCommon.netsales")[0].checked && insuredType.value==1){
//						  if(mobile.value=="" || mobile.value==null || email.value=="" || email.value==null){
//								alert("当选择电子保单时，请录入联系人的手机、邮箱！");
//								return false;
//							}
//					  }
//				}
				//军人保险校验
				if(riskCode == "DAV"){
					if(insuredFlag[2].checked || insuredFlag[8].checked){
						var _soldierIdentifyNumber = document.getElementById('_soldierIdentifyNumber');
						if(_soldierIdentifyNumber.value=="" || _soldierIdentifyNumber.value==null){
							var _soldierRelations = document.getElementById('_soldierRelations');
							if((insuredFlag[2].checked && _soldierRelations.value == 0) || insuredFlag[8].checked){
								alert("请录入军人证件号码");
								return false;
							}
						}
					}
				}
				//平台交管-增加车主后清空交强险信息
//				var pm_vehicle_switch = document.getElementById("pm_vehicle_switch").value;
//				if(bizType == "ENDORSE" && pm_vehicle_switch == "1" && insuredFlag[2].checked){
//					ItemKind.clearSumPremiumCI();
//				}
				
				//校验驾驶证号码
				if(insuredType!=null && insuredType.value==1 && insuredFlag[3].checked == true &&!Insured.checkDrivingLicenseNo(drivingLicenseNo)){
					return false;
				}
				//重庆车船税改造，根据关系人类型修改车船税页面的纳税人编码
				CarShipTax.setTaxPayerNo();
				//如果关系人类型为团体，单位性质不能为空
				if(!Insured.checkinsuredTypeForFG()){
					alert("关系人类型为团体时，单位性质不允许为空！");
					return false;
				}
				if(bizType!="ENDORSE"){
					Insured.onchangeIsNetProp();
				}
				//如果关系人类型为个人，车主证件类型为身份证，证件号码必录
				if(document.getElementById("_insuredType").value=="1" && document.getElementById("_identifyType").value=="01" && comCode.substring(0,2)=="31"){
				var insuredFlags = document.getElementsByName("_insuredFlag");
					if(insuredFlags[2].checked){
						if(document.getElementById("_identifyNumber") == null || document.getElementById("_identifyNumber").value==null 
								|| document.getElementById("_identifyNumber").value==""){
							alert("车主证件类型为身份证，证件号码必录");
							return false;
						}
					}
				}
				if(comCode.substring(0,2) =="31" && useNatureCode =='211'){
					var insuredFlags = document.getElementsByName("_insuredFlag");
					if(insuredFlags[0].checked){
						if(mobile.value ==""){
							errorMessage("当使用性质为家庭自用车时，投保人、被保险人、车主的移动电话不允许为空");
							return false;
						}
					}
					if(insuredFlags[1].checked){
						if(mobile.value ==""){
							errorMessage("当使用性质为家庭自用车时，投保人、被保险人、车主的移动电话不允许为空");
							return false;
						}
					}
					if(insuredFlags[2].checked){
						if(mobile.value ==""){
							errorMessage("当使用性质为家庭自用车时，投保人、被保险人、车主的移动电话不允许为空");
							return false;
						}
					}
				}
				if(!this.checkInsuredKind()){
					return false;
				}
				if(insuredFlag[2].checked && insuredType.value == '2' && ItemKind.kindIsExists('051027')){
					errorMessage("当条款类型为F42、且车主为个人时，才允许选择机动车损失保险(IACJQL0001)");
					return false;
				}
				//增加关系人方法
				Insured.insured_Add(pageCode,field,idx);
				//辅助核保的处理
				if("DAA,DAZ,DAT,DAG".indexOf(document.getElementById("riskCode").value) > -1){
					AnciInfo.clearRswitch();
				}
				//清除手续费
				MainTotal.changeCommissionSwith();
			},
			/**
			 * @author sinosoft
			 * @description 检验页面是否加载
			 * @return true:加载成功;false:加载失败
			 */
			checkTabView : function (){
				if(el_tableView != null){
					var tabs = el_tableView.get('tabs');
					var bizType = document.getElementById('bizType').value;
					var tabLength = tabs.length;
					for(var i=0;i<tabLength;i++){
						if (tabs[i].get('id') == "insuredTab" && !tabs[i].get('dataLoaded')) {
							if(!document.getElementById("editType").value == "ENDOR_UPDATE"){
								alert("请先加载关系人页面！");
							}
							el_tableView.set('activeTab', tabs[i]);
							return false;
						}
						if (tabs[i].get('id') == "kindTab" && !tabs[i].get('dataLoaded')) {
							if(!document.getElementById("editType").value == "ENDOR_UPDATE"){
								alert("请先加载保险责任页面！");
							}
							el_tableView.set('activeTab', tabs[i]);
							return false;
						}
						if(bizType == "ENDORSE"){
							if(tabs[i].get('id') == "engageTab" && !(document.getElementById("iniPrpCengage_Flag") != null
									&& document.getElementById("iniPrpCengage_Flag").value == "1")){
								if(document.getElementById("editType").value != "ENDOR_UPDATE"){
									alert("请先加载特别约定页面！");
								}
								el_tableView.set('activeTab', tabs[i]);
								return false;
							}
						}
					}
					return true;
				}else{
					return true;
				}
			},
			/**
			 * @author huxiaodong
			 * @description 删除按钮的click事件<br/>
			 *<p>
			 *1>删除关系人操作<br/> 
			 *2>校验优惠合法性<br/>
			 *</p>
			 * @param filed 表单域
			 * @param obj 删除的域
			 * @return
			 */
			clickDelete : function(filed,obj){
				//删除关系人操作
				Insured.deleteOneRow(filed,obj);
				//校验优惠合法性
				ItemCar.doCheckProfits();
			},
			/**
			 * @author sinosoft
			 * @description 天津委托人校验
			 * @return true
			 */
			beforeCalCheckTJDAG : function(){
				var riskCode = document.getElementById("riskCode").value;
				var maxIdx = parseInt(document.getElementById("idx").value);
				if(riskCode=="DAG"){
					if(isNaN(maxIdx)){
						maxIdx = 0;
					}
					for(i = 0; i <= maxIdx; i++){
						try{
							//委托人勾选时校验
							if(document.getElementById("prpCinsureds["+ i +"].insuredFlag").value != null && 
									document.getElementById("prpCinsureds["+ i +"].insuredFlag").value.length>7 && 
									document.getElementById("prpCinsureds["+ i +"].insuredFlag").value.substring(7,8) == "1"){
								if(document.getElementById("prpCinsureds["+ i +"].insuredName").value == null || 
										document.getElementById("prpCinsureds["+ i +"].insuredName").value == ""){
									alert('请录入委托人名称！');
									return false;
								}
								if(document.getElementById("prpCinsureds["+ i +"].insuredAddress").value == null || 
										document.getElementById("prpCinsureds["+ i +"].insuredAddress").value == ""){
									alert('请录入委托人地址信息！');
									return false;
								}
								if(document.getElementById("prpCinsureds["+ i +"].mobile").value == null || 
										document.getElementById("prpCinsureds["+ i +"].mobile").value == ""){
									alert('请录入委托人电话信息！');
									return false;
								}
							}
						}catch(e){
							continue;
						}
					}
					if(Insured.checkInsuredInfo()==false){
						return false ;
					}
				}
			},
			/**
			 * @author sinosoft
			 * @description 快速报价关系人
			 * @return true
			 */
			queryInsuredFlag : function (field){
			  var driverNo = 0;
			  var idx = parseInt(globalindex["insertInsuredRow"]);
			  var driverCount = 0;
			  if(isNaN(idx)){
				  idx = 1;
			  }
			  idx = parseInt(document.getElementById("idx").value);
			  //判断关系人角色是否为空
			  var insuredFlag = document.getElementsByName("_insuredFlag");
			  var checkFlag = "0";
			  var insuredFlag_length=insuredFlag.length;
			  for(var i=0;i<insuredFlag_length;i++){
				     if(insuredFlag[i].checked){
				        checkFlag = "1";
				     }
				  }
			  if(checkFlag == "0"){
				  errorMessage("请选择一个关系人角色！");
				  return false;
			  }
			  
			  var insuredFlagDescription = '';
			  var insuredFlag1 = '';
			  if(insuredFlag[0] != null && insuredFlag[0].checked){
				  insuredFlagDescription += '投保人/';
				  insuredFlag1 += '1';
			  }else{
				  insuredFlag1 +='0';
			  }
			  if(insuredFlag[1] != null && insuredFlag[1].checked){
				  insuredFlagDescription += '被保险人/';
				  insuredFlag1 += '1';
			  }else{
				  insuredFlag1 +='0';
			  }
			  if(insuredFlag[2] != null && insuredFlag[2].checked){
				  insuredFlagDescription += '车主/';
				  insuredFlag1 += '1';
			  }else{
				  insuredFlag1 +='0';
			  }
			  if(insuredFlag[3] != null && insuredFlag[3].checked){
				  insuredFlagDescription += '指定驾驶人/';
				  insuredFlag1 += '1';
			  }else{
				  insuredFlag1 +='0';
			  }
			  if(insuredFlag[4] != null && insuredFlag[4].checked){
				  insuredFlagDescription += '受益人/';
				  insuredFlag1 += '1';
			  }else{
				  insuredFlag1 +='0';
			  }
			  if(insuredFlag[5] != null && insuredFlag[5].checked){
				  insuredFlagDescription += '港澳车车主/';
				  insuredFlag1 += '1';
			  }else{
				  insuredFlag1 +='0';
			  }
			  if(insuredFlag[6] != null && insuredFlag[6].checked){
				  insuredFlagDescription += '联系人/';
				  insuredFlag1 += '1';
			  }else{
				  insuredFlag1 +='0';
			  }
			  if(insuredFlag[7] != null && insuredFlag[7].checked){
				  insuredFlagDescription += '委托人/';
				  insuredFlag1 += '1';
			  }else{
				  insuredFlag1 +='0';
			  }

			  insuredFlagDescription = insuredFlagDescription.substring(0, insuredFlagDescription.length -1);

			  //判断投保人/被保险人/车主是否重复
			  for(var j=0;j<idx;j++){
				  if(document.getElementById("prpCinsureds["+ j +"].insuredName") != null && 
							document.getElementById("prpCinsureds["+ j +"].insuredName") != ""){
					  if(isNaN(document.getElementById("prpCinsureds["+j+"].insuredFlag"))&&document.getElementById("prpCinsureds["+j+"].insuredFlag")!=null){
						  if(((insuredFlag1.substring(0,2)).indexOf("1")>-1)&&
								  ((document.getElementById("prpCinsureds["+j+"].insuredFlag").value.substring(0,2)).indexOf("1")>-1)
									){
							  if(((insuredFlag1.substring(0,2)=="01"&&document.getElementById("prpCinsureds["+j+"].insuredFlag").value.substring(0,2)=="10"))||
									  ((insuredFlag1.substring(0,2)=="10"&&document.getElementById("prpCinsureds["+j+"].insuredFlag").value.substring(0,2)=="01"))){
							  }else{
								  errorMessage("请不要重复录入投保人/被保险人");
								  return false;
							  }
						  }
						  if(((insuredFlag1.substring(2,3)).indexOf("1")>-1)&&
								  ((document.getElementById("prpCinsureds["+j+"].insuredFlag").value.substring(2,3)).indexOf("1")>-1)
									){
							  if(((insuredFlag1.substring(2,3)=="0"&&document.getElementById("prpCinsureds["+j+"].insuredFlag").value.substring(2,3)=="1"))||
									  ((insuredFlag1.substring(2,3)=="1"&&document.getElementById("prpCinsureds["+j+"].insuredFlag").value.substring(2,3)=="0"))){
							  }else{
								  errorMessage("请不要重复录入车主.");
								  return false;	           
							  }	         	
						  }
						  if(document.getElementById("prpCinsureds["+j+"].insuredFlag").value.substring(3,4)=="1"){
			          	      driverNo++;
			     		  }
					  }
				  }
			  }
			  if(isGuangdong()){
				  if(guangZhouFlag){
					  if(driverNo>=1 && insuredFlag1.substring(3,4)=="1"){
					      errorMessage("广州地区只可录入一名指定驾驶员！");
					      return false;
	  				  }
				  }
			  }else if(driverNo>=3 && insuredFlag1.substring(3,4)=="1"){
			      errorMessage("最多只允许录入三个指定驾驶人！");
			      return false;
				  }
			  Insured.insured4S_Add('insertInsuredRow',field,'hidden_index_insured',idx,insuredFlagDescription,insuredFlag1);
			},
			/**
			 * @author sinosoft
			 * @description 添加关系人行
			 * @return true
			 */
			insured4S_Add:function(pageCode, field, idx, indexMax, insuredFlagDescription, insuredFlag1) {
			    var index = indexMax;
				insertRowForStruts2(pageCode, field, index);
				  //返回flag到界面
				  var insuredFlagDes = document.getElementById("prpCinsureds["+ indexMax +"].insuredFlagDes");
				  var insuredFlag0 = document.getElementById("prpCinsureds["+ indexMax +"].insuredFlag");
				  insuredFlagDes.value = insuredFlagDescription;
				  insuredFlag0.value = insuredFlag1;
				  
				if(insuredFlag0.value.substring(3,4) == "1"){
					document.getElementById("drivingLicenseNo["+ indexMax +"]").style.display = "";
				}
				//全局变量
				document.getElementById("idx").value = parseInt(document.getElementById("idx").value) + 1;
			},
			/**
			 * @author sinosoft
			 * @description 编辑关系人
			 * @return true
			 */
			editCustomer4S : function(obj, index)
			{
				if(index == undefined || index == null || index < 0){
					var tr = getTR(obj);
					var eleName = tr.cells[0].all[0].name;
					var index=eleName.substring(eleName.indexOf("[")+1,eleName.indexOf("]"));
				}
				Insured.updateIndex = index;
				var insuredType = document.getElementById("prpCinsureds[" + index + "].insuredType").value;
				var customerURL = document.getElementById("customerURL").value;
				var insuredCode = document.getElementById("prpCinsureds[" + index + "].insuredCode").value;
				if(insuredCode=="")
				{
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
			},	
			/**
			 * @author sinosoft
			 * @description 删除关系人
			 * @return true
			 */
			deleteOneRowCQP:function(obj,field){
				var tr = getTR(obj);
				var eleName = tr.cells[0].all[0].name;
				var index=eleName.substring(eleName.indexOf("[")+1,eleName.indexOf("]"));
				//获取角色串
				var insuredFlag = document.getElementById(eleName.substring(0,eleName.indexOf("[")+1)+index+"].insuredFlag").value;
				if(document.getElementById("updateIndex").value == index){
					if(!confirm("此条记录正在修改，确定要删除吗？")){
						return false;
					}
					document.getElementById("updateIndex").value = "-1";
				}else{
				   if(silenceMode == false && !confirm("确定要删除此条记录吗？")){
			   		return false;
				   }
				}
				//点击删除关系人信息，保费应不受影响
				//MainHead.clearSumPremiumCI_quickNew();
				deleteRow(obj,field);
			},
			/**
			 * @author sinosoft
			 * @description 自保业务，投保人变更时清空保费
			 * @return true
			 */
			clearQuickCommission:function(idx){
				// 获取修改前投保人客户编码
				var insuredCodeOld = document.getElementById("insuredCodeOld").value;
				// 判断修改前后投保人客户编码是否相等
				var _insuredFlag = document.getElementById("prpCinsureds["+ idx +"].insuredFlag").value;
				var _insuredCode = document.getElementById("prpCinsureds["+ idx +"].insuredCode").value;
				if(_insuredFlag!=null && _insuredFlag.substring(0,1) == '1'){
					if(_insuredCode != insuredCodeOld){
						// 更新隐藏的投保人客户编码
						document.getElementById("insuredCodeOld").value = _insuredCode;	
						// 清空保费
						MainHead.clearSumPremiumBI_quickNew();
						MainHead.clearSumPremiumCI_quickNew();
					}
				}
			},
			/**
			 * @author sinosoft
			 * @description 驾驶证号赋值
			 * @return true
			 */
			writeDivLicenseNo4S:function(idx){
				var identifyNumber = document.getElementById("prpCinsureds["+ idx +"].identifyNumber").value;
				if(document.getElementById("prpCinsureds["+ idx +"].identifyType").value=="01" && isNaN(document.getElementById("prpCinsureds["+ idx +"].drivingLicenseNo"))){
					document.getElementById("prpCinsureds["+ idx +"].drivingLicenseNo").value = identifyNumber;
					if(document.getElementById("drivingLicenseNos["+ idx +"]") != null){
						document.getElementById("drivingLicenseNos["+ idx +"]").value = identifyNumber;
					}
				}else if(isNaN(document.getElementById("prpCinsureds["+ idx +"].drivingLicenseNo"))){
					document.getElementById("prpCinsureds["+ idx +"].drivingLicenseNo").value = "";
					if(document.getElementById("drivingLicenseNos["+ idx +"]") != null){
						document.getElementById("drivingLicenseNos["+ idx +"]").value = "";
					}
				}
			},
			/**
			 * @author sinosoft
			 * @description 根据身份证日期生成年龄
			 * @return true
			 */
			getAge4S:function(dtmBirth,idx){
			   var birthYear = dtmBirth.getFullYear();
			   var date = new Date();
			   var age = date.getYear() - birthYear;
			   document.getElementById("prpCinsureds["+ idx +"].age").value = age;
			   document.getElementById("prpCinsureds["+ idx +"].age").readOnly = true;
			},
			/**
			 * @description 检验组织机构代码/个人身份证号码长度
			 * @param field输入域
			 * @return 校验通过 true,校验失败 false
			 */
			checkIdentifyNumberID4S:function (field)
			{
				var eleName = field.name;
				var idx=eleName.substring(eleName.indexOf("[")+1,eleName.indexOf("]"));
				if(isNaN(idx)){
					idx = 0;
				}
				// 证件类型只有是身份证的时候才校验
				var IDCARD_SHIELD = document.getElementById("IDCARD_SHIELD");
				if(document.getElementById("prpCinsureds["+ idx +"].insuredType").value=="1"&&document.getElementById("prpCinsureds["+ idx +"].identifyType").value=="01")
				{
                   if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1"
    				   && field == document.getElementById("identifyNumber["+ idx +"]") && document.getElementById("identifyNumber["+ idx +"]").readOnly){
                   }else{
    				   if(field.value==""){
    				       document.getElementById("prpCinsureds["+ idx +"].age").value = "";
    					   document.getElementById("prpCinsureds["+ idx +"].drivingLicenseNo").value = "";
    					   return false;
    				   }
    				   if(!Insured.isChinaIDCard(field.value, idx)){// 用客户管理系统的身份证校验
    				       document.getElementById("prpCinsureds["+ idx +"].age").value = "";
    					   field.select();
    					   return false;
    				   }else{
    					   Insured.writeDivLicenseNo4S(idx);
    				   }
                   }
				}else if (document.getElementById("prpCinsureds["+ idx +"].insuredType").value=="1"&&document.getElementById("prpCinsureds["+ idx +"].identifyType").value=="16"){
					//身份证
					 if(field.value==""){
						 document.getElementById("prpCinsureds["+ idx +"].age").value = "";
					     document.getElementById("prpCinsureds["+ idx +"].drivingLicenseNo").value = "";
						 return false;
					  }
					  if(trim(field.value).length!=15){
						    alert("输入的外国人永久居留身份证号码必须为15位！");
						    field.value="";
						    field.focus();
							return false;
					  }
					
				}else if(document.getElementById("prpCinsureds["+ idx +"].insuredType").value=="1"){
					Insured.writeDrivingLicenseNo4S(field,idx);
				}else if(document.getElementById("prpCinsureds["+ idx +"].insuredType").value=="2"){	    
					if(field.value!=""&&field.readOnly==false&&!Insured.isValidEntpCode(field.value)){
				   	  	 field.select();
				   	  	 return false;
					}
					
				}
			    return true;
			},
			 /**
			 * @author sinosoft
			 * @description 改变身份证号码
			 * @return
			 */
			changeIdentifyNumberForCqp : function(field){
				var eleName = field.name;
				var idx=eleName.substring(eleName.indexOf("[")+1,eleName.indexOf("]"));
				if(isNaN(idx)){
					idx = 0;
				}
				document.getElementById("prpCinsureds["+ idx +"].identifyNumber").value = document.getElementById("identifyNumber["+ idx +"]").value;
			},
			/**
			 * @author sinosoft
			 * @description 拉框只读放开，需要外层有span标签
			 * @return true
			 */
			selectNoReadOnly:function(selectedId){
				var obj = document.getElementById(selectedId);
			    obj.onmouseover = function(){
			    	obj.releaseCapture();
			    }
			},
			/**
			 * @author sinosoft
			 * @description 设置下拉框只读，需要外层有span标签
			 * @return true
			 */
			selectReadOnly:function(selectedId){
				var obj = document.getElementById(selectedId);
				obj.onmouseover = function(){
					obj.setCapture();
			    }
			    obj.onmouseout = function(){
					obj.releaseCapture();
			    }
			    obj.onfocus = function(){
			    	obj.blur();
			    }
			    obj.onbeforeactivate = function(){
			    	return false;
			    }
			},
			/**
			 * @author sinosoft
			 * @description 关系人查询返回值赋值
			 * @return true
			 */
			insuredValue4S:function(filed,idx)
			{
				document.getElementById("save2").focus();
				var _insuredType = document.getElementById("prpCinsureds["+ idx +"].insuredType").value;
				// 判断是否要置主要字段为只读。
				var readOnlyFlag = Insured.getAuditStatus(filed.data[0].auditStatus);
				if(readOnlyFlag=="1" && document.getElementById("insuredTypeReadOnlySpan["+ idx +"]") != null){
					Insured.selectReadOnly("insuredTypeReadOnlySpan["+ idx +"]");
				}
				if(_insuredType == "1"){
			        document.getElementById("prpCinsureds["+ idx +"].insuredCode").value=filed.data[0].insuredCode;
			        if(readOnlyFlag=="1")
			        {
						document.getElementById("prpCinsureds["+ idx +"].insuredCode").readOnly = true;
			       	}
			        document.getElementById("prpCinsureds["+ idx +"].insuredName").value=filed.data[0].insuredName;// 名称
			        if(readOnlyFlag=="1")
			        {
			        	document.getElementById("prpCinsureds["+ idx +"].insuredName").readOnly = true;
			        }
			        if(filed.data[0].identifyType  != null)
			        {
			        	document.getElementById("prpCinsureds["+ idx +"].identifyType").value = filed.data[0].identifyType;// 证件类型
			        	if(readOnlyFlag=="1")
			        	{
			        		Insured.selectReadOnly("identifyTypeShow["+ idx +"]");
			        	}
			        }
			        if(filed.data[0].countryCode  != null)
			        {
			        	document.getElementById("prpCinsureds["+ idx +"].countryCode").value = filed.data[0].countryCode;// 国籍
			        }
			        if(filed.data[0].resident  != null)
			        {
			        	document.getElementById("resident["+idx+"]").value= filed.data[0].resident;// 居民与非居民
			        }
			        if(filed.data[0].unitType != null)
			        {
			        	document.getElementById("prpCinsureds["+ idx +"].unitType").value = filed.data[0].unitType;// 单位性质
			        }else if(document.getElementById("prpCinsureds["+ idx +"].unitType") !=null && document.getElementById("prpCinsureds["+ idx +"].unitType") != undefined){
			        	document.getElementById("prpCinsureds["+ idx +"].unitType").options.add(new Option("",""));
			        	document.getElementById("prpCinsureds["+ idx +"].unitType").value = "";
			        }
			        if(filed.data[0].identifyNumber  != null)
			        {
			        	var IDCARD_SHIELD = document.getElementById("IDCARD_SHIELD");
			        	if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1" && filed.data[0].identifyType =="01"){
				       		var identifyNumbers = filed.data[0].identifyNumber;
				       		var identifyNumberLSJ = filed.data[0].identifyNumberLSJ;
				       		if(identifyNumbers!=""){
			       				document.getElementById("prpCinsureds["+ idx +"].identifyNumber").value= identifyNumbers;
				       			document.getElementById("prpCinsureds["+ idx +"].identifyNumber").value = identifyNumbers;
				       			if(document.getElementById("identifyNumber["+ idx +"]") != null){
					       			document.getElementById("identifyNumber["+ idx +"]").value = identifyNumberLSJ.substr(0, 10) + "******" + identifyNumberLSJ.substr(16, 2);
					       			document.getElementById("identifyNumber["+ idx +"]").readOnly = true;
				       			}
				       		}else{
				       			document.getElementById("prpCinsureds["+ idx +"].identifyNumber").value = identifyNumbers;// 证件号码
				       			if(document.getElementById("identifyNumber["+idx+"]") != null){
						   			document.getElementById("identifyNumber["+idx+"]").value = identifyNumberLSJ;
				       			}
				   			}
				       		if(identifyNumbers != "" && document.getElementById("prpCinsureds["+ idx +"].drivingLicenseNo") != null){
				       			document.getElementById("prpCinsureds["+ idx +"].drivingLicenseNo").value = identifyNumbers
				       		}
				       		if(document.getElementById("drivingLicenseNos["+ idx +"]") != null){
					       		document.getElementById("drivingLicenseNos["+ idx +"]").value = identifyNumberLSJ.substr(0, 10) + "******" + identifyNumberLSJ.substr(16, 2);
				       		}
			        	}else{
				        	document.getElementById("prpCinsureds["+ idx +"].identifyNumber").value = filed.data[0].identifyNumber.trim();// 证件号码
				        	if(document.getElementById("identifyNumber["+idx+"]") !=null){
				        		document.getElementById("identifyNumber["+idx+"]").value = filed.data[0].identifyNumber.trim();// 证件号码
				        	}
			        	}
			        	if(readOnlyFlag=="1")
			        	{
			        		document.getElementById("prpCinsureds["+ idx +"].identifyNumber").readOnly = true;
			        	}
			        }
			        if(filed.data[0].sex != null && filed.data[0].sex!="")
			        {
			        	document.getElementById("prpCinsureds["+ idx +"].sex").value = filed.data[0].sex;// 性别
			        	if(readOnlyFlag=="1")
			        	{
			        		Insured.selectReadOnly("sexReadOnlySpan["+ idx +"]");
			        	}
			        }
			        if(filed.data[0].age != null && filed.data[0].age != ""){
			        	document.getElementById("prpCinsureds["+ idx +"].age").value = filed.data[0].age;// 年龄
			        }else{
			        	document.getElementById("prpCinsureds["+ idx +"].age").value = "";
			        }
			        if(filed.data[0].insuredAddress  != null)
			        {
			        	document.getElementById("prpCinsureds["+ idx +"].insuredAddress").value = filed.data[0].insuredAddress;// 地址
			        	if(readOnlyFlag=="1"){
					        document.getElementById("prpCinsureds["+ idx +"].insuredAddress").readOnly = true;
					    }
			        }
			        if(filed.data[0].postCode  != null)
			        {
			        	document.getElementById("prpCinsureds["+ idx +"].postCode").value = filed.data[0].postCode;// 邮编
			        	if(readOnlyFlag=="1"){
					        document.getElementById("prpCinsureds["+ idx +"].postCode").readOnly = true;
					    }
			        }
			        var phoneType = filed.data[0].phoneType;
			       	if(filed.data[0].mobile != null)
			       	{   
			       		var mobiles = filed.data[0].mobile;
			       		var mobileNoYG = filed.data[0].mobileNoYG;
			       		if(mobiles!=""){
			       			if(Common.isCqp()){
			       				document.getElementById("prpCinsureds["+ idx +"].mobile").value= mobiles;
				       			document.getElementById("mobile["+ idx +"]").value = mobileNoYG.substring(0,3)+"****"+mobileNoYG.substring(7,mobiles.length);// 移动电话
				       			document.getElementById("prpCinsureds["+ idx +"].mobile").value = mobiles;
				       			document.getElementById("mobile["+ idx +"]").style.display = "block";
				       			document.getElementById("prpCinsureds["+ idx +"].mobile").style.display = "none";
				       			document.getElementById("mobile["+ idx +"]").readOnly = true;
			       			}else{
			       				document.getElementById("prpCinsureds["+ idx +"].mobile").value= mobiles;
			       			}
			       		}else{
			       			document.getElementById("prpCinsureds["+ idx +"].mobile").value = mobiles;// 移动电话
				   			if(Common.isCqp()){
				   				document.getElementById("mobile["+idx+"]").value = mobileNoYG;
				   			}
			   			}
			   			if(readOnlyFlag=="1"){
					        document.getElementById("prpCinsureds["+ idx +"].mobile").readOnly = true;
					    }
			   		}
			       	if(filed.data[0].phoneNumber != null) {
			   			document.getElementById("prpCinsureds["+ idx +"].phoneNumber").value = filed.data[0].phoneNumber;// 固定电话
			   			if(readOnlyFlag == "1") {
			   				document.getElementById("prpCinsureds["+ idx +"].phoneNumber").readOnly = true;
				        }
			   		}
			       	if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1" && filed.data[0].identifyType == "01"){
			       	}else{
				       	Insured.checkIdentifyNumberID4S(document.getElementById("prpCinsureds["+ idx +"].identifyNumber"),idx);
			       	}
			   		if(filed.data[0].versionNo != null)
			   		{
			   			document.getElementById("prpCinsureds["+ idx +"].versionNo").value = filed.data[0].versionNo;// 版本号码
			   		}
			   		if(filed.data[0].auditStatus != null)
			   		{
			   			var auditStatus = filed.data[0].auditStatus;// 审批状态
			   			var auditStatusDes = Insured.tranAuditStatus(auditStatus);
			   			document.getElementById("prpCinsureds["+ idx +"].auditStatus").value = auditStatus;
						document.getElementById("prpCinsureds["+ idx +"].auditStatusDes").value = auditStatusDes;
			   		}
			   		// 集团代码
			   		if(document.getElementById("prpCinsureds["+ idx +"].insuredFlag").value.substring(0,1)=="1" 
			   				&& filed.data[0].groupCode != null && document.getElementById("groupCode") != null){
			   			document.getElementById("groupCode").value = filed.data[0].groupCode;	
			   		}
			 	}else{
			 		document.getElementById("prpCinsureds["+ idx +"].insuredCode").value=filed.data[0].insuredCode;
			 		if(readOnlyFlag=="1")
			   		{
			 			document.getElementById("prpCinsureds["+ idx +"].insuredCode").readOnly = true;
			 		}
			    	document.getElementById("prpCinsureds["+ idx +"].insuredName").value=filed.data[0].insuredName;// 名称
				    if(readOnlyFlag=="1")
				    {
				        document.getElementById("prpCinsureds["+ idx +"].insuredName").readOnly = true;
				    }
				    if(filed.data[0].unitType  != null)
			 		{
			 			// 当单位性质为空时默认为企业单位;LICHENHUI;20111025(bug16057);begin;
			 			if(trim(filed.data[0].unitType)!=""){
				 			var myunitType = document.getElementById("myunitType");	 
			 				if(myunitType != null){
			                    myunitType.value = document.getElementById("prpCinsureds[0].unitType").value;
				        	    document.getElementById("prpCinsureds["+ idx +"].unitType").value = filed.data[0].unitType;// 单位性质
				        	    if(myunitType.value != filed.data[0].unitType){
				        		   document.getElementById("prpCinsureds["+ idx +"].unitType").onchange();
				        	    }
			        	    }else{
			        	    	document.getElementById("prpCinsureds["+ idx +"].unitType").value = filed.data[0].unitType;// 单位性质
			        	    }
			 			}else{
			 				document.getElementById("prpCinsureds["+ idx +"].unitType").value = "";
			 			}
			 			// 当单位性质为空时默认为企业单位;LICHENHUI;20111025(bug16057);end;
			 		}else if(document.getElementById("prpCinsureds["+ idx +"].unitType") !=null && document.getElementById("prpCinsureds["+ idx +"].unitType") != undefined){
			        	document.getElementById("prpCinsureds["+ idx +"].unitType").options.add(new Option("",""));
			        	document.getElementById("prpCinsureds["+ idx +"].unitType").value = "";
			        }
				    if(filed.data[0].countryCode  != null) {
			        	document.getElementById("prpCinsureds["+ idx +"].countryCode").value = filed.data[0].countryCode;// 国籍
			        }
			        if(filed.data[0].resident  != null) {
			        	document.getElementById("resident["+idx+"]").value = filed.data[0].resident;// 居民与非居民
			        }
			        if(filed.data[0].identifyNumber  != null)
			 		{
			 			document.getElementById("prpCinsureds["+ idx +"].identifyNumber").value = filed.data[0].identifyNumber.trim();// 证件号码
			 			if(document.getElementById("identifyNumber["+ idx +"]")!=null){
			 				document.getElementById("identifyNumber["+ idx +"]").value = filed.data[0].identifyNumber.trim();
			 			}
			 		}
			 		// LiChenhui;组织机构代码控制只读;20100930;begin;
					if(readOnlyFlag=="1")
			    	{
						document.getElementById("prpCinsureds["+ idx +"].identifyNumber").readOnly = true;
						if(document.getElementById("identifyNumber["+ idx +"]")!=null){
							document.getElementById("identifyNumber["+ idx +"]").readOnly = true;
						}
					}
	    			if(filed.data[0].unifiedSocialCreditCode != null)
			        {
			        	document.getElementById("prpCinsureds["+ idx +"].unifiedSocialCreditCode").value = filed.data[0].unifiedSocialCreditCode; //统一社会信用代码	
			        	if(readOnlyFlag=="1")
			        	{
			        		document.getElementById("prpCinsureds["+ idx +"].unifiedSocialCreditCode").readOnly = true;
			        	}
			        }
					// LiChenhui;组织机构代码控制只读;20100930;end;
			        if(filed.data[0].insuredAddress  != null)
			 		{
			 			document.getElementById("prpCinsureds["+ idx +"].insuredAddress").value = filed.data[0].insuredAddress;// 地址
			 			if(readOnlyFlag=="1"){
					        document.getElementById("prpCinsureds["+ idx +"].insuredAddress").readOnly = true;
					    }
			 		}
			        if(filed.data[0].postCode  != null)
			 		{
			 			document.getElementById("prpCinsureds["+ idx +"].postCode").value = filed.data[0].postCode;// 邮编
			 			if(readOnlyFlag=="1"){
					        document.getElementById("prpCinsureds["+ idx +"].postCode").readOnly = true;
					    }
			 		}
			        var phoneType = filed.data[0].phoneType;
			       	if(filed.data[0].mobile != null)
			       	{
			   			var mobiles = filed.data[0].mobile;
			   			var mobileNoYG =filed.data[0].mobileNoYG;
			   			if(mobiles!=""){
			       			if(Common.isCqp()){
			       				document.getElementById("prpCinsureds["+ idx +"].mobile").value= mobiles;
				       			document.getElementById("mobile["+ idx +"]").value = mobileNoYG.substring(0,3)+"****"+mobileNoYG.substring(7,mobiles.length);// 移动电话
				       			document.getElementById("prpCinsureds["+ idx +"].mobile").value = mobiles;
				       			document.getElementById("mobile["+ idx +"]").style.display = "block";
				       			document.getElementById("prpCinsureds["+ idx +"].mobile").style.display = "none";
				       			document.getElementById("mobile["+ idx +"]").readOnly = true;
			       			}else{
			       				document.getElementById("prpCinsureds["+ idx +"].mobile").value= mobiles;
			       			}
			       		}else{
			       			document.getElementById("prpCinsureds["+ idx +"].mobile").value = mobiles;// 移动电话
				   			if(Common.isCqp()){
				   				document.getElementById("mobile["+idx+"]").value = mobileNoYG;
				   			}
			   			}
			   			if(readOnlyFlag=="1"){
					        document.getElementById("prpCinsureds["+ idx +"].mobile").readOnly = true;
					    }
			   		}
			       	if(filed.data[0].phoneNumber != null) {
			   			document.getElementById("prpCinsureds["+ idx +"].phoneNumber").value = filed.data[0].phoneNumber;// 固定电话
			   			if(readOnlyFlag == "1") {
			   				document.getElementById("prpCinsureds["+ idx +"].phoneNumber").readOnly = true;
				        }
			   		}
			   		if(filed.data[0].versionNo != null)
			   		{
			   			document.getElementById("prpCinsureds["+ idx +"].versionNo").value = filed.data[0].versionNo;// 版本号码
			   		}
			   		if(filed.data[0].auditStatus != null)
			   		{
			   			var auditStatus = filed.data[0].auditStatus;// 审批状态
			   			var auditStatusDes = Insured.tranAuditStatus(auditStatus);
			   			document.getElementById("prpCinsureds["+ idx +"].auditStatus").value = auditStatus;
						document.getElementById("prpCinsureds["+ idx +"].auditStatusDes").value = auditStatusDes;
			   		}
			   		if(filed.data[0].appendPrintName != null)
			   		{
			   			document.getElementById("prpCinsureds["+ idx +"].appendPrintName").value = filed.data[0].appendPrintName;// 批改附加
			   		}
			   		// 集团代码
			   		if(document.getElementById("prpCinsureds["+ idx +"].insuredFlag").value.substring(0,1)=="1" 
			   				&& filed.data[0].groupCode != null && document.getElementById("groupCode") != null){
			   			document.getElementById("groupCode").value = filed.data[0].groupCode;	
			   		}
			 	}
				var isFinanceCustomer = document.getElementById("prpCinsureds["+ idx +"].isFinanceCustomer");
				if(isFinanceCustomer != null && isFinanceCustomer != undefined){
			        while(document.all("prpCinsureds["+ idx +"].isFinanceCustomer").options.length>0){
			        	document.all("prpCinsureds["+ idx +"].isFinanceCustomer").options.remove(0);
			        }
			        if(filed.data[0].financeFlag  == "0") {
			        	isFinanceCustomer.options.add(new Option("否","3"));
			        	isFinanceCustomer.options.add(new Option("普惠融资间接带动","2"));
			        }else{
			        	isFinanceCustomer.options.add(new Option("否","3"));
			        	isFinanceCustomer.options.add(new Option("普惠融资间接带动","2"));
			        	isFinanceCustomer.options.add(new Option("普惠融资直接带动","1"));
			        }
				}
				//校验客户系统返回信息
				Insured.checkCstReturnInfoForCqp(filed.data[0].mobileNoYG, filed.data[0].phoneNumber, filed.data[0].insuredAddress, idx);
			},
			/**
			 * @author sinosoft
			 * @description 关系人信息多于一条时重复查询
			 * @return true
			 */
			searchCustomer4S:function(url,idx)
			{
				var _insuredType = document.getElementById("prpCinsureds["+ idx +"].insuredType").value;
				var _insuredName = document.getElementById("prpCinsureds["+ idx +"].insuredName").value;
				var _identifyNumber = document.getElementById("prpCinsureds["+ idx +"].identifyNumber").value;
				var _identifyType = document.getElementById("prpCinsureds["+ idx +"].identifyType").value;
				if(_insuredType == "1"){
					var strURL = url+"?customerCName="+URLEncoding(_insuredName)+"&identifyType="+_identifyType+"&identifyNumber="+_identifyNumber+"&syscode=prpall";
					window.open(strURL, "QueryCustomList", "height=600,width=800,top=200,left=200,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0");
				
				}else if(_insuredType == "2"){
					var strURL = url+"?customerCName="+URLEncoding(_insuredName)+"&organizeCode="+_identifyNumber+"&syscode=prpall";
					window.open(strURL, "QueryCustomList", "height=600,width=800,top=200,left=200,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0");
				}
			},
			/**
			 * @description 创建客户信息
			 * @param null
			 * @return null
			 * @date 2009-09-17
			 */
			createCustomer4S:function(url,idx){
				var _insuredType = document.getElementById("prpCinsureds["+ idx +"].insuredType").value;
				var _insuredName = document.getElementById("prpCinsureds["+ idx +"].insuredName").value;
				var _identifyNumber = document.getElementById("prpCinsureds["+ idx +"].identifyNumber").value;
				var _identifyType = document.getElementById("prpCinsureds["+ idx +"].identifyType").value;
				var _unifiedSocialCreditCode = document.getElementById("prpCinsureds["+ idx +"].unifiedSocialCreditCode").value;
				if(_insuredType == "1"){
					var strURL = url+"?customerCName="+URLEncoding(_insuredName)+"&identifyType="+_identifyType+"&identifyNumber="+_identifyNumber+"&syscode=prpall";
					window.open(strURL);
				
				}else if(_insuredType == "2"){
					var strURL = url+"?customerCName="+URLEncoding(_insuredName)+"&organizeCode="+_identifyNumber+"&unifiedSocialCreditCode="+_unifiedSocialCreditCode+"&syscode=prpall";
					window.open(strURL, "QueryCustomList", "height=600,width=800,top=200,left=200,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0");
				}
			},
			/**
			 * @author sinosoft
			 * @description 团体关系人查询
			 * @return true
			 */
			queryCustomerG4S:function(value,idx) {
				var _insuredName = document.getElementById("prpCinsureds["+ idx +"].insuredName").value;
				var _identifyNumber = document.getElementById("prpCinsureds["+ idx +"].identifyNumber").value;
				var _insuredCode = document.getElementById("prpCinsureds["+ idx +"].insuredCode").value;
				var _identifyType = document.getElementById("prpCinsureds["+ idx +"].identifyType").value;
				var _unifiedSocialCreditCode = document.getElementById("prpCinsureds["+ idx +"].unifiedSocialCreditCode").value;
				var customerURL = document.getElementById("customerURL");
				var _editflag = document.getElementById("editFlag").value;
				if((_insuredName==null||_insuredName == "")&&(_identifyNumber==null||_identifyNumber == "")&&(_insuredCode==null||_insuredCode == "")&&(_unifiedSocialCreditCode==null||_unifiedSocialCreditCode == "")){
					errorMessage("请输入查询条件（名称、组织机构代码、统一社会信用代码或客户代码至少输入一项）！");
					document.getElementById("prpCinsureds["+ idx +"].insuredName").select();
					return false;
				}
				var callback = 
				{success:function (res) 
				{
					var prod = YAHOO.lang.JSON.parse(res.responseText);
					if(prod.data[0]==undefined){
						alert("查询失败，请您查看录入信息是否正确!");
					    return;
					}
					if(parseInt(prod.data[0].count)==1){
						Insured.insuredValue4S(prod,idx);
					}else if(parseInt(prod.data[0].count)>1){
						Insured.searchCustomer4S(prod.data[0].URL,idx);
					}else{
						Insured.createCustomer4S(prod.data[0].URL,idx);
				  	}
				  	// 将审批状态、代码和版本号设置为只读
				  	document.getElementById("prpCinsureds["+ idx +"].insuredCode").readOnly = true;
				  	document.getElementById("prpCinsureds["+ idx +"].auditStatus").readOnly = true;
				  	document.getElementById("prpCinsureds["+ idx +"].versionNo").readOnly = true;
				  	Insured.clearQuickCommission(idx);
				},
				failure:function (res) 
				{
				   errorMessage("服务异常！");
				   return false;
				}
				};
				var strURL = "/prpall/custom/customAmountQueryG.do?_identifyType="+_identifyType+"&_insuredName="+_insuredName+"&_identifyNumber="+_identifyNumber+"&_insuredCode="+_insuredCode+"&unifiedSocialCreditCode="+_unifiedSocialCreditCode;
				var transaction = YAHOO.util.Connect.asyncRequest('POST',strURL, callback); 
			},
			/**
			 * @author sinosoft
			 * @description 个人关系人查询
			 * @return true
			 */
			queryCustomerP4S:function(value,idx) {
				var _insuredType = document.getElementById("prpCinsureds["+ idx +"].insuredType").value;
				if(_insuredType == null || _insuredType == ""){
					_insuredType = "1";
				}
				var _editflag = document.getElementById("editFlag").value;
				var _insuredName = document.getElementById("prpCinsureds["+ idx +"].insuredName").value;
				var _identifyNumber = document.getElementById("prpCinsureds["+ idx +"].identifyNumber").value;
				var _insuredCode = document.getElementById("prpCinsureds["+ idx +"].insuredCode").value;
				var _identifyType = document.getElementById("prpCinsureds["+ idx +"].identifyType").value;
				var customerURL = document.getElementById("customerURL");
				if((_insuredName==null||_insuredName == "")&&(_identifyNumber==null||_identifyNumber == "")&&(_insuredCode==null||_insuredCode == "")){
					errorMessage("请输入查询条件（名称、证件号码或代码至少输入一项）！");
					document.getElementById("prpCinsureds["+ idx +"].insuredName").select();
					return false;
				}

				var callback = {
				/**
				 * @private
				 */
				success:function (res) 
				{
					var prod = YAHOO.lang.JSON.parse(res.responseText);
					var flag;
					if(prod.data[0]==undefined){
				    	alert("查询关系人信息失败，请您查看录入信息是否正确!");
				     	return;
					}
					if(parseInt(prod.data[0].count)==1){
						Insured.insuredValue4S(prod,idx);
					}else if(parseInt(prod.data[0].count)>1){
						Insured.searchCustomer4S(prod.data[0].URL,idx);
					}else{
						Insured.createCustomer4S(prod.data[0].URL,idx);// modified by LanNing 20100823
					}
					if(_insuredType == "1" && document.getElementById("prpCinsureds["+ idx +"].identifyType").value =="01"){
				  		var identifyNumber = document.getElementById("prpCinsureds["+ idx +"].identifyNumber");
				  		var IDCARD_SHIELD = document.getElementById("IDCARD_SHIELD");
				  		if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1"){
				  		}else{
					  		Insured.checkIdentifyNumberID4S(identifyNumber,idx);
				  		}
				  	}
					// 将审批状态、代码和版本号设置为只读
					if(flag == false){
							document.getElementById("prpCinsureds["+ idx +"].insuredCode").readOnly = false;
						}
						if(flag == undefined){
							document.getElementById("prpCinsureds["+ idx +"].auditStatus").readOnly = true;
						    document.getElementById("prpCinsureds["+ idx +"].versionNo").readOnly = true;
							document.getElementById("prpCinsureds["+ idx +"].insuredCode").readOnly = true;
						}
						// 自保业务，投保人变更时清空保费 add by wangyiming 20120808
						Insured.clearQuickCommission(idx);
					
				},
				/**
				 * @private
				 */
				failure:function (res) 
				{
				   errorMessage("登录超时，请重登陆！");
				   return false;
				}
			};
			var strURL = "/prpall/custom/customAmountQueryP.do?_identifyType="+_identifyType+"&_insuredName="+_insuredName+"&_identifyNumber="+_identifyNumber+"&_insuredCode="+_insuredCode;
			var transaction = YAHOO.util.Connect.asyncRequest('POST',strURL, callback); 
		},
		/**
		 * @author sinosoft
		 * @description 动态显示驾驶人输入域
		 * @return true
		 */
		controlInsuredDisplay:function(field){
			var eleName = field.name;
			var idx=eleName.substring(eleName.indexOf("[")+1,eleName.indexOf("]"));
			if(isNaN(idx)){
				idx = 0;
			}
			//document.getElementById("prpCinsureds["+idx+"].unifiedSocialCreditCode").value = "";// 统一社会信用代码
			if(document.getElementById("prpCinsureds["+idx+"].insuredType").value=='1'){
				document.getElementById("identifyTypeShow["+idx+"]").style.display = '' ;
				document.getElementById("unitTypeShow["+idx+"]").style.display = 'none' ;
				document.getElementById("prpCinsureds["+idx+"].identifyType").value = "01" ;
				document.getElementById("prpCinsureds["+idx+"].identifyType").disabled = false ;
				document.getElementById("prpCinsureds["+idx+"].unitType").disabled = true ;
				document.getElementById("unifiedSocialCreditCode["+idx+"]").style.display = 'none' ;  //当类型为个人隐藏统一社会信用代码
			}else if(document.getElementById("prpCinsureds["+idx+"].insuredType").value=='2'){
				var insuredFlag = document.getElementById("prpCinsureds["+idx+"].insuredFlag");
				if(insuredFlag != null && insuredFlag.value != null && insuredFlag.value.length >=4
						&& insuredFlag.value.substring(3,4) == "1"){
					alert("指定驾驶人不能为团体！");
					document.getElementById("prpCinsureds["+idx+"].insuredType").value = '1';
					return false;
				}
				document.getElementById("identifyTypeShow["+idx+"]").style.display = 'none' ;
				document.getElementById("unitTypeShow["+idx+"]").style.display = '' ;
				document.getElementById("prpCinsureds["+idx+"].identifyType").value = "31" ;
				document.getElementById("prpCinsureds["+idx+"].unitType").disabled = false ;
				document.getElementById("unifiedSocialCreditCode["+idx+"]").style.display = "" ;  //当类型为团体显示统一社会信用代码
			}
		},
		/**
		 * @author sinosoft
		 * @description 天津DAG委托人校验
		 * @return true
		 */
		checkTJDAGInsuredType:function(field){
			var riskCode = document.getElementById("riskCode").value;
			if(riskCode == 'DAG'){
				var eleName = field.name;
				var idx=eleName.substring(eleName.indexOf("[")+1,eleName.indexOf("]"));
				if(isNaN(idx)){
					idx = 0;
				}
				if(document.getElementById("prpCinsureds["+idx+"].insuredFlag").value.length>7 && 
						document.getElementById("prpCinsureds["+idx+"].insuredFlag").value.substring(7,8) == "1"){
					if(document.getElementById("prpCinsureds["+idx+"].insuredType").value=='2'){
						alert("委托人勾选时关系人类型不允许为团体！");
						document.getElementById("prpCinsureds["+idx+"].insuredType").value = '1' ;
						return false ;
					}
				}
			}
		},
		/**
		 * @author sinosoft
		 * @description 证件类型改变时，清空证件号码
		 * @return true
		 */
		clearIdentifyNumberCQP:function(field){
			var eleName = field.name;
			var idx=eleName.substring(eleName.indexOf("[")+1,eleName.indexOf("]"));
			if(isNaN(idx)){
				idx = 0;
			}
			if(field.value!="01"){
				document.getElementById("prpCinsureds["+ idx +"].age").readOnly = false;
			}
			document.getElementById("prpCinsureds["+ idx +"].identifyNumber").value = "";
		},
		/**
		 * @author sinosoft
		 * @description 查询关系人信息
		 * @return true
		 */
		queryCustomer4S:function(value){
			Insured.updateIndex = -1;
			//判断关系人角色是否为空
			var oTBODYData = document.getElementById("insertInsuredRow").tBodies.item(0);
				var rowsCount = oTBODYData.rows.length;
			if(rowsCount == "0"){
				errorMessage("请新增关系人信息！");
				return false;
			}
			var idx = parseInt(globalindex["insertInsuredRow"]) - 1;
			
			//双击查询，当前行处理
			if(value != null){			
				var _id = value.id;
				if(_id != null && _id.indexOf("button_InsuredFlagDetail_SubPage_Query")>= 0){
					idx = _id.substring(_id.indexOf("[")+1,_id.indexOf("]"));
				}
			}
			if(isNaN(idx)){
				idx = 0;
			}
			// 防止出现删除行报错
			for(var i=idx;i>=0;i--){
				try{
					document.getElementById("prpCinsureds["+ idx +"].insuredType").value;
				}catch(e){
					idx = i;
				}
			}
			// 正在查询行的序号放页面
			document.getElementById("queryRowIndex").value = idx ;
			var insuredType = document.getElementById("prpCinsureds["+ idx +"].insuredType").value;
			if(insuredType == null || insuredType == ""){
				insuredType = "1";
			}
			if(insuredType == "1"){
				Insured.queryCustomerP4S(value,idx);
			}else if(insuredType == "2"){
				Insured.queryCustomerG4S(value,idx);
			}
		},
		/**
		 * @author sinosoft
		 * @description 控制不能修改年龄
		 * @return true
		 */
		AgeMessage:function(field){
			var eleName = field.name;
			var idx=eleName.substring(eleName.indexOf("[")+1,eleName.indexOf("]"));
			if(isNaN(idx)){
				idx = 0;
			}
			if(document.getElementById("prpCinsureds["+idx+"].identifyType").value=='01'){
				errorMessage("证件类型为身份证，年龄自动生成，不允许修改！");
			}
		},
		/**
		 * @author sinosoft
		 * @description 回写驾驶证号码
		 * @return true
		 */
		writeDrivingLicenseNo4S:function(obj,idx){
			var licenseNo = obj.value;
			if(document.getElementById("prpCinsureds["+ idx +"].identifyType").value=="05" && Insured.checkDrivingLicenseNo(obj)){
				document.getElementById("prpCinsureds["+ idx +"].drivingLicenseNo").value = licenseNo;
			}
		},
		/**
		 * @description 校验年龄
		 * @param 表单域
		 * @return 通过true,不通过false
		 */
		checkAgeCQP : function (field){
			var eleName = field.name;
			var idx=eleName.substring(eleName.indexOf("[")+1,eleName.indexOf("]"));
			if(isNaN(idx)){
				idx = 0;
			}
			var ageField = document.getElementById("prpCinsureds["+idx+"].age");
			var insuredType=document.getElementById("prpCinsureds["+idx+"].insuredType");
			var age = "";
			if(ageField != null && ageField.value != null){
				age = parseInt(ageField.value);
			}
			if(insuredType.value!=""&&insuredType.value!=null&&insuredType.value==1){
				if(age<0||age>200){
					alert("年龄不应该超出0~200的范围！");
					field.select();
					field.focus();
					return false;
				}
				if(age == 0){
					alert("年龄不能为0！");
					try{
						field.select();
						field.focus();
					}catch(e){
					}
					return false;	    
				}
			}else{
				return true;
			}
		},
		/**
		 * @description 校验驾龄 forCQP
		 * @param 表单域
		 * @return 通过true,不通过false
		 */
		checkDrivindYear : function (field){
			var eleName = field.name;
			var idx=eleName.substring(eleName.indexOf("[")+1,eleName.indexOf("]"));
			if(isNaN(idx)){
				idx = 0;
			}
			var ageField = document.getElementById("prpCinsureds["+idx+"].age");
			if(ageField != null && ageField.value != null && trim(ageField.value) != ""){
				var age = parseInt(ageField.value);
			}else{
				var age = parseInt(0);
			}
			if(document.getElementById("prpCinsureds["+idx+"].insuredFlag").value.substring(3,4) == "1"){
				if(document.getElementById("prpCinsureds["+idx+"].drivingYears").value != "" && document.getElementById("prpCinsureds["+idx+"].drivingYears").value != null){
					if(document.getElementById("prpCinsureds["+idx+"].drivingYears").value > age){
						errorMessage("驾龄不能大于年龄!");
						//document.getElementById("prpCinsureds["+idx+"].drivingYears").focus();
						//document.getElementById("prpCinsureds["+idx+"].drivingYears").select();
						return false;          
					}	
				}
			}
		},
		//校验关系人地址，电话不能为空
		checkInsuredInfo : function (){
			var comCode = document.getElementById("comCode").value;
			var maxIdx = parseInt(document.getElementById("idx").value);
			if(isNaN(maxIdx)){
				maxIdx = 0;
			}
			var oTBODYData = document.getElementById("insertInsuredRow").tBodies.item(0);
			var rowsCount = oTBODYData.rows.length;
			if(rowsCount=="0"){
				alert("请补录关系人信息！");
				return false;
			}
			var check0 = false;
			var check1 = false;
			var check2 = false;
			for(i = 0; i <= maxIdx; i++){
				try{
					document.getElementById("prpCinsureds["+ i +"].insuredName").value;
				}catch(e){
					continue;
				}
				if(document.getElementById("prpCinsureds["+ i +"].insuredName").value != null && 
						document.getElementById("prpCinsureds["+ i +"].insuredName").value != ""){
						
					if(document.getElementById("prpCinsureds["+ i +"].insuredFlag").value.substring(0,1)=="1" || 
							document.getElementById("prpCinsureds["+ i +"].insuredFlag").value.substring(1,2)=="1" || 
							document.getElementById("prpCinsureds["+ i +"].insuredFlag").value.substring(3,4)=="1" || 
							document.getElementById("prpCinsureds["+ i +"].insuredFlag").value.substring(6,7)=="1"){
						//联系人勾选校验
						//仅校验投保人、被保险人和指定驾驶人的地址，其他角色无须校验
						if(document.getElementById("prpCinsureds["+ i +"].insuredFlag").value != null && 
							document.getElementById("prpCinsureds["+ i +"].insuredFlag").value.substring(0,1)=="1" || 
							document.getElementById("prpCinsureds["+ i +"].insuredFlag").value.substring(1,2)=="1" || 
							document.getElementById("prpCinsureds["+ i +"].insuredFlag").value.substring(3,4)=="1"){
							if(document.getElementById("prpCinsureds["+ i +"].insuredAddress").value == null || 
									document.getElementById("prpCinsureds["+ i +"].insuredAddress").value == ""){
								alert('请补录关系人地址信息！');
								document.getElementById("prpCinsureds["+ i +"].insuredAddress").select();
								return false;
							}
						}
						if((document.getElementById("prpCinsureds["+ i +"].mobile").value == null || 
								document.getElementById("prpCinsureds["+ i +"].mobile").value == "")&&
								(document.getElementById("prpCinsureds["+ i +"].phoneNumber").value == null ||
								document.getElementById("prpCinsureds["+ i +"].phoneNumber").value == "" )){
							alert('请补录关系人电话信息！');
							document.getElementById("prpCinsureds["+ i +"].mobile").select();
							return false;
						}
					}
					//指定驾驶人勾选时校验
					if(document.getElementById("prpCinsureds["+ i +"].insuredFlag").value != null && 
							document.getElementById("prpCinsureds["+ i +"].insuredFlag").value.substring(3,4) == "1"){
						if(document.getElementById("prpCinsureds["+ i +"].drivingLicenseNo").value == null || 
								document.getElementById("prpCinsureds["+ i +"].drivingLicenseNo").value == ""){
							alert('驾驶证号码不允许为空！');
							return false;
						}
						if(document.getElementById("prpCinsureds["+ i +"].drivingCarType").value == null || 
								document.getElementById("prpCinsureds["+ i +"].drivingCarType").value == ""){
							alert('准驾车型不允许为空！');
							return false;
						}
						if(document.getElementById("prpCinsureds["+ i +"].causetroubleTimes").value == null || 
								document.getElementById("prpCinsureds["+ i +"].causetroubleTimes").value == ""){
							alert('上年违章次数不允许为空！');
							return false;
						}
						if(document.getElementById("prpCinsureds["+ i +"].acceptLicenseDate").value == null || 
								document.getElementById("prpCinsureds["+ i +"].acceptLicenseDate").value == ""){
							alert('初次领证日期不允许为空！');
							return false;
						}
						if(document.getElementById("prpCinsureds["+ i +"].drivingYears").value == null || 
								document.getElementById("prpCinsureds["+ i +"].drivingYears").value == ""){
							alert('驾龄不允许为空！');
							return false;
						}
						var sex = document.getElementById("prpCinsureds["+ i +"].sex");
						if(sex != null && "1,2".indexOf(sex.value) < 0){
							alert('指定驾驶人性别为必录！');
							return false;
						}
						if(document.getElementById("prpCinsureds["+ i +"].identifyType").value=="05" 
							&& document.getElementById("prpCinsureds["+ i +"].drivingLicenseNo").value != document.getElementById("prpCinsureds["+ i +"].identifyNumber").value){
					  		alert("指定驾驶人的证件类型为驾驶执照时，证件号码必须与驾驶证号码一致！");
					  		document.getElementById("prpCinsureds["+ i +"].drivingLicenseNo").value = document.getElementById("prpCinsureds["+ i +"].identifyNumber").value;
					  		return false;
					  	}
					}
					if(document.getElementById("prpCinsureds["+ i +"].insuredFlag").value != null){
						if((document.getElementById("prpCinsureds["+ i +"].insuredFlag").value.substring(0,1) == "1") 
							|| (document.getElementById("prpCinsureds["+ i +"].insuredFlag").value.substring(1,2) == "1")
							|| (comCode.substring(0,2) == "32" ? (document.getElementById("prpCinsureds["+ i +"].insuredFlag").value.substring(2,3) == "1") : false)){
							//投保人或者被保险人勾选时需要客户系统交互
							if(document.getElementById("prpCinsureds["+ i +"].insuredCode") != null
								&& document.getElementById("prpCinsureds["+ i +"].insuredCode").value != null
								&& trim(document.getElementById("prpCinsureds["+ i +"].insuredCode").value) != ""){
								if(document.getElementById("prpCinsureds["+ i +"].auditStatus").value=='0' || 
									document.getElementById("prpCinsureds["+ i +"].auditStatus").value=='1' || 
									document.getElementById("prpCinsureds["+ i +"].auditStatus").value=='3'){
									errorMessage("投保人/被保险人不允许为未经过审批的客户！");
									return false;
								}
							}else{
								errorMessage("关系人必从客户系统带入，请点查询按钮进行查询！");
								return false;
							}
						}
					}
					if(Common.isCqp()){//zy
						//投保人被勾选时、校验国籍不能为空、将居民与非居民附到insuredFlag的第30位
						var strInsuredFlag = document.getElementById("prpCinsureds["+ i +"].insuredFlag").value;
						var resident = document.getElementById("resident["+i+"]");
						//校验是否存在投保人、被保险人、车主
						if(document.getElementById("prpCinsureds["+ i +"].insuredFlag").value.substring(0,1)=="1"){
							check0 = true;
					    }
						if(document.getElementById("prpCinsureds["+ i +"].insuredFlag").value.substring(1,2)=="1"){
							check1 = true;
					    }
						if(document.getElementById("prpCinsureds["+ i +"].insuredFlag").value.substring(2,3)=="1"){
							check2 = true;
					    }
						var strInsuredFlag = document.getElementById("prpCinsureds["+ i +"].insuredFlag").value;
						var resident = document.getElementById("resident["+i+"]");
						if(document.getElementById("prpCinsureds["+ i +"].insuredFlag").value != null && 
								document.getElementById("prpCinsureds["+ i +"].insuredFlag").value.substring(0,1) == "1"){
							if(trim(document.getElementById("prpCinsureds["+ i +"].countryCode").value) == ""){
								errorMessage("投保人国籍不能为空，请重查客户信息");
								return false;
							}
							//投保人时将居民与非居民附到insuredFlag的第30位
//							if(document.getElementById("editType").value!="RENEWAL"){
								if(resident != null){
									document.getElementById("prpCinsureds["+ i +"].insuredFlag").value = Insured.dealInsuredFlagResident(strInsuredFlag, resident.value);
								}else{
									document.getElementById("prpCinsureds["+ i +"].insuredFlag").value = Insured.dealInsuredFlagResident(strInsuredFlag, resident.value);
								}
//							}
						} else{
//							if( document.getElementById("editType").value!="RENEWAL"){
								document.getElementById("prpCinsureds["+ i +"].insuredFlag").value = Insured.dealInsuredFlagResident(strInsuredFlag, resident.value);
//							}
						}
					}
				}else{
					alert('请补录关系人信息！');
					document.getElementById("prpCinsureds["+ i +"].insuredName").select();
					return false;
				}
			}
			if(!check0){
			    alert("必须录入投保人");
			    return false;
			}
			if(!check1){
			    alert("必须录入被保险人");
			    return false;
			}
			if(!check2){
			    alert("必须录入车主");
			    return false;
			}
		},

		/**
		 * @description 将客户新增或查询界面返回信息赋值到页面（类型为"个人"）
		 * @param obj
		 * @return
		 */
		insuredValuePForCqp : function(obj) {
			var maxIdx = -1;
			if(Insured.updateIndex > -1){
				maxIdx = Insured.updateIndex;//若当前操作为修改则需要将客户返回信息回写到被修改的关系人而不是最后一条
			} else {
				maxIdx = Insured.getInsuredsMaxIndex() - 1;
				//获取有效的最大下标
				for(var i=maxIdx; i>=0; i--){
					if(document.getElementById("prpCinsureds["+ i +"].insuredType")!=null){
						maxIdx = i;
						break;
					}
				}
			}
			Insured.updateIndex = -1;//回置updateIndex
			
			var auditStatus = obj.auditStatus;
			// 判断是否要置主要字段为只读。
			var readOnlyFlag = Insured.getAuditStatus(auditStatus);
			if("0,1,3".indexOf(auditStatus) <= -1 || trim(auditStatus)==""){
				var IDCARD_SHIELD = document.getElementById("IDCARD_SHIELD");
				if(readOnlyFlag=="1" && document.getElementById("insuredTypeReadOnlySpan["+ maxIdx +"]") != null){
					Insured.selectReadOnly("insuredTypeReadOnlySpan["+ maxIdx +"]");
				}
				if(obj.insuredCode != null && obj.insuredCode != undefined ){
					document.getElementById("prpCinsureds["+maxIdx+"].insuredCode").value = obj.insuredCode;
					if(readOnlyFlag=="1"){
						document.getElementById("prpCinsureds["+maxIdx+"].insuredCode").readOnly = true;
					}
				}
				if(obj.insuredName != null && obj.insuredName != undefined ){
					document.getElementById("prpCinsureds["+maxIdx+"].insuredName").value = obj.insuredName;
					if(readOnlyFlag=="1"){
						document.getElementById("prpCinsureds["+maxIdx+"].insuredName").readOnly = true;
					}
				}
				if(obj.identifytype != null && obj.identifytype != undefined ){
					document.getElementById("prpCinsureds["+maxIdx+"].identifyType").value = obj.identifytype;
					if(readOnlyFlag=="1"){
						Insured.selectReadOnly("identifyTypeShow["+ maxIdx +"]");
					}
				}
				if(obj.identifyNumberEdit != null && obj.identifyNumberEdit != undefined ){
					if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1" && obj.identifytype != null && obj.identifytype != undefined && obj.identifytype.trim() == "01"){
						if(obj.identifyNumberLSJ != null && obj.identifyNumberLSJ != undefined && obj.identifyNumberLSJ !=""){
			            	//隐藏域赋值
							document.getElementById("prpCinsureds["+maxIdx+"].identifyNumber").value = obj.identifyNumberLSJ;
							if(document.getElementById("identifyNumber["+maxIdx+"]") != null){
								document.getElementById("identifyNumber["+maxIdx+"]").value = obj.identifyNumberEdit.trim().substr(0, 10) + "******" + obj.identifyNumberEdit.trim().substr(16, 2);
								document.getElementById("identifyNumber["+maxIdx+"]").readOnly = true;
							}
						}else{
							document.getElementById("prpCinsureds["+maxIdx+"].identifyNumber").value = obj.identifyNumberLSJ;
							if(document.getElementById("identifyNumber["+maxIdx+"]") != null){
								document.getElementById("identifyNumber["+maxIdx+"]").value = obj.identifyNumberEdit;
							}
						}
						if(isNaN(document.getElementById("prpCinsureds["+maxIdx+"].drivingLicenseNo"))){
							document.getElementById("prpCinsureds["+maxIdx+"].drivingLicenseNo").value = obj.identifyNumberLSJ;
							if(document.getElementById("drivingLicenseNos["+maxIdx+"]") != null){
								document.getElementById("drivingLicenseNos["+maxIdx+"]").value = obj.identifyNumberEdit.trim().substr(0, 10) + "******" + obj.identifyNumberEdit.trim().substr(16, 2);
							}
						}
					}else{
						document.getElementById("prpCinsureds["+maxIdx+"].identifyNumber").value = obj.identifyNumberEdit;
						if(document.getElementById("identifyNumber["+maxIdx+"]") != null){
							document.getElementById("identifyNumber["+maxIdx+"]").value = obj.identifyNumberEdit;
						}
					}
					if(readOnlyFlag=="1"){
						document.getElementById("prpCinsureds["+maxIdx+"].identifyNumber").readOnly = true;
					}
				}
				if(obj.sex != null && obj.sex != undefined  && obj.sex !=""){
					document.getElementById("prpCinsureds["+maxIdx+"].sex").value = obj.sex;
				}else{
					document.getElementById("prpCinsureds["+maxIdx+"].sex").value = '0';
				}
				if(obj.age != null && obj.age != undefined  && obj.age != ""){
					document.getElementById("prpCinsureds["+maxIdx+"].age").value = obj.age;
				}else{
					document.getElementById("prpCinsureds["+maxIdx+"].age").value = "";
				}
				if(readOnlyFlag=="1"){
					Insured.selectReadOnly("sexReadOnlySpan["+ maxIdx +"]");
		        }
				if(obj.countryCode != null && obj.countryCode != undefined ){
					document.getElementById("prpCinsureds["+maxIdx+"].countryCode").value = obj.countryCode;//国籍
				}
				if(obj.resident != null && obj.resident != undefined ){
					document.getElementById("resident["+maxIdx+"]").value = obj.resident;//居民非居民
				}
				if(obj.mobile != null && obj.mobile != undefined ){
					if(obj.mobile != ""){
						document.getElementById("prpCinsureds["+maxIdx+"].mobile").value = obj.mobile;
						document.getElementById("mobile["+maxIdx+"]").value = obj.mobileNoYG.substr(0, 3) + "****" + obj.mobileNoYG.substr(7, 4);// 移动电话
						document.getElementById("mobile["+maxIdx+"]").style.display = "";
						document.getElementById("prpCinsureds["+maxIdx+"].mobile").style.display = "none";
						document.getElementById("mobile["+maxIdx+"]").readOnly = true;
					}else{
						document.getElementById("prpCinsureds["+maxIdx+"].mobile").value = obj.mobile;
						document.getElementById("mobile["+maxIdx+"]").value = obj.mobileNoYG;
					}
					if(readOnlyFlag=="1"){
						document.getElementById("prpCinsureds["+maxIdx+"].mobile").readOnly = true;
					}
				}
				if(obj.phoneNumber != null && obj.phoneNumber != undefined ){
					document.getElementById("prpCinsureds["+maxIdx+"].phoneNumber").value = obj.phoneNumber;
					if(readOnlyFlag=="1"){
						document.getElementById("prpCinsureds["+maxIdx+"].phoneNumber").readOnly = true;
					}
				}
				if(obj.insuredAddress != null && obj.insuredAddress != undefined ){
					document.getElementById("prpCinsureds["+maxIdx+"].insuredAddress").value = obj.insuredAddress;
					if(readOnlyFlag=="1"){
				        document.getElementById("prpCinsureds["+ maxIdx +"].insuredAddress").readOnly = true;
				    }
				}
				if(obj.postCode != null && obj.postCode != undefined ){
					document.getElementById("prpCinsureds["+maxIdx+"].postCode").value = obj.postCode;
					if(readOnlyFlag=="1"){
				        document.getElementById("prpCinsureds["+ maxIdx +"].postCode").readOnly = true;
				    }
				}
			  	if(document.getElementById("prpCinsureds["+maxIdx+"].identifyType").value =="01" || document.getElementById("prpCinsureds["+maxIdx+"].identifyType").value =="16"){
			  		var identifyNumber = document.getElementById("prpCinsureds["+maxIdx+"].identifyNumber");
			  		if(IDCARD_SHIELD != null && IDCARD_SHIELD.value == "1" && document.getElementById("prpCinsureds["+maxIdx+"].identifyType").value =="01"){
			  		}else{
				  		Insured.checkIdentifyNumberIDForCqp(identifyNumber);
			  		}
			  	}
			  	if(obj.auditStatus != null && obj.auditStatus != undefined ){
					var auditStatus = obj.auditStatus;// 审批状态
					var auditStatusDes = Insured.tranAuditStatus(auditStatus);
					document.getElementById("prpCinsureds["+maxIdx+"].auditStatus").value = auditStatus;
					document.getElementById("prpCinsureds["+maxIdx+"].auditStatusDes").value = auditStatusDes;
				}
				if(obj.versionNo != null && obj.versionNo != undefined ){
					document.getElementById("prpCinsureds["+maxIdx+"].versionNo").value = obj.versionNo;// 版本号
				}
				if(obj.appendPrintName != null && obj.appendPrintName != undefined ){
					document.getElementById("prpCinsureds["+maxIdx+"].appendPrintName").value = obj.appendPrintName;// 打印附加
				}
//				if(obj.groupCode != null && obj.groupCode != undefined ){
//					document.getElementById("groupCode["+maxIdx+"]").value = obj.groupCode;// 集团代码
//				}
		  		//校验客户系统返回信息
				Insured.checkCstReturnInfoForCqp(obj.mobileNoYG, obj.phoneNumber, obj.insuredAddress, maxIdx);
			}else{
				alert("此客户未经审核通过，不允许录单！");
				return false;
			}
		},

		/**
		 * @description 将客户新增或查询界面返回信息赋值到页面（类型为"团体"）
		 * @param obj
		 * @return
		 */
		insuredValueGForCqp : function(obj) {
			var maxIdx = -1;
			if(Insured.updateIndex > -1){
				maxIdx = Insured.updateIndex;//若当前操作为修改则需要将客户返回信息回写到被修改的关系人而不是最后一条
			} else {
				maxIdx = Insured.getInsuredsMaxIndex() - 1;
				//获取有效的最大下标
				for(var i=maxIdx; i>=0; i--){
					if(document.getElementById("prpCinsureds["+ i +"].insuredType")!=null){
						maxIdx = i;
						break;
					}
				}
			}
			Insured.updateIndex = -1;//回置updateIndex
			
			var auditStatus = obj.auditStatus;
			if("0,1,3".indexOf(auditStatus) <= -1 || trim(auditStatus)==""){
				var readOnlyFlag = Insured.getAuditStatus(obj.auditStatus);
				if(readOnlyFlag=="1" && document.getElementById("insuredTypeReadOnlySpan["+ maxIdx +"]") != null){
					Insured.selectReadOnly("insuredTypeReadOnlySpan["+ maxIdx +"]");
				}
				if(obj.insuredCode != null && obj.insuredCode != undefined ){
					document.getElementById("prpCinsureds["+maxIdx+"].insuredCode").value = obj.insuredCode.trim();// ID
					if(readOnlyFlag=="1")
			        {
			       		 document.getElementById("prpCinsureds["+maxIdx+"].insuredCode").readOnly = true;
			       	}
				}
				if(obj.insuredName != null && obj.insuredName != undefined ){
					document.getElementById("prpCinsureds["+maxIdx+"].insuredName").value = obj.insuredName;// 名称
					if(readOnlyFlag=="1")
			        {
			       		 document.getElementById("prpCinsureds["+maxIdx+"].insuredName").readOnly = true;
			       	}
				}
				if(obj.identifyNumberEdit != null && obj.identifyNumberEdit != undefined ){
					document.getElementById("prpCinsureds["+maxIdx+"].identifyNumber").value = obj.identifyNumberEdit.trim();// 组织机构代码
					if(document.getElementById("identifyNumber["+maxIdx+"]") != null){
						document.getElementById("identifyNumber["+maxIdx+"]").value = obj.identifyNumberEdit.trim();
					}
				}
				//LiChenhui;组织机构代码控制只读;20100930;begin;
				if(readOnlyFlag=="1")
			    {
		      		 document.getElementById("prpCinsureds["+maxIdx+"].identifyNumber").readOnly = true;
		      		 if(document.getElementById("identifyNumber["+maxIdx+"]") != null){
		      			document.getElementById("identifyNumber["+maxIdx+"]").readOnly = true;
		      		 }
			    }
			    //LiChenhui;组织机构代码控制只读;20100930;end;
				if(obj.countryCode != null && obj.countryCode != undefined ) {
					document.getElementById("prpCinsureds["+maxIdx+"].countryCode").value = obj.countryCode;// 国籍
				}
				if(obj.unitType != null && obj.unitType != undefined ){
					document.getElementById("prpCinsureds["+maxIdx+"].unitType").value = obj.unitType;// 单位性质
				}
				if(obj.resident != null && obj.resident != undefined ){
					document.getElementById("resident["+maxIdx+"]").value = obj.resident;//居民非居民
				}
				if(obj.mobile != null && obj.mobile != undefined ){
					if(obj.mobile != ""){
						document.getElementById("prpCinsureds["+maxIdx+"].mobile").value = obj.mobile;
						document.getElementById("mobile["+maxIdx+"]").value = obj.mobileNoYG.substr(0, 3) + "****" + obj.mobileNoYG.substr(7, 4);// 移动电话
						document.getElementById("mobile["+maxIdx+"]").style.display = "";
						document.getElementById("prpCinsureds["+maxIdx+"].mobile").style.display = "none";
						document.getElementById("mobile["+maxIdx+"]").readOnly = true;
					}else{
						document.getElementById("prpCinsureds["+maxIdx+"].mobile").value = obj.mobile;
						document.getElementById("mobile["+maxIdx+"]").value = obj.mobileNoYG;
					}
					if(readOnlyFlag=="1"){
						document.getElementById("prpCinsureds["+maxIdx+"].mobile").readOnly = true;
					}
				}
				if(obj.phoneNumber != null && obj.phoneNumber != undefined ){
					document.getElementById("prpCinsureds["+maxIdx+"].phoneNumber").value = obj.phoneNumber;// 固定电话
					if(readOnlyFlag=="1"){
						document.getElementById("prpCinsureds["+maxIdx+"].phoneNumber").readOnly = true;
					}
				}
				if(obj.unifiedSocialCreditCode != null && obj.unifiedSocialCreditCode != undefined ){
					document.getElementById("prpCinsureds["+maxIdx+"].unifiedSocialCreditCode").value = obj.unifiedSocialCreditCode;// 统一社会信用代码
					if(readOnlyFlag=="1"){
						document.getElementById("prpCinsureds["+maxIdx+"].unifiedSocialCreditCode").readOnly = true;
					}
				}
				if(obj.insuredAddress != null && obj.insuredAddress != undefined ){
					document.getElementById("prpCinsureds["+maxIdx+"].insuredAddress").value = obj.insuredAddress;// 地址
					if(readOnlyFlag=="1"){
				        document.getElementById("prpCinsureds["+ maxIdx +"].insuredAddress").readOnly = true;
				    }
				}
				if(obj.postCode != null && obj.postCode != undefined ){
					document.getElementById("prpCinsureds["+maxIdx+"].postCode").value = obj.postCode;// 邮编
					if(readOnlyFlag=="1"){
				        document.getElementById("prpCinsureds["+ maxIdx +"].postCode").readOnly = true;
				    }
				}
			  	if(obj.auditStatus != null && obj.auditStatus != undefined ){
					var auditStatus = obj.auditStatus;// 审批状态
					var auditStatusDes = Insured.tranAuditStatus(auditStatus);
					document.getElementById("prpCinsureds["+maxIdx+"].auditStatus").value = auditStatus;
					document.getElementById("prpCinsureds["+maxIdx+"].auditStatusDes").value = auditStatusDes;
				}
				if(obj.versionNo != null && obj.versionNo != undefined ){
					document.getElementById("prpCinsureds["+maxIdx+"].versionNo").value = obj.versionNo;// 版本号
				}
				if(obj.appendPrintName != null && obj.appendPrintName != undefined ){
					document.getElementById("prpCinsureds["+maxIdx+"].appendPrintName").value = obj.appendPrintName;// 打印附加
				}
//				if(obj.groupCode != null && obj.groupCode != undefined ){
//					document.getElementById("groupCode["+maxIdx+"]").value = obj.groupCode;// 集团代码
//				}
				//校验客户系统返回信息
				Insured.checkCstReturnInfoForCqp(obj.mobileNoYG, obj.phoneNumber, obj.insuredAddress, maxIdx);
			}else{
				alert("此客户未经审核通过，不允许录单！");
				return false;
			}
		},

		/**
		 * @private
		 * @description 获取关系人列表的最大下标+1
		 * @return
		 */
		getInsuredsMaxIndex : function() {
			var index = document.getElementById("hidden_index_insured").value;
			if (isNaN(parseInt(globalindex["insertInsuredRow"]))) {
				globalindex["insertInsuredRow"] = parseInt(index);
			}
			var maxIndex = parseInt(globalindex["insertInsuredRow"]);
			if(isNaN(maxIndex)){
				maxIndex = 0
			}
			return maxIndex;
		},

		/**
		 * 证件号码：（blurIdentityNumber/queryCustomerP/insuredValue/insuredValueP）
		 * @description 校验组织机构代码/个人身份证号码，并回写驾驶证号
		 * <p>
		 * <font color=red>规则 : 调用:R29,R625</font>
		 * </p>
		 * @param field输入域
		 * @return 校验通过 true,校验失败 false
		 */
		checkIdentifyNumberIDForCqp : function (field) {
			var eleName = field.name;
			var idx=eleName.substring(eleName.indexOf("[")+1,eleName.indexOf("]"));
			if(isNaN(idx) || idx == "") {
				idx = 0;
			}
			// 证件类型只有是身份证的时候才校验
			if(document.getElementById("prpCinsureds["+ idx +"].insuredType") != null 
					&& document.getElementById("prpCinsureds["+ idx +"].insuredType").value=="1"
						&&document.getElementById("prpCinsureds["+ idx +"].identifyType").value=="01") {
				if(field.value==""){
					document.getElementById("prpCinsureds["+ idx +"].age").value = "";
					document.getElementById("prpCinsureds["+ idx +"].drivingLicenseNo").value = "";
					return false;
				}
				if(!Insured.isChinaIDCard(field.value,idx)){// 用客户管理系统的身份证校验
					document.getElementById("prpCinsureds["+ idx +"].age").value = "";
					field.focus();
			   	  	field.select();
			   	  	return false;
				}else{
					//回写驾驶证号
					Insured.writeDivLicenseNoForCqp(idx);
				}
			}else if(document.getElementById("prpCinsureds["+ idx +"].insuredType") != null 
					&& document.getElementById("prpCinsureds["+ idx +"].insuredType").value=="1"
					&&document.getElementById("prpCinsureds["+ idx +"].identifyType").value=="16"){
				//身份证
				 if(field.value==""){
					 document.getElementById("prpCinsureds["+ idx +"].age").value = "";
					 document.getElementById("prpCinsureds["+ idx +"].drivingLicenseNo").value = "";
					 return false;
				  }
				  if(trim(field.value).length!=15){
					    alert("输入的外国人永久居留身份证号码必须为15位！");
					    field.value="";
					    field.focus();
						return false;
				  }
				
			}else if(document.getElementById("prpCinsureds["+ idx +"].insuredType") != null 
					&& document.getElementById("prpCinsureds["+ idx +"].insuredType").value=="1"){
				Insured.writeDrivingLicenseNoForCqp(field,idx);
			}else if(document.getElementById("prpCinsureds["+ idx +"].insuredType") != null 
					&& document.getElementById("prpCinsureds["+ idx +"].insuredType").value=="2"){	    
				if(field.value!="" && field.readOnly==false && !Insured.isValidEntpCode(field.value)){
					 field.focus();
			   	  	 field.select();
			   	  	 return false;
				}
				
			}
		    return true;
		},
		/**
		 * 证件号码
		 * @description 证件类型为“身份证” 根据身份证号回写驾驶证号
		 * @param idx
		 * @return
		 */
		writeDivLicenseNoForCqp : function(idx) {
			var identifyNumber = document.getElementById("prpCinsureds["+ idx +"].identifyNumber").value;
			if(document.getElementById("prpCinsureds["+ idx +"].identifyType").value=="01" 
				&& isNaN(document.getElementById("prpCinsureds["+ idx +"].drivingLicenseNo"))){
				if(document.getElementById("drivingLicenseNos["+ idx +"]") != null){
					document.getElementById("drivingLicenseNos["+ idx +"]").value = identifyNumber;
				}
				document.getElementById("prpCinsureds["+ idx +"].drivingLicenseNo").value = identifyNumber;
			}else if(isNaN(document.getElementById("prpCinsureds["+ idx +"].drivingLicenseNo"))){
				document.getElementById("prpCinsureds["+ idx +"].drivingLicenseNo").value = "";
				if(document.getElementById("drivingLicenseNos["+ idx +"]") != null){
					document.getElementById("drivingLicenseNos["+ idx +"]").value = "";
				}
			}
		},
		
		/**
		 * 证件号码
		 * @description 证件类型为“驾驶证” 校验证件号合法性并回写驾驶证号码
		 * @param obj
		 * @param idx
		 * @return
		 */
		writeDrivingLicenseNoForCqp : function(obj,idx) {
			var licenseNo = obj.value;
			if(document.getElementById("prpCinsureds["+ idx +"].identifyType").value=="05" && Insured.checkDrivingLicenseNo(obj)){
				document.getElementById("prpCinsureds["+ idx +"].drivingLicenseNo").value = licenseNo;
			}
		},
		/**
		 * @author zhangfan
		 * @description 浏览页面年龄触发
		 * @param obj
		 * @return
		 */
		showInsuredAge : function(obj){
			checkIsInteger(obj);
			checkLength(obj);
			Insured.checkAgeRange(obj);
		},
		/**
		 * @author zhangfan
		 * @description 浏览页面驾龄触发
		 * @param obj
		 * @return
		 */
		showDrivingYears : function(obj){
			checkIsInteger(obj);
			Insured.checkCarDriverAge(obj);
		},
		/**
		 * @author sinosoft
		 * @description 设置纳税人信息
		 * @param optionType 删除添加状态
		 * @param index 关系人序号
		 * @return
		 */
		setTaxPayerInfo : function(optionType, index){
			var taxPayerCode = document.getElementById('prpCcarShipTax.taxPayerCode');
			var taxPayerName = document.getElementById('prpCcarShipTax.taxPayerName');
			var taxPayerNumber = document
					.getElementById("prpCcarShipTax.taxPayerNumber");
			var taxPayerIdentNo = document
					.getElementById("prpCcarShipTax.taxPayerIdentNo");
			var taxPayerNature = document
					.getElementById("prpCcarShipTax.taxPayerNature");
			var taxPayerIdentNoLSJ = document
			        .getElementById('prpCcarShipTax.taxPayerIdentNoLSJ');
			var taxPayerNumberLSJ = document
			        .getElementById('prpCcarShipTax.taxPayerNumberLSJ');
			if (optionType == "0") {
				// 判断交强险标签页是否加载，如果已加载
				if (taxPayerCode != null && taxPayerCode != undefined) {
					taxPayerCode.value = "";
					taxPayerName.value = "";
					taxPayerNumber.value = "";
					taxPayerIdentNo.value = "";
					taxPayerNature.value = "";
					if(taxPayerIdentNoLSJ != null){
						taxPayerIdentNoLSJ.value = "";
					}
					if(taxPayerNumberLSJ !=null){
						taxPayerNumberLSJ.value = "";
					}
					// 没有加载,将数据同步至公共缓存区
				} else {
					var CItaxPayer = null;
					if (publicCache.CItaxPayer == null) {
						CItaxPayer = {};
					} else {
						CItaxPayer = publicCache.CItaxPayer;
					}
					CItaxPayer['taxPayerCode'] = "";
					CItaxPayer['taxPayerName'] = "";
					CItaxPayer['taxPayerNumber'] = "";
					CItaxPayer['taxPayerIdentNo'] = "";
					CItaxPayer['taxPayerNature'] = "";
					if(taxPayerIdentNoLSJ != null){
						CItaxPayer['taxPayerIdentNoLSJ'] = "";
					}
					if(taxPayerNumberLSJ != null){
						CItaxPayer['taxPayerNumberLSJ'] = "";
					}
					publicCache['CItaxPayer'] = CItaxPayer;
				}
			} else if (optionType == "1") {
				var insuredCode = document
						.getElementById('prpCinsureds[' + index + '].insuredCode');
				var insuredName = document
						.getElementById('prpCinsureds[' + index + '].insuredName');
				var identifyNumber = document
						.getElementById('prpCinsureds[' + index + '].identifyNumber');
				var insuredType = document
						.getElementById('prpCinsureds[' + index + '].insuredType');
				var identifyNumberLSJ = document
				        .getElementById('identifyNumber[' + index + ']');
				// 判断交强险标签页是否加载，如果已加载
				if (taxPayerCode != null && taxPayerCode != undefined) {
					taxPayerCode.value = insuredCode.value;
					taxPayerName.value = insuredName.value;
					taxPayerNumber.value = identifyNumber.value;
					taxPayerIdentNo.value = identifyNumber.value;
					if(insuredType.value =="1"){
						taxPayerNature.value = "3";
					}else if(insuredType.value =="2"){
						taxPayerNature.value = "4";
					}			
					if(taxPayerIdentNoLSJ != null){
						if(identifyNumberLSJ != null){
							taxPayerIdentNoLSJ.value = identifyNumberLSJ.value;
						}
					}
					if(taxPayerNumberLSJ != null){
						if(identifyNumberLSJ != null){
							taxPayerNumberLSJ.value = identifyNumberLSJ.value;
						}
					}
					// 没有加载,将数据同步至公共缓存区
				} else {
					var CItaxPayer = null;
					if (publicCache.CItaxPayer == null) {
						CItaxPayer = {};
					} else {
						CItaxPayer = publicCache.CItaxPayer;
					}
					CItaxPayer['taxPayerCode'] = insuredCode.value;
					CItaxPayer['taxPayerName'] = insuredName.value;
					CItaxPayer['taxPayerNumber'] = identifyNumber.value;
					CItaxPayer['taxPayerIdentNo'] = identifyNumber.value;
					if(insuredType.value =="1"){
						CItaxPayer['taxPayerNature'] = "3";
					}else if(insuredType.value =="2"){
						CItaxPayer['taxPayerNature'] = "4";
					}			
					if(taxPayerIdentNoLSJ != null){
						if(identifyNumberLSJ != null){
							CItaxPayer['taxPayerIdentNoLSJ'] = identifyNumberLSJ.value;
						}
					}
					if(taxPayerNumberLSJ != null){
						if(identifyNumberLSJ != null){
							CItaxPayer['taxPayerNumberLSJ'] = identifyNumberLSJ.value;
						}
					}
					publicCache['CItaxPayer'] = CItaxPayer;
				}
			}
		},
		
		/**
		 * @author LCH
		 * @description 获取投保人所在行的Index
		 * @return Index
		 */
		getApplicantIndex : function() {
			var table = document.getElementById('insertInsuredRow');
			var businessNature = document.getElementById("prpCmain.businessNature").value;
			var rows =  table.tBodies.item(0).rows;
			var elen = rows.length;
			var applicantIndex = -1;
			var reg = /^prpCinsureds(\[){1}[0-9]{1,5}(\]){1}(\.){1}insuredFlag/;
			for (var i = 0; i < elen; i++) {
				var row = rows[i];
				var els = row.all;
				for(var j=0;j<els.length;j++){
					var elName = els[j].name || els[i].id;
					if(reg.exec(elName)){
						var index = ItemKind.getGlobalIndex(elName);
					    if(document.getElementById("prpCinsureds["+index+"].insuredFlag").value.substring(0,1)=="1") {
					    	applicantIndex = index;
					    	break;
					    }
					}
				}
				if(applicantIndex > -1){
					break;
				}
			}
			return applicantIndex;
		},
		/**
		 * @author LCH
		 * @description 获取车主所在行的Index
		 * @return Index
		 */
		getCarOwenerIndex : function() {
			var table = document.getElementById('insertInsuredRow');
			var rows =  table.tBodies.item(0).rows;
			var elen = rows.length;
			var ownerIndex = -1;
			var reg = /^prpCinsureds(\[){1}[0-9]{1,5}(\]){1}(\.){1}insuredFlag/;
			for (var i = 0; i < elen; i++) {
				var row = rows[i];
				var els = row.all;
				for(var j=0;j<els.length;j++){
					var elName = els[j].name || els[i].id;
					if(reg.exec(elName)){
						var index = ItemKind.getGlobalIndex(elName);
					    if(document.getElementById("prpCinsureds["+index+"].insuredFlag").value.substring(2,3)=="1") {
					    	ownerIndex = index;
					    	break;
					    }
					}
				}
				if(ownerIndex > -1){
					break;
				}
			}
			return ownerIndex;
		},
		/**
		 * @author zhangkai
		 * @description 改变客户类型清空交叉销售信息
		 */
		changeTypeClearCrossInfo : function (){
			var bizType = document.getElementById('bizType').value;
			var channelAgentCode = document.getElementById("prpCmainChannel.agentCode");
			if(bizType != 'ENDORSE' && channelAgentCode != null && channelAgentCode.value != ""){
				var _insuredFlag = document.getElementsByName("_insuredFlag");
				var downInsuredType = document.getElementById("_insuredType").value;
				var upInsuredType = "";
				var upflag = false;
				var downflag = false;
				var _insuredFlagValue = "";
				for ( var i = 0; i < _insuredFlag.length; i++) {
					if (_insuredFlag[i].checked == true) {
						_insuredFlagValue += "1";
					} else {
						_insuredFlagValue += "0";
					}
				}
				if(_insuredFlagValue.substring(1,2)=="1"){
					downflag = true;
				}
				var insuredTab = document.getElementById("insertInsuredRow");
				var insuredTbody = insuredTab.tBodies.item(0);
				var insuredRow = insuredTbody.rows;
				for(var j = 0; j < insuredRow.length; j++){
					var eles = insuredRow[j].all;
					for(var k = 0 ; k < eles.length ; k++){
						var eleName = eles[k].name || eles[k].id || "";
						if(eleName.indexOf("insuredFlag") > -1){
							if(eles[k].value.substring(1,2)=="1"){
								upflag = true;
								var index = eleName.substring(eleName.indexOf("[")+1, eleName.indexOf("]"));
								upInsuredType = document.getElementById("prpCinsureds["+index+"].insuredType").value;
							}
							break;
						}
					}
				}
				if(downflag){
					if(upflag){
						if(downInsuredType != upInsuredType){
							MainTotal.clearCrossInfo();
						}
					}else{
						MainTotal.clearCrossInfo();
					}
				}
			}
		},
		
		/**
		 * @author zhangkai
		 * @description  上平台地区改变了被保险人关系代码清空投保查询码
		 */
		changeCodeClearDemandNo : function (){
				var comCode = document.getElementById("prpCmain.comCode").value;
				if(isNaN(document.getElementById("CarShipInit_Flag")) && comCode.substring(0,2) != "12" && document.getElementById("isTaxDemand") != null && document.getElementById("isTaxDemand").value =="1"){
					var _insuredFlag = document.getElementsByName("_insuredFlag");
					var downInsuredCode = document.getElementById("_insuredCode").value;
					var upInsuredCode = "";
					var upflag = false;
					var downflag = false;
					var _insuredFlagValue = "";
					for ( var i = 0; i < _insuredFlag.length; i++) {
						if (_insuredFlag[i].checked == true) {
							_insuredFlagValue += "1";
						} else {
							_insuredFlagValue += "0";
						}
					}
					if(_insuredFlagValue.substring(1,2)=="1"){
						downflag = true;
					}
					var insuredTab = document.getElementById("insertInsuredRow");
					var insuredTbody = insuredTab.tBodies.item(0);
					var insuredRow = insuredTbody.rows;
					for(var j = 0; j < insuredRow.length; j++){
						var eles = insuredRow[j].all;
						for(var k = 0 ; k < eles.length ; k++){
							var eleName = eles[k].name || eles[k].id || "";
							if(eleName.indexOf("insuredFlag") > -1){
								if(eles[k].value.substring(1,2)=="1"){
									upflag = true;
									var index = eleName.substring(eleName.indexOf("[")+1, eleName.indexOf("]"));
									upInsuredCode = document.getElementById("prpCinsureds["+index+"].insuredCode").value;
								}
								break;
							}
						}
					}
					if(downflag){
						if(upflag){
							if(downInsuredCode != upInsuredCode){
		  						CarShipTax.clearDemandNo();
							}
						}else{
							CarShipTax.clearDemandNo();
						}
					}
				}
		},
		
		checkRepeatInsuredFlag : function (strInsureFlag, isUnDoDelete){
			var objTopLen = document.getElementById("hidden_index_insured").value;
			var driverCount = 0;
			//hidden_index_insured 没什么用直接取insertInsuredRow
//			if(objTopLen == null || (objTopLen == 0 && document.getElementById("editType").value=="NEW")){
			objTopLen = parseInt(globalindex["insertInsuredRow"]);
//			}
			for(var j=0;j<objTopLen;j++){
			  	if(document.getElementById("updateIndex").value == j){// 保存
			  		//撤销删除（isUnDoDelete为true）时，对于正在修改的关系人也要做角色是否重复的校验
			  		if(!isUnDoDelete){
			  			continue;
			  		}
			  	}
			    if(isNaN(document.getElementById("prpCinsureds["+j+"].insuredFlag"))&&document.getElementById("prpCinsureds["+j+"].insuredFlag")!=null){
				     if(((strInsureFlag.substring(0,2)).indexOf("1")>-1)&&
				         ((document.getElementById("prpCinsureds["+j+"].insuredFlag").value.substring(0,2)).indexOf("1")>-1)
				         &&(document.getElementById("prpCinsureds["+j+"].flag").value.trim().substring(0,1)!="B")){
				            if(((strInsureFlag.substring(0,2)=="01"&&document.getElementById("prpCinsureds["+j+"].insuredFlag").value.substring(0,2)=="10"))||
				               ((strInsureFlag.substring(0,2)=="10"&&document.getElementById("prpCinsureds["+j+"].insuredFlag").value.substring(0,2)=="01"))){
				            }else{
				                errorMessage("请不要重复录入投保人/被保险人");
							     return false;
				           }
				     }
					 if(((strInsureFlag.substring(2,3)).indexOf("1")>-1)&&
				         ((document.getElementById("prpCinsureds["+j+"].insuredFlag").value.substring(2,3)).indexOf("1")>-1)&&
				         	(document.getElementById("prpCinsureds["+j+"].flag").value.trim().substring(0,1)!="B" && document.getElementById("prpCinsureds["+j+"].flag").value.trim().substring(0,1)!="D")){
				           if(((strInsureFlag.substring(2,3)=="0"&&document.getElementById("prpCinsureds["+j+"].insuredFlag").value.substring(2,3)=="1"))||
				               ((strInsureFlag.substring(2,3)=="1"&&document.getElementById("prpCinsureds["+j+"].insuredFlag").value.substring(2,3)=="0"))){
				           }else{
				                errorMessage("请不要重复录入车主.");
							     return false;	           
				           }	         	
				     }
					 if(((strInsureFlag.substring(6,7)).indexOf("1")>-1)&&
					         ((document.getElementById("prpCinsureds["+j+"].insuredFlag").value.substring(6,7)).indexOf("1")>-1)&&
					         	(document.getElementById("prpCinsureds["+j+"].flag").value.trim().substring(0,1)!="B" && document.getElementById("prpCinsureds["+j+"].flag").value.trim().substring(0,1)!="D")){
					           if(((strInsureFlag.substring(6,7)=="0"&&document.getElementById("prpCinsureds["+j+"].insuredFlag").value.substring(6,7)=="1"))||
					               ((strInsureFlag.substring(6,7)=="1"&&document.getElementById("prpCinsureds["+j+"].insuredFlag").value.substring(6,7)=="0"))){
					           }else{
					                errorMessage("请不要重复录入联系人.");
								     return false;	           
					           }	         	
					     }
					 if(((strInsureFlag.substring(7,8)).indexOf("1")>-1)&&
					         ((document.getElementById("prpCinsureds["+j+"].insuredFlag").value.substring(7,8)).indexOf("1")>-1)&&
					         	(document.getElementById("prpCinsureds["+j+"].flag").value.trim().substring(0,1)!="B" && document.getElementById("prpCinsureds["+j+"].flag").value.trim().substring(0,1)!="D")){
					           if(((strInsureFlag.substring(7,8)=="0"&&document.getElementById("prpCinsureds["+j+"].insuredFlag").value.substring(7,8)=="1"))||
					               ((strInsureFlag.substring(7,8)=="1"&&document.getElementById("prpCinsureds["+j+"].insuredFlag").value.substring(7,8)=="0"))){
					           }else{
					                errorMessage("请不要重复录入委托人.");
								     return false;	           
					           }	         	
					     }
//				     if(strInsureFlag.substring(3,4)=="1"&&document.getElementById("prpCinsureds["+j+"].insuredFlag").value.substring(3,4)=="1"  &&
//				    		 document.getElementById("prpCinsureds["+j+"].flag").value.trim().substring(0,1)!="B"){
//				          driverNo++;
//				     }	    
			    }
			}
			return true;
		},
	/**
	 * @author 		QinHuina
	 * @description 当是否上门投保为'是'时，修改了被保险人信息需清空保费
	 * @param 		insureFlag 
	 * @return
	 */
	clearSumPremiumByCondition : function(){
		var dropinVisitInsureFlag = document.getElementsByName("prpCitemCar.isDropinVisitInsure");
		var comCode = document.getElementById("comCode").value;
		if(XIAMEN_CODE.indexOf(comCode.substring(0,4)) > -1){
			if(dropinVisitInsureFlag != null && dropinVisitInsureFlag[0].checked){
				//清空保费
				ItemKind.clearSumPremium();
			}
		}
	},
	/**
	 * @author 		QinHuina
	 * @description 被保险人的单位性质改变时，如果上门投保为'是'，需清空保费
	 * @param 		field 单位性质
	 * @return
	 */
	changeUnitType : function(field){
		var name = field.id || field.name;
		var idx = name.substring(name.indexOf('[')+1,name.indexOf(']'));
		var insuredFlag = document.getElementById("prpCinsureds[" + idx + "].insuredFlag").value;
		//如果是上门投保业务，被保险人改变时需清空保费
		/*
		 * 厦门费改后不存在上门投保
		if(insuredFlag.substring(1,2) == "1"){
			Insured.clearSumPremiumByCondition();
		}*/
	},
	/**
	 * @author 		QinHuina
	 * @description 上门投保为'是'时，修改了被保险人类型和单位性质信息需清空保费
	 * @param 		field 单位性质
	 * @return
	 */
	checkClearSumPremiumByCondition : function (){
		var _insuredFlag = document.getElementsByName("_insuredFlag");
		var downInsuredType = document.getElementById("_insuredType").value;
		var downUnitType = document.getElementById("_unitType").value;
		var upInsuredType = "";
		var upUnitType = "";
		var upflag = false;
		var downflag = false;
		var _insuredFlagValue = "";
		for ( var i = 0; i < _insuredFlag.length; i++) {
			if (_insuredFlag[i].checked == true) {
				_insuredFlagValue += "1";
			} else {
				_insuredFlagValue += "0";
			}
		}
		if(_insuredFlagValue.substring(1,2)=="1"){
			downflag = true;
		}
		var insuredTab = document.getElementById("insertInsuredRow");
		var insuredTbody = insuredTab.tBodies.item(0);
		var insuredRow = insuredTbody.rows;
		for(var j = 0; j < insuredRow.length; j++){
			var eles = insuredRow[j].all;
			for(var k = 0 ; k < eles.length ; k++){
				var eleName = eles[k].name || eles[k].id || "";
				if(eleName.indexOf("insuredFlag") > -1){
					if(eles[k].value.substring(1,2)=="1"){
						upflag = true;
						var index = eleName.substring(eleName.indexOf("[")+1, eleName.indexOf("]"));
						//类型
						upInsuredType = document.getElementById("prpCinsureds["+index+"].insuredType").value;
						//单位性质
						upUnitType = document.getElementById("prpCinsureds["+index+"].unitType").value;
					}
					break;
				}
			}
		}
		/*
		 * 厦门费改后不存在上门投保
			if(downflag){
				if(upflag){
					if(downInsuredType != upInsuredType || (upUnitType !="" && downUnitType != upUnitType )){
  						Insured.clearSumPremiumByCondition();
					}
				}else{
					Insured.clearSumPremiumByCondition();
				}
			}*/
	},

	/**
	 * @author 		yanggang
	 * @description 判断是否需要加载关系人标签页
	 * @return
	 */
	checkInitEngage : function(field,type){
		var isInit = false;
		if(type != null && type == "InsuredAdd"){
			var insuredFlag = document.getElementsByName("_insuredFlag");
			if(insuredFlag[1].checked == true || insuredFlag[2].checked == true || insuredFlag[3].checked == true){
				isInit = true;
			}
		}else if(field != null && type != null && type == "InsuredDel"){
			var name = field.name;
			var index = name.substring(name.indexOf('[') +1,name.indexOf(']'));
			var insuredFlag = document.getElementById("prpCinsureds["+index+"].insuredFlag");
			if(insuredFlag != null && insuredFlag.value != null && insuredFlag.value.length >= 4 && ("1" == insuredFlag.value.substring(1,2) 
					|| "1" == insuredFlag.value.substring(2,3) || "1" == insuredFlag.value.substring(3,4))){
				isInit = true;
			}
		}
		return isInit
	},
	/**
	 * @author zhangkai
	 * @description 保费厘定、平台交互前判断车主是否与交管的车主相同
	 */
	checkInsureBeforePlat : function(){
		var comCode = document.getElementById("prpCmain.comCode").value;
		var ownerNamePlat = document.getElementById("ciPmInsureVehicleCar.ownerName");//交管车主名称(隐藏域)
		var ownerName= Insured.getOwnerName();	
		if(comCode.substring(0,2)=='32' && ownerNamePlat != null && trim(ownerNamePlat.value) != ''){
			if(trim(ownerName) != trim(ownerNamePlat.value)){
				alert("平台交管记录车主为 "+ ownerNamePlat.value +" ，请用此车主名称出单!");
				return false;
			}
		}
		return  true;
	},
	/**
	 * @author zhangkai
	 *  @description 改变车主后清空保费
	 */
	ownerClearPremium : function(){
		var _insuredFlag = document.getElementsByName("_insuredFlag");
		var insureTab = document.getElementById("insertInsuredRow");
		var tbody = insureTab.tBodies.item(0);
		var rows = tbody.rows;
		var upflag = false;
		var downflag = false;
		var upOwnerName = "";
		var downOwnerName = "";
		var _insuredFlagValue = "";
		for ( var i = 0; i < _insuredFlag.length; i++) {
			if (_insuredFlag[i].checked == true) {
				_insuredFlagValue += "1";
			} else {
				_insuredFlagValue += "0";
			}
		}
		if(_insuredFlagValue.substring(2,3)=="1"){
			downflag = true;
			downOwnerName = document.getElementById("_insuredName").value;
		}
		for(var j=0;j<rows.length;j++){
			var eles = rows[j].all;
			for(var k=0;k<eles.length;k++){
				var name = eles[k].name || eles[k].id;
				if(name.indexOf("insuredFlag")> -1){
					var insuredFlag = document.getElementById(name).value;
					if(insuredFlag.substring(2,3)=='1'){
						upflag = true; 
						var index = name.substring(name.indexOf('[') +1,name.indexOf(']'));
						upOwnerName = document.getElementById("prpCinsureds["+index+"].insuredName").value;
					}
					break;
				}
			}
			if(upflag){
				break;
			}
		}
		if(downflag && trim(upOwnerName) != trim(downOwnerName)){
			// 清空总保费
			ItemKind.clearSumPremium();
		}
	},
	getMobile : function(){
		var vCount = Insured.getInsuredsMaxIndex();
		var mobilePB = "";
		for(var i=0;i<vCount;i++){
			insuredFlag = document.getElementById("prpCinsureds["+i+"].insuredFlag");
			if(insuredFlag!=null && insuredFlag.value.substring(1,2)=='1'){
				var mobile = document.getElementById("prpCinsureds["+i+"].mobile");
				if(mobile!=null && mobile.value!="" && mobile.value.length=='11'){
					mobilePB = mobile.value.substring(0,3)+"****"+mobile.value.substring(7,11);
					break;
				}
			}
			
		}
		return mobilePB;
	},
	

	/**
	 * 角色修改：双击关系人角色
	 * @description 显示角色修改界面
	 * @param obj
	 * @return
	 */
	editInsuredFlag:function(obj){
		var name = obj.name || obj.id; 
		var index = ItemKind.getGlobalIndex(name);
		if(Insured.checkBeforeEditInsuredFlag(index)){
			Insured.showInsuredFlagDialog(index);
		}
	},

	/**
	 * 角色修改：双击关系人角色
	 * @description 修改角色之前先校验名称、组织机构代码或代码至少输入一项
	 * @param idx
	 * @return
	 */
	checkBeforeEditInsuredFlag : function(idx){
		var _insuredName = document.getElementById("prpCinsureds["+ idx +"].insuredName").value;
		var _identifyNumber = document.getElementById("prpCinsureds["+ idx +"].identifyNumber").value;
		var _insuredCode = document.getElementById("prpCinsureds["+ idx +"].insuredCode").value;
		if((_insuredName==null||_insuredName == "")&&(_identifyNumber==null||_identifyNumber == "")
				&&(_insuredCode==null||_insuredCode == "")){
		       errorMessage("请先录入关系人（名称、组织机构代码或代码至少输入一项）");
		       document.getElementById("prpCinsureds["+ idx +"].insuredName").focus();
		       document.getElementById("prpCinsureds["+ idx +"].insuredName").select();
			   return false;
		}
		return true;
	},

	/**
	 * 角色修改：双击关系人角色
	 * @description 显示角色修改界面
	 * @param iIndex
	 * @return
	 */
	showInsuredFlagDialog : function(iIndex){
		var insuredFlag = document.getElementById("prpCinsureds[" + iIndex + "].insuredFlag");
		var insuredFlagTemps = document.getElementsByName("insuredFlagTemp[" + iIndex + "]");
		var insuredType = document.getElementById("prpCinsureds[" + iIndex + "].insuredType");
		document.getElementById("InsuredFlagDetail["+ iIndex +"]").style.display = "";
		if(insuredType!=null && insuredType.value=="2"){
			insuredFlagTemps[3].disabled = true;
		}else{
			insuredFlagTemps[3].disabled = "";
		}
		if(insuredFlag != null && insuredFlag.value.length >= 8){
			if(insuredFlag.value.substring(0,1) == "1"){
				insuredFlagTemps[0].checked = true;
				Insured.changeButton(insuredFlagTemps[0]);
			}
			if(insuredFlag.value.substring(1,2) == "1"){
				insuredFlagTemps[1].checked = true;
				Insured.changeButton(insuredFlagTemps[0]);
			}
			if(insuredFlag.value.substring(2,3) == "1"){
				insuredFlagTemps[2].checked = true;
			}
			if(insuredFlag.value.substring(3,4) == "1"){
				insuredFlagTemps[3].checked = true;
				Insured.changeButton(insuredFlagTemps[0]);
			}
			if(insuredFlag.value.substring(4,5) == "1"){
				insuredFlagTemps[4].checked = true;
			}
			if(insuredFlag.value.substring(5,6) == "1"){
				insuredFlagTemps[5].checked = true;
			}
			if(insuredFlag.value.substring(6,7) == "1"){
				insuredFlagTemps[6].checked = true;
			}
			if(insuredFlag.value.substring(7,8) == "1"){
				insuredFlagTemps[7].checked = true;
			}
		}
		var dialogI;
		if(Insured.hpDialogIs.containsKey(iIndex) && Insured.hpDialogIs.get(iIndex)){
			dialogI = Insured.hpDialogIs.get(iIndex);
		}else{
			var profitTableName = "InsuredFlagDetail[" +  iIndex + "]";
			var table  = document.getElementById(profitTableName);
			var panelID = "panel" + profitTableName;
			if(!dialogI)
			{
				 dialogI = new YAHOO.widget.Panel(panelID, {
					width : "370px",
					height : "240px",
					fixedcenter : true,
					close : true,
					draggable : true,
					zindex : 4,
					modal : true,
					visible : true
				});
				dialogI.setHeader("角色信息修改");
				dialogI.setBody(table);
				var fm = document.getElementById("fm");
				dialogI.render(fm);
			}	
			Insured.hpDialogIs.put(iIndex,dialogI);
		}
		dialogI.show();
	},

	/**
	 * 角色修改：点击角色修改界面的"确定"按钮
	 * @description 将修改后的角色信息更新到页面
	 * @param field
	 * @return
	 */
	saveInsuredFlagDialog:function(field) {
		var name = field.id || field.name;
		var intIndex = name.substring(name.indexOf('[')+1,name.indexOf(']'));
		var obj = document.getElementsByName("insuredFlagTemp[" + intIndex + "]");
		//获取关系人角色代码串
		var strInsureFlag  = Insured.getInsuredFlag(obj);
		if(strInsureFlag != null && strInsureFlag.length >= 8 && strInsureFlag != "00000000"){
			var insuredFlagEl = document.getElementById("prpCinsureds[" + intIndex + "].insuredFlag");
			var auditStatus = document.getElementById("prpCinsureds[" + intIndex + "].auditStatus");
			//校验角色重复性
			if(!Insured.checkInsuredFlagEcho(strInsureFlag, intIndex)) {
				return false;
			}
			//修改"投保人/被保险人"要提示修改意外险信息
			if(strInsureFlag.substring(0, 1) != insuredFlagEl.value.substring(0,1) ||
					  strInsureFlag.substring(1, 2) != insuredFlagEl.value.substring(1,2)){
				Insured.changeEad();
			}
			//投保人改变时清空保费（自保业务）
			if(strInsureFlag.substring(0, 1) != insuredFlagEl.value.substring(0,1)){
				//Insured.changeCommissionSwithByIB(intIndex);
				Insured.clearQuickCommission(intIndex);
			}
			//被保险人改变时清空车船税税额
			if(insuredFlagEl.value.substring(1,2) == "0" && strInsureFlag.substring(1, 2) == "1"){
				//Insured.taxPayerNameValue(intIndex,strInsureFlag);
				MainHead.clearSumPremiumCI_quickNew();
			}
			//如果是上门投保业务，被保险人改变时要清空保费
			if(strInsureFlag.substring(1, 2) != insuredFlagEl.value.substring(1, 2)){
				 var dropinVisitInsureFlag = document.getElementsByName("prpCitemCar.isDropinVisitInsure");
				 var comCode = document.getElementById("comCode").value;
		         if(XIAMEN_CODE.indexOf(comCode.substring(0,4)) > -1){
			            if(dropinVisitInsureFlag != null && dropinVisitInsureFlag[0].checked){
			    	           MainHead.clearSumPremiumCI_quickNew();
				               MainHead.clearSumPremiumBI_quickNew();
			            }
			     }/*
			                       厦门费改后不存在上门投保
			     else{
			            Insured.clearSumPremiumByCondition();
			     }*/
			}
			//校验投保人和被保险人是否审核通过
			if(strInsureFlag.substring(0,2).indexOf("1")>-1){
				if("0,1,3".indexOf(auditStatus.value) <= -1 || trim(auditStatus.value)==""){					
				}else{
    				alert("此客户未经审核通过，不允许录单！");
	    			return false;
	    			
				}				
			}
			//获取关系人角色中文描述（用于显示）  
			var strInsureFlagDescription = Insured.getInsureFlagDes(strInsureFlag);
			insuredFlagEl.value = strInsureFlag;
			document.getElementById("prpCinsureds[" + intIndex + "].insuredFlagDes").value = strInsureFlagDescription;
		}else{
			alert("请勾选关系人角色！");
			return false;
		}
		//R443 选择"指定驾驶人"后才显示驾龄等相关信息否则不显示
		Insured.showDriverInfo(strInsureFlag,intIndex);
		//关闭子页面
		var name = field.id || field.name;
		var intIndex = name.substring(name.indexOf('[')+1,name.indexOf(']'));
		document.getElementById("InsuredFlagDetail["+ intIndex +"]").style.display = "none";
		Insured.hpDialogIs.get(intIndex).hide();
		
		return true;
	},
	/**
	 * @description 校验角色重复性：投保人/被保险人/车主不能重复录入以及指定驾驶人条数
	 * @param strInsureFlag 角色标志字符串
	 * @param updateIndex 当前被修改的关系人下标：如果当前操作为修改，传入值应>=0;如果不是修改，传入值应为-1
	 * @return 校验通过返回true;不通过返回false
	 */
	checkInsuredFlagEcho : function(strInsureFlag, updateIndex) {
		//获取关系人最大行数 用于判断角色重复
		var idx = Insured.getInsuredsMaxIndex();
		//判断投保人/被保险人/车主是否重复
		var driverCount = 0;
		for(var j=0; j < idx; j++){
			if(j != updateIndex){
				var insuredFlagEl = document.getElementById("prpCinsureds["+j+"].insuredFlag");
				if(isNaN(insuredFlagEl) && insuredFlagEl!=null){
					if((strInsureFlag.substring(0,2)).indexOf("1")>-1 
							&& (insuredFlagEl.value.substring(0,2)).indexOf("1")>-1){
						if(!(strInsureFlag.substring(0,2)=="01" && insuredFlagEl.value.substring(0,2)=="10") 
								&& !(strInsureFlag.substring(0,2)=="10" && insuredFlagEl.value.substring(0,2)=="01")){
							errorMessage("请不要重复录入投保人/被保险人");
							return false;
						}
					}
					if((strInsureFlag.substring(2,3)).indexOf("1")>-1 
							&& (insuredFlagEl.value.substring(2,3)).indexOf("1")>-1){
						errorMessage("请不要重复录入车主.");
						return false;
					}
					//使用性质为“家庭自用”时，最多只能有三个指定驾驶人
					if(strInsureFlag.substring(3,4)=="1"){
						if(insuredFlagEl.value.substring(3,4)=="1"){
							driverCount++;
						}
					}
				}
			}
		}
		if(driverCount>=3){
			errorMessage("使用性质为“家庭自用”时，最多只能有三个指定驾驶人.");
			return false;
		}
		//广东广州指定驾驶人个性
		if(isGuangdong()){
			if(guangZhouFlag){
				if(driverCount >= 3){
					errorMessage("广州控制:只能录三个驾驶员!");
					return false;
				}
			}else{
				if(driverCount >= 1){
					errorMessage("广东控制:只能录一个驾驶员!");
					return false;
				}
			}
		}
		return true;
	},
	/**
	 * @private
	 * @description 获取关系人角色标志字符串
	 * @param insuredFlagArr 关系人角色域的集合（各复选框）
	 * @return 关系人角色标志字符串
	 */
	getInsuredFlag : function (insuredFlagArr) {
		var strInsureFlag  = "000000000000000000000000000000";
		for(var i=0;i<insuredFlagArr.length;i++){
	    	if(insuredFlagArr[i].checked){
	    		strInsureFlag = strInsureFlag.substring(0,i)+"1"+strInsureFlag.substring(i+1);
	    	}
		}
		return strInsureFlag;
	},
	/**
	*车船税清空
	*/
	taxPayerNameValue : function(index,strInsureFlag){
		var comCode = document.getElementById('comCode').value;
		var strCarShipFlag=document.getElementById("strCarShipFlag").value;
		_insuredType=document.getElementById("prpCinsureds["+ index +"].insuredType").value;
		if(strInsureFlag.substring(1, 2) =="1"){
			if(strCarShipFlag!=null && strCarShipFlag=='1'){
				// 查询关系人的同时将客户代码、客户名称、证件号带到车船税
				document.getElementById("prpCcarShipTax.taxPayerCode").value = document.getElementById("prpCinsureds["+ index +"].insuredCode").value;
				document.getElementById("prpCcarShipTax.taxPayerName").value = document.getElementById("prpCinsureds["+ index +"].insuredName").value;
			   	document.getElementById("prpCcarShipTax.taxPayerIdentNo").value = document.getElementById("prpCinsureds["+ index +"].identifyNumber").value.trim();
			   	document.getElementById("prpCcarShipTax.taxPayerNumber").value = document.getElementById("prpCinsureds["+ index +"].identifyNumber").value.trim();
				//车船税上平台地区修改投保人或被保险人之后清空车船税税额
				CarShipTaxQuick.clearPlatSumPayTax();
			    var taxPayerNature = document.getElementById("prpCcarShipTax.taxPayerNature");
				if(_insuredType =="1"){
					for(var i=0;i<taxPayerNature.options.length;i){
						taxPayerNature.options.remove(0);	
					}
					taxPayerNature.options.add(new Option("自然人","3"));
					taxPayerNature.value = "3";
			    }else if(_insuredType =="2"){
					for(var i=0;i<taxPayerNature.options.length;i){
					    taxPayerNature.options.remove(0);
					}
					taxPayerNature.options.add(new Option("法人","4"));
					taxPayerNature.value = "4";	
					if(isGuangdong()){
						//广东个性 法人纳税人识别码不加机构代码前6;zouyx;2011-7-19
						document.getElementById("prpCcarShipTax.taxPayerNumber").value = document.getElementById("prpCinsureds["+index+"].identifyNumber").value;
					}else{
						document.getElementById("prpCcarShipTax.taxPayerNumber").value = document.getElementById("prpCinsureds["+index+"].taxPayerNumber").value;
					}						
				}
			   
				document.getElementById("prpCcarShipTax.carLotEquQuality").value=document.getElementById("prpCitemCar.carLotEquQuality").value;
				document.getElementById("prpCcarShipTax.prePayTaxYear").value=parseInt(document.getElementById("prpCmain.operateDate").value.substring(0,4))-1;
			}	
		}				
	},
	/**
	 * @private
	 * @description 获取关系人角色的中文描述
	 * @param strInsureFlag 关系人角色标志字符串
	 * @return
	 */
	getInsureFlagDes : function (strInsureFlag) {
		var strInsureFlagDescription = "";
		if(strInsureFlag.substring(0,1) == "1"){
			strInsureFlagDescription += '投保人/';
		}
		if(strInsureFlag.substring(1,2) == "1"){
			strInsureFlagDescription += '被保险人/';
		}
		if(strInsureFlag.substring(2,3) == "1"){
			strInsureFlagDescription += '车主/';
		}
		if(strInsureFlag.substring(3,4) == "1"){
			strInsureFlagDescription += '指定驾驶人/';
		}
		if(strInsureFlag.substring(4,5) == "1"){
			strInsureFlagDescription += '受益人/';
		}
		if(strInsureFlag.substring(5,6) == "1"){
			strInsureFlagDescription += '港澳车车主/';
		}
		if(strInsureFlag.substring(6,7) == "1"){
			strInsureFlagDescription += '联系人/';
		}
		if(strInsureFlag.substring(7,8) == "1"){
			strInsureFlagDescription += '委托人/';
		}
		strInsureFlagDescription = strInsureFlagDescription.substring(0, strInsureFlagDescription.length -1);
		return strInsureFlagDescription
	},
	/**
	 * @description 选择"指定驾驶人"后才显示驾龄等相关信息否则不显示
	 * <p>
	 * <font color=red>规则 : 调用：R443</font>
	 * </p>
	 * @param strInsureFlag 关系人角色串
	 * @return
	 */
	showDriverInfo : function (strInsureFlag,index){
		if(strInsureFlag.substring(3,4) == "1"){
			document.getElementById("drivingLicenseNo["+ index +"]").style.display = "";
		}else{
			document.getElementById("drivingLicenseNo["+ index +"]").style.display = "none";
		}
	},
	/**
	 * 角色：修改角色“被保险人”时直接调用
	 * @description 勾选角色“被保险人”时校验
	 * @param field
	 * @return
	 */
	clickInsured : function(field) {
		//勾选被保险人时，“确定”按钮变更为“查询”
		Insured.changeButton(field);
		//为"纳税人编码"赋值
		Insured.changeTaxPayerNo(field);
	},

	/**
	 * 角色：修改角色“被保险人”时(clickInsured)
	 * @description 关系人信息从客户系统获取后更改角色时为"纳税人编码"赋值(PRPALL-3089)
	 * @param field
	 * @return
	 */
	changeTaxPayerNo : function(field) {
		var comCode = document.getElementById("prpCmain.comCode").value;
		if(comCode.substring(0,2) == '50'){
			var name = field.id || field.name;
			var intIndex = name.substring(name.indexOf('[')+1,name.indexOf(']'));
			var insuredType = document.getElementById("prpCinsureds["+ intIndex +"].insuredType1");
			if(field.checked && document.getElementById("prpCinsureds["+ intIndex +"].insuredType1").disabled){
				if(insuredType!=null && insuredType.value=="1"){
					//被保险人类型为个人，纳税人编码为固定值
					if(document.getElementById("prpCcarShipTax.taxPayerNo")!=null){
						document.getElementById("prpCcarShipTax.taxPayerNo").value="500902220000202";	
						document.getElementById("prpCcarShipTax.taxPayerNo").readOnly = true;	
					}
				}else if(insuredType!=null && insuredType.value=="2"){
					//被保险人类型为团体，纳税人编码要手动输入
					if(document.getElementById("prpCcarShipTax.taxPayerNo")!=null){
						document.getElementById("prpCcarShipTax.taxPayerNo").value="";
						document.getElementById("prpCcarShipTax.taxPayerNo").readOnly = false;	
					}
				}
			}
		}
	},
	/**
	 * 角色修改
	 * @description 关闭角色修改界面
	 * @param field
	 * @return
	 */
	closeInsuredFlagDialog : function (field) {
		var name = field.id || field.name;
		var intIndex = name.substring(name.indexOf('[')+1,name.indexOf(']'));
		var insuredFlag=document.getElementById("prpCinsureds[" + intIndex + "].insuredFlag").value;
		var obj = document.getElementsByName("insuredFlagTemp[" + intIndex + "]");
		for(var i=0;i<obj.length;i++){
			if(insuredFlag.substring(i,i+1)=='1'){
				obj[i].checked=true
			}else{
				obj[i].checked=false
			}
		}
		document.getElementById("InsuredFlagDetail["+ intIndex +"]").style.display = "none";
		Insured.hpDialogIs.get(intIndex).hide();
	},
	/**
	 * 角色修改：点击角色修改界面的"查询"按钮
	 * @description 将修改后的角色更新到界面并查询客户系统
	 * @param field
	 * @return
	 */
	queryCustomInSubPage : function (field){
		if(Insured.saveInsuredFlagDialog(field)){
			Insured.queryCustomer4S(field);
		}
	},
	/**
	 * 角色：修改角色时触发
	 * @description 勾选“投保人/被保险人/指定驾驶人”角色中任一时,若关系人“客户代码”字段为空则“确定”按钮变更为“查询”
	 * R103
	 * <p>
	 * <font color=red>规则 : R103</font>
	 * </p>
	 * @param field
	 * @return
	 */
	changeButton : function(field){
		var name = field.id || field.name;
		var intIndex = name.substring(name.indexOf('[')+1,name.indexOf(']'));
		var insuredFlagTemps = document.getElementsByName("insuredFlagTemp[" + intIndex + "]");
		var flag = false;
		if(insuredFlagTemps[0].checked || insuredFlagTemps[1].checked || insuredFlagTemps[3].checked){
			var insuredCode = document.getElementById("prpCinsureds["+ intIndex +"].insuredCode");
			if(trim(insuredCode.value)==""){
				flag = true;
			}
		}
		var saveBtn = document.getElementById("button_InsuredFlagDetail_SubPage_Save[" + intIndex + "]");
		var queryBtn = document.getElementById("button_InsuredFlagDetail_SubPage_Query[" + intIndex + "]");
		if(flag){
			if(saveBtn.style.display != "none"){
				saveBtn.style.display = "none";
			}
			if(queryBtn.style.display != ""){
				queryBtn.style.display = "";
			}
		}else{
			if(saveBtn.style.display != ""){
				saveBtn.style.display = "";
			}
			if(queryBtn.style.display != "none"){
				queryBtn.style.display = "none";
			}
		}
	},
	
	changePre : function (field){
		var name = field.id || field.name;
		var intIndex = name.substring(name.indexOf('[')+1,name.indexOf(']'));
		var insuredFlag=document.getElementById("prpCinsureds[" + intIndex + "].insuredFlag").value;
	   if(insuredFlag.substring(2,3)=='1'){
		      MainHead.clearSumPremiumBI_quickNew();
		     MainHead.clearSumPremiumCI_quickNew();
	   }
	},
	
	/**
	 * @description 校验客户系统返回信息-若移动电话、固定电话均为空或地址为空时，弹出提示并进入客户系统"客户信息修改"界面
	 * @param field
	 * @return
	 */
	checkCstReturnInfo : function (mobile, phoneNumber, insuredAddress){
		var connectedproposalno = document.getElementById("prpCCarERisk.connectedproposalno");
		if(connectedproposalno != null){
			//意外险只校验移动电话
			if(mobile==null || mobile==undefined || mobile==""){
				alert("客户移动电话为空，请进行补录。");
				editCustomer();
			}
		}else{
			if((insuredAddress==null || insuredAddress==undefined || insuredAddress == "")
					|| ((mobile==null || mobile==undefined || mobile == "") 
							&& (phoneNumber==null || phoneNumber==undefined || phoneNumber==""))){
				alert("客户移动电话、固定电话均为空或地址为空，请进行补录。");
				Insured.editCustomer();
			}
		}
	},
	/**
	 * @description 校验客户系统返回信息-若移动电话、固定电话均为空或地址为空时，弹出提示并进入客户系统"客户信息修改"界面
	 * @param field
	 * @return
	 */
	checkCstReturnInfoForCqp : function (mobile, phoneNumber, insuredAddress, index){
		if((insuredAddress==null || insuredAddress==undefined || insuredAddress == "")
				|| ((mobile==null || mobile==undefined || mobile == "") 
						&& (phoneNumber==null || phoneNumber==undefined || phoneNumber==""))){
			alert("客户移动电话或地址为空，请进行补录。");
			Insured.editCustomer4S('', index);
		}
	},
	
	//快速报价上门投保选择"是"单位性质改变时清空保费
	clearPremium:function(){
		var idx = parseInt(globalindex["insertInsuredRow"]) - 1;
			if(isNaN(idx)){
				idx = 0;
			}
			// 防止出现删除行报错
			for(var i=idx;i>=0;i--){
				try{
					document.getElementById("prpCinsureds["+ idx +"].insuredType").value;
				}catch(e){
					idx = i;
				}
			}
    	 var insuredFlag = document.getElementById("prpCinsureds["+idx+"].insuredFlag").value;  	
		 var dropinVisitInsureFlag = document.getElementsByName("prpCitemCar.isDropinVisitInsure");
		 var comCode = document.getElementById("comCode").value;	
		     if(XIAMEN_CODE.indexOf(comCode.substring(0,4)) > -1){		    	 
		    		 if(dropinVisitInsureFlag != null && dropinVisitInsureFlag[0].checked && insuredFlag.substring(1,2) == "1"){
			    	  MainHead.clearSumPremiumCI_quickNew();
				      MainHead.clearSumPremiumBI_quickNew();
				     }			         		
	         } 
     },

	 //关系人类型改变时清空保费
	insuredTypeChangeclearPremium:function(){
    	 var sumPremium = document.getElementById("sumPremium").value;
		 if(sumPremium != ""){
			 MainHead.clearSumPremiumCI_quickNew();
			 MainHead.clearSumPremiumBI_quickNew();
		 }
    	 
	},
	//校验统一社会信用代码
	checkSocialCreditCode:function(fileCode){
		var code=fileCode.value;
		if(code!=null && code!=""){
			if(code.length==18){
				if (!Common.isNumber(code.substr(0, 17))) {
						alert("统一社会信用代码应由17位数字+1位数字或大写字母组成！");
						fileCode.value="";
						fileCode.focus();
						return false;
					}else{
						var arr=/^[A-Z0-9]+$/;
						if(!arr.test(code)){
							alert("统一社会信用代码应由17位数字+1位数字或大写字母组成！");
							fileCode.value="";
							fileCode.focus();
							return false;
						}
					}
			}else{
				alert("统一社会信用代码应由17位数字+1位数字或大写字母组成！");
				fileCode.value="";
				fileCode.focus();
				return false;
			}
		}else{
			alert("统一社会信用代码应由17位数字+1位数字或大写字母组成！");
			fileCode.value="";
			fileCode.focus();
			return false;
		}
	},
	
	/**
	 * @author yanggang
	 * @description 军属军人的click事件<br/>
	 * @param filed
	 *            表单域
	 * @return
	 */
	clickSoldier : function(filed){
		var insuredFlags = document.getElementsByName("_insuredFlag");
		if(filed.checked && insuredFlags != null && insuredFlags.length >= 8 && insuredFlags[2].checked){
			alert("不能同时录入车主和军属军人信息，请先录入车主信息。");
			filed.checked = false;
			return false;
		}
		Insured.selectReadOnlyInsuredType();
		if(filed.checked){
			document.getElementById("soldierIdentifyType").style.display = "";
			document.getElementById("soldierIdentifyTypeValue").style.display = "";
			document.getElementById("soldierIdentifyNumber").style.display = "";
			document.getElementById("soldierIdentifyNumberValue").style.display = "";
		}else{
			Insured.clearSoldierInput();
			document.getElementById("soldierIdentifyType").style.display = "none";
			document.getElementById("soldierIdentifyTypeValue").style.display = "none";
			document.getElementById("soldierIdentifyNumber").style.display = "none";
			document.getElementById("soldierIdentifyNumberValue").style.display = "none";
		}
	},
	
	/**
	 * @author yanggang
	 * @description 车主的click事件<br/>
	 * @param filed
	 *            表单域
	 * @return
	 */
	clickOwner : function(filed){
		var insuredFlags = document.getElementsByName("_insuredFlag");
		if(filed.checked && insuredFlags != null && insuredFlags.length >= 8 && insuredFlags[8].checked){
			alert("不能同时录入车主和军属军人信息，请先录入车主信息。");
			filed.checked = false;
			return false;
		}
		Insured.selectReadOnlyInsuredType();
		if(filed.checked){
			document.getElementById("soldierRelations").style.display = "";
			document.getElementById("soldierRelationsValue").style.display = "";
			document.getElementById("soldierIdentifyType").style.display = "";
			document.getElementById("soldierIdentifyTypeValue").style.display = "";
			document.getElementById("soldierIdentifyNumber").style.display = "";
			document.getElementById("soldierIdentifyNumberValue").style.display = "";
		}else{
			Insured.clearSoldierInput();
			document.getElementById("soldierRelations").style.display = "none";
			document.getElementById("soldierRelationsValue").style.display = "none";
			document.getElementById("soldierIdentifyType").style.display = "none";
			document.getElementById("soldierIdentifyTypeValue").style.display = "none";
			document.getElementById("soldierIdentifyNumber").style.display = "none";
			document.getElementById("soldierIdentifyNumberValue").style.display = "none";
		}
	},
	
	/**
	 * @author yanggang
	 * @description 车主的click事件<br/>
	 * @param filed 
	 *            表单域
	 * @return
	 */
	selectReadOnlyInsuredType : function(){
		var insuredFlags = document.getElementsByName("_insuredFlag");
		if(insuredFlags != null && insuredFlags.length >= 8){
			if(insuredFlags[2].checked == false && insuredFlags[8].checked == false){
				Insured.selectNoReadOnly("selected_insuredType");
			}else{
		   	 	var _insuredType = document.getElementById("_insuredType");
		   	 	if(_insuredType != null){
					for(var i=0;i<_insuredType.options.length;i++){
					    if(_insuredType.options[i].value == 1){
					    	_insuredType.options[i].selected = true;
					    	_insuredType.onchange();
					    }
					}
		   	 	}
				Insured.selectReadOnly("selected_insuredType");
			}
		}
	},
	
	/**
	 * @author yanggang
	 * @description 清空关系人中与军人有关的input内容
	 * @param
	 * @return
	 */
	clearSoldierInput : function(){
   	 	var _soldierRelations = document.getElementById("_soldierRelations");
   	 	if(_soldierRelations != null){
			for(var i=0;i<_soldierRelations.options.length;i++){
			    if(_soldierRelations.options[i].value == 0){
			    	_soldierRelations.options[i].selected = true;
			    }
			}
   	 	}
   	 	var _soldierIdentifyType = document.getElementById("_soldierIdentifyType");
   	 	if(_soldierIdentifyType != null){
			for(var i=0;i<_soldierIdentifyType.options.length;i++){
			    if(_soldierIdentifyType.options[i].value == "000"){
			    	_soldierIdentifyType.options[i].selected = true;
			    	_soldierIdentifyType.onchange();
			    }
			}
   	 	}
	},
	
	/**
	 * @author yanggang
	 * @description 军人证件类型的onchange方法
	 * @param
	 * @return
	 */
	onchangeSoldierIdentifyType : function(){
   	 	var _soldierIdentifyNumber = document.getElementById("_soldierIdentifyNumber");
   	 	if(_soldierIdentifyNumber != null){
   	 		_soldierIdentifyNumber.value = "";
   	 	}
	},
	
	/**
	 * @author yanggang
	 * @description 军人证件号码的校验
	 * @param
	 * @return
	 */
	checkSoldierIdentifyNumber : function(filed){
   	 	var _soldierIdentifyType = document.getElementById("_soldierIdentifyType");
   	 	if(_soldierIdentifyType != null && _soldierIdentifyType.value == "000"){
   	   	 	if(filed.value != "" && !(filed.value.length == 18 && Common.isNumber(filed.value))){
   	   	 		alert("当军人证件类型为军人保障卡时，军人证件号码必须为18位数字。");
   	   	 		filed.focus();
   	   	 		filed.select();
   	   	 		return false;
   	   	 	}
   	 	}
	},
	
	/**
	 * @author yanggang
	 * @description 与军人关系的onchange方法
	 * @param
	 * @return
	 */
	onchangeSoldierRelations : function(field){
   	 	if(field.value != 0){
   	   	 	var _soldierIdentifyType = document.getElementById("_soldierIdentifyType");
   	   	 	if(_soldierIdentifyType != null){
   				for(var i=0;i<_soldierIdentifyType.options.length;i++){
   				    if(_soldierIdentifyType.options[i].value == "000"){
   				    	_soldierIdentifyType.options[i].selected = true;
   				    	_soldierIdentifyType.onchange();
   				    }
   				}
   	   	 	}
			document.getElementById("soldierIdentifyType").style.display = "none";
			document.getElementById("soldierIdentifyTypeValue").style.display = "none";
			document.getElementById("soldierIdentifyNumber").style.display = "none";
			document.getElementById("soldierIdentifyNumberValue").style.display = "none";
   	 	}else{
			document.getElementById("soldierIdentifyType").style.display = "";
			document.getElementById("soldierIdentifyTypeValue").style.display = "";
			document.getElementById("soldierIdentifyNumber").style.display = "";
			document.getElementById("soldierIdentifyNumberValue").style.display = "";
   	 	}
	},
	
	/**
	 * @author yanggang
	 * @description 保费计算前的军人关系人校验
	 * @param
	 * @return
	 */
	checkSoldierInsured : function(){
		var flag = "0";
		//车主与军人关系
		var soldierRelationsOwner;
		//车主军人证件号
		var soldierIdentifyNumberOwner;
		//是否包含军属军人
		var isSoldier = false;
		var maxIdx = Insured.getInsuredsMaxIndex();
		for(var i = 0;i<maxIdx;i++){
			var insuredFlag = document.getElementById("prpCinsureds["+ i +"].insuredFlag");
			if(insuredFlag != null && insuredFlag.value.length >= 30){
				if(document.getElementById("prpCinsureds["+i+"].flag").value.substring(0,1) == "B"
					|| document.getElementById("prpCinsureds["+i+"].flag").value.substring(0,1) == "D"){
					continue;
				}
				if(insuredFlag.value.substring(2,3) == "1"){
					soldierRelationsOwner = document.getElementById("prpCinsureds["+ i +"].soldierRelations").value;
					soldierIdentifyNumberOwner = document.getElementById("prpCinsureds["+ i +"].soldierIdentifyNumber").value;
				}
				if(insuredFlag.value.substring(24,25) == "1"){
					isSoldier = true;
				}
			}
		}
		if(soldierRelationsOwner == "0" && (soldierIdentifyNumberOwner == "" || trim(soldierIdentifyNumberOwner) == "")){
			flag = "1";
		}else if(soldierRelationsOwner != "0" && !isSoldier){
			flag = "2";
		}
		return flag;
	},
	 checkInsuredKind:function (){
//		if(document.getElementById('itemKindLoadFlag') == null){
//			return YAHOO.util.Event.onAvailable("itemKindLoadFlag",Insured.doCheckinsuredKind);
//		}else{
			return Insured.doCheckinsuredKind();
//	    }
	 },
	 doCheckinsuredKind	:function (){
	       var comCode=document.getElementById("comCode"); 
	       var flag=true;
	       if(comCode!=null&&comCode.value.substring(0,2)=="31"){
			   var identifyType=document.getElementById("_identifyType").value;
           	   if(!(identifyType=="01"||identifyType=="02"||identifyType=="03"||identifyType=="553")){
           		    var strKind="";
           		    if(ItemKind.kindIsExists("051047")){
           			    strKind+='051047'; 
	           			if(confirm("本次操作将导致险别:"+strKind+"被删除，是否继续?")){
							var kinds = [];
							kinds = strKind.toString().split(',');
							var kindsLength =kinds.length ;
							for(var i = 0;i<kindsLength;i++){
								ItemKind.deleteKind(kinds[i]);
								ItemKind.checkAllKind();
								ItemCar.doCheckProfits();
							}
						}else {
							flag= false;
						}
           		    }
           	   }
           	  
          }
	      return flag;
	 },
	 checkKindInsured:function (){
		    var comCode=document.getElementById("comCode");
		    var flag=true;
		    if(comCode!=null&&comCode.value.substring(0,2)=="31"){
			    var index = document.getElementById("hidden_index_insured").value;
				var len = parseInt(globalindex["insertInsuredRow"]);
				var _bizType=document.getElementById("bizType");
	 			if(isNaN(len)&&parseInt(index)!=0){
		 			len = parseInt(index);
	 			}	
	 			if(len != null) {
	 				for(var j=0;j<len;j++){
	 					 var insuredFlag = document.getElementById("prpCinsureds["+j+"].insuredFlag");
	 					 var identifyType=document.getElementById("prpCinsureds["+j+"].identifyType");
	 					 var flagValue=document.getElementById("prpCinsureds["+j+"].flag");
	 					 if(insuredFlag!=null&&insuredFlag.value.substring(2,3)=='1'){
	 						 if(_bizType.value == "ENDORSE"){
	 				   		     if(flagValue.value.substring(0,1)=="B"||flagValue.value.substring(0,1)=="D"){
	 				   		      	 continue;
	 				   		     }
	 						 }   
	 			   		     if(identifyType!=null&&!(identifyType.value=="01"||identifyType.value=="02"||identifyType.value=="03"||identifyType.value=="553")){
	 			   		    	 flag=false
	 			   		    	 break;
	 			   		     }
	 					 }
	 	 			}
	 			}
		    }
		    return flag;
	 	},
		checkInsuredCode : function(){
			var comCode = document.getElementById("comCode").value;
			if("32".indexOf(comCode.substring(0,2)) > -1 && document.getElementById("bizType").value != "ENDORSE"){
				var ownerCode = "";
				var policyHolderCode = "";
				var index = document.getElementById("hidden_index_insured").value;
				var len = parseInt(globalindex["insertInsuredRow"]);
				if(isNaN(len)&& parseInt(index)!=0){
				    len = parseInt(index);
				}
				var owner = false;
				var policy = false;
				for(var i=0;i<len;i++){
					if(document.getElementById("prpCinsureds["+i+"].insuredFlag")!=null){
						insuredFlag = document.getElementById("prpCinsureds["+i+"].insuredFlag");
						if(insuredFlag != null && insuredFlag.value.substring(2,3)=="1"){
							// 车主
							ownerCode = document.getElementById("prpCinsureds["+i+"].insuredCode").value;
							owner = true;
						}
						if(insuredFlag != null && insuredFlag.value.substring(0,1)=="1"){
							// 投保人
							policyHolderCode = document.getElementById("prpCinsureds["+i+"].insuredCode").value;
							policy = true;
						}
						if(ownerCode != "" && policyHolderCode != ""){
							break;
						}
					}
				}
				if(owner && policy && trim(ownerCode) != trim(policyHolderCode)){
					return false;
				}
			}
			return true;
		}
	};