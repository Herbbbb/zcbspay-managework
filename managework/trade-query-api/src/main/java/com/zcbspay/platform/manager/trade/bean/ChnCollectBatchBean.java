package com.zcbspay.platform.manager.trade.bean;

import java.io.Serializable;

public class ChnCollectBatchBean implements Serializable {

	private static final long serialVersionUID = -3441766524579238538L;

	private String tid;// 标识
	private String batchno;// 批次号
	private String msgtype;// 报文类型
	private String servicetype;// 服务类型
	private String transmitleg;// 发起方代码
	private String receiver;// 接收方代码
	private String transdate;// 本地日期
	private String transtime;// 本地时间
	private String totalqty;// 总笔数
	private String totalamt;// 总金额
	private String rspcode;// 应答码
	private String respmsg;// 应答信息
	private String rspdate;// 业务应答时间
	private String operatorcode;// 操作员代码
	private String origbatchno;// 原始批次号
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

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public String getServicetype() {
		return servicetype;
	}

	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
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

	public String getRspcode() {
		return rspcode;
	}

	public void setRspcode(String rspcode) {
		this.rspcode = rspcode;
	}

	public String getRespmsg() {
		return respmsg;
	}

	public void setRespmsg(String respmsg) {
		this.respmsg = respmsg;
	}

	public String getRspdate() {
		return rspdate;
	}

	public void setRspdate(String rspdate) {
		this.rspdate = rspdate;
	}

	public String getOperatorcode() {
		return operatorcode;
	}

	public void setOperatorcode(String operatorcode) {
		this.operatorcode = operatorcode;
	}

	public String getOrigbatchno() {
		return origbatchno;
	}

	public void setOrigbatchno(String origbatchno) {
		this.origbatchno = origbatchno;
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

}
