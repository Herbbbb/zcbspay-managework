package com.zcbspay.platform.manager.system.service;

import java.util.List;

import com.zcbspay.platform.manager.system.bean.CityBean;

public interface CityService {

	/**
	 * @param pid
	 * @return
	 */
	public List<?> findNotMuniByPid(Long pid);

	/**
	 * 
	 * @param cCode
	 * @return
	 */
	public CityBean findByPid(String CCode);
	
}

