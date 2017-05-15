<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>
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
				<input type="hidden" id="flag_ins" value="${flag}" />
				<table width="100%">
					<tr>
						<td align="right" width="10%">委托机构编号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							id="merchId_ins" maxlength="15" /></td>
						<td align="right" width="10%">委托机构名称</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							id="memberName_ins" maxlength="50" /></td>
						</td>
						<td align="right">
						<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">查询</a> 
						<a href="javascript:resize()" class="easyui-linkbutton" iconCls="icon-redo">清空</a></td>
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
		$(function(){
			flag=$('#flag_ins').val();
			
			if(flag=='4'){			
				$('#test').datagrid({
					title:'委托机构信息列表',
					iconCls:'icon-save',
					height:540,	
					singleSelect:true,
					nowrap: false,
					striped: true,
					url:'merchant/queryMerchModify?flag='+flag,
					remoteSort: false,
					columns:[
					[
						{field:'MEMBER_ID',title:' 委托机构编号',align:'center',width:120},
						{field:'ENTERPRISE_NAME',title:'委托机构名称',width:120,align:'center'},
						{field:'LICENCE_NO',title:'营业执照号',width:120,align:'center'},
						{field:'CORPORATION',title:'法人名称',width:120,align:'center'}, 
						{field:'CONTACT',title:'联系人',width:120,align:'center'},
						{field:'STATUS',title:'状态',width:100,align:'center',
							formatter:function(value,rec){
								if(value=="00"){
									return "在用";
								}else if(value=="29"){
									return "注册审核终止";
								}else if(value=="49"){
									return "修改审核终止";
								}else if(value=="19"){
									return "委托机构注册终止";
								}else if(value=="69"){
									return "注销审核终止";
								}else if(value=="99"){
									return "委托机构归档";
								}else if(value=="41"){
									return "变更复审未过";
								}else if(value=="40"){
									return "变更待复审";
								}else if(value=="31"){
									return "变更初审未过"; 
								}else if(value=="61"){
									return "注销复审未过";
								}else if(value=="21"){
									return "注册复审未过";
								}else if(value=="20"){
									return "注册待复审";
								}else if(value=="30"){
									return "变更待初审";
								}else if(value=="51"){
									return "注销初审未过";
								}else if(value=="50"){
									return "注销待初审";
								}else if(value=="11"){
									return "注册初审未过";
								}else if(value=="10"){
									return "注册待初审";
								}else if(value=="60"){
									return "注销待复审";
								}else if(value=="32"){
									return "变更待完善信息"; 
								}
						}
							},	
						{field:'DEPT_ID',title:'操作',width:150,align:'center',
						formatter:function(value,rec){	
							if(rec.STATUS=='32'){
								return '<a href="javascript:toUpload('+rec.SELF_ID+')" style="color:blue;margin-left:10px">上传证件照片</a>';
							}else{
								return '<a href="javascript:toMerchModifyEdit('+rec.SELF_ID+')" style="color:blue;margin-left:10px">变更</a>&nbsp<a href="javascript:toMerchModifyDetail('+rec.SELF_ID+')" style="color:blue;margin-left:10px">详情</a>';	
							}
													
						}
					}
					]],
						pagination:true,
						rownumbers:true
				});
			}else{
				$('#test').datagrid({
					title:'委托机构变更审核信息列表',
					iconCls:'icon-save',
					height:540,	
					singleSelect:true,
					nowrap: false,
					striped: true,
					url:'merchant/queryMerchModify?flag='+flag,
					remoteSort: false,
					columns:[
					[
						{field:'MEMBER_ID',title:' 委托机构编号',align:'center',width:120},
						{field:'ENTERPRISE_NAME',title:'委托机构名称',width:120,align:'center'},
						{field:'LICENCE_NO',title:'营业执照号',width:120,align:'center'},
						{field:'CORPORATION',title:'法人名称',width:120,align:'center'}, 
						{field:'CONTACT',title:'联系人',width:120,align:'center'},
						{field:'STATUS',title:'状态',width:100,align:'center',
							formatter:function(value,rec){
								if(value=="00"){
									return "在用";
								}else if(value=="29"){
									return "注册审核终止";
								}else if(value=="49"){
									return "修改审核终止";
								}else if(value=="19"){
									return "委托机构注册终止";
								}else if(value=="69"){
									return "注销审核终止";
								}else if(value=="99"){
									return "委托机构归档";
								}else if(value=="41"){
									return "变更复审未过";
								}else if(value=="40"){
									return "变更待复审";
								}else if(value=="31"){
									return "变更初审未过"; 
								}else if(value=="61"){
									return "注销复审未过";
								}else if(value=="21"){
									return "注册复审未过";
								}else if(value=="20"){
									return "注册待复审";
								}else if(value=="30"){
									return "变更待初审";
								}else if(value=="51"){
									return "注销初审未过";
								}else if(value=="50"){
									return "注销待初审";
								}else if(value=="11"){
									return "注册初审未过";
								}else if(value=="10"){
									return "注册待初审";
								}else if(value=="60"){
									return "注销待复审";
								}
						}
							},	
						{field:'DEPT_ID',title:'操作',width:150,align:'center',
						formatter:function(value,rec){	
							if(flag=='4'){
								return '<a href="javascript:toMerchModifyEdit('+rec.SELF_ID+')" style="color:blue;margin-left:10px">修改</a>&nbsp;&nbsp;<a href="javascript:toMerchModifyDetail('+rec.SELF_ID+')" style="color:blue;margin-left:10px">详情</a>';
							}else if(flag=='5'){
								return '<a href="javascript:toMerchModifyAudit('+rec.SELF_ID+')" style="color:blue;margin-left:10px">审核</a>';
							}else{
								return '<a href="javascript:toMerchModifyAudit('+rec.SELF_ID+')" style="color:blue;margin-left:10px">审核</a>';
							}
						}
					}
					]],
						pagination:true,
						rownumbers:true
				});
			}
			
			var p = $('#test').datagrid('getPager');
			$.extend($.fn.validatebox.defaults.rules, {   
			    minLength: {   
			        validator: function(value, param){ 
						var re =  /^\d+$/; 
		        		if(!re.test(value)){
							return false;
			        	}  
			            return value.length >= param[0];   
			        },   
			        message: '请输入4位数字的部门代码'  
			    }
			   
			});  
		});
		function search(){
			//var url="merchant/queryMerch?flag="+$("#flag").val();
			var data={
					'memberId':$('#merchId_ins').val(),
					'memberName':$('#memberName_ins').val(),					
					};
			$('#test').datagrid('load',data);
		}
		function resize(){
			$('#theForm :input').val('');
		}
		//详情
		function toMerchModifyDetail(id,isApply){
			window.location.href= "<%=basePath%>" +'merchant/toMerchDetail?merchApplyId='+id;
			//window.event.returnValue = false;
		}
		//变更
		function toMerchModifyEdit(id){
			window.location.href= "<%=basePath%>" +'merchant/toMerchModifyEdit?merchApplyId='+id;
			//window.event.returnValue = false;
		}
		//初审、复审 
		function toMerchModifyAudit(merchApplyId){
			flag=$('#flag_ins').val();
			window.location.href= "<%=basePath%>" +'merchant/toMerchModifyDetail?merchApplyId='+merchApplyId+'&flag='+flag;
			//window.event.returnValue = false;
		}
		function toActivateStatus(memberId) {
			if(($("#"+memberId).attr("value"))!=0){
				alert("您刚刚已经申请过发送邮件了");
				return ;
			}
		
			$.ajax({
				type : "POST",
				url : "<%=basePath%>" +"/pages/active/replayEmailActiveStatusAction.action?memberId="+memberId,
				data : "",
				dataType : "json",
				success : function(json) {
					var dataArray = eval(json);
					alert(dataArray.messg)
					$("#"+memberId).attr("value",01);

				}
			});
			
			setTimeout("remove("+memberId+")",5000);
		}
		
		function remove(memberId){
			$("#"+memberId).attr("value",120000);
		}
		function toUpload(merchApplyId){
			window.location.href= "<%=basePath%>" +'/merchant/toUploadModifyInfo?merchApplyId='+merchApplyId;
		}
	
</script>

