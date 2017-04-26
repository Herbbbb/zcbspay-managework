package com.zcbspay.platform.manager.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.system.bean.UserBean;
import com.zcbspay.platform.manager.system.dao.UserDAO;
import com.zcbspay.platform.manager.system.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	public Map<String, Object> findUserByPage(Map<String, Object> variables, int page,int rows) {
		return userDAO.findUserByPage(variables, page, rows);
	}

	public long findUserByPageCount(Map<String, Object> variables) {
		return userDAO.findUserByPageCount(variables);
	}

	public List<?> saveUser(UserBean user) {
		return userDAO.saveUser(user);
	}

	public List<?> updateUser(UserBean user) {
		return userDAO.updateUser(user);
	}
	@Override
	public UserBean getLoginUser(UserBean userBean) {
		return userDAO.getLoginUser(userBean);
	}

	@Override
	public UserBean getSingleById(Long userId) {
		return userDAO.getSingleById(userId);
	}

	@Override
	public void resetPwd(UserBean userBean, String timestamp) {
		userDAO.resetPwd(userBean,timestamp);
	}

}
