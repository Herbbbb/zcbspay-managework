package com.zcbspay.platform.manager.merchant.bean;

import java.io.Serializable;

public class MerchBankAccoutBean implements Serializable{
	
	private static final long serialVersionUID = 6141172251172114476L;

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
	public long gettId() {
		return tId;
	}
	public void settId(long tId) {
		this.tId = tId;
	}
	public String getMerchNo() {
		return merchNo;
	}
	public void setMerchNo(String merchNo) {
		this.merchNo = merchNo;
	}
	public String getBankNode() {
		return bankNode;
	}
	public void setBankNode(String bankNode) {
		this.bankNode = bankNode;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getAccoutNo() {
		return accoutNo;
	}
	public void setAccoutNo(String accoutNo) {
		this.accoutNo = accoutNo;
	}
	public String getAccoutName() {
		return accoutName;
	}
	public void setAccoutName(String accoutName) {
		this.accoutName = accoutName;
	}
	public String getProtocoltype() {
		return protocoltype;
	}
	public void setProtocoltype(String protocoltype) {
		this.protocoltype = protocoltype;
	}
	public String getBankProvince() {
		return bankProvince;
	}
	public void setBankProvince(String bankProvince) {
		this.bankProvince = bankProvince;
	}
	public String getBankCity() {
		return bankCity;
	}
	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}
	public String getChannelCode() {
		return channelCode;
	}
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
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
