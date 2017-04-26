package com.zcbspay.platform.manager.business.bean;

import java.util.Date;

/**
 * TFee entity. @author MyEclipse Persistence Tools
 */
public class FeeBean implements java.io.Serializable {

	// Fields

	private Long feeid;
	private String prdtver;
	private String feever;
	private String feename;
	private String status;
	private Date intime;
	private Long inuser;
	private Date uptime;
	private Long upuser;
	private String initflag;
	private String notes;
	private String remarks;

	// Constructors

	/** default constructor */
	public FeeBean() {
	}

	/** minimal constructor */
	public FeeBean(Long feeid, String feever, String feename, String status) {
		this.feeid = feeid;
		this.feever = feever;
		this.feename = feename;
		this.status = status;
	}

	/** full constructor */
	public FeeBean(Long feeid, String prdtver, String feever, String feename,
			String status, Date intime, Long inuser, Date uptime, Long upuser,
			String initflag, String notes, String remarks) {
		this.feeid = feeid;
		this.prdtver = prdtver;
		this.feever = feever;
		this.feename = feename;
		this.status = status;
		this.intime = intime;
		this.inuser = inuser;
		this.uptime = uptime;
		this.upuser = upuser;
		this.initflag = initflag;
		this.notes = notes;
		this.remarks = remarks;
	}

	// Property accessors
	public Long getFeeid() {
		return this.feeid;
	}

	public void setFeeid(Long feeid) {
		this.feeid = feeid;
	}

	public String getPrdtver() {
		return this.prdtver;
	}

	public void setPrdtver(String prdtver) {
		this.prdtver = prdtver;
	}

	public String getFeever() {
		return this.feever;
	}

	public void setFeever(String feever) {
		this.feever = feever;
	}

	public String getFeename() {
		return this.feename;
	}

	public void setFeename(String feename) {
		this.feename = feename;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getIntime() {
		return this.intime;
	}

	public void setIntime(Date intime) {
		this.intime = intime;
	}

	public Long getInuser() {
		return this.inuser;
	}

	public void setInuser(Long inuser) {
		this.inuser = inuser;
	}

	public Date getUptime() {
		return this.uptime;
	}

	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}

	public Long getUpuser() {
		return this.upuser;
	}

	public void setUpuser(Long upuser) {
		this.upuser = upuser;
	}

	public String getInitflag() {
		return this.initflag;
	}

	public void setInitflag(String initflag) {
		this.initflag = initflag;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}