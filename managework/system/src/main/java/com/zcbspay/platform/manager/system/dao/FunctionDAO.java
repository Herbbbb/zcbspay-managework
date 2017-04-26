package com.zcbspay.platform.manager.system.dao;

import java.util.List;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.system.bean.UserBean;
import com.zcbspay.platform.manager.system.pojo.PojoFunction;

public interface FunctionDAO extends BaseDAO<PojoFunction>{

	/**
	 * 
	 * @param loginuser
	 * @return
	 */
	public List<?> findAllFuntion(UserBean loginuser);
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
	
	/**
	 * 
	 * @param loginuser
	 * @return
	 */
	public List<?> findLoginFuntion(UserBean loginuser);
}
