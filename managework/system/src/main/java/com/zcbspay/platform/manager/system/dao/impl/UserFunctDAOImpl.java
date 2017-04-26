package com.zcbspay.platform.manager.system.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.system.dao.UserFunctDAO;
import com.zcbspay.platform.manager.system.pojo.PojoUserFunct;

@Repository
public class UserFunctDAOImpl extends HibernateBaseDAOImpl<PojoUserFunct> implements UserFunctDAO{
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void deleteOldFunc(Long userId) {
		updateByHQL("delete from PojoUserFunct u where u.userId = ?",new Object[]{userId});
	}

	@Override
	public List<?> findByProperty(Long userId) {
		String sql = "select u from PojoUserFunct u where u.userId =?";
		Object[] paramaters = new Object[]{userId};
		return queryByHQL(sql, paramaters);
	}

	@Override
	public void save(List<PojoUserFunct> list) {
		Object[] paramaters = null;
		String sql;
		if(list.size() > 0){
			for(PojoUserFunct userFunct : list){
				sql = "insert into T_USER_FUNCT(USER_ID,FUNCT_ID) values (?,?)";
				paramaters = new Object[]{
						"".equals(userFunct.getUserId()) ? null : userFunct.getUserId(),
						"".equals(userFunct.getFunctId()) ? null : userFunct.getFunctId()};
				queryBySQL(sql, paramaters);
			}
		}
	}
}
