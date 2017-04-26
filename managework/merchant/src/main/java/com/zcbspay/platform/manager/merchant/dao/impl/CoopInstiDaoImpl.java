package com.zcbspay.platform.manager.merchant.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.merchant.bean.CoopInstiBean;
import com.zcbspay.platform.manager.merchant.dao.CoopInstiDao;
@Repository
public class CoopInstiDaoImpl extends HibernateBaseDAOImpl<CoopInstiBean> implements CoopInstiDao {

	@Override
	public List<?> findAll() {
		String sql = "select * from T_COOP_INSTI";
		return queryBySQL(sql,null);
	}

}
