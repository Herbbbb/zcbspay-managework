package com.zcbspay.platform.manager.risk.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.risk.bean.BlacklistMemberBean;
import com.zcbspay.platform.manager.risk.bean.BlacklistPanBean;
import com.zcbspay.platform.manager.risk.bean.LimitCreditSingleBean;
import com.zcbspay.platform.manager.risk.bean.RiskBean;
import com.zcbspay.platform.manager.risk.bean.RiskCaseBean;
import com.zcbspay.platform.manager.risk.bean.WhitePanBean;
import com.zcbspay.platform.manager.risk.dao.RiskDAO;
import com.zcbspay.platform.manager.risk.service.RiskService;


@Service("riskService")
public class RiskServiceImpl implements  RiskService{
	@Autowired
	private RiskDAO riskDAO;
	
	@Override
	public Map<String, Object> findRiskByPage(Map<String, Object> variables, int page, int rows) {
		return riskDAO.findRiskByPage(variables, page, rows);
	}

	@Override
	public String AddOneRisk(RiskBean risk) {
		return riskDAO.AddOneRisk(risk);
	}

	@Override
	public Map<String, Object> queryOneRisk(String riskId) {
		return riskDAO.queryOneRisk(riskId);
	}

	@Override
	public String UpdateOneRisk(RiskBean risk) {
		return riskDAO.UpdateOneRisk(risk);
	}

	@Override
	public List<?> queryRiskCase(String riskver) {
		return riskDAO.queryRiskCase(riskver);
	}

	@Override
	public List<?> query_risk_list() {
		return riskDAO.query_risk_list();
	}

	@Override
	public Map<String, Object> queryOneRiskCase(String v_caseid) {
		return riskDAO.queryOneRiskCase(v_caseid);
	}

	@Override
	public List<?> query_risk_list_active(String riskid) {
		return riskDAO.query_risk_list_active(riskid);
	}

	@Override
	public String UpdateOneRiskCase(RiskCaseBean riskcase) {
		return riskDAO.UpdateOneRiskCase(riskcase);
	}

	@Override
	public Map<String, Object> findBlackPanByPage(Map<String, Object> variables, int page, int rows) {
		return riskDAO.findBlackPanByPage(variables, page, rows);
	}

	@Override
	public List<?> query_risk_level() {
		return riskDAO.query_risk_level();
	}

	@Override
	public String AddOneBlackPan(BlacklistPanBean blackPan) {
		return riskDAO.AddOneBlackPan(blackPan);
	}

	@Override
	public Map<String, Object> queryOneBlackPan(String tId) {
		return riskDAO.queryOneBlackPan(tId);
	}

	@Override
	public String updateOneBlackPan(BlacklistPanBean blackPan) {
		return riskDAO.updateOneBlackPan(blackPan);
	}

	@Override
	public String deleteOneBlackPan(String tid) {
		return riskDAO.deleteOneBlackPan(tid);
	}

	@Override
	public String startOneBlackPan(String tid) {
		return riskDAO.startOneBlackPan(tid);
	}

	@Override
	public Map<String, Object> findWhitePanByPage(Map<String, Object> variables, int page, int rows) {
		return riskDAO.findWhitePanByPage(variables, page, rows);
	}

	@Override
	public String AddOneWhitePan(WhitePanBean whitePan) {
		return riskDAO.AddOneWhitePan(whitePan);
	}

	@Override
	public Map<String, Object> queryOneWhitePan(String tId) {
		return riskDAO.queryOneWhitePan(tId);
	}

	@Override
	public String updateOneWhitePan(WhitePanBean whitePan) {
		return riskDAO.updateOneWhitePan(whitePan);
	}

	@Override
	public String deleteOneWhitePan(String tid) {
		return riskDAO.deleteOneWhitePan(tid);
	}

	@Override
	public String startOneWhitePan(String tid) {
		return riskDAO.startOneWhitePan(tid);
	}

	@Override
	public List<?> query_risk_all() {
		return riskDAO.query_risk_all();
	}

	@Override
	public List<?> query_risk_case_all(String riskver) {
		return riskDAO.query_risk_case_all(riskver);
	}

	@Override
	public Map<String, Object> findBlacklistMemberByPage(Map<String, Object> variables, int page, int rows) {
		return riskDAO.findBlacklistMemberByPage(variables, page, rows);
	}

	@Override
	public String AddOneBlacklistMember(BlacklistMemberBean blm) {
		return riskDAO.AddOneBlacklistMember(blm);
	}

	@Override
	public Map<String, Object> queryOneBlacklistMember(String tId) {
		return riskDAO.queryOneBlacklistMember(tId);
	}

	@Override
	public String updateBlacklistMember(BlacklistMemberBean blm) {
		return riskDAO.updateBlacklistMember(blm);
	}

	@Override
	public String deleteOneBlacklistMember(String tid, Long userid) {
		return riskDAO.deleteOneBlacklistMember(tid, userid);
	}

	@Override
	public String startOneBlacklistMember(String tid, Long userid) {
		return riskDAO.startOneBlacklistMember(tid, userid);
	}

	@Override
	public Map<String, Object> findlimitCreditSingleByPage(Map<String, Object> variables, int page, int rows) {
		return riskDAO.findlimitCreditSingleByPage(variables, page, rows);
	}

	@Override
	public String AddOnelimitCreditSingle(LimitCreditSingleBean limitSingle) {
		return riskDAO.AddOnelimitCreditSingle(limitSingle);
	}

	@Override
	public String updateOnelimitCreditSingle(LimitCreditSingleBean limitSingle) {
		return riskDAO.updateOnelimitCreditSingle(limitSingle);
	}

	@Override
	public Map<String, Object> queryOnelimitCreditSingle(String tId) {
		return riskDAO.queryOnelimitCreditSingle(tId);
	}

	@Override
	public String deleteOnelimitCreditSingle(String tId, Long userid) {
		return riskDAO.deleteOnelimitCreditSingle(tId, userid);
	}

	@Override
	public String startOnelimitCreditSingle(String tId, Long userid) {
		return riskDAO.startOnelimitCreditSingle(tId, userid);
	}
	

}
