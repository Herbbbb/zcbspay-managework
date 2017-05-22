package com.zcbspay.platform.manager.merchant.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.merchant.bean.ProductBean;
import com.zcbspay.platform.manager.merchant.dao.ProductDao;

@Repository
@SuppressWarnings("all")
public class ProductDaoImpl extends HibernateBaseDAOImpl<ProductBean> implements ProductDao {

	@Override
	public List<?> queryProduct() {
		String sql = "select tp.prdtver,tp.prdtname from t_product tp where status='00' order by prdtver";
//		String sql = "select tp.* from tl_coopinsti_product t inner join t_product tp on t.prouct_id=tp.prdtver where t.coop_insti_id=?";
		return queryBySQL(sql,new Object[]{});
	}

}
