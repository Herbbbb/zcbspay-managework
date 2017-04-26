package com.zcbspay.platform.manager.risk.dao;

import java.util.Map;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.risk.bean.BlackIdnumBean;
import com.zcbspay.platform.manager.risk.pojo.PojoBlackIdnum;

public interface CardHolderBlackDAO extends BaseDAO<PojoBlackIdnum> {
	Map<String, Object> queryCardHolderBlackList(Map<String, Object> variables, int i, int j);

	String AddOneBlackCardHolder(BlackIdnumBean blackIdnumModel);

	Map<String, Object> queryOneBlackCardHolder(String tid);

	String delteOneCardHolderBlack(String tid);

	String startCardHolderBlack(String tid);

	String updateBlackCardHolder(BlackIdnumBean blackIdnumModel);
}
