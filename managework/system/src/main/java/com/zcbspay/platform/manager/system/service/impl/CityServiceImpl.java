package com.zcbspay.platform.manager.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.system.dao.CityDao;
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
	public List<?> findByPid(String CCode) {
		return cityDao.findByPid(CCode);
	}


	
}
