package com.zcbspay.platform.manager.merchant.bean;

public class BustSortType {

	/**业务类型 11000001：实时代收**/
	private String a_bustCode;
	/**业务类型 11000002：实时代付**/
	private String b_bustCode;
	/**业务类型 111000003：批量代收；**/
	private String c_bustCode;
	/**业务类型 11000004：批量代付**/
	private String d_bustCode;
	/**付款单位代码-(实时代收)**/
	private String a_chargingunit;
	/**业务种类-(实时代收)**/
	private String a_busiSort;
	/**付款单位代码-(实时代付)**/
	private String b_chargingunit;
	/**业务种类-(实时代付)**/
	private String b_busiSort;
	/**付款单位代码-(批量代收)**/
	private String c_chargingunit;
	/**业务种类-(批量代收)**/
	private String c_busiSort;
	/**付款单位代码-(批量代付)**/
	private String d_chargingunit;
	/**业务种类-(批量代付)**/
	private String d_busiSort;
	
	public String getA_bustCode() {
		return a_bustCode;
	}
	public void setA_bustCode(String a_bustCode) {
		this.a_bustCode = a_bustCode;
	}
	public String getB_bustCode() {
		return b_bustCode;
	}
	public void setB_bustCode(String b_bustCode) {
		this.b_bustCode = b_bustCode;
	}
	public String getC_bustCode() {
		return c_bustCode;
	}
	public void setC_bustCode(String c_bustCode) {
		this.c_bustCode = c_bustCode;
	}
	public String getD_bustCode() {
		return d_bustCode;
	}
	public void setD_bustCode(String d_bustCode) {
		this.d_bustCode = d_bustCode;
	}
	public String getA_chargingunit() {
		return a_chargingunit;
	}
	public void setA_chargingunit(String a_chargingunit) {
		this.a_chargingunit = a_chargingunit;
	}
	public String getA_busiSort() {
		return a_busiSort;
	}
	public void setA_busiSort(String a_busiSort) {
		this.a_busiSort = a_busiSort;
	}
	public String getB_chargingunit() {
		return b_chargingunit;
	}
	public void setB_chargingunit(String b_chargingunit) {
		this.b_chargingunit = b_chargingunit;
	}
	public String getB_busiSort() {
		return b_busiSort;
	}
	public void setB_busiSort(String b_busiSort) {
		this.b_busiSort = b_busiSort;
	}
	public String getC_chargingunit() {
		return c_chargingunit;
	}
	public void setC_chargingunit(String c_chargingunit) {
		this.c_chargingunit = c_chargingunit;
	}
	public String getC_busiSort() {
		return c_busiSort;
	}
	public void setC_busiSort(String c_busiSort) {
		this.c_busiSort = c_busiSort;
	}
	public String getD_chargingunit() {
		return d_chargingunit;
	}
	public void setD_chargingunit(String d_chargingunit) {
		this.d_chargingunit = d_chargingunit;
	}
	public String getD_busiSort() {
		return d_busiSort;
	}
	public void setD_busiSort(String d_busiSort) {
		this.d_busiSort = d_busiSort;
	}
	
	
}
