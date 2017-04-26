package com.zcbspay.platform.manager.merchant.dao;

import java.util.List;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.merchant.bean.CoopInstiBean;

public interface CoopInstiDao extends BaseDAO<CoopInstiBean> {

	List<?> findAll();

}
