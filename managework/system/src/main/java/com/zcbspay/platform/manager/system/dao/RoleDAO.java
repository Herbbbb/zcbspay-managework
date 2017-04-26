package com.zcbspay.platform.manager.system.dao;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.system.bean.RoleBean;
import com.zcbspay.platform.manager.system.pojo.PojoRole;

/**
 * @author guojia
 *
 */
public interface RoleDAO extends BaseDAO<PojoRole>{

	/**
	 * 
	 * @param variables
	 * @param page
	 * @param rows
	 * @return
	 */
	public Map<String, Object> findRoleByPage(Map<String, Object> variables, int page,int rows);
	/**
	 * 
	 * @param variables
	 * @return
	 */
	public long findRoleByPageCount(Map<String, Object> variables);
	/**
	 * 
	 * @param role
	 * @return
	 */
	public List<?> saveRole(RoleBean role);
	/**
	 * 
	 * @param role
	 * @return
	 */
	public List<?> updateRole(RoleBean role);
	/**
	 * 
	 * @param roleId
	 * @return
	 */
	public List<?> deleteRole(Long roleId);
	
	/**
	 * @param roleId
	 * @return
	 */
	public RoleBean getSingleById(Long roleId);
	
	/**
	 * @param organId
	 * @param status
	 * @return
	 */
	public List<?> findByProperty(Long deptId, String status);
	
	/**
	 * @return
	 */
	public List<PojoRole> findAll();
}
