package com.zcbspay.platform.manager.risk.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.risk.bean.BlackIdnumBean;
import com.zcbspay.platform.manager.risk.dao.CardHolderBlackDAO;
import com.zcbspay.platform.manager.risk.service.CardHolderBlackService;

/**
 * 持卡人黑名单service
 * 
 * @author lianhai
 *
 */
@Service("cardHolderBlackService")
public class CardHolderBlackServiceImpl implements CardHolderBlackService {
	@Autowired
	private CardHolderBlackDAO cardHolderBlackDAO;
	@Override
	public Map<String, Object> queryCardHolderBlackList(Map<String, Object> variables, int page, int rows) {
		return cardHolderBlackDAO.queryCardHolderBlackList(variables, page, rows);
	}

	@Override
	public String AddOneBlackCardHolder(BlackIdnumBean blackIdnumBean) {
		return cardHolderBlackDAO.AddOneBlackCardHolder(blackIdnumBean);
	}

	@Override
	public Map<String, Object> queryOneBlackCardHolder(String tid) {
		return cardHolderBlackDAO.queryOneBlackCardHolder(tid);
	}

	@Override
	public String delteOneCardHolderBlack(String tid) {
		return cardHolderBlackDAO.delteOneCardHolderBlack(tid);
	}

	@Override
	public String startCardHolderBlack(String tid) {
		return cardHolderBlackDAO.startCardHolderBlack(tid);
	}

	@Override
	public String updateBlackCardHolder(BlackIdnumBean blackIdnumBean) {
		return cardHolderBlackDAO.updateBlackCardHolder(blackIdnumBean);
	}

}
