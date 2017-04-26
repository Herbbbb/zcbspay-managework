package com.zcbspay.platform.manager.system.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.system.bean.CityBean;
import com.zcbspay.platform.manager.system.dao.CityDao;
import com.zcbspay.platform.manager.system.pojo.PojoCity;
import com.zcbspay.platform.manager.system.service.CityService;


@Service("cityService")
public class CityServiceImpl implements CityService {

	@Autowired
	private CityDao cityDao;
	
	@Override
	public List<?> findNotMuniByPid(Long pid) {
		return cityDao.findNotMuniByPid(pid);
	}

	@Override
	public CityBean findByPid(String CCode) {
		PojoCity pojo = (PojoCity) cityDao.findByPid(CCode).get(0);
		CityBean bean = new CityBean();
		BeanUtils.copyProperties(pojo, bean);
		return bean;
	}


	
}
