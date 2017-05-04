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
		<div id="p" class="easyui-panel" title="查询条件" style="height: 148px; padding: 10px; background: #fafafa;" iconCls="icon-save" collapsible="true">
			<form id="theForm" method="post">
				<table width="100%">
					<tr>
						<td align="right" width="10%">付款人名称</td>
						<td align="left" style="padding-left: 5px" width="25%"><input name="debtorname" id="debtornames" /></td>
						<td align="right" width="10%">付款人账号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input name="debtoraccountno" id="debtoraccountnos" /></td>
						<td align="right" width="10%">付款行行号</td>
						<td align="left" style="padding-left: 5px" width="25%"><input name="debtorbranchcode" id="debtorbranchcodes" /></td>
					</tr>
					<tr>
						<td align="right" width="10%">收款人名称</td>
						<td align="left" style="padding-left: 5px" width="15%"><input name="creditorname" id="creditornames" /></td>
						<td align="right" width="10%">收款人账号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input name="creditoraccountno" id="creditoraccountnos" /></td>

						<td align="right" width="10%">收款行行号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input name="creditorbranchcode" id="creditorbranchcodes" /></td>
					</tr>
					<tr>
						<td align="right" width="10%">合同（协议）号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input name="endtoendidentification" id="endtoendidentifications" /></td>
						<td align="right" width="10%">发起方代码</td>
						<td align="left" style="padding-left: 5px" width="15%"><input name="transmitleg" id="transmitlegs" /></td>

						<td align="right" width="10%">应答状态</td>
						<td style="padding-left: 5px"><select name="rspstatus" id="rspstatuss" style="width: 150px">
								<option value="">--请选择应答状态--</option>
								<option value="PR05">已成功</option>
								<option value="PR09">已拒绝</option>
								<option value="PR32">逾期退回</option>
						</select></td>
					</tr>
					<tr>
						<td align="right" width="10%">交易起止时间</td>
						<td colspan="2" style="padding-left: 5px"><input id="stime" type="text" style="width: 120PX" class="easyui-datetimebox" data-options="showSeconds:false" name="stime"></input> 至<input id=etime type="text" style="width: 120PX" class="easyui-datetimebox" data-options="showSeconds:false" name="etime"></input></td>
						<td align="right" width="10%"></td>
						<td align="left" style="padding-left: 5px" width="15%"></td>
						<td align="left"><a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a> <a href="javascript:resize()" class="easyui-linkbutton" iconCls="icon-redo">清空</a></td>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="test"></table>
		</div>
	</div>
	<div id="w" class="easyui-window" closed="true" title="My Window" iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<table width="100%" cellpadding="2" cellspacing="2" id="groupinfo" border="1">
					<tr>					
						<td>报文标识号</td><td id="msgid"></td>
						<td>明细标识号</td><td id="txid"></td>
					</tr>
					<tr>	
						<td>发起方代码</td><td id="transmitleg"></td>
						<td>接收方代码</td><td id="receiver"></td>
					</tr>
					<tr>	
						<td>交易类型 </td><td id="tradetype"></td>
						<td>本地日期 </td><td id="transdate"></td>
					</tr>
					<tr>	
						<td>本地时间</td><td id="transtime"></td>
						<td>付款人名称</td><td id="debtorname"></td>
					</tr>
					<tr>	
						<td>付款人账号</td><td id="debtoraccountno"></td>
						<td>付款行行号</td><td id="debtorbranchcode"></td>
					</tr>
					<tr>	
						<td>收款行行号</td><td id="creditorbranchcode"></td>
						<td>收款人名称</td><td id="creditorname"></td>
					</tr>
					<tr>	
						<td>收款人账号</td><td id="creditoraccountno"></td>
						<td>金额（元）</td><td id="amount"></td>
					</tr>
					<tr>	
						<td>业务种类编码</td><td id="purposeproprietary"></td>
						<td>合同（协议）号</td><td id="endtoendidentification"></td>
					</tr>
					<tr>	
						<td>票据号码</td><td id="billnumber"></td>
						<td>应答报文标识号</td><td id="rspmsgid"></td>
					</tr>
					<tr>	
						<td>应答状态</td><td id="rspstatus"></td>
						<td>应答码</td><td id="rsprejectcode"></td>
					</tr>
					<tr>	
						<td>业务拒绝信息</td><td id="rsprejectinformation"></td>
						<td>业务应答时间</td><td id="rspdate"></td>
					</tr>
					<tr>	
						<td>轧差日期</td><td id="nettingdate"></td>
						<td>通用处理报文标识号</td><td id="commsgid"></td>
					</tr>
					<tr>	
						<td>通用处理应答状态</td><td id="comstatus"></td>
						<td>通用处理应答码</td><td id="comrejectcode"></td>
					</tr>
					<tr>	
						<td>通用处理业务拒绝信息</td><td id="comrejectinformation"></td>
						<td>通用处理业务应答时间</td><td id="comdate"></td>
					</tr>
					<tr>	
						<td>交易流水号</td><td id="txnseqno"></td>
						<td>备注</td><td id="notes"></td>
					</tr>
					<tr>	
						<td>备注</td><td id="remarks"></td>
						<td/><td/>		
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
							title : '实时代付渠道流水信息列表',
							iconCls : 'icon-save',
							height : 500,
							singleSelect : true,
							nowrap : false,
							striped : true,
							url : 'trade/getChnPaymentSingleLogByPage',
							remoteSort : false,
							idField : 'ORGAN_ID',

							columns : [ [
									{
										field : 'MSGID',
										title : '报文标识号',
										width : 120,
										align : 'center'
									},
									{
										field : 'TXID',
										title : '明细标识号',
										width : 120,
										align : 'center'
									},
									{
										field : 'TRANSMITLEG',
										title : '发起方代码',
										width : 120,
										align : 'center'
									},
									{
										field : 'RECEIVER',
										title : '接收方代码',
										width : 120,
										align : 'center'
									},
									{
										field : 'TRADETYPE',
										title : '交易类型',
										width : 120,
										align : 'center'
									},
									{
										field : 'TRANSDATE',
										title : '本地日期 ',
										width : 120,
										align : 'center',
										formatter : function(value, rec) {
											return changeDate(rec.TRANSDATE);
										}
									},
									{
										field : 'TRANSTIME',
										title : '本地时间',
										width : 120,
										align : 'center',
										formatter : function(value, rec) {
											return changeTime(rec.TRANSTIME);
										}
									},
									{
										field : 'DEBTORNAME',
										title : '付款人名称',
										width : 120,
										align : 'center'
									},
									{
										field : 'DEBTORACCOUNTNO',
										title : '付款人账号',
										width : 120,
										align : 'center'
									},
									{
										field : 'DEBTORBRANCHCODE',
										title : '付款行行号',
										width : 120,
										align : 'center'
									},
									{
										field : 'CREDITORBRANCHCODE',
										title : '收款行行号',
										width : 120,
										align : 'center'
									},
									{
										field : 'CREDITORNAME',
										title : '收款人名称',
										width : 120,
										align : 'center'
									},
									{
										field : 'CREDITORACCOUNTNO',
										title : '收款人账号',
										width : 120,
										align : 'center'
									},
									{
										field : 'AMOUNT',
										title : '金额（元）',
										width : 120,
										align : 'center',
										formatter : function(value, rec) {
											return yuanToFen(rec.AMOUNT);
										}
									},
									{
										field : 'PURPOSEPROPRIETARY',
										title : '业务种类编码',
										width : 120,
										align : 'center'
									},
									{
										field : 'ENDTOENDIDENTIFICATION',
										title : '合同（协议）号',
										width : 120,
										align : 'center'
									},
									{
										field : 'RSPSTATUS',
										title : '应答状态',
										width : 120,
										align : 'center',
										formatter : function(value, rec) {
											return analysisStatus(rec.RSPSTATUS);
										}
									},
									{
										field : 'RSPREJECTCODE',
										title : '应答码',
										width : 120,
										align : 'center'
									},
									{
										field : 'RSPREJECTINFORMATION',
										title : '业务拒绝信息',
										width : 120,
										align : 'center'
									},
									{
										field : 'RSPDATE',
										title : '业务应答时间',
										width : 125,
										align : 'center',
										formatter : function(value, rec) {
											return changeDateTime(rec.RSPDATE);
										}
									},
									{
										field : 'NETTINGDATE',
										title : '轧差日期',
										width : 120,
										align : 'center',
										formatter : function(value, rec) {
											return changeDate(rec.NETTINGDATE);
										}
									},
									{
										field : 'COMMSGID',
										title : '通用处理报文标识号',
										width : 120,
										align : 'center'
									},
									{
										field : 'COMSTATUS',
										title : '通用处理应答状态',
										width : 120,
										align : 'center',
										formatter : function(value, rec) {
											return analysisStatus(rec.COMSTATUS);
										}
									},
									{
										field : 'COMREJECTCODE',
										title : '通用处理应答码',
										width : 120,
										align : 'center'
									},
									{
										field : 'COMREJECTINFORMATION',
										title : '通用处理业务拒绝信息',
										width : 130,
										align : 'center'
									},
									{
										field : 'COMDATE',
										title : '通用处理业务应答时间',
										width : 130,
										align : 'center',
										formatter : function(value, rec) {
											return changeDateTime(rec.COMDATE);
										}
									},
									{
										field : 'TXNSEQNO',
										title : '交易流水号',
										width : 120,
										align : 'center'
									},
									{
										field : 'ID',
										title : '操作',
										width : 100,
										align : 'center',
										formatter : function(value, rec) {
											if (rec.TID != null) {
												return '<a href="javascript:queryDetail(\''
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
			"debtorname" : $('#debtornames').val(),
			"debtoraccountno" : $('#debtoraccountnos').val(),
			"debtorbranchcode" : $('#debtorbranchcodes').val(),
			"creditorname" : $('#creditornames').val(),
			"creditoraccountno" : $('#creditoraccountnos').val(),
			"creditorbranchcode" : $('#creditorbranchcodes').val(),
			"endtoendidentification" : $('#endtoendidentifications').val(),
			"transmitleg" : $('#transmitlegs').val(),
			"rspstatus" : $('#rspstatuss').val(),
			"stime" : $('#stime').datebox('getValue'),
			"etime" : $('#etime').datebox('getValue')
		}
		$('#test').datagrid('load', data);
	}

	function resize() {
		$('#theForm :input').val('');
	}

	function queryDetail(logseqno) {
		$("#msgid").html("");
		$("#txid").html("");
		$("#transmitleg").html("");
		$("#receiver").html("");
		$("#transdate").html("");
		$("#transtime").html("");
		$("#debtorname").html("");
		$("#debtoraccountno").html("");
		$("#debtorbranchcode").html("");
		$("#creditorbranchcode").html("");
		$("#creditorname").html("");
		$("#creditoraccountno").html("");
		$("#amount").html("");
		$("#purposeproprietary").html("");
		$("#endtoendidentification").html("");
		$("#billnumber").html("");
		$("#rspmsgid").html("");
		$("#rspstatus").html("");
		$("#rsprejectcode").html("");
		$("#rsprejectinformation").html("");
		$("#rspdate").html("");
		$("#nettingdate").html("");
		$("#commsgid").html("");
		$("#comstatus").html("");
		$("#comrejectcode").html("");
		$("#comrejectinformation").html("");
		$("#comdate").html("");
		$("#txnseqno").html("");
		$("#notes").html("");
		$("#remarks").html("");

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
			height : 485
		});
		var rows = $('#test').datagrid('getSelected');
		$("#msgid").html(rows["MSGID"]);
		$("#txid").html(rows["TXID"]);
		$("#transmitleg").html(rows["TRANSMITLEG"]);
		$("#receiver").html(rows["RECEIVER"]);
		$("#tradetype").html(rows["TRADETYPE"]);
		$("#transdate").html(changeDate(rows["TRANSDATE"]));
		$("#transtime").html(changeTime(rows["TRANSTIME"]));
		$("#debtorname").html(rows["DEBTORNAME"]);
		$("#debtoraccountno").html(rows["DEBTORACCOUNTNO"]);
		$("#debtorbranchcode").html(rows["DEBTORBRANCHCODE"]);
		$("#creditorbranchcode").html(rows["CREDITORBRANCHCODE"]);
		$("#creditorname").html(rows["CREDITORNAME"]);
		$("#creditoraccountno").html(rows["CREDITORACCOUNTNO"]);
		$("#amount").html(rows["AMOUNT"]/100);
		$("#purposeproprietary").html(rows["PURPOSEPROPRIETARY"]);
		$("#endtoendidentification").html(rows["ENDTOENDIDENTIFICATION"]);
		$("#billnumber").html(rows["BILLNUMBER"]);
		$("#rspmsgid").html(rows["RSPMSGID"]);
		$("#rspstatus").html(analysisStatus(rows["RSPSTATUS"]));
		$("#rsprejectcode").html(rows["RSPREJECTCODE"]);
		$("#rsprejectinformation").html(rows["RSPREJECTINFORMATION"]);
		$("#rspdate").html(changeDateTime(rows["RSPDATE"]));
		$("#nettingdate").html(changeDate(rows["NETTINGDATE"]));
		$("#commsgid").html(rows["COMMSGID"]);
		$("#comstatus").html(analysisStatus(rows["COMSTATUS"]));
		$("#comrejectcode").html(rows["COMREJECTCODE"]);
		$("#comrejectinformation").html(rows["COMREJECTINFORMATION"]);
		$("#comdate").html(changeDateTime(rows["COMDATE"]));
		$("#txnseqno").html(rows["TXNSEQNO"]);
		$("#notes").html(rows["NOTES"]);
		$("#remarks").html(rows["REMARKS"]);
	}
	
	// 格式化日期时间
	function changeDateTime(value){
		var dateString = value;
		if(dateString==null){
			return "";
		}else{
			year=dateString.substring(0,4);//0123
			month=dateString.substring(4,6);//45
			day=dateString.substring(6,8);//67
			hour=dateString.substring(8,10);//89
			minte=dateString.substring(10,12);//10 11
			s=dateString.substring(12,14);// 11 12
			return year+"-"+month+"-"+day+" " + hour +":"+minte+":"+s;
		}
	}
	// 格式化日期
	function changeDate(value){
		var dateString = value;
		if(dateString==null){
			return "";
		}else{
			year=dateString.substring(0,4);//0123
			month=dateString.substring(4,6);//45
			day=dateString.substring(6,8);//67
			return year+"-"+month+"-"+day;
		}
	}
	// 格式化时间
	function changeTime(value){
		var dateString = value;
		if(dateString==null){
			return "";
		}else{
			hour=dateString.substring(0,2);
			minte=dateString.substring(2,4);
			s=dateString.substring(4,6);
			return hour +":"+minte+":"+s;
		}
	}
	// 解析状态
	function analysisStatus(value){
		if (value == "PR05") {
			return "已成功";
		} 
		if (value == "PR09") {
			return "已拒绝";
		} 
		if (value == "PR32") {
			return "逾期退回";
		} 
	}
	// 转换金额格式：分-->元
	function yuanToFen(value){
		return value/100;
	}
</script>
</html>
