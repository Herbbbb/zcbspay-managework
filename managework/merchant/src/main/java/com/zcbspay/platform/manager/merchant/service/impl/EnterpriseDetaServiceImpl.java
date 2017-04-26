package com.zcbspay.platform.manager.merchant.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.merchant.bean.EnterpriseDetaApplyBean;
import com.zcbspay.platform.manager.merchant.dao.EnterpriseDetaDao;
import com.zcbspay.platform.manager.merchant.pojo.PojoEnterpriseDetaApply;
import com.zcbspay.platform.manager.merchant.service.EnterpriseDetaService;

@Service("enterpriseDetaService")
@SuppressWarnings("all")
public class EnterpriseDetaServiceImpl implements EnterpriseDetaService {

	@Autowired
	private EnterpriseDetaDao enterpriseDetaDao;
	@Override
	public EnterpriseDetaApplyBean findById(String selfId) {
		EnterpriseDetaApplyBean bean = new EnterpriseDetaApplyBean();
		PojoEnterpriseDetaApply pojo = (PojoEnterpriseDetaApply) enterpriseDetaDao.findById(selfId).get(0);
		BeanUtils.copyProperties(pojo, bean);
		return bean;
	}

}
