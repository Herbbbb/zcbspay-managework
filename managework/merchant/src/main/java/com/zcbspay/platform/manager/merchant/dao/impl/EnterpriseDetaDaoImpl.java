package com.zcbspay.platform.manager.merchant.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.merchant.dao.EnterpriseDetaDao;
import com.zcbspay.platform.manager.merchant.pojo.PojoEnterpriseDetaApply;

@Repository
public class EnterpriseDetaDaoImpl extends HibernateBaseDAOImpl<PojoEnterpriseDetaApply> implements EnterpriseDetaDao {

	@Override
	public List<?> findById(String selfId) {
		String hql = "select p from PojoEnterpriseDetaApply p where p.selfId=?";
		return queryByHQL(hql,new Object[]{selfId});
	}

}
