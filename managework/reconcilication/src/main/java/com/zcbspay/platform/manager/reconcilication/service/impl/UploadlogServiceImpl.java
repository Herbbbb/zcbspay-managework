package com.zcbspay.platform.manager.reconcilication.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zcbspay.platform.manager.reconcilication.bean.ChnTxnBean;
import com.zcbspay.platform.manager.reconcilication.dao.UploadlogDao;
import com.zcbspay.platform.manager.reconcilication.exception.BatchInsException;
import com.zcbspay.platform.manager.reconcilication.service.UploadlogService;
@Service("uploadlogService")
public class UploadlogServiceImpl implements UploadlogService{

	@Autowired
	private UploadlogDao uploadlogDao;
	
	
	
	@Override
	public Map<String, Object> findProcessByPage(Map<String, Object> variables, String page, String rows) {
		return uploadlogDao.findProcessByPage(variables, page,rows);
	}

	@Override
	public List<?> saveProcess(String instiid) {
		return uploadlogDao.saveProcess(instiid);
	}

	@Override
	public List<?> startCheckFile(String filestartid) {
		return uploadlogDao.startCheckFile(filestartid);
	}

	@Override
	public Map<String, Object> queryFail(Map<String, Object> variables, String page, String rows) {
		return uploadlogDao.queryFail(variables,page,rows);
	}

	@Override
	public Map<String, Object> querySuccess(Map<String, Object> variables, String page, String rows) {
		return uploadlogDao.querySuccess(variables,page,rows);
	}

	@Override
	@Transactional
	public String importBatch(List<ChnTxnBean> list) {
		try {
			return (String) uploadlogDao.importBatch(list);
		} catch (BatchInsException e) {
			e.printStackTrace();
			return e.getMessage();
		}
		
		
	}

	
}
