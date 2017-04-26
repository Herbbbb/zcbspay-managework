package com.zcbspay.platform.manager.merchant.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.merchant.bean.BankInfoBean;
import com.zcbspay.platform.manager.merchant.bean.MerchBankAccoutBean;
import com.zcbspay.platform.manager.merchant.dao.BankInfoDao;
import com.zcbspay.platform.manager.merchant.dao.MerchBankAccoutDao;
import com.zcbspay.platform.manager.merchant.pojo.PojoBankInfo;
import com.zcbspay.platform.manager.merchant.pojo.PojoMerchBankAccout;
import com.zcbspay.platform.manager.merchant.service.MerchBankAccoutService;

@Service("merchBankAccoutService")
public class MerchBankAccoutServiceImpl implements MerchBankAccoutService {

	@Autowired
	private MerchBankAccoutDao merchBankAccountDao;
	@Autowired
	private BankInfoDao bankInfoDao;

	@Override
	public List<?> findAllAccout(MerchBankAccoutBean bankAccout, int page, int rows) {
		return merchBankAccountDao.findAllAccout(bankAccout,page,rows);
	}

	@Override
	public boolean addBankAccount(MerchBankAccoutBean bankAccount) {
		
		PojoMerchBankAccout pojo = new PojoMerchBankAccout();
		BeanUtils.copyProperties(bankAccount, pojo );
		try {
			merchBankAccountDao.addBankAccount(pojo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public MerchBankAccoutBean findById(String tId) {
		PojoMerchBankAccout pojo = (PojoMerchBankAccout) merchBankAccountDao.findById(tId).get(0);
		MerchBankAccoutBean bean = new MerchBankAccoutBean();
		BeanUtils.copyProperties(pojo, bean );
		return bean;
	}

	@Override
	public boolean eidtBankAccount(MerchBankAccoutBean bankAccout) {
		
		try {
			merchBankAccountDao.eidtBankAccount(bankAccout);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delect(String tId) {
		try {
			merchBankAccountDao.delect(tId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public BankInfoBean queryBankInfo(String bankNode) {
		List<?> list = bankInfoDao.queryBankInfo(bankNode);
		BankInfoBean bean = new BankInfoBean();
		if(list.size() != 0){
			PojoBankInfo pojo = (PojoBankInfo) list.get(0);
			BeanUtils.copyProperties(pojo, bean);
		}else{
			bean = null;
		}
		return bean;
	}

	@Override
	public Integer findAll(MerchBankAccoutBean bankAccount) {
		return merchBankAccountDao.findAll(bankAccount).size();
	}
}
