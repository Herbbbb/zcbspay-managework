package com.zcbspay.platform.manager.merchant.bean;

import java.util.Date;

public class AgencyInfoBean implements java.io.Serializable {

	private static final long serialVersionUID = -8525909273118824087L;
	/**标示**/
	private Long tId;
	/**委托机构号**/
	private String merchNo;
	/**业务类型 11000001：实时代收；11000002：实时代付；11000003：批量代收；11000004：批量代付**/
	private String bustCode;
	/**付款单位代码-渠道分配**/
	private String chargingunit;
	/**业务种类，渠道分配**/
	private String busiSort;
	/**状态**/
	private String status;
	/**录入人**/
	private Long inUser;
	/**录入时间**/
	private Date inTime;
	/**备注**/
	private String notes;
	/**备注**/
	private String remarks;
	public Long gettId() {
		return tId;
	}
	public void settId(Long tId) {
		this.tId = tId;
	}
	public String getMerchNo() {
		return merchNo;
	}
	public void setMerchNo(String merchNo) {
		this.merchNo = merchNo;
	}
	public String getBustCode() {
		return bustCode;
	}
	public void setBustCode(String bustCode) {
		this.bustCode = bustCode;
	}
	public String getChargingunit() {
		return chargingunit;
	}
	public void setChargingunit(String chargingunit) {
		this.chargingunit = chargingunit;
	}
	public String getBusiSort() {
		return busiSort;
	}
	public void setBusiSort(String busiSort) {
		this.busiSort = busiSort;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getInUser() {
		return inUser;
	}
	public void setInUser(Long inUser) {
		this.inUser = inUser;
	}
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
