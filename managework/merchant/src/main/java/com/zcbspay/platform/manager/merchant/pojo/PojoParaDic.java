package com.zcbspay.platform.manager.merchant.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_PARA_DIC")
public class PojoParaDic implements Serializable{
	private static final long serialVersionUID = 1211015818864019622L;
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
	
	@Id
	@Column(name = "TID")
	public Long gettId() {
		return tId;
	}
	public void settId(Long tId) {
		this.tId = tId;
	}
	@Column(name = "PARA_CODE")
	public String getParaCode() {
		return paraCode;
	}
	public void setParaCode(String paraCode) {
		this.paraCode = paraCode;
	}
	@Column(name = "PARENT_ID")
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	@Column(name = "PARA_NAME")
	public String getParaName() {
		return paraName;
	}
	public void setParaName(String paraName) {
		this.paraName = paraName;
	}
	@Column(name = "PARA_TYPE")
	public Long getParaType() {
		return paraType;
	}
	public void setParaType(Long paraType) {
		this.paraType = paraType;
	}
	@Column(name = "HAS_SUB")
	public Long getHasSub() {
		return hasSub;
	}
	public void setHasSub(Long hasSub) {
		this.hasSub = hasSub;
	}
	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name = "ADDED")
	public String getAdded() {
		return added;
	}
	public void setAdded(String added) {
		this.added = added;
	}
	@Column(name = "REMARKS")
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
