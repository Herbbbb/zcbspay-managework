package com.zcbspay.platform.manager.merchant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.merchant.dao.MccListDAO;
import com.zcbspay.platform.manager.merchant.service.MccListService;

@Service("mccListService")
@SuppressWarnings("all")
public class MccListServiceImpl implements MccListService {

	@Autowired
	private MccListDAO mccListDao;
	@Override
	public List<?> findAll() {
		return mccListDao.findAll();
	}

}
