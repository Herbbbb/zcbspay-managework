package com.zcbspay.platform.manager.merchant.bean;

import java.io.Serializable;
import java.util.Date;

public class CoopInstiBean implements Serializable{

	private static final long serialVersionUID = 3554139575016240805L;
	/**合作机构ID**/
	private Long Id;
	/**机构号**/
	private String instiCode;
	/**机构名称**/
	private String instiName;
	/**状态**/
	private String status;
	/**创建时间**/
	private Date inTime;
	/**创建操作员**/
	private Long inUser;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getInstiCode() {
		return instiCode;
	}
	public void setInstiCode(String instiCode) {
		this.instiCode = instiCode;
	}
	public String getInstiName() {
		return instiName;
	}
	public void setInstiName(String instiName) {
		this.instiName = instiName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	public Long getInUser() {
		return inUser;
	}
	public void setInUser(Long inUser) {
		this.inUser = inUser;
	}
}
