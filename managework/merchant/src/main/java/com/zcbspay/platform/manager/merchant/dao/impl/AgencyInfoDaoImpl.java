package com.zcbspay.platform.manager.merchant.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.exception.ContractException;
import com.zcbspay.platform.manager.merchant.bean.AgencyInfoBean;
import com.zcbspay.platform.manager.merchant.dao.AgencyInfoDao;
import com.zcbspay.platform.manager.merchant.pojo.PojoAgencyInfo;

@Repository
@SuppressWarnings("all")
public class AgencyInfoDaoImpl extends HibernateBaseDAOImpl<PojoAgencyInfo> implements AgencyInfoDao {

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public Map<String, Object> saveAgencyInfo(PojoAgencyInfo pojo) throws ContractException {
		Map<String, Object> map = new HashMap<String, Object>();
		Date curDate = new Date(System.currentTimeMillis());
		pojo.setInTime(curDate);
		pojo.setStatus("00");
		if(queryByChargingunit(pojo.getChargingunit())){
			String info = "付款单位代码: "+pojo.getChargingunit()+" 已存在!";
			map.put("RET", "error");
			map.put("INFO", info);
			throw new ContractException(info);
		}
		saveEntity(pojo);
		if(queryAgencyInfo(pojo)){
			String info = "添加失败!";
			map.put("RET", "error");
			map.put("INFO", info);
			throw new ContractException(info);
		}else{
			map.put("RET", "succ");
			map.put("INFO", "添加成功");
		}
		return map;
	}

	@Override
	public boolean queryAgencyInfo(PojoAgencyInfo bean) {
		String sql = "select t from PojoAgencyInfo t where t.merchNo=? and t.bustCode=?";
		List<?> resultList = queryByHQL(sql, new Object[]{bean.getMerchNo(),bean.getBustCode()});
		
		if (resultList.size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<?> queryByMerchNo(String merchNo){
		String sql = "select t from PojoAgencyInfo t where t.merchNo=?";
		return queryByHQL(sql, new Object[]{merchNo});
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public Map<String, Object> updateAgencyInfo(PojoAgencyInfo bean) throws ContractException {
		Map<String, Object> map = new HashMap<String, Object>();
		PojoAgencyInfo pojo = update(bean);
		int size = findByCode(bean.getMerchNo(),bean.getChargingunit()).size();
		if(size > 1){
			String info = "付款单位代码: "+bean.getChargingunit()+" 已存在!";
			map.put("RET", "error");
			map.put("INFO", info);
			throw new ContractException(info);
		}
		if (pojo.getChargingunit().equals(bean.getChargingunit())) {
			map.put("RET", "succ");
			map.put("INFO", "添加成功");
		}else{
			String info = "添加失败!";
			map.put("RET", "error");
			map.put("INFO", info);
			throw new ContractException(info);
		}
		return map;
	}
	
	@Override
	public List<?> queryByCode(String merchNo, String bustCode){
		String sql = "select t from PojoAgencyInfo t where t.merchNo=? and t.bustCode=?";
		return queryByHQL(sql, new Object[]{merchNo,bustCode});
	}
	@Override
	public List<?> findByCode(String merchNo, String chargingunit){
		String sql = "select t from PojoAgencyInfo t where t.merchNo=? and t.chargingunit=?";
		return queryByHQL(sql, new Object[]{merchNo,chargingunit});
	}

	@Override
	public boolean queryByChargingunit(String chargingunit) {
		String sql = "select t from PojoAgencyInfo t where t.chargingunit=?";
		int size = queryByHQL(sql, new Object[]{chargingunit}).size();
		if(size >= 1){
			return true;
		}
		return false;
	}

	@Override
	public List<?> queryChargingunit(AgencyInfoBean bean) {
		Map<String, Object> map = new HashMap<String, Object>();
		String sql = "select t from PojoAgencyInfo t where t.chargingunit=?";
		return queryByHQL(sql, new Object[]{bean.getChargingunit()});
	}
	
}
