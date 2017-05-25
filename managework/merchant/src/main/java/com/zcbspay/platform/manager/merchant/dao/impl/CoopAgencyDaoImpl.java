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
import com.zcbspay.platform.manager.utils.RSAUtils;

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
			Map<String, Object> resultlist = executeOracleProcedure("{CALL PCK_T_COOP_AGENCY.ins_t_coop_agency(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}", columns,
				paramaters, "cursor0").get(0);
			 String mark = (String) resultlist.get("RET");

	        if (mark.equals("succ") ) {
	            
	            Map<String, Object> variables = new HashMap<String, Object>();
	            variables.put("merberId", pojo.getCaCode());
	            // 商户秘钥
	            Map<String, Object> merch_keyMap;
				try {
					merch_keyMap = RSAUtils.genKeyPair();
				
	            Map<String, Object> plath_keyMap = RSAUtils.genKeyPair();
	            String merch_publicKey = RSAUtils.getPublicKey(merch_keyMap);
	            String merch_privateKey = RSAUtils.getPrivateKey(merch_keyMap);
	            String plath_publicKey = RSAUtils.getPublicKey(plath_keyMap);
	            String plath_privateKey = RSAUtils.getPrivateKey(plath_keyMap);
	            variables.put("memberpubkey", merch_publicKey);
	            variables.put("memberprikey", merch_privateKey);
	            variables.put("localpubkey", plath_publicKey);
	            variables.put("localprikey", plath_privateKey);
	            @SuppressWarnings("unused")
	            List<?> MKlist = saveMerchMk(variables);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
	        }
	        return resultlist;
	    }
	public List<?> saveMerchMk(Map<String, Object> variables) {

        String[] columns = new String[]{"v_memberid", "v_safetype",
                "v_memberpubkey", "v_memberprikey", "v_localpubkey",
                "v_localprikey", "v_storgetype", "v_keyflag", "v_notes",
                "v_remarks"};
        Object[] paramaters = new Object[]{
                variables.containsKey("merberId") ? variables.get("merberId") : null,
                "01",
                variables.containsKey("memberpubkey") ? variables.get("memberpubkey") : null,
                variables.containsKey("memberprikey") ? variables.get("memberprikey") : null,
                variables.containsKey("localpubkey") ? variables.get("localpubkey") : null,
                variables.containsKey("localprikey") ? variables.get("localprikey") : null,
                		"01", "1", null, null};
        return executeOracleProcedure("{CALL  PCK_T_MERCH_MK.pro_i_t_merch_mk(?,?,?,?,?,?,?,?,?,?,?)}",
                        columns, paramaters, "cursor0");
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

	@Override
	public Map<String, Object> queryProfit(Map<String, Object> result, Integer page, Integer rows) {
		String[] columns = new String[]{"v_cacode", "v_date",
				"v_profit","i_no", "i_perno"};

        Object[] paramaters = new Object[]{
        		result.containsKey("caCode") ? result.get("caCode") : null,
				result.containsKey("date") ? result.get("date") : null,
				result.containsKey("profitType") ? result.get("profitType") : null,
                page, rows};
        return executePageOracleProcedure("{CALL STAT_AGENCY_PROFIT.STAT_AGENCY_PROFIT(?,?,?,?,?,?,?)}",
                columns, paramaters,"cursor0", "v_total");
	}

	@Override
	public List<?> findByCode(String caCode) {
		String sql = "select po from PojoCoopAgency po where po.caCode=?";
		return queryByHQL(sql, new Object[]{caCode});
	}

}
