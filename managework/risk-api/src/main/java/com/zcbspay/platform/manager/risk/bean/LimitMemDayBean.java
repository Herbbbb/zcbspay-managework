package com.zcbspay.platform.manager.risk.bean;

import java.io.Serializable;

public class LimitMemDayBean implements Serializable {
	private static final long serialVersionUID = -1595199416314201788L;

	// Fields
	private Long TId;
	private String memberid;
	private String limitAmount;
	private String limitCount;
	private String risklevel;
	private String status;
	private String notes;
	private String remarks;

	public Long getTId() {
		return TId;
	}

	public void setTId(Long tId) {
		TId = tId;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getLimitAmount() {
		return limitAmount;
	}

	public void setLimitAmount(String limitAmount) {
		this.limitAmount = limitAmount;
	}

	public String getLimitCount() {
		return limitCount;
	}

	public void setLimitCount(String limitCount) {
		this.limitCount = limitCount;
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

}
