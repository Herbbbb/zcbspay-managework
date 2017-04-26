package com.zcbspay.platform.manager.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.system.bean.UserRoleBean;
import com.zcbspay.platform.manager.system.dao.UserRoleDAO;
import com.zcbspay.platform.manager.system.pojo.PojoUserRole;
import com.zcbspay.platform.manager.system.service.UserRoleService;

@Service("userRoleService")
@SuppressWarnings("all")
public class UserRoleServiceImpl implements UserRoleService {


	@Autowired
	private UserRoleDAO userRoleDAO;

	public void deleteOldUserRole(Long userId) {
		userRoleDAO.deleteOldUserRole(userId);
		
	}


	@Override
	public List<?> findByProperty(Long userId) {
		List<UserRoleBean> newlist = new ArrayList<UserRoleBean>();
		List<PojoUserRole> list = (List<PojoUserRole>) userRoleDAO.findByProperty(userId);
		for (PojoUserRole pojo : list) {
			UserRoleBean bean = new UserRoleBean();
			bean.setRoleId(pojo.getRoleId());
			bean.setUserId(pojo.getUserId());
			bean.setUserRoleId(pojo.getUserRoleId());
			
			newlist.add(bean);
		}
		return newlist;
	}


	@Override
	public void save(List<UserRoleBean> userRoleList) {
		List<PojoUserRole> list = new ArrayList<PojoUserRole>();
		for(UserRoleBean bean : userRoleList){
			PojoUserRole pojo = new PojoUserRole();
			pojo.setRoleId(bean.getRoleId());
			pojo.setUserId(bean.getUserId());
			pojo.setUserRoleId(bean.getUserRoleId());
			
			list.add(pojo);
		}
		userRoleDAO.save(list);
		
	}

}
