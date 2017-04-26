package com.zcbspay.platform.manager.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.system.bean.FunctionBean;
import com.zcbspay.platform.manager.system.bean.UserBean;
import com.zcbspay.platform.manager.system.dao.FunctionDAO;
import com.zcbspay.platform.manager.system.pojo.PojoFunction;
import com.zcbspay.platform.manager.system.service.FunctionService;
@Service("functionService")
@SuppressWarnings("all")
public class FunctionServiceImpl implements FunctionService{

	@Autowired
	private FunctionDAO functionDAO;
	
	@Override
	public List<?> findAllFuntion(UserBean loginuser){
		List<FunctionBean> beanList = new ArrayList<FunctionBean>();
		List<PojoFunction> list = (List<PojoFunction>) functionDAO.findAllFuntion(loginuser);
		for (PojoFunction pojo : list) {
			FunctionBean bean = new FunctionBean();
			bean.setFunctOrder(pojo.getFunctOrder());
			bean.setIcon(pojo.getIcon());
			bean.setFunctId(pojo.getFunctId());
			bean.setStatus(pojo.getStatus());
			bean.setLevelId(pojo.getLevelId());
			bean.setLeafnode(pojo.getLeafnode());
			bean.setFunctName(pojo.getFunctName());
			bean.setParentId(pojo.getParentId());
			bean.setUrl(pojo.getUrl());
			
			beanList.add(bean);
		}
		
		return beanList;
	}
	@Override
	public List<?> findFunction(){
		return functionDAO.findFunction();
	}
	@Override
	public List<?> existUserAndRoleFunct(Long userId,Long fid){
		return functionDAO.existUserAndRoleFunct(userId, fid);
	}
	@Override
	public List<?> findLoginFuntion(UserBean loginuser) {
		return functionDAO.findLoginFuntion(loginuser);
	}
}
