<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="<%=basePath%>/js/extendsValidator_1.0_20151215.js"></script>
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
	border-width: 1px 1px 1px 1px;
	border-style: groove;
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
	height: 15px;
}

table tr td select {
	height: 20px
}
</style>
	<div style="padding-top: 5px; margin-left: 5px; margin-right: 5px"
		id="continer">
		<div id="p" class="easyui-panel" title="查询条件"
			style="height: 130px; padding-top: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form action="" id="searchForm">
				<table width="100%">
					<tr>
						<td class="add" align="right">委托机构号</td>
						<td class="add" align="left" style="padding-left: 5px"><input
							id="a_merchNo" name="merchNo" /></td>
						<td class="add" align="right">公司全称</td>
						<td class="add" align="left" style="padding-left: 5px"><input
							id="a_companyName" name="companyName" /></td>
					</tr>
					<tr>
						<td class="add" align="right">纳税人识别号</td>
						<td class="add" align="left" style="padding-left: 5px"><input
							id="a_taxPayerId" name="taxPayerId" /></td>
						<td class="add" align="right">开户银行账号</td>
						<td class="add" align="left" style="padding-left: 5px"><input
							id="a_accountNo" name="accountNo" /></td>
						
						<td class="add" align="right" colspan="3">
							<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a> 
							<a href="javascript:resize()" class="easyui-linkbutton"iconCls="icon-redo">清空</a></td>
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
	<div id="w" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 400px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; font-size: 12px; text-align: center">
				<form id="saveForm" action="merchTax/save" method="post">
					<input type="hidden" id="bankProvince" name="documenEvidence" />
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr style="height: 25px">
							<td class="update" width="15%">公司全称</td>
							<td class="update" align="left">
							<input type="text" id="companyName" name="companyName" class="easyui-validatebox" required="true"
								maxlength="128" missingMessage="请输入公司全称" validType="debName[]"/></td>
							<td class="update">委托机构号</td>
							<td class="update" align="left">
							<input type="text" id="merchNo" name="merchNo" class="easyui-validatebox" required="true"
								maxlength="15" missingMessage="请输入委托机构号" validType="merchno[]"/></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">纳税人识别号</td>
							<td class="update" align="left">
							<input type="text" id="taxPayerId" name="taxPayerId" class="easyui-validatebox" required="true"
								maxlength="32" missingMessage="请输入纳税人识别号"/></td>
							<td class="update">开户银行账号</td>
							<td class="update" align="left">
							<input type="text" id="accountNo" name="accountNo" class="easyui-validatebox" required="true"
								maxlength="32" missingMessage="请输入开户银行全称" validType="bankcard[]"/></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">公司地址</td>
							<td class="update" align="left">
							<input type="text" id="companyAddress" name="companyAddress" class="easyui-validatebox" required="true"
								maxlength="256" missingMessage="请选择公司地址" validType="debName[]"/></td>
							<td class="update">公司电话</td>
							<td class="update" align="left">
							<input type="text" id="compaynTelno" name="compaynTelno" class="easyui-validatebox" required="true"
								maxlength="32" missingMessage="请选择公司电话"/></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">开户银行全称</td>
							<td class="update" align="left" colspan="3">
							<select id="banknode_ins" maxlength="64" class="easyui-validatebox" required="true" name="bankName" 
							missingMessage="请输入开户行" style="width: 320px"/><option value=''>--请选择开户行--</option></select><font color="red">*</font>
							<input id="banknode_key" maxlength="16" type="text" onclick="checkBankKey('add')" onchange="queryBankNode('add')"/></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">增值税纳税人类型</td>
							<td class="update" align="left">
							<select id="taxpanyerType" class="easyui-validatebox" missingMessage="请选择增值税纳税人类型"
								required="true" name="taxpanyerType">
									<option value=''>--请选择增值税类型--</option>
									<option value='01'>一般纳税人</option>
									<option value='02'>小规模纳税人</option>
							</select></td>
							<td class="update">增值税发票类型</td>
							<td class="update" align="left">
							<select id="invoiceType" class="easyui-validatebox" missingMessage="请选择增值税发票类型"
								required="true" name="invoiceType">
									<option value=''>--请选择发票类型--</option>
									<option value='01'>专用发票</option>
									<option value='02'>普通发票</option>
							</select></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">增值税证明文件</td>
							<td class="update" align="left" colspan="3">&nbsp;&nbsp;&nbsp;
								<input type="checkbox" id="ebidence_1" name="documen" style="align:center" value="01"/>&nbsp;&nbsp;&nbsp;资格证书&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox" id="ebidence_2" name="documen" style="align:center" value="02"/>&nbsp;&nbsp;&nbsp;税务登记证&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox" id="ebidence_3" name="documen" style="align:center" value="03"/>&nbsp;&nbsp;&nbsp;五证合一 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
						<tr style="height: 25px">
							<td class="update">财务部联系人</td>
							<td class="update" align="left">
							<input type="text" id="contAct" name="contAct" class="easyui-validatebox" required="true"
								maxlength="32" missingMessage="请输入联系人" validType="debName[]"/></td>
							<td class="update">财务部联系人电话</td>
							<td class="update" align="left">
							<input type="text" id="contPhone" name="contPhone" class="easyui-validatebox" required="true"
								maxlength="32" missingMessage="请输入联系人电话" validType="cellphonenum[]"/></td>
						</tr>
						
						<tr style="height: 25px">
							<td class="update">备注</td>
							<td class="update" align="left" colspan="3">
							<textarea rows="3" cols="81" id="notes" maxlength="512" name="notes" style="resize: none;"
									onkeyup="value=value.replace(/<[^<]+>/g,'')"></textarea></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveUser()" id="btn_submit" onclick="">提交</a>
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeAdd()">返回</a>
			</div>
		</div>
	</div>
	<div id="w2" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 400px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; font-size: 12px; text-align: center">
				<form id="b_saveForm" action="merchTax/eidtBankAccount" method="post">
					<input type="hidden" id="b_tId" name="tId" /> 
					<input type="hidden" id="bankProvince" name="documenEvidence" />
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr style="height: 25px">
							<td class="update" width="15%">公司全称</td>
							<td class="update" align="left">
							<input type="text" id="b_companyName" name="companyName" class="easyui-validatebox" required="true"
								maxlength="128" missingMessage="请输入公司全称" validType="debName[]"/></td>
							<td class="update">委托机构号</td>
							<td class="update" align="left">
							<input type="text" id="b_merchNo" name="merchNo" class="easyui-validatebox" required="true"
								maxlength="15" missingMessage="请输入委托机构号" validType="merchno[]"/></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">纳税人识别号</td>
							<td class="update" align="left">
							<input type="text" id="b_taxPayerId" name="taxPayerId" class="easyui-validatebox" required="true"
								maxlength="32" missingMessage="请输入纳税人识别号"/></td>
							<td class="update">开户银行账号</td>
							<td class="update" align="left">
							<input type="text" id="b_accountNo" name="accountNo" class="easyui-validatebox" required="true"
								maxlength="32" missingMessage="请输入开户银行账号" validType="bankcard[]"/></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">公司地址</td>
							<td class="update" align="left">
							<input type="text" id="b_companyAddress" name="companyAddress" class="easyui-validatebox" required="true"
								maxlength="256" missingMessage="请选择公司地址" validType="debName[]"/></td>
							<td class="update">公司电话</td>
							<td class="update" align="left">
							<input type="text" id="b_compaynTelno" name="compaynTelno" class="easyui-validatebox" required="true"
								maxlength="32" missingMessage="请选择公司电话"/></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">开户银行全称</td>
							<td class="update" align="left" colspan="3">
							<select id="b_banknode_ins" maxlength="64" class="easyui-validatebox" required="true" style="width: 320px" 
							missingMessage="请输入开户行" name="bankName"/><option value=''>--请选择开户行--</option></select><font color="red">*</font>
							<input id="b_banknode_key" maxlength="16" type="text" onclick="checkBankKey('update')" onchange="queryBankNode('update')"/></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">增值税纳税人类型</td>
							<td class="update" align="left">
							<select id="b_taxpanyerType" class="easyui-validatebox" missingMessage="请选择增值税纳税人类型"
								required="true" name="taxpanyerType">
									<option value=''>--请选择增值税类型--</option>
									<option value='01'>一般纳税人</option>
									<option value='02'>小规模纳税人</option>
							</select></td>
							<td class="update">增值税发票类型</td>
							<td class="update" align="left">
							<select id="b_invoiceType" class="easyui-validatebox" missingMessage="请选择增值税发票类型"
								required="true" name="invoiceType">
									<option value=''>--请选择发票类型--</option>
									<option value='01'>专用发票</option>
									<option value='02'>普通发票</option>
							</select></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">增值税证明文件</td>
							<td class="update" align="left" colspan="3">&nbsp;&nbsp;&nbsp;
								<input type="checkbox" id="b_ebidence_1" name="b_documen" style="align:left" value="01"/>&nbsp;&nbsp;&nbsp;资格证书&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox" id="b_ebidence_2" name="b_documen" style="align:left" value="02"/>&nbsp;&nbsp;&nbsp;税务登记证&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox" id="b_ebidence_3" name="b_documen" style="align:left" value="03"/>&nbsp;&nbsp;&nbsp;五证合一 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
						<tr style="height: 25px">
							<td class="update">财务部联系人</td>
							<td class="update" align="left">
							<input type="text" id="b_contAct" name="contAct" class="easyui-validatebox" required="true"
								maxlength="32" missingMessage="请输入联系人" validType="debName[]"/></td>
							<td class="update">财务部联系人电话</td>
							<td class="update" align="left">
							<input type="text" id="b_contPhone" name="contPhone" class="easyui-validatebox" required="true"
								maxlength="32" missingMessage="请输入联系人电话" validType="cellphonenum[]"/></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">备注</td>
							<td class="update" align="left" colspan="3">
							<textarea rows="3" cols="81" id="b_notes" maxlength="512" name="notes" style="resize: none;"
									onkeyup="value=value.replace(/<[^<]+>/g,'')"></textarea></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveBank()" id="b_btn_submit" onclick="">提交</a>
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeAdd()">返回</a>
			</div>
		</div>
	</div>
	<div id="w3" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 400px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; font-size: 12px; text-align: center">
				<form id="" action="" method="post">
					<input type="hidden" id="d_tId" name="tId" value="${json.tId}"/> 
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update" width="18%">公司全称</td>
							<td class="update" align="left" width="28%"><span id="d_companyName"></span></td>
							<td class="update" width="18%">委托机构号</td>
							<td class="update" align="left" width="28%"><span id="d_merchNo"></span></td>
						</tr>
						<tr style="height: 25px">	
							<td class="update">纳税人识别号</td>
							<td class="update" align="left"><span id="d_taxPayerId"></span></td>
							<td class="update">开户银行账号</td>
							<td class="update" align="left"><span id="d_accountNo"></span></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">公司地址</td>
							<td class="update" align="left"><span id="d_companyAddress"></span></td>
							<td class="update">公司电话</td>
							<td class="update" align="left"><span id="d_compaynTelno"></span></td>
						</tr>
						
						<tr style="height: 25px">
							<td class="update">开户银行全称</td>
							<td class="update" align="left"  colspan="3"><span id="d_bankName"></span></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">	
							<td class="update">纳税人类型</td>
							<td class="update" align="left"><span id="d_taxpanyerType"></span></td>
							<td class="update">发票类型</td>
							<td class="update" align="left"><span id="d_invoiceType"></span></td>
						</tr>
						<tr style="height: 25px">	
							<td class="update">证明文件</td>
							<td class="update" align="left"  colspan="3"><span id="d_documenEvidence"></span></td>
						</tr>
						<tr style="height: 25px">	
							<td class="update">财务部联系人</td>
							<td class="update" align="left"><span id="d_contAct"></span></td>
							<td class="update">财务部联系人电话</td>
							<td class="update" align="left"><span id="d_contPhone"></span></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">备注</td>
							<td align="left" colspan="3" class="update"><span id="d_notes" rows="3" cols="81" style="resize: none;"></span></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeAdd()">返回</a>
			</div>
		</div>
	</div>
</body>
<script>
  	var width = $("#continer").width();
		$(function(){
			$('#bankList').datagrid({
				title:'委托机构发票信息列表',
				iconCls:'icon-save',
				height:600,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'merchTax/query',
				remoteSort: false,
				columns:[[
					{field:'MERCHNO',title:'委托机构号',align:'center',width:130},
					{field:'COMPANYNAME',title:'公司全称',width:130,align:'center'},
					{field:'TAXPAYERID',title:'纳税人识别号',width:130,align:'center'},
					{field:'BANKNAME',title:'开户银行全称',align:'center',width:250},
					{field:'ACCOUNTNO',title:'开户银行账号',width:120,align:'center'},
					{field:'TAXPAYERTYPE',title:'纳税人类型',width:100,align:'center'},
					{field:'INVOICETYPE',title:'发票类型',width:100,align:'center'},
					{field:'STATUS',title:'状态',width:60,align:'center',
						formatter:function(value,rec){
							if(value=="00"){
								return "正常";
							}else{
								return "注销";
							}
						}
					},
					{field:'TID',title:'操作',align:'center',width:120,rowspan:2,
						formatter:function(value,rec){
							if(rec.STATUS=="00"){
								return '<a href="javascript:showUser('+value+')" style="color:blue;margin-left:10px">修改</a>'+
								'<a href="javascript:deleteUser('+value+')" style="color:blue;margin-left:10px">注销</a>'+
								'<a href="javascript:findById('+value+')" style="color:blue;margin-left:10px">详情</a>'
							}else{
								return '';
							}
							
					}}
				]],
				pagination:true,
				rownumbers:true,
				toolbar:[{
					id:'btnadd',
					text:'新增发票信息',
					iconCls:'icon-add',
					handler:function(){
						$("#user_code").removeAttr('readonly');
						showAdd(0);
						$("#saveForm").attr("action","merchTax/save");
					}
				}]
			});
		});

		function resize(){
			$('#searchForm :input').val('');
		}
		
		function showAdd(num){
			$("#saveForm").attr("action","merchTax/save");
			$('#saveForm :input').val('');
			$("#banknode_ins").val('');
			$("#ebidence_1").val("01");
			$("#ebidence_2").val("02");
			$("#ebidence_3").val("03");
			$('#w').window({
				title: '新增委托机构发票信息',
				top:100,
				left:400,
				width: 800,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 370
			});
			$('#btn_submit').linkbutton('enable');	
		}
		function closeAdd(){
			$('#w').window('close');
			$('#w2').window('close');
			$('#w3').window('close');
			
		}		
		function search(){
			var data={'merchNo':$('#a_merchNo').val(),'companyName':$('#a_companyName').val(),'taxPayerId':$("#a_taxPayerId").val(),'accountNo':$("#a_accountNo").val()};
			$('#bankList').datagrid('load',data);
		}
		function getValue(){  
		    var hobbies = document.getElementsByName("documen");  
		    var value;  
		    for (i=0; i<hobbies.length; i++){  
		        if (hobbies[i].checked){  
		            if (!value){  
		                value = hobbies[i].value;  
		            } else {  
		                value += "," + hobbies[i].value;  
		            }  
		        }  
		    }  
		    $("#bankProvince").val(value);
		}  
		function saveUser(){
			getValue();
			$('#saveForm').form('submit', {  
			    onSubmit: function(){  
			    	if($('#saveForm').form('validate')){
			    		$('#btn_submit').linkbutton('disable');	
			    		return true;   
				    }
			        return false;   
			    }, 
			    success: function(json) {
			    	$('#w').window('close');
		    		$('#btn_submit').linkbutton('enable');
		    		json = eval('(' + json + ')');
					 if(json.status=='succ'){
						 $.messager.alert('提示',"保存成功");
						 search();
					 }else{
						 $.messager.alert('提示',"保存失败"); 
						 search();
					 }
				}
			});  
		}
		function saveBank(){
			$('#b_saveForm').form('submit', {  
			    onSubmit: function(){  
			    	if($('#b_saveForm').form('validate')){
			    		$('#b_btn_submit').linkbutton('disable');	
			    		return true;   
				    }
			        return false;   
			    },   
			    success: function(json) {
			    	$('#w2').window('close');
			    	json = eval('(' + json + ')');
		    		$('#b_btn_submit').linkbutton('enable');
					 if(json.status=='succ'){
						 $.messager.alert('提示',"修改成功");
						 search();
					 }else{
						 $.messager.alert('提示',"修改失败");
						 search();
					 }
				} 
			});
		}
		
		function showUser(tId){
			$('#b_saveForm :input').val('');
			$.ajax({
			   type: "POST",
			   url: "merchTax/findById",
			   data: "tId="+tId,
			   async: false,
			   dataType:"json",
			   success: function(json){	
				    $("#b_tId").val(json.tId);
					$("#b_merchNo").val(json.merchNo);
					$("#b_companyName").val(json.companyName);
					$("#b_companyAddress").val(json.companyAddress);
					$("#b_compaynTelno").val(json.compaynTelno);
					$("#b_protocoltype").val(json.protocoltype);
					$("#b_taxPayerId").val(json.taxPayerId);
					$("#b_accountNo").val(json.accountNo);
					$("#b_bankName").val(json.bankName);
					var html = '<option >' + json.bankName + '</option>';
					$("#b_banknode_ins").html(html);
					
					$("#b_invoiceType").val(json.invoiceType);
					$("#b_taxpanyerType").val(json.taxpanyerType);
					$("#b_documenEvidence").val(json.documenEvidence);
					var resultList = json.documenEvidence.split(",");
					for (i=0; i<resultList.length; i++){  
				        if (resultList[i] == "01"){
				        	$("#b_ebidence_1").attr("checked",'true');
				        }else if(resultList[i] == "02"){
				        	$("#b_ebidence_2").attr("checked",'true');
				        }else if(resultList[i] == "03"){
				        	$("#b_ebidence_3").attr("checked",'true');
				        }  
				    }  
					$("#b_contAct").val(json.contAct);
					$("#b_contPhone").val(json.contPhone);
					
					$("#b_status").val(json.status);
					$("#b_notes").val(json.notes);
			   }
			});
			$('#w2').window({
				title: '修改委托机构发票信息',
				top:100,
				left:400,
				width: 800,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 370
			});
		}
		function findById(tId){
			$.ajax({
			   type: "POST",
			   url: "merchTax/findById",
			   data: "tId="+tId,
			   async: false,
			   dataType:"json",
			   success: function(json){	
				   
				    $("#d_tId").val(json.tId);
					$("#d_merchNo").html(json.merchNo);
					$("#d_companyName").html(json.companyName);
					$("#d_companyAddress").html(json.companyAddress);
					$("#d_compaynTelno").html(json.compaynTelno);
					$("#d_protocoltype").html(json.protocoltype);
					$("#d_taxPayerId").html(json.taxPayerId);
					$("#d_accountNo").html(json.accountNo);
					$("#d_bankName").html(json.bankName);
					var html = '<option >' + json.bankName + '</option>';
					$("#d_banknode_ins").html(html);
						var invoiceType;
						if(json.invoiceType == ''){
							invoiceType = '未选择发票类型';
					   	}else if(json.invoiceType == '01'){
					   		invoiceType = '专用发票';
					   	}else if(json.invoiceType == '02'){
					   		invoiceType = '普通发票';
					   	}
					$("#d_invoiceType").html(invoiceType);
						var taxpanyerType;
						if(json.taxpanyerType == ''){
							taxpanyerType = '未选择纳税人类型';
					   	}else if(json.taxpanyerType == '01'){
					   		taxpanyerType = '一般纳税人';
					   	}else if(json.taxpanyerType == '02'){
					   		taxpanyerType = '小规模纳税人';
					   	}
					$("#d_taxpanyerType").html(taxpanyerType);
					$("#d_documenEvidence").html(json.documenEvidence);
					var resultList = json.documenEvidence.split(",");
					var documenEvidence = "";
					for (i=0; i<resultList.length; i++){  
				        if (resultList[i] == "01"){
				        	documenEvidence += "  资格证书 ";
				        }else if(resultList[i] == "02"){
				        	documenEvidence += "  税务登记证 ";
				        }else if(resultList[i] == "03"){
				        	documenEvidence += "  五证合一 ";
				        }  
				    }  
					$("#d_documenEvidence").html(documenEvidence);
					$("#d_contAct").html(json.contAct);
					$("#d_contPhone").html(json.contPhone);
					
					$("#d_status").html(json.status);
					$("#d_notes").html(json.notes);
				   
				    
// 				    $("#d_tId").val(json.tId);
// 					$("#d_status").html(json.status);
// 					$("#d_bankProvince").html(json.bankProvince);
// 					$("#d_bankCity").html(json.accoutNo);
// 					$("#d_accoutNoa").html(json.accoutNo);
// 					$("#d_accoutNamea").html(json.accoutName);
// 					$("#d_merchNoa").html(json.merchNo);
// 					var protocoltype;
// 					   if(json.protocoltype == ''){
// 						   protocoltype = '未选择协议类型';
// 					   }else if(json.protocoltype == '1'){
// 						   protocoltype = '代理收款';
// 					   }else if(json.protocoltype == '2'){
// 						   protocoltype = '代理付款';
// 					   }
// 					$("#d_protocoltype").html(protocoltype);
// 					$("#d_bankNode").html(json.bankNode);
// 					$("#d_bankCode").html(json.bankCode);
// 					$("#d_bankCode").val(json.bankCode);
// 					$("#d_channelCode").html(json.channelCode);
// 					$("#d_notes").html(json.notes);
			   }
			});
			$('#w3').window({
				title: '委托机构发票信息详情',
				top:100,
				left:400,
				width: 800,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 370
			});
		}

		function deleteUser(tId){
			$.messager.confirm('提示','您是否想要注销此委托机构发票信息?',function(r){   
			    if (r){  
			    	$.ajax({
						   type: "POST",
						   url: "merchTax/delect",
						   data: "tId="+tId,
						   async: false,
						   dataType:"json",
						   success: function(json){
//		 					   json = eval("(" + data + ")");
								 if(json.status=='succ'){
									 $.messager.alert('提示',"注销成功");
									 search();
								 }else{
									 $.messager.alert('提示',"注销失败");
									 search();
								 }
						    }
						});
			    }   
			}); 
		}
		function checkBankKey(type){
			var pid;
			if (type == 'add') {
				pid = $("#banknode_key").val();
			} else {
				pid = $("#b_banknode_key").val();
			}
// 			var pid = $("#banknode_key").val();
			 if(pid=='输入关键字检索开户行'){
				if (type == 'add') {
					 $("#banknode_key").val('');
				} else {
					 $("#b_banknode_key").val('');
				}
			}
			$("#b_banknode_key").css({color:"#515151"});
			$("#banknode_key").css({color:"#515151"});
		}
		
		function queryBankNode(type) {
			var pid;
			if (type == 'add') {
				pid = $("#banknode_key").val();
			} else {
				pid = $("#b_banknode_key").val();
			}
// 			var pid = $("#banknode_key").val();
			if(pid==null||pid==''){
				if (type == 'add') {
					$("#banknode_key").val('输入关键字检索开户行');
					$("#banknode_key").css({color:"#BEBEBE"});
				} else {
					$("#b_banknode_key").val('输入关键字检索开户行');
					$("#b_banknode_key").css({color:"#BEBEBE"});
				}
				return;
			} 
			$.ajax({
				type: "POST",
				url: "agency/queryBankNode",
				data: "bankName=" + pid,
				dataType: "json",
				success: function(json) {
					var html;
					$.each(json,function(key, value) {
						html += '<option value="' + value.BANK_NAME + '">' + value.BANK_NAME + '</option>';
					});
					if (type == 'add') {
						$("#banknode_ins").html(html);
					} else {
						$("#b_banknode_ins").html(html);
					}
// 					$("#banknode_ins").html(html);
				}
			});
		}
	</script>
</html>
