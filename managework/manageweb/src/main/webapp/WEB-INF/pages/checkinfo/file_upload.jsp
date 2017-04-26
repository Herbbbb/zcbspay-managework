<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../../top.jsp"></jsp:include>
<html>
<head>
<style>
table tr td {
	padding-top: 4px;
	padding-bottom: 4px;
	padding-left: 4px;
	border-style: solid;
	border-color: #000000;
	height: 20px;
}

table tr td input {
	height: 15px;
}

.type-file-box {
	position: relative;
	width: 260px
}

input {
	vertical-align: middle;
	margin: 2;
	padding: 2;
}

.type-file-text {
	margin-left: 2px, height: 18px;
	border: 1px solid #cdcdcd;
	width: 180px;
}

.type-file-button {
	background-color: #FFF;
	border: 1px solid #CDCDCD;
	height: 20px;
	width: 70px;
}

.type-file-file {
	position: absolute;
	margin-left: -260px;
	height: 20px;
	filter: alpha(opacity : 0);
	opacity: 0;
	width: 260px
}

.type-add-button {
	height: 20px;
}
.add-on {
	height: 20px;
	width:200px;
}
</style>
</head>
<body>
	<div style="margin: 5px;" id="continer">

		<div style="padding-left: 5px; padding-right: 5px">
			<form id="importCsvForm" method="post"
				action="pages/merchant/uploadUploadAction.action"
				enctype="multipart/form-data">
				<table width="100%" border="1">
					<tr>
						<td colspan="4" align="center">对账文件上传</td>
					</tr>
					<tr height="26" id="fileadd1">
						<td align="center">对账文件</td>
						<td colspan="3">
							<div class="type-file-text" id="importModal">
							     <input name="orderCSV" class="add-on" type="file">
							</div>
						</td>
					</tr>
					<tr height="26" id="fileadd1">
						<td align="center">对账机构</td>
						<td colspan="3"><select id="instiid_ins"
							class="easyui-validatebox" name="instiid">

						</select></td>
					</tr>
					<tr>
						<td align="center" colspan="4" id="uploadbutton">
							<a class="easyui-linkbutton"  iconCls="icon-ok"  onclick="fileUpload()">上传</a>
				            <a class="easyui-linkbutton" iconCls="icon-back" onclick="back()">关闭</a>
						</td>
					</tr>
					<tr>
						<td align="center" colspan="4" id="uploadhint"><img
							alt="正在上传" src="pictuer/loading.gif">文件正在上传,请耐心等待...</td>
					</tr>
				</table>
			</form>
		</div>
	</div>



</body>
<script type="text/javascript">
	function queryChannel() {
		$.ajax({
			type : "POST",
			url : "checkinfo/queryChannel",
			data : "",
			dataType : "json",
			success : function(json) {
				var html = "<option  Seleted ='Seleted' value=''>--请选择--</option>";
				$.each(json,
				function(key, value) {
					html += '<option value="' + value.CHANNEL_CODE + '">' + value.CHANNEL_NAME + '</option>';
				});
				$("#instiid_ins").html(html);
			}
		});
	}
	$(document).ready(function() {
		$("#billDate").datebox();
		queryChannel();
		$("#button").click(function() {
			$("#upload").trigger('click');
		});

		$("#upload").change(function() {
			$("#textfield").val($("#upload").val());
		});

		$("#uploadbutton").show();
		$("#uploadhint").hide();

		 	$("#billDate").datebox({  
		   	required:true
	    	 });  
	      
	      $('#startDate').datebox({   
	         });  
	  
		
	});

	function fileUpload() {
		if ($("#instiid_ins").val() == "") {
			 $.messager.alert("提示","请选择对账机构");
		} else {
			importConfirm();
		}

	}
	
	/**导入csv文件到数据库确认*/
	function importConfirm(){
	     var formData = new FormData( $("#importCsvForm")[0] );
	     $.ajax({
	          url: 'checkinfo/csvimport',
	          type: 'POST',
	          data: formData,
	          dataType:"json",
	          cache: false,
	          contentType: false,  
	          processData: false,  
	          success: function (data) {
	              console.log("data:"+JSON.stringify(data));
	           	  $.messager.alert("提示",data.msg);
	          },  
	          error: function (returndata) {  
	        	  $.messager.alert("提示","上传失败");
	          }  
	     });  
	}

	function back() {
		var form = document.forms['fileuploadform'];
		/* form.action = "checkinfo/showFileUpload";
		form.submit(); */
	}
	
	/**补0**/
	function pad(num, n) {  
	    var len = num.toString().length;  
	    while(len < n) {  
	        num = "0" + num;  
	        len++;  
	    }  
	    return num;  
	}  
	
	function billFileUpload(){
		if($('#startDate').datebox('getValue')==""||$('#startDate').datebox('getValue')==null){
			$.messager.alert('提示', '请选择对账日期');
			return;
		}
		if ($("#instiid_wechat").val() == ""||$("#instiid_wechat").val() == null) {
			$.messager.alert('提示', '请选择对账机构');
			return;
		}
		var date=$('#startDate').datebox('getValue');
		var startDate = new Date(date);
		var day = startDate.getTime() - 1 * 24 * 60 * 60 * 1000;
		var datefm = new Date(day);
		var billDate=datefm.getFullYear() + "-" + pad((datefm.getMonth() + 1), 2) + "-" +pad( datefm.getDate(),2);
		$.ajax({
			type : "POST",
			url : "pages/merchant/downWeChatBillUploadAction.action",
			data : "billDate="+billDate+"&instiid="+$("#instiid_wechat").val(),
			dataType : "json",
			success : function(json) {
				$.messager.alert('提示', json.info);
			}
		});
		
		
	}
	
	
	
	function downBillchan() {
		
		$('#downBillchanform').form('submit', {
			onSubmit : function() {
				if($('#downBillchanform').form('validate')){
					//校验日期，大于当前日期
					var billDate =new Date($('input[name="billDate"]').val().replace(/-/g,"/"));
					var myDate = new Date();
					var result=myDate.getFullYear()+'/'+(myDate.getMonth()+1)+'/'+myDate.getDate() ;
					var curDate=new Date(result);
					if(billDate-curDate>=0){
						alert("对账日期只能选择当前日期之前");
						return false;
					}
					
					$("#downBillchanButton").hide();
					return;
				}

			},
			success : function(json) {
				$("#downBillchanButton").show();
			},
			error: function(e) { 
				alert("下载失败！请联系管理员！"); 
			} 
		});
		

	}
</script>
</html>
