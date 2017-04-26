package com.zcbspay.platform.manager.merchant.bean;

import java.io.Serializable;
import java.util.Date;

public class MerchRateConfigBean implements Serializable{
	private static final long serialVersionUID = 2902383579038667825L;
	/** 标识 **/
	private Long tId;
	/** 商户号 **/
	private String memberId;
	/** 业务代码 **/
	private String busiCode;
	/** 清算标志,0：不参加清算；1：参加清算；4：参加清算，退还原始手续费；5：参加清算，差额退还原始手续费； **/
	private Long setlflg;
	/** 扣率类型 **/
	private Long rateMethod;
	/** 扣率代码 **/
	private Long rateId;
	/** 写入时间 **/
	private Date inTime;
	/** 写入人 **/
	private Long inUser;
	/** 备注 **/
	private String notes;
	/** 备注 **/
	private String remarks;
	public Long gettId() {
		return tId;
	}
	public void settId(Long tId) {
		this.tId = tId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getBusiCode() {
		return busiCode;
	}
	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}
	public Long getSetlflg() {
		return setlflg;
	}
	public void setSetlflg(Long setlflg) {
		this.setlflg = setlflg;
	}
	public Long getRateMethod() {
		return rateMethod;
	}
	public void setRateMethod(Long rateMethod) {
		this.rateMethod = rateMethod;
	}
	public Long getRateId() {
		return rateId;
	}
	public void setRateId(Long rateId) {
		this.rateId = rateId;
	}
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	public Long getInUser() {
		return inUser;
	}
	public void setInUser(Long inUser) {
		this.inUser = inUser;
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
