package com.zcbspay.platform.manager.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zcbspay.platform.manager.system.bean.CityBean;
import com.zcbspay.platform.manager.system.bean.OrganBean;
import com.zcbspay.platform.manager.system.bean.ProvinceBean;
import com.zcbspay.platform.manager.system.bean.UserBean;
import com.zcbspay.platform.manager.system.service.CityService;
import com.zcbspay.platform.manager.system.service.OrganService;
import com.zcbspay.platform.manager.system.service.ProvinceService;

@Controller
@RequestMapping("/organ")
@SuppressWarnings("all")
public class OrganController {

private static final long serialVersionUID = -5212979447414357931L;
	
	@Autowired
	private OrganService organService;
	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private CityService cityService;

	@ResponseBody
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView result=new ModelAndView("/system/organ_manager");
        return result;
    }
	/**
	 * 获取市信息集合
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/queryCity")
	public List<?> queryCity(long pid){
		
		return cityService.findNotMuniByPid(pid);
	}
	/**
	 * 获取省信息集合
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/queryProvince")
	public List<ProvinceBean> queryProvince(){
		
		return provinceService.findAll();
	}
	
	/**
	 * 取得上级机构集合
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/getSuper")
	public List<?> getSuper(){
			 
		return organService.queryByHQL(null, null);
	}
	
	/**
	 * 删除组织机构   
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/delete")
	public List<?> delete(Long organId){
		
		return organService.deleteOrgan(organId);
	}
	/**
	 * 新增组织机构信息
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/save")
	public List<?> save(HttpServletRequest request,OrganBean organ){
		
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		organ.setCreator(loginUser.getLoginName());
		return organService.saveOrgan(organ);
	}
	
	/**
	 * 更新组织机构信息
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/update")
	public List<?> update(HttpServletRequest request,OrganBean organ){
		
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		
		organ.setCreator(loginUser.getLoginName());
		
		return organService.updateOrgan(organ);
	}
	
	/**
	 * 通过ID获取组织机构信息
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/getSingleById")
	public Map<String, Object> getSingleById(Long organId,Long pid){
		Map<String, Object> variable = new HashMap<String, Object>();
		OrganBean organ = organService.get(organId);
		pid = Long.parseLong(organ.getProvince());
		List<CityBean> cityList = (List<CityBean>) cityService.findNotMuniByPid(pid);
		variable.put("organModel", organ);
		variable.put("cityList", cityList);
		
		return variable;
	}
	
	/**
	 * 查询组织机构信息
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/query")
	public Map<String, Object> query(String organName,String organCode,int page,int rows){
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("organName", organName);
		variables.put("organCode", organCode);
		return organService.findOrganByPage(variables,page, rows);
	}

}

