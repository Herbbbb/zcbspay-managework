package com.zcbspay.platform.manager.merchant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.merchant.dao.ParaDicDao;
import com.zcbspay.platform.manager.merchant.service.ProdCaseService;

@Service("prodCaseService")
public class ProdCaseServiceImpl implements ProdCaseService {

	@Autowired
	private ParaDicDao paraDicDao;
	@Override
	public List<?> findParaDic() {
		return paraDicDao.findParaDic();
	}
	@Override
	public List<?> findParaById(String busiCode) {
		return paraDicDao.findParaById(busiCode);
	}

}
