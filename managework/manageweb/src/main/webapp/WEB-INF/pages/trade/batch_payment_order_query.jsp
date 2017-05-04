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
						<td align="right">批次号</td>
						<td align="left" style="padding-left: 5px"><input
							id="batchnos"  /></td>
						<td align="right">委托机构号</td>
						<td align="left" style="padding-left: 5px"><input
							id="merids"  /></td>
					</tr>
					<tr>
						<td align="right" width="10%">起止时间</td>
						<td colspan="2" style="padding-left: 5px"><input id="stime" type="text"
							style="width: 120PX" class="easyui-datetimebox"
							data-options="showSeconds:false" name="stime"></input> 至<input
							id=etime type="text" style="width: 120PX"
							class="easyui-datetimebox" data-options="showSeconds:false"
							name="etime"></input></td>
						<td style="padding-left: 5px"></td>
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
						<td>批次号</td><td id="batchno"></td>
						<td>订单发送时间</td><td id="txntime"></td>
					</tr>
					<tr>						
						<td>总笔数</td><td id="totalqty"></td>
						<td>总金额</td><td id="totalamt"></td>
					</tr>
					<tr>						
						<td>保留域</td><td id="reserved"></td>
						<td>响应码</td><td id="respcode"></td>
					</tr>
					<tr>						
						<td>应答信息</td><td id="respmsg"></td>
						<td>状态</td><td id="status"></td>
					</tr>
					<tr>						
						<td>订单提交时间</td><td id="ordercommitime"></td>
						<td>异步通知结果</td><td id="syncnotify"></td>
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

	function changeDate(value){
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
	var width = $("#continer").width();
	$(function() {

		$('#test')
				.datagrid(
						{
							title : '批量代付列表',
							iconCls : 'icon-save',
							height : 400,
							singleSelect : true,
							nowrap : false,
							striped : true,
							url : 'trade/getBatchPaymentOrderByPage',
							remoteSort : false,
							idField : 'MSGID',
							columns : [ [
								{field:'MERID',title:'委托机构号',width:120,align:'center'},
								{field:'VERSION',title:'版本',width:120,align:'center'},
								{field:'ENCODING',title:'编码方式',width:120,align:'center',
									formatter : function(value, rec) {
										if (rec.ENCODING == "1") {
											return "UTF-8";
										} 
									}		
								},
								{field:'BATCHNO',title:'批次号',width:180,align:'center'},
								{field:'TXNTIME',title:'订单发送时间',width:150,align:'center',
									formatter : function(value, rec) {
										return changeDate(rec.TXNTIME);
									}	
								},
								{field:'TOTALQTY',title:'总笔数',width:120,align:'center'},
								{field:'TOTALAMT',title:'总金额',width:120,align:'center'},
								{field:'RESERVED',title:'保留域',width:120,align:'center'},
								{field:'STATUS',title:'状态',width:120,align:'center',
									formatter : function(value, rec) {
										if (rec.STATUS == "00") {
											return "支付成功";
										} 
										if (rec.STATUS == "01") {
											return "订单提交成功,但未支付";
										} 
										if (rec.STATUS == "02") {
											return "支付中";
										} 
										if (rec.STATUS == "03") {
											return "支付失败";
										} 
										if (rec.STATUS == "04") {
											return "订单失效";
										} 
									}	
								},
								{field:'ORDERCOMMITIME',title:'订单提交时间',width:150,align:'center',
									formatter : function(value, rec) {
										return changeDate(rec.ORDERCOMMITIME);
									}		
								},
								{field:'SYNCNOTIFY',title:'异步通知结果',width:120,align:'center'},
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
									url:'trade/getPaymentOrderDetaByBatchNo?batchno='+batchNo,	
									remoteSort: false,
									idField:'TID',
									columns:[
									[
										{field:'BATCHNO',title:'批次号',width:180,align:'center'},
										{field:'ORDERID',title:'商户订单号',width:120,align:'center'},
										{field:'CURRENCYCODE',title:'交易币种',width:120,align:'center',
											formatter : function(value, rec) {
												if (rec.CURRENCYCODE == "156") {
													return "人民币";
												} 
											}	
										},
										{field:'AMT',title:'单笔金额(元)',width:120,align:'center'},
										{field:'DEBTORBANK',title:'付款人银行号',width:150,align:'center'},
										{field:'DEBTORACCOUNT',title:'付款人账号',width:150,align:'center'},
										{field:'DEBTORNAME',title:'付款人名称',width:150,align:'center'},
										{field:'DEBTORCONSIGN',title:'付款合同号',width:150,align:'center'},
										{field:'CREDITORBANK',title:'收款人银行号',width:150,align:'center'},
										{field:'CREDITORACCOUNT',title:'收款人账号',width:150,align:'center'},
										{field:'CREDITORNAME',title:'收款人名称',width:150,align:'center'},
										{field:'PROPRIETARY',title:'业务种类编码',width:120,align:'center'},
										{field:'RESPCODE',title:'响应码',width:120,align:'center'},
										{field:'RESPMSG',title:'应答信息',width:120,align:'center'},
										{field:'RELATETRADETXN',title:'交易序列号',width:120,align:'center'},
										{field:'STATUS',title:'状态',width:120,align:'center',
											formatter : function(value, rec) {
												if (rec.STATUS == "00") {
													return "支付成功";
												} 
												if (rec.STATUS == "01") {
													return "订单提交成功,但未支付";
												} 
												if (rec.STATUS == "02") {
													return "支付中";
												} 
												if (rec.STATUS == "03") {
													return "支付失败";
												} 
												if (rec.STATUS == "04") {
													return "订单失效";
												} 
											}	
										},
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
			"merid" : $('#merids').val(),
			"stime" : $('#stime').datebox('getValue'),
			"etime" : $('#etime').datebox('getValue')
		}
		$('#test').datagrid('load', data);
	}
	
	function resize(){
		$('#theForm :input').val('');
	}
	function queryDetail(batchNo){
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
		$("#batchno").html("");
		$("#txntime").html("");
		$("#totalqty").html("");
		$("#totalamt").html("");
		$("#reserved").html("");
		$("#respcode").html("");
		$("#respmsg").html("");
		$("#status").html("");
		$("#ordercommitime").html("");
		$("#syncnotify").html("");
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
			height: 400
		});
	
		function getStatus(value){
			if (value == "00") {
				return "支付成功";
			} 
			if (value == "01") {
				return "订单提交成功,但未支付";
			} 
			if (value == "02") {
				return "支付中";
			} 
			if (value == "03") {
				return "支付失败";
			} 
			if (value == "04") {
				return "订单失效";
			} 
		}
		
		var rows = $('#test').datagrid('getSelected');
		$("#tid").html(rows["TID"]);
		$("#accesstype").html(rows["ACCESSTYPE"]);
		$("#coopinstiid").html(rows["COOPINSTIID"]);
		$("#merid").html(rows["MERID"]);
		$("#version").html(rows["VERSION"]);
		if (rows["ENCODING"] == "1") {
			$("#encoding").html("UTF-8");
		}
		$("#txntype").html(rows["TXNTYPE"]);
		$("#txnsubtype").html(rows["TXNSUBTYPE"]);
		$("#biztype").html(rows["BIZTYPE"]);
		$("#backurl").html(rows["BACKURL"]);
		$("#batchno").html(rows["BATCHNO"]);
		$("#txntime").html(changeDate(rows["TXNTIME"]));
		$("#totalqty").html(rows["TOTALQTY"]);
		$("#totalamt").html(rows["TOTALAMT"]);
		$("#reserved").html(rows["RESERVED"]);
		$("#respcode").html(rows["RESPCODE"]);
		$("#respmsg").html(rows["RESPMSG"]);
		$("#status").html(getStatus(rows["STATUS"]));
		$("#ordercommitime").html(changeDate(rows["ORDERCOMMITIME"]));
		$("#syncnotify").html(rows["SYNCNOTIFY"]);
		$("#notes").html(rows["NOTES"]);
		$("#remarks").html(rows["REMARKS"]);
	}
</script>
</html>
