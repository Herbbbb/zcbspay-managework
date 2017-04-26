package com.zcbspay.platform.manager.system.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_ROLE_FUNCT")
public class PojoRoleFunct implements java.io.Serializable {

	private static final long serialVersionUID = -7837915625814108336L;
	private Long roleFunctId;
	private Long roleId;
	private Long functId;

	
	@Id
	@Column(name = "ROLE_FUNCT_ID")
	public Long getRoleFunctId() {
		return this.roleFunctId;
	}

	public void setRoleFunctId(Long roleFunctId) {
		this.roleFunctId = roleFunctId;
	}

	@Column(name = "ROLE_ID")
	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Column(name = "FUNCT_ID")
	public Long getFunctId() {
		return this.functId;
	}

	public void setFunctId(Long functId) {
		this.functId = functId;
	}

}