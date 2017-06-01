<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>
<%-- <%@taglib prefix="s" uri="/struts-tags"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<style type="text/css">
table {
	
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

table tr td.head-title {
	height: 25px;
	background-color: #F0F8FF;
	border-width: 1px 1px 1px 1px;
	border-style: groove;
	font-weight: bold;
}

table tr td.head-guide {
	background-color: #F0FFFF;
	font-weight: bold;
}

table tr td font.current-step {
	color: #EE4000;
}
</style>

<script type="text/javascript"
	src="<%=basePath%>/js/extendsValidator_1.0_20151215.js"></script>

<body>
	<div style="margin: 5px;" id="continer">
		<div id="title" name="title" class="easyui-panel" title="机构信息"
			style="background: #fafafa;" iconCls="icon-save"
			data-options="fit:true,border:false" collapsible="false">
			<div style="padding-left: 5px; padding-right: 5px">
				<form id="merchDetaForm" action="agency/saveMerchDeta" method="post">
					<input type="hidden" id="isDelegation" value="${merchMap.IS_DELEGATION}" /> 
					<input type="hidden" id="merchId" name="merchDeta.merchId" value="${merchMap.MERCH_ID}" />
					<input type="hidden" id="merchApplyId" value="${merchMap.SELF_ID}" />
					<input type="hidden" id="prdtVer" value="${merchMap.PRDT_VER}" />
					<input type="hidden" id="a_riskVer" value="${merchMap.RISK_VER}" />
					<input type="hidden" id="num_merchNo" value="${merchMap.MEMBER_ID}" />
					<input type="hidden" id="CACODE" value="${merchMap.CACODE}" />
					<input type="hidden" id="flag_ins" value="${flag}" />
					<table width="100%">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update" align="center" width="15%">机构名称<font color="red">*</font></td>
							<td class="update" width="30%">${merchMap.ENTERPRISE_NAME}</td>
							<td class="update" align="center">机构编号</td>
							<td class="update" >${merchMap.MEMBER_ID}</td>
						</tr>
<!-- 						<tr> -->
<!-- 							<td class="update" align="center">收费单位代码<font color="red">*</font></td> -->
<%-- 							<td class="update" >${merchMap.CHARGINGUNIT}</td> --%>
							
<!-- 							<td class="update" align="center"></td> -->
<!-- 							<td class="update"></td> -->
<!-- 							<td class="update" align="center">机构代码<font color="red">*</font></td> -->
<%-- 							<td class="update" >${merchMap.INSTCODE}</td> --%>
<!-- 						</tr> -->
						<tr>
							<td class="update" align="center">机构所在地<font color="red">*</font></td>
							<td class="update" >${merchMap.PROVINCENAME }
								${merchMap.CITYNAME} ${merchMap.STREETNAME}</td>
							<td class="update" align="center">收费单位配置信息</td>
							<td class="update" style="font-size: 12px;color:blue;cursor:pointer;" onclick="findChargingunit()">点击查看</td>
						</tr>
						<tr>
							<td class="update" align="center">联系手机号<font color="red">*</font></td>
							<td class="update" >${merchMap.PHONE}</td>
							<td class="update" align="center" width="15%">邮箱<font color="red">*</font></td>
							<td class="update" >${merchMap.EMAIL}</td>
						</tr>
						<tr>
							<td class="update" align="center">地址</td>
							<td class="update" >${merchMap.ADDRESS}</td>
							<td class="update" align="center">邮编编码</td>
							<td class="update" >${merchMap.POST_CODE}</td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update" align="center">营业执照号<font color="red">*</font></td>
							<td class="update" >${merchMap.LICENCE_NO}</td>
							<td class="update" align="center">组织机构代码号<font color="red">*</font></td>
							<td class="update" >${merchMap.ORG_CODE}</td>
						</tr>
						<tr>
							<td class="update" align="center">税务登记号<font color="red">*</font></td>
							<td class="update" >${merchMap.TAX_NO}</td>
<!-- 							<td class="update" align="center">所属行业<font color="red">*</font></td> -->
<%-- 							<td class="update" >${merchMap.MCCLIST}</td> --%>
<!-- 						</tr> -->
						
<!-- 						<tr> -->
							<td class="update" align="center">机构网站地址<font color="red">*</font></td>
							<td class="update" >${merchMap.WEBSITE}</td>
<!-- 							<td class="update"></td> -->
<!-- 							<td class="update"></td> -->
						</tr>
						<tr>
							<td class="update" align="center" id="psamORpass">法人姓名<font color="red">*</font></td>
							<td class="update" >${merchMap.CORPORATION}</td>
							<td class="update" align="center">法人身份证号<font color="red">*</font></td>
							<td class="update">${merchMap.CORP_NO}</td>
						</tr>

						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>

							<td class="update" align="center">开户行<font color="red">*</font></td>
							<td class="update" colspan="3">${merchMap.BANKNAME}</td>
						</tr>
						<tr>
							<td class="update" align="center">开户账号<font color="red">*</font></td>
							<td class="update" >${merchMap.ACC_NUM}</td>
							<td class="update" align="center">开户名<font color="red">*</font></td>
							<td class="update" >${merchMap.ACC_NAME}
						</tr>

						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update" align="center">机构清算类型<font color="red">*</font></td>
							<td class="update" >${merchMap.SETLTYPENAME}</td>
							<td class="update" align="center">机构清算周期<font color="red">*</font></td>
							<td class="update" >${merchMap.SETLNAME}</td>
						</tr>
						<tr>
<!-- 							<td class="update" align="center">合作机构<font color="red">*</font></td> -->
<%-- 							<td class="update">${merchMap.INSTI_NAME}</td> --%>
							<td class="update" align="center">产品<font color="red">*</font></td>
							<td class="update">${merchMap.PRDTNAME}</td>
							<td class="update" align="center">代理商<font color="red">*</font></td>
							<td class="update"><span id="b_caCode"></span></td>
						</tr>
						<tr>
							<td class="update" align="center">计费方式</td>
							<td class="update" style="font-size: 12px;color:blue;cursor:pointer;" onclick="findFeeVer()">点击查看</td>
							<td class="update" align="center">风控版本</td>
							<td align="left" class="update"><span id="b_riskVer"></span></td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>

						<tr id="delegation">
							<td class="update" align="center">委托人姓名<font color="red">*</font></td>
							<td class="update" >${merchMap.SIGNATORY}</td>
							<td class="update" align="center">委托人身份证号<font color="red">*</font></td>
							<td class="update" >${merchMap.SIGN_CERT_NO}</td>
						</tr>
						<tr>
							<td class="update" align="center">客户经理</td>
							<td class="update" >${merchMap.CUST_MGR}</td>
							<td class="update" align="center">客户经理部门</td>
							<td class="update" >${merchMap.CUST_MGR_DEPT}</td>
						</tr>
						<tr>
							<td class="update" align="center">合约开始日期</td>
							<td class="update" >${merchMap.AGREEMT_START}</td>
							<td class="update" align="center">合约终止日期</td>
							<td class="update" >${merchMap.AGREEMT_END}</td>
						</tr>
						<tr>
							<td class="update" align="center">保证金</td>
							<td class="update" >${merchMap.DEPOSIT}<font color="red">元</font>
							</td>
							<td class="update" align="center">服务费</td>
							<td class="update" >${merchMap.CHARGE}<font color="red">元</font>
							</td>
						</tr>

						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update" align="center">联系人姓名</td>
							<td class="update" >${merchMap.CONTACT}</td>
							<td class="update" align="center">联系人地址</td>
							<td class="update" >${merchMap.CONT_ADDRESS}</td>
						</tr>
						<tr>
							<td class="update" align="center">联系人电话</td>
							<td class="update" >${merchMap.CONT_PHONE}</td>
							<td class="update" align="center">联系人职位</td>
							<td class="update" >${merchMap.CONT_TITLE}</td>
						</tr>
						<tr>
							<td class="update" align="center">联系人邮箱</td>
							<td class="update" >${merchMap.CONT_EMAIL}</td>
							<td class="update" align="center">备注</td>
							<td class="update" >${merchMap.NOTES}</td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td class="update" align="center">机构法人营业执照</td>
							<td class="update" ><span id="busilice_cert_img"></span></td>
							<td class="update" align="center">组织机构代码证</td>
							<td class="update" ><span id="orgCert_cert_img"></span></td>
						</tr>
						<tr>
							<td class="update" align="center">法人身份证正面照</td>
							<td class="update" ><span id="corpfileFace_cert_img"></span></td>
							<td class="update" align="center" id="psamORpass">法人身份证背面照</td>
							<td class="update" ><span id="corpfileOpp_cert_img"></span></td>
						</tr>
						<tr id="delegation_pic">
							<td class="update" align="center">人身份证正面照</td>
							<td class="update" ><span id="signfileFace_cert_img"></span></td>
							<td class="update" align="center" id="psamORpass">人身份证背面照</td>
							<td class="update" ><span id="signfileOpp_cert_img"></span></td>
						</tr>
						<tr>
							<td class="update" align="center">税务登记证文件目录</td>
							<td class="update" ><span id="taxRegCert_cert_img"></span></td>
							<td class="update"></td>
							<td class="update"></td>
						</tr>

						<c:if test="${flag==2}">
							<tr>
								<td class="update" align="center">初核意见</td>
								<td class="update" colspan="3" align="center"><textarea rows="5"
										cols="100" style="margin: 5px" maxlength="60" id="STOPINION"></textarea>
								</td>
							</tr>
						</c:if>
						<c:if test="${flag==3}">
							<tr>
								<td class="update" align="center">初审人</td>
								<td class="update" >${merchMap.STEXANAME}</td>
								<td class="update" align="center">初审意见</td>
								<td class="update" >${merchMap.STEXA_OPT}</td>
							</tr>
							<tr>
								<td class="update" align="center">复核意见</td>
								<td class="update" colspan="3" align="center"><textarea rows="5"
										cols="100" style="margin: 5px" maxlength="60" id="STOPINION"></textarea>
								</td>
								<td class="update" align="center"></td>
								<td class="update"></td>
							</tr>
						</c:if>
						<c:if test="${flag==9}">
							<tr>
								<td class="update" align="center">初核意见</td>
								<td class="update" colspan="3" align="center"><textarea rows="5"
										cols="100" style="margin: 5px" value="${merchMap.STEXA_OPT}"
										maxlength="60" id="STOPINION"></textarea></td>
							</tr>
							<tr>
								<td class="update" align="center">复核意见</td>
								<td class="update" colspan="3" align="center"><textarea rows="5"
										cols="100" style="margin: 5px" value="${merchMap.CVLEXA_OPT}"
										maxlength="60" id="STOPINION"></textarea></td>
								<td class="update" align="center"></td>
								<td class="update"></td>
							</tr>
						</c:if>
					</table>
				</form>
			</div>
		</div>
	</div>
	<div region="south" border="false" style="text-align: center; padding: 5px 0;">
		<c:if test="${flag==2}">
			<a href="javascript:DetailParaDic('0');" id="button_ins1"
				class="easyui-linkbutton" iconCls="icon-ok">下一步</a>
			<a href="javascript:merchAudit('9');" id="button_ins2"
				class="easyui-linkbutton" iconCls="icon-cancel">否决</a>
			<a href="javascript:merchAudit('1');" id="button_ins3"
				class="easyui-linkbutton" iconCls="icon-no">驳回</a>
		</c:if>
		<c:if test="${flag==3}">
			<a href="javascript:showUser('3');" id="button_ins4"
				class="easyui-linkbutton" iconCls="icon-ok">下一步</a>
			<a href="javascript:merchAudit('9');" id="button_ins5"
				class="easyui-linkbutton" iconCls="icon-cancel">否决</a>
			<a href="javascript:merchAudit('1');" id="button_ins6"
				class="easyui-linkbutton" iconCls="icon-no">驳回</a>
		</c:if>
		<a href="javascript:history.back(-1);" class="easyui-linkbutton"
			iconCls="icon-back">返回</a>
	</div>
	
	<div id="w" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px; top: 50%; left: 50%;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="deptForm" action="" method="post">
					<table cellpadding="2" cellspacing="2" style="text-align: left" id="inputForm">
						<tr>
							<td class="add" align="center" width="30%">委托机构名称</td>
							<td class="add" width="30%"><input id="b_merName" name="enterpriseName" readonly="true"/></td>
						</tr>
						<tr>
							<td class="add" align="center">风控版本</td>
							<td class="add"><select name="riskVer" maxlength="8" required="true" id="riskver" /></select> <font color="red">*</font></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:updateMerch()" id="btn_submit">保存</a> 
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeAdd()">返回</a>
			</div>
		</div>
	</div>
	<div id="w4" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px; top: 50%; left: 50%; ">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center;overflow:hidden;">
				<table id="test"></table>
			</div>
			<div region="south" border="false"
				style="text-align: center; padding: 15px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok"
					href="javascript:merchAudit('0')" id="btn_submit7">保存</a> 
				<a class="easyui-linkbutton" iconCls="icon-back"
					href="javascript:void(0)" onclick="closeAdd()">返回</a>
			</div>
		</div>
	</div>
	<div id="w5" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px; top: 50%; left: 50%; ">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center;overflow:hidden;">
				<table id="test2"></table>
			</div>
			<div region="south" border="false"
				style="text-align: center; padding: 15px 0;">
				<a class="easyui-linkbutton" iconCls="icon-back"
					href="javascript:void(0)" onclick="closeAdd2()">返回</a>
			</div>
		</div>
	</div>
	<div id="w6" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px; top: 50%; left: 50%; ">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center;overflow:hidden;">
				<input type="hidden" id="b_merchNo" name="merchNo"/>
				<table width="100%" cellpadding="2" cellspacing="2">
					<tr>
						<td colspan="4" class="head-title">实时代收</td>
						<input type="hidden" id="a_bustCode" name="a_bustCode"/>
					</tr>
					<tr style="height: 25px">
						<td class="update" width="18%">付款单位代码</td>
						<td align="left" class="update" width="28%"><span id="a_chargingunit"></span></td>
						<td width="18%" class="update">业务种类</td>
						<td align="left" class="update" width="28%"><span id="a_busiSort"></span></td>
					</tr>
					<tr>
						<td colspan="4" class="head-title">实时代付</td>
						<input type="hidden" id="b_bustCode" name="b_bustCode"/>
					</tr>
					<tr style="height: 25px">
						<td width="18%" class="update">付款单位代码</td>
						<td align="left" class="update"><span id="b_chargingunit"></span></td>
						<td width="18%" class="update">业务种类</td>
						<td align="left" class="update"><span id="b_busiSort"></span></td>
					</tr>
					<tr>
						<td colspan="4" class="head-title">批量代收</td>
						<input type="hidden" id="c_bustCode" name="c_bustCode"/>
					</tr>
					<tr style="height: 25px">
						<td width="18%" class="update">付款单位代码</td>
						<td align="left" class="update"><span id="c_chargingunit"></span></td>
						<td width="18%" class="update">业务种类</td>
						<td align="left" class="update"><span id="c_busiSort"></span></td>
					</tr>
					<tr>
						<td colspan="4" class="head-title">批量代付</td>
						<input type="hidden" id="d_bustCode" name="d_bustCode"/>
					</tr>
					<tr style="height: 25px">
						<td width="18%" class="update">付款单位代码</td>
						<td align="left" class="update"><span id="d_chargingunit"></span></td>
						<td width="18%" class="update">业务种类</td>
						<td align="left" class="update"><span id="d_busiSort"></span></td>
					</tr>
				</table>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 15px 0;">
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeAdd2()">返回</a>
			</div>
		</div>
	</div>
	<div id="w2" class="easyui-window" closed="true" title="My Window" iconCls="icon-save" 
		style="width: 500px; height: 400px; padding: 5px; top: 50%; left: 50%;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="saveForm" action="agency/addRateConfig" method="post">
					<input type="hidden" id="a_memberId" name="memberId"/>
					<input type="hidden" id="busiCode" name="busiCode"/> 
					<table width="90%" cellpadding="2" cellspacing="2">
						<tr style="height: 25px">
							<td class="add" width="18%">清算标志</td>
							<td class="add" align="left">
								<select id="setlflg" name="setlflg">
										<option value=''>--请选择清算类型--</option>
										<option value='0'>不参加清算</option>
										<option value='1'>参加清算</option>
								</select>
							</td>
						</tr>
						<tr style="height: 25px">
							<td class="add" width="18%">扣率类型</td>
							<td class="add" align="left">
								<select id="rateMethod" name="rateMethod" required="true"
								onchange="findParaDesc('rateMethod')" /></select>
							</td>
							<td class="add" width="18%">扣率描述</td>
							<td class="add" align="left">
								<select id="rateId" name="rateId" required="true"><option value=''>--请选择扣率描述--</option></select>
							</td>
						</tr>
						<tr style="height: 25px">
							<td class="add">备注</td>
							<td class="add" align="left" colspan="3">
							<textarea rows="3" cols="81" id="d_notes" maxlength="64" name="notes" style="resize: none;"
									onkeyup="value=value.replace(/<[^<]+>/g,'')"></textarea></td>

						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:save(0)" id="btn_submit2">提交</a>
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeAdd2()">返回</a>
			</div>
		</div>
	</div>
	
	<div id="w3" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 400px; padding: 5px; top: 50%; left: 50%;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="b_saveForm" action="agency/updateRateConfig" method="post">
					<input type="hidden" id="b_tId" name="tId"/> 
					<input type="hidden" id="b_memberId" name="memberId"/>
					<input type="hidden" id="b_busiCode" name="busiCode"/> 
					<input type="hidden" id="c_rateId"/> 
					<input type="hidden" id="c_rateMethod"/> 
					<table width="90%" cellpadding="2" cellspacing="2">
						<tr style="height: 25px">
							<td class="add" width="18%">清算标志</td>
							<td class="add" align="left">
								<select id="b_setlflg" name="setlflg" required="true">
										<option value=''>--请选择清算类型--</option>
										<option value='0'>不参加清算</option>
										<option value='1'>参加清算</option>
								</select>
							</td>
						</tr>
						<tr style="height: 25px">
							<td >扣率类型</td>
							<td class="add" align="left">
								<select id="b_rateMethod" name="rateMethod" required="true" onchange="findParaDesc('b_rateMethod')"/>
								</select>
							</td>
							<td class="add" width="18%">扣率描述</td>
							<td class="add" align="left">
								<select id="b_rateId" name="rateId" required="true">
								<option value=''>--请选择扣率描述--</option>
								</select>
							</td>
						</tr>
						<tr style="height: 25px">
							<td >备注</td>
							<td class="add" align="left" colspan="3">
							<textarea rows="3" cols="81" id="b_notes" maxlength="64" name="notes" style="resize: none;"
									onkeyup="value=value.replace(/<[^<]+>/g,'')"></textarea></td>

						</tr>
					</table>
				</form>	
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:update()" id="b_btn_submit">提交</a>
				<a class="easyui-linkbutton" iconCls="icon-back" href="javascript:void(0)" onclick="closeAdd2()">返回</a>
			</div>
		</div>
	</div>
<script>
	var memberId = $("#merchApplyId").val();
	var flag = $("#flag_ins").val();
	 var pid = $("#prdtVer").val();
  $(function() {
		checkIsDelegation();
		initCertUrl(); 
		queryRiskType(pid)
		showCaCode();
	});
	
	function checkIsDelegation(){
		var isDelegation = $('#isDelegation').val();
		if(isDelegation=='1'){
			$('#delegation').show();
			$('#delegation_pic').show();
		}else{
			$('#delegation').hide();
			$('#delegation_pic').hide();
		}
	}
	
	function initCertUrl(){
		$("span[id*='_cert_img']").each(function(){
			var _this = $(this);
			var id = _this.attr('id');
			var certType = id.substring(0,id.indexOf('_cert_img'));
			$.ajax({
				type: "POST",
				url: "agency/downloadImgUrl",
				data: "merchApplyId=" + $('#merchApplyId').val()+"&certTypeCode="+certType,
				dataType: "json",
				success: function(json) {
					 if(json.status=='OK'){
						 var URL = json.url;
						 _this.html('<a href="'+URL+'" target="view_window" style="font-size: 12px;color:blue">点击查看</a>');
					 }else if(json.status=='notExist'){
						 $(this).html('暂无可查看文件');
					 } else if(json.status == 'fail'){
						 _this.html('查询失败');
					 }
				}
			}); 
		});
	}
	
	function merchAudit(result) {
		$("#button_ins1").linkbutton('disable');
		$("#button_ins2").linkbutton('disable');
		$("#button_ins3").linkbutton('disable');
		$("#btn_submit7").linkbutton('disable');
		var merchApplyId = $("#merchApplyId").val();
		var stexaOpt = $("#STOPINION").val();
		$.ajax({
			type: "POST",
			url: "agency/audit?isAgree=" + result + "&merchApplyId=" + merchApplyId + "&flag=" + flag,
			data: "stexaOpt=" + encodeURI(stexaOpt),
			dataType: "json",
			success: function(json) {
				$.each(json,function(key, value) {
					
					if (value.INFO == "操作成功!") {
						alert("提示：操作成功!");
						history.back( - 1);
					}else{
						alert("提示:操作失败!");
					}
				})
	
			}
		});
	}
	function closeAdd(){
		$('#w').window('close');
		$('#w2').window('close');
		$('#w3').window('close');
		$('#w4').window('close');
	}
	function closeAdd2(){
		$('#w').window('close');
		$('#w2').window('close');
		$('#w3').window('close');
		$('#w5').window('close');
		$('#w6').window('close');
	}
	function search(){
		$('#test').datagrid('load',null);
	}
 function showUser(){
	
		$.ajax({
		   type: "POST",
		   url: "agency/findEnterById",
		   data: "memberId="+memberId,
		   async: false,
		   dataType:"json",
		   success: function(json){	
				$("#b_merName").val(json.enterpriseName);
				$("#b_merchId").val(json.enterpriseMemberId);
				queryRiskType(pid);
		   }
		});
		
		$('#w').window({
			title: '添加风控信息',
			top:200,
			left: 350,
			width: 400,
			modal: true,
			minimizable:false,
			collapsible:false,
			maximizable:false,
			shadow: false,
			closed: false,
			height: 180
		});
	}
	 function DetailParaDic(result){
		 $('#test').datagrid({
				iconCls:'icon-save',
				height:400,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'agency/findRateConfig?memberId='+memberId,
				remoteSort: false,
				columns:[[
					{field:'BUSINAME',title:'业务类型',align:'center',width:130},
					{field:'SETLFLG',title:'计费类型',width:130,align:'center'},
					{field:'RATE_METHOD',title:'扣率版本',align:'center',width:100},
					{field:'RATE_DESC',title:'扣率描述',width:120,align:'center'},
					{field:'TID',title:'操作',align:'center',width:120,
						formatter:function(value,rec){
							if(rec.SETLFLG == null){
								return '<a href="javascript:showAdd('+rec.BUSICODE+')" style="color:blue;margin-left:10px">设置</a>'
							}else{
								return '<a href="javascript:showUpdate('+rec.BUSICODE+')" style="color:blue;margin-left:10px">变更</a>'
							}
						}
					}
				]],
			});
			
			$('#w4').window({
				title: '添加计费方式',
				top:300,
				left:300,
				width: 680,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 280
			});
		}
	 function findFeeVer(result){
		 $('#test2').datagrid({
				iconCls:'icon-save',
				height:400,
				nowrap: false,
				striped: true,
				singleSelect:true,
				url:'agency/findRateConfig?memberId='+memberId,
				remoteSort: false,
				columns:[[
					{field:'BUSINAME',title:'业务类型',align:'center',width:130},
					{field:'SETLFLG',title:'计费类型',width:130,align:'center'},
					{field:'RATE_METHOD',title:'扣率版本',align:'center',width:100},
					{field:'RATE_DESC',title:'扣率描述',width:120,align:'center'}
				]],
			});
			
			$('#w5').window({
				title: '查看计费方式',
				top:150,
				left:300,
				width: 580,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 280
			});
		}
	 function findChargingunit(result){
		 var num = $("#num_merchNo").val();
		$('#b_saveForm :input').val('');
		$('#a_bustCode').val(11000001);
		$('#b_bustCode').val(11000002);
		$('#c_bustCode').val(11000003);
		$('#d_bustCode').val(11000004);
		$('#b_merchNo').val(num);
		
		$.ajax({
		   type: "POST",
		   url: "agency/queryByMerchNo",
		   data: "merchNo="+num,
		   async: false,
		   dataType:"json",
		   success: function(json){
			   $.each(json, function(key,value){
				   if(value.bustCode == "11000001"){
					   $('#a_chargingunit').html(value.chargingunit);
					   $('#a_busiSort').html(value.busiSort);
				   }else if(value.bustCode == "11000002"){
					   $('#b_chargingunit').html(value.chargingunit);
					   $('#b_busiSort').html(value.busiSort);
				   }else if(value.bustCode == "11000003"){
					   $('#c_chargingunit').html(value.chargingunit);
					   $('#c_busiSort').html(value.busiSort);
				   }else if(value.bustCode == "11000004"){
					   $('#d_chargingunit').html(value.chargingunit);
					   $('#d_busiSort').html(value.busiSort);
				   }
			   });
		   }
		});
		$('#w6').window({
			title: '业务收费信息',
			top:100,
			left:300,
			width:700,
			modal: true,
			minimizable:false,
			collapsible:false,
			maximizable:false,
			shadow: false,
			closed: false,
			height: 330
		});
		$('#b_btn_submit2').linkbutton('enable');	
	}
	 function queryRiskType(pid) {
		$.ajax({
			type: "POST",
			url: "agency/queryRiskType?vid=" + pid,
			data: "rand=" + new Date().getTime(),
			dataType: "json",
			success: function(json) {
				var html = "<option value=''>--请选择风控版本--</option>";
				var riskVal = $("#a_riskVer").val();
				var risk = "未选择风控版本";
				$.each(json,
				function(key, value) {
					if(value.RISKVER==riskVal){
						risk = value.RISKNAME;
					}
					html += '<option value="' + value.RISKVER + '">' + value.RISKNAME + '</option>';
				});
				$("#riskver").html(html);
				$("#b_riskVer").html(risk);
			}
		});
	}
		 
	 function updateMerch(){
		 var riskVer = $("#riskver").val();
		$.ajax({
		   type: "POST",
		   url: "agency/updateMerch",
		   data: {"memberId":memberId,"riskVer":riskVer},
		   async: false,
		   dataType:"json",
		   success: function(data){
				 if(data.status=='OK'){
					 closeAdd();
					 merchAudit('0');
				 }else{
					 $.messager.alert('提示',"提交失败");  
				 }
		    }
		});
	}

	function showAdd(busiCode){
		$("#saveForm").attr("action","agency/addRateConfig");
		$('#saveForm :input').val('');
		$('#busiCode').val(busiCode);
		$('#a_memberId').val(memberId);
		$('#w2').window({
			title: '新增计费方式',
			top:500,
			left:300,
			width: 700,
			modal: true,
			minimizable:false,
			collapsible:false,
			maximizable:false,
			shadow: false,
			closed: false,
			height: 230
		});
		findParaDic()
		$('#btn_submit').linkbutton('enable');	
	}
	function showUpdate(busiCode){
		$("#b_saveForm").attr("action","agency/updateRateConfig");
		$.ajax({
		   type: "POST",
		   url: "agency/findRateById",
		   data: {"memberId":memberId,"busiCode":busiCode},
		   dataType:"json",
		   success: function(json){
				$("#b_tId").val(json.tId);
				$("#b_memberId").val(json.memberId);
				$("#b_busiCode").val(json.busiCode);
				$("#c_rateMethod").val(json.rateMethod);
				$("#c_rateId").val(json.rateId);
				$("#b_setlflg").val(json.setlflg);
				$("#b_notes").val(json.notes);
				$("#b_remarks").val(json.remarks);
				findParaDic();
				findParaDesc('c_rateMethod');
			  }
		});
		$('#w3').window({
			title: '变更计费方式',
			top:500,
			left:300,
			width: 700,
			modal: true,
			minimizable:false,
			collapsible:false,
			maximizable:false,
			shadow: false,
			closed: false,
			height: 230
		});
		
		$('#b_btn_submit').linkbutton('enable');	
	}
	function findParaDic() {
		$.ajax({
			type: "POST",
			url: "agency/findParaDic",
			dataType: "json",
			success: function(json) {
				var rateMethod = $("#c_rateMethod").val();
				var html = "<option value='0'>--请选择扣率类型--</option>";
				$.each(json,
				function(key, value) {
					if(value.PARA_CODE==rateMethod){
						html += '<option value="' + value.PARA_CODE + '" selected="selected">' + value.PARA_NAME + '</option>';
					}else {
						html += '<option value="' + value.PARA_CODE + '">' + value.PARA_NAME + '</option>';
					}
				}) ;
				$("#rateMethod").html(html);
				$("#b_rateMethod").html(html);
			}
		});
	}
	
	function findParaDesc(type) {
		var paraCode;
		if (type == 'rateMethod') {
			paraCode = $("#rateMethod").val();
		} else if(type == 'b_rateMethod'){
			paraCode = $("#b_rateMethod").val();
		}else{
			paraCode = $("#c_rateMethod").val();
		}
		$.ajax({
			type: "POST",
			url: 'agency/findParaDesc?paraCode='+paraCode,
			dataType: "json",
			success: function(json) {
				var rateId = $("#c_rateId").val();
				var html = "<option value='0'>--请选择扣率描述--</option>";
				$.each(json,
				function(key, value) {
					if(value.RATE_ID==rateId){
						html += '<option value="' + value.RATE_ID + '" selected="selected">' + value.RATE_DESC + '</option>';
					}else {
						html += '<option value="' + value.RATE_ID + '">' + value.RATE_DESC + '</option>';
					}
				}) ;
				$("#rateId").html(html);
				$("#b_rateId").html(html);
			}
		});
	}
	function save(){
		$('#saveForm').form('submit', {  
		    onSubmit: function(){  
			    if($('#saveForm').form('validate')){
			    	$('#btn_submit2').linkbutton('disable');		
					return true;
				}
		        return false;   
		    },   
		    success:function(data){  
		    	var json = eval('(' + data + ')');
		    	$.each(json, function(key,value){
		    		if(value.ERR != 'succ'){
	    				$.messager.alert('提示',"操作失败!");
	    				search();
			    	}else{
			    		$.messager.alert('提示',value.INFO);
			    		search();
			    		closeAdd2();
			    	}
		    		$('#btn_submit2').linkbutton('enable');		
				}) 
		    }   
		});  
	}
	function update(){
		$("#b_saveForm").attr("action","agency/updateRateConfig");
		$('#b_saveForm').form('submit', {  
		    onSubmit: function(){  
			    if($('#b_saveForm').form('validate')){
			    	$('#b_btn_submit').linkbutton('disable');		
					return true;
				}
		        return false;   
		    },   
		    success:function(data){  
		    	var json = eval('(' + data + ')');
		    	$.each(json, function(key,value){
		    		if(value.ERR != 'succ'){
	    				$.messager.alert('提示',"操作失败!");
	    				search();
			    	}else{
			    		$.messager.alert('提示',value.INFO);
			    		search();
			    		closeAdd2();
			    	}
		    		$('#b_btn_submit').linkbutton('enable');		
				}) 
		    }   
		});  
	}
	function showCaCode() {
		$.ajax({
			type: "POST",
			url: "coopAgency/query",
			data: {"page":1,"rows":10},
			dataType: "json",
			success: function(json) {
				var code = $("#CACODE").val();
				var html;
				$.each(json.rows,function(key, value) {
					if(value.CACODE==code){
						html = '<option value="" selected="selected">' + value.CANAME + '</option>';
// 					}else{
// 						html += '<option value="">' + value.CANAME + '</option>';
					}
				});
				$("#b_caCode").html(html);
	
			}
		});
	}
	function toMerchAudit(){
		window.location.href= "<%=basePath%>" +'agency/showMerchAuditQuery';
	}
// 			function merchAudit(result) {
				
// 				var stexaOpt = $("#STOPINION").val();
// 				var flag = $("#flag").val();
// 				var URL;
// 				if(flag != 5){
<%-- 					url ="<%=basePath%>" +'agency/showMerchAuditQuery'; --%>
// 				}else{
<%-- 					url = "<%=basePath%>" +'agency/merchModifyFirstCheck'; --%>
// 				}
// 				$.ajax({
// 					type: "POST",
// 					url: "agency/audit?isAgree=" + result + "&merchApplyId=" + memberId + "&flag="+flag,
// 					data: "stexaOpt=" + encodeURI(stexaOpt),
// 					dataType: "json",
// 					success: function(json) {
// 						$.each(json,
// 						function(key, value) {
// 							$.messager.alert('提示',value.INFO);
// 							if (value.INFO == "操作成功!") {
// 									window.location.href= url;
// 							}
// 						})
			
// 					}
// 				});
// 			}
	</script>
</body>

</html>
