package com.zcbspay.platform.manager.controller.coopAgency;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zcbspay.platform.manager.merchant.bean.SplitByAccNumsBean;
import com.zcbspay.platform.manager.merchant.service.CoopAgencyService;
import com.zcbspay.platform.manager.system.bean.UserBean;

@Controller
@RequestMapping("/coopSplit")
@SuppressWarnings("all")
public class CoopSplitController {
	
	
	@Autowired
	private CoopAgencyService coopAgencyService;
	
	
	/**
	 * 代理商分润首页
	 * @param request
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/show")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView result=new ModelAndView("/coopAgency/coop_split");
        return result;
    }
	
	/**
	 * 查询
	 * @param bankAccout
	 * @param page
	 * @param rows "total":12,"rows"
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/query")
	public Map<String, Object> query(SplitByAccNumsBean split,Integer page,Integer rows) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("caCode", split.getCaCode());
		return coopAgencyService.findSplitAll(result,page, rows);
	}
	
	/**
	 * 新增发票信息
	 * @param request
	 * @param bankAccout
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/save")
	public Map<String, Object> save(HttpServletRequest request,SplitByAccNumsBean split) {
		Map<String, Object> result = new HashMap<String, Object>();
		UserBean user = (UserBean)request.getSession().getAttribute("LOGIN_USER");
		split.setInUser(user.getUserId());
		result = coopAgencyService.addSplit(split);
        return result;
	}
	
	/**
	 * 查询发票信息
	 * @param request
	 * @param tId
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/findById")
	public SplitByAccNumsBean findSplitById(String tId) {
		return coopAgencyService.findSplitById(tId);
	}
	
	/**
	 * 修改信息
	 * @param bankAccout
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/eidtBankAccount")
	public Map<String, Object> editSplit(HttpServletRequest request,SplitByAccNumsBean split) {
		UserBean user = (UserBean)request.getSession().getAttribute("LOGIN_USER");
		split.setUpUser(user.getUserId());
        return coopAgencyService.editSplit(split);
	}
	/**
	 * 删除信息
	 * @param bankAccout
	 * @return queryCity
	 */
	@ResponseBody
    @RequestMapping("/delect")
	public Map<String, Object> delect(String tId) {
        return coopAgencyService.deleteSplit(tId);
	}
	
}