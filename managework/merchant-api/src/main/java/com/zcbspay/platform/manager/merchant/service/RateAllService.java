package com.zcbspay.platform.manager.merchant.service;

import java.util.List;

public interface RateAllService {

	/**
	 * 扣率信息
	 * @param paraCode
	 * @return
	 */
	List<?> findParaDesc(String paraCode);

	/**
	 * 查找扣率描述
	 * @param rateId
	 * @return
	 */
	List<?> findParaById(Long rateMethod,Long rateId);


}
