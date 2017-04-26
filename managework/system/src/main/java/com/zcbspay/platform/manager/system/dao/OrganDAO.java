package com.zcbspay.platform.manager.system.dao;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.system.bean.OrganBean;
import com.zcbspay.platform.manager.system.pojo.PojoOrgan;

public interface OrganDAO extends BaseDAO<PojoOrgan>{

	/**
	 * 
	 * @param organ
	 * @return
	 */
	public List<?> saveOrgan(OrganBean organ);
	/**
	 * 
	 * @param organ
	 * @return
	 */
	public List<?> updateOrgan(OrganBean organ);
	/**
	 * 
	 * @param variables
	 * @param page
	 * @param rows
	 * @return
	 */
	public  Map<String, Object> findOrganByPage(Map<String, Object> variables, int page,int rows);
	/**
	 * 
	 * @param variables
	 * @return
	 */
	public long findOrganByPageCount(Map<String, Object> variables);
	/**
	 * 
	 * @param organId
	 * @return
	 */
	public List<?> deleteOrgan(Long organId);
	
	/**
	 * @return
	 */
	public List<?> findAll();
	
	/**
	 * @param string
	 * @param objects
	 * @return
	 */
	public List<?> queryBy(String string, Object[] objects);
	
	/**
	 * @param organId
	 * @return
	 */
	public OrganBean get(Long organId);
	
	/**
	 * @param organId
	 * @param status
	 * @return
	 */
	public List<?> findByProperty(Long organId,String status);
}
