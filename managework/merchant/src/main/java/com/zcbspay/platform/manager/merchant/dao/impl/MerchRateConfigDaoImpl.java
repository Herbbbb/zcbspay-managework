package com.zcbspay.platform.manager.merchant.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.merchant.bean.MerchRateConfigBean;
import com.zcbspay.platform.manager.merchant.dao.MerchRateConfigDao;
import com.zcbspay.platform.manager.merchant.pojo.PojoMerchRateConfig;

@Repository
public class MerchRateConfigDaoImpl extends HibernateBaseDAOImpl<PojoMerchRateConfig> implements MerchRateConfigDao {

	@Override
	public List<?> findRateConfig(String memberId) {
		 String[] columns = new String[]{"v_self_id"};
	     return executeOracleProcedure("{CALL PCK_T_MERCH_RATE_CONFIG.sel_t_merch_rate_config(?,?)}",columns, new Object[]{memberId}, "cursor0");
	}

	@Override
	public List<?> addRateConfig(MerchRateConfigBean merchRate) {
		 String[] columns = new String[]{"v_member_id", "v_busicode",
				 	"v_setlflg","v_rate_method", "v_rate_id",
	                "v_inuser", "v_notes", "v_remarks"};

	        Object[] paramaters = new Object[]{
	        		"".equals(merchRate.getMemberId()) ? null : merchRate.getMemberId(),
			        "".equals(merchRate.getBusiCode()) ? null : merchRate.getBusiCode(),
    				"".equals(merchRate.getSetlflg()) ? null : merchRate.getSetlflg(),
    				"".equals(merchRate.getRateMethod()) ? null : merchRate.getRateMethod(),
    				"".equals(merchRate.getRateId()) ? null : merchRate.getRateId(),
    				"".equals(merchRate.getInUser()) ? null : merchRate.getInUser(),
    				"".equals(merchRate.getNotes()) ? null : merchRate.getNotes(),
					"".equals(merchRate.getRemarks()) ? null : merchRate.getRemarks()};
	        return executeOracleProcedure("{CALL PCK_T_MERCH_RATE_CONFIG.ins_t_merch_rate_config(?,?,?,?,?,?,?,?,?)}",
	                columns, paramaters, "cursor0");
	}

	@Override
	public List<?> updateRateConfig(MerchRateConfigBean merchRate) {
		String[] columns = new String[]{"v_tid","v_member_id", "v_busicode",
				"v_setlflg","v_rate_method", "v_rate_id",
                "v_inuser", "v_notes", "v_remarks"};

        Object[] paramaters = new Object[]{
        		"".equals(merchRate.gettId()) ? null : merchRate.gettId(),
        		"".equals(merchRate.getMemberId()) ? null : merchRate.getMemberId(),
		        "".equals(merchRate.getBusiCode()) ? null : merchRate.getBusiCode(),
				"".equals(merchRate.getSetlflg()) ? null : merchRate.getSetlflg(),
				"".equals(merchRate.getRateMethod()) ? null : merchRate.getRateMethod(),
				"".equals(merchRate.getRateId()) ? null : merchRate.getRateId(),
				"".equals(merchRate.getInUser()) ? null : merchRate.getInUser(),
				"".equals(merchRate.getNotes()) ? null : merchRate.getNotes(),
				"".equals(merchRate.getRemarks()) ? null : merchRate.getRemarks()};
	        return executeOracleProcedure("{CALL PCK_T_MERCH_RATE_CONFIG.upt_t_merch_rate_config(?,?,?,?,?,?,?,?,?,?)}",
	                columns, paramaters, "cursor0");
	}

	@Override
	public List<?> findParaById(String memberId, String busiCode) {
		 Object[] paramaters = new Object[]{
	        		"".equals(memberId) ? null : memberId,
	        		"".equals(busiCode) ? null : busiCode
			       };
		String hql = "select p from PojoMerchRateConfig p where p.memberId=? and p.busiCode=?";
		return queryByHQL(hql, paramaters);
	}

}
