package com.zcbspay.platform.manager.merchant.certhandler;

import com.zcbspay.platform.manager.merchant.bean.CertType;
import com.zcbspay.platform.manager.merchant.pojo.PojoEnterpriseDetaApply;

public class CorpFileOppPicHandler extends CertPicHandler{
    public CorpFileOppPicHandler(){
        certType = CertType.CORPFILE_OPPOSITE;
    }
    
    @Override
    public PojoEnterpriseDetaApply decorate(PojoEnterpriseDetaApply enterpriseDetaApply,String fileName) {
        enterpriseDetaApply.setCorpFileOpp(fileName);
        return enterpriseDetaApply;
    }
    
    @Override
    public String getFileName(PojoEnterpriseDetaApply enterpriseDetaApply){
        return enterpriseDetaApply.getCorpFileOpp();
    }
}
