package com.zcbspay.platform.manager.merchant.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_MERCH_TAX_INVOICE")
public class PojoMerchTaxInvoice implements Serializable {

	private static final long serialVersionUID = -8789693255781294402L;
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
	/** 增值税一般纳税人证明文件
	 * 01 《一般纳税人资格证书》 复印件
	 * 02 加盖“增值税一般纳税人”戳印的《税务登记证》复印件
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
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_t_merch_tax_invoice_tid") 
	@SequenceGenerator(name="seq_t_merch_tax_invoice_tid",sequenceName="SEQ_T_MERCH_TAX_INVOICE_TID",allocationSize=1)
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
	@Column(name = "COMPANYNAME")
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Column(name = "TAXPAYERID")
	public String getTaxPayerId() {
		return taxPayerId;
	}
	public void setTaxPayerId(String taxPayerId) {
		this.taxPayerId = taxPayerId;
	}
	@Column(name = "COMPANYADDRESS")
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	@Column(name = "COMPANYTELNO")
	public String getCompaynTelno() {
		return compaynTelno;
	}
	public void setCompaynTelno(String compaynTelno) {
		this.compaynTelno = compaynTelno;
	}
	@Column(name = "BANKNAME")
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	@Column(name = "ACCOUNTNO")
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	@Column(name = "TAXPAYERTYPE")
	public String getTaxpanyerType() {
		return taxpanyerType;
	}
	public void setTaxpanyerType(String taxpanyerType) {
		this.taxpanyerType = taxpanyerType;
	}
	@Column(name = "INVOICETYPE")
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	@Column(name = "DOCUMENEVIDENCE")
	public String getDocumenEvidence() {
		return documenEvidence;
	}
	public void setDocumenEvidence(String documenEvidence) {
		this.documenEvidence = documenEvidence;
	}
	@Column(name = "CONTACT")
	public String getContAct() {
		return contAct;
	}
	public void setContAct(String contAct) {
		this.contAct = contAct;
	}
	@Column(name = "CONTPHONE")
	public String getContPhone() {
		return contPhone;
	}
	public void setContPhone(String contPhone) {
		this.contPhone = contPhone;
	}
	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
