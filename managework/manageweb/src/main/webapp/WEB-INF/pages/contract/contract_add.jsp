<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link href="<%=basePath%>js/uploadify/uploadify.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<%=basePath%>js/uploadify/jquery.uploadify.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/js/extendsValidator_1.0_20151215.js"></script>
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
	height: 15px
}

table tr td select {
	height: 20px
}
</style>
	<div style="padding-top: 5px; margin-left: 5px; margin-right: 5px" id="continer">
		<div id="p" class="easyui-panel" title="查询条件"
			style="height: 130px; padding-top: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form action="" id="searchForm">
				<table width="100%">
					<tr>
						<td class="add" align="right" width="18%">委托机构号</td>
						<td class="add" align="left" style="padding-left: 5px"><input
							id="a_merchNo" name="merchNo" /></td>
						<td class="add" align="right" width="18%">合同编号</td>
						<td class="add" align="left" style="padding-left: 5px"><input
							id="a_contractNum" name="contractNum" /></td>
					</tr>
					<tr>
						<td class="add" align="right">付款人名称</td>
						<td class="add" align="left" style="padding-left: 5px"><input
							id="a_debName" name="debName" /></td>
						<td class="add" align="right">付款人账号</td>
						<td class="add" align="left" style="padding-left: 5px"><input
							id="a_debBranchCode" name="debBranchCode" /></td>
					</tr>
					<tr>
						<td class="add" align="right">收款人名称</td>
						<td class="add" align="left" style="padding-left: 5px"><input
							id="a_credName" name="credName" /></td>
						<td class="add" align="right">收款人账号</td>
						<td class="add" align="left" style="padding-left: 5px"><input
							id="a_credAccNo" name="credAccNo" /></td>
						<td class="add" align="right" colspan="3"><a href="javascript:search()"
							class="easyui-linkbutton" iconCls="icon-search">查询</a> <a
							href="javascript:resize()" class="easyui-linkbutton"
							iconCls="icon-redo">清空</a></td>
							<td class="add" align="right"></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="bankList">
			</table>
		</div>
	</div>
	<div id="w" class="easyui-window" closed="true" title="My Window" iconCls="icon-save" style="width: 600px; height: 400px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding:10px 5px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="saveForm" action="contract/save" method="post">
					<input type="hidden" id="fileAddress" name="fileAddress" />
					<table width="90%" cellpadding="2" cellspacing="2">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 30px">
							<td class="update" width="18%">委托机构号</td>
							<td class="update" align="left">
							<input type="text" id="merchNo" name="merchNo" class="easyui-validatebox" required="true"
								maxlength="15" missingMessage="请输入委托机构号" validType="merchno"/></td>
							<td class="update" width="18%">合同编号 </td>
							<td class="update" align="left">
							<input type="text" id="contractNum" name="contractNum" class="easyui-validatebox" required="true"
								maxlength="20" missingMessage="请输入合同编号" validType="contract"/></td>
						</tr>
<!-- 						<tr style="height: 30px"> -->
<!-- 							<td class="update">业务类型</td> -->
<!-- 							<td class="update" align="left"> -->
<!-- 							<input type="text" id="categoryPurpose" name="categoryPurpose" class="easyui-validatebox" required="true" -->
<!-- 								maxlength="10" missingMessage="请输入业务类型"/></td> -->
<!-- 							<td class="update">业务种类</td> -->
<!-- 							<td class="update" align="left"> -->
<!-- 							<input type="text" id="proprieTary" name="proprieTary" class="easyui-validatebox" required="true" -->
<!-- 								maxlength="10" missingMessage="请输入业务种类"/></td> -->
<!-- 						</tr> -->
						<tr style="height: 30px">
							<td class="update">合同类型</td>
							<td class="update" align="left">
							<select id="contractType" class="easyui-validatebox" missingMessage="请选择类型"
								required="true" name="contractType" onchange="checkIsDelegation(1)">
									<option value=''>请选择合同类型</option>
									<option value='CT00'>批量代收协议</option>
									<option value='CT01'>批量代付协议</option>
									<option value='CT02'>实时代收协议</option>
									<option value='CT03'>实时代付协议</option>
							</select></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">付款人名称</td>
							<td class="update" align="left">
							<input type="text" name="debName" required="true" maxlength="15" 
							missingMessage="请输入付款人名称" class="easyui-validatebox" validType="debName"/></td>
							<td class="update">付款人账号 </td>
							<td class="update" align="left">
							<input type="text" id="debAccNo" name="debAccNo" class="easyui-validatebox" required="true"
								maxlength="20" missingMessage="请输入付款人账号" validType="bankcard"/></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">付款行银行全称</td>
							<td class="update" align="left" colspan="3">
								<select id="debBranchCode" class="easyui-validatebox" required="true" name="debBranchCode" style="width: 250px"/>
								<option value=''>--请选择开户行--</option></select><font color="red">*</font>
								<input id="banknode_key" maxlength="16" type="text" onclick="checkBankKey('add_a')" onchange="queryBankNode('add_a')"/></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">金额限制类型</td>
							<td class="update" align="left">
							<select id="debTranLimitType" class="easyui-validatebox" missingMessage="请选择类型"
								required="true" name="debTranLimitType">
									<option value='00'>--不限--</option>
									<option value='01'>按年限次</option>
									<option value='02'>按月限次</option>
									<option value='03'>总计限次</option>
							</select></td>
							<td class="update">累计金额上限(元)</td>
							<td class="update" align="left">
							<input type="text" id="debAccyAmoLimit" name="debAccyAmoLimit" class="easyui-validatebox" required="true"
								maxlength="12" missingMessage="请输入累计上限金额(元)" validType="amount"/></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">付款次数限制类型</td>
							<td class="update" align="left">
							<select id="debTransLimitType" class="easyui-validatebox" missingMessage="请选择类型" name="debTransLimitType">
									<option value='00'>--不限--</option>
									<option value='01'>按年限次</option>
									<option value='02'>按月限次</option>
									<option value='03'>总计限次</option>
							</select></td>
							<td class="update">付款次数限制</td>
							<td class="update" align="left">
							<input type="text" id="debTransLimit" name="debTransLimit" class="easyui-validatebox" 
								maxlength="10" missingMessage="请输入限制次数"/></td>
						</tr>
						<tr style="height:30px">
							<td class="update">单笔金额上限(元) </td>
							<td class="update" align="left"  colspan="3">
							<input type="text" id="debAmoLimit" name="debAmoLimit" class="easyui-validatebox" required="true"
								maxlength="20" missingMessage="请输入单笔上限金额(元)" validType="amount"/></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">收款人名称</td>
							<td class="update" align="left">
							<input type="text" id="credName" name="credName" class="easyui-validatebox" required="true"
								maxlength="12" missingMessage="请输入收款人名称" class="easyui-validatebox" validType="debName"/></td>
							<td class="update">收款人账号 </td>
							<td class="update" align="left">
							<input type="text" id="credAccNo" name="credAccNo" class="easyui-validatebox" required="true"
								maxlength="20" missingMessage="请输入收款人账号" validType="bankcard"/></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">收款行银行全称</td>
							<td class="update" align="left" colspan="3">
								<select id="credBranchCode" class="easyui-validatebox" required="true" name="credBranchCode" style="width: 250px"/>
								<option value=''>--请选择开户行--</option></select><font color="red">*</font>
								<input id="b_banknode_key" maxlength="16" type="text" onclick="checkBankKey('add_b')" onchange="queryBankNode('add_b')"/></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">金额限制类型</td>
							<td class="update" align="left">
							<select id="credTranLimitType" class="easyui-validatebox" missingMessage="请选择类型"
								required="true" name="credTranLimitType">
									<option value='00'>--不限--</option>
									<option value='01'>按年限次</option>
									<option value='02'>按月限次</option>
									<option value='03'>总计限次</option>
							</select></td>
							<td class="update">累计金额上限(元)</td>
							<td class="update" align="left">
							<input type="text" id="credAccuAmoLimit" name="credAccuAmoLimit" class="easyui-validatebox" required="true"
								maxlength="12" missingMessage="请输入累计上限金额(元)" validType="amount"/></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">收款次数限制类型</td>
							<td class="update" align="left">
							<select id="credTransLimitType" class="easyui-validatebox" missingMessage="请选择类型" name="credTransLimitType">
									<option value='00'>--不限--</option>
									<option value='01'>按年限次</option>
									<option value='02'>按月限次</option>
									<option value='03'>总计限次</option>
							</select></td>
							<td class="update">收款次数限制</td>
							<td class="update" align="left">
							<input type="text" id="credTransLimit" name="credTransLimit" class="easyui-validatebox" 
								maxlength="10" missingMessage="请输入限制次数"/></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">单笔金额上限(元) </td>
							<td class="update" align="left" colspan="3">
							<input type="text" id="credAmoLimit" name="credAmoLimit" class="easyui-validatebox" required="true"
								maxlength="20" missingMessage="请输入单笔上限金额(元)" validType="amount"/></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 30px">
							<td class="update" align="center">合约开始日期</td>
							<td class="update" align="left"><input type="text" class="easyui-datebox" name="signDate"/></td>
							<td class="update" align="center">合约终止日期</td>
							<td class="update" align="left"><input type="text" class="easyui-datebox" name="expiryDate"/></td>
						</tr>
						<tr id="delegation" style="height: 30px">
							<td class="update">收费协议号</td>
							<td class="update" align="left">
							<input type="text" id="chargeConntract" name="chargeConntract" class="easyui-validatebox"
								maxlength="12" missingMessage="请输入收费协议号"/></td>
							<td class="update">收费代码</td>
							<td class="update" align="left">
							<input type="text" id="chargeNo" name="chargeNo" class="easyui-validatebox"
								maxlength="20" missingMessage="请输入收费代码"/></td>
						</tr>
						<tr id="delegation_2" style="height: 30px">
							<td class="update">付费协议号</td>
							<td class="update" align="left">
							<input type="text" id="payContract" name="payContract" class="easyui-validatebox"
								maxlength="12" missingMessage="请输入付费协议号"/></td>
							<td class="update"></td>
							<td class="update" align="left">
							</td>
						</tr>
						<tr style="height: 30px">
							<td class="update" align="center">合同附件</td>
							<td class="update" align="left"><input class="easyui-validatebox" required="true" id="fileAddress_cert_img" type="file"/>
								<div id="fileAddress_span"></div> 
							</td>
							<td class="update"></td>
							<td class="update" align="left"></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">备注</td>
							<td class="update" align="left" colspan="3">
							<textarea rows="3" cols="81" id="notes" maxlength="64" name="notes" 
							style="resize: none;"></textarea></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveUser('0')" id="btn_submit">提交</a>
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeAdd()">返回</a>
			</div>
		</div>
	</div>
	<div id="w2" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 400px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="b_saveForm" action="" method="post">
					<input type="hidden" id="b_tId" name="tId" readonly="true"/> 
					<input type="hidden" id="b_fileAddress" name="fileAddress" readonly="true"/> 
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 30px">
							<td width="18%" class="update">委托机构号</td>
							<td align="left" class="update"><span id="b_merchNo"></span></td>
							<td width="18%" class="update">合同编号 </td>
							<td align="left" class="update"><span id="b_contractNum"></span></td>
						</tr>
<!-- 						<tr style="height: 30px"> -->
<!-- 							<td class="update">业务类型</td> -->
<!-- 							<td align="left" class="update"><span id="b_categoryPurpose"></span></td> -->
<!-- 							<td class="update">业务种类</td> -->
<!-- 							<td align="left" class="update"><span id="b_proprieTary"></span></td> -->
<!-- 						</tr> -->
						<tr style="height: 30px">
							<td class="update">合同类型</td>
							<td align="left" class="update"><span id="b_contractType"></span></td>
							<td class="update"></td>
							<td align="left" class="update"></span></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">付款人名称</td>
							<td align="left" class="update"><span id="b_debName"></span></td>
							<td class="update">付款人账号 </td>
							<td align="left" class="update"><span id="b_debAccNo"></span></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">付款行银行全称</td>
							<td align="left" class="update"><span id="b_debBranchCode"></span></td>
							<td class="update">单笔金额上限(元) </td>
							<td align="left" class="update"><span id="b_debAmoLimit"></span></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">金额限制类型</td>
							<td align="left" class="update"><span id="b_debTranLimitType"></span></td>
							<td class="update">累计金额上限(元)</td>
							<td align="left" class="update"><span id="b_debAccyAmoLimit"></span></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">付款次数限制类型</td>
							<td align="left" class="update"><span id="b_debTransLimitType"></span></td>
							<td class="update">付款次数限制</td>
							<td align="left" class="update"><span id="b_debTransLimit"></span></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">收款人名称</td>
							<td align="left" class="update"><span id="b_credName"></span></td>
							<td class="update">收款人账号 </td>
							<td align="left" class="update"><span id="b_credAccNo"></span></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">收款行银行全称</td>
							<td align="left" class="update"><span id="b_credBranchCode"></span></td>
							<td class="update">单笔金额上限(元) </td>
							<td align="left" class="update"><span id="b_credAmoLimit"></span></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">金额限制类型</td>
							<td align="left" class="update"><span id="b_credTranLimitType"></span></td>
							<td class="update">累计金额上限(元)</td>
							<td align="left" class="update"><span id="b_credAccuAmoLimit"></span></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">收款次数限制类型</td>
							<td align="left" class="update"><span id="b_credTransLimitType"></span></td>
							<td class="update">收款次数限制</td>
							<td align="left" class="update"><span id="b_credTransLimit"></span></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 30px">
							<td align="center" class="update">合约开始日期</td>
							<td align="left" class="update"><span id="b_startDate"></span></td>
							<td align="center" class="update">合约终止日期</td>
							<td align="left" class="update"><span id="b_endDate"></span></td>
						</tr>
						<tr id="b_delegation" style="height: 30px">
							<td class="update">收费协议号</td>
							<td class="update" align="left"><span id="b_chargeConntract"></span></td>
							<td class="update">收费代码</td>
							<td class="update" align="left"><span id="b_chargeNo"></span></td>
						</tr>
						<tr id="b_delegation_2" style="height: 30px">
							<td class="update">付费协议号</td>
							<td class="update" align="left"><span id="b_payContract"></span></td>
							<td class="update"></td>
							<td class="update" align="left"></td>
						</tr>
						<tr style="height: 30px">
							<td align="center" class="update">合同附件</td>
							<td align="left" class="update"><div id="signfileOpp_span"></div></td>
							<td class="update"></td>
							<td class="update" align="left"></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">备注</td>
							<td align="left" colspan="3" class="update"><span id="b_notes" rows="3" cols="81" style="resize: none;"></span></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-back" onclick="closeAdd()">返回</a>
			</div>
		</div>
	</div>
	<div id="w3" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 400px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="c_saveForm" action="" method="post">
					<input type="hidden" id="c_tId" name="tId" readonly="true"/> 
					<input type="hidden" id="c_fileAddress" name="fileAddress" readonly="true"/> 
					<table width="100%" cellpadding="2" cellspacing="2">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 30px">
							<td width="18%" class="update">委托机构号</td>
							<td align="left" class="update"><span id="c_merchNo"></span></td>
							<td width="18%" class="update">合同编号 </td>
							<td align="left" class="update"><span id="c_contractNum"></span></td>
						</tr>
<!-- 						<tr style="height: 30px"> -->
<!-- 							<td class="update">业务类型</td> -->
<!-- 							<td align="left" class="update"><span id="c_categoryPurpose"></span></td> -->
<!-- 							<td class="update">业务种类</td> -->
<!-- 							<td align="left" class="update"><span id="c_proprieTary"></span></td> -->
<!-- 						</tr> -->
						<tr style="height: 30px">
							<td class="update">合同类型</td>
							<td align="left" class="update"><span id="c_contractType"></span></td>
							<td class="update"></td>
							<td align="left" class="update"></span></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">付款人名称</td>
							<td align="left" class="update"><span id="c_debName"></span></td>
							<td class="update">付款人账号 </td>
							<td align="left" class="update"><span id="c_debAccNo"></span></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">付款行银行全称</td>
							<td align="left" class="update"><span id="c_debBranchCode"></span></td>
							<td class="update">单笔金额上限(元) </td>
							<td align="left" class="update"><span id="c_debAmoLimit"></span></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">金额限制类型</td>
							<td align="left" class="update"><span id="c_debTranLimitType"></span></td>
							<td class="update">累计金额上限(元)</td>
							<td align="left" class="update"><span id="c_debAccyAmoLimit"></span></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">付款次数限制类型</td>
							<td align="left" class="update"><span id="c_debTransLimitType"></span></td>
							<td class="update">付款次数限制</td>
							<td align="left" class="update"><span id="c_debTransLimit"></span></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">收款人名称</td>
							<td align="left" class="update"><span id="c_credName"></span></td>
							<td class="update">收款人账号 </td>
							<td align="left" class="update"><span id="c_credAccNo"></span></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">收款行银行全称</td>
							<td align="left" class="update"><span id="c_credBranchCode"></span></td>
							<td class="update">单笔金额上限(元)</td>
							<td align="left" class="update"><span id="c_credAmoLimit"></span></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">金额限制类型</td>
							<td align="left" class="update"><span id="c_credTranLimitType"></span></td>
							<td class="update">累计金额上限(元)</td>
							<td align="left" class="update"><span id="c_credAccuAmoLimit"></span></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">收款次数限制类型</td>
							<td align="left" class="update"><span id="c_credTransLimitType"></span></td>
							<td class="update">收款次数限制</td>
							<td align="left" class="update"><span id="c_credTransLimit"></span></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr style="height: 30px">
							<td align="center" class="update">合约开始日期</td>
							<td align="left" class="update"><span id="c_startDate"></span></td>
							<td align="center" class="update">合约终止日期</td>
							<td align="left" class="update"><span id="c_endDate"></span></td>
						</tr>
						<tr id="c_delegation" style="height: 30px">
							<td class="update">收费协议号</td>
							<td class="update" align="left"><span id="c_chargeConntract"></span></td>
							<td class="update">收费代码</td>
							<td class="update" align="left"><span id="c_chargeNo"></span></td>
						</tr>
						<tr id="c_delegation_2" style="height: 30px">
							<td class="update">付费协议号</td>
							<td class="update" align="left"><span id="c_payContract"></span></td>
							<td class="update"></td>
							<td class="update" align="left"></td>
						</tr>
						<tr style="height: 30px">
							<td align="center" class="update">合同附件</td>
							<td align="left" class="update"><div id="c_signfileOpp_span"></div></td>
							<td class="update"></td>
							<td class="update" align="left"></td>
						</tr>
						<tr style="height: 30px">
							<td class="update">备注</td>
							<td align="left" colspan="3" class="update"><span id="c_notes" rows="3" cols="81" style="resize: none;"></span></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
			<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:deleteUser()" id="c_btn_submit">提交</a>
				<a class="easyui-linkbutton" iconCls="icon-back" onclick="closeAdd()">返回</a>
			</div>
		</div>
	</div>
	<div id="w4" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 400px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="d_saveForm" action="contract/excelImport" method="post">
					<table width="90%" cellpadding="2" cellspacing="2">
					<tr style="height: 30px">
						<td class="update" align="center"  style="font-size: 15px;">合同文件</td>
						<td class="update" align="left">
							<input style="height: 25px;" class="easyui-validatebox" name="orderCSV" type="file"/>
						</td>
					</tr>
					<tr style="height: 30px">
						<td class="update" align="center"></td>
						<td class="update" align="left"><div style="height: 25px;font-size: 15px;" id="org_province"></div></td>
					</tr>
				</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:saveFile()" id="d_btn_submit">提交</a>
				<a class="easyui-linkbutton" iconCls="icon-back" onclick="closeAdd()">返回</a>
			</div>
		</div>
	</div>
	<div id="w5" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px; top: 50%; left: 50%; ">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center;overflow:hidden;">
				<form id="d_saveForm" action="" method="post">
					<table width="90%" cellpadding="2" cellspacing="2">
						<tr style="height: 30px">
							<td align="left" class="update"><span id="error_message"></span></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 15px 0;">
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeAdd()">返回</a>
			</div>
		</div>
	</div>
</body>
</body>
<script>
  	var width = $("#continer").width();
		$(function(){
			$('#bankList').datagrid({
				title:'合同列表',
				iconCls:'icon-save',
				height:600,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'contract/query',
				remoteSort: false,
				columns:[[
					{field:'MERCHNO',title:'委托机构号',align:'center',width:130},
					{field:'CONTRACTNUM',title:'合同编号',width:130,align:'center'},
					{field:'DEBTORNAME',title:'付款人名称',align:'center',width:100},
					{field:'CREDITORNAME',title:'收款人名称',width:120,align:'center'},
					{field:'CONTRACTTYPE',title:'合同类型',width:100,align:'center',
						formatter:function(value,rec){
							if(value=="CT00"){
								return "批量代收协议";
							}else if(value=="CT01"){
								return "批量代付协议";
							}else if(value=="CT02"){
								return "实时代收协议";
							}else if(value=="CT03"){
								return "实时代付协议";
							}
						}
					},
					{field:'SIGNDATE',title:'签约日期',width:100,align:'center'},
					{field:'EXPIRYDATE',title:'失效日期',width:100,align:'center'},
					{field:'STATUS',title:'状态',width:100,align:'center',
						formatter:function(value,rec){
							if(value=="00"){
								return "有效";
							}else if(value=="10" || value=="20"){
								return "待审";
							}else if(value=="19" || value=="29"){
								return "审核未通过";
							}else if(value=="89"){
								return "过期失效";
							}else if(value=="99"){
								return "已注销";
							}
						}
					},
					{field:'TID',title:'操作',align:'center',width:160,rowspan:2,
						formatter:function(value,rec){
							if(rec.STATUS=="00"){
								return '<a href="javascript:delFindById('+value+')" style="color:blue;margin-left:10px">注销</a>'+
								'<a href="javascript:findById('+value+')" style="color:blue;margin-left:10px">详情</a>'
							}else if(rec.STATUS=="10" || rec.STATUS=='20'){
								return '<a href="javascript:findById('+value+')" style="color:blue;margin-left:10px">详情</a>';
							}
						}}
					]],
				pagination:true,
				rownumbers:true,
				toolbar:[{
					id:'btnadd',
					text:'新增合同',
					iconCls:'icon-add',
					handler:function(){
						showAdd(0);
					}
				},{
					id:'btnadds',
					text:'批量上传',
					iconCls:'icon-add',
					handler:function(){
						showFile();
					}
				}]
			});
		});

		function resize(){
			$('#searchForm :input').val('');
		}
		
		function showAdd(num){
			$('#saveForm :input').val('');
			$('#fileAddress_span').html("");
			checkIsDelegation(1);
			$('#w').window({
				title: '新增合同信息',
				top:100,
				width: 800,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 680
			});
			$('#btn_submit').linkbutton('enable');	
		}
		function showFile(){
			$('#d_saveForm :input').val('');
			$('#org_province').html('');
			$('#w4').window({
				title: '合同批量上传',
				top:150,
				left:300,
				width: 600,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 180
			});
			$('#d_btn_submit').linkbutton('enable');	
		}
		function closeAdd(){
			$('#w').window('close');
			$('#w2').window('close');
			$('#w3').window('close');
			$('#w4').window('close');
			$('#w5').window('close');
			
		}		
		function search(){
			var data={'merchNo':$('#a_merchNo').val(),'contractNum':$('#a_contractNum').val(),
					'debName':$("#a_debName").val(),'credName':$("#a_credName").val(),
					'debBranchCode':$("#a_debBranchCode").val(),'credAccNo':$("#a_credAccNo").val()};
			$('#bankList').datagrid('load',data);
		}
		function saveUser(){
			$('#saveForm').form('submit', {  
			    onSubmit: function(){  
			    	if($('#saveForm').form('validate')){
			    		$('#btn_submit').linkbutton('disable');	
			    		return true;   
				    }
			        return false;   
			    }, 
			    success:function(json){
			    	$('#btn_submit').linkbutton('enable');	
			    	json = eval('(' + json + ')');
					if(json.RET == "succ"){
						 $.messager.alert('提示', '添加成功');
						 search();
						 closeAdd();
					}else{
						 $.messager.alert("提示",json.INFO);
					}
			    }
			});  
		}
		function findById(tId){
			$.ajax({
			   type: "POST",
			   url: "contract/findById",
			   data: "tId="+tId,
			   async: false,
			   dataType:"json",
			   success: function(json){
				   var tId = json.tId;
				   $("#b_tId").html(json.tId);
				   $("#b_merchNo").html(json.merchNo);
				   $("#b_contractNum").html(json.contractNum);
				   $("#b_debName").html(json.debName);
				   $("#b_debAccNo").html(json.debAccNo);
				   showBranchCode('find',json.debBranchCode);
				   $("#b_credName").html(json.credName);
				   $("#b_credAccNo").html(json.credAccNo);
				   var contractType;
				   if(json.contractType == 'CT00'){
					   contractType = '批量代收协议';
				   }else if(json.contractType == 'CT01'){
					   contractType = '批量代付协议';
				   }else if(json.contractType == 'CT02'){
					   contractType = '实时代收付协议';
				   }else if(json.contractType == 'CT03'){
					   contractType = '实时代收付协议';
				   }
				   $("#b_contractType").html(contractType);
				   $("#b_contractType").val(json.contractType);
				   showBranchCode('find_a',json.credBranchCode);
				   $("#b_debAmoLimit").html(json.debAmoLimit);
 				   var debTranLimitType;
				   if(json.debTranLimitType == '00'){
					   debTranLimitType = '--不限--';
				   }else if(json.debTranLimitType == '01'){
					   debTranLimitType = '按年限次';
				   }else if(json.debTranLimitType == '02'){
					   debTranLimitType = '按月限次';
				   }else if(json.debTranLimitType == '03'){
					   debTranLimitType = '总计限次';
				   }
				   $("#b_debTranLimitType").html(debTranLimitType);
				   $("#b_debAccyAmoLimit").html(json.debAccyAmoLimit);
				   var debTransLimitType;
				   if(json.debTransLimitType == '00'){
					   debTransLimitType = '--不限--';
				   }else if(json.debTransLimitType == '01'){
					   debTransLimitType = '按年限次';
				   }else if(json.debTransLimitType == '02'){
					   debTransLimitType = '按月限次';
				   }else if(json.debTransLimitType == '03'){
					   debTransLimitType = '总计限次';
				   }
				   $("#b_debTransLimitType").html(debTransLimitType);
				   $("#b_debTransLimit").html(json.debTransLimit);
				   $("#b_credAmoLimit").html(json.credAmoLimit);
				   var credTranLimitType;
				   if(json.credTranLimitType == '00'){
					   credTranLimitType = '--不限--';
				   }else if(json.credTranLimitType == '01'){
					   credTranLimitType = '按年限次';
				   }else if(json.credTranLimitType == '02'){
					   credTranLimitType = '按月限次';
				   }else if(json.credTranLimitType == '03'){
					   credTranLimitType = '总计限次';
				   }
				   $("#b_credTranLimitType").html(credTranLimitType);
				   $("#b_credAccuAmoLimit").html(json.credAccuAmoLimit);
				   var credTransLimitType;
				   if(json.credTransLimitType == '00'){
					   credTransLimitType = '--不限--';
				   }else if(json.credTransLimitType == '01'){
					   credTransLimitType = '按年限次';
				   }else if(json.credTransLimitType == '02'){
					   credTransLimitType = '按月限次';
				   }else if(json.credTransLimitType == '03'){
					   credTransLimitType = '总计限次';
				   }
				   $("#b_credTransLimitType").html(credTransLimitType);
				   $("#b_credTransLimit").html(json.credTransLimit);
				   $("#b_startDate").html(json.signDate);
				   $("#b_endDate").html(json.expiryDate);
				   $("#b_notes").html(json.notes);
				   $("#b_fileAddress").html(json.fileAddress);
				   $("#b_proprieTary").html(json.proprieTary);
				   $("#b_categoryPurpose").html(json.categoryPurpose);
				   $("#b_chargeNo").html(json.chargeNo);
				   $("#b_chargeConntract").html(json.chargeConntract);
				   $("#b_payContract").html(json.payContract);
				   initCertUrl(tId);
				   checkIsDelegation(2);
			   }
			});
			$('#w2').window({
				title: '合同详情',
				top:100,
				width: 800,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 630
			});
		}
		function delFindById(tId){
			$.ajax({
			   type: "POST",
			   url: "contract/findById",
			   data: "tId="+tId,
			   async: false,
			   dataType:"json",
			   success: function(json){
				   var tId = json.tId;
				   $("#c_tId").html(json.tId);
				   $("#c_merchNo").html(json.merchNo);
				   $("#c_contractNum").html(json.contractNum);
				   $("#c_debName").html(json.debName);
				   $("#c_debAccNo").html(json.debAccNo);
				   showBranchCode('delete',json.debBranchCode);
				   $("#c_credName").html(json.credName);
				   $("#c_credAccNo").html(json.credAccNo);
				   var contractType;
				   if(json.contractType == 'CT00'){
					   contractType = '批量代收协议';
				   }else if(json.contractType == 'CT01'){
					   contractType = '批量代付协议';
				   }else if(json.contractType == 'CT02'){
					   contractType = '实时代收付协议';
				   }else if(json.contractType == 'CT03'){
					   contractType = '实时代收付协议';
				   }
				   $("#c_contractType").html(contractType);
				   $("#c_contractType").val(json.contractType);
				   showBranchCode('delete_a',json.credBranchCode);
				   $("#c_debAmoLimit").html(json.debAmoLimit);
 				   var debTranLimitType;
				   if(json.debTranLimitType == '00'){
					   debTranLimitType = '--不限--';
				   }else if(json.debTranLimitType == '01'){
					   debTranLimitType = '按年限次';
				   }else if(json.debTranLimitType == '02'){
					   debTranLimitType = '按月限次';
				   }else if(json.debTranLimitType == '03'){
					   debTranLimitType = '总计限次';
				   }
				   $("#c_debTranLimitType").html(debTranLimitType);
				   $("#c_debAccyAmoLimit").html(json.debAccyAmoLimit);
				   var debTransLimitType;
				   if(json.debTransLimitType == '00'){
					   debTransLimitType = '--不限--';
				   }else if(json.debTransLimitType == '01'){
					   debTransLimitType = '按年限次';
				   }else if(json.debTransLimitType == '02'){
					   debTransLimitType = '按月限次';
				   }else if(json.debTransLimitType == '03'){
					   debTransLimitType = '总计限次';
				   }
				   $("#c_debTransLimitType").html(debTransLimitType);
				   $("#c_debTransLimit").html(json.debTransLimit);
				   $("#c_credAmoLimit").html(json.credAmoLimit);
				   var credTranLimitType;
				   if(json.credTranLimitType == '00'){
					   credTranLimitType = '--不限--';
				   }else if(json.credTranLimitType == '01'){
					   credTranLimitType = '按年限次';
				   }else if(json.credTranLimitType == '02'){
					   credTranLimitType = '按月限次';
				   }else if(json.credTranLimitType == '03'){
					   credTranLimitType = '总计限次';
				   }
				   $("#c_credTranLimitType").html(credTranLimitType);
				   $("#c_credAccuAmoLimit").html(json.credAccuAmoLimit);
				   var credTransLimitType;
				   if(json.credTransLimitType == '00'){
					   credTransLimitType = '--不限--';
				   }else if(json.credTransLimitType == '01'){
					   credTransLimitType = '按年限次';
				   }else if(json.credTransLimitType == '02'){
					   credTransLimitType = '按月限次';
				   }else if(json.credTransLimitType == '03'){
					   credTransLimitType = '总计限次';
				   }
				   $("#c_credTransLimitType").html(credTransLimitType);
				   $("#c_credTransLimit").html(json.credTransLimit);
				   $("#c_startDate").html(json.signDate);
				   $("#c_endDate").html(json.expiryDate);
				   $("#c_notes").html(json.notes);
				   $("#c_fileAddress").html(json.fileAddress);
				   $("#c_proprieTary").html(json.proprieTary);
				   $("#c_categoryPurpose").html(json.categoryPurpose);
				   $("#c_chargeNo").html(json.chargeNo);
				   $("#c_chargeConntract").html(json.chargeConntract);
				   $("#c_payContract").html(json.payContract);
				   initCertUrl(tId);
				   checkIsDelegation(3);
			   }
			});
			$('#w3').window({
				title: '注销合同',
				top:100,
				width: 800,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 630
			});
		}

		function deleteUser(){
			$('#c_saveForm').form('submit', {  
			    onSubmit: function(){  
			    	if($('#c_saveForm').form('validate')){
			    		$('#c_btn_submit').linkbutton('disable');	
			    		return true;   
				    }
			        return false;   
			    }, 
			    success:function(json){
			    	 $.ajax({
						   type: "POST",
						   url: "contract/delect",
						   data: {'tId':$('#c_tId').val(),'withdrawOpt':$('#c_withdrawOpt').val(),'revocationDate':$('#revocationDate').val()},
						   dataType:"json",
						   success: function(json) {
								if(json.RET=='succ'){
									 $.messager.confirm('提示', '注销成功');
									 search();
									 closeAdd();
								 }else{
									 $.messager.alert("提示",json.INFO);
									 closeAdd();
								 }
								$('#c_btn_submit').linkbutton('enable');		
						   }
						});
			    }
			});  
			}
		$(function(){
			$("input[id*='_cert_img']").each(function(){
				  var tId = $("#b_tId");
				  var _this = $(this);
				  var id = _this.attr('id');
				  var certType = id.substring(0,id.indexOf('_cert_img'));
				  var certSpan = $('#fileAddress_span');
				  $(this).uploadify({
						'auto' : true,
						'swf' : '<%=basePath%>js/uploadify/uploadify.swf', 
						'uploader': '<%=basePath%>contract/fileUpload',
						'formData' : {'tId':tId,'fileAddress':fileAddress},
						'fileObjName': 'headImage',
						 'method'   : 'post',
						//可选  
// 						'height': 20,
						//可选  
						'width': 120,
						//设置允许上传的文件格式  
// 						'fileExt'   : '*.jpg;*.gif;*.png',  
						//设置允许上传的文件格式后，必须加上下面这行代码才能帮你过滤  
						//'fileDesc'    : 'Image Files',  
						//允许连续上传多个文件  
						'multi': 'false',
						//一次性最多允许上传多少个,不设置的话默认为999个  
						'queueSizeLimit': 1,
						//每个文件允许上传的大小(字节)  
						'sizeLimit'   : 1024*1024*10,  //1M=1024K=1024*1024Byte
						'buttonText'     : '选择文件' ,
						'onUploadError' : function(file, errorCode, errorMsg, errorString) {
							$.messager.alert('提示', '上传失败');
				        },
						 'onUploadSuccess' : function(file, data, response) {
					         	var isSucc = false;   
					         	var retInfo;
					         	jsonRet = eval('(' + data + ')');
					         	var URL =jsonRet.path;
						 		$("#fileAddress").val(jsonRet.fileName);
							 	if(!response||data.indexOf("status")==-1){
							 		isSucc = false; 
					            }else{
						            
						            if(jsonRet.status=='OK'){
						            	isSucc = true;  
						            }
					            }
							 	if(isSucc){
							 		retInfo = "上传成功";
							 		certSpan.html('<a href="'+URL+'" target="view_window" style="font-size: 12px;color:blue">点击查看</a>');
							 	}else{retInfo = "上传失败";}
							 	
					            $.messager.alert('提示', retInfo);
					    }, 
				        'onFallback' : function() {
				        	$.messager.alert('提示', '检测到flash控件不可用,请确认当前浏览器支持flash控件');
				        }
					});
			});
		  });
		function initCertUrl(tId){
				var certType = $('#c_signfileOpp_span');
				var certSpan = $('#signfileOpp_span');
				$.ajax({
					type: "POST",
					url: "contract/downloadImgUrl",
					data: "tId=" + tId,
					dataType: "json",
					success: function(json) {
						 if(json.status=='OK'){
							 var URL = json.url;
							 certType.html('<a href="'+URL+'" target="view_window" style="font-size: 12px;color:blue">点击查看</a>');
							 certSpan.html('<a href="'+URL+'" target="view_window" style="font-size: 12px;color:blue">点击查看</a>');
						 }else if(json.status=='notExist'){
							 certType.html('暂无可查看文件');
							 certSpan.html('暂无可查看文件');
						 } else{
							 certType.html('查询失败');
							 certSpan.html('查询失败');
						 }
					}
				}); 
		}
		
		function showBranchCode(type,value){ 
			$.ajax({
			   type: "POST",
			   url: "bankaccout/queryBankInfo",
			   data: "bankNode="+value,
			   async: false,
			   dataType:"json",
			   success: function(json){	
				   var result;
				   if(json == null){
					   result = "开户行未选择！";
				   }else{
					   result = json.bankName;
				   }
				    if(type == 'find') {
		 				$("#b_debBranchCode").html(result);
		 			} else if(type == 'find_a'){
		 				$("#b_credBranchCode").html(result);
		 			} else if(type == 'delete'){
		 				$("#c_debBranchCode").html(result);
		 			} else if(type == 'delete_a'){
		 				$("#c_credBranchCode").html(result);
		 			}
			     }
			});
		}
		function saveFile(){ 
			 var formData = new FormData( $("#d_saveForm")[0] );
			$.ajax({
			   url: "contract/excelImport",
			   type: 'POST',
			   data: formData,
	           dataType:"json",
	           cache: false,
	           contentType: false,  
	           processData: false, 
			   success: function(json){	
				   console.log("json:"+JSON.stringify(json));
				   		if(json.status == "error"){
				   			showError();
				   			var html ="<div>--批量上传错误信息--</div>";
				   		   for (var i = 0; i < json.msg.length; i++) {
							   html += '<div>'+json.msg[i]+'</div>';
				   		   }
				   		 $("#error_message").html(html);
						
					   }else{
						   $.messager.alert('提示', '导入成功！');
					   }
				  
			   }
			  
			});
		}
		function showError(){	
			$('#w5').window({
				title: '批量上传错误信息',
				top:100,
				width: 700,
				collapsible:false,
				minimizable:false,
				maximizable:false,
				modal: true,
				shadow: false,
				closed: false,
				height: 340
			});
		}
		
		function checkIsDelegation(type){
			var isDelegation;
			if(type == 1){
				isDelegation = $('#contractType').val();
			}else if(type == 2){
				isDelegation = $('#b_contractType').val();
			}else if(type == 3){
				isDelegation = $('#c_contractType').val();
			}
			if(isDelegation == "CT00"){
				$('#delegation').show();
				$('#delegation_2').hide();
				$('#b_delegation').show();
				$('#b_delegation_2').hide();
				$('#c_delegation').show();
				$('#c_delegation_2').hide();
			}else if(isDelegation == "CT01"){
				$('#delegation').hide();
				$('#delegation_2').show();
				$('#b_delegation').hide();
				$('#b_delegation_2').show();
				$('#c_delegation').hide();
				$('#c_delegation_2').show();
			}else{
				$('#delegation').hide();
				$('#delegation_2').hide();
				$('#b_delegation').hide();
				$('#b_delegation_2').hide();
				$('#c_delegation').hide();
				$('#c_delegation_2').hide();
			}
		}
		
		function checkBankKey(type){
			var pid;
			if (type == 'add_a') {
				pid = $("#banknode_key").val();
			} else {
				pid = $("#b_banknode_key").val();
			}
			 if(pid=='输入关键字检索开户行'){
				if (type == 'add_a') {
					 $("#banknode_key").val('');
				} else {
					 $("#b_banknode_key").val('');
				}
			}
			$("#banknode_key").css({color:"#515151"});
			$("#b_banknode_key").css({color:"#515151"});
		}
		
		function queryBankNode(type) {
			var pid;
			if (type == 'add_a') {
				pid = $("#banknode_key").val();
			} else {
				pid = $("#b_banknode_key").val();
			}
			if(pid==null||pid==''){
				if (type == 'add_a') {
					$("#banknode_key").val('输入关键字检索开户行');
					$("#banknode_key").css({color:"#BEBEBE"});
				} else {
					$("#b_banknode_key").val('输入关键字检索开户行');
					$("#b_banknode_key").css({color:"#BEBEBE"});
				}
				return;
			} 
			$.ajax({
				type: "POST",
				url: "agency/queryBankNode",
				data: "bankName=" + pid,
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择开户行--</option>";
					$.each(json,function(key, value) {
						html += '<option value="' + value.BANK_NODE + '">' + value.BANK_NAME + '</option>';
					});
					if (type == 'add_a') {
						$("#debBranchCode").html(html);
					} else {
						$("#credBranchCode").html(html);
					}
				}
			});
		}
	</script>
</html>
