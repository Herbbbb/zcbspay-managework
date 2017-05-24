<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>
<html>
<head>
</head>
<body>
	<div style="margin: 5px; border:" id="continer">
		<div id="p" class="easyui-panel" title="路由查询"
			style="height: 72px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="dedurateForm" method="post">
				<table width="100%">
					<tr>
						<td align="right">路由版本代码</td>
						<td align="left" style="padding-left: 5px"><input
							name="routver" id="routver_qid" maxlength="8" /></td>
						<td align="right">路由版本名称</td>
						<td align="left" style="padding-left: 5px"><input
							name="routname" id="routname_qid" maxlength="128" />
						</td>
						<td align="right" colspan=2><a href="javascript:search()"
							class="easyui-linkbutton" iconCls="icon-search">查询</a>
							<a
							href="javascript:resize()" class="easyui-linkbutton"
							iconCls="icon-redo">清空</a>
							</td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="test"></table>
		</div>
	</div>
	<div id="w" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="theForm" method="post"
					action="route/saveRoute">
					<input name="routid" id="routid" type="hidden" />
					<table width="100%" cellpadding="2" cellspacing="2"
						style="text-align: left" id="inputForm">
						<tr>
							<td align="right" width="15%" height="50px">路由版本代码</td>
							<td align="left" style="padding-left: 5px" width="25%">
							<input name="routver" id="routver" required="true" validType="minLength[8,8]" maxlength="8"
								class="easyui-validatebox" missingMessage="请输入路由版本"/> <font color="red">*</font></td>
							</td>
							<td align="right" width="15%">路由版本名称</td>
							<td align="left" style="padding-left: 5px" width="25%"><input
								name="routname" id="routname" required="true"
								missingMessage="请输入路由版本名称" maxlength="32"
								class="easyui-validatebox"
								onblur="value=value.replace( /\s+/g,'')" /> <font color="red">*</font></td>
							</td>
						</tr>
						<tr></tr>
						<tr>
							<td align="right" width="15%">备注</td>
							<td align="left" style="padding-left: 5px" width="25%">
							<input name="note" id="notes" maxlength="64" class="easyui-validatebox" /></td>
							<td align="center" colspan="2"><font color="red">提示:请于启用、注销前在备注处填写理由</font></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false"
				style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok"
					href="javascript:saveRoute()" id="btn_submit" onclick="">保存</a> <a
					class="easyui-linkbutton" iconCls="icon-cancel"
					href="javascript:void(0)" onclick="closeAdd()">取消</a>
			</div>
		</div>
	</div>
</body>

<script>
	
		var width = $("#continer").width();
	  	var gridHeight = 540;
		var panelWidth = 640;
		var panelHeight = 260;
		var panelHoriFloat = (width-panelWidth)/2;
		var panelVertFloat = 150;
	
		$(function() {
			$('#test').datagrid({
				title: '路由版本列表', 
				singleSelect: true,
				iconCls: 'icon-save',
				height: gridHeight,
				nowrap: false,
				striped: true,
				sortName: 'ROUTVER',
				url: 'route/queryRouteEdition',
				remoteSort: false,
				columns: [[				    
					{field: 'ROUTVER',title: '路由版本代码',width: 200,align: 'center'},
				    {field: 'ROUTNAME',title: '路由版本名称',width: 250,align: 'center'},
				    {field: 'STATUS',title: '状态',width: 100,align: 'center',
				    	formatter: function(value, rec){
				    		if(value == 00){
				    			return "在用";
				    		}else if(value == 01){
				    			return "停用";
				    		}
				    	}
				    },
				    {field: 'NOTES',title: '备注',width: 100,align: 'center'},				
				    {field: 'ROUTID',title: '操作',width: 150,align: 'center', 
						formatter: function(value, rec) {
							if(rec.STATUS ==00){
								return '<a href="javascript:showRoute(' + value + ')" style="color:blue;margin-left:10px">修改</a>&nbsp;&nbsp;<a href="javascript:deleteRoute('+ value + ')" style="color:blue;margin-left:10px">注销</a>';
							}else if(rec.STATUS ==01){
								return '<a href="javascript:startRoute(' + value + ')" style="color:blue;margin-left:10px">启用</a>';
							}
							
					}
				}]],
				pagination: true,
				rownumbers: true,
				toolbar: [{
					id: 'btnadd',
					text: '新增路由版本',
					iconCls: 'icon-add',
					handler: function() {
						showAdd();
					}
				}]
			});
			var p = $('#test').datagrid('getPager');
			$(p).pagination({
				onBeforeRefresh: function() {
	
		}
			});
		});
	
		function search() {
			var data = {
				'routver': $('#routver_qid').val(),
				'routname': $("#routname_qid").val()
			};
			$('#test').datagrid('load', data);
		}
	
		//新增路由版本 
		function showAdd() {
			$('#theForm').clearForm();
			$('#routname').removeAttr('readonly');
			$("#routname").css("background-color","#FFFFFF");
		  	$.ajax({
		  		type: "POST",
		  		url: "route/queryRoutver",
		  		data:"",
		  		async: false,
		  		dataType: "json",
		  		success: function(json) {
		  			$("#routver").val(json.ROUTVER);
                    $("#routver").attr("disabled","disabled");
		  		}
		  	});	
			$('#w').window({
				title: '扣率版本信息',
				top: panelVertFloat,
		  		left: panelHoriFloat,
		  		width: panelWidth,
		  		height: panelHeight,
				collapsible: false,
				minimizable: false,
				maximizable: false,
				modal: true,
				shadow: false,
				closed: false
			});
			$("#theForm").attr("action", "route/saveRoute");
			$('#btn_submit').linkbutton('enable');
		}
		
		//保存 
		function saveRoute(){
			$("#routver").removeAttr("disabled");
			$('#routname').removeAttr('readonly');
			$("#routname").css("background-color","#FFFFFF");
			
			$('#theForm').form('submit', {
				onSubmit: function() {
					if ($('#theForm').form('validate')) {
						$('#btn_submit').linkbutton('disable');
						return true;
					}
					return false;
				},
				success: function(data) {
					$.messager.alert('提示', data);
					closeAdd();
					$('#btn_submit').linkbutton('enable');
					search();
				}
			});
		}

		//取消
		function closeAdd() {
			$('#w').window('close');
		}

		//修改
		function showRoute(routid){
			$('#routname').removeAttr('readonly');
			$("#routname").css("background-color","#FFFFFF");
			$.ajax({
				type: "POST",
				url: "route/queryOneRoute",
				data: "routid=" + routid,
				dataType: "json",
				success: function(json) {
					$("#routid").val(routid);
					$("#routver").val(json.ROUTVER);
					$("#routver").attr("disabled","disabled");
					$("#routname").val(json.ROUTNAME);
					$("#notes").val(json.NOTES);										
				}	
			});
			$('#w').window({
				title: '修改路由版本',
				top: panelVertFloat,
		  		left: panelHoriFloat,
		  		width: panelWidth,
		  		height: panelHeight,
				collapsible: false,
				minimizable: false,
				maximizable: false,
				modal: true,
				shadow: false,
				closed: false
			});
			$("#theForm").attr("action", "route/updateRoute");
			$('#btn_submit').linkbutton('enable');
		}
	    //注销 
		function deleteRoute(routid){
			$.ajax({
				type: "POST",
				url: "route/queryOneRoute",
				data: "routid=" + routid,
				dataType: "json",
				success: function(json) {
					$("#routid").val(routid);
					
					$("#routver").val(json.ROUTVER);
					$("#routver").attr("readonly","readonly");
					$("#routver").css("background-color","#BEBEBE");
					
					$("#routname").val(json.ROUTNAME);
					$("#routname").attr("readonly","readonly");
					$("#routname").css("background-color","#BEBEBE");
					
					$("#notes").val(json.NOTES);					
				}	
			});
			$('#w').window({
				title: '注销路由版本', 
				top: panelVertFloat,
		  		left: panelHoriFloat,
		  		width: panelWidth,
		  		height: panelHeight,
				collapsible: false,
				minimizable: false,
				maximizable: false,
				modal: true,
				shadow: false,
				closed: false
			});
			$('#btn_submit').linkbutton('enable');
			$("#theForm").attr("action", "route/deleteRoute"); 			
	    }
		function startRoute(routid){
			$.ajax({
				type: "POST",
				url: "route/queryOneRoute",
				data: "routid=" + routid,
				dataType: "json",
				success: function(json) {
					$("#routid").val(routid);
					$("#routver").val(json.ROUTVER);
					$("#routver").attr("readonly","readonly");
					$("#routname").val(json.ROUTNAME);
					$("#routname").attr("readonly","readonly");
					$("#notes").val(json.NOTES);										
				}	
			});
			$('#w').window({
				title: '启用路由版本', 
				top: panelVertFloat,
		  		left: panelHoriFloat,
		  		width: panelWidth,
		  		height: panelHeight,
				collapsible: false,
				minimizable: false,
				maximizable: false,
				modal: true,
				shadow: false,
				closed: false
			});
			$("#theForm").attr("action", "route/startRoute"); 
			$('#btn_submit').linkbutton('enable');
		}
	
		function resize(){
			$('#dedurateForm :input').val('');
		}
</script>
</html>

