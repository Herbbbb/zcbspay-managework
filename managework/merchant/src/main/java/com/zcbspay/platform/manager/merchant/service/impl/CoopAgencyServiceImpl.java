package com.zcbspay.platform.manager.merchant.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.exception.ContractException;
import com.zcbspay.platform.manager.merchant.bean.CoopAgencyBean;
import com.zcbspay.platform.manager.merchant.bean.SplitByAccNumsBean;
import com.zcbspay.platform.manager.merchant.dao.CoopAgencyDao;
import com.zcbspay.platform.manager.merchant.dao.SplitByAccNumsDao;
import com.zcbspay.platform.manager.merchant.pojo.PojoCoopAgency;
import com.zcbspay.platform.manager.merchant.service.CoopAgencyService;

@Service("coopAgencyService")
public class CoopAgencyServiceImpl implements CoopAgencyService {

	@Autowired
	private CoopAgencyDao coopAgencyDao;
	@Autowired
	private SplitByAccNumsDao splitByAccNumsDao;

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

	@Override
	public Map<String, Object> findSplitAll(Map<String, Object> result, Integer page, Integer rows) {
		return splitByAccNumsDao.findSplitAll(result,page,rows);
	}

	@Override
	public Map<String, Object> addSplit(SplitByAccNumsBean split) {
		return splitByAccNumsDao.addSplit(split);
	}

	@Override
	public SplitByAccNumsBean findSplitById(String tId) {
		return splitByAccNumsDao.findSplitById(tId);
	}

	@Override
	public Map<String, Object> editSplit(SplitByAccNumsBean split) {
		return splitByAccNumsDao.editSplit(split);
	}

	@Override
	public Map<String, Object> deleteSplit(String tId) {
		return splitByAccNumsDao.deleteSplit(tId);
	}

	@Override
	public Map<String, Object> queryProfit(Map<String, Object> result, Integer page, Integer rows) {
		return coopAgencyDao.queryProfit(result, page,rows);
	}

	@Override
	public CoopAgencyBean findByCode(String caCode) {
		PojoCoopAgency pojo = (PojoCoopAgency) coopAgencyDao.findByCode(caCode).get(0);
		CoopAgencyBean bean = new CoopAgencyBean();
		try {
			BeanUtils.copyProperties(pojo, bean);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return bean;
	}
	
}
