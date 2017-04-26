package com.zcbspay.platform.manager.merchant.bean;

import java.util.Date;

public class ContractBean implements java.io.Serializable {

	private static final long serialVersionUID = -5487305921443738237L;
	/** 标识 **/
	private Long tId;
	/** 合同编号 **/
	private String contractNum;
	/** 商户号 **/
	private String merchNo;
	/** 付款人名称 **/
	private String debName;
	/** 付款人账号 **/
	private String debAccNo;
	/** 付款行行号 **/
	private String debBranchCode;
	/** 收款人名称 **/
	private String credName;
	/** 收款人账号 **/
	private String credAccNo;
	/** 收款行行号 **/
	private String credBranchCode;
	/** 合同收付类型 CT00：代收协议  CT01：代付协议 CT99：代收付协议 **/
	private String contractType;
	/** 单笔金额上限(分)-付款 **/
	private Long debAmoLimit;
	/** 付款累计金额限制类型00 不限 01 按年限次 02 按月限次03 总计限次 **/
	private String debTranLimitType;
	/** 累计金额上限(分) -付款 **/
	private Long debAccyAmoLimit;
	/** 付款次数限制类型  00  不限 01  按年限次 02  按月限次03  总计限次 **/
	private String debTransLimitType;
	/** 付款次数限制 **/
	private Long debTransLimit;
	/** 单笔金额上限(分) -收款 **/
	private Long credAmoLimit;
	/** 收款累计金额限制类型00 不限 01 按年限次 02 按月限次03 总计限次 **/
	private String credTranLimitType;
	/** 累计金额上限(分) -收款 **/
	private Long credAccuAmoLimit;
	/** 收款次数限制类型00 不限 01 按年限次 02 按月限次03 总计限次 **/
	private String credTransLimitType;
	/** 付款次数限制 **/
	private Long credTransLimit;
	/** 签约日期 **/
	private String signDate;
	/** 失效日期 **/
	private String expiryDate;
	/** 00 有效 10 待审 19审核未果 89过期失效99撤销 **/
	private String status;
	/** 记录写入人 **/
	private Long inUser;
	/** 记录写入时间 **/
	private Date inTime;
	/** 初审人 **/
	private Long stexaUser;
	/** 初审时间 **/
	private Date stexaTime;
	/** 初审意见 **/
	private String stexaOpt;
	/** 复核人 **/
	private Long cvlexaUser;
	/** 复核时间**/
	private Date cvlexaTime;
	/** 复核意见 **/
	private String cvlexaOpt;
	/** 注销人 **/
	private Long withdrawUser;
	/** 注销时间 **/
	private String withdrawTime;
	/** 注销原因 **/
	private String withdrawOpt;
	/** 备注 **/
	private String notes;
	/** 备注 **/
	private String remarks;
	/** 附件地址 **/
	private String fileAddress;
	/** 合同注销生效日期 **/
	private String revocationDate;
	/** 批量导入时的文件名称 **/
	private String fileName;
	/** 业务种类代码 **/
	private String proprieTary;
	/** 业务类型代码  **/
	private String categoryPurpose;
	
	public Long gettId() {
		return tId;
	}
	public void settId(Long tId) {
		this.tId = tId;
	}
	public String getContractNum() {
		return contractNum;
	}
	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}
	public String getMerchNo() {
		return merchNo;
	}
	public void setMerchNo(String merchNo) {
		this.merchNo = merchNo;
	}
	public String getDebName() {
		return debName;
	}
	public void setDebName(String debName) {
		this.debName = debName;
	}
	public String getDebAccNo() {
		return debAccNo;
	}
	public void setDebAccNo(String debAccNo) {
		this.debAccNo = debAccNo;
	}
	public String getDebBranchCode() {
		return debBranchCode;
	}
	public void setDebBranchCode(String debBranchCode) {
		this.debBranchCode = debBranchCode;
	}
	public String getCredName() {
		return credName;
	}
	public void setCredName(String credName) {
		this.credName = credName;
	}
	public String getCredAccNo() {
		return credAccNo;
	}
	public void setCredAccNo(String credAccNo) {
		this.credAccNo = credAccNo;
	}
	public String getCredBranchCode() {
		return credBranchCode;
	}
	public void setCredBranchCode(String credBranchCode) {
		this.credBranchCode = credBranchCode;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public Long getDebAmoLimit() {
		return debAmoLimit;
	}
	public void setDebAmoLimit(Long debAmoLimit) {
		this.debAmoLimit = debAmoLimit;
	}
	public String getDebTranLimitType() {
		return debTranLimitType;
	}
	public void setDebTranLimitType(String debTranLimitType) {
		this.debTranLimitType = debTranLimitType;
	}
	public Long getDebAccyAmoLimit() {
		return debAccyAmoLimit;
	}
	public void setDebAccyAmoLimit(Long debAccyAmoLimit) {
		this.debAccyAmoLimit = debAccyAmoLimit;
	}
	public String getDebTransLimitType() {
		return debTransLimitType;
	}
	public void setDebTransLimitType(String debTransLimitType) {
		this.debTransLimitType = debTransLimitType;
	}
	public Long getDebTransLimit() {
		return debTransLimit;
	}
	public void setDebTransLimit(Long debTransLimit) {
		this.debTransLimit = debTransLimit;
	}
	
	public Long getCredAmoLimit() {
		return credAmoLimit;
	}
	public void setCredAmoLimit(Long credAmoLimit) {
		this.credAmoLimit = credAmoLimit;
	}
	public String getCredTranLimitType() {
		return credTranLimitType;
	}
	public void setCredTranLimitType(String credTranLimitType) {
		this.credTranLimitType = credTranLimitType;
	}
	public Long getCredAccuAmoLimit() {
		return credAccuAmoLimit;
	}
	public void setCredAccuAmoLimit(Long credAccuAmoLimit) {
		this.credAccuAmoLimit = credAccuAmoLimit;
	}
	public String getCredTransLimitType() {
		return credTransLimitType;
	}
	public void setCredTransLimitType(String credTransLimitType) {
		this.credTransLimitType = credTransLimitType;
	}
	public Long getCredTransLimit() {
		return credTransLimit;
	}
	public void setCredTransLimit(Long credTransLimit) {
		this.credTransLimit = credTransLimit;
	}
	public String getSignDate() {
		return signDate;
	}
	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
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
	public Long getStexaUser() {
		return stexaUser;
	}
	public void setStexaUser(Long stexaUser) {
		this.stexaUser = stexaUser;
	}
	public Date getStexaTime() {
		return stexaTime;
	}
	public void setStexaTime(Date stexaTime) {
		this.stexaTime = stexaTime;
	}
	public String getStexaOpt() {
		return stexaOpt;
	}
	public void setStexaOpt(String stexaOpt) {
		this.stexaOpt = stexaOpt;
	}
	public Long getCvlexaUser() {
		return cvlexaUser;
	}
	public void setCvlexaUser(Long cvlexaUser) {
		this.cvlexaUser = cvlexaUser;
	}
	public Date getCvlexaTime() {
		return cvlexaTime;
	}
	public void setCvlexaTime(Date cvlexaTime) {
		this.cvlexaTime = cvlexaTime;
	}
	public String getCvlexaOpt() {
		return cvlexaOpt;
	}
	public void setCvlexaOpt(String cvlexaOpt) {
		this.cvlexaOpt = cvlexaOpt;
	}
	public Long getWithdrawUser() {
		return withdrawUser;
	}
	public void setWithdrawUser(Long withdrawUser) {
		this.withdrawUser = withdrawUser;
	}
	public String getWithdrawTime() {
		return withdrawTime;
	}
	public void setWithdrawTime(String withdrawTime) {
		this.withdrawTime = withdrawTime;
	}
	public String getWithdrawOpt() {
		return withdrawOpt;
	}
	public void setWithdrawOpt(String withdrawOpt) {
		this.withdrawOpt = withdrawOpt;
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
	public String getFileAddress() {
		return fileAddress;
	}
	public void setFileAddress(String fileAddress) {
		this.fileAddress = fileAddress;
	}
	public String getRevocationDate() {
		return revocationDate;
	}
	public void setRevocationDate(String revocationDate) {
		this.revocationDate = revocationDate;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getProprieTary() {
		return proprieTary;
	}
	public void setProprieTary(String proprieTary) {
		this.proprieTary = proprieTary;
	}
	public String getCategoryPurpose() {
		return categoryPurpose;
	}
	public void setCategoryPurpose(String categoryPurpose) {
		this.categoryPurpose = categoryPurpose;
	}
}