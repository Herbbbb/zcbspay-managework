package com.zcbspay.platform.manager.merchant.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.merchant.bean.MerchBankAccoutBean;
import com.zcbspay.platform.manager.merchant.dao.MerchBankAccoutDao;
import com.zcbspay.platform.manager.merchant.pojo.PojoMerchBankAccout;

@Repository
@SuppressWarnings("all")
public class MerchBankAccoutDaoImpl extends HibernateBaseDAOImpl<PojoMerchBankAccout> implements MerchBankAccoutDao {

	@Override
	public List<?> findAllAccout(MerchBankAccoutBean bankAccount, int page, int rows) {
		int count = page * rows;
		int num = page - 1;
		int num2 = num * rows;
		String sql = "select * from ( select  t.*, rownum RN from T_MERCH_BANK_ACCOUNT t where MERCHNO like ? and ACCOUNTNO like ? and ACCOUNTNAME like ? ) where RN between ? and ?";
		Object[] paramaters = new Object[] {
				bankAccount.getMerchNo() == null ? "%%" : "%"+bankAccount.getMerchNo()+"%",
				bankAccount.getAccoutNo() == null  ? "%%" : "%"+bankAccount.getAccoutNo()+"%",
				bankAccount.getAccoutName() == null  ? "%%" : "%"+bankAccount.getAccoutName()+"%",
				num2,count	};
		return queryBySQL(sql, paramaters);
	}

	@Override
	public void addBankAccount(PojoMerchBankAccout bankAccount) {
		saveEntity(bankAccount);
	}

	@Override
	public List<?> findById(String tId) {
		String sql = "select po from PojoMerchBankAccout po where po.tId=?";
		return queryByHQL(sql, new Object[]{Long.parseLong(tId)});
	}

	@Override
	public void eidtBankAccount(MerchBankAccoutBean bankAccount) {
		String sql = "update T_MERCH_BANK_ACCOUNT set MERCHNO=?,BANKNODE=?,BANKCODE=?,ACCOUNTNO=?,ACCOUNTNAME=?,PROTOCOLTYPE=?,BANKPROVINCE=?,"
				+ "BANKCITY=?,CHANNELCODE=?,STATUS=?,NOTES=? WHERE TID=?";
		Object[] paramaters = new Object[] {
				"".equals(bankAccount.getMerchNo()) ? null : bankAccount.getMerchNo(),
				"".equals(bankAccount.getBankNode()) ? null : bankAccount.getBankNode(),
				"".equals(bankAccount.getBankCode()) ? null : bankAccount.getBankCode(),
				"".equals(bankAccount.getAccoutNo()) ? null : bankAccount.getAccoutNo(),
				"".equals(bankAccount.getAccoutName()) ? null : bankAccount.getAccoutName(),
				"".equals(bankAccount.getProtocoltype()) ? null : bankAccount.getProtocoltype(),
				"".equals(bankAccount.getBankProvince()) ? null : bankAccount.getBankProvince(),
				"".equals(bankAccount.getBankCity()) ? null : bankAccount.getBankCity(),
				"".equals(bankAccount.getChannelCode()) ? null : bankAccount.getChannelCode(),
				"".equals(bankAccount.getStatus()) ? null : bankAccount.getStatus(),
				"".equals(bankAccount.getNotes()) ? null : bankAccount.getNotes(),
				"".equals(bankAccount.gettId()) ? null : bankAccount.gettId()};
				
		updateBySQL(sql, paramaters);
	}

	@Override
	public void delect(String tId) {
		String sql = "update PojoMerchBankAccout po set po.status='00' where po.tId=?";
		updateByHQL(sql, new Object[]{Long.parseLong(tId)});
		
	}

	@Override
	public List<?> findAll(MerchBankAccoutBean bankAccount) {
		String sql = "select  t.*, rownum RN from T_MERCH_BANK_ACCOUNT t where MERCHNO like ? and ACCOUNTNO like ? and ACCOUNTNAME like ? ";
		Object[] paramaters = new Object[] {
				bankAccount.getMerchNo() == null ? "%%" : "%"+bankAccount.getMerchNo()+"%",
				bankAccount.getAccoutNo() == null ? "%%" : "%"+bankAccount.getAccoutNo()+"%",
				bankAccount.getAccoutName() == null ? "%%" : "%"+bankAccount.getAccoutName()+"%"};
		return queryBySQL(sql, paramaters);
	}
}
