package com.zcbspay.platform.manager.system.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_USER")
public class PojoUser implements java.io.Serializable {
	
	private static final long serialVersionUID = -585996272237918258L;
	private Long userId;
	private String userCode;
	private String userName;
	private String loginName;
	private String pwd;
	private String pwdValid;
	private Short pwdErrorNumber;
	private Date lastLoginTime;
	private String creator;
	private Date createDate;
	private Long organId;
	private Long deptId;
	private String isadmin;
	private String status;
	private String notes;
	private String remarks;

	@Id
	@Column(name = "USER_ID")
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "USER_CODE")
	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@Column(name = "USER_NAME")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "LOGIN_NAME")
	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column(name = "PWD")
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "PWD_VALID")
	public String getPwdValid() {
		return this.pwdValid;
	}

	public void setPwdValid(String pwdValid) {
		this.pwdValid = pwdValid;
	}

	@Column(name = "PWD_ERROR_NUMBER")
	public Short getPwdErrorNumber() {
		return this.pwdErrorNumber;
	}

	public void setPwdErrorNumber(Short pwdErrorNumber) {
		this.pwdErrorNumber = pwdErrorNumber;
	}

	@Column(name = "LAST_LOGIN_TIME")
	public Date getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Column(name = "CREATOR", length = 32)
	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Column(name = "CREATE_DATE")
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "ORGAN_ID")
	public Long getOrganId() {
		return this.organId;
	}

	public void setOrganId(Long organId) {
		this.organId = organId;
	}

	@Column(name = "DEPT_ID")
	public Long getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	@Column(name = "ISADMIN", length = 1)
	public String getIsadmin() {
		return this.isadmin;
	}

	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}

	@Column(name = "STATUS")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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