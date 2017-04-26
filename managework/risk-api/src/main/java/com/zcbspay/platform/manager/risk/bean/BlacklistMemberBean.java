package com.zcbspay.platform.manager.risk.bean;

import java.io.Serializable;

public class BlacklistMemberBean implements Serializable {

	private static final long serialVersionUID = 4924403586735984172L;

	// Fields
	private Long TId;
	private String memberid;
	private String status;
	private String notes;
	private String remarks;
	private String risklevel;

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

	public String getRisklevel() {
		return risklevel;
	}

	public void setRisklevel(String risklevel) {
		this.risklevel = risklevel;
	}

}
