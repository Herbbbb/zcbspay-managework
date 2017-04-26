package com.zcbspay.platform.manager.trade.dao;

import java.util.Map;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.trade.bean.CnapsLogBean;

public interface CnapsLogDao extends BaseDAO<String> {
	/**
	 * CNAPS核心交易分页查询
	 * @author: zhangshd
	 * @return String
	 * @date: 2017年3月2日 下午3:14:43
	 * @version v1.0
	 */
	Map<String, Object> getCnapsLogByPage(String page, String rows, CnapsLogBean values);

}
