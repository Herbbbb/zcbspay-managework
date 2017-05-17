package com.zcbspay.platform.manager.merchant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.merchant.dao.CoopAgencyDao;
import com.zcbspay.platform.manager.merchant.service.CoopAgencyService;

@Service("coopAgencyService")
public class CoopAgencyServiceImpl implements CoopAgencyService {

	@Autowired
	private CoopAgencyDao coopAgencyDao;
	
}
