package com.zcbspay.platform.manager.system.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zcbspay.platform.manager.dao.impl.HibernateBaseDAOImpl;
import com.zcbspay.platform.manager.system.bean.OrganBean;
import com.zcbspay.platform.manager.system.dao.OrganDAO;
import com.zcbspay.platform.manager.system.pojo.PojoOrgan;
import com.zcbspay.platform.manager.utils.BeanCopyUtil;

@Repository
public class OrganDAOImpl extends HibernateBaseDAOImpl<PojoOrgan> implements OrganDAO{
	
	public List<?> saveOrgan(OrganBean organ) {
		String[] columns = new String[] { "v_organ_code", "v_organ_name",
				"v_superid", "v_province", "v_city", "v_creator", "v_notes",
				"v_remarks" };
		Object[] paramaters = new Object[] {
				"".equals(organ.getOrganCode()) ? null : organ.getOrganCode(),
				"".equals(organ.getOrganName()) ? null : organ.getOrganName(),
				"".equals(organ.getSuperid()) ? null : organ.getSuperid(),
				"".equals(organ.getProvince()) ? null : organ.getProvince(),
				"".equals(organ.getCity()) ? null : organ.getCity(),
				"".equals(organ.getCreator()) ? null : organ.getCreator(),
				"".equals(organ.getNotes()) ? null : organ.getNotes(),
				"".equals(organ.getRemarks()) ? null : organ.getRemarks() };
		return executeOracleProcedure("{CALL PCK_T_ORGAN.ins_t_organ(?,?,?,?,?,?,?,?,?)}",columns,
				paramaters, "cursor0");
	}

	public List<?> updateOrgan(OrganBean organ) {
		String[] columns = new String[] { "v_organ_id","v_organ_code", "v_organ_name",
				"v_superid", "v_province", "v_city", "v_creator","v_status", "v_notes",
				"v_remarks" };
		Object[] paramaters = new Object[] {
				organ.getOrganId(),
				"".equals(organ.getOrganCode()) ? null : organ.getOrganCode(),
				"".equals(organ.getOrganName()) ? null : organ.getOrganName(),
				"".equals(organ.getSuperid()) ? null : organ.getSuperid(),
				"".equals(organ.getProvince()) ? null : organ.getProvince(),
				"".equals(organ.getCity()) ? null : organ.getCity(),
				"".equals(organ.getCreator()) ? null : organ.getCreator(),
				"".equals(organ.getStatus()) ? null : organ.getStatus(),
				"".equals(organ.getNotes()) ? null : organ.getNotes(),
				"".equals(organ.getRemarks()) ? null : organ.getRemarks() };
		
		return executeOracleProcedure("{CALL PCK_T_ORGAN.upt_t_organ(?,?,?,?,?,?,?,?,?,?,?)}",columns,
				paramaters, "cursor0");
	}
	
	public  Map<String, Object> findOrganByPage(Map<String, Object> variables, int page,
			int rows) {
		String[] columns = new String[]{
				"v_organ_code","v_organ_name","i_no", "i_perno"
		};
		Object[] paramaters = new Object[4];
		paramaters[0] = variables.containsKey("organCode")?variables.get("organCode"):null;
		paramaters[1] = variables.containsKey("organName")?variables.get("organName"):null;
		paramaters[2] = page;
		paramaters[3] = rows;
		return executePageOracleProcedure("{CALL PCK_T_ORGAN.sel_t_organ(?,?,?,?,?,?)}",columns,
				paramaters, "cursor0","v_total");
	}

	public long findOrganByPageCount(Map<String, Object> variables) {
		String[] columns = new String[]{"v_organ_code","v_organ_name"};
		Object[] paramaters = new Object[2];
		paramaters[0] = variables.containsKey("organCode")?variables.get("organCode"):null;
		paramaters[1] = variables.containsKey("organName")?variables.get("organName"):null;
		Object total = executeOracleProcedure("{CALL PCK_T_ORGAN.sel_t_organ_num(?,?,?)}",columns,
				paramaters, "cursor0").get(0).get("TOTAL");
		return Long.valueOf(total.toString());
	}

	public List<?> deleteOrgan(Long organId) {
		String[] columns = new String[] { "v_organ_id" };
		Object[] paramaters = new Object[] {organId};
		return executeOracleProcedure("{CALL PCK_T_ORGAN.del_t_organ(?,?)}",columns,
				paramaters, "cursor0");	
	}
	
	public List<?> findAll() {
		Object[] paramaters = null;
		String sql = "select * from T_ORGAN";
		return queryBySQL(sql,paramaters);
	}
	
	public List<?> queryBy(String string, Object[] objects){
		Object[] paramaters = null;
		String sql = "select rm from PojoOrgan rm where rm.levelid='1' or rm.levelid='0'";
		return queryByHQL(sql, paramaters);
	}

	@Override
	public OrganBean get(Long organId) {
		Criteria crite = this.getSession().createCriteria(PojoOrgan.class);
		crite.add(Restrictions.eq("organId",organId));
		Object uniqueResult = crite.uniqueResult();
		return BeanCopyUtil.copyBean(OrganBean.class, uniqueResult);
	}

	@Override
	public List<?> findByProperty(Long organId,String status) {
		Object[] paramaters = null;
		String sql;
		if(organId == null){
			sql = "select rm from PojoOrgan rm where rm.status='00'";
		}else{
			sql = "select rm from PojoOrgan rm where rm.status='00' and rm.organId=?";
			paramaters = new Object[]{organId};
		}
		return queryByHQL(sql, paramaters);
	}
	
}
