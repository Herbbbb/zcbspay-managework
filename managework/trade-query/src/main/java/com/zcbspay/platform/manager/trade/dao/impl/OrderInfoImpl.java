package com.zcbspay.platform.manager.trade.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.trade.bean.OrderInfoBean;
import com.zcbspay.platform.manager.trade.dao.OrderInfoDao;

@Repository
public class OrderInfoImpl extends HibernateBaseDAOImpl<String> implements OrderInfoDao {

	@Override
	public Map<String, Object> getOrderInfoByPage(String page, String rows, OrderInfoBean variables) {
		String[] columns = new String[]{
				 "v_ORDERNO", 
				 "v_TN",
				 "v_SECMEMBERNO",
				 "v_stime", 
				 "v_etime",
				 "v_STATUS",
				 "v_user",
	             "i_no",
	             "i_perno"
	             };
		 
	        Object[] paramaters = new Object[]{
	                variables.getOrderNo(),
	                variables.getTn(),
	                variables.getSecmemberNo(),
	                variables.getStime(),
	                variables.getEtime(),
	                variables.getStatus(),
	                variables.getUserId(),
	                page, rows};
	        return executePageOracleProcedure(
	               "{CALL PCK_SEL_t_txns_orderinfo.sel_txns_log(?,?,?,?,?,?,?,?,?,?,?)}", columns,
	               paramaters, "cursor0","v_total");
	}
	@Override
	public List<?> getOrderInfoDetail(String id) {
		String[] columns = new String[] { "v_ID" };
        Object[] paramaters = new Object[1];
        paramaters[0] = id;
        return executeOracleProcedure(
                "{CALL PCK_SEL_t_txns_orderinfo.sel_txns_log_deta(?,?)}", columns,
                paramaters, "cursor0");
	}

	
}
