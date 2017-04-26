package com.zcbspay.platform.manager.system.dao;

import java.util.List;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.system.bean.ProvinceBean;
import com.zcbspay.platform.manager.system.pojo.PojoProvince;

public interface ProvinceDao extends BaseDAO<PojoProvince>{

	/**
	 * 查询所有
	 * @return
	 */
	public List<?> findAll();

	/**
	 * 查询省
	 * @param pId
	 * @return
	 */
	public ProvinceBean findById(String pId);
}
