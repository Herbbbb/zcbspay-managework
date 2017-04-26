package com.zcbspay.platform.manager.merchant.bean;

import java.io.Serializable;
import java.util.Date;
public class ProductBean implements Serializable {
	private static final long serialVersionUID = 760959780835394296L;
	private String prdtver;
	private Long prdtid;
	private String prdtname;
	private String status;
	private Date intime;
	private Long inuser;
	private Date uptime;
	private Long upuser;
	private String notes;
	private String remarks;
	public String getPrdtver() {
		return prdtver;
	}
	public void setPrdtver(String prdtver) {
		this.prdtver = prdtver;
	}
	public Long getPrdtid() {
		return prdtid;
	}
	public void setPrdtid(Long prdtid) {
		this.prdtid = prdtid;
	}
	public String getPrdtname() {
		return prdtname;
	}
	public void setPrdtname(String prdtname) {
		this.prdtname = prdtname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getIntime() {
		return intime;
	}
	public void setIntime(Date intime) {
		this.intime = intime;
	}
	public Long getInuser() {
		return inuser;
	}
	public void setInuser(Long inuser) {
		this.inuser = inuser;
	}
	public Date getUptime() {
		return uptime;
	}
	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}
	public Long getUpuser() {
		return upuser;
	}
	public void setUpuser(Long upuser) {
		this.upuser = upuser;
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