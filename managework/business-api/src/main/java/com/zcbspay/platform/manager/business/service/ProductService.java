package com.zcbspay.platform.manager.business.service;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.business.bean.MerchAPIBean;
import com.zcbspay.platform.manager.business.bean.ProductBean;

public interface ProductService {
	public Map<String, Object> findProductByPage(Map<String, Object> variables, int page,int rows) ;
	public List<?> queryBusinessType() ;
	public String AddOneProduct(ProductBean product,List listbusicode);
	public List<?> queryProdCase(String  prdtver) ;
	public String updateProduct(ProductBean product,List listbusicode);
	public Map<String, Object> findCashByPage(Map<String, Object> variables, int page,int rows);
	public List<?> queryChnlType();
	public List<?> queryCaseMark(String  cashver) ;
	public Map<String, Object> queryOneCase(String cashver) ;
	/**
	 * 根据标识符查询产品
	 * @param value
	 * @return
	 */
	public Map<String, Object> findByPrdtver(String value);
	/**
	 * 查询所有产品
	 * @return
	 */
	public List<?> findAll();
	public String saveMerch(MerchAPIBean merchAPIBean);
	public Map<String, Object> queryMerchs(MerchAPIBean merchAPIBean, String page, String rows);
	public String updateMerch(MerchAPIBean merchAPIBean);
	public String changeStatus(MerchAPIBean merchAPIBean);
}
