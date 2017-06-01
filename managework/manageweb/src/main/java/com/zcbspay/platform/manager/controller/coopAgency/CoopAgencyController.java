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

import com.zcbspay.platform.manager.merchant.bean.CoopAgencyBean;
import com.zcbspay.platform.manager.merchant.bean.SplitByAccNumsBean;
import com.zcbspay.platform.manager.merchant.bean.CoopAgencyBean;
import com.zcbspay.platform.manager.merchant.service.CoopAgencyService;
import com.zcbspay.platform.manager.system.bean.UserBean;

@Controller
@RequestMapping("/coopAgency")
@SuppressWarnings("all")
public class CoopAgencyController {
	
	@Autowired
	private CoopAgencyService coopAgencyService;
	@ResponseBody
    @RequestMapping("/show")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView result=new ModelAndView("/coopAgency/coop_agency");
        return result;
    }
	
	/**
	* 代理商分润统计信息
	* @param request
	* @return
	*/
	@ResponseBody
	@RequestMapping("/showProfit")
	public ModelAndView showProfit(HttpServletRequest request) {
		ModelAndView result=new ModelAndView("/coopAgency/coop_profit");
		return result;
	}
	
	/**
	 * 查询分润统计信息
	 * @param bankAccout
	 * @param page
	 * @param rows "total":12,"rows"
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryProfit")
	public Map<String, Object> queryProfit(CoopAgencyBean split,String date,Integer page,Integer rows) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("caCode", split.getCaCode());
		result.put("date", date);
		result.put("profitType", split.getProfitType());
		return coopAgencyService.queryProfit(result,page, rows);
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
	public Map<String, Object> query(CoopAgencyBean coop,Integer page,Integer rows) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("caName", coop.getCaName());
		result.put("status", coop.getStatus());
		result.put("caCode", coop.getCaCode());
		return coopAgencyService.findAll(result,page, rows);
	}
	
	/**
	 * 查询代理商名称
	 * @param bankAccout
	 * @param page
	 * @param rows "total":12,"rows"
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findByCode")
	public CoopAgencyBean findByCode(String caCode) {
		return coopAgencyService.findByCode(caCode);
	}
	
	/**
	 * 新增发票信息
	 * @param request
	 * @param bankAccout
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/save")
	public Map<String, Object> save(HttpServletRequest request,CoopAgencyBean coop) {
		Map<String, Object> result = new HashMap<String, Object>();
		UserBean user = (UserBean)request.getSession().getAttribute("LOGIN_USER");
		coop.setStatus("00");
		coop.setInUser(user.getUserId());
		result = coopAgencyService.addCoopAgency(coop);
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
	public List<?> findTaxById(String tId) {
		return coopAgencyService.findById(tId);
	}
	
	/**
	 * 修改信息
	 * @param bankAccout
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/eidtBankAccount")
	public Map<String, Object> eidtBankAccount(CoopAgencyBean coop) {
        return coopAgencyService.editCoopAgency(coop);
	}
	/**
	 * 删除信息
	 * @param bankAccout
	 * @return queryCity
	 */
	@ResponseBody
    @RequestMapping("/delect")
	public Map<String, Object> delect(String tId) {
        return coopAgencyService.deleteCoopAgency(tId);
	}
	
	/**
	 * 查询代理商获利模式
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryProfitType")
    public List<?> queryProfitType() {
    	return coopAgencyService.queryProfitType();
    }
	
}