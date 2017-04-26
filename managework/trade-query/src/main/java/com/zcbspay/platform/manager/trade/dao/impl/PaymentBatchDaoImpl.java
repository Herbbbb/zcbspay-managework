package com.zcbspay.platform.manager.trade.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.trade.bean.CollectAndPaymentBean;
import com.zcbspay.platform.manager.trade.dao.PaymentBatchDao;

@Repository
public class PaymentBatchDaoImpl extends HibernateBaseDAOImpl<String> implements PaymentBatchDao {

	@Override
	public Map<String, Object> getBepsPaymentBatchByPage(String page, String rows, CollectAndPaymentBean collectBatchBean) {
		String[] columns = new String[]{
				 "v_BATCHNO", 
				 "v_user",
	             "i_no",
	             "i_perno"
	             };
		 
	        Object[] paramaters = new Object[]{
	        		collectBatchBean.getBatchNo(),
	        		collectBatchBean.getUserId(),
	                page, rows};
	        return executePageOracleProcedure(
	               "{CALL PCK_t_cnaps_payment_batch_log.sel_t_cnaps_payment_batch_log(?,?,?,?,?,?)}", columns,
	               paramaters, "cursor0","v_total");
	}

	@Override
	public Map<String, Object> queryPaymentDetail(String page, String rows, CollectAndPaymentBean collectBatchBean) {
		String[] columns = new String[]{
				 "v_BATCHNO", 
				 "v_user",
	             "i_no",
	             "i_perno"
	             };
		 
	        Object[] paramaters = new Object[]{
	        		collectBatchBean.getBatchNo(),
	        		collectBatchBean.getUserId(),
	                page, rows};
	        return executePageOracleProcedure(
	               "{CALL PCK_t_cnaps_payment_deta_log.sel_t_cnaps_payment_deta_log(?,?,?,?,?,?)}", columns,
	               paramaters, "cursor0","v_total");
	}


}
