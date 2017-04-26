package com.zcbspay.platform.manager.trade.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.trade.dao.ChnlDetaDao;

@Repository
public class ChnlDetaDaoImpl extends HibernateBaseDAOImpl<String> implements ChnlDetaDao {

	@Override
	public List<?> getAllChannelCodeList() {
		String sql = "select * from T_CHNL_DETA where STATUS='00'";
		return queryBySQL(sql, null);
	}



}
