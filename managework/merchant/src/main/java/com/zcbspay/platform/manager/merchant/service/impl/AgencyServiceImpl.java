package com.zcbspay.platform.manager.merchant.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.exception.ContractException;
import com.zcbspay.platform.manager.merchant.bean.AgencyInfoBean;
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
import com.zcbspay.platform.manager.merchant.dao.AgencyInfoDao;
import com.zcbspay.platform.manager.merchant.dao.EnterpriseDetaDao;
import com.zcbspay.platform.manager.merchant.pojo.PojoAgencyInfo;
import com.zcbspay.platform.manager.merchant.pojo.PojoEnterpriseDetaApply;
import com.zcbspay.platform.manager.merchant.pojo.PojoMerchDetaApply;
import com.zcbspay.platform.manager.merchant.service.AgencyService;
@Service("agencyService")
@SuppressWarnings("all")
public class AgencyServiceImpl implements AgencyService {

	 private final static Log log = LogFactory.getLog(AgencyServiceImpl.class);
	@Autowired
	private AgencyDao agencyDAO;
	@Autowired
	private EnterpriseDetaDao enterpriseDetaDao;
	@Autowired
	private AgencyInfoDao agencyInfoDao;
	
	public List<?> queryMerchParent() {
		return agencyDAO.queryMerchParent();
	}
	
	public List<?> queryMerchType() {
		
		return agencyDAO.queryMerchType();
	}
	
	public List<?> queryTrade() {
		
		return agencyDAO.queryTrade();
	}

	public List<?> querysetltype() {
		
		return agencyDAO.querysetltype();
	}
	
	public Map<String, Object> findMerchByPage(Map<String, Object> variables, Integer page, Integer rows) {
		
		return agencyDAO.findMerchByPage(variables,page,rows);
	}

	public List<?> saveMerchDeta(MerchDetaApplyBean merchDeta,EnterpriseDetaApplyBean enterprise) {
		return agencyDAO.saveMerchDeta(merchDeta,enterprise);
	}

	public List<?> queryCounty(Long pid) {
		return agencyDAO.queryCounty(pid);
	}

	public List<?> queryBankNode(String bankName, Integer page, Integer rows) {
		return agencyDAO.queryBankNode(bankName,page,rows);
	}

	public List<?> queryCashAll() {
		return agencyDAO.queryCashAll();
	}

	public List<?> queryChnlnameAll() {
		return agencyDAO.queryChnlnameAll();
	}

	public List<?> queryRouteAll() {
		return agencyDAO.queryRouteAll();
	}

	public List<?> queryRiskType(String vid) {
		return agencyDAO.queryRiskType(vid);
	}

	public List<?> querySplit(String vid) {
		return agencyDAO.querySplit(vid);
	}

	public List<?> queryFee(String vid) {
		return agencyDAO.queryFee(vid);
	}

	public List<?> querySetlcycleAll() {
		return agencyDAO.querySetlcycleAll();
	}

	public MerchDetaApplyBean getBean(Long selfId) {
		MerchDetaApplyBean bean = new MerchDetaApplyBean();
		PojoMerchDetaApply pojo = (PojoMerchDetaApply) agencyDAO.getBean(selfId).get(0);
		BeanUtils.copyProperties(pojo, bean);
		return bean;
	}

	@Override
	public boolean upload(String merchApplyId, String path, CertType certType) {
//
        CertPicHandler certHandler = getCertHandler(certType);
        if (certHandler == null) {
            log.warn("upload to ftp get a exception.caused by:certHandler is null");
            return false;
        }
        PojoEnterpriseDetaApply enterpriseDeta = (PojoEnterpriseDetaApply) enterpriseDetaDao.findById(merchApplyId).get(0);
        enterpriseDeta = certHandler.decorate(enterpriseDeta,path);
        if (enterpriseDeta == null) {
            log.warn("upload to ftp get a exception.caused by:merch is not exist");
            return false;
        }
        enterpriseDetaDao.update(enterpriseDeta);
		return true;
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

	@Override
	public boolean commitMerch(String merchApplyId) {
		
		return agencyDAO.commitMerch(merchApplyId);
	}

	@Override
	public String downloadFromFtp(String merchApplyId, CertType certType) {
		PojoEnterpriseDetaApply enterpriseDeta = (PojoEnterpriseDetaApply) enterpriseDetaDao.findById(merchApplyId).get(0);
        CertPicHandler certPicHandler = getCertHandler(certType);
        String fileName = certPicHandler.getFileName(enterpriseDeta);
        if (fileName == null) {// not upload yet return "";
            return "";
        }
		return fileName;
	}

	@Override
	public List<?> saveChangeMerchDeta(String merchApplyId, MerchDetaApplyBean merchDeta,EnterpriseDetaApplyBean enterpriseDeta) {
		return agencyDAO.saveChangeMerchDeta(merchApplyId,merchDeta,enterpriseDeta);
	}

	@Override
	public String queryBankName(String bankNode, String bankCode) {
		return agencyDAO.queryBankName(bankNode,bankCode);
	}

	@Override
	public Map<String, Object> queryApplyMerchDeta(String merchApplyId, Long userId) {
		return agencyDAO.queryApplyMerchDeta(merchApplyId,userId);
	}

	@Override
	public List<Map<String, Object>> merchAudit(String merchApplyId, MerchDetaApplyBean merchDeta, String memId,
			String flag, String isAgree) {
		return agencyDAO.merchAudit(merchApplyId, merchDeta, memId, flag, isAgree);
	}

	@Override
	public void updateMerch(String memberId, String riskVer) {
		agencyDAO.updateMerch(memberId,riskVer);
	}

	@Override
	public Map<String, Object> saveAgencyInfo(AgencyInfoBean bean) {
		Map<String, Object> map = new HashMap<String, Object>();
		PojoAgencyInfo pojo = new PojoAgencyInfo();
		BeanUtils.copyProperties(bean, pojo);
		try {
			map = agencyInfoDao.saveAgencyInfo(pojo);
			
		} catch(ContractException e){
			map.put("RET", "error");
			map.put("INFO", e.getMessage());
		}
		return map;
	}

	@Override
	public List<?> queryByMerchNo(String merchNo) {
		return agencyInfoDao.queryByMerchNo(merchNo);
	}

	@Override
	public Map<String, Object> updateAgencyInfo(AgencyInfoBean bean) {
		Map<String, Object> map = new HashMap<String, Object>();
		PojoAgencyInfo pojo = new PojoAgencyInfo();
		BeanUtils.copyProperties(bean, pojo);
		try {
			map = agencyInfoDao.updateAgencyInfo(pojo);
		} catch (ContractException e) {
			map.put("RET", "error");
			map.put("INFO", e.getMessage());
		}
		return map;
	}
	
	@Override
	public AgencyInfoBean queryByCode(String merchNo, String bustCode) {
		AgencyInfoBean bean = new AgencyInfoBean();
		PojoAgencyInfo pojo;
		List<?> result = agencyInfoDao.queryByCode(merchNo,bustCode);
		if(result.size() == 0){
			bean = null;
		}else{
			pojo = (PojoAgencyInfo) agencyInfoDao.queryByCode(merchNo,bustCode).get(0);
			BeanUtils.copyProperties(pojo,bean);
		}
		return bean;
	}

	@Override
	public Map<String, Object> queryProfit(Map<String, Object> result, Integer page, Integer rows) {
		return agencyDAO.queryProfit(result, page,rows);
	}
}












