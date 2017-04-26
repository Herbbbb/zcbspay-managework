package com.zcbspay.platform.manager.merchant.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.zcbspay.platform.manager.merchant.dao.EnterpriseDetaDao;
import com.zcbspay.platform.manager.merchant.dao.MerchDetaDAO;
import com.zcbspay.platform.manager.merchant.pojo.PojoEnterpriseDetaApply;
import com.zcbspay.platform.manager.merchant.pojo.PojoMerchDetaApply;
import com.zcbspay.platform.manager.merchant.service.MerchDetaService;
@Service("merchDetaService")
@SuppressWarnings("all")
public class MerchDetaServiceImpl implements MerchDetaService {

	 private final static Log log = LogFactory.getLog(MerchDetaServiceImpl.class);
	@Autowired
	private MerchDetaDAO merchDetaDAO;
	@Autowired
	private EnterpriseDetaDao enterpriseDetaDao;
	
	public List<?> queryMerchParent() {
		return merchDetaDAO.queryMerchParent();
	}
	
	public List<?> queryMerchType() {
		
		return merchDetaDAO.queryMerchType();
	}
	
	public List<?> queryTrade() {
		
		return merchDetaDAO.queryTrade();
	}

	public List<?> querysetltype() {
		
		return merchDetaDAO.querysetltype();
	}
	
	public Map<String, Object> findMerchByPage(Map<String, Object> variables, Integer page, Integer rows) {
		
		return merchDetaDAO.findMerchByPage(variables,page,rows);
	}

	public List<?> saveMerchDeta(MerchDetaApplyBean merchDeta,EnterpriseDetaApplyBean enterprise) {
		return merchDetaDAO.saveMerchDeta(merchDeta,enterprise);
	}

	public List<?> queryCounty(Long pid) {
		return merchDetaDAO.queryCounty(pid);
	}

	public List<?> queryBankNode(String bankName, Integer page, Integer rows) {
		return merchDetaDAO.queryBankNode(bankName,page,rows);
	}

	public List<?> queryCashAll() {
		return merchDetaDAO.queryCashAll();
	}

	public List<?> queryChnlnameAll() {
		return merchDetaDAO.queryChnlnameAll();
	}

	public List<?> queryRouteAll() {
		return merchDetaDAO.queryRouteAll();
	}

	public List<?> queryRiskType(String vid) {
		return merchDetaDAO.queryRiskType(vid);
	}

	public List<?> querySplit(String vid) {
		return merchDetaDAO.querySplit(vid);
	}

	public List<?> queryFee(String vid) {
		return merchDetaDAO.queryFee(vid);
	}

	public List<?> querySetlcycleAll() {
		return merchDetaDAO.querySetlcycleAll();
	}

	public MerchDetaApplyBean getBean(Long selfId) {
		MerchDetaApplyBean bean = new MerchDetaApplyBean();
		PojoMerchDetaApply pojo = (PojoMerchDetaApply) merchDetaDAO.getBean(selfId).get(0);
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
		
		return merchDetaDAO.commitMerch(merchApplyId);
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
		return merchDetaDAO.saveChangeMerchDeta(merchApplyId,merchDeta,enterpriseDeta);
	}

	@Override
	public String queryBankName(String bankNode, String bankCode) {
		return merchDetaDAO.queryBankName(bankNode,bankCode);
	}

	@Override
	public Map<String, Object> queryApplyMerchDeta(String merchApplyId, Long userId) {
		return merchDetaDAO.queryApplyMerchDeta(merchApplyId,userId);
	}

	@Override
	public List<Map<String, Object>> merchAudit(String merchApplyId, MerchDetaApplyBean merchDeta, String memId,
			String flag, String isAgree) {
		return merchDetaDAO.merchAudit(merchApplyId, merchDeta, memId, flag, isAgree);
	}

	@Override
	public void updateMerch(String memberId, String riskVer) {
		merchDetaDAO.updateMerch(memberId,riskVer);
	}


}












