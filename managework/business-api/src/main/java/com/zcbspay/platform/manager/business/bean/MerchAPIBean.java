package com.zcbspay.platform.manager.business.bean;

/**
 * TBusiRate entity. @author MyEclipse Persistence Tools
 */
public class MerchAPIBean implements java.io.Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 760340700893336577L;

	private String memberid;
	
	private String biztype;
	
	private String txntype;
	
	private String txnsubtype;
	
	private String apiname;
	
	private String status;
	
	private String notes;
	
	private String remarks;
	
	private String userId;
	
	private String tid;
	

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getBiztype() {
		return biztype;
	}

	public void setBiztype(String biztype) {
		this.biztype = biztype;
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

	public String getApiname() {
		return apiname;
	}

	public void setApiname(String apiname) {
		this.apiname = apiname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}