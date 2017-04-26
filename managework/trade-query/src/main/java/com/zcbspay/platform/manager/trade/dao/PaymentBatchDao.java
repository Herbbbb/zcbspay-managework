package com.zcbspay.platform.manager.trade.dao;

import java.util.Map;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.trade.bean.CollectAndPaymentBean;

public interface PaymentBatchDao extends BaseDAO<String> {
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
	Map<String, Object> getBepsPaymentBatchByPage(String page, String rows, CollectAndPaymentBean collectBatchBean);
	/**
	 * BEPS批量代付交易流水详细信息分页查询
	 * @author: zhangshd
	 * @param collectBatchBean
	 * @param page
	 * @param rows
	 * @param request
	 * @return Map<String,Object>
	 * @date: 2017年3月7日 下午3:45:49 
	 * @version v1.0
	 */
	Map<String, Object> queryPaymentDetail(String page, String rows, CollectAndPaymentBean collectBatchBean);

}
