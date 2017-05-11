package com.zcbspay.platform.manager.merchant.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.merchant.dao.AgencyInfoDao;
import com.zcbspay.platform.manager.merchant.pojo.PojoAgencyInfo;

@Repository
@SuppressWarnings("all")
public class AgencyInfoDaoImpl extends HibernateBaseDAOImpl<PojoAgencyInfo> implements AgencyInfoDao {

	@Override
	public boolean saveAgencyInfo(PojoAgencyInfo pojo) {
		Date curDate = new Date(System.currentTimeMillis());
		pojo.setInTime(curDate);
		pojo.setStatus("00");
		
		saveEntity(pojo);
		return queryAgencyInfo(pojo);
	}

	@Override
	public boolean queryAgencyInfo(PojoAgencyInfo bean) {
		String sql = "select t from PojoAgencyInfo t where t.merchNo=? and t.bustCode=?";
		List<?> resultList = queryByHQL(sql, new Object[]{bean.getMerchNo(),bean.getBustCode()});
		
		if (resultList.size() == 0) {
			return false;
		}
		return true;
	}

	@Override
	public List<?> queryByMerchNo(String merchNo){
		String sql = "select t from PojoAgencyInfo t where t.merchNo=?";
		return queryByHQL(sql, new Object[]{merchNo});
	}

	@Override
	public PojoAgencyInfo updateAgencyInfo(PojoAgencyInfo bean) {
		return update(bean);
	}
	
	@Override
	public List<?> queryByCode(String merchNo, String bustCode){
		String sql = "select t from PojoAgencyInfo t where t.merchNo=? and t.bustCode=?";
		return queryByHQL(sql, new Object[]{merchNo,bustCode});
	}
	
}
