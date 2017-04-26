package com.zcbspay.platform.manager.system.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TParaDic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_PARA_DIC")
public class PojoParaDic implements java.io.Serializable {

	private static final long serialVersionUID = -4732133832626818557L;
	private Long tid;
	private String paraCode;
	private Long parentId;
	private String paraName;
	private String paraType;
	private Long hasSub;
	private Long status;
	private String remarks;

	@Id
	@Column(name = "TID")
	public Long getTid() {
		return this.tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	@Column(name = "PARA_CODE")
	public String getParaCode() {
		return this.paraCode;
	}

	public void setParaCode(String paraCode) {
		this.paraCode = paraCode;
	}

	@Column(name = "PARENT_ID")
	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Column(name = "PARA_NAME")
	public String getParaName() {
		return this.paraName;
	}

	public void setParaName(String paraName) {
		this.paraName = paraName;
	}

	@Column(name = "PARA_TYPE")
	public String getParaType() {
		return this.paraType;
	}

	public void setParaType(String paraType) {
		this.paraType = paraType;
	}

	@Column(name = "HAS_SUB")
	public Long getHasSub() {
		return this.hasSub;
	}

	public void setHasSub(Long hasSub) {
		this.hasSub = hasSub;
	}

	@Column(name = "STATUS")
	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	@Column(name = "REMARKS")
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}