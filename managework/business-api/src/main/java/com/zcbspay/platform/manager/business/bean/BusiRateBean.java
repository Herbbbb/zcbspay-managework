package com.zcbspay.platform.manager.business.bean;

/**
 * TBusiRate entity. @author MyEclipse Persistence Tools
 */
public class BusiRateBean implements java.io.Serializable {

	// Fields

	/**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4211613220222800243L;
    private Long tid;
	private String feever;
	private String busicode;
	private String feeRate;
	private String minFee;
	private String maxFee;
	private String rateType;
	private String inuser;
	private String intime;
	private String notes;
	private String remarks;
	// Constructors

	/** default constructor */
	public BusiRateBean() {
	}


	public Long getTid() {
		return this.tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getFeever() {
		return this.feever;
	}

	public void setFeever(String feever) {
		this.feever = feever;
	}

	public String getBusicode() {
		return this.busicode;
	}

	public void setBusicode(String busicode) {
		this.busicode = busicode;
	}

	public String getFeeRate() {
		return this.feeRate;
	}

	public void setFeeRate(String feeRate) {
		this.feeRate = feeRate;
	}

	public String getMinFee() {
		return this.minFee;
	}

	public void setMinFee(String minFee) {
		this.minFee = minFee;
	}

	public String getMaxFee() {
		return this.maxFee;
	}

	public void setMaxFee(String maxFee) {
		this.maxFee = maxFee;
	}

	public String getRateType() {
		return this.rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public String getInuser() {
		return this.inuser;
	}

	public void setInuser(String inuser) {
		this.inuser = inuser;
	}

	public String getIntime() {
		return this.intime;
	}

	public void setIntime(String intime) {
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