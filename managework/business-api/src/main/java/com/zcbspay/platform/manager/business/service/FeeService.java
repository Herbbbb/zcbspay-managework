package com.zcbspay.platform.manager.business.service;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.business.bean.AccumulateRateBean;
import com.zcbspay.platform.manager.business.bean.BusiRateBean;
import com.zcbspay.platform.manager.business.bean.CardRateBean;
import com.zcbspay.platform.manager.business.bean.CommonRateBean;
import com.zcbspay.platform.manager.business.bean.NewCardRateBean;
import com.zcbspay.platform.manager.business.bean.StepRateBean;

public interface FeeService {
	/**
	 * 查选所有扣率信息
	 * @author: zhangshd
	 * @return List<?>
	 * @date: 2017年2月24日 上午10:39:49 
	 * @version v1.0
	 */
	public List<?> queryFeeAll();
	/**
	 * 分页查询业务扣率
	 * @author: zhangshd
	 * @param variables
	 * @param page
	 * @param rows
	 * @return Map<String,Object>
	 * @date: 2017年2月24日 上午10:40:04 
	 * @version v1.0
	 */
	public Map<String, Object> findBusiRateByPage(BusiRateBean variables, String page, String rows);
	/**
	 * 扣率版本下的业务实例
	 * @author: zhangshd
	 * @param feever
	 * @return List<?>
	 * @date: 2017年2月24日 上午10:40:15 
	 * @version v1.0
	 */
	public List<?> queryFeeCaseByFeever(String feever);
	/**
	 *  查询一条扣率版本实例信息
	 * @author: zhangshd
	 * @param caseid
	 * @return Map<String,Object>
	 * @date: 2017年2月24日 上午10:40:22 
	 * @version v1.0
	 */
	public Map<String, Object> queryOneBusiRate(String caseid);
	
	/**
	 * 修改扣率实例
	 * @author: zhangshd
	 * @param busiRateEntity
	 * @return String
	 * @date: 2017年2月24日 上午10:40:28 
	 * @version v1.0
	 */
	public String updateBusiRate(BusiRateBean busiRateEntity);
	/**
	 * 添加扣率实例
	 * @author: zhangshd
	 * @param busiRate
	 * @return String
	 * @date: 2017年2月24日 上午10:40:36 
	 * @version v1.0
	 */
	public String addOneBusiRate(BusiRateBean busiRate);
	/**
	 * 卡扣率分页查询
	 * @author: zhangshd
	 * @param variables
	 * @param page
	 * @param rows
	 * @return Map<String,Object>
	 * @date: 2017年2月24日 上午10:40:42 
	 * @version v1.0
	 */
	public Map<String, Object> findCardRateByPage(Map<String, Object> variables, String page, String rows);
	/**
	 * 查询一条卡扣率版本实例信息
	 * @author: zhangshd
	 * @param caseid
	 * @return Map<String,Object>
	 * @date: 2017年2月24日 上午10:40:48 
	 * @version v1.0
	 */
	public Map<String, Object> queryOneCardRate(String caseid);
	/**
	 * 更新卡扣率信息
	 * @author: zhangshd
	 * @param cardrate
	 * @return String
	 * @date: 2017年2月24日 上午10:40:54 
	 * @version v1.0
	 */
	public String updateCardRate(CardRateBean cardrate);
	/**
	 * 添加卡扣率信息
	 * @author: zhangshd
	 * @param cardRateEntity
	 * @return String
	 * @date: 2017年2月24日 上午10:41:01 
	 * @version v1.0
	 */
	public String addOneCardRate(CardRateBean cardRateEntity);
	/**
	 * 添加常规扣率信息
	 * @author: zhangshd
	 * @param rateModel
	 * @return String
	 * @date: 2017年2月24日 上午10:41:07 
	 * @version v1.0
	 */
	public String addOneCommonRate(CommonRateBean rateModel);
	/**
	 * 查询扣率类型
	 * @author: zhangshd
	 * @return List<?>
	 * @date: 2017年2月24日 上午10:41:13 
	 * @version v1.0
	 */
	public List<?> queryRateType();
	/**
	 * 分页查询常规扣率版本
	 * @author: zhangshd
	 * @param variables
	 * @param page
	 * @param rows
	 * @return Map<String,Object>
	 * @date: 2017年2月24日 上午10:41:18 
	 * @version v1.0
	 */
	public Map<String, Object> findCommonRateByPage(CommonRateBean variables, String page, String rows);
	/**
	 * 查询一条常规扣率版本
	 * @author: zhangshd
	 * @param caseid
	 * @return Map<String,Object>
	 * @date: 2017年2月24日 上午10:41:24 
	 * @version v1.0
	 */
	public Map<String, Object> queryOneCommonRate(String caseid);
	/**
	 * 更新常规费率
	 * @author: zhangshd
	 * @param rateEntity
	 * @return String
	 * @date: 2017年2月24日 上午10:41:29 
	 * @version v1.0
	 */
	public String updateCommonRate(CommonRateBean rateEntity);
	/**
	 * 添加新卡类型扣率
	 * @author: zhangshd
	 * @param cardRateEntity
	 * @return String
	 * @date: 2017年2月24日 上午10:41:34 
	 * @version v1.0
	 */
	public String saveNewCardRate(NewCardRateBean cardRateEntity);
	/**
	 * 新卡扣率分页查询
	 * @author: zhangshd
	 * @param variables
	 * @param page
	 * @param rows
	 * @return Map<String,Object>
	 * @date: 2017年2月24日 上午10:41:39 
	 * @version v1.0
	 */
	public Map<String, Object> findNewCardRateByPage(NewCardRateBean variables, String page, String rows);
	/**
	 * 查询一条新卡类型扣率版本实例信息
	 * @author: zhangshd
	 * @param caseid
	 * @return Map<String,Object>
	 * @date: 2017年2月24日 上午10:41:44 
	 * @version v1.0
	 */
	public Map<String, Object> queryOneNewCardRate(String caseid);
	/**
	 *  更新新的卡扣率信息
	 * @author: zhangshd
	 * @param cardrate
	 * @return String
	 * @date: 2017年2月24日 上午10:41:49 
	 * @version v1.0
	 */
	public String updateNewCardRate(NewCardRateBean cardrate);
	/**
	 *  添加分段扣率信息
	 * @author: zhangshd
	 * @param stepRateBean
	 * @return String
	 * @date: 2017年2月24日 上午10:41:54 
	 * @version v1.0
	 */
	public String AddOneStepRate(StepRateBean stepRateBean);
	/**
	 * 分页查询分段扣率信息
	 * @author: zhangshd
	 * @param stepRateBean
	 * @param page
	 * @param rows
	 * @return Map<String,Object>
	 * @date: 2017年2月24日 上午10:42:02 
	 * @version v1.0
	 */
	public  Map<String, Object> findStpeRateByPage(StepRateBean stepRateBean, String page, String rows);
	/**
	 * 查询一条分段扣率版本实例信息
	 * @author: zhangshd
	 * @param caseid
	 * @return Map<String,Object>
	 * @date: 2017年2月24日 上午10:42:08 
	 * @version v1.0
	 */
	public Map<String, Object> queryOneStepRate(String caseid);
	/**
	 * 更新分段扣率信息
	 * @author: zhangshd
	 * @param stepRateBean
	 * @return String
	 * @date: 2017年2月24日 上午10:42:13 
	 * @version v1.0
	 */
	public String updateStepRate(StepRateBean stepRateBean);
	/**
	 * 添加累计分段扣率信息
	 * @author: zhangshd
	 * @param accumulateRateBean
	 * @return String
	 * @date: 2017年2月24日 上午10:42:18 
	 * @version v1.0
	 */
	public String addOneAccumulateRate(AccumulateRateBean accumulateRateBean);
	/**
	 * 分页查询累计分段扣率信息
	 * @author: zhangshd
	 * @param accumulateRateBean
	 * @param page
	 * @param rows
	 * @return Map<String,Object>
	 * @date: 2017年2月24日 上午10:42:23 
	 * @version v1.0
	 */
	public Map<String, Object> findAccumulateRateByPage(AccumulateRateBean accumulateRateBean, String page,
			String rows);
	/**
	 * 查询累计分段扣率
	 * @author: zhangshd
	 * @param caseid
	 * @return Map<String,Object>
	 * @date: 2017年2月24日 上午10:42:29 
	 * @version v1.0
	 */
	public Map<String, Object> queryOneAccumulateRate(String caseid);
	/**
	 * 更新累计分段扣率信息
	 * 
	 * @return
	 */
	public String updateAccumulateRate(AccumulateRateBean accumulateRateBean);
}
