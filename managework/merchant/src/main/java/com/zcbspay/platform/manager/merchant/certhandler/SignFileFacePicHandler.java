package com.zcbspay.platform.manager.merchant.certhandler;

import com.zcbspay.platform.manager.merchant.bean.CertType;
import com.zcbspay.platform.manager.merchant.pojo.PojoEnterpriseDetaApply;

public class SignFileFacePicHandler extends CertPicHandler{
    public SignFileFacePicHandler(){
        certType = CertType.SIGNATORYFILE_FACE;
    }
    
    @Override
    public PojoEnterpriseDetaApply decorate(PojoEnterpriseDetaApply enterpriseDetaApply,String fileName) {
        enterpriseDetaApply.setSignCertFile(fileName);
        return enterpriseDetaApply;
    }
    
    @Override
    public String getFileName(PojoEnterpriseDetaApply enterpriseDetaApply){
        return enterpriseDetaApply.getSignCertFile();
    }
}
