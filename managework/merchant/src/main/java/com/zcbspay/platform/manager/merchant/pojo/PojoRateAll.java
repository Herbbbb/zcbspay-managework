package com.zcbspay.platform.manager.merchant.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_RATE_ALL")
public class PojoRateAll implements Serializable{
	private static final long serialVersionUID = 7011118453539732642L;
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
	
	@Id
	@Column(name = "TID")
	public Long gettId() {
		return tId;
	}
	public void settId(Long tId) {
		this.tId = tId;
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
	@Column(name = "RATE_DESC")
	public String getRateDesc() {
		return rateDesc;
	}
	public void setRateDesc(String rateDesc) {
		this.rateDesc = rateDesc;
	}
	@Column(name = "NOTES")
	public Long getNotes() {
		return notes;
	}
	public void setNotes(Long notes) {
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
