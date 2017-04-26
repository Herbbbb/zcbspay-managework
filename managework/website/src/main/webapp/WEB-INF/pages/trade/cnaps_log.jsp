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
						<td align="right" width="10%">报文标识号</td>
						<td align="left" style="padding-left: 5px" width="25%"><input
							name="msgId" id="msgId" maxlength="32" /></td>
						<td align="right" width="10%">报文类型</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="msgType" id="msgType" maxlength="32" /></td>
						<td></td>
					</tr>
					<tr>
						<td align="right" width="10%">报文发送时间</td>
						<td style="padding-left: 5px"><input id="stime" type="text"
							style="width: 120PX" class="easyui-datetimebox"
							data-options="showSeconds:false" name="stime"></input> 至<input
							id=etime type="text" style="width: 120PX"
							class="easyui-datetimebox" data-options="showSeconds:false"
							name="etime"></input></td>
						<td></td>
						<td></td>
						<td align="right"><a href="javascript:search()"
							class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="test"></table>
		</div>
	</div>
</body>

<script>
	var width = $("#continer").width();
	$(function() {

		$('#test')
				.datagrid(
						{
							title : '交易订单列表',
							iconCls : 'icon-save',
							height : 500,
							singleSelect : true,
							nowrap : false,
							striped : true,
							url : 'trade/getCnapsLogByPage',
							remoteSort : false,
							idField : 'MSGID',
							columns : [ [
								{field:'MSGID',title:'报文标识号',width:120,align:'center'},
								{field:'SYSCODE',title:'系统编号',width:120,align:'center'},
								{field:'MSGTYPE',title:'报文类型',width:120,align:'center'},
								{field:'CREATEDATE',title:'报文发送时间',width:120,align:'center'},
								{field:'INSTRUCTINGDIRECTPARTY',title:'发起直接参与机构',width:120,align:'center'},
								{field:'INSTRUCTINGPARTY',title:'发起参与机构',width:120,align:'center'},
								{field:'INSTRUCTEDDIRECTPARTY',title:'接收直接参与机构',width:120,align:'center'},
								{field:'INSTRUCTEDPARTY',title:'接收参与机构',width:120,align:'center'},
								{field:'ORGNLMSGID',title:'原报文标识号',width:120,align:'center'},
								{field:'ORGNLINSTGPTY',title:'原发起参与机构',width:120,align:'center'},
								{field:'ORIGINALMESSAGETYPE',title:'原报文类型',width:120,align:'center'},
								{field:'TOTALNUMBER',title:'总记录数',width:120,align:'center'},
								{field:'STARTNUMBER',title:'本报文记录起始序号',width:120,align:'center'},
								{field:'ENDNUMBER',title:'本报文记录截止序号',width:120,align:'center'},
								{field:'ADDINFO',title:'附言',width:120,align:'center'},
						] ],
							pagination : true,
							rownumbers : true

						});

	});

	function search() {
		var data = {
			"msgId" : $('#msgId').val(),
			"msgType" : $('#msgType').val(),
			"stime" : $('#stime').datebox('getValue'),
			"etime" : $('#etime').datebox('getValue')
		}
		$('#test').datagrid('load', data);
	}
</script>
</html>
