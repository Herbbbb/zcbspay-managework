package com.zcbspay.platform.manager.controller.risk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zcbspay.platform.manager.risk.bean.LimitMemCreditDayBean;
import com.zcbspay.platform.manager.risk.bean.LimitMemCreditMonthBean;
import com.zcbspay.platform.manager.risk.bean.LimitMemDayBean;
import com.zcbspay.platform.manager.risk.bean.LimitMemMonthBean;
import com.zcbspay.platform.manager.risk.bean.LimitPerdayBean;
import com.zcbspay.platform.manager.risk.bean.LimitSingleBean;
import com.zcbspay.platform.manager.risk.bean.RiskCaseBean;
import com.zcbspay.platform.manager.risk.service.LimitPerdayService;
import com.zcbspay.platform.manager.system.bean.UserBean;

@Controller
@RequestMapping("/risk")
public class LimitController {
	
	@Autowired
	private LimitPerdayService limitPerdayService;

	/*@Autowired
	private RiskService riskService;*/
	
	@RequestMapping("/showPerday")
	public String showPerday() {
		return "/risk/limit_perday_manager";
	}
	// 对应页面功能模块：银行卡单日限次,卡类别日累计限额，单笔限额
	// --------------------------------------------------------------单卡单日限次------------------------------------------------------
	
	@ResponseBody
	@RequestMapping("/queryLimitPerdayByPage")
	public Map<String, Object> queryLimitPerdayByPage(HttpServletRequest request, RiskCaseBean riskCaseBean, int page, int rows) {
		Map<String, Object> variables = new HashMap<String, Object>();
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		variables.put("userId", loginUser.getUserId());
		if (riskCaseBean == null) {
			riskCaseBean = new RiskCaseBean();
		}
		variables.put("busicode", riskCaseBean.getBusicode());
		variables.put("riskver", riskCaseBean.getRiskver());
		Map<String, Object> groupList = limitPerdayService.findLimitPerdayByPage(variables,
				page, rows);
		return groupList;
	}

	@ResponseBody
	@RequestMapping(value="/saveLimitPerday", produces = "text/html;charset=UTF-8")
	public String saveLimitPerday(LimitPerdayBean limitPerdayBean) {
		if (limitPerdayBean == null) {
			limitPerdayBean = new LimitPerdayBean();
		}
		String mark = limitPerdayService.AddOneLimitPerday(limitPerdayBean);
		return mark;
	}

	@ResponseBody
	@RequestMapping("/queryOneLimitPerday")
	public Map<String, Object> queryOneLimitPerday(String riskId) {
		Map<String, Object> feeList = limitPerdayService.queryOneLimitPerday(riskId);
		return feeList;
	}

	@ResponseBody
	@RequestMapping(value="/updateLimitPerday", produces = "text/html;charset=UTF-8")
	public String updateLimitPerday(LimitPerdayBean limitPerdayBean) {
		if (limitPerdayBean == null) {
			limitPerdayBean = new LimitPerdayBean();
		}
		String mark = limitPerdayService.updateOneLimitPerday(limitPerdayBean);
		return mark;
	}

	@ResponseBody
	@RequestMapping(value="/deleteLimitPerday", produces = "text/html;charset=UTF-8")
	public String deleteLimitPerday(String riskId) {
		String mark = limitPerdayService.deleteOneLimitPerday(riskId);
		return mark;
	}

	@ResponseBody
	@RequestMapping(value="/startLimitPerday", produces = "text/html;charset=UTF-8")
	public String startLimitPerday(String riskId) {
		String mark = limitPerdayService.startOneLimitPerday(riskId);
		return mark;
	}

	/*// 风险等级
	@ResponseBody
	@RequestMapping("/queryRiskLevel")
	public List<?> queryRiskLevel() {
		List<?> riskcheckList = riskService.query_risk_level();
		return riskcheckList;
	}*/

	// 风控版本
	@ResponseBody
	@RequestMapping("/queryRiskAll")
	public List<?> queryRiskAll() {
		List<?> List = limitPerdayService.query_risk_all();
		return List;
	}

	// --------------------------------------------------------------卡类别日累计限额------------------------------------------------------

	@RequestMapping("/showLimitMemCreditDay")
	public String showLimitMemCreditDay() {
		return "/risk/limit_mem_credit_day_manager";
	}
	
	@ResponseBody
	@RequestMapping("/queryLimitMemCreditDayByPage")
	public Map<String, Object> queryLimitMemCreditDayByPage(HttpServletRequest request, LimitMemCreditDayBean limitMemCreditDayBean, int page, int rows) {
		Map<String, Object> variables = new HashMap<String, Object>();
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		variables.put("userId", loginUser.getUserId());
		if (limitMemCreditDayBean == null) {
			limitMemCreditDayBean = new LimitMemCreditDayBean();
		}
		variables.put("memberid", limitMemCreditDayBean.getMemberid());
		variables.put("card_type", limitMemCreditDayBean.getCardType());
		Map<String, Object> LimitMemList = limitPerdayService
				.findLimitMemCreditDayByPage(variables, page, rows);
		return LimitMemList;
	}

	@ResponseBody
	@RequestMapping(value="/saveLimitMemCreditDay", produces = "text/html;charset=UTF-8")
	public String saveLimitMemCreditDay(LimitMemCreditDayBean limitMemCreditDayBean) {
		if (limitMemCreditDayBean == null) {
			limitMemCreditDayBean = new LimitMemCreditDayBean();
		}
		String mark = limitPerdayService.AddOneLimitMemCreditDay(limitMemCreditDayBean);
		return mark;
	}

	@ResponseBody
	@RequestMapping("/queryLimitMemCreditDay")
	public Map<String, Object> queryLimitMemCreditDay(String riskId) {
		Map<String, Object> onelimit = limitPerdayService.queryOneLimitMemCreditDay(riskId);
		return onelimit;
	}

	@ResponseBody
	@RequestMapping(value="/updateLimitMemCreditDay", produces = "text/html;charset=UTF-8")
	public String updateLimitMemCreditDay(LimitMemCreditDayBean limitMemCreditDayBean) {
		if (limitMemCreditDayBean == null) {
			limitMemCreditDayBean = new LimitMemCreditDayBean();
		}
		String mark = limitPerdayService.UpdateLimitMemCreditDay(limitMemCreditDayBean);
		return mark;
	}

	@ResponseBody
	@RequestMapping(value="/deleteLimitMemCreditDay", produces = "text/html;charset=UTF-8")
	public String deleteLimitMemCreditDay(String riskId) {
		String mark = limitPerdayService.deleteLimitMemCreditDay(riskId);
		return mark;
	}

	@ResponseBody
	@RequestMapping(value="/startLimitMemCreditDay", produces = "text/html;charset=UTF-8")
	public String startLimitMemCreditDay(String riskId) {
		String mark = limitPerdayService.startLimitMemCreditDay(riskId);
		return mark;
	}

	// --------------------------------------------------------------卡类别月累计限额------------------------------------------------------
	// private LimitMemCreditMonthBean limitMemCreditMonthBean;

	@RequestMapping("/showLimitMemCreditMonth")
	public String showLimitMemCreditMonth() {
		return "/risk/limit_mem_credit_month_manager";
	}

	@ResponseBody
	@RequestMapping("/queryLimitMemCreditMonthByPage")
	public Map<String, Object> queryLimitMemCreditMonthByPage(HttpServletRequest request, LimitMemCreditMonthBean limitMemCreditMonthBean, int page, int rows) {
		Map<String, Object> variables = new HashMap<String, Object>();
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		variables.put("userId", loginUser.getUserId());
		if (limitMemCreditMonthBean == null) {
			limitMemCreditMonthBean = new LimitMemCreditMonthBean();
		}
		variables.put("memberid", limitMemCreditMonthBean.getMemberid());
		variables.put("card_type", limitMemCreditMonthBean.getCardType());
		Map<String, Object> LimitMemList = limitPerdayService
				.findLimitMemCreditMonthByPage(variables, page, rows);
		return LimitMemList;
	}

	@ResponseBody
	@RequestMapping(value="/saveLimitMemCreditMonth", produces = "text/html;charset=UTF-8")
	public String saveLimitMemCreditMonth(LimitMemCreditMonthBean limitMemCreditMonthBean) {
		if (limitMemCreditMonthBean == null) {
			limitMemCreditMonthBean = new LimitMemCreditMonthBean();
		}
		String mark = limitPerdayService.AddOneLimitMemCreditMonth(limitMemCreditMonthBean);
		return mark;
	}

	@ResponseBody
	@RequestMapping("/queryLimitMemCreditMonth")
	public Map<String, Object> queryLimitMemCreditMonth(String riskId) {
		Map<String, Object> onelimit = limitPerdayService.queryOneLimitMemCreditMonth(riskId);
		return onelimit;
	}

	@ResponseBody
	@RequestMapping(value="/updateLimitMemCreditMonth", produces = "text/html;charset=UTF-8")
	public String updateLimitMemCreditMonth(LimitMemCreditMonthBean limitMemCreditMonthBean) {
		if (limitMemCreditMonthBean == null) {
			limitMemCreditMonthBean = new LimitMemCreditMonthBean();
		}
		String mark = limitPerdayService.UpdateLimitMemCreditMonth(limitMemCreditMonthBean);
		return mark;
	}

	@ResponseBody
	@RequestMapping(value="/deleteLimitMemCreditMonth", produces = "text/html;charset=UTF-8")
	public String deleteLimitMemCreditMonth(String riskId) {
		String mark = limitPerdayService.deleteLimitMemCreditMonth(riskId);
		return mark;
	}

	@ResponseBody
	@RequestMapping(value="/startLimitMemCreditMonth", produces = "text/html;charset=UTF-8")
	public String startLimitMemCreditMonth(String riskId) {
		String mark = limitPerdayService.startLimitMemCreditMonth(riskId);
		return mark;
	}

	// --------------------------------------------------------------商户月累计限额------------------------------------------------------
	// private LimitMemMonthBean limitMemMonthBean;

	@RequestMapping("/showLimitMemMonth")
	public String showLimitMemMonth() {
		return "/risk/limit_mem_month_manager";
	}

	@ResponseBody
	@RequestMapping("/queryLimitMemMonthByPage")
	public Map<String, Object> queryLimitMemMonthByPage(HttpServletRequest request, LimitMemMonthBean limitMemMonthBean, int page, int rows) {
		Map<String, Object> variables = new HashMap<String, Object>();
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		variables.put("userId", loginUser.getUserId());
		if (limitMemMonthBean == null) {
			limitMemMonthBean = new LimitMemMonthBean();
		}
		variables.put("memberid", limitMemMonthBean.getMemberid());
		Map<String, Object> LimitMemList = limitPerdayService.findLimitMemMonthByPage(variables,
				page, rows);
		return LimitMemList;
	}

	@ResponseBody
	@RequestMapping(value="/saveLimitMemMonth", produces = "text/html;charset=UTF-8")
	public String saveLimitMemMonth(LimitMemMonthBean limitMemMonthBean) {
		if (limitMemMonthBean == null) {
			limitMemMonthBean = new LimitMemMonthBean();
		}
		String mark = limitPerdayService.AddOneLimitMemMonth(limitMemMonthBean);
		return mark;
	}

	@ResponseBody
	@RequestMapping("/queryLimitMemMonth")
	public Map<String, Object> queryLimitMemMonth(String riskId) {
		Map<String, Object> onelimit = limitPerdayService.queryOneLimitMemMonth(riskId);
		return onelimit;
	}

	@ResponseBody
	@RequestMapping(value="/updateLimitMemMonth", produces = "text/html;charset=UTF-8")
	public String updateLimitMemMonth(LimitMemMonthBean limitMemMonthBean) {
		if (limitMemMonthBean == null) {
			limitMemMonthBean = new LimitMemMonthBean();
		}
		String mark = limitPerdayService.UpdateLimitMemMonth(limitMemMonthBean);
		return mark;
	}

	@ResponseBody
	@RequestMapping(value="/deleteLimitMemMonth", produces = "text/html;charset=UTF-8")
	public String deleteLimitMemMonth(HttpServletRequest request, String riskId) {
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		String mark = limitPerdayService.deleteLimitMemMonth(riskId, loginUser.getUserId());
		return mark;
	}

	@ResponseBody
	@RequestMapping(value="/startLimitMemMonth", produces = "text/html;charset=UTF-8")
	public String startLimitMemMonth(HttpServletRequest request, String riskId) {
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		String mark = limitPerdayService.startLimitMemMonth(riskId, loginUser.getUserId());
		return mark;
	}

	// --------------------------------------------------------------商户日累计限额------------------------------------------------------
	// private LimitMemDayBean limitMemDayBean;

	@RequestMapping("/showLimitMemDay")
	public String showLimitMemDay() {
		return "/risk/limit_mem_day_manager";
	}

	@ResponseBody
	@RequestMapping("/queryLimitMemDayByPage")
	public Map<String, Object> queryLimitMemDayByPage(HttpServletRequest request, LimitMemDayBean limitMemDayBean, int page, int rows) {
		Map<String, Object> variables = new HashMap<String, Object>();
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		variables.put("userId", loginUser.getUserId());
		if (limitMemDayBean == null) {
			limitMemDayBean = new LimitMemDayBean();
		}
		variables.put("memberid", limitMemDayBean.getMemberid());
		Map<String, Object> LimitMemList = limitPerdayService.findLimitMemDayByPage(variables, page, rows);
		return LimitMemList;
	}

	@ResponseBody
	@RequestMapping(value="/saveLimitMemDay", produces = "text/html;charset=UTF-8")
	public String saveLimitMemDay(LimitMemDayBean limitMemDayBean) {
		if (limitMemDayBean == null) {
			limitMemDayBean = new LimitMemDayBean();
		}
		String mark = limitPerdayService.AddOneLimitMemDay(limitMemDayBean);
		return mark;
	}

	@ResponseBody
	@RequestMapping("/queryLimitMemDay")
	public Map<String, Object> queryLimitMemDay(String riskId) {
		Map<String, Object> onelimit = limitPerdayService.queryOneLimitMemDay(riskId);
		return onelimit;
	}

	@ResponseBody
	@RequestMapping(value="/updateLimitMemDay", produces = "text/html;charset=UTF-8")
	public String updateLimitMemDay(LimitMemDayBean limitMemDayBean) {
		if (limitMemDayBean == null) {
			limitMemDayBean = new LimitMemDayBean();
		}
		String mark = limitPerdayService.UpdateLimitMemDay(limitMemDayBean);
		return mark;
	}

	@ResponseBody
	@RequestMapping(value="/deleteLimitMemDay", produces = "text/html;charset=UTF-8")
	public String deleteLimitMemDay(HttpServletRequest request, String riskId) {
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		String mark = limitPerdayService.deleteLimitMemDay(riskId, loginUser.getUserId());
		return mark;
	}

	@ResponseBody
	@RequestMapping(value="/startLimitMemDay", produces = "text/html;charset=UTF-8")
	public String startLimitMemDay(HttpServletRequest request, String riskId) {
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		String mark = limitPerdayService.startLimitMemDay(riskId, loginUser.getUserId());
		return mark;
	}

	// --------------------------------------------------------------单笔限额------------------------------------------------------
	// private LimitSingleBean limitSingleBean;

	@RequestMapping("/showLimitSingle")
	public String showLimitSingle() {
		return "/risk/limit_single_manager";
	}

	@ResponseBody
	@RequestMapping("/queryLimitSingleByPage")
	public Map<String, Object> queryLimitSingleByPage(HttpServletRequest request, LimitSingleBean limitSingleBean, int page, int rows, String riskver) {
		Map<String, Object> variables = new HashMap<String, Object>();
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		variables.put("userId", loginUser.getUserId());
		if (limitSingleBean == null) {
			limitSingleBean = new LimitSingleBean();

		}
		variables.put("caseid", limitSingleBean.getCaseid());
		variables.put("riskver", riskver);
		Map<String, Object> LimitMemList = limitPerdayService.findLimitSingleByPage(variables,
				page, rows);
		return LimitMemList;
	}

	@ResponseBody
	@RequestMapping(value="/saveLimitSingle", produces = "text/html;charset=UTF-8")
	public String saveLimitSingle(LimitSingleBean limitSingleBean) {
		if (limitSingleBean == null) {
			limitSingleBean = new LimitSingleBean();
		}
		String mark = limitPerdayService.AddOneLimitSingle(limitSingleBean);
		return mark;
	}

	@ResponseBody
	@RequestMapping("/queryLimitSingle")
	public Map<String, Object> queryLimitSingle(String riskId) {
		Map<String, Object> onelimit = limitPerdayService.queryOneLimitSingle(riskId);
		return onelimit;
	}

	@ResponseBody
	@RequestMapping(value="/updateLimitSingle", produces = "text/html;charset=UTF-8")
	public String updateLimitSingle(LimitSingleBean limitSingleBean) {
		if (limitSingleBean == null) {
			limitSingleBean = new LimitSingleBean();
		}
		String mark = limitPerdayService.updateOneLimitSingle(limitSingleBean);
		return mark;
	}

	@ResponseBody
	@RequestMapping(value="/deleteLimitSingle", produces = "text/html;charset=UTF-8")
	public String deleteLimitSingle(String riskId) {
		String mark = limitPerdayService.deleteOneLimitSingle(riskId);
		return mark;
	}

	@ResponseBody
	@RequestMapping(value="/startLimitSingle", produces = "text/html;charset=UTF-8")
	public String startLimitSingle(String riskId) {
		String mark = limitPerdayService.startOneLimitSingle(riskId);
		return mark;
	}
}
