package com.zcbspay.platform.manager.risk.service;

import java.util.List;
import java.util.Map;

import com.zcbspay.platform.manager.risk.bean.BlacklistMemberBean;
import com.zcbspay.platform.manager.risk.bean.BlacklistPanBean;
import com.zcbspay.platform.manager.risk.bean.LimitCreditSingleBean;
import com.zcbspay.platform.manager.risk.bean.RiskBean;
import com.zcbspay.platform.manager.risk.bean.RiskCaseBean;
import com.zcbspay.platform.manager.risk.bean.WhitePanBean;

/**
 * 
 * @author lianhai
 *
 */
public interface RiskService {
	public Map<String, Object> findRiskByPage(Map<String, Object> variables, int page, int rows);

	public String AddOneRisk(RiskBean risk);

	public Map<String, Object> queryOneRisk(String riskId);

	public String UpdateOneRisk(RiskBean risk);

	public List<?> queryRiskCase(String riskver);

	public List<?> query_risk_list();

	public Map<String, Object> queryOneRiskCase(String v_caseid);

	public List<?> query_risk_list_active(String riskid);

	public String UpdateOneRiskCase(RiskCaseBean riskcase);

	public Map<String, Object> findBlackPanByPage(Map<String, Object> variables, int page, int rows);

	public List<?> query_risk_level();

	public String AddOneBlackPan(BlacklistPanBean blackPan);

	public Map<String, Object> queryOneBlackPan(String tId);

	public String updateOneBlackPan(BlacklistPanBean blackPan);

	public String deleteOneBlackPan(String tid);

	public String startOneBlackPan(String tid);

	public Map<String, Object> findWhitePanByPage(Map<String, Object> variables, int page, int rows);

	public String AddOneWhitePan(WhitePanBean whitePan);

	public Map<String, Object> queryOneWhitePan(String tId);

	public String updateOneWhitePan(WhitePanBean whitePan);

	public String deleteOneWhitePan(String tid);

	public String startOneWhitePan(String tid);

	public List<?> query_risk_all();

	public List<?> query_risk_case_all(String riskver);

	public Map<String, Object> findBlacklistMemberByPage(Map<String, Object> variables, int page, int rows);

	public String AddOneBlacklistMember(BlacklistMemberBean blm);

	public Map<String, Object> queryOneBlacklistMember(String tId);

	public String updateBlacklistMember(BlacklistMemberBean blm);

	public String deleteOneBlacklistMember(String tid, Long userid);

	public String startOneBlacklistMember(String tid, Long userid);

	public Map<String, Object> findlimitCreditSingleByPage(Map<String, Object> variables, int page, int rows);

	public String AddOnelimitCreditSingle(LimitCreditSingleBean limitSingle);

	public String updateOnelimitCreditSingle(LimitCreditSingleBean limitSingle);

	public Map<String, Object> queryOnelimitCreditSingle(String tId);

	public String deleteOnelimitCreditSingle(String tId, Long userid);

	public String startOnelimitCreditSingle(String tId, Long userid);
	/**
	 * 提现风控
	 * 
	 * @param merchId
	 * @param subMerchId
	 * @param memberId
	 * @param busiCode
	 * @param txnAmt
	 * @param cardType
	 * @param cardNo
	 * @throws TradeException
	 */
	// public void tradeRiskControl(String merchId,String subMerchId,String
	// memberId,String busiCode,String txnAmt,String cardType,String cardNo)
	// throws TradeException;

	/**
	 * 提现手续费
	 * 
	 * @param txnsLog
	 * @return
	 */
	// public Long getTxnFee(TxnsLogBean txnsLog);

	/**
	 * 交易明细
	 * 
	 * @param txnseqno
	 * @return
	 */
	// public List<?> getTxnsLogbyId(String txnseqno);
}
