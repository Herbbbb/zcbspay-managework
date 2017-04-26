package com.zcbspay.platform.manager.trade.dao;

import java.util.List;

import com.zcbspay.platform.manager.dao.BaseDAO;

public interface BusinessDao extends BaseDAO<String> {
	/**
	 * 获取全部的交易类型
	 * @author: zhangshd
	 * @return List<?>
	 * @date: 2017年3月2日 下午2:24:07
	 * @version v1.0
	 */
	public List<?> getAllBusiness();

}
