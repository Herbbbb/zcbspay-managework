package com.zcbspay.platform.manager.risk.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.risk.bean.LimitMemCreditDayBean;
import com.zcbspay.platform.manager.risk.bean.LimitMemCreditMonthBean;
import com.zcbspay.platform.manager.risk.bean.LimitMemDayBean;
import com.zcbspay.platform.manager.risk.bean.LimitMemMonthBean;
import com.zcbspay.platform.manager.risk.bean.LimitPerdayBean;
import com.zcbspay.platform.manager.risk.bean.LimitSingleBean;
import com.zcbspay.platform.manager.risk.dao.LimitPerdayDao;
import com.zcbspay.platform.manager.risk.service.LimitPerdayService;

@Service("limitPerdayService")
public class LimitPerdayServiceImpl implements LimitPerdayService {
	@Autowired
	private LimitPerdayDao limitPerdayDao;
	
	@Override
	public List<?> query_risk_all() {
		return limitPerdayDao.query_risk_all();
	}

	@Override
	public String AddOneLimitPerday(LimitPerdayBean limitPerday) {
		return limitPerdayDao.AddOneLimitPerday(limitPerday);
	}

	@Override
	public Map<String, Object> queryOneLimitPerday(String tId) {
		return limitPerdayDao.queryOneLimitPerday(tId);
	}

	@Override
	public Map<String, Object> findLimitPerdayByPage(Map<String, Object> variables, int page, int rows) {
		return limitPerdayDao.findLimitPerdayByPage(variables, page, rows);
	}

	@Override
	public String updateOneLimitPerday(LimitPerdayBean limitPerday) {
		return limitPerdayDao.updateOneLimitPerday(limitPerday);
	}

	@Override
	public String deleteOneLimitPerday(String tId) {
		return limitPerdayDao.deleteOneLimitPerday(tId);
	}

	@Override
	public String startOneLimitPerday(String tId) {
		return limitPerdayDao.startOneLimitPerday(tId);
	}

	@Override
	public Map<String, Object> findLimitMemCreditDayByPage(Map<String, Object> variables, int page, int rows) {
		return limitPerdayDao.findLimitMemCreditDayByPage(variables, page, rows);
	}

	@Override
	public String AddOneLimitMemCreditDay(LimitMemCreditDayBean Mem) {
		return limitPerdayDao.AddOneLimitMemCreditDay(Mem);
	}

	@Override
	public Map<String, Object> queryOneLimitMemCreditDay(String tId) {
		return limitPerdayDao.queryOneLimitMemCreditDay(tId);
	}

	@Override
	public String UpdateLimitMemCreditDay(LimitMemCreditDayBean Mem) {
		return limitPerdayDao.UpdateLimitMemCreditDay(Mem);
	}

	@Override
	public String deleteLimitMemCreditDay(String tId) {
		return limitPerdayDao.deleteLimitMemCreditDay(tId);
	}

	@Override
	public String startLimitMemCreditDay(String tId) {
		return limitPerdayDao.startLimitMemCreditDay(tId);
	}

	@Override
	public Map<String, Object> findLimitMemCreditMonthByPage(Map<String, Object> variables, int page, int rows) {
		return limitPerdayDao.findLimitMemCreditMonthByPage(variables, page, rows);
	}

	@Override
	public String AddOneLimitMemCreditMonth(LimitMemCreditMonthBean Mem) {
		return limitPerdayDao.AddOneLimitMemCreditMonth(Mem);
	}

	@Override
	public Map<String, Object> queryOneLimitMemCreditMonth(String tId) {
		return limitPerdayDao.queryOneLimitMemCreditMonth(tId);
	}

	@Override
	public String UpdateLimitMemCreditMonth(LimitMemCreditMonthBean Mem) {
		return limitPerdayDao.UpdateLimitMemCreditMonth(Mem);
	}

	@Override
	public String deleteLimitMemCreditMonth(String tId) {
		return limitPerdayDao.deleteLimitMemCreditMonth(tId);
	}

	@Override
	public String startLimitMemCreditMonth(String tId) {
		return limitPerdayDao.startLimitMemCreditMonth(tId);
	}

	@Override
	public Map<String, Object> findLimitMemMonthByPage(Map<String, Object> variables, int page, int rows) {
		return limitPerdayDao.findLimitMemMonthByPage(variables, page, rows);
	}

	@Override
	public String AddOneLimitMemMonth(LimitMemMonthBean Mem) {
		return limitPerdayDao.AddOneLimitMemMonth(Mem);
	}

	@Override
	public Map<String, Object> queryOneLimitMemMonth(String tId) {
		return limitPerdayDao.queryOneLimitMemMonth(tId);
	}

	@Override
	public String UpdateLimitMemMonth(LimitMemMonthBean Mem) {
		return limitPerdayDao.UpdateLimitMemMonth(Mem);
	}

	@Override
	public String deleteLimitMemMonth(String tId, Long userid) {
		return limitPerdayDao.deleteLimitMemMonth(tId, userid);
	}

	@Override
	public String startLimitMemMonth(String tId, Long userid) {
		return limitPerdayDao.startLimitMemMonth(tId, userid);
	}

	@Override
	public Map<String, Object> findLimitMemDayByPage(Map<String, Object> variables, int page, int rows) {
		return limitPerdayDao.findLimitMemDayByPage(variables, page, rows);
	}

	@Override
	public String AddOneLimitMemDay(LimitMemDayBean Mem) {
		return limitPerdayDao.AddOneLimitMemDay(Mem);
	}

	@Override
	public Map<String, Object> queryOneLimitMemDay(String tId) {
		return limitPerdayDao.queryOneLimitMemDay(tId);
	}

	@Override
	public String UpdateLimitMemDay(LimitMemDayBean Mem) {
		return limitPerdayDao.UpdateLimitMemDay(Mem);
	}

	@Override
	public String deleteLimitMemDay(String tId, Long userid) {
		return limitPerdayDao.deleteLimitMemDay(tId, userid);
	}

	@Override
	public String startLimitMemDay(String tId, Long userid) {
		return limitPerdayDao.startLimitMemDay(tId, userid);
	}

	@Override
	public Map<String, Object> findLimitSingleByPage(Map<String, Object> variables, int page, int rows) {
		return limitPerdayDao.findLimitSingleByPage(variables, page, rows);
	}

	@Override
	public String AddOneLimitSingle(LimitSingleBean limitSingle) {
		return limitPerdayDao.AddOneLimitSingle(limitSingle);
	}

	@Override
	public String updateOneLimitSingle(LimitSingleBean limitSingle) {
		return limitPerdayDao.updateOneLimitSingle(limitSingle);
	}

	@Override
	public Map<String, Object> queryOneLimitSingle(String tId) {
		return limitPerdayDao.queryOneLimitSingle(tId);
	}

	@Override
	public String deleteOneLimitSingle(String tId) {
		return limitPerdayDao.deleteOneLimitSingle(tId);
	}

	@Override
	public String startOneLimitSingle(String tId) {
		return limitPerdayDao.startOneLimitSingle(tId);
	}

}
