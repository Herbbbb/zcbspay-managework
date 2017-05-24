<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
						<td align="right" width="15%">对账日期</td>
						<td align="left" style="padding-left: 5px" width="25%">
							<input name="checkInfoDate" maxlength="12" type="text"
							id="checkInfoDate" />
						</td>
						<td align="right"><a href="javascript:search()"
							class="easyui-linkbutton" iconCls="icon-search">查询</a>
							<a href="javascript:resize()" class="easyui-linkbutton"
							iconCls="icon-redo">清空</a>
							</td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="checkInfoTrade"></table>
			<table id="checkInfoInfos"></table>
			<input type="hidden" id="checkDateReturn" name="checkDateReturn">
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
							<td width="15%">扣率代码</td>
							<td width="30%"><input id="rateId-form"  name="rateId" maxlength="10"/></td>
							<td width="15%">扣率描述</td>
							<td><input id="rateDes-form" name="rateDes" maxlength="64" /></td>
						</tr>
						<tr>
							<td>计费方式</td>
							<td>
							<select id="rateType" class="easyui-validatebox" required="true" name="rateType"
								onchange="showRateDetail()" missingMessage="请选择计费方式">
							</select>
							</td>
							<td width="15%">扣率(百分比)</td>
							<td><input id="feeRate" name="feeRate" validType="percent" required="true" type="text"
								class="easyui-validatebox" maxlength="5" missingMessage="请输入扣率"/></td>
						</tr>
						<tr>
							<td>最低收费额(单位:元)</td>
							<td><input id="minFee" name="minFee" maxlength="12" validType="amount" required="true" type="text"
								class="easyui-validatebox" missingMessage="请输入最低收费金额"/></td>
							<td width="15%">最高收费额(单位:元)</td>
							<td><input id="maxFee" name="maxFee" required="true" maxlength="12" validType="amount" type="text"
								class="easyui-validatebox" missingMessage="请输入最高收费金额"/></td>
						</tr>
						<tr>
							<td>备注</td>
							<td colspan="3"><textarea id="notes" rows="3" cols="75"
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
	  var gridHeight = 300;
	  var panelWidth = 800;
	  var panelHeight = 260;
	  var panelHoriFloat = (width-panelWidth)/2;
	  var panelVertFloat = 150;
	  
	  $(function() {
		  $('#checkInfoDate').datebox({
			  
		  }); 
	  });
		$(function() {
			//交易类对账信息集合
			$('#checkInfoTrade').datagrid({
				title: '总账数据列表',
				iconCls: 'icon-save',
				height: gridHeight,
				singleSelect: true,
				nowrap: false,
				striped: true,
				remoteSort: false,
				columns: [[{
					field: 'transactionNettingDate',
					title: '轧差日期',
					width: 150,
					align: 'center'
				},
				{
					field: 'transactionNettingRound',
					title: '轧差场次',
					width: 120,
					align: 'center'
				},
				{
					field: 'messageType',
					title: '报文类型代码',
					width: 150,
					align: 'center'
				},
				{
					field: 'sendTotalCount',
					title: '往帐包总笔数',
					width: 100,
					align: 'center'
				},
				{
					field: 'sendTotalAmount',
					title: '往帐包总金额',
					width: 100,
					align: 'center'
				},
				{
					field: 'receiveTotalCount',
					title: '来账包总笔数',
					width: 100,
					align: 'center'
				},
				{
					field: 'receiveTotalAmount',
					title: '来账包总金额',
					width: 100,
					align: 'center'
				},
				{
					field: 'processStatus',
					title: '包处理状态',
					width: 100,
					align: 'center'
				},
				{
					field: 'BUSIID',
					title: '操作',
					width: 100,
					align: 'center',
					formatter: function(value, rec) {
						return '<a href="javascript:downloadCheckInfoDetail()" style="color:blue;margin-left:10px">下载明细</a>';
					}
				}
				]]
			});
			
			//信息类对账信息集合
			$('#checkInfoInfos').datagrid({
				title: '总账数据列表',
				iconCls: 'icon-save',
				height: gridHeight,
				singleSelect: true,
				nowrap: false,
				striped: true,
				remoteSort: false,
				columns: [[{
					field: 'messageType',
					title: '报文类型代码',
					width: 150,
					align: 'center'
				},
				{
					field: 'sendTotalCount',
					title: '往报文总笔数',
					width: 120,
					align: 'center'
				},
				{
					field: 'receiveTotalCount',
					title: '来报文总笔数',
					width: 150,
					align: 'center'
				},
				{
					field: 'receiveDate',
					title: '受理日期',
					width: 100,
					align: 'center'
				}
				]]
			});
			datagridreload();
		});
	  
	  	function datagridreload(){
	  		
	  		$.ajax({
				type: "POST",
				url: "checkinfo/queryCheckInfoTotal?checkInfoDate=" + $("#checkInfoDate").datebox('getValue'),
				async:false,
				dataType: "json",
				success: function(json) {
					if(json.resultBool==true){
						$("#checkDateReturn").val(json.resultObj.checkDate);
						$('#checkInfoTrade').datagrid('loadData', json.resultObj.totalCheckPaymentList);
						$('#checkInfoInfos').datagrid('loadData', json.resultObj.totalCheckMessageList);
					}else{
						$.messager.alert('提示', json.errMsg);
					}
				}
			});
	  		
	  	}
	  
		function search() {
			datagridreload();
		}
		function downloadCheckInfoDetail() {
			var dataObj = $('#checkInfoTrade').datagrid('getSelected');
			dataObj.checkDate=$("#checkDateReturn").val();
			//
			$.ajax({
			type: "POST",
			url: "checkinfo/queryCheckInfoDetail",
			data:dataObj,
			async:false,
			dataType: "json",
			success: function(json) {
				if(json.resultBool==true){
					$.messager.alert('提示', json.resultObj);
				}else{
					$.messager.alert('提示', json.errMsg);
				}
			}
		}); 
		}
		function resize(){
			$('#theForm :input').val('');
		}
	</script>
</html>
