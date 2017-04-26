package com.zcbspay.platform.manager.merchant.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.merchant.dao.MccListDAO;
import com.zcbspay.platform.manager.merchant.pojo.PojoMccList;

@Repository
@SuppressWarnings("all")
public class MccListDAOImpl extends HibernateBaseDAOImpl<PojoMccList> implements MccListDAO {

	@Override
	public List<?> findAll() {
		Object[] paramaters = null;
		String sql = "select * from T_MCC_LIST";
		return queryBySQL(sql,paramaters);
	}

}
