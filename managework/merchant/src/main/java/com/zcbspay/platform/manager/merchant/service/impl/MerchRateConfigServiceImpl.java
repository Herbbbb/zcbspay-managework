package com.zcbspay.platform.manager.merchant.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.merchant.bean.MerchRateConfigBean;
import com.zcbspay.platform.manager.merchant.dao.MerchRateConfigDao;
import com.zcbspay.platform.manager.merchant.pojo.PojoMerchRateConfig;
import com.zcbspay.platform.manager.merchant.service.MerchRateConfigService;

@Service("merchRateConfigService")
public class MerchRateConfigServiceImpl implements MerchRateConfigService {

	@Autowired
	private MerchRateConfigDao merchRateConfigDao;

	@Override
	public List<?> findRateConfig(String memberId) {
		return merchRateConfigDao.findRateConfig(memberId);
	}

	@Override
	public List<?> addRateConfig(MerchRateConfigBean merchRate) {
		return merchRateConfigDao.addRateConfig(merchRate);
	}

	@Override
	public List<?> updateRateConfig(MerchRateConfigBean merchRate) {
		return merchRateConfigDao.updateRateConfig(merchRate);
	}

	@Override
	public MerchRateConfigBean findParaById(String memberId, String busiCode) {
		MerchRateConfigBean bean = new MerchRateConfigBean();
		PojoMerchRateConfig pojo = (PojoMerchRateConfig) merchRateConfigDao.findParaById(memberId, busiCode).get(0);
		BeanUtils.copyProperties(pojo, bean);
		return bean;
	}
	
}
