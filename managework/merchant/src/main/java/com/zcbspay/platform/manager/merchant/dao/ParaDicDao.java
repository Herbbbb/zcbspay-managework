package com.zcbspay.platform.manager.merchant.dao;

import java.util.List;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.merchant.pojo.PojoParaDic;

public interface ParaDicDao extends BaseDAO<PojoParaDic> {

	/**
	 * 查询扣率版本
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
