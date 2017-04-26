package com.zcbspay.platform.manager.merchant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.merchant.dao.CoopInstiDao;
import com.zcbspay.platform.manager.merchant.service.CoopInstiService;

@Service("coopInstiService")
public class CoopInstiServiceImpl implements CoopInstiService {

	@Autowired
	private CoopInstiDao coopInstiDao;
	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return coopInstiDao.findAll();
	}

}
