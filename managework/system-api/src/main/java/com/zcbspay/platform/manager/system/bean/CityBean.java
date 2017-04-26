package com.zcbspay.platform.manager.system.bean;

import java.io.Serializable;


/**
 * 城市
 */
public class CityBean implements Serializable{
	
	private static final long serialVersionUID = -2190886676526765059L;

	private Long CId;
	
	private String CName;
	private String CZcode;
	private String CPcode;
	private Long PId;
	private String CCode;
	
	public Long getCId() {
		return CId;
	}
	public void setCId(Long cId) {
		CId = cId;
	}
	public String getCName() {
		return CName;
	}
	public void setCName(String cName) {
		CName = cName;
	}
	public String getCZcode() {
		return CZcode;
	}
	public void setCZcode(String cZcode) {
		CZcode = cZcode;
	}
	public String getCPcode() {
		return CPcode;
	}
	public void setCPcode(String cPcode) {
		CPcode = cPcode;
	}
	public Long getPId() {
		return PId;
	}
	public void setPId(Long pId) {
		PId = pId;
	}
	public String getCCode() {
		return CCode;
	}
	public void setCCode(String cCode) {
		CCode = cCode;
	}
}
