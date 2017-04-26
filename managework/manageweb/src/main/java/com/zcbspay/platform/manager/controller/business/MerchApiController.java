package com.zcbspay.platform.manager.controller.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zcbspay.platform.manager.business.bean.BusiRateBean;
import com.zcbspay.platform.manager.business.bean.MerchAPIBean;
import com.zcbspay.platform.manager.business.service.ProductService;
import com.zcbspay.platform.manager.utils.JsonUtils;
import com.zcbspay.platform.manager.utils.UserHelper;
/**
 * 扣率相关的类
 * @author: zhangshd
 * @date:   2017年4月13日 15:35:30 
 * @version :1.0
 */
@Controller
@RequestMapping("/merchapi/")
public class MerchApiController {
	
	@Autowired
	private ProductService productService; 
	
	
	@RequestMapping("show")
	public String showBusiRate() {
		return "business/merchapi_manager";
	}
	
	@ResponseBody
	@RequestMapping("saveMerch")
	public void saveMerch(HttpServletResponse response,MerchAPIBean merchAPIBean,HttpServletRequest request) {
		merchAPIBean.setUserId(UserHelper.getCurrentUser(request).getUserId().toString());
		String mark = productService.saveMerch(merchAPIBean);
		JsonUtils.json_encodeAndWrite(response, mark);
	}
	
	@ResponseBody
	@RequestMapping("updateMerch")
	public void updateMerch(HttpServletResponse response,MerchAPIBean merchAPIBean,HttpServletRequest request) {
		merchAPIBean.setUserId(UserHelper.getCurrentUser(request).getUserId().toString());
		String mark = productService.updateMerch(merchAPIBean);
		JsonUtils.json_encodeAndWrite(response, mark);
	}
	
	
	@ResponseBody
	@RequestMapping("queryMerchs")
	public Map<String, Object> queryMerchs(HttpServletRequest request, MerchAPIBean merchAPIBean, String page,
			String rows) {
		merchAPIBean.setUserId(UserHelper.getCurrentUser(request).getUserId().toString());
		return productService.queryMerchs(merchAPIBean, page, rows);
	}
	@ResponseBody
	@RequestMapping("changeStatus")
	public Map<String, Object> changeStatus(HttpServletRequest request, MerchAPIBean merchAPIBean,HttpServletResponse response) {
		merchAPIBean.setUserId(UserHelper.getCurrentUser(request).getUserId().toString());
		String mark = productService.changeStatus(merchAPIBean);
		Map<String, Object> result=new HashMap<String, Object>();
		result.put("flag", mark);
		return result;
		//JsonUtils.json_encodeAndWrite(response, mark);
	}
	
	
	
}
