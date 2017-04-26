package com.zcbspay.platform.manager.trade.dao;

import java.util.Map;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.trade.bean.BatchPaymentOrderBean;
import com.zcbspay.platform.manager.trade.bean.RealTimePaymentOrderBean;

public interface OrderPaymentDao extends BaseDAO<String> {

	Map<String, Object> getRealTimePaymentOrderByPage(String page, String rows,
			RealTimePaymentOrderBean realTimePaymentOrderBean);

	Map<String, Object> getBatchPaymentOrderByPage(String page, String rows,
			BatchPaymentOrderBean batchPaymentOrderBean);

	Map<String, Object> getPaymentOrderDetaByBatchNo(String page, String rows,
			BatchPaymentOrderBean batchCollectOrderBean);
	

}
