package com.zcbspay.platform.manager.system.bean;

import java.io.Serializable;

public class UserFunctBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -62258721124124731L;

	private Long userFunctId;
	private Long userId;
	private Long functId;
	public Long getUserFunctId() {
		return userFunctId;
	}
	public void setUserFunctId(Long userFunctId) {
		this.userFunctId = userFunctId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getFunctId() {
		return functId;
	}
	public void setFunctId(Long functId) {
		this.functId = functId;
	}
}
