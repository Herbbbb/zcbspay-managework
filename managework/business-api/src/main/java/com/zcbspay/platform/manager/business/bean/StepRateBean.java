package com.zcbspay.platform.manager.business.bean;

import java.util.Date;

/**
 * TStepRate entity. @author MyEclipse Persistence Tools
 */
public class StepRateBean implements java.io.Serializable {

    // Fields

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -2950010758485850483L;
    private Long tid;
    private String rateId;
    

	private String rateDes;
    private String rateType;
    private Long servicefee=0L;
    
    private Long inuser;
    private Date intime;
    private String notes;
    private String remarks;
    
    private String feeRate;
    private String minFee;
    private String maxFee;
    private String limit1;
    private String feeRate2;
    private String minFee2;
    private String maxFee2;
    private String limit2;
    private String feeRate3;
    private String minFee3;
    private String maxFee3;
    


    // Constructors

    public String getFeeRate() {
		return feeRate;
	}
	public void setFeeRate(String feeRate) {
		this.feeRate = feeRate;
	}
	public String getMinFee() {
		return minFee;
	}
	public void setMinFee(String minFee) {
		this.minFee = minFee;
	}
	public String getMaxFee() {
		return maxFee;
	}
	public void setMaxFee(String maxFee) {
		this.maxFee = maxFee;
	}
	public String getLimit1() {
		return limit1;
	}
	public void setLimit1(String limit1) {
		this.limit1 = limit1;
	}
	public String getFeeRate2() {
		return feeRate2;
	}
	public void setFeeRate2(String feeRate2) {
		this.feeRate2 = feeRate2;
	}
	public String getMinFee2() {
		return minFee2;
	}
	public void setMinFee2(String minFee2) {
		this.minFee2 = minFee2;
	}
	public String getMaxFee2() {
		return maxFee2;
	}
	public void setMaxFee2(String maxFee2) {
		this.maxFee2 = maxFee2;
	}
	public String getLimit2() {
		return limit2;
	}
	public void setLimit2(String limit2) {
		this.limit2 = limit2;
	}
	public String getFeeRate3() {
		return feeRate3;
	}
	public void setFeeRate3(String feeRate3) {
		this.feeRate3 = feeRate3;
	}
	public String getMinFee3() {
		return minFee3;
	}
	public void setMinFee3(String minFee3) {
		this.minFee3 = minFee3;
	}
	public String getMaxFee3() {
		return maxFee3;
	}
	public void setMaxFee3(String maxFee3) {
		this.maxFee3 = maxFee3;
	}
	/** default constructor */
    public StepRateBean() {
    }
    public String getRateId() {
		return rateId;
	}
	public void setRateId(String typeId) {
		this.rateId = typeId;
	}
	public String getRateDes() {
		return rateDes;
	}
	public void setRateDes(String typeDes) {
		this.rateDes = typeDes;
	}
    // Property accessors
    public Long getTid() {
        return this.tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }


    public String getRateType() {
        return this.rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public Long getServicefee() {
        return this.servicefee;
    }

    public void setServicefee(Long servicefee) {
        this.servicefee = servicefee;
    }

    

    public Long getInuser() {
        return this.inuser;
    }

    public void setInuser(Long inuser) {
        this.inuser = inuser;
    }

    public Date getIntime() {
        return this.intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}