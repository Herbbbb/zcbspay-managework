package com.zcbspay.platform.manager.merchant.service;

import com.zcbspay.platform.manager.merchant.bean.EnterpriseDetaApplyBean;

public interface EnterpriseDetaService {

	/**
	 * 商户企业信息
	 * @param memberId
	 * @return
	 */
	EnterpriseDetaApplyBean findById(String selfId);

}
