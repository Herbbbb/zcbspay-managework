package com.zcbspay.platform.manager.system.bean;

import java.io.Serializable;

public class ParaDicBean implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3836090274114386325L;
	private Long tid;
	private String paraCode;
	private Long parentId;
	private String paraName;
	private String paraType;
	private Long hasSub;
	private Long status;
	private String remarks;
	public Long getTid() {
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	public String getParaCode() {
		return paraCode;
	}
	public void setParaCode(String paraCode) {
		this.paraCode = paraCode;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getParaName() {
		return paraName;
	}
	public void setParaName(String paraName) {
		this.paraName = paraName;
	}
	public String getParaType() {
		return paraType;
	}
	public void setParaType(String paraType) {
		this.paraType = paraType;
	}
	public Long getHasSub() {
		return hasSub;
	}
	public void setHasSub(Long hasSub) {
		this.hasSub = hasSub;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
