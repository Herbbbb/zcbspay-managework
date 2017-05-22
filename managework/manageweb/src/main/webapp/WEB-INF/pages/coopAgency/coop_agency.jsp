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
			style="height: 80px; padding-top: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form action="" id="searchForm">
				<table width="100%">
					<tr>
						<td class="add" align="right">代理商名称</td>
						<td class="add" align="left" style="padding-left: 5px">
						<input id="a_caName" name="caName" /></td>
						<td class="add" align="right">代理商编号</td>
						<td class="add" align="left" style="padding-left: 5px">
						<input id="a_caCode" name="caCode" /></td>
						<td class="add" align="right">代理商状态</td>
						<td class="add" align="left" style="padding-left: 5px">
						<select id="a_status" name="status"/>
								<option value=''>--请选择代理商状态--</option>
								<option value='00'>--在用--</option>
								<option value='99'>--停用--</option>
								</select></td>
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
				<form id="saveForm" action="coopAgency/save" method="post">
					<input type="hidden" id="bankNode" name="bankNode" />
					<input type="hidden" id="caBank" name="caBank" /> 
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update" width="15%">代理商名称 </td>
							<td class="update" align="left">
							<input type="text" id="caName" name="caName" class="easyui-validatebox" required="true"
								maxlength="64" missingMessage="请输入代理商名称 " validType="debName[]"/><font color="red">*</font></td>
							<td class="update">代理商编号</td>
							<td class="update" align="left">
							<input type="text" id="caCode" name="caCode" class="easyui-validatebox" required="true"
								maxlength="11" missingMessage="请输入代理商编号"/><font color="red">*</font></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">代理商获利模式</td>
							<td class="update" align="left">
							<select id="profitType" class="easyui-validatebox"required="true" name="profitType"></select><font color="red">*</font></td>
							<td class="update">代理商所在地</td>
							<td class="update" colspan="2" align="left">
							<select id="province_ins" class="easyui-validatebox" required="true" name="caProvince" onchange="showCity('province_ins')" /></select> 
							<select id="city_ins" class="easyui-validatebox" required="true" name="caCity"/>
							<option value=''>--请选择所属市--</option></select><font color="red">*</font></td>
						</tr>
<!-- 						<tr style="height: 25px"> -->
<!-- 							<td class="update">组织机构代码</td> -->
<!-- 							<td class="update" align="left"> -->
<!-- 							<input type="text" id="organId" name="organId" class="easyui-validatebox" maxlength="10" missingMessage="请输入组织机构代码"/></td> -->
<!-- 							<td class="update">上级代码</td> -->
<!-- 							<td class="update" align="left"> -->
<!-- 							<input type="text" id="superCode" name="superCode" class="easyui-validatebox" maxlength="11" missingMessage="请输入上级代码"/></td> -->
<!-- 						</tr> -->
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">银行账号</td>
							<td class="update" align="left">
							<input type="text" id="caBankAcc" name="caBankAcc" class="easyui-validatebox" required="true"
								maxlength="32" missingMessage="请输入银行账号" validType="bankcard[]"/><font color="red">*</font></td>
							<td class="update">银行账户名</td>
							<td class="update" align="left">
							<input type="text" id="caAccName" name="caAccName" class="easyui-validatebox" required="true"
								maxlength="64" missingMessage="请输入银行账户名" validType="debName[]"/><font color="red">*</font></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">开户行名称</td>
							<td class="update" align="left" colspan="3">
								<select id="banknode_ins" maxlength="64" class="easyui-validatebox" required="true" style="width: 250px" 
								 onchange="showBankInfo('add')"/><option value=''>--请选择开户行--</option></select><font color="red">*</font>
								<input id="banknode_key" maxlength="16" type="text" onclick="checkBankKey('add')" onchange="queryBankNode('add')"/></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">开户行行号</td>
							<td class="update" align="left"><span id="bankNode_ins"></span></td>
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
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveUser()" id="btn_submit">提交</a>
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeAdd()">返回</a>
			</div>
		</div>
	</div>
	<div id="w2" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 400px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; font-size: 12px; text-align: center">
				<form id="b_saveForm" action="coopAgency/eidtBankAccount" method="post">
					<input type="hidden" id="b_caId" name="caId" /> 
					<input type="hidden" id="b_bankNode" name="bankNode" /> 
					<input type="hidden" id="b_caBank" name="caBank" /> 
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update" width="15%">代理商名称 </td>
							<td class="update" align="left">
							<input type="text" id="b_caName" name="caName" class="easyui-validatebox" required="true"
								maxlength="64" missingMessage="请输入代理商名称 " validType="debName[]"/></td>
							<td class="update">代理商编号</td>
							<td class="update" align="left">
							<input type="text" id="b_caCode" name="caCode" class="easyui-validatebox" required="true"
								maxlength="11" missingMessage="请输入代理商编号"/></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">代理商获利模式</td>
							<td class="update" align="left">
							<select id="b_profitType" class="easyui-validatebox"required="true" name="profitType"></select><font color="red">*</font></td>
							<td class="update">代理商所在地</td>
							<td class="update" colspan="2" align="left">
							<select id="bnkProvince_ins" class="easyui-validatebox" name="caProvince" onchange="showCity()"/></select> 
							<select id="bnkCity_ins" class="easyui-validatebox" required="true" name="caCity"/>
							<option value=''>--请选择所属市--</option></select><font color="red">*</font></td>
						</tr>
<!-- 						<tr style="height: 25px"> -->
<!-- 							<td class="update">组织机构代码</td> -->
<!-- 							<td class="update" align="left"> -->
<!-- 							<input type="text" id="b_organId" name="organId" class="easyui-validatebox" -->
<!-- 								maxlength="10" missingMessage="请输入组织机构代码" /></td> -->
<!-- 							<td class="update">上级代码</td> -->
<!-- 							<td class="update" align="left"> -->
<!-- 							<input type="text" id="b_superCode" name="superCode" class="easyui-validatebox" -->
<!-- 								maxlength="11" missingMessage="请输入上级代码"/></td> -->
<!-- 						</tr> -->
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">银行账号</td>
							<td class="update" align="left">
							<input type="text" id="b_caBankAcc" name="caBankAcc" class="easyui-validatebox" required="true"
								maxlength="32" missingMessage="请输入银行账号" validType="bankcard[]"/></td>
							<td class="update">银行账户名</td>
							<td class="update" align="left">
							<input type="text" id="b_caAccName" name="caAccName" class="easyui-validatebox" required="true"
								maxlength="64" missingMessage="请输入银行账户名"/></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">开户行名称</td>
							<td class="update" align="left" colspan="3">
								<select id="b_banknode_ins" maxlength="64" class="easyui-validatebox" required="true" style="width: 250px" 
								onchange="showBankInfo('update')"/><option value=''>--请选择开户行--</option></select><font color="red">*</font>
								<input id="b_banknode_key" maxlength="16" type="text" onclick="checkBankKey('update')" onchange="queryBankNode('update')"/></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">开户行行号</td>
							<td class="update" align="left"><span id="b_bankNode_ins"></span></td>
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
		iconCls="icon-save" style="width: 500px; height: 400px; padding: 5px;toolbar: no;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; font-size: 12px; text-align: center">
				<form id="" action="" method="post">
					<input type="hidden" id="c_caId" name="caId" />  
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
<!-- 						<tr style="height: 25px"> -->
<!-- 							<td class="update" width="18%">公司全称</td> -->
<!-- 							<td class="update" align="left" width="28%"><span id="c_companyName"></span></td> -->
<!-- 							<td class="update" width="18%">委托机构号</td> -->
<!-- 							<td class="update" align="left" width="28%"><span id="c_merchNo"></span></td> -->
<!-- 						</tr> -->
						<tr style="height: 25px">
							<td class="update" width="18%">代理商名称 </td>
							<td class="update" align="left" width="28%"><span id="c_caName"></span></td>
							<td class="update" width="18%">代理商编号</td>
							<td class="update" align="left" width="28%"><span id="c_caCode"></span></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">代理商获利模式</td>
							<td class="update" align="left"><span id="c_profitType"></span></td>
							<td class="update">代理商所在地</td>
							<td class="update" colspan="2" align="left"><span id="c_address"></span></td>
						</tr>
<!-- 						<tr style="height: 25px"> -->
<!-- 							<td class="update">组织机构代码</td> -->
<!-- 							<td class="update" align="left"><span id="c_organId"></span></td> -->
<!-- 							<td class="update">上级代码</td> -->
<!-- 							<td class="update" align="left"><span id="c_superCode"></span></td> -->
<!-- 						</tr> -->
						<tr style="height: 25px">
							<td class="update">银行账号</td>
							<td class="update" align="left"><span id="c_caBankAcc"></span></td>
							<td class="update">银行账户名</td>
							<td class="update" align="left"><span id="c_caAccName"></span></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">开户行名称</td>
							<td class="update" align="left"><span id="c_caBank"></span></td>
							<td class="update">开户行行号</td>
							<td class="update" align="left"><span id="c_bankNode"></span></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">备注</td>
							<td align="left" colspan="3" class="update"><span id="c_notes" rows="3" cols="81" style="resize: none;"></span></td>
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
				title:'代理商信息列表',
				iconCls:'icon-save',
				height:600,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'coopAgency/query',
				remoteSort: false,
				columns:[[
					{field:'CANAME',title:'代理商名称',align:'center',width:130},
					{field:'CACODE',title:'代理商编号',width:130,align:'center'},
					{field:'CAACCNAME',title:'银行账户名',align:'center',width:120},
					{field:'CABANKACC',title:'银行账号',width:130,align:'center'},
					{field:'CABANK',title:'银行账户开户行名称',align:'center',width:250},
					{field:'CACITY',title:'代理商所在地',width:120,align:'center',
						formatter:function(value,rec){
							return findAddress(rec.CAPROVINCE,rec.CACITY);
						}
					},
					{field:'STATUS',title:'状态',width:60,align:'center',
						formatter:function(value,rec){
							if(value=="00"){
								return "正常";
							}else{
								return "停用";
							}
						}
					},
					{field:'CAID',title:'操作',align:'center',width:120,rowspan:2,
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
					text:'新增代理商信息',
					iconCls:'icon-add',
					handler:function(){
						$("#user_code").removeAttr('readonly');
						showAdd(0);
						$("#saveForm").attr("action","coopAgency/save");
					}
				}]
			});
		});

		function resize(){
			$('#searchForm :input').val('');
		}
		
		function showAdd(num){
			showProvince();
			showProfitType();
			$("#saveForm").attr("action","coopAgency/save");
			$('#saveForm :input').val('');
			$('#bnkProvince_ins').html('');
			$('#b_profitType').val('');
			$('#w').window({
				title: '新增代理商信息',
				top:100,
				left:400,
				width: 800,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 350
			});
			$('#btn_submit').linkbutton('enable');	
		}
		function closeAdd(){
			$('#w').window('close');
			$('#w2').window('close');
			$('#w3').window('close');
			
		}		
		function search(){
			var data={'caCode':$('#a_caCode').val(),'caName':$('#a_caName').val(),'status':$("#a_status").val()};
			$('#bankList').datagrid('load',data);
		}
		function findAddress(province,city){
			var address = province + city;
			return address;
		}
		function showProvince() {
			$.ajax({
				type: "POST",
				url: "agency/queryProvince",
				dataType: "json",
				success: function(json) {
					var province = $("#bnkProvince_ins").val();
					var html = "<option value=''>--请选择所属省--</option>";
					$.each(json,function(key, value) {
						if(value.P_ID==province){
							html += '<option value="' + value.P_ID + '" selected="selected">' + value.P_NAME + '</option>';
						}else{
							html += '<option value="' + value.P_ID + '">' + value.P_NAME + '</option>';
						}
					}) ;
					$("#province_ins").html(html);
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
				url: "agency/queryCity",
				data: "pid=" + pid,
				dataType: "json",
				success: function(json) {
					var province = $("#bnkCity_ins").val();
					var html = "<option value=''>--请选择所属市--</option>";
					$.each(json,function(key, value) {
						if(value.C_ID == province){
							html += '<option value="' + value.C_ID + '" selected="selected">' + value.C_NAME + '</option>';
						}else{
							html += '<option value="' + value.C_ID + '">' + value.C_NAME + '</option>';
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
			
		function showProfitType() {
			$.ajax({
				type: "POST",
				url: "coopAgency/queryProfitType",
				dataType: "json",
				success: function(json) {
					var province = $("#b_profitType").val();
					var html = "<option value=''>--请选择获利模式--</option>";
					$.each(json,function(key, value) {
						if(value.PARA_CODE==province){
							html += '<option value="' + value.PARA_CODE + '" selected="selected">' + value.PARA_NAME + '</option>';
						}else{
							html += '<option value="' + value.PARA_CODE + '">' + value.PARA_NAME + '</option>';
						}
					}) ;
					$("#profitType").html(html);
				}
			});
		}
		function saveUser(){
			$('#saveForm').form('submit', {  
			    onSubmit: function(){  
			    	if($('#saveForm').form('validate')){
			    		$('#btn_submit').linkbutton('disable');	
			    		return true;   
				    }
			        return false;   
			    }, 
			    success: function(json) {
		    		$('#btn_submit').linkbutton('enable');
		    		json = eval('(' + json + ')');
		    		if(json.RET=='succ'){
						 $.messager.alert('提示',json.INFO);
						 $('#w').window('close');
						 search();
					}else{
						 $.messager.alert('提示',json.INFO);
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
			    	json = eval('(' + json + ')');
		    		$('#b_btn_submit').linkbutton('enable');
					if(json.RET=='succ'){
						$('#w2').window('close');
						$.messager.alert('提示',json.INFO);
						search();
					}else{
						$.messager.alert('提示',json.INFO);
					}
				} 
			});
		}
		
		function showUser(caId){
			$('#b_saveForm :input').val('');
			$.ajax({
			   type: "POST",
			   url: "coopAgency/findById",
			   data: "tId="+caId,
			   async: false,
			   dataType:"json",
			   success: function(json){	
				    $("#b_caId").val(json[0].CAID);
					$("#b_caCode").val(json[0].CACODE);
					$("#b_caName").val(json[0].CANAME);
					$("#b_caBankAcc").val(json[0].CABANKACC);
					$("#b_caAccName").val(json[0].CAACCNAME);
					$("#b_bankNode_ins").html(json[0].BANK_NODE);
					var html = "<option value='"+json[0].BANKNAME+"'>"+json[0].BANKNAME+"</option>";
					$("#b_banknode_ins").html(html);
					$("#b_bankNode").val(json[0].BANK_NODE);
					$("#b_organId").val(json[0].ORGANID);
					$("#b_superCode").val(json[0].SUPERCODE);
					$("#b_status").val(json[0].STATUS);
					$("#b_notes").val(json[0].NOTES);
					
					var province = json[0].CAPROVINCE;
					$.ajax({
						type: "POST",
						url: "agency/queryProvince",
						dataType: "json",
						success: function(json) {
							var html2;
							$.each(json,function(key, value) {
								if(value.P_ID==province){
									html2 += '<option value="' + value.P_ID + '" selected="selected">' + value.P_NAME + '</option>';
								}else{
									html2 += '<option value="' + value.P_ID + '">' + value.P_NAME + '</option>';
								}
							}) ;
							$("#bnkProvince_ins").html(html2);
						}
					});
					var city = json[0].CACITY;
					$.ajax({
						type: "POST",
						url: "agency/queryCity",
						data: "pid=" + province,
						dataType: "json",
						success: function(json) {
							var html3;
							$.each(json,function(key, value) {
								if(value.C_ID == city){
									html3 += '<option value="' + value.C_ID + '" selected="selected">' + value.C_NAME + '</option>';
								}else{
									html3 += '<option value="' + value.C_ID + '">' + value.C_NAME + '</option>';
								}
							});
							
						$("#bnkCity_ins").html(html3);
						}
					});
					var b_profitType = json[0].PROFITTYPE;
					$.ajax({
						type: "POST",
						url: "coopAgency/queryProfitType",
						dataType: "json",
						success: function(json) {
							var html4 = "<option value=''>--请选择获利模式--</option>";
							$.each(json,function(key, value) {
								if(value.PARA_CODE==b_profitType){
									html4 += '<option value="' + value.PARA_CODE + '" selected="selected">' + value.PARA_NAME + '</option>';
								}else{
									html4 += '<option value="' + value.PARA_CODE + '">' + value.PARA_NAME + '</option>';
								}
							}) ;
							$("#b_profitType").html(html4);
						}
					});
			    }
			});
			
			$('#w2').window({
				title: '修改代理商信息',
				top:100,
				left:400,
				width: 800,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 350
			});
			showProfitType();
		}
		function findById(caId){
			$.ajax({
			   type: "POST",
			   url: "coopAgency/findById",
			   data: "tId="+caId,
			   async: false,
			   dataType:"json",
			   success: function(json){	
				    $("#c_caId").val(json[0].CAID);
					$("#c_caCode").html(json[0].CACODE);
					$("#c_caName").html(json[0].CANAME);
					$("#c_caBankAcc").html(json[0].CABANKACC);
					$("#c_caAccName").html(json[0].CAACCNAME);
					$("#c_bankNode").html(json[0].BANK_NODE);
					$("#c_caBank").html(json[0].BANKNAME);
// 					$("#c_organId").html(json[0].ORGANID);
// 					$("#c_superCode").html(json[0].SUPERCODE);
					$("#c_status").html(json[0].STATUS);
					$("#c_notes").html(json[0].NOTES);
					
					var province = json[0].CAPROVINCE;
					var city = json[0].CACITY;
					var html = '';
					$.ajax({
						type: "POST",
						url: "agency/queryProvince",
						dataType: "json",
						success: function(json) {
							$.each(json,function(key, value) {
								if(value.P_ID==province){
									html += value.P_NAME;
									$.ajax({
										type: "POST",
										url: "agency/queryCity",
										data: "pid=" + province,
										dataType: "json",
										success: function(json) {
											$.each(json,function(key, value) {
												if(value.C_ID == city){
													html += value.C_NAME;
												}
											});
											$("#c_address").html(html);
										}
									});
								}
							}) ;
						}
					});
					
					var b_profitType = json[0].PROFITTYPE;
					$.ajax({
						type: "POST",
						url: "coopAgency/queryProfitType",
						dataType: "json",
						success: function(json) {
							var html4;
							$.each(json,function(key, value) {
								if(value.PARA_CODE==b_profitType){
									html4 = value.PARA_NAME;
								}
							}) ;
							$("#c_profitType").html(html4);
						}
					});
			    }
			});
			$('#w3').window({
				title: '代理商信息详情',
				top:100,
				left:400,
				width: 800,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 270
			});
		}

		function deleteUser(caId){
			$.messager.confirm('提示','您是否想要注销此代理商信息?',function(r){   
			    if (r){  
			    	$.ajax({
					   type: "POST",
					   url: "coopAgency/delect",
					   data: "tId="+caId,
					   async: false,
					   dataType:"json",
					   success: function(json){
							 if(json.RET=='succ'){
								$('#w3').window('close');
								$.messager.alert('提示',json.INFO);
								search();
							 }else{
								$.messager.alert('提示',json.INFO);
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
					var html = "<option value=''>--请选择开户行--</option>";
					$.each(json,function(key, value) {
						html += '<option value="' + value.BANK_NODE + '">' + value.BANK_NAME + '</option>';
					});
					if (type == 'add') {
						$("#banknode_ins").html(html);
					} else {
						$("#b_banknode_ins").html(html);
					}
				}
			});
		}
		function showBankInfo(type){ 
			var bankNode;
			if (type == 'add') {
				bankNode = $("#banknode_ins").val();
			} else {
				bankNode = $("#b_banknode_ins").val();
			}
			$.ajax({
			   type: "POST",
			   url: "bankaccout/queryBankInfo",
			   data: "bankNode="+bankNode,
			   async: false,
			   dataType:"json",
			   success: function(json){	
				   if (type == 'add') {
					   $("#caBank").val(json.bankName);
					   $("#bankNode").val(json.bankNode);
					   $("#bankNode_ins").html(json.bankNode);
					} else {
						$("#b_caBank").val(json.bankName);
						$("#b_bankNode").val(json.bankNode);
						$("#b_bankNode_ins").html(json.bankNode);
					}
			   }
			});
		}
	</script>
</html>
