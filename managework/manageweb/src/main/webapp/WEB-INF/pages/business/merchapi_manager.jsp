<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="../../top.jsp"></jsp:include>
<html>
<head>
<style type="text/css">
table tr td input {
	height: 15px
}
table tr td select {
	height: 20px
}
table tr td.head-title {
	height: 25px;
	background-color: #F0F8FF;
	font-weight: bold;
	border-width: 1px 1px 1px 1px;
	border-style: groove;
}
table tr td.add {
	height: 25px;
}
table tr td.update {
	height: 25px;
	padding-left: 10px;
	border-width: 1px 1px 1px 1px;
	border-style: groove;
}
</style>
<script type="text/javascript" src="js/extendsValidator_1.0_20151215.js"></script>
</head>
<body>

	<div style="margin: 5px; border:" id="continer">
		<div id="p" class="easyui-panel" title="查询条件"
			style="height: 100px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="theForm" method="post">
				<table width="100%">
					<tr>
						<td class="add" align="right" width="15%">委托机构号</td>
						<td class="add" align="left" style="padding-left: 5px" width="25%">
							<input name="memberid" id="memberids" class="easyui-validatebox" /></td>
						<td class="add" align="right" colspan=2>
							<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a>
							<a href="javascript:resize()" class="easyui-linkbutton" iconCls="icon-redo">清空</a>
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
				<form id="txnRateForm"
					action="merchapi/saveMerch" method="post">
					<input type="hidden" id ="tid" name="tid">
					<table width="100%" cellpadding="2" cellspacing="2" style="text-align: left">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update" align="center" width="15%">委托机构号</td>
							<td class="update" align="left" style="padding-left: 5px" width="25%">
								<input required="true" name="memberid" id="memberid"
								class="easyui-validatebox" missingMessage="请输入委托机构号"/>
							</td>

							<td class="update" align="center" width="15%">产品类型</td>
							<td class="update" align="left" style="padding-left: 5px" width="25%">
								<input required="true" name="biztype" id="biztype"
								class="easyui-validatebox" missingMessage="请输入产品类型"/>
							</td>
						</tr>
						<tr>
							<td class="update" align="center" width="15%">交易类型</td>
							<td class="update" align="left" style="padding-left: 5px" width="25%">
							    <input name="txntype" id="txntype" required="true"
								class="easyui-validatebox" missingMessage="请输入交易类型"/>
								</td>
							<td class="update" align="center" width="15%">交易子类</td>
							<td class="update" align="left" style="padding-left: 5px" width="25%">
								<input name="txnsubtype" id="txnsubtype" required="true"
								class="easyui-validatebox" missingMessage="请输入交易子类"/>
							</td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update" align="center" width="15%">API接口名称</td>
							<td class="update" align="left" style="padding-left: 5px" width="25%">
								<input name="apiname" id="apiname" required="true"
								class="easyui-validatebox" missingMessage="请输入API接口名称"/>
							</td>
							<td class="update" align="center" width="15%">状态</td>
							<td class="update" align="left" style="padding-left: 5px" width="25%">
								<input name="status" id="status" required="true"
								class="easyui-validatebox" missingMessage="请输入状态"/>
							</td>
						</tr>
						<tr>
							<td class="update" align="center" width="15%">备注1</td>
							<td class="update" align="left" style="padding-left: 5px" width="25%">
								<input name="notes" id="notes" required="true"
								class="easyui-validatebox" missingMessage="请输入备注"/>
							</td>

							<td class="update" align="center" width="15%">备注2</td>
							<td class="update" align="left" style="padding-left: 5px" width="25%">
							<input name="remarks" id="remarks" required="true"
								class="easyui-validatebox" missingMessage="请输入备注"/>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false"
				style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" id="save_button" iconCls="icon-ok"
					href="javascript:saveMerch()" onclick="">保存</a> <a
					class="easyui-linkbutton" id="cancel_button" iconCls="icon-cancel"
					href="javascript:void(0)" onclick="closeAdd()">取消</a>
			</div>
		</div>
	</div>
</body>

<script>
	  var width = $("#continer").width();
	  var gridHeight = 600;
	  var panelWidth = 800;
	  var panelHeight = 260;
	  var panelHoriFloat = (width-panelWidth)/2;
	  var panelVertFloat = 150;
	  
	  
		$(function() {
			$('#test').datagrid({
				title: '接口权限列表',
				iconCls: 'icon-save',
				height: gridHeight,
				singleSelect: true,
				nowrap: false,
				striped: true,
				url: 'merchapi/queryMerchs',
				remoteSort: false,
				columns: [[
				           {field: 'MEMBERID',title: '委托机构号',width: 100,align: 'center'},
							{field: 'BIZTYPE',title: '产品类型',width: 100,align: 'center'},
						    {field: 'TXNTYPE',title: '交易类型',width: 100,align: 'center'},
						    {field: 'TXNSUBTYPE',title: '交易子类',width: 100,align: 'center'},
						    {field: 'API_NAME',title: 'API接口名称',width: 100,align: 'center'},
						    {field: 'STATUS',title: '状态',width: 100,align: 'center',
						    	formatter : function(value, rec) {
									if (value == '00') {
										return '启用';
									} else{
										return '禁用';
									}
								}
						    
						    },
						    {field: 'NOTES',title: '备注1',width: 150,align: 'center'},
						    {field: 'REMARKS',title: '备注2',width: 150,align: 'center'},
						    {field: 'TID',title: '操作',width: 150,align: 'center', 
								formatter: function(value, rec) {
									if(rec.STATUS =='00'){                                                                                                   
										return '<a href="javascript:showUpdate(' + value + ')" style="color:blue;margin-left:10px">修改</a>&nbsp;&nbsp;<a href="javascript:changeStatus(false)" style="color:blue;margin-left:10px">禁用</a>';
									}else{
										return '<a href="javascript:showUpdate(' + value + ')" style="color:blue;margin-left:10px">修改</a>&nbsp;&nbsp;<a href="javascript:changeStatus(true)" style="color:blue;margin-left:10px">启用</a>';
									}
							}
				}
				]],
				pagination: true,
				rownumbers: true,
				toolbar: [{
					id: 'btnadd',
					text: '新增接口权限',
					iconCls: 'icon-add',
					handler: function() {
						showAdd(false);
					}
				}]
			});
			var p = $('#test').datagrid('getPager');
		});
		
		function changeStatus(status){
			var rows = $('#test').datagrid('getSelected');
			var st;
			if(status==true){
				st="00"
			}else{
				st="01"
			}
			var datas = {
					'status': st,
					'tid':rows["TID"]
				};
			$.ajax({
				type: "POST",
				url: "merchapi/changeStatus",
				data:datas,
				dataType: "json",
				success: function(json) {
					$.messager.alert('提示', json.flag);
					search();
				}
			});
			
		}
		
		
		function showAdd(isToModify) {
			$("#save_button").show();
			$("#cancel_button").show();
			$("#save_button").linkbutton('enable');
			$('#txnRateForm').clearForm();
			$("#txnRateForm").attr("action", "merchapi/saveMerch");
			$('#w').window({
				title: '接口权限信息',
				top: panelVertFloat,
		  		left: panelHoriFloat,
		  		width: panelWidth,
		  		height: panelHeight,
				collapsible: false,
				minimizable: false,
				maximizable: false,
				modal: true,
				shadow: true,
				closed: false
			});
		}
		function saveMerch() {
			if ($('#txnRateForm').form("validate")) {
				$("#save_button").linkbutton('disable');
				$('#txnRateForm').form('submit', {
					onSubmit: function() {
						return $('#txnRateForm').form('validate');
					},
					success: function(data) {
						if(data.split("validateUserLoginAction").length>1){
							window.parent.location.replace("<%=basePath%>"+"pages/logoutAction.action?relogin=relogin");
							return ;
						}
						if (data == '添加成功!') {
							closeAdd();
							search();
						} else if (data == '修改成功!') {
							closeAdd();
							search();
						} else {
							closeAdd();
							$.messager.alert('提示', data);
							$("#save_button").linkbutton('enable');
						}
					}
				});
			}
		}
		function showUpdate(tid) {
			showAdd(true);
			$("#save_button").show();
			$("#cancel_button").show();
			
			var rows = $('#test').datagrid('getSelected');
			$("#tid").val(rows["TID"]);
			$("#memberid").val(rows["MEMBERID"]);
			$("#biztype").val(rows["BIZTYPE"]);
			$("#txntype").val(rows["TXNTYPE"]);
			$("#txnsubtype").val(rows["TXNSUBTYPE"]);
			$("#apiname").val(rows["API_NAME"]);
			if(rows["STATUS"]=='00'){
				$("#status").val('启用');
			}else{
				$("#status").val('禁用');
			}
			
			$("#notes").val(rows["NOTES"]);
			$("#remarks").val(rows["REMARKS"]);
			$("#txnRateForm").attr("action", "merchapi/updateMerch");
		}
		function closeAdd() {
			$('#w').window('close');
		}
		function search() {
			var data = {
				'memberid': $('#memberids').val()
			};
			$('#test').datagrid('load', data);
		}
		
		function resize(){
			$('#theForm :input').val('');
		}
	</script>
</html>
