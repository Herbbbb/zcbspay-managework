package com.zcbspay.platform.manager.merchant.dao;

import java.util.List;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.merchant.pojo.PojoFtp;

public interface FtpDao extends BaseDAO<PojoFtp> {

	/**
	 * 查询Ftp配置信息
	 * @return
	 */
	List<?> query();

}
