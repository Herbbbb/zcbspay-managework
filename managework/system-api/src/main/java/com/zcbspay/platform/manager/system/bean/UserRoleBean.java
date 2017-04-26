package com.zcbspay.platform.manager.system.bean;

import java.io.Serializable;

public class UserRoleBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4911803932165922368L;
	
	private Long userRoleId;
	private Long userId;
	private Long roleId;
	public Long getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
