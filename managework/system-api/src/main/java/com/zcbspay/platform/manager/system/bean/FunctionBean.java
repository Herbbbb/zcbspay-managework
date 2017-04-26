package com.zcbspay.platform.manager.system.bean;

import java.io.Serializable;
import java.util.List;

public class FunctionBean implements Serializable{

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
	public Long getFunctId() {
		return functId;
	}
	public void setFunctId(Long functId) {
		this.functId = functId;
	}
	public String getFunctName() {
		return functName;
	}
	public void setFunctName(String functName) {
		this.functName = functName;
	}
	public Long getFunctOrder() {
		return functOrder;
	}
	public void setFunctOrder(Long functOrder) {
		this.functOrder = functOrder;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	public Short getLevelId() {
		return levelId;
	}
	public void setLevelId(Short levelId) {
		this.levelId = levelId;
	}
	public String getLeafnode() {
		return leafnode;
	}
	public void setLeafnode(String leafnode) {
		this.leafnode = leafnode;
	}
	public String getSysFlag() {
		return sysFlag;
	}
	public void setSysFlag(String sysFlag) {
		this.sysFlag = sysFlag;
	}
	public Byte getFunctType() {
		return functType;
	}
	public void setFunctType(Byte functType) {
		this.functType = functType;
	}
	public String getIsadmin() {
		return isadmin;
	}
	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}
	public String getMoveSort() {
		return moveSort;
	}
	public void setMoveSort(String moveSort) {
		this.moveSort = moveSort;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private String id;
	private String text;
	private String state;
	private String checked;
	private String checkbox;
	private List<FunctionBean> children;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public String getCheckbox() {
		return checkbox;
	}
	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}
	public List<FunctionBean> getChildren() {
		return children;
	}
	public void setChildren(List<FunctionBean> children) {
		this.children = children;
	}
	
}
