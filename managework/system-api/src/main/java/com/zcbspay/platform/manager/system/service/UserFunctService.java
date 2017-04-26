package com.zcbspay.platform.manager.system.service;

import java.util.List;

import com.zcbspay.platform.manager.system.bean.UserFunctBean;

public interface UserFunctService {
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
	 * @param functList
	 */
	public void save(List<UserFunctBean> functList);
}
