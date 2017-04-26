package com.zcbspay.platform.manager.reconcilication.service;

import com.zcbspay.platform.cnaps.application.bean.ResultBean;
import com.zcbspay.platform.cnaps.application.bean.TotalCheckPaymentBean;

public interface CheckInfoService {
	/**
	 * 测试方法
	 * @author: zhangshd
	 * @return String
	 * @date: 2017年2月28日 上午11:40:08 
	 * @version v1.0
	 */
	public String sayHello();
	
	/**
	 * 查询对账全部信息
	 * @author: zhangshd
	 * @param checkinfoDate
	 * @return String
	 * @date: 2017年2月28日 下午2:57:12 
	 * @version v1.0
	 */
	public ResultBean queryCheckInfoTotal(String checkInfoDate);
	
	/**
	 * 查询对账详细信息
	 * @author: zhangshd
	 * @param caseId
	 * @return ResultBean
	 * @date: 2017年2月28日 下午3:03:27 
	 * @version v1.0
	 */
	public ResultBean queryCheckInfoDetail(TotalCheckPaymentBean totalCheckPaymentBean,String checkDate);
}
