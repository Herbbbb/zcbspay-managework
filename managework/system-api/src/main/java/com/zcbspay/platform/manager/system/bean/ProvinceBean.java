package com.zcbspay.platform.manager.system.bean;

import java.io.Serializable;
/**
 *城市名
 */
public class ProvinceBean implements Serializable{

	private static final long serialVersionUID = 2198930296623009826L;
	
	private String PId;
	private String PName;
	private String PCode;
	public String getPId() {
		return PId;
	}
	public void setPId(String PId) {
		this.PId = PId;
	}
	public String getPName() {
		return PName;
	}
	public void setPName(String PName) {
		this.PName = PName;
	}
	public String getPCode() {
		return PCode;
	}
	public void setPCode(String PCode) {
		this.PCode = PCode;
	}
}
