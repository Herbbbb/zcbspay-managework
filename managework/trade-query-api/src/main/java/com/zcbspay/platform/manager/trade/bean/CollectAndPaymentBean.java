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

/**
 * 交易订单查询bean
 *
 * @author zhangshd
 * @version
 * @date 2017年3月2日 16:09:43
 * @since
 */
public class CollectAndPaymentBean implements Serializable {
	private Long userId;
	private String batchNo;
	private String msgId;
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
