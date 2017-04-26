package com.zcbspay.platform.manager.trade.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.trade.bean.CollectAndPaymentBean;
import com.zcbspay.platform.manager.trade.dao.PaymentSingleDao;

@Repository
public class PaymentSingleDaoImpl extends HibernateBaseDAOImpl<String> implements PaymentSingleDao {

	@Override
	public Map<String, Object> getBepsPaymentSingleByPage(String page, String rows,
			CollectAndPaymentBean collectBatchBean) {
		String[] columns = new String[]{
				 "v_MSGID", 
				 "v_user",
	             "i_no",
	             "i_perno"
	             };
		 
	        Object[] paramaters = new Object[]{
	        		collectBatchBean.getMsgId(),
	        		collectBatchBean.getUserId(),
	                page, rows};
	        return executePageOracleProcedure(
	               "{CALL PCK_t_cnaps_payment_single_log.sel_t_cnaps_payment_single_log(?,?,?,?,?,?)}", columns,
	               paramaters, "cursor0","v_total");
	}


}
