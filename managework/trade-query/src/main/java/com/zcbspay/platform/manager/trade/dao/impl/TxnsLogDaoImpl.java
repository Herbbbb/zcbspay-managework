package com.zcbspay.platform.manager.trade.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.trade.bean.TxnsLogBean;
import com.zcbspay.platform.manager.trade.dao.TxnsLogDao;

@Repository
public class TxnsLogDaoImpl extends HibernateBaseDAOImpl<String> implements TxnsLogDao {

	@Override
	public List<?> getAllChannelCodeList() {
		String sql = "select * from T_CHNL_DETA where STATUS='00'";
		return queryBySQL(sql, null);
	}

	@Override
	public Map<String, Object> getTxnsLogByPage(String page, String rows, TxnsLogBean variables) {
		 String[] columns = new String[]{
				 "v_txnseqno", 
				 "v_busicode",
				 "v_pan",
				 "v_accordno", 
				 "v_accsecmerno",
				 "v_payrettsnseqno",
				 "v_retcode",
				 "v_accsettledate",
				 "v_PAYORDNO",
				 "v_accfirmerno",
	             "v_payinst",
				 "v_accmemberid",
	             "v_stime", 
	             "v_etime",
	             "v_user",
	             "i_no",
	             "i_perno"
	             };
		 
	        Object[] paramaters = new Object[]{
	                variables.getTxnseqno(),//
	                variables.getBusicode(),//
	                variables.getPan(),//
	                variables.getAccordno(),//
	                variables.getAccsecmerno(),
	                variables.getPayrettsnseqno(),//
	                variables.getRetcode(),//
	                variables.getAccsettledate(),//
	                variables.getPayordno(),
	                variables.getAccfirmerno(),//
	                variables.getPayinst(),
	                variables.getAccmemberid(),
	                variables.getStime(),//
	                variables.getEtime(),//
	                variables.getUserId(), //
	                page, rows};
	        return executePageOracleProcedure(
	               "{CALL PCK_SEL_T_TXNS_LOG.sel_txns_log(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}", columns,
	               paramaters, "cursor0","v_total");
	}

	@Override
	public List<?> getTxnsLogById(String txnseqno) {
		String[] columns = new String[] { "v_txnseqno" };
        Object[] paramaters = new Object[1];
        paramaters[0] = txnseqno;
        return executeOracleProcedure(
                "{CALL PCK_SEL_T_TXNS_LOG.sel_txns_log_deta(?,?)}", columns,
                paramaters, "cursor0");
	}
}
