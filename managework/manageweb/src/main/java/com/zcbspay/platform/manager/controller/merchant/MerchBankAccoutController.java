package com.zcbspay.platform.manager.controller.merchant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zcbspay.platform.manager.merchant.bean.BankInfoBean;
import com.zcbspay.platform.manager.merchant.bean.MerchBankAccoutBean;
import com.zcbspay.platform.manager.merchant.service.AgencyService;
import com.zcbspay.platform.manager.merchant.service.MerchBankAccoutService;
import com.zcbspay.platform.manager.system.bean.CityBean;
import com.zcbspay.platform.manager.system.bean.ProvinceBean;
import com.zcbspay.platform.manager.system.bean.UserBean;
import com.zcbspay.platform.manager.system.service.CityService;
import com.zcbspay.platform.manager.system.service.ProvinceService;

@Controller
@RequestMapping("/bankaccout")
@SuppressWarnings("all")
public class MerchBankAccoutController {
	
	@Autowired
	private MerchBankAccoutService merchBankAccoutService;
	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private CityService cityService;
	@Autowired
	private AgencyService agencyService;
	
	@ResponseBody
    @RequestMapping("/show")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView result=new ModelAndView("/merch/bankaccout/bank_accout");
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
	public Map<String, Object> query(MerchBankAccoutBean bankAccout,int page,int rows){
		Map<String, Object> result = new HashMap<String, Object>();
		List<?> list = merchBankAccoutService.findAllAccout(bankAccout,page, rows);
		Integer total= merchBankAccoutService.findAll(bankAccout);
		result.put("total", total);
		result.put("rows", list);
		return result;
	}
	
	/**
	 * 新增用户信息
	 * @param request
	 * @param bankAccout
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/save")
	public Map<String, Object> save(HttpServletRequest request,MerchBankAccoutBean bankAccout) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		UserBean loginUser = (UserBean)request.getSession().getAttribute("LOGIN_USER");
		result.put("userId", loginUser.getUserId().toString());
        result.put("merberId", bankAccout.getMerchNo());
        result.put("status", "00");
        result.put("flag", "10");
        Map<String, Object> map = agencyService.findMerchByPage(result, 1, 10);
        for (String k : map.keySet()) {
	    	Integer key = (Integer) map.get("total");
            if( key != 1){
            	String  info = "委托机构号" + bankAccout.getMerchNo() + "不存在或已注销！";
            	 result.put("RET", "FAIL");
            	 result.put("INFO", info);
            	 return map;
            }
        }
        bankAccout.setStatus("00");
        boolean isSucc = merchBankAccoutService.addBankAccount(bankAccout);
        Map<String, Object> resultList = new HashMap<String, Object>();
        if (isSucc == true) {
        	resultList.put("RET", "OK");
        	resultList.put("INFO", "保存成功");
        } else {
        	resultList.put("RET", "FAIL");
        	resultList.put("INFO", "保存失败");
        }
        
        return resultList;
	}
	
	/**
	 * 查询商户信息
	 * @param request
	 * @param tId
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/findById")
	public MerchBankAccoutBean findById(HttpServletRequest request,String tId) {
		return merchBankAccoutService.findById(tId);
	}
	
	/**
	 * 修改信息
	 * @param bankAccout
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/eidtBankAccount")
	public Map<String, Object> eidtBankAccount(HttpServletRequest request,MerchBankAccoutBean bankAccout) {
		Map<String, Object> result = new HashMap<String, Object>();
		UserBean loginUser = (UserBean)request.getSession().getAttribute("LOGIN_USER");
		result.put("userId", loginUser.getUserId().toString());
        result.put("merberId", bankAccout.getMerchNo());
        result.put("status", "00");
        result.put("flag", "10");
        Map<String, Object> map = agencyService.findMerchByPage(result, 1, 10);
        for (String k : map.keySet()) {
	    	Integer key = (Integer) map.get("total");
            if( key != 1){
            	String  info = "委托机构号" + bankAccout.getMerchNo() + "不存在或已注销！";
            	 result.put("RET", "FAIL");
            	 result.put("INFO", info);
            	 return map;
            }
        }
		boolean isSucc = merchBankAccoutService.eidtBankAccount(bankAccout);
		Map<String, Object> resultList = new HashMap<String, Object>();
        if (isSucc == true) {
        	resultList.put("RET", "OK");
        	resultList.put("INFO", "修改成功");
        } else {
        	resultList.put("RET", "FAIL");
        	resultList.put("INFO", "修改成功");
        }
        return resultList;
	}
	/**
	 * 删除信息
	 * @param bankAccout
	 * @return queryCity
	 */
	@ResponseBody
    @RequestMapping("/delect")
	public Map<String, String> delect(String tId) {
		Map<String, String> result = new HashMap<String, String>();
		MerchBankAccoutBean bean = merchBankAccoutService.findById(tId);
		bean.setStatus("01");
        boolean isSucc = merchBankAccoutService.eidtBankAccount(bean);
        if (isSucc) {
            result.put("status", "OK");
        } else {
            result.put("status", "FAIL");
        }
        return result;
	}
	
	/**
	 * 获取市信息集合
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/queryCity")
	public List<?> queryCity(String CCode){
		return cityService.findByPid(CCode);
	}
	
	/**
	 * 获取省信息集合
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/queryProvince")
	public ProvinceBean queryProvince(String pId){
		return provinceService.findById(pId);
	}
	
	/**
	 * 获取银行信息
	 * @param bankNode
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/queryBankInfo")
	public BankInfoBean queryBankInfo(String bankNode){
		return merchBankAccoutService.queryBankInfo(bankNode);
	}
	
}
