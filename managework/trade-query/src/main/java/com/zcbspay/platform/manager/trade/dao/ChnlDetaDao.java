package com.zcbspay.platform.manager.trade.dao;

import java.util.List;

import com.zcbspay.platform.manager.dao.BaseDAO;

public interface ChnlDetaDao extends BaseDAO<String> {
	/**
	 * 获取所有的交易渠道
	 * @author: zhangshd
	 * @return List<?>
	 * @date: 2017年3月2日 下午3:04:45 
	 * @version v1.0
	 */
	public List<?> getAllChannelCodeList();

}
