package com.zcbspay.platform.manager.merchant.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.exception.ContractException;
import com.zcbspay.platform.manager.merchant.bean.CoopAgencyBean;
import com.zcbspay.platform.manager.merchant.dao.CoopAgencyDao;
import com.zcbspay.platform.manager.merchant.pojo.PojoCoopAgency;

@Repository
public class CoopAgencyDaoImpl extends HibernateBaseDAOImpl<PojoCoopAgency> implements CoopAgencyDao {

	@Override
	public Map<String, Object> findAll(Map<String, Object> variables, Integer page, Integer rows) {

		String[] columns = new String[]{"v_caname", "v_status",
				"v_cacode","i_no", "i_perno"};

        Object[] paramaters = new Object[]{
                variables.containsKey("caName") ? variables.get("caName") : null,
                variables.containsKey("status") ? variables.get("status") : null,
                variables.containsKey("caCode") ? variables.get("caCode") : null,
                page, rows};
        return executePageOracleProcedure("{CALL pck_t_coop_agency.sel_t_coop_agency(?,?,?,?,?,?,?)}",
                columns, paramaters,"cursor0", "v_total");
	}

	@Override
	public Map<String, Object> addCoopAgency(CoopAgencyBean pojo) {
		pojo.setOrganId((long) 1);
        String[] columns = new String[]{"v_cacode", "v_caname",
                "v_profittype", "v_caprovince", "v_cacity",
                "v_cabankacc", "v_caaccname", "v_cabank", 
                "v_banknode","v_organid", "v_supercode",
                "v_inuser", "v_notes","v_remarks"};
        Object[] paramaters = null;
			paramaters = new Object[]{
			        "".equals(pojo.getCaCode()) ? null : pojo.getCaCode(),
	        		"".equals(pojo.getCaName()) ? null : pojo.getCaName(),
	        		"".equals(pojo.getProfitType()) ? null : pojo.getProfitType(),
			        "".equals(pojo.getCaProvince()) ? null : pojo.getCaProvince(),
			        "".equals(pojo.getCaCity()) ? null : pojo.getCaCity(),
			        "".equals(pojo.getCaBankAcc()) ? null : pojo.getCaBankAcc(),
	        		"".equals(pojo.getCaAccName()) ? null : pojo.getCaAccName(),
			        "".equals(pojo.getCaBank()) ? null : pojo.getCaBank(),
			        "".equals(pojo.getBankNode()) ? null : pojo.getBankNode(),
	        		"".equals(pojo.getOrganId()) ? null : pojo.getOrganId(),
			        "".equals(pojo.getSuperCode()) ? null : pojo.getSuperCode(),
			        "".equals(pojo.getInUser()) ? null : pojo.getInUser(),
 	        		"".equals(pojo.getNotes()) ? null : pojo.getNotes(),
    				"".equals(pojo.getRemarks()) ? null : pojo.getRemarks()};
		return executeOracleProcedure("{CALL PCK_T_COOP_AGENCY.ins_t_coop_agency(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}", columns,
				paramaters, "cursor0").get(0);
	}
	@Override
	public Map<String, Object> editCoopAgency(CoopAgencyBean pojo) {
		String[] columns = new String[]{"v_caid","v_cacode", "v_caname",
				"v_profittype", "v_caprovince", "v_cacity",
				"v_cabankacc", "v_caaccname", "v_cabank", 
				"v_banknode","v_organid", "v_supercode",
				"v_inuser", "v_notes","v_remarks"};
		Object[] paramaters = null;
		paramaters = new Object[]{
				"".equals(pojo.getCaId()) ? null : pojo.getCaId(),
				"".equals(pojo.getCaCode()) ? null : pojo.getCaCode(),
        		"".equals(pojo.getCaName()) ? null : pojo.getCaName(),
        		"".equals(pojo.getProfitType()) ? null : pojo.getProfitType(),
		        "".equals(pojo.getCaProvince()) ? null : pojo.getCaProvince(),
		        "".equals(pojo.getCaCity()) ? null : pojo.getCaCity(),
		        "".equals(pojo.getCaBankAcc()) ? null : pojo.getCaBankAcc(),
        		"".equals(pojo.getCaAccName()) ? null : pojo.getCaAccName(),
		        "".equals(pojo.getCaBank()) ? null : pojo.getCaBank(),
		        "".equals(pojo.getBankNode()) ? null : pojo.getBankNode(),
        		"".equals(pojo.getOrganId()) ? null : pojo.getOrganId(),
		        "".equals(pojo.getSuperCode()) ? null : pojo.getSuperCode(),
		        "".equals(pojo.getInUser()) ? null : pojo.getInUser(),
        		"".equals(pojo.getNotes()) ? null : pojo.getNotes(),
				"".equals(pojo.getRemarks()) ? null : pojo.getRemarks()};
		return executeOracleProcedure("{CALL PCK_T_COOP_AGENCY.upt_t_coop_agency(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}", columns,
				paramaters, "cursor0").get(0);
	}
	
	@Override
	public List<?> findById(String caId) {
		String[] columns = new String[]{"v_caid"};
		Object[] paramaters = new Object[]{caId};
		return executeOracleProcedure("{CALL PCK_T_COOP_AGENCY.sel_t_coop_agency_deta(?,?)}", columns,paramaters, "cursor0");
	}
	
	public List<?> queryProfitType() {
		String[] columns = new String[]{"v_in"};
		Object[] paramaters = new Object[]{null};
		return executeOracleProcedure("{CALL  PCK_FOR_SELECT.sel_profit (?,?)}",columns,paramaters, "cursor0");
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public Map<String, Object> deleteCoopAgency(String caId) throws ContractException {
		Map<String, Object> map = new HashMap<String, Object>();
		String sql = "select po from PojoCoopAgency po where po.caId=?";
		PojoCoopAgency pojo = (PojoCoopAgency) queryByHQL(sql, new Object[]{Long.parseLong(caId)}).get(0);
		pojo.setStatus("99");
		PojoCoopAgency bean = update(pojo);
		if(bean.getStatus() == "00"){
			String info = "注销失败!";
			map.put("RET", "error");
			map.put("INFO", info);
			throw new ContractException(info);
		}else{
			map.put("RET", "succ");
			map.put("INFO", "注销成功");
		}
		return map;
	}

}
