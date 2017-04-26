package com.zcbspay.platform.manager.trade.dao;

import java.util.Map;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.trade.bean.CollectAndPaymentBean;

public interface CollectSingleDao extends BaseDAO<String> {

	Map<String, Object> getBepsCollectSingleByPage(String page, String rows, CollectAndPaymentBean collectBatchBean);

}
