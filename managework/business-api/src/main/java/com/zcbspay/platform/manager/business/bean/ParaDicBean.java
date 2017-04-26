package com.zcbspay.platform.manager.business.bean;



public class ParaDicBean implements java.io.Serializable {

	// Fields

	private Long tid;
	private String paraCode;
	private Long parentId;
	private String paraName;
	private String paraType;
	private Long hasSub;
	private Long status;
	private String remarks;

	// Constructors

	/** default constructor */
	public ParaDicBean() {
	}

	/** full constructor */
	public ParaDicBean(String paraCode, Long parentId, String paraName,
			String paraType, Long hasSub, Long status, String remarks) {
		this.paraCode = paraCode;
		this.parentId = parentId;
		this.paraName = paraName;
		this.paraType = paraType;
		this.hasSub = hasSub;
		this.status = status;
		this.remarks = remarks;
	}

	public Long getTid() {
		return this.tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getParaCode() {
		return this.paraCode;
	}

	public void setParaCode(String paraCode) {
		this.paraCode = paraCode;
	}

	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParaName() {
		return this.paraName;
	}

	public void setParaName(String paraName) {
		this.paraName = paraName;
	}

	public String getParaType() {
		return this.paraType;
	}

	public void setParaType(String paraType) {
		this.paraType = paraType;
	}

	public Long getHasSub() {
		return this.hasSub;
	}

	public void setHasSub(Long hasSub) {
		this.hasSub = hasSub;
	}

	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
