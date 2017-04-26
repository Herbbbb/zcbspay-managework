package com.zcbspay.platform.manager.merchant.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_MERCH_BANK_ACCOUNT")
public class PojoMerchBankAccout implements Serializable{

	private static final long serialVersionUID = -6141072919269100403L;
	/**标示**/
	private long tId;
	/**商户号**/
	private String merchNo;
	/**支行行号**/
	private String bankNode;
	/**清算行号**/
	private String bankCode;
	/**账号**/
	private String accoutNo;
	/**账户名称**/
	private String accoutName;
	/**协议类型**/
	private String protocoltype;
	/**所属省**/
	private String bankProvince;
	/**所属市**/
	private String bankCity;
	/**渠道代码**/
	private String channelCode;
	/**状态 00:正常**/
	private String status;
	/**备注**/
	private String notes;
	/**备注**/
	private String remarks;
	
	@Id
	@Column(name = "TID")
	public long gettId() {
		return tId;
	}
	public void settId(long tId) {
		this.tId = tId;
	}
	@Column(name = "MERCHNO")
	public String getMerchNo() {
		return merchNo;
	}
	public void setMerchNo(String merchNo) {
		this.merchNo = merchNo;
	}
	@Column(name = "BANKNODE")
	public String getBankNode() {
		return bankNode;
	}
	public void setBankNode(String bankNode) {
		this.bankNode = bankNode;
	}
	@Column(name = "BANKCODE")
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	@Column(name = "ACCOUNTNO")
	public String getAccoutNo() {
		return accoutNo;
	}
	public void setAccoutNo(String accoutNo) {
		this.accoutNo = accoutNo;
	}
	@Column(name = "ACCOUNTNAME")
	public String getAccoutName() {
		return accoutName;
	}
	public void setAccoutName(String accoutName) {
		this.accoutName = accoutName;
	}
	@Column(name = "PROTOCOLTYPE")
	public String getProtocoltype() {
		return protocoltype;
	}
	public void setProtocoltype(String protocoltype) {
		this.protocoltype = protocoltype;
	}
	@Column(name = "BANKPROVINCE")
	public String getBankProvince() {
		return bankProvince;
	}
	public void setBankProvince(String bankProvince) {
		this.bankProvince = bankProvince;
	}
	@Column(name = "BANKCITY")
	public String getBankCity() {
		return bankCity;
	}
	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}
	@Column(name = "CHANNELCODE")
	public String getChannelCode() {
		return channelCode;
	}
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
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
