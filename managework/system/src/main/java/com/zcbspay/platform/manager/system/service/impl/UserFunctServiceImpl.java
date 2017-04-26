package com.zcbspay.platform.manager.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.system.bean.UserFunctBean;
import com.zcbspay.platform.manager.system.dao.UserFunctDAO;
import com.zcbspay.platform.manager.system.pojo.PojoUserFunct;
import com.zcbspay.platform.manager.system.service.UserFunctService;
@Service("userFunctService")
@SuppressWarnings("all")
public class UserFunctServiceImpl implements UserFunctService{

	@Autowired
	private UserFunctDAO userFunctDAO;
	
	public void deleteOldFunc(Long userId) {
		userFunctDAO.deleteOldFunc(userId);
	}

	
	@Override
	public List<?> findByProperty(Long userId) {
		List<UserFunctBean> newlist = new ArrayList<UserFunctBean>();
		List<PojoUserFunct> list = (List<PojoUserFunct>) userFunctDAO.findByProperty(userId);
		for (PojoUserFunct pojo : list) {
			UserFunctBean bean = new UserFunctBean();
			bean.setFunctId(pojo.getFunctId());
			bean.setUserFunctId(pojo.getUserFunctId());
			bean.setUserId(pojo.getUserId());
			
			newlist.add(bean);
		}
		return newlist;
	}


	@Override
	public void save(List<UserFunctBean> functList) {
		List<PojoUserFunct> list = new ArrayList<PojoUserFunct>();
		for(UserFunctBean bean : functList){
			PojoUserFunct pojo = new PojoUserFunct();
			pojo.setFunctId(bean.getFunctId());
			pojo.setUserFunctId(bean.getUserFunctId());
			pojo.setUserId(bean.getUserId());
			
			list.add(pojo);
		}
		userFunctDAO.save(list);
	}
}
