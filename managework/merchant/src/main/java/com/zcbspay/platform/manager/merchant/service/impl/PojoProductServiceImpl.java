package com.zcbspay.platform.manager.merchant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.merchant.bean.ProductBean;
import com.zcbspay.platform.manager.merchant.dao.ProductDao;
import com.zcbspay.platform.manager.merchant.service.PojoProductService;

@Service("pojoProductService")
@SuppressWarnings("all")
public class PojoProductServiceImpl implements PojoProductService {

	@Autowired
	private ProductDao productDao;
	@Override
	public List<ProductBean> queryProduct(long coopInstiId) {
		return (List<ProductBean>) productDao.queryProduct(coopInstiId);
	}

}
