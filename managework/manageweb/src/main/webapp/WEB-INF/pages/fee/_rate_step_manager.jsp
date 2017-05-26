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
							<input id="rateId"  name="rateId" maxlength="10"/></td>
						<td class="add" align="right" width="15%">扣率描述</td>
						<td class="add" align="left" style="padding-left: 5px" width="25%">
							<input id="rateDes" name="rateDes" maxlength="64" /></td>
						<td class="add" align="right">
						<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a>
						<a href="javascript:resize()" class="easyui-linkbutton" iconCls="icon-redo">清空</a></td>
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
					action="fee/saveStepRate" method="post">
					<table width="100%" cellpadding="2" cellspacing="2"
						style="text-align: left">
						<tr>
							<td class="update" width="15%">扣率代码</td>
							<td class="update" width="30%"><input id="rateId_form"  name="rateId" maxlength="10"/></td>
							<td class="update" width="15%">扣率描述</td>
							<td class="update"><input id="rateDes_form" name="rateDes" maxlength="64" /></td>
						</tr>
						<tr>
							<td class="update">计费方式</td>
							<td class="update"><select id="rateType" class="easyui-validatebox" required="true" name="rateType"
								onchange="showRateDetail()" missingMessage="请输入计费方式">
							</select></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>	
							<td class="update" width="15%">扣率(百分比)</td>
							<td class="update"><input id="feeRate" name="feeRate" required="true" validType="percent" type="text" 
							class="easyui-validatebox" maxlength="5" missingMessage="请输入扣率"/></td>
						</tr>
						<tr>
							<td class="update">最低收费额(元)</td>
							<td class="update"><input id="minFee" name="minFee" required="true" validType="amount" maxlength="12" 
							type="text" class="easyui-validatebox" missingMessage="请输入最低收费金额"/></td>
							<td class="update" width="15%">最高收费额(元)</td>
							<td class="update"><input id="maxFee" name="maxFee" required="true" validType="amount" maxlength="12" 
							type="text" class="easyui-validatebox" missingMessage="请输入最高收费金额"/></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update">分界线1(元)</td>
							<td class="update"><input id="limit1" name="limit1" validType="amount" type="text" class="easyui-validatebox"
								maxlength="12" missingMessage="请输入金额"/></td>
							<td class="update" width="15%">扣率(百分比)</td>
							<td class="update"><input id="feeRate2" name="feeRate2" required="true" validType="percent" type="text" 
							class="easyui-validatebox" maxlength="5" missingMessage="请输入金额"/></td>
						</tr>
						<tr>
							<td class="update">最低收费额(元)</td>
							<td class="update"><input id="minFee2" name="minFee2" required="true" maxlength="12" validType="amount" 
							type="text" class="easyui-validatebox" missingMessage="请输入最低收费金额"/></td>
							<td class="update" width="15%">最高收费额(元)</td>
							<td class="update"><input id="maxFee2" name="maxFee2" required="true" maxlength="12" validType="amount" 
							type="text" class="easyui-validatebox" missingMessage="请输入收费金额"/></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update">分界线2(元)</td>
							<td class="update"><input id="limit2" name="limit2" validType="amount" type="text" class="easyui-validatebox"
								maxlength="12" missingMessage="请输入金额"/></td>
							<td class="update" width="15%">扣率(百分比)</td>
							<td class="update"><input id="feeRate3" name="feeRate3" required="true" validType="percent" type="text" 
							class="easyui-validatebox" maxlength="5" missingMessage="请输入扣率"/></td>
						</tr>
						<tr>
							<td class="update">最低收费额(元)</td>
							<td class="update"><input id="minFee3" name="minFee3" required="true" maxlength="12" validType="amount" 
							type="text" class="easyui-validatebox" missingMessage="请输入最低收费金额"/></td>
							<td class="update" width="15%">最高收费额(元)</td>
							<td class="update"><input id="maxFee3" name="maxFee3" required="true" maxlength="12" validType="amount" 
							type="text" class="easyui-validatebox" missingMessage="请输入最高收费金额"/></td>
						</tr>
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
	  var panelHeight = 470;
	  var panelHoriFloat = (width-panelWidth)/2;
	  var panelVertFloat = 150;
	  var width = $("#continer").width();
	  
	  
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
					$("#rateType").html(html);
				}
			});
		});
	  
		$(function() {
			$('#test').datagrid({
				title: '分段扣率列表',
				iconCls: 'icon-save',
				height: gridHeight,
				singleSelect: true,
				nowrap: false,
				striped: true,
				url: 'fee/queryStepRate',
				remoteSort: false,
				columns: [
				[{
					title: '',
					align: 'center',
						
				},
				{
					title: '',
					align: 'center'
				}, 
				{
					title: '',
					align: 'center'
				},
				{
					title: '段1',
					align: 'center',
					colspan:3
				},
				{
					title: '',
					align: 'center',
				},
				{
					title: '段2',
					align: 'center',
					colspan:3
				},
				{
					title: '',
					align: 'center',
				},
				{
					title: '段3',
					align: 'center',
					colspan:3
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
					field: 'RATE_TYPE_NAME',
					title: '计费方式',
					width: 150,
					align: 'center',
					rowspan:1
				},
				{
					field: 'FEE_RATE',
					title: '扣率(百分比)',
					width: 100,
					align: 'center',
						rowspan:1
				},
				{
					field: 'MIN_FEE',
					title: '最低额(元)',
					width: 100,
					align: 'center',
					rowspan:1
				},
				{
					field: 'MAX_FEE',
					title: '最高额(元)',
					width: 100,
					align: 'center',
					rowspan:1
				},
				{field: 'LIMIT1',title: '分割线(元)',width: 100,align: 'center',rowspan:1,
					formatter:function(value,rec){
						return fenToYuan(rec.LIMIT1);
					}
				},
				{field: 'FEE_RATE2',title: '扣率(百分比)',width: 100,align: 'center',rowspan:1},
				{field: 'MIN_FEE2',title: '最低额(元)',width: 100,align: 'center',rowspan:1},
				{field: 'MAX_FEE2',title: '最高额(元)',width: 100,align: 'center',rowspan:1},
				{field: 'LIMIT2',title: '分割线(元)',width: 100,align: 'center',rowspan:1,
					formatter:function(value,rec){
						return fenToYuan(rec.LIMIT2);
					}
				},
				{field: 'FEE_RATE3',title: '扣率(百分比)',width: 100,align: 'center',rowspan:1},
				{field: 'MIN_FEE3',title: '最低额(元)',width: 100,align: 'center',rowspan:1
				},
				{
					field: 'MAX_FEE3',
					title: '最高额(元)',
					width: 100,
					align: 'center',
					rowspan:1
				},
				{
					field: 'BUSIID',
					title: '操作',
					width: 100,
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
					text: '新增分段类型扣率',
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
			$("#save_button").linkbutton('enable');
			$('#txnRateForm :input').val('');
			$('#notes').val('');
// 			$('#txnRateForm').clearForm();
			$("#txnRateForm").attr("action", "fee/saveStepRate");
			$('#w').window({
				title: '分段扣率信息',
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
			var ratatype = $("#rateType").val();
	       var minfee =$("#minFee").val();
	       var maxfee = $("#maxFee").val();
	       var minfee2 = $("#minFee2").val();
	       var maxfee2 = $("#maxFee2").val();
	       var minfee3 = $("#minFee3").val();
	       var maxfee3 = $("#maxFee3").val();
	       var minfee_min = parseFloat(minfee);
	       var maxfee_max = parseFloat(maxfee);
	       var minfee2_min = parseFloat(minfee2);
	       var maxfee2_max = parseFloat(maxfee2);
	       var minfee3_min = parseFloat(minfee3);
	       var maxfee3_max = parseFloat(maxfee3);
	       if(ratatype=="03" && ((minfee_min >=maxfee_max) || (minfee2_min >=maxfee2_max) || (minfee3_min>=maxfee3_max))){
	    	   alert("最低收费额不能大于等于最高收费额");
	       }else{
				if ($('#txnRateForm').form("validate")) {
					$("#save_button").linkbutton('disable');
					$('#txnRateForm').form('submit', {
						onSubmit: function() {
							return $('#txnRateForm').form('validate');
						},
						success: function(data) {
							if (data == '添加成功!') {
								alert(data);
								closeAdd();
								search();
							} else if (data == '修改成功!') {
								alert(data);
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

		}
		function showTxnRate(tid) {
			$("#save_button").show();
			$("#cancel_button").show();
			showAdd(true);
			$.ajax({
				type: "POST",
				url: "fee/queryOneStepRate?caseid=" + tid,
				dataType: "json",
				success: function(json) {
					$("#rateId_form").val(json.RATE_ID);
					$("#rateDes_form").val(json.RATE_DESC);
					$("#rateType").val(json.RATE_TYPE);
					$("#feeRate").val(json.FEE_RATE);
					$("#minFee").val(json.MIN_FEE);
					$("#maxFee").val(json.MAX_FEE);
					$("#feeRate2").val(json.FEE_RATE2);
					$("#minFee2").val(json.MIN_FEE2);
					$("#maxFee2").val(json.MAX_FEE2);
					$("#feeRate3").val(json.FEE_RATE3);
					$("#minFee3").val(json.MIN_FEE3);
					$("#maxFee3").val(json.MAX_FEE3);
					$("#limit1").val(json.LIMIT1);
					$("#limit2").val(json.LIMIT2);
					$("#notes").val(json.NOTES);
				}
			});
			$("#txnRateForm").attr("action", "fee/updateStepRate");
	
		}
		function closeAdd() {
			$('#w').window('close');
	
		}
		function search() {
			var data = {
				'rateId': $('#rateId').val(),
				'rateDes': $('#rateDes').val()
			};
			$('#test').datagrid('load', data);
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
				
				$("#feeRate2").attr("readonly", "readonly");
				$("#feeRate2").val("0");
				$("#maxFee2").attr("readonly", "readonly");
				$("#maxFee2").val("0");
				$("#minFee2").removeAttr("readonly");
				$("#minFee2").val("");
				
				$("#feeRate3").attr("readonly", "readonly");
				$("#feeRate3").val("0");
				$("#maxFee3").attr("readonly", "readonly");
				$("#maxFee3").val("0");
				$("#minFee3").removeAttr("readonly");
				$("#minFee3").val("");
			} else if (ratatype == '02') {
				$("#feeRate").removeAttr("readonly");
				$("#feeRate").val("");
				$("#maxFee").attr("readonly", "readonly");
				$("#maxFee").val("0");
				$("#minFee").attr("readonly", "readonly");
				$("#minFee").val("0");
				
				$("#feeRate2").removeAttr("readonly");
				$("#feeRate2").val("");
				$("#maxFee2").attr("readonly", "readonly");
				$("#maxFee2").val("0");
				$("#minFee2").attr("readonly", "readonly");
				$("#minFee2").val("0");
				
				$("#feeRate3").removeAttr("readonly");
				$("#feeRate3").val("");
				$("#maxFee3").attr("readonly", "readonly");
				$("#maxFee3").val("0");
				$("#minFee3").attr("readonly", "readonly");
				$("#minFee3").val("0");
			} else if (ratatype == '03') {
				$("#feeRate").removeAttr("readonly");
				$("#feeRate").val("");
				$("#maxFee").removeAttr("readonly");
				$("#maxFee").val("");
				$("#minFee").removeAttr("readonly");
				$("#minFee").val("");
				
				$("#feeRate2").removeAttr("readonly");
				$("#feeRate2").val("");
				$("#maxFee2").removeAttr("readonly");
				$("#maxFee2").val("");
				$("#minFee2").removeAttr("readonly");
				$("#minFee2").val("");
				
				$("#feeRate3").removeAttr("readonly");
				$("#feeRate3").val("");
				$("#maxFee3").removeAttr("readonly");
				$("#maxFee3").val("");
				$("#minFee3").removeAttr("readonly");
				$("#minFee3").val("");
			}
	
		}
		function showTxnRateDetail(tid) {
			showAdd();
			$.ajax({
				type: "POST",
				url: "fee/queryOneStepRate?caseid=" + tid,
				dataType: "json",
				success: function(json) {
					$("#rateId_form").val(json.RATE_ID);
					$("#rateDes_form").val(json.RATE_DESC);
					$("#rateType").val(json.RATE_TYPE);
					$("#feeRate").val(json.FEE_RATE);
					$("#minFee").val(json.MIN_FEE);
					$("#maxFee").val(json.MAX_FEE);
					$("#minFee2").val(json.MIN_FEE2);
					$("#maxFee2").val(json.MAX_FEE2);
					$("#minFee3").val(json.MIN_FEE3);
					$("#maxFee3").val(json.MAX_FEE3);
					$("#limit1").val(json.LIMIT1);
					$("#limit2").val(json.LIMIT2);
					$("#feeRate2").val(json.FEE_RATE2);
					$("#feeRate3").val(json.FEE_RATE3);
					$("#notes").val(json.NOTES);				
				}
			});
			$("#txnRateForm").attr("action", "fee/updateStepRate");
			$("#save_button").hide();
			$("#cancel_button").hide();
		}
		function resize(){
			$('#theForm :input').val('');
		}
		function fenToYuan(value){
			var str = (value).toFixed(2) + '';
			var intSum = str.substring(0,str.indexOf(".")).replace( /\B(?=(?:\d{3})+$)/g, ',' );
			var dot = str.substring(str.length,str.indexOf("."))
			var ret = intSum + dot;
			return ret;
		}
	</script>
</html>
