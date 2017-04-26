package com.zcbspay.platform.manager.system.bean;

import java.io.Serializable;

public class OrganBean implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5659695924098437023L;
	private Long organId;
	private String organCode;
	private String organName;
	private Long superid;
	private Byte levelid;
	private String province;
	private String city;
	private String creator;
	private String status;
	private String notes;
	private String remarks;
	public Long getOrganId() {
		return organId;
	}
	public void setOrganId(Long organId) {
		this.organId = organId;
	}
	public String getOrganCode() {
		return organCode;
	}
	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}
	public String getOrganName() {
		return organName;
	}
	public void setOrganName(String organName) {
		this.organName = organName;
	}
	public Long getSuperid() {
		return superid;
	}
	public void setSuperid(Long superid) {
		this.superid = superid;
	}
	public Byte getLevelid() {
		return levelid;
	}
	public void setLevelid(Byte levelid) {
		this.levelid = levelid;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
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
