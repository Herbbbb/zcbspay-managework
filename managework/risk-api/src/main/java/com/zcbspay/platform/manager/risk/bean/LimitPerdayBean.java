package com.zcbspay.platform.manager.risk.bean;

import java.io.Serializable;

public class LimitPerdayBean implements Serializable {
	private static final long serialVersionUID = 4956139830811192300L;
	
	// Fields
	private Long TId;
	private Long caseid;
	private Long nums;
	private String risklevel;
	private String status;
	private String notes;
	private String remarks;
	private String cardtype;
	public Long getTId() {
		return TId;
	}
	public void setTId(Long tId) {
		TId = tId;
	}
	public Long getCaseid() {
		return caseid;
	}
	public void setCaseid(Long caseid) {
		this.caseid = caseid;
	}
	public Long getNums() {
		return nums;
	}
	public void setNums(Long nums) {
		this.nums = nums;
	}
	public String getRisklevel() {
		return risklevel;
	}
	public void setRisklevel(String risklevel) {
		this.risklevel = risklevel;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

}
