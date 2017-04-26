package com.zcbspay.platform.manager.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.system.bean.RoleFunctBean;
import com.zcbspay.platform.manager.system.dao.RoleFunctDAO;
import com.zcbspay.platform.manager.system.pojo.PojoRoleFunct;
import com.zcbspay.platform.manager.system.service.RoleFunctService;
@Service("roleFunctService")
@SuppressWarnings("all")
public class RoleFunctServiceImpl implements RoleFunctService{

	@Autowired
	private RoleFunctDAO roleFunctDAO;
	
	public void deleteRoleFunction(Long roleId) {
		roleFunctDAO.deleteRoleFunction(roleId);
	}

	@Override
	public List<?> findByProperty(Long roleId) {
		List<RoleFunctBean> beanList = new ArrayList<RoleFunctBean>();
		List<PojoRoleFunct> list = (List<PojoRoleFunct>) roleFunctDAO.findByProperty(roleId);
		for (PojoRoleFunct pojo : list) {
			RoleFunctBean bean = new RoleFunctBean();
			bean.setFunctId(pojo.getFunctId());
			bean.setRoleFunctId(pojo.getRoleFunctId());
			bean.setRoleId(pojo.getRoleId());
			
			beanList.add(bean);
		}
		return beanList;
	}

	@Override
	public void save(List<RoleFunctBean> functList) {
		List<PojoRoleFunct> list = new ArrayList<PojoRoleFunct>();
		for(RoleFunctBean roleFunct : functList){
			PojoRoleFunct roleunct = new PojoRoleFunct();
			roleunct.setFunctId(roleFunct.getFunctId());
			roleunct.setRoleFunctId(roleFunct.getRoleFunctId());
			roleunct.setRoleId(roleFunct.getRoleId());
			list.add(roleunct);
		}
		roleFunctDAO.save(list);
	}

	@Override
	public List<RoleFunctBean> findRoleFunctByRoleIds(List<Long> roleIdlist) {
		List<RoleFunctBean> beanList = new ArrayList<RoleFunctBean>();
		List<PojoRoleFunct> list = (List<PojoRoleFunct>) roleFunctDAO.findRoleFunctByRoleIds(roleIdlist);
		for (PojoRoleFunct pojo : list) {
			RoleFunctBean bean = new RoleFunctBean();
			bean.setFunctId(pojo.getFunctId());
			bean.setRoleFunctId(pojo.getRoleFunctId());
			bean.setRoleId(pojo.getRoleId());
			
			beanList.add(bean);
		}
		return beanList;
	}
}
