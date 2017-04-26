package com.zcbspay.platform.manager.merchant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.merchant.dao.RateAllDao;
import com.zcbspay.platform.manager.merchant.service.RateAllService;

@Service("rateAllService")
public class RateAllServiceImpl implements RateAllService {

	@Autowired
	private RateAllDao rateAllDao;

	@Override
	public List<?> findParaDesc(String paraCode) {
		return rateAllDao.findParaDesc(Long.parseLong(paraCode));
	}

	@Override
	public List<?> findParaById(Long rateMethod,Long rateId) {
		return rateAllDao.findParaById(rateMethod,rateId);
	}
}
