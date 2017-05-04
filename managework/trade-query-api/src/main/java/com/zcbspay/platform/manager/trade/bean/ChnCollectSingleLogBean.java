package com.zcbspay.platform.manager.trade.bean;

import java.io.Serializable;

public class ChnCollectSingleLogBean implements Serializable {

	private static final long serialVersionUID = -4547100770958053686L;

	private String tid;// 标识
	private String msgid;// 报文标识号
	private String txid;// 明细标识号
	private String transdate;// 本地日期
	private String transtime;// 本地时间
	private String debtorname;// 付款人名称
	private String debtoraccountno;// 付款人账号
	private String debtorbranchcode;// 付款行行号
	private String creditorbranchcode;// 收款行行号
	private String creditorname;// 收款人名称
	private String creditoraccountno;// 收款人账号
	private String amount;// 金额
	private String purposeproprietary;// 业务种类编码
	private String endtoendidentification;// 合同（协议）号
	private String summary;// 摘要
	private String billnumber;// 票据号码
	private String rspmsgid;// 应答报文标识号
	private String rspstatus;// 应答状态
	private String rsprejectcode;// 应答码
	private String rsprejectinformation;// 业务拒绝信息
	private String rspdate;// 业务应答时间
	private String nettingdate;// 轧差日期
	private String commsgid;// 通用处理报文标识号
	private String comstatus;// 通用处理应答状态
	private String comrejectcode;// 通用处理应答码
	private String comrejectinformation;// 通用处理业务拒绝信息
	private String comdate;// 通用处理业务应答时间
	private String txnseqno;// 交易流水号
	private String notes;// 备注
	private String remarks;// 备注
	private String transmitleg;// 发起方代码
	private String receiver;// 接收方代码

	private String etime;
	private String stime;
	private Long userId;

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getMsgid() {
		return msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

	public String getTxid() {
		return txid;
	}

	public void setTxid(String txid) {
		this.txid = txid;
	}

	public String getTransdate() {
		return transdate;
	}

	public void setTransdate(String transdate) {
		this.transdate = transdate;
	}

	public String getTranstime() {
		return transtime;
	}

	public void setTranstime(String transtime) {
		this.transtime = transtime;
	}

	public String getDebtorname() {
		return debtorname;
	}

	public void setDebtorname(String debtorname) {
		this.debtorname = debtorname;
	}

	public String getDebtoraccountno() {
		return debtoraccountno;
	}

	public void setDebtoraccountno(String debtoraccountno) {
		this.debtoraccountno = debtoraccountno;
	}

	public String getDebtorbranchcode() {
		return debtorbranchcode;
	}

	public void setDebtorbranchcode(String debtorbranchcode) {
		this.debtorbranchcode = debtorbranchcode;
	}

	public String getCreditorbranchcode() {
		return creditorbranchcode;
	}

	public void setCreditorbranchcode(String creditorbranchcode) {
		this.creditorbranchcode = creditorbranchcode;
	}

	public String getCreditorname() {
		return creditorname;
	}

	public void setCreditorname(String creditorname) {
		this.creditorname = creditorname;
	}

	public String getCreditoraccountno() {
		return creditoraccountno;
	}

	public void setCreditoraccountno(String creditoraccountno) {
		this.creditoraccountno = creditoraccountno;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPurposeproprietary() {
		return purposeproprietary;
	}

	public void setPurposeproprietary(String purposeproprietary) {
		this.purposeproprietary = purposeproprietary;
	}

	public String getEndtoendidentification() {
		return endtoendidentification;
	}

	public void setEndtoendidentification(String endtoendidentification) {
		this.endtoendidentification = endtoendidentification;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getBillnumber() {
		return billnumber;
	}

	public void setBillnumber(String billnumber) {
		this.billnumber = billnumber;
	}

	public String getRspmsgid() {
		return rspmsgid;
	}

	public void setRspmsgid(String rspmsgid) {
		this.rspmsgid = rspmsgid;
	}

	public String getRspstatus() {
		return rspstatus;
	}

	public void setRspstatus(String rspstatus) {
		this.rspstatus = rspstatus;
	}

	public String getRsprejectcode() {
		return rsprejectcode;
	}

	public void setRsprejectcode(String rsprejectcode) {
		this.rsprejectcode = rsprejectcode;
	}

	public String getRsprejectinformation() {
		return rsprejectinformation;
	}

	public void setRsprejectinformation(String rsprejectinformation) {
		this.rsprejectinformation = rsprejectinformation;
	}

	public String getRspdate() {
		return rspdate;
	}

	public void setRspdate(String rspdate) {
		this.rspdate = rspdate;
	}

	public String getNettingdate() {
		return nettingdate;
	}

	public void setNettingdate(String nettingdate) {
		this.nettingdate = nettingdate;
	}

	public String getCommsgid() {
		return commsgid;
	}

	public void setCommsgid(String commsgid) {
		this.commsgid = commsgid;
	}

	public String getComstatus() {
		return comstatus;
	}

	public void setComstatus(String comstatus) {
		this.comstatus = comstatus;
	}

	public String getComrejectcode() {
		return comrejectcode;
	}

	public void setComrejectcode(String comrejectcode) {
		this.comrejectcode = comrejectcode;
	}

	public String getComrejectinformation() {
		return comrejectinformation;
	}

	public void setComrejectinformation(String comrejectinformation) {
		this.comrejectinformation = comrejectinformation;
	}

	public String getComdate() {
		return comdate;
	}

	public void setComdate(String comdate) {
		this.comdate = comdate;
	}

	public String getTxnseqno() {
		return txnseqno;
	}

	public void setTxnseqno(String txnseqno) {
		this.txnseqno = txnseqno;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTransmitleg() {
		return transmitleg;
	}

	public void setTransmitleg(String transmitleg) {
		this.transmitleg = transmitleg;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
