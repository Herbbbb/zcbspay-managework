package com.zcbspay.platform.manager.system.dao;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.system.bean.UserBean;
import com.zcbspay.platform.manager.system.pojo.PojoUser;


public interface UserDAO extends BaseDAO<PojoUser>{ 
	/**
	 * 
	 * @param variables
	 * @param page
	 * @param rows
	 * @return
	 */
	public Map<String, Object> findUserByPage(Map<String, Object> variables, int page,int rows);
	/**
	 * 
	 * @param variables
	 * @return
	 */
	public long findUserByPageCount(Map<String, Object> variables);
	/**
	 * 
	 * @param user
	 * @return
	 */
	public List<?> saveUser(UserBean user);
	/**
	 * 
	 * @param user
	 * @return
	 */
	public List<?> updateUser(UserBean user);
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public UserBean getLoginUser(UserBean user);
	
	/**
	 * @param userId
	 * @return
	 */
	public UserBean getSingleById(Long userId);
	/**
	 * @param timestamp 
	 * @param pwd
	 * @param pwdValid
	 */
	public void resetPwd(UserBean userBean, String timestamp);
}
