package com.zcbspay.platform.manager.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.system.bean.RoleBean;
import com.zcbspay.platform.manager.system.dao.RoleDAO;
import com.zcbspay.platform.manager.system.pojo.PojoRole;
import com.zcbspay.platform.manager.system.service.RoleService;
@Service("roleService")
@SuppressWarnings("all")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDAO roleDAO;

	public Map<String, Object> findRoleByPage(Map<String, Object> variables, int page,
			int rows) {
		return roleDAO.findRoleByPage(variables, page, rows);
	}

	public long findRoleByPageCount(Map<String, Object> variables) {
		return roleDAO.findRoleByPageCount(variables);
	}

	public List<?> saveRole(RoleBean role) {
		return roleDAO.saveRole(role);
	}

	public List<?> updateRole(RoleBean role) {
		return roleDAO.updateRole(role);
	}

	public List<?> deleteRole(Long roleId) {
		return roleDAO.deleteRole(roleId);
	}

	@Override
	public RoleBean getSingleById(Long roleId) {
		return roleDAO.getSingleById(roleId);
	}

	@Override
	public List<?> findByProperty(Long deptId, String status) {
		return roleDAO.findByProperty(deptId,status);
	}

	@Override
	public List<?> findAll() {
		List<RoleBean> newlist = new ArrayList<RoleBean>();
		List<PojoRole> list = roleDAO.findAll();
		for (PojoRole role : list) {
			RoleBean bean = new RoleBean();
			bean.setRoleId(role.getRoleId());
			bean.setRoleName(role.getRoleName());
			bean.setOrganId(role.getOrganId());
			bean.setDeptId(role.getDeptId());
			bean.setCreator(role.getCreator());
			bean.setCreatDate(role.getCreatDate());
			bean.setStatus(role.getStatus());
			bean.setNotes(role.getNotes());
			bean.setRemarks(role.getRemarks());
			
			newlist.add(bean);
		}
		return newlist;
	}

}
