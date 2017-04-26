package com.zcbspay.platform.manager.merchant.service;

import java.util.List;

import com.zcbspay.platform.manager.merchant.bean.ProductBean;

public interface PojoProductService {

	/**
     * 合作机构相关产品
     * @return
     */
	List<ProductBean> queryProduct(long coopInstiId);
}
