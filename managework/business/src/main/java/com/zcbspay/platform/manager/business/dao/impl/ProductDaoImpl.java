package com.zcbspay.platform.manager.business.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.business.bean.MerchAPIBean;
import com.zcbspay.platform.manager.business.bean.ProductBean;
import com.zcbspay.platform.manager.business.dao.ProductDao;
import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;

@Repository
public class ProductDaoImpl extends HibernateBaseDAOImpl<ProductBean> implements ProductDao {
	@Override
	public String AddOneProduct(ProductBean product, String busicodeStr) {
		Object[] paramaters = new Object[] { product.getPrdtname(), product.getNotes(), product.getRemarks(),
				busicodeStr, product.getInuser() };
		String[] columns = new String[] { "v_prdtname", "v_notes", "v_remarks", "v_casestr", "v_inuser" };
		Object total = executeOracleProcedure("{CALL PCK_T_PRODUCT.ins_t_product(?,?,?,?,?,?)}", columns, paramaters,
				"cursor0").get(0).get("INFO");
		return (String) total;
	}

	@Override
	public Map<String, Object> findProductByPage(Map<String, Object> variables, int page, int rows) {
		String[] columns = new String[] { "v_prdtver", "v_prdtname", "i_no", "i_perno" };

		Object[] paramaters = new Object[] { variables.containsKey("prdtver") ? variables.get("prdtver") : null,
				variables.containsKey("prdtname") ? variables.get("prdtname") : null, page, rows };
		return executePageOracleProcedure("{CALL PCK_T_PRODUCT.sel_t_product(?,?,?,?,?,?)}", columns, paramaters,
				"cursor0", "v_total");
	}

	@Override
	public List<?> queryBusinessType() {
		String[] columns = new String[] { "v_in" };
		Object[] paramaters = new Object[1];
		paramaters[0] = 1;
		return executeOracleProcedure("{CALL  PCK_FOR_SELECT.sel_business(?,?)}", columns, paramaters, "cursor0");
	}

	@Override
	public List<?> findByProperty(String propertyName, String value) {
		String sql = "select * from T_PRODUCT ct where ct."+propertyName+"="+ value;
		return queryBySQL(sql, null);
	}

	@Override
	public List<?> queryProdCase(String prdtver) {
		String[] columns = new String[] { "v_prdtver" };
		Object[] paramaters = new Object[1];
		paramaters[0] = prdtver;
		return executeOracleProcedure("{CALL  PCK_T_PRODUCT.sel_prod_case(?,?)}", columns, paramaters,
				"cursor0");
	}

	@Override
	public String updateProduct(ProductBean product, String busicodeStr) {
		Object[] paramaters = new Object[] { product.getPrdtver(), product.getPrdtname(), product.getNotes(),
				product.getRemarks(), busicodeStr, product.getInuser() };
		String[] columns = new String[] { "v_prdtver", "v_prdtname", "v_notes", "v_remarks", "v_casestr", "v_upuser" };
		Object total = executeOracleProcedure("{CALL PCK_T_PRODUCT.upt_t_product(?,?,?,?,?,?,?)}", columns,
				paramaters, "cursor0").get(0).get("INFO");
		return (String) total;
	}

	@Override
	public List<?> findAll() {
		String sql = "select * from T_PRODUCT ";
		return queryBySQL(sql, null);
	}

	@Override
	public String saveMerch(MerchAPIBean merchAPIBean) {
		Object[] paramaters = new Object[] { merchAPIBean.getMemberid(), merchAPIBean.getBiztype(),merchAPIBean.getTxntype(), merchAPIBean.getTxnsubtype(),
				merchAPIBean.getApiname(), merchAPIBean.getNotes(),merchAPIBean.getRemarks() };
		String[] columns = new String[] { "v_memberid", "v_biztype", "v_txntype", "v_txnsubtype", "v_api_name","v_notes","v_remarks" };
		Object total = executeOracleProcedure("{CALL pck_t_merch_api_auth.ins_t_merch_api_auth(?,?,?,?,?,?,?,?)}", columns, paramaters,
				"cursor0").get(0).get("INFO");
		return (String) total;
	}

	@Override
	public Map<String, Object> queryMerchs(MerchAPIBean merchAPIBean, String page, String rows) {
		Object[] paramaters = new Object[] { merchAPIBean.getMemberid(), merchAPIBean.getBiztype(),merchAPIBean.getTxntype(), merchAPIBean.getTxnsubtype(),
				merchAPIBean.getApiname(), page,rows};
		String[] columns = new String[] { "v_memberid", "v_biztype", "v_txntype", "v_txnsubtype", "v_api_name","i_no","i_perno" };
		Map<String, Object> total = executePageOracleProcedure("{CALL pck_t_merch_api_auth.sel_t_merch_api_auth(?,?,?,?,?,?,?,?,?)}", columns, paramaters,
				"cursor0","v_total");
		return total;
		
	}

	@Override
	public String updateMerch(MerchAPIBean merchAPIBean) {
		Object[] paramaters = new Object[] {merchAPIBean.getTid(), merchAPIBean.getMemberid(), merchAPIBean.getBiztype(),merchAPIBean.getTxntype(),merchAPIBean.getTxnsubtype(),
				merchAPIBean.getApiname(), merchAPIBean.getNotes(),merchAPIBean.getRemarks() };
		String[] columns = new String[] {"v_tid", "v_memberid", "v_biztype", "v_txntype", "v_txnsubtype", "v_api_name","v_notes","v_remarks" };
		Object total = executeOracleProcedure("{CALL pck_t_merch_api_auth.upt_t_merch_api_auth(?,?,?,?,?,?,?,?,?)}", columns, paramaters,
				"cursor0").get(0).get("INFO");
		return (String) total;
	}

	@Override
	public String changeStatus(MerchAPIBean merchAPIBean) {
		Object[] paramaters = new Object[] {merchAPIBean.getTid(), merchAPIBean.getStatus()};
		String[] columns = new String[] {"v_tid", "v_status"};
		Object total = executeOracleProcedure("{CALL pck_t_merch_api_auth.del_t_merch_api_auth(?,?,?)}", columns, paramaters,
				"cursor0").get(0).get("INFO");
		return (String) total;
	}

}
