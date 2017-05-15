package com.zcbspay.platform.manager.merchant.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_HZ_AGENCY_INFO")
public class PojoAgencyInfo implements Serializable {

	private static final long serialVersionUID = 5092702045548250290L;

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
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_t_hz_agency_info_tid") 
	@SequenceGenerator(name="seq_t_hz_agency_info_tid",sequenceName="SEQ_T_HZ_AGENCY_INFO_TID",allocationSize=1)
	@Column(name = "TID")
	public Long gettId() {
		return tId;
	}
	public void settId(Long tId) {
		this.tId = tId;
	}
	@Column(name = "MERCHNO")
	public String getMerchNo() {
		return merchNo;
	}
	public void setMerchNo(String merchNo) {
		this.merchNo = merchNo;
	}
	@Column(name = "BUSICODE")
	public String getBustCode() {
		return bustCode;
	}
	public void setBustCode(String bustCode) {
		this.bustCode = bustCode;
	}
	@Column(name = "CHARGINGUNIT")
	public String getChargingunit() {
		return chargingunit;
	}
	public void setChargingunit(String chargingunit) {
		this.chargingunit = chargingunit;
	}
	@Column(name = "BUSISORT")
	public String getBusiSort() {
		return busiSort;
	}
	public void setBusiSort(String busiSort) {
		this.busiSort = busiSort;
	}
	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name = "INUSER")
	public Long getInUser() {
		return inUser;
	}
	public void setInUser(Long inUser) {
		this.inUser = inUser;
	}
	@Column(name = "INTIME")
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	@Column(name = "NOTES")
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Column(name = "REMARKS")
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
