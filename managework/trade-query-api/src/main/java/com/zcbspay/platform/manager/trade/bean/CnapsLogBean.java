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
public class CnapsLogBean implements Serializable {
	private Long userId;
	private String msgId;
	private String msgType;
	private String createDate;
	private String stime;// 受理订单开始时间
	private String etime;// 受理订单结束时间

	public String getStime() {
		if (!StringUtils.isBlank(stime)) {
			stime = stime.replace("-", "").replace(":", "").replace(" ", "");
		}
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getEtime() {
		if (!StringUtils.isBlank(etime)) {
			etime = etime.replace("-", "").replace(":", "").replace(" ", "");
		}
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
