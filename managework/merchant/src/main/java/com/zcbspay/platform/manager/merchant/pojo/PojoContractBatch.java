package com.zcbspay.platform.manager.merchant.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_CONTRACT_BATCH")
public class PojoContractBatch implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	/** 标识 **/
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
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_t_contract_barch_tid") 
	@SequenceGenerator(name="seq_t_contract_barch_tid",sequenceName="SEQ_T_CONTRACT_BATCH_TID",allocationSize=1)
	@Column(name = "TID")
	public Long gettId() {
		return tId;
	}
	public void settId(Long tId) {
		this.tId = tId;
	}
	@Column(name = "BATCHNO")
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	@Column(name = "MERCHNO")
	public String getMerchNo() {
		return merchNo;
	}
	public void setMerchNo(String merchNo) {
		this.merchNo = merchNo;
	}
	@Column(name = "TOTALCOUNT")
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	@Column(name = "INTIME")
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	@Column(name = "REMARKS")
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Column(name = "NOTES")
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
