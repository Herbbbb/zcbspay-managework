package com.zcbspay.platform.manager.system.service;

import java.util.List;

import com.zcbspay.platform.manager.system.bean.ProvinceBean;

public interface ProvinceService {

	/**
	 * @return
	 */
	public List<ProvinceBean> findAll();

	/**
	 * 查询省
	 * @param pId
	 * @return
	 */
	public ProvinceBean findById(String pId);
}
