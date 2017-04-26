package com.zcbspay.platform.manager.trade.dao;

import java.util.Map;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.trade.bean.CollectAndPaymentBean;

public interface PaymentSingleDao extends BaseDAO<String> {

	Map<String, Object> getBepsPaymentSingleByPage(String page, String rows, CollectAndPaymentBean collectBatchBean);
}
