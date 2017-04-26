package com.zcbspay.platform.manager.system.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TFunction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_FUNCTION")
public class PojoFunction implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1516562813621074734L;
	private Long functId;
	private String functName;
	private Long functOrder;
	private String parentId;
	private String url;
	private String icon;
	private Byte status;
	private Short levelId;
	private String leafnode;
	private String sysFlag;
	private Byte functType;
	private String isadmin;
	private String moveSort;
	private String notes;
	private String remarks;

	@Id
	@Column(name = "FUNCT_ID")
	public Long getFunctId() {
		return this.functId;
	}

	public void setFunctId(Long functId) {
		this.functId = functId;
	}

	@Column(name = "FUNCT_NAME")
	public String getFunctName() {
		return this.functName;
	}

	public void setFunctName(String functName) {
		this.functName = functName;
	}

	@Column(name = "FUNCT_ORDER")
	public Long getFunctOrder() {
		return this.functOrder;
	}

	public void setFunctOrder(Long functOrder) {
		this.functOrder = functOrder;
	}

	@Column(name = "PARENT_ID")
	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	@Column(name = "URL")
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "ICON")
	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Column(name = "STATUS")
	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	@Column(name = "LEVEL_ID")
	public Short getLevelId() {
		return this.levelId;
	}

	public void setLevelId(Short levelId) {
		this.levelId = levelId;
	}

	@Column(name = "LEAFNODE")
	public String getLeafnode() {
		return this.leafnode;
	}

	public void setLeafnode(String leafnode) {
		this.leafnode = leafnode;
	}

	@Column(name = "SYS_FLAG")
	public String getSysFlag() {
		return this.sysFlag;
	}

	public void setSysFlag(String sysFlag) {
		this.sysFlag = sysFlag;
	}

	@Column(name = "FUNCT_TYPE")
	public Byte getFunctType() {
		return this.functType;
	}

	public void setFunctType(Byte functType) {
		this.functType = functType;
	}

	@Column(name = "ISADMIN")
	public String getIsadmin() {
		return this.isadmin;
	}

	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}

	@Column(name = "MOVE_SORT")
	public String getMoveSort() {
		return this.moveSort;
	}

	public void setMoveSort(String moveSort) {
		this.moveSort = moveSort;
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