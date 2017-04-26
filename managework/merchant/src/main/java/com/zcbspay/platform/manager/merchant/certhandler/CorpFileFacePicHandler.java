package com.zcbspay.platform.manager.merchant.certhandler;

import com.zcbspay.platform.manager.merchant.bean.CertType;
import com.zcbspay.platform.manager.merchant.pojo.PojoEnterpriseDetaApply;

public class CorpFileFacePicHandler extends CertPicHandler {
    
    public CorpFileFacePicHandler(){
        certType = CertType.CORPFILE_FACE;
    }
    
    @Override
    public PojoEnterpriseDetaApply decorate(PojoEnterpriseDetaApply enterpriseDetaApply, String fileName) {
        enterpriseDetaApply.setCorpFile(fileName);
        return enterpriseDetaApply;
    }
    
    @Override
    public String getFileName(PojoEnterpriseDetaApply enterpriseDetaApply){
        return enterpriseDetaApply.getCorpFile();
    }
}
