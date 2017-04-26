package com.zcbspay.platform.manager.merchant.dao;

import java.util.List;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.merchant.bean.MerchRateConfigBean;
import com.zcbspay.platform.manager.merchant.pojo.PojoMerchRateConfig;

public interface MerchRateConfigDao extends BaseDAO<PojoMerchRateConfig> {


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
	 * @param merchRate
	 * @return
	 */
	List<?> updateRateConfig(MerchRateConfigBean merchRate);

	/**
	 * 查询业务计费方式
	 * @param memberId
	 * @param busiCode
	 * @return
	 */
	List<?> findParaById(String memberId, String busiCode);

}
