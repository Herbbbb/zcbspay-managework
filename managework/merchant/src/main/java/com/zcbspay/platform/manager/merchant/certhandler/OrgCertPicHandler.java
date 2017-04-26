package com.zcbspay.platform.manager.merchant.certhandler;

import com.zcbspay.platform.manager.merchant.bean.CertType;
import com.zcbspay.platform.manager.merchant.pojo.PojoEnterpriseDetaApply;

public class OrgCertPicHandler extends CertPicHandler{
    public OrgCertPicHandler(){
        certType = CertType.ORGCERT;
    }

    @Override
    public PojoEnterpriseDetaApply decorate(PojoEnterpriseDetaApply enterpriseDetaApply, String fileName) { 
        enterpriseDetaApply.setOrgCodeFile(fileName);
        return enterpriseDetaApply;
    }
    
    @Override
    public String getFileName(PojoEnterpriseDetaApply enterpriseDetaApply){
        return enterpriseDetaApply.getOrgCodeFile();
    }
}
