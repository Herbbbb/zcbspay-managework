package com.zcbspay.platform.manager.merchant.dao;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.exception.ContractException;
import com.zcbspay.platform.manager.merchant.pojo.PojoAgencyInfo;

public interface AgencyInfoDao extends BaseDAO<PojoAgencyInfo>{

	/**
	 * 添加业务收费信息
	 * @param bean
	 * @return
	 */
	Map<String, Object> saveAgencyInfo(PojoAgencyInfo bean) throws ContractException ;
	/**
	 * 修改业务收费信息
	 * @param bean
	 * @return
	 */
	Map<String, Object> updateAgencyInfo(PojoAgencyInfo bean)throws ContractException;
	
	
	/**
	 * 查询业务收费信息
	 * @param bean
	 * @return
	 */
	boolean queryAgencyInfo(PojoAgencyInfo bean);
	/**
	 * 查询业务收费信息
	 * @param merchNo
	 * @param bustCode 
	 * @return
	 */
	List<?> queryByMerchNo(String merchNo);
	/**
	 * 验证付款单位代码
	 * @param merchNo
	 * @param bustCode 
	 * @return
	 */
	boolean queryByChargingunit(String chargingunit);
	/**
	 * 查询业务收费信息
	 * @param merchNo
	 * @param bustCode 
	 * @return
	 */
	List<?> queryByCode(String merchNo, String bustCode);
}
