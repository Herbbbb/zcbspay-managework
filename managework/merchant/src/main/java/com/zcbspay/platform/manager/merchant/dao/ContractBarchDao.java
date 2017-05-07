package com.zcbspay.platform.manager.merchant.dao;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.merchant.pojo.PojoContractBatch;

public interface ContractBarchDao extends BaseDAO<PojoContractBatch> {

	/**
	 * 新增批次信息
	 * @param batchNo
	 * @return
	 */
	boolean saveBatch(PojoContractBatch batch);
	
	/**
	 * 验证批次号
	 * @param batchNo
	 * @param merchNo
	 * @return
	 */
	boolean queryContractBatch(String batchNo,String merchNo);
	
}
