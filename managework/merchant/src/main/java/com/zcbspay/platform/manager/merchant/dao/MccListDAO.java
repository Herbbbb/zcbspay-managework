package com.zcbspay.platform.manager.merchant.dao;

import java.util.List;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.merchant.pojo.PojoMccList;

public interface MccListDAO extends BaseDAO<PojoMccList>{

	/**
     * 产品类型
     * @return
     */
	List<?> findAll(); 

}
