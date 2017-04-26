package com.zcbspay.platform.manager.merchant.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.merchant.dao.RateAllDao;
import com.zcbspay.platform.manager.merchant.pojo.PojoRateAll;

@Repository
public class RateAllDaoImpl extends HibernateBaseDAOImpl<PojoRateAll> implements RateAllDao {

	@Override
	public List<?> findParaDesc(Long paraCode) {
		String sql = "select * from t_rate_all where RATE_METHOD=?";
		return queryBySQL(sql,new Object[]{paraCode});
	}

	@Override
	public List<?> findParaById(Long rateMethod,Long rateId) {
		Object[] paramaters = new Object[]{
        		"".equals(rateMethod) ? null : rateMethod,
        		"".equals(rateId) ? null : rateId
		       };
		String sql = "select * from t_rate_all t where t.rate_method=? and t.rate_id=?";
		return queryBySQL(sql,paramaters);
	}

}
