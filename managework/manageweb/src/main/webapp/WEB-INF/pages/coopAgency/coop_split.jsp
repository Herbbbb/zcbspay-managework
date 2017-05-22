<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link href="<%=basePath%>js/uploadify/uploadify.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>js/uploadify/jquery.uploadify.min.js"></script>
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
	table {
	
	}
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
	<div style="padding-top: 5px; margin-left: 5px; margin-right: 5px" id="continer">
		<div id="p" class="easyui-panel" title="查询条件" style="height: 80px; padding-top: 10px; background: #fafafa;" iconCls="icon-save" collapsible="true">
			<form action="" id="searchForm">
				<table width="100%">
					<tr>
						<td class="add" align="right"></td>
						<td class="add" align="right">代理商编号</td>
						<td class="add" align="left" style="padding-left: 5px">
						<input id="a_caCode" name="caCode" /></td>
						<td class="add" align="right"></td>
						<td class="add" align="right"></td>
						<td class="add" align="left" colspan="3">
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
				<form id="saveForm" action="coopSplit/save" method="post">
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">代理商编号</td>
							<td class="update" align="left">
							<input type="text" id="caCode" name="caCode" class="easyui-validatebox" required="true"
								maxlength="11" missingMessage="请输入代理商编号"/><font color="red">*</font></td>
							<td class="update">分润比例(1)</td>
							<td class="update" align="left">
							<input type="text" id="rate1" name="rate1" class="easyui-validatebox" required="true"
								maxlength="2" missingMessage="请输入分润比例"/><font color="red">*</font></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">分界线(一)</td>
							<td class="update" align="left">
							<input type="text" id="limit1" name="limit1" class="easyui-validatebox" required="true"
								maxlength="10" missingMessage="请输入分界线比例值"/><font color="red">*</font></td>
						
							<td class="update">分润比例(2)</td>
							<td class="update" align="left">
							<input type="text" id="rate2" name="rate2" class="easyui-validatebox" required="true"
								maxlength="2" missingMessage="请输入分润比例"/><font color="red">*</font></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">分界线(二)</td>
							<td class="update" align="left">
							<input type="text" id="limit2" name="limit2" class="easyui-validatebox" required="true"
								maxlength="10" missingMessage="请输入分界线比例值"/><font color="red">*</font></td>
							<td class="update">分润比例(3)</td>
							<td class="update" align="left">
							<input type="text" id="rate3" name="rate3" class="easyui-validatebox" required="true"
								maxlength="2" missingMessage="请输入分润比例"/><font color="red">*</font></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">分界线(三)</td>
							<td class="update" align="left">
							<input type="text" id="limit3" name="limit3" class="easyui-validatebox" required="true"
								maxlength="10" missingMessage="请输入分界线比例值"/><font color="red">*</font></td>
							<td class="update">分润比例(4)</td>
							<td class="update" align="left">
							<input type="text" id="rate4" name="rate4" class="easyui-validatebox" required="true"
								maxlength="2" missingMessage="请输入分润比例"/><font color="red">*</font></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
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
				<form id="b_saveForm" action="coopSplit/eidtBankAccount" method="post">
					<input type="hidden" id="b_tId" name="tId" /> 
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">代理商编号</td>
							<td class="update" align="left">
							<input type="text" id="b_caCode" name="caCode" class="easyui-validatebox" required="true"
								maxlength="11" missingMessage="请输入代理商编号"/><font color="red">*</font></td>
							<td class="update">分润比例(1)</td>
							<td class="update" align="left">
							<input type="text" id="b_rate1" name="rate1" class="easyui-validatebox" required="true"
								maxlength="2" missingMessage="请输入分润比例"/><font color="red">*</font></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">分界线(一)</td>
							<td class="update" align="left">
							<input type="text" id="b_limit1" name="limit1" class="easyui-validatebox" required="true"
								maxlength="10" missingMessage="请输入分界线比例值"/><font color="red">*</font></td>
						
							<td class="update">分润比例(2)</td>
							<td class="update" align="left">
							<input type="text" id="b_rate2" name="rate2" class="easyui-validatebox" required="true"
								maxlength="2" missingMessage="请输入分润比例"/><font color="red">*</font></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">分界线(二)</td>
							<td class="update" align="left">
							<input type="text" id="b_limit2" name="limit2" class="easyui-validatebox" required="true"
								maxlength="10" missingMessage="请输入分界线比例值"/><font color="red">*</font></td>
							<td class="update">分润比例(3)</td>
							<td class="update" align="left">
							<input type="text" id="b_rate3" name="rate3" class="easyui-validatebox" required="true"
								maxlength="2" missingMessage="请输入分润比例"/><font color="red">*</font></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">分界线(三)</td>
							<td class="update" align="left">
							<input type="text" id="b_limit3" name="limit3" class="easyui-validatebox" required="true"
								maxlength="10" missingMessage="请输入分界线比例值"/><font color="red">*</font></td>
							<td class="update">分润比例(4)</td>
							<td class="update" align="left">
							<input type="text" id="b_rate4" name="rate4" class="easyui-validatebox" required="true"
								maxlength="2" missingMessage="请输入分润比例"/><font color="red">*</font></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
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
					<input type="hidden" id="c_tId" name="tId" />  
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update" width="18%">代理商编号</td>
							<td class="update" align="left" width="28%"><span id="c_caCode"></span></td>
							<td class="update" width="18%">分润比例(1)</td>
							<td class="update" align="left" width="28%"><span id="c_rate1"></span></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">分界线(一)</td>
							<td class="update" align="left"><span id="c_limit1"></span></td>
							<td class="update">分润比例(2)</td>
							<td class="update" align="left"><span id="c_rate2"></span></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">分界线(二)</td>
							<td class="update" align="left"><span id="c_limit2"></span></td>
							<td class="update">分润比例(3)</td>
							<td class="update" align="left"><span id="c_rate3"></span></td>
						</tr>
						<tr style="height: 25px">
							<td class="update">分界线(三)</td>
							<td class="update" align="left"><span id="c_limit3"></span></td>
							<td class="update">分润比例(4)</td>
							<td class="update" align="left"><span id="c_rate4"></span></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
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
				title:'代理商分润信息列表',
				iconCls:'icon-save',
				height:600,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'coopSplit/query',
				remoteSort: false,
				columns:[[
					{field:'CACODE',title:'代理商编号',width:130,align:'center'},
					{field:'RATE1',title:'分润比例(1)',align:'center',width:90},
					{field:'LIMIT1',title:'分界线(一)',align:'center',width:90},
					{field:'RATE2',title:'分润比例(2)',align:'center',width:90},
					{field:'LIMIT2',title:'分界线(二)',align:'center',width:90},
					{field:'RATE3',title:'分润比例(3)',align:'center',width:90},
					{field:'LIMIT3',title:'分界线(三)',align:'center',width:90},
					{field:'RATE4',title:'分润比例(4)',align:'center',width:90},
					{field:'STATUS',title:'状态',width:60,align:'center',
						formatter:function(value,rec){
							if(value=="00"){
								return "正常";
							}else{
								return "停用";
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
					text:'新增代理商分润信息',
					iconCls:'icon-add',
					handler:function(){
						$("#user_code").removeAttr('readonly');
						showAdd(0);
						$("#saveForm").attr("action","coopSplit/save");
					}
				}]
			});
		});

		function resize(){
			$('#searchForm :input').val('');
		}
		
		function showAdd(num){
			$("#saveForm").attr("action","coopSplit/save");
			$('#saveForm :input').val('');
			$('#w').window({
				title: '新增代理商分润信息',
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
		
		function showUser(tId){
			$('#b_saveForm :input').val('');
			$.ajax({
			   type: "POST",
			   url: "coopSplit/findById",
			   data: "tId="+tId,
			   async: false,
			   dataType:"json",
			   success: function(json){	
				    $("#b_tId").val(json.tId);
					$("#b_caCode").val(json.caCode);
					$("#b_rate1").val(json.rate1);
					$("#b_limit1").val(json.limit1);
					$("#b_rate2").val(json.rate2);
					$("#b_limit2").val(json.limit2);
					$("#b_rate3").val(json.rate3);
					$("#b_limit3").val(json.limit3);
					$("#b_rate4").val(json.rate4);
					$("#b_status").val(json.status);
					$("#b_notes").val(json.notes);
			    }
			});
			
			$('#w2').window({
				title: '修改代理商分润信息',
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
		}
		function findById(tId){
			$.ajax({
			   type: "POST",
			   url: "coopSplit/findById",
			   data: "tId="+tId,
			   async: false,
			   dataType:"json",
			   success: function(json){	
				   $("#c_tId").val(json.tId);
					$("#c_caCode").html(json.caCode);
					$("#c_rate1").html(json.rate1);
					$("#c_limit1").html(json.limit1);
					$("#c_rate2").html(json.rate2);
					$("#c_limit2").html(json.limit2);
					$("#c_rate3").html(json.rate3);
					$("#c_limit3").html(json.limit3);
					$("#c_rate4").html(json.rate4);
					$("#c_status").val(json.status);
					$("#c_notes").html(json.notes);
					
			    }
			});
			$('#w3').window({
				title: '代理商分润信息详情',
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
		}

		function deleteUser(tId){
			$.messager.confirm('提示','您是否想要注销此代理商分润信息?',function(r){   
			    if (r){  
			    	$.ajax({
					   type: "POST",
					   url: "coopSplit/delect",
					   data: "tId="+tId,
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
	</script>
</html>
