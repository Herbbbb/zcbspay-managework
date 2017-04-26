package com.zcbspay.platform.manager.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.system.bean.ProvinceBean;
import com.zcbspay.platform.manager.system.dao.ProvinceDao;
import com.zcbspay.platform.manager.system.service.ProvinceService;

@Service("provinceService")
@SuppressWarnings("all")
public class ProvinceServiceImpl implements ProvinceService {
	
	@Autowired
	private ProvinceDao provinceDao;

	@Override
	public List<ProvinceBean> findAll() {
		return  (List<ProvinceBean>) provinceDao.findAll();
	}

	@Override
	public ProvinceBean findById(String pId) {
		return provinceDao.findById(pId);
	}

}
