package com.zcbspay.platform.manager.system.dao;

import java.util.List;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.system.pojo.PojoUserFunct;

public interface UserFunctDAO extends BaseDAO<PojoUserFunct>{
	/**
	 * 
	 * @param userId
	 */
	public void deleteOldFunc(Long userId);

	/**
	 * @param userId
	 * @return
	 */
	public List<?> findByProperty(Long userId);

	/**
	 * @param list
	 */
	public void save(List<PojoUserFunct> list);
}
