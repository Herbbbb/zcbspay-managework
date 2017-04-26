package com.zcbspay.platform.manager.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.system.bean.OrganBean;
import com.zcbspay.platform.manager.system.dao.OrganDAO;
import com.zcbspay.platform.manager.system.service.OrganService;


@Service("organService")
public class OrganServiceImpl implements OrganService {
	
	@Autowired
	private OrganDAO organDAO;

	@Override
	public List<?> saveOrgan(OrganBean organ) {
		return organDAO.saveOrgan(organ);
	}
	@Override
	public List<?> updateOrgan(OrganBean organ) {
		return organDAO.updateOrgan(organ);
	}
	@Override
	public Map<String, Object> findOrganByPage(Map<String, Object> variables, int page,
			int rows) {
		return organDAO.findOrganByPage(variables, page, rows);
	}
	@Override
	public long findOrganByPageCount(Map<String, Object> variables) {
		return organDAO.findOrganByPageCount(variables);
	}
	@Override
	public List<?> deleteOrgan(Long organId) {
		return organDAO.deleteOrgan(organId);	
	}
	
	@Override
	public List<?> findAll() {
		return organDAO.findAll();	
	}
	@Override
	public List<?> queryByHQL(String string, Object[] objects) {
		return organDAO.queryBy(string,objects);
	}
	@Override
	public OrganBean get(Long organId) {
		return organDAO.get(organId);
	}
	@Override
	public List<?> findByProperty(Long organId,String status) {
		return organDAO.findByProperty(organId,status);
	}
}
