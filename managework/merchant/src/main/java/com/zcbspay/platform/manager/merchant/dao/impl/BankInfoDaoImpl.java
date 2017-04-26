package com.zcbspay.platform.manager.merchant.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.merchant.dao.BankInfoDao;
import com.zcbspay.platform.manager.merchant.pojo.PojoBankInfo;

@Repository
public class BankInfoDaoImpl extends HibernateBaseDAOImpl<PojoBankInfo> implements BankInfoDao {

	@Override
	public List<?> queryBankInfo(String bankNode) {
		String sql = "select po from PojoBankInfo po where po.bankNode=?";
		return queryByHQL(sql, new Object[]{bankNode});
	}


}
