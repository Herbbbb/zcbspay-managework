package com.zcbspay.platform.manager.trade.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.trade.bean.CnapsLogBean;
import com.zcbspay.platform.manager.trade.dao.CnapsLogDao;

@Repository
public class CnapsLogDaoImpl extends HibernateBaseDAOImpl<String> implements CnapsLogDao {

	@Override
	public Map<String, Object> getCnapsLogByPage(String page, String rows, CnapsLogBean variables) {
		String[] columns = new String[]{
				 "v_MSGID", 
				 "v_MSGTYPE",
				 "v_stime", 
				 "v_etime",
				 "v_user",
	             "i_no",
	             "i_perno"
	             };
		 
	        Object[] paramaters = new Object[]{
	                variables.getMsgId(),
	                variables.getMsgType(),
	                variables.getStime(),
	                variables.getEtime(),
	                variables.getUserId(),
	                page, rows};
	        return executePageOracleProcedure(
	               "{CALL PCK_T_CNAPS_LOG.sel_T_CNAPS_LOG(?,?,?,?,?,?,?,?,?)}", columns,
	               paramaters, "cursor0","v_total");
	}


}
