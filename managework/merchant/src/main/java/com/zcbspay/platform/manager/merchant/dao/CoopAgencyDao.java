package com.zcbspay.platform.manager.merchant.dao;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.exception.ContractException;
import com.zcbspay.platform.manager.merchant.bean.CoopAgencyBean;
import com.zcbspay.platform.manager.merchant.pojo.PojoCoopAgency;

public interface CoopAgencyDao extends BaseDAO<PojoCoopAgency> {

	/**
	 * 查询代理商信息列表
	 * @param variables
	 * @param page
	 * @param rows
	 * @return
	 */
	Map<String, Object> findAll(Map<String, Object> variables, Integer page, Integer rows);
	
	/**
	 * 新增代理商
	 * @param pojo
	 * @return
	 */
	Map<String, Object> addCoopAgency(CoopAgencyBean pojo);
	
	/**
	 * 修改代理商
	 * @param pojo
	 * @return
	 */
	Map<String, Object> editCoopAgency(CoopAgencyBean pojo);
	
	 /**
	  * 查询详情
	 * @param caId
	 * @return
	 */
	List<?> findById(String caId);
	
	/**
	 * 查询代理商获利模式
	 * @return
	 */
	List<?> queryProfitType();

	/**
	 * 注销代理商信息
	 * @param caId
	 * @return
	 */
	Map<String, Object> deleteCoopAgency(String caId) throws ContractException;
}
