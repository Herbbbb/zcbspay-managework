package com.zcbspay.platform.manager.system.service;

import java.util.List;

import com.zcbspay.platform.manager.system.bean.RoleFunctBean;

/**
 * 
 * Class Description
 *
 * @author guojia
 * @version
 * @date 2016年12月28日 下午4:23:24
 * @since
 */
public interface RoleFunctService{
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
	 */
	public void save(List<RoleFunctBean> functList);

	/**
	 * @param roleIdlist
	 * @return
	 */
	public List<RoleFunctBean> findRoleFunctByRoleIds(List<Long> roleIdlist);
}
