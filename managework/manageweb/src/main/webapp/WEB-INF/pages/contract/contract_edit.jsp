<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link href="<%=basePath%>js/uploadify/uploadify.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<%=basePath%>js/uploadify/jquery.uploadify.min.js"></script>
<style type="text/css">
.left, .mid, .right {
	width: auto;
	float: left;
}

.form-control {
	border: 2px solid #A9C9E2;
}

.mid {
	padding-top: 45px;
	padding-left: 12px;
	padding-right: 12px;
}
</style>
<body>
	<style type="text/css">
table tr td.head-title {
	height: 25px;
	background-color: #F0F8FF;
	font-weight: bold;
}
table tr td.update {
	height: 25px;
	padding-left: 10px;
	border-width: 1px 1px 1px 1px;
	border-style: groove;
}
table tr td.add {
	height: 25px;
}

table tr td input {
	height: 15px
}

table tr td select {
	height: 20px
}
</style>
	<div style="padding-top: 5px; margin-left: 5px; margin-right: 5px" id="continer">
		<div id="p" class="easyui-panel" title="查询条件" style="height: 130px;background: #fafafa;" iconCls="icon-save" collapsible="true">
			<form action="" id="searchForm">
				<table width="100%">
					<tr>
						<td class="add" align="right">委托机构号</td>
						<td class="add" align="left" style="padding-left: 5px"><input
							id="a_merchNo" name="merchNo" /></td>
						<td class="add" align="right">合同编号</td>
						<td class="add" align="left" style="padding-left: 5px"><input
							id="a_contractNum" name="contractNum" /></td>
					</tr>
					<tr>
						<td class="add" align="right">付款人名称</td>
						<td class="add" align="left" style="padding-left: 5px"><input
							id="a_debName" name="debName" /></td>
						<td class="add" align="right">付款人账号</td>
						<td class="add" align="left" style="padding-left: 5px"><input
							id="a_debBranchCode" name="debBranchCode" /></td>
					</tr>
					<tr>
						<td class="add" align="right">收款人名称</td>
						<td class="add" align="left" style="padding-left: 5px"><input
							id="a_credName" name="credName" /></td>
						<td class="add" align="right">收款人账号</td>
						<td class="add" align="left" style="padding-left: 5px"><input
							id="a_credAccNo" name="credAccNo" /></td>
						<td class="add" align="right" colspan="3"><a href="javascript:search()"
							class="easyui-linkbutton" iconCls="icon-search">查询</a> <a
							href="javascript:resize()" class="easyui-linkbutton"
							iconCls="icon-redo">清空</a></td>
							<td class="add" align="right"></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="bankList">
			</table>
		</div>
	</div>
	<div id="w2" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 400px; padding: 10px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="b_saveForm" action="" method="post">
					<input type="hidden" id="b_tId" name="tId"/> 
					<input type="hidden" id="b_fileAddress" name="fileAddress"/> 
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 30px">
							<td width="18%" class="update">委托机构号</td>
							<td align="left" class="update"><span id="b_merchNo"></span></td>
							<td width="18%" class="update">合同编号 </td>
							<td align="left" class="update"><span id="b_contractNum"></span></td>
						</tr>
<!-- 						<tr style="height: 30px"> -->
<!-- 							<td class="update">业务类型</td> -->
<!-- 							<td align="left" class="update"><span id="b_categoryPurpose"></span></td> -->
<!-- 							<td class="update">业务种类</td> -->
<!-- 							<td align="left" class="update"><span id="b_proprieTary"></span></td> -->
<!-- 						</tr> -->
						<tr style="height: 30px">
							<td class="update">合同类型</td>
							<td align="left" class="update"><span id="b_contractType"></span></td>
							<td class="update"></td>
							<td align="left" class="update"></span></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">付款人名称</td>
							<td align="left" class="update"><span id="b_debName"></span></td>
							<td class="update">付款人账号 </td>
							<td align="left" class="update"><span id="b_debAccNo"></span></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">付款行银行全称</td>
							<td align="left" class="update"><span id="b_debBranchCode"></span></td>
							<td class="update">单笔金额上限 </td>
							<td align="left" class="update"><span id="b_debAmoLimit"></span></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">金额限制类型</td>
							<td align="left" class="update"><span id="b_debTranLimitType"></span></td>
							<td class="update">累计金额上限</td>
							<td align="left" class="update"><span id="b_debAccyAmoLimit"></span></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">付款次数限制类型</td>
							<td align="left" class="update"><span id="b_debTransLimitType"></span></td>
							<td class="update">付款次数限制</td>
							<td align="left" class="update"><span id="b_debTransLimit"></span></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">收款人名称</td>
							<td align="left" class="update"><span id="b_credName"></span></td>
							<td class="update">收款人账号 </td>
							<td align="left" class="update"><span id="b_credAccNo"></span></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">收款行银行全称</td>
							<td align="left" class="update"><span id="b_credBranchCode"></span></td>
							<td class="update">单笔金额上限 </td>
							<td align="left" class="update"><span id="b_credAmoLimit"></span></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">金额限制类型</td>
							<td align="left" class="update"><span id="b_credTranLimitType"></span></td>
							<td class="update">累计金额上限</td>
							<td align="left" class="update"><span id="b_credAccuAmoLimit"></span></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">收款次数限制类型</td>
							<td align="left" class="update"><span id="b_credTransLimitType"></span></td>
							<td class="update">收款次数限制</td>
							<td align="left" class="update"><span id="b_credTransLimit"></span></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 30px">
							<td align="center" class="update">合约开始日期</td>
							<td align="left" class="update"><span id="b_startDate"></span></td>
							<td align="center" class="update">合约终止日期</td>
							<td align="left" class="update"><span id="b_endDate"></span></td>
						</tr>
						<tr id="b_delegation" style="height: 30px">
							<td class="update">收费代码</td>
							<td class="update" align="left"><span id="b_chargeNo"></span></td>
							<td class="update">收费协议号</td>
							<td class="update" align="left"><span id="b_chargeConntract"></span></td>
						</tr>
						<tr style="height: 30px">
							<td align="center" class="update">合同附件</td>
							<td align="left" class="update"><div id="signfileOpp_span"></div></td>
							<td id="b_delegation2" class="update">付费协议号</td>
							<td id="b_delegation3" class="update" align="left"><span id="b_payContract"></span></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">备注</td>
							<td align="left" colspan="3" class="update"><span id="b_notes" rows="3" cols="81" style="resize: none;"></span></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a href="javascript:merchAudit('0');" id="button_ins1" class="easyui-linkbutton" iconCls="icon-ok">通过</a>
				<a href="javascript:merchAudit('1');" id="button_ins3" class="easyui-linkbutton" iconCls="icon-no">不通过</a>
				<a class="easyui-linkbutton" iconCls="icon-back" onclick="closeAdd()">返回</a>
			</div>
		</div>
	</div>
</body>
</body>
<script>
  	var width = $("#continer").width();
		$(function(){
			$('#bankList').datagrid({
				title:'合同列表',
				iconCls:'icon-save',
				height:600,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'contract/queryAudit',
				remoteSort: false,
				columns:[[
					{field:'MERCHNO',title:'委托机构号',align:'center',width:130},
					{field:'CONTRACTNUM',title:'合同编号',width:130,align:'center'},
					{field:'DEBTORNAME',title:'付款人名称',align:'center',width:100},
					{field:'CREDITORNAME',title:'收款人名称',width:120,align:'center'},
					{field:'CONTRACTTYPE',title:'合同类型',width:100,align:'center',
						formatter:function(value,rec){
							if(value=="CT00"){
								return "批量代收协议";
							}else if(value=="CT01"){
								return "批量代付协议";
							}else if(value=="CT02"){
								return "实时代收协议";
							}else if(value=="CT03"){
								return "实时代付协议";
							}
						}
					},
					{field:'STATUS',title:'状态',width:60,align:'center',
						formatter:function(value,rec){
							if(value=="00"){
								return "有效";
							}else if(value=="10" || value=="20"){
								return "待审";
							}else if(value=="19" || value=="29"){
								return "审核未通过";
							}else if(value=="89"){
								return "过期失效";
							}else if(value=="99"){
								return "撤销";
							}
						}
					},
					{field:'TID',title:'操作',align:'center',width:160,rowspan:2,
						formatter:function(value,rec){
							if(rec.STATUS=="00"){
								return '<a href="javascript:deleteUser('+value+')" style="color:blue;margin-left:10px">注销</a>'+
								'<a href="javascript:findById('+value+')" style="color:blue;margin-left:10px">详情</a>'
							}else if(rec.STATUS=="10" || rec.STATUS=='20'){
								return '<a href="javascript:findById('+value+')" style="color:blue;margin-left:10px">审核</a>';
							}
						}}
					]],
				pagination:true,
				rownumbers:true
			});
		});

		function resize(){
			$('#searchForm :input').val('');
		}
		
		function closeAdd(){
			$('#w').window('close');
			$('#w2').window('close');
			$('#w3').window('close');
			
		}		
		function search(){
			var data={'merchNo':$('#a_merchNo').val(),'contractNum':$('#a_contractNum').val(),
					'debName':$("#a_debName").val(),'credName':$("#a_credName").val(),
					'debBranchCode':$("#a_debBranchCode").val(),'credAccNo':$("#a_credAccNo").val()};
			$('#bankList').datagrid('load',data);
		}
		function findById(tId){
			$.ajax({
			   type: "POST",
			   url: "contract/findById",
			   data: "tId="+tId,
			   async: false,
			   dataType:"json",
			   success: function(json){
				   var tId = json.tId;
				   $("#b_tId").val(json.tId);
				   $("#b_merchNo").html(json.merchNo);
				   $("#b_contractNum").html(json.contractNum);
				   $("#b_debName").html(json.debName);
				   $("#b_debAccNo").html(json.debAccNo);
				   showBranchCode('find',json.debBranchCode);
// 				   $("#b_debBranchCode").html(json.debBranchCode);
				   $("#b_credName").html(json.credName);
				   $("#b_credAccNo").html(json.credAccNo);
				   var contractType;
				   if(json.contractType == 'CT00'){
					   contractType = '批量代收协议';
				   }else if(json.contractType == 'CT01'){
					   contractType = '批量代付协议';
				   }else if(json.contractType == 'CT02'){
					   contractType = '实时代收付协议';
				   }else if(json.contractType == 'CT03'){
					   contractType = '实时代收付协议';
				   }
				   $("#b_contractType").html(contractType);
				   $("#b_contractType").val(json.contractType);
				   showBranchCode('find_a',json.credBranchCode);
// 				   $("#b_credBranchCode").html(json.credBranchCode);
				   $("#b_debAmoLimit").html(json.debAmoLimit);
 				   var debTranLimitType;
				   if(json.debTranLimitType == '00'){
					   debTranLimitType = '--不限--';
				   }else if(json.debTranLimitType == '01'){
					   debTranLimitType = '按年限次';
				   }else if(json.debTranLimitType == '02'){
					   debTranLimitType = '按月限次';
				   }else if(json.debTranLimitType == '03'){
					   debTranLimitType = '总计限次';
				   }
				   $("#b_debTranLimitType").html(debTranLimitType);
				   $("#b_debAccyAmoLimit").html(json.debAccyAmoLimit);
				   var debTransLimitType;
				   if(json.debTransLimitType == '00'){
					   debTransLimitType = '--不限--';
				   }else if(json.debTransLimitType == '01'){
					   debTransLimitType = '按年限次';
				   }else if(json.debTransLimitType == '02'){
					   debTransLimitType = '按月限次';
				   }else if(json.debTransLimitType == '03'){
					   debTransLimitType = '总计限次';
				   }
				   $("#b_debTransLimitType").html(debTransLimitType);
				   $("#b_debTransLimit").html(json.debTransLimit);
				   $("#b_credAmoLimit").html(json.credAmoLimit);
				   var credTranLimitType;
				   if(json.credTranLimitType == '00'){
					   credTranLimitType = '--不限--';
				   }else if(json.credTranLimitType == '01'){
					   credTranLimitType = '按年限次';
				   }else if(json.credTranLimitType == '02'){
					   credTranLimitType = '按月限次';
				   }else if(json.credTranLimitType == '03'){
					   credTranLimitType = '总计限次';
				   }
				   $("#b_credTranLimitType").html(credTranLimitType);
				   $("#b_credAccuAmoLimit").html(json.credAccuAmoLimit);
				   var credTransLimitType;
				   if(json.credTransLimitType == '00'){
					   credTransLimitType = '--不限--';
				   }else if(json.credTransLimitType == '01'){
					   credTransLimitType = '按年限次';
				   }else if(json.credTransLimitType == '02'){
					   credTransLimitType = '按月限次';
				   }else if(json.credTransLimitType == '03'){
					   credTransLimitType = '总计限次';
				   }
				   $("#b_credTransLimitType").html(credTransLimitType);
				   $("#b_credTransLimit").html(json.credTransLimit);
				   $("#b_startDate").html(json.signDate);
				   $("#b_endDate").html(json.expiryDate);
				   $("#b_notes").html(json.notes);
				   $("#b_fileAddress").html(json.fileAddress);
				   $("#proprieTary").html(json.proprieTary);
				   $("#categoryPurpose").html(json.categoryPurpose);
				   initCertUrl(tId);
				   checkIsDelegation();
			   }
			});
			$('#w2').window({
				title: '合同详情',
				top:100,
				width: 800,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 650
			});
		}

		$(function(){
			$("input[id*='_cert_img']").each(function(){
				  var tId = $("#b_tId");
				  var _this = $(this);
				  var id = _this.attr('id');
				  var certType = id.substring(0,id.indexOf('_cert_img'));
				  var certSpan = $('#fileAddress_span');
				  $(this).uploadify({
						'auto' : true,
						'swf' : '<%=basePath%>js/uploadify/uploadify.swf', 
						'uploader': '<%=basePath%>contract/fileUpload',
						'formData' : {'tId':tId,'fileAddress':fileAddress},
						'fileObjName': 'headImage',
						 'method'   : 'post',
						//可选  
// 						'height': 20,
						//可选  
						'width': 120,
						//设置允许上传的文件格式  
// 						'fileExt'   : '*.jpg;*.gif;*.png',  
						//设置允许上传的文件格式后，必须加上下面这行代码才能帮你过滤  
						//'fileDesc'    : 'Image Files',  
						//允许连续上传多个文件  
						'multi': 'false',
						//一次性最多允许上传多少个,不设置的话默认为999个  
						'queueSizeLimit': 1,
						//每个文件允许上传的大小(字节)  
						'sizeLimit'   : 1024*1024*10,  //1M=1024K=1024*1024Byte
						'buttonText'     : '选择文件' ,
						'onUploadError' : function(file, errorCode, errorMsg, errorString) {
							$.messager.alert('提示', '上传失败');
				        },
						 'onUploadSuccess' : function(file, data, response) {
					         	var isSucc = false;   
					         	var retInfo;
					         	jsonRet = eval('(' + data + ')');
					         	var URL =jsonRet.path;
						 		$("#fileAddress").val(URL);
							 	if(!response||data.indexOf("status")==-1){
							 		isSucc = false; 
					            }else{
						            
						            if(jsonRet.status=='OK'){
						            	isSucc = true;  
						            }
					            }
							 	if(isSucc){
							 		retInfo = "上传成功";
							 		certSpan.html('<a href="'+URL+'" target="view_window" style="font-size: 12px;color:blue">点击查看</a>');
							 	}else{retInfo = "上传失败";}
							 	
					            $.messager.alert('提示', retInfo);
					    }, 
				        'onFallback' : function() {
				        	$.messager.alert('提示', '检测到flash控件不可用,请确认当前浏览器支持flash控件');
				        }
					});
			});
		  });
		function initCertUrl(tId){
			var certSpan = $('#signfileOpp_span');
			$.ajax({
				type: "POST",
				url: "contract/downloadImgUrl",
				data: "tId=" + tId,
				dataType: "json",
				success: function(json) {
					 if(json.status=='OK'){
						 var URL = json.url;
						 certSpan.html('<a href="'+URL+'" target="view_window" style="font-size: 12px;color:blue">点击查看</a>');
					 }else if(json.status=='notExist'){
						 certSpan.html('暂无可查看文件');
					 } else{
						 certSpan.html('查询失败');
					 }
				}
			}); 
		}
		
		function merchAudit(result) {
			$("#button_ins1").linkbutton('disable');
			$("#button_ins3").linkbutton('disable');
			var tId = $("#b_tId").val();
			var stexaOpt = $("#STOPINION").val();
			$.ajax({
				type: "POST",
				url: "contract/audit?isAgree=" + result + "&tId=" + tId,
				data: "stexaOpt=" + encodeURI(stexaOpt),
				dataType: "json",
				success: function(json) {
			    	$.each(json, function(key,value){
			    		if(value.RET == "succ"){
		    				$.messager.alert('提示',"操作成功!");
			    			search();
				    		closeAdd();
				    	}else{
				    		$.messager.alert('提示',value.INFO); 
				    		search();
				    		closeAdd();
				    	}
			    		$("#button_ins1").linkbutton('enable');
						$("#button_ins3").linkbutton('enable');		
					}) 
				}
			});
		}
		function checkIsDelegation(){
			var isDelegation = $('#b_contractType').val();
			if(isDelegation == "CT00"){
				$('#b_delegation').show();
				$('#b_delegation2').hide();
				$('#b_delegation3').hide();
			}else if(isDelegation == "CT01"){
				$('#b_delegation').hide();
				$('#b_delegation2').show();
				$('#b_delegation3').show();
			}else{
				$('#b_delegation').hide();
				$('#b_delegation2').hide();
				$('#b_delegation3').hide();
			}
		}
		function showBranchCode(type,value){ 
			$.ajax({
			   type: "POST",
			   url: "bankaccout/queryBankInfo",
			   data: "bankNode="+value,
			   async: false,
			   dataType:"json",
			   success: function(json){	
				    var result = json.bankName;
				    if(type == 'find') {
		 				$("#b_debBranchCode").html(result);
		 			} else if(type == 'find_a'){
		 				$("#b_credBranchCode").html(result);
		 			}
			     }
			});
		}
	</script>
</html>
