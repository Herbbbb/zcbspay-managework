package com.zcbspay.platform.manager.merchant.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_MERCH_RATE_CONFIG")
public class PojoMerchRateConfig implements Serializable{

	private static final long serialVersionUID = 6942010672027751656L;
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
	
	@Id
	@Column(name = "TID")
	public Long gettId() {
		return tId;
	}
	public void settId(Long tId) {
		this.tId = tId;
	}
	@Column(name = "MEMBER_ID")
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	@Column(name = "BUSICODE")
	public String getBusiCode() {
		return busiCode;
	}
	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}
	@Column(name = "SETLFLG")
	public Long getSetlflg() {
		return setlflg;
	}
	public void setSetlflg(Long setlflg) {
		this.setlflg = setlflg;
	}
	@Column(name = "RATE_METHOD")
	public Long getRateMethod() {
		return rateMethod;
	}
	public void setRateMethod(Long rateMethod) {
		this.rateMethod = rateMethod;
	}
	@Column(name = "RATE_ID")
	public Long getRateId() {
		return rateId;
	}
	public void setRateId(Long rateId) {
		this.rateId = rateId;
	}
	@Column(name = "INTIME")
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	@Column(name = "INUSER")
	public Long getInUser() {
		return inUser;
	}
	public void setInUser(Long inUser) {
		this.inUser = inUser;
	}
	@Column(name = "NOTES")
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Column(name = "REMARKS")
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
