<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../../top.jsp"></jsp:include>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
</head>
<style type="text/css">
table {
	
}

table tr td {
	height: 25px;
	padding-left: 10px;
	border-width: 1px 1px 1px 1px;
	border-style: groove;
}

table tr td input {
	height: 15px
}

table tr td.head-title {
	background-color: #F0F8FF;
	font-weight: bold;
}

table tr td.head-guide {
	background-color: #F0FFFF;
	font-weight: bold;
}

table tr td font.current-step {
	color: #EE4000;
}
</style>
<script type="text/javascript"
	src="<%=basePath%>/js/extendsValidator_1.0_20151215.js"></script>
</head>
<body>
	<div style="margin: 5px;" id="continer">
		<div id="title" name="title" class="easyui-panel" title="委托机构开通"
			style="background: #fafafa;" iconCls="icon-save" collapsible="false">
			<div style="padding-left: 5px; padding-right: 5px">
				<form id="merchDetaForm" action="merchant/saveMerchDeta"
					method="post">
					<input type="hidden" id="merchant_busiScan1" name="taxfile" /> <input
						type="hidden" id="merchant_busiScan2" name="licencefile" /> <input
						type="hidden" id="merchant_busiScan3" name="orgcodefile" /> <input
						type="hidden" id="merchant_busiScan4" name="corpfile" />
					<table width="100%">
						<tr>
							<td colspan="4" class="head-guide"><font
								class="current-step">第一步:企业信息录入</font>---->第二步:上传证件照片</td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td align="center" width="15%">企业名称</td>
							<td width="30%"><input id="merName" name="enterpriseName"
								required="true" maxlength="30" style="width: 250px"
								class="easyui-validatebox" validType="MerchLength[60]" /> <font
								color="red">*</font></td>
							<td colspan="2"></td>
						</tr>
						<tr>
							<td align="center">企业所在地</td>
							<td colspan="3"><select id="province_ins"
								class="easyui-validatebox" required="true" name="province"
								onchange="showCity('province_ins')" /></select> <select id="city_ins"
								class="easyui-validatebox" required="true" name="city"
								onchange="showCounty('city_ins')" /></select> <select id="county_ins"
								class="easyui-validatebox" required="true" name="street" /></select> <font
								color="red">*</font></td>
						</tr>
						<tr>
							<td align="center">联系手机号</td>
							<td><input class="easyui-validatebox" maxlength="11"
								validType="cellphonenum" required="true" name="phone" /> <font
								color="red">*</font></td>
							<td align="center" width="15%">邮箱</td>
							<td><input name="email" maxlength="32" validType="email"
								type="text" required="true" class="easyui-validatebox" /> <font
								color="red">*</font></td>
						</tr>
						<tr>
							<td align="center">地址</td>
							<td><input class="easyui-validatebox" maxlength="128"
								name="address" style="width: 300px" /></td>
							<td align="center">邮编编码</td>
							<td><input class="easyui-validatebox"
								validType="postcode[6]" maxlength="6" name="postCode" /></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<!--  
					<tr> 
						<td align="center">企业类型</td>
						<td> 企业</td><td></td><td></td>
					</tr>-->
						<tr>
							<td align="center">营业执照号</td>
							<td><input name="licenceNo" maxlength="18" type="text"
								validType="licencenoNewLength[15,18]" id="add_licenceNo"
								onkeyup="value=value.replace(/[^0-9a-zA-Z]/g,'')"
								required="true" class="easyui-validatebox" /><font color="red">*</font>
							</td>
							<td align="center">组织机构代码号</td>
							<td><input name="orgCode" maxlength="18" type="text"
								validType="orgNewLength[8,9,10,18]" id="add_orgCode"
								onkeyup="value=value.replace(/[^\d\-]/g,'')" required="true"
								class="easyui-validatebox" /> <font color="red">*</font></td>
						</tr>
						<tr>
							<td align="center">税务登记号</td>
							<td><input name="taxno" maxlength="20" type="text"
								required="true" validType="merLength[15]" id="add_taxno"
								onkeyup="value=value.replace(/[^0-9a-zA-Z]/g,'')"
								class="easyui-validatebox" /> <font color="red">*</font></td>
							<td align="center">所属行业</td>
							<td><select id="mcclist_ins" class="easyui-validatebox"
								name="mccList" required="true" /></select><font color="red">*</font></td>
						</tr>
						<tr>
							<td align="center">企业网站地址</td>
							<td><input name="website" maxlength="256" type="text"
								validType="url" required="true" class="easyui-validatebox" /> <font
								color="red">*</font></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td align="center" id="psamORpass">法人姓名</td>
							<td><input name="corporation" maxlength="16" type="text"
								required="true" class="easyui-validatebox" /> <font color="red">*</font></td>
							<td align="center">法人身份证号</td>
							<td><input class="easyui-validatebox" required="true"
								validType="cardNo[18]" maxlength="18" name="corpNo" /> <font
								color="red">*</font></td>
						</tr>

						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td align="center">委托机构清算类型</td>
							<td><select id="setltype_ins" class="easyui-validatebox"
								required="true" name="setlType" /></select> <font color="red">*</font></td>
							<td align="center">委托机构清算周期</td>
							<td><select id="setlcycle_ins" class="easyui-validatebox"
								required="true" name="setlCycle" /></select> <font color="red">*</font>
							</td>
						</tr>
						<tr>

							<td align="center">开户行</td>
							<td colspan="3"><select id="banknode_ins"
								class="easyui-validatebox" required="true" name="bankNode"
								style="width: 350px" /></select> <font color="red">*</font> <input
								id="banknode_key" maxlength="16" type="text"
								onclick="checkBankKey()" onchange="queryBankNode()" /></td>
						</tr>
						<tr>
							<td align="center">开户账号</td>
							<td><input name="accNum" maxlength="32" required="true"
								type="text" validType="settleAccount" class="easyui-validatebox" />
								<font color="red">*</font></td>
							<td align="center">开户名</td>
							<td><input class="easyui-validatebox" maxlength="30"
								validType="accName" required="true" name="accName" /> <font
								color="red">*</font></td>
						</tr>

						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td align="center">合作机构</td>
							<td><select id="coop_insti_ins" class="easyui-validatebox"
								required="true" name="coopInstiId" style="width: 150px"
								onchange="refreshProduct()" /></select> <font color="red">*</font></td>
							<td align="center">产品</td>
							<td><select id="prdtver_ins" class="easyui-validatebox"
								required="true" name="prdtVer" style="width: 150px"
								onchange="showThreeVersion()" /></select> <font color="red">*</font></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td align="center"><input type="checkbox" id="isDelegation"
								name="isDelegation" onchange="checkIsDelegation()" />是否授权人办理</td>
							<td colspan="3"></td>
						</tr>
						<tr id="delegation">
							<td align="center">委托人姓名</td>
							<td><input class="easyui-validatebox" maxlength="16"
								id="signatory" name="signatory" /> <font color="red">*</font></td>
							<td align="center">委托人身份证号</td>
							<td><input class="easyui-validatebox" validType="cardNo[18]"
								id="signCertNo" maxlength="18" name="signCertNo" /> <font
								color="red">*</font></td>
						</tr>
						<tr>
							<td align="center">客户经理</td>
							<td><input class="easyui-validatebox" maxlength="16"
								name="custMgr" /></td>
							<td align="center">客户经理部门</td>
							<td><input name="custMgrDept" maxlength="16" type="text" /></td>
						</tr>
						<tr>
							<td align="center">合约开始日期</td>
							<td><input name="agreemtStart" maxlength="12" type="date"
								id="startDate" /></td>
							<td align="center">合约终止日期</td>
							<td><input class="easyui-validatebox" maxlength="32"
								type="date" name="agreemtEnd" id="endDate" /></td>
						</tr>
						<tr>
							<td align="center">保证金</td>
							<td><input class="easyui-validatebox" maxlength="8"
								validType="amount" name="deposit" /><font color="red">元</font>
							</td>
							<td align="center">服务费</td>
							<td><input name="charge" maxlength="8" validType="amount"
								class="easyui-validatebox" type="text" /><font color="red">元</font>
							</td>
						</tr>

						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td align="center">联系人姓名</td>
							<td><input name="contact" maxlength="16" type="text"
								class="easyui-validatebox" />
							<td align="center">联系人地址</td>
							<td><input name="contAddress" maxlength="120"
								style="width: 250px" type="text" class="easyui-validatebox" />
							</td>
						</tr>
						<tr>
							<td align="center">联系人电话</td>
							<td><input class="easyui-validatebox" maxlength="11"
								validType="chinesetest" name="contPhone" /></td>
							<td align="center">联系人职位</td>
							<td><input name="contTitle" maxlength="16" type="text" /></td>
						</tr>
						<tr>
							<td align="center">联系人邮箱</td>
							<td><input class="easyui-validatebox" maxlength="16"
								validType="email" name="contEmail" /></td>
							<td colspan="2"></td>
						</tr>
					</table>
				</form>
				<div id="w" class="easyui-window" closed="true" title="My Window"
					iconCls="icon-save"
					style="width: 500px; height: 200px; padding: 5px;">
					<div class="easyui-layout" fit="true">
						<div region="center" border="false"
							style="border: 1px solid #ccc; background: #fff; border: 1px solid #ccc; text-align: center">
							<form id="theForm" action="merchant/upload" method="post"
								enctype="multipart/form-data">
								<input type="hidden" id="scanType" />
								<table width="100%" height="100%" cellpadding="2"
									cellspacing="2" border="0">
									<tr>
										<td align="right" id="uptitle"></td>
										<td align="left"><input style="height: 20px"
											id="imagehead" type="file" name="headImage"
											class="easyui-validatebox"></td>
									</tr>
								</table>
							</form>
						</div>
						<div region="south" border="false"
							style="text-align: center; padding: 5px 0;">
							<a class="easyui-linkbutton" iconCls="icon-save"
								href="javascript:uploadProcess()" id="btn_upload">上传</a> <a
								class="easyui-linkbutton" iconCls="icon-cancel"
								href="javascript:closeUpload()">取消</a>
						</div>
					</div>
				</div>
			</div>
			<div region="south" border="false"
				style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" id="button_id"
					href="javascript:savemerchDate()" onclick="">下一步</a> <a
					class="easyui-linkbutton" iconCls="icon-cancel"
					href="javascript:resize()" onclick="resize()">取消</a> <a
					href="javascript:backToMerchIndex()" class="easyui-linkbutton"
					iconCls="icon-back">返回</a>
			</div>
		</div>
	</div>
</body>

<script>
	  $(function() {
			showProvince();
			showMerchType();
			//showqueryTrade();
			showCoopInsti() ;
			showMccList();
			//showCash();
			showChnlname();
			//showMerchParent(); 
			showSetlcycleAll();
			showSetClearType();
			//showMccList();
			$('#startDate,#endDate').datebox({});
			$("#startDate,#endDate").datebox({ editable:false});
			queryBankNode();
			checkIsDelegation();
		});
		
		function loadOrgan() {
			var html = '<option value="">--请选择所属机构--</option>';
			$.ajax({
				type: "GET",
				url: "pages/pos/queryOrganfAction.action",
				data: "rand=" + new Date().getTime(),
				dataType: "json",
				success: function(json) {
					$.each(json,
					function(key, value) {
						html += '<option value="' + value.organId + '">' + value.organName + '</option>';
					});
					$("#dept_ins").html(html);
				}
			});
		}
		
		function savemerchDate() {				
			var jp = $("#banknode_ins").val(); 
			var add_licenceNo = $("#add_licenceNo").val();
			var add_orgCode = $("#add_orgCode").val();
			var add_taxno = $("#add_taxno").val();
			if(add_licenceNo.length == 18){
				if(add_licenceNo != add_orgCode && add_licenceNo != add_taxno ){
					$.messager.alert('提示',"税务登记号、营业执照号、组织机构代码输入不一致！");
					return false;
				}
			}
			if ($('#merchDetaForm').form("validate")) {
				$("#button_id").linkbutton('disable');
				$('#merchDetaForm').form('submit', {
					onSubmit: function() {
						return $('#merchDetaForm').form('validate');
					},
					success: function(json) {
						
						json = eval('(' + json + ')');
						$.each(json, function(key, value) {
							if (value.RET == "succ") {
								$("#button_id").linkbutton('enable');
								$.messager.confirm('提示', '保存成功,等待上传证件照片',function(data){
									if(data){
										window.location.href='merchant/toUpload?merchApplyId='+value.INFO;
									}
									
								});
							} else {
								$.messager.alert('提示', value.INFO);
								$("#button_id").linkbutton('enable');
							}
						});
					}
					
				});
			}
		}
		
		function showProvince() {
			$.ajax({
				type: "POST",
				url: "merchant/queryProvince",
				dataType: "json",
				success: function(json) {
					var province = $('#province_old').val();
					var html = "<option value=''>--请选择所属省--</option>";
					$.each(json,
					function(key, value) {
						//alert(value.roleName);
// 						html += '<option value="' + value.P_ID + '">' + value.P_NAME + '</option>';
						if(value.P_ID==province){
							html += '<option value="' + value.P_ID + '" selected="selected">' + value.P_NAME + '</option>';
						}else{
							html += '<option value="' + value.P_ID + '">' + value.P_NAME + '</option>';
						}
					}) ;
					$("#province_ins").html(html);
					$("#bnkProvince_ins").html(html);
				}
			});
		}
		
		function showCity(type) {
			var pid;
			if (type == 'province_ins') {
				pid = $("#province_ins").val();
			} else {
				pid = $("#bnkProvince_ins").val();
			}
		
			$.ajax({
				type: "POST",
				url: "merchant/queryCity",
				data: "pid=" + pid,
				dataType: "json",
				success: function(json) {
					var city = $('#city_old').val();
					var html = "<option value=''>--请选择所属市--</option>";
					$.each(json,
					function(key, value) {
						if(value.C_ID!=pid){
							html += '<option value="' + value.C_ID + '" selected="selected">' + value.C_NAME + '</option>';
						}else if(value.C_ID==city){
							html += '<option value="' + value.C_ID + '" selected="selected">' + value.C_NAME + '</option>';
						}
					});
					if (type == 'province_ins') {
						$("#city_ins").html(html);
					} else {
						$("#bnkCity_ins").html(html);
					}
		
				}
			});
		}
		function showCounty(type) {
			var pid;
			if (type == 'city_ins') {
				pid = $("#city_ins").val();
			} else {
				pid = $("#bnkCity_ins").val();
			}
			$.ajax({
				type: "POST",
				url: "merchant/queryCounty",
				data: "pid=" + pid,
				dataType: "json",
				success: function(json) {
					var county = $('#county_old').val();
					var html = "<option value=''>--请选择所属县--</option>";
					$.each(json,
					function(key, value) {
						if(value.T_ID==county){
							html += '<option value="' + value.T_ID + '" selected="selected">' + value.T_NAME + '</option>';
						}else{
							html += '<option value="' + value.T_ID + '">' + value.T_NAME + '</option>';
						}
						//alert(value.roleName);
// 						html += '<option value="' + value.T_ID + '">' + value.T_NAME + '</option>';
					});
					if (type == 'city_ins') {
						$("#county_ins").html(html);
					} else {
						$("#bnkStreet_ins").html(html);
					}
		
				}
			});
		}
		
		function checkBankKey(){
			var pid = $("#banknode_key").val();
			 if(pid=='输入关键字检索开户行'){
				$("#banknode_key").val('');
			}
			$("#banknode_key").css({color:"#515151"});
		}
		
		function queryBankNode() {
			var pid = $("#banknode_key").val();
			if(pid==null||pid==''){
				$("#banknode_key").val('输入关键字检索开户行');
				$("#banknode_key").css({color:"#BEBEBE"});
				return;
			} 
			$.ajax({
				type: "POST",
				url: "merchant/queryBankNode",
				data: "bankName=" + pid,
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择开户行--</option>";
					$.each(json,function(key, value) {
						var codenode = value.BANK_CODE + "," + value.BANK_NODE;
						html += '<option value="' + codenode + '">' + value.BANK_NAME + '</option>';
					});
					$("#banknode_ins").html(html);
				}
			});
		}
		
		function showMerchType(){
			$.ajax({
				type: "POST",
				url: "merchant/queryMerchType",
				data: "rand=" + new Date().getTime(),
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择委托机构类型--</option>";
					$.each(json,function(key, value) {
						html += '<option value="' + value.PARA_CODE + '">' + value.PARA_NAME + '</option>';
					}) ;
					$("#merchtype_ins").html(html);
		
				}
			});
		}
		function showMerchParent() {
			$.ajax({
				type: "POST",
				url: "merchant/showMerchParent",
				data: "rand=" + new Date().getTime(),
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择上级委托机构--</option>";
					$.each(json,
					function(key, value) {
						html += '<option value="' + value.MEMBERID + '">' + value.MERCHNAME + '</option>';
					}) ;
					$("#parent_ins").html(html);
		
				}
			});
		}
		
		function showMccList(){
			$.ajax({
				type: "POST",
				url: "merchant/queryMccList",
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--委托机构所属行业--</option>";
					$.each(json,
					function(key, value) {
						html += '<option value="' + value.MCCLIST + '">' + value.MCCCONT+'('+value.MCCLIST+')</option>';
					}) ;
					$("#mcclist_ins").html(html);
		
				}
			});
		}
		
		function resize() {
			$(':input').val("");
		}
		function showUpload(type) {
			$("#btn_upload").linkbutton('enable');
			var uploadTitle;
			if (type == 'busi') {
				uploadTitle = '上传税务登记证';
			} else if (type == 'licenceno') {
				uploadTitle = '上传营业执照';
			} else if (type == 'orgcode') {
				uploadTitle = '上传组织代码证';
			} else if (type == 'corpfile') {
				uploadTitle = '上传身份证照';
			} else if (type == 'union') {
				uploadTitle = '上传入网协议';
			} else if (type == 'shop') {
				uploadTitle = '上传门店照片';
			} else if (type == 'other') {
				uploadTitle = '上传全部附件';
			}
			$("#scanType").val(type);
			$("#uptitle").html(uploadTitle.substring(2));
			$('#w').window({
				title: uploadTitle,
				width: 400,
				modal: true,
				collapsible: false,
				minimizable: false,
				maximizable: false,
				shadow: false,
				closed: false,
				height: 120
			});
			cleanFile('imagehead');
			$('#imagehead').validatebox();
		}
		function closeUpload() {
			$('#w').window('close');
		}
		function uploadProcess() {
			var type = $("#scanType").val();
			if ($('#imagehead').validatebox("isValid")) {
				$("#btn_upload").linkbutton('disable');
				$('#theForm').ajaxSubmit({
		
					success: function(json) {
						json = eval('(' + json + ')');
		
						if (json.status == "OK") {
							$.messager.alert('提示', "上传成功");
							if (type == 'busi') {
								$("#merchant_busiScan1").val(json.fileName);
								//$("#taxfile_ins").val(json.fileName);
							} else if (type == 'licenceno') {
								$("#merchant_busiScan2").val(json.fileName);
								//$("#licencefile_ins").val(json.fileName);
							} else if (type == 'orgcode') {
								$("#merchant_busiScan3").val(json.fileName);
								//$("#orgcodefile_ins").val(json.fileName);
							} else {
								$("#merchant_busiScan4").val(json.fileName);
								//$("#corpfile_ins").val(json.fileName);
							}
							closeUpload();
						} else {
							var error = "上传失败";
							if (json.status == "file_over") {
								error = "上传失败，上传文件大小超过10M！";
							}
							$.messager.alert('提示', error);
							$("#btn_upload").linkbutton('enable');
						}
					}
				});
			}
		}
		function cleanFile(id) {
			/*alert("清除"+id);
					var _file = document.getElementById(id);    
					if(_file.files){        
						_file.value = "";    
					}else{        
						if (typeof _file != "object"){ 
							return null; 
						}        
						var _span = document.createElement("span");        
						_span.id = "__tt__";        
						_file.parentNode.insertBefore(_span,_file);        
						var tf = document.createElement("form");        
						tf.appendChild(_file);        
						document.getElementsByTagName("body")[0].appendChild(tf);        
						tf.reset();        
						_span.parentNode.insertBefore(_file,_span);        
						_span.parentNode.removeChild(_span);        
						_span = null;        
						tf.parentNode.removeChild(tf);    
					}*/
			var file = $("#" + id);
			file.after(file.clone().val(""));
			file.remove();
		}
		
		function showProduct(coopInstiId) {
			$.ajax({
				type: "POST",
				url: "merchant/queryProduct?coopInstiId="+coopInstiId,
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择产品--</option>";
					$.each(json,
					function(key, value) {
						html += '<option value="' + value.PRDTVER + '">' + value.PRDTNAME + '</option>';
					}) ;
					$("#prdtver_ins").html(html);
				}
			});
		}
		
		function showCash() {
			$.ajax({
				type: "POST",
				url: "merchant/queryCash",
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择收银台--</option>";
					$.each(json,
					function(key, value) {
						html += '<option value="' + value.CASHVER + '">' + value.CASHNAME + '</option>';
					});
					$("#cashver_ins").html(html);
				}
			});
		}
		
		function showChnlname() {
			$.ajax({
				type: "POST",
				url: "merchant/queryRouteAll",
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择路由版本--</option>";
					$.each(json,
					function(key, value) {
						html += '<option value="' + value.CHNLCODE + '">' + value.CHNLNAME + '</option>';
					});
					$("#routver_ins").html(html);
				}
			});
		}
		function showSetlcycleAll() {
			$.ajax({
				type: "POST",
				url: "merchant/querySetlcycleAll",
				data: "rand=" + new Date().getTime(),
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择清算周期--</option>";
					$.each(json,
					function(key, value) {
						html += '<option value="' + value.PARA_CODE + '">' + value.PARA_NAME + '</option>';
					});
					$("#setlcycle_ins").html(html);
		
				}
			});
		}
		
		function showCoopInsti() {
			$.ajax({
				type: "POST",
				url: "merchant/queryAll",
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择合作机构--</option>";
					$.each(json,
					function(key, value) {
						html += '<option value="' + value.ID + '">' + value.INSTI_NAME + '</option>';
					}) ;
					$("#coop_insti_ins").html(html);
				}
			});
		}
		
		function refreshProduct(){
			var coopInstiId = $("#coop_insti_ins").val();
			var html = "<option value=''>--请选择风控版本--</option>";
			$("#riskver").html(html);
			 html = "<option value=''>--请选择分润版本--</option>";
			$("#spiltver").html(html);
			html = "<option value=''>--请选择扣率版本--</option>";
			$("#feever_ins").html(html);
			if (coopInstiId != "" && coopInstiId != null) {
				showProduct(coopInstiId);
			}
		}
		
		function showThreeVersion() {
			var pid = $("#prdtver_ins").val();
			if (pid != "" && !pid != null) {
				queryDistType(pid);
				queryFee(pid);
				queryRiskType(pid)
			}
		}
		function queryRiskType(pid) {
			$.ajax({
				type: "POST",
				url: "merchant/queryRiskType?vid=" + pid,
				data: "rand=" + new Date().getTime(),
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择风控版本--</option>";
					$.each(json,
					function(key, value) {
						html += '<option value="' + value.RISKVER + '">' + value.RISKNAME + '</option>';
					});
					$("#riskver").html(html);
		
				}
			});
		}
		function queryDistType(pid) {
			$.ajax({
				type: "POST",
				url: "merchant/querySplit?vid=" + pid,
				data: "rand=" + new Date().getTime(),
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择分润版本--</option>";
					$.each(json,
					function(key, value) {
						html += '<option value="' + value.SPLITVER + '">' + value.SPLITNAME + '</option>';
					});
					$("#spiltver").html(html);
		
				}
			});
		}
		function queryFee(pid) {
			$.ajax({
				type: "POST",
				url: "merchant/queryFee?vid=" + pid,
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择扣率版本--</option>";
					$.each(json,
					function(key, value) {
						html += '<option value="' + value.FEEVER + '">' + value.FEENAME + '</option>';
					});
					$("#feever_ins").html(html);
				}
			});
		}
		function showSetClearType() {
			$.ajax({
				type: "POST",
				url: "merchant/queryMerchClearType",
				data: "rand=" + new Date().getTime(),
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择清算类型--</option>";
					$.each(json,
					function(key, value) {
						html += '<option value="' + value.PARA_CODE + '">' + value.PARA_NAME + '</option>';
					});
					$("#setltype_ins").html(html);
		
				}
			});
		}
		
		function checkIsDelegation(){
			var isDelegation = $('#isDelegation').prop("checked");
			if(isDelegation){
				$('#isDelegation').val(1);
				$('#delegation').show();
				$('#corpno').validatebox({required: true});
				$('#signatory').validatebox({required: true});
			}else{
				$('#isDelegation').val(0);
				$('#delegation').hide();
				$('#corpno').validatebox({required: false});
				$('#signatory').validatebox({required: false});
			}
		}
		
		function backToMerchIndex(){
			window.location.href= "<%=basePath%>" +'merchant/show';
		}
	</script>
</html>

