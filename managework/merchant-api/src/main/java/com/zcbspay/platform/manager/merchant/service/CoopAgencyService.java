package com.zcbspay.platform.manager.merchant.service;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.merchant.bean.CoopAgencyBean;
import com.zcbspay.platform.manager.merchant.bean.SplitByAccNumsBean;

public interface CoopAgencyService {

	/**
	 * 查询代理商信息列表
	 * @param result
	 * @param page
	 * @param rows
	 * @return
	 */
	Map<String, Object> findAll(Map<String, Object> result, Integer page, Integer rows);

	/**
	 * 
	 * @param coop
	 * @return
	 */
	Map<String, Object> addCoopAgency(CoopAgencyBean coop);

	/**
	 * @param tId
	 * @return
	 */
	List<?> findById(String tId);

	/**
	 * @param coop
	 * @return
	 */
	Map<String, Object> editCoopAgency(CoopAgencyBean coop);

	/**
	 * @param tId
	 * @return
	 */
	Map<String, Object> deleteCoopAgency(String tId);

	/**
	 * 查询代理商获利模式
	 * @return
	 */
	List<?> queryProfitType();

	/**
	 * 查询代理商分润信息列表
	 * @param result
	 * @param page
	 * @param rows
	 * @return
	 */
	Map<String, Object> findSplitAll(Map<String, Object> result, Integer page, Integer rows);

	/**
	 * 新增代理商分润信息
	 * @param split
	 * @return
	 */
	Map<String, Object> addSplit(SplitByAccNumsBean split);

	/**
	 * 查询代理商分润信息详情
	 * @param tId
	 * @return
	 */
	SplitByAccNumsBean findSplitById(String tId);

	/**
	 * 修改代理商分润信息
	 * @param split
	 * @return
	 */
	Map<String, Object> editSplit(SplitByAccNumsBean split);

	/**
	 * 注销代理商分润信息
	 * @param tId
	 * @return
	 */
	Map<String, Object> deleteSplit(String tId);

}
