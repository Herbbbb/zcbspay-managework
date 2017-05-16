package com.zcbspay.platform.manager.merchant.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.exception.ContractException;
import com.zcbspay.platform.manager.merchant.bean.MerchTaxInvoiceBean;
import com.zcbspay.platform.manager.merchant.dao.MerchTaxInvoiceDao;
import com.zcbspay.platform.manager.merchant.pojo.PojoMerchTaxInvoice;

@Repository
public class MerchTaxInvoiceDaoImpl extends HibernateBaseDAOImpl<PojoMerchTaxInvoice> implements MerchTaxInvoiceDao {

	@Override
	public List<?> findTaxAll(MerchTaxInvoiceBean metchTax, int page, int rows) {
		int count = page * rows;
		int num = page - 1;
		int num2 = num * rows;
		String sql = "select * from ( select  t.*, rownum RN from T_MERCH_TAX_INVOICE t where t.MERCHNO like ? "
				+ "and t.COMPANYNAME like ? and t.TAXPAYERID like ?  and t.ACCOUNTNO like ?) where RN between ? and ?";
		Object[] paramaters = new Object[] {
				metchTax.getMerchNo() == null ? "%%" : "%"+ metchTax.getMerchNo()+"%",
				metchTax.getCompanyName() == null  ? "%%" : "%"+ metchTax.getCompanyName()+"%",
				metchTax.getTaxPayerId() == null  ? "%%" : "%"+ metchTax.getTaxPayerId()+"%",
				metchTax.getAccountNo() == null  ? "%%" : "%"+ metchTax.getAccountNo()+"%",
				num2,count	};
		return queryBySQL(sql, paramaters);
	}

	@Override
	public List<?> findTaxAllCount(MerchTaxInvoiceBean metchTax) {
		String sql = "select  t.*, rownum RN from T_MERCH_TAX_INVOICE t where t.MERCHNO like ? "
				+ "and t.COMPANYNAME like ? and t.TAXPAYERID like ?  and t.ACCOUNTNO like ?";
		Object[] paramaters = new Object[] {
				metchTax.getMerchNo() == null ? "%%" : "%"+ metchTax.getMerchNo()+"%",
				metchTax.getCompanyName() == null  ? "%%" : "%"+ metchTax.getCompanyName()+"%",
				metchTax.getTaxPayerId() == null  ? "%%" : "%"+ metchTax.getTaxPayerId()+"%",
				metchTax.getAccountNo() == null  ? "%%" : "%"+ metchTax.getAccountNo()+"%"};
		return queryBySQL(sql, paramaters);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public Map<String, Object> addTax(PojoMerchTaxInvoice metchTax) throws ContractException {
		Map<String, Object> map = new HashMap<String, Object>();
		saveEntity(metchTax);
		if(!queryTax(metchTax)){
			String info = "添加失败!";
			map.put("RET", "error");
			map.put("INFO", info);
			throw new ContractException(info);
		}else{
			map.put("RET", "succ");
			map.put("INFO", "添加成功");
		}
		return map;
	}
	
	@Override
	public boolean queryTax(PojoMerchTaxInvoice metchTax) {
		String sql = "select t from PojoMerchTaxInvoice t where t.merchNo=? and t.companyName=? and t.taxPayerId=? and t.accountNo=?";
		int size = queryByHQL(sql, new Object[]{metchTax.getMerchNo(),metchTax.getCompanyName(),metchTax.getTaxPayerId(),metchTax.getAccountNo()}).size();
		if(size == 1){
			return true;
		}
		return false;
	}

	@Override
	public List<?> findTaxById(String tId) {
		String sql = "select t from PojoMerchTaxInvoice t where t.tId=?";
		return queryByHQL(sql, new Object[]{Long.parseLong(tId)});
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public Map<String, Object> eidtTax(PojoMerchTaxInvoice pojo) throws ContractException {
		Map<String, Object> map = new HashMap<String, Object>();
		PojoMerchTaxInvoice bean = update(pojo);
		if(bean == null){
			String info = "修改失败!";
			map.put("RET", "error");
			map.put("INFO", info);
			throw new ContractException(info);
		}else{
			map.put("RET", "succ");
			map.put("INFO", "修改成功");
		}
		return map;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public Map<String, Object> delectTax(String tId) throws ContractException {
		Map<String, Object> map = new HashMap<String, Object>();
		PojoMerchTaxInvoice pojo = (PojoMerchTaxInvoice) findTaxById(tId).get(0);
		pojo.setStatus("99");
		PojoMerchTaxInvoice bean = update(pojo);
		if(bean.getStatus() == "00"){
			String info = "注销失败!";
			map.put("RET", "error");
			map.put("INFO", info);
			throw new ContractException(info);
		}else{
			map.put("RET", "succ");
			map.put("INFO", "注销成功");
		}
		return map;
	}


	
}
