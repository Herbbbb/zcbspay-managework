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
import com.zcbspay.platform.manager.merchant.service.MerchBankAccoutService;
import com.zcbspay.platform.manager.system.bean.CityBean;
import com.zcbspay.platform.manager.system.bean.ProvinceBean;
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
	public Map<String, String> save(HttpServletRequest request,MerchBankAccoutBean bankAccout) {
		Map<String, String> result = new HashMap<String, String>();
		bankAccout.setStatus("00");
        boolean isSucc = merchBankAccoutService.addBankAccount(bankAccout);
        if (isSucc == true) {
            result.put("status", "OK");
        } else {
            result.put("status", "FAIL");
        }
        return result;
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
	public Map<String, String> eidtBankAccount(MerchBankAccoutBean bankAccout) {
		Map<String, String> result = new HashMap<String, String>();
		boolean isSucc = merchBankAccoutService.eidtBankAccount(bankAccout);
        if (isSucc == true) {
            result.put("status", "OK");
        } else {
            result.put("status", "FAIL");
        }
        return result;
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
	public CityBean queryCity(String CCode){
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
