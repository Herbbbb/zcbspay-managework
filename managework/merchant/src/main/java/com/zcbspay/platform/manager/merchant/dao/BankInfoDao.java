package com.zcbspay.platform.manager.merchant.dao;

import java.util.List;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.merchant.pojo.PojoBankInfo;

public interface BankInfoDao extends BaseDAO<PojoBankInfo> {

	/**
	 * 获取银行信息
	 * @param bankNode
	 * @return
	 */
	List<?> queryBankInfo(String bankNode);
}
