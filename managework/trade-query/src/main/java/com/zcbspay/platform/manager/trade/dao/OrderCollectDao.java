package com.zcbspay.platform.manager.trade.dao;

import java.util.Map;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.trade.bean.BatchCollectOrderBean;
import com.zcbspay.platform.manager.trade.bean.RealTimeCollectOrderBean;

public interface OrderCollectDao extends BaseDAO<String> {

	Map<String, Object> getRealTimeCollectOrderByPage(String page, String rows,
			RealTimeCollectOrderBean realTimeCollectOrderBean);

	Map<String, Object> getBatchCollectOrderByPage(String page, String rows,
			BatchCollectOrderBean batchCollectOrderBean);

	Map<String, Object> getCollectOrderDetaByBatchNo(String page, String rows,
			BatchCollectOrderBean batchCollectOrderBean);
	

}
