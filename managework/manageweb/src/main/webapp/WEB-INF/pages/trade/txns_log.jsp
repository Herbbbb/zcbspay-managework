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
			style="height: 150px; padding: 10px; background: #fafafa;"
			iconCls="icon-save" collapsible="true">
			<form id="theForm" method="post">
				<table width="100%">
					<tr>
						<td align="right" width="10%">交易序列号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="txnseqno" id="txnseqno" maxlength="32" /></td>

						<td align="right" width="10%">交易类型</td>
						<td colspan="1" style="padding-left: 5px"><select name="busicode"
							class="easyui-validatebox validatebox-text" id="busicode" style="width:150px">
								<option value="">请选择</option>
								<c:forEach items="${bus}" var="bus">
									<c:if test="${bus.BUSICODE!='10000003'&&bus.BUSICODE!='10000004'&&bus.BUSICODE!='30000002'&&bus.BUSICODE!='30000003'}">
										<option value=${bus.BUSICODE }>${bus.BUSINAME}</option>
									</c:if>
								</c:forEach> 
						</select></td>

						<td align="right" width="10%">转出帐号或卡号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="pan" id="pan" maxlength="32" /></td>

						<td align="right" width="10%">受理订单号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="accordno" id="accordno" maxlength="32" /></td>
					</tr>
					<tr>
<!-- 						<td align="left" style="padding-left: 5px" width="15%"><input -->
<!-- 							name="accfirmerno" id="accfirmerno" maxlength="32" /></td> -->
						<td align="right" width="10%">委托机构号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="accsecmerno" id="accsecmerno" maxlength="32" /></td>
						<td align="right" width="10%">支付方交易流水号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="payrettsnseqno" id="payrettsnseqno" maxlength="32" /></td>


						<td align="right" width="10%">中心应答码</td>
						<td colspan="1" style="padding-left: 5px"><select name="retcode" id="retcode" style="width:150px">
								<option value="">请选择</option>
								<option value="00">成功</option>
								<option value="01">失败</option>
						</select></td>
						<td align="right" width="10%">受理清算日期</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							id="accsettledate" type="text" class="easyui-datebox"
							name="accsettledate"></input></td>
					</tr>
					<tr>
						<td align="right" width="10%">支付订单号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="payordno" id="payordno" maxlength="32" /></td>

						<td align="right" width="10%">交易渠道
						<td colspan="1" style="padding-left: 5px"><select name="payinst" id="payinst" style="width:150px">
								<option value="">请选择</option>
								<c:forEach items="${channel}" var="channel">
									<option value=${channel.CHNLCODE }>${channel.CHNLNAME}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>

						<td align="right" width="10%">受理委托机构号</td>
						<td align="left" style="padding-left: 5px" width="15%"><input
							name="accmemberid" id="accmemberid" maxlength="32" /></td>

						<td align="right" width="10%">受理定单提交时间</td>
						<td colspan="2" style="padding-left: 5px"><input id="stime" type="text"
							style="width: 120PX" class="easyui-datetimebox"
							data-options="showSeconds:false" name="stime"></input>
							至<input id=etime type="text" style="width: 120PX"
							class="easyui-datetimebox" data-options="showSeconds:false"
							name="etime"></input></td>
						<td></td>
						<td colspan="2" align="right"><a href="javascript:search()"
							class="easyui-linkbutton" iconCls="icon-search">查询</a>
							<a
							href="javascript:resize()" class="easyui-linkbutton"
							iconCls="icon-redo">清空</a></td>
							</td>
					
					</tr>
				</table>
			</form>
		</div>
		<div style="margin-top: 5px">
			<table id="test"></table>
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
						<td>交易序列号</td>
						<td id="ttxnseqno"></td>
						<td>交易日期</td>
						<td id="ttxndate"></td>
					</tr>
					<tr>
						<td>交易时间</td>
						<td id="ttxntime"></td>
						<td>产品版本[委托机构角色]</td>
						<td id="tprdtver"></td>
					</tr>
					<tr>
						<td>业务类型</td>
						<td id="tbusitype"></td>
						<td>交易类型</td>
						<td id="tbusicode"></td>
					</tr>
					<tr>
						<td>交易金额[合计]</td>
						<td id="tamount"></td>
						<td>交易佣金</td>
						<td id="ttradcomm"></td>
					</tr>
					<tr>
						<td>交易手续费</td>
						<td id="ttxnfee"></td>
						<td>风控版本</td>
						<td id="triskver"></td>
					</tr>
					<tr>
						<td>分润版本</td>
						<td id="tsplitver"></td>
						<td>扣率版本</td>
						<td id="tfeever"></td>
					</tr>
					<tr>
						<td>转出帐号或卡号</td>
						<td id="tpan"></td>
						<td>受理委托机构号</td>
						<td id="taccsecmerno"></td>
					</tr>
					<tr>
						<td>转出帐号类型</td>
						<td id="tcardtype"></td>
						<td>转出帐号或卡号所属机构</td>
						<td id="tcardinstino"></td>
					</tr>
					<tr>
						<td>转入帐号或卡号</td>
						<td id="tinpan"></td>
						<td>转入帐号或卡号类型</td>
						<td id="tincardtype"></td>
					</tr>
					<tr>
						<td>转入帐号或卡号机构代码</td>
						<td id="tincardinstino"></td>
						<td>受理订单号</td>
						<td id="taccordno"></td>
					</tr>
					<tr>
						<td>受理清算日期</td>
						<td id="taccsettledate"></td>
						<td>支付订单号</td>
						<td id="tpayordno"></td>
					</tr>
					<tr>
						<td>受理定提交时间</td>
						<td id="taccordcommitime"></td>
						<td>受理定单完成时间</td>
						<td id="taccordfintime"></td>
					</tr>
					<tr>
						<td>交易渠道</td>
						<td id="tpayinst"></td>
						<td>支付合作机构号</td>
						<td id="tpayfirmerno"></td>
					</tr>
					<tr>
						<td>支付委托机构号</td>
						<td id="tpaysecmerno"></td>
						<td>支付定单提交时间</td>
						<td id="tpayordcomtime"></td>
					</tr>
					<tr>
						<td>支付定单完成时间</td>
						<td id="tpayordfintime"></td>
						<td>支付方交易序列号</td>
						<td id="tpayrettsnseqno"></td>
					</tr>
					<tr>
						<td>支付方应答码</td>
						<td id="tpayretcode"></td>
						<td>支付方应答信息</td>
						<td id="tpayretinfo"></td>
					</tr>
					<tr>
						<td>应用定单号</td>
						<td id="tappordno"></td>
						<td>应用所属机构</td>
						<td id="tappinst"></td>
					</tr>
					<tr>
						<td>应用定单提交时间</td>
						<td id="tappordcommitime"></td>
						<td>应用定单完成时间</td>
						<td id="tappordfintime"></td>
					</tr>
					<tr>
						<td>交易查询流水</td>
						<td id="ttradeseltxn"></td>
						<td>中心应答码</td>
						<td id="tretcode"></td>
					</tr>
					<tr>
						<td>中心应答信息</td>
						<td id="tretinfo"></td>
						<td>交易状态标志位</td>
						<td id="ttradestatflag"></td>
					</tr>
					<tr>
						<td>交易所涉流水表标志位</td>
						<td id="ttradetxnflag"></td>
						<td>涉及流水表标志</td>
						<td id="trelate"></td>
					</tr>
					<tr>
						<td>中心应答时间</td>
						<td id="tretdatetime"></td>
						<td>原交易序列号</td>
						<td id="ttxnseqno_og"></td>
					</tr>
					
					<tr>
						<td>受理委托机构号</td>
						<td id="taccmemberid"></td>
						<td>应用定单状态</td>
						<td id="tapporderstatus"></td>
					</tr>
					
					<tr>
						<td>应用订单应答信息</td>
						<td id="tapporderinfo"></td>
						<td>备注</td>
						<td id="tnotes"></td>
					</tr>
<!-- 					<tr> -->
<!-- 						<td>备注</td> -->
<!-- 						<td id="tremarks"></td> -->
						
<!-- 					</tr> -->
				</table>
			</div>
			<div region="south" border="false" style="text-align: center; padding: 15px 0;">
				<a class="easyui-linkbutton" iconCls="icon-back" onclick="closeAdd()">返回</a>
			</div>
		</div>
	</div>
</body>

<script>
	function changeDate(value){
		var dateString = value;
		if(dateString==null || dateString== 0){
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
	function b_changeDate(value){
		var dateString = value;
		if(dateString==null || dateString== 0){
			return "";
		}else{
			year=dateString.substring(0,4);//0123
			month=dateString.substring(4,6);//45
			day=dateString.substring(6,8);//67
			return year+"-"+month+"-"+day;
		}
	}
	function c_changeDate(value){
		var dateString = value;
		if(dateString==null || dateString== 0){
			return "";
		}else{
			hour=dateString.substring(8,10);//89
			minte=dateString.substring(10,12);//10 11
			s=dateString.substring(12,14);// 11 12
			return hour +":"+minte+":"+s;
		}
	}
  	var width = $("#continer").width();
		$(function(){
			
			$('#test').datagrid({
				title:'交易信息列表',
				iconCls:'icon-save',
				height:400,
				singleSelect:true,
				nowrap: false,
				striped: true,
				url:'trade/getTxnsLogByPage',
				remoteSort: false,
				idField:'ORGAN_ID',
				columns:[
				[
					{field:'TXNSEQNO',title:'交易序列号',width:120,align:'center'},
					{field:'TXNDATE',title:'交易时间',width:150,align:'center',
						formatter : function(value, rec) {
							return changeDate(rec.TXNDATE+rec.TXNTIME);
						}
					},
					{field:'BUSINAME',title:'交易类型',width:120,align:'center'},
					{field:'AMOUNT',title:'交易金额(元)',width:120,align:'center',
						formatter:function(value,rec){
							return fenToYuan(rec.AMOUNT);
						}
					},
					{field:'TXNFEE',title:'交易手续费(元)',width:120,align:'center',
						formatter:function(value,rec){
							return fenToYuan(rec.TXNFEE);
						}
					},
					{field:'RETINFO',title:'中心应答信息',width:120,align:'center'},
					{field:'PAN',title:'转出帐号或卡号',width:150,align:'center'},
					{field:'ACCSECMERNO',title:'委托机构号',width:150,align:'center'},
					{field:'ACCORDNO',title:'订单号',width:150,align:'center'},
					{field:'PAYORDNO',title:'支付订单号',width:150,align:'center'},
					{field:'PAYRETTSNSEQNO',title:'支付订单号',width:150,align:'center'},
					{field:'ACCORDCOMMITIME',title:'受理定单提交时间',width:150,align:'center'},
					{field:'ACCORDFINTIME',title:'受理定单完成时间',width:150,align:'center',
						formatter : function(value, rec) {
							return changeDate(rec.ACCORDFINTIME);
						}	
					},
					{field:'ACCSETTLEDATE',title:'受理清算日期',width:120,align:'center',
						formatter : function(value, rec) {
							return b_changeDate(rec.ACCSETTLEDATE);
						}		
					},
					{field:'CHNLNAME',title:'交易渠道',width:120,align:'center'},
					{field:'TXNSEQNO_OG',title:'操作',width:100,align:'center',
					formatter:function(value,rec){
						if(rec.TXNSEQNO!=null){
							return '<a href="javascript:queryTxnsLog(\''+rec.TXNSEQNO+'\')" style="color:blue;margin-left:10px">详细信息</a>';
						}else {
							return '';
						}
					}
				    } 
					
				]],
				pagination:true,
				rownumbers:true
		
			});
	
		});
		
		function search(){
			var data={"txnseqno":$('#txnseqno').val(),
			"busicode":$('#busicode').val(),
			"pan":$('#pan').val(),
			"accordno":$('#accordno').val(),
			"accsecmerno":$('#accsecmerno').val(),
			"accfirmerno":$('#accfirmerno').val(),
 			"accsettledate":$('#accsettledate').datebox('getValue'),
			"stime":$('#stime').datebox('getValue'),
			"etime":$('#etime').datebox('getValue'), 
			"payType":$('#paytype').val(),
			"payrettsnseqno":$('#payrettsnseqno').val(),
			"retcode":$('#retcode').val(),
			"payordno":$('#payordno').val(),
			"payinst":$('#payinst').val(),
			"accmemberid":$('#accmemberid').val()
		}
			$('#test').datagrid('load',data);
		}
		
		function resize(){
			$('#theForm :input').val('');
		}
		
		function queryTxnsLog(txnseqno){
		 $("#ttxnseqno").html("");
			   $("#ttxndate").html("");
			   $("#ttxntime").html("");
			   $("#tapptype").html("");
			   $("#tbusitype").html("");
			   $("#tbusicode").html("");
			   $("#tamount").html("");
			   $("#ttradcomm").html("");
			   $("#ttxnfee").html("");
			   $("#triskver").html("");
			   $("#tsplitver").html("");
			   $("#tfeever").html("");
			   $("#tprdtver").html("");
			   $("#tcheckstandver").html("");
			   $("#troutver").html("");
			   $("#tpan").html("");
			   $("#tcardtype").html("");
			   $("#tcardinstino").html("");
			   $("#tinpan").html("");
			   $("#tincardtype").html("");
			   $("#tincardinstino").html("");
			   $("#taccordno").html("");
			   $("#taccordinst").html("");
			   $("#taccsecmerno").html("");
			   $("#taccfirmerno").html("");
			   $("#taccsettledate").html("");
			   $("#taccordcommitime").html("");
			   $("#taccordfintime").html("");
			   $("#tpaytype").html("");
			   $("#tpayordno").html("");
			   $("#tpayinst").html("");
			   $("#tpayfirmerno").html("");
			   $("#tpaysecmerno").html("");
			   $("#tpayordcomtime").html("");
			   $("#tpayordfintime").html("");
			   $("#tpayrettsnseqno").html("");
			   $("#tpayretcode").html("");
			   $("#tpayretinfo").html("");
			   $("#tappordno").html("");
			   $("#tappinst").html("");
			   $("#tappordcommitime").html("");
			   $("#tappordfintime").html("");
			   $("#ttradeseltxn").html("");
			   $("#tretcode").html("");
			   $("#tretinfo").html("");
			   $("#ttradestatflag").html("");
			   $("#ttradetxnflag").html("");
			   $("#ttxncode").html("");
			   $("#tcashcode").html("");
			   $("#trelate").html("");
			   $("#tretdatetime").html("");
			   $("#ttxnseqno_og").html("");
			   $("#tnotes").html("");
			   $("#tremarks").html("");
			   $("#taccmemberid").html("");
			   $("#tapporderstatus").html("");
			   $("#tapporderinfo").html("");
			   
			$('#w').window({
				title: '详细信息',
				top:50,
				left:100,
				width:910,
				modal: true,
				minimizable:false,
				collapsible:false,
				maximizable:false,
				shadow: false,
				closed: false,
				height: 750
			});
		
	
			$.ajax({
				   type: "POST",
				   url: "trade/getTxnsLogByTxnseqno",
				   data: "txnseqno="+txnseqno,
				   dataType:"json",
				   success:function(date){
					   if(date.messg!=null){
						   
					   }else{
						   json=date.json;		   
					   $("#ttxnseqno").html(json.TXNSEQNO);
					   $("#ttxndate").html(b_changeDate(json.TXNDATE+json.TXNTIME));
					   $("#ttxntime").html(c_changeDate(json.TXNDATE+json.TXNTIME));
					   $("#tapptype").html(json.APPTYPE);
					   $("#tbusitype").html(json.BUSITYPE);
					   $("#tbusicode").html(json.BUSINAME);
					   $("#tamount").html(fenToYuan(json.AMOUNT));
					   $("#ttradcomm").html(fenToYuan(json.TRADCOMM));
					   $("#ttxnfee").html(fenToYuan(json.TXNFEE));
					   $("#triskver").html(json.RISKNAME);
					   $("#tsplitver").html(json.SPLITVER);
					   $("#tfeever").html(json.FEENAME);
					   $("#tprdtver").html(json.PRDTNAME);
					   $("#tcheckstandver").html(json.CASHNAME);
					   $("#troutver").html(json.ROUTNAME);
					   $("#tpan").html(json.PAN);
					   if(json.CARDTYPE=="1"){
						   $("#tcardtype").html("借记卡");
					   }
					   if(json.CARDTYPE=="2"){
						   $("#tcardtype").html("信用卡");
					   }
					   $("#tcardinstino").html(json.CARDINSTINO);
					   $("#tinpan").html(json.INPAN);
					   if(json.tincardtype=="1"){
						   $("#tincardtype").html("借记卡");
					   }
					   if(json.tincardtype=="2"){
						   $("#tincardtype").html("信用卡");
					   }
					   $("#tincardinstino").html(json.INCARDINSTINO);
					   $("#taccordno").html(json.ACCORDNO);
					   $("#taccordinst").html(json.ACCORDINST);
					   $("#taccsecmerno").html(json.ACCSECMERNO);
					   $("#taccfirmerno").html(json.ACCFIRMERNO);
					   $("#taccsettledate").html(changeDate(json.ACCSETTLEDATE+json.ACCORDFINTIME));
					   $("#taccordcommitime").html(changeDate(json.ACCORDCOMMITIME));
					   //$("#taccordfintime").html(json.ACCORDFINTIME);
					   $("#tpaytype").html(json.PAYTYPE);
					   $("#tpayordno").html(json.PAYORDNO);
                       $("#tpayinst").html(json.CHNLNAME);
					   $("#tpayfirmerno").html(json.PAYFIRMERNO);
					   $("#tpaysecmerno").html(json.PAYSECMERNO);
					   $("#tpayordcomtime").html(changeDate(json.PAYORDCOMTIME));
					   $("#tpayordfintime").html(changeDate(json.PAYORDFINTIME));
					   $("#tpayrettsnseqno").html(json.PAYRETTSNSEQNO);
					   $("#tpayretcode").html(json.PAYRETCODE);
					   $("#tpayretinfo").html(json.PAYRETINFO);
					   $("#tappordno").html(json.APPORDNO);
					   $("#tappinst").html(json.APPINST);
					   $("#tappordcommitime").html(changeDate(json.APPORDCOMMITIME));
					   $("#tappordfintime").html(changeDate(json.APPORDFINTIME));
					   $("#ttradeseltxn").html(json.TRADESELTXN);
					   $("#tretcode").html(json.RETCODE);
					   $("#tretinfo").html(json.RETINFO);
					   $("#ttradestatflag").html(json.TRADESTATFLAG);
					   $("#ttradetxnflag").html(json.TRADETXNFLAG);
					   $("#ttxncode").html(json.TXNCODE);
					   $("#tcashcode").html(json.CASHCODE);
					   $("#trelate").html(json.RELATE);
					   $("#tretdatetime").html(changeDate(json.RETDATETIME));
					   $("#ttxnseqno_og").html(json.TXNSEQNO_OG);
					   $("#tnotes").html(json.NOTES);
					   $("#tremarks").html(json.REMARKS);
					   $("#taccmemberid").html(json.ACCMEMBERID);
					   $("#tapporderstatus").html(json.APPORDERSTATUS);
					   $("#tapporderinfo").html(json.APPORDERINFO);
					   }
				 	}
				});
		}
		
		function closeAdd(){
			$('#w').window('close');
		}
		function fenToYuan(value){
			var str = (value/100).toFixed(2) + '';
			var intSum = str.substring(0,str.indexOf(".")).replace( /\B(?=(?:\d{3})+$)/g, ',' );
			var dot = str.substring(str.length,str.indexOf("."))
			var ret = intSum + dot;
			return ret;
		}
	</script>
</html>
