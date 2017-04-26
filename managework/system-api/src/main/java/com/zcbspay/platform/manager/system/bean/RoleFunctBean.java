package com.zcbspay.platform.manager.system.bean;

import java.io.Serializable;

public class RoleFunctBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3277150642834311743L;

	private Long roleFunctId;
	private Long roleId;
	private Long functId;
	public Long getRoleFunctId() {
		return roleFunctId;
	}
	public void setRoleFunctId(Long roleFunctId) {
		this.roleFunctId = roleFunctId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getFunctId() {
		return functId;
	}
	public void setFunctId(Long functId) {
		this.functId = functId;
	}
}
