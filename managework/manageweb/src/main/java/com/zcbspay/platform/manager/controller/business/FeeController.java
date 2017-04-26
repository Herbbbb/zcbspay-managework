package com.zcbspay.platform.manager.controller.business;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zcbspay.platform.manager.business.bean.AccumulateRateBean;
import com.zcbspay.platform.manager.business.bean.BusiRateBean;
import com.zcbspay.platform.manager.business.bean.CardRateBean;
import com.zcbspay.platform.manager.business.bean.CommonRateBean;
import com.zcbspay.platform.manager.business.bean.NewCardRateBean;
import com.zcbspay.platform.manager.business.bean.StepRateBean;
import com.zcbspay.platform.manager.business.service.FeeService;
import com.zcbspay.platform.manager.utils.JsonUtils;
import com.zcbspay.platform.manager.utils.UserHelper;
/**
 * 扣率相关的类
 * @author: zhangshd
 * @date:   2017年2月24日 上午10:04:26   
 * @version :1.0
 */
@Controller
@RequestMapping("/fee/")
public class FeeController {

	@Autowired
	private FeeService feeService;
	
	/**
	 * 业务类型扣率
	 * @author: zhangshd
	 * @return String
	 * @date: 2017年2月24日 上午10:25:36 
	 * @version v1.0
	 */
	@RequestMapping("showBusiRate")
	public String showBusiRate() {
		return "fee/txn_rate_manager";
	}
	/**
	 * 卡类型扣率
	 * @author: zhangshd
	 * @return String
	 * @date: 2017年2月24日 上午10:25:57 
	 * @version v1.0
	 */
	@RequestMapping("showCardRate")
	public String showCardRate() {
		return "fee/card_rate_manager";
	}
	
	/**
	 * 常规类型扣率
	 * @author: zhangshd
	 * @return String
	 * @date: 2017年2月24日 上午10:26:16 
	 * @version v1.0
	 */
	@RequestMapping("showCommonRate")
	public String showCommonRate() {
		return "fee/_rate_common_manager";
	}
	
	/**
	 * 分段类型扣率
	 * @author: zhangshd
	 * @return String
	 * @date: 2017年2月24日 上午10:26:32 
	 * @version v1.0
	 */
	@RequestMapping("showStpeRate")
	public String showStpeRate() {
		return "fee/_rate_step_manager";
	}
	/**
	 * 新版卡类型扣率
	 * @author: zhangshd
	 * @return String
	 * @date: 2017年2月24日 上午10:27:01 
	 * @version v1.0
	 */
	@RequestMapping("showNewCardRate")
	public String showNewCardRate() {
		return "fee/_rate_card_manager";
	}
	/**
	 * 累计分段扣率
	 * @author: zhangshd
	 * @return String
	 * @date: 2017年2月24日 上午10:27:18 
	 * @version v1.0
	 */
	@RequestMapping("showAccumulateRate")
	public String showAccumulateRate() {
		return "fee/_rate_accumulate_manager";
	}
	/**
	 * 查询所有扣率版本
	 * @author: zhangshd
	 * @return List<?>
	 * @date: 2017年2月24日 上午10:27:34 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryFeeAll")
	public List<?> queryFeeAll() {
		List<?> resultList = feeService.queryFeeAll();
		return resultList;
	}
	
	/**
	 * 业务类型扣率分页查询
	 * @author: zhangshd
	 * @param request
	 * @param busiRateEntity
	 * @param page
	 * @param rows
	 * @return Map<String, Object>
	 * @date: 2017年2月24日 上午10:25:07 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryTxnRate")
	public Map<String, Object> queryTxnRate(HttpServletRequest request, BusiRateBean busiRateEntity, String page,
			String rows) {
		busiRateEntity.setInuser(UserHelper.getCurrentUser(request).getUserId().toString());
		Map<String, Object> busiList = feeService.findBusiRateByPage(busiRateEntity, page, rows);
		return busiList;
	}
	/**
	 * 常规扣率版本分页查询
	 * @author: zhangshd
	 * @param request
	 * @param rateBean
	 * @param page
	 * @param rows
	 * @return Map<String, Object>
	 * @date: 2017年2月24日 上午10:29:05 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryCommonRate")
	public Map<String, Object> queryCommonRate(HttpServletRequest request,CommonRateBean rateBean, String page,
			String rows) {
		rateBean.setInuser(UserHelper.getCurrentUser(request).getUserId().toString());
		Map<String, Object> busiList = feeService.findCommonRateByPage(rateBean, page, rows);
		return busiList;
	}
	/**
	 * 扣率版本下的业务实例
	 * @author: zhangshd
	 * @param feever
	 * @return List<?>
	 * @date: 2017年2月24日 上午10:29:29 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryFeeCaseByFeever")
	public List<?> queryFeeCaseByFeever(String feever) {
		List<?> resultList = feeService.queryFeeCaseByFeever(feever);
		return resultList;
	}
	/**
	 * 查询业务扣率详细信息
	 * @author: zhangshd
	 * @param caseid
	 * @return Map<String, Object>
	 * @date: 2017年2月24日 上午10:29:41 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryOneBusiRate")
	public Map<String, Object> queryOneBusiRate(String caseid) {
		Map<String, Object> feecase = feeService.queryOneBusiRate(caseid);
		return feecase;
	}
	
	
	/**
	 * 查询一条常规扣率版本实例信息
	 * @author: zhangshd
	 * @param caseid
	 * @return Map<String, Object>
	 * @date: 2017年2月24日 上午10:30:36 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryOneCommonRate")
	public Map<String, Object> queryOneCommonRate(String caseid) {
		Map<String, Object> feecase = feeService.queryOneCommonRate(caseid);
		return feecase;
	}

	/**
	 * 修改业务扣率实例
	 * @author: zhangshd
	 * @param busiRateEntity
	 * @param response
	 * @date: 2017年2月24日 上午10:31:06 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("updateBusiRate")
	public void updateBusiRate(BusiRateBean busiRateEntity, HttpServletResponse response) {
		String mark = feeService.updateBusiRate(busiRateEntity);
		JsonUtils.json_encodeAndWrite(response, mark);
	}
	/**
	 * 修改常规扣率实例
	 * @author: zhangshd
	 * @param rateEntity
	 * @param response
	 * @date: 2017年2月24日 上午10:31:16 
	 * @version v1.0
	 */
	
	@ResponseBody
	@RequestMapping("updateCommonRate")
	public void updateCommonRate(CommonRateBean rateEntity, HttpServletResponse response) {
		String mark = feeService.updateCommonRate(rateEntity);
		JsonUtils.json_encodeAndWrite(response, mark);
	}
	/**
	 *  添加业务扣率实例
	 * @author: zhangshd
	 * @param busiRateModel
	 * @param request
	 * @param response
	 * @date: 2017年2月24日 上午10:31:25 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("saveTxnRate")
	public void saveTxnRate(BusiRateBean busiRateModel, HttpServletRequest request, HttpServletResponse response) {
		busiRateModel.setInuser(UserHelper.getCurrentUser(request).getUserId().toString());
		String mark = feeService.addOneBusiRate(busiRateModel);
		JsonUtils.json_encodeAndWrite(response, mark);
	}
	/**
	 * 添加常规扣率
	 * @author: zhangshd
	 * @param rateModel
	 * @param request
	 * @param response
	 * @date: 2017年2月24日 上午10:31:47 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("saveCommonRate")
	public void saveCommonRate(CommonRateBean rateModel, HttpServletRequest request, HttpServletResponse response) {
		rateModel.setInuser(UserHelper.getCurrentUser(request).getUserId().toString());
		String mark = feeService.addOneCommonRate(rateModel);
		JsonUtils.json_encodeAndWrite(response, mark);
	}

	/**
	 * 新卡扣率分页查询
	 * @author: zhangshd
	 * @param cardRateEntity
	 * @param page
	 * @param rows
	 * @param request
	 * @param response
	 * @return Map<String, Object>
	 * @date: 2017年2月24日 上午10:32:00 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryNewCardRate")
	public Map<String, Object> queryNewCardRate(NewCardRateBean cardRateEntity, String page, String rows,
			HttpServletRequest request, HttpServletResponse response) {
		cardRateEntity.setInuser(UserHelper.getCurrentUser(request).getUserId());
		Map<String, Object> busiList = feeService.findNewCardRateByPage(cardRateEntity, page, rows);
		return busiList;
	}

	/**
	 * 查询一条卡扣率版本实例信息
	 * @author: zhangshd
	 * @param caseid
	 * @return Map<String,Object>
	 * @date: 2017年2月24日 上午10:33:00 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryOneCardRate")
	public Map<String, Object> queryOneCardRate(String caseid) {
		Map<String, Object> feecase = feeService.queryOneCardRate(caseid);
		return feecase;
	}
	/**
	 * 查询一条新卡类型扣率版本实例信息
	 * @author: zhangshd
	 * @param caseid
	 * @return Map<String,Object>
	 * @date: 2017年2月24日 上午10:34:54 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryOneNewCardRate")
	public Map<String, Object> queryOneNewCardRate(String caseid) {
		Map<String, Object> feecase = feeService.queryOneNewCardRate(caseid);
		return feecase;
	}

	/**
	 * 更新新的卡扣率信息
	 * @author: zhangshd
	 * @param cardrate
	 * @param response void
	 * @date: 2017年2月24日 上午10:35:01 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("updateNewCardRate")
	public void updateNewCardRate(NewCardRateBean cardrate, HttpServletResponse response) {
		String mark = feeService.updateNewCardRate(cardrate);
		JsonUtils.json_encodeAndWrite(response, mark);

	}

	/**
	 *  添加卡扣率信息
	 * @author: zhangshd
	 * @param cardRateEntity
	 * @param request
	 * @param response void
	 * @date: 2017年2月24日 上午10:35:08 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("saveCardRate")
	public void saveCardRate(CardRateBean cardRateEntity, HttpServletRequest request, HttpServletResponse response) {
		cardRateEntity.setInuser(UserHelper.getCurrentUser(request).getUserId());
		String mark = feeService.addOneCardRate(cardRateEntity);
		JsonUtils.json_encodeAndWrite(response, mark);
	}
	
	/**
	 * 添加新卡扣率信息
	 * @author: zhangshd
	 * @param cardRateEntity
	 * @param request
	 * @param response void
	 * @date: 2017年2月24日 上午10:35:15 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("saveNewCardRate")
	public void saveNewCardRate(NewCardRateBean cardRateEntity, HttpServletRequest request, HttpServletResponse response) {
		cardRateEntity.setInuser(UserHelper.getCurrentUser(request).getUserId());
		String mark = feeService.saveNewCardRate(cardRateEntity);
		JsonUtils.json_encodeAndWrite(response, mark);
	}

	/**
	 * 查询扣率类型
	 * @author: zhangshd
	 * @return List<?>
	 * @date: 2017年2月24日 上午10:35:21 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryRateType")
	public List<?> queryRateType() {
		List<?> resultList = feeService.queryRateType();
		return resultList;
	}
	
	/**
	 * 添加分段扣率信息
	 * @author: zhangshd
	 * @param stepRateBean
	 * @param request
	 * @param response void
	 * @date: 2017年2月24日 上午10:35:28 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("saveStepRate")
	public void saveStepRate(StepRateBean stepRateBean, HttpServletRequest request, HttpServletResponse response) {
		stepRateBean.setInuser(UserHelper.getCurrentUser(request).getUserId());
        String mark = feeService.AddOneStepRate(stepRateBean);
		JsonUtils.json_encodeAndWrite(response, mark);
	}
	
	/**
	 *  查询分段扣率信息
	 * @author: zhangshd
	 * @param stepRateBean
	 * @param request
	 * @param response
	 * @param page
	 * @param rows
	 * @return Map<String,Object>
	 * @date: 2017年2月24日 上午10:35:34 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryStepRate")
	public  Map<String, Object> queryStepRate(StepRateBean stepRateBean, HttpServletRequest request, HttpServletResponse response,String page, String rows) {
		stepRateBean.setInuser(UserHelper.getCurrentUser(request).getUserId());
        return feeService.findStpeRateByPage(stepRateBean,page,rows);
	}
	
	/**
	 * 查询一条分段扣率版本实例信息
	 * @author: zhangshd
	 * @param caseid
	 * @return Map<String,Object>
	 * @date: 2017年2月24日 上午10:35:40 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryOneStepRate")
	public Map<String, Object> queryOneStepRate(String caseid) {
		Map<String, Object> feecase = feeService.queryOneStepRate(caseid);
		return feecase;
	}
	
	/**
	 *  更新分段扣率信息
	 * @author: zhangshd
	 * @param stepRateBean
	 * @param response void
	 * @date: 2017年2月24日 上午10:35:45 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("updateStepRate")
	public void updateStepRate(StepRateBean stepRateBean, HttpServletResponse response) {
		String mark = feeService.updateStepRate(stepRateBean);
		JsonUtils.json_encodeAndWrite(response, mark);

	}
	
	
	/**
	 * 添加累计分段扣率信息
	 * @author: zhangshd
	 * @param accumulateRateBean
	 * @param request
	 * @param response void
	 * @date: 2017年2月24日 上午10:35:50 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("saveAccumulateRate")
	public void saveAccumulateRate(AccumulateRateBean accumulateRateBean, HttpServletRequest request, HttpServletResponse response) {
		accumulateRateBean.setInuser(UserHelper.getCurrentUser(request).getUserId());
        String mark = feeService.addOneAccumulateRate(accumulateRateBean);
		JsonUtils.json_encodeAndWrite(response, mark);
	}
	
	
	
	/**
	 * 分页查询累计分段扣率信息
	 * @author: zhangshd
	 * @param accumulateRateBean
	 * @param request
	 * @param response
	 * @param page
	 * @param rows
	 * @return Map<String,Object>
	 * @date: 2017年2月24日 上午10:35:57 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryAccumulateRate")
	public Map<String, Object> queryAccumulateRate(AccumulateRateBean accumulateRateBean, HttpServletRequest request, HttpServletResponse response,String page, String rows) {
	     accumulateRateBean.setInuser(UserHelper.getCurrentUser(request).getUserId());
	     Map<String, Object> resultList = feeService.findAccumulateRateByPage(accumulateRateBean, page, rows);
	     return resultList;   
	}
	
	
	/**
	 * 查询累计分段扣率
	 * @author: zhangshd
	 * @param caseid
	 * @return Map<String,Object>
	 * @date: 2017年2月24日 上午10:36:03 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryOneAccumulateRate")
	public Map<String, Object> queryOneAccumulateRate(String caseid) {
		Map<String, Object> feecase = feeService.queryOneAccumulateRate(caseid);
		return feecase;
	}

	
	/**
	 * 更新累计分段扣率信息
	 * @author: zhangshd
	 * @param accumulateRateBean
	 * @param response void
	 * @date: 2017年2月24日 上午10:36:10 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("updateAccumulateRate")
	public void updateAccumulateRate(AccumulateRateBean accumulateRateBean, HttpServletResponse response) {
		String mark = feeService.updateAccumulateRate(accumulateRateBean);
		JsonUtils.json_encodeAndWrite(response, mark);

	}
	
	
	
	
}
