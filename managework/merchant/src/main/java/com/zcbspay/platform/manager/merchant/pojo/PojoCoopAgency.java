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
@Table(name = "T_COOP_AGENCY")
public class PojoCoopAgency implements Serializable {

	private static final long serialVersionUID = -3904374208295162886L;

	/** 代理商ID **/
	private Long caId;
	/** 代理商编号 **/
	private String caCode;
	/** 代理商名称 **/
	private String caName;
	/** 代理商获利模式 **/
	private String profitType;
	/** 代理商所在省 **/
	private Long caProvince;
	/** 代理商所在市 **/
	private Long caCity;
	/** 状态:00在用 99停用 **/
	private String status;
	/** 账户(银行账号) **/
	private String caBankAcc;
	/** 银行账户名 **/
	private String caAccName;
	/** 开户行名称 **/
	private String caBank;
	/** 开户行行号 **/
	private String bankCode;
	/** 组织机构代码（扩展用） **/
	private Long organId;
	/** 级别（拓展类用）--暂时只需支持二级代理 **/
	private Long caLevel;
	/** 上级代码（拓展类用） **/
	private String superCode;
	/** 录入人 **/
	private Long inUser;
	/** 录入时间 **/
	private Date inTime;
	/** 备注1 **/
	private String notes;
	/** 备注2 **/
	private String remarks;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_t_coop_agency_tid") 
	@SequenceGenerator(name="seq_t_coop_agency_tid",sequenceName="SEQ_T_COOP_AGENCY_TID",allocationSize=1)
	@Column(name = "CAID")
	public Long getCaId() {
		return caId;
	}
	public void setCaId(Long caId) {
		this.caId = caId;
	}
	@Column(name = "CACODE")
	public String getCaCode() {
		return caCode;
	}
	public void setCaCode(String caCode) {
		this.caCode = caCode;
	}
	@Column(name = "CANAME")
	public String getCaName() {
		return caName;
	}
	public void setCaName(String caName) {
		this.caName = caName;
	}
	@Column(name = "PROFITTYPE")
	public String getProfitType() {
		return profitType;
	}
	public void setProfitType(String profitType) {
		this.profitType = profitType;
	}
	@Column(name = "CAPROVINCE")
	public Long getCaProvince() {
		return caProvince;
	}
	public void setCaProvince(Long caProvince) {
		this.caProvince = caProvince;
	}
	@Column(name = "CACITY")
	public Long getCaCity() {
		return caCity;
	}
	public void setCaCity(Long caCity) {
		this.caCity = caCity;
	}
	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name = "CABANKACC")
	public String getCaBankAcc() {
		return caBankAcc;
	}
	public void setCaBankAcc(String caBankAcc) {
		this.caBankAcc = caBankAcc;
	}
	@Column(name = "CAACCNAME")
	public String getCaAccName() {
		return caAccName;
	}
	public void setCaAccName(String caAccName) {
		this.caAccName = caAccName;
	}
	@Column(name = "CABANK")
	public String getCaBank() {
		return caBank;
	}
	public void setCaBank(String caBank) {
		this.caBank = caBank;
	}
	@Column(name = "BANKCODE")
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	@Column(name = "ORGANID")
	public Long getOrganId() {
		return organId;
	}
	public void setOrganId(Long organId) {
		this.organId = organId;
	}
	@Column(name = "CALEVEL")
	public Long getCaLevel() {
		return caLevel;
	}
	public void setCaLevel(Long caLevel) {
		this.caLevel = caLevel;
	}
	@Column(name = "SUPERCODE")
	public String getSuperCode() {
		return superCode;
	}
	public void setSuperCode(String superCode) {
		this.superCode = superCode;
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
