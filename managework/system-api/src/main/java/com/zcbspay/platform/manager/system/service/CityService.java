package com.zcbspay.platform.manager.system.service;

import java.util.List;

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
	public List<?> findByPid(String CCode);
	
}

