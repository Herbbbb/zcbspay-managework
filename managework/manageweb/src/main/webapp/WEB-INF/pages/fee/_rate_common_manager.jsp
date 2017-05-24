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
						<td class="add" align="right" width="15%">扣率代码</td>
						<td class="add" align="left" style="padding-left: 5px" width="25%">
							<input id="rateId"  name="rateId" maxlength="10"/>
						</td>
						<td class="add" align="right" width="15%">扣率描述</td>
						<td class="add" align="left" style="padding-left: 5px" width="25%">
							<input id="rateDes" name="rateDes" maxlength="64" />
						</td>
						<td class="add" align="right">
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
					action="fee/saveTxnRate" method="post">
					<table width="100%" cellpadding="2" cellspacing="2"
						style="text-align: left">
						<tr>
							<td class="update" width="15%">扣率代码</td>
							<td class="update" width="30%"><input id="rateId-form"  name="rateId" maxlength="10"/></td>
							<td class="update" width="15%">扣率描述</td>
							<td class="update"><input id="rateDes-form" name="rateDes" maxlength="64" /></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update">计费方式</td>
							<td class="update"><select id="rateType" class="easyui-validatebox" required="true" name="rateType"
								onchange="showRateDetail()" missingMessage="请选择计费方式">
							</select></td>
							<td class="update" width="15%">扣率(百分比)</td>
							<td class="update"><input id="feeRate" name="feeRate" validType="percent" required="true" type="text"
								class="easyui-validatebox" maxlength="5" missingMessage="请输入扣率"/></td>
						</tr>
						<tr>
							<td class="update">最低收费额(元)</td>
							<td class="update"><input id="minFee" name="minFee" maxlength="12" validType="amount" required="true"
							 type="text" class="easyui-validatebox" missingMessage="请输入最低收费金额"/></td>
							<td class="update" width="15%">最高收费额(元)</td>
							<td class="update"><input id="maxFee" name="maxFee" required="true" maxlength="12" validType="amount" 
							type="text" class="easyui-validatebox" missingMessage="请输入最高收费金额"/></td>
						</tr>
						<tr>
							<td class="update">备注</td>
							<td class="update" colspan="3"><textarea id="notes" rows="3" cols="75" name="notes" maxlength="32"></textarea></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false"
				style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" id="save_button" iconCls="icon-ok"
					href="javascript:saveTxnRate()" onclick="">保存</a> <a
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
			$.ajax({
				type: "POST",
				url: "fee/queryRateType",
				dataType: "json",
				success: function(json) {
					var html = "<option selected = 'selected'  value=''>--请选择扣计费类型--</option>";
					$.each(json,
					function(key, value) {
						html += '<option value="' + value.PARA_CODE + '">' + value.PARA_NAME + '</option>';
					});
					$("#rateType").html(html);
				}
			});
		});
	  
	  
		$(function() {
			$('#test').datagrid({
				title: '常规扣率列表',
				iconCls: 'icon-save',
				height: gridHeight,
				singleSelect: true,
				nowrap: false,
				striped: true,
				url: 'fee/queryCommonRate',
				remoteSort: false,
				columns: [[{
					field: 'RATE_ID',
					title: '扣率代码',
					width: 150,
					align: 'center'
				},
				{
					field: 'RATE_DESC',
					title: '扣率描述',
					width: 120,
					align: 'center'
				},
				{
					field: 'RATE_TYPE_NAME',
					title: '计费方式',
					width: 150,
					align: 'center'
				},
				{
					field: 'FEE_RATE',
					title: '扣率(百分比)',
					width: 100,
					align: 'center'
				},
				{
					field: 'MIN_FEE',
					title: '最低额(元)',
					width: 100,
					align: 'center'
				},
				{
					field: 'MAX_FEE',
					title: '最高额(元)',
					width: 100,
					align: 'center'
				},
				{
					field: 'BUSIID',
					title: '操作',
					width: 100,
					align: 'center',
					formatter: function(value, rec) {
						return '<a href="javascript:showTxnRate(\'' + rec.TID + '\')" style="color:blue;margin-left:10px">修改</a>&nbsp;&nbsp;<a href="javascript:showTxnRateDetail(\'' + rec.TID + '\')" style="color:blue;margin-left:10px">详情</a>';
					}
				}
				]],
				pagination: true,
				rownumbers: true,
				toolbar: [{
					id: 'btnadd',
					text: '新增常规类型扣率',
					iconCls: 'icon-add',
					handler: function() {
						showAdd(false);
					}
				}]
			});
			var p = $('#test').datagrid('getPager');
		});
		function showAdd(isToModify) {
			$("#save_button").show();
			$("#cancel_button").show();
			if(!isToModify){
				$("#busipack").removeAttr("disabled");
				$("#busicase").removeAttr("disabled");
			}else{
				$("#busipack").attr("disabled","disabled");
				$("#busicase").attr("disabled","disabled");
			}
			$("#save_button").linkbutton('enable');
			$('#txnRateForm :input').val('');
			$('#notes').val('');
// 			$('#txnRateForm').clearForm();
			$("#txnRateForm").attr("action", "fee/saveCommonRate");
			$('#w').window({
				title: '常规类型扣率',
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
			//showFee();
		}
		function saveTxnRate() {
			if ($('#txnRateForm').form("validate")) {
				$("#save_button").linkbutton('disable');
				$('#txnRateForm').form('submit', {
					onSubmit: function() {
						$("#busipack").removeAttr("disabled");
						$("#busicase").removeAttr("disabled");
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
							alert(data);
							$("#save_button").linkbutton('enable');
						}
					}
				});
			}
		}
		function showTxnRate(tid) {
			showAdd(true);
			$("#save_button").show();
			$("#cancel_button").show();
			$.ajax({
				type: "POST",
				url: "fee/queryOneCommonRate?caseid=" + tid,
				dataType: "json",
				success: function(json) {
					$("#rateId-form").val(json.RATE_ID);
					$("#rateDes-form").val(json.RATE_DESC);
					$("#rateType").val(json.RATE_TYPE);
					$("#feeRate").val(json.FEE_RATE);
					$("#minFee").val(json.MIN_FEE);
					$("#maxFee").val(json.MAX_FEE);
				}
			});
			$("#txnRateForm").attr("action", "fee/updateCommonRate");
		}
		function closeAdd() {
			$('#w').window('close');
		}
		function search() {
			var data = {
				'rateId': $('#rateId').val(),
				'rateDes': $("#rateDes").val()
			};
			$('#test').datagrid('load', data);
		}
		function showTxnRateDetail(tid) {
			showAdd();
			$.ajax({
				type: "POST",
				url: "fee/queryOneCommonRate?caseid=" + tid,
				dataType: "json",
				success: function(json) {
					$("#feeRate").val(json.FEE_RATE);
					$("#rateId-form").val(json.RATE_ID);
					$("#rateDes-form").val(json.RATE_DESC);
					$("#rateType").val(json.RATE_TYPE);
					$("#minFee").val(json.MIN_FEE);
					$("#maxFee").val(json.MAX_FEE);
					$("#notes").val(json.NOTES);
					setTimeout(function() {
						$("#busicase").val(json.BUSICODE);
						$("#busipack").val(json.FEEVER);
					},
					500);
				}
			});
			$("#txnRateForm").attr("action", "fee/updateBusiRate");
			$("#save_button").hide();
			$("#cancel_button").hide();
		}
	
		function showRateDetail() {
			var ratatype = $("#rateType").val();
			if (ratatype == '01') {
				$("#feeRate").attr("readonly", "readonly");
				$("#feeRate").val("0");
				$("#maxFee").attr("readonly", "readonly");
				$("#maxFee").val("0");
				$("#minFee").removeAttr("readonly");
				$("#minFee").val("");
			} else if (ratatype == '02') {
				$("#feeRate").removeAttr("readonly");
				$("#feeRate").val("");
				$("#maxFee").attr("readonly", "readonly");
				$("#maxFee").val("0");
				$("#minFee").removeAttr("readonly");
				$("#minFee").val("");
			} else if (ratatype == '03') {
				$("#feeRate").removeAttr("readonly");
				$("#feeRate").val("");
				$("#maxFee").removeAttr("readonly");
				$("#maxFee").val("");
				$("#minFee").removeAttr("readonly");
				$("#minFee").val("");
			}
		}
		function resize(){
			$('#theForm :input').val('');
		}
	</script>
</html>
