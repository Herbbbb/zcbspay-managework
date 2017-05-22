package com.zcbspay.platform.manager.merchant.bean;

import java.io.Serializable;
import java.util.Date;

public class MerchDetaApplyBean implements Serializable{
	private static final long serialVersionUID = 6022044819280354473L;
	/**主键**/
    private Long selfId;
    /**在用会员表主键**/
    private Long merchId;
    /**会员外键**/
    private Long memId;
    /**会员号**/
    private String memberId;
    /**上级商户**/
    private String parent;
    /**清算周期**/
    private Long setlCycle;
    /**清算类型**/
    private String  setlType;
    /**结算行号**/
    private String bankCode;
    /**开户行号**/
    private String bankNode;
    /**开户账号**/
    private String accNum;
    /**开户名**/
    private String accName;
    /**服务费**/
    private String charge;
    /**保证金**/
    private String deposit;
    /**合约开始日期**/
    private String agreemtStart;
    /**合约终止日期**/
    private String agreemtEnd;
    /**产品代码**/
    private String prdtVer;
    /**扣率版本**/
    private String feeVer;
    /**分润版本**/
    private String spiltVer;
    /**风控版本**/
    private String riskVer;
    /**路由版本**/
    private String routVer;
    /**状态**/
    private String merchStatus;
    /**写入人**/
    private Long mInUser;
    /**写入时间**/
    private Date mInTime;
    /**初审人**/
    private Long stexaUser;
    /**初审时间**/
    private Date stexaTime;
    /**初审意见**/
    private String stexaOpt;
    /**复核人**/
    private Long cvlexaUser;
    /**复核时间**/
    private Date cvlexaTime;
    /**复核意见**/
    private String cvlexaOpt;
    /**备注**/
    private String notes;
    /**备注**/
    private String remarks;
//    /**门户用户激活状态**/
//    private long memApplyId;
    /**付款卡清算行号**/
    private String payBankCode;
    /**付款卡开户行号**/
    private String payBankNode;
    /**付款卡开户账号**/
    private String payAccNum;
    /**付款卡开户名**/
    private String payAccName;
    /**会员类型，01-个人，02-企业，03-委托机构**/
    private String memberType;
    /**收费单位代码**/
    private String chargingunit;
    /**机构代码（发送方、接收方）**/
    private String instCode;
    
	public Long getSelfId() {
		return selfId;
	}
	public void setSelfId(Long selfId) {
		this.selfId = selfId;
	}
	public Long getMerchId() {
		return merchId;
	}
	public void setMerchId(Long merchId) {
		this.merchId = merchId;
	}
	public Long getMemId() {
		return memId;
	}
	public void setMemId(Long memId) {
		this.memId = memId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public Long getSetlCycle() {
		return setlCycle;
	}
	public void setSetlCycle(Long setlCycle) {
		this.setlCycle = setlCycle;
	}
	public String getSetlType() {
		return setlType;
	}
	public void setSetlType(String setlType) {
		this.setlType = setlType;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankNode() {
		return bankNode;
	}
	public void setBankNode(String bankNode) {
		this.bankNode = bankNode;
	}
	public String getAccNum() {
		return accNum;
	}
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getAgreemtStart() {
		return agreemtStart;
	}
	public void setAgreemtStart(String agreemtStart) {
		this.agreemtStart = agreemtStart;
	}
	public String getAgreemtEnd() {
		return agreemtEnd;
	}
	public void setAgreemtEnd(String agreemtEnd) {
		this.agreemtEnd = agreemtEnd;
	}
	public String getPrdtVer() {
		return prdtVer;
	}
	public void setPrdtVer(String prdtVer) {
		this.prdtVer = prdtVer;
	}
	public String getFeeVer() {
		return feeVer;
	}
	public void setFeeVer(String feeVer) {
		this.feeVer = feeVer;
	}
	public String getSpiltVer() {
		return spiltVer;
	}
	public void setSpiltVer(String spiltVer) {
		this.spiltVer = spiltVer;
	}
	public String getRiskVer() {
		return riskVer;
	}
	public void setRiskVer(String riskVer) {
		this.riskVer = riskVer;
	}
	public String getRoutVer() {
		return routVer;
	}
	public void setRoutVer(String routVer) {
		this.routVer = routVer;
	}
	public String getMerchStatus() {
		return merchStatus;
	}
	public void setMerchStatus(String merchStatus) {
		this.merchStatus = merchStatus;
	}
	public Long getmInUser() {
		return mInUser;
	}
	public void setmInUser(Long mInUser) {
		this.mInUser = mInUser;
	}
	public Date getmInTime() {
		return mInTime;
	}
	public void setmInTime(Date mInTime) {
		this.mInTime = mInTime;
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
//	public long getMemApplyId() {
//		return memApplyId;
//	}
//	public void setMemApplyId(long memApplyId) {
//		this.memApplyId = memApplyId;
//	}
	public String getPayBankCode() {
		return payBankCode;
	}
	public void setPayBankCode(String payBankCode) {
		this.payBankCode = payBankCode;
	}
	public String getPayBankNode() {
		return payBankNode;
	}
	public void setPayBankNode(String payBankNode) {
		this.payBankNode = payBankNode;
	}
	public String getPayAccNum() {
		return payAccNum;
	}
	public void setPayAccNum(String payAccNum) {
		this.payAccNum = payAccNum;
	}
	public String getPayAccName() {
		return payAccName;
	}
	public void setPayAccName(String payAccName) {
		this.payAccName = payAccName;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public String getChargingunit() {
		return chargingunit;
	}
	public void setChargingunit(String chargingunit) {
		this.chargingunit = chargingunit;
	}
	public String getInstCode() {
		return instCode;
	}
	public void setInstCode(String instCode) {
		this.instCode = instCode;
	}
    
}
