package com.zcbspay.platform.manager.trade.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.trade.dao.BusinessDao;

@Repository
public class BusinessDaoImpl extends HibernateBaseDAOImpl<String> implements BusinessDao {

	@Override
	public List<?> getAllBusiness() {
		String sql = "select * from T_BUSINESS where STATUS='00'";
		return queryBySQL(sql, null);
	}

}
