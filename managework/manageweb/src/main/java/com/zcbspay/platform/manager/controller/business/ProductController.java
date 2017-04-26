package com.zcbspay.platform.manager.controller.business;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zcbspay.platform.manager.business.bean.ProductBean;
import com.zcbspay.platform.manager.business.service.ProductService;
import com.zcbspay.platform.manager.utils.JsonUtils;
import com.zcbspay.platform.manager.utils.UserHelper;

@Controller
@RequestMapping("/product/")
public class ProductController {

	@Autowired
	private ProductService productService;

	

	/**
	 * 产品信息管理页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("show")
	public String show(HttpServletRequest request) {
		return "/business/product_manager";
	}

	/**
	 * 产品组合分页查询
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryProduct")
	public Map<String, Object> queryProduct(HttpServletRequest request, ProductBean productBean, String page,
			String rows) {
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("userId", UserHelper.getCurrentUser(request).getUserId());
		variables.put("prdtver", productBean.getPrdtver());
		variables.put("prdtname", productBean.getPrdtname());
		Map<String, Object> groupList = productService.findProductByPage(variables, Integer.valueOf(page),
				Integer.valueOf(rows));
		return groupList;
	}

	/**
	 * 产品新增
	 * 
	 * @param productBean
	 * @param request
	 * @param checkboxList
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addProduct")
	public void addProduct(ProductBean productBean, HttpServletRequest request, HttpServletResponse response,
			String[] checkboxList) {
		String result = "";
		if (StringUtils.isEmpty(productBean.getPrdtname().trim())) {
			result = "产品名称不能为空";
		} else if (checkboxList == null || checkboxList.length == 0) {
			result = "请选择业务";
		} else {
			productBean.setInuser(UserHelper.getCurrentUser(request).getUserId());
			result = productService.AddOneProduct(productBean, Arrays.asList(checkboxList));
		}

		JsonUtils.json_encodeAndWrite(response, result);
	}

	/**
	 * 业务类型
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("queryBusinessType")
	public List<?> queryBusinessType() throws Exception {
		List<?> paralist = (List<?>) productService.queryBusinessType();
		return paralist;
	}

	/**
	 * 查询一条产品信息
	 */
	@ResponseBody
	@RequestMapping("queryOneProduct")
	public Map<String, Object> queryOneProduct(String pid) {
		Map<String, Object> product = null;
		if (pid != null && !pid.equals("")) {
			product = productService.findByPrdtver(pid);
		}
		return product;
	}

	// 查询业务类型，标记拥有的业务
	@ResponseBody
	@RequestMapping("queryProductCase")
	public List<?> queryProductCase(String pid, HttpServletResponse response) {
		List<?> caselist = null;
		if (pid != null && !pid.equals("")) {
			caselist = productService.queryProdCase(pid);
			return caselist;
		}
		return caselist;
	}

	// 产品修改
	@ResponseBody
	@RequestMapping("updateProduct")
	public void updateProduct(ProductBean productBean,HttpServletResponse response,HttpServletRequest request,String[] checkboxList) {
		String result = "";
		if (StringUtils.isEmpty(productBean.getPrdtname().trim())
				|| StringUtils.isEmpty(productBean.getPrdtver().trim())) {
			result = "产品名称不能为空";
		}
		productBean.setInuser(UserHelper.getCurrentUser(request).getUserId());
	    result = productService.updateProduct(productBean, Arrays.asList(checkboxList));
		JsonUtils.json_encodeAndWrite(response, result);
	}
	
	/**
	 * 查询所有产品
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("queryProductAll")
	public List<?> queryProductAll() {
		List<?> resultList = productService.findAll();
		return resultList;
	}
}
