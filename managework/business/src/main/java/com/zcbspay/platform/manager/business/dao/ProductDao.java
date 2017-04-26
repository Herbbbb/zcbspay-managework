package com.zcbspay.platform.manager.business.dao;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.business.bean.MerchAPIBean;
import com.zcbspay.platform.manager.business.bean.ProductBean;
import com.zcbspay.platform.manager.dao.BaseDAO;

public interface ProductDao extends BaseDAO<ProductBean>{

	/**
	 * 添加一个产品
	 * @param productBean 产品实体类
	 * @param busicodeStr 业务code组成的字符串用"," 逗号隔开
	 * @return
	 */
	public String AddOneProduct(ProductBean productBean,String busicodeStr);
	
	
	/**
	 * 分页查询产品
	 * @param variables
	 * @param page
	 * @param rows
	 * @return
	 */
	public Map<String, Object> findProductByPage(Map<String, Object> variables, int page, int rows);
	
	/**
	 * 查询业务类型
	 * @return
	 */
	public List<?> queryBusinessType();

	/**
	 * 查询一个产品
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List<?> findByProperty(String propertyName, String value);

	/**
	 * 查询业务
	 * @param prdtver
	 * @return
	 */
	public List<?> queryProdCase(String prdtver);

	/**
	 * 更新产品
	 * @param product
	 * @param busicodeStr
	 * @return
	 */
	public String updateProduct(ProductBean product, String busicodeStr);

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
