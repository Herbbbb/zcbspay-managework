package com.zcbspay.platform.manager.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.system.bean.DeptBean;
import com.zcbspay.platform.manager.system.dao.DeptDAO;
import com.zcbspay.platform.manager.system.service.DeptService;
@Service("deptService")
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDAO deptDAO;

	public Map<String, Object> findDeptByPage(Map<String, Object> variables, int page,
			int rows) {
		return deptDAO.findDeptByPage(variables, page, rows);
	}

	public long findDeptByPageCount(Map<String, Object> variables) {
		Object total = deptDAO.findDeptByPageCount(variables);
		return Long.valueOf(total.toString());
	}

	public List<?> saveDept(DeptBean dept) {
		return deptDAO.saveDept(dept);
	}

	public List<?> updateDept(DeptBean dept) {
		return deptDAO.updateDept(dept);
	}

	public List<?> deleteDept(Long deptId) {
		return deptDAO.deleteDept(deptId);
	}

    @Override
    public List<?> updateDeptNotes(String deptCode, String notes) {
        return deptDAO.updateDeptNotes(deptCode,notes);
    }

	@Override
	public DeptBean get(Long deptId) {
		 return deptDAO.get(deptId);
	}

	@Override
	public List<?> findByProperty(Long organId,String status) {
		 return deptDAO.findByProperty(organId,status);
	}

}
