package com.zcbspay.platform.manager.controller.system;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.zcbspay.platform.manager.system.bean.UserFunctBean;
import com.zcbspay.platform.manager.system.bean.UserRoleBean;
import com.zcbspay.platform.manager.system.service.DeptService;
import com.zcbspay.platform.manager.system.service.FunctionService;
import com.zcbspay.platform.manager.system.service.OrganService;
import com.zcbspay.platform.manager.system.service.ProvinceService;
import com.zcbspay.platform.manager.system.service.RoleFunctService;
import com.zcbspay.platform.manager.system.service.RoleService;
import com.zcbspay.platform.manager.system.service.UserFunctService;
import com.zcbspay.platform.manager.system.service.UserRoleService;
import com.zcbspay.platform.manager.system.service.UserService;
import com.zcbspay.platform.manager.utils.MD5Util;

@Controller
@RequestMapping("/user")
@SuppressWarnings("all")
public class UserController {
	@Autowired
	private OrganService organService;
	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private DeptService deptService;
	@Autowired
	private FunctionService functionService;
	@Autowired
	private RoleFunctService roleFunctService;
	@Autowired
	private UserRoleService userRoleService;
	@Autowired
	private UserFunctService userFunctService;
	
	@ResponseBody
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView result=new ModelAndView("/system/user/user_manager");
        return result;
    }


		/**
		 * 显示组织机构列表
		 * 
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
		 * 
		 * @return
		 */
		@ResponseBody
	    @RequestMapping("/showDept")
		public List<?> showDept(Long organId){
			List<DeptBean> deptList = (List<DeptBean>)deptService.findByProperty(organId,null);
			
			return deptList;
		}

		/**
		 * 显示用户可选的角色（由所选的职能部门决定）
		 * 
		 * @return
		 */
		@ResponseBody
	    @RequestMapping("/showRole")
		public List<?> showRole(Long deptId,String status){
			List<RoleBean> deptList = (List<RoleBean>)roleService.findByProperty(deptId,"00");
			
			return deptList;
		}

		/**
		 * 查询
		 * 
		 * @return
		 */
		@ResponseBody
	    @RequestMapping("/query")
		public Map<String, Object> query(UserBean user,int page,int rows){
			Map<String, Object> variables = new HashMap<String, Object>();
			if (user != null) {
				variables.put("userName", user.getUserName());
				variables.put("userCode", user.getUserCode());
				variables.put("organId", user.getOrganId());
				variables.put("deptId", user.getDeptId());
				variables.put("roleId", user.getNotes());
			}
//			Map<String, Object> userList = userService.findUserByPage(variables,page, rows);
//			return userList;
			return userService.findUserByPage(variables,page, rows);
		}

		/**
		 * 新增用户信息
		 * 
		 * @return
		 */
		@ResponseBody
	    @RequestMapping("/save")
		public List<?> save(HttpServletRequest request,String pwd,UserBean user) {
			UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
//			UserBean user = new UserBean();
			user.setCreator(loginUser.getLoginName());
			String passwordMark = "w5y1j5z1s1l1z6z0y8z1m1l0c5r5y3z4";
			passwordMark = passwordMark + "123456";
			user.setPwd(MD5Util.MD5(passwordMark));
//			List<UserBean> returnList = (List<UserBean>) userService.saveUser(user);
//			return returnList;
			return userService.saveUser(user);
		}

		@ResponseBody
	    @RequestMapping("/update")
		public List<?> update(HttpServletRequest request,UserBean user) {
			UserBean loginUser = (UserBean) request.getSession().getAttribute("LOGIN_USER");
//			UserBean user = new UserBean();
			user.setCreator(loginUser.getLoginName());
//			List<UserBean> returnList = (List<UserBean>) userService.updateUser(user);
//			return returnList;
			return userService.updateUser(user);
		}

		/**
		 * 通过ID获取用户信息
		 * 
		 * @return
		 */
		@ResponseBody
	    @RequestMapping("/getSingleById")
		public UserBean getSingleById(Long userId) {
			UserBean user = userService.getSingleById(userId);
			return user;
		}

		/**
		 * 删除用户
		 * 
		 * @return
		 */
		@ResponseBody
	    @RequestMapping("/delete")
	    public List delete(HttpServletRequest request,UserBean user) {	    
		    user.setStatus("01");
		    List<UserBean> returnList = (List<UserBean>) userService.updateUser(user);
		    
		    List resultList = new ArrayList();
		    Map<String, Object> map1 = new HashMap<String, Object>();
		    map1 = (Map<String, Object>) returnList.get(0);
		    if(map1.get("RET").equals("succ")){
		        Map<String, Object> map2 = new HashMap<String, Object>();
		        map2.put("RET", "succ");
		        map2.put("INFO", "注销成功!");
		        resultList.add(map2);
		    }
			return resultList;
		}

		/**
		 * 重置密码
		 * 
		 * @return
		 */
		
		@ResponseBody
	    @RequestMapping("/resetPwd")
		public String resetPwd(Long userId) {
			UserBean user = userService.getSingleById(userId);
			String passwordMark = "w5y1j5z1s1l1z6z0y8z1m1l0c5r5y3z4";
			passwordMark = passwordMark + "123456";
			user.setPwd(MD5Util.MD5(passwordMark));
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, +30);//
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");   
			String pwdVal = format.format(cal.getTime().getTime());
//			user.setPwdValid(new Date());// 密码重置有效期更新为当前时间，登录后会强制修改密码
//			user.setPwdValid(new Timestamp(new Date().getTime()));// 密码重置有效期更新为当前时间，登录后会强制修改密码
			userService.resetPwd(user, pwdVal);
			return "true";
		}

		// /////////////////////////////////////用户权限管理模块///////////////////////////////////////////

		/**
		 * 加载所有角色
		 * 
		 * @return
		 */
		@ResponseBody
	    @RequestMapping("/queryRoleAllList")
		public List<?> queryRoleAllList() {
			return roleService.findByProperty(null,"00");
		}

		/**
		 * 加载用户已经有的角色
		 * 
		 * @return
		 */
		@ResponseBody
	    @RequestMapping("/queryRoleListhave")
		public List<?> queryRoleListhave(Long userId) {
			List<RoleBean> rolelist = (List<RoleBean>) roleService.findAll();
			List<UserRoleBean> rolefunctList = (List<UserRoleBean>) userRoleService.findByProperty(userId);
			
			List<RoleBean> haverolelist = new ArrayList<RoleBean>();
			for (RoleBean roleMl : rolelist) {
				for (UserRoleBean rfctml : rolefunctList) {
					if ((roleMl.getRoleId()).equals(rfctml.getRoleId())) {
						haverolelist.add(roleMl);
					}
				}
			}
			return haverolelist;

		}

		/**
		 * 加载用户已经有的权限
		 * 
		 * @return
		 */
		@ResponseBody
	    @RequestMapping("/queryFunction")
		public Map<String, Object> queryFunction(HttpServletRequest request,Long userId) {
			List<RoleFunctBean> roleList = new ArrayList<RoleFunctBean>();
			UserBean user = (UserBean) request.getSession().getAttribute("LOGIN_USER");
			List<FunctionBean> list = (List<FunctionBean>) functionService.findAllFuntion(user);
			List<UserRoleBean> allRoleList = (List<UserRoleBean>) userRoleService.findByProperty(userId);
			List<Long> roleIdlist = new ArrayList<Long>();
			for (UserRoleBean role : allRoleList) {
				roleIdlist.add(role.getRoleId());
			}
			if (roleIdlist.size() > 0) {
					roleList = (List<RoleFunctBean>) roleFunctService.findRoleFunctByRoleIds(roleIdlist);
			}
			List<UserFunctBean> userList = (List<UserFunctBean>) userFunctService.findByProperty(userId);
			List<FunctionBean> removeList = new ArrayList<FunctionBean>();
			List<FunctionBean> children = new ArrayList<FunctionBean>();
			for (FunctionBean function : list) {
				if ("0".equals(function.getParentId())) {// 根节点
					if (children != null) {
						children = null;
					}
					function.setChildren(new ArrayList<FunctionBean>());
					children = function.getChildren();
					function.setState("closed");
				} else {// 子节点
					for (RoleFunctBean roleFunct : roleList) {
						if (roleFunct.getFunctId().equals(function.getFunctId())) {
							function.setChecked("true");
							function.setText("<span style='color:blue'>" + function.getFunctName() + "</span>");
						}
					}
					for (UserFunctBean userFunct : userList) {
						if (userFunct.getFunctId().equals(function.getFunctId())) {
							function.setChecked("true");
						}
					}
					children.add(function);
					removeList.add(function);
				}
				function.setId(function.getFunctId().toString());
				if(function.getText() == null || function.getText().toString().equals("")){
					function.setText(function.getFunctName());
				}
			}
			list.removeAll(removeList);// 移除全部的子节点数据

			Map<String, Object> result = new HashMap<String, Object>();
			result.put("result", list);
			result.put("roleFunction", roleList);
			return result;
		}

		/**
		 * 保存用户权限
		 * 
		 * @return
		 */
		@ResponseBody
	    @RequestMapping("/saveAuth")
		public String saveAuth(String userFunc,Long userId) {
			userFunctService.deleteOldFunc(userId);
			if(userFunc != null || !userFunc.toString().equals("")){
				String[] funcId = userFunc.split(",");
				List<UserFunctBean> functList = new ArrayList<UserFunctBean>();
				Long num = 1L;
				for (int i = 0; i < funcId.length; i++) {
					UserFunctBean model = new UserFunctBean();
					model.setUserFunctId(num);
					model.setUserId(userId);
					model.setFunctId(Long.valueOf(funcId[i]));
					functList.add(model);
					num++;
				}
				userFunctService.save(functList);
				return "true";
			}
			return "false";
		}

		/**
		 * 保存用户角色
		 * 
		 * @return
		 */
		@ResponseBody
	    @RequestMapping("/SaveUserRole")
		public String SaveUserRole(String userFunc,Long userId) {
			userRoleService.deleteOldUserRole(userId);
			if(userFunc != null || !userFunc.toString().equals("")){
				String[] roleId = userFunc.split(",");
				List<UserRoleBean> userRoleList = new ArrayList<UserRoleBean>();
				Long num = 1L;
				for (int i = 0; i < roleId.length; i++) {
					UserRoleBean model = new UserRoleBean();
					model.setUserRoleId(num);
					model.setUserId(userId);
					model.setRoleId(Long.valueOf(roleId[i]));
					userRoleList.add(model);
					num++;
				}
				userRoleService.save(userRoleList);
				return "true";
			}
			return "false";
		}

		@ResponseBody
	    @RequestMapping("/changePassword")
		public Map<String, Object> changePassword(HttpServletRequest request,Long userId,String oldPwd,String newPwd,String conPwd) {
			String passwordMark = "w5y1j5z1s1l1z6z0y8z1m1l0c5r5y3z4";
			String old_passwordMark = passwordMark + oldPwd;
			String new_passwordMark = passwordMark + newPwd;
			UserBean user = (UserBean) request.getSession().getAttribute("LOGIN_USER");
			String md5Pwd = MD5Util.MD5(old_passwordMark);
			Map<String, Object> returnMap = new HashMap<String, Object>();
			if (md5Pwd.equalsIgnoreCase(user.getPwd())) {// 检验MD5密码是否正确
				if (newPwd.equalsIgnoreCase(conPwd)) {
					user.setPwd(MD5Util.MD5(new_passwordMark));
					// 密码有效期延长30天
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.DAY_OF_MONTH, +30);//
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");   
					String pwdVal = format.format(cal.getTime().getTime());
//					Timestamp timestamp = new Timestamp(cal.getTime().getTime());
					UserBean bean = new UserBean();
					bean.setPwd(MD5Util.MD5(new_passwordMark));
					bean.setUserId(user.getUserId());
					userService.resetPwd(bean, pwdVal);
					returnMap.put("retcode", "succ");
					returnMap.put("retinfo", "操作成功！");
				} else {
					returnMap.put("retcode", "error");
					returnMap.put("retinfo", "确认密码输入错误！");

				}

			} else {
				returnMap.put("retcode", "error");
				returnMap.put("retinfo", "原始密码错误！");
			}
			return returnMap;
		}

	}

