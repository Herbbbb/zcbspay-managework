package com.zcbspay.platform.manager.risk.bean;

import java.io.Serializable;

public class WhitePanBean implements Serializable {

	private static final long serialVersionUID = 6723279048164192550L;

	// Fields
	private Long TId;
	private String pan;
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

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
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
