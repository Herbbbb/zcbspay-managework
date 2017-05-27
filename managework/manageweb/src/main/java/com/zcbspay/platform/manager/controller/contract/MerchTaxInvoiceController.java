package com.zcbspay.platform.manager.controller.contract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zcbspay.platform.manager.merchant.bean.MerchTaxInvoiceBean;
import com.zcbspay.platform.manager.merchant.service.AgencyService;
import com.zcbspay.platform.manager.merchant.service.MerchBankAccoutService;
import com.zcbspay.platform.manager.system.bean.UserBean;
@SuppressWarnings("all")
@Controller
@RequestMapping("/merchTax")
public class MerchTaxInvoiceController {

	@Autowired
	private MerchBankAccoutService merchBankAccoutService;
	@Autowired
	private AgencyService agencyService;
	
	@ResponseBody
    @RequestMapping("/show")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView result=new ModelAndView("/merchTax/march_tax");
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
	public Map<String, Object> query(MerchTaxInvoiceBean metchTax,int page,int rows){
		Map<String, Object> result = new HashMap<String, Object>();
		List<?> list = merchBankAccoutService.findTaxAll(metchTax,page, rows);
		Integer total= merchBankAccoutService.findTaxAllCount(metchTax);
		result.put("total", total);
		result.put("rows", list);
		return result;
	}
	
	/**
	 * 新增发票信息
	 * @param request
	 * @param bankAccout
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/save")
	public Map<String, Object> save(HttpServletRequest request,MerchTaxInvoiceBean metchTax) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		UserBean loginUser = (UserBean)request.getSession().getAttribute("LOGIN_USER");
		result.put("userId", loginUser.getUserId().toString());
        result.put("merberId", metchTax.getMerchNo());
        result.put("status", "00");
        result.put("flag", "10");
        Map<String, Object> map = agencyService.findMerchByPage(result, 1, 10);
        for (String k : map.keySet()) {
	    	Integer key = (Integer) map.get("total");
            if( key != 1){
            	String  info = "委托机构号" + metchTax.getMerchNo() + "不存在或已注销！";
            	 result.put("RET", "FAIL");
            	 result.put("INFO", info);
            	 return result;
            }
        }
		metchTax.setStatus("00");
		result = merchBankAccoutService.addTax(metchTax);
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
	public MerchTaxInvoiceBean findTaxById(String tId) {
		return merchBankAccoutService.findTaxById(tId);
	}
	
	/**
	 * 修改信息
	 * @param bankAccout
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/eidtBankAccount")
	public Map<String, Object> eidtBankAccount(HttpServletRequest request,MerchTaxInvoiceBean metchTax) {
		Map<String, Object> result = new HashMap<String, Object>();
		UserBean loginUser = (UserBean)request.getSession().getAttribute("LOGIN_USER");
		result.put("userId", loginUser.getUserId().toString());
        result.put("merberId", metchTax.getMerchNo());
        result.put("status", "00");
        result.put("flag", "10");
        Map<String, Object> map = agencyService.findMerchByPage(result, 1, 10);
        for (String k : map.keySet()) {
	    	Integer key = (Integer) map.get("total");
            if( key != 1){
            	String  info = "委托机构号" + metchTax.getMerchNo() + "不存在或已注销！";
            	 result.put("RET", "FAIL");
            	 result.put("INFO", info);
            	 return result;
            }
        }
        return merchBankAccoutService.eidtTax(metchTax);
	}
	/**
	 * 删除信息
	 * @param bankAccout
	 * @return queryCity
	 */
	@ResponseBody
    @RequestMapping("/delect")
	public Map<String, Object> delect(String tId) {
        return merchBankAccoutService.delectTax(tId);
	}
	
	/**
     * 关键字查询开户行
     */
    @ResponseBody
	@RequestMapping("/queryBankNode")
    public List<?> queryBankNode(String bankName, Integer page, Integer rows) { 
    	return agencyService.queryBankNode(bankName, page, rows);
     }
	
}
