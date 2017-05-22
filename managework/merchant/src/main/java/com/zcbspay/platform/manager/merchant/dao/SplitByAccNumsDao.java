package com.zcbspay.platform.manager.merchant.dao;

import java.util.Map;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.merchant.bean.SplitByAccNumsBean;
import com.zcbspay.platform.manager.merchant.pojo.PojoSplitByAccNums;

public interface SplitByAccNumsDao extends BaseDAO<PojoSplitByAccNums> {

	/**
	 * 查询代理商信息列表
	 * @param variables
	 * @param page
	 * @param rows
	 * @return
	 */
	Map<String, Object> findSplitAll(Map<String, Object> variables, Integer page, Integer rows);
	
	/**
	 * 新增代理商
	 * @param pojo
	 * @return
	 */
	Map<String, Object> addSplit(SplitByAccNumsBean pojo);
	
	/**
	 * 修改代理商
	 * @param pojo
	 * @return
	 */
	Map<String, Object> editSplit(SplitByAccNumsBean pojo);
	
	 /**
	  * 查询详情
	 * @param caId
	 * @return
	 */
	SplitByAccNumsBean findSplitById(String tId);
	
	/**
	 * 注销代理商信息
	 * @param caId
	 * @return
	 */
	Map<String, Object> deleteSplit(String tId);
}

