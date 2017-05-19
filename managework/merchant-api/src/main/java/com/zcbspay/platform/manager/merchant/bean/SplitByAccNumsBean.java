package com.zcbspay.platform.manager.merchant.bean;

import java.util.Date;

public class SplitByAccNumsBean implements java.io.Serializable {

	private static final long serialVersionUID = 2516413016474603729L;
	/**标识**/
	private Long tId;
	/**代理商代码**/
	private String caCode;
	/**代理商分润比例1（%）**/
	private Long rate1;
	/**分界线-- 100代表 上一区间截止100，下一区间自101开始**/
	private Long limit1;
	/**代理商分润比例2（%）**/
	private Long rate2;
	/**分界线-- 100代表 上一区间截止100，下一区间自101开始**/
	private Long limit2;
	/**代理商分润比例3（%）**/
	private Long rate3;
	/**分界线-- 100代表 上一区间截止100，下一区间自101开始**/
	private Long limit3;
	/**代理商分润比例4（%）**/
	private Long rate4;
	/**状态   00有效，其他无效**/
	private String status;
	/**写入时间**/
	private Date inTime;
	/**写入人**/
	private Long inUser;
	/**更新时间**/
	private Date upTime;
	/**更新人**/
	private Long upUser;
	/**备注**/
	private String notes;
	/**备注**/
	private String remarks;
	public Long gettId() {
		return tId;
	}
	public void settId(Long tId) {
		this.tId = tId;
	}
	public String getCaCode() {
		return caCode;
	}
	public void setCaCode(String caCode) {
		this.caCode = caCode;
	}
	public Long getRate1() {
		return rate1;
	}
	public void setRate1(Long rate1) {
		this.rate1 = rate1;
	}
	public Long getLimit1() {
		return limit1;
	}
	public void setLimit1(Long limit1) {
		this.limit1 = limit1;
	}
	public Long getRate2() {
		return rate2;
	}
	public void setRate2(Long rate2) {
		this.rate2 = rate2;
	}
	public Long getLimit2() {
		return limit2;
	}
	public void setLimit2(Long limit2) {
		this.limit2 = limit2;
	}
	public Long getRate3() {
		return rate3;
	}
	public void setRate3(Long rate3) {
		this.rate3 = rate3;
	}
	public Long getLimit3() {
		return limit3;
	}
	public void setLimit3(Long limit3) {
		this.limit3 = limit3;
	}
	public Long getRate4() {
		return rate4;
	}
	public void setRate4(Long rate4) {
		this.rate4 = rate4;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	public Long getInUser() {
		return inUser;
	}
	public void setInUser(Long inUser) {
		this.inUser = inUser;
	}
	public Date getUpTime() {
		return upTime;
	}
	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}
	public Long getUpUser() {
		return upUser;
	}
	public void setUpUser(Long upUser) {
		this.upUser = upUser;
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
