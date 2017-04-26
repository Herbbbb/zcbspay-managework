package com.zcbspay.platform.manager.merchant.dao;

import java.util.List;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.merchant.bean.MerchBankAccoutBean;
import com.zcbspay.platform.manager.merchant.pojo.PojoMerchBankAccout;

public interface MerchBankAccoutDao extends BaseDAO<PojoMerchBankAccout> {

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
	void addBankAccount(PojoMerchBankAccout bankAccount);

	/**
	 * 查询详情
	 * @param tId
	 * @return
	 */
	List<?> findById(String tId);

	/**
	 * 修改
	 * @param bankAccout
	 * @return
	 */
	void eidtBankAccount(MerchBankAccoutBean bankAccout);

	/**
	 * 注销
	 * @param bankAccout
	 */
	void delect(String tId);

	/**
	 * 查询总数
	 * @return
	 */
	List<?> findAll(MerchBankAccoutBean bankAccount);


}
