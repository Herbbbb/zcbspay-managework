package com.zcbspay.platform.manager.trade.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.trade.bean.BatchCollectOrderBean;
import com.zcbspay.platform.manager.trade.bean.RealTimeCollectOrderBean;
import com.zcbspay.platform.manager.trade.dao.OrderCollectDao;

@Repository
public class OrderCollectDaoImpl extends HibernateBaseDAOImpl<String> implements OrderCollectDao {

	@Override
	public Map<String, Object> getRealTimeCollectOrderByPage(String page, String rows,
			RealTimeCollectOrderBean realTimeCollectOrderBean) {
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
	                realTimeCollectOrderBean.getMerid(),
	                realTimeCollectOrderBean.getMername(),
	                realTimeCollectOrderBean.getOrderid(),
	                realTimeCollectOrderBean.getStime(),
	                realTimeCollectOrderBean.getEtime(),
	                realTimeCollectOrderBean.getTn(),realTimeCollectOrderBean.getStatus(),realTimeCollectOrderBean.getDebtoraccount(),
	                realTimeCollectOrderBean.getCreditoraccount(),realTimeCollectOrderBean.getUserId(),
	                page, rows};
	        return executePageOracleProcedure(
	               "{CALL PCK_t_order_payment_single.sel_t_order_payment_single(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}", columns,
	               paramaters, "cursor0","v_total");
	}

	@Override
	public Map<String, Object> getBatchCollectOrderByPage(String page, String rows,
			BatchCollectOrderBean batchCollectOrderBean) {
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
	        		batchCollectOrderBean.getBatchno(),
	        		batchCollectOrderBean.getMerid(),
	        		batchCollectOrderBean.getStime(),
	        		batchCollectOrderBean.getEtime(),
	        		batchCollectOrderBean.getUserId(),
	                page, rows};
	        return executePageOracleProcedure(
	               "{CALL PCK_t_order_collect_batch.sel_t_order_collect_batch(?,?,?,?,?,?,?,?,?)}", columns,
	               paramaters, "cursor0","v_total");
	}

	@Override
	public Map<String, Object> getCollectOrderDetaByBatchNo(String page, String rows,
			BatchCollectOrderBean batchCollectOrderBean) {
		String[] columns = new String[]{
				"v_BATCHNO",
	             "v_user",
	             "i_no",
	             "i_perno"
	             };
		 
	        Object[] paramaters = new Object[]{
	        		batchCollectOrderBean.getBatchno(),
	        		batchCollectOrderBean.getUserId(),
	                page, rows};
	        return executePageOracleProcedure(
	               "{CALL PCK_t_order_collect_deta.sel_t_order_collect_deta(?,?,?,?,?,?)}", columns,
	               paramaters, "cursor0","v_total");
	}

	
}
