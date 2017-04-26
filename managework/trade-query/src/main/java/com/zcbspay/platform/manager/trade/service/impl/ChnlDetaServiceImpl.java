package com.zcbspay.platform.manager.trade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.trade.dao.ChnlDetaDao;
import com.zcbspay.platform.manager.trade.service.ChnlDetaService;
@Service("chnlDetaService")
public class ChnlDetaServiceImpl implements ChnlDetaService{

	@Autowired
	private ChnlDetaDao chnlDetaDao;
	@Override
	public List<?> getAllChannelCodeList() {
		return chnlDetaDao.getAllChannelCodeList();
	}
}
