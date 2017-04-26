package com.zcbspay.platform.manager.risk.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.risk.bean.BlackIdnumBean;
import com.zcbspay.platform.manager.risk.dao.CardHolderBlackDAO;
import com.zcbspay.platform.manager.risk.pojo.PojoBlackIdnum;

@Repository
public class CardHolderBlackDAOImpl extends HibernateBaseDAOImpl<PojoBlackIdnum> implements CardHolderBlackDAO {

	@Override
	public Map<String, Object> queryCardHolderBlackList(Map<String, Object> variables, int page, int rows) {
		String[] columns = new String[] { "v_idnum", "v_merchaname", "i_no", "i_perno" };
		Object[] paramaters = new Object[4];
		paramaters[0] = variables.containsKey("idnum") ? variables.get("idnum") : null;
		paramaters[1] = variables.containsKey("merchname") ? variables.get("merchname") : null;
		paramaters[2] = page;
		paramaters[3] = rows;
		return executePageOracleProcedure("{CALL PCK_T_BLACKLIST_IDNUM.sel_t_blacklist_idnum(?,?,?,?,?,?)}", columns,
				paramaters, "cursor0", "v_total");

	}

	@Override
	public String AddOneBlackCardHolder(BlackIdnumBean blackIdnumBean) {
		String[] columns = new String[] { "v_idnum", "v_risklevel", "v_notes", "v_remarks", "v_sdate", "v_edate" };
		Object[] paramaters = new Object[] { blackIdnumBean.getIdnum(), blackIdnumBean.getRisklevel(),
				blackIdnumBean.getNotes(), blackIdnumBean.getRemarks(), blackIdnumBean.getSdate(),
				blackIdnumBean.getEdate() };
		Object total = executeOracleProcedure("{CALL PCK_T_BLACKLIST_IDNUM.ins_t_blacklist_idnum(?,?,?,?,?,?,?)}",
				columns, paramaters, "cursor0").get(0).get("INFO");
		return (String) total;
	}

	@Override
	public Map<String, Object> queryOneBlackCardHolder(String tid) {
		String[] columns = new String[] { "v_tid" };

		Object[] paramaters = new Object[] { tid };
		Map<String, Object> map = executeOracleProcedure("{CALL PCK_T_BLACKLIST_IDNUM.sel_t_blacklist_idnum_date(?,?)}",
				columns, paramaters, "cursor0").get(0);
		return map;

	}

	@Override
	public String delteOneCardHolderBlack(String tid) {
		if (tid == null) {
			return "操作失败！";
		}
		Object[] paramaters = new Object[] { tid, null };
		String[] columns = new String[] { "v_t_id", "v_user" };
		Object total = executeOracleProcedure("{CALL PCK_T_BLACKLIST_IDNUM.del_t_blacklist_idnum(?,?,?)}", columns,
				paramaters, "cursor0").get(0).get("INFO");
		return (String) total;
	}

	@Override
	public String startCardHolderBlack(String tid) {
		if (tid == null || tid == "") {
			return "操作失败";
		}
		Object[] paramaters = new Object[] { tid, null };
		String[] columns = new String[] { "v_t_id", "v_user" };
		Object total = executeOracleProcedure("{CALL PCK_T_BLACKLIST_IDNUM.start_t_blacklist_idnum(?,?,?)}", columns,
				paramaters, "cursor0").get(0).get("INFO");
		return (String) total;
	}

	@Override
	public String updateBlackCardHolder(BlackIdnumBean blackIdnumBean) {
		if (blackIdnumBean == null) {
			return null;
		}

		Object[] paramaters = new Object[] { blackIdnumBean.getTid(), blackIdnumBean.getIdnum(),
				blackIdnumBean.getRisklevel(), blackIdnumBean.getNotes(), blackIdnumBean.getRemarks(),
				blackIdnumBean.getSdate(), blackIdnumBean.getEdate() };
		String[] columns = new String[] { "v_t_id", "v_idnum", "v_risklevel", "v_notes", "v_remarks", "v_sdate",
				" v_edate" };
		Object total = executeOracleProcedure("{CALL PCK_T_BLACKLIST_IDNUM.upt_t_blacklist_idnum(?,?,?,?,?,?,?,?)}",
				columns, paramaters, "cursor0").get(0).get("INFO");
		return (String) total;
	}

}
