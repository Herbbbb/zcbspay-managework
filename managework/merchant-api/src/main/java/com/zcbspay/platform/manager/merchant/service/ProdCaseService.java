package com.zcbspay.platform.manager.merchant.service;

import java.util.List;

public interface ProdCaseService {


	/**
	 * 查询扣率类型
	 * @return
	 */
	List<?> findParaDic();

	/**
	 * 查询扣率名称
	 * @param busiCode
	 * @return
	 */
	List<?> findParaById(String busiCode);
}
