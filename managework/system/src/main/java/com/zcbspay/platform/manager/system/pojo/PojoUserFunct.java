package com.zcbspay.platform.manager.system.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TUserFunct entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_USER_FUNCT")
public class PojoUserFunct implements java.io.Serializable {

	private static final long serialVersionUID = -7397469521603886068L;
	private Long userFunctId;
	private Long userId;
	private Long functId;

	@Id
	@Column(name = "USER_FUNCT_ID")
	public Long getUserFunctId() {
		return this.userFunctId;
	}

	public void setUserFunctId(Long userFunctId) {
		this.userFunctId = userFunctId;
	}

	@Column(name = "USER_ID")
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "FUNCT_ID")
	public Long getFunctId() {
		return this.functId;
	}

	public void setFunctId(Long functId) {
		this.functId = functId;
	}

}