package com.zcbspay.platform.manager.merchant.service;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.merchant.bean.BankInfoBean;
import com.zcbspay.platform.manager.merchant.bean.MerchBankAccoutBean;
import com.zcbspay.platform.manager.merchant.bean.MerchTaxInvoiceBean;

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

	/**
	 * 查询所有发票信息
	 * @param metchTax
	 * @param page
	 * @param rows
	 * @return
	 */
	List<?> findTaxAll(MerchTaxInvoiceBean metchTax, int page, int rows);

	/**
	 * 查询发票信息总数
	 * @param metchTax
	 * @return
	 */
	Integer findTaxAllCount(MerchTaxInvoiceBean metchTax);

	/**
	 * 新增发票信息
	 * @param metchTax
	 * @return
	 */
	Map<String, Object> addTax(MerchTaxInvoiceBean metchTax);

	/**
	 * 查询发票信息
	 * @param tId
	 * @return
	 */
	MerchTaxInvoiceBean findTaxById(String tId);

	/**
	 * 修改发票信息
	 * @param metchTax
	 * @return
	 */
	Map<String, Object> eidtTax(MerchTaxInvoiceBean metchTax);

	/**
	 * 注销发票信息
	 * @param tId
	 * @return
	 */
	Map<String, Object> delectTax(String tId);
}
