package com.zcbspay.platform.manager.trade.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.trade.bean.BatchPaymentOrderBean;
import com.zcbspay.platform.manager.trade.bean.RealTimePaymentOrderBean;
import com.zcbspay.platform.manager.trade.dao.OrderPaymentDao;

@Repository
public class OrderPaymentDaoImpl extends HibernateBaseDAOImpl<String> implements OrderPaymentDao {

	@Override
	public Map<String, Object> getRealTimePaymentOrderByPage(String page, String rows,
			RealTimePaymentOrderBean realTimePaymentOrderBean) {
		String[] columns = new String[]{
				 "v_merid", 
				 "v_mername",
				 "v_orderid", 
				 "v_stime",
				 "v_etime",
	             "v_tn",
	             "v_status",
	             "v_debtoraccount",
	             "v_creditoraccount",
	             "v_user",
	             "i_no",
	             "i_perno"
	             };
		 
	        Object[] paramaters = new Object[]{
	        		realTimePaymentOrderBean.getMerid(),
	        		realTimePaymentOrderBean.getMername(),
	        		realTimePaymentOrderBean.getOrderid(),
	        		realTimePaymentOrderBean.getStime(),
	        		realTimePaymentOrderBean.getEtime(),
	        		realTimePaymentOrderBean.getTn(),realTimePaymentOrderBean.getStatus(),realTimePaymentOrderBean.getDebtoraccount(),
	        		realTimePaymentOrderBean.getCreditoraccount(),realTimePaymentOrderBean.getUserId(),
	                page, rows};
	        return executePageOracleProcedure(
	               "{CALL PCK_t_order_payment_single.sel_t_order_payment_single(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}", columns,
	               paramaters, "cursor0","v_total");
	}

	@Override
	public Map<String, Object> getBatchPaymentOrderByPage(String page, String rows,
			BatchPaymentOrderBean batchPaymentOrderBean) {
		String[] columns = new String[]{
				"v_batchno",
				 "v_merid", 
				 "v_sdate",
				 "v_edate",
	             "v_user",
	             "i_no",
	             "i_perno"
	             };
		 
	        Object[] paramaters = new Object[]{
	        		batchPaymentOrderBean.getBatchno(),
	        		batchPaymentOrderBean.getMerid(),
	        		batchPaymentOrderBean.getStime(),
	        		batchPaymentOrderBean.getEtime(),
	        		batchPaymentOrderBean.getUserId(),
	                page, rows};
	        return executePageOracleProcedure(
	               "{CALL PCK_t_order_payment_batch.sel_t_order_payment_batch(?,?,?,?,?,?,?,?,?)}", columns,
	               paramaters, "cursor0","v_total");
	}

	@Override
	public Map<String, Object> getPaymentOrderDetaByBatchNo(String page, String rows,
			BatchPaymentOrderBean batchOrderBean) {
		String[] columns = new String[]{
				"v_BATCHNO",
	             "v_user",
	             "i_no",
	             "i_perno"
	             };
		 
	        Object[] paramaters = new Object[]{
	        		batchOrderBean.getBatchno(),
	        		batchOrderBean.getUserId(),
	                page, rows};
	        return executePageOracleProcedure(
	               "{CALL PCK_t_order_payment_deta.sel_t_order_payment_deta(?,?,?,?,?,?)}", columns,
	               paramaters, "cursor0","v_total");
	}

	
}
