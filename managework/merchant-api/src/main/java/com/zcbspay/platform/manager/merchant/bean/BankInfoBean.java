package com.zcbspay.platform.manager.merchant.bean;

import java.io.Serializable;

public class BankInfoBean implements Serializable {
	private static final long serialVersionUID = -5956805921038884642L;
	
	/**节点号码**/
	private String bankNode;
	/**清算行号**/
	private String bankCode;
	/**城市代码**/
	private String bankCity;
	/**银行名称**/
	private String bankName;
	/**银行简称**/
	private String bankSname;
	/**地址**/
	private String bankAddress;
	/**状态**/
	private String status;
	/**主银行缩写代码**/
	private String mainBankScode;
	/**主银行银行名称**/
	private String mainBankSname;
	/**级别**/
	private String bankLevel;
	/**父级节点号码**/
	private String parentNode;
	/**备注1**/
	private String notes;
	/**备注2**/
	private String remarks;
	
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
	public String getBankCity() {
		return bankCity;
	}
	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankSname() {
		return bankSname;
	}
	public void setBankSname(String bankSname) {
		this.bankSname = bankSname;
	}
	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMainBankScode() {
		return mainBankScode;
	}
	public void setMainBankScode(String mainBankScode) {
		this.mainBankScode = mainBankScode;
	}
	public String getMainBankSname() {
		return mainBankSname;
	}
	public void setMainBankSname(String mainBankSname) {
		this.mainBankSname = mainBankSname;
	}
	public String getBankLevel() {
		return bankLevel;
	}
	public void setBankLevel(String bankLevel) {
		this.bankLevel = bankLevel;
	}
	public String getParentNode() {
		return parentNode;
	}
	public void setParentNode(String parentNode) {
		this.parentNode = parentNode;
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
