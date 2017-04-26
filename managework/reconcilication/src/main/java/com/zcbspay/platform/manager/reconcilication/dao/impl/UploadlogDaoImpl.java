package com.zcbspay.platform.manager.reconcilication.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.reconcilication.bean.ChannelFileBean;
import com.zcbspay.platform.manager.reconcilication.bean.ChnTxnBean;
import com.zcbspay.platform.manager.reconcilication.dao.UploadlogDao;

@Repository
public class UploadlogDaoImpl extends HibernateBaseDAOImpl<ChannelFileBean> implements UploadlogDao {

	@Override
	public Map<String, Object> findProcessByPage(Map<String, Object> variables, String page, String rows) {
		String[] columns = new String[] { "v_stime", "v_etime", "i_no", "i_perno" };
		Object[] paramaters = new Object[4];
		paramaters[0] = variables.containsKey("startDate") ? variables.get("startDate") : null;
		paramaters[1] = variables.containsKey("endDate") ? variables.get("endDate") : null;
		paramaters[2] = page;
		paramaters[3] = rows;
		return executePageOracleProcedure("{CALL PCK_T_SETT_PROCESS.sel_t_sett_process(?,?,?,?,?,?)}", columns,
				paramaters, "cursor0", "v_total");
	}

	@Override
	public List<?> saveProcess(String instiid) {
		String[] columns = new String[] {"v_instiid","v_stage","v_speed","v_status"}; 
		Object[] paramaters = new Object[]{instiid,"11","0","00"};
		return executeOracleProcedure(
				"{CALL  PCK_T_SETT_PROCESS.ins_t_sett_process(?,?,?,?,?)}",columns,
				paramaters, "cursor0");
	}

	@Override
	public List<?> startCheckFile(String filestartid) {
		String[] columns = new String[] {"v_tid"}; 
		Object[] paramaters = new Object[]{filestartid};
		return executeOracleProcedure(
				"{CALL  CHECK_BILL.checkbill(?,?)}",columns,
				paramaters, "cursor0");
	}

	@Override
	public Map<String, Object> queryFail(Map<String, Object> variables, String page, String rows) {
		String[] columns = new String[]{"v_proid","v_stime","v_etime","v_user","i_no","i_perno"};
        Object[] paramaters = new Object[6];
        paramaters[0] = variables.containsKey("proid")?variables.get("proid"):null;
        paramaters[1] = variables.containsKey("stime")?variables.get("stime"):null;
        paramaters[2] = variables.containsKey("etime")?variables.get("etime"):null;
        paramaters[3] = variables.containsKey("user")?variables.get("user"):null;
        paramaters[4] = page;
        paramaters[5] = rows;
        return executePageOracleProcedure("{CALL PCK_SEL_checkfile_succ.sel_mistake(?,?,?,?,?,?,?,?)}",
                columns, paramaters, "cursor0", "v_total");
	}

	@Override
	public Map<String, Object> querySuccess(Map<String, Object> variables, String page, String rows) {
		String[] columns = new String[]{"v_proid","v_stime","v_etime","v_user","i_no","i_perno"};
        Object[] paramaters = new Object[6];
        paramaters[0] = variables.containsKey("proid")?variables.get("proid"):null;
        paramaters[1] = variables.containsKey("stime")?variables.get("stime"):null;
        paramaters[2] = variables.containsKey("etime")?variables.get("etime"):null;
        paramaters[3] = variables.containsKey("user")?variables.get("user"):null;
        paramaters[4] = page;
        paramaters[5] = rows;
        return executePageOracleProcedure("{CALL PCK_SEL_checkfile_succ.sel_succ(?,?,?,?,?,?,?,?)}",
                columns, paramaters, "cursor0", "v_total");
	}

	@SuppressWarnings("unused")
	@Override
	public Object importBatch(List<ChnTxnBean> list) {
		String[] columns = new String[] {"v_INSTIID",
				"v_BUSICODE",
				"v_CHARGINGUNIT",
				"v_TRANSDATE",
				"v_TXID",
                "v_CREDITORBRANCHCODE",
                "v_CREDITORACCOUNTNO",
                "v_CREDITORNAME",
                "v_DEBTORBRANCHCODE",
                "v_DEBTORACCOUNTNO",
                "v_DEBTORNAME",
                "v_CURRENCYSYMBOL",
                "v_AMOUNT",
                "v_METEROBJNUMBER",
                "v_AUTHNUMBER",
                "v_VOUCHERNUMBER",
                "v_BILLNUMBER",
                "v_SYSTRCNO",
                "v_RSPCODE",
                "v_SETTLEDATE",
                "v_SETTLESTATUS",
                "v_LOGID"};
		StringBuffer returnMessage = new StringBuffer();
		for (ChnTxnBean chnTxnBean : list) {
			Object[] paramaters = new Object[] {chnTxnBean.getInstiid(),
					chnTxnBean.getBusicode(),chnTxnBean.getChargingunit(),chnTxnBean.getTransdate(),chnTxnBean.getTxid(),
					chnTxnBean.getCreditorbranchcode(),chnTxnBean.getCreditoraccountno(),chnTxnBean.getCreditorname(),
					chnTxnBean.getDebtorbranchcode(),chnTxnBean.getDebtoraccountno(),chnTxnBean.getDebtorname(),
					chnTxnBean.getCurrencysymbol(),chnTxnBean.getAmount(),chnTxnBean.getMeterobjnumber(),chnTxnBean.getAuthnumber(),
					chnTxnBean.getVouchernumber(),chnTxnBean.getBillnumber(),chnTxnBean.getSystrcno(),chnTxnBean.getRspcode(),chnTxnBean
					.getSettledate(),chnTxnBean.getSettlestatus(),chnTxnBean.getLogid()
	        };
			Object total = executeOracleProcedure(
	                "{CALL PCK_t_chn_txn.ins_t_chn_txn_nocur(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}",
	                columns,paramaters, "cursor0").get(0).get("INFO");
			if (!total.equals("执行成功")) {
				returnMessage.append("导入失败数据原明细序号:").append(chnTxnBean.getTxid());
				returnMessage.append("[").append(total.toString()).append("];;");
			}
		}
		if (returnMessage!=null) {
			return returnMessage.toString();
		}else{
			return "执行成功";
		}
	}

}
