package com.zcbspay.platform.manager.risk.service;

import java.util.Map;

import com.zcbspay.platform.manager.risk.bean.BlackIdnumBean;

public interface CardHolderBlackService {

	Map<String, Object> queryCardHolderBlackList(Map<String, Object> variables, int i, int j);

	String AddOneBlackCardHolder(BlackIdnumBean blackIdnumBean);

	Map<String, Object> queryOneBlackCardHolder(String tid);

	String delteOneCardHolderBlack(String tid);

	String startCardHolderBlack(String tid);

	String updateBlackCardHolder(BlackIdnumBean blackIdnumBean);

}
