package com.zcbspay.platform.manager.trade.service;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.trade.bean.CnapsLogBean;
import com.zcbspay.platform.manager.trade.bean.CollectAndPaymentBean;
import com.zcbspay.platform.manager.trade.bean.OrderInfoBean;
import com.zcbspay.platform.manager.trade.bean.TxnsLogBean;

public interface TxnsLogService {
	/**
	 * 分页查询交易流水
	 * @author: zhangshd
	 * @param page
	 * @param rows
	 * @param values
	 * @return Map<String,Object>
	 * @date: 2017年3月2日 下午3:56:54 
	 * @version v1.0
	 */
	public Map<String, Object> getTxnsLogByPage(String page, String rows, TxnsLogBean values);
	/**
	 * 获取交易流水详细信息
	 * @author: zhangshd
	 * @param txnseqno
	 * @return List<?>
	 * @date: 2017年3月3日 上午11:05:01 
	 * @version v1.0
	 */
	public List<?> getTxnsLogById(String txnseqno);
	/**
	 * 交易订单分页查询
	 * @author: zhangshd
	 * @return String
	 * @date: 2017年3月2日 下午3:14:43
	 * @version v1.0
	 */
	public Map<String, Object> getOrderInfoByPage(String page, String rows, OrderInfoBean values);
	/**
	 * 获取订单详细信息
	 * @author: zhangshd
	 * @param txnseqno
	 * @return Map<String,Object>
	 * @date: 2017年3月3日 上午11:04:33 
	 * @version v1.0
	 */
	public List<?> getOrderInfoDetail(String id);
	/**
	 * CNAPS核心交易分页查询
	 * @author: zhangshd
	 * @return String
	 * @date: 2017年3月2日 下午3:14:43
	 * @version v1.0
	 */
	public Map<String, Object> getCnapsLogByPage(String page, String rows, CnapsLogBean values);
	/**
	 * BEPS批量代收交易流水查询分页查询
	 * @author: zhangshd
	 * @param values
	 * @param page
	 * @param rows
	 * @param request
	 * @return Map<String,Object>
	 * @date: 2017年3月7日 下午3:38:02 
	 * @version v1.0
	 */
	public Map<String, Object> getBepsCollectBatchByPage(String page, String rows, CollectAndPaymentBean collectBatchBean);
	/**
	 * BEPS批量代收交易流水详细信息分页查询
	 * @author: zhangshd
	 * @param collectBatchBean
	 * @param page
	 * @param rows
	 * @param request
	 * @return Map<String,Object>
	 * @date: 2017年3月7日 下午3:45:49 
	 * @version v1.0
	 */
	public Map<String, Object> queryDetail(String page, String rows, CollectAndPaymentBean collectBatchBean);
	/**
	 * BEPS批量代付交易流水详细信息分页查询
	 * @author: zhangshd
	 * @param collectBatchBean
	 * @param page
	 * @param rows
	 * @param request
	 * @return Map<String,Object>
	 * @date: 2017年3月8日 下午2:39:04 
	 * @version v1.0
	 */
	public Map<String, Object> queryPaymentDetail(String page, String rows, CollectAndPaymentBean collectBatchBean);
	/**
	 * BEPS批量代付交易流水查询分页查询
	 * @author: zhangshd
	 * @param values
	 * @param page
	 * @param rows
	 * @param request
	 * @return Map<String,Object>
	 * @date: 2017年3月7日 下午3:38:02 
	 * @version v1.0
	 */
	public Map<String, Object> getBepsPaymentBatchByPage(String page, String rows,
			CollectAndPaymentBean collectBatchBean);
}
