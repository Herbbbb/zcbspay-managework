package com.zcbspay.platform.manager.trade.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.trade.bean.CollectAndPaymentBean;
import com.zcbspay.platform.manager.trade.dao.CollectBatchDao;

@Repository
public class CollectBatchDaoImpl extends HibernateBaseDAOImpl<String> implements CollectBatchDao {

	@Override
	public Map<String, Object> getBepsCollectBatchByPage(String page, String rows, CollectAndPaymentBean collectBatchBean) {
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
	               "{CALL PCK_T_CNAPS_COLLECT_BATCH_LOG.sel_T_CNAPS_COLLECT_BATCH_LOG(?,?,?,?,?,?)}", columns,
	               paramaters, "cursor0","v_total");
	}

	@Override
	public Map<String, Object> queryDetail(String page, String rows, CollectAndPaymentBean collectBatchBean) {
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
	               "{CALL PCK_T_CNAPS_COLLECT_DETA_LOG.sel_T_CNAPS_COLLECT_DETA_LOG(?,?,?,?,?,?)}", columns,
	               paramaters, "cursor0","v_total");
	}


}
