package com.zcbspay.platform.manager.trade.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.trade.bean.CnapsLogBean;
import com.zcbspay.platform.manager.trade.bean.CollectAndPaymentBean;
import com.zcbspay.platform.manager.trade.bean.OrderInfoBean;
import com.zcbspay.platform.manager.trade.bean.TxnsLogBean;
import com.zcbspay.platform.manager.trade.dao.CnapsLogDao;
import com.zcbspay.platform.manager.trade.dao.CollectBatchDao;
import com.zcbspay.platform.manager.trade.dao.CollectSingleDao;
import com.zcbspay.platform.manager.trade.dao.OrderInfoDao;
import com.zcbspay.platform.manager.trade.dao.PaymentBatchDao;
import com.zcbspay.platform.manager.trade.dao.PaymentSingleDao;
import com.zcbspay.platform.manager.trade.dao.TxnsLogDao;
import com.zcbspay.platform.manager.trade.service.TxnsLogService;
@Service("txnsLogService")
public class TxnsLogServiceImpl implements TxnsLogService{

	@Autowired
	private TxnsLogDao txnsLogDao;
	
	@Autowired
	private OrderInfoDao orderInfoDao;
	
	@Autowired
	private CnapsLogDao canpsLogDao;
	
	@Autowired
	private CollectBatchDao collectBatchDao;
	
	@Autowired
	private PaymentBatchDao paymentBatchDao;
	
	@Autowired
	private PaymentSingleDao paymentSingleDao;
	
	@Autowired
	private CollectSingleDao collectSingleDao;
	
	
	@Override
	public Map<String, Object> getTxnsLogByPage(String page, String rows, TxnsLogBean values) {
		return txnsLogDao.getTxnsLogByPage(page,rows,values);
	}
	@Override
	public List<?> getTxnsLogById(String txnseqno) {
		return txnsLogDao.getTxnsLogById(txnseqno);
	}
	@Override
	public Map<String, Object> getOrderInfoByPage(String page, String rows, OrderInfoBean values) {
		return orderInfoDao.getOrderInfoByPage(page,rows,values);
	}
	@Override
	public List<?> getOrderInfoDetail(String id) {
		return orderInfoDao.getOrderInfoDetail(id);
	}
	@Override
	public Map<String, Object> getCnapsLogByPage(String page, String rows, CnapsLogBean values) {
		return canpsLogDao.getCnapsLogByPage(page,rows,values);
	}
	@Override
	public Map<String, Object> getBepsCollectBatchByPage(String page, String rows, CollectAndPaymentBean collectBatchBean) {
		return collectBatchDao.getBepsCollectBatchByPage(page,rows,collectBatchBean);
	}
	@Override
	public Map<String, Object> queryDetail(String page, String rows, CollectAndPaymentBean collectBatchBean) {
		return collectBatchDao.queryDetail(page,rows,collectBatchBean);
	}
	@Override
	public Map<String, Object> queryPaymentDetail(String page, String rows, CollectAndPaymentBean collectBatchBean) {
		return paymentBatchDao.queryPaymentDetail(page, rows, collectBatchBean);
	}
	@Override
	public Map<String, Object> getBepsPaymentBatchByPage(String page, String rows,
			CollectAndPaymentBean collectBatchBean) {
		return paymentBatchDao.getBepsPaymentBatchByPage(page, rows, collectBatchBean);
	}
	@Override
	public Map<String, Object> getBepsPaymentSingleByPage(String page, String rows,
			CollectAndPaymentBean collectBatchBean) {
		return paymentSingleDao.getBepsPaymentSingleByPage(page, rows, collectBatchBean);
	}
	@Override
	public Map<String, Object> getBepsCollectSingleByPage(String page, String rows,
			CollectAndPaymentBean collectBatchBean) {
		return collectSingleDao.getBepsCollectSingleByPage(page, rows, collectBatchBean);
	}
	
}
