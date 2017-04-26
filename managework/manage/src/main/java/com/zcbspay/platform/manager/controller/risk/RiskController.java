package com.zcbspay.platform.manager.controller.risk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zcbspay.platform.manager.risk.bean.BlackIdnumBean;
import com.zcbspay.platform.manager.risk.bean.BlacklistMemberBean;
import com.zcbspay.platform.manager.risk.bean.BlacklistPanBean;
import com.zcbspay.platform.manager.risk.bean.LimitCreditSingleBean;
import com.zcbspay.platform.manager.risk.bean.RiskBean;
import com.zcbspay.platform.manager.risk.bean.RiskCaseBean;
import com.zcbspay.platform.manager.risk.bean.WhitePanBean;
import com.zcbspay.platform.manager.risk.service.CardHolderBlackService;
import com.zcbspay.platform.manager.risk.service.RiskService;
import com.zcbspay.platform.manager.system.bean.UserBean;
import com.zcbspay.platform.manager.utils.StringUtil;

@Controller
@RequestMapping("/risk")
public class RiskController {
	@Autowired
	private RiskService riskService;
	@Autowired
	private CardHolderBlackService cardHolderBlackService;

	@RequestMapping("/index")
	public String showRisk() {
		return "/risk/risk_manager";
	}

	// 对应页面功能模块：风控管理；银行卡黑名单，银行卡白名单,商户黑名单，分卡种单笔限额

	/**
	 * 风控版本分页查询
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryRisk")
	public Map<String, Object> queryRisk(HttpServletRequest request, RiskBean risk, int page, int rows) {
		Map<String, Object> variables = new HashMap<String, Object>();
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		variables.put("userId", loginUser.getUserId());
		if (risk == null) {
			risk = new RiskBean();
		}
		variables.put("riskver", risk.getRiskver());
		variables.put("riskname", risk.getRiskname());
		Map<String, Object> groupList = riskService.findRiskByPage(variables, page, rows);
		return groupList;
	}

	/**
	 * 保存风控版本
	 * 
	 * @param risk
	 * @return-
	 */
	@ResponseBody
	@RequestMapping(value="/saveRisk", produces = "text/html;charset=UTF-8")
	public String saveRisk(HttpServletRequest request, RiskBean risk) {
		String result = "";
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		if (risk == null || StringUtil.isEmpty(risk.getRiskver().trim())
				|| StringUtil.isEmpty(risk.getRiskname().trim())) {
			result = "风控版本代码或者风控名称不能为空";
			return null;
		}

		risk.setInuser(loginUser.getUserId());
		result = riskService.AddOneRisk(risk);
		return result;
	}

	@ResponseBody
	@RequestMapping("/queryOneRisk")
	public Map<String, Object> queryOneRisk(String riskId) {
		Map<String, Object> feeList = riskService.queryOneRisk(riskId);
		return feeList;
	}

	@ResponseBody
	@RequestMapping("/queryOneRiskCase")
	public Map<String, Object> queryOneRiskCase(String riskId) {
		Map<String, Object> feeList = riskService.queryOneRiskCase(riskId);
		return feeList;
	}

	@ResponseBody
	@RequestMapping(value="/updateOneRisk", produces = "text/html;charset=UTF-8")
	public String updateOneRisk(HttpServletRequest request, RiskBean risk) {
		String result = "";
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		if (risk == null || StringUtil.isEmpty(risk.getRiskver().trim())
				|| StringUtil.isEmpty(risk.getRiskname().trim())) {
			result = "风控版本代码或者风控名称不能为空";
			return result;
		}
		risk.setInuser(loginUser.getUserId());
		String mark = riskService.UpdateOneRisk(risk);
		return mark;
	}

	// 根据一条风控ID，查询下面的实例，给实例配置复选业务
	@RequestMapping("/toMakeRiskCase")
	public ModelAndView toMakeRiskCase(String riskverMake) {
		ModelAndView modelAndView = new ModelAndView("/risk/risk_case_make");
		if (riskverMake != null && !StringUtil.isEmpty(riskverMake.trim())) {
			modelAndView.addObject("riskver", riskverMake);
		}
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/queryRiskCase")
	public List<?> queryRiskCase(String riskver) {
		List<?> riskCaseList = riskService.queryRiskCase(riskver);
		return riskCaseList;
	}

	/**
	 * 风控策略(所有的策略)
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryRisklistCheck")
	public List<?> queryRisklistCheck() {
		List<?> riskcheckList = riskService.query_risk_list();
		return riskcheckList;
	}

	/**
	 * 风控策略(一条风控实例包含的风控策略做标记)
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryRisklistCheckActive")
	public List<?> queryRisklistCheckActive(String riskId) {
		List<?> riskcheckList = riskService.query_risk_list_active(riskId);
		return riskcheckList;
	}

	/**
	 * 修改风控实例，生成activeflag64位
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateRiskCase", produces = "text/html;charset=UTF-8")
	public String updateRiskCase(HttpServletRequest request, RiskCaseBean riskCase, String[] checkboxList) {
		if (riskCase == null) {
			riskCase = new RiskCaseBean();
		}
		StringBuffer activeflag = new StringBuffer("000000000000000000000000000000000000000000000000000000000000");
		if (checkboxList != null) {
			for (int i = 0; i < checkboxList.length; i++) {
				activeflag.deleteCharAt(Integer.parseInt(checkboxList[i]) - 1);
				activeflag.insert(Integer.parseInt(checkboxList[i]) - 1, "1");
			}
		}
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		riskCase.setUpuser(loginUser.getUserId());
		riskCase.setActiveflag(activeflag.toString());
		String mark = riskService.UpdateOneRiskCase(riskCase);
		return mark;
	}

	/**
	 * 风控版本
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryRisklist")
	public List<?> queryRisklist() {
		List<?> riskcheckList = riskService.query_risk_all();
		return riskcheckList;
	}

	/**
	 * 风控实例
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryRisklistCase")
	public List<?> queryRisklistCase(String riskId) {
		List<?> riskcheckList = riskService.query_risk_case_all(riskId);
		return riskcheckList;
	}

	// -------------------------------------------------------------银行卡黑名单-----------------------------------------------------------------------
	@RequestMapping("/showBlackPan")
	public String showBlackPan() {
		return "/risk/black_pan_manager";
	}

	@ResponseBody
	@RequestMapping("/queryBlackPanByPage")
	public Map<String, Object> queryBlackPanByPage(HttpServletRequest request, BlacklistPanBean blacklistPan, int page, int rows) {
		Map<String, Object> variables = new HashMap<String, Object>();
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		variables.put("userId", loginUser.getUserId());
		if (blacklistPan == null) {
			blacklistPan = new BlacklistPanBean();
		}
		variables.put("pan", blacklistPan.getPan());
		Map<String, Object> groupList = riskService.findBlackPanByPage(variables, page, rows);
		return groupList;
	}

	// 
	/**
	 * 风险等级
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryRiskLevel")
	public List<?> queryRiskLevel() {
		List<?> riskcheckList = riskService.query_risk_level();
		return riskcheckList;
	}

	@ResponseBody
	@RequestMapping(value="/saveBlackPan", produces = "text/html;charset=UTF-8")
	public String saveBlackPan(BlacklistPanBean blacklistPan) {
		if (blacklistPan == null) {
			blacklistPan = new BlacklistPanBean();
		}
		String mark = riskService.AddOneBlackPan(blacklistPan);
		return mark;
	}

	@ResponseBody
	@RequestMapping("/queryOneBlackPan")
	public Map<String, Object> queryOneBlackPan(String riskId) {
		Map<String, Object> feeList = riskService.queryOneBlackPan(riskId);
		return feeList;
	}

	@ResponseBody
	@RequestMapping(value="/updateBlackPan", produces = "text/html;charset=UTF-8")
	public String updateBlackPan(BlacklistPanBean blacklistPan) {
		if (blacklistPan == null) {
			blacklistPan = new BlacklistPanBean();
		}
		String mark = riskService.updateOneBlackPan(blacklistPan);
		return mark;
	}

	@ResponseBody
	@RequestMapping(value="/deleteBlackPan", produces = "text/html;charset=UTF-8")
	public String deleteBlackPan(String riskId) {
		String mark = riskService.deleteOneBlackPan(riskId);
		return mark;
	}

	@ResponseBody
	@RequestMapping(value="/startBlackPan", produces = "text/html;charset=UTF-8")
	public String startBlackPan(String riskId) {
		String mark = riskService.startOneBlackPan(riskId);
		return mark;
	}

	// --------------------------------------------------
	// 银行卡白名单------------------------------------------------------------------------

	@RequestMapping("/showWhitePan")
	public String showWhitePan() {
		return "/risk/white_pan_manager";
	}

	@ResponseBody
	@RequestMapping("/queryWhitePanByPage")
	public Map<String, Object> queryWhitePanByPage(HttpServletRequest request, WhitePanBean whitePanBean, int page, int rows) {
		Map<String, Object> variables = new HashMap<String, Object>();
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		variables.put("userId", loginUser.getUserId());
		if (whitePanBean == null) {
			whitePanBean = new WhitePanBean();
		}
		variables.put("pan", whitePanBean.getPan());
		Map<String, Object> groupList = riskService.findWhitePanByPage(variables, page, rows);
		return groupList;
	}

	@ResponseBody
	@RequestMapping(value="/saveWhitePan", produces = "text/html;charset=UTF-8")
	public String saveWhitePan(WhitePanBean whitePanBean) {
		if (whitePanBean == null) {
			whitePanBean = new WhitePanBean();
		}
		String mark = riskService.AddOneWhitePan(whitePanBean);
		return mark;
	}

	@ResponseBody
	@RequestMapping("/queryOneWhitePan")
	public Map<String, Object> queryOneWhitePan(String riskId) {
		Map<String, Object> feeList = riskService.queryOneWhitePan(riskId);
		return feeList;
	}

	@ResponseBody
	@RequestMapping(value="/updateWhitePan", produces = "text/html;charset=UTF-8")
	public String updateWhitePan(WhitePanBean whitePanBean) {
		if (whitePanBean == null) {
			whitePanBean = new WhitePanBean();
		}
		String mark = riskService.updateOneWhitePan(whitePanBean);
		return mark;
	}

	@ResponseBody
	@RequestMapping(value="/deleteWhitePan", produces = "text/html;charset=UTF-8")
	public String deleteWhitePan(String riskId) {
		String mark = riskService.deleteOneWhitePan(riskId);
		return mark;
	}

	@ResponseBody
	@RequestMapping(value="/startWhitePan", produces = "text/html;charset=UTF-8")
	public String startWhitePan(String riskId) {
		String mark = riskService.startOneWhitePan(riskId);
		return mark;
	}

	// --------------------------------------------------------------卡类别日累计限额------------------------------------------------------
	// private BlacklistMemberModel blacklistMemberModel;

	@RequestMapping("/showBlacklistMember")
	public String showBlacklistMember() {
		return "/risk/black_mem_manager";
	}

	@ResponseBody
	@RequestMapping("/queryBlacklistMemberByPage")
	public Map<String, Object> queryBlacklistMemberByPage(HttpServletRequest request, BlacklistMemberBean blacklistMemberBean, int page, int rows, String merchName) {
		Map<String, Object> variables = new HashMap<String, Object>();
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		variables.put("userId", loginUser.getUserId());
		if (blacklistMemberBean == null) {
			blacklistMemberBean = new BlacklistMemberBean();
		}
		variables.put("memberId", blacklistMemberBean.getMemberid());
		variables.put("merchName", merchName);
		Map<String, Object> LimitMemList = riskService.findBlacklistMemberByPage(variables, page, rows);
		return LimitMemList;
	}

	@ResponseBody
	@RequestMapping(value="/saveBlacklistMember", produces = "text/html;charset=UTF-8")
	public String saveBlacklistMember(BlacklistMemberBean blacklistMemberBean) {
		if (blacklistMemberBean == null) {
			blacklistMemberBean = new BlacklistMemberBean();
		}
		String mark = riskService.AddOneBlacklistMember(blacklistMemberBean);
		return mark;
	}

	@ResponseBody
	@RequestMapping("/queryOneBlacklistMember")
	public Map<String, Object> queryOneBlacklistMember(String riskId) {
		Map<String, Object> onelimit = riskService.queryOneBlacklistMember(riskId);
		return onelimit;
	}

	@ResponseBody
	@RequestMapping(value="/updateBlacklistMember", produces = "text/html;charset=UTF-8")
	public String updateBlacklistMember(BlacklistMemberBean blacklistMemberBean) {
		if (blacklistMemberBean == null) {
			blacklistMemberBean = new BlacklistMemberBean();
		}
		String mark = riskService.updateBlacklistMember(blacklistMemberBean);
		return mark;
	}

	@ResponseBody
	@RequestMapping(value="/deleteBlacklistMember", produces = "text/html;charset=UTF-8")
	public String deleteBlacklistMember(HttpServletRequest request, String riskId) {
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		String mark = riskService.deleteOneBlacklistMember(riskId, loginUser.getUserId());
		return mark;
	}

	@ResponseBody
	@RequestMapping(value="/startBlacklistMember", produces = "text/html;charset=UTF-8")
	public String startBlacklistMember(HttpServletRequest request,String riskId) {
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		String mark = riskService.startOneBlacklistMember(riskId, loginUser.getUserId());
		return mark;
	}

	// -------------------------------------------------------------------------------------------
	// --------------------------------------------------------------分卡种单笔限额------------------------------------------------------
	// private LimitCreditSingleModel limitCreditSingleModel;

	@RequestMapping("/showLimitCreditSingle")
	public String showLimitCreditSingle() {
		return "/risk/limit_credit_single_manager";
	}

	@ResponseBody
	@RequestMapping("/queryLimitCreditSingleByPage")
	public Map<String, Object>  queryLimitCreditSingleByPage(HttpServletRequest request, LimitCreditSingleBean limitCreditSingleBean, int page, int rows, String riskver) {
		Map<String, Object> variables = new HashMap<String, Object>();
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		variables.put("userId", loginUser.getUserId());
		if (limitCreditSingleBean == null) {
			limitCreditSingleBean = new LimitCreditSingleBean();
		}
		variables.put("caseid", limitCreditSingleBean.getCaseid());
		variables.put("riskver", riskver);
		Map<String, Object> LimitMemList = riskService.findlimitCreditSingleByPage(variables,
				page, rows);
		return LimitMemList;
	}

	@ResponseBody
	@RequestMapping(value="/saveLimitCreditSingle", produces = "text/html;charset=UTF-8")
	public String saveLimitCreditSingle(LimitCreditSingleBean limitCreditSingleBean) {
		if (limitCreditSingleBean == null) {
			limitCreditSingleBean = new LimitCreditSingleBean();
		}
		String mark = riskService.AddOnelimitCreditSingle(limitCreditSingleBean);
		return mark;
	}

	@ResponseBody
	@RequestMapping("/queryLimitCreditSingle")
	public Map<String, Object> queryLimitCreditSingle(String riskId) {
		Map<String, Object> onelimit = riskService.queryOnelimitCreditSingle(riskId);
		return onelimit;
	}

	@ResponseBody
	@RequestMapping(value="/updateLimitCreditSingle", produces = "text/html;charset=UTF-8")
	public String updateLimitCreditSingle(LimitCreditSingleBean limitCreditSingleBean) {
		if (limitCreditSingleBean == null) {
			limitCreditSingleBean = new LimitCreditSingleBean();
		}
		String mark = riskService.updateOnelimitCreditSingle(limitCreditSingleBean);
		return mark;
	}

	@ResponseBody
	@RequestMapping(value="/deleteLimitCreditSingle", produces = "text/html;charset=UTF-8")
	public String deleteLimitCreditSingle(HttpServletRequest request, String riskId) {
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		String mark = riskService.deleteOnelimitCreditSingle(riskId,
				loginUser.getUserId());
		return mark;
	}

	@ResponseBody
	@RequestMapping(value="/startLimitCreditSingle", produces = "text/html;charset=UTF-8")
	public String startLimitCreditSingle(HttpServletRequest request, String riskId) {
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		String mark = riskService.startOnelimitCreditSingle(riskId, loginUser.getUserId());
		return mark;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	// -----------------------------------------------------------------持卡人黑名单------------------------------------------------
	@RequestMapping("/showCardholderBlackList")
	public String showCardholderBlackList(){ 
		return "/risk/cardholder_black_manager"; 
	}
	public final static String DEFAULT_TIME_STAMP_FROMAT2 = "yyyy-MM-dd";

	/**
	 * 根据身份证号查询持卡人黑名单
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryCardHolderBlackList")
	public Map<String, Object> queryCardHolderBlackList(BlackIdnumBean blackIdnumBean, int page, int rows) {
		Map<String, Object> variables = new HashMap<String, Object>();
		if (blackIdnumBean == null) {
			blackIdnumBean = new BlackIdnumBean();
		}
		variables.put("idnum", blackIdnumBean.getIdnum());

		Map<String, Object> result = cardHolderBlackService.queryCardHolderBlackList(variables, page, rows);
		return result;
	}

	/***
	 * 保存持卡人黑名单信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveCardHolderBlack", produces = "text/html;charset=UTF-8")
	public String saveCardHolderBlack(BlackIdnumBean blackIdnumBean) {
		if (blackIdnumBean == null) {
			blackIdnumBean = new BlackIdnumBean();
		}
		String sdateString = blackIdnumBean.getSdate();
		String edateString = blackIdnumBean.getEdate();
		String[] sdate1 = sdateString.split("-");
		String[] edate1 = edateString.split("-");
		String sdate = "";
		String edate = "";
		for (int i = 0; i < sdate1.length; i++) {
			sdate = sdate + sdate1[i];
			edate = edate + edate1[i];
		}
		blackIdnumBean.setSdate(sdate);
		blackIdnumBean.setEdate(edate);
		String result = cardHolderBlackService.AddOneBlackCardHolder(blackIdnumBean);
		return result;
	}

	/**
	 * （根据选中的记录的tid）查询一条持卡人黑名单信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryOneBlackCardHolder")
	public Map<String, Object> queryOneBlackCardHolder(HttpServletRequest request) {
		String tid = request.getParameter("tid");
		Map<String, Object> blackCardHolder = cardHolderBlackService.queryOneBlackCardHolder(tid);
		String sdateString = (String) blackCardHolder.get("SDATE");
		String edateString = (String) blackCardHolder.get("EDATE");
		String sdate = sdateString.substring(0, 4) + "-" + sdateString.substring(4, 6) + "-"
				+ sdateString.substring(6, 8);
		String edate = edateString.substring(0, 4) + "-" + edateString.substring(4, 6) + "-"
				+ edateString.substring(6, 8);
		blackCardHolder.put("SDATE", sdate);
		blackCardHolder.put("EDATE", edate);

		return blackCardHolder;
	}

	/***
	 * 修改持卡人黑名单
	 */
	@ResponseBody
	@RequestMapping(value="/updateBlackCardHolder", produces = "text/html;charset=UTF-8")
	public String updateBlackCardHolder(HttpServletRequest request, BlackIdnumBean blackIdnumBean) {
		String tid = request.getParameter("tid");
		blackIdnumBean.setTid(tid);
		String sdateString = blackIdnumBean.getSdate();
		String edateString = blackIdnumBean.getEdate();
		String[] sdate1 = sdateString.split("-");
		String[] edate1 = edateString.split("-");
		String sdate = "";
		String edate = "";
		for (int i = 0; i < sdate1.length; i++) {
			sdate = sdate + sdate1[i];
			edate = edate + edate1[i];
		}
		blackIdnumBean.setSdate(sdate);
		blackIdnumBean.setEdate(edate);
		String mark = cardHolderBlackService.updateBlackCardHolder(blackIdnumBean);
		return mark;
	}

	/**
	 * （根据选中记录的tid）注销此持卡人黑名单
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/deleteCardHolderBlack", produces = "text/html;charset=UTF-8")
	public String deleteCardHolderBlack(HttpServletRequest request) {
		String tid = request.getParameter("tid");
		String mark = cardHolderBlackService.delteOneCardHolderBlack(tid);
		return mark;
	}

	/**
	 * （根据选中记录的tid）启用此持卡人黑名单
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/startCardHolderBlack", produces = "text/html;charset=UTF-8")
	public String startCardHolderBlack(HttpServletRequest request) {
		String tid = request.getParameter("tid");
		String mark = cardHolderBlackService.startCardHolderBlack(tid);
		return mark;

	}
}
