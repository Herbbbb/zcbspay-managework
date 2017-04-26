package com.zcbspay.platform.manager.risk.service;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.risk.bean.LimitMemCreditDayBean;
import com.zcbspay.platform.manager.risk.bean.LimitMemCreditMonthBean;
import com.zcbspay.platform.manager.risk.bean.LimitMemDayBean;
import com.zcbspay.platform.manager.risk.bean.LimitMemMonthBean;
import com.zcbspay.platform.manager.risk.bean.LimitPerdayBean;
import com.zcbspay.platform.manager.risk.bean.LimitSingleBean;

public interface LimitPerdayService {
	public List<?> query_risk_all() ;
    public String AddOneLimitPerday(LimitPerdayBean limitPerday);
    public Map<String, Object> queryOneLimitPerday(String tId);
	public Map<String, Object> findLimitPerdayByPage(Map<String, Object> variables, int page,int rows);
    public String updateOneLimitPerday(LimitPerdayBean limitPerday);
    public String deleteOneLimitPerday(String tId);
    public String startOneLimitPerday(String tId);
    
    
    public Map<String, Object> findLimitMemCreditDayByPage(Map<String, Object> variables, int page,int rows);
    public String AddOneLimitMemCreditDay(LimitMemCreditDayBean Mem);
    public Map<String, Object> queryOneLimitMemCreditDay(String tId);
    public String UpdateLimitMemCreditDay(LimitMemCreditDayBean Mem);
    public String deleteLimitMemCreditDay(String tId);
    public String startLimitMemCreditDay(String tId);
    
    public Map<String, Object> findLimitMemCreditMonthByPage(Map<String, Object> variables, int page,int rows);
    public String AddOneLimitMemCreditMonth(LimitMemCreditMonthBean Mem);
    public Map<String, Object> queryOneLimitMemCreditMonth(String tId);	 
    public String UpdateLimitMemCreditMonth(LimitMemCreditMonthBean Mem); 
    public String deleteLimitMemCreditMonth(String tId);
    public String startLimitMemCreditMonth(String tId);
    
    public Map<String, Object> findLimitMemMonthByPage(Map<String, Object> variables, int page,int rows);
    public String AddOneLimitMemMonth(LimitMemMonthBean Mem);
    public Map<String, Object> queryOneLimitMemMonth(String tId); 
    public String UpdateLimitMemMonth(LimitMemMonthBean Mem);  
    public String deleteLimitMemMonth(String tId,Long userid);
    public String startLimitMemMonth(String tId,Long userid);	
    
    public Map<String, Object> findLimitMemDayByPage(Map<String, Object> variables, int page,int rows);
    public String AddOneLimitMemDay(LimitMemDayBean Mem);
    public Map<String, Object> queryOneLimitMemDay(String tId);	 
    public String UpdateLimitMemDay(LimitMemDayBean Mem);
    public String deleteLimitMemDay(String tId,Long userid);
    public String startLimitMemDay(String tId,Long userid);
    
    public Map<String, Object> findLimitSingleByPage(Map<String, Object> variables, int page,int rows);
    public String AddOneLimitSingle(LimitSingleBean limitSingle);
    public String updateOneLimitSingle(LimitSingleBean limitSingle);     
    public Map<String, Object> queryOneLimitSingle(String tId);
    public String deleteOneLimitSingle(String tId);
    public String startOneLimitSingle(String tId);
     
}
