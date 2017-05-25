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
		<div id="p" class="easyui-panel" title="查询条件" style="height: 100px; padding: 10px; background: #fafafa;"
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
				<form id="txnRateForm" action="fee/saveMemberRate" method="post">
					<table width="100%" cellpadding="2" cellspacing="2"
						style="text-align: left">
						<tr>
							<td class="update" width="15%">扣率代码</td>
							<td class="update" width="30%"><input id="rateId_form"  name="rateId" maxlength="10"/></td>
							<td class="update" width="15%">扣率描述</td>
							<td class="update"><input id="rateDes_form" name="rateDes" maxlength="64" /></td>
						</tr>
						<tr>
							<td class="update head-title" width="15%">卡类别</td>
							<td class="update head-title" colspan="3" width="30%">借记卡</td>
						</tr>
						<tr>
							<td class="update">计费方式</td>
							<td class="update"><select id="rateTypeD" class="easyui-validatebox" required="true" name="rateTypeD"
								onchange="showRateDetail('D')" missingMessage="请选择计费方式">
							</select></td>
							<td class="update" width="15%">扣率(百分比)</td>
							<td class="update"><input id="feeRateD" name="feeRateD" required="true" validType="percent" type="text" 
							class="easyui-validatebox" maxlength="5" missingMessage="请输入扣率"/></td>
						</tr>
						<tr>
							<td class="update">最低收费额(元)</td>
							<td class="update"><input id="minFeeD" name="minFeeD" required="true" maxlength="12" validType="amount" 
							type="text" class="easyui-validatebox" missingMessage="请输入最低收费金额"/></td>
							<td class="update" width="15%">最高收费额(元)</td>
							<td class="update"><input id="maxFeeD" name="maxFeeD" required="true" maxlength="12" validType="amount" 
							type="text" class="easyui-validatebox" missingMessage="请输入最高收费金额"/></td>
						</tr>
						<!-- 借记卡end -->
						<!-- 贷记卡start -->
						<tr>
							<td class="update head-title" width="15%">卡类别</td>
							<td class="update head-title" colspan="3" width="30%">贷记卡</td>
						</tr>
						<tr>
							<td class="update">计费方式</td>
							<td class="update"><select id="rateTypeC" class="easyui-validatebox" required="true" name="rateTypeC"
								onchange="showRateDetail('C')" missingMessage="请选择计费方式">
							</select></td>
							<td class="update" width="15%">扣率(百分比)</td>
							<td class="update"><input id="feeRateC" name="feeRateC" required="true" validType="percent" type="text" 
							class="easyui-validatebox" maxlength="5" missingMessage="请输入扣率"/></td>
						</tr>
						<tr>
							<td class="update">最低收费额(元)</td>
							<td class="update"><input id="minFeeC" name="minFeeC" required="true" maxlength="12" validType="amount" 
							type="text" class="easyui-validatebox" missingMessage="请输入最低收费金额"/></td>
							<td class="update" width="15%">最高收费额(元)</td>
							<td class="update"><input id="maxFeeC" name="maxFeeC" required="true" maxlength="12" validType="amount" 
							type="text" class="easyui-validatebox" missingMessage="请输入最高收费金额"/></td>
						</tr>
						<!-- 贷记卡end -->
						<!-- 准贷记卡start -->
						<tr>
							<td class="update head-title" width="15%">卡类别</td>
							<td class="update head-title" colspan="3" width="30%">准贷记卡</td>
						</tr>
						<tr>
							<td class="update">计费方式</td>
							<td class="update"><select id="rateTypeSC" class="easyui-validatebox" required="true" name="rateTypeSC"
								onchange="showRateDetail('SC')" missingMessage="请选择计费方式">
							</select></td>
							<td class="update" width="15%">扣率(百分比)</td>
							<td class="update"><input id="feeRateSC" name="feeRateSC" required="true" validType="percent" type="text" 
							class="easyui-validatebox" maxlength="5" missingMessage="请输入扣率"/></td>
						</tr>
						<tr>
							<td class="update">最低收费额(元)</td>
							<td class="update"><input id="minFeeSC" name="minFeeSC" required="true" maxlength="12" validType="amount" 
							type="text" class="easyui-validatebox" missingMessage="请输入最低收费金额"/></td>
							<td class="update" width="15%">最高收费额(元)</td>
							<td class="update"><input id="maxFeeSC" name="maxFeeSC" required="true" maxlength="12" validType="amount" 
							type="text" class="easyui-validatebox" missingMessage="请输入最高收费金额"/></td>
						</tr>
						<!-- 准贷记卡end -->
						<tr>
							<td class="update">备注</td>
							<td class="update" colspan="3"><textarea id="notes" rows="3" cols="75"
									name="notes" maxlength="32"></textarea></td>
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
	  var panelHeight = 420;
	  var panelHoriFloat = (width-panelWidth)/2;
	  var panelVertFloat = 150;
	  $(function() {
			$.ajax({
				type: "POST",
				url: "fee/queryRateType",
				dataType: "json",
				success: function(json) {
					var html = "<option  Seleted ='Seleted' value=''>--请选择扣计费类型--</option>";
					$.each(json,
					function(key, value) {
						html += '<option value="' + value.PARA_CODE + '">' + value.PARA_NAME + '</option>';
					});
					$("#rateTypeD").html(html);
					$("#rateTypeC").html(html);
					$("#rateTypeSC").html(html);
				}
			});
		});
	  
		$(function() {
			$('#test').datagrid({
				title: '卡分类扣率列表',
				iconCls: 'icon-save',
				height: gridHeight,
				singleSelect: true,
				nowrap: false,
				striped: true,
				url: 'fee/queryNewCardRate',
				remoteSort: false,
				columns: [
				          
				[{
					title: '',
					align: 'center'
					
				},
				{
					title: '',
					align: 'center'
				}, 
				{
					title: '借记卡',
					align: 'center',
					colspan:4
				},
				{
					title: '贷记卡',
					align: 'center',
					colspan:4
				},
				{
					title: '准贷记卡',
					align: 'center',
					colspan:4
				},
				{
					title: '',
					align: 'center',
					colspan:4
				}
 				], 
				[{
					field: 'RATE_ID',
					title: '扣率代码',
					width: 60,
					align: 'center',
					rowspan:1
				},
				{
					field: 'RATE_DESC',
					title: '扣率描述',
					width: 120,
					align: 'center',
					rowspan:1
				},
				{
					field: 'RATE_TYPE_NAME_D',
					title: '计费方式',
					width: 130,
					align: 'center',
					rowspan:1
				},
				{
					field: 'FEE_RATE_D',
					title: '扣率(百分比)',
					width: 90,
					align: 'center',
					rowspan:1
				},
				{
					field: 'MIN_FEE_D',
					title: '最低额(元)',
					width: 90,
					align: 'center',
					rowspan:1
				},
				{
					field: 'MAX_FEE_D',
					title: '最高额(元)',
					width: 90,
					align: 'center',
					rowspan:1
				},
				
				
				{
					field: 'RATE_TYPE_NAME_C',
					title: '计费方式',
					width: 130,
					align: 'center',
					rowspan:1
				},
				{
					field: 'FEE_RATE_C',
					title: '扣率(百分比)',
					width: 90,
					align: 'center',
					rowspan:1
				},
				{
					field: 'MIN_FEE_C',
					title: '最低额(元)',
					width: 90,
					align: 'center',
					rowspan:1
				},
				{
					field: 'MAX_FEE_C',
					title: '最高额(元)',
					width: 90,
					align: 'center',
					rowspan:1
				},
				
				{
					field: 'RATE_TYPE_NAME_SC',
					title: '计费方式',
					width: 130,
					align: 'center',
					rowspan:1
				},
				{
					field: 'FEE_RATE_SC',
					title: '扣率(百分比)',
					width: 90,
					align: 'center',
					rowspan:1
				},
				{
					field: 'MIN_FEE_SC',
					title: '最低额(元)',
					width: 90,
					align: 'center',
					rowspan:1
				},
				{
					field: 'MAX_FEE_SC',
					title: '最高额(元)',
					width: 90,
					align: 'center',
					rowspan:1
				},
				{
					field: 'BUSIID',
					title: '操作',
					width: 90,
					align: 'center',
					formatter: function(value, rec) {
						return '<a href="javascript:showTxnRate(\'' + rec.TID + '\')" style="color:blue;margin-left:10px">修改</a>&nbsp;&nbsp<a href="javascript:showTxnRateDetail(\'' + rec.TID + '\')" style="color:blue;margin-left:10px">详情</a>';
					},
					rowspan:1
				}

				]],
				pagination: true,
				rownumbers: true,
				toolbar: [{
					id: 'btnadd',
					text: '新增卡类型扣率',
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
			$("#txnRateForm").attr("action", "fee/saveNewCardRate");
			$('#w').window({
				title: '卡扣率信息',
				top: panelVertFloat,
		  		left: panelHoriFloat,
		  		width: panelWidth,
		  		height: panelHeight,
				collapsible: false,
				minimizable: false,
				maximizable: false,
				modal: true,
				shadow: true,
				closed: false, 
			});
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
			$("#save_button").show();
			$("#cancel_button").show();
			showAdd(true);
			$.ajax({
				type: "POST",
				url: "fee/queryOneNewCardRate?caseid=" + tid,
				dataType: "json",
				success: function(json) {
					$("#rateId_form").val(json.RATE_ID);
					$("#rateDes_form").val(json.RATE_DESC);
					
					$("#feeRateD").val(json.FEE_RATE_D);
					$("#rateTypeD").val(json.RATE_TYPE_D);
					$("#minFeeD").val(json.MIN_FEE_D);
					$("#maxFeeD").val(json.MAX_FEE_D);
					
					$("#feeRateC").val(json.FEE_RATE_C);
					$("#rateTypeC").val(json.RATE_TYPE_C);
					$("#minFeeC").val(json.MIN_FEE_C);
					$("#maxFeeC").val(json.MAX_FEE_C);
					
					$("#feeRateSC").val(json.FEE_RATE_SC);
					$("#rateTypeSC").val(json.RATE_TYPE_SC);
					$("#minFeeSC").val(json.MIN_FEE_SC);
					$("#maxFeeSC").val(json.MAX_FEE_SC);
					
					$("#notes").val(json.NOTES);
				}
			});
			$("#txnRateForm").attr("action", "fee/updateNewCardRate");
		}
		
		
		function closeAdd() {
			$('#w').window('close');

		}
		
		function search() {
			var data = {
				'rateId': $('#rateId').val(),
				'rateDes': $("#rateDes").val(),
			};
			$('#test').datagrid('load', data);
		}
		
		function showRateDetail(type) {
			var ratatype = $("#rateType"+type).val();
			if(type=='D'){
				if (ratatype == '01') {
					$("#feeRateD").attr("readonly", "readonly");
					$("#feeRateD").val("0");
					$("#maxFeeD").attr("readonly", "readonly");
					$("#maxFeeD").val("0");
					$("#minFeeD").removeAttr("readonly");
					$("#minFeeD").val("");
				} else if (ratatype == '02') {
					$("#feeRateD").removeAttr("readonly");
					$("#feeRateD").val("");
					$("#maxFeeD").attr("readonly", "readonly");
					$("#maxFeeD").val("0");
					$("#minFeeD").attr("readonly", "readonly");
					$("#minFeeD").val("0");
				} else if (ratatype == '03') {
					$("#feeRateD").removeAttr("readonly");
					$("#feeRateD").val("");
					$("#maxFeeD").removeAttr("readonly");
					$("#maxFeeD").val("");
					$("#minFeeD").removeAttr("readonly");
					$("#minFeeD").val("");
				}
			}
			if(type=='C'){
				if (ratatype == '01') {
					$("#feeRateC").attr("readonly", "readonly");
					$("#feeRateC").val("0");
					$("#maxFeeC").attr("readonly", "readonly");
					$("#maxFeeC").val("0");
					$("#minFeeC").removeAttr("readonly");
					$("#minFeeC").val("");
				} else if (ratatype == '02') {
					$("#feeRateC").removeAttr("readonly");
					$("#feeRateC").val("");
					$("#maxFeeC").attr("readonly", "readonly");
					$("#maxFeeC").val("0");
					$("#minFeeC").attr("readonly", "readonly");
					$("#minFeeC").val("0");
				} else if (ratatype == '03') {
					$("#feeRateC").removeAttr("readonly");
					$("#feeRateC").val("");
					$("#maxFeeC").removeAttr("readonly");
					$("#maxFeeC").val("");
					$("#minFeeC").removeAttr("readonly");
					$("#minFeeC").val("");
				}
			}
			if(type=='SC'){
				if (ratatype == '01') {
					$("#feeRateSC").attr("readonly", "readonly");
					$("#feeRateSC").val("0");
					$("#maxFeeSC").attr("readonly", "readonly");
					$("#maxFeeSC").val("0");
					$("#minFeeSC").removeAttr("readonly");
					$("#minFeeSC").val("");
				} else if (ratatype == '02') {
					$("#feeRateSC").removeAttr("readonly");
					$("#feeRateSC").val("");
					$("#maxFeeSC").attr("readonly", "readonly");
					$("#maxFeeSC").val("0");
					$("#minFeeSC").attr("readonly", "readonly");
					$("#minFeeSC").val("0");
				} else if (ratatype == '03') {
					$("#feeRateSC").removeAttr("readonly");
					$("#feeRateSC").val("");
					$("#maxFeeSC").removeAttr("readonly");
					$("#maxFeeSC").val("");
					$("#minFeeSC").removeAttr("readonly");
					$("#minFeeSC").val("");
				}
			}
			
		}
		
		function showTxnRateDetail(tid) {
			showAdd();
			$.ajax({
				type: "POST",
				url: "fee/queryOneNewCardRate?caseid=" + tid,
				dataType: "json",
				success: function(json) {
					$("#rateId_form").val(json.RATE_ID);
					$("#rateDes_form").val(json.RATE_DESC);
					
					$("#feeRateD").val(json.FEE_RATE_D);
					$("#rateTypeD").val(json.RATE_TYPE_D);
					$("#minFeeD").val(json.MIN_FEE_D);
					$("#maxFeeD").val(json.MAX_FEE_D);
					
					$("#feeRateC").val(json.FEE_RATE_C);
					$("#rateTypeC").val(json.RATE_TYPE_C);
					$("#minFeeC").val(json.MIN_FEE_C);
					$("#maxFeeC").val(json.MAX_FEE_C);
					
					$("#feeRateSC").val(json.FEE_RATE_SC);
					$("#rateTypeSC").val(json.RATE_TYPE_SC);
					$("#minFeeSC").val(json.MIN_FEE_SC);
					$("#maxFeeSC").val(json.MAX_FEE_SC);
					
					$("#notes").val(json.NOTES);
				}
			});
			$("#txnRateForm").attr("action", "fee/updateNewCardRate");
			$("#save_button").hide();
			$("#cancel_button").hide();
		}
		function resize(){
			$('#theForm :input').val('');
		}
	</script>
</html>
