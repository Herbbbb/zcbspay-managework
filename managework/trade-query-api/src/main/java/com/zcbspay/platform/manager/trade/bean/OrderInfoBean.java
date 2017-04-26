/* 
 * TxnLogBean.java  
 * 
 * version TODO
 *
 * 2015年11月16日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zcbspay.platform.manager.trade.bean;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

/**
 * 交易订单查询bean
 *
 * @author zhangshd
 * @version
 * @date 2017年3月2日 16:09:43
 * @since
 */
public class OrderInfoBean implements Serializable {
	private String orderNo;// 订单号
	private String tn;// 受理订单号
	private String secmemberNo;// 二级商户号
	private String status;// 状态
	private String stime;// 受理订单开始时间
	private String etime;// 受理订单结束时间
	private Long userId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getTn() {
		return tn;
	}
	public void setTn(String tn) {
		this.tn = tn;
	}
	public String getSecmemberNo() {
		return secmemberNo;
	}
	public void setSecmemberNo(String secmemberNo) {
		this.secmemberNo = secmemberNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 public String getStime() {
	    	if (!StringUtils.isBlank(stime)) {
	    		stime=stime.replace("-", "").replace(":", "").replace(" ", "");
	        }
			return stime;
		}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getEtime() {
		if (!StringUtils.isBlank(etime)) {
			etime=etime.replace("-", "").replace(":", "").replace(" ", "");
        }
		return etime;
	}
	public void setEtime(String etime) {
		this.etime = etime;
	}
}
