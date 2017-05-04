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
			style="height: 100px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="theForm" method="post">
				<table width="100%">
					<tr>
						<td align="right" width="10%">批次号</td>
						<td align="left" style="padding-left: 5px" width="25%"><input
							name="batchno" id="batchnos"  /></td>
						<td align="right" width="10%">发起方代码</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="transmitleg" id="transmitlegs"  /></td>
						<td align="right" width="10%">接收方代码</td>
						<td align="left" style="padding-left: 5px" width="25%"><input
							name="receiver" id="receivers"  /></td>
					</tr>
					<tr>
						<td align="right" width="10%">交易起止时间</td>
						<td colspan="2" style="padding-left: 5px"><input id="stime" type="text"
							style="width: 120PX" class="easyui-datetimebox"
							data-options="showSeconds:false" name="stime"></input> 至<input
							id=etime type="text" style="width: 120PX"
							class="easyui-datetimebox" data-options="showSeconds:false"
							name="etime"></input></td>
						<td align="right" width="10%"></td>
						<td align="left" style="padding-left: 5px" width="15%"></td>
						<td align="left" ><a href="javascript:search()"
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
						<td>批次号</td><td id="batchno"></td>
						<td>报文类型</td><td id="msgtype"></td>
					</tr>
					<tr>						
						<td>服务类型</td><td id="servicetype"></td>
						<td>发起方代码</td><td id="transmitleg"></td>
					</tr>
					<tr>						
						<td>接收方代码</td><td id="receiver"></td>
						<td>本地日期</td><td id="transdate"></td>
					</tr>
					<tr>						
						<td>本地时间</td><td id="transtime"></td>
						<td>总笔数</td><td id="totalqty"></td>
					</tr>
					<tr>						
						<td>总金额（元）</td><td id="totalamt"></td>
						<td>应答码</td><td id="rspcode"></td>
					</tr>
					<tr>						
						<td>应答信息</td><td id="respmsg"></td>
						<td>批次完成时间</td><td id="rspdate"></td>
					</tr>
					<tr>						
						<td>操作员代码</td><td id="operatorcode"></td>
						<td>原始批次号</td><td id="origbatchno"></td>
					</tr>
					<tr>						
						<td>备注</td><td id="notes"></td>
						<td>备注</td><td id="remarks"></td>
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
							title : '批量代收渠道批次列表',
							iconCls : 'icon-save',
							height : 400,
							singleSelect : true,
							nowrap : false,
							striped : true,
							url : 'trade/getChnCollectBatchLogByPage',
							remoteSort : false,
							idField : 'MSGID',
							columns : [ [
								{field:'BATCHNO',title:'批次号',width:130,align:'center'},
								{field:'MSGTYPE',title:'报文类型',width:120,align:'center'},
								{field:'SERVICETYPE',title:'服务类型',width:120,align:'center'},
								{field:'TRANSMITLEG',title:'发起方代码',width:120,align:'center'},
								{field:'RECEIVER',title:'接收方代码',width:120,align:'center'},
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
								{field:'TOTALQTY',title:'总笔数',width:120,align:'center'},
								{field:'TOTALAMT',title:'总金额（元）',width:120,align:'center',
									formatter : function(value, rec) {
										return yuanToFen(rec.TOTALAMT);
									}
								},
								{field:'RSPDATE',title:'批次完成时间',width:120,align:'center',
									formatter : function(value, rec) {
										return changeDateTime(rec.RSPDATE);
									}
									
								},
								{field:'OPERATORCODE',title:'操作员代码',width:120,align:'center'},
								{field:'ORIGBATCHNO',title:'原始批次号',width:135,align:'center'},
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
									title:'批量代收渠道批次明细列表',
									iconCls:'icon-save',
									height:400,
									singleSelect:true,
									nowrap: false,
									striped: true,
									url:'trade/getChnCollectDetaByBatchNo?batchno='+batchNo,	
									remoteSort: false,
									idField:'TID',
									columns:[
									[
										{field:'BATCHNO',title:'批次号',width:130,align:'center'},
										{field:'TXID',title:'明细标识号',width:120,align:'center'},
										{field:'CHARGINGUNIT',title:'收费单位代码',width:120,align:'center'},
										{field:'TRANSDATE',title:'提交日期',width:120,align:'center',
											formatter : function(value, rec) {
												return changeDate(rec.TRANSDATE);
											}	
										},
										{field:'DEBTORNAME',title:'付款人名称',width:120,align:'center'},
										{field:'DEBTORACCOUNTNO',title:'付款人账号',width:140,align:'center'},
										{field:'DEBTORBRANCHCODE',title:'付款行行号',width:120,align:'center'},
										{field:'CREDITORBRANCHCODE',title:'收款行行号',width:120,align:'center'},
										{field:'CREDITORACCOUNTNO',title:'收款人账号',width:140,align:'center'},
										{field:'CURRENCYSYMBOL',title:'货币类型',width:120,align:'center',
											formatter : function(value, rec) {
												if (rec.CURRENCYSYMBOL == "RMB") {
													return "人民币";
												} 
											}	
										},
										{field:'AMOUNT',title:'金额（元）',width:120,align:'center',
											formatter : function(value, rec) {
												return yuanToFen(rec.AMOUNT);
											}
										},
										{field:'METEROBJNUMBER',title:'计量对象号码',width:120,align:'center'},
										{field:'AUTHNUMBER',title:'授权号',width:120,align:'center'},
										{field:'PAYMENTTOOLTYPE',title:'支付工具类型',width:120,align:'center',
											formatter : function(value, rec) {
												if (rec.PAYMENTTOOLTYPE == "0") {
													return "未知";
												} 
												if (rec.PAYMENTTOOLTYPE == "1") {
													return "活期储蓄存折";
												} 
												if (rec.PAYMENTTOOLTYPE == "2") {
													return "对公账户";
												} 
												if (rec.PAYMENTTOOLTYPE == "3") {
													return "借记卡";
												} 
												if (rec.PAYMENTTOOLTYPE == "4") {
													return "信用卡（贷记卡）";
												} 
												if (rec.PAYMENTTOOLTYPE == "5") {
													return "活期存款账户";
												} 
											}	
										},
										{field:'VOUCHERNUMBER',title:'凭证号码',width:120,align:'center'},
										{field:'POSTSCRIPT',title:'附言',width:120,align:'center'},
										{field:'RSPSTATUS',title:'应答码',width:120,align:'center'},
										{field:'RSPREJECTCODE',title:'拒绝应答码',width:120,align:'center'},
										{field:'RSPREJECTINFORMATION',title:'业务拒绝信息',width:120,align:'center'},
										{field:'RSPDATE',title:'批次完成时间',width:125,align:'center',
											formatter : function(value, rec) {
												return changeDateTime(rec.RSPDATE);
											}
										},
										{field:'NETTINGDATE',title:'轧差日期',width:120,align:'center',
											formatter : function(value, rec) {
												return changeDate(rec.NETTINGDATE);
											}
										},
										{field:'TXNSEQNO',title:'交易流水号',width:130,align:'center'},
									]],
									pagination:true,
									rownumbers:true,
								})
							}

						});

	});

	function search() {
		var data = {
				"batchno" : $('#batchnos').val(),
				"transmitleg" : $('#transmitlegs').val(),
				"receiver" : $('#receivers').val(),
				"stime" : $('#stime').datebox('getValue'),
				"etime" : $('#etime').datebox('getValue')
		}
		$('#test').datagrid('load', data);
	}
	
	function resize(){
		$('#theForm :input').val('');
	}
	
	function queryDetail(batchNo){
		$("#batchno").html("");
		$("#msgtype").html("");
		$("#servicetype").html("");
		$("#transmitleg").html("");
		$("#receiver").html("");
		$("#transdate").html("");
		$("#transtime").html("");
		$("#totalqty").html("");
		$("#totalamt").html("");
		$("#rspcode").html("");
		$("#respmsg").html("");
		$("#rspdate").html("");
		$("#operatorcode").html("");
		$("#origbatchno").html("");
		$("#notes").html("");
		$("#remarks").html("");
		   
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
			height: 276
		});
	
		var rows = $('#test').datagrid('getSelected');
		$("#batchno").html(rows["BATCHNO"]);
		$("#msgtype").html(rows["MSGTYPE"]);
		$("#servicetype").html(rows["SERVICETYPE"]);
		$("#transmitleg").html(rows["TRANSMITLEG"]);
		$("#receiver").html(rows["RECEIVER"]);
		$("#transdate").html(changeDate(rows["TRANSDATE"]));
		$("#transtime").html(changeTime(rows["TRANSTIME"]));
		$("#totalqty").html(rows["TOTALQTY"]);
		$("#totalamt").html(rows["TOTALAMT"]/100);
		$("#rspcode").html(rows["RSPCODE"]);
		$("#respmsg").html(rows["RESPMSG"]);
		$("#rspdate").html(changeDateTime(rows["RSPDATE"]));
		$("#operatorcode").html(rows["OPERATORCODE"]);
		$("#origbatchno").html(rows["ORIGBATCHNO"]);
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
