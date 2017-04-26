package com.zcbspay.platform.manager.merchant.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.merchant.dao.ParaDicDao;
import com.zcbspay.platform.manager.merchant.pojo.PojoParaDic;

@Repository
public class ParaDicDaoImpl extends HibernateBaseDAOImpl<PojoParaDic> implements ParaDicDao {

	@Override
	public List<?> findParaDic() {
		String sql = "SELECT * FROM t_para_dic t WHERE t.para_type = 'SELFFEETYPE'";
		return queryBySQL(sql, null);
	}

	@Override
	public List<?> findParaById(String busiCode) {
		String sql = "select * from t_para_dic where para_type='SELFFEETYPE' and para_code=?";
		return queryBySQL(sql, new Object[]{busiCode});
	}

}
