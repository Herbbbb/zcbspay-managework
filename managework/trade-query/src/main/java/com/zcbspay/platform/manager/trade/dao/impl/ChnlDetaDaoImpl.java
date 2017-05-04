package com.zcbspay.platform.manager.trade.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.trade.bean.ChnCollectBatchBean;
import com.zcbspay.platform.manager.trade.bean.ChnCollectSingleLogBean;
import com.zcbspay.platform.manager.trade.bean.ChnPaymentBatchBean;
import com.zcbspay.platform.manager.trade.bean.ChnPaymentSingleLogBean;
import com.zcbspay.platform.manager.trade.dao.ChnlDetaDao;

@Repository
public class ChnlDetaDaoImpl extends HibernateBaseDAOImpl<String> implements ChnlDetaDao {


	@Override
	public List<?> getAllChannelCodeList() {
		String sql = "select * from T_CHNL_DETA where STATUS='00'";
		return queryBySQL(sql, null);
	}

	@Override
	public Map<String, Object> getChnCollectSingleLogByPage(String page, String rows,
			ChnCollectSingleLogBean chnCollectSingleLogBean) {
		String[] columns = new String[]{
             "v_transmitleg           ",
             "v_txid                  ",
             "v_stime                 ",
             "v_etime                 ",
             "v_ENDTOENDIDENTIFICATION",
             "v_status                ",
             "v_debtoraccount         ",
             "v_creditoraccount       ",

             "v_user",
             "i_no",
             "i_perno"
             };
		 
	        Object[] paramaters = new Object[]{
	        		chnCollectSingleLogBean.getTransmitleg(),
	        		chnCollectSingleLogBean.getTxid(),
	        		chnCollectSingleLogBean.getStime(),
	        		chnCollectSingleLogBean.getEtime(),
	        		chnCollectSingleLogBean.getEndtoendidentification(),
	        		chnCollectSingleLogBean.getRspstatus(),
	        		chnCollectSingleLogBean.getDebtoraccountno(),
	        		chnCollectSingleLogBean.getCreditoraccountno(),
	        		chnCollectSingleLogBean.getUserId(),
	                page, rows};
	        return executePageOracleProcedure(
	               "{CALL pck_t_chn_collect_single_log.sel_t_chn_collect_single_log(?,?,?,?,?,?,?,?,?,?,?,?,?)}", columns,
	               paramaters, "cursor0","v_total");
	}

	@Override
	public Map<String, Object> getChnPaymentSingleLogByPage(String page, String rows,
			ChnPaymentSingleLogBean chnPaymentSingleLogBean) {
		String[] columns = new String[]{
	             "v_transmitleg           ",
	             "v_txid                  ",
	             "v_stime                 ",
	             "v_etime                 ",
	             "v_ENDTOENDIDENTIFICATION",
	             "v_status                ",
	             "v_debtoraccount         ",
	             "v_creditoraccount       ",

	             "v_user",
	             "i_no",
	             "i_perno"
	             };
			 
		        Object[] paramaters = new Object[]{
		        		chnPaymentSingleLogBean.getTransmitleg(),
		        		chnPaymentSingleLogBean.getTxid(),
		        		chnPaymentSingleLogBean.getStime(),
		        		chnPaymentSingleLogBean.getEtime(),
		        		chnPaymentSingleLogBean.getEndtoendidentification(),
		        		chnPaymentSingleLogBean.getRspstatus(),
		        		chnPaymentSingleLogBean.getDebtoraccountno(),
		        		chnPaymentSingleLogBean.getCreditoraccountno(),
		        		chnPaymentSingleLogBean.getUserId(),
		                page, rows};
		        return executePageOracleProcedure(
		               "{CALL pck_t_chn_payment_single_log.sel_t_chn_payment_single_log(?,?,?,?,?,?,?,?,?,?,?,?,?)}", columns,
		               paramaters, "cursor0","v_total");
	}

	@Override
	public Map<String, Object> getChnCollectBatchLogByPage(String page, String rows,
			ChnCollectBatchBean chnCollectBatchBean) {
		String[] columns = new String[]{
				"v_batchno",
				 "v_transmitleg", 
				 "v_sdate",
				 "v_edate",
	             "v_user",
	             "i_no",
	             "i_perno"
	             };
		 
	        Object[] paramaters = new Object[]{
	        		chnCollectBatchBean.getBatchno(),
	        		chnCollectBatchBean.getTransmitleg(),
	        		chnCollectBatchBean.getStime(),
	        		chnCollectBatchBean.getEtime(),
	        		chnCollectBatchBean.getUserId(),
	                page, rows};
	        return executePageOracleProcedure(
	               "{CALL PCK_t_chn_collect_batch.sel_t_chn_collect_batch(?,?,?,?,?,?,?,?,?)}", columns,
	               paramaters, "cursor0","v_total");
	}

	@Override
	public Map<String, Object> getChnCollectDetaByBatchNo(String page, String rows,
			ChnCollectBatchBean chnCollectBatchBean) {
		String[] columns = new String[]{
				"v_BATCHNO",
	             "v_user",
	             "i_no",
	             "i_perno"
	             };
		 
	        Object[] paramaters = new Object[]{
	        		chnCollectBatchBean.getBatchno(),
	        		chnCollectBatchBean.getUserId(),
	                page, rows};
	        return executePageOracleProcedure(
	               "{CALL pck_t_chn_collect_deta.sel_t_chn_collect_deta(?,?,?,?,?,?)}", columns,
	               paramaters, "cursor0","v_total");
	}

	@Override
	public Map<String, Object> getChnPaymentBatchLogByPage(String page, String rows,
			ChnPaymentBatchBean chnPaymentBatchBean) {
		String[] columns = new String[]{
				"v_batchno",
				 "v_transmitleg", 
				 "v_sdate",
				 "v_edate",
	             "v_user",
	             "i_no",
	             "i_perno"
	             };
		 
	        Object[] paramaters = new Object[]{
	        		chnPaymentBatchBean.getBatchno(),
	        		chnPaymentBatchBean.getTransmitleg(),
	        		chnPaymentBatchBean.getStime(),
	        		chnPaymentBatchBean.getEtime(),
	        		chnPaymentBatchBean.getUserId(),
	                page, rows};
	        return executePageOracleProcedure(
	               "{CALL PCK_t_chn_payment_batch.sel_t_chn_payment_batch(?,?,?,?,?,?,?,?,?)}", columns,
	               paramaters, "cursor0","v_total");
	}

	@Override
	public Map<String, Object> getChnPaymentDetaByBatchNo(String page, String rows,
			ChnPaymentBatchBean chnPaymentBatchBean) {
		String[] columns = new String[]{
				"v_BATCHNO",
	             "v_user",
	             "i_no",
	             "i_perno"
	             };
		 
	        Object[] paramaters = new Object[]{
	        		chnPaymentBatchBean.getBatchno(),
	        		chnPaymentBatchBean.getUserId(),
	                page, rows};
	        return executePageOracleProcedure(
	               "{CALL pck_t_chn_payment_deta.sel_t_chn_payment_deta(?,?,?,?,?,?)}", columns,
	               paramaters, "cursor0","v_total");
	}

}
