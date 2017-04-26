package com.zcbspay.platform.manager.system.bean;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 
 * 部门bean
 *
 * @author guojia
 * @version
 * @date 2016年12月28日 上午11:43:28
 * @since
 */
public class DeptBean implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8606724232736081549L;
	/**
	 * 部门表示
	 */
	private Long deptId;
	/**
	 * 部门代码
	 */
	private String deptCode;
	/**
	 * 部门名称
	 */
	private String deptName;
	/**
	 * 机构表示
	 */
	private Long organId;
	/**
	 * 创建人
	 */
	private String creator;
	/**
	 * 创建时间
	 */
	private Timestamp crateTime;
	/**
	 * 创建时间
	 */
	private String status;
	private String notes;
	private String remarks;
	
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Long getOrganId() {
		return organId;
	}
	public void setOrganId(Long organId) {
		this.organId = organId;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Timestamp getCrateTime() {
		return crateTime;
	}
	public void setCrateTime(Timestamp crateTime) {
		this.crateTime = crateTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
