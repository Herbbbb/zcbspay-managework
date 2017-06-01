package com.zcbspay.platform.manager.merchant.service;

import com.zcbspay.platform.manager.merchant.bean.FtpBean;

/**
 * FTP管理
 * @author guojia
 *
 */
public interface FtpService {

	
	/**
	 * 查询FTP配置信息
	 * @return
	 */
	public FtpBean query();
}
