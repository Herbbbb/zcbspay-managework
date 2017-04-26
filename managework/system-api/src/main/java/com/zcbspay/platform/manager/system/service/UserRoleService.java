package com.zcbspay.platform.manager.system.service;

import java.util.List;

import com.zcbspay.platform.manager.system.bean.UserRoleBean;

public interface UserRoleService {
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
	 * @param userRoleList
	 */
	public void save(List<UserRoleBean> userRoleList);
}
