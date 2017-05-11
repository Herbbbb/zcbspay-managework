package com.zcbspay.platform.manager.merchant.dao;

import java.util.List;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.merchant.bean.AgencyInfoBean;
import com.zcbspay.platform.manager.merchant.pojo.PojoAgencyInfo;

public interface AgencyInfoDao extends BaseDAO<PojoAgencyInfo>{

	/**
	 * 添加业务收费信息
	 * @param bean
	 * @return
	 */
	boolean saveAgencyInfo(PojoAgencyInfo bean);
	/**
	 * 修改业务收费信息
	 * @param bean
	 * @return
	 */
	PojoAgencyInfo updateAgencyInfo(PojoAgencyInfo bean);
	
	
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
	 * 查询业务收费信息
	 * @param merchNo
	 * @param bustCode 
	 * @return
	 */
	List<?> queryByCode(String merchNo, String bustCode);
}
