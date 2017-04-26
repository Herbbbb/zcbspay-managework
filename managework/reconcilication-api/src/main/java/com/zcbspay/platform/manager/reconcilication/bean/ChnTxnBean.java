package com.zcbspay.platform.manager.reconcilication.bean;

import java.io.Serializable;

public class ChnTxnBean implements Serializable{
	private String tid;//标志
	private String txnseqno;//交易序列号-对账时用
	private String instiid;//机构标识
	private String busicode;//交易类型
	private String chargingunit;//收费单位代码
	private String transdate;//提交日期
	private String txid;//流水号-订单号
	private String creditorbranchcode;//入账银行行号
	private String creditoraccountno;//收款人账号
	private String creditorname;//收款人名称
	private String debtorbranchcode;//出账银行行号
	private String debtoraccountno;//付款人账号
	private String debtorname;//付款人名称
	private String currencysymbol;//货币符
	private String amount;//金额
	private String meterobjnumber;//计量对象号码-代收特有
	private String authnumber;//授权号-代收特有
	private String vouchernumber;//凭证号码-代收特有
	private String billnumber;//票据号码-实时交易特有
	private String systrcno;//应答流水号
	private String rspcode;//应答码
	private String settledate;//清算日
	private String settlestatus;//清算标志
	private String proid;//清算日志标识-对账时用
	private String status;//对账状态-对账时用
	private String result;//对账结果-对账时用
	private String logid;//批量下载标示
	private String notes;//备注
	private String remarks;//备注
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTxnseqno() {
		return txnseqno;
	}
	public void setTxnseqno(String txnseqno) {
		this.txnseqno = txnseqno;
	}
	public String getInstiid() {
		return instiid;
	}
	public void setInstiid(String instiid) {
		this.instiid = instiid;
	}
	public String getBusicode() {
		return busicode;
	}
	public void setBusicode(String busicode) {
		this.busicode = busicode;
	}
	public String getChargingunit() {
		return chargingunit;
	}
	public void setChargingunit(String chargingunit) {
		this.chargingunit = chargingunit;
	}
	public String getTransdate() {
		return transdate;
	}
	public void setTransdate(String transdate) {
		this.transdate = transdate;
	}
	public String getTxid() {
		return txid;
	}
	public void setTxid(String txid) {
		this.txid = txid;
	}
	public String getCreditorbranchcode() {
		return creditorbranchcode;
	}
	public void setCreditorbranchcode(String creditorbranchcode) {
		this.creditorbranchcode = creditorbranchcode;
	}
	public String getCreditoraccountno() {
		return creditoraccountno;
	}
	public void setCreditoraccountno(String creditoraccountno) {
		this.creditoraccountno = creditoraccountno;
	}
	public String getCreditorname() {
		return creditorname;
	}
	public void setCreditorname(String creditorname) {
		this.creditorname = creditorname;
	}
	public String getDebtorbranchcode() {
		return debtorbranchcode;
	}
	public void setDebtorbranchcode(String debtorbranchcode) {
		this.debtorbranchcode = debtorbranchcode;
	}
	public String getDebtoraccountno() {
		return debtoraccountno;
	}
	public void setDebtoraccountno(String debtoraccountno) {
		this.debtoraccountno = debtoraccountno;
	}
	public String getDebtorname() {
		return debtorname;
	}
	public void setDebtorname(String debtorname) {
		this.debtorname = debtorname;
	}
	public String getCurrencysymbol() {
		return currencysymbol;
	}
	public void setCurrencysymbol(String currencysymbol) {
		this.currencysymbol = currencysymbol;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getMeterobjnumber() {
		return meterobjnumber;
	}
	public void setMeterobjnumber(String meterobjnumber) {
		this.meterobjnumber = meterobjnumber;
	}
	public String getAuthnumber() {
		return authnumber;
	}
	public void setAuthnumber(String authnumber) {
		this.authnumber = authnumber;
	}
	public String getVouchernumber() {
		return vouchernumber;
	}
	public void setVouchernumber(String vouchernumber) {
		this.vouchernumber = vouchernumber;
	}
	public String getBillnumber() {
		return billnumber;
	}
	public void setBillnumber(String billnumber) {
		this.billnumber = billnumber;
	}
	public String getSystrcno() {
		return systrcno;
	}
	public void setSystrcno(String systrcno) {
		this.systrcno = systrcno;
	}
	public String getRspcode() {
		return rspcode;
	}
	public void setRspcode(String rspcode) {
		this.rspcode = rspcode;
	}
	public String getSettledate() {
		return settledate;
	}
	public void setSettledate(String settledate) {
		this.settledate = settledate;
	}
	public String getSettlestatus() {
		return settlestatus;
	}
	public void setSettlestatus(String settlestatus) {
		this.settlestatus = settlestatus;
	}
	public String getProid() {
		return proid;
	}
	public void setProid(String proid) {
		this.proid = proid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getLogid() {
		return logid;
	}
	public void setLogid(String logid) {
		this.logid = logid;
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

}
