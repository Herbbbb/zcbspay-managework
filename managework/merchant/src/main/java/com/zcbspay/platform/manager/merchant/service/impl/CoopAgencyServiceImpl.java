package com.zcbspay.platform.manager.merchant.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.exception.ContractException;
import com.zcbspay.platform.manager.merchant.bean.CoopAgencyBean;
import com.zcbspay.platform.manager.merchant.dao.CoopAgencyDao;
import com.zcbspay.platform.manager.merchant.service.CoopAgencyService;

@Service("coopAgencyService")
public class CoopAgencyServiceImpl implements CoopAgencyService {

	@Autowired
	private CoopAgencyDao coopAgencyDao;

	@Override
	public Map<String, Object> findAll(Map<String, Object> result, Integer page, Integer rows) {
		return coopAgencyDao.findAll(result, page,rows);
	}

	@Override
	public Map<String, Object> addCoopAgency(CoopAgencyBean coop) {
		
		return coopAgencyDao.addCoopAgency(coop);
	}

	@Override
	public List<?> findById(String tId) {
		
		return coopAgencyDao.findById(tId);
	}

	@Override
	public Map<String, Object> editCoopAgency(CoopAgencyBean coop) {
		
		return coopAgencyDao.editCoopAgency(coop);
	}

	@Override
	public Map<String, Object> deleteCoopAgency(String tId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = coopAgencyDao.deleteCoopAgency(tId);
		} catch(ContractException e){
			map.put("RET", "error");
			map.put("INFO", e.getMessage());
			return map;
		}
		return map;
	}

	@Override
	public List<?> queryProfitType() {
		return coopAgencyDao.queryProfitType();
	}
	
}
