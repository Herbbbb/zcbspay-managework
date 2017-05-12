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

table tr td {
	height: 25px;
	padding-left: 10px;
	border-width: 1px 1px 1px 1px;
	border-style: groove;
}

table tr td input {
	height: 15px
}

table tr td.head-title {
	background-color: #F0F8FF;
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
		<div id="title" name="title" class="easyui-panel" title="委托机构信息"
			style="background: #fafafa;" iconCls="icon-save"
			data-options="fit:true,border:false" collapsible="false">
			<div style="padding-left: 5px; padding-right: 5px">
				<form id="merchDetaForm"
					action="merchant/saveMerchDeta"
					method="post">
					<input type="hidden" id="isDelegation" value="${merchMap.IS_DELEGATION}" /> 
					<input type="hidden" id="merchId" name="merchDeta.merchId" value="${merchMap.MERCH_ID}" />
					<input type="hidden" id="merchApplyId" value="${merchMap.SELF_ID}" />
					<input type="hidden" id="prdtVer" value="${merchMap.PRDT_VER}" />
					<input type="hidden" id="flag_ins" value="${flag}" />
					<table width="100%">
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td align="center" width="15%">企业名称<font color="red">*</font></td>
							<td width="30%">${merchMap.ENTERPRISE_NAME}</td>
							<td align="center">委托机构编号</td>
							<td>${merchMap.MEMBER_ID}</td>
						</tr>
						<tr>
							<td align="center">企业所在地<font color="red">*</font></td>
							<td colspan="3">${merchMap.PROVINCENAME }
								${merchMap.CITYNAME} ${merchMap.STREETNAME}</td>
						</tr>
						<tr>
							<td align="center">联系手机号<font color="red">*</font></td>
							<td>${merchMap.PHONE}</td>
							<td align="center" width="15%">邮箱<font color="red">*</font></td>
							<td>${merchMap.EMAIL}</td>
						</tr>
						<tr>
							<td align="center">地址</td>
							<td>${merchMap.ADDRESS}</td>
							<td align="center">邮编编码</td>
							<td>${merchMap.POST_CODE}</td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td align="center">营业执照号<font color="red">*</font></td>
							<td>${merchMap.LICENCE_NO}</td>
							<td align="center">组织机构代码号<font color="red">*</font></td>
							<td>${merchMap.ORG_CODE}</td>
						</tr>
						<tr>
							<td align="center">税务登记号<font color="red">*</font></td>
							<td>${merchMap.TAX_NO}</td>
							<td align="center">所属行业<font color="red">*</font></td>
							<td>${merchMap.MCCLIST}</td>
						</tr>
						<tr>
							<td align="center">企业网站地址<font color="red">*</font></td>
							<td>${merchMap.WEBSITE}</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td align="center" id="psamORpass">法人姓名<font color="red">*</font></td>
							<td>${merchMap.CORPORATION}</td>
							<td align="center">法人身份证号<font color="red">*</font></td>
							<td>${merchMap.CORP_NO}</td>
						</tr>

						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td align="center">委托机构清算类型<font color="red">*</font></td>
							<td>${merchMap.SETLTYPENAME}</td>
							<td align="center">委托机构清算周期<font color="red">*</font></td>
							<td>${merchMap.SETLNAME}</td>
						</tr>
						<tr>

							<td align="center">开户行<font color="red">*</font></td>
							<td colspan="3">${merchMap.BANKNAME}</td>
						</tr>
						<tr>
							<td align="center">开户账号<font color="red">*</font></td>
							<td>${merchMap.ACC_NUM}</td>
							<td align="center">开户名<font color="red">*</font></td>
							<td>${merchMap.ACC_NAME}
						</tr>

						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td align="center">合作机构<font color="red">*</font></td>
							<td>${merchMap.INSTI_NAME}</td>
							<td align="center">产品<font color="red">*</font></td>
							<td>${merchMap.PRDTNAME}</td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>

						<tr id="delegation">
							<td align="center">委托人姓名<font color="red">*</font></td>
							<td>${merchMap.SIGNATORY}</td>
							<td align="center">委托人身份证号<font color="red">*</font></td>
							<td>${merchMap.SIGN_CERT_NO}
						</tr>
						<tr>
							<td align="center">客户经理</td>
							<td>${merchMap.CUST_MGR}</td>
							<td align="center">客户经理部门</td>
							<td>${merchMap.CUST_MGR_DEPT}</td>
						</tr>
						<tr>
							<td align="center">合约开始日期</td>
							<td>${merchMap.AGREEMT_START}</td>
							<td align="center">合约终止日期</td>
							<td>${merchMap.AGREEMT_END}</td>
						</tr>
						<tr>
							<td align="center">保证金</td>
							<td>${merchMap.DEPOSIT}<font color="red">元</font>
							</td>
							<td align="center">服务费</td>
							<td>${merchMap.CHARGE}<font color="red">元</font>
							</td>
						</tr>

						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td align="center">联系人姓名</td>
							<td>${merchMap.CONTACT}</td>
							<td align="center">联系人地址</td>
							<td>${merchMap.CONT_ADDRESS}</td>
						</tr>
						<tr>
							<td align="center">联系人电话</td>
							<td>${merchMap.CONT_PHONE}</td>
							<td align="center">联系人职位</td>
							<td>${merchMap.CONT_TITLE}</td>
						</tr>
						<tr>
							<td align="center">联系人邮箱</td>
							<td>${merchMap.CONT_EMAIL}</td>
							<td align="center">备注</td>
							<td>${merchMap.NOTES}</td>
						</tr>
						<tr>
							<td colspan="4" class="head-title"></td>
						</tr>
						<tr>
							<td align="center">企业法人营业执照</td>
							<td><span id="busilice_cert_img"></span></td>
							<td align="center">组织机构代码证</td>
							<td><span id="orgCert_cert_img"></span></td>
						</tr>
						<tr>
							<td align="center">法人身份证正面照</td>
							<td><span id="corpfileFace_cert_img"></span></td>
							<td align="center" id="psamORpass">法人身份证背面照</td>
							<td><span id="corpfileOpp_cert_img"></span></td>
						</tr>
						<tr id="delegation_pic">
							<td align="center">委托人身份证正面照</td>
							<td><span id="signfileFace_cert_img"></span></td>
							<td align="center" id="psamORpass">委托人身份证背面照</td>
							<td><span id="signfileOpp_cert_img"></span></td>
						</tr>
						<tr>
							<td align="center">税务登记证文件目录</td>
							<td><span id="taxRegCert_cert_img"></span></td>
							<td></td>
							<td></td>
						</tr>

						<c:if test="${flag==2}">
							<tr>
								<td align="center">初核意见</td>
								<td colspan="3" align="center"><textarea rows="5"
										cols="100" style="margin: 5px" maxlength="60" id="STOPINION"></textarea>
								</td>
							</tr>
						</c:if>
						<c:if test="${flag==3}">
							<tr>
								<td align="center">初审人</td>
								<td>${merchMap.STEXANAME}</td>
								<td align="center">初审意见</td>
								<td>${merchMap.STEXA_OPT}</td>
							</tr>
							<tr>
								<td align="center">复核意见</td>
								<td colspan="3" align="center"><textarea rows="5"
										cols="100" style="margin: 5px" maxlength="60" id="STOPINION"></textarea>
								</td>
							</tr>
						</c:if>
						<c:if test="${flag==9}">
							<tr>
								<td align="center">初核意见</td>
								<td colspan="3" align="center"><textarea rows="5"
										cols="100" style="margin: 5px" value="${merchMap.STEXA_OPT}"
										maxlength="60" id="STOPINION"></textarea></td>
							</tr>
							<tr>
								<td align="center">复核意见</td>
								<td colspan="3" align="center"><textarea rows="5"
										cols="100" style="margin: 5px" value="${merchMap.CVLEXA_OPT}"
										maxlength="60" id="STOPINION"></textarea></td>
							</tr>
						</c:if>
					</table>
				</form>
			</div>
		</div>
	</div>
	<div region="south" border="false"
		style="text-align: center; padding: 5px 0;">
		<c:if test="${flag==2}">
			<a href="javascript:DetailParaDic('0');" id="button_ins1"
				class="easyui-linkbutton" iconCls="icon-ok">通过</a>
			<a href="javascript:merchAudit('9');" id="button_ins2"
				class="easyui-linkbutton" iconCls="icon-cancel">否决</a>
			<a href="javascript:merchAudit('1');" id="button_ins3"
				class="easyui-linkbutton" iconCls="icon-no">驳回</a>
		</c:if>
		<c:if test="${flag==3}">
			<a href="javascript:showUser('0');" id="button_ins1"
				class="easyui-linkbutton" iconCls="icon-ok">通过</a>
			<a href="javascript:merchAudit('9');" id="button_ins2"
				class="easyui-linkbutton" iconCls="icon-cancel">否决</a>
			<a href="javascript:merchAudit('1');" id="button_ins3"
				class="easyui-linkbutton" iconCls="icon-no">驳回</a>
		</c:if>
		<a href="javascript:history.back(-1);" class="easyui-linkbutton"
			iconCls="icon-back">返回</a>
	</div>
	
	<div id="w" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 200px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="deptForm" action="dept/save" method="post">
					<table width="100%" cellpadding="2" cellspacing="2" style="text-align: left" id="inputForm">
						<tr>
							<td align="center" width="20%">委托机构名称</td>
							<td><input id="b_merName" name="enterpriseName" readonly="true"/></td>
						</tr>
						<tr>
							<td align="center">风控版本</td>
							<td><select name="riskVer" maxlength="8" required="true" id="riskver" /></select> <font color="red">*</font></td>
						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false"
				style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok"
					href="javascript:updateMerch()" id="btn_submit">保存</a> <a
					class="easyui-linkbutton" iconCls="icon-cancel"
					href="javascript:void(0)" onclick="closeAdd()">取消</a>
			</div>
		</div>
	</div>
<script>
  $(function() {
		checkIsDelegation();
		initCertUrl(); 
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
				url: "merchant/downloadImgUrl",
				data: "merchApplyId=" + $('#merchApplyId').val()+"&certTypeCode="+certType,
				dataType: "json",
				success: function(json) {
					 if(json.status=='OK'){
						 var URL = json.url;
						 _this.html('<a href="'+URL+'" target="view_window" style="font-size: 12px;color:blue">点击查看</a>');
					 }else if(json.status=='notExist'){
						 $(this).html('暂无可查看文件');
					 } else{
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
		var merchApplyId = $("#merchApplyId").val();
		var stexaOpt = $("#STOPINION").val();
		var flag = $("#flag_ins").val();
		$.ajax({
			type: "POST",
			url: "merchant/audit?isAgree=" + result + "&merchApplyId=" + merchApplyId + "&flag=" + flag,
			data: "stexaOpt=" + encodeURI(stexaOpt),
			dataType: "json",
			success: function(json) {
				$.each(json,function(key, value) {
					$.messager.alert('提示',value.INFO);
					if (value.INFO == "操作成功!") {
						history.back( - 1);
					}
				})
	
			}
		});
	}
	
	 function DetailParaDic(result) {
		 var memberId = $("#merchApplyId").val();
		 var flag = 2;
		 window.location.href= "<%=basePath%>" +'merchant/showProdCase?memberId='+ memberId +'&flag='+flag;
	  }
	 function closeAdd(){
			$('#w').window('close');
		}
	 function showUser(){
		 var memberId = $("#merchApplyId").val();
		 var pid = $("#prdtVer").val();
			$.ajax({
			   type: "POST",
			   url: "merchant/findEnterById",
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
				top:300,
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
		 function queryRiskType(pid) {
			$.ajax({
				type: "POST",
				url: "merchant/queryRiskType?vid=" + pid,
				data: "rand=" + new Date().getTime(),
				dataType: "json",
				success: function(json) {
					var html = "<option value=''>--请选择风控版本--</option>";
					$.each(json,
					function(key, value) {
						html += '<option value="' + value.RISKVER + '">' + value.RISKNAME + '</option>';
					});
					$("#riskver").html(html);
		
				}
			});
		}
		 
		 function updateMerch(){
			 var memberId = $("#merchApplyId").val();
			 var riskVer = $("#riskver").val();
			$.ajax({
			   type: "POST",
			   url: "merchant/updateMerch",
			   data: {"memberId":memberId,"riskVer":riskVer},
			   async: false,
			   dataType:"json",
			   success: function(data){
// 				   json = eval("(" + data + ")");
					 if(data.status=='OK'){
						 
						 $.messager.alert('提示',"提交成功");
						 closeAdd();
						 merchAudit('0');
					 }else{
						 closeAdd();
						 $.messager.alert('提示',"提交失败");  
					 }
			    }
			});
		}
	</script>
</body>

</html>
