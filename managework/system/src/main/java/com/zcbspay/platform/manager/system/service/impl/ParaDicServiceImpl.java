package com.zcbspay.platform.manager.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zcbspay.platform.manager.system.bean.ParaDicBean;
import com.zcbspay.platform.manager.system.dao.ParaDicDAO;
import com.zcbspay.platform.manager.system.service.ParaDicService;
@Service("paraDicService")
public class ParaDicServiceImpl implements ParaDicService {
    
	@Autowired
	private ParaDicDAO paraDicDAO;

    public List<?> getAllParaListByParaType(String paraType) {
        return getAllParaListByParaType(paraType, "");
    }

    public List<?> getAllParaListByParaType(String paraType, String status) {
        return paraDicDAO.getAllParaListByParaType(paraType, status);
    }
    // 新增一条参数信息
    public String AddOneParaDic(ParaDicBean paradic) {
        return paraDicDAO.AddOneParaDic(paradic);

    }
    // 分页查询参数
    public List<?> queryParaDicList(String parentid,String paraname,String status,int page,int rows) {
       
        return paraDicDAO.queryParaDicList(parentid, paraname, status, page, rows);
    }
    // 分页查询参数信息总条数
    public Long queryParaDicCount(String parentid,
            String paraname,
            String status) {
        return paraDicDAO.queryParaDicCount(parentid, paraname, status);
    }
    // 修改参数信息
    public String updatePara(ParaDicBean paradic) {
        return paraDicDAO.updatePara(paradic);
    }
}
