package com.zcbspay.platform.manager.merchant.bean;

import java.io.Serializable;

public class MccListBean implements Serializable{
	
	private static final long serialVersionUID = -7770692787755809217L;
	private String mccList;
	private String mccCont;
	private String mccType;
	private String mccTrade;
	private String industry;
	private String mccClass;
	private String mcc;
	private String status;
	public String getMccList() {
		return mccList;
	}
	public void setMccList(String mccList) {
		this.mccList = mccList;
	}
	public String getMccCont() {
		return mccCont;
	}
	public void setMccCont(String mccCont) {
		this.mccCont = mccCont;
	}
	public String getMccType() {
		return mccType;
	}
	public void setMccType(String mccType) {
		this.mccType = mccType;
	}
	public String getMccTrade() {
		return mccTrade;
	}
	public void setMccTrade(String mccTrade) {
		this.mccTrade = mccTrade;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getMccClass() {
		return mccClass;
	}
	public void setMccClass(String mccClass) {
		this.mccClass = mccClass;
	}
	public String getMcc() {
		return mcc;
	}
	public void setMcc(String mcc) {
		this.mcc = mcc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}

