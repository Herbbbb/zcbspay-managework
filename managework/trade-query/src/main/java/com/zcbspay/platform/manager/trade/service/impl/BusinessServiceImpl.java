package com.zcbspay.platform.manager.trade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.trade.dao.BusinessDao;
import com.zcbspay.platform.manager.trade.service.BusinessService;
@Service("businessService")
public class BusinessServiceImpl implements BusinessService{

	@Autowired
	private BusinessDao businessDao;
	@Override
	public String sayhello() {
		return "hi siri";
	}

	@Override
	public List<?> getAllBusiness() {
		return businessDao.getAllBusiness();
	}

	
}
