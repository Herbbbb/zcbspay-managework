package com.zcbspay.platform.manager.merchant.dao.impl;

import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.merchant.bean.SplitByAccNumsBean;
import com.zcbspay.platform.manager.merchant.dao.SplitByAccNumsDao;
import com.zcbspay.platform.manager.merchant.pojo.PojoSplitByAccNums;
import com.zcbspay.platform.manager.utils.BeanCopyUtil;

@Repository
@SuppressWarnings("all")
public class SplitByAccNumsDaoImpl extends HibernateBaseDAOImpl<PojoSplitByAccNums> implements SplitByAccNumsDao {

	@Override
	public Map<String, Object> findSplitAll(Map<String, Object> variables, Integer page, Integer rows) {

		String[] columns = new String[]{"v_cacode","i_no", "i_perno"};

        Object[] paramaters = new Object[]{
                variables.containsKey("caCode") ? variables.get("caCode") : null,
                page, rows};
        return executePageOracleProcedure("{CALL PCK_T_SPLIT_BY_ACCNUMS.sel_t_split_by_accnums(?,?,?,?,?)}",
                columns, paramaters,"cursor0", "v_total");
	}

	@Override
	public Map<String, Object> addSplit(SplitByAccNumsBean pojo) {
        String[] columns = new String[]{"v_cacode", "v_rate1",
                "v_limit1", "v_rate2", "v_limit2",
                "v_rate3", "v_limit3", "v_rate4",
                "v_inuser", "v_notes","v_remarks"};
        Object[] paramaters = null;
			paramaters = new Object[]{
			        "".equals(pojo.getCaCode()) ? null : pojo.getCaCode(),
	        		"".equals(pojo.getRate1()) ? null : pojo.getRate1(),
	        		"".equals(pojo.getLimit1()) ? null : pojo.getLimit1(),
			        "".equals(pojo.getRate2()) ? null : pojo.getRate2(),
			        "".equals(pojo.getLimit2()) ? null : pojo.getLimit2(),
			        "".equals(pojo.getRate3()) ? null : pojo.getRate3(),
	        		"".equals(pojo.getLimit3()) ? null : pojo.getLimit3(),
			        "".equals(pojo.getRate4()) ? null : pojo.getRate4(),
			        "".equals(pojo.getInUser()) ? null : pojo.getInUser(),
 	        		"".equals(pojo.getNotes()) ? null : pojo.getNotes(),
    				"".equals(pojo.getRemarks()) ? null : pojo.getRemarks()};
		return executeOracleProcedure("{CALL PCK_T_SPLIT_BY_ACCNUMS.ins_t_split_by_accnums(?,?,?,?,?,?,?,?,?,?,?,?)}", columns,
				paramaters, "cursor0").get(0);
	}
	@Override
	public Map<String, Object> editSplit(SplitByAccNumsBean pojo) {
		String[] columns = new String[]{"v_tid","v_cacode","v_rate1",
				"v_limit1", "v_rate2", "v_limit2","v_rate3", "v_limit3", "v_rate4",
                "v_upuser", "v_notes","v_remarks"};
		Object[] paramaters = null;
		paramaters = new Object[]{
				"".equals(pojo.gettId()) ? null : pojo.gettId(),
				"".equals(pojo.getCaCode()) ? null : pojo.getCaCode(),
        		"".equals(pojo.getRate1()) ? null : pojo.getRate1(),
        		"".equals(pojo.getLimit1()) ? null : pojo.getLimit1(),
		        "".equals(pojo.getRate2()) ? null : pojo.getRate2(),
		        "".equals(pojo.getLimit2()) ? null : pojo.getLimit2(),
		        "".equals(pojo.getRate3()) ? null : pojo.getRate3(),
        		"".equals(pojo.getLimit3()) ? null : pojo.getLimit3(),
		        "".equals(pojo.getRate4()) ? null : pojo.getRate4(),
		        "".equals(pojo.getUpUser()) ? null : pojo.getUpUser(),
        		"".equals(pojo.getNotes()) ? null : pojo.getNotes(),
				"".equals(pojo.getRemarks()) ? null : pojo.getRemarks()};
		return executeOracleProcedure("{CALL PCK_T_SPLIT_BY_ACCNUMS.upt_t_split_by_accnums(?,?,?,?,?,?,?,?,?,?,?,?,?)}", columns,
				paramaters, "cursor0").get(0);
	}
	@Override
	public SplitByAccNumsBean findSplitById(String tId) {
		Criteria crite = this.getSession().createCriteria(PojoSplitByAccNums.class);
		crite.add(Restrictions.eq("tId",Long.parseLong(tId)));
		Object uniqueResult = crite.uniqueResult();
		return BeanCopyUtil.copyBean(SplitByAccNumsBean.class, uniqueResult);
//		String sql = "select po from PojoSplitByAccNums po where po.tId=?";
//		return queryByHQL(sql, new Object[]{Long.parseLong(tId)});
	}
	@Override
	public Map<String, Object> deleteSplit(String tId) {
		String[] columns = new String[]{"v_tid"};
		Object[] paramaters = new Object[]{tId};
		return executeOracleProcedure("{CALL PCK_T_SPLIT_BY_ACCNUMS.del_t_split_by_accnums(?,?)}", columns,paramaters, "cursor0").get(0);
	}

}
