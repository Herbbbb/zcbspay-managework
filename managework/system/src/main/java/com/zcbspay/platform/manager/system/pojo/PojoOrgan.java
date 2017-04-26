package com.zcbspay.platform.manager.system.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_ORGAN")
public class PojoOrgan implements Serializable {

	private static final long serialVersionUID = -7694145308256317137L;
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

	@Id
	@Column(name = "ORGAN_ID")
	public Long getOrganId() {
		return this.organId;
	}

	public void setOrganId(Long organId) {
		this.organId = organId;
	}

	@Column(name = "ORGAN_CODE")
	public String getOrganCode() {
		return this.organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	@Column(name = "ORGAN_NAME")
	public String getOrganName() {
		return this.organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	@Column(name = "SUPERID")
	public Long getSuperid() {
		return this.superid;
	}

	public void setSuperid(Long superid) {
		this.superid = superid;
	}

	@Column(name = "LEVELID")
	public Byte getLevelid() {
		return this.levelid;
	}

	public void setLevelid(Byte levelid) {
		this.levelid = levelid;
	}

	@Column(name = "PROVINCE")
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "CITY")
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "CREATOR")
	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Column(name = "STATUS")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "NOTES")
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(name = "REMARKS")
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}