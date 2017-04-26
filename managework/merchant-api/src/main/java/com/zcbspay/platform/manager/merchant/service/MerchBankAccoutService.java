package com.zcbspay.platform.manager.merchant.service;

import java.util.List;

import com.zcbspay.platform.manager.merchant.bean.BankInfoBean;
import com.zcbspay.platform.manager.merchant.bean.MerchBankAccoutBean;

public interface MerchBankAccoutService {

	/**
	 * 查询所有银行账户
	 * @param bankAccout
	 * @param page
	 * @param rows
	 * @return
	 */
	List<?> findAllAccout(MerchBankAccoutBean bankAccout, int page, int rows);

	/**
	 * 新增银行账户
	 * @param bankAccout
	 * @return
	 */
	boolean addBankAccount(MerchBankAccoutBean bankAccout);

	/**
	 * 查询详情
	 * @param tId
	 * @return
	 */
	MerchBankAccoutBean findById(String tId);

	/**
	 * 修改银行账户
	 * @param bankAccout
	 * @return
	 */
	boolean eidtBankAccount(MerchBankAccoutBean bankAccout);

	/**
	 * 注销用户
	 * @param bankAccout
	 * @return
	 */
	boolean delect(String tId);

	/**
	 * 获取银行信息
	 * @param bankNode
	 * @return
	 */
	BankInfoBean queryBankInfo(String bankNode);

	/**
	 * 查询总数
	 * @return
	 */
	Integer findAll(MerchBankAccoutBean bankAccount);
}
