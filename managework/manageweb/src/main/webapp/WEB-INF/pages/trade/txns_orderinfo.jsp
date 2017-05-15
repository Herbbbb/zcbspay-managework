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
			style="height: 140px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="theForm" method="post">
				<table width="100%">
					<tr>
						<td align="right" width="10%">订单号</td>
						<td align="left" style="padding-left: 5px" width="25%"><input
							name="orderNo" id="orderNo" maxlength="32" /></td>
						<td align="right" width="10%">受理订单号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="tn" id="tn" maxlength="32" /></td>
						<td></td>
					</tr>
					<tr>
						<td align="right" width="10%">二级委托机构号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="secmemberNo" id="secmemberNo" maxlength="32" /></td>
						<td align="right" width="10%">状态</td>
						<td style="padding-left: 5px"><select name="status"
							id="status" style="width: 150px">
								<option value="">请选择</option>
								<option value="00">支付成功</option>
								<option value="01">订单提交成功,但未支付</option>
								<option value="02">支付中</option>
								<option value="03">支付失败</option>
								<option value="04">订单失效</option>
						</select></td>
						<td></td>
					</tr>
					<tr>
						<td align="right" width="10%">受理定单提交时间</td>
						<td style="padding-left: 5px"><input id="stime" type="text"
							style="width: 120PX" class="easyui-datetimebox"
							data-options="showSeconds:false" name="stime"></input> 至<input
							id=etime type="text" style="width: 120PX"
							class="easyui-datetimebox" data-options="showSeconds:false"
							name="etime"></input></td>
						<td></td>
						<td></td>
						<td align="right"><a href="javascript:search()"
							class="easyui-linkbutton" iconCls="icon-search">查询</a>
							<a
							href="javascript:resize()" class="easyui-linkbutton"
							iconCls="icon-redo">清空</a></td>
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
				<table width="100%" cellpadding="2" cellspacing="2" id="groupinfo"
					border="1">
					<tr>
						<td>订单ID</td>
						<td id="tid"></td>
						<td>所属机构</td>
						<td id="tinstitution	"></td>
					</tr>
					<tr>
						<td>订单号</td>
						<td id="tordern"></td>
						<td>订单金额(元)</td>
						<td id="torderamt"></td>
					</tr>
					<tr>
						<td>订单佣金(元)</td>
						<td id="tordercomm"></td>
						<td>订单手续费(元)</td>
						<td id="torderfee"></td>
					</tr>
					<tr>
						<td>订单提交时间</td>
						<td id="tordercommitime"></td>
						<td>一级委托机构号</td>
						<td id="tfirmemberno"></td>
					</tr>
					<tr>
						<td>一线委托机构名称</td>
						<td id="tfirmembername"></td>
						<td>一级委托机构简称</td>
						<td id="tfirmembershortname"></td>
					</tr>
					<tr>
						<td>二级委托机构号</td>
						<td id="tsecmemberno"></td>
						<td>二线委托机构名称</td>
						<td id="tsecmembername"></td>
					</tr>
					<tr>
						<td>二级委托机构简称</td>
						<td id="tsecmembershortname"></td>
						<td>商品名称</td>
						<td id="tgoodsname"></td>
					</tr>
					<tr>
						<td>商品数量</td>
						<td id="tgoodsnum"></td>
						<td>商品代码</td>
						<td id="tgoodscode"></td>
					</tr>
					<tr>
						<td>商品描述</td>
						<td id="tgoodsdescr"></td>
						<td>商品类型</td>
						<td id="tgoodstype"></td>
					</tr>
					<tr>
						<td>商品单价</td>
						<td id="tgoodsprice"></td>
						<td>同步返回URL</td>
						<td id="tfronturl"></td>
					</tr>
					<tr>
						<td>异步返回URL</td>
						<td id="tbackurl"></td>
						<td>关联交易序列号</td>
						<td id="trelatetradetxn"></td>
					</tr>
					<tr>
						<td>订单完成时间</td>
						<td id="torderfinshtime"></td>
					</tr>
					<tr>
						<td>状态</td>
						<td id="tstatus"></td>
						<td>备注</td>
						<td id="tnotes"></td>
					</tr>
					<tr>
						<td>备注</td>
						<td id="tremarks"></td>
						<td>交易类型</td>
						<td id="ttxntype"></td>
					</tr>
					<tr>
						<td>交易子类</td>
						<td id="ttxnsubtype"></td>
						<td>产品类型</td>
						<td id="tbiztype"></td>
					</tr>
					<tr>
						<td>证书 ID</td>
						<td id="tcertid"></td>
						<td>请求方保留域</td>
						<td id="treqreserved"></td>
					</tr>
					<tr>
						<td>保留域</td>
						<td id="treserved"></td>
						<td>银行卡验证信息及身份信息</td>
						<td id="tcustomerinfo"></td>
					</tr>
					<tr>
						<td>受理订单号</td>
						<td id="ttn"></td>
						<td>订单描述</td>
						<td id="torderdesc"></td>
					</tr>
					<tr>
						<td>订单支付超时时间</td>
						<td id="tpaytimeout"></td>
						<td>支付方的IP</td>
						<td id="tpayerip"></td>
					</tr>
					<tr>
						<td>异步通知结果</td>
						<td id="tsyncnotify"></td>
						<td>交易币种</td>
						<td id="tcurrencycode"></td>
					</tr>
					<tr>
						<td>接入方式</td>
						<td id="taccesstype"></td>
						<td>受理委托机构号</td>
						<td id="tmemberid"></td>
					</tr>
					<tr>
						<td>产品代码</td>
						<td id="tproductcode"></td>
						<td>行业群组号</td>
						<td id="tgroupcode"></td>
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
							title : '交易订单信息列表',
							iconCls : 'icon-save',
							height : 500,
							singleSelect : true,
							nowrap : false,
							striped : true,
							url : 'trade/getOrderInfoByPage',
							remoteSort : false,
							idField : 'ORGAN_ID',
							columns : [ [
									{field : 'ORDERNO',title : '订单号',width : 120,align : 'center'},
									{field : 'ORDERAMT',title : '订单金额(元)',width : 120,align : 'center'},
									{field : 'ORDERFEE',title : '订单手续费(元)',width : 120,align : 'center'},
									{field : 'ORDERCOMMITIME',title : '订单提交时间',width : 120,align : 'center'},
									{
										field : 'FIRMEMBERNO',
										title : '一级委托机构号',
										width : 120,
										align : 'center'
									},
									{
										field : 'FIRMEMBERNAME',
										title : '一线委托机构名称',
										width : 120,
										align : 'center'
									},
									{
										field : 'SECMEMBERNO',
										title : '二级委托机构号',
										width : 120,
										align : 'center'
									},
									{
										field : 'SECMEMBERNAME',
										title : '二线委托机构名称',
										width : 120,
										align : 'center'
									},
									{
										field : 'FRONTURL',
										title : '同步返回URL',
										width : 120,
										align : 'center'
									},
									{
										field : 'BACKURL',
										title : '异步返回URL',
										width : 120,
										align : 'center'
									},
									{
										field : 'RELATETRADETXN',
										title : '关联交易序列号',
										width : 120,
										align : 'center'
									},
									{
										field : 'ORDERFINSHTIME',
										title : '订单完成时间',
										width : 120,
										align : 'center'
									},
									{
										field : 'STATUS',
										title : '状态',
										width : 120,
										align : 'center'
									},
									{
										field : 'TXNTYPE',
										title : '交易类型',
										width : 120,
										align : 'center'
									},
									{
										field : 'TXNSUBTYPE',
										title : '交易子类',
										width : 120,
										align : 'center'
									},
									{
										field : 'BIZTYPE',
										title : '产品类型',
										width : 120,
										align : 'center'
									},
									{
										field : 'TN',
										title : '受理订单号',
										width : 120,
										align : 'center'
									},
									{
										field : 'MEMBERID',
										title : '受理委托机构号',
										width : 120,
										align : 'center'
									},
									{
										field : 'CURRENCYCODE',
										title : '交易币种',
										width : 120,
										align : 'center'
									},
									{
										field : 'ID',
										title : '操作',
										width : 100,
										align : 'center',
										formatter : function(value, rec) {
											if (rec.ID != null) {
												return '<a href="javascript:queryTxnsLog(\''
														+ rec.ID
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
			"orderNo" : $('#orderNo').val(),
			"tn" : $('#tn').val(),
			"secmemberNo" : $('#secmemberNo').val(),
			"status" : $('#status').val(),
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
		$("#tinstitution").html("");
		$("#torderno").html("");
		$("#torderamt").html("");
		$("#tordercomm").html("");
		$("#torderfee").html("");
		$("#tordercommitime").html("");
		$("#tfirmemberno").html("");
		$("#tfirmembername").html("");
		$("#tfirmembershortname").html("");
		$("#tsecmemberno").html("");
		$("#tsecmembername").html("");
		$("#tsecmembershortname").html("");
		$("#tgoodsname").html("");
		$("#tgoodsnum").html("");
		$("#tgoodscode").html("");
		$("#tgoodsdescr").html("");
		$("#tgoodstype").html("");
		$("#tgoodsprice").html("");
		$("#tfronturl").html("");
		$("#tbackurl").html("");
		$("#trelatetradetxn").html("");
		$("#torderfinshtime").html("");
		$("#tstatus").html("");
		$("#tnotes").html("");
		$("#tremarks").html("");
		$("#ttxntype").html("");
		$("#ttxnsubtype").html("");
		$("#tbiztype").html("");
		$("#tcertid").html("");
		$("#treqreserved").html("");
		$("#treserved").html("");
		$("#tcustomerinfo").html("");
		$("#ttn").html("");
		$("#torderdesc").html("");
		$("#tpaytimeout").html("");
		$("#tpayerip").html("");
		$("#tsyncnotify").html("");
		$("#tcurrencycode").html("");
		$("#taccesstype").html("");
		$("#tmemberid").html("");
		$("#tproductcode").html("");
		$("#tgroupcode").html("");

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
			height : 800
		});

		$.ajax({
			type : "POST",
			url : "trade/getOrderInfoDetail",
			data : "id=" + txnseqno,
			dataType : "json",
			success : function(date) {
				if (date.messg != null) {
					$.messager.alert('提示', date.messg);
				} else {
					json = date.json;
					$("#tid").html(json.ID);
					$("#tinstitution").html(json.INSTITUTION);
					$("#torderno").html(json.ORDERNO);
					$("#torderamt").html(json.ORDERAMT);
					$("#tordercomm").html(json.ORDERCOMM);
					$("#torderfee").html(json.ORDERFEE);
					$("#tordercommitime").html(json.ORDERCOMMITIME);
					$("#tfirmemberno").html(json.FIRMEMBERNO);
					$("#tfirmembername").html(json.FIRMEMBERNAME);
					$("#tfirmembershortname").html(json.FIRMEMBERSHORTNAME);
					$("#tsecmemberno").html(json.SECMEMBERNO);
					$("#tsecmembername").html(json.SECMEMBERNAME);
					$("#tsecmembershortname").html(json.SECMEMBERSHORTNAME);
					$("#tgoodsname").html(json.GOODSNAME);
					$("#tgoodsnum").html(json.GOODSNUM);
					$("#tgoodscode").html(json.GOODSCODE);
					$("#tgoodsdescr").html(json.GOODSDESCR);
					$("#tgoodstype").html(json.GOODSTYPE);
					$("#tgoodsprice").html(json.GOODSPRICE);
					$("#tfronturl").html(json.FRONTURL);
					$("#tbackurl").html(json.BACKURL);
					$("#trelatetradetxn").html(json.RELATETRADETXN);
					$("#torderfinshtime").html(json.ORDERFINSHTIME);
					$("#tstatus").html(json.STATUS);
					$("#tnotes").html(json.NOTES);
					$("#tremarks").html(json.REMARKS);
					$("#ttxntype").html(json.TXNTYPE);
					$("#ttxnsubtype").html(json.TXNSUBTYPE);
					$("#tbiztype").html(json.BIZTYPE);
					$("#tcertid").html(json.CERTID);
					$("#treqreserved").html(json.REQRESERVED);
					$("#treserved").html(json.RESERVED);
					$("#tcustomerinfo").html(json.CUSTOMERINFO);
					$("#ttn").html(json.TN);
					$("#torderdesc").html(json.ORDERDESC);
					$("#tpaytimeout").html(json.PAYTIMEOUT);
					$("#tpayerip").html(json.PAYERIP);
					$("#tsyncnotify").html(json.SYNCNOTIFY);
					$("#tcurrencycode").html(json.CURRENCYCODE);
					$("#taccesstype").html(json.ACCESSTYPE);
					$("#tmemberid").html(json.MEMBERID);
					$("#tproductcode").html(json.PRODUCTCODE);
					$("#tgroupcode").html(json.GROUPCODE);
				}
			}
		});
	}
</script>
</html>
