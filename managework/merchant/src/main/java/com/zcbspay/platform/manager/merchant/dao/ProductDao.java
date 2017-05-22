package com.zcbspay.platform.manager.merchant.dao;

import java.util.List;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.merchant.bean.ProductBean;

public interface ProductDao extends BaseDAO<ProductBean>{

	/**
     * 合作机构相关产品
     * @return
     */
	List<?> queryProduct();
}
