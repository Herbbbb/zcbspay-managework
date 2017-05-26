<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="<%=basePath%>/js/extendsValidator_1.0_20151215.js"></script>
<style type="text/css">
.left, .mid, .right {
	width: auto;
	float: left;
}

.form-control {
	border: 2px solid #A9C9E2;
}

.mid {
	padding-top: 45px;
	padding-left: 12px;
	padding-right: 12px;
}
</style>
<body>
	<style type="text/css">
table tr td.head-title {
	height: 25px;
	background-color: #F0F8FF;
	font-weight: bold;
	border-width: 1px 1px 1px 1px;
	border-style: groove;
}
table tr td.update {
	height: 25px;
	padding-left: 10px;
	border-width: 1px 1px 1px 1px;
	border-style: groove;
}
table tr td.add {
	height: 25px;
	
}

table tr td input {
	height: 15px;
}

table tr td select {
	height: 20px
}
</style>
	<div style="padding-top: 5px; margin-left: 5px; margin-right: 5px"
		id="continer">
		<div id="p" class="easyui-panel" title="查询条件"
			style="height: 80px; padding-top: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form action="" id="searchForm">
				<table width="100%">
					<tr>
						<td class="add" align="right">代理商编号</td>
						<td class="add" align="left" style="padding-left: 5px">
						<input id="a_caCode" name="caCode" /></td>
						
						<td class="add" align="right" >月份</td>
						<td class="add" align="left" style="padding-left: 5px">
						<input id="a_date" name="date" class="easyui-validatebox"
							 maxlength="7" missingMessage="请输入查询年月(yyyy-MM)" required="true" /></td>
						
						<td class="add" align="right">代理商获利模式</td>
						<td class="add" align="left" style="padding-left: 5px">
						<select id="profitType" name="profitType"></select></td>
						 
						<td class="add" align="right" colspan="3">
							<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a> 
							<a href="javascript:resize()" class="easyui-linkbutton"iconCls="icon-redo">清空</a></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="bankList">
			</table>
		</div>
	</div>
</body>
<script>
  	var width = $("#continer").width();
		$(function(){
			showProfitType();
			$('#bankList').datagrid({
				title:'代理商分润统计信息列表',
				iconCls:'icon-save',
				height:600,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'coopAgency/queryProfit',
				remoteSort: false,
				columns:[[
					{field:'CANAME',title:'代理商名称',align:'center',width:130},
					{field:'CACODE',title:'代理商代码',width:130,align:'center'},
					{field:'CAACCNAME',title:'银行账户名',align:'center',width:120},
					{field:'CABANKACC',title:'银行账号',width:130,align:'center'},
					{field:'BANKNODE',title:'开户行名称',align:'center',width:250,
						formatter:function(value,rec){
							return queryBankNode(rec.BANKNODE);
						}
					},
					{field:'NUMS',title:'交易成功笔数',align:'center',width:130},
					{field:'TXNFEE',title:'总手续费(元)',align:'center',width:130,
						formatter:function(value,rec){
							return fenToYuan(rec.TXNFEE);
						}
					},
					{field:'RATE',title:'分润比例(%)',align:'center',width:130},
					{field:'SPLITFEE',title:'分润金额(元)',align:'center',width:130,
						formatter:function(value,rec){
							return fenToYuan(rec.SPLITFEE);
						}
					},
					{field:'SETL',title:'结算金额(元)',align:'center',width:130,
						formatter:function(value,rec){
							return fenToYuan(rec.SETL);
						}
					},
					{field:'VDATE',title:'月份',align:'center',width:130}
				]],
				pagination:true,
				rownumbers:true,
			});
		});

		function resize(){
			$('#searchForm :input').val('');
		}
		
		function search(){
			var data={'caCode':$('#a_caCode').val(),'date':$("#a_date").val(),'profitType':$("#profitType").val()};
			$('#bankList').datagrid('load',data);
		}
			
		function showProfitType() {
			$.ajax({
				type: "POST",
				url: "coopAgency/queryProfitType",
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择获利模式--</option>";
					$.each(json,function(key, value) {
// 						if(value.PARA_CODE==province){
// 							html += '<option value="' + value.PARA_CODE + '" selected="selected">' + value.PARA_NAME + '</option>';
// 						}else{
							html += '<option value="' + value.PARA_CODE + '">' + value.PARA_NAME + '</option>';
// 						}
					}) ;
					$("#profitType").html(html);
				}
			});
		}
		
		function fenToYuan(value){
			var str = (value/100).toFixed(2) + '';
			var intSum = str.substring(0,str.indexOf(".")).replace( /\B(?=(?:\d{3})+$)/g, ',' );
			var dot = str.substring(str.length,str.indexOf("."))
			var ret = intSum + dot;
			return ret;
		}
		
		function queryBankNode(bankNode) {
			var bankName;
			$.ajax({
			   type: "POST",
			   url: "bankaccout/queryBankInfo",
			   data: "bankNode="+bankNode,
			   async: false,
			   dataType:"json",
				success: function(json) {
					var html;
					$.each(json,function(key, value) {
						bankName= json.bankName;
					});
				}
			});
		return bankName;
		}
	</script>
</html>
