package com.zcbspay.platform.manager.trade.bean;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

public class BatchPaymentOrderBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4213471451027165898L;
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
	private String batchno;// 批次号
	private String txntime;// 订单发送时间
	private String totalqty;// 总笔数
	private String totalamt;// 总金额
	private String reserved;// 保留域
	private String respcode;// 响应码
	private String respmsg;// 应答信息
	private String status;// 状态
	private String ordercommitime;// 订单提交时间
	private String syncnotify;// 异步通知结果
	private String notes;// 备注
	private String remarks;// 备注
	private Long userId;
	private String etime;
	private String stime;

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

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public String getTxntime() {
		return txntime;
	}

	public void setTxntime(String txntime) {
		this.txntime = txntime;
	}

	public String getTotalqty() {
		return totalqty;
	}

	public void setTotalqty(String totalqty) {
		this.totalqty = totalqty;
	}

	public String getTotalamt() {
		return totalamt;
	}

	public void setTotalamt(String totalamt) {
		this.totalamt = totalamt;
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
}
