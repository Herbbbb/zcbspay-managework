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
 * 交易查询条件bean 
 *
 * @author zhangshd
 * @version
 * @date 2017年3月2日 16:09:43
 * @since 
 */
public class TxnsLogBean implements Serializable{
    /**交易序列号**/
    private String txnseqno;
    /**业务代码**/
    private String busicode;
    /**业务类型**/
    private String busitype;
    /**转出帐号或卡号**/
    private String pan;
    /**受理订单号**/
    private String accordno;
    /**受理二级商户号**/
    private String accsecmerno;
    /**受理一级商户号**/
    private String accfirmerno;
    /**受理清算日期**/
    private String accsettledate;
    /**支付方交易流水号**/
    private String payrettsnseqno;
    /**中心应答码**/
    private String retcode;
    /**支付类型**/
    private String payType;
    /**支付所属机构**/
    private String payinst;
    /**支付定单号**/
    private String payordno;
    /**受理会员号**/
    private String accmemberid;
    /**转出账户名称**/
    private String pan_name;
    /**原交易序列号**/
    private String txnseqno_og;
    
    
    private String stime;
    
    private String etime;
    
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

	public String getBusitype() {
        return busitype;
    }

    public void setBusitype(String busitype) {
        this.busitype = busitype;
    }

    public String getTxnseqno_og() {
        return txnseqno_og;
    }

    public void setTxnseqno_og(String txnseqno_og) {
        this.txnseqno_og = txnseqno_og;
    }

    public String getPan_name() {
        return pan_name;
    }

    public void setPan_name(String pan_name) {
        this.pan_name = pan_name;
    }

    public String getAccmemberid() {
        return accmemberid;
    }

    public void setAccmemberid(String accmemberid) {
        this.accmemberid = accmemberid;
    }

    public String getPayordno() {
        return payordno;
    }

    public void setPayordno(String payordno) {
        this.payordno = payordno;
    }

    public String getPayinst() {
        return payinst;
    }

    public void setPayinst(String payinst) {
        this.payinst = payinst;
    }

    private Long userId;
   
    
    

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getTxnseqno() {
        return txnseqno;
    }

    public void setTxnseqno(String txnseqno) {
        this.txnseqno = txnseqno;
    }

    public String getBusicode() {
        return busicode;
    }

    public void setBusicode(String busicode) {
        this.busicode = busicode;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getAccordno() {
        return accordno;
    }

    public void setAccordno(String accordno) {
        this.accordno = accordno;
    }

    public String getAccsecmerno() {
        return accsecmerno;
    }

    public void setAccsecmerno(String accsecmerno) {
        this.accsecmerno = accsecmerno;
    }

    public String getAccfirmerno() {
        return accfirmerno;
    }

    public void setAccfirmerno(String accfirmerno) {
        this.accfirmerno = accfirmerno;
    }

    public String getAccsettledate() {
    	if (!StringUtils.isBlank(accsettledate)) {
    		accsettledate=accsettledate.replace("-", "");
        }
        return accsettledate;
    }

    public void setAccsettledate(String accsettledate) {
        this.accsettledate = accsettledate;
    }

    public String getPayrettsnseqno() {
        return payrettsnseqno;
    }

    public void setPayrettsnseqno(String payrettsnseqno) {
        this.payrettsnseqno = payrettsnseqno;
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    
    
}
