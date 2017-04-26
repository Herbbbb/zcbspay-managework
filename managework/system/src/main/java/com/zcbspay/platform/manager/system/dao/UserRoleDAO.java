package com.zcbspay.platform.manager.system.dao;

import java.util.List;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.system.pojo.PojoUserRole;

public interface UserRoleDAO extends BaseDAO<PojoUserRole>{
	/**
	 * 
	 * @param userId
	 */
	public void deleteOldUserRole(Long userId);

	/**
	 * @param userId
	 * @return
	 */
	public List<?> findByProperty(Long userId);

	/**
	 * @param list
	 */
	public void save(List<PojoUserRole> list);
}
