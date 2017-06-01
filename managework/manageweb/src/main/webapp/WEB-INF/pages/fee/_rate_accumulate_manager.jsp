<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>
<html>
<head>
<style type="text/css">
table tr td {
	height: 25px
}

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
				<form id="accumulateRateForm" action="" method="post">
					<table width="100%" cellpadding="2" cellspacing="2" style="text-align: left">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update" width="15%">扣率代码</td>
							<td class="update" width="30%"><input id="rateId_form"  name="rateId" maxlength="10"/></td>
							<td class="update" width="15%">扣率描述</td>
							<td class="update"><input id="rateDes_form" name="rateDes" maxlength="64" /></td>
						</tr>
						<tr>
							<td class="update">累计方式</td>
							<td class="update"><select id="accmode" class="easyui-validatebox"
								required="true" name="accmode" missingMessage="请选择累计方式"/>
								<option value="" selected="selected">--请选择累计方式--</option>
								<option value="0">日</option>
								<option value="1">月</option>
								<option value="2">年</option> </select></td>
							<td class="update">计费方式</td>
							<td class="update"><select id="rateType" class="easyui-validatebox" required="true" name="rateType"
								onchange="showRateDetail()" missingMessage="请选择计费方式">
								<option value='' selected="selected">请选择计费方式</option></select></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update" width="15%">扣率(百分比)</td>
							<td class="update"><input id="feerate" name="feerate" class="easyui-validatebox" 
								required="true" validType="percent" type="text" maxlength="4" missingMessage="请输入扣率"/></td>
						</tr>
						<tr>
							<td class="update">最低收费额(元)</td>
							<td class="update"><input id="minfee" name="minfee" required="true" validType="amount" maxlength="12" 
								type="text" class="easyui-validatebox" missingMessage="请输入最低收费金额"/></td>
							<td class="update" width="15%">最高收费额(元)</td>
							<td class="update"><input id="maxfee" name="maxfee" required="true" validType="amount" maxlength="12"
								 type="text" class="easyui-validatebox" missingMessage="请输入最高收费金额"/></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update">阶梯1(元)</td>
							<td class="update"><input id="limit1" name="limit1" validType="amount" type="text" class="easyui-validatebox"
								maxlength="12" missingMessage="请输入金额"/></td>
							<td class="update" width="15%">扣率(百分比)</td>
							<td class="update"><input id="feerate2"
								name="feerate2" validType="percent" required="true"
								type="text" class="easyui-validatebox" maxlength="4" missingMessage="请输入扣率"/><font color="red">*</font></td>
						</tr>
						
						<tr>
							<td class="update">最低收费额(元)</td>
							<td class="update"><input id="minfee2" name="minfee2" maxlength="12" required="true" validType="amount" 
							type="text" class="easyui-validatebox" missingMessage="请输入最低收费金额"/></td>
							<td class="update" width="15%">最高收费额(元)</td>
							<td class="update"><input id="maxfee2" name="maxfee2" maxlength="12" required="true" validType="amount" 
							type="text" class="easyui-validatebox" missingMessage="请输入最高收费金额"/></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update">阶梯2(元)</td>
							<td class="update"><input id="limit2" name="limit2" validType="amount" type="text" class="easyui-validatebox"
								maxlength="12" missingMessage="请输入金额"/></td>
							<td class="update" width="15%">扣率(百分比)</td>
							<td class="update"><input id="feerate3"
								name="feerate3" validType="percent" required="true"
								type="text" class="easyui-validatebox" maxlength="4" missingMessage="请输入扣率"/><font color="red">*</font></td>
						</tr>
						<tr>
							<td class="update">最低收费额(元)</td>
							<td class="update"><input id="minfee3" name="minfee3" maxlength="12" required="true" validType="amount" 
							type="text" class="easyui-validatebox" missingMessage="请输入最低收费金额"/></td>
							<td class="update" width="15%">最高收费额(元)</td>
							<td class="update"><input id="maxfee3" name="maxfee3" maxlength="12" required="true" validType="amount" 
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
					href="javascript:saveAccumulateRate()" onclick="">保存</a> <a
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
				title: '累计分段扣率列表',
				iconCls: 'icon-save',
				height: gridHeight,
				singleSelect: true,
				nowrap: false,
				striped: true,
				url: 'fee/queryAccumulateRate',
	
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
					field: 'ACCMODE',title: '累计方式', width: 100,align: 'center',
						formatter : function(value, rec) {
							if (value == 0) {
								return '日';
							} else if (value == 1) {
								return '月';
							} else if(value == 2){
								return '年';
							}
						}
				},
				{
					field: 'RATE_TYPE_NAME',
					title: '计费方式',
					width: 150,
					align: 'center',
				},
				
				{field: 'FEE_RATE',title: '扣率(百分比)',width: 100,align: 'center'},
				{field: 'MIN_FEE',title: '最低收费额(元)',width: 100,align: 'center'},
				{field: 'MAX_FEE',title: '最高收费额(元)',width: 100,align: 'center'},
				{field: 'LIMIT1',title: '分割线(元)',width: 100,align: 'center',
					formatter:function(value,rec){
						return fenToYuan(rec.LIMIT1);
					}
				},
				{field: 'FEE_RATE2',title: '扣率(百分比)',width: 100,align: 'center'},
				{field: 'MIN_FEE2',title: '最低收费额(元)',width: 100,align: 'center'},
				{field: 'MAX_FEE2',title: '最高收费额(元)',width: 100,align: 'center'},
				{field: 'LIMIT2',title: '分割线(元)',width: 100,align: 'center',
					formatter:function(value,rec){
						return fenToYuan(rec.LIMIT2);
					}
				},
				{field: 'FEE_RATE3',title: '扣率(百分比)',width: 100,align: 'center'},
				{field: 'MIN_FEE3',title: '最低收费额(元)',width: 100,align: 'center'},
				{field: 'MAX_FEE3',title: '最高收费额(元)',width: 100,align: 'center'},
				{
					field: 'TID',
					title: '操作',
					width: 100,
					align: 'center',
					formatter: function(value, rec) {
						return '<a href="javascript:showAccumulateRate(\'' + rec.TID + '\')" style="color:blue;margin-left:10px">修改</a>'
						+'&nbsp;&nbsp<a href="javascript:showAccumulateRateDetail(\'' + rec.TID + '\')" style="color:blue;margin-left:10px">详情</a>';
					}
				}
	
				]],
				pagination: true,
				rownumbers: true,
				toolbar: [{
					id: 'btnadd',
					text: '新增累计类型扣率',
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
			$("#cancel_button").linkbutton('enable');
			$('#accumulateRateForm :input').val('');
			$('#notes').val('');
			$("#accumulateRateForm").attr("action", "fee/saveAccumulateRate");
			$('#w').window({
				title: '累计扣率信息',
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
		//保存 
		function saveAccumulateRate() {
			   var ratatype = $("#rateType").val();
		       var minfee =$("#minfee").val();
		       var maxfee = $("#maxfee").val();
		       var minfee2 = $("#minfee2").val();
		       var maxfee2 = $("#maxfee2").val();
		       var minfee3 = $("#minfee3").val();
		       var maxfee3 = $("#maxfee3").val();
		       var minfee_min = parseFloat(minfee);
		       var maxfee_max = parseFloat(maxfee);
		       var minfee2_min = parseFloat(minfee2);
		       var maxfee2_max = parseFloat(maxfee2);
		       var minfee3_min = parseFloat(minfee3);
		       var maxfee3_max = parseFloat(maxfee3);
		       if(ratatype=="03" && ((minfee_min >maxfee_max) || (minfee2_min >maxfee2_max) || (minfee3_min>maxfee3_max))){
		    	   alert("最低收费额不能大于最高收费额");
		       }else if($("#rateType").val() == null || $("#rateType").val() == ""){
		    	   alert("请选择计费方式");
		       } else{
					if ($('#accumulateRateForm').form("validate")) {
						$("#save_button").linkbutton('disable');
						$('#accumulateRateForm').form('submit', {
							onSubmit: function() {
								$("#busipack").removeAttr("disabled");
								$("#busicase").removeAttr("disabled");
								return $('#accumulateRateForm').form('validate');
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
		function showAccumulateRate(tid) {
			showAdd(true);
			$("#save_button").show();
			$("#cancel_button").show();
			$.ajax({
				type: "POST",
				url: "fee/queryOneAccumulateRate?caseid=" + tid,
				async:false,
				dataType: "json",
				success: function(json) {	
					$("#rateId_form").val(json.RATE_ID);
					$("#rateDes_form").val(json.RATE_DESC);
					$("#rateType").val(json.RATE_TYPE);
					
					$("#feerate").val(json.FEE_RATE);
					$("#accmode").val(json.ACCMODE);
					$("#minfee").val(json.MIN_FEE);
					$("#maxfee").val(json.MAX_FEE);
					$("#limit1").val(json.LIMIT1);
					$("#feerate2").val(json.FEE_RATE2);
					$("#minfee2").val(json.MIN_FEE2);
					$("#maxfee2").val(json.MAX_FEE2);
					
					$("#limit2").val(json.LIMIT2);
					$("#feerate3").val(json.FEE_RATE3);
					$("#minfee3").val(json.MIN_FEE3);
					$("#maxfee3").val(json.MAX_FEE3);
					
					$("#notes").val(json.NOTES);
				}
			});
			$("#accumulateRateForm").attr("action", "fee/updateAccumulateRate");
	
		}
		function closeAdd() {
			$('#w').window('close');
	
		}
		function search() {
			var data = {
				'rateId': $('#rateId').val(),
				'rateDes':$('#rateDes').val()
			};
			$('#test').datagrid('load', data);
		}
		function showRateDetail() {
			var ratatype = $("#rateType").val();
			if (ratatype == '01') {
				$("#feerate").attr("readonly", "readonly");
				$("#feerate").val("0");
				$("#maxfee").attr("readonly", "readonly");
				$("#maxfee").val("0");
				$("#minfee").removeAttr("readonly");
				$("#minfee").val("");
				
				$("#feerate2").attr("readonly", "readonly");
				$("#feerate2").val("0");
				$("#maxfee2").attr("readonly", "readonly");
				$("#maxfee2").val("0");
				$("#minfee2").removeAttr("readonly");
				$("#minfee2").val("");
				
				$("#feerate3").attr("readonly", "readonly");
				$("#feerate3").val("0");
				$("#maxfee3").attr("readonly", "readonly");
				$("#maxfee3").val("0");
				$("#minfee3").removeAttr("readonly");
				$("#minfee3").val("");
			} else if (ratatype == '02') {
				$("#feerate").removeAttr("readonly");
				$("#feerate").val("");
				$("#maxfee").attr("readonly", "readonly");
				$("#maxfee").val("0");
				$("#minfee").attr("readonly", "readonly");
				$("#minfee").val("0");
				
				$("#feerate2").removeAttr("readonly");
				$("#feerate2").val("");
				$("#maxfee2").attr("readonly", "readonly");
				$("#maxfee2").val("0");
				$("#minfee2").attr("readonly", "readonly");
				$("#minfee2").val("0");
				
				$("#feerate3").removeAttr("readonly");
				$("#feerate3").val("");
				$("#maxfee3").attr("readonly", "readonly");
				$("#maxfee3").val("0");
				$("#minfee3").attr("readonly", "readonly");
				$("#minfee3").val("0");
			} else if (ratatype == '03') {
				$("#feerate").removeAttr("readonly");
				$("#feerate").val("");
				$("#maxfee").removeAttr("readonly");
				$("#maxfee").val("");
				$("#minfee").removeAttr("readonly");
				$("#minfee").val("");
				
				$("#feerate2").removeAttr("readonly");
				$("#feerate2").val("");
				$("#maxfee2").removeAttr("readonly");
				$("#maxfee2").val("");
				$("#minfee2").removeAttr("readonly");
				$("#minfee2").val("");
				
				$("#feerate3").removeAttr("readonly");
				$("#feerate3").val("");
				$("#maxfee3").removeAttr("readonly");
				$("#maxfee3").val("");
				$("#minfee3").removeAttr("readonly");
				$("#minfee3").val("");
			}
	
		}
		/* 详情 */
		function showAccumulateRateDetail(tid) {
			showAdd(true);
			$.ajax({
				type: "POST",
				url: "fee/queryOneAccumulateRate?caseid=" + tid,
				dataType: "json",
				success: function(json) {
					$("#rateId_form").val(json.RATE_ID);
					$("#rateDes_form").val(json.RATE_DESC);
					$("#rateType").val(json.RATE_TYPE);
					$("#accmode").val(json.ACCMODE);
					$("#feerate").val(json.FEE_RATE);	
					
					$("#minfee").val(json.MIN_FEE);
					$("#maxfee").val(json.MAX_FEE);
					
					$("#limit1").val(fenToYuan(json.LIMIT1));
					$("#feerate2").val(json.FEE_RATE2);
					$("#minfee2").val(json.MIN_FEE2);
					$("#maxfee2").val(json.MAX_FEE2);
					
					$("#limit2").val(fenToYuan(json.LIMIT2fenToYuan));
					$("#feerate3").val(json.FEE_RATE3);
					$("#minfee3").val(json.MIN_FEE3);
					$("#maxfee3").val(json.MAX_FEE3);					
					$("#notes").val(json.NOTES);
				}
			});
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
