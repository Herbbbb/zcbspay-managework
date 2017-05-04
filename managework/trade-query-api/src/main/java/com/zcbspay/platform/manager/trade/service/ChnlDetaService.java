package com.zcbspay.platform.manager.trade.service;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.trade.bean.ChnCollectBatchBean;
import com.zcbspay.platform.manager.trade.bean.ChnCollectSingleLogBean;
import com.zcbspay.platform.manager.trade.bean.ChnPaymentBatchBean;
import com.zcbspay.platform.manager.trade.bean.ChnPaymentSingleLogBean;

public interface ChnlDetaService {
	/**
	 * 获取所有的交易渠道
	 * 
	 * @author: zhangshd
	 * @return Object
	 * @date: 2017年3月2日 下午3:03:22
	 * @version v1.0
	 */
	public List<?> getAllChannelCodeList();

	/**
	 * 实时代收渠道流水查询
	 * 
	 * @author: 张连海
	 * @param page
	 * @param rows
	 * @param chnCollectSingleLogBean
	 * @return Map<String,Object>
	 * @date: 2017年4月27日
	 * @version v1.0
	 */
	public Map<String, Object> getChnCollectSingleLogByPage(String page, String rows,
			ChnCollectSingleLogBean chnCollectSingleLogBean);

	/**
	 * 实时代付渠道流水查询
	 * 
	 * @author: 张连海
	 * @param page
	 * @param rows
	 * @param chnPaymentSingleLogBean
	 * @return Map<String,Object>
	 * @date: 2017年4月27日
	 * @version v1.0
	 */
	public Map<String, Object> getChnPaymentSingleLogByPage(String page, String rows,
			ChnPaymentSingleLogBean chnPaymentSingleLogBean);

	/**
	 * 批量代收渠道流水查询
	 * 
	 * @author: 张连海
	 * @param page
	 * @param rows
	 * @param chnCollectBatchBean
	 * @return Map<String,Object>
	 * @date: 2017年4月27日
	 * @version v1.0
	 */
	public Map<String, Object> getChnCollectBatchLogByPage(String page, String rows,
			ChnCollectBatchBean chnCollectBatchBean);

	/**
	 * 查询代收批次明细交易信息
	 * 
	 * @author: 张连海
	 * @param chnCollectBatchBean
	 * @param page
	 * @param rows
	 * @return Map<String,Object>
	 * @date: 2017年4月27日
	 * @version v1.0
	 */
	public Map<String, Object> getChnCollectDetaByBatchNo(String page, String rows,
			ChnCollectBatchBean chnCollectBatchBean);

	/**
	 * 批量代付渠道流水查询
	 * 
	 * @author: 张连海
	 * @param page
	 * @param rows
	 * @param chnPaymentBatchBean
	 * @return Map<String,Object>
	 * @date: 2017年4月27日
	 * @version v1.0
	 */
	public Map<String, Object> getChnPaymentBatchLogByPage(String page, String rows,
			ChnPaymentBatchBean chnPaymentBatchBean);

	/**
	 * 查询代付批次明细交易信息
	 * 
	 * @author: 张连海
	 * @param chnPaymentBatchBean
	 * @param page
	 * @param rows
	 * @return Map<String,Object>
	 * @date: 2017年4月27日
	 * @version v1.0
	 */
	public Map<String, Object> getChnPaymentDetaByBatchNo(String page, String rows,
			ChnPaymentBatchBean chnPaymentBatchBean);
}
