package com.zcbspay.platform.manager.system.service;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.system.bean.OrganBean;
/**
 * 
 * Class Description
 *
 * @author guojia
 * @version
 * @date 2016年12月28日 下午4:21:36
 * @since
 */
public interface OrganService{
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
	public Map<String, Object> findOrganByPage(Map<String, Object> variables, int page, int rows);
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
	
	public List<?> findAll();
	
	public List<?> queryByHQL(String string, Object[] objects);
	
	public OrganBean get(Long organId);
	
	public List<?> findByProperty(Long organId,String status);
}
