package com.zcbspay.platform.manager.merchant.certhandler;

import com.zcbspay.platform.manager.merchant.bean.CertType;
import com.zcbspay.platform.manager.merchant.pojo.PojoEnterpriseDetaApply;

public class TaxRegCertPicHandler extends CertPicHandler{
    public TaxRegCertPicHandler(){
        certType = CertType.TAXREGCERT;
    }

    @Override
    public PojoEnterpriseDetaApply decorate(PojoEnterpriseDetaApply enterpriseDetaApply, String fileName) { 
        enterpriseDetaApply.setTaxFile(fileName);
        return enterpriseDetaApply;
    }
    
    @Override
    public String getFileName(PojoEnterpriseDetaApply enterpriseDetaApply){
        return enterpriseDetaApply.getTaxFile();
    }
}
