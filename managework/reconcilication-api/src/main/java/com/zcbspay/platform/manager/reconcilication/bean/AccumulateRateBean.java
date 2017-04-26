package com.zcbspay.platform.manager.reconcilication.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * Class Description
 *
 * @author jingxr
 * @version
 * @date 2016年8月19日 上午9:18:57
 * @since
 */
public class AccumulateRateBean implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4070931087501675269L;
    /**标识**/
    private Long tid; 
    /**扣率版本**/    
    private String rateId;
    /**业务代码**/
    private String rateDes;
    /**扣率类型**/
    private String rateType;
    /**备注**/
    private String notes;
    /**操作**/
    private String remarks;
    /**写入人**/
    private Long inuser;
    /**写入时间**/
    private Date intime;
    /**0-日 1-月 2-年**/
    private int accmode;
    /**固定费用**/
    private String servicefee="0"; 
    /**扣率（万分比）**/
    private String feerate;
    /**最低收费额**/
    private String minfee;
    /**最高收费额**/
    private String maxfee;
    /**阶梯1**/
    private String limit1;
    /****/
    private String feerate2;
    /****/
    private String minfee2;
    /****/
    private String maxfee2;
    /**阶梯2**/
    private String limit2;
    /****/
    private String feerate3;
    /****/
    private String minfee3;
    /****/
    private String  maxfee3;
    
   
	public Long getTid() {
		return tid;
	}


	public void setTid(Long tid) {
		this.tid = tid;
	}


	public String getRateId() {
		return rateId;
	}


	public void setRateId(String rateId) {
		this.rateId = rateId;
	}


	public String getRateDes() {
		return rateDes;
	}


	public void setRateDes(String rateDes) {
		this.rateDes = rateDes;
	}


	public String getRateType() {
		return rateType;
	}


	public void setRateType(String rateType) {
		this.rateType = rateType;
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


	public Long getInuser() {
		return inuser;
	}


	public void setInuser(Long inuser) {
		this.inuser = inuser;
	}


	public Date getIntime() {
		return intime;
	}


	public void setIntime(Date intime) {
		this.intime = intime;
	}


	public int getAccmode() {
		return accmode;
	}


	public void setAccmode(int accmode) {
		this.accmode = accmode;
	}


	public String getServicefee() {
		return servicefee;
	}


	public void setServicefee(String servicefee) {
		this.servicefee = servicefee;
	}


	public String getFeerate() {
		return feerate;
	}


	public void setFeerate(String feerate) {
		this.feerate = feerate;
	}


	public String getMinfee() {
		return minfee;
	}


	public void setMinfee(String minfee) {
		this.minfee = minfee;
	}


	public String getMaxfee() {
		return maxfee;
	}


	public void setMaxfee(String maxfee) {
		this.maxfee = maxfee;
	}


	public String getLimit1() {
		return limit1;
	}


	public void setLimit1(String limit1) {
		this.limit1 = limit1;
	}


	public String getFeerate2() {
		return feerate2;
	}


	public void setFeerate2(String feerate2) {
		this.feerate2 = feerate2;
	}


	public String getMinfee2() {
		return minfee2;
	}


	public void setMinfee2(String minfee2) {
		this.minfee2 = minfee2;
	}


	public String getMaxfee2() {
		return maxfee2;
	}


	public void setMaxfee2(String maxfee2) {
		this.maxfee2 = maxfee2;
	}


	public String getLimit2() {
		return limit2;
	}


	public void setLimit2(String limit2) {
		this.limit2 = limit2;
	}


	public String getFeerate3() {
		return feerate3;
	}


	public void setFeerate3(String feerate3) {
		this.feerate3 = feerate3;
	}


	public String getMinfee3() {
		return minfee3;
	}


	public void setMinfee3(String minfee3) {
		this.minfee3 = minfee3;
	}


	public String getMaxfee3() {
		return maxfee3;
	}


	public void setMaxfee3(String maxfee3) {
		this.maxfee3 = maxfee3;
	}


	public AccumulateRateBean() {
        super();
    }

   




 
    
    
    
    
  
     
    

}
