package com.zcbspay.platform.manager.merchant.dao;

import java.util.List;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.merchant.pojo.PojoRateAll;

public interface RateAllDao extends BaseDAO<PojoRateAll> {

	/**
	 * 扣率信息
	 * @param paraCode
	 * @return
	 */
	List<?> findParaDesc(Long paraCode);

	/**
	 * 查找扣率描述
	 * @param rateId
	 * @return
	 */
	List<?> findParaById(Long rateMethod,Long rateId);

}
