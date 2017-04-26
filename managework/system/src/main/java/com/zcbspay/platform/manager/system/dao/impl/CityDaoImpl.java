package com.zcbspay.platform.manager.system.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.system.dao.CityDao;
import com.zcbspay.platform.manager.system.pojo.PojoCity;

@Repository
public class CityDaoImpl extends HibernateBaseDAOImpl<PojoCity>  implements CityDao {

	@Override
	public List<?> findNotMuniByPid(Long pId) {
		String sql = "select * from T_CITY ct where ct.P_ID = ?";
		return queryBySQL(sql,new Object[]{pId});
	}

	@Override
	public List<?> findByPid(String cCode) {
		String sql = "select ct from PojoCity ct where ct.CCode = ?";
		return queryByHQL(sql,new Object[]{cCode});
	}

}
