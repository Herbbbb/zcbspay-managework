package com.zcbspay.platform.manager.merchant.dao;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.merchant.bean.ContractBean;
import com.zcbspay.platform.manager.merchant.pojo.PojoContract;

public interface ContractDao extends BaseDAO<PojoContract> {

	/**
	 * 合同列表
	 * @param contract
	 * @param page
	 * @param rows
	 * @return
	 */
	Map<String, Object> findAll(Map<String, Object> variables, int page, int rows);

	/**
	 * 新增
	 * @param pojo
	 */
	Map<String, Object> addContract(PojoContract pojo);

	/**
	 * 查询详情
	 * @param tId
	 * @return
	 */
	List<?> findById(String tId);

	/**
	 * 修改
	 * @param bean
	 */
	Map<String, Object> eidtContract(ContractBean bean);

	/**
	 * 审核查询记录数
	 * @return
	 */
	List<?> findAllCont(ContractBean contract);

	/**
	 * 审核查询
	 * @param contract
	 * @param page
	 * @param rows
	 * @return
	 */
	List<?> findAllAccout(ContractBean contract, Integer page, Integer rows);

	/**
	 * 合同审核
	 * @param contract
	 * @param isAgree
	 * @return
	 */
	List<Map<String, Object>> merchAudit(ContractBean contract, String isAgree);

	/**
	 * 合同批量导入
	 * @param list
	 * @return
	 */
	List<StringBuffer> importBatch(List<ContractBean> list);
	
}
