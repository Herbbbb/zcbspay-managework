package com.zcbspay.platform.manager.merchant.bean;

import java.io.Serializable;

public class RateAllBean implements Serializable{
	private static final long serialVersionUID = 5709447600797309451L;
	/** 标识 **/
	private Long tId;
	/** 扣率类型 **/
	private Long rateMethod;
	/** 扣率代码 **/
	private Long rateId;
	/** 扣率描述 **/
	private String rateDesc;
	/** 备注 **/
	private Long notes;
	/** 备注 **/
	private String remarks;
	public Long gettId() {
		return tId;
	}
	public void settId(Long tId) {
		this.tId = tId;
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
	public String getRateDesc() {
		return rateDesc;
	}
	public void setRateDesc(String rateDesc) {
		this.rateDesc = rateDesc;
	}
	public Long getNotes() {
		return notes;
	}
	public void setNotes(Long notes) {
		this.notes = notes;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
