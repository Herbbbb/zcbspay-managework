package com.zcbspay.platform.manager.system.dao;

import java.util.List;

import com.zcbspay.platform.manager.dao.BaseDAO;
import com.zcbspay.platform.manager.system.bean.ParaDicBean;
import com.zcbspay.platform.manager.system.pojo.PojoParaDic;



public interface ParaDicDAO extends BaseDAO<PojoParaDic>{
	/**
	 * 
	 * @param paraType
	 * @param status
	 * @return
	 */
	public List<?> getAllParaListByParaType(String paraType, String status);
	/**
	 * 
	 * @param paradic
	 * @return
	 */
	public String AddOneParaDic(ParaDicBean paradic);
	/**
	 * 
	 * @param parentid
	 * @param paraname
	 * @param status
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<?> queryParaDicList(String parentid, String paraname, String status, int page, int rows);
	/**
	 * 
	 * @param parentid
	 * @param paraname
	 * @param status
	 * @return
	 */
	public Long queryParaDicCount(String parentid, String paraname, String status);
	/**
	 * 
	 * @param paradic
	 * @return
	 */
	public String updatePara(ParaDicBean paradic);
}
