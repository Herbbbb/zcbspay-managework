package com.zcbspay.platform.manager.merchant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.merchant.bean.FtpBean;
import com.zcbspay.platform.manager.merchant.dao.FtpDao;
import com.zcbspay.platform.manager.merchant.pojo.PojoFtp;
import com.zcbspay.platform.manager.merchant.service.FtpService;

@Service("ftpService")
public class FtpServiceImpl implements FtpService{

	@Autowired
	private FtpDao ftpDAO;
	
	@Override
	public FtpBean query() {
		FtpBean bean = new FtpBean();
		PojoFtp pojo = (PojoFtp) ftpDAO.query().get(0);
		bean.setIp(pojo.getIp());
		bean.setUsers(pojo.getUsers());
		bean.setPort(pojo.getPort());
		bean.setPwd(pojo.getPwd());
		return bean;
	}

}
