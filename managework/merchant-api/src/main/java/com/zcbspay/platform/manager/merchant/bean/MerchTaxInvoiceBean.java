package com.zcbspay.platform.manager.merchant.bean;

import java.io.Serializable;

public class MerchTaxInvoiceBean implements Serializable {

	private static final long serialVersionUID = -3897704103997873042L;

	/** 标识 **/
	private Long tId;
	/** 委托机构号 **/
	private String merchNo;
	/** 公司注册登记全称 **/
	private String companyName;
	/** 纳税人识别号 **/
	private String taxPayerId;
	/** 公司地址 **/
	private String companyAddress;
	/** 公司电话 **/
	private String compaynTelno;
	/** 开户银行全称 **/
	private String bankName;
	/** 开户银行账号 **/
	private String accountNo;
	/** 贵公司的增值税纳税人类型;01增值税一般纳税人 02增值税小规模纳税人 **/
	private String taxpanyerType;
	/** 可收受的增值税发票类型01增值税普通发票 02增值税专用发票 **/
	private String invoiceType;
	/** 增值税一般纳税人证明文件01《一般纳税人资格证书》 复印件
	 * 02加盖“增值税一般纳税人”戳印的《税务登记证》复印件
	 * 03《五证合一》复印件 
	 * **/
	private String documenEvidence;
	/** 联系人 **/
	private String contAct;
	/** 联系人电话 **/
	private String contPhone;
	/** 状态 **/
	private String status;
	/** 备注 **/
	private String notes;
	/** 备注 **/
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getTaxPayerId() {
		return taxPayerId;
	}
	public void setTaxPayerId(String taxPayerId) {
		this.taxPayerId = taxPayerId;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompaynTelno() {
		return compaynTelno;
	}
	public void setCompaynTelno(String compaynTelno) {
		this.compaynTelno = compaynTelno;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getTaxpanyerType() {
		return taxpanyerType;
	}
	public void setTaxpanyerType(String taxpanyerType) {
		this.taxpanyerType = taxpanyerType;
	}
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getDocumenEvidence() {
		return documenEvidence;
	}
	public void setDocumenEvidence(String documenEvidence) {
		this.documenEvidence = documenEvidence;
	}
	public String getContAct() {
		return contAct;
	}
	public void setContAct(String contAct) {
		this.contAct = contAct;
	}
	public String getContPhone() {
		return contPhone;
	}
	public void setContPhone(String contPhone) {
		this.contPhone = contPhone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
