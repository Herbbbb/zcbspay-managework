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
						<td align="right">报文标识号</td>
						<td align="left" style="padding-left: 5px"><input
							id="msgId" maxlength="8" /></td>
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
					<td>明细标识号</td><td id="ttxid"></td>
					</tr>
					<tr>
					<td>付款人名称</td><td id="tdebtorname"></td>
					<td>付款人账号</td><td id="tdebtoraccountno"></td>
					</tr>
					<tr>
					<td>付款清算行行号</td><td id="tdebtoragentcode"></td>
					<td>付款行行号</td><td id="tdebtorbranchcode"></td>
					</tr>
					<tr>
					<td>收款清算行行号</td><td id="tcreditoragentcode"></td>
					<td>收款行行号</td><td id="tcreditorbranchcode"></td>
					</tr>
					<tr>
					<td>收款人名称</td><td id="tcreditorname"></td>
					<td>收款人账号</td><td id="tcreditoraccountno"></td>
					</tr>
					<tr>
					<td>金额(元)</td><td id="tamount"></td>
					<td>业务类型编码</td><td id="tcategorypurposecode"></td>
					</tr>
					<tr>
					<td>业务种类编码</td><td id="tpurposeproprietary"></td>
					<td>合同（协议）号</td><td id="tendtoendidentification"></td>
					</tr>
					<tr>
					<td>核验标识</td><td id="tcheckflag"></td>
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
					<td>交易流水号</td><td id="ttxnseqno"></td>
					<td>接受标识</td><td id="treceivetype"></td>
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
							title : '交易流水列表',
							iconCls : 'icon-save',
							height : 400,
							singleSelect : true,
							nowrap : false,
							striped : true,
							url : 'trade/getBepsPaymentSingleByPage',
							remoteSort : false,
							idField : 'MSGID',
							columns : [ [
								{field:'TID',title:'标识',width:120,align:'center'},
								{field:'MSGID',title:'报文标识号',width:120,align:'center'},
								{field:'RECEIVETYPE',title:'接受标识',width:120,align:'center'},
								{field:'BATCHNO',title:'批次序号',width:120,align:'center'},
								{field:'TXID',title:'明细标识号',width:120,align:'center'},
								{field:'DEBTORNAME',title:'付款人名称',width:120,align:'center'},
								{field:'DEBTORACCOUNTNO',title:'付款人账号',width:120,align:'center'},
								{field:'DEBTORAGENTCODE',title:'付款清算行行号',width:120,align:'center'},
								{field:'DEBTORBRANCHCODE',title:'付款行行号',width:120,align:'center'},
								{field:'CREDITORAGENTCODE',title:'收款清算行行号',width:120,align:'center'},
								{field:'CREDITORBRANCHCODE',title:'收款行行号',width:120,align:'center'},
								{field:'CREDITORNAME',title:'收款人名称',width:120,align:'center'},
								{field:'CREDITORACCOUNTNO',title:'收款人账号',width:120,align:'center'},
								{field:'AMOUNT',title:'金额(元)',width:120,align:'center',
									formatter:function(value,rec){
										return fenToYuan(rec.AMOUNT);
									}
								},
								{field:'CATEGORYPURPOSECODE',title:'业务类型编码',width:120,align:'center'},
								{field:'PURPOSEPROPRIETARY',title:'业务种类编码',width:120,align:'center'},
								{field:'ENDTOENDIDENTIFICATION',title:'合同（协议）号',width:120,align:'center'},
								{field:'CHECKFLAG',title:'核验标识',width:120,align:'center'},
								{field:'ID',title:'操作',width:120,align:'center',
									formatter:function(value,rec){
										return '<a href="javascript:queryDetail(\''+rec.TID+'\')" style="color:blue;margin-left:10px">详细信息</a>';
									}
								}
							] ],
							pagination : true,
							rownumbers : true,
							}
						);

	});

	function search() {
		var data = {
			"msgId" : $('#msgId').val(),
		}
		$('#test').datagrid('load', data);
	}
	function queryDetail(batchNo){
		$("#ttid").html("");
		$("#tmsgid").html("");
		$("#treceivetype").html("");
		$("#tbatchno").html("");
		$("#ttxid").html("");
		$("#tdebtorname").html("");
		$("#tdebtoraccountno").html("");
		$("#tdebtoragentcode").html("");
		$("#tdebtorbranchcode").html("");
		$("#tcreditoragentcode").html("");
		$("#tcreditorbranchcode").html("");
		$("#tcreditorname").html("");
		$("#tcreditoraccountno").html("");
		$("#tamount").html("");
		$("#tcategorypurposecode").html("");
		$("#tpurposeproprietary").html("");
		$("#tendtoendidentification").html("");
		$("#tcheckflag").html("");
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
		$("#ttxnseqno").html("");
		   
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
		$("#treceivetype").html(rows["RECEIVETYPE"]);
		$("#tbatchno").html(rows["BATCHNO"]);
		$("#ttxid").html(rows["TXID"]);
		$("#tdebtorname").html(rows["DEBTORNAME"]);
		$("#tdebtoraccountno").html(rows["DEBTORACCOUNTNO"]);
		$("#tdebtoragentcode").html(rows["DEBTORAGENTCODE"]);
		$("#tdebtorbranchcode").html(rows["DEBTORBRANCHCODE"]);
		$("#tcreditoragentcode").html(rows["CREDITORAGENTCODE"]);
		$("#tcreditorbranchcode").html(rows["CREDITORBRANCHCODE"]);
		$("#tcreditorname").html(rows["CREDITORNAME"]);
		$("#tcreditoraccountno").html(rows["CREDITORACCOUNTNO"]);
		$("#tamount").html(fenToYuan(rows["AMOUNT"]));
		$("#tcategorypurposecode").html(rows["CATEGORYPURPOSECODE"]);
		$("#tpurposeproprietary").html(rows["PURPOSEPROPRIETARY"]);
		$("#tendtoendidentification").html(rows["ENDTOENDIDENTIFICATION"]);
		$("#tcheckflag").html(rows["CHECKFLAG"]);
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
		$("#ttxnseqno").html(rows["TXNSEQNO"]);
	}
</script>
</html>
