package com.zcbspay.platform.manager.controller.system;

import java.util.ArrayList;
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
import com.zcbspay.platform.manager.system.bean.FunctionBean;
import com.zcbspay.platform.manager.system.bean.OrganBean;
import com.zcbspay.platform.manager.system.bean.RoleBean;
import com.zcbspay.platform.manager.system.bean.RoleFunctBean;
import com.zcbspay.platform.manager.system.bean.UserBean;
import com.zcbspay.platform.manager.system.service.DeptService;
import com.zcbspay.platform.manager.system.service.FunctionService;
import com.zcbspay.platform.manager.system.service.OrganService;
import com.zcbspay.platform.manager.system.service.RoleFunctService;
import com.zcbspay.platform.manager.system.service.RoleService;

@Controller
@RequestMapping("/role")
@SuppressWarnings("all")
public class RoleController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private OrganService organService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private FunctionService functionService;
	@Autowired
	private RoleFunctService roleFunctService;
	
	
	@ResponseBody
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView result=new ModelAndView("/system/role/role_manager");
        return result;
    }
	
	
	/**
	 * 显示组织机构列表
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/showOrgan")
	public List<?> showOrgan(String status){
		List<OrganBean> organList = (List<OrganBean>) organService.findByProperty(null,status);
		return organList;
	}
	
	/**
	 * 显示职能部门列表
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/showDept")
	public List<?> showDept(Long organId){
//			Map<String, Object> variable = new HashMap<String, Object>();
//			variable.put("status", "00");
//			variable.put("organId", organId);
		List<DeptBean> deptList = (List<DeptBean>)deptService.findByProperty(organId,null);
		
		return deptList;
	}
	/**
	 * 查询角色信息
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/query")
	public Map<String, Object> query(RoleBean role,int page,int rows){
		Map<String, Object> variables = new HashMap<String, Object>();
		if(role!=null){
			variables.put("roleName", role.getRoleName());
			variables.put("organId", role.getOrganId());
			variables.put("deptId", role.getDeptId());
		}
		Map<String, Object> roleList = roleService.findRoleByPage(variables,page, rows);
		return roleList;
	}
	
	/**
	 * 新增角色信息
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/save")
	public List<?> save(HttpServletRequest request,RoleBean role){
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		role.setCreator(loginUser.getLoginName());
		List<RoleBean> returnList = (List<RoleBean>) roleService.saveRole(role);
		return returnList;
	}
	
	/**
	 * 更新角色信息
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/update")
	public List<?> update(HttpServletRequest request,RoleBean role){
		UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
		role.setCreator(loginUser.getLoginName());
		List<RoleBean> returnList = (List<RoleBean>) roleService.updateRole(role);
		return returnList;
	}
	
	/**
	 * 删除角色信息
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/delete")
    public List<?> delete(HttpServletRequest request,RoleBean role){
		List<RoleBean> returnList = (List<RoleBean>) roleService.deleteRole(role.getRoleId());
		Map<String, Object> map =new HashMap<String, Object>();
		map = (Map<String, Object>) returnList.get(0);
		if(map.get("RET").equals("succ")){
			UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
			role.setCreator(loginUser.getLoginName());
		    role.setStatus("01");
		    List<RoleBean> list = (List<RoleBean>) roleService.updateRole(role);
		}	
		return returnList;
	}
	
	/**
	 * 通过Id获取角色信息
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/getSingleById")
	public RoleBean getSingleById(Long roleId){
		RoleBean role = roleService.getSingleById(roleId);
		return role;
	}
	
	@ResponseBody
    @RequestMapping("/authority")
    public ModelAndView authority(HttpServletRequest request) {
        ModelAndView result=new ModelAndView("/system/role/role_authority");
        return result;
    }
	/**
	 * 显示角色权限页面
	 * @return
	 *//*
	@ResponseBody
    @RequestMapping("/showAuth")
//	@Authority(actionName="showReceive", privilege="14")
	public String showAuth(HttpServletRequest request) {
		Map<String, Object> variable = new HashMap<String, Object>();
		UserBean user = (UserBean) request.getSession().getAttribute("LOGIN_USER");
//		UserModel user = getCurrentUser();
		if(user.getIsadmin().equals("1")||user.getOrganId()==0){//管理员和总公司用户取得全部组织机构信息,职能部门信息
			List<OrganBean> organList = (List<OrganBean>) organService.findByProperty(null,"00");
			List<RoleBean> roleList = (List<RoleBean>) roleService.findByProperty(null,"00");
			List<DeptBean> deptList = (List<DeptBean>) deptService.findByProperty(null,"00");
		}else{//其他用户只能取得其所在机构的信息
			variable.put("status", "1");
			variable.put("organId", user.getOrganId());
//			organList = serviceContainer.getOrganService().findByProperty(variable);
			List<OrganBean> organList = (List<OrganBean>) organService.findByProperty(user.getOrganId(),"1");
			variable = new HashMap<String, Object>();
			variable.put("status", "00");
			variable.put("organId", user.getOrganId());
//			roleList = serviceContainer.getRoleService().findByProperty(variable);
			List<RoleBean> roleList = (List<RoleBean>) roleService.findByProperty(user.getOrganId(),"00");
			variable = new HashMap<String, Object>();
			variable.put("status", "1");
			variable.put("organId", user.getOrganId());
//			deptList = serviceContainer.getDeptService().findByProperty(variable);
			List<DeptBean> deptList = (List<DeptBean>) deptService.findByProperty(user.getOrganId(),"1");
			
		}
		return "role_authority";
	}*/
	
	/**
	 * 点击某一角色后 查出对应角色权限
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
    @RequestMapping("/queryFunction")
    public Map<String, Object> queryFunction(HttpServletRequest request,Long roleId) throws Exception {
		
			UserBean user = (UserBean) request.getSession().getAttribute("LOGIN_USER");
            List<FunctionBean> list = (List<FunctionBean>)functionService.findAllFuntion(user);
			List<RoleFunctBean> roleList =  (List<RoleFunctBean>)roleFunctService.findByProperty(roleId);
			List<FunctionBean> removeList = new ArrayList<FunctionBean>(); 
			List<FunctionBean> children = new ArrayList<FunctionBean>();
			
			for(FunctionBean function : list){
				if("0".equals(function.getParentId())){//根节点
					if(children != null){
						children=null;
					}
					function.setChildren(new ArrayList<FunctionBean>());
					children = function.getChildren();
					function.setState("closed");
				}else{//子节点
					
					for(RoleFunctBean roleFunct : roleList){
						
						if(roleFunct.getFunctId().equals(function.getFunctId()) ){
							function.setChecked("true");
							function.setText(function.getFunctName());//没有蓝色  设置成可选
						}
						
					}
					children.add(function);//function.getChildren().add(function);
					removeList.add(function);
					
				}
				function.setId(function.getFunctId().toString());
				
				if(function.getText() == null || function.getText().toString().equals("")){
					function.setText(function.getFunctName());
				}
			}
			list.removeAll(removeList);//移除全部的子节点数据
			
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("result",list);
			result.put("roleFunction",roleList);
		
		return result;
    }
    
	/**
     * 修改角色权限（先删除，再重新保存）
     * @return
     */
	@ResponseBody
    @RequestMapping("/saveFunction")
    public String saveFunction(Long roleId,String userFunc){
    	if(roleId!=null&&!roleId.equals("")){
			roleFunctService.deleteRoleFunction(roleId);
			String[] funcId = userFunc.split(",");
			List<RoleFunctBean> functList = new ArrayList<RoleFunctBean>();
			Long num = 1L;
			for(int i = 0;i<funcId.length;i++){
				RoleFunctBean model = new RoleFunctBean();
				model.setRoleFunctId(num);
				model.setRoleId(roleId);
				model.setFunctId(Long.valueOf(funcId[i]));
				functList.add(model);
				num++;
			}
			roleFunctService.save(functList);
			return "true";
    	}
		return "flase";
	}

}
