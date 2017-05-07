package com.zcbspay.platform.manager.merchant.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.merchant.dao.ContractBarchDao;
import com.zcbspay.platform.manager.merchant.pojo.PojoContractBatch;

@Repository
public class ContractBarchDaoImpl extends HibernateBaseDAOImpl<PojoContractBatch> implements ContractBarchDao {

	@Override
	public boolean saveBatch(PojoContractBatch batch) {
		
		Date curDate = new Date(System.currentTimeMillis());
		batch.setInTime(curDate);
		saveEntity(batch);
		
		return queryContractBatch(batch.getBatchNo(),batch.getMerchNo());
	}
	public boolean queryContractBatch(String batchNo,String merchNo) {
		String sql = "select t from PojoContractBatch t where t.batchNo=? and t.merchNo=?";
		List<?> resultList = queryByHQL(sql, new Object[]{batchNo,merchNo});
		
		if (resultList.size() == 0) {
			return false;
		}
		return true;
	}
}
