package com.zcbspay.platform.manager.trade.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.trade.bean.ChnCollectBatchBean;
import com.zcbspay.platform.manager.trade.bean.ChnCollectSingleLogBean;
import com.zcbspay.platform.manager.trade.bean.ChnPaymentBatchBean;
import com.zcbspay.platform.manager.trade.bean.ChnPaymentSingleLogBean;
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
	@Override
	public Map<String, Object> getChnCollectSingleLogByPage(String page, String rows,
			ChnCollectSingleLogBean chnCollectSingleLogBean) {
		return chnlDetaDao.getChnCollectSingleLogByPage(page, rows, chnCollectSingleLogBean);
	}
	@Override
	public Map<String, Object> getChnPaymentSingleLogByPage(String page, String rows,
			ChnPaymentSingleLogBean chnPaymentSingleLogBean) {
		return chnlDetaDao.getChnPaymentSingleLogByPage(page, rows, chnPaymentSingleLogBean);
	}
	@Override
	public Map<String, Object> getChnCollectBatchLogByPage(String page, String rows,
			ChnCollectBatchBean chnCollectBatchBean) {
		return chnlDetaDao.getChnCollectBatchLogByPage(page, rows, chnCollectBatchBean);
	}
	@Override
	public Map<String, Object> getChnCollectDetaByBatchNo(String page, String rows,
			ChnCollectBatchBean chnCollectBatchBean) {
		return chnlDetaDao.getChnCollectDetaByBatchNo(page, rows, chnCollectBatchBean);
	}
	@Override
	public Map<String, Object> getChnPaymentBatchLogByPage(String page, String rows,
			ChnPaymentBatchBean chnPaymentBatchBean) {
		return chnlDetaDao.getChnPaymentBatchLogByPage(page, rows, chnPaymentBatchBean);
	}
	@Override
	public Map<String, Object> getChnPaymentDetaByBatchNo(String page, String rows,
			ChnPaymentBatchBean chnPaymentBatchBean) {
		return chnlDetaDao.getChnPaymentDetaByBatchNo(page, rows, chnPaymentBatchBean);
	}
}
