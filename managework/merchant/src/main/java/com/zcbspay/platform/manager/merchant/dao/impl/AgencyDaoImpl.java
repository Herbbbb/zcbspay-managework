package com.zcbspay.platform.manager.merchant.dao.impl;


import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.merchant.bean.CertType;
import com.zcbspay.platform.manager.merchant.bean.EnterpriseDetaApplyBean;
import com.zcbspay.platform.manager.merchant.bean.MerchDetaApplyBean;
import com.zcbspay.platform.manager.merchant.certhandler.BusiLicePicHandler;
import com.zcbspay.platform.manager.merchant.certhandler.CertPicHandler;
import com.zcbspay.platform.manager.merchant.certhandler.CorpFileFacePicHandler;
import com.zcbspay.platform.manager.merchant.certhandler.CorpFileOppPicHandler;
import com.zcbspay.platform.manager.merchant.certhandler.OrgCertPicHandler;
import com.zcbspay.platform.manager.merchant.certhandler.SignFileFacePicHandler;
import com.zcbspay.platform.manager.merchant.certhandler.SignFileOppPicHandler;
import com.zcbspay.platform.manager.merchant.certhandler.TaxRegCertPicHandler;
import com.zcbspay.platform.manager.merchant.dao.AgencyDao;
import com.zcbspay.platform.manager.merchant.pojo.PojoEnterpriseDetaApply;
import com.zcbspay.platform.manager.merchant.pojo.PojoMerchDetaApply;
import com.zcbspay.platform.manager.utils.RSAUtils;

@Repository
@SuppressWarnings("all")
public class AgencyDaoImpl extends HibernateBaseDAOImpl<PojoMerchDetaApply> implements AgencyDao {

	private final static Log log = LogFactory.getLog(AgencyDaoImpl.class);
	 private final String merchCertRootPath = "/merchant";
	public List<?> queryMerchParent() {
		return executeOracleProcedure("{CALL  PCK_FOR_SELECT.sel_parent_merch (?)}", new String[]{},new Object[]{}, "cursor0");
	}

	public Map<String, Object> findMerchByPage(Map<String, Object> variables, Integer page, Integer rows) {
		 String[] columns = new String[]{"v_user", "v_member_id",
	                "v_merch_name", "v_address", "v_status", "v_coop_insti_id",
	                "v_flag", "i_no", "i_perno"};

	        Object[] paramaters = new Object[]{
	                variables.containsKey("userId") ? variables.get("userId") : null,
	                variables.containsKey("merberId") ? variables.get("merberId") : null,
	                variables.containsKey("merchName") ? variables.get("merchName") : null,
	                variables.containsKey("address") ? variables.get("address") : null,
	                variables.containsKey("status") ? variables.get("status") : null,
	                variables.containsKey("coopInstiId") ? variables.get("coopInstiId") : null,
	                variables.containsKey("flag") ? variables.get("flag") : null,
	                page, rows};
	        return executePageOracleProcedure("{CALL PCK_AGENCY.sel_t_merchant(?,?,?,?,?,?,?,?,?,?,?)}",
	                columns, paramaters, "cursor0", "v_total");
	}

	@Override
	public List<Map<String, String>> saveMerchDeta(MerchDetaApplyBean merch,EnterpriseDetaApplyBean enterprise) {

        boolean isRepeat = isRepeat(enterprise.getEmail(), enterprise.getPhone(),enterprise.getCoopInstiId());

        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        Map<String, String> resultMap = new HashMap<String, String>();
        if (isRepeat) {
            resultMap.put("RET", "fail");
            resultMap.put("INFO", "手机号或邮箱重复");
            result.add(resultMap);
            return result;
        }
        String[] columns = new String[]{"v_parent", "v_setlcycle",
                "v_setltype", "v_bankcode", "v_banknode", "v_accnum",
                "v_accname", "v_charge", "v_deposit", "v_agreemt_start",
                "v_agreemt_end", "v_prdtver", "v_feever", "v_spiltver",
                "v_riskver", "v_routver", "v_inuser", "v_notes", "v_remarks",
                "v_pay_bank_code","v_pay_bank_node","v_pay_acc_num","v_pay_acc_name",
                "v_merch_name_e", "v_coop_insti_id_e", "v_cellphoneno",
                "v_mcc_e", "v_mcclist_e", "v_merchinsti_e", "v_province_e",
                "v_city_e", "v_street_e", "v_postcode_e", "v_address_e",
                "v_email_e", "v_website_e", "v_cardtype_e", "v_taxno_e",
                "v_licenceno_e", "v_orgcode_e", "v_corporation_e",
                "v_corpno_e", "v_contact_e", "v_contphone_e", "v_conttitle_e",
                "v_contemail_e", "v_contaddress_e", "v_contpost_e",
                "v_custfrom_e", "v_custmgr_e", "v_custmgrdept_e",
                "v_isdelegation_e", "v_signatory_e", "v_signcertno_e",
                "v_CHARGINGUNIT","v_instcode","v_notes_e", "v_remarks_e"};
        Object[] paramaters = null;
		try {
			paramaters = new Object[]{
			        "".equals(merch.getParent()) ? null : "".equals(merch.getParent()),
			        "".equals(merch.getSetlCycle()) ? null : merch.getSetlCycle(),
			        "".equals(merch.getSetlType()) ? null : merch.getSetlType(),
			        "".equals(merch.getBankCode()) ? null : merch.getBankCode(),
			        "".equals(merch.getBankNode()) ? null : merch.getBankNode(),
			        "".equals(merch.getAccNum()) ? null : merch.getAccNum(),
			        "".equals(merch.getAccName()) ? null : merch.getAccName(),
			        merch.getCharge(),
			        merch.getDeposit(),
			        "".equals(merch.getAgreemtStart()) ? null : (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(merch.getAgreemtStart())),
			        "".equals(merch.getAgreemtEnd()) ? null : (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(merch.getAgreemtEnd())),
			        "".equals(merch.getPrdtVer()) ? null : merch.getPrdtVer(),
			        "".equals(merch.getFeeVer()) ? null : merch.getFeeVer(),
			        "".equals(merch.getSpiltVer()) ? null : merch.getSpiltVer(),
			        "".equals(merch.getRiskVer()) ? null : merch.getRiskVer(),
			        "".equals(merch.getRoutVer()) ? null : merch.getRoutVer(),
			        "".equals(enterprise.getInUser()) ? null : enterprise.getInUser(),
			        "".equals(merch.getNotes()) ? null : merch.getNotes(),
			        "".equals(merch.getRemarks()) ? null : merch.getRemarks(),
			        "".equals(merch.getPayBankCode()) ? null : merch.getPayBankCode(),
			     	"".equals(merch.getPayBankNode()) ? null : merch.getPayBankNode(),
			     	"".equals(merch.getPayAccNum()) ? null : merch.getPayAccNum(),
			     	"".equals(merch.getPayAccName()) ? null : merch.getPayAccName(),	
			        "".equals(enterprise.getEnterpriseName()) ? null : enterprise.getEnterpriseName(),
			        "".equals(enterprise.getCoopInstiId()) ? null : enterprise.getCoopInstiId(),
			        "".equals(enterprise.getPhone()) ? null : enterprise.getPhone(),
			        "".equals(enterprise.getMcc()) ? null : enterprise.getMcc(),
			        "".equals(enterprise.getMccList()) ? null : enterprise.getMccList(),
			        "".equals(enterprise.getEnterpriseInsti()) ? null : enterprise.getEnterpriseInsti(),
			        "".equals(enterprise.getProvince()) ? null : enterprise.getProvince(),
			        "".equals(enterprise.getCity()) ? null : enterprise.getCity(),
			        "".equals(enterprise.getStreet()) ? null : enterprise.getStreet(),
			        "".equals(enterprise.getPostCode()) ? null : enterprise.getPostCode(),
			        "".equals(enterprise.getAddress()) ? null : enterprise.getAddress(),
			        "".equals(enterprise.getEmail()) ? null : enterprise.getEmail(),
			        "".equals(enterprise.getWebsite()) ? null : enterprise.getWebsite(),
			        "".equals(enterprise.getCardType()) ? null : enterprise.getCardType(),
			        "".equals(enterprise.getTaxno()) ? null : enterprise.getTaxno(),
			        "".equals(enterprise.getLicenceNo()) ? null : enterprise.getLicenceNo(),
			        "".equals(enterprise.getOrgCode()) ? null : enterprise.getOrgCode(),
			        "".equals(enterprise.getCorporation()) ? null : enterprise.getCorporation(),
			        "".equals(enterprise.getCorpNo()) ? null : enterprise.getCorpNo(),
			        "".equals(enterprise.getContact()) ? null : enterprise.getContact(),
			        "".equals(enterprise.getContPhone()) ? null : enterprise.getContPhone(),
			        "".equals(enterprise.getContTitle()) ? null : enterprise.getContTitle(),
			        "".equals(enterprise.getContEmail()) ? null : enterprise.getContEmail(),
			        "".equals(enterprise.getContAddress()) ? null : enterprise.getContAddress(),
			        "".equals(enterprise.getContPost()) ? null : enterprise.getContPost(),
			        "".equals(enterprise.getCustFrom()) ? null : enterprise.getCustFrom(),
			        "".equals(enterprise.getCustMgr()) ? null : enterprise.getCustMgr(),
			        "".equals(enterprise.getCustMgrDept()) ? null : enterprise.getCustMgrDept(),
			        "".equals(enterprise.getIsDelegation()) ? null : enterprise.getIsDelegation(),
			        "".equals(enterprise.getSignatory()) ? null : enterprise.getSignatory(),
			        "".equals(enterprise.getSignCertNo()) ? null : enterprise.getSignCertNo(),
			        "".equals(merch.getChargingunit()) ? null : merch.getChargingunit(),
			        "".equals(merch.getInstCode()) ? null : merch.getInstCode(),
			        "".equals(enterprise.getNotes()) ? null : enterprise.getNotes(),
			        "".equals(enterprise.getRemarks()) ? null : enterprise.getRemarks()};
		} catch (ParseException e) {
			e.printStackTrace();
		}
        List<?> dbResult = executeOracleProcedure(
                        "{CALL PCK_AGENCY.pro_i_t_merch_deta(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}",
                        columns, paramaters, "cursor0");
        if (dbResult == null || dbResult.get(0) == null) {
            resultMap.clear();
            resultMap.put("RET", "fail");
            resultMap.put("INFO", "操作失败,请联系技术人员");
            result.add(resultMap);
        } else {
            resultMap = (Map<String, String>) dbResult.get(0);
        }
        result.add(resultMap);
        return result;
    }

	@Override
	public List<?> queryCounty(Long pid) {
		String[] columns = new String[]{"v_in"};
        Object[] paramaters = new Object[1];
        paramaters[0] = pid;
        return executeOracleProcedure("{CALL  PCK_FOR_SELECT.sel_county(?,?)}", columns, paramaters,
                "cursor0");
    }

	@Override
    public List<?> queryMerchType() {
        String[] columns = new String[]{"v_in"};
        Object[] paramaters = new Object[1];
        paramaters[0] = 1;
        return executeOracleProcedure("{CALL  PCK_FOR_SELECT.sel_dic_MERCHTYPE(?,?)}", columns,
                paramaters, "cursor0");
    }
	@Override
	 public List<?> queryTrade() {
        String[] columns = new String[]{"v_in"};
        Object[] paramaters = new Object[1];
        paramaters[0] = 1;
        return executeOracleProcedure("{CALL  PCK_FOR_SELECT.sel_dic_TRADE(?,?)}", columns,
                paramaters, "cursor0");
    }

	@Override
	 public List<?> querysetltype() {
        String[] columns = new String[]{"v_in"};
        Object[] paramaters = new Object[1];
        paramaters[0] = 1;
        return executeOracleProcedure("{CALL  PCK_FOR_SELECT.sel_setltype(?,?)}", columns,
                paramaters, "cursor0");
    }

	@Override
	public List<?> queryBankNode(String bankName, Integer page, Integer rows) {
        String[] columns = new String[]{"v_bank_name", "v_bank_address",
                "i_no", "i_perno"};
        Object[] paramaters = new Object[4];
        paramaters[0] = bankName;
        paramaters[1] = null;
        paramaters[2] = "1";
        paramaters[3] = "10";
        return executeOracleProcedure("{CALL  PCK_FOR_SELECT.sel_t_bank_info(?,?,?,?,?)}", columns,
                paramaters, "cursor0");
    }

	@Override
	public List<?> queryCashAll() {
        String[] columns = new String[]{"v_in"};
        Object[] paramaters = new Object[1];
        paramaters[0] = 1;
        return executeOracleProcedure("{CALL  PCK_FOR_SELECT.sel_cash(?,?)}", columns, paramaters,
                "cursor0");
    }

	@Override
    public List<?> queryChnlnameAll() {
        String[] columns = new String[]{"v_in"};
        Object[] paramaters = new Object[1];
        paramaters[0] = 1;
        return executeOracleProcedure("{CALL  PCK_FOR_SELECT.sel_chnlname(?,?)}", columns,
                paramaters, "cursor0");
    }
    @Override
    public List<?> queryRouteAll() {
        String[] columns = new String[]{"v_in"};
        Object[] paramaters = new Object[1];
        paramaters[0] = 1;
        return executeOracleProcedure("{CALL  PCK_FOR_SELECT.sel_route(?,?)}", columns, paramaters,
                "cursor0");
    }

    @Override
    public List<?> querySetlcycleAll() {
        String[] columns = new String[]{"v_in"};
        Object[] paramaters = new Object[1];
        paramaters[0] = 1;
        return executeOracleProcedure("{CALL  PCK_FOR_SELECT.sel_dic_setl_cycle(?,?)}", columns,
                paramaters, "cursor0");
    }

    // 查询产品下的分润版本
    @Override
    public List<?> querySplit(String pid) {
        String[] columns = new String[]{"v_in"};
        Object[] paramaters = new Object[1];
        paramaters[0] = pid;
        return executeOracleProcedure("{CALL  PCK_FOR_SELECT.sel_split(?,?)}", columns, paramaters,
                "cursor0");
    }

    // 查询产品下的风控版本
    @Override
    public List<?> queryRiskType(String pid) {
        String[] columns = new String[]{"v_in"};
        Object[] paramaters = new Object[1];
        paramaters[0] = pid;
        return executeOracleProcedure(
                "{CALL  PCK_FOR_SELECT.sel_risk(?,?)}", columns, paramaters,
                "cursor0");
    }

    // 查询产品下的扣率版本
    @Override
    public List<?> queryFee(String pid) {
        String[] columns = new String[]{"v_in"};
        Object[] paramaters = new Object[1];
        paramaters[0] = pid;
        return executeOracleProcedure("{CALL  PCK_FOR_SELECT.sel_fee(?,?)}", columns, paramaters,
                "cursor0");
    }

    public boolean isRepeat(String email, String cellphone, Long coopInstiId) {
        String sql="select * from t_merch_deta t inner join t_member tp on t.member_id=tp.member_id where"
        		+ " nvl(tp.insti_code,'-1')=nvl(?,'-1') and (tp.email=? or tp.phone=?)";
        
//        String sql="select * from t_merch_deta t inner join t_member tp on t.member_id=tp.member_id where"
//        		+ " tp.insti_code=? and (tp.email=? or tp.phone=?)";
        
        Object[] paramaters = new Object[]{
        		"".equals(coopInstiId) ? null : coopInstiId,
        		"".equals(email) ? null : email,
        		"".equals(cellphone) ? null : cellphone};
        
        if(queryBySQL(sql,paramaters) != null){
            return true;
        } else {
            return false;
        }
    }
    @Override
	public List<?> getBean(Long selfId) {
		String sql = "select u from PojoMerchDetaApply u where u.selfId=?";
		return queryByHQL(sql, new Object[]{selfId});
		
	}

	@Override
	public boolean commitMerch(String merchApplyId) {
		 String[] columns = new String[]{"v_self_id"};
	        Object[] paramaters = new Object[1];
	        paramaters[0] = merchApplyId;
	        List<?> result = executeOracleProcedure(
	                "{CALL  PCK_AGENCY.addi_merch_deta(?,?)}", columns, paramaters,
	                "cursor0");
	        boolean isSucc = false;
	        if (result != null && !(result.get(0) == null)) {

	            @SuppressWarnings("unchecked")
	            Map<String, String> resultMap = (Map<String, String>) result.get(0);
	            if (resultMap.containsKey("RET")
	                    && resultMap.get("RET").equals("succ")) {
	                isSucc = true;
	            }
	        }
	        return isSucc;
	}

	@Override
	public String downloadFromFtp(PojoMerchDetaApply MerchDeta, PojoEnterpriseDetaApply enterpriseDeta,
			String targDir, CertType certType, boolean fouce) {
	    CertPicHandler certPicHandler = getCertHandler(certType);
	    String fileName = certPicHandler.getFileName(enterpriseDeta);
	    if (fileName == null) {// not upload yet return "";
	        return "";
	    }
	    targDir = targDir + "/" + MerchDeta.getMemberId();
	    if (fouce || !checkLocalExist(targDir, fileName)) {// not exist in local
	        try {
	        } catch (Exception e) {
	            e.printStackTrace();
	            log.warn("download from ftp get a exception.caused by:" + e.getMessage());
	            return null;
	        }
	    }
		return null;
	}
	private CertPicHandler getCertHandler(CertType certType) {
        switch (certType) {
            case TAXREGCERT :
                return new TaxRegCertPicHandler();
            case BUSILICE :
                return new BusiLicePicHandler();
            case ORGCERT :
                return new OrgCertPicHandler();
            case CORPFILE_FACE :
                return new CorpFileFacePicHandler();
            case CORPFILE_OPPOSITE :
                return new CorpFileOppPicHandler();
            case SIGNATORYFILE_FACE :
                return new SignFileFacePicHandler();
            case SIGNATORYFILE_OPPOSITE :
                return new SignFileOppPicHandler();
            default :
                return null;
        }
    }
	private boolean checkLocalExist(String dirPath, String fileName) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null) {
            return false;
        }
        for (File file : files) {
            if (file.isFile() && file.getName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }
	 private String getMerchCertPath(String memberId) {
	        return merchCertRootPath + "/" + String.valueOf(memberId);
	    }

	@Override
	public List<?> saveChangeMerchDeta(String merchApplyId, MerchDetaApplyBean merchDeta,EnterpriseDetaApplyBean enterpriseDeta) {
		 boolean hasSame = hasSame( enterpriseDeta.getEmail(),enterpriseDeta.getPhone(),enterpriseDeta.getCoopInstiId(),merchDeta.getMemberId());
	        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
	        Map<String, String> resultMap = new HashMap<String, String>();
	        if (hasSame) {
	            resultMap.put("RET", "fail");
	            resultMap.put("INFO", "手机号或邮箱重复");
	            result.add(resultMap);
	            return result;
	        }

	        PojoMerchDetaApply oldMerchApplyInfo = (PojoMerchDetaApply) getBean(Long.parseLong(merchApplyId)).get(0);
	        
	        if(oldMerchApplyInfo == null){
	        	return null;
	        }

	        if (merchDeta.getBankNode() == null
	                || merchDeta.getBankNode().equals("")) {
	            merchDeta.setBankCode(oldMerchApplyInfo.getBankCode());
	            merchDeta.setBankNode(oldMerchApplyInfo.getBankNode());
	        } else {
	            Object[] paramaters = merchDeta.getBankNode().split(",");
	            merchDeta.setBankCode(paramaters[0].toString());
	            merchDeta.setBankNode(paramaters[1].toString());
	        }
//	        MccListModel mccList = daoContainer.getMccListDAO().get(
//	                merchDeta.getMember().getMccList());
//	        enterpriseDeta.setMcc(mccList.getMcc());
//	        merchDeta.setmInUser(oldMerchApplyInfo.getmInUser());
//	        enterpriseDeta.setMemId(
//	                oldMerchApplyInfo.getMemberApply().getMemId());
//	        merchDeta.setMerchId(oldMerchApplyInfo.getMerchId());
//	        merchDeta.setMemberId(oldMerchApplyInfo.getMemberId());

	        String[] columns = new String[]{"v_self_id", "v_merch_id", "v_mem_id",
	                "v_member_id", "v_parent", "v_setlcycle", "v_setltype",
	                "v_bankcode", "v_banknode", "v_accnum", "v_accname",
	                "v_charge", "v_deposit", "v_agreemt_start", "v_agreemt_end",
	                "v_prdtver", "v_feever", "v_spiltver", "v_riskver",
	                "v_routver", "v_inuser", "v_notes", "v_remarks",
	                "v_pay_bank_code","v_pay_bank_node","v_pay_acc_num","v_pay_acc_name",
	                "v_merch_name_e", "v_coop_insti_id_e", "v_cellphoneno",
	                "v_mcc_e", "v_mcclist_e", "v_merchinsti_e", "v_province_e",
	                "v_city_e", "v_street_e", "v_postcode_e", "v_address_e",
	                "v_email_e", "v_website_e", "v_cardtype_e", "v_taxno_e",
	                "v_licenceno_e", "v_orgcode_e", "v_corporation_e",
	                "v_corpno_e", "v_contact_e", "v_contphone_e", "v_conttitle_e",
	                "v_contemail_e", "v_contaddress_e", "v_contpost_e",
	                "v_custfrom_e", "v_custmgr_e", "v_custmgrdept_e",
	                "v_isdelegation_e", "v_signatory_e", "v_signcertno_e",
	                "v_CHARGINGUNIT","v_instcode","v_notes_e", "v_remarks_e"};
	        Object[] paramaters = null;
			try {
				paramaters = new Object[]{
				        merchApplyId,
				        merchDeta.getMerchId(),
				        enterpriseDeta.getMemId(),
				        enterpriseDeta.getEnterpriseMemberId(),
				        "".equals(merchDeta.getParent()) ? null : merchDeta.getParent(),
				        "".equals(merchDeta.getSetlCycle()) ? null : merchDeta.getSetlCycle(),
				        "".equals(merchDeta.getSetlType()) ? null : merchDeta.getSetlType(),
				        "".equals(merchDeta.getBankCode()) ? null : merchDeta.getBankCode(),
				        "".equals(merchDeta.getBankNode()) ? null : merchDeta.getBankNode(),
				        "".equals(merchDeta.getAccNum()) ? null : merchDeta.getAccNum(),
				        "".equals(merchDeta.getAccName()) ? null : merchDeta.getAccName(),
						merchDeta.getCharge(),
						merchDeta.getDeposit(),
				        "".equals(merchDeta.getAgreemtStart()) ? null : (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(merchDeta.getAgreemtStart())),
				        "".equals(merchDeta.getAgreemtEnd()) ? null : (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(merchDeta.getAgreemtEnd())),
				        "".equals(merchDeta.getPrdtVer()) ? null : merchDeta.getPrdtVer(),
				        "".equals(merchDeta.getFeeVer()) ? null : merchDeta.getFeeVer(),
				        "".equals(merchDeta.getSpiltVer()) ? null : merchDeta.getSpiltVer(),
				        "".equals(merchDeta.getRiskVer()) ? null : merchDeta.getRiskVer(),
				        "".equals(merchDeta.getRoutVer()) ? null : merchDeta.getRoutVer(),
				        		
				        "".equals(enterpriseDeta.getInUser()) ? null : enterpriseDeta.getInUser(),
				        "".equals(merchDeta.getNotes()) ? null : merchDeta.getNotes(),
				        "".equals(merchDeta.getRemarks()) ? null : merchDeta.getRemarks(),
		        		"".equals(merchDeta.getPayBankCode()) ? null : merchDeta.getPayBankCode(),
    			     	"".equals(merchDeta.getPayBankNode()) ? null : merchDeta.getPayBankNode(),
    			     	"".equals(merchDeta.getPayAccNum()) ? null : merchDeta.getPayAccNum(),
    			     	"".equals(merchDeta.getPayAccName()) ? null : merchDeta.getPayAccName(),
				        "".equals(enterpriseDeta.getEnterpriseName()) ? null : enterpriseDeta.getEnterpriseName(),
				        "".equals(enterpriseDeta.getCoopInstiId()) ? null : enterpriseDeta.getCoopInstiId(),
				        "".equals(enterpriseDeta.getPhone()) ? null : enterpriseDeta.getPhone(),
				        		
				        "".equals(enterpriseDeta.getMcc()) ? null : enterpriseDeta.getMcc(),
				        "".equals(enterpriseDeta.getMccList()) ? null : enterpriseDeta.getMccList(),
				        "".equals(enterpriseDeta.getEnterpriseInsti()) ? null : enterpriseDeta.getEnterpriseInsti(),
				        "".equals(enterpriseDeta.getProvince()) ? null : enterpriseDeta.getProvince(),
				        "".equals(enterpriseDeta.getCity()) ? null : enterpriseDeta.getCity(),
				        "".equals(enterpriseDeta.getStreet()) ? null : enterpriseDeta.getStreet(),
				        "".equals(enterpriseDeta.getPostCode()) ? null : enterpriseDeta.getPostCode(),
				        "".equals(enterpriseDeta.getAddress()) ? null : enterpriseDeta.getAddress(),
				        "".equals(enterpriseDeta.getEmail()) ? null : enterpriseDeta.getEmail(),
				        "".equals(enterpriseDeta.getWebsite()) ? null : enterpriseDeta.getWebsite(),
				        "".equals(enterpriseDeta.getCardType()) ? null : enterpriseDeta.getCardType(),
				        "".equals(enterpriseDeta.getTaxno()) ? null : enterpriseDeta.getTaxno(),
				        "".equals(enterpriseDeta.getLicenceNo()) ? null : enterpriseDeta.getLicenceNo(),
				        "".equals(enterpriseDeta.getOrgCode()) ? null : enterpriseDeta.getOrgCode(),
				        "".equals(enterpriseDeta.getCorporation()) ? null : enterpriseDeta.getCorporation(),
				        "".equals(enterpriseDeta.getCorpNo()) ? null : enterpriseDeta.getCorpNo(),
				        "".equals(enterpriseDeta.getContact()) ? null : enterpriseDeta.getContact(),
				        "".equals(enterpriseDeta.getContPhone()) ? null : enterpriseDeta.getContPhone(),
				        "".equals(enterpriseDeta.getContTitle()) ? null : enterpriseDeta.getContTitle(),
				        "".equals(enterpriseDeta.getContEmail()) ? null : enterpriseDeta.getContEmail(),
				        "".equals(enterpriseDeta.getContAddress()) ? null : enterpriseDeta.getContAddress(),
				        "".equals(enterpriseDeta.getContPost()) ? null : enterpriseDeta.getContPost(),
				        "".equals(enterpriseDeta.getCustFrom()) ? null : enterpriseDeta.getCustFrom(),
				        "".equals(enterpriseDeta.getCustMgr()) ? null : enterpriseDeta.getCustMgr(),
				        "".equals(enterpriseDeta.getCustMgrDept()) ? null : enterpriseDeta.getCustMgrDept(),
				        "".equals(enterpriseDeta.getIsDelegation()) ? null : enterpriseDeta.getIsDelegation(),
				        "".equals(enterpriseDeta.getSignatory()) ? null : enterpriseDeta.getSignatory(),
				        "".equals(enterpriseDeta.getSignCertNo()) ? null : enterpriseDeta.getSignCertNo(),
				        "".equals(merchDeta.getChargingunit()) ? null : merchDeta.getChargingunit(),
				        "".equals(merchDeta.getInstCode()) ? null : merchDeta.getInstCode(),
				        "".equals(enterpriseDeta.getNotes()) ? null : enterpriseDeta.getNotes(),
				        "".equals(enterpriseDeta.getRemarks()) ? null : enterpriseDeta.getRemarks()};
			} catch (ParseException e) {
				e.printStackTrace();
			}
	        List<?> dbResult = executeOracleProcedure(
	                        "{CALL PCK_AGENCY.pro_u_t_merch_deta(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}",
	                        columns, paramaters, "cursor0");
	        if (dbResult == null || dbResult.get(0) == null) {
	            resultMap.clear();
	            resultMap.put("RET", "fail");
	            resultMap.put("INFO", "操作失败,请联系技术人员");
	            result.add(resultMap);
	        } else {
	            resultMap = (Map<String, String>) dbResult.get(0);
	        }
	        result.add(resultMap);
	        return result;
	}
	 public boolean hasSame(String email, String cellphone, Long coopInstiId,String memberId) {
	        String sql="select * from t_merch_deta t inner join t_member tp on t.member_id=tp.member_id where"
	        		+ " nvl(tp.insti_code,'-1')=nvl(?,'-1') and (tp.email=? or tp.phone=?) and t.member_id=?";
	        Object[] paramaters = new Object[]{
	        		"".equals(coopInstiId) ? null : coopInstiId,
	        		"".equals(email) ? null : email,
	        		"".equals(cellphone) ? null : cellphone,
	        		"".equals(memberId) ? null : memberId};
	        
	        if(queryBySQL(sql,paramaters) != null){
	            return true;
	        } else {
	            return false;
	        }
	    }

	@Override
	public String queryBankName(String bankNode, String bankCode) {
		 String querySQL;
	        SQLQuery query;

	        if (bankNode == null || bankNode.equals("")) {
	            return null;
	        }
	        querySQL = "select bank_name from t_bank_info where bank_node=?";

	        if (bankCode != null && !bankCode.equals("")) {
	            querySQL += " and bank_code=?";
	            query = getSession().createSQLQuery(querySQL);
	            query.setParameter(0, bankNode);
	            query.setParameter(1, bankCode);
	        } else {
	            query = getSession().createSQLQuery(querySQL);
	            query.setParameter(0, bankNode);
	        }
	        String result = (String) query.uniqueResult();

	        return result;
	}

	@Override
	public Map<String, Object> queryApplyMerchDeta(String merchApplyId, Long userId) {
		PojoMerchDetaApply pojoMerchApply = (PojoMerchDetaApply) getBean(Long.parseLong(merchApplyId)).get(0);
		
		if(pojoMerchApply == null){
        	return null;
        }
		
        String[] columns = new String[]{"v_user", "v_self_id", "v_merch_id"};
        Object[] paramaters = new Object[3];
        paramaters[0] = userId;
        paramaters[1] = pojoMerchApply.getSelfId();
        paramaters[2] = pojoMerchApply.getMerchId();
        return (Map<String, Object>) executeOracleProcedure("{CALL  PCK_AGENCY.sel_t_merchant_apply_deta(?,?,?,?)}",
                columns, paramaters, "cursor0").get(0);
	}

	@Override
	public List<Map<String, Object>> merchAudit(String merchApplyId, MerchDetaApplyBean merchDeta, String memId,
			String flag, String isAgree) {
        
        String[] columns = new String[]{"v_user", "v_merch_id", "v_self_id",
                "v_opinion", "v_isagree", "v_flag"};
        Object[] paramaters = new Object[6];
        if (flag.equals("2")) {
            paramaters[0] = merchDeta.getStexaUser();
            paramaters[3] = merchDeta.getStexaOpt();
        } else if(flag.equals("3")){
            paramaters[0] = merchDeta.getCvlexaUser();
            paramaters[3] = merchDeta.getCvlexaOpt();
        } else if(flag.equals("5")){
            paramaters[0] = merchDeta.getStexaUser();
            paramaters[3] = merchDeta.getStexaOpt();
        } else if(flag.equals("6")){
            paramaters[0] = merchDeta.getCvlexaUser();
            paramaters[3] = merchDeta.getCvlexaOpt();
        }

        paramaters[1] = memId;
        paramaters[2] = merchApplyId;
        paramaters[4] = isAgree;
        paramaters[5] = null;
        List<Map<String, Object>> resultlist = executeOracleProcedure("{CALL  PCK_AGENCY.exam_merch_deta(?,?,?,?,?,?,?)}", columns,
                paramaters, "cursor0");
        String mark = (String) resultlist.get(0).get("INFO");

        if (mark.equals("操作成功!") && isAgree.equals("0") && flag.equals("3")) {
            // 复审通过，flag=3
            PojoMerchDetaApply pojoMerchDetaApply = (PojoMerchDetaApply) getBean(Long.parseLong(merchApplyId)).get(0);
            
            if(pojoMerchDetaApply == null){
	        	return null;
	        }
            
            Map<String, Object> variables = new HashMap<String, Object>();
            variables.put("merberId", pojoMerchDetaApply.getMemberId());
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
//            // 生成商户账户
//            memberServiceImpl.openBusiAcct(pojoMerchDetaApply.getMemberApply()
//                    .getMemberName(), pojoMerchDetaApply.getMemberId(),
//                    pojoMerchDetaApply.getCvlexaUser());
//            //保存商户激活的信息
//            MemberQueueMode memberQueue=new MemberQueueMode();
//            memberQueue.setMemberId(pojoMerchDetaApply.getMemberId());
//            memberQueue.setEmail(pojoMerchDetaApply.getMemberApply().getEmail());
//            memberQueue.setSendTimes(0);
//            memberQueue.setFlag("01");
//            List<?> list  =daoContainer.getEnterpriseDetaDAO().getIdCardByMemberId(pojoMerchDetaApply.getMemberId());
//            if(list.size()>0){
//                JSONArray jsonArray = JSONArray.fromObject(list);
//                JSONObject job = jsonArray.getJSONObject(0);
//                ParaDicModel maxsend= daoContainer.getParadicDAO().get(102L);
//                ParaDicModel expirationTime= daoContainer.getParadicDAO().get(101L);
//                memberQueue.setEmail(job.get("EMAIL").toString());
//                memberQueue.setMaxSendTimes(Integer.parseInt(maxsend.getParaCode()));
//                memberQueue.setExpirationTime(expirationTime.getParaCode());
//                memberQueue.setIdCard(job.get("CORP_NO").toString());
//            }
//            getDaoContainer().getMemberQueueDAO().save(memberQueue);
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
	public void updateMerch(String memberId, String riskVer) {
		String sql="update t_merch_deta_apply set RISK_VER=? where SELF_ID=?";
	      updateBySQL(sql, new Object[]{riskVer,memberId});
	}
}

