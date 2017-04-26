package com.zcbspay.platform.manager.system.pojo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_USER_ROLE")
public class PojoUserRole implements java.io.Serializable {
	
	private static final long serialVersionUID = 6522807265194818407L;
	private Long userRoleId;
	private Long userId;
	private Long roleId;

	@Id
	@Column(name = "USER_ROLE_ID")
	public Long getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	@Column(name = "USER_ID")
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "ROLE_ID")
	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}