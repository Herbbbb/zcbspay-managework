package com.zcbspay.platform.manager.system.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.system.dao.UserRoleDAO;
import com.zcbspay.platform.manager.system.pojo.PojoUserRole;

@Repository
public class UserRoleDAOImpl extends HibernateBaseDAOImpl<PojoUserRole> implements UserRoleDAO{

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void deleteOldUserRole(Long userId) {
		updateByHQL("delete from PojoUserRole u where u.userId = ?",new Object[]{userId});
	}

	@Override
	public List<?> findByProperty(Long userId) {
		String sql = "select u from PojoUserRole u where u.userId =?";
		Object[] paramaters = new Object[]{userId};
		return queryByHQL(sql, paramaters);
	}

	@Override
	public void save(List<PojoUserRole> list) {
		Object[] paramaters = null;
		String sql;
		if(list.size() > 0){
			for(PojoUserRole userFunct : list){
				sql = "insert into T_USER_ROLE(USER_ROLE_ID,USER_ID,ROLE_ID) values (?,?,?)";
				paramaters = new Object[]{
						"".equals(userFunct.getUserRoleId()) ? null : userFunct.getUserRoleId(),
						"".equals(userFunct.getUserId()) ? null : userFunct.getUserId(),
						"".equals(userFunct.getRoleId()) ? null : userFunct.getRoleId()};
				queryBySQL(sql, paramaters);
			}
		}
	}
}
