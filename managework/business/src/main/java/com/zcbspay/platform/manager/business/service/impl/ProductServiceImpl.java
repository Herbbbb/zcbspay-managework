package com.zcbspay.platform.manager.business.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.business.bean.MerchAPIBean;
import com.zcbspay.platform.manager.business.bean.ProductBean;
import com.zcbspay.platform.manager.business.dao.ProductDao;
import com.zcbspay.platform.manager.business.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	// 添加一个产品
	@Override
	public String AddOneProduct(ProductBean product, @SuppressWarnings("rawtypes") List listbusicode) {
		String busicodeStr = "";
		if (product == null) {
			return "产品不能为空";
		}
		if (listbusicode != null && listbusicode.size() > 0) {
			for (int i = 0; i < listbusicode.size(); i++) {
				busicodeStr = busicodeStr + listbusicode.get(i).toString() + ",";
			}
		}
		return productDao.AddOneProduct(product, busicodeStr);
	}

	@Override
	public Map<String, Object> findProductByPage(Map<String, Object> variables, int page, int rows) {
		return productDao.findProductByPage(variables, page, rows);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> findByPrdtver(String value) {
		List<?> pList = productDao.findByProperty("PRDTVER", value);
		Map<String, Object> result = new HashMap<>();
		Map<String, Object> re = new HashMap<>();
		if (pList != null && pList.size() > 0) {
			result = (Map<String, Object>) pList.get(0);
			re.put("prdtver", result.get("PRDTVER"));
			re.put("prdtname", result.get("PRDTNAME"));
			re.put("notes", result.get("NOTES"));
		}
		return re;
	}

	@Override
	public List<?> queryBusinessType() {
		return productDao.queryBusinessType();
	}

	@Override
	public List<?> queryProdCase(String prdtver) {
		return productDao.queryProdCase(prdtver);
	}
	@Override
	public String updateProduct(ProductBean product, @SuppressWarnings("rawtypes") List listbusicode) {
		String busicodeStr = "";
		if (product == null) {
			return "产品不能为空";
		}
		if (listbusicode != null && listbusicode.size() > 0) {
			for (int i = 0; i < listbusicode.size(); i++) {
				busicodeStr = busicodeStr + listbusicode.get(i).toString() + ",";
			}
		}
		return productDao.updateProduct(product,busicodeStr);
	}

	@Override
	public Map<String, Object> findCashByPage(Map<String, Object> variables, int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> queryChnlType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> queryCaseMark(String cashver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> queryOneCase(String cashver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> findAll() {
		return productDao.findAll();
	}

	@Override
	public String saveMerch(MerchAPIBean merchAPIBean) {
		return productDao.saveMerch(merchAPIBean);
	}

	@Override
	public Map<String, Object> queryMerchs(MerchAPIBean merchAPIBean, String page, String rows) {
		return productDao.queryMerchs(merchAPIBean,page,rows);
	}

	@Override
	public String updateMerch(MerchAPIBean merchAPIBean) {
		return productDao.updateMerch(merchAPIBean);
	}

	@Override
	public String changeStatus(MerchAPIBean merchAPIBean) {
		return productDao.changeStatus(merchAPIBean);
	}

}
