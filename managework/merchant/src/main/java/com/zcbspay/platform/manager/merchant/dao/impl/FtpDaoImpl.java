package com.zcbspay.platform.manager.merchant.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.merchant.dao.FtpDao;
import com.zcbspay.platform.manager.merchant.pojo.PojoFtp;

@Repository
public class FtpDaoImpl extends HibernateBaseDAOImpl<PojoFtp> implements FtpDao {

	@Override
	public List<?> query() {
		String sql = "select u from PojoFtp u ";
		return queryByHQL(sql, null);
	}
}
