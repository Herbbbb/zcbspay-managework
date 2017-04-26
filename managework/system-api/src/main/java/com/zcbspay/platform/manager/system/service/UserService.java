package com.zcbspay.platform.manager.system.service;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.system.bean.UserBean;

/**
 * 
 * @author guojia
 *
 */
public interface UserService {
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
	 * @param userBean
	 * @return
	 */
	public UserBean getLoginUser(UserBean userBean);
	
	/**
	 * @param userId
	 * @return
	 */
	public UserBean getSingleById(Long userId);
	
	/**重置密码
	 * @param pwd
	 * @param pwdValid
	 */
	public void resetPwd(UserBean bean, String timestamp);
}
