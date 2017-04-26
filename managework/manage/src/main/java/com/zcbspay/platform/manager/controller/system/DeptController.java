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

import com.zcbspay.platform.manager.system.bean.DeptBean;
import com.zcbspay.platform.manager.system.bean.OrganBean;
import com.zcbspay.platform.manager.system.bean.UserBean;
import com.zcbspay.platform.manager.system.service.DeptService;
import com.zcbspay.platform.manager.system.service.OrganService;

@Controller
@RequestMapping("/dept")
@SuppressWarnings("all")
public class DeptController {

	@Autowired
	private DeptService deptService;
	@Autowired
	private OrganService organService;
	
	@ResponseBody
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView result=new ModelAndView("/system/dept_manager");
        return result;
    }

	/**
	 * 部门查询
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/query")
	public Map<String, Object> query(String deptName,String deptCode,int page,int rows){
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("deptName", deptName);
		variables.put("deptCode", deptCode);
		Map<String, Object> deptList = deptService.findDeptByPage(variables,page, rows);
		return deptList;
	}
	
	/**
	 * 显示部门列表
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/showOrgan")
	public List<?> showOrgan(String status){
		List<OrganBean> organList = (List<OrganBean>) organService.findByProperty(null,status);
		return organList;
	}
	
	/**
	 * 保存部门信息
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/save")
	public List<?> save(HttpServletRequest request,DeptBean dept){
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		dept.setCreator(loginUser.getLoginName());
		List<DeptBean> returnList = (List<DeptBean>) deptService.saveDept(dept);
		return returnList;
	}
	
	/**
	 * 更新部门信息
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/update")
	public List<?> update(HttpServletRequest request,DeptBean dept){
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		dept.setCreator(loginUser.getLoginName());
		List<DeptBean> returnList = (List<DeptBean>) deptService.updateDept(dept);
		return returnList;
	}
	
	/**
	 * 删除部门信息
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/delete")
    public List<?> delete(Long deptId,HttpServletRequest request,DeptBean dept){
		
		List<DeptBean> returnList = (List<DeptBean>) deptService.deleteDept(deptId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map<String, Object>) returnList.get(0);
		
		if(map.get("RET").equals("succ")){//判断注销返回成功时，去更新备注信息
			
		    UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
			dept.setCreator(loginUser.getLoginName());
			dept.setStatus("01");
			
			List<DeptBean> returnList1 = (List<DeptBean>) deptService.updateDept(dept);
			
		}
		
		return returnList;
	}
	
	/**
	 * 通过ID获取部门信息
	 * @return
	 * 
	 * 
	 */
	@ResponseBody
    @RequestMapping("/getSingleById")
	public DeptBean getSingleById(Long deptId){
//		Map<String, Object> variable = new HashMap<String, Object>();
		DeptBean dept = deptService.get(deptId);
//		variable.put("deptBean", dept);
		
		return dept;
	}

}
