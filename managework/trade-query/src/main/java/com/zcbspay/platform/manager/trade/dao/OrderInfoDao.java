package com.zcbspay.platform.manager.trade.dao;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.trade.bean.OrderInfoBean;

public interface OrderInfoDao extends BaseDAO<String> {
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
	

}
