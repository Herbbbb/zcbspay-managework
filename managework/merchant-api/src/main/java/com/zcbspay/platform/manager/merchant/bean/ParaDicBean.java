package com.zcbspay.platform.manager.merchant.bean;

import java.io.Serializable;

public class ParaDicBean implements Serializable{
	private static final long serialVersionUID = 1548987349475453596L;
	/** 标识 **/
	private Long tId;
	/** 代码 **/
	private String paraCode;
	/** 父级代码 **/
	private String parentId;
	/** 描述 **/
	private String paraName;
	/** 类型 **/
	private Long paraType;
	/**  **/
	private Long hasSub;
	/** 状态 1 在用 0 停用 **/
	private String status;
	/** 附加值，某些情况下需要用数值 **/
	private String added;
	/** 备注 **/
	private String remarks;
	public Long gettId() {
		return tId;
	}
	public void settId(Long tId) {
		this.tId = tId;
	}
	public String getParaCode() {
		return paraCode;
	}
	public void setParaCode(String paraCode) {
		this.paraCode = paraCode;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getParaName() {
		return paraName;
	}
	public void setParaName(String paraName) {
		this.paraName = paraName;
	}
	public Long getParaType() {
		return paraType;
	}
	public void setParaType(Long paraType) {
		this.paraType = paraType;
	}
	public Long getHasSub() {
		return hasSub;
	}
	public void setHasSub(Long hasSub) {
		this.hasSub = hasSub;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAdded() {
		return added;
	}
	public void setAdded(String added) {
		this.added = added;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
