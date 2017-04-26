package com.zcbspay.platform.manager.system.service;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.system.bean.DeptBean;

/**
 * 
 * 部门service
 *
 * @author guojia
 * @version
 * @date 2016年12月28日 上午11:50:04
 * @since
 */
public interface DeptService {
	
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
	 * @param deptId
	 * @return
	 */
	public List<?> deleteDept(Long deptId);
    /**
     * 
     * @param deptCode
     * @param notes
     * @return
     */
    public List<?> updateDeptNotes(String deptCode, String notes);
    
	/**
	 * @param deptId
	 * @return
	 */
	public DeptBean get(Long deptId);
	
	/**
	 * @param status
	 * @return
	 */
	public List<?> findByProperty(Long organId,String status);
}
