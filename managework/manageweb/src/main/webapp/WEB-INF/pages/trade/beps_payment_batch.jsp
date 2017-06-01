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
						<td align="right">批次序号</td>
						<td align="left" style="padding-left: 5px"><input
							id="batchNo" maxlength="8" /></td>
					</tr>
					<tr>
					</tr>
					<tr>
						<td align="right"></td>
						<td align="right"></td>
						<td align="right"></td>
						<td style="padding-left: 5px"></td>
						<td align="right"><a href="javascript:search()"
							class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="test"></table>
		</div>
		<div style="margin-top: 5px">
			<table id="detailInfo"></table>
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
						<td>标识</td><td id="ttid"></td>
						<td>报文标识号</td><td id="tmsgid"></td>
					</tr>
					<tr>
						<td>批次序号</td><td id="tbatchno"></td>
						<td>转发付款方日期</td><td id="ttransmitsenderdate"></td>
					</tr>
					<tr>
						<td>转发收款方日期</td><td id="ttransmitreceiverdate"></td>
						<td>回执期限</td><td id="treturnlimited"></td>
					</tr>
					<tr>
						<td>接收标识</td><td id="treceivetype"></td>
						<td>合同（协议）号</td><td id="tendtoendidentification"></td>
					</tr>
					<tr>
						<td>核验标识</td><td id="tcheckflag"></td>
						<td>付款人名称</td><td id="tdebtorname"></td>
					</tr>
					<tr>
						<td>付款人账号</td><td id="tdebtoraccountno"></td>
						<td>付款清算行行号</td><td id="tdebtoragentcode"></td>
					</tr>
					<tr>
						<td>付款行行号</td><td id="tdebtorbranchcode"></td>
						<td>收款清算行行号</td><td id="tcreditoragentcode"></td>
					</tr>
					<tr>
						<td>总金额(元)</td><td id="ttotalamount"></td>
						<td>业务类型编码</td><td id="tcategorypurposecode"></td>
					</tr>
					<tr>
						<td>收款人数目</td><td id="tdebtornumber"></td>
						<td>成功收款总笔数</td><td id="tsendingtotalnumber"></td>
					</tr>
					<tr>
						<td>成功收款总金额(元)</td><td id="tsendingtotalamount"></td>
						<td>失败收款总笔数</td><td id="tfailtotalnumber"></td>
					</tr>
					<tr>
						<td>失败收款总金额(元)</td><td id="tfailtotalamount"></td>
						<td>NPC处理状态</td><td id="tnpcprocessstatus"></td>
					</tr>
					<tr>
						<td>NPC业务处理码</td><td id="tnpcprocesscode"></td>
						<td>NPC拒绝信息</td><td id="tnpcrejectinformation"></td>
					</tr>
					<tr>
						<td>NPC轧差日期</td><td id="tnpcnettingdate"></td>
						<td>NPC轧差场次</td><td id="tnpcnettinground"></td>
					</tr>
					<tr>
						<td>NPC清算日期/终态日期</td><td id="tnpcsettlementdate"></td>
						<td>NPC接收时间</td><td id="tnpcreceivetime"></td>
					</tr>
					<tr>
						<td>NPC转发时间</td><td id="tnpctransmittime"></td>
						<td>应答状态</td><td id="trspstatus"></td>
					</tr>
					<tr>
						<td>应答码</td><td id="trsprejectcode"></td>
						<td>业务处理参与机构</td><td id="trspprocessparty"></td>
					</tr>
					<tr>
						<td>业务拒绝信息</td><td id="trsprejectinformation"></td>
						<td>业务应答时间</td><td id="trspdate"></td>
					</tr>
					<tr>
						<td>参与机构业务状态</td><td id="tcomprocessstatus"></td>
						<td>参与机构业务处理码</td><td id="tcomprocesscode"></td>
					</tr>
					<tr>
						<td>拒绝业务的参与机构行号</td><td id="tcompartyidentification"></td>
						<td>参与机构业务拒绝码</td><td id="tcompartyprocesscode"></td>
					</tr>
					<tr>
						<td>参与机构业务拒绝信息</td><td id="tcomrejectinformation"></td>
						<td>参与机构处理日期（终态日期）</td><td id="tcomprocessdate"></td>
					</tr>
					<tr>
						<td>参与机构轧差场次</td><td id="tcomnettinground"></td>
						<td>通用处理报文接收时间</td><td id="tcomdate"></td>
					</tr>
					<tr>

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
							title : '交易流水列表',
							iconCls : 'icon-save',
							height : 400,
							singleSelect : true,
							nowrap : false,
							striped : true,
							url : 'trade/getBepsPaymentBatchByPage',
							remoteSort : false,
							idField : 'MSGID',
							columns : [ [
								{field:'TID',title:'标识',width:120,align:'center'},
								{field:'MSGID',title:'报文标识号',width:120,align:'center'},
								{field:'BATCHNO',title:'批次序号',width:120,align:'center'},
								{field:'TRANSMITSENDERDATE',title:'转发付款方日期',width:120,align:'center'},
								{field:'TRANSMITRECEIVERDATE',title:'转发收款方日期',width:120,align:'center'},
								{field:'RETURNLIMITED',title:'回执期限',width:120,align:'center'},
								{field:'RECEIVETYPE',title:'接收标识',width:120,align:'center'},
								{field:'ENDTOENDIDENTIFICATION',title:'合同（协议）号',width:120,align:'center'},
								{field:'CHECKFLAG',title:'核验标识',width:120,align:'center'},
								{field:'DEBTORNAME',title:'付款人名称',width:120,align:'center'},
								{field:'DEBTORACCOUNTNO',title:'付款人账号',width:120,align:'center'},
								{field:'DEBTORAGENTCODE',title:'付款清算行行号',width:120,align:'center'},
								{field:'DEBTORBRANCHCODE',title:'付款行行号',width:120,align:'center'},
								{field:'CREDITORAGENTCODE',title:'收款清算行行号',width:120,align:'center'},
								{field:'TOTALAMOUNT',title:'总金额(元)',width:120,align:'center',
									formatter:function(value,rec){
										return fenToYuan(rec.TOTALAMOUNT);
									}
								},
								{field:'CATEGORYPURPOSECODE',title:'业务类型编码',width:120,align:'center'},
								{field:'DEBTORNUMBER',title:'收款人数目',width:120,align:'center'},
								{field:'SENDINGTOTALNUMBER',title:'成功收款总笔数',width:120,align:'center'},
								{field:'SENDINGTOTALAMOUNT',title:'成功收款总金额(元)',width:120,align:'center',
									formatter:function(value,rec){
										return fenToYuan(rec.SENDINGTOTALAMOUNT);
									}
								},
								{field:'FAILTOTALNUMBER',title:'失败收款总笔数',width:120,align:'center'},
								{field:'FAILTOTALAMOUNT',title:'失败收款总金额(元)',width:120,align:'center',
									formatter:function(value,rec){
										return fenToYuan(rec.FAILTOTALAMOUNT);
									}
								},
								{field:'ID',title:'操作',width:120,align:'center',
									formatter:function(value,rec){
										return '<a href="javascript:queryDetail(\''+rec.BATCHNO+'\')" style="color:blue;margin-left:10px">详细信息</a>';
									}
								}
							] ],
							pagination : true,
							rownumbers : true,
							onClickRow: function (index, row) { 
								var batchNo= row["BATCHNO"];
								$('#detailInfo').datagrid({
									title:'详情表',
									iconCls:'icon-save',
									height:400,
									singleSelect:true,
									nowrap: false,
									striped: true,
									url:'trade/queryPaymentDetail?batchNo='+batchNo,	
									remoteSort: false,
									idField:'TID',
									columns:[
									[
										{field:'TID',title:'标识',width:120,align:'center'},
										{field:'BATCHNO',title:'批次序号',width:120,align:'center'},
										{field:'TXID',title:'明细标识号',width:120,align:'center'},
										{field:'PURPOSEPROPRIETARY',title:'业务种类编码',width:120,align:'center'},
										{field:'CREDITORNAME',title:'收款人名称',width:120,align:'center'},
										{field:'CREDITORACCOUNTNO',title:'收款人账号',width:120,align:'center'},
										{field:'CREDITORBRANCHCODE',title:'收款行行号',width:120,align:'center'},
										{field:'AMOUNT',title:'交易金额(元)',width:120,align:'center',
											formatter:function(value,rec){
												return fenToYuan(rec.AMOUNT);
											}
										},
										{field:'ADDINFO',title:'附言',width:120,align:'center'},
										{field:'RSPSTATUS',title:'应答状态',width:120,align:'center'},
										{field:'RSPREJECTCODE',title:'应答码',width:120,align:'center'},
										{field:'RSPREJECTINFORMATION',title:'业务拒绝信息',width:120,align:'center'},
										{field:'RSPPROCESSPARTY',title:'业务处理参与机构',width:120,align:'center'},
										{field:'RSPDATE',title:'业务应答时间',width:120,align:'center'},
										{field:'TXNSEQNO',title:'交易流水号',width:120,align:'center'},
									]],
									pagination:true,
									rownumbers:true,
								})
							}

						});

	});

	function search() {
		var data = {
			"batchNo" : $('#batchNo').val(),
		}
		$('#test').datagrid('load', data);
	}
	function queryDetail(batchNo){
		$("#ttid").html("");
		$("#tmsgid").html("");
		$("#tbatchno").html("");
		$("#ttransmitsenderdate").html("");
		$("#ttransmitreceiverdate").html("");
		$("#treturnlimited").html("");
		$("#treceivetype").html("");
		$("#tendtoendidentification").html("");
		$("#tcheckflag").html("");
		$("#tdebtorname").html("");
		$("#tdebtoraccountno").html("");
		$("#tdebtoragentcode").html("");
		$("#tdebtorbranchcode").html("");
		$("#tcreditoragentcode").html("");
		$("#ttotalamount").html("");
		$("#tcategorypurposecode").html("");
		$("#tdebtornumber").html("");
		$("#tsendingtotalnumber").html("");
		$("#tsendingtotalamount").html("");
		$("#tfailtotalnumber").html("");
		$("#tfailtotalamount").html("");
		$("#tnpcprocessstatus").html("");
		$("#tnpcprocesscode").html("");
		$("#tnpcrejectinformation").html("");
		$("#tnpcnettingdate").html("");
		$("#tnpcnettinground").html("");
		$("#tnpcsettlementdate").html("");
		$("#tnpcreceivetime").html("");
		$("#tnpctransmittime").html("");
		$("#trspstatus").html("");
		$("#trsprejectcode").html("");
		$("#trspprocessparty").html("");
		$("#trsprejectinformation").html("");
		$("#trspdate").html("");
		$("#tcomprocessstatus").html("");
		$("#tcomprocesscode").html("");
		$("#tcompartyidentification").html("");
		$("#tcompartyprocesscode").html("");
		$("#tcomrejectinformation").html("");
		$("#tcomprocessdate").html("");
		$("#tcomnettinground").html("");
		$("#tcomdate").html("");
		   
		$('#w').window({
			title: '详细信息',
			top:90,
			left:100,
			width:900,
			modal: true,
			minimizable:false,
			collapsible:false,
			maximizable:false,
			shadow: false,
			closed: false,
			height: 800
		});
	
		var rows = $('#test').datagrid('getSelected');
		$("#ttid").html(rows["TID"]);
		$("#tmsgid").html(rows["MSGID"]);
		$("#tbatchno").html(rows["BATCHNO"]);
		$("#ttransmitsenderdate").html(rows["TRANSMITSENDERDATE"]);
		$("#ttransmitreceiverdate").html(rows["TRANSMITRECEIVERDATE"]);
		$("#treturnlimited").html(rows["RETURNLIMITED"]);
		$("#treceivetype").html(rows["RECEIVETYPE"]);
		$("#tendtoendidentification").html(rows["ENDTOENDIDENTIFICATION"]);
		$("#tcheckflag").html(rows["CHECKFLAG"]);
		$("#tdebtorname").html(rows["DEBTORNAME"]);
		$("#tdebtoraccountno").html(rows["DEBTORACCOUNTNO"]);
		$("#tdebtoragentcode").html(rows["DEBTORAGENTCODE"]);
		$("#tdebtorbranchcode").html(rows["DEBTORBRANCHCODE"]);
		$("#tcreditoragentcode").html(rows["CREDITORAGENTCODE"]);
		$("#ttotalamount").html(fenToYuan(rows["TOTALAMOUNT"]));
		$("#tcategorypurposecode").html(rows["CATEGORYPURPOSECODE"]);
		$("#tdebtornumber").html(rows["DEBTORNUMBER"]);
		$("#tsendingtotalnumber").html(rows["SENDINGTOTALNUMBER"]);
		$("#tsendingtotalamount").html(fenToYuan(rows["SENDINGTOTALAMOUNT"]));
		$("#tfailtotalnumber").html(rows["FAILTOTALNUMBER"]);
		$("#tfailtotalamount").html(fenToYuan(rows["FAILTOTALAMOUNT"]));
		$("#tnpcprocessstatus").html(rows["NPCPROCESSSTATUS"]);
		$("#tnpcprocesscode").html(rows["NPCPROCESSCODE"]);
		$("#tnpcrejectinformation").html(rows["NPCREJECTINFORMATION"]);
		$("#tnpcnettingdate").html(rows["NPCNETTINGDATE"]);
		$("#tnpcnettinground").html(rows["NPCNETTINGROUND"]);
		$("#tnpcsettlementdate").html(rows["NPCSETTLEMENTDATE"]);
		$("#tnpcreceivetime").html(rows["NPCRECEIVETIME"]);
		$("#tnpctransmittime").html(rows["NPCTRANSMITTIME"]);
		$("#trspstatus").html(rows["RSPSTATUS"]);
		$("#trsprejectcode").html(rows["RSPREJECTCODE"]);
		$("#trspprocessparty").html(rows["RSPPROCESSPARTY"]);
		$("#trsprejectinformation").html(rows["RSPREJECTINFORMATION"]);
		$("#trspdate").html(rows["RSPDATE"]);
		$("#tcomprocessstatus").html(rows["COMPROCESSSTATUS"]);
		$("#tcomprocesscode").html(rows["COMPROCESSCODE"]);
		$("#tcompartyidentification").html(rows["COMPARTYIDENTIFICATION"]);
		$("#tcompartyprocesscode").html(rows["COMPARTYPROCESSCODE"]);
		$("#tcomrejectinformation").html(rows["COMREJECTINFORMATION"]);
		$("#tcomprocessdate").html(rows["COMPROCESSDATE"]);
		$("#tcomnettinground").html(rows["COMNETTINGROUND"]);
		$("#tcomdate").html(rows["COMDATE"]);
	}
</script>
</html>
