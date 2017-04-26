package com.zcbspay.platform.manager.system.dao;

import java.util.List;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.system.pojo.PojoRoleFunct;

public interface RoleFunctDAO extends BaseDAO<PojoRoleFunct>{

	/**
	 * 
	 * @param roleId
	 */
	public void deleteRoleFunction(Long roleId);

	/**
	 * @param roleId
	 * @return
	 */
	public List<?> findByProperty(Long roleId);

	/**
	 * @param functList
	 * @return
	 */
	public void save(List<PojoRoleFunct> functList);

	/**
	 * @param roleIdlist
	 * @return
	 */
	public List<?> findRoleFunctByRoleIds(List<Long> roleIdlist);
}
