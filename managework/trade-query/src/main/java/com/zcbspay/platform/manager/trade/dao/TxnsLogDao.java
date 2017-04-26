package com.zcbspay.platform.manager.trade.dao;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.trade.bean.TxnsLogBean;

public interface TxnsLogDao extends BaseDAO<String> {
	/**
	 * 获取所有的交易渠道
	 * @author: zhangshd
	 * @return List<?>
	 * @date: 2017年3月2日 下午3:04:45 
	 * @version v1.0
	 */
	public List<?> getAllChannelCodeList();
	/**
	 * 分页查询交易流水
	 * @author: zhangshd
	 * @param page
	 * @param rows
	 * @param values
	 * @return Map<String,Object>
	 * @date: 2017年3月2日 下午3:58:16 
	 * @version v1.0
	 */
	public Map<String, Object> getTxnsLogByPage(String page, String rows, TxnsLogBean values);
	/**
	 * 获取交易流水详细信息
	 * @author: zhangshd
	 * @param txnseqno
	 * @return List<?>
	 * @date: 2017年3月3日 上午11:06:02 
	 * @version v1.0
	 */
	public List<?> getTxnsLogById(String txnseqno);

}
