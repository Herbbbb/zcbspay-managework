package com.zcbspay.platform.manager.system.service;

import java.util.List;

import com.zcbspay.platform.manager.system.bean.UserBean;
/**
 * 
 * Class Description
 *
 * @author guojia
 * @version
 * @date 2016年12月28日 下午4:21:27
 * @since
 */
public interface FunctionService {
	/**
	 * 
	 * @param loginuser
	 * @return
	 */
	public List<?> findAllFuntion(UserBean loginuser);
	/**
	 * 
	 * @param loginuser
	 * @return
	 */
	public List<?> findLoginFuntion(UserBean loginuser);
	/**
	 * 
	 * @return
	 */
	public List<?> findFunction();
	/**
	 * 
	 * @param userId
	 * @param fid
	 * @return
	 */
	public List<?> existUserAndRoleFunct(Long userId,Long fid);
}
