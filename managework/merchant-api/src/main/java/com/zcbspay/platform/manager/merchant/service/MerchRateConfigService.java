package com.zcbspay.platform.manager.merchant.service;

import java.util.List;

import com.zcbspay.platform.manager.merchant.bean.MerchRateConfigBean;

public interface MerchRateConfigService {


	/**
	 * 查询计费列表
	 * @param prdtVer
	 * @param memberId
	 * @return
	 */
	List<?> findRateConfig(String memberId);

	/**
	 * 新增计费方式
	 * @param merchRate
	 * @return
	 */
	List<?> addRateConfig(MerchRateConfigBean merchRate);

	/**
	 * 修改计费方式
	 * @param prdtVer
	 * @param memberId
	 * @return
	 */
	List<?> updateRateConfig(MerchRateConfigBean merchRate);

	/**
	 * 查询业务计费方式
	 * @param memberId
	 * @param busiCode
	 * @return
	 */
	MerchRateConfigBean findParaById(String memberId, String busiCode);

}
