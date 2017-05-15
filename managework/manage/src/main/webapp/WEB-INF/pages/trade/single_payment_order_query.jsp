<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="../../top.jsp"></jsp:include>
<body>
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
	<div style="margin: 5px; border:" id="continer">
		<div id="p" class="easyui-panel" title="查询条件"
			style="height: 130px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="theForm" method="post">
				<table width="100%">
					<tr>
						<td align="right" width="10%">委托机构代码</td>
						<td align="left" style="padding-left: 5px" width="25%"><input
							name="merid" id="merids" maxlength="32" /></td>
						<td align="right" width="10%">委托机构名称</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="mername" id="mernames" maxlength="32" /></td>
						<td align="right" width="10%">订单号</td>
						<td align="left" style="padding-left: 5px" width="25%"><input
							name="orderid" id="orderids" maxlength="32" /></td>
					</tr>
					<tr>
						<td align="right" width="10%">受理订单号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="tn" id="tns" maxlength="32" /></td>
						<td align="right" width="10%">付款人账号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="debtoraccount" id="debtoraccounts" maxlength="32" /></td>
							
						<td align="right" width="10%">收款人账号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="creditoraccount" id="creditoraccounts" maxlength="32" /></td>
					</tr>
					<tr>
						<td align="right" width="10%">状态</td>
						<td style="padding-left: 5px"><select name="status"
							id="statuss" style="width: 150px">
								<option value="">请选择</option>
								<option value="00">支付成功</option>
								<option value="01">订单提交成功,但未支付</option>
								<option value="02">支付中</option>
								<option value="03">支付失败</option>
								<option value="04">订单失效</option>
						</select></td>
						<td align="right" width="10%">起止时间</td>
						<td colspan="2" style="padding-left: 5px"><input id="stime" type="text"
							style="width: 120PX" class="easyui-datetimebox"
							data-options="showSeconds:false" name="stime"></input> 至<input
							id=etime type="text" style="width: 120PX"
							class="easyui-datetimebox" data-options="showSeconds:false"
							name="etime"></input></td>
						<td align="right"><a href="javascript:search()"
							class="easyui-linkbutton" iconCls="icon-search">查询</a>
							<a
							href="javascript:resize()" class="easyui-linkbutton"
							iconCls="icon-redo">清空</a></td></td>
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
				<table width="100%" cellpadding="2" cellspacing="2" id="groupinfo"
					border="1">
					<tr>
					<td>标志</td><td id="tid"></td>
					<td>接入类型</td><td id="accesstype"></td>
					</tr>
					<tr>
					<td>合作机构号</td><td id="coopinstiid"></td>
					<td>委托机构号</td><td id="merid"></td>
					</tr>
					<tr>
					<td>版本</td><td id="version"></td>
					<td>编码方式</td><td id="encoding"></td>
					</tr>
					<tr>
					<td>交易类型</td><td id="txntype"></td>
					<td>交易子类</td><td id="txnsubtype"></td>
					</tr>
					<tr>
					<td>产品类型</td><td id="biztype"></td>
					<td>通知地址</td><td id="backurl"></td>
					</tr>
					<tr>
					<td>订单发送时间</td><td id="txntime"></td>
					<td>委托机构订单号</td><td id="orderid"></td>
					</tr>
					<tr>
					<td>交易币种</td><td id="currencycode"></td>
					<td>金额</td><td id="txnamt"></td>
					</tr>
					<tr>
					<td>付款人银行号</td><td id="debtorbank"></td>
					<td>付款人账号</td><td id="debtoraccount"></td>
					</tr>
					<tr>
					<td>付款人名称</td><td id="debtorname"></td>
					<td>付款合同号</td><td id="debtorconsign"></td>
					</tr>
					<tr>
					<td>收款人银行号</td><td id="creditorbank"></td>
					<td>收款人账号</td><td id="creditoraccount"></td>
					</tr>
					<tr>
					<td>收款人名称</td><td id="creditorname"></td>
					<td>业务种类编码</td><td id="proprietary"></td>
					</tr>
					<tr>
					<td>摘要</td><td id="summary"></td>
					<td>保留域</td><td id="reserved"></td>
					</tr>
					<tr>
					<td>响应码</td><td id="respcode"></td>
					<td>应答信息</td><td id="respmsg"></td>
					</tr>
					<tr>
					<td>受理订单号</td><td id="tn"></td>
					<td>关联交易序列号</td><td id="relatetradetxn"></td>
					</tr>
					<tr>
					<td>状态</td><td id="status"></td>
					<td>订单提交时间</td><td id="ordercommitime"></td>
					</tr>
					<tr>
					<td>异步通知结果</td><td id="syncnotify"></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>

<script>
	var width = $("#continer").width();
	$(function() {

		$('#test')
				.datagrid(
						{
							title : '实时代付订单信息列表',
							iconCls : 'icon-save',
							height : 500,
							singleSelect : true,
							nowrap : false,
							striped : true,
							url : 'trade/getRealTimePaymentOrderByPage',
							remoteSort : false,
							idField : 'ORGAN_ID',
							columns : [ [
									{field:'ACCESSTYPE',title:'接入类型',width:121,align:'center'},
									{field:'COOPINSTIID',title:'合作机构号',width:122,align:'center'},
									{field:'MERID',title:'委托机构号',width:123,align:'center'},
									{field:'MERNAME',title:'委托机构名称',width:123,align:'center'},
									{field:'VERSION',title:'版本',width:124,align:'center'},
									{field:'ENCODING',title:'编码方式',width:125,align:'center'},
									{field:'TXNTYPE',title:'交易类型',width:126,align:'center'},
									{field:'TXNSUBTYPE',title:'交易子类',width:127,align:'center'},
									{field:'BIZTYPE',title:'产品类型',width:128,align:'center'},
									{field:'BACKURL',title:'通知地址',width:129,align:'center'},
									{field:'TXNTIME',title:'订单发送时间',width:130,align:'center'},
									{field:'ORDERID',title:'委托机构订单号',width:131,align:'center'},
									{field:'CURRENCYCODE',title:'交易币种',width:132,align:'center'},
									{field:'TXNAMT',title:'金额',width:133,align:'center'},
									{field:'DEBTORBANK',title:'付款人银行号',width:134,align:'center'},
									{field:'DEBTORACCOUNT',title:'付款人账号',width:135,align:'center'},
									{field:'DEBTORNAME',title:'付款人名称',width:136,align:'center'},
									{field:'DEBTORCONSIGN',title:'付款合同号',width:137,align:'center'},
									{field:'CREDITORBANK',title:'收款人银行号',width:138,align:'center'},
									{field:'CREDITORACCOUNT',title:'收款人账号',width:139,align:'center'},
									{field:'CREDITORNAME',title:'收款人名称',width:140,align:'center'},
									{field:'PROPRIETARY',title:'业务种类编码',width:141,align:'center'},
									{field:'SUMMARY',title:'摘要',width:142,align:'center'},
									{field:'RESERVED',title:'保留域',width:143,align:'center'},
									{field:'RESPCODE',title:'响应码',width:144,align:'center'},
									{field:'RESPMSG',title:'应答信息',width:145,align:'center'},
									{field:'TN',title:'受理订单号',width:146,align:'center'},
									{field:'RELATETRADETXN',title:'关联交易序列号',width:147,align:'center'},
									{field:'STATUS',title:'状态',width:148,align:'center'},
									{field:'ORDERCOMMITIME',title:'订单提交时间',width:149,align:'center'},
									{field:'SYNCNOTIFY',title:'异步通知结果',width:150,align:'center'},
									{
										field : 'ID',
										title : '操作',
										width : 100,
										align : 'center',
										formatter : function(value, rec) {
											if (rec.TID != null) {
												return '<a href="javascript:queryTxnsLog(\''
														+ rec.TID
														+ '\')" style="color:blue;margin-left:10px">详细信息</a>';
											} else {
												return '';
											}
										}
									} ] ],
							pagination : true,
							rownumbers : true

						});

	});

	function search() {
		var data = {
			"merid" : $('#merids').val(),
			"mername" : $('#mernames').val(),
			"orderid" : $('#orderids').val(),
			"creditoraccount" : $('#creditoraccounts').val(),
			"tn" : $('#tns').val(),
			"status" : $('#statuss').val(),
			"debtoraccount" : $('#debtoraccounts').val(),
			"stime" : $('#stime').datebox('getValue'),
			"etime" : $('#etime').datebox('getValue')
		}
		$('#test').datagrid('load', data);
	}

	function resize(){
		$('#theForm :input').val('');
	}
	
	function queryTxnsLog(txnseqno) {
		$("#tid").html("");
		$("#accesstype").html("");
		$("#coopinstiid").html("");
		$("#merid").html("");
		$("#version").html("");
		$("#encoding").html("");
		$("#txntype").html("");
		$("#txnsubtype").html("");
		$("#biztype").html("");
		$("#backurl").html("");
		$("#txntime").html("");
		$("#orderid").html("");
		$("#currencycode").html("");
		$("#txnamt").html("");
		$("#debtorbank").html("");
		$("#debtoraccount").html("");
		$("#debtorname").html("");
		$("#debtorconsign").html("");
		$("#creditorbank").html("");
		$("#creditoraccount").html("");
		$("#creditorname").html("");
		$("#proprietary").html("");
		$("#summary").html("");
		$("#reserved").html("");
		$("#respcode").html("");
		$("#respmsg").html("");
		$("#tn").html("");
		$("#relatetradetxn").html("");
		$("#status").html("");
		$("#ordercommitime").html("");
		$("#syncnotify").html("");

		$('#w').window({
			title : '详细信息',
			top : 90,
			left : 100,
			width : 900,
			modal : true,
			minimizable : false,
			collapsible : false,
			maximizable : false,
			shadow : false,
			closed : false,
			height : 550
		});
		var rows = $('#test').datagrid('getSelected');
		$("#tid").html(rows["TID"]);
		$("#accesstype").html(rows["ACCESSTYPE"]);
		$("#coopinstiid").html(rows["COOPINSTIID"]);
		$("#merid").html(rows["MERID"]);
		$("#version").html(rows["VERSION"]);
		$("#encoding").html(rows["ENCODING"]);
		$("#txntype").html(rows["TXNTYPE"]);
		$("#txnsubtype").html(rows["TXNSUBTYPE"]);
		$("#biztype").html(rows["BIZTYPE"]);
		$("#backurl").html(rows["BACKURL"]);
		$("#txntime").html(rows["TXNTIME"]);
		$("#orderid").html(rows["ORDERID"]);
		$("#currencycode").html(rows["CURRENCYCODE"]);
		$("#txnamt").html(rows["TXNAMT"]);
		$("#debtorbank").html(rows["DEBTORBANK"]);
		$("#debtoraccount").html(rows["DEBTORACCOUNT"]);
		$("#debtorname").html(rows["DEBTORNAME"]);
		$("#debtorconsign").html(rows["DEBTORCONSIGN"]);
		$("#creditorbank").html(rows["CREDITORBANK"]);
		$("#creditoraccount").html(rows["CREDITORACCOUNT"]);
		$("#creditorname").html(rows["CREDITORNAME"]);
		$("#proprietary").html(rows["PROPRIETARY"]);
		$("#summary").html(rows["SUMMARY"]);
		$("#reserved").html(rows["RESERVED"]);
		$("#respcode").html(rows["RESPCODE"]);
		$("#respmsg").html(rows["RESPMSG"]);
		$("#tn").html(rows["TN"]);
		$("#relatetradetxn").html(rows["RELATETRADETXN"]);
		$("#status").html(rows["STATUS"]);
		$("#ordercommitime").html(rows["ORDERCOMMITIME"]);
		$("#syncnotify").html(rows["SYNCNOTIFY"]);
		$("#notes").html(rows["NOTES"]);
		$("#remarks").html(rows["REMARKS"]);
	}
</script>
</html>
