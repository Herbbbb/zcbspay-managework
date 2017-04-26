package com.zcbspay.platform.manager.system.dao;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.system.bean.DeptBean;
import com.zcbspay.platform.manager.system.pojo.PojoDept;

public interface DeptDAO extends BaseDAO<PojoDept>{

	/**
	 * 更新备注信息
	 * @param deptCode 部门代码
	 * @param notes 备注
	 * @return
	 */
	public List<?> updateDeptNotes(String deptCode, String notes);
	/**
	 * 
	 * @param variables
	 * @param page
	 * @param rows
	 * @return
	 */
    public Map<String, Object> findDeptByPage(Map<String, Object> variables, int page,int rows);
    /**
     * 
     * @param variables
     * @return
     */
    public long findDeptByPageCount(Map<String, Object> variables);
    /**
     * 
     * @param dept
     * @return
     */
    public List<?> saveDept(DeptBean dept);
    /**
     * 
     * @param dept
     * @return
     */
    public List<?> updateDept(DeptBean dept);
    /**
     * 
     * @param deptId
     * @return
     */
    public List<?> deleteDept(Long deptId);
    
	/**
	 * @param deptId
	 * @return
	 */
	public DeptBean get(Long deptId);
	
	/**
	 * @param deptId
	 * @return
	 */
	public List<?> findByProperty(Long organId,String status);
}
