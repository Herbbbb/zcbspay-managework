package com.zcbspay.platform.manager.business.bean;

import java.util.Date;

public class NewCardRateBean implements java.io.Serializable {

	// Fields

	/**
     * serialVersionUID
     */
    private static final long serialVersionUID = 6686745495610585285L;
    private Long tid;
    private String rateId;
    private String rateDes;
    
    private Long inuser;
	private Date intime;
	private String notes;
	private String remarks;
    
	private String feeRateD;
	private String minFeeD;
	private String maxFeeD;
	private String rateTypeD;
	
	private String feeRateC;
	private String minFeeC;
	private String maxFeeC;
	private String rateTypeC;
	
	private String feeRateSC;
	private String minFeeSC;
	private String maxFeeSC;
	private String rateTypeSC;
	
	
	// Constructors

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


	public String getFeeRateD() {
		return feeRateD;
	}


	public void setFeeRateD(String feeRateD) {
		this.feeRateD = feeRateD;
	}


	public String getMinFeeD() {
		return minFeeD;
	}


	public void setMinFeeD(String minFeeD) {
		this.minFeeD = minFeeD;
	}


	public String getMaxFeeD() {
		return maxFeeD;
	}


	public void setMaxFeeD(String maxFeeD) {
		this.maxFeeD = maxFeeD;
	}


	public String getRateTypeD() {
		return rateTypeD;
	}


	public void setRateTypeD(String rateTypeD) {
		this.rateTypeD = rateTypeD;
	}


	public String getFeeRateC() {
		return feeRateC;
	}


	public void setFeeRateC(String feeRateC) {
		this.feeRateC = feeRateC;
	}


	public String getMinFeeC() {
		return minFeeC;
	}


	public void setMinFeeC(String minFeeC) {
		this.minFeeC = minFeeC;
	}


	public String getMaxFeeC() {
		return maxFeeC;
	}


	public void setMaxFeeC(String maxFeeC) {
		this.maxFeeC = maxFeeC;
	}


	public String getRateTypeC() {
		return rateTypeC;
	}


	public void setRateTypeC(String rateTypeC) {
		this.rateTypeC = rateTypeC;
	}


	public String getFeeRateSC() {
		return feeRateSC;
	}


	public void setFeeRateSC(String feeRateSC) {
		this.feeRateSC = feeRateSC;
	}


	public String getMinFeeSC() {
		return minFeeSC;
	}


	public void setMinFeeSC(String minFeeSC) {
		this.minFeeSC = minFeeSC;
	}


	public String getMaxFeeSC() {
		return maxFeeSC;
	}


	public void setMaxFeeSC(String maxFeeSC) {
		this.maxFeeSC = maxFeeSC;
	}


	public String getRateTypeSC() {
		return rateTypeSC;
	}


	public void setRateTypeSC(String rateTypeSC) {
		this.rateTypeSC = rateTypeSC;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	/** default constructor */
	public NewCardRateBean() {
	}


	public Long getTid() {
		return this.tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
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