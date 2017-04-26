package com.zcbspay.platform.manager.merchant.dao;

import java.util.List;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.merchant.pojo.PojoEnterpriseDetaApply;

public interface EnterpriseDetaDao extends BaseDAO<PojoEnterpriseDetaApply> {

	List<?> findById(String selfId);

}
