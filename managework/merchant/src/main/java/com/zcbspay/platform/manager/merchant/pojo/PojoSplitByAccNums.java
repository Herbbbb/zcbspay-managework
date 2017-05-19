package com.zcbspay.platform.manager.merchant.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_SPLIT_BY_ACCNUMS")
public class PojoSplitByAccNums implements java.io.Serializable {

	private static final long serialVersionUID = -5774452166190882195L;
	
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
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_t_split_by_accnums_tid") 
	@SequenceGenerator(name="seq_t_split_by_accnums_tid",sequenceName="SEQ_T_SPLIT_BY_ACCNUMS_TID",allocationSize=1)
	@Column(name = "TID")
	public Long gettId() {
		return tId;
	}
	public void settId(Long tId) {
		this.tId = tId;
	}
	@Column(name = "CACODE")
	public String getCaCode() {
		return caCode;
	}
	public void setCaCode(String caCode) {
		this.caCode = caCode;
	}
	@Column(name = "RATE1")
	public Long getRate1() {
		return rate1;
	}
	public void setRate1(Long rate1) {
		this.rate1 = rate1;
	}
	@Column(name = "LIMIT1")
	public Long getLimit1() {
		return limit1;
	}
	public void setLimit1(Long limit1) {
		this.limit1 = limit1;
	}
	@Column(name = "RATE2")
	public Long getRate2() {
		return rate2;
	}
	public void setRate2(Long rate2) {
		this.rate2 = rate2;
	}
	@Column(name = "LIMIT2")
	public Long getLimit2() {
		return limit2;
	}
	public void setLimit2(Long limit2) {
		this.limit2 = limit2;
	}
	@Column(name = "RATE3")
	public Long getRate3() {
		return rate3;
	}
	public void setRate3(Long rate3) {
		this.rate3 = rate3;
	}
	@Column(name = "LIMIT3")
	public Long getLimit3() {
		return limit3;
	}
	public void setLimit3(Long limit3) {
		this.limit3 = limit3;
	}
	@Column(name = "RATE4")
	public Long getRate4() {
		return rate4;
	}
	public void setRate4(Long rate4) {
		this.rate4 = rate4;
	}
	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name = "INTIME")
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	@Column(name = "INUSER")
	public Long getInUser() {
		return inUser;
	}
	public void setInUser(Long inUser) {
		this.inUser = inUser;
	}
	@Column(name = "UPTIME")
	public Date getUpTime() {
		return upTime;
	}
	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}
	@Column(name = "UPUSER")
	public Long getUpUser() {
		return upUser;
	}
	public void setUpUser(Long upUser) {
		this.upUser = upUser;
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
