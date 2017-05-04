package com.zcbspay.platform.manager.merchant.service;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.merchant.bean.ContractBean;

public interface ContractService {

	/**
	 * 合同列表
	 * @param contract
	 * @param page
	 * @param rows
	 * @return
	 */
	Map<String, Object> findAll(Map<String, Object> variables, int page, int rows);

	/**
	 * 新增合同
	 * @param contract
	 * @return
	 */
	Map<String, Object> addContract(ContractBean contract);

	/**
	 * 合同详情
	 * @param tId
	 * @return
	 */
	ContractBean findById(String tId);
	
	/**
	 * 根据合同编号查询详情
	 * @param tId
	 * @return
	 */
	ContractBean findByCode(String contractNum);

	/**
	 * 修改
	 * @param bean
	 * @return
	 */
	Map<String, Object> eidtContract(ContractBean bean);

	/**
	 * 审核查询记录数
	 * @return
	 */
	Integer findAllCont(ContractBean contract);

	/**
	 *  审核查询
	 * @param contract
	 * @param page
	 * @param rows
	 * @return
	 */
	List<?> findAllAccout(ContractBean contract, Integer page, Integer rows);

	/**
	 * 合同审核
	 * @param deta
	 * @param isAgree
	 * @return
	 */
	List<Map<String, Object>> merchAudit(ContractBean deta, String isAgree);

	/**
	 * 合同批量上传
	 * @param list
	 * @return
	 */
	List<StringBuffer> importBatch(List<ContractBean> list);
	
}
