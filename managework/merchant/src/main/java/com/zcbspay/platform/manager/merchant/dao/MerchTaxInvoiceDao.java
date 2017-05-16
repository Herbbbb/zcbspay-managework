package com.zcbspay.platform.manager.merchant.dao;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.exception.ContractException;
import com.zcbspay.platform.manager.merchant.bean.MerchTaxInvoiceBean;
import com.zcbspay.platform.manager.merchant.pojo.PojoMerchTaxInvoice;

public interface MerchTaxInvoiceDao extends BaseDAO<PojoMerchTaxInvoice> {

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
	List<?> findTaxAllCount(MerchTaxInvoiceBean metchTax);

	/**
	 * 新增发票信息
	 * @param metchTax
	 * @return
	 */
	Map<String, Object> addTax(PojoMerchTaxInvoice metchTax) throws ContractException;
	
	/**
	 * 验证信息是否存在
	 * @param metchTax
	 * @return
	 */
	boolean queryTax(PojoMerchTaxInvoice metchTax);

	/**
	 * 查询发票信息
	 * @param tId
	 * @return
	 */
	List<?> findTaxById(String tId);

	/**
	 * 修改发票信息
	 * @param pojo
	 * @return
	 * @throws ContractException
	 */
	Map<String, Object> eidtTax(PojoMerchTaxInvoice pojo) throws ContractException;

	/**
	 * 注销发票信息
	 * @param tId
	 * @return
	 */
	Map<String, Object> delectTax(String tId) throws ContractException;
	

}
