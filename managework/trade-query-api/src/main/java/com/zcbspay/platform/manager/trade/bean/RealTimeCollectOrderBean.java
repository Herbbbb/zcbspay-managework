package com.zcbspay.platform.manager.trade.bean;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

public class RealTimeCollectOrderBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8957681182829653297L;
	private String tid;// 标志
	private String accesstype;// 接入类型
	private String coopinstiid;// 合作机构号
	private String merid;// 商户号
	private String version;// 版本
	private String encoding;// 编码方式
	private String txntype;// 交易类型
	private String txnsubtype;// 交易子类
	private String biztype;// 产品类型
	private String backurl;// 通知地址
	private String mername;// 商户全称
	private String merabbr;// 商户简称
	private String orderid;// 商户订单号
	private String txntime;// 订单发送时间
	private String paytimeout;// 支付超时时间
	private String txnamt;// 交易金额
	private String currencycode;// 交易币种
	private String debtorbank;// 付款人银行号
	private String debtoraccount;// 付款人账号
	private String debtorname;// 付款人名称
	private String debtorconsign;// 付款合同号
	private String creditorbank;// 收款人银行号
	private String creditoraccount;// 收款人账号
	private String creditorname;// 收款人名称
	private String proprietary;// 业务种类编码
	private String summary;// 摘要
	private String orderdesc;// 订单描述
	private String reserved;// 保留域
	private String respcode;// 响应码
	private String respmsg;// 应答信息
	private String tn;// 受理订单号
	private String relatetradetxn;// 关联交易序列号
	private String status;// 状态(01:初始，订单提交成功，但未支付；02：支付中；03：支付失败；00：支付成功，04：订单失效)
	private String ordercommitime;// 订单提交时间
	private String syncnotify;// 异步通知结果
	private String notes;// 备注
	private String remarks;// 备注
	private String etime;
	private String stime;
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getStime() {
		if (!StringUtils.isBlank(stime)) {
			stime = stime.replace("-", "").replace(":", "").replace(" ", "");
		}
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getEtime() {
		if (!StringUtils.isBlank(etime)) {
			etime = etime.replace("-", "").replace(":", "").replace(" ", "");
		}
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getAccesstype() {
		return accesstype;
	}

	public void setAccesstype(String accesstype) {
		this.accesstype = accesstype;
	}

	public String getCoopinstiid() {
		return coopinstiid;
	}

	public void setCoopinstiid(String coopinstiid) {
		this.coopinstiid = coopinstiid;
	}

	public String getMerid() {
		return merid;
	}

	public void setMerid(String merid) {
		this.merid = merid;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getTxntype() {
		return txntype;
	}

	public void setTxntype(String txntype) {
		this.txntype = txntype;
	}

	public String getTxnsubtype() {
		return txnsubtype;
	}

	public void setTxnsubtype(String txnsubtype) {
		this.txnsubtype = txnsubtype;
	}

	public String getBiztype() {
		return biztype;
	}

	public void setBiztype(String biztype) {
		this.biztype = biztype;
	}

	public String getBackurl() {
		return backurl;
	}

	public void setBackurl(String backurl) {
		this.backurl = backurl;
	}

	public String getMername() {
		return mername;
	}

	public void setMername(String mername) {
		this.mername = mername;
	}

	public String getMerabbr() {
		return merabbr;
	}

	public void setMerabbr(String merabbr) {
		this.merabbr = merabbr;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getTxntime() {
		return txntime;
	}

	public void setTxntime(String txntime) {
		this.txntime = txntime;
	}

	public String getPaytimeout() {
		return paytimeout;
	}

	public void setPaytimeout(String paytimeout) {
		this.paytimeout = paytimeout;
	}

	public String getTxnamt() {
		return txnamt;
	}

	public void setTxnamt(String txnamt) {
		this.txnamt = txnamt;
	}

	public String getCurrencycode() {
		return currencycode;
	}

	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}

	public String getDebtorbank() {
		return debtorbank;
	}

	public void setDebtorbank(String debtorbank) {
		this.debtorbank = debtorbank;
	}

	public String getDebtoraccount() {
		return debtoraccount;
	}

	public void setDebtoraccount(String debtoraccount) {
		this.debtoraccount = debtoraccount;
	}

	public String getDebtorname() {
		return debtorname;
	}

	public void setDebtorname(String debtorname) {
		this.debtorname = debtorname;
	}

	public String getDebtorconsign() {
		return debtorconsign;
	}

	public void setDebtorconsign(String debtorconsign) {
		this.debtorconsign = debtorconsign;
	}

	public String getCreditorbank() {
		return creditorbank;
	}

	public void setCreditorbank(String creditorbank) {
		this.creditorbank = creditorbank;
	}

	public String getCreditoraccount() {
		return creditoraccount;
	}

	public void setCreditoraccount(String creditoraccount) {
		this.creditoraccount = creditoraccount;
	}

	public String getCreditorname() {
		return creditorname;
	}

	public void setCreditorname(String creditorname) {
		this.creditorname = creditorname;
	}

	public String getProprietary() {
		return proprietary;
	}

	public void setProprietary(String proprietary) {
		this.proprietary = proprietary;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getOrderdesc() {
		return orderdesc;
	}

	public void setOrderdesc(String orderdesc) {
		this.orderdesc = orderdesc;
	}

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

	public String getRespcode() {
		return respcode;
	}

	public void setRespcode(String respcode) {
		this.respcode = respcode;
	}

	public String getRespmsg() {
		return respmsg;
	}

	public void setRespmsg(String respmsg) {
		this.respmsg = respmsg;
	}

	public String getTn() {
		return tn;
	}

	public void setTn(String tn) {
		this.tn = tn;
	}

	public String getRelatetradetxn() {
		return relatetradetxn;
	}

	public void setRelatetradetxn(String relatetradetxn) {
		this.relatetradetxn = relatetradetxn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrdercommitime() {
		return ordercommitime;
	}

	public void setOrdercommitime(String ordercommitime) {
		this.ordercommitime = ordercommitime;
	}

	public String getSyncnotify() {
		return syncnotify;
	}

	public void setSyncnotify(String syncnotify) {
		this.syncnotify = syncnotify;
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
