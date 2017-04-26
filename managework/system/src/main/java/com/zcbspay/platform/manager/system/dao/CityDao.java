package com.zcbspay.platform.manager.system.dao;

import java.util.List;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.system.pojo.PojoCity;

public interface CityDao extends BaseDAO<PojoCity>{

	/**
	 * 查询城市信息
	 * @param pid	城市ID
	 * @return
	 */
	List<?> findNotMuniByPid(Long pid);

	/**
	 * @param cCode
	 * @return
	 */
	List<?> findByPid(String cCode);

}
