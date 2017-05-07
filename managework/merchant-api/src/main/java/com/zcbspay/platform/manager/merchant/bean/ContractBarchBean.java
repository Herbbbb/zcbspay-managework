package com.zcbspay.platform.manager.merchant.bean;

import java.util.Date;

public class ContractBarchBean implements java.io.Serializable {
	
	private static final long serialVersionUID = -8795499646799490862L;

	private Long tId;
	/** 批次号 **/
	private String batchNo;
	/** 委托机构号 **/
	private String merchNo;
	/** 批量导入合同总数 **/
	private Long totalCount;
	/** 录入时间 **/
	private Date inTime;
	/** 备注 **/
	private String remarks;
	/** 备注 **/
	private String notes;
	
	
	public Long gettId() {
		return tId;
	}
	public void settId(Long tId) {
		this.tId = tId;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getMerchNo() {
		return merchNo;
	}
	public void setMerchNo(String merchNo) {
		this.merchNo = merchNo;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
