<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<body>
	<style type="text/css">
table tr td {
	height: 25px
}

table tr td input {
	height: 25px
}

table tr td select {
	height: 20px
}
</style>
	<div style="margin: 5px; border:" id="continer">
		<div id="p" class="easyui-panel" title=""
			style="height: 100px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="theForm" method="post">
				<input type="hidden" id="memberId" value="${memberId}"/>
				<input type="hidden" id="flag" value="${flag}"/>
				<table width="100%">
					<tr>
						<td></td>
						<td></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="test"></table>
		</div>
		<div style="margin-top: 5px">
			<form id="b_theForm" method="post">
				<table width="100%">
					<tr>
						<td><a href="javascript:merchAudit('0')" class="easyui-linkbutton" iconCls="icon-ok">提交审核</a></td>
<!-- 						<td><a href="javascript:toMerchAudit()" class="easyui-linkbutton" iconCls="icon-back">返回初审列表</a></td> -->
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div id="w2" class="easyui-window" closed="true" title="My Window" iconCls="icon-save" style="width: 500px; height: 400px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="saveForm" action="merchant/addRateConfig" method="post">
					<input type="hidden" id="a_memberId" name="memberId"/>
					<input type="hidden" id="busiCode" name="busiCode"/> 
					<table width="90%" cellpadding="2" cellspacing="2">
						<tr style="height: 25px">
							<td>清算标志</td>
							<td align="left">
								<select id="setlflg" name="setlflg">
										<option value=''>--请选择清算类型--</option>
										<option value='0'>不参加清算</option>
										<option value='1'>参加清算</option>
								</select>
							</td>
						</tr>
						<tr style="height: 25px">
							<td>扣率类型</td>
							<td align="left">
								<select id="rateMethod" name="rateMethod" required="true"
								onchange="findParaDesc('rateMethod')" /></select>
							</td>
							<td>扣率描述</td>
							<td align="left">
								<select id="rateId" name="rateId" required="true"></select>
							</td>
						</tr>
						<tr style="height: 25px">
							<td>备注</td>
							<td align="left" colspan="3">
							<textarea rows="3" cols="81" id="d_notes" maxlength="64" name="notes" style="resize: none;"
									onkeyup="value=value.replace(/<[^<]+>/g,'')"></textarea></td>

						</tr>
					</table>
				</form>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:save(0)" id="btn_submit">提交</a>
				<a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="closeAdd()">取消</a>
			</div>
		</div>
	</div>
	
	<div id="w3" class="easyui-window" closed="true" title="My Window"
		iconCls="icon-save" style="width: 500px; height: 400px; padding: 5px;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc; text-align: center">
				<form id="b_saveForm" action="merchant/updateRateConfig" method="post">
					<input type="hidden" id="b_tId" name="tId"/> 
					<input type="hidden" id="b_memberId" name="memberId"/>
					<input type="hidden" id="b_busiCode" name="busiCode"/> 
					<input type="hidden" id="c_rateId"/> 
					<input type="hidden" id="c_rateMethod"/> 
					<table width="90%" cellpadding="2" cellspacing="2">
						<tr style="height: 25px">
							<td>清算标志</td>
							<td align="left">
								<select id="b_setlflg" name="setlflg" required="true">
										<option value=''>--请选择清算类型--</option>
										<option value='0'>不参加清算</option>
										<option value='1'>参加清算</option>
								</select>
							</td>
						</tr>
						<tr style="height: 25px">
							<td>扣率类型</td>
							<td align="left">
								<select id="b_rateMethod" name="rateMethod" required="true" onchange="findParaDesc('b_rateMethod')"/>
								</select>
							</td>
							<td>扣率描述</td>
							<td align="left">
								<select id="b_rateId" name="rateId" required="true">
								</select>
							</td>
						</tr>
						<tr style="height: 25px">
							<td>备注</td>
							<td align="left" colspan="3">
							<textarea rows="3" cols="81" id="b_notes" maxlength="64" name="notes" style="resize: none;"
									onkeyup="value=value.replace(/<[^<]+>/g,'')"></textarea></td>

						</tr>
					</table>
				</form>	
			</div>
			<div region="south" border="false" style="text-align: center; padding: 5px 0;">
				<a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:update()" id="b_btn_submit">提交</a>
				<a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="closeAdd()">取消</a>
			</div>
		</div>
	</div>

</body>
<script>
	var width = $("#continer").width();
 	var memberId = $("#memberId").val();
	$(function(){
		$('#test').datagrid({
			title:'委托机构业务计费列表',
			iconCls:'icon-save',
			height:600,
			nowrap: false,
			striped: true,
			singleSelect:true,
			url:'merchant/findRateConfig?memberId='+memberId,
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
			pagination:true,
			rownumbers:true
		});
	});
	
	function search(){
		$('#test').datagrid('load',null);
	}
	
	function showAdd(busiCode){
		$("#saveForm").attr("action","merchant/addRateConfig");
		$('#saveForm :input').val('');
		$('#busiCode').val(busiCode);
		$('#a_memberId').val(memberId);
		$('#w2').window({
			title: '新增计费方式',
			top:100,
			width: 600,
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
		$("#b_saveForm").attr("action","merchant/updateRateConfig");
		$.ajax({
		   type: "POST",
		   url: "merchant/findRateById",
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
			top:100,
			width: 600,
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
	
	function closeAdd(){
		$('#w2').window('close');
		$('#w3').window('close');
	}
		
	function findParaDic() {
		$.ajax({
			type: "POST",
			url: "merchant/findParaDic",
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
			url: 'merchant/findParaDesc?paraCode='+paraCode,
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
			    	$('#btn_submit').linkbutton('disable');		
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
	    				closeAdd();
			    	}else{
			    		$.messager.alert('提示',value.INFO);
			    		search();
			    		closeAdd();
			    	}
		    		$('#btn_submit').linkbutton('enable');		
				}) 
		    }   
		});  
	}
	function update(){
		$("#b_saveForm").attr("action","merchant/updateRateConfig");
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
	    				closeAdd();
			    	}else{
			    		$.messager.alert('提示',value.INFO);
			    		search();
			    		closeAdd();
			    	}
		    		$('#b_btn_submit').linkbutton('enable');		
				}) 
		    }   
		});  
	}
	
	function toMerchAudit(){
		window.location.href= "<%=basePath%>" +'merchant/showMerchAuditQuery';
	}
	function merchAudit(result) {
		var stexaOpt = $("#STOPINION").val();
		var flag = $("#flag").val();
		var URL;
		if(flag != 5){
			url ="<%=basePath%>" +'merchant/showMerchAuditQuery';
		}else{
			url = "<%=basePath%>" +'merchant/merchModifyFirstCheck';
		}
		$.ajax({
			type: "POST",
			url: "merchant/audit?isAgree=" + result + "&merchApplyId=" + memberId + "&flag=" + flag,
			data: "stexaOpt=" + encodeURI(stexaOpt),
			dataType: "json",
			success: function(json) {
				$.each(json,
				function(key, value) {
					$.messager.alert('提示',value.INFO);
					if (value.INFO == "操作成功!") {
						window.location.href= url;
					}
				})
	
			}
		});
	}
</script>
</html>
