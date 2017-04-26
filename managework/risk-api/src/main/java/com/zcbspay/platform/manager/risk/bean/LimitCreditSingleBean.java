package com.zcbspay.platform.manager.risk.bean;

import java.io.Serializable;

public class LimitCreditSingleBean implements Serializable {

	private static final long serialVersionUID = -5284012382558505915L;

	// Fields
	private Long TId;
	private String caseid;
	private String maxAmount;
	private String minAmount;
	private String cardType;
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

	public String getCaseid() {
		return caseid;
	}

	public void setCaseid(String caseid) {
		this.caseid = caseid;
	}

	public String getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(String maxAmount) {
		this.maxAmount = maxAmount;
	}

	public String getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(String minAmount) {
		this.minAmount = minAmount;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
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
